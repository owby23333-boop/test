package com.bytedance.z.dl.z.g;

import android.text.TextUtils;
import com.bytedance.z.dl.z.g.g;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ThreadFactory {
    private static final AtomicInteger z = new AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1502a;
    private final AtomicInteger dl = new AtomicInteger(1);
    private final ThreadGroup g;
    private final g.z gc;

    a(g.z zVar, String str) {
        ThreadGroup threadGroup;
        this.gc = zVar;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.g = threadGroup;
        if (TextUtils.isEmpty(str)) {
            this.f1502a = "ttdefault-" + z.getAndIncrement() + "-thread-";
        } else {
            this.f1502a = str + z.getAndIncrement() + "-thread-";
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.bytedance.sdk.component.uy.a.dl dlVar = new com.bytedance.sdk.component.uy.a.dl(this.g, runnable, this.f1502a + this.dl.getAndIncrement(), 0L);
        if (dlVar.isDaemon()) {
            dlVar.setDaemon(false);
        }
        g.z zVar = this.gc;
        if (zVar != null && zVar.z() == g.z.LOW.z()) {
            dlVar.setPriority(1);
        } else if (dlVar.getPriority() != 5) {
            dlVar.setPriority(3);
        } else {
            dlVar.setPriority(5);
        }
        return dlVar;
    }
}
