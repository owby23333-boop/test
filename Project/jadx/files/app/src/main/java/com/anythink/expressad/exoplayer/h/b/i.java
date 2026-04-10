package com.anythink.expressad.exoplayer.h.b;

import com.anythink.expressad.exoplayer.j.k;
import com.anythink.expressad.exoplayer.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f9288j;

    public i(com.anythink.expressad.exoplayer.j.h hVar, k kVar, m mVar, int i2, Object obj, long j2, long j3, long j4) {
        super(hVar, kVar, mVar, i2, obj, j2, j3);
        com.anythink.expressad.exoplayer.k.a.a(mVar);
        this.f9288j = j4;
    }

    public long e() {
        long j2 = this.f9288j;
        if (j2 != -1) {
            return j2 + 1;
        }
        return -1L;
    }

    public abstract boolean f();
}
