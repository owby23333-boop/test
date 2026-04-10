package com.baidu.tts.tools.cuid.util_GP;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class Util {
    public static final boolean DEBUG = false;
    public static final int SDK_ANDROID_M = 23;
    public static final String TAG = "DeviceId";

    private Util() {
    }

    public static boolean hasOtherServiceRuninMyPid(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningServices(100)) {
            if (runningServiceInfo.pid == Process.myPid() && !TextUtils.equals(runningServiceInfo.service.getClassName(), str)) {
                return true;
            }
        }
        return false;
    }

    public static String toHexString(byte[] bArr, String str, boolean z2) {
        return MD5Util.toHexString(bArr, str, z2);
    }

    public static String toMd5(byte[] bArr, boolean z2) {
        return MD5Util.toMd5(bArr, z2);
    }
}
