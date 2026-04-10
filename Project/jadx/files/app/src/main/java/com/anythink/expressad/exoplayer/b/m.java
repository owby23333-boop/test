package com.anythink.expressad.exoplayer.b;

import com.anythink.expressad.foundation.h.m;
import com.tencent.smtt.sdk.TbsListener;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    private static final int a = 2147385345;
    private static final int b = 536864768;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f8605c = -25230976;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f8606d = -14745368;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte f8607e = 127;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte f8608f = 31;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte f8609g = -2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte f8610h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f8611i = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f8612j = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f8613k = {64, 112, 128, 192, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 256, 384, m.a.a, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    private m() {
    }

    private static int a(byte[] bArr) {
        int i2;
        byte b2;
        int i3;
        byte b3;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i2 = (bArr[4] & 7) << 4;
                b3 = bArr[7];
            } else if (b4 != 31) {
                i2 = (bArr[4] & 1) << 6;
                b2 = bArr[5];
            } else {
                i2 = (bArr[5] & 7) << 4;
                b3 = bArr[6];
            }
            i3 = b3 & 60;
            return (((i3 >> 2) | i2) + 1) * 32;
        }
        i2 = (bArr[5] & 1) << 6;
        b2 = bArr[4];
        i3 = b2 & 252;
        return (((i3 >> 2) | i2) + 1) * 32;
    }

    private static boolean a(int i2) {
        return i2 == a || i2 == f8605c || i2 == b || i2 == f8606d;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int b(byte[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            r2 = -2
            r3 = 7
            r4 = 6
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L4f
            r2 = -1
            if (r1 == r2) goto L37
            r2 = 31
            if (r1 == r2) goto L26
            r1 = 5
            r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r3]
        L20:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
            goto L5e
        L26:
            r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            r7 = r7[r1]
            goto L47
        L37:
            r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            r7 = r7[r1]
        L47:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = 1
            goto L5e
        L4f:
            r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r4]
            goto L20
        L5e:
            if (r0 == 0) goto L64
            int r7 = r7 * 16
            int r7 = r7 / 14
        L64:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.m.b(byte[]):int");
    }

    private static com.anythink.expressad.exoplayer.k.r c(byte[] bArr) {
        if (bArr[0] == 127) {
            return new com.anythink.expressad.exoplayer.k.r(bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        if (bArrCopyOf[0] == -2 || bArrCopyOf[0] == -1) {
            for (int i2 = 0; i2 < bArrCopyOf.length - 1; i2 += 2) {
                byte b2 = bArrCopyOf[i2];
                int i3 = i2 + 1;
                bArrCopyOf[i2] = bArrCopyOf[i3];
                bArrCopyOf[i3] = b2;
            }
        }
        com.anythink.expressad.exoplayer.k.r rVar = new com.anythink.expressad.exoplayer.k.r(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            com.anythink.expressad.exoplayer.k.r rVar2 = new com.anythink.expressad.exoplayer.k.r(bArrCopyOf);
            while (rVar2.a() >= 16) {
                rVar2.b(2);
                rVar.d(rVar2.c(14));
            }
        }
        rVar.a(bArrCopyOf, bArrCopyOf.length);
        return rVar;
    }

    private static boolean d(byte[] bArr) {
        return bArr[0] == -2 || bArr[0] == -1;
    }

    public static int a(ByteBuffer byteBuffer) {
        int i2;
        byte b2;
        int i3;
        byte b3;
        int iPosition = byteBuffer.position();
        byte b4 = byteBuffer.get(iPosition);
        if (b4 != -2) {
            if (b4 == -1) {
                i2 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                b3 = byteBuffer.get(iPosition + 7);
            } else if (b4 != 31) {
                i2 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                b2 = byteBuffer.get(iPosition + 5);
            } else {
                i2 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                b3 = byteBuffer.get(iPosition + 6);
            }
            i3 = b3 & 60;
            return (((i3 >> 2) | i2) + 1) * 32;
        }
        i2 = (byteBuffer.get(iPosition + 5) & 1) << 6;
        b2 = byteBuffer.get(iPosition + 4);
        i3 = b2 & 252;
        return (((i3 >> 2) | i2) + 1) * 32;
    }

    private static com.anythink.expressad.exoplayer.m a(byte[] bArr, String str, String str2, com.anythink.expressad.exoplayer.d.e eVar) {
        com.anythink.expressad.exoplayer.k.r rVar;
        if (bArr[0] == 127) {
            rVar = new com.anythink.expressad.exoplayer.k.r(bArr);
        } else {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            if (bArrCopyOf[0] == -2 || bArrCopyOf[0] == -1) {
                for (int i2 = 0; i2 < bArrCopyOf.length - 1; i2 += 2) {
                    byte b2 = bArrCopyOf[i2];
                    int i3 = i2 + 1;
                    bArrCopyOf[i2] = bArrCopyOf[i3];
                    bArrCopyOf[i3] = b2;
                }
            }
            rVar = new com.anythink.expressad.exoplayer.k.r(bArrCopyOf);
            if (bArrCopyOf[0] == 31) {
                com.anythink.expressad.exoplayer.k.r rVar2 = new com.anythink.expressad.exoplayer.k.r(bArrCopyOf);
                while (rVar2.a() >= 16) {
                    rVar2.b(2);
                    rVar.d(rVar2.c(14));
                }
            }
            rVar.a(bArrCopyOf, bArrCopyOf.length);
        }
        rVar.b(60);
        int i4 = f8611i[rVar.c(6)];
        int i5 = f8612j[rVar.c(4)];
        int iC = rVar.c(5);
        int[] iArr = f8613k;
        int i6 = iC >= iArr.length ? -1 : (iArr[iC] * 1000) / 2;
        rVar.b(10);
        return com.anythink.expressad.exoplayer.m.a(str, com.anythink.expressad.exoplayer.k.o.D, null, i6, i4 + (rVar.c(2) > 0 ? 1 : 0), i5, null, eVar, str2);
    }
}
