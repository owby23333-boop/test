package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public final class bh {
    private static final Handler aAp = new Handler(Looper.getMainLooper());
    private static long jY = 400;

    @SuppressLint({"MissingPermission"})
    public static void a(Context context, Vibrator vibrator) {
        vibrate(context, vibrator, jY);
    }

    public static void a(Runnable runnable, Object obj, long j2) {
        Message messageObtain = Message.obtain(aAp, runnable);
        messageObtain.obj = null;
        aAp.sendMessageDelayed(messageObtain, j2);
    }

    @SuppressLint({"MissingPermission"})
    public static void b(Context context, Vibrator vibrator) {
        if (vibrator == null || ak.al(context, "android.permission.VIBRATE") != 0) {
            return;
        }
        vibrator.cancel();
    }

    public static void b(Runnable runnable) {
        aAp.removeCallbacks(runnable);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void postOnUiThread(Runnable runnable) {
        aAp.post(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            aAp.post(runnable);
        }
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j2) {
        aAp.postDelayed(runnable, j2);
    }

    @SuppressLint({"MissingPermission"})
    public static void vibrate(Context context, Vibrator vibrator, long j2) {
        if (vibrator != null) {
            try {
                if (ak.al(context, "android.permission.VIBRATE") == 0) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        vibrator.vibrate(VibrationEffect.createOneShot(j2, -1));
                    } else {
                        vibrator.vibrate(j2);
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
        }
    }
}
