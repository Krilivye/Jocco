package net.krilivye.jocco;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;


public class FileModel {
    
    public static final String DEFAULT_NAME = "Default Name";
    public static final String DEFAULT_EXTENSION = "txt";
    
    private String name = DEFAULT_NAME;
    private String extension = DEFAULT_EXTENSION;
    private Collection<Section> listOfSections = new LinkedList<Section>();

    public void setName(String name) {
        this.name = name;     
    }

    public String getName() {
        return this.name;
    }

    public void setExtension(String extension) {
        this.extension =extension;
    }

    public String getExtension() {
        return this.extension;       
    }

    public void setListOfSections(Collection<Section> listOfSections) {
        this.listOfSections = listOfSections;
        
    }

    public Collection<Section> getListOfSections() {
        return this.listOfSections;
    }



}
