package net.krilivye.jocco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the programe launcher.
 * @author Krilivye-Homestation
 */
public final class Program {

    /**
     * Inner for testing purpose.
     */
    public static final Jocco JOCCO = new Jocco();

    private static final Logger LOGGER = LoggerFactory.getLogger(Program.class);

    private Program() {
        // No one can instantiate this class.
    }

    /**
     * @param args
     * command line arguments should be a file name or a directory
     * @throws IllegalArgumentException
     * if the command line arguments are not legal.
     */
    public static void main(final String[] args) throws IllegalArgumentException {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException(Messages.getString("Program.main.null")); //$NON-NLS-1$
        }
        if (args.length > 1) {
            throw new IllegalArgumentException(Messages.getString("Program.main.tooMuchArgument")); //$NON-NLS-1$			
        }
        try {
            JOCCO.setFiles(args[0]);
            JOCCO.generateDoc();
        } catch (final Exception e) {
            LOGGER.error(e.getMessage());
            System.exit(1);
        }

    }
}
