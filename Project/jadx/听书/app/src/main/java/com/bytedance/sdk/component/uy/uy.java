package com.bytedance.sdk.component.uy;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class uy implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f807a;
    private int dl;
    private final ThreadGroup g;
    public final String z;

    public uy(String str) {
        this(5, str);
    }

    public uy(int i, String str) {
        this.f807a = new AtomicInteger(1);
        this.dl = i;
        this.g = new ThreadGroup("csj_g_" + str);
        this.z = "csj_" + (kb.g.m() ? "p" : "") + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadZ = z(this.g, runnable, this.z + "_" + this.f807a.getAndIncrement());
        if (threadZ.isDaemon()) {
            threadZ.setDaemon(false);
        }
        int i = this.dl;
        if (i > 10) {
            this.dl = 10;
        } else if (i <= 0) {
            this.dl = 1;
        }
        threadZ.setPriority(this.dl);
        return threadZ;
    }

    protected Thread z(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new com.bytedance.sdk.component.uy.a.dl(threadGroup, runnable, str);
    }
}
