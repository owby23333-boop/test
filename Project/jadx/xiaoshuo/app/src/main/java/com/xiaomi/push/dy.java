package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
class dy implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f7900a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ Context f258a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ boolean f259a;

    public dy(Context context, long j, boolean z) {
        this.f258a = context;
        this.f7900a = j;
        this.f259a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            dx.i(this.f258a, this.f7900a, this.f259a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a("PowerStatsSP onSendMsg exception: " + e.getMessage());
        }
    }
}
