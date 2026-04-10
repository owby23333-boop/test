package com.bytedance.adsdk.g.g.a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public enum z implements gc {
    TRUE,
    FALSE,
    NULL;


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, z> f132a = new HashMap(128);

    static {
        for (z zVar : values()) {
            f132a.put(zVar.name().toLowerCase(), zVar);
        }
    }

    public static z z(String str) {
        return f132a.get(str.toLowerCase());
    }
}
