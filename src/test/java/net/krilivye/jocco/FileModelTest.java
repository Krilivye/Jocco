package net.krilivye.jocco;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The file model should provide the name of the file, the extension and a list
 * of sections containing both code and comment.
 * 
 * @author Krilivye-Homestation
 * 
 */
public class FileModelTest {

    private transient FileModel filemodel;
    private transient String fileName;
    private transient String extension;

    /**
     * Initialize the filemodel class for testing purpose.
     */
    @Before
    public void setUp() {
	filemodel = new FileModel();
    }

    /**
     * Test that we can set and get the name of the file
     */
    @Test
    public void testSetName() {
	fileName = "FileName"; //$NON-NLS-1$
	// Act
	filemodel.setName(fileName);
	// Assert
	Assert.assertEquals(fileName, filemodel.getName());
    }

    /**
     * Test that the fileModel has an extension
     */
    @Test
    public void testSetExtension() {
	extension = "js"; //$NON-NLS-1$
	// Act
	filemodel.setExtension(extension);
	// Assert
	Assert.assertEquals(extension, filemodel.getExtension());
    }

    /**
     * Test that the fileModel has a collection of sections.
     */
    @Test
    public void testSetSections() {
	// Arrange
	final Collection<Section> col = new LinkedList<Section>();
	// Act
	filemodel.setListOfSections(col);
	// Assert
	Assert.assertEquals(col, filemodel.getListOfSections());
    }

    /**
     * Test that fileModel assure that it has a default name
     */
    @Test
    public void testGetName() {
	// Arrange
	final String defaultname = FileModel.DEFAULT_NAME;

	// Act
	fileName = filemodel.getName();

	// Assert
	Assert.assertEquals(defaultname, fileName);
    }

    /**
     * Test that {@link FileModel} assure that it has a default extension
     */
    @Test
    public void testGetExtension() {
	// Arrange
	final String defaultExtension = FileModel.DEFAULT_EXTENSION;

	// Act
	extension = filemodel.getExtension();

	// Assert
	Assert.assertEquals(defaultExtension, extension);
    }

    /**
     * Test that {@link FileModel} assure that it has a default empty collection
     * of sections
     */
    @Test
    public void testGetSections() {
	// Arrange
	final Collection<Section> emptycol = Collections.emptyList();

	// Act
	final Collection<Section> col = filemodel.getListOfSections();

	// Assert
	Assert.assertEquals(emptycol, col);
    }

}
