package cn.bmob.v3.util;

import com.google.gson.JsonElement;

/* JADX INFO: loaded from: classes.dex */
public final class JsonUtil {
    public static boolean getBoolean(JsonElement jsonElement, String str) {
        return jsonElement.getAsJsonObject().get(str).getAsBoolean();
    }

    public static String getString(JsonElement jsonElement, String str) {
        return jsonElement.getAsJsonObject().get(str).getAsString();
    }
}
