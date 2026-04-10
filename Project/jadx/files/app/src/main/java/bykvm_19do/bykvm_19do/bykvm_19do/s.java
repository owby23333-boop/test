package bykvm_19do.bykvm_19do.bykvm_19do;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class s {
    public static JSONObject b;
    private static final String[] a = {"GET", "POST"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f741c = {"aid", "app_version", "tt_data"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String[] f742d = {"aid", "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", "iid", "device_platform"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f743e = {"tt_data", "device_platform"};

    /* JADX WARN: Removed duplicated region for block: B:69:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.String[] r9, byte[] r10, bykvm_19do.bykvm_19do.bykvm_19do.j2 r11) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.s.a(java.lang.String[], byte[], bykvm_19do.bykvm_19do.bykvm_19do.j2):int");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:48|(1:50)(2:51|52)|117|53|(9:54|(1:56)(1:141)|123|82|(2:106|84)|(2:115|88)|91|(1:93)|94)|57|112|58|(2:121|70)|(0)|91|(0)|94) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0176, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01cd A[EXC_TOP_SPLITTER, PHI: r7 r8
  0x01cd: PHI (r7v3 java.io.BufferedReader) = (r7v2 java.io.BufferedReader), (r7v13 java.io.BufferedReader) binds: [B:87:0x01cb, B:73:0x01b0] A[DONT_GENERATE, DONT_INLINE]
  0x01cd: PHI (r8v4 java.lang.String) = (r8v2 java.lang.String), (r8v12 java.lang.String) binds: [B:87:0x01cb, B:73:0x01b0] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(int r6, java.lang.String r7, java.util.HashMap<java.lang.String, java.lang.String> r8, byte[] r9) {
        /*
            Method dump skipped, instruction units count: 507
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.s.a(int, java.lang.String, java.util.HashMap, byte[]):java.lang.String");
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str) || !a.h()) {
            return str;
        }
        Uri uri = Uri.parse(str);
        String query = uri.getQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str2 : f741c) {
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
        builderBuildUpon.appendQueryParameter("tt_info", new String(Base64.encode(a.a(query), 8)));
        return builderBuildUpon.build().toString();
    }

    public static String a(String str, String[] strArr) {
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

    public static JSONObject a(String str, JSONObject jSONObject) {
        HashMap map = new HashMap(2);
        map.put("Content-Type", a.h() ? "application/octet-stream;tt-data=a" : "application/json; charset=utf-8");
        String strA = a(1, a(str), map, a.a(jSONObject.toString()));
        if (strA != null) {
            try {
                return new JSONObject(strA);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    protected static void a(StringBuilder sb, String str, String str2) {
        if (sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(sb.toString().indexOf(63) < 0 ? "?" : DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(str);
        sb.append("=");
        sb.append(Uri.encode(str2));
    }

    public static boolean b(String str, JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder(str);
        float rawOffset = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;
        if (rawOffset < -12.0f) {
            rawOffset = -12.0f;
        }
        if (rawOffset > 12.0f) {
            rawOffset = 12.0f;
        }
        a(sb, "timezone", rawOffset + "");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sim_serial_number");
        if (jSONArrayOptJSONArray != null) {
            try {
                String strOptString = ((JSONObject) jSONArrayOptJSONArray.get(0)).optString("sim_serial_number");
                for (int i2 = 1; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    strOptString = strOptString + "," + ((JSONObject) jSONArrayOptJSONArray.get(i2)).optString("sim_serial_number");
                }
                a(sb, "sim_serial_number", strOptString);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        String strA = a(sb.toString());
        JSONObject jSONObject2 = null;
        String strA2 = a(0, strA, null, null);
        if (strA2 != null) {
            try {
                jSONObject2 = new JSONObject(strA2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return jSONObject2 != null && "success".equals(jSONObject2.optString("message", ""));
    }

    public static JSONObject c(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String strA = a(1, str, null, a.a(jSONObject.toString()));
        if (strA != null) {
            try {
                jSONObject2 = new JSONObject(strA);
            } catch (JSONException e2) {
                e2.printStackTrace();
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

    public static JSONObject d(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String strA = a(1, str, null, a.a(jSONObject.toString()));
        if (strA != null) {
            try {
                jSONObject2 = new JSONObject(strA);
            } catch (JSONException e2) {
                e2.printStackTrace();
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
