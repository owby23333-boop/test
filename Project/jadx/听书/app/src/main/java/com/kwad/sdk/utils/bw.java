package com.kwad.sdk.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import java.io.Closeable;

/* JADX INFO: loaded from: classes4.dex */
public final class bw {
    private static final Handler bbE = new Handler(Looper.getMainLooper());
    private static long nA = 400;

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            bbE.post(runnable);
        }
    }

    public static void postOnUiThread(Runnable runnable) {
        bbE.post(runnable);
    }

    public static void b(Runnable runnable) {
        bbE.postAtFrontOfQueue(runnable);
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j) {
        bbE.postDelayed(runnable, j);
    }

    public static void c(Runnable runnable) {
        bbE.removeCallbacks(runnable);
    }

    public static void a(Runnable runnable, Object obj, long j) {
        Handler handler = bbE;
        Message messageObtain = Message.obtain(handler, runnable);
        messageObtain.obj = null;
        handler.sendMessageDelayed(messageObtain, j);
    }

    public static void a(Context context, Vibrator vibrator) {
        vibrate(context, vibrator, nA);
    }

    public static void vibrate(Context context, Vibrator vibrator, long j) {
        if (vibrator != null) {
            try {
                if (au.at(context, "android.permission.VIBRATE") == 0) {
                    vibrator.vibrate(VibrationEffect.createOneShot(j, -1));
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
    }

    public static void b(Context context, Vibrator vibrator) {
        if (vibrator == null || au.at(context, "android.permission.VIBRATE") != 0) {
            return;
        }
        vibrator.cancel();
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean hA(String str) {
        return TextUtils.isEmpty(str) || str.contains(" ") || !URLUtil.isNetworkUrl(str);
    }

    public static String s(Throwable th) {
        try {
            String stackTraceString = Log.getStackTraceString(th);
            return TextUtils.isEmpty(stackTraceString) ? th.toString() : stackTraceString;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void e(DialogInterface dialogInterface) {
        try {
            dialogInterface.dismiss();
        } catch (Exception unused) {
        }
    }
}
