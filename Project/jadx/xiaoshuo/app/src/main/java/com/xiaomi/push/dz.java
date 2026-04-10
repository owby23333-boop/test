package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
class dz implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f7901a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ Context f260a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ boolean f261a;

    public dz(Context context, long j, boolean z) {
        this.f260a = context;
        this.f7901a = j;
        this.f261a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            dx.j(this.f260a, this.f7901a, this.f261a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a("PowerStatsSP onReceiveMsg exception: " + e.getMessage());
        }
    }
}
