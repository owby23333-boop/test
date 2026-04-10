package com.taobao.accs.utl;

import android.content.Intent;
import com.taobao.accs.base.AccsDataListener;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
final class b implements Runnable {
    final /* synthetic */ AccsDataListener a;
    final /* synthetic */ String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f18302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Intent f18303d;

    b(AccsDataListener accsDataListener, String str, int i2, Intent intent) {
        this.a = accsDataListener;
        this.b = str;
        this.f18302c = i2;
        this.f18303d = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.onBind(this.b, this.f18302c, a.c(this.f18303d));
    }
}
