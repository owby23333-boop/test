package com.anythink.expressad.exoplayer.e.a;

import com.anythink.expressad.exoplayer.k.af;

/* JADX INFO: loaded from: classes2.dex */
final class d {
    private static final int a = 8192;

    public static final class a {
        public final long[] a;
        public final int[] b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f8885d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f8886e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f8887f;

        /* synthetic */ a(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j2, byte b) {
            this(jArr, iArr, i2, jArr2, iArr2, j2);
        }

        private a(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j2) {
            this.a = jArr;
            this.b = iArr;
            this.f8884c = i2;
            this.f8885d = jArr2;
            this.f8886e = iArr2;
            this.f8887f = j2;
        }
    }

    private d() {
    }

    public static a a(int i2, long[] jArr, int[] iArr, long j2) {
        int i3 = 8192 / i2;
        int iA = 0;
        for (int i4 : iArr) {
            iA += af.a(i4, i3);
        }
        long[] jArr2 = new long[iA];
        int[] iArr2 = new int[iA];
        long[] jArr3 = new long[iA];
        int[] iArr3 = new int[iA];
        int i5 = 0;
        int i6 = 0;
        int iMax = 0;
        for (int i7 = 0; i7 < iArr.length; i7++) {
            int i8 = iArr[i7];
            long j3 = jArr[i7];
            while (i8 > 0) {
                int iMin = Math.min(i3, i8);
                jArr2[i6] = j3;
                iArr2[i6] = i2 * iMin;
                iMax = Math.max(iMax, iArr2[i6]);
                jArr3[i6] = ((long) i5) * j2;
                iArr3[i6] = 1;
                j3 += (long) iArr2[i6];
                i5 += iMin;
                i8 -= iMin;
                i6++;
            }
        }
        return new a(jArr2, iArr2, iMax, jArr3, iArr3, j2 * ((long) i5), (byte) 0);
    }
}
