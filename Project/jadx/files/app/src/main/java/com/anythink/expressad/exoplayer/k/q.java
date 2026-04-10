package com.anythink.expressad.exoplayer.k;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.umeng.message.entity.UMessage;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"InlinedApi"})
public final class q {
    public static final int a = -1000;
    public static final int b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9899c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f9900d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f9901e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f9902f = 4;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    private q() {
    }

    private static void a(Context context, String str, @StringRes int i2, int i3) {
        if (af.a >= 26) {
            ((NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION)).createNotificationChannel(new NotificationChannel(str, context.getString(i2), i3));
        }
    }

    private static void a(Context context, int i2, @Nullable Notification notification) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        if (notification != null) {
            notificationManager.notify(i2, notification);
        } else {
            notificationManager.cancel(i2);
        }
    }
}
