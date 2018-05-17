package io.dotcipher.shodan.challenges;

/**
 * @author cmoore
 */
public interface ChallengeClient {

    /**
     * Solve a specific set of challenge solvers.
     *
     * @param challengeSolvers The set of challenge solvers to solve.
     */
    void solve(ChallengeSolver...challengeSolvers);

    /**
     * Solve all pre-registered challenge solvers associated with this client.
     */
    void solve();

}
