package io.dotcipher.jtoolbox.blacksheep;

import io.dotcipher.jtoolbox.blacksheep.challenges.Programming1_JustToGetStartedSolver;

/**
 * @author cmoore
 */
public class BlackSheepSolver {

    public BlackSheepCredentials credentials;
    public Programming1_JustToGetStartedSolver programming1Solver;

    public BlackSheepSolver(String username, String password) {
        this.credentials = new BlackSheepCredentials(username, password);
    }

}
