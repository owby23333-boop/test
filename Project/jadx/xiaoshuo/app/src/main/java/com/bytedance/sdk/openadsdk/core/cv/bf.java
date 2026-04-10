package com.bytedance.sdk.openadsdk.core.cv;

import android.app.Activity;
import android.content.Context;
import android.os.Process;

/* JADX INFO: loaded from: classes10.dex */
public class bf {
    public static int e(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        activity.requestPermissions(strArr, i);
    }
}
