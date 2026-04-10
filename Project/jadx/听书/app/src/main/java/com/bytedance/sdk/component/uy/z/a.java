package com.bytedance.sdk.component.uy.z;

import com.bytedance.sdk.component.uy.kb;
import com.bytedance.sdk.component.uy.uy;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ThreadFactory {
    private final int g;
    private final ThreadFactory z;

    public a(ThreadFactory threadFactory, int i) {
        if (threadFactory == null) {
            this.z = new uy("default");
        } else {
            this.z = threadFactory;
        }
        this.g = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.z.newThread(runnable);
        return g() ? new e(threadNewThread) : threadNewThread;
    }

    public final String z() {
        return this.z.getClass().getName();
    }

    protected boolean g() {
        return kb.g.g(this.g);
    }
}
