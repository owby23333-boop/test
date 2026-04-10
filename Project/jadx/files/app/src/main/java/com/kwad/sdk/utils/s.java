package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class s {
    public static <T> JSONArray E(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            for (Object json : list) {
                if (json != null) {
                    if (!(json instanceof JSONObject)) {
                        if (json instanceof com.kwad.sdk.core.b) {
                            json = ((com.kwad.sdk.core.b) json).toJson();
                        } else if (!(json instanceof String)) {
                            throw new IllegalArgumentException("<T> now suppprt type: " + json.getClass().getName());
                        }
                    }
                    jSONArray.put(json);
                }
            }
        }
        return jSONArray;
    }

    public static <T extends com.kwad.sdk.core.b> List<T> a(String str, @NonNull com.kwad.sdk.core.c<T> cVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                com.kwad.sdk.core.b bVarUf = cVar.uf();
                bVarUf.parseJson(jSONObject);
                arrayList.add(bVarUf);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        return arrayList;
    }

    public static void a(JSONObject jSONObject, String str, com.kwad.sdk.core.b bVar) {
        if (jSONObject == null || bVar == null) {
            return;
        }
        try {
            jSONObject.put(str, bVar.toJson());
        } catch (JSONException unused) {
        }
    }

    public static <T> List<T> ei(String str) {
        return t.ei(str);
    }

    public static <T> List<T> f(JSONArray jSONArray) {
        return t.f(jSONArray);
    }

    public static void merge(JSONObject jSONObject, JSONObject jSONObject2) {
        t.merge(jSONObject, jSONObject2);
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        return t.parseJSON2MapString(str);
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        return t.parseMap2JSON(map);
    }

    public static void putValue(JSONArray jSONArray, JSONObject jSONObject) {
        jSONArray.put(jSONObject);
    }

    public static void putValue(JSONObject jSONObject, String str, byte b) {
        if (jSONObject == null) {
            return;
        }
        t.putValue(jSONObject, str, b);
    }

    public static void putValue(JSONObject jSONObject, String str, double d2) {
        if (jSONObject == null) {
            return;
        }
        t.putValue(jSONObject, str, d2);
    }

    public static void putValue(JSONObject jSONObject, String str, float f2) {
        if (jSONObject == null) {
            return;
        }
        t.putValue(jSONObject, str, f2);
    }

    public static void putValue(JSONObject jSONObject, String str, int i2) {
        if (jSONObject == null) {
            return;
        }
        t.putValue(jSONObject, str, i2);
    }

    public static void putValue(JSONObject jSONObject, String str, long j2) {
        if (jSONObject == null) {
            return;
        }
        t.putValue(jSONObject, str, j2);
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return;
        }
        t.putValue(jSONObject, str, str2);
    }

    public static void putValue(JSONObject jSONObject, String str, List<?> list) {
        if (jSONObject == null || list == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        boolean z2 = false;
        for (Object obj : list) {
            if (obj instanceof com.kwad.sdk.core.b) {
                putValue(jSONArray, ((com.kwad.sdk.core.b) obj).toJson());
            } else if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof JSONObject) || (obj instanceof JSONArray) || (obj instanceof Double) || (obj instanceof Boolean)) {
                jSONArray.put(obj);
            } else if (!(obj instanceof Float)) {
                break;
            } else {
                try {
                    jSONArray.put(((Float) obj).floatValue());
                } catch (JSONException unused) {
                }
            }
            z2 = true;
        }
        if (z2) {
            putValue(jSONObject, str, jSONArray);
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONObject == null) {
            return;
        }
        t.putValue(jSONObject, str, jSONArray);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        t.putValue(jSONObject, str, jSONObject2);
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z2) {
        if (jSONObject == null) {
            return;
        }
        t.putValue(jSONObject, str, z2);
    }

    public static JSONArray toJsonArray(@NonNull List<String> list) {
        return t.toJsonArray(list);
    }
}
