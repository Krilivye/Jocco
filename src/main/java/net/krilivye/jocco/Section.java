package net.krilivye.jocco;

/**
 * A Jocco section consiste of a documentation comment and its relative code.
 * After parsing the code is converted to HTML
 *
 * @author Krilivye-Homestation
 *
 */
public class Section {

    private final transient String doc;
    private final transient String code;
    private String docHTML;
    private String codeHTML;

    /**
     * @param docText the comment 
     * @param docCode the code
     */
    public Section(final String docText, final String docCode) {
        doc = docText;
        code = docCode;
    }

    /**
     * @return the original file comment
     */
    public final String getDoc() {
        return doc;
    }

    /**
     * @param string the formated documentation
     */
    public final void setDocHTML(final String string) {
        docHTML = string;

    }

    /**
     * @return the original code
     */
    public final String getCode() {
        return code;
    }

    /**
     * @param string the formated code.
     */
    public final void setCodeHTML(final String string) {
        codeHTML = string;

    }

    /**
     * @return the comment converted to html markup
     */
    public final String getDocHTML() {
        return docHTML;
    }

    /**
     * @return the code converted to html markup
     */
    public final String getCodeHTML() {
        return codeHTML;
    }

}
