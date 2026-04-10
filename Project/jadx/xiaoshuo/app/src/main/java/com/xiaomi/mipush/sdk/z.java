package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes8.dex */
class z extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ NotificationClickedActivity f7456a;

    public z(NotificationClickedActivity notificationClickedActivity) {
        this.f7456a = notificationClickedActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.xiaomi.channel.commonutils.logger.b.b("clicked activity finish by normal.");
        this.f7456a.finish();
    }
}
