package com.dangdang.zframework.network;

import com.dangdang.zframework.log.LogM;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes10.dex */
public abstract class BaseRejectedPolicy implements RejectedExecutionHandler {
    public void printLog(String str) {
        LogM.i("RejectedPolicy", str);
    }

    public void printLogE(String str) {
        LogM.e("RejectedPolicy", str);
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        rejectedExecutionImpl(runnable, threadPoolExecutor);
    }

    public abstract void rejectedExecutionImpl(Runnable runnable, ThreadPoolExecutor threadPoolExecutor);
}
