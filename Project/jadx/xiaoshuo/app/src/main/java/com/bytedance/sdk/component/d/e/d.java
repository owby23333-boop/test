package com.bytedance.sdk.component.d.e;

import android.support.v4.media.session.PlaybackStateCompat;
import com.yuewen.zu0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.text.Typography;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: loaded from: classes.dex */
public final class d implements ga, tg, Cloneable, ByteChannel {
    private static final byte[] d = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    long bf;
    s e;

    @Override // com.bytedance.sdk.component.d.e.f
    public void a_(d dVar, long j) {
        if (dVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (dVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        pe.e(dVar.bf, 0L, j);
        while (j > 0) {
            s sVar = dVar.e;
            if (j < sVar.d - sVar.bf) {
                s sVar2 = this.e;
                s sVar3 = sVar2 != null ? sVar2.p : null;
                if (sVar3 != null && sVar3.ga) {
                    if ((((long) sVar3.d) + j) - ((long) (sVar3.tg ? 0 : sVar3.bf)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        sVar.e(sVar3, (int) j);
                        dVar.bf -= j;
                        this.bf += j;
                        return;
                    }
                }
                dVar.e = sVar.e((int) j);
            }
            s sVar4 = dVar.e;
            long j2 = sVar4.d - sVar4.bf;
            dVar.e = sVar4.bf();
            s sVar5 = this.e;
            if (sVar5 == null) {
                this.e = sVar4;
                sVar4.p = sVar4;
                sVar4.vn = sVar4;
            } else {
                sVar5.p.e(sVar4).d();
            }
            dVar.bf -= j2;
            this.bf += j2;
            j -= j2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a5 A[EDGE_INSN: B:44:0x00a5->B:38:0x00a5 BREAK  A[LOOP:0: B:5:0x000b->B:46:?], SYNTHETIC] */
    @Override // com.bytedance.sdk.component.d.e.ga
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long bh() {
        /*
            r14 = this;
            long r0 = r14.bf
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lac
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            com.bytedance.sdk.component.d.e.s r6 = r14.e
            byte[] r7 = r6.e
            int r8 = r6.bf
            int r9 = r6.d
        L13:
            if (r8 >= r9) goto L91
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
            if (r10 < r11) goto L72
            r11 = 70
            if (r10 > r11) goto L72
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
            com.bytedance.sdk.component.d.e.d r0 = new com.bytedance.sdk.component.d.e.d
            r0.<init>()
            com.bytedance.sdk.component.d.e.d r0 = r0.wu(r4)
            com.bytedance.sdk.component.d.e.d r0 = r0.zk(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.s()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L72:
            if (r0 == 0) goto L76
            r1 = 1
            goto L91
        L76:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L91:
            if (r8 != r9) goto L9d
            com.bytedance.sdk.component.d.e.s r7 = r6.bf()
            r14.e = r7
            com.bytedance.sdk.component.d.e.w.e(r6)
            goto L9f
        L9d:
            r6.bf = r8
        L9f:
            if (r1 != 0) goto La5
            com.bytedance.sdk.component.d.e.s r6 = r14.e
            if (r6 != 0) goto Lb
        La5:
            long r1 = r14.bf
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.bf = r1
            return r4
        Lac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.e.d.bh():long");
    }

    @Override // com.bytedance.sdk.component.d.e.k, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.bytedance.sdk.component.d.e.ga, com.bytedance.sdk.component.d.e.tg
    public d d() {
        return this;
    }

    public final vn dt() {
        long j = this.bf;
        if (j <= 2147483647L) {
            return vn((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.bf);
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public void e(long j) throws EOFException {
        if (this.bf < j) {
            throw new EOFException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        long j = this.bf;
        if (j != dVar.bf) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        s sVar = this.e;
        s sVar2 = dVar.e;
        int i = sVar.bf;
        int i2 = sVar2.bf;
        while (j2 < this.bf) {
            long jMin = Math.min(sVar.d - i, sVar2.d - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (sVar.e[i] != sVar2.e[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == sVar.d) {
                sVar = sVar.vn;
                i = sVar.bf;
            }
            if (i2 == sVar2.d) {
                sVar2 = sVar2.vn;
                i2 = sVar2.bf;
            }
            j2 += jMin;
        }
        return true;
    }

    public final void f() {
        try {
            v(this.bf);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.component.d.e.tg, com.bytedance.sdk.component.d.e.f, java.io.Flushable
    public void flush() {
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public boolean ga() {
        return this.bf == 0;
    }

    public int hashCode() {
        s sVar = this.e;
        if (sVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = sVar.d;
            for (int i3 = sVar.bf; i3 < i2; i3++) {
                i = (i * 31) + sVar.e[i3];
            }
            sVar = sVar.vn;
        } while (sVar != this.e);
        return i;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public d clone() {
        d dVar = new d();
        if (this.bf == 0) {
            return dVar;
        }
        s sVarE = this.e.e();
        dVar.e = sVarE;
        sVarE.p = sVarE;
        sVarE.vn = sVarE;
        s sVar = this.e;
        while (true) {
            sVar = sVar.vn;
            if (sVar == this.e) {
                dVar.bf = this.bf;
                return dVar;
            }
            dVar.e.p.e(sVar.e());
        }
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public byte[] l() throws EOFException {
        return p(this.bf);
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public int m() {
        long j = this.bf;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.bf);
        }
        s sVar = this.e;
        int i = sVar.bf;
        int i2 = sVar.d;
        if (i2 - i < 4) {
            return ((v() & 255) << 24) | ((v() & 255) << 16) | ((v() & 255) << 8) | (v() & 255);
        }
        byte[] bArr = sVar.e;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.bf = j - 4;
        if (i8 == i2) {
            this.e = sVar.bf();
            w.e(sVar);
        } else {
            sVar.bf = i8;
        }
        return i9;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        s sVar = this.e;
        if (sVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), sVar.d - sVar.bf);
        byteBuffer.put(sVar.e, sVar.bf, iMin);
        int i = sVar.bf + iMin;
        sVar.bf = i;
        this.bf -= (long) iMin;
        if (i == sVar.d) {
            this.e = sVar.bf();
            w.e(sVar);
        }
        return iMin;
    }

    public String s() {
        try {
            return e(this.bf, pe.e);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public vn t() throws EOFException {
        return new vn(l());
    }

    @Override // com.bytedance.sdk.component.d.e.tg
    /* JADX INFO: renamed from: tg, reason: merged with bridge method [inline-methods] */
    public d pe() {
        return this;
    }

    public String toString() {
        return dt().toString();
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public InputStream vn() {
        return new InputStream() { // from class: com.bytedance.sdk.component.d.e.d.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(d.this.bf, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                d dVar = d.this;
                if (dVar.bf > 0) {
                    return dVar.v() & 255;
                }
                return -1;
            }

            public String toString() {
                return d.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return d.this.e(bArr, i, i2);
            }
        };
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public String w() throws EOFException {
        return ga(Long.MAX_VALUE);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            s sVarGa = ga(1);
            int iMin = Math.min(i, 8192 - sVarGa.d);
            byteBuffer.get(sVarGa.e, sVarGa.d, iMin);
            i -= iMin;
            sVarGa.d += iMin;
        }
        this.bf += (long) iRemaining;
        return iRemaining;
    }

    public final d e(d dVar, long j, long j2) {
        if (dVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        pe.e(this.bf, j, j2);
        if (j2 == 0) {
            return this;
        }
        dVar.bf += j2;
        s sVar = this.e;
        while (true) {
            int i = sVar.d;
            int i2 = sVar.bf;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            sVar = sVar.vn;
        }
        while (j2 > 0) {
            s sVarE = sVar.e();
            int i3 = (int) (((long) sVarE.bf) + j);
            sVarE.bf = i3;
            sVarE.d = Math.min(i3 + ((int) j2), sVarE.d);
            s sVar2 = dVar.e;
            if (sVar2 == null) {
                sVarE.p = sVarE;
                sVarE.vn = sVarE;
                dVar.e = sVarE;
            } else {
                sVar2.p.e(sVarE);
            }
            j2 -= (long) (sVarE.d - sVarE.bf);
            sVar = sVar.vn;
            j = 0;
        }
        return this;
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public String ga(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jE = e((byte) 10, 0L, j2);
        if (jE != -1) {
            return vn(jE);
        }
        if (j2 < bf() && bf(j2 - 1) == 13 && bf(j2) == 10) {
            return vn(j2);
        }
        d dVar = new d();
        e(dVar, 0L, Math.min(32L, bf()));
        throw new EOFException("\\n not found: limit=" + Math.min(bf(), j) + " content=" + dVar.t().ga() + Typography.ellipsis);
    }

    public final long p() {
        long j = this.bf;
        if (j == 0) {
            return 0L;
        }
        s sVar = this.e.p;
        int i = sVar.d;
        return (i >= 8192 || !sVar.ga) ? j : j - ((long) (i - sVar.bf));
    }

    public String tg(long j) throws EOFException {
        return e(j, pe.e);
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public byte v() {
        long j = this.bf;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        s sVar = this.e;
        int i = sVar.bf;
        int i2 = sVar.d;
        int i3 = i + 1;
        byte b2 = sVar.e[i];
        this.bf = j - 1;
        if (i3 == i2) {
            this.e = sVar.bf();
            w.e(sVar);
        } else {
            sVar.bf = i3;
        }
        return b2;
    }

    public String vn(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (bf(j2) == 13) {
                String strTg = tg(j2);
                v(2L);
                return strTg;
            }
        }
        String strTg2 = tg(j);
        v(1L);
        return strTg2;
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public short wu() {
        return pe.e(zk());
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public int xu() {
        return pe.e(m());
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public short zk() {
        long j = this.bf;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.bf);
        }
        s sVar = this.e;
        int i = sVar.bf;
        int i2 = sVar.d;
        if (i2 - i < 2) {
            return (short) (((v() & 255) << 8) | (v() & 255));
        }
        byte[] bArr = sVar.e;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.bf = j - 2;
        if (i4 == i2) {
            this.e = sVar.bf();
            w.e(sVar);
        } else {
            sVar.bf = i4;
        }
        return (short) i5;
    }

    public final long bf() {
        return this.bf;
    }

    @Override // com.bytedance.sdk.component.d.e.tg
    /* JADX INFO: renamed from: tg, reason: merged with bridge method [inline-methods] */
    public d p(int i) {
        s sVarGa = ga(4);
        byte[] bArr = sVarGa.e;
        int i2 = sVarGa.d;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        sVarGa.d = i5 + 1;
        this.bf += 4;
        return this;
    }

    public final byte bf(long j) {
        int i;
        pe.e(this.bf, j, 1L);
        long j2 = this.bf;
        if (j2 - j > j) {
            s sVar = this.e;
            while (true) {
                int i2 = sVar.d;
                int i3 = sVar.bf;
                long j3 = i2 - i3;
                if (j < j3) {
                    return sVar.e[i3 + ((int) j)];
                }
                j -= j3;
                sVar = sVar.vn;
            }
        } else {
            long j4 = j - j2;
            try {
                s sVar2 = this.e;
                do {
                    sVar2 = sVar2.p;
                    int i4 = sVar2.d;
                    i = sVar2.bf;
                    j4 += (long) (i4 - i);
                } while (j4 < 0);
                return sVar2.e[i + ((int) j4)];
            } catch (NullPointerException unused) {
                return (byte) 0;
            }
        }
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public vn d(long j) throws EOFException {
        return new vn(p(j));
    }

    @Override // com.bytedance.sdk.component.d.e.tg
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public d v(int i) {
        s sVarGa = ga(2);
        byte[] bArr = sVarGa.e;
        int i2 = sVarGa.d;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        sVarGa.d = i3 + 1;
        this.bf += 2;
        return this;
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public byte[] p(long j) throws EOFException {
        pe.e(this.bf, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            e(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public final vn vn(int i) {
        if (i == 0) {
            return vn.bf;
        }
        return new l(this, i);
    }

    public s ga(int i) {
        if (i >= 1 && i <= 8192) {
            s sVar = this.e;
            if (sVar == null) {
                s sVarE = w.e();
                this.e = sVarE;
                sVarE.p = sVarE;
                sVarE.vn = sVarE;
                return sVarE;
            }
            s sVar2 = sVar.p;
            return (sVar2.d + i > 8192 || !sVar2.ga) ? sVar2.e(w.e()) : sVar2;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.bytedance.sdk.component.d.e.tg
    /* JADX INFO: renamed from: bf, reason: merged with bridge method [inline-methods] */
    public d d(byte[] bArr) {
        if (bArr != null) {
            return d(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public void v(long j) throws EOFException {
        s sVar;
        while (j > 0 && (sVar = this.e) != null) {
            int iMin = (int) Math.min(j, sVar.d - sVar.bf);
            long j2 = iMin;
            this.bf -= j2;
            j -= j2;
            s sVar2 = this.e;
            int i = sVar2.bf + iMin;
            sVar2.bf = i;
            if (i == sVar2.d) {
                this.e = sVar2.bf();
                w.e(sVar2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.d.e.tg
    /* JADX INFO: renamed from: bf, reason: merged with bridge method [inline-methods] */
    public d d(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            pe.e(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                s sVarGa = ga(1);
                int iMin = Math.min(i3 - i, 8192 - sVarGa.d);
                System.arraycopy(bArr, i, sVarGa.e, sVarGa.d, iMin);
                i += iMin;
                sVarGa.d += iMin;
            }
            this.bf += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public String e(Charset charset) {
        try {
            return e(this.bf, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.component.d.e.tg
    /* JADX INFO: renamed from: zk, reason: merged with bridge method [inline-methods] */
    public d xu(long j) {
        boolean z;
        if (j == 0) {
            return zk(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return bf("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j >= zu0.s) {
            i = j < 1000000000000L ? j < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < zu0.q ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        s sVarGa = ga(i);
        byte[] bArr = sVarGa.e;
        int i2 = sVarGa.d + i;
        while (j != 0) {
            i2--;
            bArr[i2] = d[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        sVarGa.d += i;
        this.bf += (long) i;
        return this;
    }

    @Override // com.bytedance.sdk.component.d.e.tg
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public d wu(long j) {
        if (j == 0) {
            return zk(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        s sVarGa = ga(iNumberOfTrailingZeros);
        byte[] bArr = sVarGa.e;
        int i = sVarGa.d;
        for (int i2 = (i + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = d[(int) (15 & j)];
            j >>>= 4;
        }
        sVarGa.d += iNumberOfTrailingZeros;
        this.bf += (long) iNumberOfTrailingZeros;
        return this;
    }

    public String e(long j, Charset charset) throws EOFException {
        pe.e(this.bf, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        s sVar = this.e;
        int i = sVar.bf;
        if (((long) i) + j > sVar.d) {
            return new String(p(j), charset);
        }
        String str = new String(sVar.e, i, (int) j, charset);
        int i2 = (int) (((long) sVar.bf) + j);
        sVar.bf = i2;
        this.bf -= j;
        if (i2 == sVar.d) {
            this.e = sVar.bf();
            w.e(sVar);
        }
        return str;
    }

    @Override // com.bytedance.sdk.component.d.e.tg
    /* JADX INFO: renamed from: bf, reason: merged with bridge method [inline-methods] */
    public d zk(int i) {
        s sVarGa = ga(1);
        byte[] bArr = sVarGa.e;
        int i2 = sVarGa.d;
        sVarGa.d = i2 + 1;
        bArr[i2] = (byte) i;
        this.bf++;
        return this;
    }

    @Override // com.bytedance.sdk.component.d.e.ga
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

    public int e(byte[] bArr, int i, int i2) {
        pe.e(bArr.length, i, i2);
        s sVar = this.e;
        if (sVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, sVar.d - sVar.bf);
        System.arraycopy(sVar.e, sVar.bf, bArr, i, iMin);
        int i3 = sVar.bf + iMin;
        sVar.bf = i3;
        this.bf -= (long) iMin;
        if (i3 == sVar.d) {
            this.e = sVar.bf();
            w.e(sVar);
        }
        return iMin;
    }

    @Override // com.bytedance.sdk.component.d.e.tg
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public d bf(vn vnVar) {
        if (vnVar != null) {
            vnVar.e(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // com.bytedance.sdk.component.d.e.tg
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public d bf(String str) {
        return e(str, 0, str.length());
    }

    public d e(String str, int i, int i2) {
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
                    s sVarGa = ga(1);
                    byte[] bArr = sVarGa.e;
                    int i3 = sVarGa.d - i;
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
                    int i5 = sVarGa.d;
                    int i6 = (i3 + i4) - i5;
                    sVarGa.d = i5 + i6;
                    this.bf += (long) i6;
                    i = i4;
                } else {
                    if (cCharAt < 2048) {
                        zk((cCharAt >> 6) | 192);
                        zk((cCharAt & '?') | 128);
                    } else if (cCharAt >= 55296 && cCharAt <= 57343) {
                        int i7 = i + 1;
                        char cCharAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                        if (cCharAt <= 56319 && cCharAt3 >= 56320 && cCharAt3 <= 57343) {
                            int i8 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                            zk((i8 >> 18) | 240);
                            zk(((i8 >> 12) & 63) | 128);
                            zk(((i8 >> 6) & 63) | 128);
                            zk((i8 & 63) | 128);
                            i += 2;
                        } else {
                            zk(63);
                            i = i7;
                        }
                    } else {
                        zk((cCharAt >> '\f') | 224);
                        zk(((cCharAt >> 6) & 63) | 128);
                        zk((cCharAt & '?') | 128);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public d e(int i) {
        if (i < 128) {
            zk(i);
        } else if (i < 2048) {
            zk((i >> 6) | 192);
            zk((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                zk(63);
            } else {
                zk((i >> 12) | 224);
                zk(((i >> 6) & 63) | 128);
                zk((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            zk((i >> 18) | 240);
            zk(((i >> 12) & 63) | 128);
            zk(((i >> 6) & 63) | 128);
            zk((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public d e(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 >= i) {
            if (i2 <= str.length()) {
                if (charset != null) {
                    if (charset.equals(pe.e)) {
                        return e(str, i, i2);
                    }
                    byte[] bytes = str.substring(i, i2).getBytes(charset);
                    return d(bytes, 0, bytes.length);
                }
                throw new IllegalArgumentException("charset == null");
            }
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public long e(k kVar) throws IOException {
        if (kVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jE = kVar.e(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (jE == -1) {
                return j;
            }
            j += jE;
        }
    }

    @Override // com.bytedance.sdk.component.d.e.k
    public long e(d dVar, long j) {
        if (dVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.bf;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            dVar.a_(this, j);
            return j;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public long e(byte b2) {
        return e(b2, 0L, Long.MAX_VALUE);
    }

    public long e(byte b2, long j, long j2) {
        s sVar;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.bf;
            long j5 = j2 > j4 ? j4 : j2;
            if (j == j5 || (sVar = this.e) == null) {
                return -1L;
            }
            if (j4 - j < j) {
                while (j4 > j) {
                    sVar = sVar.p;
                    j4 -= (long) (sVar.d - sVar.bf);
                }
            } else {
                while (true) {
                    long j6 = ((long) (sVar.d - sVar.bf)) + j3;
                    if (j6 >= j) {
                        break;
                    }
                    sVar = sVar.vn;
                    j3 = j6;
                }
                j4 = j3;
            }
            long j7 = j;
            while (j4 < j5) {
                byte[] bArr = sVar.e;
                int iMin = (int) Math.min(sVar.d, (((long) sVar.bf) + j5) - j4);
                for (int i = (int) ((((long) sVar.bf) + j7) - j4); i < iMin; i++) {
                    if (bArr[i] == b2) {
                        return ((long) (i - sVar.bf)) + j4;
                    }
                }
                j4 += (long) (sVar.d - sVar.bf);
                sVar = sVar.vn;
                j7 = j4;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.bf), Long.valueOf(j), Long.valueOf(j2)));
    }

    @Override // com.bytedance.sdk.component.d.e.ga
    public boolean e(long j, vn vnVar) {
        return e(j, vnVar, 0, vnVar.p());
    }

    public boolean e(long j, vn vnVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.bf - j < i2 || vnVar.p() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (bf(((long) i3) + j) != vnVar.e(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.d.e.k
    public dt e() {
        return dt.d;
    }
}
