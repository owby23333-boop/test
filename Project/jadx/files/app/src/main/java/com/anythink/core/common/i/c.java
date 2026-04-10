package com.anythink.core.common.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class c implements a {
    private static final String a = "TimeOutHandlerImpl";
    private static volatile c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f7580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f7581d;

    private c() {
        HandlerThread handlerThread = new HandlerThread("timeout_handler_thread");
        handlerThread.start();
        this.f7581d = new Handler(handlerThread.getLooper());
        this.f7580c = new Handler(Looper.getMainLooper());
    }

    public static a a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    private Handler a(boolean z2) {
        return z2 ? this.f7580c : this.f7581d;
    }

    @Override // com.anythink.core.common.i.a
    public final void a(b bVar, long j2) {
        a(bVar, j2, true);
    }

    @Override // com.anythink.core.common.i.a
    public final void a(b bVar, long j2, boolean z2) {
        StringBuilder sb = new StringBuilder("sendTimeOutMsg() >>> delayMillis=");
        sb.append(j2);
        sb.append(" isMainThread=");
        sb.append(z2);
        Handler handlerA = a(z2);
        if (handlerA == null) {
            return;
        }
        handlerA.postDelayed(bVar, j2);
    }

    @Override // com.anythink.core.common.i.a
    public final void a(b bVar) {
        Handler handler = this.f7580c;
        if (handler != null) {
            handler.removeCallbacks(bVar);
        }
        Handler handler2 = this.f7581d;
        if (handler2 != null) {
            handler2.removeCallbacks(bVar);
        }
    }
}
