package com.xiaomi.mipush.sdk;

/* JADX INFO: loaded from: classes8.dex */
class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ NotificationClickedActivity f7455a;

    public y(NotificationClickedActivity notificationClickedActivity) {
        this.f7455a = notificationClickedActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.channel.commonutils.logger.b.e("clicked activity finish by timeout.");
        this.f7455a.finish();
    }
}
