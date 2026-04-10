package com.anythink.china.common.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static String a(Context context, File file) {
        if (context != null && file != null) {
            try {
                return context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1).packageName;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    private static boolean b(Context context, File file) {
        if (context != null && file != null) {
            String strA = a(context, file);
            if (!TextUtils.isEmpty(strA)) {
                return a(context, strA);
            }
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    private static void b(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                context.startActivity(launchIntentForPackage);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
