package net.krilivye.jocco;

import java.util.Collections;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class DocumentationModelTest {

    private DocumentationModel docmodel;
    
    @Before
    public void setUp(){
        this.docmodel = new DocumentationModel();
    }
    
    /**
     * Test that the documentation model contains a default empty list of file model
     */
    @Test
    public void testListOfFileModel(){
        Assert.assertEquals(Collections.emptyList(), this.docmodel.getListOfFileModel());
    }
    
    /**
     * Test that we can add FileModel to the list of file model
     */
    @Test
    public void testAddFileModel(){
        FileModel file = new FileModel();
        this.docmodel.add(file);
        Assert.assertTrue(this.docmodel.contains(file));
    }
}