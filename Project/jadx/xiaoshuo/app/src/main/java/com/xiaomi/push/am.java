package com.xiaomi.push;

import android.os.Looper;

/* JADX INFO: loaded from: classes8.dex */
public class am {
    public static void a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new RuntimeException("can't do this on ui thread");
        }
    }
}
