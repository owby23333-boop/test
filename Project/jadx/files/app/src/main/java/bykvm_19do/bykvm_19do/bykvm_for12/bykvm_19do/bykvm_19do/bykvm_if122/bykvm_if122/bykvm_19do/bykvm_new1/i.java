package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final /* synthetic */ boolean f1100l = !i.class.desiredAssertionStatus();
    long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f1101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final g f1102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> f1103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f1105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final a f1106h;
    long a = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final c f1107i = new c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final c f1108j = new c();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b f1109k = null;

    final class a implements r {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final /* synthetic */ boolean f1110e = !i.class.desiredAssertionStatus();
        private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c a = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
        boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1111c;

        a() {
        }

        private void a(boolean z2) throws IOException {
            long jMin;
            synchronized (i.this) {
                i.this.f1108j.g();
                while (i.this.b <= 0 && !this.f1111c && !this.b && i.this.f1109k == null) {
                    try {
                        i.this.k();
                    } finally {
                    }
                }
                i.this.f1108j.k();
                i.this.b();
                jMin = Math.min(i.this.b, this.a.o());
                i.this.b -= jMin;
            }
            i.this.f1108j.g();
            try {
                i.this.f1102d.a(i.this.f1101c, z2 && jMin == this.a.o(), this.a, jMin);
            } finally {
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public t b() {
            return i.this.f1108j;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            if (!f1110e && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            this.a.b(cVar, j2);
            while (this.a.o() >= 16384) {
                a(false);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f1110e && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                if (this.b) {
                    return;
                }
                if (!i.this.f1106h.f1111c) {
                    if (this.a.o() > 0) {
                        while (this.a.o() > 0) {
                            a(true);
                        }
                    } else {
                        i iVar = i.this;
                        iVar.f1102d.a(iVar.f1101c, true, (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c) null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.b = true;
                }
                i.this.f1102d.flush();
                i.this.a();
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
        public void flush() throws IOException {
            if (!f1110e && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                i.this.b();
            }
            while (this.a.o() > 0) {
                a(false);
                i.this.f1102d.flush();
            }
        }
    }

    private final class b implements s {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final /* synthetic */ boolean f1113g = !i.class.desiredAssertionStatus();
        private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c a = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
        private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c b = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f1114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1115d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f1116e;

        b(long j2) {
            this.f1114c = j2;
        }

        private void h() throws IOException {
            if (this.f1115d) {
                throw new IOException("stream closed");
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar = i.this.f1109k;
            if (bVar != null) {
                throw new o(bVar);
            }
        }

        private void i() throws IOException {
            i.this.f1107i.g();
            while (this.b.o() == 0 && !this.f1116e && !this.f1115d && i.this.f1109k == null) {
                try {
                    i.this.k();
                } finally {
                    i.this.f1107i.k();
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            long jA;
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            synchronized (i.this) {
                i();
                h();
                if (this.b.o() == 0) {
                    jA = -1;
                } else {
                    jA = this.b.a(cVar, Math.min(j2, this.b.o()));
                    i.this.a += jA;
                    if (i.this.a >= i.this.f1102d.f1059m.c() / 2) {
                        i.this.f1102d.a(i.this.f1101c, i.this.a);
                        i.this.a = 0L;
                    }
                    synchronized (i.this.f1102d) {
                        i.this.f1102d.f1057k += jA;
                        if (i.this.f1102d.f1057k >= i.this.f1102d.f1059m.c() / 2) {
                            i.this.f1102d.a(0, i.this.f1102d.f1057k);
                            i.this.f1102d.f1057k = 0L;
                        }
                    }
                }
            }
            return jA;
        }

        void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, long j2) throws IOException {
            boolean z2;
            boolean z3;
            boolean z4;
            if (!f1113g && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            while (j2 > 0) {
                synchronized (i.this) {
                    z2 = this.f1116e;
                    z3 = true;
                    z4 = this.b.o() + j2 > this.f1114c;
                }
                if (z4) {
                    eVar.skip(j2);
                    i.this.b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z2) {
                    eVar.skip(j2);
                    return;
                }
                long jA = eVar.a(this.a, j2);
                if (jA == -1) {
                    throw new EOFException();
                }
                j2 -= jA;
                synchronized (i.this) {
                    if (this.b.o() != 0) {
                        z3 = false;
                    }
                    this.b.a(this.a);
                    if (z3) {
                        i.this.notifyAll();
                    }
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public t b() {
            return i.this.f1107i;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (i.this) {
                this.f1115d = true;
                this.b.j();
                i.this.notifyAll();
            }
            i.this.a();
        }
    }

    class c extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a {
        c() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a
        protected IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a
        protected void i() {
            i.this.b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
        }

        public void k() throws IOException {
            if (h()) {
                throw b((IOException) null);
            }
        }
    }

    i(int i2, g gVar, boolean z2, boolean z3, List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list) {
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.f1101c = i2;
        this.f1102d = gVar;
        this.b = gVar.f1060n.c();
        this.f1105g = new b(gVar.f1059m.c());
        this.f1106h = new a();
        this.f1105g.f1116e = z3;
        this.f1106h.f1111c = z2;
    }

    private boolean d(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
        if (!f1100l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.f1109k == null && (!this.f1105g.f1116e || !this.f1106h.f1111c)) {
                this.f1109k = bVar;
                notifyAll();
                this.f1102d.d(this.f1101c);
                return true;
            }
            return false;
        }
    }

    void a() throws IOException {
        boolean z2;
        boolean zG;
        if (!f1100l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z2 = !this.f1105g.f1116e && this.f1105g.f1115d && (this.f1106h.f1111c || this.f1106h.b);
            zG = g();
        }
        if (z2) {
            a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
        } else {
            if (zG) {
                return;
            }
            this.f1102d.d(this.f1101c);
        }
    }

    void a(long j2) {
        this.b += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, int i2) throws IOException {
        if (!f1100l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f1105g.a(eVar, i2);
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) throws IOException {
        if (d(bVar)) {
            this.f1102d.b(this.f1101c, bVar);
        }
    }

    void a(List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list) {
        boolean zG;
        if (!f1100l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            zG = true;
            this.f1104f = true;
            if (this.f1103e == null) {
                this.f1103e = list;
                zG = g();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f1103e);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f1103e = arrayList;
            }
        }
        if (zG) {
            return;
        }
        this.f1102d.d(this.f1101c);
    }

    void b() throws IOException {
        a aVar = this.f1106h;
        if (aVar.b) {
            throw new IOException("stream closed");
        }
        if (aVar.f1111c) {
            throw new IOException("stream finished");
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar = this.f1109k;
        if (bVar != null) {
            throw new o(bVar);
        }
    }

    public void b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
        if (d(bVar)) {
            this.f1102d.c(this.f1101c, bVar);
        }
    }

    public int c() {
        return this.f1101c;
    }

    void c(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
        synchronized (this) {
            if (this.f1109k == null) {
                this.f1109k = bVar;
                notifyAll();
            }
        }
    }

    public r d() {
        synchronized (this) {
            if (!this.f1104f && !f()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f1106h;
    }

    public s e() {
        return this.f1105g;
    }

    public boolean f() {
        return this.f1102d.a == ((this.f1101c & 1) == 1);
    }

    public boolean g() {
        boolean z2;
        synchronized (this) {
            if (this.f1109k == null) {
                b bVar = this.f1105g;
                if (bVar.f1116e || bVar.f1115d) {
                    a aVar = this.f1106h;
                    if (aVar.f1111c || aVar.b) {
                        if (!this.f1104f) {
                        }
                    }
                }
                z2 = true;
            }
            z2 = false;
        }
        return z2;
    }

    public t h() {
        return this.f1107i;
    }

    void i() {
        boolean zG;
        if (!f1100l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f1105g.f1116e = true;
            zG = g();
            notifyAll();
        }
        if (zG) {
            return;
        }
        this.f1102d.d(this.f1101c);
    }

    public List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> j() throws IOException {
        List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list;
        synchronized (this) {
            if (!f()) {
                throw new IllegalStateException("servers cannot read response headers");
            }
            this.f1107i.g();
            while (this.f1103e == null && this.f1109k == null) {
                try {
                    k();
                } catch (Throwable th) {
                    this.f1107i.k();
                    throw th;
                }
            }
            this.f1107i.k();
            list = this.f1103e;
            if (list == null) {
                throw new o(this.f1109k);
            }
            this.f1103e = null;
        }
        return list;
    }

    void k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public t l() {
        return this.f1108j;
    }
}
