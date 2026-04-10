package com.ss.android.socialbase.downloader.kb;

/* JADX INFO: loaded from: classes4.dex */
class g implements a, dl, gc {
    private z e;
    private z fo;
    private final int g;
    private z gc;
    private z gz;
    private int kb;
    private z m;
    private volatile boolean uy;
    private final int z;
    private final Object dl = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f2099a = new Object();

    g(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.z = i;
        this.g = i2;
    }

    @Override // com.ss.android.socialbase.downloader.kb.a
    public z z() throws InterruptedException, ls {
        z zVar;
        z zVar2 = this.fo;
        if (zVar2 != null) {
            this.fo = zVar2.f2103a;
            zVar2.f2103a = null;
            return zVar2;
        }
        synchronized (this.f2099a) {
            zVar = this.e;
            while (zVar == null) {
                if (this.uy) {
                    throw new ls("read");
                }
                this.f2099a.wait();
                zVar = this.e;
            }
            this.fo = zVar.f2103a;
            this.gz = null;
            this.e = null;
            zVar.f2103a = null;
        }
        return zVar;
    }

    @Override // com.ss.android.socialbase.downloader.kb.dl
    public void z(z zVar) {
        synchronized (this.dl) {
            z zVar2 = this.m;
            if (zVar2 == null) {
                this.m = zVar;
                this.gc = zVar;
            } else {
                zVar2.f2103a = zVar;
                this.m = zVar;
            }
            this.dl.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.kb.dl
    public z g() throws InterruptedException, ls {
        synchronized (this.dl) {
            if (this.uy) {
                throw new ls("obtain");
            }
            z zVar = this.gc;
            if (zVar == null) {
                int i = this.kb;
                if (i < this.z) {
                    this.kb = i + 1;
                    return new z(this.g);
                }
                do {
                    this.dl.wait();
                    if (this.uy) {
                        throw new ls("obtain");
                    }
                    zVar = this.gc;
                } while (zVar == null);
            }
            this.gc = zVar.f2103a;
            if (zVar == this.m) {
                this.m = null;
            }
            zVar.f2103a = null;
            return zVar;
        }
    }

    @Override // com.ss.android.socialbase.downloader.kb.gc
    public void g(z zVar) {
        synchronized (this.f2099a) {
            z zVar2 = this.gz;
            if (zVar2 == null) {
                this.gz = zVar;
                this.e = zVar;
                this.f2099a.notify();
            } else {
                zVar2.f2103a = zVar;
                this.gz = zVar;
            }
        }
    }

    public void dl() {
        this.uy = true;
        synchronized (this.dl) {
            this.dl.notifyAll();
        }
        synchronized (this.f2099a) {
            this.f2099a.notifyAll();
        }
    }
}
