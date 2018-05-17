package io.dotcipher.shodan.challenges;

import com.google.common.collect.Lists;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * @author cmoore
 */
public abstract class AbstractChallengeClient implements ChallengeClient {

    private WebDriver webDriver;
    private String loginUrl;
    private String logoutUrl;
    private LoginFormLocator loginFormLocator;

    private Credentials credentials = getCredentials();

    private List<ChallengeSolver> registeredSolvers = Lists.newArrayList();

    public AbstractChallengeClient(String loginUrl, String logoutUrl, LoginFormLocator loginFormLocator) {
        this.webDriver = new HtmlUnitDriver();
        this.loginUrl = loginUrl;
        this.logoutUrl = logoutUrl;
        this.loginFormLocator = loginFormLocator;
    }

    protected AbstractChallengeClient(String loginUrl, String logoutUrl,
                                   LoginFormLocator loginFormLocator,
                                   List<ChallengeSolver> solversToRegister) {
        this.webDriver = new HtmlUnitDriver();
        this.loginUrl = loginUrl;
        this.logoutUrl = logoutUrl;
        this.loginFormLocator = loginFormLocator;
        this.registeredSolvers = solversToRegister;
    }

    protected abstract Credentials getCredentials();

    /**
     * Logs into the challenge client using supplied credentials.
     */
    private void login() {
        this.webDriver.get(this.loginUrl);
        WebElement userInputElement = this.webDriver.findElement(loginFormLocator.username());
        userInputElement.sendKeys(credentials.getUsername());
        WebElement passwordInputElement = this.webDriver.findElement(loginFormLocator.password());
        passwordInputElement.sendKeys(credentials.getPassword());
        passwordInputElement.submit();
    }

    /**
     * Solve a specific set of challenge solvers.
     *
     * @param challengeSolvers The set of challenge solvers to solve.
     */
    @Override
    public void solve(ChallengeSolver... challengeSolvers) {
        System.out.println("Logging in with creds: "
                + this.getCredentials().getUsername()
                + ":" + this.getCredentials().getPassword());
        login();
        for (ChallengeSolver solver : challengeSolvers) {
            solver.solve(webDriver);
        }
        System.out.println("Logging out");
        logout();
    }

    public boolean registerSolver(ChallengeSolver solver) {
        return registeredSolvers.add(solver);
    }

    /**
     * Solve all pre-registered challenge solvers associated with this client.
     */
    @Override
    public void solve() {
        login();
        for (ChallengeSolver solver : registeredSolvers) {
            solver.solve(webDriver);
        }
        logout();
    }

    /**
     * Logs out of the challenge client.
     */
    public void logout() {
        this.webDriver.get(this.logoutUrl);
    }
}
