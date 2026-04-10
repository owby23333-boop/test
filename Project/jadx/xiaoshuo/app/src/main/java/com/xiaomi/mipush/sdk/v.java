package com.xiaomi.mipush.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f7452a;

    public v(Context context) {
        this.f7452a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageHandleService.c(this.f7452a);
    }
}
