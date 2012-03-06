package net.krilivye.jocco;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.SimpleHash;
import freemarker.template.TemplateException;

/**
 * @author Krilivye-Homestation
 */
public class Template {

    /**
     * The configuration directory of the template library.
     */
    private final transient Configuration cfg = new Configuration();
    /**
     * The root element of the documentation template.
     */
    private final transient SimpleHash root = new SimpleHash();

    /**
     * The template constructor load the default configuration directory.
     */
    public Template() {

        // Specify the data source where the template files come from.
        // Here I set a file directory for it:
        try {
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources/")); //$NON-NLS-1$
        } catch (final IOException e) {
            final Logger logger = LoggerFactory.getLogger(Template.class);
            logger.error(e.getLocalizedMessage());
        }
        // Specify how templates will see the data-model. This is an advanced
        // topic...
        // but just use this:
        cfg.setObjectWrapper(new DefaultObjectWrapper());
    }

    /**
     * @param model
     * a documentation model that will fill the template.
     * @return the filled Template
     * @throws IOException
     * on template file may occure
     * @throws TemplateException
     * if the template is not correctly made.
     */
    public final String fillTemplate(final DocumentationModel model) throws TemplateException, IOException {
        final freemarker.template.Template temp = cfg.getTemplate("jocco.ftl"); //$NON-NLS-1$

        // expose a "simple" java objects:
        root.put("theList", model.getListOfFileModel()); //$NON-NLS-1$
        final Writer out = new StringWriter();
        temp.process(root, out);
        return out.toString();

    }

}
