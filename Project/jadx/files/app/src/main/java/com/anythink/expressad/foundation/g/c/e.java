package com.anythink.expressad.foundation.g.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private a a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f10487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<e> f10488d;

    public final a a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final e c() {
        return this.f10487c;
    }

    public final List<e> d() {
        return this.f10488d;
    }

    private void b(e eVar) {
        if (this.f10488d == null) {
            this.f10488d = new ArrayList();
        }
        eVar.f10487c = this;
        this.f10488d.add(eVar);
    }

    public final void a(a aVar) {
        this.a = aVar;
    }

    public final void a(String str) {
        this.b = str;
    }

    private void a(e eVar) {
        this.f10487c = eVar;
    }

    public final void a(a aVar, String str) {
        e eVar = new e();
        eVar.a = aVar;
        eVar.b = str;
        b(eVar);
    }

    public final void a(List<e> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<e> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }
}
