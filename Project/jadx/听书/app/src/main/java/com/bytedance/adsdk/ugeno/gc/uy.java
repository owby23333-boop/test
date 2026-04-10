package com.bytedance.adsdk.ugeno.gc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class uy {
    private static Map<String, e> z = new HashMap();

    public static void z(List<e> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (e eVar : list) {
            if (eVar != null) {
                z.put(eVar.z(), eVar);
            }
        }
    }

    public static e z(String str) {
        return z.get(str);
    }
}
