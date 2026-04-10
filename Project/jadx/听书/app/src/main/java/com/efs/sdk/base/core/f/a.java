package com.efs.sdk.base.core.f;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.core.controller.ControllerCenter;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ControllerCenter f1566a;

    abstract void a();

    a() {
        super(com.efs.sdk.base.core.util.concurrent.a.f1581a.getLooper());
        sendEmptyMessageDelayed(0, 60000L);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a();
        sendEmptyMessageDelayed(0, 60000L);
    }
}
