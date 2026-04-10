package com.yuewen;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class o01 {
    public static final void a(@NotNull JSONObject jSONObject, @NotNull String key, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (obj == null) {
            return;
        }
        try {
            jSONObject.put(key, obj);
        } catch (JSONException e) {
            if (m81.k()) {
                e.printStackTrace();
            }
        }
    }

    public static final byte b(boolean z) {
        return z ? (byte) 1 : (byte) 0;
    }

    @NotNull
    public static final JSONObject c(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            a(jSONObject, entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    @NotNull
    public static final Map<String, Object> d(@NotNull JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys()");
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Object obj = jSONObject.get(key);
            Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
            map.put(key, obj);
        }
        return map;
    }
}
