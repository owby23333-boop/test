package com.taobao.accs.utl;

import android.content.Intent;
import com.taobao.accs.base.AccsDataListener;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
final class c implements Runnable {
    final /* synthetic */ AccsDataListener a;
    final /* synthetic */ String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f18304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Intent f18305d;

    c(AccsDataListener accsDataListener, String str, int i2, Intent intent) {
        this.a = accsDataListener;
        this.b = str;
        this.f18304c = i2;
        this.f18305d = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.onUnbind(this.b, this.f18304c, a.c(this.f18305d));
    }
}
