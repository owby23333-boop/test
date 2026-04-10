package com.bytedance.sdk.gromore.z.g;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static Map<String, Object> z(Map<String, Object> map, Map<String, Object> map2) {
        if (map == null) {
            return map2;
        }
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }
}
