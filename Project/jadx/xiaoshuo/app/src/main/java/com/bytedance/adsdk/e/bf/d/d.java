package com.bytedance.adsdk.e.bf.d;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public enum d implements tg {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    COMMA(",");

    private static final Map<String, d> vn;
    private final String p;

    static {
        HashMap map = new HashMap(128);
        vn = map;
        for (d dVar : map.values()) {
            vn.put(dVar.e(), dVar);
        }
    }

    d(String str) {
        this.p = str;
    }

    public static boolean e(tg tgVar) {
        return tgVar instanceof d;
    }

    public String e() {
        return this.p;
    }
}
