package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.f;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.j;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final /* synthetic */ boolean f977o = !g.class.desiredAssertionStatus();
    public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a a;
    private f.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c0 f978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j f979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e f980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f982g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final f f983h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f984i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f985j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f986k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f987l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f988m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c f989n;

    public static final class a extends WeakReference<g> {
        public final Object a;

        a(g gVar, Object obj) {
            super(gVar);
            this.a = obj;
        }
    }

    public g(j jVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar, Object obj) throws IOException {
        this.f979d = jVar;
        this.a = aVar;
        this.f980e = eVar;
        this.f981f = pVar;
        this.f983h = new f(aVar, g(), eVar, pVar);
        this.f982g = obj;
    }

    private c a(int i2, int i3, int i4, boolean z2) throws Throwable {
        c cVar;
        Socket socketF;
        Socket socketA;
        c cVar2;
        c cVar3;
        c0 c0VarC;
        boolean z3;
        boolean z4;
        c cVar4;
        c cVar5;
        f.a aVar;
        synchronized (this.f979d) {
            if (this.f987l) {
                throw new IllegalStateException("released");
            }
            if (this.f989n != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.f988m) {
                throw new IOException("Canceled");
            }
            cVar = this.f985j;
            socketF = f();
            socketA = null;
            if (this.f985j != null) {
                cVar2 = this.f985j;
                cVar = null;
            } else {
                cVar2 = null;
            }
            if (!this.f986k) {
                cVar = null;
            }
            if (cVar2 == null) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(this.f979d, this.a, this, null);
                if (this.f985j != null) {
                    cVar3 = this.f985j;
                    c0VarC = null;
                    z3 = true;
                } else {
                    c0VarC = this.f978c;
                    cVar3 = cVar2;
                }
            } else {
                cVar3 = cVar2;
                c0VarC = null;
            }
            z3 = false;
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(socketF);
        if (cVar != null) {
            this.f981f.b(this.f980e, cVar);
        }
        if (z3) {
            this.f981f.a(this.f980e, cVar3);
        }
        if (cVar3 != null) {
            return cVar3;
        }
        if (c0VarC != null || ((aVar = this.b) != null && aVar.b())) {
            z4 = false;
        } else {
            this.b = this.f983h.b();
            z4 = true;
        }
        synchronized (this.f979d) {
            if (this.f988m) {
                throw new IOException("Canceled");
            }
            if (z4) {
                List<c0> listA = this.b.a();
                int size = listA.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    c0 c0Var = listA.get(i5);
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(this.f979d, this.a, this, c0Var);
                    if (this.f985j != null) {
                        cVar3 = this.f985j;
                        this.f978c = c0Var;
                        z3 = true;
                        break;
                    }
                    i5++;
                }
            }
            if (z3) {
                cVar4 = cVar3;
            } else {
                if (c0VarC == null) {
                    c0VarC = this.b.c();
                }
                this.f978c = c0VarC;
                this.f984i = 0;
                cVar4 = new c(this.f979d, c0VarC);
                a(cVar4, false);
            }
        }
        if (z3) {
            this.f981f.a(this.f980e, cVar4);
            return cVar4;
        }
        cVar4.a(i2, i3, i4, z2, this.f980e, this.f981f);
        g().a(cVar4.a());
        synchronized (this.f979d) {
            this.f986k = true;
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.b(this.f979d, cVar4);
            if (cVar4.c()) {
                socketA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(this.f979d, this.a, this);
                cVar4 = this.f985j;
            }
            cVar5 = cVar4;
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(socketA);
        this.f981f.a(this.f980e, cVar5);
        return cVar5;
    }

    private c a(int i2, int i3, int i4, boolean z2, boolean z3) throws Throwable {
        c cVarA;
        while (true) {
            cVarA = a(i2, i3, i4, z2);
            synchronized (this.f979d) {
                if (cVarA.f967l != 0) {
                    if (cVarA.a(z3)) {
                        break;
                    }
                    d();
                } else {
                    break;
                }
            }
        }
        return cVarA;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.Socket a(boolean r2, boolean r3, boolean r4) {
        /*
            r1 = this;
            boolean r0 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g.f977o
            if (r0 != 0) goto L13
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.j r0 = r1.f979d
            boolean r0 = java.lang.Thread.holdsLock(r0)
            if (r0 == 0) goto Ld
            goto L13
        Ld:
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L13:
            r0 = 0
            if (r4 == 0) goto L18
            r1.f989n = r0
        L18:
            r4 = 1
            if (r3 == 0) goto L1d
            r1.f987l = r4
        L1d:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r3 = r1.f985j
            if (r3 == 0) goto L61
            if (r2 == 0) goto L25
            r3.f966k = r4
        L25:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c r2 = r1.f989n
            if (r2 != 0) goto L61
            boolean r2 = r1.f987l
            if (r2 != 0) goto L33
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r2 = r1.f985j
            boolean r2 = r2.f966k
            if (r2 == 0) goto L61
        L33:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r2 = r1.f985j
            r1.b(r2)
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r2 = r1.f985j
            java.util.List<java.lang.ref.Reference<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g>> r2 = r2.f969n
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L5d
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r2 = r1.f985j
            long r3 = java.lang.System.nanoTime()
            r2.f970o = r3
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.j r3 = r1.f979d
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r4 = r1.f985j
            boolean r2 = r2.a(r3, r4)
            if (r2 == 0) goto L5d
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r2 = r1.f985j
            java.net.Socket r2 = r2.e()
            goto L5e
        L5d:
            r2 = r0
        L5e:
            r1.f985j = r0
            goto L62
        L61:
            r2 = r0
        L62:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g.a(boolean, boolean, boolean):java.net.Socket");
    }

    private void b(c cVar) {
        int size = cVar.f969n.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (cVar.f969n.get(i2).get() == this) {
                cVar.f969n.remove(i2);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private Socket f() {
        if (!f977o && !Thread.holdsLock(this.f979d)) {
            throw new AssertionError();
        }
        c cVar = this.f985j;
        if (cVar == null || !cVar.f966k) {
            return null;
        }
        return a(false, false, true);
    }

    private d g() {
        return bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(this.f979d);
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c a() {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c cVar;
        synchronized (this.f979d) {
            cVar = this.f989n;
        }
        return cVar;
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c a(v vVar, t.a aVar, boolean z2) {
        try {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c cVarA = a(aVar.c(), aVar.d(), aVar.a(), vVar.v(), z2).a(vVar, aVar, this);
            synchronized (this.f979d) {
                this.f989n = cVarA;
            }
            return cVarA;
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    public Socket a(c cVar) {
        if (!f977o && !Thread.holdsLock(this.f979d)) {
            throw new AssertionError();
        }
        if (this.f989n != null || this.f985j.f969n.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<g> reference = this.f985j.f969n.get(0);
        Socket socketA = a(true, false, false);
        this.f985j = cVar;
        cVar.f969n.add(reference);
        return socketA;
    }

    public void a(c cVar, boolean z2) {
        if (!f977o && !Thread.holdsLock(this.f979d)) {
            throw new AssertionError();
        }
        if (this.f985j != null) {
            throw new IllegalStateException();
        }
        this.f985j = cVar;
        this.f986k = z2;
        cVar.f969n.add(new a(this, this.f982g));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if (r6.f984i <= 1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055 A[Catch: all -> 0x0068, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:8:0x0012, B:9:0x0017, B:11:0x001d, B:28:0x004b, B:30:0x0055, B:33:0x005a, B:13:0x0021, B:14:0x0024, B:16:0x0028, B:18:0x0030, B:20:0x0034, B:22:0x003a, B:25:0x0040), top: B:43:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.io.IOException r7) {
        /*
            r6 = this;
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.j r0 = r6.f979d
            monitor-enter(r0)
            boolean r1 = r7 instanceof bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.o     // Catch: java.lang.Throwable -> L68
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L24
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.o r7 = (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.o) r7     // Catch: java.lang.Throwable -> L68
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b r1 = r7.a     // Catch: java.lang.Throwable -> L68
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b r5 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.REFUSED_STREAM     // Catch: java.lang.Throwable -> L68
            if (r1 != r5) goto L17
            int r1 = r6.f984i     // Catch: java.lang.Throwable -> L68
            int r1 = r1 + r4
            r6.f984i = r1     // Catch: java.lang.Throwable -> L68
        L17:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b r7 = r7.a     // Catch: java.lang.Throwable -> L68
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b r1 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.REFUSED_STREAM     // Catch: java.lang.Throwable -> L68
            if (r7 != r1) goto L21
            int r7 = r6.f984i     // Catch: java.lang.Throwable -> L68
            if (r7 <= r4) goto L4a
        L21:
            r6.f978c = r3     // Catch: java.lang.Throwable -> L68
            goto L48
        L24:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r1 = r6.f985j     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L4a
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r1 = r6.f985j     // Catch: java.lang.Throwable -> L68
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L34
            boolean r1 = r7 instanceof bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.a     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L4a
        L34:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r1 = r6.f985j     // Catch: java.lang.Throwable -> L68
            int r1 = r1.f967l     // Catch: java.lang.Throwable -> L68
            if (r1 != 0) goto L48
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0 r1 = r6.f978c     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L21
            if (r7 == 0) goto L21
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.f r1 = r6.f983h     // Catch: java.lang.Throwable -> L68
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0 r5 = r6.f978c     // Catch: java.lang.Throwable -> L68
            r1.a(r5, r7)     // Catch: java.lang.Throwable -> L68
            goto L21
        L48:
            r7 = 1
            goto L4b
        L4a:
            r7 = 0
        L4b:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r1 = r6.f985j     // Catch: java.lang.Throwable -> L68
            java.net.Socket r7 = r6.a(r7, r2, r4)     // Catch: java.lang.Throwable -> L68
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r2 = r6.f985j     // Catch: java.lang.Throwable -> L68
            if (r2 != 0) goto L59
            boolean r2 = r6.f986k     // Catch: java.lang.Throwable -> L68
            if (r2 != 0) goto L5a
        L59:
            r1 = r3
        L5a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L68
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(r7)
            if (r1 == 0) goto L67
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p r7 = r6.f981f
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e r0 = r6.f980e
            r7.b(r0, r1)
        L67:
            return
        L68:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L68
            goto L6c
        L6b:
            throw r7
        L6c:
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g.a(java.io.IOException):void");
    }

    public void a(boolean z2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c cVar, long j2, IOException iOException) {
        c cVar2;
        Socket socketA;
        boolean z3;
        this.f981f.b(this.f980e, j2);
        synchronized (this.f979d) {
            if (cVar != null) {
                if (cVar == this.f989n) {
                    if (!z2) {
                        this.f985j.f967l++;
                    }
                    cVar2 = this.f985j;
                    socketA = a(z2, false, true);
                    if (this.f985j != null) {
                        cVar2 = null;
                    }
                    z3 = this.f987l;
                }
            }
            throw new IllegalStateException("expected " + this.f989n + " but was " + cVar);
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(socketA);
        if (cVar2 != null) {
            this.f981f.b(this.f980e, cVar2);
        }
        if (iOException != null) {
            this.f981f.a(this.f980e, iOException);
        } else if (z3) {
            this.f981f.a(this.f980e);
        }
    }

    public c b() {
        c cVar;
        synchronized (this) {
            cVar = this.f985j;
        }
        return cVar;
    }

    public boolean c() {
        f.a aVar;
        return this.f978c != null || ((aVar = this.b) != null && aVar.b()) || this.f983h.a();
    }

    public void d() {
        c cVar;
        Socket socketA;
        synchronized (this.f979d) {
            cVar = this.f985j;
            socketA = a(true, false, false);
            if (this.f985j != null) {
                cVar = null;
            }
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(socketA);
        if (cVar != null) {
            this.f981f.b(this.f980e, cVar);
        }
    }

    public void e() {
        c cVar;
        Socket socketA;
        synchronized (this.f979d) {
            cVar = this.f985j;
            socketA = a(false, true, false);
            if (this.f985j != null) {
                cVar = null;
            }
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(socketA);
        if (cVar != null) {
            this.f981f.b(this.f980e, cVar);
        }
    }

    public String toString() {
        c cVarB = b();
        return cVarB != null ? cVarB.toString() : this.a.toString();
    }
}
