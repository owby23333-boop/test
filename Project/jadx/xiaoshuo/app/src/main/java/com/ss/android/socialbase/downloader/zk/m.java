package com.ss.android.socialbase.downloader.zk;

import android.content.Context;
import android.content.pm.ServiceInfo;

/* JADX INFO: loaded from: classes4.dex */
public class m {
    public static boolean e(Context context, String str, String str2) {
        try {
            for (ServiceInfo serviceInfo : context.getPackageManager().getPackageInfo(str, 4).services) {
                if (serviceInfo.exported && serviceInfo.enabled && serviceInfo.permission == null && serviceInfo.name.equals(str2)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
