package com.bytedance.sdk.component.zk;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class v implements ThreadFactory {
    private final String bf;
    private int d;
    private final ThreadGroup e;

    public v(int i, String str) {
        this.d = i;
        this.e = new ThreadGroup("csj_g_" + str);
        this.bf = "csj_" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.e, runnable, this.bf);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int i = this.d;
        if (i > 10 || i < 1) {
            this.d = 5;
        }
        thread.setPriority(this.d);
        return thread;
    }
}
