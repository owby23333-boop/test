package com.bytedance.pangle.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static String z;

    public static String z(Context context) {
        if (z == null) {
            String[] strArrZ = dl.z(new File(context.getApplicationInfo().sourceDir));
            String str = strArrZ[0];
            z = str;
            if (TextUtils.isEmpty(str)) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, "getHostIdentity failed. Reason: " + strArrZ[2]);
            }
        }
        return z;
    }

    public static boolean z() {
        try {
            return (Zeus.getAppApplication().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
