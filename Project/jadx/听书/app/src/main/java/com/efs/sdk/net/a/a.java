package com.efs.sdk.net.a;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static a c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, b> f1604a;
    private HashMap<String, c> b;

    public static a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    private a() {
        b();
    }

    private void b() {
        if (this.f1604a == null) {
            this.f1604a = new HashMap<>();
        }
        this.f1604a.clear();
    }

    public final b a(String str) {
        if (this.f1604a == null) {
            b();
        }
        b bVar = this.f1604a.get(str);
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        bVar2.f1612a = str;
        bVar2.b = System.currentTimeMillis();
        this.f1604a.put(str, bVar2);
        return bVar2;
    }

    public final void b(String str) {
        HashMap<String, b> map = this.f1604a;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.f1604a.remove(str);
    }

    public final c c(String str) {
        if (this.b == null) {
            this.b = new HashMap<>();
        }
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        c cVar = new c();
        cVar.A = str;
        cVar.D = System.currentTimeMillis();
        this.b.put(str, cVar);
        return cVar;
    }

    public final void d(String str) {
        HashMap<String, c> map = this.b;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.b.remove(str);
    }
}
