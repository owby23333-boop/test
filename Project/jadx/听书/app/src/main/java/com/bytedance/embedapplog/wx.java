package com.bytedance.embedapplog;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class wx {
    private static final k z = new k();
    private static final Map<String, String> g = new ConcurrentHashMap();

    public static String z(String str) {
        Map<String, String> map = g;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String strZ = z.z(str);
        if (strZ != null) {
            map.put(str, strZ);
        }
        return strZ;
    }
}
