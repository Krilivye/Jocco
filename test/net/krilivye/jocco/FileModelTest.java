package net.krilivye.jocco;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FileModelTest {
    private FileModel filemodel;
    
    /**
     * Initialize the filemodel class for testing purpose.
     */
    @Before
    public void setUp(){
        this.filemodel = new FileModel(); //$NON-NLS-1$);
    }
    
   
    /**
     * Test that we can set and get the name of the file
     */
    @Test
    public void testSetName(){
        //Arrange
        String fileName = "FileName";
        //Act
        this.filemodel.setName(fileName);
        //Assert
        Assert.assertEquals(fileName, this.filemodel.getName());
    }
   
    /**
     * Test that the fileModel has an extension
     */
    @Test
    public void testSetExtension(){
        //Arrange
        String extension = "js";
        //Act
        this.filemodel.setExtension(extension);
        //Assert
        Assert.assertEquals(extension, this.filemodel.getExtension());
    }
    
    /**
     * Test that the fileModel has a collection of sections.
     */
    @Test
    public void testSetSections(){
        //Arrange
        Collection<Section> col = new LinkedList<Section>();
        //Act
        this.filemodel.setListOfSections(col);
        //Assert
        Assert.assertEquals(col, this.filemodel.getListOfSections());        
    }
    
    /**
     * Test that fileModel assure that it has a default name
     */
    @Test
    public void testGetName(){
        //Arrange
        String defaultname = FileModel.DEFAULT_NAME;
        
        //Act
        String name = this.filemodel.getName();
        
        //Assert
        Assert.assertEquals(defaultname,name);
    }
    
    /**
     * Test that {@link FileModel} assure that it has a default extension
     */
    @Test
    public void testGetExtension(){
        //Arrange
        String defaultExtension = FileModel.DEFAULT_EXTENSION;
        
        //Act
        String extension = this.filemodel.getExtension();
        
        //Assert
        Assert.assertEquals(defaultExtension,extension);
    }
    /**
     * Test that {@link FileModel} assure that it has a default empty collection of sections
     */
    @Test
    public void testGetSections(){
        //Arrange
        Collection<Section> emptycol= Collections.emptyList();
        
        //Act
        Collection<Section> col = this.filemodel.getListOfSections();
        
        //Assert
        Assert.assertEquals(emptycol,col);
    }
    
    

     
}
