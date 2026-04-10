package com.bytedance.embedapplog;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.iflytek.aikit.media.param.MscKeys;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class pl {
    private static String e = ":push";

    public static boolean bf(Context context) {
        String strE = e(context);
        return strE != null && strE.endsWith(e);
    }

    public static String e(boolean z) {
        return z ? "yes" : "no";
    }

    public static boolean e(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static JSONObject bf(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e2) {
            tx.bf(e2);
        }
        return jSONObject;
    }

    public static boolean e(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            return jSONObject.toString().equals(jSONObject2.toString());
        }
        return e((Object) jSONObject, (Object) jSONObject2);
    }

    public static String e(Context context) {
        ISensitiveInfoProvider sensitiveInfoProvider;
        InitConfig initConfigXu = e.xu();
        return (initConfigXu == null || (sensitiveInfoProvider = initConfigXu.getSensitiveInfoProvider()) == null) ? "" : sensitiveInfoProvider.getCurrentProcessName(context);
    }

    public static String e() {
        ISensitiveInfoProvider sensitiveInfoProvider;
        InitConfig initConfigXu = e.xu();
        return (initConfigXu == null || (sensitiveInfoProvider = initConfigXu.getSensitiveInfoProvider()) == null) ? "" : sensitiveInfoProvider.getSdkBuildModel();
    }

    public static String e(String str, HashMap<String, String> map, String str2) {
        StringBuilder sb = new StringBuilder(str);
        for (String str3 : map.keySet()) {
            String strE = e(str3, str2);
            String str4 = map.get(str3);
            String strE2 = str4 != null ? e(str4, str2) : "";
            if (sb.length() > 0) {
                sb.append(com.alipay.sdk.m.w.a.p);
            }
            sb.append(strE);
            sb.append(MscKeys.KEY_VAL_SEP);
            sb.append(strE2);
        }
        return sb.toString();
    }

    private static String e(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                tx.e(th);
            }
        }
    }

    public static void e(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                tx.e(th);
            }
        }
    }

    public static void e(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                tx.bf(th);
            }
        }
    }

    public static String e(String str) {
        String line = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        BufferedReader bufferedReader = null;
        try {
            Process processExec = Runtime.getRuntime().exec("getprop " + str);
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
            try {
                line = bufferedReader2.readLine();
                processExec.destroy();
                e(bufferedReader2);
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                try {
                    tx.e(th);
                } finally {
                    e(bufferedReader);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return line;
    }

    public static JSONObject e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        bf(jSONObject2, jSONObject);
        try {
            String strE = sq.e(jSONObject2.optJSONObject("oaid"));
            if (TextUtils.isEmpty(strE)) {
                return jSONObject2;
            }
            jSONObject2.put("oaid", strE);
            return jSONObject2;
        } catch (Exception e2) {
            tx.bf(e2);
            return jSONObject2;
        }
    }
}
