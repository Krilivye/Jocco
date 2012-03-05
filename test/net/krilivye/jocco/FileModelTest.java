package net.krilivye.jocco;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileModelTest {

    private FileModel filemodel;

    /**
     * Initialize the filemodel class for testing purpose.
     */
    @Before
    public void setUp() {
        filemodel = new FileModel(); //$NON-NLS-1$);
    }

    /**
     * Test that we can set and get the name of the file
     */
    @Test
    public void testSetName() {
        // Arrange
        String fileName = "FileName";
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
        // Arrange
        String extension = "js";
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
        Collection<Section> col = new LinkedList<Section>();
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
        String defaultname = FileModel.DEFAULT_NAME;

        // Act
        String name = filemodel.getName();

        // Assert
        Assert.assertEquals(defaultname, name);
    }

    /**
     * Test that {@link FileModel} assure that it has a default extension
     */
    @Test
    public void testGetExtension() {
        // Arrange
        String defaultExtension = FileModel.DEFAULT_EXTENSION;

        // Act
        String extension = filemodel.getExtension();

        // Assert
        Assert.assertEquals(defaultExtension, extension);
    }

    /**
     * Test that {@link FileModel} assure that it has a default empty collection of sections
     */
    @Test
    public void testGetSections() {
        // Arrange
        Collection<Section> emptycol = Collections.emptyList();

        // Act
        Collection<Section> col = filemodel.getListOfSections();

        // Assert
        Assert.assertEquals(emptycol, col);
    }

}
