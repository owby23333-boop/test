package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import android.support.v4.media.session.PlaybackStateCompat;
import com.umeng.message.proguard.ad;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
final class n implements e {
    public final c a = new c();
    public final s b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f876c;

    n(s sVar) {
        if (sVar == null) {
            throw new NullPointerException("source == null");
        }
        this.b = sVar;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public long a(byte b) throws IOException {
        return a(b, 0L, Long.MAX_VALUE);
    }

    public long a(byte b, long j2, long j3) throws IOException {
        if (this.f876c) {
            throw new IllegalStateException("closed");
        }
        if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j2), Long.valueOf(j3)));
        }
        while (j2 < j3) {
            long jA = this.a.a(b, j2, j3);
            if (jA != -1) {
                return jA;
            }
            c cVar = this.a;
            long j4 = cVar.b;
            if (j4 >= j3 || this.b.a(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, j4);
        }
        return -1L;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public long a(c cVar, long j2) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        if (this.f876c) {
            throw new IllegalStateException("closed");
        }
        c cVar2 = this.a;
        if (cVar2.b == 0 && this.b.a(cVar2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.a.a(cVar, Math.min(j2, this.a.b));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c a() {
        return this.a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String a(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.a.a(this.b);
        return this.a.a(charset);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void a(long j2) throws IOException {
        if (!e(j2)) {
            throw new EOFException();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public boolean a(long j2, f fVar) throws IOException {
        return a(j2, fVar, 0, fVar.e());
    }

    public boolean a(long j2, f fVar, int i2, int i3) throws IOException {
        if (this.f876c) {
            throw new IllegalStateException("closed");
        }
        if (j2 < 0 || i2 < 0 || i3 < 0 || fVar.e() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            long j3 = ((long) i4) + j2;
            if (!e(1 + j3) || this.a.f(j3) != fVar.a(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public f b(long j2) throws IOException {
        a(j2);
        return this.a.b(j2);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public t b() {
        return this.b.b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String c(long j2) throws IOException {
        if (j2 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j2);
        }
        long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
        long jA = a((byte) 10, 0L, j3);
        if (jA != -1) {
            return this.a.h(jA);
        }
        if (j3 < Long.MAX_VALUE && e(j3) && this.a.f(j3 - 1) == 13 && e(1 + j3) && this.a.f(j3) == 10) {
            return this.a.h(j3);
        }
        c cVar = new c();
        c cVar2 = this.a;
        cVar2.a(cVar, 0L, Math.min(32L, cVar2.o()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.a.o(), j2) + " content=" + cVar.m().b() + (char) 8230);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public short c() throws IOException {
        a(2L);
        return this.a.c();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f876c) {
            return;
        }
        this.f876c = true;
        this.b.close();
        this.a.j();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String d() throws IOException {
        return c(Long.MAX_VALUE);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public byte[] d(long j2) throws IOException {
        a(j2);
        return this.a.d(j2);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public int e() throws IOException {
        a(4L);
        return this.a.e();
    }

    public boolean e(long j2) throws IOException {
        c cVar;
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        if (this.f876c) {
            throw new IllegalStateException("closed");
        }
        do {
            cVar = this.a;
            if (cVar.b >= j2) {
                return true;
            }
        } while (this.b.a(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public boolean f() throws IOException {
        if (this.f876c) {
            throw new IllegalStateException("closed");
        }
        return this.a.f() && this.b.a(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public long g() throws IOException {
        byte bF;
        a(1L);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!e(i3)) {
                break;
            }
            bF = this.a.f(i2);
            if ((bF < 48 || bF > 57) && ((bF < 97 || bF > 102) && (bF < 65 || bF > 70))) {
                break;
            }
            i2 = i3;
        }
        if (i2 == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bF)));
        }
        return this.a.g();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f876c;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        c cVar = this.a;
        if (cVar.b == 0 && this.b.a(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.a.read(byteBuffer);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public byte readByte() throws IOException {
        a(1L);
        return this.a.readByte();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void readFully(byte[] bArr) throws IOException {
        try {
            a(bArr.length);
            this.a.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (true) {
                c cVar = this.a;
                long j2 = cVar.b;
                if (j2 <= 0) {
                    throw e2;
                }
                int iA = cVar.a(bArr, i2, (int) j2);
                if (iA == -1) {
                    throw new AssertionError();
                }
                i2 += iA;
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public int readInt() throws IOException {
        a(4L);
        return this.a.readInt();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public short readShort() throws IOException {
        a(2L);
        return this.a.readShort();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void skip(long j2) throws IOException {
        if (this.f876c) {
            throw new IllegalStateException("closed");
        }
        while (j2 > 0) {
            c cVar = this.a;
            if (cVar.b == 0 && this.b.a(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j2, this.a.o());
            this.a.skip(jMin);
            j2 -= jMin;
        }
    }

    public String toString() {
        return "buffer(" + this.b + ad.f20406s;
    }
}
