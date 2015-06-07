package io.dotcipher.jtoolbox.http;

import com.google.common.collect.Lists;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.Collection;
import java.util.List;

/**
 * @author cmoore
 */
public class HttpBot {

    private String cookies;
    private HttpClient client;

    private static final Collection<Header> DEFAULT_HEADERS = Lists.newArrayList();

    static {
        DEFAULT_HEADERS.add(new BasicHeader("Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"));
        DEFAULT_HEADERS.add(new BasicHeader("Accept-Encoding",
                "gzip, deflate"));
        DEFAULT_HEADERS.add(new BasicHeader("Accept-Language",
                "en-US,en;q=0.5"));
        DEFAULT_HEADERS.add(new BasicHeader("Connection",
                "keep-alive"));
    }

    public HttpBot() {
        CookieHandler.setDefault(new CookieManager());
        client = HttpClientBuilder.create()
                .setUserAgent("Mozilla/5.0")
                .setDefaultHeaders(DEFAULT_HEADERS)
                .build();
    }

    public HttpResponse postXWwwFormUrlencoded(String url, List<Header> headers) throws IOException {
        List<Header> headersClone = Lists.newArrayList(headers);
        headersClone.add(new BasicHeader("Content-Type", "application/x-www-form-urlencoded"));
        return post(url, headersClone);
    }

    public HttpResponse post(String url, List<Header> headers) throws IOException {
        HttpPost post = new HttpPost(url);
        headers.forEach(post::addHeader);
        return client.execute(post);
    }

}
