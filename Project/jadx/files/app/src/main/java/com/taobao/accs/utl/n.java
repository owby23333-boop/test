package com.taobao.accs.utl;

import com.taobao.accs.utl.l;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class n implements Runnable {
    final /* synthetic */ l.a a;
    final /* synthetic */ l b;

    n(l lVar, l.a aVar) {
        this.b = lVar;
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l.f18331c.add(this.a);
    }
}
