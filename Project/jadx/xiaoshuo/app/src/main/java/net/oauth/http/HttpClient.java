package net.oauth.http;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public interface HttpClient {
    public static final String CONNECT_TIMEOUT = "connectTimeout";
    public static final String DELETE = "DELETE";
    public static final String FOLLOW_REDIRECTS = "followRedirects";
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String READ_TIMEOUT = "readTimeout";

    HttpResponseMessage execute(HttpMessage httpMessage, Map<String, Object> map) throws IOException;
}
