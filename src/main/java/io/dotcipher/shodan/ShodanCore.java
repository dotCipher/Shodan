package io.dotcipher.shodan;

import io.dotcipher.shodan.challenges.blacksheep.BlackSheepClient;
import io.dotcipher.shodan.challenges.blacksheep.solvers.BlackSheepProgrammingOneSolver;

public class ShodanCore {

    public static void main(String[] args) {
        BlackSheepClient blackSheepClient = new BlackSheepClient();
        blackSheepClient.solve(new BlackSheepProgrammingOneSolver());
    }

}
