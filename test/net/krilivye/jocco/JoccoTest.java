package net.krilivye.jocco;

import static org.junit.Assert.fail;

import java.io.File;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * This class test the Jocco Test class.
 * 
 * @author Krilivye-Homestation
 * 
 */

public class JoccoTest {

	private Jocco jocco;

	/**
	 * 
	 */
	@Before
	public void setUp() {
		this.jocco = new Jocco();
	}

	/**
	 * 
	 */
	@Test
	public void testSetFilesWithNull() {
		try {
			this.jocco.setFiles(null);
			fail("Expected IllegalArgumentException when argument is null"); //$NON-NLS-1$
		} catch (IllegalArgumentException expected) {
			Assert.assertEquals(Messages.getString("Program.main.null"), //$NON-NLS-1$
					expected.getMessage());
		}
	}

	/**
	 * Test the setter with correct argument
	 */
	@Test
	public void testSetFilesWithAValidFileName() {
		File test = new File("test/ressources/test.html"); //$NON-NLS-1$
		this.jocco.setFiles("test/ressources/test.html"); //$NON-NLS-1$
		Assert.assertTrue(this.jocco.getFiles().contains(test));

	}

	/**
	 * Test si l'appel du programme avec un non de fichier valable se termine
	 * bien
	 */
	@Test
	public void testSetFilesWithAValidDirectory() {
		try {
			this.jocco.setFiles("src"); //$NON-NLS-1$
			Assert.assertTrue(true);
		} catch (IllegalArgumentException e) {
			fail("Expected Argument to be valid"); //$NON-NLS-1$
		}
	}

	/**
	 * Test the documentation generation
	 */
	@Test
	public void testGenerateDoc() {

		this.jocco.setFiles("test/ressources/test.html"); //$NON-NLS-1$

		boolean execute = false;
		try {
			execute = this.jocco.generateDoc();
		} catch (Exception e) {
			// Hardware IO may Occur
			e.printStackTrace();
		}

		Assert.assertTrue(execute == true);
	}
}
