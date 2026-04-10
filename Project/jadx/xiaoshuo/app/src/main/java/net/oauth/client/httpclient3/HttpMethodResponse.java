package net.oauth.client.httpclient3;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.oauth.OAuth;
import net.oauth.client.ExcerptInputStream;
import net.oauth.http.HttpResponseMessage;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpMethod;

/* JADX INFO: loaded from: classes9.dex */
public class HttpMethodResponse extends HttpResponseMessage {
    private final HttpMethod method;
    private final byte[] requestBody;
    private final String requestEncoding;

    public HttpMethodResponse(HttpMethod httpMethod, byte[] bArr, String str) throws IOException {
        super(httpMethod.getName(), new URL(httpMethod.getURI().toString()));
        this.method = httpMethod;
        this.requestBody = bArr;
        this.requestEncoding = str;
        this.headers.addAll(getHeaders());
    }

    private List<Map.Entry<String, String>> getHeaders() {
        ArrayList arrayList = new ArrayList();
        Header[] responseHeaders = this.method.getResponseHeaders();
        if (responseHeaders != null) {
            for (Header header : responseHeaders) {
                arrayList.add(new OAuth.Parameter(header.getName(), header.getValue()));
            }
        }
        return arrayList;
    }

    @Override // net.oauth.http.HttpResponseMessage, net.oauth.http.HttpMessage
    public void dump(Map<String, Object> map) throws IOException {
        super.dump(map);
        StringBuilder sb = new StringBuilder(this.method.getName());
        sb.append(" ");
        sb.append(this.method.getPath());
        String queryString = this.method.getQueryString();
        if (queryString != null && queryString.length() > 0) {
            sb.append("?");
            sb.append(queryString);
        }
        sb.append(HttpResponseMessage.EOL);
        for (Header header : this.method.getRequestHeaders()) {
            sb.append(header.getName());
            sb.append(": ");
            sb.append(header.getValue());
            sb.append(HttpResponseMessage.EOL);
        }
        sb.append(HttpResponseMessage.EOL);
        byte[] bArr = this.requestBody;
        if (bArr != null) {
            sb.append(new String(bArr, this.requestEncoding));
        }
        map.put("HTTP request", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.method.getStatusLine().toString());
        sb2.append(HttpResponseMessage.EOL);
        for (Header header2 : this.method.getResponseHeaders()) {
            String name = header2.getName();
            String value = header2.getValue();
            sb2.append(name);
            sb2.append(": ");
            sb2.append(value);
            sb2.append(HttpResponseMessage.EOL);
        }
        sb2.append(HttpResponseMessage.EOL);
        InputStream inputStream = this.body;
        if (inputStream != null) {
            sb2.append(new String(((ExcerptInputStream) inputStream).getExcerpt(), getContentCharset()));
        }
        map.put("HTTP response", sb2.toString());
    }

    @Override // net.oauth.http.HttpResponseMessage
    public int getStatusCode() {
        return this.method.getStatusCode();
    }

    @Override // net.oauth.http.HttpMessage
    public InputStream openBody() throws IOException {
        return this.method.getResponseBodyAsStream();
    }
}
