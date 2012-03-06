package net.krilivye.jocco;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * The generated message classes
 * @author Krilivye-Homestation
 */
public final class Messages {

    private static final String BUNDLE_NAME = "net.krilivye.jocco.Messages"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private Messages() {
    }

    /**
     * @param key
     * a key string present in messages.properties
     * @return the corresponding value
     */
    public static String getString(final String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (final MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
