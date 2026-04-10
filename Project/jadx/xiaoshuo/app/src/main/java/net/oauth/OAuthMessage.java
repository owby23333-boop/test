package net.oauth;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import net.oauth.OAuth;
import net.oauth.signature.OAuthSignatureMethod;

/* JADX INFO: loaded from: classes9.dex */
public class OAuthMessage {
    public static final String AUTH_SCHEME = "OAuth";
    public static final String DELETE = "DELETE";
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public String URL;
    private final InputStream bodyAsStream;
    private final List<Map.Entry<String, String>> headers;
    public String method;
    private Map<String, String> parameterMap;
    private final List<Map.Entry<String, String>> parameters;
    private boolean parametersAreComplete;
    private static final Pattern AUTHORIZATION = Pattern.compile("\\s*(\\w*)\\s+(.*)");
    private static final Pattern NVP = Pattern.compile("(\\S*)\\s*\\=\\s*\"([^\"]*)\"");

    public OAuthMessage(String str, String str2, Collection<? extends Map.Entry> collection) {
        this(str, str2, collection, null);
    }

    private void beforeGetParameter() throws IOException {
        if (this.parametersAreComplete) {
            return;
        }
        completeParameters();
        this.parametersAreComplete = true;
    }

    public static List<OAuth.Parameter> decodeAuthorization(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            Matcher matcher = AUTHORIZATION.matcher(str);
            if (matcher.matches() && AUTH_SCHEME.equalsIgnoreCase(matcher.group(1))) {
                for (String str2 : matcher.group(2).split("\\s*,\\s*")) {
                    Matcher matcher2 = NVP.matcher(str2);
                    if (matcher2.matches()) {
                        arrayList.add(new OAuth.Parameter(OAuth.decodePercent(matcher2.group(1)), OAuth.decodePercent(matcher2.group(2))));
                    }
                }
            }
        }
        return arrayList;
    }

    public static String readAll(InputStream inputStream, String str) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
            char[] cArr = new char[512];
            while (true) {
                int i = inputStreamReader.read(cArr);
                if (i <= 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, i);
            }
        } finally {
            inputStream.close();
        }
    }

    public void addParameter(String str, String str2) {
        addParameter(new OAuth.Parameter(str, str2));
    }

    public void addParameters(Collection<? extends Map.Entry<String, String>> collection) {
        this.parameters.addAll(collection);
        this.parameterMap = null;
    }

    public void addRequiredParameters(OAuthAccessor oAuthAccessor) throws OAuthException, URISyntaxException, IOException {
        String str;
        Map<String, String> mapNewMap = OAuth.newMap(this.parameters);
        if (mapNewMap.get(OAuth.OAUTH_TOKEN) == null && (str = oAuthAccessor.accessToken) != null) {
            addParameter(OAuth.OAUTH_TOKEN, str);
        }
        OAuthConsumer oAuthConsumer = oAuthAccessor.consumer;
        if (mapNewMap.get(OAuth.OAUTH_CONSUMER_KEY) == null) {
            addParameter(OAuth.OAUTH_CONSUMER_KEY, oAuthConsumer.consumerKey);
        }
        if (mapNewMap.get(OAuth.OAUTH_SIGNATURE_METHOD) == null) {
            String str2 = (String) oAuthConsumer.getProperty(OAuth.OAUTH_SIGNATURE_METHOD);
            if (str2 == null) {
                str2 = OAuth.HMAC_SHA1;
            }
            addParameter(OAuth.OAUTH_SIGNATURE_METHOD, str2);
        }
        if (mapNewMap.get(OAuth.OAUTH_TIMESTAMP) == null) {
            addParameter(OAuth.OAUTH_TIMESTAMP, new StringBuilder(String.valueOf(System.currentTimeMillis() / 1000)).toString());
        }
        if (mapNewMap.get(OAuth.OAUTH_NONCE) == null) {
            addParameter(OAuth.OAUTH_NONCE, new StringBuilder(String.valueOf(System.nanoTime())).toString());
        }
        if (mapNewMap.get(OAuth.OAUTH_VERSION) == null) {
            addParameter(OAuth.OAUTH_VERSION, "1.0");
        }
        sign(oAuthAccessor);
    }

    public void completeParameters() throws IOException {
    }

    public void dump(Map<String, Object> map) throws IOException {
        map.put(OAuthProblemException.URL, this.URL);
        if (this.parametersAreComplete) {
            try {
                map.putAll(getParameterMap());
            } catch (Exception unused) {
            }
        }
    }

    public String getAuthorizationHeader(String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(" realm=\"");
            sb.append(OAuth.percentEncode(str));
            sb.append(Typography.quote);
        }
        beforeGetParameter();
        List<Map.Entry<String, String>> list = this.parameters;
        if (list != null) {
            for (Map.Entry<String, String> entry : list) {
                String string = toString(entry.getKey());
                if (string.startsWith("oauth_")) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(" ");
                    sb.append(OAuth.percentEncode(string));
                    sb.append("=\"");
                    sb.append(OAuth.percentEncode(toString(entry.getValue())));
                    sb.append(Typography.quote);
                }
            }
        }
        return AUTH_SCHEME + sb.toString();
    }

    public InputStream getBodyAsStream() throws IOException {
        return this.bodyAsStream;
    }

    public String getBodyEncoding() {
        return "ISO-8859-1";
    }

    public String getBodyType() {
        return getHeader("Content-Type");
    }

    public String getConsumerKey() throws IOException {
        return getParameter(OAuth.OAUTH_CONSUMER_KEY);
    }

    public Map<String, Object> getDump() throws IOException {
        HashMap map = new HashMap();
        dump(map);
        return map;
    }

    public final String getHeader(String str) {
        String value = null;
        for (Map.Entry<String, String> entry : getHeaders()) {
            if (str.equalsIgnoreCase(entry.getKey())) {
                value = entry.getValue();
            }
        }
        return value;
    }

    public final List<Map.Entry<String, String>> getHeaders() {
        return this.headers;
    }

    public String getParameter(String str) throws IOException {
        return getParameterMap().get(str);
    }

    public Map<String, String> getParameterMap() throws IOException {
        beforeGetParameter();
        if (this.parameterMap == null) {
            this.parameterMap = OAuth.newMap(this.parameters);
        }
        return this.parameterMap;
    }

    public List<Map.Entry<String, String>> getParameters() throws IOException {
        beforeGetParameter();
        return Collections.unmodifiableList(this.parameters);
    }

    public String getSignature() throws IOException {
        return getParameter(OAuth.OAUTH_SIGNATURE);
    }

    public String getSignatureMethod() throws IOException {
        return getParameter(OAuth.OAUTH_SIGNATURE_METHOD);
    }

    public String getToken() throws IOException {
        return getParameter(OAuth.OAUTH_TOKEN);
    }

    public final String readBodyAsString() throws IOException {
        return readAll(getBodyAsStream(), getBodyEncoding());
    }

    public void requireParameters(String... strArr) throws IOException, OAuthProblemException {
        Set<String> setKeySet = getParameterMap().keySet();
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!setKeySet.contains(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        OAuthProblemException oAuthProblemException = new OAuthProblemException(OAuth.Problems.PARAMETER_ABSENT);
        oAuthProblemException.setParameter(OAuth.Problems.OAUTH_PARAMETERS_ABSENT, OAuth.percentEncode(arrayList));
        throw oAuthProblemException;
    }

    public void sign(OAuthAccessor oAuthAccessor) throws OAuthException, URISyntaxException, IOException {
        OAuthSignatureMethod.newSigner(this, oAuthAccessor).sign(this);
    }

    public String toString() {
        return "OAuthMessage(" + this.method + ", " + this.URL + ", " + this.parameters + ")";
    }

    public OAuthMessage(String str, String str2, Collection<? extends Map.Entry> collection, InputStream inputStream) {
        this.parametersAreComplete = false;
        this.headers = new ArrayList();
        this.method = str;
        this.URL = str2;
        this.bodyAsStream = inputStream;
        if (collection == null) {
            this.parameters = new ArrayList();
            return;
        }
        this.parameters = new ArrayList(collection.size());
        for (Map.Entry entry : collection) {
            this.parameters.add(new OAuth.Parameter(toString(entry.getKey()), toString(entry.getValue())));
        }
    }

    private static final String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public void addParameter(Map.Entry<String, String> entry) {
        this.parameters.add(entry);
        this.parameterMap = null;
    }
}
