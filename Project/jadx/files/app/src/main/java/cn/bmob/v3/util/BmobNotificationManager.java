package cn.bmob.v3.util;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.anythink.expressad.foundation.h.i;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.umeng.message.entity.UMessage;

/* JADX INFO: loaded from: classes.dex */
public class BmobNotificationManager extends ContextWrapper {
    private static volatile BmobNotificationManager INSTANCE;
    private static NotificationManager manager;

    public BmobNotificationManager(Context context) {
        super(context);
    }

    private Bitmap getAppIcon() {
        return ((BitmapDrawable) getApplicationInfo().loadIcon(getPackageManager())).getBitmap();
    }

    public static BmobNotificationManager getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (BmobNotificationManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BmobNotificationManager(context.getApplicationContext());
                }
            }
        }
        return INSTANCE;
    }

    private NotificationManager getManager() {
        if (manager == null) {
            manager = (NotificationManager) getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        }
        return manager;
    }

    private int getResourcesId(String str) {
        int identifier = getResources().getIdentifier(str, i.f10649g, getPackageName());
        if (identifier != 0) {
            return identifier;
        }
        throw new RuntimeException("Error getting resource. Make sure you have copied all resources (values/bmob_im_notification_strings.xml) from SDK to your project. ");
    }

    private String getTicker() {
        return getResources().getString(getResourcesId("bmob_im_notification_ticker"));
    }

    public void cancelNotification() {
        INSTANCE = null;
        ((NotificationManager) getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION)).cancel(0);
    }

    @TargetApi(26)
    public void createNotificationChannel(String str, String str2, int i2) {
        getManager().createNotificationChannel(new NotificationChannel(str, str2, i2));
    }

    public NotificationCompat.Builder getNotification_N(Bitmap bitmap, String str, String str2, String str3, PendingIntent pendingIntent, String str4, int i2) {
        return new NotificationCompat.Builder(getApplicationContext(), str4).setTicker(str3).setLargeIcon(bitmap).setSmallIcon(getApplicationInfo().icon).setContentTitle(str).setContentText(str2).setAutoCancel(true).setDefaults(i2).setContentIntent(pendingIntent);
    }

    @TargetApi(26)
    public Notification.Builder getNotification_O(Bitmap bitmap, String str, String str2, String str3, PendingIntent pendingIntent, String str4) {
        return new Notification.Builder(getApplicationContext(), str4).setTicker(str3).setLargeIcon(bitmap).setSmallIcon(getApplicationInfo().icon).setContentTitle(str).setContentText(str2).setAutoCancel(true).setContentIntent(pendingIntent);
    }

    public void showNotification(Bitmap bitmap, String str, String str2, String str3, Intent intent, int i2, int i3) {
        showNotification(bitmap, str, str2, str3, intent, "BMOBIM_ID", "BMOBIM_NAME", i2, i3);
    }

    public void showNotification(Bitmap bitmap, String str, String str2, String str3, PendingIntent pendingIntent, int i2, int i3) {
        showNotification(bitmap, str, str2, str3, pendingIntent, "BMOBIM_ID", "BMOBIM_NAME", i2, i3);
    }

    public void showNotification(Bitmap bitmap, String str, String str2, String str3, Intent intent, String str4, String str5, int i2, int i3) {
        Notification notificationBuild;
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, DownloadExpSwitchCode.BUGFIX_SIGBUS_24_25);
        if (Build.VERSION.SDK_INT >= 26) {
            createNotificationChannel(str4, str5, i2);
            notificationBuild = getNotification_O(bitmap, str, str2, str3, activity, str4).build();
        } else {
            notificationBuild = getNotification_N(bitmap, str, str2, str3, activity, str4, i3).build();
        }
        getManager().notify(0, notificationBuild);
    }

    public void showNotification(Bitmap bitmap, String str, String str2, String str3, PendingIntent pendingIntent, String str4, String str5, int i2, int i3) {
        Notification notificationBuild;
        if (Build.VERSION.SDK_INT >= 26) {
            createNotificationChannel(str4, str5, i2);
            notificationBuild = getNotification_O(bitmap, str, str2, str3, pendingIntent, str4).build();
        } else {
            notificationBuild = getNotification_N(bitmap, str, str2, str3, pendingIntent, str4, i3).build();
        }
        getManager().notify(0, notificationBuild);
    }

    public static void showNotification(Context context, int i2, String str, String str2, String str3, PendingIntent pendingIntent) {
        getInstance(context).showNotification(BitmapFactory.decodeResource(context.getResources(), i2), str, str2, str3, pendingIntent, 1, 8);
    }
}
