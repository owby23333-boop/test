package cn.bmob.v3.datatype.up;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class AsyncRun {
    public static void run(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
