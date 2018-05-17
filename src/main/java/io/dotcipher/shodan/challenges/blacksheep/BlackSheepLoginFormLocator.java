package io.dotcipher.shodan.challenges.blacksheep;

import io.dotcipher.shodan.challenges.LoginFormLocator;
import org.openqa.selenium.By;

/**
 * @author cmoore
 */
public class BlackSheepLoginFormLocator implements LoginFormLocator {

    @Override
    public By username() {
        return By.id("edit_username");
    }

    @Override
    public By password() {
        return By.id("edit_password");
    }
}
