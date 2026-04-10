package com.taobao.accs.data;

import com.taobao.accs.ut.monitor.TrafficsMonitor;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class e implements Runnable {
    final /* synthetic */ TrafficsMonitor.a a;
    final /* synthetic */ d b;

    e(d dVar, TrafficsMonitor.a aVar) {
        this.b = dVar;
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TrafficsMonitor trafficsMonitor = this.b.f18172c;
        if (trafficsMonitor != null) {
            trafficsMonitor.a(this.a);
        }
    }
}
