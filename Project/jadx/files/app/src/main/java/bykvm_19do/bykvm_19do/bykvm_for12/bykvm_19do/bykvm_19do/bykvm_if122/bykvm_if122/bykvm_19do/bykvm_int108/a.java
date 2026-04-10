package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108;

import android.support.v4.media.session.PlaybackStateCompat;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.i;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.k;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class a implements bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c {
    final v a;
    final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e f990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d f991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f992e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f993f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    private abstract class b implements s {
        protected final i a;
        protected boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected long f994c;

        private b() {
            this.a = new i(a.this.f990c.b());
            this.f994c = 0L;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            try {
                long jA = a.this.f990c.a(cVar, j2);
                if (jA > 0) {
                    this.f994c += jA;
                }
                return jA;
            } catch (IOException e2) {
                a(false, e2);
                throw e2;
            }
        }

        protected final void a(boolean z2, IOException iOException) throws IOException {
            a aVar = a.this;
            int i2 = aVar.f992e;
            if (i2 == 6) {
                return;
            }
            if (i2 != 5) {
                throw new IllegalStateException("state: " + a.this.f992e);
            }
            aVar.a(this.a);
            a aVar2 = a.this;
            aVar2.f992e = 6;
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar = aVar2.b;
            if (gVar != null) {
                gVar.a(!z2, aVar2, this.f994c, iOException);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public t b() {
            return this.a;
        }
    }

    private final class c implements r {
        private final i a;
        private boolean b;

        c() {
            this.a = new i(a.this.f991d.b());
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public t b() {
            return this.a;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (j2 == 0) {
                return;
            }
            a.this.f991d.e(j2);
            a.this.f991d.a("\r\n");
            a.this.f991d.b(cVar, j2);
            a.this.f991d.a("\r\n");
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (this) {
                if (!this.b) {
                    this.b = true;
                    a.this.f991d.a("0\r\n\r\n");
                    a.this.a(this.a);
                    a.this.f992e = 3;
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
        public void flush() throws IOException {
            synchronized (this) {
                if (!this.b) {
                    a.this.f991d.flush();
                }
            }
        }
    }

    private class d extends b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s f997e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f998f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f999g;

        d(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s sVar) {
            super();
            this.f998f = -1L;
            this.f999g = true;
            this.f997e = sVar;
        }

        private void h() throws IOException {
            if (this.f998f != -1) {
                a.this.f990c.d();
            }
            try {
                this.f998f = a.this.f990c.g();
                String strTrim = a.this.f990c.d().trim();
                if (this.f998f < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f998f + strTrim + "\"");
                }
                if (this.f998f == 0) {
                    this.f999g = false;
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e.a(a.this.a.f(), this.f997e, a.this.e());
                    a(true, (IOException) null);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
        
            if (r7.f999g != false) goto L15;
         */
        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a.b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r8, long r9) throws java.io.IOException {
            /*
                r7 = this;
                r0 = 0
                int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r2 < 0) goto L4d
                boolean r2 = r7.b
                if (r2 != 0) goto L45
                boolean r2 = r7.f999g
                r3 = -1
                if (r2 != 0) goto L11
                goto L43
            L11:
                long r5 = r7.f998f
                int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r2 == 0) goto L1b
                int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r0 != 0) goto L22
            L1b:
                r7.h()
                boolean r0 = r7.f999g
                if (r0 == 0) goto L43
            L22:
                long r0 = r7.f998f
                long r9 = java.lang.Math.min(r9, r0)
                long r8 = super.a(r8, r9)
                int r10 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r10 == 0) goto L36
                long r0 = r7.f998f
                long r0 = r0 - r8
                r7.f998f = r0
                goto L44
            L36:
                java.net.ProtocolException r8 = new java.net.ProtocolException
                java.lang.String r9 = "unexpected end of stream"
                r8.<init>(r9)
                r9 = 0
                r7.a(r9, r8)
                throw r8
            L43:
                r8 = r3
            L44:
                return r8
            L45:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "closed"
                r8.<init>(r9)
                throw r8
            L4d:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "byteCount < 0: "
                r0.append(r1)
                r0.append(r9)
                java.lang.String r9 = r0.toString()
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a.d.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c, long):long");
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.f999g && !bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.b = true;
        }
    }

    private final class e implements r {
        private final i a;
        private boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f1001c;

        e(long j2) {
            this.a = new i(a.this.f991d.b());
            this.f1001c = j2;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public t b() {
            return this.a;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(cVar.o(), 0L, j2);
            if (j2 <= this.f1001c) {
                a.this.f991d.b(cVar, j2);
                this.f1001c -= j2;
                return;
            }
            throw new ProtocolException("expected " + this.f1001c + " bytes but received " + j2);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            this.b = true;
            if (this.f1001c > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            a.this.a(this.a);
            a.this.f992e = 3;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
        public void flush() throws IOException {
            if (this.b) {
                return;
            }
            a.this.f991d.flush();
        }
    }

    private class f extends b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f1003e;

        f(a aVar, long j2) throws IOException {
            super();
            this.f1003e = j2;
            if (this.f1003e == 0) {
                a(true, (IOException) null);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a.b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            long j3 = this.f1003e;
            if (j3 == 0) {
                return -1L;
            }
            long jA = super.a(cVar, Math.min(j3, j2));
            if (jA == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, (IOException) protocolException);
                throw protocolException;
            }
            this.f1003e -= jA;
            if (this.f1003e != 0) {
                return jA;
            }
            a(true, (IOException) null);
            return jA;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.f1003e != 0 && !bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.b = true;
        }
    }

    private class g extends b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f1004e;

        g(a aVar) {
            super();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a.b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f1004e) {
                long jA = super.a(cVar, j2);
                if (jA != -1) {
                    return jA;
                }
                this.f1004e = true;
                a(true, (IOException) null);
            }
            return -1L;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (!this.f1004e) {
                a(false, (IOException) null);
            }
            this.b = true;
        }
    }

    public a(v vVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar) {
        this.a = vVar;
        this.b = gVar;
        this.f990c = eVar;
        this.f991d = dVar;
    }

    private String f() throws IOException {
        String strC = this.f990c.c(this.f993f);
        this.f993f -= (long) strC.length();
        return strC;
    }

    public r a(long j2) {
        if (this.f992e == 1) {
            this.f992e = 2;
            return new e(j2);
        }
        throw new IllegalStateException("state: " + this.f992e);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public r a(y yVar, long j2) {
        if (DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(yVar.a(DownloadUtils.TRANSFER_ENCODING))) {
            return c();
        }
        if (j2 != -1) {
            return a(j2);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public s a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s sVar) throws IOException {
        if (this.f992e == 4) {
            this.f992e = 5;
            return new d(sVar);
        }
        throw new IllegalStateException("state: " + this.f992e);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public a0.a a(boolean z2) throws IOException {
        int i2 = this.f992e;
        if (i2 != 1 && i2 != 3) {
            throw new IllegalStateException("state: " + this.f992e);
        }
        try {
            k kVarA = k.a(f());
            a0.a aVarA = new a0.a().a(kVarA.a).a(kVarA.b).a(kVarA.f955c).a(e());
            if (z2 && kVarA.b == 100) {
                return null;
            }
            this.f992e = 4;
            return aVarA;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.b);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public b0 a(a0 a0Var) throws IOException {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar = this.b;
        gVar.f981f.e(gVar.f980e);
        String strB = a0Var.b("Content-Type");
        if (!bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e.b(a0Var)) {
            return new h(strB, 0L, l.a(b(0L)));
        }
        if (DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(a0Var.b(DownloadUtils.TRANSFER_ENCODING))) {
            return new h(strB, -1L, l.a(a(a0Var.s().g())));
        }
        long jA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e.a(a0Var);
        return jA != -1 ? new h(strB, jA, l.a(b(jA))) : new h(strB, -1L, l.a(d()));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public void a() throws IOException {
        this.f991d.flush();
    }

    void a(i iVar) {
        t tVarG = iVar.g();
        iVar.a(t.f884d);
        tVarG.a();
        tVarG.b();
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r rVar, String str) throws IOException {
        if (this.f992e != 0) {
            throw new IllegalStateException("state: " + this.f992e);
        }
        this.f991d.a(str).a("\r\n");
        int iB = rVar.b();
        for (int i2 = 0; i2 < iB; i2++) {
            this.f991d.a(rVar.a(i2)).a(": ").a(rVar.b(i2)).a("\r\n");
        }
        this.f991d.a("\r\n");
        this.f992e = 1;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public void a(y yVar) throws IOException {
        a(yVar.c(), bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.i.a(yVar, this.b.b().a().b().type()));
    }

    public s b(long j2) throws IOException {
        if (this.f992e == 4) {
            this.f992e = 5;
            return new f(this, j2);
        }
        throw new IllegalStateException("state: " + this.f992e);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public void b() throws IOException {
        this.f991d.flush();
    }

    public r c() {
        if (this.f992e == 1) {
            this.f992e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f992e);
    }

    public s d() throws IOException {
        if (this.f992e != 4) {
            throw new IllegalStateException("state: " + this.f992e);
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar = this.b;
        if (gVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f992e = 5;
        gVar.d();
        return new g(this);
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r e() throws IOException {
        r.a aVar = new r.a();
        while (true) {
            String strF = f();
            if (strF.length() == 0) {
                return aVar.a();
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(aVar, strF);
        }
    }
}
