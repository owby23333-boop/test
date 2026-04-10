package net.oauth;

import androidx.webkit.ProxyConfig;
import com.alipay.sdk.m.p.a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes9.dex */
public class OAuth {
    public static final String ENCODING = "UTF-8";
    public static final String FORM_ENCODED = "application/x-www-form-urlencoded";
    public static final String HMAC_SHA1 = "HMAC-SHA1";
    public static final String OAUTH_CALLBACK = "oauth_callback";
    public static final String OAUTH_CALLBACK_CONFIRMED = "oauth_callback_confirmed";
    public static final String OAUTH_CONSUMER_KEY = "oauth_consumer_key";
    public static final String OAUTH_NONCE = "oauth_nonce";
    public static final String OAUTH_SIGNATURE = "oauth_signature";
    public static final String OAUTH_SIGNATURE_METHOD = "oauth_signature_method";
    public static final String OAUTH_TIMESTAMP = "oauth_timestamp";
    public static final String OAUTH_TOKEN = "oauth_token";
    public static final String OAUTH_TOKEN_SECRET = "oauth_token_secret";
    public static final String OAUTH_VERIFIER = "oauth_verifier";
    public static final String OAUTH_VERSION = "oauth_version";
    public static final String RSA_SHA1 = "RSA-SHA1";
    public static final String VERSION_1_0 = "1.0";
    private static String characterEncoding = "UTF-8";

    public static class Parameter implements Map.Entry<String, String> {
        private final String key;
        private String value;

        public Parameter(String str, String str2) {
            this.key = str;
            this.value = str2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Parameter parameter = (Parameter) obj;
            String str = this.key;
            if (str == null) {
                if (parameter.key != null) {
                    return false;
                }
            } else if (!str.equals(parameter.key)) {
                return false;
            }
            String str2 = this.value;
            if (str2 == null) {
                if (parameter.value != null) {
                    return false;
                }
            } else if (!str2.equals(parameter.value)) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            String str = this.key;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.value;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return String.valueOf(OAuth.percentEncode(getKey())) + a.h + OAuth.percentEncode(getValue());
        }

        @Override // java.util.Map.Entry
        public String getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public String getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public String setValue(String str) {
            try {
                return this.value;
            } finally {
                this.value = str;
            }
        }
    }

    public static class Problems {
        public static final String ADDITIONAL_AUTHORIZATION_REQUIRED = "additional_authorization_required";
        public static final String CONSUMER_KEY_REFUSED = "consumer_key_refused";
        public static final String CONSUMER_KEY_REJECTED = "consumer_key_rejected";
        public static final String CONSUMER_KEY_UNKNOWN = "consumer_key_unknown";
        public static final String NONCE_USED = "nonce_used";
        public static final String OAUTH_ACCEPTABLE_TIMESTAMPS = "oauth_acceptable_timestamps";
        public static final String OAUTH_ACCEPTABLE_VERSIONS = "oauth_acceptable_versions";
        public static final String OAUTH_PARAMETERS_ABSENT = "oauth_parameters_absent";
        public static final String OAUTH_PARAMETERS_REJECTED = "oauth_parameters_rejected";
        public static final String OAUTH_PROBLEM_ADVICE = "oauth_problem_advice";
        public static final String PARAMETER_ABSENT = "parameter_absent";
        public static final String PARAMETER_REJECTED = "parameter_rejected";
        public static final String PERMISSION_DENIED = "permission_denied";
        public static final String PERMISSION_UNKNOWN = "permission_unknown";
        public static final String SIGNATURE_INVALID = "signature_invalid";
        public static final String SIGNATURE_METHOD_REJECTED = "signature_method_rejected";
        public static final String TIMESTAMP_REFUSED = "timestamp_refused";
        public static final String TOKEN_EXPIRED = "token_expired";
        public static final String TOKEN_REJECTED = "token_rejected";
        public static final String TOKEN_REVOKED = "token_revoked";
        public static final String TOKEN_USED = "token_used";
        public static final Map<String, Integer> TO_HTTP_CODE = mapToHttpCode();
        public static final String USER_REFUSED = "user_refused";
        public static final String VERSION_REJECTED = "version_rejected";

        private static Map<String, Integer> mapToHttpCode() {
            Integer num = new Integer(400);
            Integer num2 = new Integer(401);
            Integer num3 = new Integer(503);
            HashMap map = new HashMap();
            map.put(VERSION_REJECTED, num);
            map.put(PARAMETER_ABSENT, num);
            map.put(PARAMETER_REJECTED, num);
            map.put(TIMESTAMP_REFUSED, num);
            map.put(SIGNATURE_METHOD_REJECTED, num);
            map.put(NONCE_USED, num2);
            map.put(TOKEN_USED, num2);
            map.put(TOKEN_EXPIRED, num2);
            map.put(TOKEN_REVOKED, num2);
            map.put(TOKEN_REJECTED, num2);
            map.put("token_not_authorized", num2);
            map.put(SIGNATURE_INVALID, num2);
            map.put(CONSUMER_KEY_UNKNOWN, num2);
            map.put(CONSUMER_KEY_REJECTED, num2);
            map.put(ADDITIONAL_AUTHORIZATION_REQUIRED, num2);
            map.put(PERMISSION_UNKNOWN, num2);
            map.put(PERMISSION_DENIED, num2);
            map.put(USER_REFUSED, num3);
            map.put(CONSUMER_KEY_REFUSED, num3);
            return Collections.unmodifiableMap(map);
        }
    }

