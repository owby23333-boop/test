package net.oauth.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

/* JADX INFO: loaded from: classes9.dex */
public class HttpMessageDecoder extends HttpResponseMessage {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String ACCEPTED = "gzip,deflate";
    public static final String DEFLATE = "deflate";
    public static final String GZIP = "gzip";
    private final HttpResponseMessage in;

    private HttpMessageDecoder(HttpResponseMessage httpResponseMessage, String str) throws IOException {
        InputStream inflaterInputStream;
        super(httpResponseMessage.method, httpResponseMessage.url);
        this.headers.addAll(httpResponseMessage.headers);
        removeHeaders("Content-Encoding");
        removeHeaders("Content-Length");
        InputStream body = httpResponseMessage.getBody();
        if (body != null) {
            if (str == "gzip") {
                inflaterInputStream = new GZIPInputStream(body);
            } else {
                inflaterInputStream = str == DEFLATE ? new InflaterInputStream(body) : inflaterInputStream;
            }
            body = inflaterInputStream;
        }
        this.body = body;
        this.in = httpResponseMessage;
    }

    public static HttpResponseMessage decode(HttpResponseMessage httpResponseMessage) throws IOException {
        String encoding;
        return (httpResponseMessage == null || (encoding = getEncoding(httpResponseMessage)) == null) ? httpResponseMessage : new HttpMessageDecoder(httpResponseMessage, encoding);
    }

    private static String getEncoding(HttpMessage httpMessage) {
        String header = httpMessage.getHeader("Content-Encoding");
        if (header == null) {
            return null;
        }
        String str = "gzip";
        if (!"gzip".equalsIgnoreCase(header) && !"x-gzip".equalsIgnoreCase(header)) {
            str = DEFLATE;
            if (!DEFLATE.equalsIgnoreCase(header)) {
                return null;
            }
        }
        return str;
    }

    @Override // net.oauth.http.HttpResponseMessage, net.oauth.http.HttpMessage
    public void dump(Map<String, Object> map) throws IOException {
        this.in.dump(map);
    }

    @Override // net.oauth.http.HttpResponseMessage
    public int getStatusCode() throws IOException {
        return this.in.getStatusCode();
    }
}
