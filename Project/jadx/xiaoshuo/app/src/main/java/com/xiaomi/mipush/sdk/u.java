package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes8.dex */
class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f7451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ Intent f118a;

    public u(Context context, Intent intent) {
        this.f7451a = context;
        this.f118a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f7451a.startService(this.f118a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a(e.getMessage());
        }
    }
}
