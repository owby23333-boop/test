package com.bytedance.sdk.component.ga.e;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final TimeUnit e = TimeUnit.SECONDS;

    public static ExecutorService e() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 30L, e, new LinkedBlockingQueue(), new e("default"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
