package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f1958a;

    public static synchronized String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = f1958a;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + (str2.endsWith("_") ? "" : "_") + d.a(str2);
    }

    public static synchronized String a(Context context) {
        if (!TextUtils.isEmpty(f1958a)) {
            return f1958a;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            f1958a = Application.getProcessName();
            return f1958a;
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                try {
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == iMyPid) {
                        f1958a = next.processName;
                        return f1958a;
                    }
                    continue;
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }
}
