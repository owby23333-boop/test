package com.bytedance.msdk.core.wp;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        activity.requestPermissions(strArr, i);
    }

    public static int z(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable th) {
            wp.z(th);
            return -1;
        }
    }
}
