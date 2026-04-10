package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c0 {
    private static String a;

    private static String a() {
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

    public static String a(Context context) {
        if (TextUtils.isEmpty(a)) {
            a = b();
            if (TextUtils.isEmpty(a)) {
                a = a();
                if (TextUtils.isEmpty(a)) {
                    a = b(context);
                }
            }
        }
        return a;
    }

    private static String b() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return Application.getProcessName();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private static String b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static boolean c(Context context) {
        try {
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                if (packageName.equalsIgnoreCase(a(context))) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
