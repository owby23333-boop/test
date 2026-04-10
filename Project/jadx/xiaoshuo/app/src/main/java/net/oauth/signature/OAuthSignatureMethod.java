package net.oauth.signature;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.Typography;
import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import net.oauth.OAuthProblemException;

/* JADX INFO: loaded from: classes9.dex */
public abstract class OAuthSignatureMethod {
    private static final String BASE64_ENCODING = "ISO-8859-1";
    public static final String _ACCESSOR = "-Accessor";
    private String consumerSecret;
    private String tokenSecret;
    private static final Base64 BASE64 = new Base64();
    private static final Map<String, Class> NAME_TO_CLASS = new ConcurrentHashMap();

    public static class ComparableParameter implements Comparable<ComparableParameter> {
        private final String key;
        final Map.Entry value;

        public ComparableParameter(Map.Entry entry) {
            this.value = entry;
            this.key = String.valueOf(OAuth.percentEncode(toString(entry.getKey()))) + ' ' + OAuth.percentEncode(toString(entry.getValue()));
        }

        private static String toString(Object obj) {
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }

        @Override // java.lang.Comparable
        public int compareTo(ComparableParameter comparableParameter) {
            return this.key.compareTo(comparableParameter.key);
        }

        public String toString() {
            return this.key;
        }
    }

    static {
        registerMethodClass(OAuth.HMAC_SHA1, HMAC_SHA1.class);
        registerMethodClass("PLAINTEXT", PLAINTEXT.class);
        registerMethodClass(OAuth.RSA_SHA1, RSA_SHA1.class);
        registerMethodClass("HMAC-SHA1-Accessor", HMAC_SHA1.class);
        registerMethodClass("PLAINTEXT-Accessor", PLAINTEXT.class);
    }

    public static String base64Encode(byte[] bArr) {
        byte[] bArrEncode = BASE64.encode(bArr);
        try {
            return new String(bArrEncode, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            PrintStream printStream = System.err;
            StringBuilder sb = new StringBuilder();
            sb.append(e);
            printStream.println(sb.toString());
            return new String(bArrEncode);
        }
    }

    public static byte[] decodeBase64(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            PrintStream printStream = System.err;
            StringBuilder sb = new StringBuilder();
            sb.append(e);
            printStream.println(sb.toString());
            bytes = str.getBytes();
        }
        return BASE64.decode(bytes);
    }

