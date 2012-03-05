package net.krilivye.jocco;

public class Section {

    private final String doc;
    private final String code;
    private String docHTML;
    private String codeHTML;

    /**
     * @param docText
     * @param docCode
     */
    public Section(final String docText, final String docCode) {
        doc = docText;
        code = docCode;
    }

    /**
     * @return
     */
    public String getDoc() {
        return doc;
    }

    /**
     * @param string
     */
    public void setDocHTML(final String string) {
        docHTML = string;

    }

    /**
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * @param string
     */
    public void setCodeHTML(final String string) {
        codeHTML = string;

    }

    /**
     * @return
     */
    public String getDocHTML() {
        return docHTML;
    }

    /**
     * @return
     */
    public String getCodeHTML() {
        return codeHTML;
    }

}
