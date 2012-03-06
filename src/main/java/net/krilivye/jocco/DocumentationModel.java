package net.krilivye.jocco;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @author p.bousquie
 */
public class DocumentationModel {

    private transient Collection<FileModel> listOfFileModel = new LinkedList<FileModel>();

    /**
     * @return a collection of fileModel representing the files documented
     */
    public Collection<FileModel> getListOfFileModel() {
        return listOfFileModel;
    }

    /**
     * @param listOfFileModel
     */
    public void setListOfFileModels(final Collection<FileModel> listOfFileModel) {
        this.listOfFileModel = listOfFileModel;

    }

    /**
     * @param file
     */
    public void add(final FileModel file) {
        listOfFileModel.add(file);

    }

    /**
     * @param file
     * @return true if the DocumentationModel contain a file.
     */
    public boolean contains(final FileModel file) {
        return listOfFileModel.contains(file);
    }

}