    public static boolean equals(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        if (str2 == null) {
            return false;
        }
        if (str2.length() <= 0) {
            return str.length() <= 0;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        char c = (char) (charArray.length == charArray2.length ? 0 : 1);
        int length = 0;
        for (char c2 : charArray) {
            c = (char) (c | (c2 ^ charArray2[length]));
            length = (length + 1) % charArray2.length;
        }
        return c == 0;
    }

    public static String getBaseString(OAuthMessage oAuthMessage) throws URISyntaxException, IOException {
        List<Map.Entry<String, String>> parameters;
        String strSubstring = oAuthMessage.URL;
        int iIndexOf = strSubstring.indexOf(63);
        if (iIndexOf < 0) {
            parameters = oAuthMessage.getParameters();
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(OAuth.decodeForm(oAuthMessage.URL.substring(iIndexOf + 1)));
            arrayList.addAll(oAuthMessage.getParameters());
            strSubstring = strSubstring.substring(0, iIndexOf);
            parameters = arrayList;
        }
        return String.valueOf(OAuth.percentEncode(oAuthMessage.method.toUpperCase())) + Typography.amp + OAuth.percentEncode(normalizeUrl(strSubstring)) + Typography.amp + OAuth.percentEncode(normalizeParameters(parameters));
    }

    private static List<Map.Entry> getParameters(Collection<ComparableParameter> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<ComparableParameter> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().value);
        }
        return arrayList;
    }

    public static OAuthSignatureMethod newMethod(String str, OAuthAccessor oAuthAccessor) throws OAuthException {
        try {
            Map<String, Class> map = NAME_TO_CLASS;
            Class cls = map.get(str);
            if (cls != null) {
                OAuthSignatureMethod oAuthSignatureMethod = (OAuthSignatureMethod) cls.newInstance();
                oAuthSignatureMethod.initialize(str, oAuthAccessor);
                return oAuthSignatureMethod;
            }
            OAuthProblemException oAuthProblemException = new OAuthProblemException(OAuth.Problems.SIGNATURE_METHOD_REJECTED);
            String strPercentEncode = OAuth.percentEncode(map.keySet());
            if (strPercentEncode.length() <= 0) {
                throw oAuthProblemException;
            }
            oAuthProblemException.setParameter("oauth_acceptable_signature_methods", strPercentEncode);
            throw oAuthProblemException;
        } catch (IllegalAccessException e) {
            throw new OAuthException(e);
        } catch (InstantiationException e2) {
            throw new OAuthException(e2);
        }
    }

    public static OAuthSignatureMethod newSigner(OAuthMessage oAuthMessage, OAuthAccessor oAuthAccessor) throws OAuthException, IOException {
        oAuthMessage.requireParameters(OAuth.OAUTH_SIGNATURE_METHOD);
        OAuthSignatureMethod oAuthSignatureMethodNewMethod = newMethod(oAuthMessage.getSignatureMethod(), oAuthAccessor);
        oAuthSignatureMethodNewMethod.setTokenSecret(oAuthAccessor.tokenSecret);
        return oAuthSignatureMethodNewMethod;
    }

    public static String normalizeParameters(Collection<? extends Map.Entry> collection) throws IOException {
        if (collection == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (Map.Entry entry : collection) {
            if (!OAuth.OAUTH_SIGNATURE.equals(entry.getKey())) {
                arrayList.add(new ComparableParameter(entry));
            }
        }
        Collections.sort(arrayList);
        return OAuth.formEncode(getParameters(arrayList));
    }

    public static String normalizeUrl(String str) throws URISyntaxException {
        int iLastIndexOf;
        URI uri = new URI(str);
        String lowerCase = uri.getScheme().toLowerCase();
        String lowerCase2 = uri.getAuthority().toLowerCase();
        if (((lowerCase.equals("http") && uri.getPort() == 80) || (lowerCase.equals("https") && uri.getPort() == 443)) && (iLastIndexOf = lowerCase2.lastIndexOf(":")) >= 0) {
            lowerCase2 = lowerCase2.substring(0, iLastIndexOf);
        }
        String rawPath = uri.getRawPath();
        if (rawPath == null || rawPath.length() <= 0) {
            rawPath = "/";
        }
        return lowerCase + "://" + lowerCase2 + rawPath;
    }

    public static void registerMethodClass(String str, Class cls) {
        if (cls == null) {
            unregisterMethod(str);
        } else {
            NAME_TO_CLASS.put(str, cls);
        }
    }

    public static void unregisterMethod(String str) {
        NAME_TO_CLASS.remove(str);
    }

    public String getConsumerSecret() {
        return this.consumerSecret;
    }

    public abstract String getSignature(String str) throws OAuthException;

    public String getSignature(OAuthMessage oAuthMessage) throws OAuthException, URISyntaxException, IOException {
        return getSignature(getBaseString(oAuthMessage));
    }

    public String getTokenSecret() {
        return this.tokenSecret;
    }

    public void initialize(String str, OAuthAccessor oAuthAccessor) throws OAuthException {
        String string = oAuthAccessor.consumer.consumerSecret;
        if (str.endsWith(_ACCESSOR)) {
            Object property = oAuthAccessor.getProperty(OAuthConsumer.ACCESSOR_SECRET);
            if (property == null) {
                property = oAuthAccessor.consumer.getProperty(OAuthConsumer.ACCESSOR_SECRET);
            }
            if (property != null) {
                string = property.toString();
            }
        }
        if (string == null) {
            string = "";
        }
        setConsumerSecret(string);
    }

    public abstract boolean isValid(String str, String str2) throws OAuthException;

    public void setConsumerSecret(String str) {
        this.consumerSecret = str;
    }

    public void setTokenSecret(String str) {
        this.tokenSecret = str;
    }

    public void sign(OAuthMessage oAuthMessage) throws OAuthException, URISyntaxException, IOException {
        oAuthMessage.addParameter(new OAuth.Parameter(OAuth.OAUTH_SIGNATURE, getSignature(oAuthMessage)));
    }

    public void validate(OAuthMessage oAuthMessage) throws OAuthException, URISyntaxException, IOException {
        oAuthMessage.requireParameters(OAuth.OAUTH_SIGNATURE);
        String signature = oAuthMessage.getSignature();
        String baseString = getBaseString(oAuthMessage);
        if (isValid(signature, baseString)) {
            return;
        }
        OAuthProblemException oAuthProblemException = new OAuthProblemException(OAuth.Problems.SIGNATURE_INVALID);
        oAuthProblemException.setParameter(OAuth.OAUTH_SIGNATURE, signature);
        oAuthProblemException.setParameter("oauth_signature_base_string", baseString);
        oAuthProblemException.setParameter(OAuth.OAUTH_SIGNATURE_METHOD, oAuthMessage.getSignatureMethod());
        throw oAuthProblemException;
    }

    public static boolean equals(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2 == null;
        }
        if (bArr2 == null) {
            return false;
        }
        if (bArr2.length <= 0) {
            return bArr.length <= 0;
        }
        byte b2 = (byte) (bArr.length == bArr2.length ? 0 : 1);
        int length = 0;
        for (byte b3 : bArr) {
            b2 = (byte) (b2 | (b3 ^ bArr2[length]));
            length = (length + 1) % bArr2.length;
        }
        return b2 == 0;
    }
}
