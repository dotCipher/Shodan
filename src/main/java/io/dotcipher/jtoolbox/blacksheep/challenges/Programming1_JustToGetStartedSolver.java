package io.dotcipher.jtoolbox.blacksheep.challenges;

import com.google.common.collect.Lists;
import io.dotcipher.jtoolbox.blacksheep.BlackSheepCredentials;
import io.dotcipher.jtoolbox.http.HttpBot;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.util.List;

public final class Programming1_JustToGetStartedSolver {

    private static final String LOGIN_FORM = "http://www.bright-shadows.net/login.php";
    private static final String DEFAULT_FROM = "http://www.bright-shadows.net/challenges/"
            + "programming/get_started/tryout.php";
    private static final String DEFAULT_TO = "http://www.bright-shadows.net/challenges/programming/get_started/"
            + "solution.php?solution=";

    private final HttpBot bot;
    private final BlackSheepCredentials credentials;

    public Programming1_JustToGetStartedSolver(BlackSheepCredentials credentials) {
        this.bot = new HttpBot();
        this.credentials = credentials;
    }

    public void solve() throws IOException {
        Header usernameHeader = new BasicHeader("edit_username", credentials.getUsername());
        Header passwordHeader = new BasicHeader("edit_password", credentials.getPassword());
        List<Header> postHeaders = Lists.newArrayList(usernameHeader, passwordHeader);
        HttpResponse response = bot.post(LOGIN_FORM, postHeaders);
    }

}
