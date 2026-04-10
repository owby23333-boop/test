package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import android.support.v4.media.session.PlaybackStateCompat;
import com.tencent.smtt.sdk.TbsListener;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class c implements e, d, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f864c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    o a;
    long b;

    public int a(byte[] bArr, int i2, int i3) {
        u.a(bArr.length, i2, i3);
        o oVar = this.a;
        if (oVar == null) {
            return -1;
        }
        int iMin = Math.min(i3, oVar.f877c - oVar.b);
        System.arraycopy(oVar.a, oVar.b, bArr, i2, iMin);
        oVar.b += iMin;
        this.b -= (long) iMin;
        if (oVar.b == oVar.f877c) {
            this.a = oVar.b();
            p.a(oVar);
        }
        return iMin;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public long a(byte b) {
        return a(b, 0L, Long.MAX_VALUE);
    }

    public long a(byte b, long j2, long j3) {
        o oVar;
        long j4 = 0;
        if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.b), Long.valueOf(j2), Long.valueOf(j3)));
        }
        long j5 = this.b;
        if (j3 <= j5) {
            j5 = j3;
        }
        if (j2 == j5 || (oVar = this.a) == null) {
            return -1L;
        }
        long j6 = this.b;
        if (j6 - j2 >= j2) {
            while (true) {
                j6 = j4;
                j4 = ((long) (oVar.f877c - oVar.b)) + j6;
                if (j4 >= j2) {
                    break;
                }
                oVar = oVar.f880f;
            }
        } else {
            while (j6 > j2) {
                oVar = oVar.f881g;
                j6 -= (long) (oVar.f877c - oVar.b);
            }
        }
        long j7 = j2;
        while (j6 < j5) {
            byte[] bArr = oVar.a;
            int iMin = (int) Math.min(oVar.f877c, (((long) oVar.b) + j5) - j6);
            for (int i2 = (int) ((((long) oVar.b) + j7) - j6); i2 < iMin; i2++) {
                if (bArr[i2] == b) {
                    return j6 + ((long) (i2 - oVar.b));
                }
            }
            j7 = ((long) (oVar.f877c - oVar.b)) + j6;
            oVar = oVar.f880f;
            j6 = j7;
        }
        return -1L;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public long a(c cVar, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        long j3 = this.b;
        if (j3 == 0) {
            return -1L;
        }
        if (j2 > j3) {
            j2 = j3;
        }
        cVar.b(this, j2);
        return j2;
    }

    public long a(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j2 = 0;
        while (true) {
            long jA = sVar.a(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (jA == -1) {
                return j2;
            }
            j2 += jA;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c a() {
        return this;
    }

    public final c a(c cVar, long j2, long j3) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        u.a(this.b, j2, j3);
        if (j3 != 0) {
            cVar.b += j3;
            o oVar = this.a;
            while (true) {
                long j4 = oVar.f877c - oVar.b;
                if (j2 < j4) {
                    break;
                }
                j2 -= j4;
                oVar = oVar.f880f;
            }
            while (j3 > 0) {
                o oVarC = oVar.c();
                oVarC.b = (int) (((long) oVarC.b) + j2);
                oVarC.f877c = Math.min(oVarC.b + ((int) j3), oVarC.f877c);
                o oVar2 = cVar.a;
                if (oVar2 == null) {
                    oVarC.f881g = oVarC;
                    oVarC.f880f = oVarC;
                    cVar.a = oVarC;
                } else {
                    oVar2.f881g.a(oVarC);
                }
                j3 -= (long) (oVarC.f877c - oVarC.b);
                oVar = oVar.f880f;
                j2 = 0;
            }
        }
        return this;
    }

    public c a(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        fVar.a(this);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c a(String str) {
        return a(str, 0, str.length());
    }

    public c a(String str, int i2, int i3) {
        int i4;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i2);
        }
        if (i3 < i2) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
        }
        if (i3 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
        }
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                o oVarB = b(1);
                byte[] bArr = oVarB.a;
                int i5 = oVarB.f877c - i2;
                int iMin = Math.min(i3, 8192 - i5);
                bArr[i2 + i5] = (byte) cCharAt;
                i2++;
                while (i2 < iMin) {
                    if (str.charAt(i2) >= 128) {
                        break;
                    }
                    bArr[i2 + i5] = (byte) r0;
                    i2++;
                }
                int i6 = oVarB.f877c;
                int i7 = (i5 + i2) - i6;
                oVarB.f877c = i6 + i7;
                this.b += (long) i7;
            } else {
                if (cCharAt < 2048) {
                    i4 = (cCharAt >> 6) | 192;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    writeByte((cCharAt >> '\f') | TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
                    i4 = ((cCharAt >> 6) & 63) | 128;
                } else {
                    int i8 = i2 + 1;
                    char cCharAt2 = i8 < i3 ? str.charAt(i8) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        writeByte(63);
                        i2 = i8;
                    } else {
                        int i9 = (((cCharAt & 10239) << 10) | (9215 & cCharAt2)) + 65536;
                        writeByte((i9 >> 18) | TbsListener.ErrorCode.TPATCH_VERSION_FAILED);
                        writeByte(((i9 >> 12) & 63) | 128);
                        writeByte(((i9 >> 6) & 63) | 128);
                        writeByte((i9 & 63) | 128);
                        i2 += 2;
                    }
                }
                writeByte(i4);
                writeByte((cCharAt & '?') | 128);
                i2++;
            }
        }
        return this;
    }

    public c a(String str, int i2, int i3, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i2 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i2);
        }
        if (i3 < i2) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
        }
        if (i3 <= str.length()) {
            if (charset == null) {
                throw new IllegalArgumentException("charset == null");
            }
            if (charset.equals(u.a)) {
                return a(str, i2, i3);
            }
            byte[] bytes = str.substring(i2, i3).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
        throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
    }

    public final f a(int i2) {
        return i2 == 0 ? f.f866e : new q(this, i2);
    }

    public String a(long j2, Charset charset) throws EOFException {
        u.a(this.b, 0L, j2);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j2 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
        }
        if (j2 == 0) {
            return "";
        }
        o oVar = this.a;
        int i2 = oVar.b;
        if (((long) i2) + j2 > oVar.f877c) {
            return new String(d(j2), charset);
        }
        String str = new String(oVar.a, i2, (int) j2, charset);
        oVar.b = (int) (((long) oVar.b) + j2);
        this.b -= j2;
        if (oVar.b == oVar.f877c) {
            this.a = oVar.b();
            p.a(oVar);
        }
        return str;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String a(Charset charset) {
        try {
            return a(this.b, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void a(long j2) throws EOFException {
        if (this.b < j2) {
            throw new EOFException();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public boolean a(long j2, f fVar) {
        return a(j2, fVar, 0, fVar.e());
    }

    public boolean a(long j2, f fVar, int i2, int i3) {
        if (j2 < 0 || i2 < 0 || i3 < 0 || this.b - j2 < i3 || fVar.e() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (f(((long) i4) + j2) != fVar.a(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public f b(long j2) throws EOFException {
        return new f(d(j2));
    }

    o b(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException();
        }
        o oVar = this.a;
        if (oVar != null) {
            o oVar2 = oVar.f881g;
            return (oVar2.f877c + i2 > 8192 || !oVar2.f879e) ? oVar2.a(p.a()) : oVar2;
        }
        this.a = p.a();
        o oVar3 = this.a;
        oVar3.f881g = oVar3;
        oVar3.f880f = oVar3;
        return oVar3;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public t b() {
        return t.f884d;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
    public void b(c cVar, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        u.a(cVar.b, 0L, j2);
        while (j2 > 0) {
            o oVar = cVar.a;
            if (j2 < oVar.f877c - oVar.b) {
                o oVar2 = this.a;
                o oVar3 = oVar2 != null ? oVar2.f881g : null;
                if (oVar3 != null && oVar3.f879e) {
                    if ((((long) oVar3.f877c) + j2) - ((long) (oVar3.f878d ? 0 : oVar3.b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        cVar.a.a(oVar3, (int) j2);
                        cVar.b -= j2;
                        this.b += j2;
                        return;
                    }
                }
                cVar.a = cVar.a.a((int) j2);
            }
            o oVar4 = cVar.a;
            long j3 = oVar4.f877c - oVar4.b;
            cVar.a = oVar4.b();
            o oVar5 = this.a;
            if (oVar5 == null) {
                this.a = oVar4;
                o oVar6 = this.a;
                oVar6.f881g = oVar6;
                oVar6.f880f = oVar6;
            } else {
                oVar5.f881g.a(oVar4).a();
            }
            cVar.b -= j3;
            this.b += j3;
            j2 -= j3;
        }
    }

    public c c(int i2) {
        int i3;
        int i4;
        if (i2 >= 128) {
            if (i2 < 2048) {
                i4 = (i2 >> 6) | 192;
            } else {
                if (i2 < 65536) {
                    if (i2 < 55296 || i2 > 57343) {
                        i3 = (i2 >> 12) | TbsListener.ErrorCode.EXCEED_INCR_UPDATE;
                    } else {
                        writeByte(63);
                    }
                } else {
                    if (i2 > 1114111) {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
                    }
                    writeByte((i2 >> 18) | TbsListener.ErrorCode.TPATCH_VERSION_FAILED);
                    i3 = ((i2 >> 12) & 63) | 128;
                }
                writeByte(i3);
                i4 = ((i2 >> 6) & 63) | 128;
            }
            writeByte(i4);
            i2 = (i2 & 63) | 128;
            writeByte(i2);
        } else {
            writeByte(i2);
        }
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String c(long j2) throws EOFException {
        if (j2 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j2);
        }
        long j3 = j2 != Long.MAX_VALUE ? j2 + 1 : Long.MAX_VALUE;
        long jA = a((byte) 10, 0L, j3);
        if (jA != -1) {
            return h(jA);
        }
        if (j3 < o() && f(j3 - 1) == 13 && f(j3) == 10) {
            return h(j3);
        }
        c cVar = new c();
        a(cVar, 0L, Math.min(32L, o()));
        throw new EOFException("\\n not found: limit=" + Math.min(o(), j2) + " content=" + cVar.m().b() + (char) 8230);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public short c() {
        return u.a(readShort());
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public c m7clone() {
        c cVar = new c();
        if (this.b != 0) {
            cVar.a = this.a.c();
            o oVar = cVar.a;
            oVar.f881g = oVar;
            oVar.f880f = oVar;
            o oVar2 = this.a;
            while (true) {
                oVar2 = oVar2.f880f;
                if (oVar2 == this.a) {
                    break;
                }
                cVar.a.f881g.a(oVar2.c());
            }
            cVar.b = this.b;
        }
        return cVar;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String d() throws EOFException {
        return c(Long.MAX_VALUE);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public byte[] d(long j2) throws EOFException {
        u.a(this.b, 0L, j2);
        if (j2 <= 2147483647L) {
            byte[] bArr = new byte[(int) j2];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public int e() {
        return u.a(readInt());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c e(long j2) {
        if (j2 == 0) {
            return writeByte(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j2)) / 4) + 1;
        o oVarB = b(iNumberOfTrailingZeros);
        byte[] bArr = oVarB.a;
        int i2 = oVarB.f877c;
        for (int i3 = (i2 + iNumberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f864c[(int) (15 & j2)];
            j2 >>>= 4;
        }
        oVarB.f877c += iNumberOfTrailingZeros;
        this.b = ((long) iNumberOfTrailingZeros) + this.b;
        return this;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            long j2 = this.b;
            if (j2 != cVar.b) {
                return false;
            }
            long j3 = 0;
            if (j2 != 0) {
                o oVar = this.a;
                o oVar2 = cVar.a;
                int i2 = oVar.b;
                int i3 = oVar2.b;
                while (j3 < this.b) {
                    long jMin = Math.min(oVar.f877c - i2, oVar2.f877c - i3);
                    int i4 = i3;
                    int i5 = i2;
                    int i6 = 0;
                    while (i6 < jMin) {
                        if (oVar.a[i5] != oVar2.a[i4]) {
                            return false;
                        }
                        i6++;
                        i4++;
                        i5++;
                    }
                    if (i5 == oVar.f877c) {
                        oVar = oVar.f880f;
                        i2 = oVar.b;
                    } else {
                        i2 = i5;
                    }
                    if (i4 == oVar2.f877c) {
                        oVar2 = oVar2.f880f;
                        i3 = oVar2.b;
                    } else {
                        i3 = i4;
                    }
                    j3 += jMin;
                }
            }
        }
        return true;
    }

    public final byte f(long j2) {
        u.a(this.b, j2, 1L);
        long j3 = this.b;
        if (j3 - j2 <= j2) {
            long j4 = j2 - j3;
            try {
                o oVar = this.a;
                do {
                    oVar = oVar.f881g;
                    j4 += (long) (oVar.f877c - oVar.b);
                } while (j4 < 0);
                return oVar.a[oVar.b + ((int) j4)];
            } catch (NullPointerException unused) {
                return (byte) 0;
            }
        }
        o oVar2 = this.a;
        while (true) {
            int i2 = oVar2.f877c;
            int i3 = oVar2.b;
            long j5 = i2 - i3;
            if (j2 < j5) {
                return oVar2.a[((int) j2) + i3];
            }
            j2 -= j5;
            oVar2 = oVar2.f880f;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public boolean f() {
        return this.b == 0;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
    public void flush() {
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a6 A[EDGE_INSN: B:45:0x00a6->B:38:0x00a6 BREAK  A[LOOP:0: B:5:0x000c->B:47:?], SYNTHETIC] */
    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long g() {
        /*
            r15 = this;
            long r0 = r15.b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lad
            r0 = 0
            r0 = r2
            r4 = 0
            r5 = 0
        Lc:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.o r6 = r15.a
            byte[] r7 = r6.a
            int r8 = r6.b
            int r9 = r6.f877c
        L14:
            if (r8 >= r9) goto L92
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L23
            r11 = 57
            if (r10 > r11) goto L23
            int r11 = r10 + (-48)
            goto L3b
        L23:
            r11 = 97
            if (r10 < r11) goto L30
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L30
            int r11 = r10 + (-97)
        L2d:
            int r11 = r11 + 10
            goto L3b
        L30:
            r11 = 65
            if (r10 < r11) goto L73
            r11 = 70
            if (r10 > r11) goto L73
            int r11 = r10 + (-65)
            goto L2d
        L3b:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r0
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4b
            long r10 = (long) r11
            int r4 = r4 + 1
            int r8 = r8 + 1
            r12 = 4
            long r0 = r0 << r12
            long r0 = r0 | r10
            goto L14
        L4b:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r2 = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c
            r2.<init>()
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r0 = r2.e(r0)
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.n()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L73:
            if (r4 == 0) goto L77
            r5 = 1
            goto L92
        L77:
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
        L92:
            if (r8 != r9) goto L9e
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.o r7 = r6.b()
            r15.a = r7
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.p.a(r6)
            goto La0
        L9e:
            r6.b = r8
        La0:
            if (r5 != 0) goto La6
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.o r6 = r15.a
            if (r6 != 0) goto Lc
        La6:
            long r2 = r15.b
            long r4 = (long) r4
            long r2 = r2 - r4
            r15.b = r2
            return r0
        Lad:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto Lb6
        Lb5:
            throw r0
        Lb6:
            goto Lb5
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c.g():long");
    }

    public String g(long j2) throws EOFException {
        return a(j2, u.a);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c h() {
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String h(long r7) throws java.io.EOFException {
        /*
            r6 = this;
            r0 = 1
            r2 = 0
            int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r4 <= 0) goto L19
            long r2 = r7 - r0
            byte r4 = r6.f(r2)
            r5 = 13
            if (r4 != r5) goto L19
            java.lang.String r7 = r6.g(r2)
            r0 = 2
            goto L1d
        L19:
            java.lang.String r7 = r6.g(r7)
        L1d:
            r6.skip(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c.h(long):java.lang.String");
    }

    public int hashCode() {
        o oVar = this.a;
        if (oVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = oVar.b;
            int i4 = oVar.f877c;
            while (i3 < i4) {
                byte b = oVar.a[i3];
                i3++;
                i2 = (i2 * 31) + b;
            }
            oVar = oVar.f880f;
        } while (oVar != this.a);
        return i2;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final void j() {
        try {
            skip(this.b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final long k() {
        long j2 = this.b;
        if (j2 == 0) {
            return 0L;
        }
        o oVar = this.a.f881g;
        int i2 = oVar.f877c;
        return (i2 >= 8192 || !oVar.f879e) ? j2 : j2 - ((long) (i2 - oVar.b));
    }

    public byte[] l() throws EOFException {
        try {
            return d(this.b);
        } catch (EOFException e2) {
            throw e2;
        }
    }

    public f m() throws EOFException {
        return new f(l());
    }

    public String n() {
        try {
            return a(this.b, u.a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final long o() {
        return this.b;
    }

    public final f p() {
        long j2 = this.b;
        if (j2 <= 2147483647L) {
            return a((int) j2);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        o oVar = this.a;
        if (oVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), oVar.f877c - oVar.b);
        byteBuffer.put(oVar.a, oVar.b, iMin);
        oVar.b += iMin;
        this.b -= (long) iMin;
        if (oVar.b == oVar.f877c) {
            this.a = oVar.b();
            p.a(oVar);
        }
        return iMin;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public byte readByte() {
        long j2 = this.b;
        if (j2 == 0) {
            throw new IllegalStateException("size == 0");
        }
        o oVar = this.a;
        int i2 = oVar.b;
        int i3 = oVar.f877c;
        int i4 = i2 + 1;
        byte b = oVar.a[i2];
        this.b = j2 - 1;
        if (i4 == i3) {
            this.a = oVar.b();
            p.a(oVar);
        } else {
            oVar.b = i4;
        }
        return b;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void readFully(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int iA = a(bArr, i2, bArr.length - i2);
            if (iA == -1) {
                throw new EOFException();
            }
            i2 += iA;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public int readInt() {
        long j2 = this.b;
        if (j2 < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        o oVar = this.a;
        int i2 = oVar.b;
        int i3 = oVar.f877c;
        if (i3 - i2 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = oVar.a;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        int i8 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
        this.b = j2 - 4;
        if (i7 == i3) {
            this.a = oVar.b();
            p.a(oVar);
        } else {
            oVar.b = i7;
        }
        return i8;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public short readShort() {
        int i2;
        int i3;
        long j2 = this.b;
        if (j2 < 2) {
            throw new IllegalStateException("size < 2: " + this.b);
        }
        o oVar = this.a;
        int i4 = oVar.b;
        int i5 = oVar.f877c;
        if (i5 - i4 < 2) {
            i2 = (readByte() & 255) << 8;
            i3 = readByte() & 255;
        } else {
            byte[] bArr = oVar.a;
            int i6 = i4 + 1;
            byte b = bArr[i4];
            int i7 = i6 + 1;
            byte b2 = bArr[i6];
            this.b = j2 - 2;
            if (i7 == i5) {
                this.a = oVar.b();
                p.a(oVar);
            } else {
                oVar.b = i7;
            }
            i2 = (b & 255) << 8;
            i3 = b2 & 255;
        }
        return (short) (i2 | i3);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void skip(long j2) throws EOFException {
        o oVar;
        while (j2 > 0 && (oVar = this.a) != null) {
            int iMin = (int) Math.min(j2, oVar.f877c - oVar.b);
            long j3 = iMin;
            this.b -= j3;
            j2 -= j3;
            o oVar2 = this.a;
            oVar2.b = iMin + oVar2.b;
            if (oVar2.b == oVar2.f877c) {
                this.a = oVar2.b();
                p.a(oVar2);
            }
        }
    }

    public String toString() {
        return p().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i2 = iRemaining;
        while (i2 > 0) {
            o oVarB = b(1);
            int iMin = Math.min(i2, 8192 - oVarB.f877c);
            byteBuffer.get(oVarB.a, oVarB.f877c, iMin);
            i2 -= iMin;
            oVarB.f877c = iMin + oVarB.f877c;
        }
        this.b += (long) iRemaining;
        return iRemaining;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c write(byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j2 = i3;
        u.a(bArr.length, i2, j2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            o oVarB = b(1);
            int iMin = Math.min(i4 - i2, 8192 - oVarB.f877c);
            System.arraycopy(bArr, i2, oVarB.a, oVarB.f877c, iMin);
            i2 += iMin;
            oVarB.f877c = iMin + oVarB.f877c;
        }
        this.b += j2;
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c writeByte(int i2) {
        o oVarB = b(1);
        byte[] bArr = oVarB.a;
        int i3 = oVarB.f877c;
        oVarB.f877c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.b++;
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c writeInt(int i2) {
        o oVarB = b(4);
        byte[] bArr = oVarB.a;
        int i3 = oVarB.f877c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        oVarB.f877c = i6 + 1;
        this.b += 4;
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c writeShort(int i2) {
        o oVarB = b(2);
        byte[] bArr = oVarB.a;
        int i3 = oVarB.f877c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        oVarB.f877c = i4 + 1;
        this.b += 2;
        return this;
    }
}
