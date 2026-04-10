package com.bytedance.sdk.component.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l {
    private static String e;

    public static String bf(Context context) {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        String strE = e();
        e = strE;
        if (!TextUtils.isEmpty(strE)) {
            return e;
        }
        String strBf = bf();
        e = strBf;
        if (!TextUtils.isEmpty(strBf)) {
            return e;
        }
        String strD = d(context);
        e = strD;
        return strD;
    }

    private static String d(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    public static boolean e(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return false;
        }
        return TextUtils.equals(context.getApplicationContext().getPackageName(), bf(context));
    }

    private static String e() {
        try {
            return Application.getProcessName();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String bf() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
