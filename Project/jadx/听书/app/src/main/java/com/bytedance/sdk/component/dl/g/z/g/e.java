package com.bytedance.sdk.component.dl.g.z.g;

import com.bytedance.sdk.component.dl.g.ls;
import com.bytedance.sdk.component.dl.g.tb;
import com.bytedance.sdk.component.dl.g.uy;
import com.bytedance.sdk.component.dl.g.x;
import com.bytedance.sdk.component.dl.g.z.g.m;
import com.bytedance.sdk.component.dl.g.z.gc.pf;
import com.bytedance.sdk.component.dl.g.zw;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f660a = true;
    public final ls dl;
    private final uy e;
    private final m fo;
    public final com.bytedance.sdk.component.dl.g.gc g;
    private m.z gc;
    private final Object gz;
    private boolean i;
    private dl kb;
    private x m;
    private com.bytedance.sdk.component.dl.g.z.dl.dl pf;
    private int uy;
    private boolean v;
    private boolean wp;
    public final com.bytedance.sdk.component.dl.g.z z;

    public e(uy uyVar, com.bytedance.sdk.component.dl.g.z zVar, com.bytedance.sdk.component.dl.g.gc gcVar, ls lsVar, Object obj) throws IOException {
        this.e = uyVar;
        this.z = zVar;
        this.g = gcVar;
        this.dl = lsVar;
        this.fo = new m(zVar, gz(), gcVar, lsVar);
        this.gz = obj;
    }

    public com.bytedance.sdk.component.dl.g.z.dl.dl z(zw zwVar, tb.z zVar, boolean z2) {
        try {
            com.bytedance.sdk.component.dl.g.z.dl.dl dlVarZ = z(zVar.g(), zVar.dl(), zVar.a(), zwVar.fv(), z2).z(zwVar, zVar, this);
            synchronized (this.e) {
                this.pf = dlVarZ;
            }
            return dlVarZ;
        } catch (IOException e) {
            throw new gc(e);
        }
    }

    private dl z(int i, int i2, int i3, boolean z2, boolean z3) throws Throwable {
        while (true) {
            dl dlVarZ = z(i, i2, i3, z2);
            synchronized (this.e) {
                if (dlVarZ.g == 0) {
                    return dlVarZ;
                }
                if (dlVarZ.z(z3)) {
                    return dlVarZ;
                }
                a();
            }
        }
    }

    private dl z(int i, int i2, int i3, boolean z2) throws Throwable {
        Socket socketE;
        dl dlVar;
        Socket socketZ;
        x xVarG;
        boolean z3;
        boolean z4;
        m.z zVar;
        synchronized (this.e) {
            if (this.i) {
                throw new IllegalStateException("released");
            }
            if (this.pf != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.v) {
                throw new IOException("Canceled");
            }
            socketE = e();
            dlVar = this.kb;
            socketZ = null;
            if (dlVar == null) {
                dlVar = null;
            }
            if (dlVar == null) {
                com.bytedance.sdk.component.dl.g.z.z.z.z(this.e, this.z, this, null);
                dl dlVar2 = this.kb;
                if (dlVar2 != null) {
                    z3 = true;
                    dlVar = dlVar2;
                    xVarG = null;
                } else {
                    xVarG = this.m;
                }
            } else {
                xVarG = null;
            }
            z3 = false;
        }
        com.bytedance.sdk.component.dl.g.z.dl.z(socketE);
        if (dlVar != null) {
            return dlVar;
        }
        if (xVarG != null || ((zVar = this.gc) != null && zVar.z())) {
            z4 = false;
        } else {
            this.gc = this.fo.g();
            z4 = true;
        }
        synchronized (this.e) {
            if (this.v) {
                throw new IOException("Canceled");
            }
            if (z4) {
                List<x> listDl = this.gc.dl();
                int size = listDl.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    x xVar = listDl.get(i4);
                    com.bytedance.sdk.component.dl.g.z.z.z.z(this.e, this.z, this, xVar);
                    dl dlVar3 = this.kb;
                    if (dlVar3 != null) {
                        this.m = xVar;
                        z3 = true;
                        dlVar = dlVar3;
                        break;
                    }
                    i4++;
                }
            }
            if (!z3) {
                if (xVarG == null) {
                    xVarG = this.gc.g();
                }
                this.m = xVarG;
                this.uy = 0;
                dlVar = new dl(this.e, xVarG);
                z(dlVar, false);
            }
        }
        if (z3) {
            return dlVar;
        }
        dlVar.z(i, i2, i3, z2, this.g, this.dl);
        gz().g(dlVar.z());
        synchronized (this.e) {
            this.wp = true;
            com.bytedance.sdk.component.dl.g.z.z.z.g(this.e, dlVar);
            if (dlVar.gc()) {
                socketZ = com.bytedance.sdk.component.dl.g.z.z.z.z(this.e, this.z, this);
                dlVar = this.kb;
            }
        }
        com.bytedance.sdk.component.dl.g.z.dl.z(socketZ);
        return dlVar;
    }

    private Socket e() {
        if (!f660a && !Thread.holdsLock(this.e)) {
            throw new AssertionError();
        }
        dl dlVar = this.kb;
        if (dlVar == null || !dlVar.z) {
            return null;
        }
        return z(false, false, true);
    }

    public void z(boolean z2, com.bytedance.sdk.component.dl.g.z.dl.dl dlVar, long j, IOException iOException) {
        Socket socketZ;
        synchronized (this.e) {
            if (dlVar != null) {
                if (dlVar == this.pf) {
                    if (!z2) {
                        this.kb.g++;
                    }
                    socketZ = z(z2, false, true);
                }
            }
            throw new IllegalStateException("expected " + this.pf + " but was " + dlVar);
        }
        com.bytedance.sdk.component.dl.g.z.dl.z(socketZ);
        if (iOException != null) {
            this.dl.z(this.g, iOException);
        }
    }

    public com.bytedance.sdk.component.dl.g.z.dl.dl z() {
        com.bytedance.sdk.component.dl.g.z.dl.dl dlVar;
        synchronized (this.e) {
            dlVar = this.pf;
        }
        return dlVar;
    }

    private a gz() {
        return com.bytedance.sdk.component.dl.g.z.z.z.z(this.e);
    }

    public synchronized dl g() {
        return this.kb;
    }

    public void dl() {
        Socket socketZ;
        synchronized (this.e) {
            socketZ = z(false, true, false);
        }
        com.bytedance.sdk.component.dl.g.z.dl.z(socketZ);
    }

    public void a() {
        Socket socketZ;
        synchronized (this.e) {
            socketZ = z(true, false, false);
        }
        com.bytedance.sdk.component.dl.g.z.dl.z(socketZ);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.Socket z(boolean r2, boolean r3, boolean r4) {
        /*
            r1 = this;
            boolean r0 = com.bytedance.sdk.component.dl.g.z.g.e.f660a
            if (r0 != 0) goto L13
            com.bytedance.sdk.component.dl.g.uy r0 = r1.e
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
            r1.pf = r0
        L18:
            r4 = 1
            if (r3 == 0) goto L1d
            r1.i = r4
        L1d:
            com.bytedance.sdk.component.dl.g.z.g.dl r3 = r1.kb
            if (r3 == 0) goto L61
            if (r2 == 0) goto L25
            r3.z = r4
        L25:
            com.bytedance.sdk.component.dl.g.z.dl.dl r2 = r1.pf
            if (r2 != 0) goto L61
            boolean r2 = r1.i
            if (r2 != 0) goto L33
            com.bytedance.sdk.component.dl.g.z.g.dl r2 = r1.kb
            boolean r2 = r2.z
            if (r2 == 0) goto L61
        L33:
            com.bytedance.sdk.component.dl.g.z.g.dl r2 = r1.kb
            r1.g(r2)
            com.bytedance.sdk.component.dl.g.z.g.dl r2 = r1.kb
            java.util.List<java.lang.ref.Reference<com.bytedance.sdk.component.dl.g.z.g.e>> r2 = r2.f659a
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L5d
            com.bytedance.sdk.component.dl.g.z.g.dl r2 = r1.kb
            long r3 = java.lang.System.nanoTime()
            r2.gc = r3
            com.bytedance.sdk.component.dl.g.z.z r2 = com.bytedance.sdk.component.dl.g.z.z.z
            com.bytedance.sdk.component.dl.g.uy r3 = r1.e
            com.bytedance.sdk.component.dl.g.z.g.dl r4 = r1.kb
            boolean r2 = r2.z(r3, r4)
            if (r2 == 0) goto L5d
            com.bytedance.sdk.component.dl.g.z.g.dl r2 = r1.kb
            java.net.Socket r2 = r2.dl()
            goto L5e
        L5d:
            r2 = r0
        L5e:
            r1.kb = r0
            r0 = r2
        L61:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.dl.g.z.g.e.z(boolean, boolean, boolean):java.net.Socket");
    }

    public void gc() {
        com.bytedance.sdk.component.dl.g.z.dl.dl dlVar;
        dl dlVar2;
        synchronized (this.e) {
            this.v = true;
            dlVar = this.pf;
            dlVar2 = this.kb;
        }
        if (dlVar != null) {
            dlVar.dl();
        } else if (dlVar2 != null) {
            dlVar2.g();
        }
    }

    public void z(IOException iOException) {
        boolean z2;
        Socket socketZ;
        synchronized (this.e) {
            if (iOException instanceof pf) {
                pf pfVar = (pf) iOException;
                if (pfVar.z == com.bytedance.sdk.component.dl.g.z.gc.g.REFUSED_STREAM) {
                    this.uy++;
                }
                if (pfVar.z != com.bytedance.sdk.component.dl.g.z.gc.g.REFUSED_STREAM || this.uy > 1) {
                    this.m = null;
                    z2 = true;
                }
                z2 = false;
            } else {
                dl dlVar = this.kb;
                if (dlVar != null && (!dlVar.gc() || (iOException instanceof com.bytedance.sdk.component.dl.g.z.gc.z))) {
                    if (this.kb.g == 0) {
                        x xVar = this.m;
                        if (xVar != null && iOException != null) {
                            this.fo.z(xVar, iOException);
                        }
                        this.m = null;
                    }
                    z2 = true;
                }
                z2 = false;
            }
            socketZ = z(z2, false, true);
        }
        com.bytedance.sdk.component.dl.g.z.dl.z(socketZ);
    }

    public void z(dl dlVar, boolean z2) {
        if (!f660a && !Thread.holdsLock(this.e)) {
            throw new AssertionError();
        }
        if (this.kb != null) {
            throw new IllegalStateException();
        }
        this.kb = dlVar;
        this.wp = z2;
        dlVar.f659a.add(new z(this, this.gz));
    }

    private void g(dl dlVar) {
        int size = dlVar.f659a.size();
        for (int i = 0; i < size; i++) {
            if (dlVar.f659a.get(i).get() == this) {
                dlVar.f659a.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket z(dl dlVar) {
        if (!f660a && !Thread.holdsLock(this.e)) {
            throw new AssertionError();
        }
        if (this.pf != null || this.kb.f659a.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<e> reference = this.kb.f659a.get(0);
        Socket socketZ = z(true, false, false);
        this.kb = dlVar;
        dlVar.f659a.add(reference);
        return socketZ;
    }

    public boolean m() {
        if (this.m != null) {
            return true;
        }
        m.z zVar = this.gc;
        return (zVar != null && zVar.z()) || this.fo.z();
    }

    public String toString() {
        dl dlVarG = g();
        return dlVarG != null ? dlVarG.toString() : this.z.toString();
    }

    public static final class z extends WeakReference<e> {
        public final Object z;

        z(e eVar, Object obj) {
            super(eVar);
            this.z = obj;
        }
    }
}
