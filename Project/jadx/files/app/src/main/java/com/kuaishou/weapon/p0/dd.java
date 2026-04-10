package com.kuaishou.weapon.p0;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes2.dex */
public class dd {
    public static void a(Context context, int i2, String str, String str2) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent(str);
            intent.setData(Uri.parse(str2));
            intent.setPackage(context.getPackageName());
            int i3 = DownloadExpSwitchCode.BUGFIX_SIGBUS_24_25;
            if (context.getApplicationInfo().targetSdkVersion >= 31) {
                i3 = 201326592;
            }
            alarmManager.cancel(PendingIntent.getBroadcast(context, i2, intent, i3));
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str, int i2, long j2, String str2) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent(str);
            intent.setData(Uri.parse(str2));
            intent.setPackage(context.getPackageName());
            int i3 = DownloadExpSwitchCode.BUGFIX_SIGBUS_24_25;
            if (context.getApplicationInfo().targetSdkVersion >= 31) {
                i3 = 201326592;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent, i3);
            try {
                alarmManager.cancel(broadcast);
            } catch (Throwable unused) {
            }
            alarmManager.set(1, System.currentTimeMillis() + j2, broadcast);
        } catch (Throwable unused2) {
        }
    }
}
