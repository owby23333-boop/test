package com.yuewen;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class gk2 extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fk2 f11588a;

    public gk2(fk2 fk2Var) throws IOException {
        a(fk2Var);
    }

    public synchronized void a(fk2 fk2Var) throws IOException {
        try {
            if (fk2Var == null) {
                throw new NullPointerException();
            }
            if (this.f11588a != null || fk2Var.c) {
                throw new IOException("Already connected");
            }
            this.f11588a = fk2Var;
            fk2Var.g = -1;
            fk2Var.h = 0;
            fk2Var.c = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        fk2 fk2Var = this.f11588a;
        if (fk2Var != null) {
            fk2Var.g();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        fk2 fk2Var = this.f11588a;
        if (fk2Var != null) {
            synchronized (fk2Var) {
                this.f11588a.notifyAll();
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        fk2 fk2Var = this.f11588a;
        if (fk2Var == null) {
            throw new IOException("Pipe not connected");
        }
        fk2Var.e(i);
    }

    public gk2() {
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        fk2 fk2Var = this.f11588a;
        if (fk2Var != null) {
            bArr.getClass();
            if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return;
            }
            fk2Var.f(bArr, i, i2);
            return;
        }
        throw new IOException("Pipe not connected");
    }
}
