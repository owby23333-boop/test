package com.bytedance.sdk.component.dl.z;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public final class uy implements js {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kb f698a;
    private final Inflater dl;
    private final gc g;
    private int z = 0;
    private final CRC32 gc = new CRC32();

    public uy(js jsVar) {
        if (jsVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.dl = inflater;
        gc gcVarZ = wp.z(jsVar);
        this.g = gcVarZ;
        this.f698a = new kb(gcVarZ, inflater);
    }

    @Override // com.bytedance.sdk.component.dl.z.js
    public long z(dl dlVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return 0L;
        }
        if (this.z == 0) {
            g();
            this.z = 1;
        }
        if (this.z == 1) {
            long j2 = dlVar.g;
            long jZ = this.f698a.z(dlVar, j);
            if (jZ != -1) {
                z(dlVar, j2, jZ);
                return jZ;
            }
            this.z = 2;
        }
        if (this.z == 2) {
            dl();
            this.z = 3;
            if (!this.g.gc()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void g() throws IOException {
        this.g.z(10L);
        byte bG = this.g.dl().g(3L);
        boolean z = ((bG >> 1) & 1) == 1;
        if (z) {
            z(this.g.dl(), 0L, 10L);
        }
        z("ID1ID2", 8075, this.g.fo());
        this.g.gz(8L);
        if (((bG >> 2) & 1) == 1) {
            this.g.z(2L);
            if (z) {
                z(this.g.dl(), 0L, 2L);
            }
            long jKb = this.g.dl().kb();
            this.g.z(jKb);
            if (z) {
                z(this.g.dl(), 0L, jKb);
            }
            this.g.gz(jKb);
        }
        if (((bG >> 3) & 1) == 1) {
            long jZ = this.g.z((byte) 0);
            if (jZ == -1) {
                throw new EOFException();
            }
            if (z) {
                z(this.g.dl(), 0L, jZ + 1);
            }
            this.g.gz(jZ + 1);
        }
        if (((bG >> 4) & 1) == 1) {
            long jZ2 = this.g.z((byte) 0);
            if (jZ2 == -1) {
                throw new EOFException();
            }
            if (z) {
                z(this.g.dl(), 0L, jZ2 + 1);
            }
            this.g.gz(jZ2 + 1);
        }
        if (z) {
            z("FHCRC", this.g.kb(), (short) this.gc.getValue());
            this.gc.reset();
        }
    }

    private void dl() throws IOException {
        z("CRC", this.g.wp(), (int) this.gc.getValue());
        z("ISIZE", this.g.wp(), (int) this.dl.getBytesWritten());
    }

    @Override // com.bytedance.sdk.component.dl.z.js
    public tb z() {
        return this.g.z();
    }

    @Override // com.bytedance.sdk.component.dl.z.js, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f698a.close();
    }

    private void z(dl dlVar, long j, long j2) {
        pf pfVar = dlVar.z;
        while (j >= pfVar.dl - pfVar.g) {
            j -= (long) (pfVar.dl - pfVar.g);
            pfVar = pfVar.m;
        }
        while (j2 > 0) {
            int i = (int) (((long) pfVar.g) + j);
            int iMin = (int) Math.min(pfVar.dl - i, j2);
            this.gc.update(pfVar.z, i, iMin);
            j2 -= (long) iMin;
            pfVar = pfVar.m;
            j = 0;
        }
    }

    private void z(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
