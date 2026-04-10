package com.bykv.vk.component.ttvideo.utils;

import com.bytedance.sdk.component.uy.uy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class EngineThreadPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ThreadPoolExecutor f91a;

    public static ExecutorService a() {
        if (f91a == null) {
            synchronized (EngineThreadPool.class) {
                if (f91a == null) {
                    com.bytedance.sdk.component.uy.a.a aVar = new com.bytedance.sdk.component.uy.a.a(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new uy("EngineThreadPool"));
                    f91a = aVar;
                    aVar.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f91a;
    }

    public static void setExcutorInstance(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (EngineThreadPool.class) {
            f91a = threadPoolExecutor;
        }
    }
}
