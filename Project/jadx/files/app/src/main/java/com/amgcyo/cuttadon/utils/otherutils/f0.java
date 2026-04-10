package com.amgcyo.cuttadon.utils.otherutils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.fatcatfat.io.R;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.taobao.accs.common.Constants;

/* JADX INFO: compiled from: NotificationUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class f0 {
    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            String packageName = context.getPackageName();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            Intent intent = new Intent();
            if (Build.VERSION.SDK_INT >= 26) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
            } else if (Build.VERSION.SDK_INT >= 21) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("app_package", packageName);
                intent.putExtra("app_uid", applicationInfo.uid);
            } else {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts(Constants.KEY_PACKAGE, packageName, null));
            }
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            l.b.a.j.a((CharSequence) ("打开失败，请在应用管理中找到【" + com.amgcyo.cuttadon.f.o.d(R.string.app_name) + "】选择【通知管理】等类似字样进行设置！"));
        }
    }

    public static boolean b(Context context) {
        try {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
