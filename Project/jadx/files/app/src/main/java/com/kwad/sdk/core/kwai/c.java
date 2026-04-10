package com.kwad.sdk.core.kwai;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    public static class a {
        static final a afe = new a(false, false);
        static final a aff = new a(true, false);
        private static final int[] afg = new int[256];
        private static final int[] afh = new int[256];
        private final boolean afi;
        private final boolean afj = false;

        static {
            Arrays.fill(afg, -1);
            for (int i2 = 0; i2 < b.afm.length; i2++) {
                afg[b.afm[i2]] = i2;
            }
            afg[61] = -2;
            Arrays.fill(afh, -1);
            for (int i3 = 0; i3 < b.afn.length; i3++) {
                afh[b.afn[i3]] = i3;
            }
            afh[61] = -2;
        }

        private a(boolean z2, boolean z3) {
            this.afi = z2;
        }

        private int a(byte[] bArr, int i2, int i3) {
            int i4;
            int[] iArr = this.afi ? afh : afg;
            int i5 = i3 + 0;
            int i6 = 0;
            if (i5 == 0) {
                return 0;
            }
            if (i5 < 2) {
                if (this.afj && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.afj) {
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int i8 = i2 + 1;
                    int i9 = bArr[i2] & 255;
                    if (i9 == 61) {
                        i5 -= (i3 - i8) + 1;
                        break;
                    }
                    if (iArr[i9] == -1) {
                        i7++;
                    }
                    i2 = i8;
                }
                i5 -= i7;
            } else if (bArr[i3 - 1] == 61) {
                i6 = bArr[i3 - 2] == 61 ? 2 : 1;
            }
            if (i6 == 0 && (i4 = i5 & 3) != 0) {
                i6 = 4 - i4;
            }
            return (((i5 + 3) / 4) * 3) - i6;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
        
            if (r4 != 18) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x007d, code lost:
        
            if (r4 != 6) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x007f, code lost:
        
            r14[r5] = (byte) (r3 >> 16);
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0088, code lost:
        
            if (r4 != 0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x008a, code lost:
        
            r1 = r5 + 1;
            r14[r5] = (byte) (r3 >> 16);
            r5 = r1 + 1;
            r14[r1] = (byte) (r3 >> 8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x009b, code lost:
        
            if (r4 == 12) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x009d, code lost:
        
            if (r12 >= r13) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00a1, code lost:
        
            if (r10.afj == false) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a3, code lost:
        
            r14 = r12 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00a9, code lost:
        
            if (r0[r11[r12]] >= 0) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00ab, code lost:
        
            r12 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00ad, code lost:
        
            r12 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00c1, code lost:
        
            throw new java.lang.IllegalArgumentException("Input byte array has incorrect ending byte at " + r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00c2, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00cb, code lost:
        
            throw new java.lang.IllegalArgumentException("Last unit does not have enough valid bits");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int a(byte[] r11, int r12, int r13, byte[] r14) {
            /*
                Method dump skipped, instruction units count: 205
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.kwai.c.a.a(byte[], int, int, byte[]):int");
        }

        public final byte[] decode(String str) {
            return decode(str.getBytes(c.ISO_8859_1));
        }

        public final byte[] decode(byte[] bArr) {
            byte[] bArr2 = new byte[a(bArr, 0, bArr.length)];
            int iA = a(bArr, 0, bArr.length, bArr2);
            return iA != bArr2.length ? Arrays.copyOf(bArr2, iA) : bArr2;
        }
    }

    public static class b {
        static final b afk = new b(false, null, -1, true);
        static final b afl = new b(true, null, -1, false);
        private static final char[] afm = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        private static final char[] afn = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        private final boolean afi;
        private final byte[] afo = null;
        private final int afp = -1;
        private final boolean afq;

        private b(boolean z2, byte[] bArr, int i2, boolean z3) {
            this.afi = z2;
            this.afq = z3;
        }

        private final int aW(int i2) {
            int i3;
            if (this.afq) {
                i3 = ((i2 + 2) / 3) * 4;
            } else {
                int i4 = i2 % 3;
                i3 = ((i2 / 3) * 4) + (i4 == 0 ? 0 : i4 + 1);
            }
            int i5 = this.afp;
            return i5 > 0 ? i3 + (((i3 - 1) / i5) * this.afo.length) : i3;
        }

        private int b(byte[] bArr, int i2, int i3, byte[] bArr2) {
            char[] cArr = this.afi ? afn : afm;
            int i4 = ((i3 + 0) / 3) * 3;
            int i5 = i4 + 0;
            int i6 = this.afp;
            if (i6 > 0 && i4 > (i6 / 4) * 3) {
                i4 = (i6 / 4) * 3;
            }
            int i7 = 0;
            int i8 = 0;
            while (i7 < i5) {
                int iMin = Math.min(i7 + i4, i5);
                int i9 = i7;
                int i10 = i8;
                while (i9 < iMin) {
                    int i11 = i9 + 1;
                    int i12 = i11 + 1;
                    int i13 = ((bArr[i9] & 255) << 16) | ((bArr[i11] & 255) << 8);
                    int i14 = i12 + 1;
                    int i15 = i13 | (bArr[i12] & 255);
                    int i16 = i10 + 1;
                    bArr2[i10] = (byte) cArr[(i15 >>> 18) & 63];
                    int i17 = i16 + 1;
                    bArr2[i16] = (byte) cArr[(i15 >>> 12) & 63];
                    int i18 = i17 + 1;
                    bArr2[i17] = (byte) cArr[(i15 >>> 6) & 63];
                    i10 = i18 + 1;
                    bArr2[i18] = (byte) cArr[i15 & 63];
                    i9 = i14;
                }
                int i19 = ((iMin - i7) / 3) * 4;
                i8 += i19;
                if (i19 == this.afp && iMin < i3) {
                    byte[] bArr3 = this.afo;
                    int length = bArr3.length;
                    int i20 = i8;
                    int i21 = 0;
                    while (i21 < length) {
                        bArr2[i20] = bArr3[i21];
                        i21++;
                        i20++;
                    }
                    i8 = i20;
                }
                i7 = iMin;
            }
            if (i7 >= i3) {
                return i8;
            }
            int i22 = i7 + 1;
            int i23 = bArr[i7] & 255;
            int i24 = i8 + 1;
            bArr2[i8] = (byte) cArr[i23 >> 2];
            if (i22 == i3) {
                int i25 = i24 + 1;
                bArr2[i24] = (byte) cArr[(i23 << 4) & 63];
                if (!this.afq) {
                    return i25;
                }
                int i26 = i25 + 1;
                bArr2[i25] = 61;
                int i27 = i26 + 1;
                bArr2[i26] = 61;
                return i27;
            }
            int i28 = bArr[i22] & 255;
            int i29 = i24 + 1;
            bArr2[i24] = (byte) cArr[((i23 << 4) & 63) | (i28 >> 4)];
            int i30 = i29 + 1;
            bArr2[i29] = (byte) cArr[(i28 << 2) & 63];
            if (!this.afq) {
                return i30;
            }
            int i31 = i30 + 1;
            bArr2[i30] = 61;
            return i31;
        }

        public final byte[] encode(byte[] bArr) {
            byte[] bArr2 = new byte[aW(bArr.length)];
            int iB = b(bArr, 0, bArr.length, bArr2);
            return iB != bArr2.length ? Arrays.copyOf(bArr2, iB) : bArr2;
        }

        public final String encodeToString(byte[] bArr) {
            byte[] bArrEncode = encode(bArr);
            return new String(bArrEncode, 0, 0, bArrEncode.length);
        }
    }

    public static String bG(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "sDAkk/dS" + new String(vT().encode(str.getBytes()), com.kwad.sdk.crash.utils.a.UTF_8);
    }

    public static String bH(String str) {
        return TextUtils.isEmpty(str) ? "" : str.startsWith("sDAkk/dS") ? new String(vV().decode(str.substring(8)), com.kwad.sdk.crash.utils.a.UTF_8) : str;
    }

    public static boolean bI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("sDAkk/dS");
    }

    public static b vT() {
        return b.afk;
    }

    public static b vU() {
        return b.afl;
    }

    public static a vV() {
        return a.afe;
    }

    public static a vW() {
        return a.aff;
    }
}
