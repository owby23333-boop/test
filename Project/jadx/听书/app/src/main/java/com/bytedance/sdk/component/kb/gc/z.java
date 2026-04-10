package com.bytedance.sdk.component.kb.gc;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static Map<String, Map<String, Object>> g = new HashMap();
    private static volatile z z;

    private z() {
    }

    public static z z() {
        if (z != null) {
            return z;
        }
        synchronized (z.class) {
            if (z != null) {
                return z;
            }
            z zVar = new z();
            z = zVar;
            return zVar;
        }
    }

    public Map<String, Object> z(String str) {
        Map<String, Object> map = g.get(str);
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        g.put(str, map2);
        return map2;
    }
}
