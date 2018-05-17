package io.dotcipher.shodan.challenges.blacksheep.solvers;

import com.google.common.base.Optional;
import io.dotcipher.shodan.challenges.AbstractTimedChallengeSolver;
import io.dotcipher.shodan.challenges.blacksheep.BlackSheepPath;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author cmoore
 */
public class BlackSheepProgrammingOneSolver extends AbstractTimedChallengeSolver {

    private static final String PROGRAMMING_CHALLENGE_ROOT = BlackSheepPath.getProgrammingChallenges();

    private static final String PROBLEM_PATH = "/get_started/tryout.php";
    private static final String SOLUTION_PATH = "/get_started/solution.php?solution=";
    private static final String SUBMISSION_PATH = "/get_started/index.php";

    @Override
    public void timedSolve(WebDriver webDriver) {
        if (webDriver.manage().getCookies().isEmpty()) {
            System.out.println("Not logged in, returning.");
            return;
        }
        String challengeSite = PROGRAMMING_CHALLENGE_ROOT + PROBLEM_PATH;
        String solutionSite = PROGRAMMING_CHALLENGE_ROOT + SOLUTION_PATH;
        String submissionSite = PROGRAMMING_CHALLENGE_ROOT + SUBMISSION_PATH;
        webDriver.get(challengeSite);
        String text = webDriver.getPageSource();
        // Match solution from regex
        Optional<String> solutionText = findFirstGroupFromRegex(text, "The \"text\" is: '(.*)\'");
        if (!solutionText.isPresent()) {
            System.out.println("Could not find solution text at challenge site: " + challengeSite);
        }
        // Go to solution page and get source
        webDriver.get(solutionSite + solutionText.get());
        String answerPageSource = webDriver.getPageSource();
        // Match answer text
        Optional<String> answerText = findFirstGroupFromRegex(answerPageSource, "The keyword is \"(.*)\"");
        if (!answerText.isPresent()) {
            System.out.println("Could not find answer text on answer page: " + answerPageSource);
            System.out.println("Cancelling auto submit and returning...");
        }
        // Submit the answer
        webDriver.get(submissionSite);
        WebElement submissionInput = webDriver.findElement(By.className("challenge_edit"));
        submissionInput.clear();
        submissionInput.sendKeys(answerText.get());
        WebElement submissionButton = webDriver.findElement(By.className("challenge_submit"));
        submissionButton.click();
    }

    private Optional<String> findFirstGroupFromRegex(String sourceText, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sourceText);
        if (matcher.find() && matcher.groupCount() >= 1) {
            return Optional.of(matcher.group(1));
        }
        return Optional.absent();
    }

}
