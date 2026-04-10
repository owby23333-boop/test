package com.anythink.expressad.exoplayer.k;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class p {
    public static final int b = 255;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9884d = "NalUnitUtil";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9885e = 6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f9886f = 7;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f9887g = 39;
    public static final byte[] a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float[] f9883c = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f9888h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int[] f9889i = new int[10];

    public static final class a {
        public final int a;
        public final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f9890c;

        public a(int i2, int i3, boolean z2) {
            this.a = i2;
            this.b = i3;
            this.f9890c = z2;
        }
    }

    public static final class b {
        public final int a;
        public final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f9891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f9892d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f9893e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f9894f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f9895g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f9896h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f9897i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f9898j;

        public b(int i2, int i3, int i4, float f2, boolean z2, boolean z3, int i5, int i6, int i7, boolean z4) {
            this.a = i2;
            this.b = i3;
            this.f9891c = i4;
            this.f9892d = f2;
            this.f9893e = z2;
            this.f9894f = z3;
            this.f9895g = i5;
            this.f9896h = i6;
            this.f9897i = i7;
            this.f9898j = z4;
        }
    }

    private p() {
    }

    public static int a(byte[] bArr, int i2) {
        int i3;
        synchronized (f9888h) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                while (true) {
                    if (i4 >= i2 - 2) {
                        i4 = i2;
                        break;
                    }
                    if (bArr[i4] == 0 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 3) {
                        break;
                    }
                    i4++;
                }
                if (i4 < i2) {
                    if (f9889i.length <= i5) {
                        int[] iArr = f9889i;
                        f9889i = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    f9889i[i5] = i4;
                    i4 += 3;
                    i5++;
                }
            }
            i3 = i2 - i5;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = f9889i[i8] - i7;
                System.arraycopy(bArr, i7, bArr, i6, i9);
                int i10 = i6 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i6 = i11 + 1;
                bArr[i11] = 0;
                i7 += i9 + 3;
            }
            System.arraycopy(bArr, i7, bArr, i6, i3 - i6);
        }
        return i3;
    }

    private static int b(byte[] bArr, int i2) {
        return bArr[i2 + 3] & 31;
    }

    private static int c(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 126) >> 1;
    }

    private static a b(byte[] bArr, int i2, int i3) {
        t tVar = new t(bArr, i2, i3);
        tVar.a(8);
        int iC = tVar.c();
        int iC2 = tVar.c();
        tVar.a();
        return new a(iC, iC2, tVar.b());
    }

    private static int c(byte[] bArr, int i2, int i3) {
        while (i2 < i3 - 2) {
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 3) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static void a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (i4 < iPosition) {
                int i5 = byteBuffer.get(i2) & 255;
                if (i3 == 3) {
                    if (i5 == 1 && (byteBuffer.get(i4) & 31) == 7) {
                        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                        byteBufferDuplicate.position(i2 - 3);
                        byteBufferDuplicate.limit(iPosition);
                        byteBuffer.position(0);
                        byteBuffer.put(byteBufferDuplicate);
                        return;
                    }
                } else if (i5 == 0) {
                    i3++;
                }
                if (i5 != 0) {
                    i3 = 0;
                }
                i2 = i4;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static boolean a(String str, byte b2) {
        return (o.f9863h.equals(str) && (b2 & 31) == 6) || (o.f9864i.equals(str) && ((b2 & 126) >> 1) == 39);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.expressad.exoplayer.k.p.b a(byte[] r18, int r19, int r20) {
        /*
            Method dump skipped, instruction units count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.p.a(byte[], int, int):com.anythink.expressad.exoplayer.k.p$b");
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0096, code lost:
    
        r8 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(byte[] r7, int r8, int r9, boolean[] r10) {
        /*
            int r0 = r9 - r8
            r1 = 0
            r2 = 1
            if (r0 < 0) goto L8
            r3 = 1
            goto L9
        L8:
            r3 = 0
        L9:
            com.anythink.expressad.exoplayer.k.a.b(r3)
            if (r0 != 0) goto Lf
            return r9
        Lf:
            r3 = 2
            if (r10 == 0) goto L40
            boolean r4 = r10[r1]
            if (r4 == 0) goto L1c
            a(r10)
            int r8 = r8 + (-3)
            return r8
        L1c:
            if (r0 <= r2) goto L2b
            boolean r4 = r10[r2]
            if (r4 == 0) goto L2b
            r4 = r7[r8]
            if (r4 != r2) goto L2b
            a(r10)
            int r8 = r8 - r3
            return r8
        L2b:
            if (r0 <= r3) goto L40
            boolean r4 = r10[r3]
            if (r4 == 0) goto L40
            r4 = r7[r8]
            if (r4 != 0) goto L40
            int r4 = r8 + 1
            r4 = r7[r4]
            if (r4 != r2) goto L40
            a(r10)
            int r8 = r8 - r2
            return r8
        L40:
            int r4 = r9 + (-1)
            int r8 = r8 + r3
        L43:
            if (r8 >= r4) goto L66
            r5 = r7[r8]
            r5 = r5 & 254(0xfe, float:3.56E-43)
            if (r5 != 0) goto L63
            int r5 = r8 + (-2)
            r6 = r7[r5]
            if (r6 != 0) goto L61
            int r6 = r8 + (-1)
            r6 = r7[r6]
            if (r6 != 0) goto L61
            r6 = r7[r8]
            if (r6 != r2) goto L61
            if (r10 == 0) goto L60
            a(r10)
        L60:
            return r5
        L61:
            int r8 = r8 + (-2)
        L63:
            int r8 = r8 + 3
            goto L43
        L66:
            if (r10 == 0) goto Lba
            if (r0 <= r3) goto L7d
            int r8 = r9 + (-3)
            r8 = r7[r8]
            if (r8 != 0) goto L7b
            int r8 = r9 + (-2)
            r8 = r7[r8]
            if (r8 != 0) goto L7b
            r8 = r7[r4]
            if (r8 != r2) goto L7b
            goto L96
        L7b:
            r8 = 0
            goto L97
        L7d:
            if (r0 != r3) goto L8e
            boolean r8 = r10[r3]
            if (r8 == 0) goto L7b
            int r8 = r9 + (-2)
            r8 = r7[r8]
            if (r8 != 0) goto L7b
            r8 = r7[r4]
            if (r8 != r2) goto L7b
            goto L96
        L8e:
            boolean r8 = r10[r2]
            if (r8 == 0) goto L7b
            r8 = r7[r4]
            if (r8 != r2) goto L7b
        L96:
            r8 = 1
        L97:
            r10[r1] = r8
            if (r0 <= r2) goto La6
            int r8 = r9 + (-2)
            r8 = r7[r8]
            if (r8 != 0) goto Lb0
            r8 = r7[r4]
            if (r8 != 0) goto Lb0
            goto Lae
        La6:
            boolean r8 = r10[r3]
            if (r8 == 0) goto Lb0
            r8 = r7[r4]
            if (r8 != 0) goto Lb0
        Lae:
            r8 = 1
            goto Lb1
        Lb0:
            r8 = 0
        Lb1:
            r10[r2] = r8
            r7 = r7[r4]
            if (r7 != 0) goto Lb8
            r1 = 1
        Lb8:
            r10[r3] = r1
        Lba:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.p.a(byte[], int, int, boolean[]):int");
    }

    private static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    private static void a(t tVar, int i2) {
        int iD = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i2; i4++) {
            if (iD != 0) {
                iD = ((tVar.d() + i3) + 256) % 256;
            }
            if (iD != 0) {
                i3 = iD;
            }
        }
    }
}
