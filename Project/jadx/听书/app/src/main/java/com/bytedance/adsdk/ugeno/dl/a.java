package com.bytedance.adsdk.ugeno.dl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static Map<String, g> z = new HashMap();

    public static void z(List<g> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (g gVar : list) {
            if (gVar != null) {
                z.put(gVar.z(), gVar);
            }
        }
    }

    public static g z(String str) {
        return z.get(str);
    }
}
