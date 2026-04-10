package com.anythink.expressad.exoplayer.h.b;

import com.anythink.expressad.exoplayer.e.m;
import com.anythink.expressad.exoplayer.h.b.d;
import com.anythink.expressad.exoplayer.h.x;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements d.b {
    private static final String a = "BaseMediaChunkOutput";
    private final int[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x[] f9242c;

    public b(int[] iArr, x[] xVarArr) {
        this.b = iArr;
        this.f9242c = xVarArr;
    }

    @Override // com.anythink.expressad.exoplayer.h.b.d.b
    public final m a(int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.b;
            if (i3 >= iArr.length) {
                "Unmatched track of type: ".concat(String.valueOf(i2));
                return new com.anythink.expressad.exoplayer.e.d();
            }
            if (i2 == iArr[i3]) {
                return this.f9242c[i3];
            }
            i3++;
        }
    }

    public final int[] a() {
        int[] iArr = new int[this.f9242c.length];
        int i2 = 0;
        while (true) {
            x[] xVarArr = this.f9242c;
            if (i2 >= xVarArr.length) {
                return iArr;
            }
            if (xVarArr[i2] != null) {
                iArr[i2] = xVarArr[i2].b();
            }
            i2++;
        }
    }

    public final void a(long j2) {
        for (x xVar : this.f9242c) {
            if (xVar != null) {
                xVar.a(j2);
            }
        }
    }
}
