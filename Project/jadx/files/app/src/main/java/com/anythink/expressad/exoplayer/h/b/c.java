package com.anythink.expressad.exoplayer.h.b;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.j.k;
import com.anythink.expressad.exoplayer.j.t;
import com.anythink.expressad.exoplayer.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements t.c {
    public final k b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9243c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f9244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final Object f9246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f9247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f9248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final com.anythink.expressad.exoplayer.j.h f9249i;

    public c(com.anythink.expressad.exoplayer.j.h hVar, k kVar, m mVar, int i2, @Nullable Object obj, long j2, long j3) {
        this.f9249i = (com.anythink.expressad.exoplayer.j.h) com.anythink.expressad.exoplayer.k.a.a(hVar);
        this.b = (k) com.anythink.expressad.exoplayer.k.a.a(kVar);
        this.f9244d = mVar;
        this.f9245e = i2;
        this.f9246f = obj;
        this.f9247g = j2;
        this.f9248h = j3;
    }

    private long c() {
        return this.f9248h - this.f9247g;
    }

    public abstract long d();
}
