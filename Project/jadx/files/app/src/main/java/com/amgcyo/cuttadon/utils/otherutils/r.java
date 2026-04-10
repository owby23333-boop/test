package com.amgcyo.cuttadon.utils.otherutils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: compiled from: GsonConvert.java */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: compiled from: GsonConvert.java */
    private static class a {
        private static Gson a = new Gson();
    }

    public static Gson a() {
        return a.a;
    }

    public static <T> List<T> b(String str, Class cls) {
        return (List) new Gson().fromJson(str, new h0(cls));
    }

    public static <T> List<T> a(Object obj, Class cls) {
        if (obj == null) {
            return null;
        }
        h0 h0Var = new h0(cls);
        JsonElement jsonTree = a().toJsonTree(obj);
        if (jsonTree instanceof JsonArray) {
            return (List) a().fromJson(jsonTree.getAsJsonArray(), h0Var);
        }
        if (!(jsonTree instanceof JsonObject)) {
            return null;
        }
        return (List) a().fromJson(jsonTree.getAsJsonObject(), h0Var);
    }

    public static <T> T a(String str, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        return (T) a().fromJson(str, (Class) cls);
    }

    public static <T> T a(String str, Type type) {
        JsonElement jsonElement = new JsonParser().parse(str);
        if (jsonElement.isJsonObject()) {
            return (T) a().fromJson(jsonElement.getAsJsonObject(), type);
        }
        if (jsonElement.isJsonArray()) {
            return (T) a().fromJson(jsonElement.getAsJsonArray(), type);
        }
        return null;
    }

    public static String a(Object obj) {
        return a().toJson(obj);
    }
}
