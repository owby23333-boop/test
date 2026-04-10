package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
final class g implements Runnable {
    final /* synthetic */ AccsDataListener a;
    final /* synthetic */ boolean b;

    g(AccsDataListener accsDataListener, boolean z2) {
        this.a = accsDataListener;
        this.b = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.onAntiBrush(this.b, null);
    }
}
