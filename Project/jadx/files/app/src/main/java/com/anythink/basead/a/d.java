package com.anythink.basead.a;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final String a = "d";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile d f5832c;
    ConcurrentHashMap<String, com.anythink.basead.c.d> b = new ConcurrentHashMap<>();

    private d() {
    }

    public static d a() {
        if (f5832c == null) {
            synchronized (d.class) {
                if (f5832c == null) {
                    f5832c = new d();
                }
            }
        }
        return f5832c;
    }

    public final void a(int i2, String str, com.anythink.basead.c.d dVar) {
        this.b.put(i2 + str, dVar);
    }

    public final com.anythink.basead.c.d a(int i2, String str) {
        return this.b.get(i2 + str);
    }
}
