package com.dangdang.zframework.network;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes10.dex */
public class TaskDiscardPolicy extends BaseRejectedPolicy {
    @Override // com.dangdang.zframework.network.BaseRejectedPolicy
    public void rejectedExecutionImpl(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        printLog(" DiscardPolicy rejectedExp ");
    }
}
