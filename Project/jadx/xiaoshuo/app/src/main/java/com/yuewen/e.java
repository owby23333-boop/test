package com.yuewen;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f10432b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f10433a;

    public e() {
        HandlerThread handlerThread = new HandlerThread("ReportDBHandlerThread", 1);
        handlerThread.start();
        this.f10433a = new Handler(handlerThread.getLooper());
    }

    public static e a() {
        if (f10432b == null) {
            synchronized (f.class) {
                if (f10432b == null) {
                    f10432b = new e();
                }
            }
        }
        return f10432b;
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f10433a.post(runnable);
    }
}
