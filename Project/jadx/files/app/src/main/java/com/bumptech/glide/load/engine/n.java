package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: EngineResource.java */
/* JADX INFO: loaded from: classes2.dex */
class n<Z> implements s<Z> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f13572s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f13573t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final s<Z> f13574u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final a f13575v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final com.bumptech.glide.load.c f13576w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f13577x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f13578y;

    /* JADX INFO: compiled from: EngineResource.java */
    interface a {
        void a(com.bumptech.glide.load.c cVar, n<?> nVar);
    }

    n(s<Z> sVar, boolean z2, boolean z3, com.bumptech.glide.load.c cVar, a aVar) {
        com.bumptech.glide.util.k.a(sVar);
        this.f13574u = sVar;
        this.f13572s = z2;
        this.f13573t = z3;
        this.f13576w = cVar;
        com.bumptech.glide.util.k.a(aVar);
        this.f13575v = aVar;
    }

    @Override // com.bumptech.glide.load.engine.s
    @NonNull
    public Class<Z> a() {
        return this.f13574u.a();
    }

    synchronized void b() {
        if (this.f13578y) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f13577x++;
    }

    s<Z> c() {
        return this.f13574u;
    }

    boolean d() {
        return this.f13572s;
    }

    void e() {
        boolean z2;
        synchronized (this) {
            if (this.f13577x <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z2 = true;
            int i2 = this.f13577x - 1;
            this.f13577x = i2;
            if (i2 != 0) {
                z2 = false;
            }
        }
        if (z2) {
            this.f13575v.a(this.f13576w, this);
        }
    }

    @Override // com.bumptech.glide.load.engine.s
    @NonNull
    public Z get() {
        return this.f13574u.get();
    }

    @Override // com.bumptech.glide.load.engine.s
    public int getSize() {
        return this.f13574u.getSize();
    }

    @Override // com.bumptech.glide.load.engine.s
    public synchronized void recycle() {
        if (this.f13577x > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f13578y) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f13578y = true;
        if (this.f13573t) {
            this.f13574u.recycle();
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f13572s + ", listener=" + this.f13575v + ", key=" + this.f13576w + ", acquired=" + this.f13577x + ", isRecycled=" + this.f13578y + ", resource=" + this.f13574u + '}';
    }
}
