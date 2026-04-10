package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import com.umeng.message.proguard.ad;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
final class m implements d {
    public final c a = new c();
    public final r b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f875c;

    m(r rVar) {
        if (rVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.b = rVar;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c a() {
        return this.a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d a(String str) throws IOException {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(str);
        return h();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
    public t b() {
        return this.b.b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
    public void b(c cVar, long j2) throws IOException {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(cVar, j2);
        h();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f875c) {
            return;
        }
        try {
            if (this.a.b > 0) {
                this.b.b(this.a, this.a.b);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.b.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f875c = true;
        if (th == null) {
            return;
        }
        u.a(th);
        throw null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d e(long j2) throws IOException {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.a.e(j2);
        return h();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
    public void flush() throws IOException {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        c cVar = this.a;
        long j2 = cVar.b;
        if (j2 > 0) {
            this.b.b(cVar, j2);
        }
        this.b.flush();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d h() throws IOException {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        long jK = this.a.k();
        if (jK > 0) {
            this.b.b(this.a, jK);
        }
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f875c;
    }

    public String toString() {
        return "buffer(" + this.b + ad.f20406s;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.a.write(byteBuffer);
        h();
        return iWrite;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d write(byte[] bArr) throws IOException {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.a.write(bArr);
        return h();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d write(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.a.write(bArr, i2, i3);
        return h();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d writeByte(int i2) throws IOException {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeByte(i2);
        return h();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d writeInt(int i2) throws IOException {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeInt(i2);
        return h();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d writeShort(int i2) throws IOException {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeShort(i2);
        return h();
    }
}
