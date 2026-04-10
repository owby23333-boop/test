package com.jeremyliao.liveeventbus.utils;

import android.os.Looper;

/* JADX INFO: loaded from: classes7.dex */
public final class ThreadUtils {
    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
