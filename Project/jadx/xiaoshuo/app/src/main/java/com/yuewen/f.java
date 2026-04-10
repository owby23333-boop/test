package com.yuewen;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes8.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile f f11006b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f11007a;

    public f() {
        HandlerThread handlerThread = new HandlerThread("TaskHandlerThread", 1);
        handlerThread.start();
        this.f11007a = new Handler(handlerThread.getLooper());
    }

    public static f a() {
        if (f11006b == null) {
            synchronized (f.class) {
                if (f11006b == null) {
                    f11006b = new f();
                }
            }
        }
        return f11006b;
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f11007a.post(runnable);
    }
}
