package net.oauth;

import com.xiaomi.ad.common.util.SignatureUtils;
import java.util.HashMap;
import java.util.Map;
import net.oauth.OAuth;

/* JADX INFO: loaded from: classes9.dex */
public class OAuthProblemException extends OAuthException {
    public static final String HTTP_LOCATION = "Location";
    public static final String HTTP_REQUEST = "HTTP request";
    public static final String HTTP_RESPONSE = "HTTP response";
    public static final String HTTP_STATUS_CODE = "HTTP status";
    public static final String OAUTH_PROBLEM = "oauth_problem";
    public static final String SIGNATURE_BASE_STRING = "oauth_signature base string";
    public static final String URL = "URL";
    private static final long serialVersionUID = 1;
    private final Map<String, Object> parameters;

    public OAuthProblemException() {
        this.parameters = new HashMap();
    }

    public int getHttpStatusCode() {
        Object obj = getParameters().get("HTTP status");
        if (obj == null) {
            return 200;
        }
        return obj instanceof Number ? ((Number) obj).intValue() : Integer.parseInt(obj.toString());
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (message != null) {
            return message;
        }
        String problem = getProblem();
        if (problem != null) {
            return problem;
        }
        Object obj = getParameters().get("HTTP response");
        if (obj != null) {
            String string = obj.toString();
            int iIndexOf = string.indexOf(SignatureUtils.DELIMITER);
            if (iIndexOf < 0) {
                iIndexOf = string.indexOf("\r");
            }
            if (iIndexOf >= 0) {
                string = string.substring(0, iIndexOf);
            }
            String strTrim = string.trim();
            if (strTrim.length() > 0) {
                return strTrim;
            }
        }
        Integer numValueOf = Integer.valueOf(getHttpStatusCode());
        if (numValueOf == null) {
            return null;
        }
        return "HTTP status " + numValueOf;
    }

    public Map<String, Object> getParameters() {
        return this.parameters;
    }

    public String getProblem() {
        return (String) getParameters().get(OAUTH_PROBLEM);
    }

    public void setParameter(String str, Object obj) {
        getParameters().put(str, obj);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        try {
            String property = System.getProperty("line.separator", SignatureUtils.DELIMITER);
            Map<String, Object> parameters = getParameters();
            String[] strArr = {OAuth.Problems.OAUTH_PROBLEM_ADVICE, URL, SIGNATURE_BASE_STRING};
            for (int i = 0; i < 3; i++) {
                String str = strArr[i];
                Object obj = parameters.get(str);
                if (obj != null) {
                    sb.append(String.valueOf(property) + str + ": " + obj);
                }
            }
            Object obj2 = parameters.get("HTTP request");
            if (obj2 != null) {
                sb.append(String.valueOf(property) + ">>>>>>>> HTTP request:" + property + obj2);
            }
            Object obj3 = parameters.get("HTTP response");
            if (obj3 != null) {
                sb.append(String.valueOf(property) + "<<<<<<<< HTTP response:" + property + obj3);
            } else {
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    String key = entry.getKey();
                    if (!OAuth.Problems.OAUTH_PROBLEM_ADVICE.equals(key) && !URL.equals(key) && !SIGNATURE_BASE_STRING.equals(key) && !"HTTP request".equals(key) && !"HTTP response".equals(key)) {
                        sb.append(String.valueOf(property) + key + ": " + entry.getValue());
                    }
                }
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public OAuthProblemException(String str) {
        super(str);
        HashMap map = new HashMap();
        this.parameters = map;
        if (str != null) {
            map.put(OAUTH_PROBLEM, str);
        }
    }
}
