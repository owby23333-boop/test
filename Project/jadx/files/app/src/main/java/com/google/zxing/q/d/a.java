package com.google.zxing.q.d;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.i;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final int[] a = {0, 4, 1, 5};
    private static final int[] b = {6, 2, 7, 3};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f16316c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f16317d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    public static b a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map, boolean z2) throws NotFoundException {
        com.google.zxing.common.b bVarA = bVar.a();
        List<i[]> listA = a(z2, bVarA);
        if (listA.isEmpty()) {
            bVarA = bVarA.m64clone();
            bVarA.f();
            listA = a(z2, bVarA);
        }
        return new b(bVarA, listA);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r5 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r4.hasNext() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r5 = (com.google.zxing.i[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r5[1] == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        r3 = (int) java.lang.Math.max(r3, r5[1].b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r5[3] == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        r3 = java.lang.Math.max(r3, (int) r5[3].b());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.google.zxing.i[]> a(boolean r8, com.google.zxing.common.b r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = 0
        L8:
            r4 = 0
            r5 = 0
        La:
            int r6 = r9.c()
            if (r3 >= r6) goto L7c
            com.google.zxing.i[] r4 = a(r9, r3, r4)
            r6 = r4[r2]
            if (r6 != 0) goto L52
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L52
            if (r5 == 0) goto L7c
            java.util.Iterator r4 = r0.iterator()
        L23:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L4f
            java.lang.Object r5 = r4.next()
            com.google.zxing.i[] r5 = (com.google.zxing.i[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L3f
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.b()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L3f:
            r7 = r5[r6]
            if (r7 == 0) goto L23
            r5 = r5[r6]
            float r5 = r5.b()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L23
        L4f:
            int r3 = r3 + 5
            goto L8
        L52:
            r0.add(r4)
            if (r8 == 0) goto L7c
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L6a
            r5 = r4[r3]
            float r5 = r5.a()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.b()
            goto L78
        L6a:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.a()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.b()
        L78:
            int r3 = (int) r3
            r4 = r5
            r5 = 1
            goto La
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.q.d.a.a(boolean, com.google.zxing.common.b):java.util.List");
    }

    private static i[] a(com.google.zxing.common.b bVar, int i2, int i3) {
        int iC = bVar.c();
        int iE = bVar.e();
        i[] iVarArr = new i[8];
        a(iVarArr, a(bVar, iC, iE, i2, i3, f16316c), a);
        if (iVarArr[4] != null) {
            i3 = (int) iVarArr[4].a();
            i2 = (int) iVarArr[4].b();
        }
        a(iVarArr, a(bVar, iC, iE, i2, i3, f16317d), b);
        return iVarArr;
    }

    private static void a(i[] iVarArr, i[] iVarArr2, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iVarArr[iArr[i2]] = iVarArr2[i2];
        }
    }

    private static i[] a(com.google.zxing.common.b bVar, int i2, int i3, int i4, int i5, int[] iArr) {
        boolean z2;
        int i6;
        int[] iArr2;
        i[] iVarArr = new i[4];
        int[] iArr3 = new int[iArr.length];
        int i7 = i4;
        while (true) {
            if (i7 >= i2) {
                z2 = false;
                break;
            }
            int[] iArrA = a(bVar, i5, i7, i3, false, iArr, iArr3);
            if (iArrA != null) {
                while (true) {
                    iArr2 = iArrA;
                    if (i7 <= 0) {
                        break;
                    }
                    i7--;
                    iArrA = a(bVar, i5, i7, i3, false, iArr, iArr3);
                    if (iArrA == null) {
                        i7++;
                        break;
                    }
                }
                float f2 = i7;
                iVarArr[0] = new i(iArr2[0], f2);
                iVarArr[1] = new i(iArr2[1], f2);
                z2 = true;
            } else {
                i7 += 5;
            }
        }
        int i8 = i7 + 1;
        if (z2) {
            int[] iArr4 = {(int) iVarArr[0].a(), (int) iVarArr[1].a()};
            int i9 = i8;
            int i10 = 0;
            while (true) {
                if (i9 >= i2) {
                    i6 = i10;
                    break;
                }
                i6 = i10;
                int[] iArrA2 = a(bVar, iArr4[0], i9, i3, false, iArr, iArr3);
                if (iArrA2 != null && Math.abs(iArr4[0] - iArrA2[0]) < 5 && Math.abs(iArr4[1] - iArrA2[1]) < 5) {
                    iArr4 = iArrA2;
                    i10 = 0;
                } else {
                    if (i6 > 25) {
                        break;
                    }
                    i10 = i6 + 1;
                }
                i9++;
            }
            i8 = i9 - (i6 + 1);
            float f3 = i8;
            iVarArr[2] = new i(iArr4[0], f3);
            iVarArr[3] = new i(iArr4[1], f3);
        }
        if (i8 - i7 < 10) {
            Arrays.fill(iVarArr, (Object) null);
        }
        return iVarArr;
    }

    private static int[] a(com.google.zxing.common.b bVar, int i2, int i3, int i4, boolean z2, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i5 = 0;
        while (bVar.b(i2, i3) && i2 > 0) {
            int i6 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i2--;
            i5 = i6;
        }
        int length = iArr.length;
        int i7 = i2;
        boolean z3 = z2;
        int i8 = 0;
        while (i2 < i4) {
            if (bVar.b(i2, i3) != z3) {
                iArr2[i8] = iArr2[i8] + 1;
            } else {
                if (i8 != length - 1) {
                    i8++;
                } else {
                    if (a(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i7, i2};
                    }
                    i7 += iArr2[0] + iArr2[1];
                    int i9 = i8 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i8] = 0;
                    i8--;
                }
                iArr2[i8] = 1;
                z3 = !z3;
            }
            i2++;
        }
        if (i8 != length - 1 || a(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i7, i2 - 1};
    }

    private static float a(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }
}
