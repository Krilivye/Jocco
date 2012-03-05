package net.krilivye.jocco;

import java.util.Collection;
import java.util.LinkedList;


public class DocumentationModel {
    
    private Collection<FileModel> listOfFileModel = new LinkedList<FileModel>();

    public Collection<FileModel> getListOfFileModel() {
        return this.listOfFileModel;
    }
    
    public void setListOfFileModels(Collection<FileModel> listOfFileModel){
        this.listOfFileModel= listOfFileModel;
        
    }

    public void add(FileModel file) {
       this.listOfFileModel.add(file);
        
    }

    public boolean contains(FileModel file) {
        return this.listOfFileModel.contains(file);
    }

    

}