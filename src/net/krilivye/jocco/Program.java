package net.krilivye.jocco;

/**
 * This is the programe launcher.
 * @author Krilivye-Homestation
 */
public class Program {

    /**
     * Inner for testing purpose.
     */
    public static Jocco JOCCO = new Jocco();

    /**
     * @param args
     * command line arguments should be a file name or a directory
     * @throws IllegalArgumentException
     * if the command line arguments are not legal.
     */
    public static void main(final String[] args) throws IllegalArgumentException {
        if (args == null || args[0] == null) {
            throw new IllegalArgumentException(Messages.getString("Program.main.null")); //$NON-NLS-1$
        }
        if (args.length > 1) {
            throw new IllegalArgumentException(Messages.getString("Program.main.tooMuchArgument")); //$NON-NLS-1$			
        }
        try {
            JOCCO.setFiles(args[0]);
            JOCCO.generateDoc();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

}
