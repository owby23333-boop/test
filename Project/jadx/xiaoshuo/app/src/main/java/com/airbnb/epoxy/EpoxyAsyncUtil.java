package com.airbnb.epoxy;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.MainThread;

/* JADX INFO: loaded from: classes.dex */
public final class EpoxyAsyncUtil {
    private static Handler asyncBackgroundHandler;
    public static final Handler MAIN_THREAD_HANDLER = createHandler(Looper.getMainLooper(), false);
    public static final Handler AYSNC_MAIN_THREAD_HANDLER = createHandler(Looper.getMainLooper(), true);

    private EpoxyAsyncUtil() {
    }

    public static Looper buildBackgroundLooper(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return handlerThread.getLooper();
    }

    public static Handler createHandler(Looper looper, boolean z) {
        return !z ? new Handler(looper) : Handler.createAsync(looper);
    }

    @MainThread
    public static Handler getAsyncBackgroundHandler() {
        if (asyncBackgroundHandler == null) {
            asyncBackgroundHandler = createHandler(buildBackgroundLooper("epoxy"), true);
        }
        return asyncBackgroundHandler;
    }
}
