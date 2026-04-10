package net.oauth.signature;

import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import okio.Utf8;

/* JADX INFO: loaded from: classes9.dex */
class Base64 {
    static final int CHUNK_SIZE = 76;
    private static final int MASK_6BITS = 63;
    private static final int MASK_8BITS = 255;
    private static final byte PAD = 61;
    private byte[] buf;
    private int currentLinePos;
    private final int decodeSize;
    private final int encodeSize;
    private boolean eof;
    private final int lineLength;
    private final byte[] lineSeparator;
    private int modulus;
    private int pos;
    private int readPos;
    private int x;
    static final byte[] CHUNK_SEPARATOR = {Ascii.CR, 10};
    private static final byte[] intToBase64 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] base64ToInt = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, 16, 17, 18, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public Base64() {
        this(76, CHUNK_SEPARATOR);
    }

    private static boolean containsBase64Byte(byte[] bArr) {
        for (byte b2 : bArr) {
            if (isBase64(b2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] decodeBase64(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = new Base64();
        base64.setInitialBuffer(new byte[length], 0, length);
        base64.decode(bArr, 0, bArr.length);
        base64.decode(bArr, 0, -1);
        int i = base64.pos;
        byte[] bArr2 = new byte[i];
        base64.readResults(bArr2, 0, i);
        return bArr2;
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] discardNonBase64(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (isBase64(bArr[i2])) {
                bArr2[i] = bArr[i2];
                i++;
            }
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        if (bigInteger != null) {
            return encodeBase64(toIntegerBytes(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    public static boolean isArrayByteBase64(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!isBase64(bArr[i]) && !isWhiteSpace(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBase64(byte b2) {
        if (b2 == 61) {
            return true;
        }
        if (b2 < 0) {
            return false;
        }
        byte[] bArr = base64ToInt;
        return b2 < bArr.length && bArr[b2] != -1;
    }

    private static boolean isWhiteSpace(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    private void resizeBuf() {
        byte[] bArr = this.buf;
        if (bArr == null) {
            this.buf = new byte[8192];
            this.pos = 0;
            this.readPos = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.buf = bArr2;
        }
    }

    public static byte[] toIntegerBytes(BigInteger bigInteger) {
        int iBitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == iBitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i = 0;
        }
        int i2 = iBitLength / 8;
        int i3 = i2 - length;
        byte[] bArr = new byte[i2];
        System.arraycopy(byteArray, i, bArr, i3, length);
        return bArr;
    }

    public int avail() {
        if (this.buf != null) {
            return this.pos - this.readPos;
        }
        return 0;
    }

    public void decode(byte[] bArr, int i, int i2) {
        byte b2;
        if (this.eof) {
            return;
        }
        if (i2 < 0) {
            this.eof = true;
        }
        int i3 = 0;
        while (i3 < i2) {
            byte[] bArr2 = this.buf;
            if (bArr2 == null || bArr2.length - this.pos < this.decodeSize) {
                resizeBuf();
            }
            int i4 = i + 1;
            byte b3 = bArr[i];
            if (b3 == 61) {
                int i5 = this.x << 6;
                this.x = i5;
                int i6 = this.modulus;
                if (i6 == 2) {
                    int i7 = i5 << 6;
                    this.x = i7;
                    byte[] bArr3 = this.buf;
                    int i8 = this.pos;
                    this.pos = i8 + 1;
                    bArr3[i8] = (byte) ((i7 >> 16) & 255);
                } else if (i6 == 3) {
                    byte[] bArr4 = this.buf;
                    int i9 = this.pos;
                    int i10 = i9 + 1;
                    bArr4[i9] = (byte) ((i5 >> 16) & 255);
                    this.pos = i10 + 1;
                    bArr4[i10] = (byte) ((i5 >> 8) & 255);
                }
                this.eof = true;
                return;
            }
            if (b3 >= 0) {
                byte[] bArr5 = base64ToInt;
                if (b3 < bArr5.length && (b2 = bArr5[b3]) >= 0) {
                    int i11 = this.modulus + 1;
                    this.modulus = i11;
                    int i12 = i11 % 4;
                    this.modulus = i12;
                    int i13 = (this.x << 6) + b2;
                    this.x = i13;
                    if (i12 == 0) {
                        byte[] bArr6 = this.buf;
                        int i14 = this.pos;
                        int i15 = i14 + 1;
                        bArr6[i14] = (byte) ((i13 >> 16) & 255);
                        int i16 = i15 + 1;
                        bArr6[i15] = (byte) ((i13 >> 8) & 255);
                        this.pos = i16 + 1;
                        bArr6[i16] = (byte) (i13 & 255);
                    }
                }
            }
            i3++;
            i = i4;
        }
    }

    public void encode(byte[] bArr, int i, int i2) {
        if (this.eof) {
            return;
        }
        if (i2 < 0) {
            this.eof = true;
            byte[] bArr2 = this.buf;
            if (bArr2 == null || bArr2.length - this.pos < this.encodeSize) {
                resizeBuf();
            }
            int i3 = this.modulus;
            if (i3 == 1) {
                byte[] bArr3 = this.buf;
                int i4 = this.pos;
                int i5 = i4 + 1;
                byte[] bArr4 = intToBase64;
                int i6 = this.x;
                bArr3[i4] = bArr4[(i6 >> 2) & 63];
                int i7 = i5 + 1;
                bArr3[i5] = bArr4[(i6 << 4) & 63];
                int i8 = i7 + 1;
                bArr3[i7] = 61;
                this.pos = i8 + 1;
                bArr3[i8] = 61;
            } else if (i3 == 2) {
                byte[] bArr5 = this.buf;
                int i9 = this.pos;
                int i10 = i9 + 1;
                byte[] bArr6 = intToBase64;
                int i11 = this.x;
                bArr5[i9] = bArr6[(i11 >> 10) & 63];
                int i12 = i10 + 1;
                bArr5[i10] = bArr6[(i11 >> 4) & 63];
                int i13 = i12 + 1;
                bArr5[i12] = bArr6[(i11 << 2) & 63];
                this.pos = i13 + 1;
                bArr5[i13] = 61;
            }
            if (this.lineLength > 0) {
                byte[] bArr7 = this.lineSeparator;
                System.arraycopy(bArr7, 0, this.buf, this.pos, bArr7.length);
                this.pos += this.lineSeparator.length;
                return;
            }
            return;
        }
        int i14 = 0;
        while (i14 < i2) {
            byte[] bArr8 = this.buf;
            if (bArr8 == null || bArr8.length - this.pos < this.encodeSize) {
                resizeBuf();
            }
            int i15 = this.modulus + 1;
            this.modulus = i15;
            int i16 = i15 % 3;
            this.modulus = i16;
            int i17 = i + 1;
            int i18 = bArr[i];
            if (i18 < 0) {
                i18 += 256;
            }
            int i19 = (this.x << 8) + i18;
            this.x = i19;
            if (i16 == 0) {
                byte[] bArr9 = this.buf;
                int i20 = this.pos;
                int i21 = i20 + 1;
                byte[] bArr10 = intToBase64;
                bArr9[i20] = bArr10[(i19 >> 18) & 63];
                int i22 = i21 + 1;
                bArr9[i21] = bArr10[(i19 >> 12) & 63];
                int i23 = i22 + 1;
                bArr9[i22] = bArr10[(i19 >> 6) & 63];
                int i24 = i23 + 1;
                this.pos = i24;
                bArr9[i23] = bArr10[i19 & 63];
                int i25 = this.currentLinePos + 4;
                this.currentLinePos = i25;
                int i26 = this.lineLength;
                if (i26 > 0 && i26 <= i25) {
                    byte[] bArr11 = this.lineSeparator;
                    System.arraycopy(bArr11, 0, bArr9, i24, bArr11.length);
                    this.pos += this.lineSeparator.length;
                    this.currentLinePos = 0;
                }
            }
            i14++;
            i = i17;
        }
    }

    public boolean hasData() {
        return this.buf != null;
    }

    public int readResults(byte[] bArr, int i, int i2) {
        if (this.buf == null) {
            return this.eof ? -1 : 0;
        }
        int iMin = Math.min(avail(), i2);
        byte[] bArr2 = this.buf;
        if (bArr2 != bArr) {
            System.arraycopy(bArr2, this.readPos, bArr, i, iMin);
            int i3 = this.readPos + iMin;
            this.readPos = i3;
            if (i3 >= this.pos) {
                this.buf = null;
            }
        } else {
            this.buf = null;
        }
        return iMin;
    }

    public void setInitialBuffer(byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length != i2) {
            return;
        }
        this.buf = bArr;
        this.pos = i;
        this.readPos = i;
    }

    public Base64(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64() : new Base64(0);
        long length = (bArr.length * 4) / 3;
        long j = length % 4;
        if (j != 0) {
            length += 4 - j;
        }
        if (z) {
            length += ((length / 76) + 1) * ((long) CHUNK_SEPARATOR.length);
        }
        if (length > 2147483647L) {
            throw new IllegalArgumentException("Input array too big, output array would be bigger than Integer.MAX_VALUE=2147483647");
        }
        int i = (int) length;
        byte[] bArr2 = new byte[i];
        base64.setInitialBuffer(bArr2, 0, i);
        base64.encode(bArr, 0, bArr.length);
        base64.encode(bArr, 0, -1);
        if (base64.buf != bArr2) {
            base64.readResults(bArr2, 0, i);
        }
        return bArr2;
    }

    public Base64(int i, byte[] bArr) {
        String str;
        this.lineLength = i;
        byte[] bArr2 = new byte[bArr.length];
        this.lineSeparator = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        if (i > 0) {
            this.encodeSize = bArr.length + 4;
        } else {
            this.encodeSize = 4;
        }
        this.decodeSize = this.encodeSize - 1;
        if (containsBase64Byte(bArr)) {
            try {
                str = new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                str = new String(bArr);
            }
            throw new IllegalArgumentException("lineSeperator must not contain base64 characters: [" + str + "]");
        }
    }

    public byte[] decode(byte[] bArr) {
        return decodeBase64(bArr);
    }

    public byte[] encode(byte[] bArr) {
        return encodeBase64(bArr, false);
    }
}
