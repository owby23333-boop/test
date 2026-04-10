package com.xiaomi.ad.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.ad.c;
import com.xiaomi.ad.mediation.DspNameConstant;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"MissingPermission, HardwareIds"})
public final class AndroidUtils {
    public static final int PACKAGE_DISABLE = -2;
    public static final int PACKAGE_NOT_INSTALL = -1;
    public static final String TAG = "AndroidUtils";
    public static final Handler sMainHandler = new Handler(Looper.getMainLooper());
    public static volatile int sStatusBarHeight;

    public static int dpToPx(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Drawable getAppIconDrawable(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationIcon(str);
        } catch (PackageManager.NameNotFoundException e) {
            MLog.e(TAG, "getAppIconDrawable exception", e);
            return null;
        }
    }

    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (Exception unused) {
            return "";
        }
    }

    public static Context getApplicationContext(Context context) {
        return (context == null || context.getApplicationContext() == null) ? context : context.getApplicationContext();
    }

    public static String getApplicationName(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0));
        } catch (Exception e) {
            MLog.e(TAG, "getApplicationName exception", e);
            return null;
        }
    }

    public static String getDevice() {
        return Build.DEVICE;
    }

    public static PackageInfo getPackageInfo(Context context, String str, int i) {
        try {
            return context.getPackageManager().getPackageInfo(str, i);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getPackageName(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getPlatformName() {
        return c.a() ? DspNameConstant.DSP_XIAOMI : "android";
    }

    public static String getRomVersion(Context context) {
        return Build.VERSION.RELEASE;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static Signature[] getSignature(Context context, String str) {
        PackageInfo packageInfo = getPackageInfo(context, str, 64);
        if (packageInfo != null) {
            return packageInfo.signatures;
        }
        return null;
    }

    public static String getStackTrace(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static int getStatusBarHeight(Context context) {
        int identifier;
        if (sStatusBarHeight > 0) {
            return sStatusBarHeight;
        }
        synchronized (AndroidUtils.class) {
            if (sStatusBarHeight == 0 && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                sStatusBarHeight = context.getResources().getDimensionPixelSize(identifier);
            }
        }
        return sStatusBarHeight;
    }

    public static int getVersionCode(Context context) {
        return getVersionCode(context, context.getPackageName());
    }

    public static String getVersionName(Context context) {
        return getVersionName(context, context.getPackageName());
    }

    public static boolean isMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static int px2dp(Context context, int i) {
        return (int) ((i / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void runOnMainThread(Handler handler, Runnable runnable) {
        if (handler == null || runnable == null) {
            return;
        }
        if (isMainThread()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public static int getVersionCode(Context context, String str) {
        PackageInfo packageInfo = getPackageInfo(context, str, 0);
        if (packageInfo == null) {
            return -1;
        }
        if (packageInfo.applicationInfo.enabled) {
            return packageInfo.versionCode;
        }
        return -2;
    }

    public static String getVersionName(Context context, String str) {
        PackageInfo packageInfo = getPackageInfo(context, str, 0);
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    public static void runOnMainThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (isMainThread()) {
            runnable.run();
        } else {
            sMainHandler.post(runnable);
        }
    }
}
