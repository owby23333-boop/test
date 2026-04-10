package com.bytedance.sdk.component.dl.z;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class i implements a {
    boolean dl;
    public final fv g;
    public final dl z = new dl();

    i(fv fvVar) {
        if (fvVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.g = fvVar;
    }

    @Override // com.bytedance.sdk.component.dl.z.a, com.bytedance.sdk.component.dl.z.gc
    public dl dl() {
        return this.z;
    }

    @Override // com.bytedance.sdk.component.dl.z.fv
    public void a_(dl dlVar, long j) throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        this.z.a_(dlVar, j);
        q();
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    public a g(m mVar) throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        this.z.g(mVar);
        return q();
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    public a g(String str) throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        this.z.g(str);
        return q();
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    public a dl(byte[] bArr) throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        this.z.dl(bArr);
        return q();
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    public a dl(byte[] bArr, int i, int i2) throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        this.z.dl(bArr, i, i2);
        return q();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.z.write(byteBuffer);
        q();
        return iWrite;
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    public a fo(int i) throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        this.z.fo(i);
        return q();
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    public a gz(int i) throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        this.z.gz(i);
        return q();
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    public a e(int i) throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        this.z.e(i);
        return q();
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    public a wp(long j) throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        this.z.wp(j);
        return q();
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    public a kb(long j) throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        this.z.kb(j);
        return q();
    }

    @Override // com.bytedance.sdk.component.dl.z.a
    public a q() throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        long jE = this.z.e();
        if (jE > 0) {
            this.g.a_(this.z, jE);
        }
        return this;
    }

    @Override // com.bytedance.sdk.component.dl.z.a, com.bytedance.sdk.component.dl.z.fv, java.io.Flushable
    public void flush() throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        if (this.z.g > 0) {
            fv fvVar = this.g;
            dl dlVar = this.z;
            fvVar.a_(dlVar, dlVar.g);
        }
        this.g.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.dl;
    }

    @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.dl) {
            return;
        }
        try {
            if (this.z.g > 0) {
                fv fvVar = this.g;
                dl dlVar = this.z;
                fvVar.a_(dlVar, dlVar.g);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.g.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.dl = true;
        if (th != null) {
            q.z(th);
        }
    }

    @Override // com.bytedance.sdk.component.dl.z.fv
    public tb z() {
        return this.g.z();
    }

    public String toString() {
        return "buffer(" + this.g + ")";
    }
}
