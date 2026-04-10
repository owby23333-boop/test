package com.bytedance.adsdk.e.bf.d;

import androidx.webkit.ProxyConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public enum bf implements tg {
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
    MINUS(Constants.ACCEPT_TIME_SEPARATOR_SERVER, 3),
    MULTI(ProxyConfig.MATCH_ALL_SCHEMES, 4),
    DIVISION("/", 4),
    MOD("%", 4);

    private final String f;
    private final int k;
    private static final Map<String, bf> w = new HashMap(128);
    private static final Set<bf> l = new HashSet();

    static {
        for (bf bfVar : values()) {
            w.put(bfVar.e(), bfVar);
            l.add(bfVar);
        }
    }

    bf(String str, int i) {
        this.f = str;
        this.k = i;
    }

    public static bf e(String str) {
        return w.get(str);
    }

    public int bf() {
        return this.k;
    }

    public static boolean e(tg tgVar) {
        return tgVar instanceof bf;
    }

    public String e() {
        return this.f;
    }
}
