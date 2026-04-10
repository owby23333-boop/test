package com.anythink.expressad.foundation.g.f;

/* JADX INFO: loaded from: classes2.dex */
public final class k<T> {
    public T a;
    public com.anythink.expressad.foundation.g.f.a.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.anythink.expressad.foundation.g.f.f.c f10603c;

    private k(T t2, com.anythink.expressad.foundation.g.f.f.c cVar) {
        this.a = null;
        this.b = null;
        this.f10603c = null;
        this.a = t2;
        this.f10603c = cVar;
    }

    private boolean a() {
        return this.b == null;
    }

    public static <T> k<T> a(T t2, com.anythink.expressad.foundation.g.f.f.c cVar) {
        return new k<>(t2, cVar);
    }

    public static <T> k<T> a(com.anythink.expressad.foundation.g.f.a.a aVar) {
        return new k<>(aVar);
    }

    private k(com.anythink.expressad.foundation.g.f.a.a aVar) {
        this.a = null;
        this.b = null;
        this.f10603c = null;
        this.b = aVar;
    }
}
