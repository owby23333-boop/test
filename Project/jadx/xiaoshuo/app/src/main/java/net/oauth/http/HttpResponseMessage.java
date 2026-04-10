package net.oauth.http;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public abstract class HttpResponseMessage extends HttpMessage {
    public static final String EOL = "\r\n";
    public static final String LOCATION = "Location";
    public static final String STATUS_CODE = "HTTP status";
    public static final int STATUS_OK = 200;

    public HttpResponseMessage(String str, URL url) {
        super(str, url);
    }

    @Override // net.oauth.http.HttpMessage
    public void dump(Map<String, Object> map) throws IOException {
        super.dump(map);
        map.put("HTTP status", Integer.valueOf(getStatusCode()));
        String header = getHeader("Location");
        if (header != null) {
            map.put("Location", header);
        }
    }

    public abstract int getStatusCode() throws IOException;
}
