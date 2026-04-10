package com.baidu.mobads.sdk.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class bc implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    bc() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "TaskScheduler #" + this.a.getAndIncrement());
        thread.setUncaughtExceptionHandler(new bd(this));
        return thread;
    }
}
