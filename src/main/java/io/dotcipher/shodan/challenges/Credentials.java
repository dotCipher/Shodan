package io.dotcipher.shodan.challenges;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author cmoore
 */
public class Credentials {

    private static final String USERNAME_PROPERTY = "username";
    private String username;

    private static final String PASSWORD_PROPERTY = "password";
    private String password;

    protected Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Credentials fromResource(InputStream inputStream) {
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String username = properties.getProperty(USERNAME_PROPERTY);
        String password = properties.getProperty(PASSWORD_PROPERTY);
        return new Credentials(username, password);
    }

    /**
     * Gets the username for this Credentials.
     *
     * @return The username
     */
    public final String getUsername() {
        return username;
    }

    /**
     * Gets the password for this Credentials.
     *
     * @return The password
     */
    public final String getPassword() {
        return password;
    }
}
