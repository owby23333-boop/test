package com.xiaomi.onetrack.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
class d extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f7549a;

    public d(c cVar) {
        this.f7549a = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (this.f7549a.d != null) {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    this.f7549a.d.sendEmptyMessageDelayed(100, 500L);
                } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                    this.f7549a.d.sendEmptyMessageDelayed(101, 500L);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.onetrack.util.p.b("BroadcastManager", "screenReceiver throwable: " + th.getMessage());
        }
    }
}
