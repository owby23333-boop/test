package com.bytedance.sdk.component.dl.g.z.gc;

import com.bytedance.sdk.component.dl.z.fv;
import com.bytedance.sdk.component.dl.z.js;
import com.bytedance.sdk.component.dl.z.tb;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class fo {
    static final /* synthetic */ boolean fo = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f675a;
    final int dl;
    long g;
    final z gc;
    private final g i;
    private List<com.bytedance.sdk.component.dl.g.z.gc.dl> kb;
    private final List<com.bytedance.sdk.component.dl.g.z.gc.dl> uy;
    private boolean wp;
    long z = 0;
    final dl m = new dl();
    final dl e = new dl();
    com.bytedance.sdk.component.dl.g.z.gc.g gz = null;

    fo(int i, e eVar, boolean z2, boolean z3, List<com.bytedance.sdk.component.dl.g.z.gc.dl> list) {
        if (eVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.dl = i;
        this.f675a = eVar;
        this.g = eVar.i.a();
        g gVar = new g(eVar.wp.a());
        this.i = gVar;
        z zVar = new z();
        this.gc = zVar;
        gVar.g = z3;
        zVar.g = z2;
        this.uy = list;
    }

    public int z() {
        return this.dl;
    }

    public synchronized boolean g() {
        if (this.gz != null) {
            return false;
        }
        if ((this.i.g || this.i.z) && (this.gc.g || this.gc.z)) {
            if (this.wp) {
                return false;
            }
        }
        return true;
    }

    public boolean dl() {
        return this.f675a.g == ((this.dl & 1) == 1);
    }

    public synchronized List<com.bytedance.sdk.component.dl.g.z.gc.dl> a() throws IOException {
        List<com.bytedance.sdk.component.dl.g.z.gc.dl> list;
        if (!dl()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.m.z();
        while (this.kb == null && this.gz == null) {
            try {
                wp();
            } catch (Throwable th) {
                this.m.gz();
                throw th;
            }
        }
        this.m.gz();
        list = this.kb;
        if (list != null) {
            this.kb = null;
        } else {
            throw new pf(this.gz);
        }
        return list;
    }

    public tb gc() {
        return this.m;
    }

    public tb m() {
        return this.e;
    }

    public js e() {
        return this.i;
    }

    public fv gz() {
        synchronized (this) {
            if (!this.wp && !dl()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.gc;
    }

    public void z(com.bytedance.sdk.component.dl.g.z.gc.g gVar) throws IOException {
        if (a(gVar)) {
            this.f675a.g(this.dl, gVar);
        }
    }

    public void g(com.bytedance.sdk.component.dl.g.z.gc.g gVar) {
        if (a(gVar)) {
            this.f675a.z(this.dl, gVar);
        }
    }

    private boolean a(com.bytedance.sdk.component.dl.g.z.gc.g gVar) {
        if (!fo && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.gz != null) {
                return false;
            }
            if (this.i.g && this.gc.g) {
                return false;
            }
            this.gz = gVar;
            notifyAll();
            this.f675a.g(this.dl);
            return true;
        }
    }

    void z(List<com.bytedance.sdk.component.dl.g.z.gc.dl> list) {
        boolean zG;
        if (!fo && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            zG = true;
            this.wp = true;
            if (this.kb == null) {
                this.kb = list;
                zG = g();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.kb);
                arrayList.add(null);
                arrayList.addAll(list);
                this.kb = arrayList;
            }
        }
        if (zG) {
            return;
        }
        this.f675a.g(this.dl);
    }

    void z(com.bytedance.sdk.component.dl.z.gc gcVar, int i) throws IOException {
        if (!fo && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.i.z(gcVar, i);
    }

    void fo() {
        boolean zG;
        if (!fo && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.i.g = true;
            zG = g();
            notifyAll();
        }
        if (zG) {
            return;
        }
        this.f675a.g(this.dl);
    }

    synchronized void dl(com.bytedance.sdk.component.dl.g.z.gc.g gVar) {
        if (this.gz == null) {
            this.gz = gVar;
            notifyAll();
        }
    }

    private final class g implements js {
        static final /* synthetic */ boolean dl = true;
        private final long e;
        boolean g;
        private final com.bytedance.sdk.component.dl.z.dl gc = new com.bytedance.sdk.component.dl.z.dl();
        private final com.bytedance.sdk.component.dl.z.dl m = new com.bytedance.sdk.component.dl.z.dl();
        boolean z;

        g(long j) {
            this.e = j;
        }

        @Override // com.bytedance.sdk.component.dl.z.js
        public long z(com.bytedance.sdk.component.dl.z.dl dlVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            synchronized (fo.this) {
                g();
                dl();
                if (this.m.g() == 0) {
                    return -1L;
                }
                com.bytedance.sdk.component.dl.z.dl dlVar2 = this.m;
                long jZ = dlVar2.z(dlVar, Math.min(j, dlVar2.g()));
                fo.this.z += jZ;
                if (fo.this.z >= fo.this.f675a.wp.a() / 2) {
                    fo.this.f675a.z(fo.this.dl, fo.this.z);
                    fo.this.z = 0L;
                }
                synchronized (fo.this.f675a) {
                    fo.this.f675a.uy += jZ;
                    if (fo.this.f675a.uy >= fo.this.f675a.wp.a() / 2) {
                        fo.this.f675a.z(0, fo.this.f675a.uy);
                        fo.this.f675a.uy = 0L;
                    }
                }
                return jZ;
            }
        }

        private void g() throws IOException {
            fo.this.m.z();
            while (this.m.g() == 0 && !this.g && !this.z && fo.this.gz == null) {
                try {
                    fo.this.wp();
                } finally {
                    fo.this.m.gz();
                }
            }
        }

        void z(com.bytedance.sdk.component.dl.z.gc gcVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (!dl && Thread.holdsLock(fo.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (fo.this) {
                    z = this.g;
                    z2 = true;
                    z3 = this.m.g() + j > this.e;
                }
                if (z3) {
                    gcVar.gz(j);
                    fo.this.g(com.bytedance.sdk.component.dl.g.z.gc.g.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    gcVar.gz(j);
                    return;
                }
                long jZ = gcVar.z(this.gc, j);
                if (jZ == -1) {
                    throw new EOFException();
                }
                j -= jZ;
                synchronized (fo.this) {
                    if (this.m.g() != 0) {
                        z2 = false;
                    }
                    this.m.z(this.gc);
                    if (z2) {
                        fo.this.notifyAll();
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.component.dl.z.js
        public tb z() {
            return fo.this.m;
        }

        @Override // com.bytedance.sdk.component.dl.z.js, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (fo.this) {
                this.z = true;
                this.m.fv();
                fo.this.notifyAll();
            }
            fo.this.uy();
        }

        private void dl() throws IOException {
            if (this.z) {
                throw new IOException("stream closed");
            }
            if (fo.this.gz != null) {
                throw new pf(fo.this.gz);
            }
        }
    }

    void uy() throws IOException {
        boolean z2;
        boolean zG;
        if (!fo && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z2 = !this.i.g && this.i.z && (this.gc.g || this.gc.z);
            zG = g();
        }
        if (z2) {
            z(com.bytedance.sdk.component.dl.g.z.gc.g.CANCEL);
        } else {
            if (zG) {
                return;
            }
            this.f675a.g(this.dl);
        }
    }

    final class z implements fv {
        static final /* synthetic */ boolean dl = true;
        boolean g;
        private final com.bytedance.sdk.component.dl.z.dl gc = new com.bytedance.sdk.component.dl.z.dl();
        boolean z;

        z() {
        }

        @Override // com.bytedance.sdk.component.dl.z.fv
        public void a_(com.bytedance.sdk.component.dl.z.dl dlVar, long j) throws IOException {
            if (!dl && Thread.holdsLock(fo.this)) {
                throw new AssertionError();
            }
            this.gc.a_(dlVar, j);
            while (this.gc.g() >= 16384) {
                z(false);
            }
        }

        private void z(boolean z) throws IOException {
            long jMin;
            synchronized (fo.this) {
                fo.this.e.z();
                while (fo.this.g <= 0 && !this.g && !this.z && fo.this.gz == null) {
                    try {
                        fo.this.wp();
                    } finally {
                    }
                }
                fo.this.e.gz();
                fo.this.kb();
                jMin = Math.min(fo.this.g, this.gc.g());
                fo.this.g -= jMin;
            }
            fo.this.e.z();
            try {
                fo.this.f675a.z(fo.this.dl, z && jMin == this.gc.g(), this.gc, jMin);
            } finally {
            }
        }

        @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Flushable
        public void flush() throws IOException {
            if (!dl && Thread.holdsLock(fo.this)) {
                throw new AssertionError();
            }
            synchronized (fo.this) {
                fo.this.kb();
            }
            while (this.gc.g() > 0) {
                z(false);
                fo.this.f675a.g();
            }
        }

        @Override // com.bytedance.sdk.component.dl.z.fv
        public tb z() {
            return fo.this.e;
        }

        @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!dl && Thread.holdsLock(fo.this)) {
                throw new AssertionError();
            }
            synchronized (fo.this) {
                if (this.z) {
                    return;
                }
                if (!fo.this.gc.g) {
                    if (this.gc.g() > 0) {
                        while (this.gc.g() > 0) {
                            z(true);
                        }
                    } else {
                        fo.this.f675a.z(fo.this.dl, true, (com.bytedance.sdk.component.dl.z.dl) null, 0L);
                    }
                }
                synchronized (fo.this) {
                    this.z = true;
                }
                fo.this.f675a.g();
                fo.this.uy();
            }
        }
    }

    void z(long j) {
        this.g += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void kb() throws IOException {
        if (this.gc.z) {
            throw new IOException("stream closed");
        }
        if (this.gc.g) {
            throw new IOException("stream finished");
        }
        if (this.gz != null) {
            throw new pf(this.gz);
        }
    }

    void wp() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    class dl extends com.bytedance.sdk.component.dl.z.z {
        dl() {
        }

        @Override // com.bytedance.sdk.component.dl.z.z
        protected void m_() {
            fo.this.g(com.bytedance.sdk.component.dl.g.z.gc.g.CANCEL);
        }

        @Override // com.bytedance.sdk.component.dl.z.z
        protected IOException g(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void gz() throws IOException {
            if (g()) {
                throw g((IOException) null);
            }
        }
    }
}
