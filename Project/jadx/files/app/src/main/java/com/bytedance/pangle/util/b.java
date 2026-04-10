package com.bytedance.pangle.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String b;

    public static boolean a(@NonNull Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        String packageName = context.getPackageName();
        return (TextUtils.isEmpty(packageName) || (runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1)) == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !packageName.equals(componentName.getPackageName())) ? false : true;
    }

    public static String b(Context context) {
        if (b == null) {
            String[] strArrA = c.a(new File(context.getApplicationInfo().sourceDir));
            String str = strArrA[0];
            b = str;
            if (TextUtils.isEmpty(str)) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, "getHostIdentity failed. Reason: " + strArrA[2]);
            }
        }
        return b;
    }

    public static boolean a() {
        try {
            return (Zeus.getAppApplication().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
