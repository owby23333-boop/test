package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
class dq implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f7891a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ Context f251a;

    public dq(Context context, long j) {
        this.f251a = context;
        this.f7891a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Cdo.c(this.f251a, this.f7891a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a("DisconnectStatsSP onReconnection exception: " + e.getMessage());
        }
    }
}