    public static String addParameters(String str, String... strArr) throws IOException {
        return addParameters(str, newList(strArr));
    }

    public static String decodeCharacters(byte[] bArr) {
        String str = characterEncoding;
        if (str != null) {
            try {
                return new String(bArr, str);
            } catch (UnsupportedEncodingException e) {
                PrintStream printStream = System.err;
                StringBuilder sb = new StringBuilder();
                sb.append(e);
                printStream.println(sb.toString());
            }
        }
        return new String(bArr);
    }

    public static List<Parameter> decodeForm(String str) {
        String strDecodePercent;
        String strDecodePercent2;
        ArrayList arrayList = new ArrayList();
        if (!isEmpty(str)) {
            for (String str2 : str.split("\\&")) {
                int iIndexOf = str2.indexOf(61);
                if (iIndexOf < 0) {
                    strDecodePercent2 = decodePercent(str2);
                    strDecodePercent = null;
                } else {
                    String strDecodePercent3 = decodePercent(str2.substring(0, iIndexOf));
                    strDecodePercent = decodePercent(str2.substring(iIndexOf + 1));
                    strDecodePercent2 = strDecodePercent3;
                }
                arrayList.add(new Parameter(strDecodePercent2, strDecodePercent));
            }
        }
        return arrayList;
    }

    public static String decodePercent(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static byte[] encodeCharacters(String str) {
        String str2 = characterEncoding;
        if (str2 != null) {
            try {
                return str.getBytes(str2);
            } catch (UnsupportedEncodingException e) {
                PrintStream printStream = System.err;
                StringBuilder sb = new StringBuilder();
                sb.append(e);
                printStream.println(sb.toString());
            }
        }
        return str.getBytes();
    }

    public static String formEncode(Iterable<? extends Map.Entry> iterable) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        formEncode(iterable, byteArrayOutputStream);
        return decodeCharacters(byteArrayOutputStream.toByteArray());
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isFormEncoded(String str) {
        if (str == null) {
            return false;
        }
        int iIndexOf = str.indexOf(";");
        if (iIndexOf >= 0) {
            str = str.substring(0, iIndexOf);
        }
        return "application/x-www-form-urlencoded".equalsIgnoreCase(str.trim());
    }

    public static List<Parameter> newList(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length / 2);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i2 >= strArr.length) {
                return arrayList;
            }
            arrayList.add(new Parameter(strArr[i], strArr[i2]));
            i += 2;
        }
    }

    public static Map<String, String> newMap(Iterable<? extends Map.Entry> iterable) {
        HashMap map = new HashMap();
        if (iterable != null) {
            for (Map.Entry entry : iterable) {
                String string = toString(entry.getKey());
                if (!map.containsKey(string)) {
                    map.put(string, toString(entry.getValue()));
                }
            }
        }
        return map;
    }

    public static String percentEncode(Iterable iterable) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : iterable) {
            if (sb.length() > 0) {
                sb.append(com.alipay.sdk.m.w.a.p);
            }
            sb.append(percentEncode(toString(obj)));
        }
        return sb.toString();
    }

    public static void setCharacterEncoding(String str) {
        characterEncoding = str;
    }

    private static final String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static String addParameters(String str, Iterable<? extends Map.Entry<String, String>> iterable) throws IOException {
        String strFormEncode = formEncode(iterable);
        if (strFormEncode == null || strFormEncode.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str));
        sb.append(str.indexOf("?") < 0 ? '?' : Typography.amp);
        sb.append(strFormEncode);
        return sb.toString();
    }

    public static void formEncode(Iterable<? extends Map.Entry> iterable, OutputStream outputStream) throws IOException {
        if (iterable != null) {
            boolean z = true;
            for (Map.Entry entry : iterable) {
                if (z) {
                    z = false;
                } else {
                    outputStream.write(38);
                }
                outputStream.write(encodeCharacters(percentEncode(toString(entry.getKey()))));
                outputStream.write(61);
                outputStream.write(encodeCharacters(percentEncode(toString(entry.getValue()))));
            }
        }
    }

    public static String percentEncode(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace(ProxyConfig.MATCH_ALL_SCHEMES, "%2A").replace("%7E", Constants.WAVE_SEPARATOR);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
