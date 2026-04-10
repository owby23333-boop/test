package com.bytedance.sdk.component.g.z.g;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements dl, g, Cloneable, ByteChannel {
    private static final byte[] dl = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    long g;
    m z;

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public boolean z() {
        return this.g == 0;
    }

    public byte g() {
        if (this.g == 0) {
            throw new IllegalStateException("size == 0");
        }
        m mVar = this.z;
        int i = mVar.g;
        int i2 = mVar.dl;
        int i3 = i + 1;
        byte b = mVar.z[i];
        this.g--;
        if (i3 == i2) {
            this.z = mVar.g();
            e.z(mVar);
        } else {
            mVar.g = i3;
        }
        return b;
    }

    public String dl() {
        try {
            return z(this.g, uy.z);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String z(long j, Charset charset) throws EOFException {
        uy.z(this.g, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        m mVar = this.z;
        if (((long) mVar.g) + j > mVar.dl) {
            return new String(z(j), charset);
        }
        String str = new String(mVar.z, mVar.g, (int) j, charset);
        mVar.g = (int) (((long) mVar.g) + j);
        this.g -= j;
        if (mVar.g == mVar.dl) {
            this.z = mVar.g();
            e.z(mVar);
        }
        return str;
    }

    public byte[] z(long j) throws EOFException {
        uy.z(this.g, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        byte[] bArr = new byte[(int) j];
        z(bArr);
        return bArr;
    }

    public void z(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iZ = z(bArr, i, bArr.length - i);
            if (iZ == -1) {
                throw new EOFException();
            }
            i += iZ;
        }
    }

    public int z(byte[] bArr, int i, int i2) {
        uy.z(bArr.length, i, i2);
        m mVar = this.z;
        if (mVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, mVar.dl - mVar.g);
        System.arraycopy(mVar.z, mVar.g, bArr, i, iMin);
        mVar.g += iMin;
        this.g -= (long) iMin;
        if (mVar.g == mVar.dl) {
            this.z = mVar.g();
            e.z(mVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        m mVar = this.z;
        if (mVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), mVar.dl - mVar.g);
        byteBuffer.put(mVar.z, mVar.g, iMin);
        mVar.g += iMin;
        this.g -= (long) iMin;
        if (mVar.g == mVar.dl) {
            this.z = mVar.g();
            e.z(mVar);
        }
        return iMin;
    }

    public z z(String str) {
        return z(str, 0, str.length());
    }

    public z z(String str, int i, int i2) {
        char cCharAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                m mVarDl = dl(1);
                byte[] bArr = mVarDl.z;
                int i3 = mVarDl.dl - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = (i3 + i) - mVarDl.dl;
                mVarDl.dl += i5;
                this.g += (long) i5;
            } else {
                if (cCharAt2 < 2048) {
                    g((cCharAt2 >> 6) | 192);
                    g((cCharAt2 & '?') | 128);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    g((cCharAt2 >> '\f') | 224);
                    g(((cCharAt2 >> 6) & 63) | 128);
                    g((cCharAt2 & '?') | 128);
                } else {
                    int i6 = i + 1;
                    char cCharAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                    if (cCharAt2 > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        g(63);
                        i = i6;
                    } else {
                        int i7 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        g((i7 >> 18) | 240);
                        g(((i7 >> 12) & 63) | 128);
                        g(((i7 >> 6) & 63) | 128);
                        g((i7 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public z z(int i) {
        if (i < 128) {
            g(i);
        } else if (i < 2048) {
            g((i >> 6) | 192);
            g((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                g(63);
            } else {
                g((i >> 12) | 224);
                g(((i >> 6) & 63) | 128);
                g((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            g((i >> 18) | 240);
            g(((i >> 12) & 63) | 128);
            g(((i >> 6) & 63) | 128);
            g((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public z z(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(uy.z)) {
            return z(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return g(bytes, 0, bytes.length);
    }

    public z g(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        uy.z(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            m mVarDl = dl(1);
            int iMin = Math.min(i3 - i, 8192 - mVarDl.dl);
            System.arraycopy(bArr, i, mVarDl.z, mVarDl.dl, iMin);
            i += iMin;
            mVarDl.dl += iMin;
        }
        this.g += j;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            m mVarDl = dl(1);
            int iMin = Math.min(i, 8192 - mVarDl.dl);
            byteBuffer.get(mVarDl.z, mVarDl.dl, iMin);
            i -= iMin;
            mVarDl.dl += iMin;
        }
        this.g += (long) iRemaining;
        return iRemaining;
    }

    public z g(int i) {
        m mVarDl = dl(1);
        byte[] bArr = mVarDl.z;
        int i2 = mVarDl.dl;
        mVarDl.dl = i2 + 1;
        bArr[i2] = (byte) i;
        this.g++;
        return this;
    }

    public z g(long j) {
        if (j == 0) {
            return g(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        m mVarDl = dl(iNumberOfTrailingZeros);
        byte[] bArr = mVarDl.z;
        int i = mVarDl.dl;
        for (int i2 = (mVarDl.dl + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = dl[(int) (15 & j)];
            j >>>= 4;
        }
        mVarDl.dl += iNumberOfTrailingZeros;
        this.g += (long) iNumberOfTrailingZeros;
        return this;
    }

    m dl(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        m mVar = this.z;
        if (mVar == null) {
            m mVarZ = e.z();
            this.z = mVarZ;
            mVarZ.e = mVarZ;
            mVarZ.m = mVarZ;
            return mVarZ;
        }
        m mVar2 = mVar.e;
        return (mVar2.dl + i > 8192 || !mVar2.gc) ? mVar2.z(e.z()) : mVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        long j = this.g;
        if (j != zVar.g) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        m mVar = this.z;
        m mVar2 = zVar.z;
        int i = mVar.g;
        int i2 = mVar2.g;
        while (j2 < this.g) {
            long jMin = Math.min(mVar.dl - i, mVar2.dl - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (mVar.z[i] != mVar2.z[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == mVar.dl) {
                mVar = mVar.m;
                i = mVar.g;
            }
            if (i2 == mVar2.dl) {
                mVar2 = mVar2.m;
                i2 = mVar2.g;
            }
            j2 += jMin;
        }
        return true;
    }

    public int hashCode() {
        m mVar = this.z;
        if (mVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = mVar.dl;
            for (int i3 = mVar.g; i3 < i2; i3++) {
                i = (i * 31) + mVar.z[i3];
            }
            mVar = mVar.m;
        } while (mVar != this.z);
        return i;
    }

    public String toString() {
        return gc().toString();
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public z clone() {
        z zVar = new z();
        if (this.g == 0) {
            return zVar;
        }
        m mVarZ = this.z.z();
        zVar.z = mVarZ;
        mVarZ.e = mVarZ;
        mVarZ.m = mVarZ;
        m mVar = this.z;
        while (true) {
            mVar = mVar.m;
            if (mVar != this.z) {
                zVar.z.e.z(mVar.z());
            } else {
                zVar.g = this.g;
                return zVar;
            }
        }
    }

    public final a gc() {
        long j = this.g;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.g);
        }
        return a((int) j);
    }

    public final a a(int i) {
        if (i == 0) {
            return a.dl;
        }
        return new gz(this, i);
    }
}
