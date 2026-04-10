package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import java.security.SecureRandom;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m0 {
    private static String a = null;
    private static String b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f1773c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f1774d = "ToolUtils";

    public static String a() {
        String str;
        synchronized (m0.class) {
            if (!TextUtils.isEmpty(a) || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() == null) {
                str = a;
            } else {
                try {
                    a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d().getPackageName();
                } catch (Throwable th) {
                    Logger.e(f1774d, "ToolUtils getPackageName throws exception :" + th);
                }
                str = a;
            }
        }
        return str;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return a.a(str.substring(17), b(str.substring(1, 17)));
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                try {
                    String strA = a.a();
                    String str = 2 + strA + a.b(jSONObject.toString(), a.a(strA));
                    if (TextUtils.isEmpty(str)) {
                        jSONObject2.put("message", jSONObject.toString());
                        jSONObject2.put("cypher", 0);
                    } else {
                        jSONObject2.put("message", str);
                        jSONObject2.put("cypher", 2);
                    }
                } catch (Throwable unused) {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused2) {
            }
        }
        return jSONObject2;
    }

    public static String b() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return o.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String b(String str) {
        String strA = a.a(str);
        if (str != null) {
            return strA;
        }
        String strA2 = b.a();
        return strA2.concat(strA2).substring(8, 24);
    }

    public static String c() {
        String strConcat;
        try {
            strConcat = System.getProperty("http.agent");
        } catch (Exception unused) {
            strConcat = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (strConcat == null) {
            return "";
        }
        int iLastIndexOf = strConcat.lastIndexOf(";");
        if (iLastIndexOf != -1 && strConcat.length() > iLastIndexOf) {
            int i2 = iLastIndexOf + 1;
            String strSubstring = strConcat.substring(0, i2);
            strConcat = strSubstring.concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(strConcat.substring(i2));
        }
        int length = strConcat.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = strConcat.charAt(i3);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String d() {
        String str;
        synchronized (m0.class) {
            if (!TextUtils.isEmpty(b) || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() == null) {
                str = b;
            } else {
                try {
                    PackageInfo packageInfo = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d().getPackageManager().getPackageInfo(a(), 0);
                    b = String.valueOf(packageInfo.versionCode);
                    f1773c = packageInfo.versionName;
                } catch (Throwable th) {
                    Logger.e(f1774d, "ToolUtils getVersionCode throws exception :" + th);
                }
                str = b;
            }
        }
        return str;
    }

    public static String e() {
        String str;
        synchronized (m0.class) {
            if (!TextUtils.isEmpty(f1773c) || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() == null) {
                str = f1773c;
            } else {
                try {
                    PackageInfo packageInfo = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d().getPackageManager().getPackageInfo(a(), 0);
                    b = String.valueOf(packageInfo.versionCode);
                    f1773c = packageInfo.versionName;
                } catch (Throwable th) {
                    Logger.e(f1774d, "ToolUtils getVersionName throws exception :" + th);
                }
                str = f1773c;
            }
        }
        return str;
    }
}
