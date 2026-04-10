package com.kwad.components.core.r;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.kwad.sdk.utils.InstalledAppInfoManager;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        if (!TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
            if (!TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction()) || intent.getData() == null) {
                return;
            }
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            InstalledAppInfoManager.AppPackageInfo appPackageInfo = new InstalledAppInfoManager.AppPackageInfo();
            appPackageInfo.packageName = schemeSpecificPart;
            com.kwad.components.core.m.a.pr().e(InstalledAppInfoManager.a(appPackageInfo), 2);
            com.kwad.sdk.core.d.b.d("APPInstalledChangerReceiver", "uninstalled packageName :" + schemeSpecificPart);
            return;
        }
        if (intent.getData() != null) {
            String schemeSpecificPart2 = intent.getData().getSchemeSpecificPart();
            if (TextUtils.isEmpty(schemeSpecificPart2)) {
                return;
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(schemeSpecificPart2, 0);
                if (packageInfo == null) {
                    return;
                }
                com.kwad.components.core.m.a.pr().e(InstalledAppInfoManager.a(InstalledAppInfoManager.a(packageInfo, packageManager)), 1);
                com.kwad.sdk.core.d.b.d("APPInstalledChangerReceiver", "installed packageName :" + schemeSpecificPart2);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
    }
}
