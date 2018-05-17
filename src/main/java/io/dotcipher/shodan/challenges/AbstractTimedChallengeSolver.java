package io.dotcipher.shodan.challenges;

import java.util.Date;
import org.openqa.selenium.WebDriver;

/**
 * @author cmoore
 */
public abstract class AbstractTimedChallengeSolver implements ChallengeSolver {

    @Override
    public void solve(WebDriver webDriver) {
        // Start timer
        long startTime = System.nanoTime();
        // Run challenge solver
        timedSolve(webDriver);
        // End timer and output
        long nanosecondsDuration = System.nanoTime() - startTime;
        double secondsDuration = nanosecondsDuration / 1000000000.0; // Divide by 1,000,000,000
        Date completionDate = new Date();
        System.out.println("PWNED on " + completionDate + " taking a total of " + secondsDuration + " seconds!");
    }

    public abstract void timedSolve(WebDriver webDriver);

}
