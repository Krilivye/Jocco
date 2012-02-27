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
		this.doc = docText;
		this.code = docCode;
	}

	/**
	 * @return
	 */
	public String getDoc() {
		return this.doc;
	}

	/**
	 * @param string
	 */
	public void setDocHTML(final String string) {
		this.docHTML = string;

	}

	/**
	 * @return
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * @param string
	 */
	public void setCodeHTML(final String string) {
		this.codeHTML = string;

	}

	/**
	 * @return
	 */
	public String getDocHTML() {
		return this.docHTML;
	}

	/**
	 * @return
	 */
	public String getCodeHTML() {
		return this.codeHTML;
	}

}
