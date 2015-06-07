package io.dotcipher.jtoolbox.blacksheep;

import java.util.Objects;

/**
 * @author cmoore
 */
public final class BlackSheepCredentials {

    private final String username;
    private final String password;

    public BlackSheepCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlackSheepCredentials that = (BlackSheepCredentials) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
