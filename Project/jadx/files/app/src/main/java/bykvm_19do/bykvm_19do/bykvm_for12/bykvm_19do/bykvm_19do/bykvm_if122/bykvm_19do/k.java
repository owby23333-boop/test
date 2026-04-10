package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class k implements s {
    private final e a;
    private final Inflater b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f873d;

    k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.a = eVar;
        this.b = inflater;
    }

    private void i() throws IOException {
        int i2 = this.f872c;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.b.getRemaining();
        this.f872c -= remaining;
        this.a.skip(remaining);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public long a(c cVar, long j2) throws IOException {
        boolean zH;
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        if (this.f873d) {
            throw new IllegalStateException("closed");
        }
        if (j2 == 0) {
            return 0L;
        }
        do {
            zH = h();
            try {
                o oVarB = cVar.b(1);
                int iInflate = this.b.inflate(oVarB.a, oVarB.f877c, (int) Math.min(j2, 8192 - oVarB.f877c));
                if (iInflate > 0) {
                    oVarB.f877c += iInflate;
                    long j3 = iInflate;
                    cVar.b += j3;
                    return j3;
                }
                if (!this.b.finished() && !this.b.needsDictionary()) {
                }
                i();
                if (oVarB.b == oVarB.f877c) {
                    cVar.a = oVarB.b();
                    p.a(oVarB);
                }
                return -1L;
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        } while (!zH);
        throw new EOFException("source exhausted prematurely");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public t b() {
        return this.a.b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f873d) {
            return;
        }
        this.b.end();
        this.f873d = true;
        this.a.close();
    }

    public final boolean h() throws IOException {
        if (this.b.needsInput()) {
            i();
            if (this.b.getRemaining() != 0) {
                throw new IllegalStateException("?");
            }
            if (this.a.f()) {
                return true;
            }
            o oVar = this.a.a().a;
            int i2 = oVar.f877c;
            int i3 = oVar.b;
            this.f872c = i2 - i3;
            this.b.setInput(oVar.a, i3, this.f872c);
        }
        return false;
    }
}
