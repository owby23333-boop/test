package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
class dp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f7889a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ long f245a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ Context f246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ String f247a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ boolean f248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f7890b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    final /* synthetic */ long f249b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    final /* synthetic */ String f250b;
    final /* synthetic */ int c;

    public dp(Context context, String str, boolean z, long j, int i, long j2, int i2, String str2, int i3) {
        this.f246a = context;
        this.f247a = str;
        this.f248a = z;
        this.f245a = j;
        this.f7889a = i;
        this.f249b = j2;
        this.f7890b = i2;
        this.f250b = str2;
        this.c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Cdo.c(this.f246a, this.f247a, this.f248a, this.f245a, this.f7889a, this.f249b, this.f7890b, this.f250b, this.c);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a("DisconnectStatsSP onDisconnection exception: " + e.getMessage());
        }
    }
}
