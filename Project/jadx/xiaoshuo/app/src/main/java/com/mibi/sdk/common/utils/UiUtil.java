package com.mibi.sdk.common.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.mibi.sdk.common.PermissionUtils;

/* JADX INFO: loaded from: classes13.dex */
public class UiUtil {
    private static final String TAG = "UiUtil";
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static int sTaskId = -1;

    private UiUtil() {
    }

    public static int getTaskId() {
        return sTaskId;
    }

    public static void moveToFront(Activity activity) {
        if (activity == null) {
            MibiLog.d(TAG, "move to front activity is null");
        } else {
            moveToFront(activity, activity.getTaskId());
        }
    }

    public static void removeCallbacks(Runnable runnable) {
        removeCallbacks(runnable, null);
    }

    public static void removeCallbacksAndMessages(Object obj) {
        sHandler.removeCallbacksAndMessages(obj);
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0L);
    }

    public static void setTaskId(int i) {
        sTaskId = i;
    }

    public static void removeCallbacks(Runnable runnable, Object obj) {
        if (runnable != null) {
            sHandler.removeCallbacks(runnable, obj);
        }
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        if (runnable != null) {
            sHandler.postDelayed(runnable, j);
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void moveToFront(Activity activity, int i) {
        String str = TAG;
        MibiLog.d(str, "move to front called, taskId : " + i);
        if (activity == null || i <= 0 || !PermissionUtils.isPermissionGranted(activity, "android.permission.REORDER_TASKS")) {
            return;
        }
        ((ActivityManager) activity.getSystemService(TTDownloadField.TT_ACTIVITY)).moveTaskToFront(i, 1);
        MibiLog.d(str, "move to front success");
    }
}
