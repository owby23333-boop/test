package com.anythink.expressad.exoplayer.e.a;

import com.anythink.expressad.exoplayer.k.af;

/* JADX INFO: loaded from: classes2.dex */
final class m {
    public final j a;
    public final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f9001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f9002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long[] f9004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f9005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f9006h;

    public m(j jVar, long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j2) {
        com.anythink.expressad.exoplayer.k.a.a(iArr.length == jArr2.length);
        com.anythink.expressad.exoplayer.k.a.a(jArr.length == jArr2.length);
        com.anythink.expressad.exoplayer.k.a.a(iArr2.length == jArr2.length);
        this.a = jVar;
        this.f9001c = jArr;
        this.f9002d = iArr;
        this.f9003e = i2;
        this.f9004f = jArr2;
        this.f9005g = iArr2;
        this.f9006h = j2;
        this.b = jArr.length;
    }

    public final int a(long j2) {
        for (int iA = af.a(this.f9004f, j2, false); iA >= 0; iA--) {
            if ((this.f9005g[iA] & 1) != 0) {
                return iA;
            }
        }
        return -1;
    }

    public final int b(long j2) {
        for (int iA = af.a(this.f9004f, j2, true, false); iA < this.f9004f.length; iA++) {
            if ((this.f9005g[iA] & 1) != 0) {
                return iA;
            }
        }
        return -1;
    }
}
