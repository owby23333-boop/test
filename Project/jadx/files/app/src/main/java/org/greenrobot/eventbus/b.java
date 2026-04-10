package org.greenrobot.eventbus;

import java.util.logging.Level;

/* JADX INFO: compiled from: BackgroundPoster.java */
/* JADX INFO: loaded from: classes3.dex */
final class b implements Runnable, k {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final j f21296s = new j();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final c f21297t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile boolean f21298u;

    b(c cVar) {
        this.f21297t = cVar;
    }

    @Override // org.greenrobot.eventbus.k
    public void a(o oVar, Object obj) {
        i iVarA = i.a(oVar, obj);
        synchronized (this) {
            this.f21296s.a(iVarA);
            if (!this.f21298u) {
                this.f21298u = true;
                this.f21297t.a().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVarA;
        while (true) {
            try {
                iVarA = this.f21296s.a(1000);
            } catch (InterruptedException e2) {
                this.f21297t.b().a(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e2);
                return;
            } finally {
                this.f21298u = false;
            }
            if (iVarA == null) {
                synchronized (this) {
                    iVarA = this.f21296s.a();
                    if (iVarA == null) {
                        return;
                    }
                    this.f21298u = false;
                }
            }
            this.f21297t.a(iVarA);
        }
    }
}
