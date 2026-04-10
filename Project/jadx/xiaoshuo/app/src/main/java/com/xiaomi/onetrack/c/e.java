package com.xiaomi.onetrack.c;

import android.content.Intent;

/* JADX INFO: loaded from: classes8.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f7626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f7627b;

    public e(d dVar, Intent intent) {
        this.f7627b = dVar;
        this.f7626a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String action = this.f7626a.getAction();
        if (action.equals("android.intent.action.SCREEN_OFF") || action.equals("android.intent.action.SCREEN_ON")) {
            com.xiaomi.onetrack.util.p.a("EventManager", "screen on/off");
            s.a().a(action.equals("android.intent.action.SCREEN_ON") ? 0 : 2, false);
            com.xiaomi.onetrack.a.c.b.a().b();
        }
    }
}
