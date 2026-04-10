package com.bytedance.adsdk.g.g.a;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public enum dl implements gc {
    QUESTION("?", 0),
    COLON(":", 0),
    DOUBLE_AMP("&&", 1),
    DOUBLE_BAR("||", 1),
    EQ("==", 2),
    GT(">", 2),
    LT("<", 2),
    LT_EQ("<=", 2),
    GT_EQ(">=", 2),
    NOT_EQ("!=", 2),
    PLUS("+", 3),
    MINUS("-", 3),
    MULTI("*", 4),
    DIVISION("/", 4),
    MOD("%", 4);

    private final String fv;
    private final int js;
    private static final Map<String, dl> ls = new HashMap(128);
    private static final Set<dl> p = new HashSet();

    static {
        for (dl dlVar : values()) {
            ls.put(dlVar.z(), dlVar);
            p.add(dlVar);
        }
    }

    dl(String str, int i) {
        this.fv = str;
        this.js = i;
    }

    public static dl z(String str) {
        return ls.get(str);
    }

    public static boolean z(gc gcVar) {
        return gcVar instanceof dl;
    }

    public String z() {
        return this.fv;
    }

    public int g() {
        return this.js;
    }
}
