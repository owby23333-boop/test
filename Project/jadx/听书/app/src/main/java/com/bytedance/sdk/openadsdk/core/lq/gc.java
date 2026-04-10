package com.bytedance.sdk.openadsdk.core.lq;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    public static byte[] z(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        if (context.getPackageName().equalsIgnoreCase(str)) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
                if (packageInfo.packageName.equals(str)) {
                    return packageInfo.signatures[0].toByteArray();
                }
            } catch (PackageManager.NameNotFoundException e) {
                wp.z(e);
            }
        }
        return null;
    }
}
