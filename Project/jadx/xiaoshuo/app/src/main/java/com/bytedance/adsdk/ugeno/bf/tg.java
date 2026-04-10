package com.bytedance.adsdk.ugeno.bf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class tg {
    private static Map<String, bf> e = new HashMap();

    public static void e(List<bf> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (bf bfVar : list) {
            if (bfVar != null) {
                e.put(bfVar.e(), bfVar);
            }
        }
    }

    public static bf e(String str) {
        return e.get(str);
    }
}
