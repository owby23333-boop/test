package com.kwad.sdk.utils.a;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private char[] bbU;
    public byte[] bbV;
    public int position;

    public static int fa(int i) {
        if ((i >> 7) == 0) {
            return 1;
        }
        if ((i >> 14) == 0) {
            return 2;
        }
        if ((i >> 21) == 0) {
            return 3;
        }
        return (i >> 28) == 0 ? 4 : 5;
    }

    public b(int i) {
        this(new byte[i], 0);
    }

    public b(byte[] bArr) {
        this(bArr, 0);
    }

    public b(byte[] bArr, int i) {
        this.bbU = null;
        this.bbV = bArr;
        this.position = i;
    }

    public final byte get() {
        byte[] bArr = this.bbV;
        int i = this.position;
        this.position = i + 1;
        return bArr[i];
    }

    public final void e(byte b) {
        byte[] bArr = this.bbV;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public final short getShort() {
        byte[] bArr = this.bbV;
        int i = this.position;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.position = i2 + 1;
        return (short) ((bArr[i2] << 8) | i3);
    }

    public final void a(short s) {
        byte[] bArr = this.bbV;
        int i = this.position;
        int i2 = i + 1;
        bArr[i] = (byte) s;
        this.position = i2 + 1;
        bArr[i2] = (byte) (s >> 8);
    }

    public final int getInt() {
        byte[] bArr = this.bbV;
        int i = this.position;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & 255) << 16);
        this.position = i5 + 1;
        return (bArr[i5] << Ascii.CAN) | i6;
    }

    public final void eY(int i) {
        byte[] bArr = this.bbV;
        int i2 = this.position;
        int i3 = i2 + 1;
        bArr[i2] = (byte) i;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >> 16);
        this.position = i5 + 1;
        bArr[i5] = (byte) (i >> 24);
    }

    public final void D(int i, int i2) {
        byte[] bArr = this.bbV;
        int i3 = i + 1;
        bArr[i] = (byte) i2;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >> 8);
        bArr[i4] = (byte) (i2 >> 16);
        bArr[i4 + 1] = (byte) (i2 >> 24);
    }

    public final int Sq() {
        byte[] bArr = this.bbV;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        byte b = bArr[i];
        if ((b >> 7) == 0) {
            return b;
        }
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = (b & 127) | (bArr[i2] << 7);
        if ((i4 >> 14) == 0) {
            return i4;
        }
        int i5 = i3 + 1;
        this.position = i5;
        int i6 = (i4 & 16383) | (bArr[i3] << 14);
        if ((i6 >> 21) == 0) {
            return i6;
        }
        int i7 = i5 + 1;
        this.position = i7;
        int i8 = (i6 & 2097151) | (bArr[i5] << Ascii.NAK);
        if ((i8 >> 28) == 0) {
            return i8;
        }
        this.position = i7 + 1;
        return (bArr[i7] << Ascii.FS) | (i8 & 268435455);
    }

    private int E(int i, int i2) {
        while ((i2 & (-128)) != 0) {
            this.bbV[i] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i++;
        }
        int i3 = i + 1;
        this.bbV[i] = (byte) i2;
        return i3;
    }

    public final void eZ(int i) {
        this.position = E(this.position, i);
    }

    public final void f(int i, long j) {
        byte[] bArr = this.bbV;
        int i2 = i + 1;
        bArr[i] = (byte) j;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j >> 8);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j >> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j >> 24);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j >> 32);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j >> 40);
        bArr[i7] = (byte) (j >> 48);
        bArr[i7 + 1] = (byte) (j >> 56);
    }

    public final void bb(long j) {
        f(this.position, j);
        this.position += 8;
    }

    private long getLong(int i) {
        byte[] bArr = this.bbV;
        int i2 = i + 1;
        long j = ((long) bArr[i]) & 255;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8) | ((((long) bArr[i3]) & 255) << 16);
        int i5 = i4 + 1;
        long j3 = j2 | ((((long) bArr[i4]) & 255) << 24);
        int i6 = i5 + 1;
        long j4 = j3 | ((((long) bArr[i5]) & 255) << 32);
        int i7 = i6 + 1;
        return j4 | ((((long) bArr[i6]) & 255) << 40) | ((255 & ((long) bArr[i7])) << 48) | (((long) bArr[i7 + 1]) << 56);
    }

    public final long getLong() {
        long j = getLong(this.position);
        this.position += 8;
        return j;
    }

    public final float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    public final double getDouble() {
        return Double.longBitsToDouble(getLong());
    }

    public final byte[] getBytes(int i) {
        byte[] bArr = new byte[i];
        System.arraycopy(this.bbV, this.position, bArr, 0, i);
        this.position += i;
        return bArr;
    }

    public final void k(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.bbV, this.position, length);
            this.position += length;
        }
    }

    public final String getString(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String strFd = fd(i);
        this.position += i;
        return strFd;
    }

    public final String fb(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String strFe = fe(i);
        this.position += i;
        return strFe;
    }

    public final void hC(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        hE(str);
    }

    public static int hD(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                i2++;
            } else if (cCharAt < 2048) {
                i2 += 2;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                i2 += 3;
            } else {
                i = i3 + 1;
                i2 += 4;
            }
            i = i3;
        }
        return i2;
    }

    private char[] fc(int i) {
        char[] cArr = this.bbU;
        if (cArr == null) {
            if (i <= 256) {
                this.bbU = new char[256];
            } else {
                this.bbU = new char[2048];
            }
        } else if (cArr.length < i) {
            this.bbU = new char[2048];
        }
        return this.bbU;
    }

    private String fd(int i) {
        if (i > 2048) {
            return new String(this.bbV, this.position, i, UTF_8);
        }
        char[] cArrFc = fc(i);
        byte[] bArr = this.bbV;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cArrFc[i4] = (char) (b ^ 1);
                i2 = i5;
                i4++;
            } else if (b < -32) {
                cArrFc[i4] = (char) (((b & Ascii.US) << 6) | (bArr[i5] & Utf8.REPLACEMENT_BYTE));
                i2 = i5 + 1;
                i4++;
            } else if (b < -16) {
                int i6 = i5 + 1;
                cArrFc[i4] = (char) (((b & 15) << 12) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i6] & Utf8.REPLACEMENT_BYTE));
                i2 = i6 + 1;
                i4++;
            } else {
                int i7 = i5 + 1;
                int i8 = i7 + 1;
                int i9 = ((b & 7) << 18) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i7] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i8] & Utf8.REPLACEMENT_BYTE);
                int i10 = i4 + 1;
                cArrFc[i4] = (char) ((i9 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i4 = i10 + 1;
                cArrFc[i10] = (char) ((i9 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) + Utf8.LOG_SURROGATE_HEADER);
                i2 = i8 + 1;
            }
        }
        if (i2 > i3) {
            throw new IllegalArgumentException("Invalid String");
        }
        return new String(cArrFc, 0, i4);
    }

    private String fe(int i) {
        if (i > 2048) {
            return new String(this.bbV, this.position, i, UTF_8);
        }
        char[] cArrFc = fc(i);
        byte[] bArr = this.bbV;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cArrFc[i4] = (char) b;
                i2 = i5;
                i4++;
            } else if (b < -32) {
                cArrFc[i4] = (char) (((b & Ascii.US) << 6) | (bArr[i5] & Utf8.REPLACEMENT_BYTE));
                i2 = i5 + 1;
                i4++;
            } else if (b < -16) {
                int i6 = i5 + 1;
                cArrFc[i4] = (char) (((b & 15) << 12) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i6] & Utf8.REPLACEMENT_BYTE));
                i2 = i6 + 1;
                i4++;
            } else {
                int i7 = i5 + 1;
                int i8 = i7 + 1;
                int i9 = ((b & 7) << 18) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i7] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i8] & Utf8.REPLACEMENT_BYTE);
                int i10 = i4 + 1;
                cArrFc[i4] = (char) ((i9 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i4 = i10 + 1;
                cArrFc[i10] = (char) ((i9 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) + Utf8.LOG_SURROGATE_HEADER);
                i2 = i8 + 1;
            }
        }
        if (i2 > i3) {
            throw new IllegalArgumentException("Invalid String");
        }
        return new String(cArrFc, 0, i4);
    }

    static String j(byte[] bArr, int i) {
        char[] cArr = new char[bArr.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cArr[i3] = (char) (b ^ 1);
                i2 = i4;
                i3++;
            } else if (b < -32) {
                cArr[i3] = (char) (((b & Ascii.US) << 6) | (bArr[i4] & Utf8.REPLACEMENT_BYTE));
                i2 = i4 + 1;
                i3++;
            } else if (b < -16) {
                int i5 = i4 + 1;
                cArr[i3] = (char) (((b & 15) << 12) | ((bArr[i4] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i5] & Utf8.REPLACEMENT_BYTE));
                i2 = i5 + 1;
                i3++;
            } else {
                int i6 = i4 + 1;
                int i7 = i6 + 1;
                int i8 = ((b & 7) << 18) | ((bArr[i4] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i6] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i7] & Utf8.REPLACEMENT_BYTE);
                int i9 = i3 + 1;
                cArr[i3] = (char) ((i8 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i3 = i9 + 1;
                cArr[i9] = (char) ((i8 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) + Utf8.LOG_SURROGATE_HEADER);
                i2 = i7 + 1;
            }
        }
        if (i2 > i) {
            throw new IllegalArgumentException("Invalid String");
        }
        return new String(cArr, 0, i3);
    }

    private void hE(String str) {
        byte[] bArr = this.bbV;
        int i = this.position;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                bArr[i] = (byte) (cCharAt ^ 1);
                i2 = i3;
                i++;
            } else if (cCharAt < 2048) {
                int i4 = i + 1;
                bArr[i] = (byte) ((cCharAt >>> 6) | 192);
                i = i4 + 1;
                bArr[i4] = (byte) ((cCharAt & '?') | 128);
                i2 = i3;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                int i5 = i + 1;
                bArr[i] = (byte) ((cCharAt >>> '\f') | 224);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((cCharAt >>> 6) & 63) | 128);
                bArr[i6] = (byte) ((cCharAt & '?') | 128);
                i2 = i3;
                i = i6 + 1;
            } else {
                int i7 = i3 + 1;
                int iCharAt = ((cCharAt << '\n') + str.charAt(i3)) - 56613888;
                int i8 = i + 1;
                bArr[i] = (byte) ((iCharAt >>> 18) | 240);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((iCharAt >>> 12) & 63) | 128);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((iCharAt >>> 6) & 63) | 128);
                i = i10 + 1;
                bArr[i10] = (byte) ((iCharAt & 63) | 128);
                i2 = i7;
            }
        }
        this.position = i;
    }

    public static byte[] hF(String str) {
        byte[] bArr = new byte[hD(str)];
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                bArr[i2] = (byte) (cCharAt ^ 1);
                i = i3;
                i2++;
            } else if (cCharAt < 2048) {
                int i4 = i2 + 1;
                bArr[i2] = (byte) ((cCharAt >>> 6) | 192);
                i2 = i4 + 1;
                bArr[i4] = (byte) ((cCharAt & '?') | 128);
                i = i3;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                int i5 = i2 + 1;
                bArr[i2] = (byte) ((cCharAt >>> '\f') | 224);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((cCharAt >>> 6) & 63) | 128);
                bArr[i6] = (byte) ((cCharAt & '?') | 128);
                i = i3;
                i2 = i6 + 1;
            } else {
                int i7 = i3 + 1;
                int iCharAt = ((cCharAt << '\n') + str.charAt(i3)) - 56613888;
                int i8 = i2 + 1;
                bArr[i2] = (byte) ((iCharAt >>> 18) | 240);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((iCharAt >>> 12) & 63) | 128);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((iCharAt >>> 6) & 63) | 128);
                i2 = i10 + 1;
                bArr[i10] = (byte) ((iCharAt & 63) | 128);
                i = i7;
            }
        }
        return bArr;
    }

    final long F(int i, int i2) {
        long j = 0;
        if (i2 <= 0) {
            return 0L;
        }
        int i3 = i2 >> 3;
        int i4 = i2 & 7;
        int i5 = 0;
        int i6 = i;
        for (int i7 = 0; i7 < i3; i7++) {
            j ^= getLong(i6);
            i6 += 8;
        }
        int i8 = i4 << 3;
        while (i5 < i8) {
            j ^= (((long) this.bbV[i6]) & 255) << i5;
            i5 += 8;
            i6++;
        }
        int i9 = (i & 7) << 3;
        return (j >>> (64 - i9)) | (j << i9);
    }
}
