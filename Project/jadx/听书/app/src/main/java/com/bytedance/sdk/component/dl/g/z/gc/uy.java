package com.bytedance.sdk.component.dl.g.z.gc;

import com.bytedance.sdk.component.dl.g.z.gc.a;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
final class uy implements Closeable {
    private static final Logger g = Logger.getLogger(gc.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f684a;
    private final com.bytedance.sdk.component.dl.z.a dl;
    private boolean e;
    private final com.bytedance.sdk.component.dl.z.dl gc;
    private int m;
    final a.g z;

    uy(com.bytedance.sdk.component.dl.z.a aVar, boolean z) {
        this.dl = aVar;
        this.f684a = z;
        com.bytedance.sdk.component.dl.z.dl dlVar = new com.bytedance.sdk.component.dl.z.dl();
        this.gc = dlVar;
        this.z = new a.g(dlVar);
        this.m = 16384;
    }

    public synchronized void z() throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        if (this.f684a) {
            Logger logger = g;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(com.bytedance.sdk.component.dl.g.z.dl.z(">> CONNECTION %s", gc.z.gc()));
            }
            this.dl.dl(gc.z.gz());
            this.dl.flush();
        }
    }

    public synchronized void z(v vVar) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        this.m = vVar.a(this.m);
        if (vVar.dl() != -1) {
            this.z.z(vVar.dl());
        }
        z(0, 0, (byte) 4, (byte) 1);
        this.dl.flush();
    }

    public synchronized void z(int i, int i2, List<dl> list) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        this.z.z(list);
        long jG = this.gc.g();
        int iMin = (int) Math.min(this.m - 4, jG);
        long j = iMin;
        z(i, iMin + 4, (byte) 5, jG == j ? (byte) 4 : (byte) 0);
        this.dl.e(i2 & Integer.MAX_VALUE);
        this.dl.a_(this.gc, j);
        if (jG > j) {
            g(i, jG - j);
        }
    }

    public synchronized void g() throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        this.dl.flush();
    }

    public synchronized void z(boolean z, int i, int i2, List<dl> list) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        z(z, i, list);
    }

    public synchronized void z(int i, g gVar) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        if (gVar.e == -1) {
            throw new IllegalArgumentException();
        }
        z(i, 4, (byte) 3, (byte) 0);
        this.dl.e(gVar.e);
        this.dl.flush();
    }

    public int dl() {
        return this.m;
    }

    public synchronized void z(boolean z, int i, com.bytedance.sdk.component.dl.z.dl dlVar, int i2) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        z(i, z ? (byte) 1 : (byte) 0, dlVar, i2);
    }

    void z(int i, byte b, com.bytedance.sdk.component.dl.z.dl dlVar, int i2) throws IOException {
        z(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.dl.a_(dlVar, i2);
        }
    }

    public synchronized void g(v vVar) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        int i = 0;
        z(0, vVar.g() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (vVar.z(i)) {
                this.dl.gz(i == 4 ? 3 : i == 7 ? 4 : i);
                this.dl.e(vVar.g(i));
            }
            i++;
        }
        this.dl.flush();
    }

    public synchronized void z(boolean z, int i, int i2) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        z(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.dl.e(i);
        this.dl.e(i2);
        this.dl.flush();
    }

    public synchronized void z(int i, g gVar, byte[] bArr) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        if (gVar.e == -1) {
            throw gc.z("errorCode.httpCode == -1", new Object[0]);
        }
        z(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.dl.e(i);
        this.dl.e(gVar.e);
        if (bArr.length > 0) {
            this.dl.dl(bArr);
        }
        this.dl.flush();
    }

    public synchronized void z(int i, long j) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw gc.z("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
        z(i, 4, (byte) 8, (byte) 0);
        this.dl.e((int) j);
        this.dl.flush();
    }

    public void z(int i, int i2, byte b, byte b2) throws IOException {
        Logger logger = g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(gc.z(false, i, i2, b, b2));
        }
        int i3 = this.m;
        if (i2 > i3) {
            throw gc.z("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw gc.z("reserved bit set: %s", Integer.valueOf(i));
        }
        z(this.dl, i2);
        this.dl.fo(b & 255);
        this.dl.fo(b2 & 255);
        this.dl.e(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.e = true;
        this.dl.close();
    }

    private static void z(com.bytedance.sdk.component.dl.z.a aVar, int i) throws IOException {
        aVar.fo((i >>> 16) & 255);
        aVar.fo((i >>> 8) & 255);
        aVar.fo(i & 255);
    }

    private void g(int i, long j) throws IOException {
        while (j > 0) {
            int iMin = (int) Math.min(this.m, j);
            long j2 = iMin;
            j -= j2;
            z(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.dl.a_(this.gc, j2);
        }
    }

    void z(boolean z, int i, List<dl> list) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        this.z.z(list);
        long jG = this.gc.g();
        int iMin = (int) Math.min(this.m, jG);
        long j = iMin;
        byte b = jG == j ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        z(i, iMin, (byte) 1, b);
        this.dl.a_(this.gc, j);
        if (jG > j) {
            g(i, jG - j);
        }
    }
}
