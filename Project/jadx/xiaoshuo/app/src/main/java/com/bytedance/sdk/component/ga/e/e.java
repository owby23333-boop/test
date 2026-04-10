package com.bytedance.sdk.component.ga.e;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class e implements ThreadFactory {
    private final AtomicInteger bf = new AtomicInteger(1);
    private final ThreadGroup e;

    public e(String str) {
        this.e = new ThreadGroup("tt_img_" + str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.e, runnable, "tt_img_" + this.bf.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        return thread;
    }
}
