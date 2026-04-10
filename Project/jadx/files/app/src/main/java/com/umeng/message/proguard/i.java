package com.umeng.message.proguard;

import com.umeng.analytics.pro.cb;
import java.math.BigInteger;
import okio.Utf8;

/* JADX INFO: compiled from: Base64.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends j {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f20452m = 6;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f20453n = 3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f20454o = 4;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f20458s = 63;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final byte[] f20459t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final byte[] f20460u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final byte[] f20461v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f20462w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f20463x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f20464y;
    static final byte[] a = {cb.f19602k, 10};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final byte[] f20455p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final byte[] f20456q = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final byte[] f20457r = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, cb.f19602k, cb.f19603l, cb.f19604m, cb.f19605n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public i() {
        this(0);
    }

    public static byte[] c(byte[] bArr) {
        return a(bArr, false);
    }

    public static String d(byte[] bArr) {
        return g.a(a(bArr, false));
    }

    public static byte[] e(byte[] bArr) {
        return a(bArr, false, true);
    }

    public static String f(byte[] bArr) {
        return g.a(a(bArr, false, true));
    }

    public static byte[] g(byte[] bArr) {
        return a(bArr, true);
    }

    public static byte[] h(byte[] bArr) {
        return new i().j(bArr);
    }

    public static BigInteger i(byte[] bArr) {
        return new BigInteger(1, h(bArr));
    }

    public boolean a() {
        return this.f20459t == f20456q;
    }

    @Override // com.umeng.message.proguard.j
    void b(byte[] bArr, int i2, int i3) {
        byte b;
        if (this.f20473j) {
            return;
        }
        if (i3 < 0) {
            this.f20473j = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            a(this.f20462w);
            int i5 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 == 61) {
                this.f20473j = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = f20457r;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    this.f20475l = (this.f20475l + 1) % 4;
                    this.f20464y = (this.f20464y << 6) + b;
                    if (this.f20475l == 0) {
                        byte[] bArr3 = this.f20471h;
                        int i6 = this.f20472i;
                        this.f20472i = i6 + 1;
                        int i7 = this.f20464y;
                        bArr3[i6] = (byte) ((i7 >> 16) & 255);
                        int i8 = this.f20472i;
                        this.f20472i = i8 + 1;
                        bArr3[i8] = (byte) ((i7 >> 8) & 255);
                        int i9 = this.f20472i;
                        this.f20472i = i9 + 1;
                        bArr3[i9] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!this.f20473j || this.f20475l == 0) {
            return;
        }
        a(this.f20462w);
        int i10 = this.f20475l;
        if (i10 == 2) {
            this.f20464y >>= 4;
            byte[] bArr4 = this.f20471h;
            int i11 = this.f20472i;
            this.f20472i = i11 + 1;
            bArr4[i11] = (byte) (this.f20464y & 255);
            return;
        }
        if (i10 != 3) {
            return;
        }
        this.f20464y >>= 2;
        byte[] bArr5 = this.f20471h;
        int i12 = this.f20472i;
        this.f20472i = i12 + 1;
        int i13 = this.f20464y;
        bArr5[i12] = (byte) ((i13 >> 8) & 255);
        int i14 = this.f20472i;
        this.f20472i = i14 + 1;
        bArr5[i14] = (byte) (i13 & 255);
    }

    public i(boolean z2) {
        this(76, a, z2);
    }

    @Override // com.umeng.message.proguard.j
    void a(byte[] bArr, int i2, int i3) {
        if (this.f20473j) {
            return;
        }
        if (i3 >= 0) {
            int i4 = i2;
            int i5 = 0;
            while (i5 < i3) {
                a(this.f20463x);
                this.f20475l = (this.f20475l + 1) % 3;
                int i6 = i4 + 1;
                int i7 = bArr[i4];
                if (i7 < 0) {
                    i7 += 256;
                }
                this.f20464y = (this.f20464y << 8) + i7;
                if (this.f20475l == 0) {
                    byte[] bArr2 = this.f20471h;
                    int i8 = this.f20472i;
                    this.f20472i = i8 + 1;
                    byte[] bArr3 = this.f20459t;
                    int i9 = this.f20464y;
                    bArr2[i8] = bArr3[(i9 >> 18) & 63];
                    int i10 = this.f20472i;
                    this.f20472i = i10 + 1;
                    bArr2[i10] = bArr3[(i9 >> 12) & 63];
                    int i11 = this.f20472i;
                    this.f20472i = i11 + 1;
                    bArr2[i11] = bArr3[(i9 >> 6) & 63];
                    int i12 = this.f20472i;
                    this.f20472i = i12 + 1;
                    bArr2[i12] = bArr3[i9 & 63];
                    this.f20474k += 4;
                    int i13 = this.f20470g;
                    if (i13 > 0 && i13 <= this.f20474k) {
                        byte[] bArr4 = this.f20461v;
                        System.arraycopy(bArr4, 0, bArr2, this.f20472i, bArr4.length);
                        this.f20472i += this.f20461v.length;
                        this.f20474k = 0;
                    }
                }
                i5++;
                i4 = i6;
            }
            return;
        }
        this.f20473j = true;
        if (this.f20475l == 0 && this.f20470g == 0) {
            return;
        }
        a(this.f20463x);
        int i14 = this.f20472i;
        int i15 = this.f20475l;
        if (i15 == 1) {
            byte[] bArr5 = this.f20471h;
            this.f20472i = i14 + 1;
            byte[] bArr6 = this.f20459t;
            int i16 = this.f20464y;
            bArr5[i14] = bArr6[(i16 >> 2) & 63];
            int i17 = this.f20472i;
            this.f20472i = i17 + 1;
            bArr5[i17] = bArr6[(i16 << 4) & 63];
            if (bArr6 == f20455p) {
                int i18 = this.f20472i;
                this.f20472i = i18 + 1;
                bArr5[i18] = 61;
                int i19 = this.f20472i;
                this.f20472i = i19 + 1;
                bArr5[i19] = 61;
            }
        } else if (i15 == 2) {
            byte[] bArr7 = this.f20471h;
            this.f20472i = i14 + 1;
            byte[] bArr8 = this.f20459t;
            int i20 = this.f20464y;
            bArr7[i14] = bArr8[(i20 >> 10) & 63];
            int i21 = this.f20472i;
            this.f20472i = i21 + 1;
            bArr7[i21] = bArr8[(i20 >> 4) & 63];
            int i22 = this.f20472i;
            this.f20472i = i22 + 1;
            bArr7[i22] = bArr8[(i20 << 2) & 63];
            if (bArr8 == f20455p) {
                int i23 = this.f20472i;
                this.f20472i = i23 + 1;
                bArr7[i23] = 61;
            }
        }
        int i24 = this.f20474k;
        int i25 = this.f20472i;
        this.f20474k = i24 + (i25 - i14);
        if (this.f20470g <= 0 || this.f20474k <= 0) {
            return;
        }
        byte[] bArr9 = this.f20461v;
        System.arraycopy(bArr9, 0, this.f20471h, i25, bArr9.length);
        this.f20472i += this.f20461v.length;
    }

    public i(int i2) {
        this(i2, a);
    }

    public i(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    public i(int i2, byte[] bArr, boolean z2) {
        super(3, 4, i2, bArr == null ? 0 : bArr.length);
        this.f20460u = f20457r;
        if (bArr != null) {
            if (l(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + g.a(bArr) + "]");
            }
            if (i2 > 0) {
                this.f20463x = bArr.length + 4;
                this.f20461v = new byte[bArr.length];
                System.arraycopy(bArr, 0, this.f20461v, 0, bArr.length);
            } else {
                this.f20463x = 4;
                this.f20461v = null;
            }
        } else {
            this.f20463x = 4;
            this.f20461v = null;
        }
        this.f20462w = this.f20463x - 1;
        this.f20459t = z2 ? f20456q : f20455p;
    }

    public static boolean b(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!a(bArr[i2]) && !j.c(bArr[i2])) {
                return false;
            }
        }
        return true;
    }

    static byte[] b(BigInteger bigInteger) {
        int iBitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == iBitLength / 8) {
            return byteArray;
        }
        int i2 = 0;
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
            i2 = 1;
        }
        int i3 = iBitLength / 8;
        int i4 = i3 - length;
        byte[] bArr = new byte[i3];
        System.arraycopy(byteArray, i2, bArr, i4, length);
        return bArr;
    }

    @Override // com.umeng.message.proguard.j
    protected boolean b(byte b) {
        if (b >= 0) {
            byte[] bArr = this.f20460u;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = f20457r;
                if (b >= bArr.length || bArr[b] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean a(byte[] bArr) {
        return b(bArr);
    }

    public static byte[] a(byte[] bArr, boolean z2) {
        return a(bArr, z2, false);
    }

    public static byte[] a(byte[] bArr, boolean z2, boolean z3) {
        return a(bArr, z2, z3, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] bArr, boolean z2, boolean z3, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        i iVar = z2 ? new i(z3) : new i(0, a, z3);
        long jM = iVar.m(bArr);
        if (jM <= i2) {
            return iVar.k(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + jM + ") than the specified maximum size of " + i2);
    }

    public static byte[] a(String str) {
        return new i().b(str);
    }

    public static byte[] a(BigInteger bigInteger) {
        if (bigInteger != null) {
            return a(b(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }
}
