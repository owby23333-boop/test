package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class t {
    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Throwable unused) {
        }
    }

    public static <T> List<T> ei(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            return f(new JSONArray(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
            return arrayList;
        }
    }

    public static <T> List<T> f(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                Object obj = jSONArray.get(i2);
                if (obj != null) {
                    arrayList.add(obj);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
        }
        return arrayList;
    }

    public static void merge(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String string = itKeys.next().toString();
            Object objOpt = jSONObject2.opt(string);
            if (objOpt != null) {
                try {
                    jSONObject.put(string, objOpt);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString = jSONObject.optString(next, "");
                if (TextUtils.isEmpty(strOptString) || TextUtils.equals("null", strOptString)) {
                    strOptString = "";
                }
                map.put(next, strOptString);
            }
        } catch (JSONException unused) {
        }
        return map;
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static void putValue(JSONObject jSONObject, String str, byte b) {
        try {
            jSONObject.put(str, (int) b);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, double d2) {
        try {
            jSONObject.put(str, d2);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, float f2) {
        try {
            jSONObject.put(str, f2);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, int i2) {
        try {
            jSONObject.put(str, i2);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, long j2) {
        try {
            jSONObject.put(str, j2);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0 || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, jSONArray);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject2 == null || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, jSONObject2);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z2) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, z2);
        } catch (Throwable unused) {
        }
    }

    public static JSONArray toJsonArray(@NonNull List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }
}
