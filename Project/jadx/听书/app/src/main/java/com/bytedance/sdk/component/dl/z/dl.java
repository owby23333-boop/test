package com.bytedance.sdk.component.dl.z;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.exoplayer.MediaPeriodQueue;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.text.Typography;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: loaded from: classes2.dex */
public final class dl implements a, gc, Cloneable, ByteChannel {
    private static final byte[] dl = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    long g;
    pf z;

    @Override // com.bytedance.sdk.component.dl.z.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public dl q() {
        return this;
    }

    @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.bytedance.sdk.component.dl.z.a, com.bytedance.sdk.component.dl.z.gc
    public dl dl() {
        return this;
    }

    @Override // com.bytedance.sdk.component.dl.z.a, com.bytedance.sdk.component.dl.z.fv, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final long g() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public boolean gc() {
        return this.g == 0;
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public void z(long j) throws EOFException {
        if (this.g < j) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public InputStream m() {
        return new InputStream() { // from class: com.bytedance.sdk.component.dl.z.dl.1
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (dl.this.g > 0) {
                    return dl.this.gz() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return dl.this.z(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(dl.this.g, 2147483647L);
            }

            public String toString() {
                return dl.this + ".inputStream()";
            }
        };
    }

    public final dl z(dl dlVar, long j, long j2) {
        if (dlVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        q.z(this.g, j, j2);
        if (j2 == 0) {
            return this;
        }
        dlVar.g += j2;
        pf pfVar = this.z;
        while (j >= pfVar.dl - pfVar.g) {
            j -= (long) (pfVar.dl - pfVar.g);
            pfVar = pfVar.m;
        }
        while (j2 > 0) {
            pf pfVarZ = pfVar.z();
            pfVarZ.g = (int) (((long) pfVarZ.g) + j);
            pfVarZ.dl = Math.min(pfVarZ.g + ((int) j2), pfVarZ.dl);
            pf pfVar2 = dlVar.z;
            if (pfVar2 == null) {
                pfVarZ.e = pfVarZ;
                pfVarZ.m = pfVarZ;
                dlVar.z = pfVarZ;
            } else {
                pfVar2.e.z(pfVarZ);
            }
            j2 -= (long) (pfVarZ.dl - pfVarZ.g);
            pfVar = pfVar.m;
            j = 0;
        }
        return this;
    }

    public final long e() {
        long j = this.g;
        if (j == 0) {
            return 0L;
        }
        pf pfVar = this.z.e;
        return (pfVar.dl >= 8192 || !pfVar.gc) ? j : j - ((long) (pfVar.dl - pfVar.g));
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public byte gz() {
        if (this.g == 0) {
            throw new IllegalStateException("size == 0");
        }
        pf pfVar = this.z;
        int i = pfVar.g;
        int i2 = pfVar.dl;
        int i3 = i + 1;
        byte b = pfVar.z[i];
        this.g--;
        if (i3 == i2) {
            this.z = pfVar.g();
            ls.z(pfVar);
        } else {
            pfVar.g = i3;
        }
        return b;
    }

    public final byte g(long j) {
        q.z(this.g, j, 1L);
        long j2 = this.g;
        if (j2 - j > j) {
            pf pfVar = this.z;
            while (true) {
                long j3 = pfVar.dl - pfVar.g;
                if (j >= j3) {
                    j -= j3;
                    pfVar = pfVar.m;
                } else {
                    return pfVar.z[pfVar.g + ((int) j)];
                }
            }
        } else {
            long j4 = j - j2;
            try {
                pf pfVar2 = this.z;
                do {
                    pfVar2 = pfVar2.e;
                    j4 += (long) (pfVar2.dl - pfVar2.g);
                } while (j4 < 0);
                return pfVar2.z[pfVar2.g + ((int) j4)];
            } catch (NullPointerException unused) {
                return (byte) 0;
            }
        }
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public short fo() {
        if (this.g < 2) {
            throw new IllegalStateException("size < 2: " + this.g);
        }
        pf pfVar = this.z;
        int i = pfVar.g;
        int i2 = pfVar.dl;
        if (i2 - i < 2) {
            return (short) (((gz() & 255) << 8) | (gz() & 255));
        }
        byte[] bArr = pfVar.z;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.g -= 2;
        if (i4 == i2) {
            this.z = pfVar.g();
            ls.z(pfVar);
        } else {
            pfVar.g = i4;
        }
        return (short) i5;
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public int uy() {
        if (this.g < 4) {
            throw new IllegalStateException("size < 4: " + this.g);
        }
        pf pfVar = this.z;
        int i = pfVar.g;
        int i2 = pfVar.dl;
        if (i2 - i < 4) {
            return ((gz() & 255) << 24) | ((gz() & 255) << 16) | ((gz() & 255) << 8) | (gz() & 255);
        }
        byte[] bArr = pfVar.z;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.g -= 4;
        if (i8 == i2) {
            this.z = pfVar.g();
            ls.z(pfVar);
        } else {
            pfVar.g = i8;
        }
        return i9;
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public short kb() {
        return q.z(fo());
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public int wp() {
        return q.z(uy());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1 A[EDGE_INSN: B:44:0x00a1->B:38:0x00a1 BREAK  A[LOOP:0: B:5:0x000b->B:46:?], SYNTHETIC] */
    @Override // com.bytedance.sdk.component.dl.z.gc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long i() {
        /*
            r14 = this;
            long r0 = r14.g
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto La8
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            com.bytedance.sdk.component.dl.z.pf r6 = r14.z
            byte[] r7 = r6.z
            int r8 = r6.g
            int r9 = r6.dl
        L13:
            if (r8 >= r9) goto L8d
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L70
            r11 = 70
            if (r10 > r11) goto L70
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L4a:
            com.bytedance.sdk.component.dl.z.dl r0 = new com.bytedance.sdk.component.dl.z.dl
            r0.<init>()
            com.bytedance.sdk.component.dl.z.dl r0 = r0.kb(r4)
            com.bytedance.sdk.component.dl.z.dl r0 = r0.fo(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Number too large: "
            r2.<init>(r3)
            java.lang.String r0 = r0.pf()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L70:
            if (r0 == 0) goto L74
            r1 = 1
            goto L8d
        L74:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.<init>(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L8d:
            if (r8 != r9) goto L99
            com.bytedance.sdk.component.dl.z.pf r7 = r6.g()
            r14.z = r7
            com.bytedance.sdk.component.dl.z.ls.z(r6)
            goto L9b
        L99:
            r6.g = r8
        L9b:
            if (r1 != 0) goto La1
            com.bytedance.sdk.component.dl.z.pf r6 = r14.z
            if (r6 != 0) goto Lb
        La1:
            long r1 = r14.g
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.g = r1
            return r4
        La8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.dl.z.dl.i():long");
    }

    public m v() throws EOFException {
        return new m(p());
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public m dl(long j) throws EOFException {
        return new m(e(j));
    }

    public String pf() {
        try {
            return z(this.g, q.z);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String a(long j) throws EOFException {
        return z(j, q.z);
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public String z(Charset charset) {
        try {
            return z(this.g, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String z(long j, Charset charset) throws EOFException {
        q.z(this.g, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        pf pfVar = this.z;
        if (((long) pfVar.g) + j > pfVar.dl) {
            return new String(e(j), charset);
        }
        String str = new String(pfVar.z, pfVar.g, (int) j, charset);
        pfVar.g = (int) (((long) pfVar.g) + j);
        this.g -= j;
        if (pfVar.g == pfVar.dl) {
            this.z = pfVar.g();
            ls.z(pfVar);
        }
        return str;
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public String ls() throws EOFException {
        return gc(Long.MAX_VALUE);
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public String gc(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jZ = z((byte) 10, 0L, j2);
        if (jZ != -1) {
            return m(jZ);
        }
        if (j2 < g() && g(j2 - 1) == 13 && g(j2) == 10) {
            return m(j2);
        }
        dl dlVar = new dl();
        z(dlVar, 0L, Math.min(32L, g()));
        throw new EOFException("\\n not found: limit=" + Math.min(g(), j) + " content=" + dlVar.v().gc() + Typography.ellipsis);
    }

    String m(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (g(j2) == 13) {
                String strA = a(j2);
                gz(2L);
                return strA;
            }
        }
        String strA2 = a(j);
        gz(1L);
        return strA2;
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public byte[] p() throws EOFException {
        return e(this.g);
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public byte[] e(long j) throws EOFException {
        q.z(this.g, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        byte[] bArr = new byte[(int) j];
        z(bArr);
        return bArr;
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
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
        q.z(bArr.length, i, i2);
        pf pfVar = this.z;
        if (pfVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, pfVar.dl - pfVar.g);
        System.arraycopy(pfVar.z, pfVar.g, bArr, i, iMin);
        pfVar.g += iMin;
        this.g -= (long) iMin;
        if (pfVar.g == pfVar.dl) {
            this.z = pfVar.g();
            ls.z(pfVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        pf pfVar = this.z;
        if (pfVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), pfVar.dl - pfVar.g);
        byteBuffer.put(pfVar.z, pfVar.g, iMin);
        pfVar.g += iMin;
        this.g -= (long) iMin;
        if (pfVar.g == pfVar.dl) {
            this.z = pfVar.g();
            ls.z(pfVar);
        }
        return iMin;
    }

    public final void fv() {
        try {
            gz(this.g);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public void gz(long j) throws EOFException {
        pf pfVar;
        while (j > 0 && (pfVar = this.z) != null) {
            int iMin = (int) Math.min(j, pfVar.dl - this.z.g);
            long j2 = iMin;
            this.g -= j2;
            j -= j2;
            this.z.g += iMin;
            if (this.z.g == this.z.dl) {
                pf pfVar2 = this.z;
                this.z = pfVar2.g();
                ls.z(pfVar2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public dl g(m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        mVar.z(this);
        return this;
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public dl g(String str) {
        return z(str, 0, str.length());
    }

    public dl z(String str, int i, int i2) {
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
                pf pfVarGc = gc(1);
                byte[] bArr = pfVarGc.z;
                int i3 = pfVarGc.dl - i;
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
                int i5 = (i3 + i) - pfVarGc.dl;
                pfVarGc.dl += i5;
                this.g += (long) i5;
            } else {
                if (cCharAt2 < 2048) {
                    fo((cCharAt2 >> 6) | 192);
                    fo((cCharAt2 & '?') | 128);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    fo((cCharAt2 >> '\f') | 224);
                    fo(((cCharAt2 >> 6) & 63) | 128);
                    fo((cCharAt2 & '?') | 128);
                } else {
                    int i6 = i + 1;
                    char cCharAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                    if (cCharAt2 > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        fo(63);
                        i = i6;
                    } else {
                        int i7 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        fo((i7 >> 18) | 240);
                        fo(((i7 >> 12) & 63) | 128);
                        fo(((i7 >> 6) & 63) | 128);
                        fo((i7 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public dl z(int i) {
        if (i < 128) {
            fo(i);
        } else if (i < 2048) {
            fo((i >> 6) | 192);
            fo((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                fo(63);
            } else {
                fo((i >> 12) | 224);
                fo(((i >> 6) & 63) | 128);
                fo((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            fo((i >> 18) | 240);
            fo(((i >> 12) & 63) | 128);
            fo(((i >> 6) & 63) | 128);
            fo((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public dl z(String str, int i, int i2, Charset charset) {
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
        if (charset.equals(q.z)) {
            return z(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return dl(bytes, 0, bytes.length);
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public dl dl(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return dl(bArr, 0, bArr.length);
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public dl dl(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        q.z(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            pf pfVarGc = gc(1);
            int iMin = Math.min(i3 - i, 8192 - pfVarGc.dl);
            System.arraycopy(bArr, i, pfVarGc.z, pfVarGc.dl, iMin);
            i += iMin;
            pfVarGc.dl += iMin;
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
            pf pfVarGc = gc(1);
            int iMin = Math.min(i, 8192 - pfVarGc.dl);
            byteBuffer.get(pfVarGc.z, pfVarGc.dl, iMin);
            i -= iMin;
            pfVarGc.dl += iMin;
        }
        this.g += (long) iRemaining;
        return iRemaining;
    }

    public long z(js jsVar) throws IOException {
        if (jsVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jZ = jsVar.z(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (jZ == -1) {
                return j;
            }
            j += jZ;
        }
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public dl fo(int i) {
        pf pfVarGc = gc(1);
        byte[] bArr = pfVarGc.z;
        int i2 = pfVarGc.dl;
        pfVarGc.dl = i2 + 1;
        bArr[i2] = (byte) i;
        this.g++;
        return this;
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    /* JADX INFO: renamed from: dl, reason: merged with bridge method [inline-methods] */
    public dl gz(int i) {
        pf pfVarGc = gc(2);
        byte[] bArr = pfVarGc.z;
        int i2 = pfVarGc.dl;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        pfVarGc.dl = i3 + 1;
        this.g += 2;
        return this;
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public dl e(int i) {
        pf pfVarGc = gc(4);
        byte[] bArr = pfVarGc.z;
        int i2 = pfVarGc.dl;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        pfVarGc.dl = i5 + 1;
        this.g += 4;
        return this;
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    /* JADX INFO: renamed from: fo, reason: merged with bridge method [inline-methods] */
    public dl wp(long j) {
        boolean z;
        if (j == 0) {
            return fo(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return g("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j >= 100000000) {
            i = j < MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US ? j < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        pf pfVarGc = gc(i);
        byte[] bArr = pfVarGc.z;
        int i2 = pfVarGc.dl + i;
        while (j != 0) {
            i2--;
            bArr[i2] = dl[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        pfVarGc.dl += i;
        this.g += (long) i;
        return this;
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    /* JADX INFO: renamed from: uy, reason: merged with bridge method [inline-methods] */
    public dl kb(long j) {
        if (j == 0) {
            return fo(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        pf pfVarGc = gc(iNumberOfTrailingZeros);
        byte[] bArr = pfVarGc.z;
        int i = pfVarGc.dl;
        for (int i2 = (pfVarGc.dl + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = dl[(int) (15 & j)];
            j >>>= 4;
        }
        pfVarGc.dl += iNumberOfTrailingZeros;
        this.g += (long) iNumberOfTrailingZeros;
        return this;
    }

    pf gc(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        pf pfVar = this.z;
        if (pfVar == null) {
            pf pfVarZ = ls.z();
            this.z = pfVarZ;
            pfVarZ.e = pfVarZ;
            pfVarZ.m = pfVarZ;
            return pfVarZ;
        }
        pf pfVar2 = pfVar.e;
        return (pfVar2.dl + i > 8192 || !pfVar2.gc) ? pfVar2.z(ls.z()) : pfVar2;
    }

    @Override // com.bytedance.sdk.component.dl.z.fv
    public void a_(dl dlVar, long j) {
        pf pfVar;
        if (dlVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (dlVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        q.z(dlVar.g, 0L, j);
        while (j > 0 && (pfVar = dlVar.z) != null) {
            if (j < pfVar.dl - pfVar.g) {
                pf pfVar2 = this.z;
                pf pfVar3 = pfVar2 != null ? pfVar2.e : null;
                if (pfVar3 != null && pfVar3.gc) {
                    if ((((long) pfVar3.dl) + j) - ((long) (pfVar3.f696a ? 0 : pfVar3.g)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        dlVar.z.z(pfVar3, (int) j);
                        dlVar.g -= j;
                        this.g += j;
                        return;
                    }
                }
                dlVar.z = dlVar.z.z((int) j);
            }
            pf pfVar4 = dlVar.z;
            long j2 = pfVar4.dl - pfVar4.g;
            dlVar.z = pfVar4.g();
            pf pfVar5 = this.z;
            if (pfVar5 == null) {
                this.z = pfVar4;
                pfVar4.e = pfVar4;
                pfVar4.m = pfVar4;
            } else {
                pfVar5.e.z(pfVar4).dl();
            }
            dlVar.g -= j2;
            this.g += j2;
            j -= j2;
        }
    }

    @Override // com.bytedance.sdk.component.dl.z.js
    public long z(dl dlVar, long j) {
        if (dlVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        long j2 = this.g;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        dlVar.a_(this, j);
        return j;
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public long z(byte b) {
        return z(b, 0L, Long.MAX_VALUE);
    }

    public long z(byte b, long j, long j2) {
        pf pfVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.g), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.g;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (pfVar = this.z) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                pfVar = pfVar.e;
                j4 -= (long) (pfVar.dl - pfVar.g);
            }
        } else {
            while (true) {
                long j6 = ((long) (pfVar.dl - pfVar.g)) + j3;
                if (j6 >= j) {
                    break;
                }
                pfVar = pfVar.m;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = pfVar.z;
            int iMin = (int) Math.min(pfVar.dl, (((long) pfVar.g) + j5) - j4);
            for (int i = (int) ((((long) pfVar.g) + j7) - j4); i < iMin; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - pfVar.g)) + j4;
                }
            }
            j4 += (long) (pfVar.dl - pfVar.g);
            pfVar = pfVar.m;
            j7 = j4;
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public boolean z(long j, m mVar) {
        return z(j, mVar, 0, mVar.e());
    }

    public boolean z(long j, m mVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.g - j < i2 || mVar.e() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (g(((long) i3) + j) != mVar.z(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.dl.z.fv
    public tb z() {
        return tb.dl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dl)) {
            return false;
        }
        dl dlVar = (dl) obj;
        long j = this.g;
        if (j != dlVar.g) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        pf pfVar = this.z;
        pf pfVar2 = dlVar.z;
        int i = pfVar.g;
        int i2 = pfVar2.g;
        while (j2 < this.g) {
            long jMin = Math.min(pfVar.dl - i, pfVar2.dl - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (pfVar.z[i] != pfVar2.z[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == pfVar.dl) {
                pfVar = pfVar.m;
                i = pfVar.g;
            }
            if (i2 == pfVar2.dl) {
                pfVar2 = pfVar2.m;
                i2 = pfVar2.g;
            }
            j2 += jMin;
        }
        return true;
    }

    public int hashCode() {
        pf pfVar = this.z;
        if (pfVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = pfVar.dl;
            for (int i3 = pfVar.g; i3 < i2; i3++) {
                i = (i * 31) + pfVar.z[i3];
            }
            pfVar = pfVar.m;
        } while (pfVar != this.z);
        return i;
    }

    public String toString() {
        return tb().toString();
    }

    /* JADX INFO: renamed from: js, reason: merged with bridge method [inline-methods] */
    public dl clone() {
        dl dlVar = new dl();
        if (this.g == 0) {
            return dlVar;
        }
        pf pfVarZ = this.z.z();
        dlVar.z = pfVarZ;
        pfVarZ.e = pfVarZ;
        pfVarZ.m = pfVarZ;
        pf pfVar = this.z;
        while (true) {
            pfVar = pfVar.m;
            if (pfVar != this.z) {
                dlVar.z.e.z(pfVar.z());
            } else {
                dlVar.g = this.g;
                return dlVar;
            }
        }
    }

    public final m tb() {
        long j = this.g;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.g);
        }
        return m((int) j);
    }

    public final m m(int i) {
        if (i == 0) {
            return m.g;
        }
        return new p(this, i);
    }
}
