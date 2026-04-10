package com.bytedance.sdk.component.dl.g.z.gc;

import com.bytedance.sdk.component.dl.g.z.gc.a;
import com.bytedance.sdk.component.dl.z.js;
import com.bytedance.sdk.component.dl.z.tb;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
final class gz implements Closeable {
    static final Logger z = Logger.getLogger(gc.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z f680a;
    private final com.bytedance.sdk.component.dl.z.gc dl;
    final a.z g;
    private final boolean gc;

    interface g {
        void z(int i, int i2, List<dl> list) throws IOException;

        void z(int i, long j);

        void z(int i, com.bytedance.sdk.component.dl.g.z.gc.g gVar);

        void z(int i, com.bytedance.sdk.component.dl.g.z.gc.g gVar, com.bytedance.sdk.component.dl.z.m mVar);

        void z(boolean z, int i, int i2);

        void z(boolean z, int i, int i2, List<dl> list);

        void z(boolean z, int i, com.bytedance.sdk.component.dl.z.gc gcVar, int i2) throws IOException;

        void z(boolean z, v vVar);
    }

    gz(com.bytedance.sdk.component.dl.z.gc gcVar, boolean z2) {
        this.dl = gcVar;
        this.gc = z2;
        z zVar = new z(gcVar);
        this.f680a = zVar;
        this.g = new a.z(4096, zVar);
    }

    public void z(g gVar) throws IOException {
        if (this.gc) {
            if (!z(true, gVar)) {
                throw gc.g("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.bytedance.sdk.component.dl.z.m mVarDl = this.dl.dl(gc.z.e());
        Logger logger = z;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.bytedance.sdk.component.dl.g.z.dl.z("<< CONNECTION %s", mVarDl.gc()));
        }
        if (!gc.z.equals(mVarDl)) {
            throw gc.g("Expected a connection header but was %s", mVarDl.z());
        }
    }

    public boolean z(boolean z2, g gVar) throws IOException {
        try {
            this.dl.z(9L);
            int iZ = z(this.dl);
            if (iZ < 0 || iZ > 16384) {
                throw gc.g("FRAME_SIZE_ERROR: %s", Integer.valueOf(iZ));
            }
            byte bGz = (byte) (this.dl.gz() & 255);
            if (z2 && bGz != 4) {
                throw gc.g("Expected a SETTINGS frame but was %s", Byte.valueOf(bGz));
            }
            byte bGz2 = (byte) (this.dl.gz() & 255);
            int iUy = this.dl.uy() & Integer.MAX_VALUE;
            Logger logger = z;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(gc.z(true, iUy, iZ, bGz, bGz2));
            }
            switch (bGz) {
                case 0:
                    g(gVar, iZ, bGz2, iUy);
                    return true;
                case 1:
                    z(gVar, iZ, bGz2, iUy);
                    return true;
                case 2:
                    dl(gVar, iZ, bGz2, iUy);
                    return true;
                case 3:
                    a(gVar, iZ, bGz2, iUy);
                    return true;
                case 4:
                    gc(gVar, iZ, bGz2, iUy);
                    return true;
                case 5:
                    m(gVar, iZ, bGz2, iUy);
                    return true;
                case 6:
                    e(gVar, iZ, bGz2, iUy);
                    return true;
                case 7:
                    gz(gVar, iZ, bGz2, iUy);
                    return true;
                case 8:
                    fo(gVar, iZ, bGz2, iUy);
                    return true;
                default:
                    this.dl.gz(iZ);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private void z(g gVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw gc.g("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z2 = (b & 1) != 0;
        short sGz = (b & 8) != 0 ? (short) (this.dl.gz() & 255) : (short) 0;
        if ((b & 32) != 0) {
            z(gVar, i2);
            i -= 5;
        }
        gVar.z(z2, i2, -1, z(z(i, b, sGz), sGz, b, i2));
    }

    private List<dl> z(int i, short s, byte b, int i2) throws IOException {
        z zVar = this.f680a;
        zVar.f681a = i;
        zVar.z = i;
        this.f680a.gc = s;
        this.f680a.g = b;
        this.f680a.dl = i2;
        this.g.z();
        return this.g.g();
    }

    private void g(g gVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw gc.g("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z2 = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw gc.g("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short sGz = (b & 8) != 0 ? (short) (this.dl.gz() & 255) : (short) 0;
        gVar.z(z2, i2, this.dl, z(i, b, sGz));
        this.dl.gz(sGz);
    }

    private void dl(g gVar, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw gc.g("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw gc.g("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        z(gVar, i2);
    }

    private void z(g gVar, int i) throws IOException {
        this.dl.uy();
        this.dl.gz();
    }

    private void a(g gVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw gc.g("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw gc.g("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int iUy = this.dl.uy();
        com.bytedance.sdk.component.dl.g.z.gc.g gVarZ = com.bytedance.sdk.component.dl.g.z.gc.g.z(iUy);
        if (gVarZ == null) {
            throw gc.g("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iUy));
        }
        gVar.z(i2, gVarZ);
    }

    private void gc(g gVar, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw gc.g("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw gc.g("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            return;
        }
        if (i % 6 != 0) {
            throw gc.g("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        v vVar = new v();
        for (int i3 = 0; i3 < i; i3 += 6) {
            short sFo = this.dl.fo();
            int iUy = this.dl.uy();
            if (sFo == 2) {
                if (iUy != 0 && iUy != 1) {
                    throw gc.g("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (sFo == 3) {
                sFo = 4;
            } else if (sFo != 4) {
                if (sFo == 5 && (iUy < 16384 || iUy > 16777215)) {
                    throw gc.g("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iUy));
                }
            } else {
                if (iUy < 0) {
                    throw gc.g("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                sFo = 7;
            }
            vVar.z(sFo, iUy);
        }
        gVar.z(false, vVar);
    }

    private void m(g gVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw gc.g("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short sGz = (b & 8) != 0 ? (short) (this.dl.gz() & 255) : (short) 0;
        gVar.z(i2, this.dl.uy() & Integer.MAX_VALUE, z(z(i - 4, b, sGz), sGz, b, i2));
    }

    private void e(g gVar, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            throw gc.g("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw gc.g("TYPE_PING streamId != 0", new Object[0]);
        }
        gVar.z((b & 1) != 0, this.dl.uy(), this.dl.uy());
    }

    private void gz(g gVar, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw gc.g("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw gc.g("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int iUy = this.dl.uy();
        int iUy2 = this.dl.uy();
        int i3 = i - 8;
        com.bytedance.sdk.component.dl.g.z.gc.g gVarZ = com.bytedance.sdk.component.dl.g.z.gc.g.z(iUy2);
        if (gVarZ == null) {
            throw gc.g("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iUy2));
        }
        com.bytedance.sdk.component.dl.z.m mVarDl = com.bytedance.sdk.component.dl.z.m.g;
        if (i3 > 0) {
            mVarDl = this.dl.dl(i3);
        }
        gVar.z(iUy, gVarZ, mVarDl);
    }

    private void fo(g gVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw gc.g("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long jUy = ((long) this.dl.uy()) & 2147483647L;
        if (jUy == 0) {
            throw gc.g("windowSizeIncrement was 0", Long.valueOf(jUy));
        }
        gVar.z(i2, jUy);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.dl.close();
    }

    static final class z implements js {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f681a;
        int dl;
        byte g;
        short gc;
        private final com.bytedance.sdk.component.dl.z.gc m;
        int z;

        @Override // com.bytedance.sdk.component.dl.z.js, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        z(com.bytedance.sdk.component.dl.z.gc gcVar) {
            this.m = gcVar;
        }

        @Override // com.bytedance.sdk.component.dl.z.js
        public long z(com.bytedance.sdk.component.dl.z.dl dlVar, long j) throws IOException {
            while (true) {
                int i = this.f681a;
                if (i == 0) {
                    this.m.gz(this.gc);
                    this.gc = (short) 0;
                    if ((this.g & 4) != 0) {
                        return -1L;
                    }
                    g();
                } else {
                    long jZ = this.m.z(dlVar, Math.min(j, i));
                    if (jZ == -1) {
                        return -1L;
                    }
                    this.f681a = (int) (((long) this.f681a) - jZ);
                    return jZ;
                }
            }
        }

        @Override // com.bytedance.sdk.component.dl.z.js
        public tb z() {
            return this.m.z();
        }

        private void g() throws IOException {
            int i = this.dl;
            int iZ = gz.z(this.m);
            this.f681a = iZ;
            this.z = iZ;
            byte bGz = (byte) (this.m.gz() & 255);
            this.g = (byte) (this.m.gz() & 255);
            if (gz.z.isLoggable(Level.FINE)) {
                gz.z.fine(gc.z(true, this.dl, this.z, bGz, this.g));
            }
            int iUy = this.m.uy() & Integer.MAX_VALUE;
            this.dl = iUy;
            if (bGz != 9) {
                throw gc.g("%s != TYPE_CONTINUATION", Byte.valueOf(bGz));
            }
            if (iUy != i) {
                throw gc.g("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static int z(com.bytedance.sdk.component.dl.z.gc gcVar) throws IOException {
        return (gcVar.gz() & 255) | ((gcVar.gz() & 255) << 16) | ((gcVar.gz() & 255) << 8);
    }

    static int z(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw gc.g("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
