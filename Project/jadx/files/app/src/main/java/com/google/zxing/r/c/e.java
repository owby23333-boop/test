package com.google.zxing.r.c;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.g;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: compiled from: MatrixUtil.java */
/* JADX INFO: loaded from: classes2.dex */
final class e {
    private static final int[][] a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[][] f16365c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, TbsListener.ErrorCode.DOWNLOAD_USER_PAUSE, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO}, new int[]{6, 24, 50, 76, 102, 128, TbsListener.ErrorCode.STARTDOWNLOAD_NEEDDOWNLOAD_KEY_ERROR}, new int[]{6, 28, 54, 80, 106, TbsListener.ErrorCode.DOWNLOAD_CDN_URL_IS_NULL, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[][] f16366d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static void a(b bVar) {
        bVar.a((byte) -1);
    }

    private static void b(b bVar) throws WriterException {
        if (bVar.a(8, bVar.b() - 8) == 0) {
            throw new WriterException();
        }
        bVar.a(8, bVar.b() - 8, 1);
    }

    private static boolean b(int i2) {
        return i2 == -1;
    }

    static void c(g gVar, b bVar) throws WriterException {
        if (gVar.e() < 7) {
            return;
        }
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        a(gVar, aVar);
        int i2 = 0;
        int i3 = 17;
        while (i2 < 6) {
            int i4 = i3;
            for (int i5 = 0; i5 < 3; i5++) {
                boolean zA = aVar.a(i4);
                i4--;
                bVar.a(i2, (bVar.b() - 11) + i5, zA);
                bVar.a((bVar.b() - 11) + i5, i2, zA);
            }
            i2++;
            i3 = i4;
        }
    }

    private static void d(b bVar) {
        int i2 = 8;
        while (i2 < bVar.c() - 8) {
            int i3 = i2 + 1;
            int i4 = i3 % 2;
            if (b(bVar.a(i2, 6))) {
                bVar.a(i2, 6, i4);
            }
            if (b(bVar.a(6, i2))) {
                bVar.a(6, i2, i4);
            }
            i2 = i3;
        }
    }

    static void a(com.google.zxing.common.a aVar, ErrorCorrectionLevel errorCorrectionLevel, g gVar, int i2, b bVar) throws WriterException {
        a(bVar);
        a(gVar, bVar);
        a(errorCorrectionLevel, i2, bVar);
        c(gVar, bVar);
        a(aVar, i2, bVar);
    }

    private static void b(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 5; i4++) {
            int[] iArr = b[i4];
            for (int i5 = 0; i5 < 5; i5++) {
                bVar.a(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    private static void b(g gVar, b bVar) {
        if (gVar.e() < 2) {
            return;
        }
        int[] iArr = f16365c[gVar.e() - 1];
        for (int i2 : iArr) {
            if (i2 >= 0) {
                for (int i3 : iArr) {
                    if (i3 >= 0 && b(bVar.a(i3, i2))) {
                        b(i3 - 2, i2 - 2, bVar);
                    }
                }
            }
        }
    }

    static void a(g gVar, b bVar) throws WriterException {
        c(bVar);
        b(bVar);
        b(gVar, bVar);
        d(bVar);
    }

    private static void c(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 7; i4++) {
            int[] iArr = a[i4];
            for (int i5 = 0; i5 < 7; i5++) {
                bVar.a(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    private static void d(int i2, int i3, b bVar) throws WriterException {
        for (int i4 = 0; i4 < 7; i4++) {
            int i5 = i3 + i4;
            if (b(bVar.a(i2, i5))) {
                bVar.a(i2, i5, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    private static void c(b bVar) throws WriterException {
        int length = a[0].length;
        c(0, 0, bVar);
        c(bVar.c() - length, 0, bVar);
        c(0, bVar.c() - length, bVar);
        a(0, 7, bVar);
        a(bVar.c() - 8, 7, bVar);
        a(0, bVar.c() - 8, bVar);
        d(7, 0, bVar);
        d((bVar.b() - 7) - 1, 0, bVar);
        d(7, bVar.b() - 7, bVar);
    }

    static void a(ErrorCorrectionLevel errorCorrectionLevel, int i2, b bVar) throws WriterException {
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        a(errorCorrectionLevel, i2, aVar);
        for (int i3 = 0; i3 < aVar.c(); i3++) {
            boolean zA = aVar.a((aVar.c() - 1) - i3);
            int[] iArr = f16366d[i3];
            bVar.a(iArr[0], iArr[1], zA);
            if (i3 < 8) {
                bVar.a((bVar.c() - i3) - 1, 8, zA);
            } else {
                bVar.a(8, (bVar.b() - 7) + (i3 - 8), zA);
            }
        }
    }

    static void a(com.google.zxing.common.a aVar, int i2, b bVar) throws WriterException {
        boolean zA;
        int iC = bVar.c() - 1;
        int iB = bVar.b() - 1;
        int i3 = 0;
        int i4 = -1;
        while (iC > 0) {
            if (iC == 6) {
                iC--;
            }
            while (iB >= 0 && iB < bVar.b()) {
                int i5 = i3;
                for (int i6 = 0; i6 < 2; i6++) {
                    int i7 = iC - i6;
                    if (b(bVar.a(i7, iB))) {
                        if (i5 < aVar.c()) {
                            zA = aVar.a(i5);
                            i5++;
                        } else {
                            zA = false;
                        }
                        if (i2 != -1 && d.a(i2, i7, iB)) {
                            zA = !zA;
                        }
                        bVar.a(i7, iB, zA);
                    }
                }
                iB += i4;
                i3 = i5;
            }
            i4 = -i4;
            iB += i4;
            iC -= 2;
        }
        if (i3 == aVar.c()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i3 + '/' + aVar.c());
    }

    static int a(int i2) {
        return 32 - Integer.numberOfLeadingZeros(i2);
    }

    static int a(int i2, int i3) {
        if (i3 != 0) {
            int iA = a(i3);
            int iA2 = i2 << (iA - 1);
            while (a(iA2) >= iA) {
                iA2 ^= i3 << (a(iA2) - iA);
            }
            return iA2;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    static void a(ErrorCorrectionLevel errorCorrectionLevel, int i2, com.google.zxing.common.a aVar) throws WriterException {
        if (f.b(i2)) {
            int iF = (errorCorrectionLevel.f() << 3) | i2;
            aVar.a(iF, 5);
            aVar.a(a(iF, 1335), 10);
            com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
            aVar2.a(21522, 15);
            aVar.b(aVar2);
            if (aVar.c() == 15) {
                return;
            }
            throw new WriterException("should not happen but we got: " + aVar.c());
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void a(g gVar, com.google.zxing.common.a aVar) throws WriterException {
        aVar.a(gVar.e(), 6);
        aVar.a(a(gVar.e(), 7973), 12);
        if (aVar.c() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar.c());
    }

    private static void a(int i2, int i3, b bVar) throws WriterException {
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i2 + i4;
            if (b(bVar.a(i5, i3))) {
                bVar.a(i5, i3, 0);
            } else {
                throw new WriterException();
            }
        }
    }
}
