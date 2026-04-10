package com.bytedance.sdk.component.panglarmor;

import android.content.Context;
import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public class ga {
    public static int e(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return -1;
        }
    }
}
