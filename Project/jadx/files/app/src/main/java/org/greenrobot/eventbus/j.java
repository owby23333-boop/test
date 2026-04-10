package org.greenrobot.eventbus;

/* JADX INFO: compiled from: PendingPostQueue.java */
/* JADX INFO: loaded from: classes3.dex */
final class j {
    private i a;
    private i b;

    j() {
    }

    synchronized void a(i iVar) {
        try {
            if (iVar == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            if (this.b != null) {
                this.b.f21338c = iVar;
                this.b = iVar;
            } else {
                if (this.a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.b = iVar;
                this.a = iVar;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized i a() {
        i iVar;
        iVar = this.a;
        if (this.a != null) {
            this.a = this.a.f21338c;
            if (this.a == null) {
                this.b = null;
            }
        }
        return iVar;
    }

    synchronized i a(int i2) throws InterruptedException {
        if (this.a == null) {
            wait(i2);
        }
        return a();
    }
}
