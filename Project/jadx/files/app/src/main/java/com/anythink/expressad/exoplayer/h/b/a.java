package com.anythink.expressad.exoplayer.h.b;

import com.anythink.expressad.exoplayer.j.k;
import com.anythink.expressad.exoplayer.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends i {
    public final long a;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private b f9240k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int[] f9241l;

    public a(com.anythink.expressad.exoplayer.j.h hVar, k kVar, m mVar, int i2, Object obj, long j2, long j3, long j4, long j5) {
        super(hVar, kVar, mVar, i2, obj, j2, j3, j5);
        this.a = j4;
    }

    public final void a(b bVar) {
        this.f9240k = bVar;
        this.f9241l = bVar.a();
    }

    protected final b c() {
        return this.f9240k;
    }

    public final int a(int i2) {
        return this.f9241l[i2];
    }
}
