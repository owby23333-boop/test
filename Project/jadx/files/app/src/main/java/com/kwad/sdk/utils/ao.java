package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ao {
    private static String azc = "";
    private static volatile Boolean azd;

    private static String DK() {
        return Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
    }

    private static String DL() {
        try {
            Object objB = r.b(Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()), "currentProcessName", new Object[0]);
            return objB instanceof String ? (String) objB : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String cz(@NonNull Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return "";
        }
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "";
    }

    public static String getProcessName(@NonNull Context context) {
        if (!TextUtils.isEmpty(azc)) {
            return azc;
        }
        String strDK = DK();
        azc = strDK;
        if (!TextUtils.isEmpty(strDK)) {
            return azc;
        }
        String strDL = DL();
        azc = strDL;
        if (!TextUtils.isEmpty(strDL)) {
            return azc;
        }
        String strCz = cz(context);
        azc = strCz;
        return strCz;
    }

    public static boolean isInMainProcess(Context context) {
        if (azd == null) {
            String processName = getProcessName(context);
            azd = Boolean.valueOf(!TextUtils.isEmpty(processName) && processName.equals(context.getPackageName()));
        }
        return azd.booleanValue();
    }
}
