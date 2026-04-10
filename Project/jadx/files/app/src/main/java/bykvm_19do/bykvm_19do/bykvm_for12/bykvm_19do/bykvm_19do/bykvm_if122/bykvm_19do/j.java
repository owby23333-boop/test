package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class j implements s {
    private final e b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Inflater f869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k f870d;
    private int a = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CRC32 f871e = new CRC32();

    public j(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f869c = new Inflater(true);
        this.b = l.a(sVar);
        this.f870d = new k(this.b, this.f869c);
    }

    private void a(c cVar, long j2, long j3) {
        o oVar = cVar.a;
        while (true) {
            long j4 = oVar.f877c - oVar.b;
            if (j2 < j4) {
                break;
            }
            j2 -= j4;
            oVar = oVar.f880f;
        }
        while (j3 > 0) {
            int i2 = (int) (((long) oVar.b) + j2);
            int iMin = (int) Math.min(oVar.f877c - i2, j3);
            this.f871e.update(oVar.a, i2, iMin);
            j3 -= (long) iMin;
            oVar = oVar.f880f;
            j2 = 0;
        }
    }

    private void a(String str, int i2, int i3) throws IOException {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }

    private void h() throws IOException {
        this.b.a(10L);
        byte bF = this.b.a().f(3L);
        boolean z2 = ((bF >> 1) & 1) == 1;
        if (z2) {
            a(this.b.a(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.b.readShort());
        this.b.skip(8L);
        if (((bF >> 2) & 1) == 1) {
            this.b.a(2L);
            if (z2) {
                a(this.b.a(), 0L, 2L);
            }
            long jC = this.b.a().c();
            this.b.a(jC);
            if (z2) {
                a(this.b.a(), 0L, jC);
            }
            this.b.skip(jC);
        }
        if (((bF >> 3) & 1) == 1) {
            long jA = this.b.a((byte) 0);
            if (jA == -1) {
                throw new EOFException();
            }
            if (z2) {
                a(this.b.a(), 0L, jA + 1);
            }
            this.b.skip(jA + 1);
        }
        if (((bF >> 4) & 1) == 1) {
            long jA2 = this.b.a((byte) 0);
            if (jA2 == -1) {
                throw new EOFException();
            }
            if (z2) {
                a(this.b.a(), 0L, jA2 + 1);
            }
            this.b.skip(jA2 + 1);
        }
        if (z2) {
            a("FHCRC", this.b.c(), (short) this.f871e.getValue());
            this.f871e.reset();
        }
    }

    private void i() throws IOException {
        a("CRC", this.b.e(), (int) this.f871e.getValue());
        a("ISIZE", this.b.e(), (int) this.f869c.getBytesWritten());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public long a(c cVar, long j2) throws IOException {
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        if (j2 == 0) {
            return 0L;
        }
        if (this.a == 0) {
            h();
            this.a = 1;
        }
        if (this.a == 1) {
            long j3 = cVar.b;
            long jA = this.f870d.a(cVar, j2);
            if (jA != -1) {
                a(cVar, j3, jA);
                return jA;
            }
            this.a = 2;
        }
        if (this.a == 2) {
            i();
            this.a = 3;
            if (!this.b.f()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public t b() {
        return this.b.b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f870d.close();
    }
}
