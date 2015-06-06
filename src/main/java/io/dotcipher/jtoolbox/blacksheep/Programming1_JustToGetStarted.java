package io.dotcipher.jtoolbox.blacksheep;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import sun.net.www.http.HttpClient;

public class Programming1_JustToGetStarted {

    private static final String DEFAULT_FROM = "http://www.bright-shadows.net/challenges/"
            + "programming/get_started/tryout.php";
    private static final String DEFAULT_TO = "http://www.bright-shadows.net/challenges/programming/get_started/"
            + "solution.php?solution=";

    private String fromUrl;
    private String toUrl;

    public Programming1_JustToGetStarted() {
        fromUrl = DEFAULT_FROM;
        toUrl = DEFAULT_TO;
    }

    public void run() throws IOException {
        URL obj = new URL(fromUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + fromUrl);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // print result
        System.out.println(response.toString());
    }

    public void runViaHttpClient() {
        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost("http://localhost/index.php");
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        HttpResponse httpResponse = httpClient.execute(httpPost);

        BufferedInputStream bis = new BufferedInputStream(httpResponse.getEntity().getContent()); // Just gets the HTML
        // content, not the
        // cookies
    }

}
