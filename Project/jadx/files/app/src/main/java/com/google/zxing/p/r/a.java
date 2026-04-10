package com.google.zxing.p.r;

import com.google.zxing.NotFoundException;
import com.google.zxing.p.k;

/* JADX INFO: compiled from: AbstractRSSReader.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends k {
    private final int[] a = new int[4];
    private final int[] b = new int[8];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f16259c = new float[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f16260d = new float[4];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f16261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f16262f;

    protected a() {
        int[] iArr = this.b;
        this.f16261e = new int[iArr.length / 2];
        this.f16262f = new int[iArr.length / 2];
    }

    protected final int[] a() {
        return this.b;
    }

    protected final int[] b() {
        return this.a;
    }

    protected final int[] c() {
        return this.f16262f;
    }

    protected final float[] d() {
        return this.f16260d;
    }

    protected final int[] e() {
        return this.f16261e;
    }

    protected final float[] f() {
        return this.f16259c;
    }

    protected static int a(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            if (k.a(iArr, iArr2[i2], 0.45f) < 0.2f) {
                return i2;
            }
        }
        throw NotFoundException.f();
    }

    protected static void b(int[] iArr, float[] fArr) {
        float f2 = fArr[0];
        int i2 = 0;
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] > f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] + 1;
    }

    protected static void a(int[] iArr, float[] fArr) {
        float f2 = fArr[0];
        int i2 = 0;
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] < f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] - 1;
    }

    protected static boolean a(int[] iArr) {
        float f2 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f2 >= 0.7916667f && f2 <= 0.89285713f) {
            int i2 = Integer.MIN_VALUE;
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 > i2) {
                    i2 = i4;
                }
                if (i4 < i3) {
                    i3 = i4;
                }
            }
            if (i2 < i3 * 10) {
                return true;
            }
        }
        return false;
    }
}
