package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
class eb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f7903a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ Context f264a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ boolean f265a;

    public eb(Context context, long j, boolean z) {
        this.f264a = context;
        this.f7903a = j;
        this.f265a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            dx.l(this.f264a, this.f7903a, this.f265a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a("PowerStatsSP onPong exception: " + e.getMessage());
        }
    }
}
