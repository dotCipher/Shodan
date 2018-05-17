package io.dotcipher.shodan.challenges;

import org.openqa.selenium.WebDriver;

/**
 * Solves and submits a challenge using a Selenium WebDriver.
 */
public interface ChallengeSolver {

    void solve(WebDriver driver);

}
