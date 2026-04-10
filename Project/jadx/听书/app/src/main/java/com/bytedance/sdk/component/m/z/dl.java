package com.bytedance.sdk.component.m.z;

import com.bytedance.sdk.component.uy.a.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static final TimeUnit z = TimeUnit.SECONDS;

    public static ExecutorService z() {
        a aVar = new a(1, 2, 30L, z, new LinkedBlockingQueue(), new z("default"));
        aVar.allowCoreThreadTimeOut(true);
        return aVar;
    }
}
