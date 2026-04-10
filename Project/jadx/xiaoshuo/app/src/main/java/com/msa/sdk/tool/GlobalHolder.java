package com.msa.sdk.tool;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public final class GlobalHolder {
    private static Context sAppContext;
    private static Handler sBackgroundHandler;
    private static Handler sUIHandler = new Handler(Looper.getMainLooper());

    private GlobalHolder() {
    }

    private static void checkInit() {
        if (sAppContext == null) {
            throw new IllegalStateException("GlobalHolder should be init before using");
        }
    }

    public static Context getApplicationContext() {
        checkInit();
        return sAppContext;
    }

    public static Handler getBackgroundHandler() {
        checkInit();
        if (sBackgroundHandler == null) {
            synchronized (GlobalHolder.class) {
                if (sBackgroundHandler == null) {
                    HandlerThread handlerThread = new HandlerThread("zeus-bg-task-" + sAppContext.getPackageName());
                    if (!handlerThread.isAlive()) {
                        handlerThread.start();
                    }
                    sBackgroundHandler = new Handler(handlerThread.getLooper());
                }
            }
        }
        return sBackgroundHandler;
    }

    public static Handler getUIHandler() {
        return sUIHandler;
    }

    public static void init(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            sAppContext = context.getApplicationContext();
        }
        MLog.setDebugOn(true);
    }
}
