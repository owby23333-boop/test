package org.android.agoo.control;

import android.content.Intent;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class h implements Runnable {
    final /* synthetic */ Intent a;
    final /* synthetic */ g b;

    h(g gVar, Intent intent) {
        this.b = gVar;
        this.a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a.onHandleIntent(this.a);
    }
}
