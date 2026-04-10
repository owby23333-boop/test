package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
final class j implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Logger f1119g = Logger.getLogger(e.class.getName());
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d a;
    private final boolean b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1122e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c f1120c = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final d.b f1123f = new d.b(this.f1120c);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1121d = 16384;

    j(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar, boolean z2) {
        this.a = dVar;
        this.b = z2;
    }

    private static void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar, int i2) throws IOException {
        dVar.writeByte((i2 >>> 16) & 255);
        dVar.writeByte((i2 >>> 8) & 255);
        dVar.writeByte(i2 & 255);
    }

    private void b(int i2, long j2) throws IOException {
        while (j2 > 0) {
            int iMin = (int) Math.min(this.f1121d, j2);
            long j3 = iMin;
            j2 -= j3;
            a(i2, iMin, (byte) 9, j2 == 0 ? (byte) 4 : (byte) 0);
            this.a.b(this.f1120c, j3);
        }
    }

    void a(int i2, byte b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, int i3) throws IOException {
        a(i2, i3, (byte) 0, b);
        if (i3 > 0) {
            this.a.b(cVar, i3);
        }
    }

    public void a(int i2, int i3, byte b, byte b2) throws IOException {
        if (f1119g.isLoggable(Level.FINE)) {
            f1119g.fine(e.a(false, i2, i3, b, b2));
        }
        int i4 = this.f1121d;
        if (i3 > i4) {
            e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
            throw null;
        }
        if ((Integer.MIN_VALUE & i2) != 0) {
            e.a("reserved bit set: %s", Integer.valueOf(i2));
            throw null;
        }
        a(this.a, i3);
        this.a.writeByte(b & 255);
        this.a.writeByte(b2 & 255);
        this.a.writeInt(i2 & Integer.MAX_VALUE);
    }

    public void a(int i2, int i3, List<c> list) throws IOException {
        synchronized (this) {
            if (this.f1122e) {
                throw new IOException("closed");
            }
            this.f1123f.a(list);
            long jO = this.f1120c.o();
            int iMin = (int) Math.min(this.f1121d - 4, jO);
            long j2 = iMin;
            a(i2, iMin + 4, (byte) 5, jO == j2 ? (byte) 4 : (byte) 0);
            this.a.writeInt(i3 & Integer.MAX_VALUE);
            this.a.b(this.f1120c, j2);
            if (jO > j2) {
                b(i2, jO - j2);
            }
        }
    }

    public void a(int i2, long j2) throws IOException {
        synchronized (this) {
            if (this.f1122e) {
                throw new IOException("closed");
            }
            if (j2 == 0 || j2 > 2147483647L) {
                e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j2));
                throw null;
            }
            a(i2, 4, (byte) 8, (byte) 0);
            this.a.writeInt((int) j2);
            this.a.flush();
        }
    }

    public void a(int i2, b bVar) throws IOException {
        synchronized (this) {
            if (this.f1122e) {
                throw new IOException("closed");
            }
            if (bVar.a == -1) {
                throw new IllegalArgumentException();
            }
            a(i2, 4, (byte) 3, (byte) 0);
            this.a.writeInt(bVar.a);
            this.a.flush();
        }
    }

    public void a(int i2, b bVar, byte[] bArr) throws IOException {
        synchronized (this) {
            if (this.f1122e) {
                throw new IOException("closed");
            }
            if (bVar.a == -1) {
                e.a("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.a.writeInt(i2);
            this.a.writeInt(bVar.a);
            if (bArr.length > 0) {
                this.a.write(bArr);
            }
            this.a.flush();
        }
    }

    public void a(n nVar) throws IOException {
        synchronized (this) {
            if (this.f1122e) {
                throw new IOException("closed");
            }
            this.f1121d = nVar.c(this.f1121d);
            if (nVar.b() != -1) {
                this.f1123f.a(nVar.b());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.a.flush();
        }
    }

    public void a(boolean z2, int i2, int i3) throws IOException {
        synchronized (this) {
            if (this.f1122e) {
                throw new IOException("closed");
            }
            a(0, 8, (byte) 6, z2 ? (byte) 1 : (byte) 0);
            this.a.writeInt(i2);
            this.a.writeInt(i3);
            this.a.flush();
        }
    }

    public void a(boolean z2, int i2, int i3, List<c> list) throws IOException {
        synchronized (this) {
            if (this.f1122e) {
                throw new IOException("closed");
            }
            a(z2, i2, list);
        }
    }

    public void a(boolean z2, int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, int i3) throws IOException {
        synchronized (this) {
            if (this.f1122e) {
                throw new IOException("closed");
            }
            a(i2, z2 ? (byte) 1 : (byte) 0, cVar, i3);
        }
    }

    void a(boolean z2, int i2, List<c> list) throws IOException {
        if (this.f1122e) {
            throw new IOException("closed");
        }
        this.f1123f.a(list);
        long jO = this.f1120c.o();
        int iMin = (int) Math.min(this.f1121d, jO);
        long j2 = iMin;
        byte b = jO == j2 ? (byte) 4 : (byte) 0;
        if (z2) {
            b = (byte) (b | 1);
        }
        a(i2, iMin, (byte) 1, b);
        this.a.b(this.f1120c, j2);
        if (jO > j2) {
            b(i2, jO - j2);
        }
    }

    public void b(n nVar) throws IOException {
        synchronized (this) {
            if (this.f1122e) {
                throw new IOException("closed");
            }
            int i2 = 0;
            a(0, nVar.d() * 6, (byte) 4, (byte) 0);
            while (i2 < 10) {
                if (nVar.d(i2)) {
                    this.a.writeShort(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                    this.a.writeInt(nVar.a(i2));
                }
                i2++;
            }
            this.a.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.f1122e = true;
            this.a.close();
        }
    }

    public void flush() throws IOException {
        synchronized (this) {
            if (this.f1122e) {
                throw new IOException("closed");
            }
            this.a.flush();
        }
    }

    public void i() throws IOException {
        synchronized (this) {
            if (this.f1122e) {
                throw new IOException("closed");
            }
            if (this.b) {
                if (f1119g.isLoggable(Level.FINE)) {
                    f1119g.fine(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(">> CONNECTION %s", e.a.b()));
                }
                this.a.write(e.a.g());
                this.a.flush();
            }
        }
    }

    public int j() {
        return this.f1121d;
    }
}
