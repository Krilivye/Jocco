package net.krilivye.jocco;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @author p.bousquie
 */
public class FileModel {

    /**
     * Files without name shall have a default name
     */
    public static final String DEFAULT_NAME = ""; //$NON-NLS-1$
    /**
     * Files without extensions shall have a default extension
     */
    public static final String DEFAULT_EXTENSION = ""; //$NON-NLS-1$

    private String name = DEFAULT_NAME;
    private String extension = DEFAULT_EXTENSION;
    private Collection<Section> listOfSections = new LinkedList<Section>();

    /**
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the name of the parsed file or a default blank name
     */
    public String getName() {
        return name;
    }

    /**
     * @param extension
     */
    public void setExtension(final String extension) {
        this.extension = extension;
    }

    /**
     * @return the extension of the parsed file or a default blank extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param listOfSections
     */
    public void setListOfSections(final Collection<Section> listOfSections) {
        this.listOfSections = listOfSections;

    }

    /**
     * @return a collection of section of the parsed file
     */
    public Collection<Section> getListOfSections() {
        return listOfSections;
    }

}
