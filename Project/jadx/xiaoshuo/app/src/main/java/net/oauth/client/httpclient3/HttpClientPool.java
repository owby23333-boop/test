package net.oauth.client.httpclient3;

import java.net.URL;
import org.apache.commons.httpclient.HttpClient;

/* JADX INFO: loaded from: classes9.dex */
public interface HttpClientPool {
    HttpClient getHttpClient(URL url);
}
