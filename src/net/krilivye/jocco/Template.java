package net.krilivye.jocco;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.SimpleHash;

/**
 * @author Krilivye-Homestation
 * 
 */
public class Template {

	private final Configuration cfg = new Configuration();
	SimpleHash root = new SimpleHash();
	/**
	 * 
	 */
	public Template() {

		// Specify the data source where the template files come from.
		// Here I set a file directory for it:
		try {
			this.cfg.setDirectoryForTemplateLoading(new File("src/ressources/")); //$NON-NLS-1$
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Specify how templates will see the data-model. This is an advanced
		// topic...
		// but just use this:
		this.cfg.setObjectWrapper(new DefaultObjectWrapper());
	}

	/**
	 * @param sections
	 * @return the filled Template
	 * @throws Exception
	 */
	public String fillTemplate(final DocumentationModel model) throws Exception {
		freemarker.template.Template temp = this.cfg.getTemplate("jocco.ftl"); //$NON-NLS-1$

		// expose a "simple" java objects:
		this.root.put("theList", model.getListOfFileModel()); //$NON-NLS-1$
		Writer out = new StringWriter();
		temp.process(this.root, out);
		return out.toString();
		
	}

}
