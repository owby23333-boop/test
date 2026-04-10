package com.ss.android.socialbase.downloader.uy;

import android.os.Process;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.downloader.kb.ls;
import com.ss.android.socialbase.downloader.pf.m;
import java.io.InputStream;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes4.dex */
public class z implements g {
    private final int dl;
    private com.ss.android.socialbase.downloader.kb.z e;
    private com.ss.android.socialbase.downloader.kb.z fo;
    private final int g;
    private com.ss.android.socialbase.downloader.kb.z gz;
    private volatile boolean i;
    private com.ss.android.socialbase.downloader.kb.z kb;
    private int ls;
    private com.ss.android.socialbase.downloader.kb.z m;
    private volatile Future pf;
    private com.ss.android.socialbase.downloader.kb.z uy;
    private volatile Throwable v;
    private volatile boolean wp;
    private final InputStream z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f2111a = new Object();
    private final Object gc = new Object();
    private final Runnable p = new Runnable() { // from class: com.ss.android.socialbase.downloader.uy.z.1
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.kb.z zVarA;
            Process.setThreadPriority(10);
            do {
                try {
                    zVarA = z.this.a();
                    zVarA.dl = z.this.z.read(zVarA.z);
                    z.this.dl(zVarA);
                } catch (Throwable th) {
                    try {
                        z.this.v = th;
                        wp.z(th);
                        synchronized (z.this.gc) {
                            z.this.i = true;
                            z.this.gc.notify();
                            m.z(z.this.z);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (z.this.gc) {
                            z.this.i = true;
                            z.this.gc.notify();
                            m.z(z.this.z);
                            throw th2;
                        }
                    }
                }
            } while (zVarA.dl != -1);
            synchronized (z.this.gc) {
                z.this.i = true;
                z.this.gc.notify();
            }
            m.z(z.this.z);
        }
    };

    public z(InputStream inputStream, int i, int i2) throws Throwable {
        this.z = inputStream;
        this.g = i;
        if (i2 <= 0) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.dl = i2;
        dl();
    }

    @Override // com.ss.android.socialbase.downloader.uy.g
    public com.ss.android.socialbase.downloader.kb.z z() throws InterruptedException, com.ss.android.socialbase.downloader.gc.z {
        return gc();
    }

    @Override // com.ss.android.socialbase.downloader.uy.g
    public void z(com.ss.android.socialbase.downloader.kb.z zVar) {
        g(zVar);
    }

    @Override // com.ss.android.socialbase.downloader.uy.g
    public void g() {
        synchronized (this.f2111a) {
            this.wp = true;
            this.f2111a.notify();
        }
        Future future = this.pf;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.pf = null;
        }
    }

    private void dl() throws Throwable {
        this.pf = com.ss.android.socialbase.downloader.downloader.dl.ls().submit(this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.kb.z a() throws InterruptedException, ls {
        int i;
        com.ss.android.socialbase.downloader.kb.z zVar = this.gz;
        if (zVar != null) {
            if (this.wp) {
                throw new ls("");
            }
            this.gz = zVar.f2103a;
            zVar.f2103a = null;
            return zVar;
        }
        synchronized (this.f2111a) {
            if (this.wp) {
                throw new ls("");
            }
            com.ss.android.socialbase.downloader.kb.z zVar2 = this.m;
            if (zVar2 == null && (i = this.ls) < this.dl) {
                this.ls = i + 1;
                return new com.ss.android.socialbase.downloader.kb.z(this.g);
            }
            while (zVar2 == null) {
                this.f2111a.wait();
                if (this.wp) {
                    throw new ls("");
                }
                zVar2 = this.m;
            }
            this.gz = zVar2.f2103a;
            this.e = null;
            this.m = null;
            zVar2.f2103a = null;
            return zVar2;
        }
    }

    private void g(com.ss.android.socialbase.downloader.kb.z zVar) {
        synchronized (this.f2111a) {
            com.ss.android.socialbase.downloader.kb.z zVar2 = this.e;
            if (zVar2 == null) {
                this.e = zVar;
                this.m = zVar;
                this.f2111a.notify();
            } else {
                zVar2.f2103a = zVar;
                this.e = zVar;
            }
        }
    }

    private com.ss.android.socialbase.downloader.kb.z gc() throws InterruptedException, com.ss.android.socialbase.downloader.gc.z {
        com.ss.android.socialbase.downloader.kb.z zVar;
        com.ss.android.socialbase.downloader.kb.z zVar2 = this.kb;
        if (zVar2 != null) {
            this.kb = zVar2.f2103a;
            zVar2.f2103a = null;
            return zVar2;
        }
        synchronized (this.gc) {
            zVar = this.fo;
            if (zVar == null) {
                do {
                    if (this.i) {
                        m();
                    }
                    this.gc.wait();
                    zVar = this.fo;
                } while (zVar == null);
            }
            this.kb = zVar.f2103a;
            this.uy = null;
            this.fo = null;
            zVar.f2103a = null;
        }
        return zVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(com.ss.android.socialbase.downloader.kb.z zVar) {
        synchronized (this.gc) {
            com.ss.android.socialbase.downloader.kb.z zVar2 = this.uy;
            if (zVar2 == null) {
                this.uy = zVar;
                this.fo = zVar;
                this.gc.notify();
            } else {
                zVar2.f2103a = zVar;
                this.uy = zVar;
            }
        }
    }

    private void m() throws com.ss.android.socialbase.downloader.gc.z {
        Throwable th = this.v;
        if (th != null) {
            if (th instanceof ls) {
                throw new com.ss.android.socialbase.downloader.gc.z(1068, "async reader closed!");
            }
            m.z(th, "async_read");
        }
        throw new com.ss.android.socialbase.downloader.gc.z(1069, "async reader terminated!");
    }
}
