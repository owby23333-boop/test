package net.oauth.http;

import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.oauth.OAuth;
import net.oauth.OAuthMessage;
import net.oauth.ParameterStyle;
import net.oauth.client.ExcerptInputStream;

/* JADX INFO: loaded from: classes9.dex */
public class HttpMessage {
    private static /* synthetic */ int[] $SWITCH_TABLE$net$oauth$ParameterStyle = null;
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    private static final Pattern CHARSET = Pattern.compile("; *charset *= *([^;\"]*|\"([^\"]|\\\\\")*\")(;|$)");
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String DEFAULT_CHARSET = "ISO-8859-1";
    public static final String REQUEST = "HTTP request";
    public static final String RESPONSE = "HTTP response";
    public static final String STATUS_CODE = "HTTP status";
    protected InputStream body;
    public final List<Map.Entry<String, String>> headers;
    public String method;
    public URL url;

    public static /* synthetic */ int[] $SWITCH_TABLE$net$oauth$ParameterStyle() {
        int[] iArr = $SWITCH_TABLE$net$oauth$ParameterStyle;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[ParameterStyle.valuesCustom().length];
        try {
            iArr2[ParameterStyle.AUTHORIZATION_HEADER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[ParameterStyle.BODY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[ParameterStyle.QUERY_STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$net$oauth$ParameterStyle = iArr2;
        return iArr2;
    }

    public HttpMessage() {
        this(null, null);
    }

    private static boolean equalsIgnoreCase(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    private static final String getCharset(String str) {
        if (str == null) {
            return "ISO-8859-1";
        }
        Matcher matcher = CHARSET.matcher(str);
        if (!matcher.find()) {
            return "ISO-8859-1";
        }
        String strGroup = matcher.group(1);
        return (strGroup.length() >= 2 && strGroup.charAt(0) == '\"' && strGroup.charAt(strGroup.length() - 1) == '\"') ? strGroup.substring(1, strGroup.length() - 1).replace("\\\"", "\"") : strGroup;
    }

    public static HttpMessage newRequest(OAuthMessage oAuthMessage, ParameterStyle parameterStyle) throws IOException {
        boolean zEqualsIgnoreCase = "POST".equalsIgnoreCase(oAuthMessage.method);
        InputStream bodyAsStream = oAuthMessage.getBodyAsStream();
        if (parameterStyle == ParameterStyle.BODY && (!zEqualsIgnoreCase || bodyAsStream != null)) {
            parameterStyle = ParameterStyle.QUERY_STRING;
        }
        String strAddParameters = oAuthMessage.URL;
        ArrayList arrayList = new ArrayList(oAuthMessage.getHeaders());
        int i = $SWITCH_TABLE$net$oauth$ParameterStyle()[parameterStyle.ordinal()];
        if (i == 1) {
            arrayList.add(new OAuth.Parameter(HttpHeaders.AUTHORIZATION, oAuthMessage.getAuthorizationHeader(null)));
            List<Map.Entry<String, String>> parameters = oAuthMessage.getParameters();
            if (parameters != null && !parameters.isEmpty()) {
                ArrayList arrayList2 = new ArrayList(parameters);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    if (((String) ((Map.Entry) it.next()).getKey()).startsWith("oauth_")) {
                        it.remove();
                    }
                }
                if (zEqualsIgnoreCase && bodyAsStream == null) {
                    byte[] bytes = OAuth.formEncode(arrayList2).getBytes(oAuthMessage.getBodyEncoding());
                    arrayList.add(new OAuth.Parameter("Content-Type", "application/x-www-form-urlencoded"));
                    arrayList.add(new OAuth.Parameter("Content-Length", new StringBuilder(String.valueOf(bytes.length)).toString()));
                    bodyAsStream = new ByteArrayInputStream(bytes);
                } else {
                    strAddParameters = OAuth.addParameters(strAddParameters, arrayList2);
                }
            }
        } else if (i == 2) {
            byte[] bytes2 = OAuth.formEncode(oAuthMessage.getParameters()).getBytes(oAuthMessage.getBodyEncoding());
            arrayList.add(new OAuth.Parameter("Content-Type", "application/x-www-form-urlencoded"));
            arrayList.add(new OAuth.Parameter("Content-Length", new StringBuilder(String.valueOf(bytes2.length)).toString()));
            bodyAsStream = new ByteArrayInputStream(bytes2);
        } else if (i == 3) {
            strAddParameters = OAuth.addParameters(strAddParameters, oAuthMessage.getParameters());
        }
        HttpMessage httpMessage = new HttpMessage(oAuthMessage.method, new URL(strAddParameters), bodyAsStream);
        httpMessage.headers.addAll(arrayList);
        return httpMessage;
    }

    public void dump(Map<String, Object> map) throws IOException {
    }

    public final InputStream getBody() throws IOException {
        InputStream inputStreamOpenBody;
        if (this.body == null && (inputStreamOpenBody = openBody()) != null) {
            this.body = new ExcerptInputStream(inputStreamOpenBody);
        }
        return this.body;
    }

    public final String getContentCharset() {
        return getCharset(getHeader("Content-Type"));
    }

    public final String getHeader(String str) {
        String value = null;
        for (Map.Entry<String, String> entry : this.headers) {
            if (equalsIgnoreCase(str, entry.getKey())) {
                value = entry.getValue();
            }
        }
        return value;
    }

    public InputStream openBody() throws IOException {
        return null;
    }

    public String removeHeaders(String str) {
        Iterator<Map.Entry<String, String>> it = this.headers.iterator();
        String value = null;
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (equalsIgnoreCase(str, next.getKey())) {
                value = next.getValue();
                it.remove();
            }
        }
        return value;
    }

    public HttpMessage(String str, URL url) {
        this(str, url, null);
    }

    public HttpMessage(String str, URL url, InputStream inputStream) {
        this.headers = new ArrayList();
        this.method = str;
        this.url = url;
        this.body = inputStream;
    }
}
