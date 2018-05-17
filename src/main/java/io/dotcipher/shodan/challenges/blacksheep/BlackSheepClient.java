package io.dotcipher.shodan.challenges.blacksheep;

import com.google.common.collect.Lists;
import io.dotcipher.shodan.challenges.AbstractChallengeClient;
import io.dotcipher.shodan.challenges.ChallengeSolver;
import io.dotcipher.shodan.challenges.Credentials;
import io.dotcipher.shodan.challenges.LoginFormLocator;
import java.io.InputStream;
import java.util.List;

/**
 * @author cmoore
 */
public class BlackSheepClient extends AbstractChallengeClient {

    private static final LoginFormLocator LOGIN_FORM_LOCATOR = new BlackSheepLoginFormLocator();

    private static final List<ChallengeSolver> BLACK_SHEEP_SOLVERS = Lists.newArrayList(

    );

    public BlackSheepClient() {
        super(BlackSheepPath.getLogin(), BlackSheepPath.getLogout(), LOGIN_FORM_LOCATOR);
    }

    protected BlackSheepClient(List<ChallengeSolver> solversToRegister) {
        super(BlackSheepPath.getLogin(), BlackSheepPath.getLogout(), LOGIN_FORM_LOCATOR, BLACK_SHEEP_SOLVERS);
    }

    @Override
    protected Credentials getCredentials() {
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("io/dotcipher/shodan/challenges/blacksheep/credentials.properties");
        if (inputStream == null) {
            System.out.println("No \"credentials.properties\" file found");
        }
        return Credentials.fromResource(inputStream);
    }
}
