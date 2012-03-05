package net.krilivye.jocco;

import java.util.Collection;
import java.util.LinkedList;

public class FileModel {

    /**
     * Files without name shall have a default name
     */
    public static final String DEFAULT_NAME = "Default Name"; //$NON-NLS-1$
    /**
     * Files withous extensions shall have a default extension
     */
    public static final String DEFAULT_EXTENSION = "txt"; //$NON-NLS-1$

    private String name = DEFAULT_NAME;
    private String extension = DEFAULT_EXTENSION;
    private Collection<Section> listOfSections = new LinkedList<Section>();

    public void setName(final String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setExtension(final String extension) {
	this.extension = extension;
    }

    public String getExtension() {
	return extension;
    }

    public void setListOfSections(final Collection<Section> listOfSections) {
	this.listOfSections = listOfSections;

    }

    public Collection<Section> getListOfSections() {
	return listOfSections;
    }

}
