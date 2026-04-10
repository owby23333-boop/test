package com.xiaomi.httpdns.thread;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes8.dex */
public class AsyncHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HandlerThread f7380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Handler f7381b;

    public static final class SingleHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AsyncHandler f7382a = new AsyncHandler();
    }

    public synchronized void a() {
        if (f7380a == null) {
            HandlerThread handlerThread = new HandlerThread("Async_Handler_Thread");
            f7380a = handlerThread;
            handlerThread.start();
            f7381b = new Handler(f7380a.getLooper());
        }
    }
}
