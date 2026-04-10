package org.android.agoo.control;

import android.content.Intent;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class k implements Runnable {
    final /* synthetic */ Intent a;
    final /* synthetic */ BaseIntentService b;

    k(BaseIntentService baseIntentService, Intent intent) {
        this.b = baseIntentService;
        this.a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.onHandleIntent(this.a);
    }
}
