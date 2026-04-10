package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.efs.sdk.base.Constants;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class r {
    private static volatile boolean fo;
    private static volatile int gz;
    private static volatile boolean m;
    public static JSONObject z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f298a = {"GET", "POST"};
    private static final String[] gc = {"aid", "app_version", "tt_data"};
    static final String[] g = {"aid", "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", "iid", "device_platform"};
    public static final String[] dl = {"tt_data", "device_platform"};
    private static Object e = new Object();

    public static boolean z(int i) {
        return i >= 500 && i < 600;
    }

    private static String z(String str) {
        if (TextUtils.isEmpty(str) || !z.gz()) {
            return str;
        }
        Uri uri = Uri.parse(str);
        String query = uri.getQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str2 : gc) {
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(new Pair(str2, queryParameter));
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (Pair pair : arrayList) {
            builderBuildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        builderBuildUpon.appendQueryParameter("tt_info", new String(Base64.encode(s.z(query), 8)));
        return builderBuildUpon.build().toString();
    }

    public static String z(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri uri = Uri.parse(str);
        HashMap map = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                map.put(str2, queryParameter);
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (String str3 : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str3, (String) map.get(str3));
        }
        return builderBuildUpon.build().toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:35|(1:37)(1:38)|106|39|(10:40|(1:42)(1:119)|68|108|71|(2:93|73)|(2:110|62)|76|(1:78)|79)|43|104|44|(1:46)) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011a, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0175 A[EXC_TOP_SPLITTER, PHI: r0 r10
  0x0175: PHI (r0v3 java.io.BufferedReader) = (r0v2 java.io.BufferedReader), (r0v12 java.io.BufferedReader) binds: [B:74:0x01a9, B:61:0x0173] A[DONT_GENERATE, DONT_INLINE]
  0x0175: PHI (r10v3 java.lang.String) = (r10v2 java.lang.String), (r10v12 java.lang.String) binds: [B:74:0x01a9, B:61:0x0173] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String z(int r8, java.lang.String r9, java.util.HashMap<java.lang.String, java.lang.String> r10, byte[] r11) {
        /*
            Method dump skipped, instruction units count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.r.z(int, java.lang.String, java.util.HashMap, byte[]):java.lang.String");
    }

    public static JSONObject z(String str, JSONObject jSONObject) {
        HashMap map = new HashMap(2);
        if (z.gz()) {
            map.put(HttpHeaders.CONTENT_TYPE, "application/octet-stream;tt-data=a");
        } else {
            map.put(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
        }
        String strZ = z(1, z(str), map, s.z(jSONObject.toString()));
        if (strZ != null) {
            try {
                return new JSONObject(strZ);
            } catch (JSONException e2) {
                com.bytedance.sdk.component.utils.wp.z(e2);
            }
        }
        return null;
    }

    public static String z(Context context, String str, byte[] bArr, String str2, boolean z2, boolean z3) {
        byte[] bArrZ;
        try {
            try {
                HashMap map = new HashMap();
                if (z2) {
                    try {
                        bArrZ = z(bArr);
                        map.put(HttpHeaders.CONTENT_ENCODING, Constants.CP_GZIP);
                    } catch (Exception unused) {
                        return null;
                    }
                } else {
                    bArrZ = z(context, bArr);
                    map.put("log-encode-type", Constants.CP_GZIP);
                    str = str + "&tt_data=a";
                    if (z3) {
                        str = str + "&config_retry=b";
                    }
                    map.remove(HttpHeaders.CONTENT_ENCODING);
                    map.put(HttpHeaders.CONTENT_TYPE, "application/octet-stream;tt-data=a");
                }
                if (!TextUtils.isEmpty(str2)) {
                    map.put(HttpHeaders.CONTENT_TYPE, str2);
                }
                return z(1, str, map, bArrZ);
            } catch (Exception e2) {
                js.dl("__kite", e2.getMessage());
                return "";
            }
        } catch (RuntimeException e3) {
            js.dl("__kite", e3.getMessage());
            return "";
        }
    }

    public static byte[] z(byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(8192);
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                gZIPOutputStream2.close();
            }
            throw th;
        }
    }

    private static byte[] z(Context context, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (context != null) {
                z(context);
                if (gz >= 3) {
                    return null;
                }
                byte[] bArrA = TTEncryptUtils.a(byteArray, byteArray.length);
                g(context);
                return bArrA;
            }
            return TTEncryptUtils.a(byteArray, byteArray.length);
        } catch (Throwable th) {
            try {
                js.dl("__kite", "gzip ".concat(String.valueOf(th)));
                return null;
            } finally {
                gZIPOutputStream.close();
            }
        }
    }

    private static void z(Context context) {
        if (m || context == null) {
            return;
        }
        synchronized (e) {
            try {
                SharedPreferences sharedPreferencesG = o.g(context);
                gz = sharedPreferencesG.getInt("app_log_encrypt_faild_count", 0);
                SharedPreferences.Editor editorEdit = sharedPreferencesG.edit();
                editorEdit.putInt("app_log_encrypt_faild_count", gz + 1);
                editorEdit.apply();
                m = true;
            } catch (Throwable unused) {
            }
        }
    }

    private static void g(Context context) {
        if (fo || context == null) {
            return;
        }
        synchronized (e) {
            try {
                SharedPreferences.Editor editorEdit = o.g(context).edit();
                if (gz > 2) {
                    gz -= 2;
                } else {
                    gz = 0;
                }
                editorEdit.putInt("app_log_encrypt_faild_count", gz);
                editorEdit.apply();
                fo = true;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int z(java.lang.String[] r8, byte[] r9, com.bytedance.embedapplog.bv r10) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.r.z(java.lang.String[], byte[], com.bytedance.embedapplog.bv):int");
    }

    public static JSONObject g(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        HashMap map = new HashMap(2);
        if (z.gz()) {
            map.put(HttpHeaders.CONTENT_TYPE, "application/octet-stream;tt-data=a");
        } else {
            map.put(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
        }
        String strZ = z(1, str, map, s.z(jSONObject.toString()));
        if (strZ != null) {
            try {
                jSONObject2 = new JSONObject(strZ);
            } catch (JSONException e2) {
                com.bytedance.sdk.component.utils.wp.z(e2);
                jSONObject2 = null;
            }
        } else {
            jSONObject2 = null;
        }
        if (jSONObject2 != null && "ss_app_log".equals(jSONObject2.optString("magic_tag", ""))) {
            return jSONObject2.optJSONObject("config");
        }
        return null;
    }

    public static JSONObject dl(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String strZ = z(1, str, null, s.z(jSONObject.toString()));
        if (strZ != null) {
            try {
                jSONObject2 = new JSONObject(strZ);
            } catch (JSONException e2) {
                com.bytedance.sdk.component.utils.wp.z(e2);
                jSONObject2 = null;
            }
        } else {
            jSONObject2 = null;
        }
        if (jSONObject2 != null && "success".equals(jSONObject2.optString("message", ""))) {
            return jSONObject2.optJSONObject("data");
        }
        return null;
    }
}
