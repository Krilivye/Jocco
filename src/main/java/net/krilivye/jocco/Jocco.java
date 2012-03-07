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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tautua.markdownpapers.Markdown;
import org.tautua.markdownpapers.parser.ParseException;

import freemarker.template.TemplateException;

/**
 * @author Krilivye-Homestation This is the Jocco main class.
 */
public class Jocco {

    private transient List<File> files;
    private transient List<Section> listOfSections;
    private final transient Markdown markdown = new Markdown();

    private static final Logger LOGGER = LoggerFactory.getLogger(Jocco.class);

    /**
     * For Test interface.
     */
    public Jocco() {
        files = new ArrayList<File>();
    }

    /**
     * @param dirOrFile
     */
    public Jocco(final String dirOrFile) {
        validate(dirOrFile);
    }

    // Valide le constructeur en vérifiant que l'argument est bien un répertoire
    // ou un fichier.
    private void validate(final String dirOrFile) {

        final File file = new File(dirOrFile);
        if (file.exists()) {
            files = new LinkedList<File>();
            addFiles(files, file);
        } else {
            throw new IllegalArgumentException(Messages.getString("Program.main.illegal")); //$NON-NLS-1$
        }
    }

    // Méthode qui construit la liste des fichier en garantissant qu'il n'y ait
    // aucun null
    private void addFiles(final List<File> listOffiles, final File dir) {
        if (dir != null) {
            if (dir.isDirectory()) {
                for (final File file : dir.listFiles()) {
                    addFiles(listOffiles, file);
                }
            } else {
                listOffiles.add(dir);
            }
        }

    }

    /**
     * @return a list of files
     */
    public List<File> getFiles() {
        return files;
    }

    /**
     * This setter does not permit null value
     * @param fileOrDir
     * a file or a dir name
     */
    public void setFiles(final String fileOrDir) {
        if (fileOrDir == null) {
            throw new IllegalArgumentException(Messages.getString("Program.main.null")); //$NON-NLS-1$
        }
        validate(fileOrDir);

    }

    /**
     * @return true if the process's have been correctly executed, false
     * otherwise.
     * @throws IOException
     * @throws TemplateException
     */
    public boolean generateDoc() throws IOException, TemplateException {
        final Writer fileout = new FileWriter(new File("documentation.html")); //$NON-NLS-1$
        final Template template = new Template();
        final DocumentationModel docmodel = new DocumentationModel();
        for (final File file : files) {
            final FileModel model = new FileModel();
            final List<Section> sections = parseFile(file);
            markDownHiglight(sections);
            model.setListOfSections(sections);
            model.setName(file.getName().split("\\.")[0]);
            model.setExtension(file.getName().split("\\.")[1]);

            docmodel.add(model);

        }
        fileout.write(template.fillTemplate(docmodel));
        fileout.close();

        return true;
    }

    private void markDownHiglight(final List<Section> sections) {

        for (final Section section : sections) {
            transformDoc(section);
            section.setCodeHTML("<pre><code class='prettyprint'>" + section.getCode() + "</code></pre>"); //$NON-NLS-1$ //$NON-NLS-2$

        }

    }

    private void transformDoc(final Section section) {
        final Writer out = new StringWriter();
        final Reader input = new StringReader(section.getDoc());
        try {
            markdown.transform(input, out);
            section.setDocHTML(out.toString());
        } catch (final ParseException e) {
            LOGGER.error(e.getMessage());
        }
    }

    private List<Section> parseFile(final File file) throws FileNotFoundException, IOException {
        listOfSections = new LinkedList<Section>();
        final BufferedReader input = new BufferedReader(new FileReader(file));
        boolean hascode = false;

        final StringBuilder docsText = new StringBuilder();
        final StringBuilder codeText = new StringBuilder();

        String line;
        while (null != (line = input.readLine())) {
            if (line.contains("*") || line.contains("////")) { //$NON-NLS-1$ //$NON-NLS-2$
                if (hascode) {
                    save(docsText, codeText);
                    hascode = false;
                    docsText.setLength(0);
                    codeText.setLength(0);
                }
                docsText.append(line).append("\n"); //$NON-NLS-1$
            } else {
                hascode = true;
                codeText.append(line).append("\n"); //$NON-NLS-1$
            }
        }
        save(docsText, codeText);
        return listOfSections;
    }

    private void save(final StringBuilder docsText, final StringBuilder codeText) {
        listOfSections.add(new Section(docsText.toString(), codeText.toString()));
    }
}
