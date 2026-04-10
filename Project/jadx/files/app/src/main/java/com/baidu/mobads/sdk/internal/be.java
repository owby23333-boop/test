package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
final class be implements RejectedExecutionHandler {
    be() {
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        av.h("ThreadPoolFactory").e("Exceeded ThreadPoolExecutor pool size");
        synchronized (this) {
            if (bb.f12886d == null) {
                LinkedBlockingQueue unused = bb.f12887e = new LinkedBlockingQueue();
                ThreadPoolExecutor unused2 = bb.f12886d = new ThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS, bb.f12887e, bb.f12888f);
            }
        }
        bb.f12886d.execute(runnable);
    }
}
