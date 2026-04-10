package com.yuewen;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes2.dex */
public class fk2 extends InputStream {
    public static final int i = 1024;
    public static final int j = 1024;
    public static final /* synthetic */ boolean k = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f11147b;
    public boolean c;
    public Thread d;
    public Thread e;
    public byte[] f;
    public int g;
    public int h;

    public fk2(gk2 gk2Var) throws IOException {
        this(gk2Var, 1024);
    }

    public final void a() throws IOException {
        while (this.g == this.h) {
            b();
            notifyAll();
            try {
                wait(2000L);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        }
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        int i2 = this.g;
        if (i2 < 0) {
            return 0;
        }
        int i3 = this.h;
        if (i2 == i3) {
            return this.f.length;
        }
        if (i2 > i3) {
            return i2 - i3;
        }
        return (i2 + this.f.length) - i3;
    }

    public final void b() throws IOException {
        if (!this.c) {
            throw new IOException("Pipe not connected");
        }
        if (this.f11146a || this.f11147b) {
            throw new IOException("Pipe closed");
        }
        Thread thread = this.d;
        if (thread != null && !thread.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    public void c(gk2 gk2Var) throws IOException {
        gk2Var.a(this);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f11147b = true;
        synchronized (this) {
            this.g = -1;
        }
    }

    public final void d(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.f = new byte[i2];
    }

    public synchronized void e(int i2) throws IOException {
        b();
        this.e = Thread.currentThread();
        if (this.g == this.h) {
            a();
        }
        if (this.g < 0) {
            this.g = 0;
            this.h = 0;
        }
        byte[] bArr = this.f;
        int i3 = this.g;
        int i4 = i3 + 1;
        this.g = i4;
        bArr[i3] = (byte) (i2 & 255);
        if (i4 >= bArr.length) {
            this.g = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x000a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void f(byte[] r5, int r6, int r7) throws java.io.IOException {
        /*
            r4 = this;
            monitor-enter(r4)
            r4.b()     // Catch: java.lang.Throwable -> L4b
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L4b
            r4.e = r0     // Catch: java.lang.Throwable -> L4b
        La:
            if (r7 <= 0) goto L49
            int r0 = r4.g     // Catch: java.lang.Throwable -> L4b
            int r1 = r4.h     // Catch: java.lang.Throwable -> L4b
            if (r0 != r1) goto L15
            r4.a()     // Catch: java.lang.Throwable -> L4b
        L15:
            int r0 = r4.h     // Catch: java.lang.Throwable -> L4b
            int r1 = r4.g     // Catch: java.lang.Throwable -> L4b
            r2 = 0
            if (r0 >= r1) goto L21
            byte[] r0 = r4.f     // Catch: java.lang.Throwable -> L4b
            int r0 = r0.length     // Catch: java.lang.Throwable -> L4b
        L1f:
            int r0 = r0 - r1
            goto L30
        L21:
            if (r1 >= r0) goto L2f
            r3 = -1
            if (r1 != r3) goto L1f
            r4.h = r2     // Catch: java.lang.Throwable -> L4b
            r4.g = r2     // Catch: java.lang.Throwable -> L4b
            byte[] r0 = r4.f     // Catch: java.lang.Throwable -> L4b
            int r0 = r0.length     // Catch: java.lang.Throwable -> L4b
            int r0 = r0 - r2
            goto L30
        L2f:
            r0 = r2
        L30:
            if (r0 <= r7) goto L33
            r0 = r7
        L33:
            byte[] r1 = r4.f     // Catch: java.lang.Throwable -> L4b
            int r3 = r4.g     // Catch: java.lang.Throwable -> L4b
            java.lang.System.arraycopy(r5, r6, r1, r3, r0)     // Catch: java.lang.Throwable -> L4b
            int r7 = r7 - r0
            int r6 = r6 + r0
            int r1 = r4.g     // Catch: java.lang.Throwable -> L4b
            int r1 = r1 + r0
            r4.g = r1     // Catch: java.lang.Throwable -> L4b
            byte[] r0 = r4.f     // Catch: java.lang.Throwable -> L4b
            int r0 = r0.length     // Catch: java.lang.Throwable -> L4b
            if (r1 < r0) goto La
            r4.g = r2     // Catch: java.lang.Throwable -> L4b
            goto La
        L49:
            monitor-exit(r4)
            return
        L4b:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.fk2.f(byte[], int, int):void");
    }

    public synchronized void g() {
        this.f11146a = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (!this.c) {
            throw new IOException("Pipe not connected");
        }
        if (this.f11147b) {
            throw new IOException("Pipe closed");
        }
        Thread thread = this.e;
        if (thread != null && !thread.isAlive() && !this.f11146a && this.g < 0) {
            throw new IOException("Write end dead");
        }
        this.d = Thread.currentThread();
        int i2 = 2;
        while (true) {
            int i3 = this.g;
            if (i3 >= 0) {
                byte[] bArr = this.f;
                int i4 = this.h;
                int i5 = i4 + 1;
                this.h = i5;
                int i6 = bArr[i4] & 255;
                if (i5 >= bArr.length) {
                    this.h = 0;
                }
                if (i3 == this.h) {
                    this.g = -1;
                }
                return i6;
            }
            if (this.f11146a) {
                return -1;
            }
            Thread thread2 = this.e;
            if (thread2 != null && !thread2.isAlive() && i2 - 1 < 0) {
                throw new IOException("Pipe broken");
            }
            notifyAll();
            try {
                wait(2000L);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        }
    }

    public fk2(gk2 gk2Var, int i2) throws IOException {
        this.f11146a = false;
        this.f11147b = false;
        this.c = false;
        this.g = -1;
        this.h = 0;
        d(i2);
        c(gk2Var);
    }

    public fk2() {
        this.f11146a = false;
        this.f11147b = false;
        this.c = false;
        this.g = -1;
        this.h = 0;
        d(1024);
    }

    public fk2(int i2) {
        this.f11146a = false;
        this.f11147b = false;
        this.c = false;
        this.g = -1;
        this.h = 0;
        d(i2);
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int length;
        if (bArr != null) {
            if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == 0) {
                return 0;
            }
            int i4 = read();
            if (i4 < 0) {
                return -1;
            }
            bArr[i2] = (byte) i4;
            int i5 = 1;
            while (true) {
                int i6 = this.g;
                if (i6 < 0 || i3 <= 1) {
                    break;
                }
                int i7 = this.h;
                if (i6 > i7) {
                    length = Math.min(this.f.length - i7, i6 - i7);
                } else {
                    length = this.f.length - i7;
                }
                int i8 = i3 - 1;
                if (length > i8) {
                    length = i8;
                }
                System.arraycopy(this.f, this.h, bArr, i2 + i5, length);
                int i9 = this.h + length;
                this.h = i9;
                i5 += length;
                i3 -= length;
                if (i9 >= this.f.length) {
                    this.h = 0;
                }
                if (this.g == this.h) {
                    this.g = -1;
                }
            }
            return i5;
        }
        throw new NullPointerException();
    }
}
