package com.ss.android.socialbase.downloader.v;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class z implements ThreadFactory {
    private final boolean dl;
    private final AtomicInteger g;
    private final String z;

    public z(String str) {
        this(str, false);
    }

    public z(String str, boolean z) {
        this.g = new AtomicInteger();
        this.z = str;
        this.dl = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.bytedance.sdk.component.uy.a.dl dlVar = new com.bytedance.sdk.component.uy.a.dl(runnable, this.z + "-" + this.g.incrementAndGet());
        if (!this.dl) {
            if (dlVar.isDaemon()) {
                dlVar.setDaemon(false);
            }
            if (dlVar.getPriority() != 5) {
                dlVar.setPriority(5);
            }
        }
        return dlVar;
    }
}
