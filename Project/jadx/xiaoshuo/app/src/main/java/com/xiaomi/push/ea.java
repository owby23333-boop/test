package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
class ea implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f7902a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ Context f262a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ boolean f263a;

    public ea(Context context, long j, boolean z) {
        this.f262a = context;
        this.f7902a = j;
        this.f263a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            dx.k(this.f262a, this.f7902a, this.f263a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a("PowerStatsSP onPing exception: " + e.getMessage());
        }
    }
}
