package com.taobao.accs.net;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class x implements Runnable {
    final /* synthetic */ v a;

    x(v vVar) {
        this.a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.o();
        if (this.a.I != null) {
            this.a.I.setCloseReason("shut down");
        }
        synchronized (this.a.f18247u) {
            try {
                this.a.f18247u.notifyAll();
            } catch (Exception unused) {
            }
        }
    }
}
