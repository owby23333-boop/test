package com.kwad.sdk.api.kwai;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final ExecutorService aaJ = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    private static final Handler Ui = new Handler(Looper.getMainLooper());

    public static Future<?> submit(Runnable runnable) {
        return aaJ.submit(runnable);
    }
}
