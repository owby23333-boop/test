package com.yuewen;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.iflytek.aikit.media.param.MscKeys;
import com.xiaomi.ad.common.util.SignatureUtils;
import java.io.IOException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes17.dex */
public class yf4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20340a = "WebLogger";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20341b;
    public static final String c;

    static {
        String property = System.getProperty("line.separator");
        f20341b = property;
        c = property + property;
    }

    public yf4() {
        throw new UnsupportedOperationException();
    }

    public static String a(String str) {
        String[] strArrSplit = str.split(f20341b);
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            sb.append("- ");
            sb.append(str2);
            sb.append(SignatureUtils.DELIMITER);
        }
        return sb.toString();
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.startsWith("{")) {
                    str = new JSONObject(str).toString(3);
                } else if (str.startsWith("[")) {
                    str = new JSONArray(str).toString(3);
                }
            } catch (JSONException unused) {
            }
        }
        return str;
    }

    public static String[] c(nh1 nh1Var) {
        nh1Var.p().indexOf("?");
        StringBuilder sb = new StringBuilder();
        String str = c;
        sb.append(str);
        sb.append("Query: ");
        String str2 = "";
        sb.append("");
        sb.append(str);
        sb.append("Method: @");
        sb.append(nh1Var.m());
        sb.append(str);
        if (!f(null)) {
            str2 = "Headers:" + f20341b + a(null);
        }
        sb.append(str2);
        return sb.toString().split(f20341b);
    }

    public static String[] d(com.duokan.reader.common.webservices.b bVar) {
        String string;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(f20341b);
            sb.append("Status Code: ");
            sb.append(bVar.code());
            String str = c;
            sb.append(str);
            sb.append("Cost time: ");
            sb.append(bVar.e());
            sb.append(str);
            sb.append(bVar.getAllHeaders());
            string = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            string = "";
        }
        return string.split(f20341b);
    }

    public static Map<String, Object> e(String str) {
        ArrayMap arrayMap = new ArrayMap(0);
        if (TextUtils.isEmpty(str)) {
            return arrayMap;
        }
        for (String str2 : str.split(com.alipay.sdk.m.w.a.p)) {
            String[] strArrSplit = str2.split(MscKeys.KEY_VAL_SEP);
            if (strArrSplit.length == 1) {
                arrayMap.put(strArrSplit[0], "");
            } else if (strArrSplit.length == 2) {
                if (TextUtils.isEmpty(strArrSplit[1])) {
                    arrayMap.put(strArrSplit[0], "");
                } else {
                    try {
                        if (strArrSplit[1].startsWith("{")) {
                            arrayMap.put(strArrSplit[0], new JSONObject(strArrSplit[1]));
                        } else if (strArrSplit[1].startsWith("[")) {
                            arrayMap.put(strArrSplit[0], new JSONArray(strArrSplit[1]));
                        } else {
                            arrayMap.put(strArrSplit[0], strArrSplit[1]);
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return arrayMap;
    }

    public static boolean f(String str) {
        return TextUtils.isEmpty(str) || SignatureUtils.DELIMITER.equals(str) || "\t".equals(str) || TextUtils.isEmpty(str.trim());
    }

    public static /* synthetic */ void g(nh1 nh1Var) {
        StringBuilder sb = new StringBuilder();
        String str = f20341b;
        sb.append(str);
        sb.append("Body:");
        sb.append(str);
        sb.append(nh1Var.g());
        String string = sb.toString();
        Log.d(f20340a, "╔══════ Request ID:" + nh1Var.hashCode() + "════════════════════════════════════════════════════════════════════════");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("║ URL: ");
        sb2.append(nh1Var.p());
        Log.d(f20340a, sb2.toString());
        i(f20340a, c(nh1Var));
        i(f20340a, string.split(str));
        Log.d(f20340a, "╚═══════════════════════════════════════════════════════════════════════════════════════");
    }

    public static /* synthetic */ void h(String str, com.duokan.reader.common.webservices.b bVar) {
        try {
            StringBuilder sb = new StringBuilder();
            String str2 = f20341b;
            sb.append(str2);
            sb.append("Body:");
            sb.append(str2);
            sb.append(b(str));
            String string = sb.toString();
            Log.d(f20340a, "╔══════ Response ID:" + bVar.d().hashCode() + "═══════════════════════════════════════════════════════════════════════");
            i(f20340a, d(bVar));
            i(f20340a, string.split(str2));
            Log.d(f20340a, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        } catch (Exception unused) {
        }
    }

    public static void i(String str, String[] strArr) {
        for (String str2 : strArr) {
            int length = str2.length();
            int i = 0;
            while (i <= length / 110) {
                int i2 = i * 110;
                i++;
                Log.d(str, "║ " + str2.substring(i2, Math.min(i * 110, str2.length())));
            }
        }
    }

    public static void j(nh1 nh1Var) {
    }

    public static void k(com.duokan.reader.common.webservices.b bVar, String str) {
    }
}
