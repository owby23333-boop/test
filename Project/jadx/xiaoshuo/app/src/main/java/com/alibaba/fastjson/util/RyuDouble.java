package com.alibaba.fastjson.util;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.yuewen.zu0;
import java.lang.reflect.Array;
import java.math.BigInteger;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: loaded from: classes.dex */
public final class RyuDouble {
    private static final int[][] POW5_INV_SPLIT;
    private static final int[][] POW5_SPLIT;

    static {
        int[] iArr = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_PROBESIZE, 4};
        Class cls = Integer.TYPE;
        POW5_SPLIT = (int[][]) Array.newInstance((Class<?>) cls, iArr);
        POW5_INV_SPLIT = (int[][]) Array.newInstance((Class<?>) cls, 291, 4);
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger bigIntegerSubtract = bigInteger.shiftLeft(31).subtract(bigInteger);
        BigInteger bigIntegerSubtract2 = bigInteger.shiftLeft(31).subtract(bigInteger);
        int i = 0;
        while (i < 326) {
            BigInteger bigIntegerPow = BigInteger.valueOf(5L).pow(i);
            int iBitLength = bigIntegerPow.bitLength();
            int i2 = i == 0 ? 1 : (int) ((((((long) i) * 23219280) + zu0.q) - 1) / zu0.q);
            if (i2 != iBitLength) {
                throw new IllegalStateException(iBitLength + " != " + i2);
            }
            if (i < POW5_SPLIT.length) {
                for (int i3 = 0; i3 < 4; i3++) {
                    POW5_SPLIT[i][i3] = bigIntegerPow.shiftRight((iBitLength - 121) + ((3 - i3) * 31)).and(bigIntegerSubtract).intValue();
                }
            }
            if (i < POW5_INV_SPLIT.length) {
                BigInteger bigInteger2 = BigInteger.ONE;
                BigInteger bigIntegerAdd = bigInteger2.shiftLeft(iBitLength + 121).divide(bigIntegerPow).add(bigInteger2);
                for (int i4 = 0; i4 < 4; i4++) {
                    if (i4 == 0) {
                        POW5_INV_SPLIT[i][i4] = bigIntegerAdd.shiftRight((3 - i4) * 31).intValue();
                    } else {
                        POW5_INV_SPLIT[i][i4] = bigIntegerAdd.shiftRight((3 - i4) * 31).and(bigIntegerSubtract2).intValue();
                    }
                }
            }
            i++;
        }
    }

    public static String toString(double d) {
        char[] cArr = new char[24];
        return new String(cArr, 0, toString(d, cArr, 0));
    }

    public static int toString(double d, char[] cArr, int i) {
        int i2;
        boolean z;
        boolean z2;
        int i3;
        long j;
        long j2;
        boolean z3;
        boolean z4;
        int i4;
        long j3;
        long j4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z5;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        if (!Double.isNaN(d)) {
            if (d == Double.POSITIVE_INFINITY) {
                int i14 = i + 1;
                cArr[i] = 'I';
                int i15 = i14 + 1;
                cArr[i14] = 'n';
                int i16 = i15 + 1;
                cArr[i15] = 'f';
                int i17 = i16 + 1;
                cArr[i16] = 'i';
                int i18 = i17 + 1;
                cArr[i17] = 'n';
                int i19 = i18 + 1;
                cArr[i18] = 'i';
                int i20 = i19 + 1;
                cArr[i19] = 't';
                i12 = i20 + 1;
                cArr[i20] = 'y';
            } else if (d == Double.NEGATIVE_INFINITY) {
                int i21 = i + 1;
                cArr[i] = '-';
                int i22 = i21 + 1;
                cArr[i21] = 'I';
                int i23 = i22 + 1;
                cArr[i22] = 'n';
                int i24 = i23 + 1;
                cArr[i23] = 'f';
                int i25 = i24 + 1;
                cArr[i24] = 'i';
                int i26 = i25 + 1;
                cArr[i25] = 'n';
                int i27 = i26 + 1;
                cArr[i26] = 'i';
                int i28 = i27 + 1;
                cArr[i27] = 't';
                i13 = i28 + 1;
                cArr[i28] = 'y';
            } else {
                long jDoubleToLongBits = Double.doubleToLongBits(d);
                if (jDoubleToLongBits == 0) {
                    int i29 = i + 1;
                    cArr[i] = '0';
                    int i30 = i29 + 1;
                    cArr[i29] = '.';
                    i13 = i30 + 1;
                    cArr[i30] = '0';
                } else {
                    if (jDoubleToLongBits != Long.MIN_VALUE) {
                        int i31 = (int) ((jDoubleToLongBits >>> 52) & 2047);
                        long j5 = jDoubleToLongBits & 4503599627370495L;
                        if (i31 == 0) {
                            i2 = -1074;
                        } else {
                            i2 = (i31 - 1023) - 52;
                            j5 |= 4503599627370496L;
                        }
                        boolean z6 = jDoubleToLongBits < 0;
                        boolean z7 = (j5 & 1) == 0;
                        long j6 = 4 * j5;
                        long j7 = j6 + 2;
                        int i32 = (j5 != 4503599627370496L || i31 <= 1) ? 1 : 0;
                        long j8 = (j6 - 1) - ((long) i32);
                        int i33 = i2 - 2;
                        if (i33 >= 0) {
                            int iMax = Math.max(0, ((int) ((((long) i33) * 3010299) / zu0.q)) - 1);
                            int i34 = ((((-i33) + iMax) + (((iMax == 0 ? 1 : (int) ((((((long) iMax) * 23219280) + zu0.q) - 1) / zu0.q)) + 122) - 1)) - 93) - 21;
                            if (i34 >= 0) {
                                int[] iArr = POW5_INV_SPLIT[iMax];
                                long j9 = j6 >>> 31;
                                long j10 = j6 & 2147483647L;
                                int i35 = iArr[0];
                                z = z6;
                                int i36 = iArr[1];
                                int i37 = iArr[2];
                                z2 = z7;
                                int i38 = iArr[3];
                                long j11 = ((((((((((((j10 * ((long) i38)) >>> 31) + (((long) i37) * j10)) + (j9 * ((long) i38))) >>> 31) + (((long) i36) * j10)) + (((long) i37) * j9)) >>> 31) + (((long) i35) * j10)) + (((long) i36) * j9)) >>> 21) + ((((long) i35) * j9) << 10)) >>> i34;
                                long j12 = j7 >>> 31;
                                long j13 = j7 & 2147483647L;
                                long j14 = ((((((((((((j13 * ((long) i38)) >>> 31) + (((long) i37) * j13)) + (j12 * ((long) i38))) >>> 31) + (((long) i36) * j13)) + (((long) i37) * j12)) >>> 31) + (((long) i35) * j13)) + (((long) i36) * j12)) >>> 21) + ((((long) i35) * j12) << 10)) >>> i34;
                                long j15 = j8 >>> 31;
                                long j16 = j8 & 2147483647L;
                                long j17 = j14;
                                long j18 = ((((((((((((j16 * ((long) i38)) >>> 31) + (((long) i37) * j16)) + (j15 * ((long) i38))) >>> 31) + (((long) i36) * j16)) + (((long) i37) * j15)) >>> 31) + (((long) i35) * j16)) + (((long) i36) * j15)) >>> 21) + ((((long) i35) * j15) << 10)) >>> i34;
                                if (iMax <= 21) {
                                    long j19 = j6 % 5;
                                    if (j19 == 0) {
                                        if (j19 != 0) {
                                            i11 = 0;
                                        } else if (j6 % 25 != 0) {
                                            i11 = 1;
                                        } else if (j6 % 125 != 0) {
                                            i11 = 2;
                                        } else if (j6 % 625 != 0) {
                                            i11 = 3;
                                        } else {
                                            long j20 = j6 / 625;
                                            i11 = 4;
                                            for (long j21 = 0; j20 > j21 && j20 % 5 == j21; j21 = 0) {
                                                j20 /= 5;
                                                i11++;
                                            }
                                        }
                                        z5 = i11 >= iMax;
                                        z4 = false;
                                        j = j11;
                                        j2 = j17;
                                        i3 = 2;
                                        z3 = z5;
                                        j3 = j18;
                                        i4 = iMax;
                                    } else if (z2) {
                                        if (j8 % 5 != 0) {
                                            i10 = 0;
                                        } else if (j8 % 25 != 0) {
                                            i10 = 1;
                                        } else if (j8 % 125 != 0) {
                                            i10 = 2;
                                        } else if (j8 % 625 != 0) {
                                            i10 = 3;
                                        } else {
                                            long j22 = j8 / 625;
                                            i10 = 4;
                                            for (long j23 = 0; j22 > j23 && j22 % 5 == j23; j23 = 0) {
                                                j22 /= 5;
                                                i10++;
                                            }
                                        }
                                        z4 = i10 >= iMax;
                                        z5 = false;
                                        j = j11;
                                        j2 = j17;
                                        i3 = 2;
                                        z3 = z5;
                                        j3 = j18;
                                        i4 = iMax;
                                    } else {
                                        if (j7 % 5 != 0) {
                                            i9 = 0;
                                        } else if (j7 % 25 != 0) {
                                            i9 = 1;
                                        } else if (j7 % 125 != 0) {
                                            i9 = 2;
                                        } else if (j7 % 625 != 0) {
                                            i9 = 3;
                                        } else {
                                            long j24 = j7 / 625;
                                            i9 = 4;
                                            for (long j25 = 0; j24 > j25 && j24 % 5 == j25; j25 = 0) {
                                                j24 /= 5;
                                                i9++;
                                            }
                                        }
                                        if (i9 >= iMax) {
                                            j17--;
                                        }
                                    }
                                    z4 = false;
                                    j = j11;
                                    j2 = j17;
                                    i3 = 2;
                                    z3 = z5;
                                    j3 = j18;
                                    i4 = iMax;
                                } else {
                                    z4 = false;
                                    j = j11;
                                    j2 = j17;
                                    i3 = 2;
                                    z3 = z5;
                                    j3 = j18;
                                    i4 = iMax;
                                }
                            } else {
                                throw new IllegalArgumentException("" + i34);
                            }
                        } else {
                            z = z6;
                            z2 = z7;
                            int i39 = -i33;
                            int iMax2 = Math.max(0, ((int) ((((long) i39) * 6989700) / zu0.q)) - 1);
                            int i40 = i39 - iMax2;
                            int i41 = ((iMax2 - ((i40 == 0 ? 1 : (int) ((((((long) i40) * 23219280) + zu0.q) - 1) / zu0.q)) - 121)) - 93) - 21;
                            if (i41 >= 0) {
                                int[] iArr2 = POW5_SPLIT[i40];
                                long j26 = j6 >>> 31;
                                long j27 = j6 & 2147483647L;
                                int i42 = iArr2[0];
                                int i43 = iArr2[1];
                                int i44 = i32;
                                i3 = 2;
                                int i45 = iArr2[2];
                                int i46 = iArr2[3];
                                long j28 = ((((((((((((j27 * ((long) i46)) >>> 31) + (((long) i45) * j27)) + (j26 * ((long) i46))) >>> 31) + (((long) i43) * j27)) + (((long) i45) * j26)) >>> 31) + (((long) i42) * j27)) + (((long) i43) * j26)) >>> 21) + ((((long) i42) * j26) << 10)) >>> i41;
                                long j29 = j7 >>> 31;
                                long j30 = j7 & 2147483647L;
                                j = j28;
                                long j31 = ((((((((((((j30 * ((long) i46)) >>> 31) + (((long) i45) * j30)) + (j29 * ((long) i46))) >>> 31) + (((long) i43) * j30)) + (((long) i45) * j29)) >>> 31) + (((long) i42) * j30)) + (((long) i43) * j29)) >>> 21) + ((((long) i42) * j29) << 10)) >>> i41;
                                long j32 = j8 >>> 31;
                                long j33 = j8 & 2147483647L;
                                j2 = j31;
                                long j34 = ((((((((((((j33 * ((long) i46)) >>> 31) + (((long) i45) * j33)) + (j32 * ((long) i46))) >>> 31) + (((long) i43) * j33)) + (((long) i45) * j32)) >>> 31) + (((long) i42) * j33)) + (((long) i43) * j32)) >>> 21) + ((((long) i42) * j32) << 10)) >>> i41;
                                int i47 = iMax2 + i33;
                                z3 = true;
                                if (iMax2 > 1) {
                                    z3 = iMax2 < 63 && (j6 & ((1 << (iMax2 - 1)) - 1)) == 0;
                                } else if (z2) {
                                    z4 = i44 == 1;
                                    i4 = i47;
                                    j3 = j34;
                                } else {
                                    j2--;
                                }
                                z4 = false;
                                i4 = i47;
                                j3 = j34;
                            } else {
                                throw new IllegalArgumentException("" + i41);
                            }
                        }
                        int i48 = j2 >= 1000000000000000000L ? 19 : j2 >= 100000000000000000L ? 18 : j2 >= 10000000000000000L ? 17 : j2 >= 1000000000000000L ? 16 : j2 >= 100000000000000L ? 15 : j2 >= 10000000000000L ? 14 : j2 >= 1000000000000L ? 13 : j2 >= 100000000000L ? 12 : j2 >= RealConnection.IDLE_CONNECTION_HEALTHY_NS ? 11 : j2 >= 1000000000 ? 10 : j2 >= zu0.s ? 9 : j2 >= zu0.q ? 8 : j2 >= 1000000 ? 7 : j2 >= 100000 ? 6 : j2 >= 10000 ? 5 : j2 >= 1000 ? 4 : j2 >= 100 ? 3 : j2 >= 10 ? i3 : 1;
                        int i49 = (i4 + i48) - 1;
                        boolean z8 = i49 < -3 || i49 >= 7;
                        if (z4 || z3) {
                            boolean z9 = z4;
                            int i50 = 0;
                            int i51 = 0;
                            while (true) {
                                long j35 = j2 / 10;
                                long j36 = j3 / 10;
                                if (j35 <= j36 || (j2 < 100 && z8)) {
                                    break;
                                }
                                z9 &= j3 % 10 == 0;
                                z3 &= i50 == 0;
                                i50 = (int) (j % 10);
                                j /= 10;
                                i51++;
                                j2 = j35;
                                j3 = j36;
                            }
                            if (z9 && z2) {
                                while (j3 % 10 == 0 && (j2 >= 100 || !z8)) {
                                    z3 &= i50 == 0;
                                    i50 = (int) (j % 10);
                                    j2 /= 10;
                                    j /= 10;
                                    j3 /= 10;
                                    i51++;
                                }
                            }
                            if (z3 && i50 == 5 && j % 2 == 0) {
                                i50 = 4;
                            }
                            j4 = j + ((long) (((j != j3 || (z9 && z2)) && i50 < 5) ? 0 : 1));
                            i5 = i51;
                        } else {
                            i5 = 0;
                            int i52 = 0;
                            while (true) {
                                long j37 = j2 / 10;
                                long j38 = j3 / 10;
                                if (j37 <= j38 || (j2 < 100 && z8)) {
                                    break;
                                }
                                i52 = (int) (j % 10);
                                j /= 10;
                                i5++;
                                j2 = j37;
                                j3 = j38;
                            }
                            j4 = j + ((long) ((j == j3 || i52 >= 5) ? 1 : 0));
                        }
                        int i53 = i48 - i5;
                        if (z) {
                            i6 = i + 1;
                            cArr[i] = '-';
                        } else {
                            i6 = i;
                        }
                        if (z8) {
                            for (int i54 = 0; i54 < i53 - 1; i54++) {
                                int i55 = (int) (j4 % 10);
                                j4 /= 10;
                                cArr[(i6 + i53) - i54] = (char) (i55 + 48);
                            }
                            cArr[i6] = (char) ((j4 % 10) + 48);
                            cArr[i6 + 1] = '.';
                            int i56 = i6 + i53 + 1;
                            if (i53 == 1) {
                                cArr[i56] = '0';
                                i56++;
                            }
                            int i57 = i56 + 1;
                            cArr[i56] = 'E';
                            if (i49 < 0) {
                                cArr[i57] = '-';
                                i49 = -i49;
                                i57++;
                            }
                            if (i49 >= 100) {
                                int i58 = i57 + 1;
                                i8 = 48;
                                cArr[i57] = (char) ((i49 / 100) + 48);
                                i49 %= 100;
                                i57 = i58 + 1;
                                cArr[i58] = (char) ((i49 / 10) + 48);
                            } else {
                                i8 = 48;
                                if (i49 >= 10) {
                                    cArr[i57] = (char) ((i49 / 10) + 48);
                                    i57++;
                                }
                            }
                            cArr[i57] = (char) ((i49 % 10) + i8);
                            return (i57 + 1) - i;
                        }
                        char c = '0';
                        if (i49 < 0) {
                            int i59 = i6 + 1;
                            cArr[i6] = '0';
                            int i60 = i59 + 1;
                            cArr[i59] = '.';
                            int i61 = -1;
                            while (i61 > i49) {
                                cArr[i60] = c;
                                i61--;
                                i60++;
                                c = '0';
                            }
                            i7 = i60;
                            for (int i62 = 0; i62 < i53; i62++) {
                                cArr[((i60 + i53) - i62) - 1] = (char) ((j4 % 10) + 48);
                                j4 /= 10;
                                i7++;
                            }
                        } else {
                            int i63 = i49 + 1;
                            if (i63 >= i53) {
                                for (int i64 = 0; i64 < i53; i64++) {
                                    cArr[((i6 + i53) - i64) - 1] = (char) ((j4 % 10) + 48);
                                    j4 /= 10;
                                }
                                int i65 = i6 + i53;
                                while (i53 < i63) {
                                    cArr[i65] = '0';
                                    i53++;
                                    i65++;
                                }
                                int i66 = i65 + 1;
                                cArr[i65] = '.';
                                i7 = i66 + 1;
                                cArr[i66] = '0';
                            } else {
                                int i67 = i6 + 1;
                                for (int i68 = 0; i68 < i53; i68++) {
                                    if ((i53 - i68) - 1 == i49) {
                                        cArr[((i67 + i53) - i68) - 1] = '.';
                                        i67--;
                                    }
                                    cArr[((i67 + i53) - i68) - 1] = (char) ((j4 % 10) + 48);
                                    j4 /= 10;
                                }
                                i7 = i6 + i53 + 1;
                            }
                        }
                        return i7 - i;
                    }
                    int i69 = i + 1;
                    cArr[i] = '-';
                    int i70 = i69 + 1;
                    cArr[i69] = '0';
                    int i71 = i70 + 1;
                    cArr[i70] = '.';
                    i12 = i71 + 1;
                    cArr[i71] = '0';
                }
            }
            return i12 - i;
        }
        int i72 = i + 1;
        cArr[i] = 'N';
        int i73 = i72 + 1;
        cArr[i72] = 'a';
        i13 = i73 + 1;
        cArr[i73] = 'N';
        return i13 - i;
    }
}
