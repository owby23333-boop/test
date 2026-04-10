package com.bykv.vk.component.ttvideo.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class EngineThreadPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ThreadPoolExecutor f2060a;

    public static ExecutorService a() {
        if (f2060a == null) {
            synchronized (EngineThreadPool.class) {
                if (f2060a == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    f2060a = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f2060a;
    }

    public static void setExcutorInstance(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (EngineThreadPool.class) {
            f2060a = threadPoolExecutor;
        }
    }
}
