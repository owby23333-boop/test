package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
final class h implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Intent b;

    h(Context context, Intent intent) {
        this.a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        g.a().b(this.a, this.b);
    }
}
