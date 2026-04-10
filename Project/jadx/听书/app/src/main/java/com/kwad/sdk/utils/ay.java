package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ay {
    private static String bah = "";
    private static volatile Boolean bai;

    public static String getProcessName(Context context) {
        if (!TextUtils.isEmpty(bah)) {
            return bah;
        }
        String strRi = Ri();
        bah = strRi;
        if (!TextUtils.isEmpty(strRi)) {
            return bah;
        }
        String strRj = Rj();
        bah = strRj;
        if (!TextUtils.isEmpty(strRj)) {
            return bah;
        }
        String strDm = dm(context);
        bah = strDm;
        return strDm;
    }

    private static String Ri() {
        return Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
    }

    private static String Rj() {
        try {
            Object objCallStaticMethod = z.callStaticMethod(Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()), "currentProcessName", new Object[0]);
            return objCallStaticMethod instanceof String ? (String) objCallStaticMethod : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String dm(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return "";
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
        return "";
    }

    public static boolean isInMainProcess(Context context) {
        if (bai == null) {
            String processName = getProcessName(context);
            bai = Boolean.valueOf(!TextUtils.isEmpty(processName) && processName.equals(context.getPackageName()));
        }
        return bai.booleanValue();
    }
}
