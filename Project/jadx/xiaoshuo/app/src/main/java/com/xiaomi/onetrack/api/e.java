package com.xiaomi.onetrack.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;

/* JADX INFO: loaded from: classes8.dex */
class e extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f7550a;

    public e(c cVar) {
        this.f7550a = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f7550a.d != null) {
            Intent intent2 = new Intent();
            intent2.putExtras(intent);
            Message messageObtain = Message.obtain();
            messageObtain.what = 10;
            messageObtain.obj = intent2;
            this.f7550a.d.sendMessage(messageObtain);
            com.xiaomi.onetrack.util.p.a("BroadcastManager", "netReceiver");
        }
    }
}
