package net.oauth.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import net.oauth.OAuth;
import net.oauth.http.HttpMessage;
import net.oauth.http.HttpResponseMessage;

/* JADX INFO: loaded from: classes9.dex */
public class URLConnectionResponse extends HttpResponseMessage {
    private final URLConnection connection;
    private final String requestEncoding;
    private final byte[] requestExcerpt;
    private final String requestHeaders;

    public URLConnectionResponse(HttpMessage httpMessage, String str, byte[] bArr, URLConnection uRLConnection) throws IOException {
        super(httpMessage.method, httpMessage.url);
        this.requestHeaders = str;
        this.requestExcerpt = bArr;
        this.requestEncoding = httpMessage.getContentCharset();
        this.connection = uRLConnection;
        this.headers.addAll(getHeaders());
    }

    private List<Map.Entry<String, String>> getHeaders() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        while (true) {
            String headerField = getHeaderField(this.connection, i);
            if (headerField == null) {
                break;
            }
            String headerFieldKey = getHeaderFieldKey(this.connection, i);
            if (headerFieldKey != null) {
                arrayList.add(new OAuth.Parameter(headerFieldKey, headerField));
                if ("Content-Type".equalsIgnoreCase(headerFieldKey)) {
                    z = true;
                }
            }
            i++;
        }
        if (!z) {
            arrayList.add(new OAuth.Parameter("Content-Type", this.connection.getContentType()));
        }
        return arrayList;
    }

    @Override // net.oauth.http.HttpResponseMessage, net.oauth.http.HttpMessage
    public void dump(Map<String, Object> map) throws IOException {
        super.dump(map);
        StringBuilder sb = new StringBuilder(this.requestHeaders);
        sb.append(HttpResponseMessage.EOL);
        byte[] bArr = this.requestExcerpt;
        if (bArr != null) {
            sb.append(new String(bArr, this.requestEncoding));
        }
        map.put("HTTP request", sb.toString());
        URLConnection uRLConnection = this.connection;
        HttpURLConnection httpURLConnection = uRLConnection instanceof HttpURLConnection ? (HttpURLConnection) uRLConnection : null;
        StringBuilder sb2 = new StringBuilder();
        int i = 0;
        while (true) {
            String headerField = getHeaderField(this.connection, i);
            if (headerField == null) {
                break;
            }
            String headerFieldKey = getHeaderFieldKey(this.connection, i);
            if (i == 0 && headerFieldKey != null && httpURLConnection != null) {
                String str = "HTTP " + getStatusCode();
                String responseMessage = httpURLConnection.getResponseMessage();
                if (responseMessage != null) {
                    str = String.valueOf(str) + " " + responseMessage;
                }
                sb2.append(str);
                sb2.append(HttpResponseMessage.EOL);
            }
            if (headerFieldKey != null) {
                sb2.append(headerFieldKey);
                sb2.append(": ");
                headerFieldKey.toLowerCase();
            }
            sb2.append(headerField);
            sb2.append(HttpResponseMessage.EOL);
            i++;
        }
        sb2.append(HttpResponseMessage.EOL);
        InputStream inputStream = this.body;
        if (inputStream != null) {
            sb2.append(new String(((ExcerptInputStream) inputStream).getExcerpt(), getContentCharset()));
        }
        map.put("HTTP response", sb2.toString());
    }

    public String getHeaderField(URLConnection uRLConnection, int i) {
        try {
            return uRLConnection.getHeaderField(i);
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    public String getHeaderFieldKey(URLConnection uRLConnection, int i) {
        try {
            return uRLConnection.getHeaderFieldKey(i);
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    @Override // net.oauth.http.HttpResponseMessage
    public int getStatusCode() throws IOException {
        URLConnection uRLConnection = this.connection;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 200;
    }

    @Override // net.oauth.http.HttpMessage
    public InputStream openBody() {
        try {
            return this.connection.getInputStream();
        } catch (IOException unused) {
            return null;
        }
    }
}
