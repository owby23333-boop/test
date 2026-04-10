package com.bytedance.sdk.component.dl.z;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public final class kb implements js {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f694a;
    private int dl;
    private final Inflater g;
    private final gc z;

    kb(gc gcVar, Inflater inflater) {
        if (gcVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.z = gcVar;
        this.g = inflater;
    }

    @Override // com.bytedance.sdk.component.dl.z.js
    public long z(dl dlVar, long j) throws IOException {
        boolean zG;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.f694a) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zG = g();
            try {
                pf pfVarGc = dlVar.gc(1);
                int iInflate = this.g.inflate(pfVarGc.z, pfVarGc.dl, (int) Math.min(j, 8192 - pfVarGc.dl));
                if (iInflate > 0) {
                    pfVarGc.dl += iInflate;
                    long j2 = iInflate;
                    dlVar.g += j2;
                    return j2;
                }
                if (!this.g.finished() && !this.g.needsDictionary()) {
                }
                dl();
                if (pfVarGc.g != pfVarGc.dl) {
                    return -1L;
                }
                dlVar.z = pfVarGc.g();
                ls.z(pfVarGc);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!zG);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean g() throws IOException {
        if (!this.g.needsInput()) {
            return false;
        }
        dl();
        if (this.g.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.z.gc()) {
            return true;
        }
        pf pfVar = this.z.dl().z;
        this.dl = pfVar.dl - pfVar.g;
        this.g.setInput(pfVar.z, pfVar.g, this.dl);
        return false;
    }

    private void dl() throws IOException {
        int i = this.dl;
        if (i == 0) {
            return;
        }
        int remaining = i - this.g.getRemaining();
        this.dl -= remaining;
        this.z.gz(remaining);
    }

    @Override // com.bytedance.sdk.component.dl.z.js
    public tb z() {
        return this.z.z();
    }

    @Override // com.bytedance.sdk.component.dl.z.js, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f694a) {
            return;
        }
        this.g.end();
        this.f694a = true;
        this.z.close();
    }
}
