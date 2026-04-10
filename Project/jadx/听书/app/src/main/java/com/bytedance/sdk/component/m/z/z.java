package com.bytedance.sdk.component.m.z;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class z implements ThreadFactory {
    private final AtomicInteger g = new AtomicInteger(1);
    private final ThreadGroup z;

    public z(String str) {
        this.z = new ThreadGroup("tt_img_".concat(String.valueOf(str)));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.bytedance.sdk.component.uy.a.dl dlVar = new com.bytedance.sdk.component.uy.a.dl(this.z, runnable, "tt_img_" + this.g.getAndIncrement());
        if (dlVar.isDaemon()) {
            dlVar.setDaemon(false);
        }
        return dlVar;
    }
}
