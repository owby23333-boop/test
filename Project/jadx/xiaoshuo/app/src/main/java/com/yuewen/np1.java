package com.yuewen;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class np1 {
    public static JSONArray a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONObject) {
                    jSONArray2.put(b((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    jSONArray2.put(a((JSONArray) obj));
                } else {
                    jSONArray2.put(obj);
                }
            } catch (JSONException unused) {
            }
        }
        return jSONArray2;
    }

    public static JSONObject b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArrayNames = jSONObject.names();
            if (jSONArrayNames != null) {
                for (int i = 0; i < jSONArrayNames.length(); i++) {
                    String string = jSONArrayNames.getString(i);
                    Object obj = jSONObject.get(string);
                    if (obj instanceof JSONObject) {
                        jSONObject2.put(string, b((JSONObject) obj));
                    } else if (obj instanceof JSONArray) {
                        jSONObject2.put(string, a((JSONArray) obj));
                    } else {
                        jSONObject2.put(string, obj);
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public static JSONArray c(JSONObject jSONObject, String str) throws JSONException {
        Object obj = jSONObject.get(str);
        return obj != JSONObject.NULL ? (JSONArray) obj : new JSONArray();
    }

    public static boolean d(JSONObject jSONObject, String str) {
        return e(jSONObject, str, false);
    }

    public static boolean e(JSONObject jSONObject, String str, boolean z) {
        try {
            Object obj = jSONObject.get(str);
            return obj != JSONObject.NULL ? ((Boolean) obj).booleanValue() : z;
        } catch (Exception unused) {
            return z;
        }
    }

    public static JSONObject f(File file, JSONObject jSONObject) {
        FileInputStream fileInputStreamG;
        if (file == null || !file.exists() || (fileInputStreamG = q41.G(file)) == null) {
            return jSONObject;
        }
        JSONObject jSONObjectH = h(fileInputStreamG, jSONObject);
        yu3.b(fileInputStreamG);
        return jSONObjectH;
    }

    public static JSONObject g(InputStream inputStream, String str, JSONObject jSONObject) {
        try {
            return new JSONObject(new String(yu3.d(inputStream), str));
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public static JSONObject h(InputStream inputStream, JSONObject jSONObject) {
        return g(inputStream, "UTF-8", jSONObject);
    }

    public static JSONArray i(JSONObject jSONObject, String str, JSONArray jSONArray) {
        try {
            return c(jSONObject, str);
        } catch (JSONException unused) {
            return jSONArray;
        }
    }

    public static String j(JSONObject jSONObject, String str) {
        return k(jSONObject, str, "");
    }

    public static String k(JSONObject jSONObject, String str, String str2) {
        try {
            Object obj = jSONObject.get(str);
            return obj != JSONObject.NULL ? String.valueOf(obj) : str2;
        } catch (Exception unused) {
            return str2;
        }
    }

    public static String[] l(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return new String[0];
        }
        String[] strArr = new String[jSONArrayOptJSONArray.length()];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            strArr[i] = jSONArrayOptJSONArray.optString(i, "");
        }
        return strArr;
    }

    public static JSONArray m(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        if (strArr != null) {
            for (String str : strArr) {
                jSONArray.put(str);
            }
        }
        return jSONArray;
    }
}
