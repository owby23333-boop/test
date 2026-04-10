package com.bytedance.adsdk.e.bf.d;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public enum e implements tg {
    TRUE,
    FALSE,
    NULL;

    private static final Map<String, e> tg = new HashMap(128);

    static {
        for (e eVar : values()) {
            tg.put(eVar.name().toLowerCase(), eVar);
        }
    }

    public static e e(String str) {
        return tg.get(str.toLowerCase());
    }
}
