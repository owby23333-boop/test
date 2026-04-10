package com.amgcyo.cuttadon.utils.comic;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: JsonToMap.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static JsonObject a(String str) {
        return new JsonParser().parse(str).getAsJsonObject();
    }

    public static Map<String, Object> b(String str) {
        return a(a(str));
    }

    public static Map<String, Object> a(JsonObject jsonObject) {
        HashMap map = new HashMap();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            if (value instanceof JsonArray) {
                map.put(key, a((JsonArray) value));
            } else if (value instanceof JsonObject) {
                map.put(key, a((JsonObject) value));
            } else {
                map.put(key, value);
            }
        }
        return map;
    }

    public static List<Object> a(JsonArray jsonArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jsonArray.size(); i2++) {
            JsonElement jsonElement = jsonArray.get(i2);
            if (jsonElement instanceof JsonArray) {
                arrayList.add(a((JsonArray) jsonElement));
            } else if (jsonElement instanceof JsonObject) {
                arrayList.add(a((JsonObject) jsonElement));
            } else {
                arrayList.add(jsonElement);
            }
        }
        return arrayList;
    }
}
