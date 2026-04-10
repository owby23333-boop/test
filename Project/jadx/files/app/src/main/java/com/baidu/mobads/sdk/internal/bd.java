package com.baidu.mobads.sdk.internal;

import java.lang.Thread;

/* JADX INFO: loaded from: classes2.dex */
class bd implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ bc a;

    bd(bc bcVar) {
        this.a = bcVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        av.h("ThreadPoolFactory").c("线程名字=" + thread.getName() + "线程crash信息", th);
    }
}
