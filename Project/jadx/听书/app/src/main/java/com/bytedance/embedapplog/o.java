package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.umeng.analytics.pro.an;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class o {
    private static String z = ":push";

    public static boolean z(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean z(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            return jSONObject.toString().equals(jSONObject2.toString());
        }
        return z((Object) jSONObject, (Object) jSONObject2);
    }

    public static String z(Context context) {
        e eVarLq;
        gz gzVarI = z.i();
        return (gzVarI == null || (eVarLq = gzVarI.lq()) == null) ? "" : eVarLq.z(context);
    }

    public static boolean z() {
        gz gzVarI = z.i();
        if (gzVarI != null) {
            return gzVarI.l();
        }
        return true;
    }

    public static boolean g() {
        e eVarLq;
        gz gzVarI = z.i();
        if (gzVarI == null || (eVarLq = gzVarI.lq()) == null) {
            return false;
        }
        return eVarLq.dl();
    }

    public static String dl() {
        e eVarLq;
        gz gzVarI = z.i();
        return (gzVarI == null || (eVarLq = gzVarI.lq()) == null) ? "" : eVarLq.g();
    }

    public static boolean a() {
        e eVarLq;
        gz gzVarI = z.i();
        if (gzVarI == null || (eVarLq = gzVarI.lq()) == null) {
            return false;
        }
        return eVarLq.a();
    }

    public static JSONObject z(JSONObject jSONObject) {
        e eVarLq;
        gz gzVarI = z.i();
        return (gzVarI == null || (eVarLq = gzVarI.lq()) == null) ? jSONObject : eVarLq.z(jSONObject);
    }

    public static String g(JSONObject jSONObject) {
        try {
            byte[] bytes = jSONObject.toString().getBytes("UTF-8");
            return bytes.length == 0 ? "" : TTEncryptUtils.clientPackedBase64(bytes, bytes.length);
        } catch (Exception e) {
            js.g("parseEncrypt#parse error: " + e.getMessage());
            return "";
        }
    }

    public static JSONObject z(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("aid", z.e());
            jSONObject2.putOpt(an.x, "android");
            jSONObject2.putOpt(an.y, Build.VERSION.RELEASE);
            jSONObject2.putOpt(an.F, Build.BRAND);
            jSONObject2.putOpt(an.ai, Build.MODEL);
            jSONObject2.putOpt("device_platform", "android");
            if (jSONObject != null) {
                jSONObject2.putOpt("app_version", jSONObject.optString("app_version"));
                if (TextUtils.isEmpty(str)) {
                    jSONObject2.putOpt("device_id", jSONObject.optString("device_id"));
                } else {
                    jSONObject2.putOpt("device_id", str);
                }
                jSONObject2.putOpt("device_model", jSONObject.optString("device_model"));
                jSONObject2.putOpt("os_api", Integer.valueOf(jSONObject.optInt("os_api")));
                jSONObject2.putOpt(an.s, jSONObject.optString(an.s));
                jSONObject2.putOpt("package", jSONObject.optString("package"));
                jSONObject2.putOpt("rom", jSONObject.optString("rom"));
                jSONObject2.putOpt("rom_version", fo.g());
                jSONObject2.putOpt("sdk_version", jSONObject.optString("sdk_version_name"));
                jSONObject2.putOpt("version_code", jSONObject.optString("version_code"));
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject2;
    }

    public static SharedPreferences g(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.g.g(context, bv.z(), 0);
    }

    public static boolean gc() {
        gz gzVarI = z.i();
        if (gzVarI == null) {
            return false;
        }
        return gzVarI.uf();
    }

    public static boolean m() {
        gz gzVarI = z.i();
        if (gzVarI == null) {
            return false;
        }
        return gzVarI.fv();
    }

    public static e e() {
        gz gzVarI = z.i();
        if (gzVarI == null) {
            return null;
        }
        return gzVarI.lq();
    }

    public static Looper gz() {
        e eVarLq;
        gz gzVarI = z.i();
        if (gzVarI == null || (eVarLq = gzVarI.lq()) == null) {
            return null;
        }
        return eVarLq.m();
    }

    public static Looper z(bv bvVar) {
        gz gzVarVm;
        e eVarLq;
        if (bvVar == null || (gzVarVm = bvVar.vm()) == null || (eVarLq = gzVarVm.lq()) == null) {
            return null;
        }
        return eVarLq.gc();
    }

    public static Looper g(bv bvVar) {
        gz gzVarVm;
        e eVarLq;
        if (bvVar == null || (gzVarVm = bvVar.vm()) == null || (eVarLq = gzVarVm.lq()) == null) {
            return null;
        }
        return eVarLq.m();
    }

    public static boolean dl(Context context) {
        String strZ = z(context);
        return strZ != null && strZ.endsWith(z);
    }

    public static JSONObject g(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e) {
            cb.g(e);
        }
        return jSONObject;
    }

    public static String z(String str, HashMap<String, String> map, String str2) {
        StringBuilder sb = new StringBuilder(str);
        for (String str3 : map.keySet()) {
            String strZ = z(str3, str2);
            String str4 = map.get(str3);
            String strZ2 = str4 != null ? z(str4, str2) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(strZ).append("=").append(strZ2);
        }
        return sb.toString();
    }

    private static String z(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void z(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                cb.z(th);
            }
        }
    }

    public static void z(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                cb.g(th);
            }
        }
    }

    public static String z(String str) {
        e eVarLq;
        gz gzVarI = z.i();
        return (gzVarI == null || (eVarLq = gzVarI.lq()) == null) ? "" : eVarLq.z(str);
    }

    public static JSONObject dl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        g(jSONObject2, jSONObject);
        try {
            String strZ = dh.z(jSONObject2.optJSONObject("oaid"));
            if (TextUtils.isEmpty(strZ)) {
                return jSONObject2;
            }
            jSONObject2.put("oaid", strZ);
            return jSONObject2;
        } catch (Exception e) {
            cb.g(e);
            return jSONObject2;
        }
    }
}
