package com.yuewen;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.lang.reflect.Type;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class sb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Gson f17417a = new GsonBuilder().serializeSpecialFloatingPointValues().setLenient().create();

    public static <T> T a(JsonElement jsonElement, Class<T> cls) {
        return (T) f17417a.fromJson(jsonElement, (Class) cls);
    }

    public static <T> T b(JsonElement jsonElement, Type type) {
        return (T) f17417a.fromJson(jsonElement, type);
    }

    public static <T> T c(String str, Class<T> cls) {
        return (T) f17417a.fromJson(str, (Class) cls);
    }

    public static <T> T d(String str, Type type) {
        return (T) f17417a.fromJson(str, type);
    }

    public static Gson e() {
        return f17417a;
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JsonElement jsonElement = new JsonParser().parse(str);
            return jsonElement != null && jsonElement.isJsonObject();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String g(Object obj) {
        return f17417a.toJson(obj);
    }

    public static String h(Object obj, Type type) {
        return f17417a.toJson(obj, type);
    }

    public static String i(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : map.keySet()) {
                jSONObject.put(str, map.get(str));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
