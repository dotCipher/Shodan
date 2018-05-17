package io.dotcipher.shodan.challenges.blacksheep;

/**
 * @author cmoore
 */
public class BlackSheepPath {

    private BlackSheepPath() {

    }

    private static final String HTTP_PREFIX = "http://";
    private static final String ROOT_URL = "www.bright-shadows.net";

    private static final String FULL_URL = HTTP_PREFIX + ROOT_URL;

    private static final String LOGIN_SUFFIX = "/login.php";
    private static final String LOGOUT_SUFFIX = "/logout.php";

    private static final String CHALLENGES = "/challenges";
    private static final String PROGRAMMING = "/programming";

    public static String getBase() {
        return FULL_URL;
    }

    public static String getLogin() {
        return FULL_URL+ LOGIN_SUFFIX;
    }

    public static String getLogout() {
        return FULL_URL + LOGOUT_SUFFIX;
    }

    public static String getChallenges() {
        return FULL_URL + CHALLENGES;
    }

    public static String getProgrammingChallenges() {
        return FULL_URL + CHALLENGES + PROGRAMMING;
    }
}
