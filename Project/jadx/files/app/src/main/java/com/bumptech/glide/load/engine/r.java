package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.m.a;

/* JADX INFO: compiled from: LockedResource.java */
/* JADX INFO: loaded from: classes2.dex */
final class r<Z> implements s<Z>, a.f {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final Pools.Pool<r<?>> f13580w = com.bumptech.glide.util.m.a.a(20, new a());

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final com.bumptech.glide.util.m.c f13581s = com.bumptech.glide.util.m.c.b();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private s<Z> f13582t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f13583u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f13584v;

    /* JADX INFO: compiled from: LockedResource.java */
    class a implements a.d<r<?>> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.m.a.d
        public r<?> create() {
            return new r<>();
        }
    }

    r() {
    }

    private void a(s<Z> sVar) {
        this.f13584v = false;
        this.f13583u = true;
        this.f13582t = sVar;
    }

    @NonNull
    static <Z> r<Z> b(s<Z> sVar) {
        r rVarAcquire = f13580w.acquire();
        com.bumptech.glide.util.k.a(rVarAcquire);
        r rVar = rVarAcquire;
        rVar.a(sVar);
        return rVar;
    }

    private void d() {
        this.f13582t = null;
        f13580w.release(this);
    }

    synchronized void c() {
        this.f13581s.a();
        if (!this.f13583u) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f13583u = false;
        if (this.f13584v) {
            recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.s
    @NonNull
    public Z get() {
        return this.f13582t.get();
    }

    @Override // com.bumptech.glide.load.engine.s
    public int getSize() {
        return this.f13582t.getSize();
    }

    @Override // com.bumptech.glide.load.engine.s
    public synchronized void recycle() {
        this.f13581s.a();
        this.f13584v = true;
        if (!this.f13583u) {
            this.f13582t.recycle();
            d();
        }
    }

    @Override // com.bumptech.glide.util.m.a.f
    @NonNull
    public com.bumptech.glide.util.m.c b() {
        return this.f13581s;
    }

    @Override // com.bumptech.glide.load.engine.s
    @NonNull
    public Class<Z> a() {
        return this.f13582t.a();
    }
}
