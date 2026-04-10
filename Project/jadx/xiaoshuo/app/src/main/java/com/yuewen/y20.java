package com.yuewen;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class y20 extends nw0 {
    public short[][] A;
    public short[][] B;
    public short[][] C;
    public short[][] D;
    public short[][] E;
    public short[][] F;
    public boolean G = false;
    public short[][] z;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014 A[PHI: r10
  0x0014: PHI (r10v4 int) = (r10v1 int), (r10v2 int), (r10v2 int), (r10v2 int), (r10v2 int), (r10v2 int) binds: [B:6:0x0012, B:9:0x001c, B:14:0x0028, B:16:0x002c, B:22:0x003a, B:24:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int A(byte[] r18) {
        /*
            r17 = this;
            r0 = r18
            int r1 = r0.length
            r2 = 1
            r3 = 0
            r5 = 1
            r7 = 0
            r9 = r2
            r10 = r9
            r8 = r7
        Lc:
            int r11 = r1 + (-1)
            if (r8 >= r11) goto L72
            r11 = r0[r8]
            if (r11 < 0) goto L17
        L14:
            r13 = r17
            goto L70
        L17:
            int r10 = r10 + 1
            int r12 = r8 + 1
            int r13 = r0.length
            if (r12 >= r13) goto L14
            r13 = -127(0xffffffffffffff81, float:NaN)
            r14 = -32
            if (r13 > r11) goto L28
            r13 = -97
            if (r11 <= r13) goto L2e
        L28:
            if (r14 > r11) goto L14
            r13 = -17
            if (r11 > r13) goto L14
        L2e:
            r13 = r0[r12]
            r15 = 64
            if (r15 > r13) goto L38
            r15 = 126(0x7e, float:1.77E-43)
            if (r13 <= r15) goto L3f
        L38:
            r15 = -128(0xffffffffffffff80, float:NaN)
            if (r15 > r13) goto L14
            r15 = -4
            if (r13 > r15) goto L14
        L3f:
            int r9 = r9 + 1
            r15 = 500(0x1f4, double:2.47E-321)
            long r5 = r5 + r15
            int r11 = r11 + 256
            int r13 = r13 + 256
            r8 = 159(0x9f, float:2.23E-43)
            if (r13 >= r8) goto L4e
            r8 = r2
            goto L4f
        L4e:
            r8 = r7
        L4f:
            r13 = 160(0xa0, float:2.24E-43)
            if (r11 >= r13) goto L56
            int r11 = r11 + (-112)
            goto L58
        L56:
            int r11 = r11 + (-176)
        L58:
            int r11 = r11 << r2
            int r11 = r11 - r8
            int r11 = r11 + r14
            r13 = r17
            short[][] r8 = r13.F
            int r14 = r8.length
            if (r11 >= r14) goto L6f
            r8 = r8[r11]
            int r11 = r8.length
            r14 = 32
            if (r14 >= r11) goto L6f
            short r8 = r8[r14]
            if (r8 == 0) goto L6f
            long r14 = (long) r8
            long r3 = r3 + r14
        L6f:
            r8 = r12
        L70:
            int r8 = r8 + r2
            goto Lc
        L72:
            r13 = r17
            float r0 = (float) r9
            float r1 = (float) r10
            float r0 = r0 / r1
            r1 = 1112014848(0x42480000, float:50.0)
            float r0 = r0 * r1
            float r3 = (float) r3
            float r4 = (float) r5
            float r3 = r3 / r4
            float r3 = r3 * r1
            float r0 = r0 + r3
            int r0 = (int) r0
            int r0 = r0 - r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.y20.A(byte[]):int");
    }

    public int B(byte[] bArr) {
        if (bArr.length > 1 && -2 == bArr[0] && -1 == bArr[1]) {
            return 100;
        }
        return (-1 == bArr[0] && -2 == bArr[1]) ? 100 : 0;
    }

    public int C(byte[] bArr) {
        int i;
        byte b2;
        byte b3;
        int i2;
        byte b4;
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            byte b5 = bArr[i3];
            if ((b5 & 127) == b5) {
                i4++;
            } else if (-64 <= b5 && b5 <= -33 && (i2 = i3 + 1) < length && -128 <= (b4 = bArr[i2]) && b4 <= -65) {
                i5 += 2;
                i3 = i2;
            } else if (-32 <= b5 && b5 <= -17 && (i = i3 + 2) < length && -128 <= (b2 = bArr[i3 + 1]) && b2 <= -65 && -128 <= (b3 = bArr[i]) && b3 <= -65) {
                i5 += 3;
                i3 = i;
            }
            i3++;
        }
        if (i4 == length) {
            return 0;
        }
        int i6 = (int) ((i5 / (length - i4)) * 100.0f);
        if (i6 > 98) {
            return i6;
        }
        if (i6 <= 95 || i5 <= 30) {
            return 0;
        }
        return i6;
    }

    public void D() {
        for (int i = 0; i < 94; i++) {
            Arrays.fill(this.B[i], (short) 0);
        }
    }

    public void E() {
        for (int i = 0; i < 126; i++) {
            Arrays.fill(this.C[i], (short) 0);
        }
    }

    public void F() {
        for (int i = 0; i < 94; i++) {
            Arrays.fill(this.D[i], (short) 0);
        }
    }

    public void G() {
        for (int i = 0; i < 94; i++) {
            Arrays.fill(this.z[i], (short) 0);
        }
    }

    public void H() {
        for (int i = 0; i < 126; i++) {
            Arrays.fill(this.A[i], (short) 0);
        }
    }

    public void I() {
        for (int i = 0; i < 94; i++) {
            Arrays.fill(this.F[i], (short) 0);
        }
    }

    public void J() {
        for (int i = 0; i < 94; i++) {
            Arrays.fill(this.E[i], (short) 0);
        }
    }

    public int e(byte[] bArr) {
        int i = 75;
        for (byte b2 : bArr) {
            if (b2 < 0 || b2 == 27) {
                i -= 5;
            }
            if (i <= 0) {
                return 0;
            }
        }
        return i;
    }

    public int f(byte[] bArr) {
        byte b2;
        long j;
        int length = bArr.length;
        long j2 = 0;
        long j3 = 1;
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (i < length - 1) {
            byte b3 = bArr[i];
            if (b3 < 0) {
                i3++;
                if (-95 <= b3 && b3 <= -7 && ((64 <= (b2 = bArr[i + 1]) && b2 <= 126) || (-95 <= b2 && b2 <= -2))) {
                    i2++;
                    j3 += 500;
                    int i4 = (b3 + 256) - 161;
                    short s = this.B[i4][(64 > b2 || b2 > 126) ? (b2 + 256) - 97 : b2 - 64];
                    if (s != 0) {
                        j = s;
                    } else if (3 <= i4 && i4 <= 37) {
                        j = 200;
                    }
                    j2 += j;
                }
                i++;
            }
            i++;
        }
        return (int) (((i2 / i3) * 50.0f) + ((j2 / j3) * 50.0f));
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x007e, code lost:
    
        if (r3 != 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int g(byte[] r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            int r2 = r1.length
            r3 = 1
            r4 = 0
            r6 = 1
            r8 = 0
            r9 = r3
            r10 = r9
        Ld:
            int r11 = r2 + (-1)
            if (r8 >= r11) goto L86
            r11 = r1[r8]
            r12 = 128(0x80, float:1.8E-43)
            if (r11 < r12) goto L19
            goto L84
        L19:
            int r10 = r10 + 1
            r15 = 254(0xfe, float:3.56E-43)
            r3 = 161(0xa1, float:2.26E-43)
            r12 = 126(0x7e, float:1.77E-43)
            r13 = 64
            if (r3 > r11) goto L5b
            r14 = 249(0xf9, float:3.49E-43)
            if (r11 > r14) goto L5b
            int r14 = r8 + 1
            r14 = r1[r14]
            if (r13 > r14) goto L31
            if (r14 <= r12) goto L35
        L31:
            if (r3 > r14) goto L5b
            if (r14 > r15) goto L5b
        L35:
            int r9 = r9 + 1
            r16 = 500(0x1f4, double:2.47E-321)
            long r6 = r6 + r16
            int r11 = r11 + (-161)
            if (r13 > r14) goto L44
            if (r14 > r12) goto L44
            int r14 = r14 + (-64)
            goto L46
        L44:
            int r14 = r14 + (-97)
        L46:
            short[][] r3 = r0.B
            r3 = r3[r11]
            short r3 = r3[r14]
            if (r3 == 0) goto L51
        L4e:
            long r11 = (long) r3
        L4f:
            long r4 = r4 + r11
            goto L81
        L51:
            r3 = 3
            if (r3 > r11) goto L81
            r3 = 37
            if (r11 >= r3) goto L81
            r11 = 200(0xc8, double:9.9E-322)
            goto L4f
        L5b:
            r3 = 129(0x81, float:1.81E-43)
            if (r3 > r11) goto L81
            if (r11 > r15) goto L81
            int r3 = r8 + 1
            r3 = r1[r3]
            if (r13 > r3) goto L69
            if (r3 <= r12) goto L6f
        L69:
            r14 = 128(0x80, float:1.8E-43)
            if (r14 > r3) goto L81
            if (r3 > r15) goto L81
        L6f:
            int r9 = r9 + 1
            r14 = 500(0x1f4, double:2.47E-321)
            long r6 = r6 + r14
            int r11 = r11 + (-129)
            int r3 = r3 + (-64)
            short[][] r12 = r0.C
            r11 = r12[r11]
            short r3 = r11[r3]
            if (r3 == 0) goto L81
            goto L4e
        L81:
            int r8 = r8 + 1
            r3 = 1
        L84:
            int r8 = r8 + r3
            goto Ld
        L86:
            float r1 = (float) r9
            float r2 = (float) r10
            float r1 = r1 / r2
            r2 = 1112014848(0x42480000, float:50.0)
            float r1 = r1 * r2
            float r3 = (float) r4
            float r4 = (float) r6
            float r3 = r3 / r4
            float r3 = r3 * r2
            float r1 = r1 + r3
            int r1 = (int) r1
            r2 = 1
            int r1 = r1 - r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.y20.g(byte[]):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005b A[PHI: r5 r8
  0x005b: PHI (r5v2 long) = (r5v1 long), (r5v1 long), (r5v1 long), (r5v1 long), (r5v4 long), (r5v4 long), (r5v4 long), (r5v4 long) binds: [B:9:0x001a, B:11:0x001d, B:20:0x0033, B:21:0x0035, B:23:0x003e, B:24:0x0040, B:25:0x0042, B:26:0x0044] A[DONT_GENERATE, DONT_INLINE]
  0x005b: PHI (r8v2 int) = (r8v1 int), (r8v1 int), (r8v1 int), (r8v1 int), (r8v4 int), (r8v4 int), (r8v4 int), (r8v4 int) binds: [B:9:0x001a, B:11:0x001d, B:20:0x0033, B:21:0x0035, B:23:0x003e, B:24:0x0040, B:25:0x0042, B:26:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int h(byte[] r17) {
        /*
            r16 = this;
            r0 = r17
            int r1 = r0.length
            r2 = 1
            r3 = 0
            r5 = 1
            r7 = 0
            r8 = r2
            r9 = r8
        Lb:
            int r10 = r1 + (-1)
            if (r7 >= r10) goto L61
            r10 = r0[r7]
            if (r10 < 0) goto L16
            r11 = r16
            goto L5f
        L16:
            int r9 = r9 + 1
            r11 = -127(0xffffffffffffff81, float:NaN)
            if (r11 > r10) goto L5b
            r12 = -2
            if (r10 > r12) goto L5b
            int r13 = r7 + 1
            r13 = r0[r13]
            r14 = 65
            if (r14 > r13) goto L2b
            r14 = 90
            if (r13 <= r14) goto L37
        L2b:
            r14 = 97
            if (r14 > r13) goto L33
            r14 = 122(0x7a, float:1.71E-43)
            if (r13 <= r14) goto L37
        L33:
            if (r11 > r13) goto L5b
            if (r13 > r12) goto L5b
        L37:
            int r8 = r8 + 1
            r14 = 500(0x1f4, double:2.47E-321)
            long r5 = r5 + r14
            r11 = -95
            if (r11 > r10) goto L5b
            if (r10 > r12) goto L5b
            if (r11 > r13) goto L5b
            if (r13 > r12) goto L5b
            int r10 = r10 + 256
            int r10 = r10 + (-161)
            int r13 = r13 + 256
            int r13 = r13 + (-161)
            r11 = r16
            short[][] r12 = r11.E
            r10 = r12[r10]
            short r10 = r10[r13]
            if (r10 == 0) goto L5d
            long r12 = (long) r10
            long r3 = r3 + r12
            goto L5d
        L5b:
            r11 = r16
        L5d:
            int r7 = r7 + 1
        L5f:
            int r7 = r7 + r2
            goto Lb
        L61:
            r11 = r16
            float r0 = (float) r8
            float r1 = (float) r9
            float r0 = r0 / r1
            r1 = 1112014848(0x42480000, float:50.0)
            float r0 = r0 * r1
            float r2 = (float) r3
            float r3 = (float) r5
            float r2 = r2 / r3
            float r2 = r2 * r1
            float r0 = r0 + r2
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.y20.h(byte[]):int");
    }

    public int i(byte[] bArr) {
        int[] iArr = {0, o(bArr), m(bArr), p(bArr), f(bArr), l(bArr), C(bArr), 0, 0, x(bArr), 0, 0, k(bArr), h(bArr), z(bArr), 0, A(bArr), j(bArr), y(bArr), e(bArr), 0};
        Arrays.fill(iArr, 0);
        short[][] sArr = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 126, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED);
        this.z = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 94, 94);
        G();
        t(this.z);
        this.A = sArr;
        H();
        u(this.A);
        this.B = sArr;
        D();
        t(sArr);
        this.D = sArr;
        F();
        s(sArr);
        this.D = sArr;
        F();
        s(sArr);
        this.E = sArr;
        J();
        t(sArr);
        this.F = sArr;
        t(sArr);
        this.F = sArr;
        t(sArr);
        int i = 20;
        int i2 = 0;
        for (int i3 = 0; i3 < 21; i3++) {
            int i4 = iArr[i3];
            if (i4 > i2) {
                i = i3;
                i2 = i4;
            }
        }
        if (i2 <= 50) {
            return 20;
        }
        return i;
    }

    public int j(byte[] bArr) {
        byte b2;
        int length = bArr.length;
        long j = 1;
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        long j2 = 0;
        while (i < length - 1) {
            byte b3 = bArr[i];
            if (b3 < 0) {
                i3++;
                if (-95 <= b3 && b3 <= -2 && -95 <= (b2 = bArr[i + 1]) && b2 <= -2) {
                    i2++;
                    j += 500;
                    int i4 = (b3 + 256) - 161;
                    short s = this.F[i4][(b2 + 256) - 161];
                    if (s != 0) {
                        j2 += (long) s;
                    } else if (15 <= i4 && i4 < 55) {
                        j2 += 0;
                    }
                }
                i++;
            }
            i++;
        }
        return (int) (((i2 / i3) * 50.0f) + ((j2 / j) * 50.0f));
    }

    public int k(byte[] bArr) {
        byte b2;
        int length = bArr.length;
        long j = 1;
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        long j2 = 0;
        while (i < length - 1) {
            byte b3 = bArr[i];
            if (b3 < 0) {
                i3++;
                if (-95 <= b3 && b3 <= -2 && -95 <= (b2 = bArr[i + 1]) && b2 <= -2) {
                    i2++;
                    j += 500;
                    int i4 = (b3 + 256) - 161;
                    short s = this.E[i4][(b2 + 256) - 161];
                    if (s != 0) {
                        j2 += (long) s;
                    } else if (15 <= i4 && i4 < 55) {
                        j2 += 0;
                    }
                }
                i++;
            }
            i++;
        }
        return (int) (((i2 / i3) * 50.0f) + ((j2 / j) * 50.0f));
    }

    public int l(byte[] bArr) {
        byte b2;
        long j;
        byte b3;
        byte b4;
        byte b5;
        int length = bArr.length;
        long j2 = 0;
        long j3 = 1;
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (i < length - 1) {
            byte b6 = bArr[i];
            if (b6 < 0) {
                i3++;
                int i4 = i + 3;
                if (i4 < length && -114 == b6 && -95 <= (b3 = bArr[i + 1]) && b3 <= -80 && -95 <= (b4 = bArr[i + 2]) && b4 <= -2 && -95 <= (b5 = bArr[i4]) && b5 <= -2) {
                    i2++;
                } else if (-95 <= b6 && b6 <= -2 && -95 <= (b2 = bArr[(i4 = i + 1)]) && b2 <= -2) {
                    i2++;
                    j3 += 500;
                    int i5 = (b6 + 256) - 161;
                    short s = this.D[i5][(b2 + 256) - 161];
                    if (s != 0) {
                        j = s;
                    } else if (35 <= i5 && i5 <= 92) {
                        j = 150;
                    }
                    j2 += j;
                }
                i = i4;
            }
            i++;
        }
        return (int) (((i2 / i3) * 50.0f) + ((j2 / j3) * 50.0f));
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0084, code lost:
    
        if (r3 != 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m(byte[] r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            int r2 = r1.length
            r4 = 0
            r6 = 1
            r8 = 0
            r9 = 1
            r10 = 1
        Lc:
            int r11 = r2 + (-1)
            if (r8 >= r11) goto Lb6
            r11 = r1[r8]
            if (r11 < 0) goto L17
        L14:
            r3 = 1
            goto Lb3
        L17:
            int r10 = r10 + 1
            r12 = 500(0x1f4, double:2.47E-321)
            r14 = -95
            r15 = -2
            if (r14 > r11) goto L50
            r3 = -9
            if (r11 > r3) goto L50
            int r3 = r8 + 1
            if (r3 >= r2) goto L50
            r3 = r1[r3]
            if (r14 > r3) goto L50
            if (r3 > r15) goto L50
            int r9 = r9 + 1
            long r6 = r6 + r12
            int r11 = r11 + 256
            int r11 = r11 + (-161)
            int r3 = r3 + 256
            int r3 = r3 + (-161)
            short[][] r12 = r0.z
            r12 = r12[r11]
            short r3 = r12[r3]
            if (r3 == 0) goto L45
        L41:
            long r11 = (long) r3
        L42:
            long r4 = r4 + r11
            goto Laf
        L45:
            r3 = 15
            if (r3 > r11) goto Laf
            r3 = 55
            if (r11 >= r3) goto Laf
            r11 = 200(0xc8, double:9.9E-322)
            goto L42
        L50:
            r3 = -127(0xffffffffffffff81, float:NaN)
            if (r3 > r11) goto L89
            if (r11 > r15) goto L89
            int r14 = r8 + 1
            if (r14 >= r2) goto L89
            r14 = r1[r14]
            r3 = 126(0x7e, float:1.77E-43)
            r12 = 64
            r13 = -128(0xffffffffffffff80, float:NaN)
            if (r13 > r14) goto L66
            if (r14 <= r15) goto L6a
        L66:
            if (r12 > r14) goto L87
            if (r14 > r3) goto L87
        L6a:
            int r9 = r9 + 1
            r16 = 500(0x1f4, double:2.47E-321)
            long r6 = r6 + r16
            int r11 = r11 + 256
            int r11 = r11 + (-129)
            if (r12 > r14) goto L7b
            if (r14 > r3) goto L7b
            int r14 = r14 + (-64)
            goto L7e
        L7b:
            int r14 = r14 + 256
            int r14 = r14 - r12
        L7e:
            short[][] r3 = r0.A
            r3 = r3[r11]
            short r3 = r3[r14]
            if (r3 == 0) goto Laf
            goto L41
        L87:
            r3 = -127(0xffffffffffffff81, float:NaN)
        L89:
            if (r3 > r11) goto Laf
            if (r11 > r15) goto Laf
            int r3 = r8 + 3
            if (r3 >= r2) goto Laf
            int r11 = r8 + 1
            r11 = r1[r11]
            r12 = 48
            if (r12 > r11) goto Laf
            r13 = 57
            if (r11 > r13) goto Laf
            int r11 = r8 + 2
            r11 = r1[r11]
            r14 = -127(0xffffffffffffff81, float:NaN)
            if (r14 > r11) goto Laf
            if (r11 > r15) goto Laf
            r3 = r1[r3]
            if (r12 > r3) goto Laf
            if (r3 > r13) goto Laf
            int r9 = r9 + 1
        Laf:
            int r8 = r8 + 1
            goto L14
        Lb3:
            int r8 = r8 + r3
            goto Lc
        Lb6:
            float r1 = (float) r9
            float r2 = (float) r10
            float r1 = r1 / r2
            r2 = 1112014848(0x42480000, float:50.0)
            float r1 = r1 * r2
            float r3 = (float) r4
            float r4 = (float) r6
            float r3 = r3 / r4
            float r3 = r3 * r2
            float r1 = r1 + r3
            int r1 = (int) r1
            r2 = 1
            int r1 = r1 - r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.y20.m(byte[]):int");
    }

    public int n(byte[] bArr) {
        byte b2;
        long j;
        int length = bArr.length;
        long j2 = 0;
        long j3 = 1;
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (i < length - 1) {
            byte b3 = bArr[i];
            if (b3 < 0) {
                i3++;
                if (-95 <= b3 && b3 <= -9 && -95 <= (b2 = bArr[i + 1]) && b2 <= -2) {
                    i2++;
                    j3 += 500;
                    int i4 = (b3 + 256) - 161;
                    short s = this.z[i4][(b2 + 256) - 161];
                    if (s != 0) {
                        j = s;
                    } else if (15 <= i4 && i4 < 55) {
                        j = 200;
                    }
                    j2 += j;
                }
                i++;
            }
            i++;
        }
        return (int) (((i2 / i3) * 50.0f) + ((j2 / j3) * 50.0f));
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x007f, code lost:
    
        if (r3 != 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int o(byte[] r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            int r2 = r1.length
            r3 = 1
            r4 = 0
            r6 = 1
            r8 = 0
            r9 = r3
            r10 = r9
        Ld:
            int r11 = r2 + (-1)
            if (r8 >= r11) goto L87
            r11 = r1[r8]
            if (r11 < 0) goto L17
            goto L85
        L17:
            int r10 = r10 + 1
            r12 = 500(0x1f4, double:2.47E-321)
            r14 = -95
            r15 = -2
            if (r14 > r11) goto L4d
            r3 = -9
            if (r11 > r3) goto L4d
            int r3 = r8 + 1
            r3 = r1[r3]
            if (r14 > r3) goto L4d
            if (r3 > r15) goto L4d
            int r9 = r9 + 1
            long r6 = r6 + r12
            int r11 = r11 + 256
            int r11 = r11 + (-161)
            int r3 = r3 + 256
            int r3 = r3 + (-161)
            short[][] r12 = r0.z
            r12 = r12[r11]
            short r3 = r12[r3]
            if (r3 == 0) goto L42
        L3f:
            long r11 = (long) r3
        L40:
            long r4 = r4 + r11
            goto L82
        L42:
            r3 = 15
            if (r3 > r11) goto L82
            r3 = 55
            if (r11 >= r3) goto L82
            r11 = 200(0xc8, double:9.9E-322)
            goto L40
        L4d:
            r3 = -127(0xffffffffffffff81, float:NaN)
            if (r3 > r11) goto L82
            if (r11 > r15) goto L82
            int r3 = r8 + 1
            r3 = r1[r3]
            r14 = 126(0x7e, float:1.77E-43)
            r12 = 64
            r13 = -128(0xffffffffffffff80, float:NaN)
            if (r13 > r3) goto L61
            if (r3 <= r15) goto L65
        L61:
            if (r12 > r3) goto L82
            if (r3 > r14) goto L82
        L65:
            int r9 = r9 + 1
            r16 = 500(0x1f4, double:2.47E-321)
            long r6 = r6 + r16
            int r11 = r11 + 256
            int r11 = r11 + (-129)
            if (r12 > r3) goto L76
            if (r3 > r14) goto L76
            int r3 = r3 + (-64)
            goto L79
        L76:
            int r3 = r3 + 256
            int r3 = r3 - r12
        L79:
            short[][] r12 = r0.A
            r11 = r12[r11]
            short r3 = r11[r3]
            if (r3 == 0) goto L82
            goto L3f
        L82:
            int r8 = r8 + 1
            r3 = 1
        L85:
            int r8 = r8 + r3
            goto Ld
        L87:
            float r1 = (float) r9
            float r2 = (float) r10
            float r1 = r1 / r2
            r2 = 1112014848(0x42480000, float:50.0)
            float r1 = r1 * r2
            float r3 = (float) r4
            float r4 = (float) r6
            float r3 = r3 / r4
            float r3 = r3 * r2
            float r1 = r1 + r3
            int r1 = (int) r1
            r2 = 1
            int r1 = r1 - r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.y20.o(byte[]):int");
    }

    public int p(byte[] bArr) {
        byte b2;
        short s;
        long j;
        byte b3;
        int i = 1;
        int length = bArr.length - 1;
        long j2 = 0;
        long j3 = 1;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b4 = 126;
            if (bArr[i2] == 126) {
                int i4 = i2 + 1;
                byte b5 = bArr[i4];
                byte b6 = 125;
                if (b5 == 123) {
                    i3++;
                    i2 += 2;
                    while (i2 < length) {
                        byte b7 = bArr[i2];
                        if (b7 == 10 || b7 == 13) {
                            break;
                        }
                        if (b7 == b4) {
                            int i5 = i2 + 1;
                            if (bArr[i5] == b6) {
                                i2 = i5;
                                break;
                            }
                        }
                        if (33 > b7 || b7 > 119 || 33 > (b3 = bArr[i2 + 1]) || b3 > 119) {
                            if (161 <= b7 && b7 <= 247 && 161 <= (b2 = bArr[i2 + 1]) && b2 <= 247) {
                                int i6 = (b7 + 256) - 161;
                                j3 += 500;
                                s = this.z[i6][(b2 + 256) - 161];
                                if (s == 0) {
                                    if (15 > i6 || i6 >= 55) {
                                    }
                                    j = 200;
                                }
                                j = s;
                            }
                            i2 += 2;
                            i = 1;
                            b4 = 126;
                            b6 = 125;
                        } else {
                            int i7 = b7 - 33;
                            j3 += 500;
                            s = this.z[i7][b3 - 33];
                            if (s == 0) {
                                if (15 > i7 || i7 >= 55) {
                                    i2 += 2;
                                    i = 1;
                                    b4 = 126;
                                    b6 = 125;
                                }
                                j = 200;
                            }
                            j = s;
                        }
                        j2 += j;
                        i2 += 2;
                        i = 1;
                        b4 = 126;
                        b6 = 125;
                    }
                } else if (b5 == 125 || b5 == 126) {
                    i2 = i4;
                }
                i = 1;
            } else {
                i = 1;
            }
            i2 += i;
        }
        return (int) ((i3 > 4 ? 50.0f : i3 > i ? 41.0f : i3 > 0 ? 39.0f : 0.0f) + ((j2 / j3) * 50.0f));
    }

    public void q(int[][] iArr) {
        int[] iArr2 = iArr[9];
        iArr2[89] = 600;
        int[] iArr3 = iArr[11];
        iArr3[15] = 599;
        int[] iArr4 = iArr[3];
        iArr4[66] = 598;
        int[] iArr5 = iArr[6];
        iArr5[121] = 597;
        iArr4[0] = 596;
        int[] iArr6 = iArr[5];
        iArr6[82] = 595;
        iArr4[42] = 594;
        iArr6[34] = 593;
        iArr4[8] = 592;
        iArr4[6] = 591;
        iArr4[67] = 590;
        int[] iArr7 = iArr[7];
        iArr7[139] = 589;
        int[] iArr8 = iArr[23];
        iArr8[137] = 588;
        int[] iArr9 = iArr[12];
        iArr9[46] = 587;
        int[] iArr10 = iArr[4];
        iArr10[8] = 586;
        iArr10[41] = 585;
        int[] iArr11 = iArr[18];
        iArr11[47] = 584;
        iArr9[114] = 583;
        iArr5[1] = 582;
        int[] iArr12 = iArr[22];
        iArr12[60] = 581;
        iArr6[46] = 580;
        iArr3[79] = 579;
        iArr4[23] = 578;
        iArr7[114] = 577;
        int[] iArr13 = iArr[29];
        iArr13[102] = 576;
        int[] iArr14 = iArr[19];
        iArr14[14] = 575;
        iArr10[133] = 574;
        iArr4[29] = 573;
        iArr10[109] = 572;
        int[] iArr15 = iArr[14];
        iArr15[127] = 571;
        iArr6[48] = 570;
        int[] iArr16 = iArr[13];
        iArr16[104] = 569;
        iArr4[132] = 568;
        int[] iArr17 = iArr[26];
        iArr17[64] = 567;
        iArr7[19] = 566;
        iArr10[12] = 565;
        iArr3[124] = 564;
        iArr7[89] = 563;
        int[] iArr18 = iArr[15];
        iArr18[124] = 562;
        iArr10[108] = 561;
        iArr14[66] = 560;
        iArr4[21] = 559;
        int[] iArr19 = iArr[24];
        iArr19[12] = 558;
        int[] iArr20 = iArr[28];
        iArr20[111] = 557;
        iArr9[107] = 556;
        iArr4[112] = 555;
        int[] iArr21 = iArr[8];
        iArr21[113] = 554;
        iArr6[40] = 553;
        iArr17[145] = 552;
        iArr4[48] = 551;
        iArr4[70] = 550;
        iArr12[17] = 549;
        int[] iArr22 = iArr[16];
        iArr22[47] = 548;
        iArr4[53] = 547;
        iArr10[24] = 546;
        int[] iArr23 = iArr[32];
        iArr23[120] = 545;
        iArr19[49] = 544;
        iArr19[142] = 543;
        iArr11[66] = 542;
        iArr13[150] = 541;
        iArr6[122] = 540;
        iArr6[114] = 539;
        iArr4[44] = 538;
        int[] iArr24 = iArr[10];
        iArr24[128] = 537;
        iArr18[20] = 536;
        iArr16[33] = 535;
        iArr15[87] = 534;
        iArr4[126] = 533;
        iArr10[53] = 532;
        iArr10[40] = 531;
        iArr2[93] = 530;
        iArr18[137] = 529;
        iArr24[123] = 528;
        iArr10[56] = 527;
        iArr6[71] = 526;
        iArr24[8] = 525;
        iArr6[16] = 524;
        iArr6[146] = 523;
        iArr11[88] = 522;
        iArr19[4] = 521;
        int[] iArr25 = iArr[20];
        iArr25[47] = 520;
        iArr6[33] = 519;
        iArr2[43] = 518;
        iArr25[12] = 517;
        iArr25[13] = 516;
        iArr6[156] = 515;
        iArr12[140] = 514;
        iArr21[146] = 513;
        int[] iArr26 = iArr[21];
        iArr26[123] = 512;
        iArr10[90] = 511;
        iArr6[62] = 510;
        int[] iArr27 = iArr[17];
        iArr27[59] = 509;
        iArr24[37] = 508;
        iArr11[107] = 507;
        iArr15[53] = 506;
        iArr12[51] = 505;
        iArr21[13] = 504;
        iArr6[29] = 503;
        iArr2[7] = 502;
        iArr12[14] = 501;
        iArr21[55] = 500;
        int[] iArr28 = iArr[33];
        iArr28[9] = 499;
        iArr22[64] = 498;
        iArr7[131] = 497;
        int[] iArr29 = iArr[34];
        iArr29[4] = 496;
        iArr7[101] = 495;
        iArr3[139] = 494;
        iArr4[135] = 493;
        iArr7[102] = 492;
        iArr27[13] = 491;
        iArr4[20] = 490;
        int[] iArr30 = iArr[27];
        iArr30[106] = 489;
        iArr6[88] = 488;
        iArr5[33] = 487;
        iArr6[139] = 486;
        iArr5[0] = 485;
        iArr27[58] = 484;
        iArr6[133] = 483;
        iArr2[107] = 482;
        iArr8[39] = 481;
        iArr6[23] = 480;
        iArr4[79] = 479;
        iArr23[97] = 478;
        iArr4[136] = 477;
        iArr10[94] = 476;
        iArr26[61] = 475;
        iArr8[123] = 474;
        iArr17[16] = 473;
        iArr19[137] = 472;
        iArr12[18] = 471;
        iArr6[1] = 470;
        iArr25[119] = 469;
        iArr4[7] = 468;
        iArr24[79] = 467;
        iArr18[105] = 466;
        iArr4[144] = 465;
        iArr9[80] = 464;
        iArr18[73] = 463;
        iArr4[19] = 462;
        iArr21[109] = 461;
        iArr4[15] = 460;
        int[] iArr31 = iArr[31];
        iArr31[82] = 459;
        iArr4[43] = 458;
        int[] iArr32 = iArr[25];
        iArr32[119] = 457;
        iArr22[111] = 456;
        iArr7[77] = 455;
        iArr4[95] = 454;
        iArr19[82] = 453;
        iArr7[52] = 452;
        iArr2[151] = 451;
        iArr4[129] = 450;
        iArr6[87] = 449;
        iArr4[55] = 448;
        iArr21[153] = 447;
        iArr10[83] = 446;
        iArr4[114] = 445;
        iArr8[147] = 444;
        iArr18[31] = 443;
        iArr4[54] = 442;
        iArr3[122] = 441;
        iArr10[4] = 440;
        iArr29[149] = 439;
        iArr4[17] = 438;
        iArr26[64] = 437;
        iArr17[144] = 436;
        iArr10[62] = 435;
        iArr21[15] = 434;
        int[] iArr33 = iArr[35];
        iArr33[80] = 433;
        iArr7[110] = 432;
        iArr8[114] = 431;
        iArr4[108] = 430;
        iArr4[62] = 429;
        iArr26[41] = 428;
        iArr18[99] = 427;
        iArr6[47] = 426;
        iArr10[96] = 425;
        iArr25[122] = 424;
        iArr6[21] = 423;
        iArr10[157] = 422;
        iArr22[14] = 421;
        iArr4[117] = 420;
        iArr7[129] = 419;
        iArr10[27] = 418;
        iArr6[30] = 417;
        iArr12[16] = 416;
        iArr6[64] = 415;
        iArr27[99] = 414;
        iArr27[57] = 413;
        iArr21[105] = 412;
        iArr6[112] = 411;
        iArr25[59] = 410;
        iArr5[129] = 409;
        iArr11[17] = 408;
        iArr4[92] = 407;
        iArr20[118] = 406;
        iArr4[109] = 405;
        iArr31[51] = 404;
        iArr16[116] = 403;
        iArr5[15] = 402;
        int[] iArr34 = iArr[36];
        iArr34[136] = 401;
        iArr9[74] = 400;
        iArr25[88] = 399;
        iArr34[68] = 398;
        iArr4[147] = 397;
        iArr18[84] = 396;
        iArr22[32] = 395;
        iArr22[58] = 394;
        iArr7[66] = 393;
        iArr8[107] = 392;
        iArr2[6] = 391;
        iArr9[86] = 390;
        iArr8[112] = 389;
        iArr[37][23] = 388;
        iArr4[138] = 387;
        iArr25[68] = 386;
        iArr18[116] = 385;
        iArr11[64] = 384;
        iArr9[139] = 383;
        iArr3[155] = 382;
        iArr10[156] = 381;
        iArr9[84] = 380;
        iArr11[49] = 379;
        iArr32[125] = 378;
        iArr32[147] = 377;
        iArr18[110] = 376;
        iArr14[96] = 375;
        int[] iArr35 = iArr[30];
        iArr35[152] = 374;
        iArr5[31] = 373;
        iArr30[117] = 372;
        iArr4[10] = 371;
        iArr5[131] = 370;
        iArr16[112] = 369;
        iArr34[156] = 368;
        iArr10[60] = 367;
        iArr18[121] = 366;
        iArr10[112] = 365;
        iArr35[142] = 364;
        iArr8[154] = 363;
        iArr30[101] = 362;
        iArr2[140] = 361;
        iArr4[89] = 360;
        iArr11[148] = 359;
        iArr10[69] = 358;
        iArr22[49] = 357;
        iArr5[117] = 356;
        iArr34[55] = 355;
        iArr6[123] = 354;
        iArr10[126] = 353;
        iArr10[119] = 352;
        iArr2[95] = 351;
        iArr6[24] = 350;
        iArr22[133] = 349;
        iArr24[134] = 348;
        iArr17[59] = 347;
        iArr5[41] = 346;
        iArr5[146] = 345;
        iArr14[24] = 344;
        iArr6[113] = 343;
        iArr24[118] = 342;
        iArr29[151] = 341;
        iArr2[72] = 340;
        iArr31[25] = 339;
        iArr11[126] = 338;
        iArr11[28] = 337;
        iArr10[153] = 336;
        iArr4[84] = 335;
        iArr26[18] = 334;
        iArr32[129] = 333;
        iArr5[107] = 332;
        iArr9[25] = 331;
        iArr27[109] = 330;
        iArr7[76] = 329;
        iArr18[15] = 328;
        iArr10[14] = 327;
        iArr8[88] = 326;
        iArr11[2] = 325;
        iArr5[88] = 324;
        iArr22[84] = 323;
        iArr9[48] = 322;
        iArr7[68] = 321;
        iArr6[50] = 320;
        iArr16[54] = 319;
        iArr7[98] = 318;
        iArr3[6] = 317;
        iArr2[80] = 316;
        iArr22[41] = 315;
        iArr7[43] = 314;
        iArr20[117] = 313;
        iArr4[51] = 312;
        iArr7[3] = 311;
        iArr25[81] = 310;
        iArr10[2] = 309;
        iArr3[16] = 308;
        iArr24[4] = 307;
        iArr24[119] = 306;
        iArr5[142] = 305;
        iArr11[51] = 304;
        iArr21[144] = 303;
        iArr24[65] = 302;
        iArr3[64] = 301;
        iArr3[130] = 300;
        iArr2[92] = 299;
        iArr11[29] = 298;
        iArr11[78] = 297;
        iArr11[151] = 296;
        iArr28[127] = 295;
        iArr33[113] = 294;
        iArr24[155] = 293;
        iArr4[76] = 292;
        iArr34[123] = 291;
        iArr16[143] = 290;
        iArr6[135] = 289;
        iArr8[116] = 288;
        iArr5[101] = 287;
        iArr15[74] = 286;
        iArr7[153] = 285;
        iArr4[101] = 284;
        iArr2[74] = 283;
        iArr4[156] = 282;
        iArr10[147] = 281;
        iArr2[12] = 280;
        iArr11[133] = 279;
        iArr10[0] = 278;
        iArr7[155] = 277;
        iArr2[144] = 276;
        iArr8[49] = 275;
        iArr6[89] = 274;
        iArr24[11] = 273;
        iArr4[110] = 272;
        iArr4[40] = 271;
        iArr13[115] = 270;
        iArr2[100] = 269;
        iArr26[67] = 268;
        iArr8[145] = 267;
        iArr24[47] = 266;
        iArr10[31] = 265;
        iArr10[81] = 264;
        iArr12[62] = 263;
        iArr10[28] = 262;
        iArr30[39] = 261;
        iArr30[54] = 260;
        iArr23[46] = 259;
        iArr10[76] = 258;
        iArr17[15] = 257;
        iArr9[154] = 256;
        iArr2[150] = 255;
        iArr18[17] = 254;
        iArr6[129] = 253;
        iArr24[40] = 252;
        iArr16[37] = 251;
        iArr31[104] = 250;
        iArr4[152] = 249;
        iArr6[22] = 248;
        iArr21[48] = 247;
        iArr10[74] = 246;
        iArr5[17] = 245;
        iArr35[82] = 244;
        iArr10[116] = 243;
        iArr22[42] = 242;
        iArr6[55] = 241;
        iArr10[64] = 240;
        iArr15[19] = 239;
        iArr33[82] = 238;
        iArr35[139] = 237;
        iArr17[152] = 236;
        iArr23[32] = 235;
        iArr26[102] = 234;
        iArr24[131] = 233;
        iArr2[128] = 232;
        iArr4[87] = 231;
        iArr10[51] = 230;
        iArr24[15] = 229;
        iArr10[150] = 228;
        iArr7[4] = 227;
        iArr7[51] = 226;
        iArr7[157] = 225;
        iArr10[146] = 224;
        iArr10[91] = 223;
        iArr7[13] = 222;
        iArr27[116] = 221;
        iArr8[21] = 220;
        iArr6[106] = 219;
        iArr15[100] = 218;
        iArr24[152] = 217;
        iArr15[89] = 216;
        iArr5[138] = 215;
        iArr9[157] = 214;
        iArr24[102] = 213;
        iArr14[94] = 212;
        iArr7[74] = 211;
        iArr11[128] = 210;
        iArr30[111] = 209;
        iArr3[57] = 208;
        iArr4[131] = 207;
        iArr35[23] = 206;
        iArr35[126] = 205;
        iArr10[36] = 204;
        iArr17[124] = 203;
        iArr10[19] = 202;
        iArr2[152] = 201;
    }

    public void r(int[][] iArr) {
        int[] iArr2 = iArr[41];
        iArr2[122] = 600;
        int[] iArr3 = iArr[35];
        iArr3[0] = 599;
        int[] iArr4 = iArr[43];
        iArr4[15] = 598;
        iArr3[99] = 597;
        iArr3[6] = 596;
        iArr3[8] = 595;
        int[] iArr5 = iArr[38];
        iArr5[154] = 594;
        int[] iArr6 = iArr[37];
        iArr6[34] = 593;
        iArr6[115] = 592;
        int[] iArr7 = iArr[36];
        iArr7[12] = 591;
        int[] iArr8 = iArr[18];
        iArr8[77] = 590;
        iArr3[100] = 589;
        iArr3[42] = 588;
        iArr[120][75] = 587;
        iArr3[23] = 586;
        int[] iArr9 = iArr[13];
        iArr9[72] = 585;
        int[] iArr10 = iArr[0];
        iArr10[67] = 584;
        int[] iArr11 = iArr[39];
        iArr11[172] = 583;
        int[] iArr12 = iArr[22];
        iArr12[182] = 582;
        int[] iArr13 = iArr[15];
        iArr13[186] = 581;
        iArr13[165] = 580;
        iArr3[44] = 579;
        int[] iArr14 = iArr[40];
        iArr14[13] = 578;
        iArr5[1] = 577;
        iArr6[33] = 576;
        iArr7[24] = 575;
        int[] iArr15 = iArr[56];
        iArr15[4] = 574;
        iArr3[29] = 573;
        int[] iArr16 = iArr[9];
        iArr16[96] = 572;
        iArr6[62] = 571;
        int[] iArr17 = iArr[48];
        iArr17[47] = 570;
        int[] iArr18 = iArr[51];
        iArr18[14] = 569;
        iArr11[122] = 568;
        int[] iArr19 = iArr[44];
        iArr19[46] = 567;
        iArr3[21] = 566;
        iArr7[8] = 565;
        iArr7[141] = 564;
        int[] iArr20 = iArr[3];
        iArr20[81] = 563;
        iArr6[155] = 562;
        int[] iArr21 = iArr[42];
        iArr21[84] = 561;
        iArr7[40] = 560;
        iArr3[103] = 559;
        int[] iArr22 = iArr[11];
        iArr22[84] = 558;
        int[] iArr23 = iArr[45];
        iArr23[33] = 557;
        iArr[121][79] = 556;
        int[] iArr24 = iArr[2];
        iArr24[77] = 555;
        iArr7[41] = 554;
        iArr6[47] = 553;
        iArr11[125] = 552;
        iArr6[26] = 551;
        iArr3[48] = 550;
        iArr3[28] = 549;
        iArr3[159] = 548;
        iArr6[40] = 547;
        iArr3[145] = 546;
        iArr6[147] = 545;
        int[] iArr25 = iArr[46];
        iArr25[160] = 544;
        iArr6[46] = 543;
        int[] iArr26 = iArr[50];
        iArr26[99] = 542;
        int[] iArr27 = iArr[52];
        iArr27[13] = 541;
        int[] iArr28 = iArr[10];
        iArr28[82] = 540;
        iArr3[169] = 539;
        iArr3[31] = 538;
        int[] iArr29 = iArr[47];
        iArr29[31] = 537;
        iArr8[79] = 536;
        int[] iArr30 = iArr[16];
        iArr30[113] = 535;
        iArr6[104] = 534;
        iArr11[134] = 533;
        iArr7[53] = 532;
        iArr5[0] = 531;
        int[] iArr31 = iArr[4];
        iArr31[86] = 530;
        int[] iArr32 = iArr[54];
        iArr32[17] = 529;
        iArr4[157] = 528;
        iArr3[165] = 527;
        int[] iArr33 = iArr[69];
        iArr33[147] = 526;
        iArr[117][95] = 525;
        iArr3[162] = 524;
        iArr3[17] = 523;
        iArr7[142] = 522;
        iArr7[4] = 521;
        iArr6[166] = 520;
        iArr3[168] = 519;
        iArr3[19] = 518;
        iArr6[48] = 517;
        iArr21[37] = 516;
        iArr14[146] = 515;
        iArr7[123] = 514;
        iArr12[41] = 513;
        int[] iArr34 = iArr[20];
        iArr34[119] = 512;
        iArr24[74] = 511;
        iArr19[113] = 510;
        iArr3[125] = 509;
        iArr6[16] = 508;
        iArr3[20] = 507;
        iArr3[55] = 506;
        iArr6[145] = 505;
        iArr10[88] = 504;
        iArr20[94] = 503;
        int[] iArr35 = iArr[6];
        iArr35[65] = 502;
        int[] iArr36 = iArr[26];
        iArr36[15] = 501;
        iArr2[126] = 500;
        iArr7[129] = 499;
        int[] iArr37 = iArr[31];
        iArr37[75] = 498;
        int[] iArr38 = iArr[19];
        iArr38[61] = 497;
        iArr3[128] = 496;
        int[] iArr39 = iArr[29];
        iArr39[79] = 495;
        iArr7[62] = 494;
        iArr6[189] = 493;
        iArr11[109] = 492;
        iArr11[135] = 491;
        int[] iArr40 = iArr[72];
        iArr40[15] = 490;
        iArr29[106] = 489;
        iArr32[14] = 488;
        int[] iArr41 = iArr[24];
        iArr41[52] = 487;
        iArr5[162] = 486;
        iArr2[43] = 485;
        iArr6[121] = 484;
        int[] iArr42 = iArr[14];
        iArr42[66] = 483;
        iArr6[30] = 482;
        iArr3[7] = 481;
        int[] iArr43 = iArr[49];
        iArr43[58] = 480;
        iArr4[188] = 479;
        iArr41[66] = 478;
        iArr3[171] = 477;
        iArr14[186] = 476;
        iArr11[164] = 475;
        iArr[78][186] = 474;
        iArr[8][72] = 473;
        iArr7[190] = 472;
        iArr3[53] = 471;
        iArr3[54] = 470;
        iArr12[159] = 469;
        iArr3[9] = 468;
        iArr2[140] = 467;
        iArr6[22] = 466;
        iArr17[97] = 465;
        iArr26[97] = 464;
        iArr7[127] = 463;
        iArr6[23] = 462;
        iArr14[55] = 461;
        iArr3[43] = 460;
        iArr36[22] = 459;
        iArr3[15] = 458;
        iArr40[179] = 457;
        iArr34[129] = 456;
        iArr27[101] = 455;
        iArr3[12] = 454;
        iArr21[156] = 453;
        iArr13[157] = 452;
        iArr26[140] = 451;
        iArr36[28] = 450;
        iArr32[51] = 449;
        iArr3[112] = 448;
        iArr7[116] = 447;
        iArr21[11] = 446;
        iArr6[172] = 445;
        iArr6[29] = 444;
        iArr19[107] = 443;
        iArr26[17] = 442;
        iArr11[107] = 441;
        iArr38[109] = 440;
        iArr7[60] = 439;
        iArr43[132] = 438;
        iArr36[16] = 437;
        iArr4[155] = 436;
        iArr6[120] = 435;
        iArr13[159] = 434;
        iArr4[6] = 433;
        iArr23[188] = 432;
        iArr3[38] = 431;
        iArr11[143] = 430;
        iArr17[144] = 429;
        iArr6[168] = 428;
        iArr6[1] = 427;
        iArr7[109] = 426;
        iArr25[53] = 425;
        iArr5[54] = 424;
        iArr7[0] = 423;
        iArr40[33] = 422;
        iArr21[8] = 421;
        iArr7[31] = 420;
        iArr3[150] = 419;
        iArr[118][93] = 418;
        iArr6[61] = 417;
        iArr10[85] = 416;
        iArr7[27] = 415;
        iArr3[134] = 414;
        iArr7[145] = 413;
        iArr35[96] = 412;
        iArr7[14] = 411;
        iArr30[36] = 410;
        iArr13[175] = 409;
        iArr3[10] = 408;
        iArr7[189] = 407;
        iArr3[51] = 406;
        iArr3[109] = 405;
        iArr3[147] = 404;
        iArr3[180] = 403;
        iArr40[5] = 402;
        iArr7[107] = 401;
        iArr43[116] = 400;
        int[] iArr44 = iArr[73];
        iArr44[30] = 399;
        iArr35[90] = 398;
        iArr24[70] = 397;
        int[] iArr45 = iArr[17];
        iArr45[141] = 396;
        iArr3[62] = 395;
        iArr30[180] = 394;
        iArr31[91] = 393;
        iArr13[171] = 392;
        iArr3[177] = 391;
        iArr6[173] = 390;
        iArr30[121] = 389;
        iArr3[5] = 388;
        iArr25[122] = 387;
        iArr14[138] = 386;
        iArr26[49] = 385;
        iArr7[152] = 384;
        iArr9[43] = 383;
        iArr16[88] = 382;
        iArr7[159] = 381;
        int[] iArr46 = iArr[27];
        iArr46[62] = 380;
        iArr14[18] = 379;
        iArr45[129] = 378;
        iArr4[97] = 377;
        iArr9[131] = 376;
        iArr25[107] = 375;
        iArr[60][64] = 374;
        iArr7[179] = 373;
        iArr6[55] = 372;
        iArr2[173] = 371;
        iArr19[172] = 370;
        int[] iArr47 = iArr[23];
        iArr47[187] = 369;
        iArr7[149] = 368;
        iArr45[125] = 367;
        int[] iArr48 = iArr[55];
        iArr48[180] = 366;
        iArr18[129] = 365;
        iArr7[51] = 364;
        iArr6[122] = 363;
        iArr17[32] = 362;
        iArr18[99] = 361;
        iArr32[16] = 360;
        iArr2[183] = 359;
        iArr6[179] = 358;
        iArr5[179] = 357;
        iArr3[143] = 356;
        iArr6[24] = 355;
        iArr14[177] = 354;
        iArr29[117] = 353;
        iArr11[52] = 352;
        iArr12[99] = 351;
        iArr14[142] = 350;
        iArr7[49] = 349;
        iArr5[17] = 348;
        iArr11[188] = 347;
        iArr7[186] = 346;
        iArr3[189] = 345;
        iArr2[7] = 344;
        iArr8[91] = 343;
        iArr4[137] = 342;
        iArr3[142] = 341;
        iArr3[117] = 340;
        iArr11[138] = 339;
        iArr30[59] = 338;
        iArr11[174] = 337;
        iArr48[145] = 336;
        iArr6[21] = 335;
        iArr7[180] = 334;
        iArr6[156] = 333;
        iArr43[13] = 332;
        iArr2[107] = 331;
        iArr7[56] = 330;
        int[] iArr49 = iArr[53];
        iArr49[8] = 329;
        iArr12[114] = 328;
        int[] iArr50 = iArr[5];
        iArr50[95] = 327;
        iArr6[0] = 326;
        iArr36[183] = 325;
        iArr12[66] = 324;
        iArr3[58] = 323;
        iArr17[117] = 322;
        iArr7[102] = 321;
        iArr12[122] = 320;
        iArr3[11] = 319;
        iArr25[19] = 318;
        iArr12[49] = 317;
        iArr17[166] = 316;
        iArr2[125] = 315;
        iArr2[1] = 314;
        iArr3[178] = 313;
        iArr2[12] = 312;
        iArr36[167] = 311;
        iArr21[152] = 310;
        iArr21[46] = 309;
        iArr21[151] = 308;
        iArr34[135] = 307;
        iArr6[162] = 306;
        iArr6[50] = 305;
        iArr12[185] = 304;
        iArr7[166] = 303;
        iArr38[40] = 302;
        iArr12[107] = 301;
        iArr12[102] = 300;
        int[] iArr51 = iArr[57];
        iArr51[162] = 299;
        iArr12[124] = 298;
        iArr6[138] = 297;
        iArr6[25] = 296;
        iArr10[69] = 295;
        iArr4[172] = 294;
        iArr21[167] = 293;
        iArr3[120] = 292;
        iArr2[128] = 291;
        iArr24[88] = 290;
        iArr34[123] = 289;
        iArr3[123] = 288;
        iArr7[28] = 287;
        iArr21[188] = 286;
        iArr21[164] = 285;
        iArr21[4] = 284;
        iArr4[57] = 283;
        iArr11[3] = 282;
        iArr21[3] = 281;
        iArr51[158] = 280;
        iArr3[146] = 279;
        iArr41[54] = 278;
        iArr9[110] = 277;
        iArr47[132] = 276;
        iArr36[102] = 275;
        iArr48[178] = 274;
        iArr45[117] = 273;
        iArr2[161] = 272;
        iArr5[150] = 271;
        iArr28[71] = 270;
        iArr29[60] = 269;
        iArr30[114] = 268;
        int[] iArr52 = iArr[21];
        iArr52[47] = 267;
        iArr11[101] = 266;
        iArr8[45] = 265;
        iArr14[121] = 264;
        iArr23[41] = 263;
        iArr12[167] = 262;
        iArr36[149] = 261;
        iArr13[189] = 260;
        iArr2[177] = 259;
        iArr25[36] = 258;
        iArr34[40] = 257;
        iArr2[54] = 256;
        iArr20[87] = 255;
        iArr14[16] = 254;
        iArr21[15] = 253;
        iArr22[83] = 252;
        iArr10[94] = 251;
        iArr[122][81] = 250;
        iArr2[26] = 249;
        iArr7[34] = 248;
        iArr19[148] = 247;
        iArr3[3] = 246;
        iArr7[114] = 245;
        iArr21[112] = 244;
        iArr3[183] = 243;
        iArr43[73] = 242;
        iArr11[2] = 241;
        iArr5[121] = 240;
        iArr19[114] = 239;
        iArr43[32] = 238;
        int[] iArr53 = iArr[1];
        iArr53[65] = 237;
        iArr5[25] = 236;
        iArr11[4] = 235;
        iArr21[62] = 234;
        iArr3[40] = 233;
        iArr41[2] = 232;
        iArr49[49] = 231;
        iArr2[133] = 230;
        iArr4[134] = 229;
        iArr20[83] = 228;
        iArr5[158] = 227;
        iArr41[17] = 226;
        iArr27[59] = 225;
        iArr5[41] = 224;
        iArr6[127] = 223;
        iArr12[175] = 222;
        iArr19[30] = 221;
        iArr29[178] = 220;
        iArr4[99] = 219;
        iArr38[4] = 218;
        iArr6[97] = 217;
        iArr5[181] = 216;
        iArr23[103] = 215;
        iArr53[86] = 214;
        iArr14[15] = 213;
        iArr12[136] = 212;
        iArr[75][165] = 211;
        iArr7[15] = 210;
        iArr25[80] = 209;
        int[] iArr54 = iArr[59];
        iArr54[55] = 208;
        iArr6[108] = 207;
        iArr52[109] = 206;
        iArr41[165] = 205;
        iArr[79][158] = 204;
        iArr19[139] = 203;
        iArr7[124] = 202;
        iArr21[185] = 201;
        iArr11[186] = 200;
        iArr12[128] = 199;
        iArr14[44] = 198;
        iArr2[105] = 197;
        iArr53[70] = 196;
        iArr53[68] = 195;
        iArr49[22] = 194;
        iArr7[54] = 193;
        iArr29[147] = 192;
        iArr3[36] = 191;
        iArr3[185] = 190;
        iArr23[37] = 189;
        iArr4[163] = 188;
        iArr15[115] = 187;
        iArr5[164] = 186;
        iArr3[141] = 185;
        iArr21[132] = 184;
        iArr25[120] = 183;
        iArr33[142] = 182;
        iArr5[175] = 181;
        iArr12[112] = 180;
        iArr5[142] = 179;
        iArr14[37] = 178;
        iArr6[109] = 177;
        iArr14[144] = 176;
        iArr19[117] = 175;
        iArr3[181] = 174;
        iArr36[105] = 173;
        iArr30[48] = 172;
        iArr19[122] = 171;
        int[] iArr55 = iArr[12];
        iArr55[86] = 170;
        int[] iArr56 = iArr[84];
        iArr56[53] = 169;
        iArr45[44] = 168;
        iArr54[54] = 167;
        iArr7[98] = 166;
        iArr23[115] = 165;
        iArr44[9] = 164;
        iArr19[123] = 163;
        iArr6[188] = 162;
        iArr18[117] = 161;
        iArr13[156] = 160;
        iArr7[155] = 159;
        iArr19[25] = 158;
        iArr5[12] = 157;
        iArr5[140] = 156;
        iArr47[4] = 155;
        iArr23[149] = 154;
        iArr12[189] = 153;
        iArr5[147] = 152;
        iArr46[5] = 151;
        iArr12[42] = 150;
        iArr20[68] = 149;
        iArr11[51] = 148;
        iArr7[29] = 147;
        iArr34[108] = 146;
        iArr26[57] = 145;
        iArr48[104] = 144;
        iArr12[46] = 143;
        iArr8[164] = 142;
        iArr26[159] = 141;
        iArr[85][131] = 140;
        iArr36[79] = 139;
        iArr5[100] = 138;
        iArr49[112] = 137;
        iArr34[190] = 136;
        iArr42[69] = 135;
        iArr47[11] = 134;
        iArr14[114] = 133;
        iArr14[148] = 132;
        iArr49[130] = 131;
        iArr7[2] = 130;
        iArr[66][82] = 129;
        iArr23[166] = 128;
        iArr31[88] = 127;
        iArr30[57] = 126;
        iArr12[116] = 125;
        iArr7[108] = 124;
        iArr9[48] = 123;
        iArr32[12] = 122;
        iArr14[136] = 121;
        iArr7[128] = 120;
        iArr47[6] = 119;
        iArr5[125] = 118;
        iArr23[154] = 117;
        iArr18[127] = 116;
        iArr19[163] = 115;
        iArr30[173] = 114;
        iArr4[49] = 113;
        iArr34[112] = 112;
        iArr13[168] = 111;
        iArr3[129] = 110;
        iArr34[45] = 109;
        iArr5[10] = 108;
        iArr51[171] = 107;
        iArr19[190] = 106;
        iArr14[56] = 105;
        iArr7[156] = 104;
        iArr20[88] = 103;
        iArr26[122] = 102;
        iArr7[7] = 101;
        iArr11[43] = 100;
        iArr13[166] = 99;
        iArr21[136] = 98;
        iArr12[131] = 97;
        iArr19[23] = 96;
        iArr32[147] = 95;
        iArr2[32] = 94;
        iArr47[121] = 93;
        iArr11[108] = 92;
        iArr24[78] = 91;
        iArr14[155] = 90;
        iArr48[51] = 89;
        iArr38[34] = 88;
        iArr17[128] = 87;
        iArr17[159] = 86;
        iArr34[70] = 85;
        iArr[34][71] = 84;
        iArr30[31] = 83;
        iArr21[157] = 82;
        iArr34[44] = 81;
        iArr22[92] = 80;
        iArr19[180] = 79;
        iArr56[33] = 78;
        iArr30[116] = 77;
        int[] iArr57 = iArr[61];
        iArr57[163] = 76;
        iArr3[164] = 75;
        iArr7[42] = 74;
        iArr9[40] = 73;
        iArr4[176] = 72;
        iArr24[66] = 71;
        iArr34[133] = 70;
        iArr7[65] = 69;
        iArr5[33] = 68;
        iArr55[91] = 67;
        iArr7[26] = 66;
        iArr13[174] = 65;
        iArr[77][32] = 64;
        iArr30[1] = 63;
        iArr[25][86] = 62;
        iArr45[13] = 61;
        iArr50[75] = 60;
        iArr7[52] = 59;
        iArr18[164] = 58;
        iArr55[85] = 57;
        iArr11[168] = 56;
        iArr4[16] = 55;
        iArr14[69] = 54;
        iArr36[108] = 53;
        iArr18[56] = 52;
        iArr30[37] = 51;
        iArr14[29] = 50;
        iArr25[171] = 49;
        iArr14[128] = 48;
        iArr40[114] = 47;
        iArr52[103] = 46;
        iArr12[44] = 45;
        iArr14[115] = 44;
        iArr4[7] = 43;
        iArr4[153] = 42;
        iArr45[20] = 41;
        iArr30[49] = 40;
        iArr7[57] = 39;
        iArr8[38] = 38;
        iArr23[184] = 37;
        iArr6[167] = 36;
        iArr36[106] = 35;
        iArr57[121] = 34;
        iArr[89][140] = 33;
        iArr25[61] = 32;
        iArr11[163] = 31;
        iArr14[62] = 30;
        iArr5[165] = 29;
        iArr29[37] = 28;
        iArr8[155] = 27;
        iArr34[33] = 26;
        iArr39[90] = 25;
        iArr34[103] = 24;
        iArr6[51] = 23;
        iArr51[0] = 22;
        iArr14[31] = 21;
        iArr23[32] = 20;
        iArr54[23] = 19;
        iArr8[47] = 18;
        iArr23[134] = 17;
        iArr6[59] = 16;
        iArr52[128] = 15;
        iArr7[106] = 14;
        iArr37[39] = 13;
        iArr14[182] = 12;
        iArr27[155] = 11;
        iArr21[166] = 10;
        iArr3[27] = 9;
        iArr5[3] = 8;
        iArr9[44] = 7;
        iArr[58][157] = 6;
        iArr29[51] = 5;
        iArr2[37] = 4;
        iArr2[172] = 3;
        iArr18[165] = 2;
        iArr13[161] = 1;
        iArr41[181] = 0;
    }

    public void s(short[][] sArr) {
        short[] sArr2 = sArr[48];
        sArr2[49] = 599;
        short[] sArr3 = sArr[35];
        sArr3[65] = 598;
        short[] sArr4 = sArr[41];
        sArr4[27] = 597;
        sArr3[0] = 596;
        short[] sArr5 = sArr[39];
        sArr5[19] = 595;
        sArr3[42] = 594;
        short[] sArr6 = sArr[38];
        sArr6[66] = 593;
        sArr3[8] = 592;
        sArr3[6] = 591;
        sArr3[66] = 590;
        short[] sArr7 = sArr[43];
        sArr7[14] = 589;
        short[] sArr8 = sArr[69];
        sArr8[80] = 588;
        short[] sArr9 = sArr[50];
        sArr9[48] = 587;
        short[] sArr10 = sArr[36];
        sArr10[71] = 586;
        short[] sArr11 = sArr[37];
        sArr11[10] = 585;
        short[] sArr12 = sArr[60];
        sArr12[52] = 584;
        short[] sArr13 = sArr[51];
        sArr13[21] = 583;
        short[] sArr14 = sArr[40];
        sArr14[2] = 582;
        short[] sArr15 = sArr[67];
        sArr15[35] = 581;
        sArr6[78] = 580;
        short[] sArr16 = sArr[49];
        sArr16[18] = 579;
        sArr3[23] = 578;
        short[] sArr17 = sArr[42];
        sArr17[83] = 577;
        short[] sArr18 = sArr[79];
        sArr18[47] = 576;
        short[] sArr19 = sArr[61];
        sArr19[82] = 575;
        sArr6[7] = 574;
        sArr3[29] = 573;
        sArr11[77] = 572;
        short[] sArr20 = sArr[54];
        sArr20[67] = 571;
        sArr6[80] = 570;
        short[] sArr21 = sArr[52];
        sArr21[74] = 569;
        sArr10[37] = 568;
        short[] sArr22 = sArr[74];
        sArr22[8] = 567;
        sArr4[83] = 566;
        sArr10[75] = 565;
        sArr16[63] = 564;
        sArr17[58] = 563;
        short[] sArr23 = sArr[56];
        sArr23[33] = 562;
        sArr11[76] = 561;
        short[] sArr24 = sArr[62];
        sArr24[39] = 560;
        sArr3[21] = 559;
        short[] sArr25 = sArr[70];
        sArr25[19] = 558;
        sArr[77][88] = 557;
        sArr13[14] = 556;
        sArr10[17] = 555;
        short[] sArr26 = sArr[44];
        sArr26[51] = 554;
        sArr6[72] = 553;
        sArr22[90] = 552;
        sArr3[48] = 551;
        sArr3[69] = 550;
        short[] sArr27 = sArr[66];
        sArr27[86] = 549;
        short[] sArr28 = sArr[57];
        sArr28[20] = 548;
        sArr3[53] = 547;
        sArr10[87] = 546;
        short[] sArr29 = sArr[84];
        sArr29[67] = 545;
        sArr25[56] = 544;
        short[] sArr30 = sArr[71];
        sArr30[54] = 543;
        sArr12[70] = 542;
        short[] sArr31 = sArr[80];
        sArr31[1] = 541;
        sArr5[59] = 540;
        sArr5[51] = 539;
        sArr3[44] = 538;
        sArr2[4] = 537;
        short[] sArr32 = sArr[55];
        sArr32[24] = 536;
        sArr21[4] = 535;
        sArr20[26] = 534;
        sArr10[31] = 533;
        sArr11[22] = 532;
        sArr11[9] = 531;
        short[] sArr33 = sArr[46];
        sArr33[0] = 530;
        sArr23[46] = 529;
        short[] sArr34 = sArr[47];
        sArr34[93] = 528;
        sArr11[25] = 527;
        sArr5[8] = 526;
        sArr33[73] = 525;
        sArr6[48] = 524;
        sArr5[83] = 523;
        sArr12[92] = 522;
        sArr25[11] = 521;
        short[] sArr35 = sArr[63];
        sArr35[84] = 520;
        sArr6[65] = 519;
        short[] sArr36 = sArr[45];
        sArr36[45] = 518;
        sArr35[49] = 517;
        sArr35[50] = 516;
        sArr5[93] = 515;
        short[] sArr37 = sArr[68];
        sArr37[20] = 514;
        sArr26[84] = 513;
        sArr27[34] = 512;
        sArr11[58] = 511;
        sArr5[0] = 510;
        short[] sArr38 = sArr[59];
        sArr38[1] = 509;
        sArr34[8] = 508;
        sArr19[17] = 507;
        short[] sArr39 = sArr[53];
        sArr39[87] = 506;
        sArr15[26] = 505;
        sArr7[46] = 504;
        sArr6[61] = 503;
        sArr36[9] = 502;
        sArr27[83] = 501;
        sArr7[88] = 500;
        sArr[85][20] = 499;
        sArr28[36] = 498;
        sArr7[6] = 497;
        short[] sArr40 = sArr[86];
        sArr40[77] = 496;
        sArr17[70] = 495;
        sArr16[78] = 494;
        sArr10[40] = 493;
        sArr17[71] = 492;
        short[] sArr41 = sArr[58];
        sArr41[49] = 491;
        sArr3[20] = 490;
        short[] sArr42 = sArr[76];
        sArr42[20] = 489;
        sArr5[25] = 488;
        sArr14[34] = 487;
        sArr5[76] = 486;
        sArr14[1] = 485;
        sArr38[0] = 484;
        sArr5[70] = 483;
        sArr33[14] = 482;
        sArr37[77] = 481;
        sArr6[55] = 480;
        sArr3[78] = 479;
        sArr29[44] = 478;
        sArr10[41] = 477;
        sArr11[62] = 476;
        short[] sArr43 = sArr[65];
        sArr43[67] = 475;
        sArr8[66] = 474;
        short[] sArr44 = sArr[73];
        sArr44[55] = 473;
        sArr30[49] = 472;
        sArr27[87] = 471;
        sArr6[33] = 470;
        short[] sArr45 = sArr[64];
        sArr45[61] = 469;
        sArr3[7] = 468;
        sArr34[49] = 467;
        sArr23[14] = 466;
        sArr10[49] = 465;
        sArr9[81] = 464;
        sArr32[76] = 463;
        sArr3[19] = 462;
        sArr26[47] = 461;
        sArr3[15] = 460;
        short[] sArr46 = sArr[82];
        sArr46[59] = 459;
        sArr3[43] = 458;
        sArr44[0] = 457;
        sArr28[83] = 456;
        sArr17[46] = 455;
        sArr10[0] = 454;
        sArr25[88] = 453;
        sArr17[22] = 452;
        sArr33[58] = 451;
        sArr10[34] = 450;
        sArr5[24] = 449;
        sArr3[55] = 448;
        sArr26[91] = 447;
        sArr11[51] = 446;
        sArr10[19] = 445;
        sArr8[90] = 444;
        sArr32[35] = 443;
        sArr3[54] = 442;
        sArr16[61] = 441;
        sArr10[67] = 440;
        short[] sArr47 = sArr[88];
        sArr47[34] = 439;
        sArr3[17] = 438;
        sArr43[69] = 437;
        sArr22[89] = 436;
        sArr11[31] = 435;
        sArr7[48] = 434;
        short[] sArr48 = sArr[89];
        sArr48[27] = 433;
        sArr17[79] = 432;
        sArr8[57] = 431;
        sArr10[13] = 430;
        sArr3[62] = 429;
        sArr43[47] = 428;
        sArr23[8] = 427;
        sArr6[79] = 426;
        sArr11[64] = 425;
        sArr45[64] = 424;
        sArr6[53] = 423;
        sArr6[31] = 422;
        sArr23[81] = 421;
        sArr10[22] = 420;
        sArr7[4] = 419;
        sArr10[90] = 418;
        sArr6[62] = 417;
        sArr27[85] = 416;
        sArr5[1] = 415;
        sArr38[40] = 414;
        sArr41[93] = 413;
        sArr26[43] = 412;
        sArr5[49] = 411;
        sArr45[2] = 410;
        sArr4[35] = 409;
        sArr12[22] = 408;
        sArr3[91] = 407;
        short[] sArr49 = sArr[78];
        sArr49[1] = 406;
        sArr10[14] = 405;
        sArr46[29] = 404;
        sArr21[86] = 403;
        sArr14[16] = 402;
        short[] sArr50 = sArr[91];
        sArr50[52] = 401;
        sArr9[75] = 400;
        sArr45[30] = 399;
        short[] sArr51 = sArr[90];
        sArr51[78] = 398;
        sArr10[52] = 397;
        sArr32[87] = 396;
        sArr28[5] = 395;
        sArr28[31] = 394;
        sArr17[35] = 393;
        sArr8[50] = 392;
        sArr36[8] = 391;
        sArr9[87] = 390;
        sArr8[55] = 389;
        sArr[92][3] = 388;
        sArr10[43] = 387;
        sArr45[10] = 386;
        sArr23[25] = 385;
        sArr12[68] = 384;
        sArr13[46] = 383;
        sArr9[0] = 382;
        sArr6[30] = 381;
        sArr9[85] = 380;
        sArr12[54] = 379;
        sArr44[6] = 378;
        sArr44[28] = 377;
        sArr23[19] = 376;
        sArr24[69] = 375;
        short[] sArr52 = sArr[81];
        sArr52[66] = 374;
        sArr14[32] = 373;
        sArr42[31] = 372;
        sArr3[10] = 371;
        sArr4[37] = 370;
        sArr21[82] = 369;
        sArr50[72] = 368;
        sArr11[29] = 367;
        sArr23[30] = 366;
        sArr11[80] = 365;
        sArr52[56] = 364;
        sArr25[3] = 363;
        sArr42[15] = 362;
        sArr33[47] = 361;
        sArr3[88] = 360;
        sArr19[58] = 359;
        sArr11[37] = 358;
        sArr28[22] = 357;
        sArr4[23] = 356;
        sArr51[66] = 355;
        sArr5[60] = 354;
        sArr6[0] = 353;
        sArr11[87] = 352;
        sArr33[2] = 351;
        sArr6[56] = 350;
        sArr41[11] = 349;
        sArr2[10] = 348;
        sArr22[4] = 347;
        sArr14[42] = 346;
        sArr4[52] = 345;
        sArr19[92] = 344;
        sArr5[50] = 343;
        sArr34[88] = 342;
        sArr47[36] = 341;
        sArr36[73] = 340;
        sArr46[3] = 339;
        sArr19[36] = 338;
        sArr12[33] = 337;
        sArr6[27] = 336;
        sArr3[83] = 335;
        sArr43[24] = 334;
        sArr44[10] = 333;
        sArr4[13] = 332;
        sArr9[27] = 331;
        sArr38[50] = 330;
        sArr17[45] = 329;
        sArr32[19] = 328;
        sArr10[77] = 327;
        sArr8[31] = 326;
        sArr12[7] = 325;
        sArr14[88] = 324;
        sArr28[56] = 323;
        sArr9[50] = 322;
        sArr17[37] = 321;
        sArr6[82] = 320;
        sArr21[25] = 319;
        sArr17[67] = 318;
        sArr2[40] = 317;
        sArr36[81] = 316;
        sArr28[14] = 315;
        sArr17[13] = 314;
        sArr49[0] = 313;
        sArr3[51] = 312;
        sArr4[67] = 311;
        sArr45[23] = 310;
        sArr10[65] = 309;
        sArr2[50] = 308;
        sArr33[69] = 307;
        sArr34[89] = 306;
        sArr4[48] = 305;
        sArr12[56] = 304;
        sArr26[82] = 303;
        sArr34[35] = 302;
        sArr16[3] = 301;
        sArr16[69] = 300;
        sArr36[93] = 299;
        sArr12[34] = 298;
        sArr12[82] = 297;
        sArr19[61] = 296;
        sArr40[42] = 295;
        sArr48[60] = 294;
        sArr2[31] = 293;
        sArr3[75] = 292;
        sArr50[39] = 291;
        sArr39[19] = 290;
        sArr5[72] = 289;
        sArr8[59] = 288;
        sArr4[7] = 287;
        sArr20[13] = 286;
        sArr7[28] = 285;
        sArr10[6] = 284;
        sArr36[75] = 283;
        sArr10[61] = 282;
        sArr6[21] = 281;
        sArr36[14] = 280;
        sArr19[43] = 279;
        sArr10[63] = 278;
        sArr7[30] = 277;
        sArr33[51] = 276;
        sArr37[87] = 275;
        sArr5[26] = 274;
        sArr33[76] = 273;
        sArr10[15] = 272;
        sArr3[40] = 271;
        sArr18[60] = 270;
        sArr33[7] = 269;
        sArr43[72] = 268;
        sArr8[88] = 267;
        sArr34[18] = 266;
        sArr11[0] = 265;
        sArr11[49] = 264;
        sArr15[37] = 263;
        sArr10[91] = 262;
        short[] sArr53 = sArr[75];
        sArr53[48] = 261;
        sArr53[63] = 260;
        short[] sArr54 = sArr[83];
        sArr54[87] = 259;
        sArr11[44] = 258;
        sArr44[54] = 257;
        sArr13[61] = 256;
        sArr33[57] = 255;
        sArr32[21] = 254;
        sArr5[66] = 253;
        sArr34[11] = 252;
        sArr21[8] = 251;
        sArr46[81] = 250;
        sArr10[57] = 249;
        sArr6[54] = 248;
        sArr7[81] = 247;
        sArr11[42] = 246;
        sArr14[18] = 245;
        sArr31[90] = 244;
        sArr11[84] = 243;
        sArr28[15] = 242;
        sArr6[87] = 241;
        sArr11[32] = 240;
        sArr39[53] = 239;
        sArr48[29] = 238;
        sArr52[53] = 237;
        sArr53[3] = 236;
        sArr54[73] = 235;
        sArr27[13] = 234;
        sArr2[7] = 233;
        sArr33[35] = 232;
        sArr3[86] = 231;
        sArr11[20] = 230;
        sArr33[80] = 229;
        sArr6[24] = 228;
        sArr4[68] = 227;
        sArr17[21] = 226;
        sArr7[32] = 225;
        sArr6[20] = 224;
        sArr11[59] = 223;
        sArr4[77] = 222;
        sArr38[57] = 221;
        sArr37[59] = 220;
        sArr5[43] = 219;
        sArr20[39] = 218;
        sArr2[28] = 217;
        sArr20[28] = 216;
        sArr4[44] = 215;
        sArr13[64] = 214;
        sArr34[72] = 213;
        sArr24[67] = 212;
        sArr17[43] = 211;
        sArr19[38] = 210;
        sArr42[25] = 209;
        sArr2[91] = 208;
        sArr10[36] = 207;
        sArr31[32] = 206;
        sArr52[40] = 205;
        sArr11[5] = 204;
        sArr22[69] = 203;
        sArr10[82] = 202;
        sArr33[59] = 201;
    }

    public void t(short[][] sArr) {
        short[] sArr2 = sArr[20];
        sArr2[35] = 599;
        short[] sArr3 = sArr[49];
        sArr3[26] = 598;
        short[] sArr4 = sArr[41];
        sArr4[38] = 597;
        short[] sArr5 = sArr[17];
        sArr5[26] = 596;
        short[] sArr6 = sArr[32];
        sArr6[42] = 595;
        short[] sArr7 = sArr[39];
        sArr7[42] = 594;
        short[] sArr8 = sArr[45];
        sArr8[49] = 593;
        short[] sArr9 = sArr[51];
        sArr9[57] = 592;
        short[] sArr10 = sArr[50];
        sArr10[47] = 591;
        short[] sArr11 = sArr[42];
        sArr11[90] = 590;
        short[] sArr12 = sArr[52];
        sArr12[65] = 589;
        short[] sArr13 = sArr[53];
        sArr13[47] = 588;
        short[] sArr14 = sArr[19];
        sArr14[82] = 587;
        short[] sArr15 = sArr[31];
        sArr15[19] = 586;
        short[] sArr16 = sArr[40];
        sArr16[46] = 585;
        short[] sArr17 = sArr[24];
        sArr17[89] = 584;
        short[] sArr18 = sArr[23];
        sArr18[85] = 583;
        sArr2[28] = 582;
        sArr11[20] = 581;
        short[] sArr19 = sArr[34];
        sArr19[38] = 580;
        sArr8[9] = 579;
        short[] sArr20 = sArr[54];
        sArr20[50] = 578;
        short[] sArr21 = sArr[25];
        sArr21[44] = 577;
        short[] sArr22 = sArr[35];
        sArr22[66] = 576;
        sArr2[55] = 575;
        short[] sArr23 = sArr[18];
        sArr23[85] = 574;
        sArr2[31] = 573;
        sArr3[17] = 572;
        sArr4[16] = 571;
        sArr22[73] = 570;
        sArr2[34] = 569;
        short[] sArr24 = sArr[29];
        sArr24[44] = 568;
        sArr22[38] = 567;
        sArr3[9] = 566;
        short[] sArr25 = sArr[46];
        sArr25[33] = 565;
        sArr3[51] = 564;
        sArr16[89] = 563;
        short[] sArr26 = sArr[26];
        sArr26[64] = 562;
        sArr20[51] = 561;
        sArr20[36] = 560;
        sArr7[4] = 559;
        sArr13[13] = 558;
        sArr17[92] = 557;
        short[] sArr27 = sArr[27];
        sArr27[49] = 556;
        short[] sArr28 = sArr[48];
        sArr28[6] = 555;
        short[] sArr29 = sArr[21];
        sArr29[51] = 554;
        short[] sArr30 = sArr[30];
        sArr30[40] = 553;
        sArr11[92] = 552;
        sArr15[78] = 551;
        sArr21[82] = 550;
        short[] sArr31 = sArr[47];
        sArr31[0] = 549;
        sArr19[19] = 548;
        sArr31[35] = 547;
        sArr29[63] = 546;
        short[] sArr32 = sArr[43];
        sArr32[75] = 545;
        sArr29[87] = 544;
        sArr22[59] = 543;
        sArr21[34] = 542;
        sArr29[27] = 541;
        sArr7[26] = 540;
        sArr19[26] = 539;
        sArr7[52] = 538;
        sArr10[57] = 537;
        short[] sArr33 = sArr[37];
        sArr33[79] = 536;
        sArr26[24] = 535;
        short[] sArr34 = sArr[22];
        sArr34[1] = 534;
        sArr23[40] = 533;
        sArr4[33] = 532;
        sArr13[26] = 531;
        sArr20[86] = 530;
        sArr2[16] = 529;
        sArr25[74] = 528;
        sArr30[19] = 527;
        sArr8[35] = 526;
        sArr8[61] = 525;
        sArr30[9] = 524;
        sArr4[53] = 523;
        sArr4[13] = 522;
        sArr10[34] = 521;
        sArr13[86] = 520;
        sArr31[47] = 519;
        sArr34[28] = 518;
        sArr10[53] = 517;
        sArr7[70] = 516;
        short[] sArr35 = sArr[38];
        sArr35[15] = 515;
        sArr11[88] = 514;
        short[] sArr36 = sArr[16];
        sArr36[29] = 513;
        sArr27[90] = 512;
        sArr24[12] = 511;
        short[] sArr37 = sArr[44];
        sArr37[22] = 510;
        sArr19[69] = 509;
        sArr17[10] = 508;
        sArr37[11] = 507;
        sArr7[92] = 506;
        sArr3[48] = 505;
        sArr15[46] = 504;
        sArr14[50] = 503;
        sArr29[14] = 502;
        sArr6[28] = 501;
        sArr23[3] = 500;
        sArr13[9] = 499;
        sArr19[80] = 498;
        sArr28[88] = 497;
        sArr25[53] = 496;
        sArr34[53] = 495;
        short[] sArr38 = sArr[28];
        sArr38[10] = 494;
        sArr37[65] = 493;
        sArr2[10] = 492;
        sArr16[76] = 491;
        sArr31[8] = 490;
        sArr10[74] = 489;
        sArr18[62] = 488;
        sArr3[65] = 487;
        sArr38[87] = 486;
        short[] sArr39 = sArr[15];
        sArr39[48] = 485;
        sArr34[7] = 484;
        sArr14[42] = 483;
        sArr4[20] = 482;
        sArr26[55] = 481;
        sArr29[93] = 480;
        sArr15[76] = 479;
        sArr19[31] = 478;
        sArr2[66] = 477;
        sArr9[33] = 476;
        sArr19[86] = 475;
        sArr33[67] = 474;
        sArr13[53] = 473;
        sArr16[88] = 472;
        sArr7[10] = 471;
        sArr17[3] = 470;
        sArr27[25] = 469;
        sArr26[15] = 468;
        sArr29[88] = 467;
        sArr12[62] = 466;
        sArr25[81] = 465;
        sArr35[72] = 464;
        sArr5[30] = 463;
        sArr12[92] = 462;
        sArr19[90] = 461;
        sArr29[7] = 460;
        short[] sArr40 = sArr[36];
        sArr40[13] = 459;
        sArr8[41] = 458;
        sArr6[5] = 457;
        sArr26[89] = 456;
        sArr18[87] = 455;
        sArr2[39] = 454;
        sArr27[23] = 453;
        sArr21[59] = 452;
        sArr3[20] = 451;
        sArr20[77] = 450;
        sArr27[67] = 449;
        sArr31[33] = 448;
        sArr4[17] = 447;
        sArr14[81] = 446;
        sArr36[66] = 445;
        sArr8[26] = 444;
        sArr3[81] = 443;
        sArr13[55] = 442;
        sArr36[26] = 441;
        sArr20[62] = 440;
        sArr2[70] = 439;
        sArr11[35] = 438;
        sArr2[57] = 437;
        sArr19[36] = 436;
        sArr25[63] = 435;
        sArr14[45] = 434;
        sArr29[10] = 433;
        sArr12[93] = 432;
        sArr21[2] = 431;
        sArr30[57] = 430;
        sArr4[24] = 429;
        sArr38[43] = 428;
        sArr8[86] = 427;
        sArr9[56] = 426;
        sArr33[28] = 425;
        sArr12[69] = 424;
        sArr32[92] = 423;
        sArr4[31] = 422;
        sArr33[87] = 421;
        sArr31[36] = 420;
        sArr36[16] = 419;
        sArr16[56] = 418;
        sArr17[55] = 417;
        sArr5[1] = 416;
        sArr22[57] = 415;
        sArr27[50] = 414;
        sArr26[14] = 413;
        sArr10[40] = 412;
        sArr7[19] = 411;
        sArr14[89] = 410;
        sArr24[91] = 409;
        sArr5[89] = 408;
        sArr7[74] = 407;
        sArr25[39] = 406;
        sArr16[28] = 405;
        sArr8[68] = 404;
        sArr32[10] = 403;
        sArr11[13] = 402;
        sArr37[81] = 401;
        sArr4[47] = 400;
        sArr28[58] = 399;
        sArr32[68] = 398;
        sArr36[79] = 397;
        sArr14[5] = 396;
        sArr20[59] = 395;
        sArr5[36] = 394;
        sArr23[0] = 393;
        sArr4[5] = 392;
        sArr4[72] = 391;
        sArr36[39] = 390;
        sArr20[0] = 389;
        sArr9[16] = 388;
        sArr24[36] = 387;
        sArr31[5] = 386;
        sArr31[51] = 385;
        sArr37[7] = 384;
        sArr22[30] = 383;
        sArr26[9] = 382;
        sArr36[7] = 381;
        sArr6[1] = 380;
        short[] sArr41 = sArr[33];
        sArr41[76] = 379;
        sArr19[91] = 378;
        sArr12[36] = 377;
        sArr26[77] = 376;
        sArr22[48] = 375;
        sArr16[80] = 374;
        sArr4[92] = 373;
        sArr27[93] = 372;
        sArr39[17] = 371;
        sArr36[76] = 370;
        sArr9[12] = 369;
        sArr23[20] = 368;
        sArr39[54] = 367;
        sArr10[5] = 366;
        sArr41[22] = 365;
        sArr33[57] = 364;
        sArr38[47] = 363;
        sArr11[31] = 362;
        sArr23[2] = 361;
        sArr32[64] = 360;
        sArr18[47] = 359;
        sArr38[79] = 358;
        sArr21[45] = 357;
        sArr18[91] = 356;
        sArr34[19] = 355;
        sArr21[46] = 354;
        sArr34[36] = 353;
        sArr20[85] = 352;
        sArr25[20] = 351;
        sArr27[37] = 350;
        sArr26[81] = 349;
        sArr11[29] = 348;
        sArr15[90] = 347;
        sArr4[59] = 346;
        sArr17[65] = 345;
        sArr37[84] = 344;
        sArr17[90] = 343;
        sArr35[54] = 342;
        sArr38[70] = 341;
        sArr27[15] = 340;
        sArr38[80] = 339;
        sArr24[8] = 338;
        sArr8[80] = 337;
        sArr13[37] = 336;
        sArr38[65] = 335;
        sArr18[86] = 334;
        sArr7[45] = 333;
        sArr13[32] = 332;
        sArr35[68] = 331;
        sArr8[78] = 330;
        sArr32[7] = 329;
        sArr25[82] = 328;
        sArr27[38] = 327;
        sArr36[62] = 326;
        sArr17[17] = 325;
        sArr34[70] = 324;
        sArr12[28] = 323;
        sArr18[40] = 322;
        sArr38[50] = 321;
        sArr11[91] = 320;
        sArr31[76] = 319;
        sArr39[42] = 318;
        sArr32[55] = 317;
        sArr24[84] = 316;
        sArr37[90] = 315;
        sArr13[16] = 314;
        sArr34[93] = 313;
        sArr19[10] = 312;
        sArr6[53] = 311;
        sArr32[65] = 310;
        sArr38[7] = 309;
        sArr22[46] = 308;
        sArr29[39] = 307;
        sArr37[18] = 306;
        sArr16[10] = 305;
        sArr20[53] = 304;
        sArr35[74] = 303;
        sArr38[26] = 302;
        sArr39[13] = 301;
        sArr7[34] = 300;
        sArr7[46] = 299;
        sArr11[66] = 298;
        sArr41[58] = 297;
        sArr39[56] = 296;
        sArr23[51] = 295;
        sArr3[68] = 294;
        sArr30[37] = 293;
        sArr9[84] = 292;
        sArr9[9] = 291;
        sArr16[70] = 290;
        sArr4[84] = 289;
        sArr38[64] = 288;
        sArr6[88] = 287;
        sArr17[5] = 286;
        sArr13[23] = 285;
        sArr11[27] = 284;
        sArr34[38] = 283;
        sArr6[86] = 282;
        sArr19[30] = 281;
        sArr35[63] = 280;
        sArr17[59] = 279;
        sArr34[81] = 278;
        sArr6[11] = 277;
        sArr9[21] = 276;
        sArr20[41] = 275;
        sArr29[50] = 274;
        sArr18[89] = 273;
        sArr14[87] = 272;
        sArr26[7] = 271;
        sArr30[75] = 270;
        sArr32[84] = 269;
        sArr9[25] = 268;
        sArr36[67] = 267;
        sArr6[9] = 266;
        sArr28[51] = 265;
        sArr7[7] = 264;
        sArr37[88] = 263;
        sArr12[24] = 262;
        sArr18[34] = 261;
        sArr6[75] = 260;
        sArr14[10] = 259;
        sArr38[91] = 258;
        sArr6[83] = 257;
        sArr21[75] = 256;
        sArr13[45] = 255;
        sArr24[85] = 254;
        sArr13[59] = 253;
        sArr36[2] = 252;
        sArr14[78] = 251;
        sArr39[75] = 250;
        sArr9[42] = 249;
        sArr8[67] = 248;
        sArr39[74] = 247;
        sArr21[81] = 246;
        sArr33[62] = 245;
        sArr36[55] = 244;
        sArr23[38] = 243;
        sArr18[23] = 242;
        sArr35[30] = 241;
        sArr5[28] = 240;
        sArr37[73] = 239;
        sArr18[78] = 238;
        sArr16[77] = 237;
        sArr35[87] = 236;
        sArr27[19] = 235;
        sArr35[82] = 234;
        sArr33[22] = 233;
        sArr4[30] = 232;
        sArr20[9] = 231;
        sArr6[30] = 230;
        sArr30[52] = 229;
        sArr16[84] = 228;
        sArr13[57] = 227;
        sArr27[27] = 226;
        sArr35[64] = 225;
        sArr23[43] = 224;
        sArr18[69] = 223;
        sArr38[12] = 222;
        sArr10[78] = 221;
        sArr10[1] = 220;
        sArr26[88] = 219;
        sArr40[40] = 218;
        sArr41[89] = 217;
        sArr4[28] = 216;
        sArr15[77] = 215;
        sArr25[1] = 214;
        sArr31[19] = 213;
        sArr22[55] = 212;
        sArr4[21] = 211;
        sArr27[10] = 210;
        sArr6[77] = 209;
        sArr26[37] = 208;
        sArr2[33] = 207;
        sArr4[52] = 206;
        sArr6[18] = 205;
        sArr35[13] = 204;
        sArr2[18] = 203;
        sArr2[24] = 202;
        sArr8[19] = 201;
        sArr23[53] = 200;
    }

    public void u(short[][] sArr) {
        short[] sArr2 = sArr[52];
        sArr2[132] = 600;
        short[] sArr3 = sArr[73];
        sArr3[135] = 599;
        short[] sArr4 = sArr[49];
        sArr4[123] = 598;
        short[] sArr5 = sArr[77];
        sArr5[146] = 597;
        short[] sArr6 = sArr[81];
        sArr6[123] = 596;
        short[] sArr7 = sArr[82];
        sArr7[144] = 595;
        short[] sArr8 = sArr[51];
        sArr8[179] = 594;
        short[] sArr9 = sArr[83];
        sArr9[154] = 593;
        short[] sArr10 = sArr[71];
        sArr10[139] = 592;
        short[] sArr11 = sArr[64];
        sArr11[139] = 591;
        short[] sArr12 = sArr[85];
        sArr12[144] = 590;
        sArr2[125] = 589;
        short[] sArr13 = sArr[88];
        sArr13[25] = 588;
        sArr6[106] = 587;
        sArr6[148] = 586;
        short[] sArr14 = sArr[62];
        sArr14[137] = 585;
        short[] sArr15 = sArr[94];
        sArr15[0] = 584;
        short[] sArr16 = sArr[1];
        sArr16[64] = 583;
        short[] sArr17 = sArr[67];
        sArr17[163] = 582;
        short[] sArr18 = sArr[20];
        sArr18[190] = 581;
        short[] sArr19 = sArr[57];
        sArr19[131] = 580;
        short[] sArr20 = sArr[29];
        sArr20[169] = 579;
        short[] sArr21 = sArr[72];
        sArr21[143] = 578;
        short[] sArr22 = sArr[0];
        sArr22[173] = 577;
        short[] sArr23 = sArr[11];
        sArr23[23] = 576;
        short[] sArr24 = sArr[61];
        sArr24[141] = 575;
        short[] sArr25 = sArr[60];
        sArr25[123] = 574;
        sArr6[114] = 573;
        sArr7[131] = 572;
        sArr17[156] = 571;
        sArr10[167] = 570;
        sArr18[50] = 569;
        sArr5[132] = 568;
        short[] sArr26 = sArr[84];
        sArr26[38] = 567;
        sArr[26][29] = 566;
        short[] sArr27 = sArr[74];
        sArr27[187] = 565;
        sArr14[116] = 564;
        sArr17[135] = 563;
        short[] sArr28 = sArr[5];
        sArr28[86] = 562;
        sArr21[186] = 561;
        short[] sArr29 = sArr[75];
        sArr29[161] = 560;
        short[] sArr30 = sArr[78];
        sArr30[130] = 559;
        sArr15[30] = 558;
        sArr26[72] = 557;
        sArr16[67] = 556;
        sArr29[172] = 555;
        sArr27[185] = 554;
        short[] sArr31 = sArr[53];
        sArr31[160] = 553;
        short[] sArr32 = sArr[123];
        sArr32[14] = 552;
        short[] sArr33 = sArr[79];
        sArr33[97] = 551;
        sArr12[110] = 550;
        sArr30[171] = 549;
        sArr2[131] = 548;
        short[] sArr34 = sArr[56];
        sArr34[100] = 547;
        short[] sArr35 = sArr[50];
        sArr35[182] = 546;
        sArr15[64] = 545;
        short[] sArr36 = sArr[106];
        sArr36[74] = 544;
        sArr23[102] = 543;
        sArr31[124] = 542;
        sArr[24][3] = 541;
        short[] sArr37 = sArr[86];
        sArr37[148] = 540;
        sArr31[184] = 539;
        sArr37[147] = 538;
        sArr[96][161] = 537;
        sArr7[77] = 536;
        short[] sArr38 = sArr[59];
        sArr38[146] = 535;
        sArr26[126] = 534;
        sArr33[132] = 533;
        sArr12[123] = 532;
        sArr10[101] = 531;
        sArr12[106] = 530;
        sArr[6][184] = 529;
        sArr19[156] = 528;
        sArr29[104] = 527;
        sArr35[137] = 526;
        sArr33[133] = 525;
        short[] sArr39 = sArr[76];
        sArr39[108] = 524;
        sArr19[142] = 523;
        sArr26[130] = 522;
        sArr2[128] = 521;
        short[] sArr40 = sArr[47];
        sArr40[44] = 520;
        sArr2[152] = 519;
        short[] sArr41 = sArr[54];
        sArr41[104] = 518;
        sArr[30][47] = 517;
        sArr10[123] = 516;
        sArr2[107] = 515;
        sArr[45][84] = 514;
        sArr[107][118] = 513;
        sArr28[161] = 512;
        short[] sArr42 = sArr[48];
        sArr42[126] = 511;
        sArr17[170] = 510;
        sArr[43][6] = 509;
        short[] sArr43 = sArr[70];
        sArr43[112] = 508;
        sArr37[174] = 507;
        sArr26[166] = 506;
        sArr33[130] = 505;
        sArr19[141] = 504;
        sArr6[178] = 503;
        sArr34[187] = 502;
        sArr6[162] = 501;
        sArr31[104] = 500;
        sArr32[35] = 499;
        sArr43[169] = 498;
        short[] sArr44 = sArr[69];
        sArr44[164] = 497;
        short[] sArr45 = sArr[109];
        sArr45[61] = 496;
        sArr3[130] = 495;
        sArr14[134] = 494;
        sArr41[125] = 493;
        sArr33[105] = 492;
        sArr43[165] = 491;
        sArr10[189] = 490;
        short[] sArr46 = sArr[23];
        sArr46[147] = 489;
        sArr8[139] = 488;
        sArr40[137] = 487;
        sArr5[123] = 486;
        sArr37[183] = 485;
        short[] sArr47 = sArr[63];
        sArr47[173] = 484;
        sArr33[144] = 483;
        sArr26[159] = 482;
        sArr25[91] = 481;
        short[] sArr48 = sArr[66];
        sArr48[187] = 480;
        sArr3[114] = 479;
        sArr12[56] = 478;
        sArr10[149] = 477;
        sArr26[189] = 476;
        short[] sArr49 = sArr[104];
        sArr49[31] = 475;
        sArr9[82] = 474;
        short[] sArr50 = sArr[68];
        sArr50[35] = 473;
        sArr23[77] = 472;
        sArr[15][155] = 471;
        sArr9[153] = 470;
        sArr10[1] = 469;
        sArr31[190] = 468;
        sArr35[135] = 467;
        short[] sArr51 = sArr[3];
        sArr51[147] = 466;
        sArr42[136] = 465;
        sArr48[166] = 464;
        short[] sArr52 = sArr[55];
        sArr52[159] = 463;
        sArr7[150] = 462;
        short[] sArr53 = sArr[58];
        sArr53[178] = 461;
        sArr11[102] = 460;
        sArr[16][106] = 459;
        sArr50[110] = 458;
        sArr41[14] = 457;
        sArr25[140] = 456;
        sArr[91][71] = 455;
        sArr41[150] = 454;
        sArr30[177] = 453;
        sArr30[117] = 452;
        sArr49[12] = 451;
        sArr3[150] = 450;
        sArr8[142] = 449;
        sArr6[145] = 448;
        sArr48[183] = 447;
        sArr8[178] = 446;
        sArr29[107] = 445;
        short[] sArr54 = sArr[65];
        sArr54[119] = 444;
        sArr44[176] = 443;
        sArr38[122] = 442;
        sArr30[160] = 441;
        sArr12[183] = 440;
        sArr[105][16] = 439;
        sArr3[110] = 438;
        sArr49[39] = 437;
        sArr[119][16] = 436;
        sArr39[162] = 435;
        sArr17[152] = 434;
        sArr7[24] = 433;
        sArr3[121] = 432;
        sArr9[83] = 431;
        sArr7[145] = 430;
        sArr4[133] = 429;
        sArr15[13] = 428;
        sArr53[139] = 427;
        sArr27[189] = 426;
        sArr48[177] = 425;
        sArr12[184] = 424;
        sArr52[183] = 423;
        sArr10[107] = 422;
        sArr23[98] = 421;
        sArr21[153] = 420;
        short[] sArr55 = sArr[2];
        sArr55[137] = 419;
        sArr38[147] = 418;
        sArr53[152] = 417;
        sArr52[144] = 416;
        sArr3[125] = 415;
        sArr2[154] = 414;
        sArr43[178] = 413;
        sArr33[148] = 412;
        sArr47[143] = 411;
        sArr35[140] = 410;
        sArr40[145] = 409;
        sArr42[123] = 408;
        sArr34[107] = 407;
        sArr26[83] = 406;
        sArr38[112] = 405;
        sArr[124][72] = 404;
        sArr33[99] = 403;
        sArr51[37] = 402;
        sArr[114][55] = 401;
        sArr12[152] = 400;
        sArr25[47] = 399;
        sArr54[96] = 398;
        sArr27[110] = 397;
        sArr37[182] = 396;
        sArr35[99] = 395;
        sArr17[186] = 394;
        sArr6[74] = 393;
        short[] sArr56 = sArr[80];
        sArr56[37] = 392;
        sArr[21][60] = 391;
        sArr[110][12] = 390;
        sArr25[162] = 389;
        sArr20[115] = 388;
        sArr9[130] = 387;
        sArr2[136] = 386;
        sArr47[114] = 385;
        sArr4[127] = 384;
        sArr9[109] = 383;
        sArr48[128] = 382;
        sArr30[136] = 381;
        sArr6[180] = 380;
        sArr39[104] = 379;
        sArr34[156] = 378;
        sArr24[23] = 377;
        sArr[4][30] = 376;
        sArr44[154] = 375;
        sArr[100][37] = 374;
        sArr41[177] = 373;
        sArr46[119] = 372;
        sArr10[171] = 371;
        sArr26[146] = 370;
        sArr18[184] = 369;
        sArr37[76] = 368;
        sArr27[132] = 367;
        sArr40[97] = 366;
        sArr7[137] = 365;
        sArr15[56] = 364;
        sArr[92][30] = 363;
        sArr[19][117] = 362;
        sArr42[173] = 361;
        sArr55[136] = 360;
        sArr[7][182] = 359;
        sArr27[188] = 358;
        short[] sArr57 = sArr[14];
        sArr57[132] = 357;
        sArr14[172] = 356;
        sArr[25][39] = 355;
        sArr12[129] = 354;
        sArr11[98] = 353;
        sArr17[127] = 352;
        sArr21[167] = 351;
        sArr19[143] = 350;
        sArr39[187] = 349;
        sArr9[181] = 348;
        sArr26[10] = 347;
        sArr52[166] = 346;
        sArr52[188] = 345;
        short[] sArr58 = sArr[13];
        sArr58[151] = 344;
        sArr14[124] = 343;
        sArr31[136] = 342;
        sArr36[57] = 341;
        sArr40[166] = 340;
        sArr45[30] = 339;
        sArr30[114] = 338;
        sArr9[19] = 337;
        sArr34[162] = 336;
        sArr25[177] = 335;
        sArr13[9] = 334;
        sArr27[163] = 333;
        sArr2[156] = 332;
        sArr10[180] = 331;
        sArr25[57] = 330;
        sArr21[173] = 329;
        sArr7[91] = 328;
        sArr8[186] = 327;
        sArr29[86] = 326;
        sArr29[78] = 325;
        sArr39[170] = 324;
        sArr25[147] = 323;
        sArr7[75] = 322;
        sArr56[148] = 321;
        sArr37[150] = 320;
        sArr58[95] = 319;
        sArr22[11] = 318;
        sArr26[190] = 317;
        sArr39[166] = 316;
        sArr57[72] = 315;
        sArr17[144] = 314;
        sArr26[44] = 313;
        sArr21[125] = 312;
        sArr48[127] = 311;
        sArr25[25] = 310;
        sArr43[146] = 309;
        sArr33[135] = 308;
        sArr41[135] = 307;
        sArr25[104] = 306;
        sArr52[132] = 305;
        sArr15[2] = 304;
        sArr41[133] = 303;
        sArr34[190] = 302;
        sArr53[174] = 301;
        sArr56[144] = 300;
        sArr12[113] = 299;
    }

    public void v(int[][] iArr) {
        int[] iArr2 = iArr[3];
        iArr2[74] = 600;
        iArr2[45] = 599;
        iArr2[3] = 598;
        iArr2[24] = 597;
        iArr2[30] = 596;
        iArr2[42] = 595;
        iArr2[46] = 594;
        iArr2[39] = 593;
        iArr2[11] = 592;
        iArr2[37] = 591;
        iArr2[38] = 590;
        iArr2[31] = 589;
        iArr2[41] = 588;
        iArr2[5] = 587;
        iArr2[10] = 586;
        iArr2[75] = 585;
        iArr2[65] = 584;
        iArr2[72] = 583;
        int[] iArr3 = iArr[37];
        iArr3[91] = 582;
        int[] iArr4 = iArr[0];
        iArr4[27] = 581;
        iArr2[18] = 580;
        iArr2[22] = 579;
        iArr2[61] = 578;
        iArr2[14] = 577;
        int[] iArr5 = iArr[24];
        iArr5[80] = 576;
        int[] iArr6 = iArr[4];
        iArr6[82] = 575;
        int[] iArr7 = iArr[17];
        iArr7[80] = 574;
        int[] iArr8 = iArr[30];
        iArr8[44] = 573;
        iArr2[73] = 572;
        iArr2[64] = 571;
        int[] iArr9 = iArr[38];
        iArr9[14] = 570;
        int[] iArr10 = iArr[33];
        iArr10[70] = 569;
        iArr2[1] = 568;
        iArr2[16] = 567;
        iArr2[35] = 566;
        iArr2[40] = 565;
        iArr6[74] = 564;
        iArr6[24] = 563;
        int[] iArr11 = iArr[42];
        iArr11[59] = 562;
        iArr2[7] = 561;
        iArr2[71] = 560;
        iArr2[12] = 559;
        int[] iArr12 = iArr[15];
        iArr12[75] = 558;
        iArr2[20] = 557;
        iArr6[39] = 556;
        int[] iArr13 = iArr[34];
        iArr13[69] = 555;
        iArr2[28] = 554;
        int[] iArr14 = iArr[35];
        iArr14[24] = 553;
        iArr2[82] = 552;
        int[] iArr15 = iArr[28];
        iArr15[47] = 551;
        iArr2[67] = 550;
        iArr3[16] = 549;
        int[] iArr16 = iArr[26];
        iArr16[93] = 548;
        iArr6[1] = 547;
        iArr16[85] = 546;
        int[] iArr17 = iArr[31];
        iArr17[14] = 545;
        iArr6[3] = 544;
        iArr6[72] = 543;
        iArr5[51] = 542;
        int[] iArr18 = iArr[27];
        iArr18[51] = 541;
        iArr18[49] = 540;
        int[] iArr19 = iArr[22];
        iArr19[77] = 539;
        iArr18[10] = 538;
        int[] iArr20 = iArr[29];
        iArr20[68] = 537;
        int[] iArr21 = iArr[20];
        iArr21[35] = 536;
        int[] iArr22 = iArr[41];
        iArr22[11] = 535;
        iArr5[70] = 534;
        int[] iArr23 = iArr[36];
        iArr23[61] = 533;
        iArr17[23] = 532;
        int[] iArr24 = iArr[43];
        iArr24[16] = 531;
        int[] iArr25 = iArr[23];
        iArr25[68] = 530;
        int[] iArr26 = iArr[32];
        iArr26[15] = 529;
        iArr2[32] = 528;
        int[] iArr27 = iArr[19];
        iArr27[53] = 527;
        int[] iArr28 = iArr[40];
        iArr28[83] = 526;
        iArr6[14] = 525;
        iArr23[9] = 524;
        iArr6[73] = 523;
        iArr25[10] = 522;
        iArr2[63] = 521;
        int[] iArr29 = iArr[39];
        iArr29[14] = 520;
        iArr2[78] = 519;
        iArr10[47] = 518;
        int[] iArr30 = iArr[21];
        iArr30[39] = 517;
        iArr13[46] = 516;
        iArr23[75] = 515;
        iArr22[92] = 514;
        iArr3[93] = 513;
        iArr6[34] = 512;
        iArr12[86] = 511;
        int[] iArr31 = iArr[46];
        iArr31[1] = 510;
        iArr3[65] = 509;
        iArr2[62] = 508;
        iArr26[73] = 507;
        iArr30[65] = 506;
        iArr20[75] = 505;
        iArr16[51] = 504;
        iArr2[34] = 503;
        iArr6[10] = 502;
        iArr8[22] = 501;
        iArr14[73] = 500;
        iArr7[82] = 499;
        int[] iArr32 = iArr[45];
        iArr32[8] = 498;
        iArr18[73] = 497;
        int[] iArr33 = iArr[18];
        iArr33[55] = 496;
        int[] iArr34 = iArr[25];
        iArr34[2] = 495;
        iArr2[26] = 494;
        iArr32[46] = 493;
        iArr6[22] = 492;
        iArr6[40] = 491;
        iArr33[10] = 490;
        iArr26[9] = 489;
        iArr16[49] = 488;
        iArr2[47] = 487;
        iArr5[65] = 486;
        iArr6[76] = 485;
        iArr24[67] = 484;
        iArr2[9] = 483;
        iArr22[37] = 482;
        iArr10[68] = 481;
        iArr24[31] = 480;
        iArr27[55] = 479;
        iArr6[30] = 478;
        iArr18[33] = 477;
        int[] iArr35 = iArr[16];
        iArr35[62] = 476;
        iArr23[35] = 475;
        iArr3[15] = 474;
        iArr18[70] = 473;
        iArr19[71] = 472;
        iArr10[45] = 471;
        iArr17[78] = 470;
        iArr24[59] = 469;
        iArr26[19] = 468;
        iArr7[28] = 467;
        iArr28[28] = 466;
        iArr21[93] = 465;
        iArr33[15] = 464;
        iArr6[23] = 463;
        iArr2[23] = 462;
        iArr16[64] = 461;
        int[] iArr36 = iArr[44];
        iArr36[92] = 460;
        iArr7[27] = 459;
        iArr2[56] = 458;
        iArr34[38] = 457;
        iArr25[31] = 456;
        iArr14[43] = 455;
        iArr6[54] = 454;
        iArr14[19] = 453;
        iArr19[47] = 452;
        iArr11[0] = 451;
        iArr25[28] = 450;
        iArr31[33] = 449;
        iArr23[85] = 448;
        iArr17[12] = 447;
        iArr2[76] = 446;
        iArr6[75] = 445;
        iArr23[56] = 444;
        iArr6[64] = 443;
        iArr34[77] = 442;
        iArr12[52] = 441;
        iArr10[73] = 440;
        iArr2[55] = 439;
        iArr24[82] = 438;
        iArr18[82] = 437;
        iArr21[3] = 436;
        iArr28[51] = 435;
        iArr2[17] = 434;
        iArr18[71] = 433;
        iArr6[52] = 432;
        iArr36[48] = 431;
        iArr18[2] = 430;
        iArr7[39] = 429;
        iArr17[8] = 428;
        iArr36[54] = 427;
        iArr24[18] = 426;
        iArr24[77] = 425;
        iArr6[61] = 424;
        iArr27[91] = 423;
        iArr17[13] = 422;
        iArr36[71] = 421;
        iArr21[0] = 420;
        iArr25[87] = 419;
        iArr30[14] = 418;
        iArr20[13] = 417;
        iArr2[58] = 416;
        iArr16[18] = 415;
        iArr6[47] = 414;
        iArr6[18] = 413;
        iArr2[53] = 412;
        iArr16[92] = 411;
        iArr30[7] = 410;
        iArr6[37] = 409;
        iArr6[63] = 408;
        iArr23[51] = 407;
        iArr6[32] = 406;
        iArr15[73] = 405;
        iArr6[50] = 404;
        iArr22[60] = 403;
        iArr25[1] = 402;
        iArr23[92] = 401;
        iArr12[41] = 400;
        iArr30[71] = 399;
        iArr22[30] = 398;
        iArr26[76] = 397;
        iArr7[34] = 396;
        iArr16[15] = 395;
        iArr16[25] = 394;
        iArr17[77] = 393;
        iArr17[3] = 392;
        iArr31[34] = 391;
        iArr18[84] = 390;
        iArr25[8] = 389;
        iArr35[0] = 388;
        iArr15[80] = 387;
        iArr16[54] = 386;
        iArr10[18] = 385;
        iArr17[20] = 384;
        iArr17[62] = 383;
        iArr8[41] = 382;
        iArr10[30] = 381;
        iArr32[45] = 380;
        iArr3[82] = 379;
        iArr12[33] = 378;
        iArr21[12] = 377;
        iArr33[5] = 376;
        iArr15[86] = 375;
        iArr8[19] = 374;
        iArr11[43] = 373;
        iArr23[31] = 372;
        iArr7[93] = 371;
        iArr6[15] = 370;
        iArr30[20] = 369;
        iArr25[21] = 368;
        iArr15[72] = 367;
        iArr6[20] = 366;
        iArr16[55] = 365;
        iArr30[5] = 364;
        iArr27[16] = 363;
        iArr25[64] = 362;
        iArr28[59] = 361;
        iArr3[26] = 360;
        iArr16[56] = 359;
        iArr6[12] = 358;
        iArr10[71] = 357;
        iArr26[39] = 356;
        iArr9[40] = 355;
        iArr19[74] = 354;
        iArr2[25] = 353;
        iArr12[48] = 352;
        iArr22[82] = 351;
        iArr22[9] = 350;
        iArr34[48] = 349;
        iArr17[71] = 348;
        iArr24[29] = 347;
        iArr16[80] = 346;
        iArr6[5] = 345;
        iArr33[71] = 344;
        iArr20[0] = 343;
        iArr24[43] = 342;
        iArr25[81] = 341;
        iArr6[42] = 340;
        iArr36[28] = 339;
        iArr25[93] = 338;
        iArr7[81] = 337;
        iArr34[25] = 336;
        iArr22[23] = 335;
        iArr13[35] = 334;
        iArr6[53] = 333;
        iArr15[36] = 332;
        iArr6[41] = 331;
        iArr34[60] = 330;
        iArr25[20] = 329;
        iArr2[43] = 328;
        iArr5[79] = 327;
        iArr20[41] = 326;
        iArr8[83] = 325;
        iArr2[50] = 324;
        iArr19[18] = 323;
        iArr33[3] = 322;
        iArr29[30] = 321;
        iArr6[28] = 320;
        iArr30[64] = 319;
        iArr6[68] = 318;
        iArr7[71] = 317;
        iArr18[0] = 316;
        iArr29[28] = 315;
        iArr8[13] = 314;
        iArr23[70] = 313;
        iArr21[82] = 312;
        iArr10[38] = 311;
        iArr36[87] = 310;
        iArr13[45] = 309;
        iArr6[26] = 308;
        iArr5[44] = 307;
        iArr9[67] = 306;
        iArr9[6] = 305;
        iArr8[68] = 304;
        iArr12[89] = 303;
        iArr5[93] = 302;
        iArr28[41] = 301;
        iArr9[3] = 300;
        iArr15[23] = 299;
        iArr16[17] = 298;
        iArr6[38] = 297;
        iArr19[78] = 296;
        iArr12[37] = 295;
        iArr34[85] = 294;
        iArr6[9] = 293;
        iArr6[7] = 292;
        iArr18[53] = 291;
        iArr29[29] = 290;
        iArr22[43] = 289;
        iArr34[62] = 288;
        iArr6[48] = 287;
        iArr15[28] = 286;
        iArr30[40] = 285;
        iArr23[73] = 284;
        iArr16[39] = 283;
        iArr19[54] = 282;
        iArr10[5] = 281;
        iArr27[21] = 280;
        iArr31[31] = 279;
        iArr21[64] = 278;
        iArr16[63] = 277;
        iArr19[23] = 276;
        iArr34[81] = 275;
        iArr6[62] = 274;
        iArr3[31] = 273;
        iArr28[52] = 272;
        iArr20[79] = 271;
        iArr22[48] = 270;
        iArr17[57] = 269;
        iArr26[92] = 268;
        iArr23[36] = 267;
        iArr18[7] = 266;
        iArr14[29] = 265;
        iArr3[34] = 264;
        iArr13[42] = 263;
        iArr18[15] = 262;
        iArr10[27] = 261;
        iArr17[38] = 260;
        iArr27[79] = 259;
        iArr6[31] = 258;
        iArr6[66] = 257;
        iArr7[32] = 256;
        iArr16[67] = 255;
        iArr35[30] = 254;
        iArr16[46] = 253;
        iArr5[26] = 252;
        iArr14[10] = 251;
        iArr33[37] = 250;
        iArr2[19] = 249;
        iArr10[69] = 248;
        iArr17[9] = 247;
        iArr32[29] = 246;
        iArr2[15] = 245;
        iArr33[54] = 244;
        iArr2[44] = 243;
        iArr17[29] = 242;
        iArr33[45] = 241;
        iArr9[28] = 240;
        iArr5[12] = 239;
        iArr14[82] = 238;
        iArr7[43] = 237;
        iArr15[9] = 236;
        iArr25[25] = 235;
        iArr36[37] = 234;
        iArr25[75] = 233;
        iArr25[92] = 232;
        iArr4[24] = 231;
        iArr27[74] = 230;
        iArr32[32] = 229;
        iArr35[72] = 228;
        iArr35[93] = 227;
        iArr32[13] = 226;
        iArr5[8] = 225;
        iArr34[47] = 224;
        iArr15[26] = 223;
        iArr24[81] = 222;
        iArr26[71] = 221;
        iArr33[41] = 220;
        iArr16[62] = 219;
        iArr22[24] = 218;
        iArr28[11] = 217;
        iArr24[57] = 216;
        iArr13[53] = 215;
        iArr21[32] = 214;
        iArr13[43] = 213;
        iArr22[91] = 212;
        iArr20[57] = 211;
        iArr12[43] = 210;
        iArr19[89] = 209;
        iArr10[83] = 208;
        iArr24[20] = 207;
        iArr34[58] = 206;
        iArr8[30] = 205;
        iArr6[56] = 204;
        iArr7[64] = 203;
        iArr25[0] = 202;
        iArr36[12] = 201;
        iArr34[37] = 200;
        iArr14[13] = 199;
        iArr21[30] = 198;
        iArr30[84] = 197;
        iArr20[14] = 196;
        iArr8[5] = 195;
        iArr3[2] = 194;
        iArr6[78] = 193;
        iArr20[78] = 192;
        iArr20[84] = 191;
        iArr26[86] = 190;
        iArr21[68] = 189;
        iArr8[39] = 188;
        iArr12[69] = 187;
        iArr6[60] = 186;
        iArr21[61] = 185;
        iArr22[67] = 184;
        iArr35[35] = 183;
        iArr23[57] = 182;
        iArr29[80] = 181;
        iArr6[59] = 180;
        iArr6[44] = 179;
        iArr28[54] = 178;
        iArr8[8] = 177;
        iArr36[30] = 176;
        iArr17[93] = 175;
        iArr17[47] = 174;
        iArr35[70] = 173;
        iArr30[0] = 172;
        iArr7[35] = 171;
        iArr30[67] = 170;
        iArr36[18] = 169;
        iArr23[29] = 168;
        iArr33[67] = 167;
        iArr5[28] = 166;
        iArr23[24] = 165;
        iArr25[5] = 164;
        iArr17[65] = 163;
        iArr16[59] = 162;
        iArr15[2] = 161;
        iArr29[69] = 160;
        iArr11[40] = 159;
        iArr3[80] = 158;
        iArr12[66] = 157;
        iArr13[38] = 156;
        iArr15[48] = 155;
        iArr3[77] = 154;
        iArr20[34] = 153;
        iArr10[12] = 152;
        iArr6[65] = 151;
        iArr8[31] = 150;
        iArr18[92] = 149;
        iArr6[2] = 148;
        iArr6[51] = 147;
        iArr25[77] = 146;
        iArr6[35] = 145;
        iArr2[13] = 144;
        iArr16[26] = 143;
        iArr36[4] = 142;
        iArr29[53] = 141;
        iArr21[11] = 140;
        iArr28[33] = 139;
        iArr32[7] = 138;
        iArr6[70] = 137;
        iArr2[49] = 136;
        iArr21[59] = 135;
        iArr30[12] = 134;
        iArr10[53] = 133;
        iArr21[14] = 132;
        iArr3[18] = 131;
        iArr33[17] = 130;
        iArr23[23] = 129;
        iArr33[57] = 128;
        iArr16[74] = 127;
        iArr14[2] = 126;
        iArr9[58] = 125;
        iArr13[68] = 124;
        iArr20[81] = 123;
        iArr21[69] = 122;
        iArr29[86] = 121;
        iArr6[16] = 120;
        iArr35[49] = 119;
        iArr12[72] = 118;
        iArr16[35] = 117;
        iArr26[14] = 116;
        iArr28[90] = 115;
        iArr10[79] = 114;
        iArr14[4] = 113;
        iArr25[33] = 112;
        iArr27[19] = 111;
        iArr17[41] = 110;
        iArr36[1] = 109;
        iArr19[56] = 108;
        iArr17[27] = 107;
        iArr26[18] = 106;
        iArr18[32] = 105;
        iArr3[39] = 104;
        iArr11[11] = 103;
        iArr20[71] = 102;
        iArr26[58] = 101;
        iArr31[10] = 100;
        iArr7[30] = 99;
        iArr9[15] = 98;
        iArr20[60] = 97;
        iArr6[11] = 96;
        iArr9[31] = 95;
        iArr28[79] = 94;
        iArr15[49] = 93;
        iArr15[84] = 92;
        iArr16[77] = 91;
        iArr19[32] = 90;
        iArr10[17] = 89;
        iArr25[18] = 88;
        iArr26[64] = 87;
        iArr6[6] = 86;
        iArr10[51] = 85;
        iArr36[77] = 84;
        iArr20[5] = 83;
        iArr31[25] = 82;
        iArr27[58] = 81;
        iArr6[46] = 80;
        iArr12[71] = 79;
        iArr33[58] = 78;
        iArr16[45] = 77;
        iArr32[66] = 76;
        iArr13[10] = 75;
        iArr27[37] = 74;
        iArr10[65] = 73;
        iArr36[52] = 72;
        iArr35[38] = 71;
        iArr23[46] = 70;
        iArr21[26] = 69;
        iArr8[37] = 68;
        iArr6[58] = 67;
        iArr24[2] = 66;
        iArr8[18] = 65;
        iArr27[35] = 64;
        iArr12[68] = 63;
        iArr2[36] = 62;
        iArr14[40] = 61;
        iArr23[32] = 60;
        iArr3[14] = 59;
        iArr7[11] = 58;
        iArr27[78] = 57;
        iArr3[11] = 56;
        iArr15[63] = 55;
        iArr20[61] = 54;
        iArr10[3] = 53;
        iArr22[52] = 52;
        iArr10[63] = 51;
        iArr19[41] = 50;
        iArr6[19] = 49;
        iArr26[41] = 48;
        iArr5[4] = 47;
        iArr17[28] = 46;
        iArr24[30] = 45;
        iArr7[3] = 44;
        iArr24[70] = 43;
        iArr13[19] = 42;
        iArr21[77] = 41;
        iArr33[83] = 40;
        iArr7[15] = 39;
        iArr25[61] = 38;
        iArr28[27] = 37;
        iArr35[48] = 36;
        iArr29[78] = 35;
        iArr22[53] = 34;
        iArr28[91] = 33;
        iArr28[72] = 32;
        iArr33[52] = 31;
        iArr14[66] = 30;
        iArr29[93] = 29;
        iArr27[48] = 28;
        iArr16[36] = 27;
        iArr18[25] = 26;
        iArr11[71] = 25;
        iArr11[85] = 24;
        iArr16[48] = 23;
        iArr15[15] = 22;
        iArr2[66] = 21;
        iArr34[24] = 20;
        iArr18[43] = 19;
        iArr18[78] = 18;
        iArr32[43] = 17;
        iArr18[72] = 16;
        iArr28[29] = 15;
        iArr22[0] = 14;
        iArr27[57] = 13;
        iArr12[59] = 12;
        iArr20[29] = 11;
        iArr6[25] = 10;
        iArr30[42] = 9;
        iArr25[35] = 8;
        iArr10[1] = 7;
        iArr6[57] = 6;
        iArr7[60] = 5;
        iArr34[19] = 4;
        iArr19[65] = 3;
        iArr11[29] = 2;
        iArr18[66] = 1;
        iArr16[89] = 0;
    }

    public void w(int[][] iArr) {
        int[] iArr2 = iArr[31];
        iArr2[43] = 600;
        int[] iArr3 = iArr[19];
        iArr3[56] = 599;
        int[] iArr4 = iArr[38];
        iArr4[46] = 598;
        int[] iArr5 = iArr[3];
        iArr5[3] = 597;
        int[] iArr6 = iArr[29];
        iArr6[77] = 596;
        iArr3[33] = 595;
        int[] iArr7 = iArr[30];
        iArr7[0] = 594;
        iArr6[89] = 593;
        iArr2[26] = 592;
        iArr2[38] = 591;
        int[] iArr8 = iArr[32];
        iArr8[85] = 590;
        int[] iArr9 = iArr[15];
        iArr9[0] = 589;
        int[] iArr10 = iArr[16];
        iArr10[54] = 588;
        iArr9[76] = 587;
        iArr2[25] = 586;
        int[] iArr11 = iArr[23];
        iArr11[13] = 585;
        int[] iArr12 = iArr[28];
        iArr12[34] = 584;
        int[] iArr13 = iArr[18];
        iArr13[9] = 583;
        iArr6[37] = 582;
        int[] iArr14 = iArr[22];
        iArr14[45] = 581;
        iArr3[46] = 580;
        iArr10[65] = 579;
        iArr11[5] = 578;
        int[] iArr15 = iArr[26];
        iArr15[70] = 577;
        iArr2[53] = 576;
        int[] iArr16 = iArr[27];
        iArr16[12] = 575;
        iArr7[67] = 574;
        iArr2[57] = 573;
        int[] iArr17 = iArr[20];
        iArr17[20] = 572;
        iArr7[31] = 571;
        iArr17[72] = 570;
        iArr9[51] = 569;
        iArr5[8] = 568;
        iArr8[53] = 567;
        iArr16[85] = 566;
        int[] iArr18 = iArr[25];
        iArr18[23] = 565;
        iArr9[44] = 564;
        iArr8[3] = 563;
        iArr2[68] = 562;
        iArr7[24] = 561;
        iArr6[49] = 560;
        iArr16[49] = 559;
        iArr11[23] = 558;
        iArr2[91] = 557;
        iArr2[46] = 556;
        iArr3[74] = 555;
        iArr16[27] = 554;
        iArr5[17] = 553;
        iArr17[38] = 552;
        int[] iArr19 = iArr[21];
        iArr19[82] = 551;
        iArr12[25] = 550;
        iArr8[5] = 549;
        iArr2[23] = 548;
        iArr18[45] = 547;
        iArr8[87] = 546;
        iArr13[26] = 545;
        int[] iArr20 = iArr[24];
        iArr20[10] = 544;
        iArr15[82] = 543;
        iArr9[89] = 542;
        iArr12[36] = 541;
        iArr12[31] = 540;
        iArr10[23] = 539;
        iArr10[77] = 538;
        iArr3[84] = 537;
        iArr11[72] = 536;
        iArr4[48] = 535;
        iArr11[2] = 534;
        iArr7[20] = 533;
        iArr4[47] = 532;
        int[] iArr21 = iArr[39];
        iArr21[12] = 531;
        iArr11[21] = 530;
        iArr13[17] = 529;
        iArr7[87] = 528;
        iArr6[62] = 527;
        iArr6[87] = 526;
        int[] iArr22 = iArr[34];
        iArr22[53] = 525;
        iArr8[29] = 524;
        int[] iArr23 = iArr[35];
        iArr23[0] = 523;
        iArr20[43] = 522;
        int[] iArr24 = iArr[36];
        iArr24[44] = 521;
        iArr17[30] = 520;
        iArr21[86] = 519;
        iArr14[14] = 518;
        iArr6[39] = 517;
        iArr12[38] = 516;
        iArr11[79] = 515;
        iArr20[56] = 514;
        iArr6[63] = 513;
        iArr2[45] = 512;
        iArr11[26] = 511;
        iArr9[87] = 510;
        iArr7[74] = 509;
        iArr20[69] = 508;
        iArr17[4] = 507;
        iArr16[50] = 506;
        iArr7[75] = 505;
        iArr20[13] = 504;
        iArr7[8] = 503;
        iArr2[6] = 502;
        iArr18[80] = 501;
        iArr24[8] = 500;
        iArr9[18] = 499;
        iArr21[23] = 498;
        iArr10[24] = 497;
        iArr2[89] = 496;
        iArr9[71] = 495;
        iArr9[57] = 494;
        iArr7[11] = 493;
        iArr9[36] = 492;
        iArr10[60] = 491;
        iArr20[45] = 490;
        int[] iArr25 = iArr[37];
        iArr25[35] = 489;
        iArr20[87] = 488;
        iArr17[45] = 487;
        iArr2[90] = 486;
        iArr8[21] = 485;
        iArr3[70] = 484;
        iArr20[15] = 483;
        iArr15[92] = 482;
        iArr25[13] = 481;
        iArr21[2] = 480;
        iArr11[70] = 479;
        iArr16[25] = 478;
        iArr9[69] = 477;
        iArr3[61] = 476;
        iArr2[58] = 475;
        iArr20[57] = 474;
        iArr24[74] = 473;
        iArr19[6] = 472;
        iArr7[44] = 471;
        iArr9[91] = 470;
        iArr16[16] = 469;
        iArr6[42] = 468;
        int[] iArr26 = iArr[33];
        iArr26[86] = 467;
        iArr6[41] = 466;
        iArr17[68] = 465;
        iArr18[47] = 464;
        iArr14[0] = 463;
        iArr13[14] = 462;
        iArr2[28] = 461;
        iArr9[2] = 460;
        iArr11[76] = 459;
        iArr4[32] = 458;
        iArr6[82] = 457;
        iArr19[86] = 456;
        iArr20[62] = 455;
        iArr2[64] = 454;
        iArr4[26] = 453;
        iArr8[86] = 452;
        iArr14[32] = 451;
        iArr3[59] = 450;
        iArr22[18] = 449;
        iArr13[54] = 448;
        iArr4[63] = 447;
        iArr24[23] = 446;
        iArr23[35] = 445;
        iArr8[62] = 444;
        iArr12[35] = 443;
        iArr16[13] = 442;
        iArr2[59] = 441;
        iArr6[29] = 440;
        iArr9[64] = 439;
        iArr15[84] = 438;
        iArr19[90] = 437;
        iArr17[24] = 436;
        iArr10[18] = 435;
        iArr14[23] = 434;
        iArr2[14] = 433;
        iArr9[1] = 432;
        iArr13[63] = 431;
        iArr3[10] = 430;
        iArr18[49] = 429;
        iArr24[57] = 428;
        iArr17[22] = 427;
        iArr9[15] = 426;
        iArr2[51] = 425;
        iArr20[60] = 424;
        iArr2[70] = 423;
        iArr9[7] = 422;
        iArr12[40] = 421;
        iArr13[41] = 420;
        iArr9[38] = 419;
        iArr8[0] = 418;
        iArr3[51] = 417;
        iArr22[62] = 416;
        iArr10[27] = 415;
        iArr17[70] = 414;
        iArr14[33] = 413;
        iArr15[73] = 412;
        iArr17[79] = 411;
        iArr11[6] = 410;
        iArr20[85] = 409;
        iArr4[51] = 408;
        iArr6[88] = 407;
        iArr4[55] = 406;
        iArr8[32] = 405;
        iArr16[18] = 404;
        iArr11[87] = 403;
        iArr23[6] = 402;
        iArr22[27] = 401;
        iArr21[35] = 400;
        iArr7[88] = 399;
        iArr8[92] = 398;
        iArr8[49] = 397;
        iArr20[61] = 396;
        iArr13[74] = 395;
        iArr11[77] = 394;
        iArr11[50] = 393;
        iArr11[32] = 392;
        iArr11[36] = 391;
        iArr4[38] = 390;
        iArr6[86] = 389;
        iArr24[15] = 388;
        iArr2[50] = 387;
        iArr9[86] = 386;
        iArr21[13] = 385;
        iArr22[26] = 384;
        iArr3[34] = 383;
        iArr10[3] = 382;
        iArr15[93] = 381;
        iArr3[67] = 380;
        iArr20[72] = 379;
        iArr6[17] = 378;
        iArr11[24] = 377;
        iArr18[19] = 376;
        iArr13[65] = 375;
        iArr7[78] = 374;
        iArr16[52] = 373;
        iArr14[18] = 372;
        iArr10[38] = 371;
        iArr19[26] = 370;
        iArr22[20] = 369;
        iArr9[42] = 368;
        iArr10[71] = 367;
        int[] iArr27 = iArr[17];
        iArr27[17] = 366;
        iArr20[71] = 365;
        iArr13[84] = 364;
        iArr9[40] = 363;
        iArr2[62] = 362;
        iArr9[8] = 361;
        iArr10[69] = 360;
        iArr6[79] = 359;
        iArr4[91] = 358;
        iArr2[92] = 357;
        iArr17[77] = 356;
        iArr5[16] = 355;
        iArr16[87] = 354;
        iArr10[25] = 353;
        iArr24[33] = 352;
        iArr25[76] = 351;
        iArr7[12] = 350;
        iArr15[75] = 349;
        iArr18[14] = 348;
        iArr8[26] = 347;
        iArr11[22] = 346;
        iArr17[90] = 345;
        iArr3[8] = 344;
        iArr4[41] = 343;
        iArr22[2] = 342;
        iArr21[4] = 341;
        iArr16[89] = 340;
        iArr12[41] = 339;
        iArr12[44] = 338;
        iArr20[92] = 337;
        iArr22[65] = 336;
        iArr21[14] = 335;
        iArr19[38] = 334;
        iArr3[31] = 333;
        iArr25[39] = 332;
        iArr26[41] = 331;
        iArr4[4] = 330;
        iArr11[80] = 329;
        iArr18[24] = 328;
        iArr25[17] = 327;
        iArr14[16] = 326;
        iArr14[46] = 325;
        iArr26[91] = 324;
        iArr20[89] = 323;
        iArr7[52] = 322;
        iArr6[38] = 321;
        iArr4[85] = 320;
        iArr9[12] = 319;
        iArr16[58] = 318;
        iArr6[52] = 317;
        iArr25[38] = 316;
        iArr22[41] = 315;
        iArr2[65] = 314;
        iArr6[53] = 313;
        iArr14[47] = 312;
        iArr14[19] = 311;
        iArr15[0] = 310;
        iArr25[86] = 309;
        iArr23[4] = 308;
        iArr24[54] = 307;
        iArr17[76] = 306;
        iArr7[9] = 305;
        iArr7[33] = 304;
        iArr11[17] = 303;
        iArr11[33] = 302;
        iArr4[52] = 301;
        iArr9[19] = 300;
        iArr12[45] = 299;
        iArr6[78] = 298;
        iArr11[15] = 297;
        iArr26[5] = 296;
        iArr27[40] = 295;
        iArr7[83] = 294;
        iArr13[1] = 293;
        iArr7[81] = 292;
        iArr3[40] = 291;
        iArr20[47] = 290;
        iArr27[56] = 289;
        iArr21[80] = 288;
        iArr7[46] = 287;
        iArr10[61] = 286;
        iArr15[78] = 285;
        iArr15[57] = 284;
        iArr17[46] = 283;
        iArr18[15] = 282;
        iArr18[91] = 281;
        iArr19[83] = 280;
        iArr7[77] = 279;
        iArr23[30] = 278;
        iArr7[34] = 277;
        iArr17[69] = 276;
        iArr23[10] = 275;
        iArr6[70] = 274;
        iArr14[50] = 273;
        iArr13[0] = 272;
        iArr14[64] = 271;
        iArr4[65] = 270;
        iArr14[70] = 269;
        iArr20[58] = 268;
        iArr3[66] = 267;
        iArr7[59] = 266;
        iArr25[14] = 265;
        iArr10[56] = 264;
        iArr6[85] = 263;
        iArr2[15] = 262;
        iArr24[84] = 261;
        iArr21[15] = 260;
        iArr21[90] = 259;
        iArr13[12] = 258;
        iArr19[93] = 257;
        iArr20[66] = 256;
        iArr16[90] = 255;
        iArr18[90] = 254;
        iArr14[24] = 253;
        iArr24[67] = 252;
        iArr26[90] = 251;
        iArr9[60] = 250;
        iArr11[85] = 249;
        iArr22[1] = 248;
        iArr21[37] = 247;
        iArr19[18] = 246;
        iArr22[4] = 245;
        iArr12[33] = 244;
        iArr9[13] = 243;
        iArr8[22] = 242;
        iArr7[76] = 241;
        iArr17[21] = 240;
        iArr4[66] = 239;
        iArr8[55] = 238;
        iArr8[89] = 237;
        iArr18[26] = 236;
        iArr10[80] = 235;
        iArr9[43] = 234;
        iArr4[54] = 233;
        iArr21[68] = 232;
        iArr14[88] = 231;
        iArr19[84] = 230;
        iArr19[17] = 229;
        iArr17[28] = 228;
        iArr8[1] = 227;
        iArr26[87] = 226;
        iArr4[71] = 225;
        iArr25[47] = 224;
        iArr13[77] = 223;
        iArr25[58] = 222;
        iArr22[74] = 221;
        iArr8[54] = 220;
        iArr16[33] = 219;
        iArr8[93] = 218;
        iArr11[51] = 217;
        iArr17[57] = 216;
        iArr14[37] = 215;
        iArr21[10] = 214;
        iArr21[17] = 213;
        iArr26[4] = 212;
        iArr8[84] = 211;
        iArr22[3] = 210;
        iArr12[27] = 209;
        iArr9[79] = 208;
        iArr22[21] = 207;
        iArr22[69] = 206;
        iArr19[62] = 205;
        iArr24[24] = 204;
        iArr10[89] = 203;
        iArr13[48] = 202;
        iArr4[15] = 201;
        iArr24[58] = 200;
        iArr19[56] = 199;
        iArr22[48] = 198;
        iArr19[15] = 197;
        iArr21[3] = 196;
        iArr10[44] = 195;
        iArr13[79] = 194;
        iArr18[13] = 193;
        iArr6[47] = 192;
        iArr4[88] = 191;
        iArr17[71] = 190;
        iArr10[58] = 189;
        iArr23[57] = 188;
        iArr6[30] = 187;
        iArr6[23] = 186;
        iArr22[93] = 185;
        iArr7[85] = 184;
        iArr9[80] = 183;
        iArr8[78] = 182;
        iArr25[82] = 181;
        iArr14[40] = 180;
        iArr19[69] = 179;
        iArr15[85] = 178;
        iArr2[31] = 177;
        iArr12[64] = 176;
        iArr4[13] = 175;
        iArr18[2] = 174;
        iArr14[34] = 173;
        iArr12[28] = 172;
        iArr20[91] = 171;
        iArr26[74] = 170;
        iArr6[40] = 169;
        iArr9[77] = 168;
        iArr8[80] = 167;
        iArr7[41] = 166;
        iArr11[30] = 165;
        iArr20[63] = 164;
        iArr7[53] = 163;
        iArr21[70] = 162;
        iArr11[61] = 161;
        iArr25[27] = 160;
        iArr10[55] = 159;
        iArr14[74] = 158;
        iArr15[50] = 157;
        iArr10[10] = 156;
        iArr22[63] = 155;
        iArr23[14] = 154;
        iArr27[7] = 153;
        iArr9[59] = 152;
        iArr16[23] = 151;
        iArr13[70] = 150;
        iArr8[56] = 149;
        iArr25[87] = 148;
        iArr27[61] = 147;
        iArr13[83] = 146;
        iArr11[86] = 145;
        iArr27[31] = 144;
        iArr11[83] = 143;
        iArr23[2] = 142;
        iArr13[64] = 141;
        iArr16[43] = 140;
        iArr8[42] = 139;
        iArr18[76] = 138;
        iArr3[85] = 137;
        iArr25[81] = 136;
        iArr4[83] = 135;
        iArr23[7] = 134;
        iArr10[51] = 133;
        iArr16[22] = 132;
        iArr10[76] = 131;
        iArr14[4] = 130;
        iArr4[84] = 129;
        iArr27[83] = 128;
        iArr20[46] = 127;
        iArr26[15] = 126;
        iArr17[48] = 125;
        iArr27[30] = 124;
        iArr7[93] = 123;
        iArr12[11] = 122;
        iArr12[30] = 121;
        iArr9[62] = 120;
        iArr27[87] = 119;
        iArr8[81] = 118;
        iArr11[37] = 117;
        iArr7[22] = 116;
        iArr8[66] = 115;
        iArr26[78] = 114;
        iArr19[4] = 113;
        iArr2[17] = 112;
        iArr21[61] = 111;
        iArr13[76] = 110;
        iArr9[85] = 109;
        iArr2[47] = 108;
        iArr3[57] = 107;
        iArr11[55] = 106;
        iArr16[29] = 105;
        iArr6[46] = 104;
        iArr26[0] = 103;
        iArr10[83] = 102;
        iArr21[78] = 101;
        iArr8[77] = 100;
        iArr24[25] = 99;
        iArr22[19] = 98;
        iArr4[49] = 97;
        iArr3[25] = 96;
        iArr11[53] = 95;
        iArr12[43] = 94;
        iArr2[44] = 93;
        iArr24[34] = 92;
        iArr10[34] = 91;
        iArr23[1] = 90;
        iArr3[87] = 89;
        iArr13[53] = 88;
        iArr6[54] = 87;
        iArr14[41] = 86;
        iArr4[18] = 85;
        iArr14[2] = 84;
        iArr17[3] = 83;
        iArr21[69] = 82;
        iArr7[29] = 81;
        iArr12[19] = 80;
        iArr6[90] = 79;
        iArr27[86] = 78;
        iArr9[9] = 77;
        iArr21[73] = 76;
        iArr9[37] = 75;
        iArr23[40] = 74;
        iArr26[77] = 73;
        iArr16[86] = 72;
        iArr24[79] = 71;
        iArr11[18] = 70;
        iArr22[87] = 69;
        iArr21[24] = 68;
        iArr15[8] = 67;
        iArr26[48] = 66;
        iArr21[30] = 65;
        iArr26[28] = 64;
        iArr10[67] = 63;
        iArr2[78] = 62;
        iArr8[23] = 61;
        iArr20[55] = 60;
        iArr7[68] = 59;
        iArr13[60] = 58;
        iArr9[17] = 57;
        iArr11[34] = 56;
        iArr17[49] = 55;
        iArr9[78] = 54;
        iArr20[14] = 53;
        iArr3[41] = 52;
        iArr2[55] = 51;
        iArr19[39] = 50;
        iArr23[9] = 49;
        iArr7[15] = 48;
        iArr17[52] = 47;
        iArr23[71] = 46;
        iArr17[7] = 45;
        iArr6[72] = 44;
        iArr25[77] = 43;
        iArr14[35] = 42;
        iArr17[61] = 41;
        iArr2[60] = 40;
        iArr17[93] = 39;
        iArr16[92] = 38;
        iArr12[16] = 37;
        iArr24[26] = 36;
        iArr13[89] = 35;
        iArr19[63] = 34;
        iArr14[52] = 33;
        iArr20[65] = 32;
        iArr2[8] = 31;
        iArr2[49] = 30;
        iArr26[30] = 29;
        iArr25[15] = 28;
        iArr13[18] = 27;
        iArr18[50] = 26;
        iArr6[20] = 25;
        iArr23[48] = 24;
        iArr4[75] = 23;
        iArr15[83] = 22;
        iArr19[87] = 21;
        iArr16[71] = 20;
        iArr8[91] = 19;
        iArr18[73] = 18;
        iArr10[84] = 17;
        iArr18[31] = 16;
        iArr27[90] = 15;
        iArr13[40] = 14;
        iArr27[77] = 13;
        iArr27[35] = 12;
        iArr11[52] = 11;
        iArr11[35] = 10;
        iArr10[5] = 9;
        iArr11[58] = 8;
        iArr3[60] = 7;
        iArr7[32] = 6;
        iArr4[34] = 5;
        iArr11[4] = 4;
        iArr11[1] = 3;
        iArr16[57] = 2;
        iArr21[38] = 1;
        iArr8[33] = 0;
    }

    public int x(byte[] bArr) {
        int i;
        int i2;
        byte b2;
        long j;
        int i3;
        int i4;
        byte b3;
        int i5;
        long j2;
        int length = bArr.length;
        long j3 = 0;
        long j4 = 1;
        int i6 = 0;
        int i7 = 1;
        int i8 = 1;
        while (i6 < length - 1) {
            byte b4 = bArr[i6];
            byte b5 = Ascii.ESC;
            if (b4 == 27 && (i = i6 + 3) < length) {
                byte b6 = bArr[i6 + 1];
                byte b7 = 33;
                if (b6 == 36 && bArr[i6 + 2] == 41 && bArr[i] == 65) {
                    i6 += 4;
                    while (true) {
                        byte b8 = bArr[i6];
                        if (b8 == b5) {
                            break;
                        }
                        i8++;
                        if (33 <= b8 && b8 <= 119 && 33 <= (b3 = bArr[(i4 = i6 + 1)]) && b3 <= 119) {
                            i7++;
                            int i9 = b8 - 33;
                            j4 += 500;
                            short s = this.z[i9][b3 - 33];
                            if (s != 0) {
                                i5 = i4;
                                j2 = s;
                            } else {
                                i5 = i4;
                                if (15 <= i9 && i9 < 55) {
                                    j2 = 200;
                                }
                                i6 = i5;
                            }
                            j3 += j2;
                            i6 = i5;
                        }
                        i6++;
                        b5 = Ascii.ESC;
                    }
                } else if (i < length && b6 == 36 && bArr[i6 + 2] == 41 && bArr[i] == 71) {
                    i6 += 4;
                    while (true) {
                        byte b9 = bArr[i6];
                        if (b9 == 27) {
                            break;
                        }
                        i8++;
                        if (b7 <= b9 && b9 <= 126 && b7 <= (b2 = bArr[(i2 = i6 + 1)]) && b2 <= 126) {
                            i7++;
                            j4 += 500;
                            int i10 = b9 - 33;
                            short s2 = this.D[i10][b2 - 33];
                            if (s2 != 0) {
                                j = s2;
                            } else {
                                if (35 <= i10 && i10 <= 92) {
                                    j = 150;
                                }
                                i6 = i2;
                            }
                            j3 += j;
                            i6 = i2;
                        }
                        i6++;
                        b7 = 33;
                    }
                }
                if (bArr[i6] == 27 && (i3 = i6 + 2) < length && bArr[i6 + 1] == 40 && bArr[i3] == 66) {
                    i6 = i3;
                }
            }
            i6++;
        }
        return (int) (((i7 / i8) * 50.0f) + ((j3 / j4) * 50.0f));
    }

    public int y(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i + 2;
            if (i2 < bArr.length && bArr[i] == 27 && ((char) bArr[i + 1]) == '$' && ((char) bArr[i2]) == 'B') {
                return 100;
            }
        }
        return 0;
    }

    public int z(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i + 3;
            if (i2 < bArr.length && bArr[i] == 27 && ((char) bArr[i + 1]) == '$' && ((char) bArr[i + 2]) == ')' && ((char) bArr[i2]) == 'C') {
                return 100;
            }
        }
        return 0;
    }
}
