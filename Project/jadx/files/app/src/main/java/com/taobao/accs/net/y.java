package com.taobao.accs.net;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class y implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ v b;

    y(v vVar, String str) {
        this.b = vVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.a;
        if (str != null && str.equals(this.b.O) && this.b.f18246t == 2) {
            this.b.K = false;
            this.b.M = true;
            this.b.o();
            this.b.I.setCloseReason("conn timeout");
        }
    }
}
