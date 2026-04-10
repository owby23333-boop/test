package com.amgcyo.cuttadon.sdk.utils;

import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.config.ForceBean;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.utils.otherutils.r;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ArtForceUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static Map<String, Object> a;

    public static int a(String str, int i2) {
        if (a == null) {
            a = b();
        }
        Map<String, Object> map = a;
        if (map == null) {
            return i2;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey().equals(str)) {
                Object value = entry.getValue();
                if (value instanceof JsonPrimitive) {
                    JsonPrimitive jsonPrimitive = (JsonPrimitive) value;
                    if (jsonPrimitive.isNumber()) {
                        int asInt = jsonPrimitive.getAsInt();
                        return asInt <= i2 ? i2 : asInt;
                    }
                } else {
                    continue;
                }
            }
        }
        return i2;
    }

    private static Map<String, Object> b() {
        ForceBean force;
        MkAppConfig mkAppConfigE = com.amgcyo.cuttadon.utils.otherutils.h.e();
        if (mkAppConfigE == null || (force = mkAppConfigE.getForce()) == null) {
            return null;
        }
        return com.amgcyo.cuttadon.j.c.b.b(r.a(force));
    }

    public static String c(String str) {
        return a(str, "");
    }

    public static List<String> b(String str) {
        if (a == null) {
            a = b();
        }
        if (a == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, Object>> it = a.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Object> next = it.next();
            if (next.getKey().equals(str)) {
                Object value = next.getValue();
                if (value instanceof JsonArray) {
                    JsonArray asJsonArray = ((JsonArray) value).getAsJsonArray();
                    if (asJsonArray != null) {
                        for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                            arrayList.add(asJsonArray.get(i2).getAsString());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static int a(String str) {
        return a(str, 0);
    }

    public static String a(String str, String str2) {
        if (a == null) {
            a = b();
        }
        Map<String, Object> map = a;
        if (map == null) {
            return str2;
        }
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Object> next = it.next();
            if (next.getKey().equals(str)) {
                Object value = next.getValue();
                if (value instanceof JsonPrimitive) {
                    JsonPrimitive jsonPrimitive = (JsonPrimitive) value;
                    if (jsonPrimitive.isString()) {
                        String asString = jsonPrimitive.getAsString();
                        if (!TextUtils.isEmpty(asString)) {
                            return asString;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return str2;
    }

    public static void a() {
        try {
            if (a == null || a.size() <= 0) {
                return;
            }
            a.clear();
            a = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
