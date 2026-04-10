package com.bytedance.sdk.component.dl.g.z.gc;

import android.os.SystemClock;
import com.bytedance.sdk.component.dl.g.z.gc.gz;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Closeable {
    static final /* synthetic */ boolean js = true;
    static final ExecutorService z = new com.bytedance.sdk.component.uy.a.a(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.dl.g.z.dl.z("OkHttp Http2Connection", true));
    final g dl;
    int e;
    final i fo;
    final Set<Integer> fv;
    final boolean g;
    final String gc;
    boolean gz;
    final v i;
    private int iq;
    long kb;
    final uy ls;
    int m;
    final dl p;
    final Socket pf;
    private Map<Integer, wp> q;
    private final ExecutorService tb;
    boolean v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map<Integer, fo> f666a = new LinkedHashMap();
    long uy = 0;
    v wp = new v();

    public static abstract class g {
        public static final g m = new g() { // from class: com.bytedance.sdk.component.dl.g.z.gc.e.g.1
            @Override // com.bytedance.sdk.component.dl.g.z.gc.e.g
            public void z(fo foVar) throws IOException {
                foVar.z(com.bytedance.sdk.component.dl.g.z.gc.g.REFUSED_STREAM);
            }
        };

        public void z(e eVar) {
        }

        public abstract void z(fo foVar) throws IOException;
    }

    boolean a(int i) {
        return i != 0 && (i & 1) == 0;
    }

    e(z zVar) {
        v vVar = new v();
        this.i = vVar;
        this.v = false;
        this.fv = new LinkedHashSet();
        this.fo = zVar.m;
        boolean z2 = zVar.e;
        this.g = z2;
        this.dl = zVar.gc;
        this.e = zVar.e ? 1 : 2;
        if (zVar.e) {
            this.e += 2;
        }
        this.iq = zVar.e ? 1 : 2;
        if (zVar.e) {
            this.wp.z(7, 16777216);
        }
        String str = zVar.g;
        this.gc = str;
        this.tb = new com.bytedance.sdk.component.uy.a.a(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bytedance.sdk.component.dl.g.z.dl.z(com.bytedance.sdk.component.dl.g.z.dl.z("OkHttp %s Push Observer", str), true));
        vVar.z(7, 65535);
        vVar.z(5, 16384);
        this.kb = vVar.a();
        this.pf = zVar.z;
        this.ls = new uy(zVar.f674a, z2);
        this.p = new dl(new gz(zVar.dl, z2));
    }

    synchronized fo z(int i) {
        return this.f666a.get(Integer.valueOf(i));
    }

    synchronized fo g(int i) {
        fo foVarRemove;
        foVarRemove = this.f666a.remove(Integer.valueOf(i));
        notifyAll();
        return foVarRemove;
    }

    public synchronized int z() {
        return this.i.dl(Integer.MAX_VALUE);
    }

    public fo z(List<com.bytedance.sdk.component.dl.g.z.gc.dl> list, boolean z2) throws IOException {
        return g(0, list, z2);
    }

    private fo g(int i, List<com.bytedance.sdk.component.dl.g.z.gc.dl> list, boolean z2) throws IOException {
        int i2;
        fo foVar;
        boolean z3;
        boolean z4 = !z2;
        synchronized (this.ls) {
            synchronized (this) {
                if (this.gz) {
                    throw new com.bytedance.sdk.component.dl.g.z.gc.z();
                }
                i2 = this.e;
                this.e = i2 + 2;
                foVar = new fo(i2, this, z4, false, list);
                z3 = !z2 || this.kb == 0 || foVar.g == 0;
                if (foVar.g()) {
                    this.f666a.put(Integer.valueOf(i2), foVar);
                }
            }
            if (i == 0) {
                this.ls.z(z4, i2, i, list);
            } else {
                if (this.g) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
                this.ls.z(i, i2, list);
            }
        }
        if (z3) {
            this.ls.g();
        }
        return foVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.ls.dl());
        r6 = r2;
        r8.kb -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(int r9, boolean r10, com.bytedance.sdk.component.dl.z.dl r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            com.bytedance.sdk.component.dl.g.z.gc.uy r12 = r8.ls
            r12.z(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L60
            monitor-enter(r8)
        L12:
            long r4 = r8.kb     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L30
            java.util.Map<java.lang.Integer, com.bytedance.sdk.component.dl.g.z.gc.fo> r2 = r8.f666a     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            if (r2 == 0) goto L28
            r8.wait()     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            goto L12
        L28:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
        L30:
            long r4 = java.lang.Math.min(r12, r4)     // Catch: java.lang.Throwable -> L56
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L56
            com.bytedance.sdk.component.dl.g.z.gc.uy r4 = r8.ls     // Catch: java.lang.Throwable -> L56
            int r4 = r4.dl()     // Catch: java.lang.Throwable -> L56
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L56
            long r4 = r8.kb     // Catch: java.lang.Throwable -> L56
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L56
            long r4 = r4 - r6
            r8.kb = r4     // Catch: java.lang.Throwable -> L56
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            long r12 = r12 - r6
            com.bytedance.sdk.component.dl.g.z.gc.uy r4 = r8.ls
            if (r10 == 0) goto L51
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = r3
        L52:
            r4.z(r5, r9, r11, r2)
            goto Ld
        L56:
            r9 = move-exception
            goto L5e
        L58:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L56
            r9.<init>()     // Catch: java.lang.Throwable -> L56
            throw r9     // Catch: java.lang.Throwable -> L56
        L5e:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            throw r9
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.dl.g.z.gc.e.z(int, boolean, com.bytedance.sdk.component.dl.z.dl, long):void");
    }

    void z(long j) {
        this.kb += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void z(final int i, final com.bytedance.sdk.component.dl.g.z.gc.g gVar) {
        try {
            z.execute(new com.bytedance.sdk.component.dl.g.z.g("OkHttp %s stream %d", new Object[]{this.gc, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.dl.g.z.gc.e.1
                @Override // com.bytedance.sdk.component.dl.g.z.g
                public void dl() {
                    try {
                        e.this.g(i, gVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    void g(int i, com.bytedance.sdk.component.dl.g.z.gc.g gVar) throws IOException {
        this.ls.z(i, gVar);
    }

    void z(final int i, final long j) {
        try {
            z.execute(new com.bytedance.sdk.component.dl.g.z.g("OkHttp Window Update %s stream %d", new Object[]{this.gc, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.dl.g.z.gc.e.2
                @Override // com.bytedance.sdk.component.dl.g.z.g
                public void dl() {
                    try {
                        e.this.ls.z(i, j);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    void z(final boolean z2, final int i, final int i2, final wp wpVar) {
        try {
            z.execute(new com.bytedance.sdk.component.dl.g.z.g("OkHttp %s ping %08x%08x", new Object[]{this.gc, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.component.dl.g.z.gc.e.3
                @Override // com.bytedance.sdk.component.dl.g.z.g
                public void dl() {
                    try {
                        e.this.g(z2, i, i2, wpVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    void g(boolean z2, int i, int i2, wp wpVar) throws IOException {
        synchronized (this.ls) {
            if (wpVar != null) {
                wpVar.z();
                this.ls.z(z2, i, i2);
            } else {
                this.ls.z(z2, i, i2);
            }
        }
    }

    synchronized wp dl(int i) {
        Map<Integer, wp> map = this.q;
        if (map == null) {
            return null;
        }
        return map.remove(Integer.valueOf(i));
    }

    public void g() throws IOException {
        this.ls.g();
    }

    public void z(com.bytedance.sdk.component.dl.g.z.gc.g gVar) throws IOException {
        synchronized (this.ls) {
            synchronized (this) {
                if (this.gz) {
                    return;
                }
                this.gz = true;
                this.ls.z(this.m, gVar, com.bytedance.sdk.component.dl.g.z.dl.z);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        z(com.bytedance.sdk.component.dl.g.z.gc.g.NO_ERROR, com.bytedance.sdk.component.dl.g.z.gc.g.CANCEL);
    }

    void z(com.bytedance.sdk.component.dl.g.z.gc.g gVar, com.bytedance.sdk.component.dl.g.z.gc.g gVar2) throws IOException {
        fo[] foVarArr;
        if (!js && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        wp[] wpVarArr = null;
        try {
            z(gVar);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (this.f666a.isEmpty()) {
                foVarArr = null;
            } else {
                foVarArr = (fo[]) this.f666a.values().toArray(new fo[this.f666a.size()]);
                this.f666a.clear();
            }
            Map<Integer, wp> map = this.q;
            if (map != null) {
                wp[] wpVarArr2 = (wp[]) map.values().toArray(new wp[this.q.size()]);
                this.q = null;
                wpVarArr = wpVarArr2;
            }
        }
        if (foVarArr != null) {
            for (fo foVar : foVarArr) {
                try {
                    foVar.z(gVar2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        if (wpVarArr != null) {
            for (wp wpVar : wpVarArr) {
                wpVar.dl();
            }
        }
        try {
            this.ls.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.pf.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    public void dl() throws IOException {
        z(true);
    }

    void z(boolean z2) throws IOException {
        if (z2) {
            this.ls.z();
            this.ls.g(this.wp);
            if (this.wp.a() != 65535) {
                this.ls.z(0, r5 - 65535);
            }
        }
        com.bytedance.sdk.component.uy.a.dl dlVar = new com.bytedance.sdk.component.uy.a.dl(this.p, "Http2Connection");
        dlVar.setName("csj_http2_connection" + SystemClock.uptimeMillis());
        dlVar.start();
    }

    public synchronized boolean a() {
        return this.gz;
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.bytedance.sdk.component.dl.z.a f674a;
        com.bytedance.sdk.component.dl.z.gc dl;
        boolean e;
        String g;
        g gc = g.m;
        i m = i.z;
        Socket z;

        public z(boolean z) {
            this.e = z;
        }

        public z z(Socket socket, String str, com.bytedance.sdk.component.dl.z.gc gcVar, com.bytedance.sdk.component.dl.z.a aVar) {
            this.z = socket;
            this.g = str;
            this.dl = gcVar;
            this.f674a = aVar;
            return this;
        }

        public z z(g gVar) {
            this.gc = gVar;
            return this;
        }

        public e z() {
            return new e(this);
        }
    }

    class dl extends com.bytedance.sdk.component.dl.g.z.g implements gz.g {
        final gz z;

        dl(gz gzVar) {
            super("OkHttp %s", e.this.gc);
            this.z = gzVar;
        }

        @Override // com.bytedance.sdk.component.dl.g.z.g
        protected void dl() {
            e eVar;
            com.bytedance.sdk.component.dl.g.z.gc.g gVar = com.bytedance.sdk.component.dl.g.z.gc.g.INTERNAL_ERROR;
            com.bytedance.sdk.component.dl.g.z.gc.g gVar2 = com.bytedance.sdk.component.dl.g.z.gc.g.INTERNAL_ERROR;
            try {
                try {
                    this.z.z(this);
                    while (this.z.z(false, (gz.g) this)) {
                    }
                    gVar = com.bytedance.sdk.component.dl.g.z.gc.g.NO_ERROR;
                    gVar2 = com.bytedance.sdk.component.dl.g.z.gc.g.CANCEL;
                    eVar = e.this;
                } catch (IOException unused) {
                    gVar = com.bytedance.sdk.component.dl.g.z.gc.g.PROTOCOL_ERROR;
                    gVar2 = com.bytedance.sdk.component.dl.g.z.gc.g.PROTOCOL_ERROR;
                    eVar = e.this;
                } catch (NullPointerException unused2) {
                    gVar2 = com.bytedance.sdk.component.dl.g.z.gc.g.PROTOCOL_ERROR;
                    gVar = com.bytedance.sdk.component.dl.g.z.gc.g.PROTOCOL_ERROR;
                    eVar = e.this;
                }
                eVar.z(gVar, gVar2);
                com.bytedance.sdk.component.dl.g.z.dl.z(this.z);
            } catch (Throwable th) {
                try {
                    e.this.z(gVar, gVar2);
                } catch (Exception unused3) {
                }
                com.bytedance.sdk.component.dl.g.z.dl.z(this.z);
                throw th;
            }
        }

        @Override // com.bytedance.sdk.component.dl.g.z.gc.gz.g
        public void z(boolean z, int i, com.bytedance.sdk.component.dl.z.gc gcVar, int i2) throws IOException {
            if (e.this.a(i)) {
                e.this.z(i, gcVar, i2, z);
                return;
            }
            fo foVarZ = e.this.z(i);
            if (foVarZ == null) {
                e.this.z(i, com.bytedance.sdk.component.dl.g.z.gc.g.PROTOCOL_ERROR);
                gcVar.gz(i2);
            } else {
                foVarZ.z(gcVar, i2);
                if (z) {
                    foVarZ.fo();
                }
            }
        }

        @Override // com.bytedance.sdk.component.dl.g.z.gc.gz.g
        public void z(boolean z, int i, int i2, List<com.bytedance.sdk.component.dl.g.z.gc.dl> list) {
            if (e.this.a(i)) {
                e.this.z(i, list, z);
                return;
            }
            synchronized (e.this) {
                fo foVarZ = e.this.z(i);
                if (foVarZ == null) {
                    if (e.this.gz) {
                        return;
                    }
                    if (i <= e.this.m) {
                        return;
                    }
                    if (i % 2 == e.this.e % 2) {
                        return;
                    }
                    final fo foVar = new fo(i, e.this, false, z, list);
                    e.this.m = i;
                    e.this.f666a.put(Integer.valueOf(i), foVar);
                    try {
                        e.z.execute(new com.bytedance.sdk.component.dl.g.z.g("OkHttp %s stream %d", new Object[]{e.this.gc, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.dl.g.z.gc.e.dl.1
                            @Override // com.bytedance.sdk.component.dl.g.z.g
                            public void dl() {
                                try {
                                    e.this.dl.z(foVar);
                                } catch (IOException e) {
                                    com.bytedance.sdk.component.dl.g.z.e.gc.g().z(4, "Http2Connection.Listener failure for " + e.this.gc, e);
                                    try {
                                        foVar.z(com.bytedance.sdk.component.dl.g.z.gc.g.PROTOCOL_ERROR);
                                    } catch (IOException unused) {
                                    }
                                }
                            }
                        });
                    } catch (Throwable unused) {
                    }
                    return;
                }
                foVarZ.z(list);
                if (z) {
                    foVarZ.fo();
                }
            }
        }

        @Override // com.bytedance.sdk.component.dl.g.z.gc.gz.g
        public void z(int i, com.bytedance.sdk.component.dl.g.z.gc.g gVar) {
            if (e.this.a(i)) {
                e.this.dl(i, gVar);
                return;
            }
            fo foVarG = e.this.g(i);
            if (foVarG != null) {
                foVarG.dl(gVar);
            }
        }

        @Override // com.bytedance.sdk.component.dl.g.z.gc.gz.g
        public void z(boolean z, v vVar) {
            fo[] foVarArr;
            long j;
            int i;
            synchronized (e.this) {
                int iA = e.this.i.a();
                if (z) {
                    e.this.i.z();
                }
                e.this.i.z(vVar);
                z(vVar);
                int iA2 = e.this.i.a();
                foVarArr = null;
                if (iA2 == -1 || iA2 == iA) {
                    j = 0;
                } else {
                    j = iA2 - iA;
                    if (!e.this.v) {
                        e.this.z(j);
                        e.this.v = true;
                    }
                    if (!e.this.f666a.isEmpty()) {
                        foVarArr = (fo[]) e.this.f666a.values().toArray(new fo[e.this.f666a.size()]);
                    }
                }
                try {
                    e.z.execute(new com.bytedance.sdk.component.dl.g.z.g("OkHttp %s settings", e.this.gc) { // from class: com.bytedance.sdk.component.dl.g.z.gc.e.dl.2
                        @Override // com.bytedance.sdk.component.dl.g.z.g
                        public void dl() {
                            e.this.dl.z(e.this);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
            if (foVarArr == null || j == 0) {
                return;
            }
            for (fo foVar : foVarArr) {
                synchronized (foVar) {
                    foVar.z(j);
                }
            }
        }

        private void z(final v vVar) {
            try {
                e.z.execute(new com.bytedance.sdk.component.dl.g.z.g("OkHttp %s ACK Settings", new Object[]{e.this.gc}) { // from class: com.bytedance.sdk.component.dl.g.z.gc.e.dl.3
                    @Override // com.bytedance.sdk.component.dl.g.z.g
                    public void dl() {
                        try {
                            e.this.ls.z(vVar);
                        } catch (IOException unused) {
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.sdk.component.dl.g.z.gc.gz.g
        public void z(boolean z, int i, int i2) {
            if (z) {
                wp wpVarDl = e.this.dl(i);
                if (wpVarDl != null) {
                    wpVarDl.g();
                    return;
                }
                return;
            }
            e.this.z(true, i, i2, (wp) null);
        }

        @Override // com.bytedance.sdk.component.dl.g.z.gc.gz.g
        public void z(int i, com.bytedance.sdk.component.dl.g.z.gc.g gVar, com.bytedance.sdk.component.dl.z.m mVar) {
            fo[] foVarArr;
            synchronized (e.this) {
                foVarArr = (fo[]) e.this.f666a.values().toArray(new fo[e.this.f666a.size()]);
                e.this.gz = true;
            }
            for (fo foVar : foVarArr) {
                if (foVar.z() > i && foVar.dl()) {
                    foVar.dl(com.bytedance.sdk.component.dl.g.z.gc.g.REFUSED_STREAM);
                    e.this.g(foVar.z());
                }
            }
        }

        @Override // com.bytedance.sdk.component.dl.g.z.gc.gz.g
        public void z(int i, long j) {
            if (i == 0) {
                synchronized (e.this) {
                    e.this.kb += j;
                    e.this.notifyAll();
                }
                return;
            }
            fo foVarZ = e.this.z(i);
            if (foVarZ != null) {
                synchronized (foVarZ) {
                    foVarZ.z(j);
                }
            }
        }

        @Override // com.bytedance.sdk.component.dl.g.z.gc.gz.g
        public void z(int i, int i2, List<com.bytedance.sdk.component.dl.g.z.gc.dl> list) {
            e.this.z(i2, list);
        }
    }

    void z(final int i, final List<com.bytedance.sdk.component.dl.g.z.gc.dl> list) {
        synchronized (this) {
            if (this.fv.contains(Integer.valueOf(i))) {
                z(i, com.bytedance.sdk.component.dl.g.z.gc.g.PROTOCOL_ERROR);
            } else {
                this.fv.add(Integer.valueOf(i));
                this.tb.execute(new com.bytedance.sdk.component.dl.g.z.g("OkHttp %s Push Request[%s]", new Object[]{this.gc, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.dl.g.z.gc.e.4
                    @Override // com.bytedance.sdk.component.dl.g.z.g
                    public void dl() {
                        if (e.this.fo.z(i, list)) {
                            try {
                                e.this.ls.z(i, com.bytedance.sdk.component.dl.g.z.gc.g.CANCEL);
                                synchronized (e.this) {
                                    e.this.fv.remove(Integer.valueOf(i));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    void z(final int i, final List<com.bytedance.sdk.component.dl.g.z.gc.dl> list, final boolean z2) {
        this.tb.execute(new com.bytedance.sdk.component.dl.g.z.g("OkHttp %s Push Headers[%s]", new Object[]{this.gc, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.dl.g.z.gc.e.5
            @Override // com.bytedance.sdk.component.dl.g.z.g
            public void dl() {
                boolean z3 = e.this.fo.z(i, list, z2);
                if (z3) {
                    try {
                        e.this.ls.z(i, com.bytedance.sdk.component.dl.g.z.gc.g.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (!z3 && !z2) {
                    return;
                }
                synchronized (e.this) {
                    e.this.fv.remove(Integer.valueOf(i));
                }
            }
        });
    }

    void z(final int i, com.bytedance.sdk.component.dl.z.gc gcVar, final int i2, final boolean z2) throws IOException {
        final com.bytedance.sdk.component.dl.z.dl dlVar = new com.bytedance.sdk.component.dl.z.dl();
        long j = i2;
        gcVar.z(j);
        gcVar.z(dlVar, j);
        if (dlVar.g() != j) {
            throw new IOException(dlVar.g() + " != " + i2);
        }
        this.tb.execute(new com.bytedance.sdk.component.dl.g.z.g("OkHttp %s Push Data[%s]", new Object[]{this.gc, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.dl.g.z.gc.e.6
            @Override // com.bytedance.sdk.component.dl.g.z.g
            public void dl() {
                try {
                    boolean z3 = e.this.fo.z(i, dlVar, i2, z2);
                    if (z3) {
                        e.this.ls.z(i, com.bytedance.sdk.component.dl.g.z.gc.g.CANCEL);
                    }
                    if (!z3 && !z2) {
                        return;
                    }
                    synchronized (e.this) {
                        e.this.fv.remove(Integer.valueOf(i));
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    void dl(final int i, final com.bytedance.sdk.component.dl.g.z.gc.g gVar) {
        this.tb.execute(new com.bytedance.sdk.component.dl.g.z.g("OkHttp %s Push Reset[%s]", new Object[]{this.gc, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.dl.g.z.gc.e.7
            @Override // com.bytedance.sdk.component.dl.g.z.g
            public void dl() {
                synchronized (e.this) {
                    e.this.fv.remove(Integer.valueOf(i));
                }
            }
        });
    }
}
