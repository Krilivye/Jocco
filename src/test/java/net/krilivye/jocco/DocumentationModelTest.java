package net.krilivye.jocco;

import java.util.Collections;

import junit.framework.Assert;


import org.junit.Before;
import org.junit.Test;

/**
 * The documentation model consist of a list of file model. You can only add
 * file to the model.
 * 
 * @author Krilivye-Homestation
 * 
 */
public class DocumentationModelTest {

    private transient DocumentationModel docmodel;

    /**
     * Prepare the model to test
     */
    @Before
    public void setUp() {
	docmodel = new DocumentationModel();
    }

    /**
     * Test that the documentation model contains a default empty list of file
     * model
     */
    @Test
    public void testListOfFileModel() {
	Assert.assertEquals(Collections.emptyList(),
	        docmodel.getListOfFileModel());
    }

    /**
     * Test that we can add FileModel to the list of file model
     */
    @Test
    public void testAddFileModel() {
	final FileModel file = new FileModel();
	docmodel.add(file);
	Assert.assertTrue(docmodel.contains(file));
    }
}
