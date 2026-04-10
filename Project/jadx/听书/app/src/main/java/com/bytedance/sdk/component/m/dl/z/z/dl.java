package com.bytedance.sdk.component.m.dl.z.z;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
class dl implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f771a;
    private byte[] dl;
    private final Charset g;
    private int gc;
    private final InputStream z;

    public dl(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public dl(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(a.z)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.z = inputStream;
        this.g = charset;
        this.dl = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.z) {
            if (this.dl != null) {
                this.dl = null;
                this.z.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String z() throws java.io.IOException {
        /*
            r7 = this;
            java.io.InputStream r0 = r7.z
            monitor-enter(r0)
            byte[] r1 = r7.dl     // Catch: java.lang.Throwable -> L8b
            if (r1 == 0) goto L83
            int r1 = r7.f771a     // Catch: java.lang.Throwable -> L8b
            int r2 = r7.gc     // Catch: java.lang.Throwable -> L8b
            if (r1 < r2) goto L10
            r7.dl()     // Catch: java.lang.Throwable -> L8b
        L10:
            int r1 = r7.f771a     // Catch: java.lang.Throwable -> L8b
        L12:
            int r2 = r7.gc     // Catch: java.lang.Throwable -> L8b
            r3 = 10
            if (r1 == r2) goto L45
            byte[] r2 = r7.dl     // Catch: java.lang.Throwable -> L8b
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L8b
            if (r4 != r3) goto L42
            int r3 = r7.f771a     // Catch: java.lang.Throwable -> L8b
            if (r1 == r3) goto L2b
            int r3 = r1 + (-1)
            r2 = r2[r3]     // Catch: java.lang.Throwable -> L8b
            r4 = 13
            if (r2 != r4) goto L2b
            goto L2c
        L2b:
            r3 = r1
        L2c:
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L8b
            byte[] r4 = r7.dl     // Catch: java.lang.Throwable -> L8b
            int r5 = r7.f771a     // Catch: java.lang.Throwable -> L8b
            int r3 = r3 - r5
            java.nio.charset.Charset r6 = r7.g     // Catch: java.lang.Throwable -> L8b
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L8b
            r2.<init>(r4, r5, r3, r6)     // Catch: java.lang.Throwable -> L8b
            int r1 = r1 + 1
            r7.f771a = r1     // Catch: java.lang.Throwable -> L8b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
            return r2
        L42:
            int r1 = r1 + 1
            goto L12
        L45:
            com.bytedance.sdk.component.m.dl.z.z.dl$1 r1 = new com.bytedance.sdk.component.m.dl.z.z.dl$1     // Catch: java.lang.Throwable -> L8b
            int r2 = r7.gc     // Catch: java.lang.Throwable -> L8b
            int r4 = r7.f771a     // Catch: java.lang.Throwable -> L8b
            int r2 = r2 - r4
            int r2 = r2 + 80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8b
        L51:
            byte[] r2 = r7.dl     // Catch: java.lang.Throwable -> L8b
            int r4 = r7.f771a     // Catch: java.lang.Throwable -> L8b
            int r5 = r7.gc     // Catch: java.lang.Throwable -> L8b
            int r5 = r5 - r4
            r1.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L8b
            r2 = -1
            r7.gc = r2     // Catch: java.lang.Throwable -> L8b
            r7.dl()     // Catch: java.lang.Throwable -> L8b
            int r2 = r7.f771a     // Catch: java.lang.Throwable -> L8b
        L63:
            int r4 = r7.gc     // Catch: java.lang.Throwable -> L8b
            if (r2 == r4) goto L51
            byte[] r4 = r7.dl     // Catch: java.lang.Throwable -> L8b
            r5 = r4[r2]     // Catch: java.lang.Throwable -> L8b
            if (r5 != r3) goto L80
            int r3 = r7.f771a     // Catch: java.lang.Throwable -> L8b
            if (r2 == r3) goto L76
            int r5 = r2 - r3
            r1.write(r4, r3, r5)     // Catch: java.lang.Throwable -> L8b
        L76:
            int r2 = r2 + 1
            r7.f771a = r2     // Catch: java.lang.Throwable -> L8b
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L8b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
            return r1
        L80:
            int r2 = r2 + 1
            goto L63
        L83:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L8b
            java.lang.String r2 = "LineReader is closed"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8b
            throw r1     // Catch: java.lang.Throwable -> L8b
        L8b:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.m.dl.z.z.dl.z():java.lang.String");
    }

    public boolean g() {
        return this.gc == -1;
    }

    private void dl() throws IOException {
        InputStream inputStream = this.z;
        byte[] bArr = this.dl;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.f771a = 0;
        this.gc = i;
    }
}
