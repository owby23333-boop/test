package com.taobao.accs.net;

import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class d implements Runnable {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.f18202e.c()) {
            ALog.e(this.a.d(), "receive ping time out! ", new Object[0]);
            f.a(this.a.f18201d).c();
            this.a.a("", false, "receive ping timeout");
            this.a.f18202e.a(-12);
        }
    }
}
