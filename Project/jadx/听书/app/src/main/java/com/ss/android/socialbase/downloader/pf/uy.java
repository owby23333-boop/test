package com.ss.android.socialbase.downloader.pf;

import android.content.Context;
import android.content.pm.ServiceInfo;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes4.dex */
public class uy {
    public static boolean z(Context context, String str, String str2) {
        try {
            for (ServiceInfo serviceInfo : context.getPackageManager().getPackageInfo(str, 4).services) {
                if (serviceInfo.exported && serviceInfo.enabled && serviceInfo.permission == null && serviceInfo.name.equals(str2)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        return false;
    }
}
