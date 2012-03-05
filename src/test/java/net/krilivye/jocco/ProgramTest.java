package net.krilivye.jocco;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Test;

/**
 * Test de la classe program.
 * 
 * @author Krilivye-Homestation
 */
public class ProgramTest {

    private static final String[] TEST = new String[] {
            "NonValid", "encore moins" }; //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * Test si l'appel du programme sans argument est valable.
     */
    @Test
    public void testMainWithNull() {
        try {
            Program.main(new String[] {});
            fail("Expected IllegalArgumentException when argument is empty"); //$NON-NLS-1$
        } catch (final IllegalArgumentException expected) {
            Assert.assertEquals(Messages.getString("Program.main.null"), //$NON-NLS-1$
                    expected.getMessage());
        }
    }

    /**
     * Test si l'appel du programme avec trops d'arguments est valable.
     */
    @Test
    public void testMainWithTooMuchArguments() {
        try {
            Program.main(TEST);
            fail("Expected IllegalArgumentException when argument is not valid "); //$NON-NLS-1$
        } catch (final IllegalArgumentException e) {
            Assert.assertEquals(
                    Messages.getString("Program.main.tooMuchArgument"), //$NON-NLS-1$
                    e.getMessage());
        }
    }

}
