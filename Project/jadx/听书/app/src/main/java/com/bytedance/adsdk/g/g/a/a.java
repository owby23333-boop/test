package com.bytedance.adsdk.g.g.a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public enum a implements gc {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    COMMA(",");

    private static final Map<String, a> m;
    private final String e;

    static {
        HashMap map = new HashMap(128);
        m = map;
        for (a aVar : map.values()) {
            m.put(aVar.z(), aVar);
        }
    }

    a(String str) {
        this.e = str;
    }

    public static boolean z(gc gcVar) {
        return gcVar instanceof a;
    }

    public String z() {
        return this.e;
    }
}
