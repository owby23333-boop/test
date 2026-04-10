package com.msa.sdk.tool;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes3.dex */
public final class HandlerHolder {
    private static Handler sBackgroundHandler;
    private static HandlerThread sHandlerThread = new HandlerThread("background_task");

    public static synchronized Handler getBackgroundHandler() {
        if (sBackgroundHandler == null) {
            synchronized (HandlerHolder.class) {
                if (sBackgroundHandler == null) {
                    if (!sHandlerThread.isAlive()) {
                        sHandlerThread.start();
                    }
                    sBackgroundHandler = new Handler(sHandlerThread.getLooper());
                }
            }
        }
        return sBackgroundHandler;
    }
}
