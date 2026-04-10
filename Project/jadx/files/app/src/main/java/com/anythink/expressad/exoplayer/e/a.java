package com.anythink.expressad.exoplayer.e;

import com.anythink.expressad.exoplayer.e.k;
import com.anythink.expressad.exoplayer.k.af;
import com.umeng.message.proguard.ad;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements k {
    public final int a;
    public final int[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f8832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f8833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f8834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f8835f;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.f8832c = jArr;
        this.f8833d = jArr2;
        this.f8834e = jArr3;
        this.a = iArr.length;
        int i2 = this.a;
        if (i2 > 0) {
            this.f8835f = jArr2[i2 - 1] + jArr3[i2 - 1];
        } else {
            this.f8835f = 0L;
        }
    }

    private int b(long j2) {
        return af.a(this.f8834e, j2, true);
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final k.a a(long j2) {
        int iA = af.a(this.f8834e, j2, true);
        l lVar = new l(this.f8834e[iA], this.f8832c[iA]);
        if (lVar.b >= j2 || iA == this.a - 1) {
            return new k.a(lVar);
        }
        int i2 = iA + 1;
        return new k.a(lVar, new l(this.f8834e[i2], this.f8832c[i2]));
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final boolean a() {
        return true;
    }

    public final String toString() {
        return "ChunkIndex(length=" + this.a + ", sizes=" + Arrays.toString(this.b) + ", offsets=" + Arrays.toString(this.f8832c) + ", timeUs=" + Arrays.toString(this.f8834e) + ", durationsUs=" + Arrays.toString(this.f8833d) + ad.f20406s;
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final long b() {
        return this.f8835f;
    }
}
