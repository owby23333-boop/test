package com.anythink.expressad.foundation.g.f.f;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public final int a;
    public final byte[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f10552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.anythink.expressad.foundation.g.f.c.c> f10553d;

    public c(int i2, byte[] bArr, List<com.anythink.expressad.foundation.g.f.c.c> list) {
        this(i2, bArr, a(list), list);
    }

    private static Map<String, String> a(List<com.anythink.expressad.foundation.g.f.c.c> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (com.anythink.expressad.foundation.g.f.c.c cVar : list) {
            treeMap.put(cVar.a(), cVar.b());
        }
        return treeMap;
    }

    private c(int i2, byte[] bArr, Map<String, String> map, List<com.anythink.expressad.foundation.g.f.c.c> list) {
        this.a = i2;
        this.b = bArr;
        this.f10552c = map;
        if (list == null) {
            this.f10553d = null;
        } else {
            this.f10553d = Collections.unmodifiableList(list);
        }
    }
}
