package com.bytedance.sdk.component.bf.e.bf;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class e implements bf, d, Cloneable, ByteChannel {
    private static final byte[] d = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    long bf;
    ga e;

    public byte bf() {
        long j = this.bf;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        ga gaVar = this.e;
        int i = gaVar.bf;
        int i2 = gaVar.d;
        int i3 = i + 1;
        byte b2 = gaVar.e[i];
        this.bf = j - 1;
        if (i3 == i2) {
            this.e = gaVar.bf();
            vn.e(gaVar);
        } else {
            gaVar.bf = i3;
        }
        return b2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    public String d() {
        try {
            return e(this.bf, zk.e);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public boolean e() {
        return this.bf == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        long j = this.bf;
        if (j != eVar.bf) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        ga gaVar = this.e;
        ga gaVar2 = eVar.e;
        int i = gaVar.bf;
        int i2 = gaVar2.bf;
        while (j2 < this.bf) {
            long jMin = Math.min(gaVar.d - i, gaVar2.d - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (gaVar.e[i] != gaVar2.e[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == gaVar.d) {
                gaVar = gaVar.vn;
                i = gaVar.bf;
            }
            if (i2 == gaVar2.d) {
                gaVar2 = gaVar2.vn;
                i2 = gaVar2.bf;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public final tg ga() {
        long j = this.bf;
        if (j <= 2147483647L) {
            return tg((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.bf);
    }

    public int hashCode() {
        ga gaVar = this.e;
        if (gaVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = gaVar.d;
            for (int i3 = gaVar.bf; i3 < i2; i3++) {
                i = (i * 31) + gaVar.e[i3];
            }
            gaVar = gaVar.vn;
        } while (gaVar != this.e);
        return i;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        ga gaVar = this.e;
        if (gaVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), gaVar.d - gaVar.bf);
        byteBuffer.put(gaVar.e, gaVar.bf, iMin);
        int i = gaVar.bf + iMin;
        gaVar.bf = i;
        this.bf -= (long) iMin;
        if (i == gaVar.d) {
            this.e = gaVar.bf();
            vn.e(gaVar);
        }
        return iMin;
    }

    /* JADX INFO: renamed from: tg, reason: merged with bridge method [inline-methods] */
    public e clone() {
        e eVar = new e();
        if (this.bf == 0) {
            return eVar;
        }
        ga gaVarE = this.e.e();
        eVar.e = gaVarE;
        gaVarE.p = gaVarE;
        gaVarE.vn = gaVarE;
        ga gaVar = this.e;
        while (true) {
            gaVar = gaVar.vn;
            if (gaVar == this.e) {
                eVar.bf = this.bf;
                return eVar;
            }
            eVar.e.p.e(gaVar.e());
        }
    }

    public String toString() {
        return ga().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            ga gaVarD = d(1);
            int iMin = Math.min(i, 8192 - gaVarD.d);
            byteBuffer.get(gaVarD.e, gaVarD.d, iMin);
            i -= iMin;
            gaVarD.d += iMin;
        }
        this.bf += (long) iRemaining;
        return iRemaining;
    }

    public String e(long j, Charset charset) throws EOFException {
        zk.e(this.bf, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        ga gaVar = this.e;
        int i = gaVar.bf;
        if (((long) i) + j > gaVar.d) {
            return new String(e(j), charset);
        }
        String str = new String(gaVar.e, i, (int) j, charset);
        int i2 = (int) (((long) gaVar.bf) + j);
        gaVar.bf = i2;
        this.bf -= j;
        if (i2 == gaVar.d) {
            this.e = gaVar.bf();
            vn.e(gaVar);
        }
        return str;
    }

    public ga d(int i) {
        if (i >= 1 && i <= 8192) {
            ga gaVar = this.e;
            if (gaVar == null) {
                ga gaVarE = vn.e();
                this.e = gaVarE;
                gaVarE.p = gaVarE;
                gaVarE.vn = gaVarE;
                return gaVarE;
            }
            ga gaVar2 = gaVar.p;
            return (gaVar2.d + i > 8192 || !gaVar2.ga) ? gaVar2.e(vn.e()) : gaVar2;
        }
        throw new IllegalArgumentException();
    }

    public final tg tg(int i) {
        if (i == 0) {
            return tg.d;
        }
        return new p(this, i);
    }

    public e bf(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            zk.e(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                ga gaVarD = d(1);
                int iMin = Math.min(i3 - i, 8192 - gaVarD.d);
                System.arraycopy(bArr, i, gaVarD.e, gaVarD.d, iMin);
                i += iMin;
                gaVarD.d += iMin;
            }
            this.bf += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public byte[] e(long j) throws EOFException {
        zk.e(this.bf, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            e(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public void e(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iE = e(bArr, i, bArr.length - i);
            if (iE == -1) {
                throw new EOFException();
            }
            i += iE;
        }
    }

    public e bf(int i) {
        ga gaVarD = d(1);
        byte[] bArr = gaVarD.e;
        int i2 = gaVarD.d;
        gaVarD.d = i2 + 1;
        bArr[i2] = (byte) i;
        this.bf++;
        return this;
    }

    public int e(byte[] bArr, int i, int i2) {
        zk.e(bArr.length, i, i2);
        ga gaVar = this.e;
        if (gaVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, gaVar.d - gaVar.bf);
        System.arraycopy(gaVar.e, gaVar.bf, bArr, i, iMin);
        int i3 = gaVar.bf + iMin;
        gaVar.bf = i3;
        this.bf -= (long) iMin;
        if (i3 == gaVar.d) {
            this.e = gaVar.bf();
            vn.e(gaVar);
        }
        return iMin;
    }

    public e bf(long j) {
        if (j == 0) {
            return bf(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        ga gaVarD = d(iNumberOfTrailingZeros);
        byte[] bArr = gaVarD.e;
        int i = gaVarD.d;
        for (int i2 = (i + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = d[(int) (15 & j)];
            j >>>= 4;
        }
        gaVarD.d += iNumberOfTrailingZeros;
        this.bf += (long) iNumberOfTrailingZeros;
        return this;
    }

    public e e(String str) {
        return e(str, 0, str.length());
    }

    public e e(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt < 128) {
                    ga gaVarD = d(1);
                    byte[] bArr = gaVarD.e;
                    int i3 = gaVarD.d - i;
                    int iMin = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                    while (i4 < iMin) {
                        char cCharAt2 = str.charAt(i4);
                        if (cCharAt2 >= 128) {
                            break;
                        }
                        bArr[i4 + i3] = (byte) cCharAt2;
                        i4++;
                    }
                    int i5 = gaVarD.d;
                    int i6 = (i3 + i4) - i5;
                    gaVarD.d = i5 + i6;
                    this.bf += (long) i6;
                    i = i4;
                } else {
                    if (cCharAt < 2048) {
                        bf((cCharAt >> 6) | 192);
                        bf((cCharAt & '?') | 128);
                    } else if (cCharAt >= 55296 && cCharAt <= 57343) {
                        int i7 = i + 1;
                        char cCharAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                        if (cCharAt <= 56319 && cCharAt3 >= 56320 && cCharAt3 <= 57343) {
                            int i8 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                            bf((i8 >> 18) | 240);
                            bf(((i8 >> 12) & 63) | 128);
                            bf(((i8 >> 6) & 63) | 128);
                            bf((i8 & 63) | 128);
                            i += 2;
                        } else {
                            bf(63);
                            i = i7;
                        }
                    } else {
                        bf((cCharAt >> '\f') | 224);
                        bf(((cCharAt >> 6) & 63) | 128);
                        bf((cCharAt & '?') | 128);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public e e(int i) {
        if (i < 128) {
            bf(i);
        } else if (i < 2048) {
            bf((i >> 6) | 192);
            bf((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                bf(63);
            } else {
                bf((i >> 12) | 224);
                bf(((i >> 6) & 63) | 128);
                bf((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            bf((i >> 18) | 240);
            bf(((i >> 12) & 63) | 128);
            bf(((i >> 6) & 63) | 128);
            bf((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public e e(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 >= i) {
            if (i2 <= str.length()) {
                if (charset != null) {
                    if (charset.equals(zk.e)) {
                        return e(str, i, i2);
                    }
                    byte[] bytes = str.substring(i, i2).getBytes(charset);
                    return bf(bytes, 0, bytes.length);
                }
                throw new IllegalArgumentException("charset == null");
            }
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }
}
