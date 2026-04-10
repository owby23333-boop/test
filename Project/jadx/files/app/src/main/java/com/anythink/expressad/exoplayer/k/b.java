package com.anythink.expressad.exoplayer.k;

import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String a = "AtomicFile";
    private final File b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f9823c;

    private static final class a extends OutputStream {
        private final FileOutputStream a;
        private boolean b = false;

        public a(File file) {
            this.a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.b) {
                return;
            }
            this.b = true;
            flush();
            try {
                this.a.getFD().sync();
            } catch (IOException unused) {
            }
            this.a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public final void flush() {
            this.a.flush();
        }

        @Override // java.io.OutputStream
        public final void write(int i2) throws IOException {
            this.a.write(i2);
        }

        @Override // java.io.OutputStream
        public final void write(@NonNull byte[] bArr) throws IOException {
            this.a.write(bArr);
        }

        @Override // java.io.OutputStream
        public final void write(@NonNull byte[] bArr, int i2, int i3) throws IOException {
            this.a.write(bArr, i2, i3);
        }
    }

    public b(File file) {
        this.b = file;
        this.f9823c = new File(file.getPath() + ".bak");
    }

    private void d() {
        if (this.f9823c.exists()) {
            this.b.delete();
            this.f9823c.renameTo(this.b);
        }
    }

    public final void a() {
        this.b.delete();
        this.f9823c.delete();
    }

    public final OutputStream b() throws IOException {
        if (this.b.exists()) {
            if (this.f9823c.exists()) {
                this.b.delete();
            } else if (!this.b.renameTo(this.f9823c)) {
                String str = "Couldn't rename file " + this.b + " to backup file " + this.f9823c;
            }
        }
        try {
            return new a(this.b);
        } catch (FileNotFoundException e2) {
            if (!this.b.getParentFile().mkdirs()) {
                throw new IOException("Couldn't create directory " + this.b, e2);
            }
            try {
                return new a(this.b);
            } catch (FileNotFoundException e3) {
                throw new IOException("Couldn't create " + this.b, e3);
            }
        }
    }

    public final InputStream c() {
        if (this.f9823c.exists()) {
            this.b.delete();
            this.f9823c.renameTo(this.b);
        }
        return new FileInputStream(this.b);
    }

    public final void a(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.f9823c.delete();
    }
}
