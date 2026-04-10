package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.push.aj;

/* JADX INFO: loaded from: classes8.dex */
class ak extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ aj f7792a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(aj ajVar, Looper looper) {
        super(looper);
        this.f7792a = ajVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        aj.b bVar = (aj.b) message.obj;
        int i = message.what;
        if (i == 0) {
            bVar.a();
        } else if (i == 1) {
            bVar.mo323c();
        }
        super.handleMessage(message);
    }
}
