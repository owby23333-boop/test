package com.anythink.china.common.b;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.anythink.china.common.NotificationBroadcaseReceiver;
import com.anythink.china.common.a.e;
import com.anythink.core.common.k.h;
import com.anythink.expressad.foundation.h.i;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.umeng.message.entity.UMessage;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b {
    public static final String a = "a";
    public static final String b = "anythink_action_notification_click";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6444c = "anythink_action_notification_cannel";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6445d = "anythink_broadcast_receiver_extra_url";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f6446e = "anythink_broadcast_receiver_extra_unique_id";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f6447f = "anythink_broadcast_receiver_extra_request_status";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f6448g = "anythink_broadcast_receiver_extra_notification_id";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile a f6449j;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Map<String, c> f6450h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private NotificationManager f6451i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f6452k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f6453l;

    private a(Context context) {
        this.f6452k = context;
        this.f6451i = b(context);
    }

    private static int a(long j2, long j3) {
        return (int) (((j2 * 1.0f) / j3) * 100.0f);
    }

    public static a a(Context context) {
        if (f6449j == null) {
            synchronized (a.class) {
                if (f6449j == null) {
                    f6449j = new a(context);
                }
            }
        }
        return f6449j;
    }

    private void d(e eVar) {
        a(eVar, 0L, 100L, true);
    }

    private void e(e eVar) {
        a(eVar, 0L, 100L, true);
    }

    private c f(e eVar) {
        String str = eVar.f6433n;
        c cVar = this.f6450h.get(str);
        if (cVar != null) {
            return cVar;
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.f6452k, str);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24 && i2 >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(str, str, 3);
            notificationChannel.setSound(null, null);
            this.f6451i.createNotificationChannel(notificationChannel);
        }
        this.f6453l++;
        builder.setOngoing(true).setSound(null).setPriority(0).setOnlyAlertOnce(true).setAutoCancel(false);
        try {
            builder.setSmallIcon(this.f6452k.getPackageManager().getApplicationInfo(this.f6452k.getPackageName(), 128).icon);
        } catch (Throwable th) {
            th.printStackTrace();
            builder.setSmallIcon(h.a(this.f6452k, "core_icon_close", i.f10645c));
        }
        builder.setContentTitle(eVar.f6422c).setLargeIcon(eVar.f6423d);
        c cVar2 = new c();
        cVar2.a = this.f6453l;
        cVar2.b = builder;
        cVar2.f6454c = -1;
        this.f6450h.put(str, cVar2);
        return cVar2;
    }

    @Override // com.anythink.china.common.b.b
    public final NotificationManager b(Context context) {
        if (context == null) {
            return null;
        }
        return (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
    }

    public final void c(e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.b) || this.f6451i == null) {
            return;
        }
        this.f6451i.cancel(f(eVar).a);
        this.f6450h.remove(eVar.f6433n);
    }

    @Override // com.anythink.china.common.b.b
    public final String b(e eVar) {
        return eVar.f6433n;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0147 A[Catch: all -> 0x0179, TryCatch #0 {all -> 0x0179, blocks: (B:8:0x000f, B:10:0x0013, B:11:0x001b, B:13:0x0025, B:16:0x00ac, B:20:0x00b8, B:52:0x0141, B:54:0x0147, B:55:0x014b, B:57:0x015d, B:59:0x016c, B:58:0x0165, B:24:0x00c8, B:27:0x00d4, B:36:0x00f3, B:38:0x00fb, B:43:0x0106, B:46:0x010f, B:48:0x0115, B:50:0x0119, B:51:0x012d, B:15:0x002d), top: B:71:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x015d A[Catch: all -> 0x0179, TryCatch #0 {all -> 0x0179, blocks: (B:8:0x000f, B:10:0x0013, B:11:0x001b, B:13:0x0025, B:16:0x00ac, B:20:0x00b8, B:52:0x0141, B:54:0x0147, B:55:0x014b, B:57:0x015d, B:59:0x016c, B:58:0x0165, B:24:0x00c8, B:27:0x00d4, B:36:0x00f3, B:38:0x00fb, B:43:0x0106, B:46:0x010f, B:48:0x0115, B:50:0x0119, B:51:0x012d, B:15:0x002d), top: B:71:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0165 A[Catch: all -> 0x0179, TryCatch #0 {all -> 0x0179, blocks: (B:8:0x000f, B:10:0x0013, B:11:0x001b, B:13:0x0025, B:16:0x00ac, B:20:0x00b8, B:52:0x0141, B:54:0x0147, B:55:0x014b, B:57:0x015d, B:59:0x016c, B:58:0x0165, B:24:0x00c8, B:27:0x00d4, B:36:0x00f3, B:38:0x00fb, B:43:0x0106, B:46:0x010f, B:48:0x0115, B:50:0x0119, B:51:0x012d, B:15:0x002d), top: B:71:0x000f, outer: #1 }] */
    @Override // com.anythink.china.common.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a(com.anythink.china.common.a.e r15, long r16, long r18, boolean r20) {
        /*
            Method dump skipped, instruction units count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.china.common.b.a.a(com.anythink.china.common.a.e, long, long, boolean):void");
    }

    public final void a(e eVar, long j2, long j3) {
        a(eVar, j2, j3, false);
    }

    public final void a(e eVar) {
        a(eVar, 100L, 100L, true);
    }

    private void a(e eVar, NotificationCompat.Builder builder, c cVar) {
        e.a aVar = cVar.f6455d;
        if (aVar == null || aVar != eVar.a()) {
            cVar.f6455d = eVar.a();
            Intent intent = new Intent(b);
            intent.putExtra(f6446e, eVar.f6433n);
            intent.putExtra(f6445d, eVar.b);
            intent.putExtra(f6447f, eVar.a().toString());
            intent.putExtra(f6448g, cVar.a);
            intent.setClass(this.f6452k, NotificationBroadcaseReceiver.class);
            PendingIntent broadcast = PendingIntent.getBroadcast(this.f6452k, cVar.a, intent, DownloadExpSwitchCode.BUGFIX_SIGBUS_24_25);
            Intent intent2 = new Intent(f6444c);
            intent2.putExtra(f6446e, eVar.f6433n);
            intent2.putExtra(f6445d, eVar.b);
            intent2.putExtra(f6447f, eVar.a().toString());
            intent2.putExtra(f6448g, cVar.a);
            intent2.setClass(this.f6452k, NotificationBroadcaseReceiver.class);
            builder.setContentIntent(broadcast).setDeleteIntent(PendingIntent.getBroadcast(this.f6452k, cVar.a, intent2, DownloadExpSwitchCode.BUGFIX_SIGBUS_24_25));
        }
    }

    public final void a(int i2) {
        if (i2 < 0) {
            return;
        }
        try {
            this.f6451i.cancel(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a() {
        NotificationManager notificationManager = this.f6451i;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
    }
}
