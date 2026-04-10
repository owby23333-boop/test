package com.bytedance.sdk.component.panglearmor;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;

/* JADX INFO: loaded from: classes2.dex */
public class uy {
    public static int z(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static boolean z(Context context) {
        ApplicationInfo applicationInfo;
        return (context == null || (applicationInfo = context.getApplicationInfo()) == null || (applicationInfo.flags & 1) <= 0) ? false : true;
    }
}
