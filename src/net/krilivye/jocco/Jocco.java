package net.krilivye.jocco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.tautua.markdownpapers.Markdown;
import org.tautua.markdownpapers.parser.ParseException;

/**
 * @author Krilivye-Homestation This is the Jocco main class.
 */
public class Jocco {

	private List<File> files;
	private List<Section> listOfSections;
	private final Markdown markdown = new Markdown();

	/**
	 * For Test interface
	 */
	public Jocco() {
		this.files = new ArrayList<File>();
	}

	/**
	 * 
	 * @param dirOrFile
	 */
	public Jocco(final String dirOrFile) {
		validate(dirOrFile);
	}

	// Valide le constructeur en vérifiant que l'argument est bien un répertoire
	// ou un fichier.
	private void validate(final String dirOrFile) {
		File file = new File(dirOrFile);
		if (file.canRead() == false) {
			throw new IllegalArgumentException(
					Messages.getString("Program.main.illegal")); //$NON-NLS-1$
		}
		this.files = new LinkedList<File>();
		addFiles(this.files, file);
	}

	// Méthode qui construit la liste des fichier en garantissant qu'il n'y ait
	// aucun null
	private void addFiles(final List<File> listOffiles, final File dir) {
		if (dir != null) {
			if (!dir.isDirectory()) {
				listOffiles.add(dir);
			} else {
				for (File file : dir.listFiles()) {
					addFiles(listOffiles, file);
				}
			}
		}

	}

	/**
	 * @return a list of files
	 */
	public List<File> getFiles() {
		return this.files;
	}

	/**
	 * This setter does not permit null value
	 * @param fileOrDir
	 *            a file or a dir name
	 */
	public void setFiles(final String fileOrDir) {
		if (fileOrDir == null) {
			throw new IllegalArgumentException(
					Messages.getString("Program.main.null")); //$NON-NLS-1$
		}
		validate(fileOrDir);

	}

	/**
	 * @return true if the process's have been correctly executed, false
	 *         otherwise.
	 * @throws Exception
	 */
	public boolean generateDoc() throws Exception {
		Writer fileout = new FileWriter(new File("documentation.html")); //$NON-NLS-1$
		Template template = new Template();
		DocumentationModel docmodel= new DocumentationModel();
		for (File file : this.files) {
		    FileModel model = new FileModel();
			List<Section> sections = parseFile(file);
			MarkDownHiglight(sections);
			model.setListOfSections(sections);
			model.setName(file.getName());
			model.setExtension(file.getName());
			
			docmodel.add(model);
			

			
		}
		fileout.write(template.fillTemplate(docmodel));
		fileout.close();

		return true;
	}

	private void MarkDownHiglight(final List<Section> sections) {

		for (Section section : sections) {
			transformDoc(section);
			section.setCodeHTML("<pre>" + section.getCode() + "</pre>"); //$NON-NLS-1$ //$NON-NLS-2$

		}

	}
	private void transformDoc(final Section section) {
		Writer out = new StringWriter();
		Reader in = new StringReader(section.getDoc());
		try {
			this.markdown.transform(in, out);
			section.setDocHTML(out.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	private List<Section> parseFile(final File file)
			throws FileNotFoundException, IOException {
		this.listOfSections = new LinkedList<Section>();
		BufferedReader in = new BufferedReader(new FileReader(file));
		boolean hascode = false;

		StringBuilder docsText = new StringBuilder();
		StringBuilder codeText = new StringBuilder();

		String line;
		while (null != (line = in.readLine())) {
			if (line.contains("*")|| line.contains("////")) { //$NON-NLS-1$
				if (hascode) {
					save(docsText, codeText);
					hascode = false;
					docsText = new StringBuilder();
					codeText = new StringBuilder();
				}
				docsText.append(line).append("\n"); //$NON-NLS-1$
			} else {
				hascode = true;
				codeText.append(line).append("\n"); //$NON-NLS-1$
			}
		}
		save(docsText, codeText);
		return this.listOfSections;
	}

	private void save(final StringBuilder docsText, final StringBuilder codeText) {
		this.listOfSections.add(new Section(docsText.toString(), codeText
				.toString()));
	}
}
