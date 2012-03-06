package net.krilivye.jocco;

import static org.junit.Assert.fail;

import java.io.File;
import java.net.URL;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class test the Jocco Test class.
 * @author Krilivye-Homestation
 */

public class JoccoTest {

    private transient Jocco jocco;

    private static final Logger LOGGER = LoggerFactory.getLogger(JoccoTest.class);

    private transient URL testFile;

    /**
	 * 
	 */
    @Before
    public void setUp() {
        jocco = new Jocco();
        testFile = getClass().getResource("test.html");
    }

    /**
	 * 
	 */
    @Test
    public void testSetFilesWithNull() {
        try {
            jocco.setFiles(null);
            fail("Expected IllegalArgumentException when argument is null"); //$NON-NLS-1$
        } catch (final IllegalArgumentException expected) {
            Assert.assertEquals(Messages.getString("Program.main.null"), //$NON-NLS-1$
                    expected.getMessage());
        }
    }

    /**
     * Test the setter with correct argument
     */
    @Test
    public void testSetFilesWithAValidFileName() {

        jocco.setFiles(testFile.getPath()); //$NON-NLS-1$
        Assert.assertTrue(jocco.getFiles().contains(new File(testFile.getPath())));

    }

    /**
     * Test si l'appel du programme avec un non de fichier valable se termine
     * bien
     */
    @Test
    public void testSetFilesWithAValidDirectory() {
        try {
            jocco.setFiles("src"); //$NON-NLS-1$
            Assert.assertTrue(true);
        } catch (final IllegalArgumentException e) {
            fail("Expected Argument to be valid"); //$NON-NLS-1$
        }
    }

    /**
     * Test the documentation generation
     */
    @Test
    public void testGenerateDoc() {

        jocco.setFiles(testFile.getPath()); //$NON-NLS-1$

        try {
            final boolean execute = jocco.generateDoc();
            Assert.assertTrue(execute);
        } catch (final Exception e) {
            // Hardware IO may Occur
            LOGGER.error(e.getMessage());
            fail();
        }

    }
}
