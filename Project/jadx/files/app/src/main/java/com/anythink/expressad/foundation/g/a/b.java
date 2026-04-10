package com.anythink.expressad.foundation.g.a;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<K, V> extends a<K, V> {
    private static final int b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f10431c = 16777216;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10432d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<V> f10434f = Collections.synchronizedList(new LinkedList());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicInteger f10433e = new AtomicInteger();

    private b(int i2) {
        this.f10432d = i2;
        if (i2 > 16777216) {
            String.format("You set too large memory cache size (more than %1$d Mb)", 16);
        }
    }

    private int e() {
        return this.f10432d;
    }

    @Override // com.anythink.expressad.foundation.g.a.a, com.anythink.expressad.foundation.g.a.e
    public final boolean a(K k2, V v2) {
        boolean z2;
        int iC = c();
        int i2 = this.f10432d;
        int iAddAndGet = this.f10433e.get();
        if (iC < i2) {
            while (iAddAndGet + iC > i2) {
                if (this.f10434f.remove(d())) {
                    iAddAndGet = this.f10433e.addAndGet(-c());
                }
            }
            this.f10434f.add(v2);
            this.f10433e.addAndGet(iC);
            z2 = true;
        } else {
            z2 = false;
        }
        super.a(k2, v2);
        return z2;
    }

    @Override // com.anythink.expressad.foundation.g.a.a, com.anythink.expressad.foundation.g.a.e
    public final void b() {
        this.f10434f.clear();
        this.f10433e.set(0);
        super.b();
    }

    protected abstract int c();

    protected abstract V d();

    @Override // com.anythink.expressad.foundation.g.a.a, com.anythink.expressad.foundation.g.a.e
    public final void a(K k2) {
        Object objB = super.b(k2);
        if (objB != null && this.f10434f.remove(objB)) {
            this.f10433e.addAndGet(-c());
        }
        super.a(k2);
    }
}
