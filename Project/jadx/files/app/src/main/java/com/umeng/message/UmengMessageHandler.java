package com.umeng.message;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.UPushNotificationChannel;
import com.umeng.message.entity.UMessage;
import com.umeng.message.entity.UNotificationItem;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.o;
import com.umeng.message.proguard.s;
import com.umeng.message.service.UMJobIntentService;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes3.dex */
public class UmengMessageHandler implements UPushMessageHandler {
    private static final String a = "UmengMessageHandler";
    private static Date b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f20270c = "9999999999999";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f20271e = "umeng_push_notification_default_large_icon";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f20272f = "umeng_push_notification_default_small_icon";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f20273g = "umeng_push_notification_default_sound";
    public static boolean isChannelSet = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f20274d;

    private void a(Context context, Notification notification, boolean z2, UMessage uMessage) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
            int i2 = this.f20274d;
            if (!PushAgent.getInstance(context).getNotificationOnForeground() && o.a().c()) {
                UTrack.getInstance().trackMsgDismissed(uMessage);
                return;
            }
            int displayNotificationNumber = MessageSharedPrefs.getInstance(context).getDisplayNotificationNumber();
            if (displayNotificationNumber == 1 && !z2) {
                UTrack.getInstance().trackMsgDismissed(uMessage);
                return;
            }
            MessageNotificationQueue messageNotificationQueue = MessageNotificationQueue.getInstance();
            if (displayNotificationNumber > 0) {
                while (messageNotificationQueue.size() >= displayNotificationNumber) {
                    UNotificationItem uNotificationItemPollFirst = messageNotificationQueue.pollFirst();
                    if (notificationManager != null) {
                        notificationManager.cancel(uNotificationItemPollFirst.id);
                    }
                    UTrack.getInstance().trackMsgDismissed(uNotificationItemPollFirst.message);
                }
            }
            messageNotificationQueue.addLast(new UNotificationItem(i2, uMessage));
            if (notificationManager != null) {
                notificationManager.notify(i2, notification);
                UTrack.getInstance().trackMsgShow(uMessage, notification);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void dealWithCustomMessage(Context context, UMessage uMessage) {
    }

    public void dealWithNotificationMessage(Context context, UMessage uMessage) {
        String strSubstring;
        Notification.Builder builder;
        UPLog.i(a, "notify: " + uMessage.getRaw().toString());
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(context);
        if (uMessage.hasResourceFromInternet() && !messageSharedPrefs.hasResourceDownloaded(uMessage.msg_id) && startDownloadResourceService(context, uMessage)) {
            return;
        }
        String lastMessageMsgID = messageSharedPrefs.getLastMessageMsgID();
        String strSubstring2 = ("".equals(lastMessageMsgID) || 22 != lastMessageMsgID.length()) ? "" : lastMessageMsgID.substring(7, 20);
        String str = uMessage.msg_id;
        if (str != null && 22 == str.length() && uMessage.msg_id.startsWith("u")) {
            messageSharedPrefs.setLastMessageMsgID(uMessage.msg_id);
            strSubstring = uMessage.msg_id.substring(7, 20);
        } else {
            strSubstring = f20270c;
        }
        boolean z2 = "".equals(strSubstring2) || strSubstring.compareToIgnoreCase(strSubstring2) >= 0;
        messageSharedPrefs.removeMessageResourceRecord(uMessage.msg_id);
        Notification notification = getNotification(context, uMessage);
        int notificationDefaults = getNotificationDefaults(context, uMessage);
        if (notification == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel silenceMode = isInNoDisturbTime(context) ? UPushNotificationChannel.getSilenceMode(context) : UPushNotificationChannel.getDefaultMode(context);
                if (silenceMode == null) {
                    return;
                } else {
                    builder = new Notification.Builder(context, silenceMode.getId());
                }
            } else {
                builder = new Notification.Builder(context);
            }
            if (!TextUtils.isEmpty(uMessage.expand_image) && Build.VERSION.SDK_INT >= 16) {
                builder.setStyle(new Notification.BigPictureStyle().bigPicture(getExpandImage(context, uMessage)));
            }
            if (!TextUtils.isEmpty(uMessage.bar_image)) {
                int smallIconId = getSmallIconId(context, uMessage);
                if (smallIconId < 0) {
                    return;
                }
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), b.a("upush_bar_image_notification"));
                remoteViews.setImageViewBitmap(b.b("notification_bar_image"), getBarImage(context, uMessage));
                builder.setContent(remoteViews).setSmallIcon(smallIconId).setTicker(uMessage.ticker).setAutoCancel(true);
            } else if (!a(context, builder, uMessage)) {
                return;
            } else {
                builder.setContentTitle(uMessage.title).setContentText(uMessage.text).setTicker(uMessage.ticker).setAutoCancel(true);
            }
            notification = builder.getNotification();
        }
        this.f20274d = new Random(System.nanoTime()).nextInt();
        notification.deleteIntent = getDismissPendingIntent(context, uMessage);
        notification.contentIntent = getClickPendingIntent(context, uMessage);
        if ((notificationDefaults & 1) != 0) {
            Uri sound = getSound(context, uMessage);
            if (sound != null) {
                notification.sound = getSound(context, uMessage);
            }
            if (sound != null) {
                notificationDefaults ^= 1;
            }
        }
        notification.defaults = notificationDefaults;
        a(context, notification, z2, uMessage);
    }

    public Bitmap getBarImage(Context context, UMessage uMessage) {
        try {
            return BitmapFactory.decodeFile(UmengDownloadResourceService.getMessageResourceFolder(context, uMessage) + uMessage.bar_image.hashCode());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public PendingIntent getClickPendingIntent(Context context, UMessage uMessage) {
        Intent intent = new Intent();
        int i2 = DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP;
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.setClass(context, UmengNotificationClickActivity.class);
        intent.putExtra("MSG", uMessage.getRaw().toString());
        intent.putExtra(UmengNotificationReceiver.EXTRA_KEY_NOTIFICATION_ID, this.f20274d);
        if (Build.VERSION.SDK_INT >= 23) {
            i2 = 335544320;
        }
        return PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, i2);
    }

    public PendingIntent getDismissPendingIntent(Context context, UMessage uMessage) {
        Intent intent = new Intent();
        intent.setClass(context, UmengNotificationReceiver.class);
        intent.putExtra("MSG", uMessage.getRaw().toString());
        intent.putExtra(UmengNotificationReceiver.EXTRA_KEY_ACTION, 11);
        intent.putExtra(UmengNotificationReceiver.EXTRA_KEY_NOTIFICATION_ID, this.f20274d);
        return PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() + 1), intent, Build.VERSION.SDK_INT >= 23 ? 335544320 : DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
    }

    public Bitmap getExpandImage(Context context, UMessage uMessage) {
        try {
            return BitmapFactory.decodeFile(UmengDownloadResourceService.getMessageResourceFolder(context, uMessage) + uMessage.expand_image.hashCode());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Bitmap getLargeIcon(Context context, UMessage uMessage) {
        Bitmap bitmapDecodeFile;
        try {
            if (uMessage.isLargeIconFromInternet()) {
                bitmapDecodeFile = BitmapFactory.decodeFile(UmengDownloadResourceService.getMessageResourceFolder(context, uMessage) + uMessage.img.hashCode());
            } else {
                bitmapDecodeFile = null;
            }
            if (bitmapDecodeFile != null) {
                return bitmapDecodeFile;
            }
            int iC = TextUtils.isEmpty(uMessage.largeIcon) ? -1 : b.c(uMessage.largeIcon);
            if (iC < 0) {
                iC = b.c(f20271e);
            }
            return iC > 0 ? BitmapFactory.decodeResource(context.getResources(), iC) : bitmapDecodeFile;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Notification getNotification(Context context, UMessage uMessage) {
        return null;
    }

    public int getNotificationDefaults(Context context, UMessage uMessage) {
        Calendar calendar = Calendar.getInstance();
        boolean zIsInNoDisturbTime = isInNoDisturbTime(context);
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(context);
        long muteDuration = ((long) messageSharedPrefs.getMuteDuration()) * 1000;
        int i2 = 0;
        if (!zIsInNoDisturbTime && (b == null || calendar.getTimeInMillis() - b.getTime() >= muteDuration)) {
            int notificationPlayVibrate = messageSharedPrefs.getNotificationPlayVibrate();
            UPLog.i(a, "playVibrate:" + notificationPlayVibrate);
            int i3 = (notificationPlayVibrate != 1 && (notificationPlayVibrate == 2 || !uMessage.play_vibrate)) ? 0 : 2;
            int notificationPlayLights = messageSharedPrefs.getNotificationPlayLights();
            UPLog.i(a, "playLights:" + notificationPlayLights);
            if (notificationPlayLights == 1 || (notificationPlayLights != 2 && uMessage.play_lights)) {
                i3 |= 4;
            }
            int notificationPlaySound = messageSharedPrefs.getNotificationPlaySound();
            UPLog.i(a, "playSound:" + notificationPlaySound);
            if (notificationPlaySound == 1 || (notificationPlaySound != 2 && uMessage.play_sound)) {
                i3 |= 1;
            }
            i2 = i3;
            b = calendar.getTime();
            if (uMessage.screen_on) {
                a(context);
            }
        }
        return i2;
    }

    public int getSmallIconId(Context context, UMessage uMessage) {
        try {
            iC = TextUtils.isEmpty(uMessage.icon) ? -1 : b.c(uMessage.icon);
            if (iC < 0) {
                iC = b.c(f20272f);
            }
            if (iC < 0) {
                UPLog.i(a, "no custom notification small icon! change to use app icon");
                iC = context.getApplicationInfo().icon;
            }
            if (iC < 0) {
                UPLog.e(a, "can't find notification small icon");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return iC;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.net.Uri getSound(android.content.Context r5, com.umeng.message.entity.UMessage r6) {
        /*
            r4 = this;
            r0 = 0
            boolean r1 = r6.isSoundFromInternet()     // Catch: java.lang.Throwable -> L6b
            if (r1 == 0) goto L2b
            java.lang.String r1 = com.umeng.message.UmengDownloadResourceService.getMessageResourceFolder(r5, r6)     // Catch: java.lang.Throwable -> L6b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b
            r2.<init>()     // Catch: java.lang.Throwable -> L6b
            r2.append(r1)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r1 = r6.sound     // Catch: java.lang.Throwable -> L6b
            int r1 = r1.hashCode()     // Catch: java.lang.Throwable -> L6b
            r2.append(r1)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L6b
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L6b
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L6b
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> L6b
            if (r2 != 0) goto L2c
        L2b:
            r1 = r0
        L2c:
            if (r1 != 0) goto L64
            r2 = -1
            java.lang.String r3 = r6.sound     // Catch: java.lang.Throwable -> L6b
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L6b
            if (r3 != 0) goto L3d
            java.lang.String r6 = r6.sound     // Catch: java.lang.Throwable -> L6b
            int r2 = com.umeng.message.proguard.b.d(r6)     // Catch: java.lang.Throwable -> L6b
        L3d:
            if (r2 >= 0) goto L45
            java.lang.String r6 = "umeng_push_notification_default_sound"
            int r2 = com.umeng.message.proguard.b.d(r6)     // Catch: java.lang.Throwable -> L6b
        L45:
            if (r2 <= 0) goto L64
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b
            r6.<init>()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r1 = "android.resource://"
            r6.append(r1)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Throwable -> L6b
            r6.append(r5)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r5 = "/"
            r6.append(r5)     // Catch: java.lang.Throwable -> L6b
            r6.append(r2)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Throwable -> L6b
        L64:
            if (r1 == 0) goto L6b
            android.net.Uri r5 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L6b
            return r5
        L6b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.getSound(android.content.Context, com.umeng.message.entity.UMessage):android.net.Uri");
    }

    @Override // com.umeng.message.api.UPushMessageHandler
    public void handleMessage(Context context, UMessage uMessage) {
        if (UMessage.DISPLAY_TYPE_NOTIFICATION.equals(uMessage.display_type)) {
            dealWithNotificationMessage(context, uMessage);
        } else if ("custom".equals(uMessage.display_type)) {
            if (TextUtils.isEmpty(uMessage.recall)) {
                dealWithCustomMessage(context, uMessage);
            } else {
                a(context, uMessage);
            }
        }
    }

    public boolean isInNoDisturbTime(Context context) {
        Calendar calendar = Calendar.getInstance();
        int i2 = (calendar.get(11) * 60) + calendar.get(12);
        boolean z2 = i2 >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute();
        boolean z3 = i2 <= (PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute();
        if ((PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute() >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute()) {
            if (z2 && z3) {
                return true;
            }
        } else if (z2 || z3) {
            return true;
        }
        return false;
    }

    public boolean startDownloadResourceService(Context context, UMessage uMessage) {
        try {
            Intent intent = new Intent(context, (Class<?>) UmengDownloadResourceService.class);
            intent.putExtra(AgooConstants.MESSAGE_BODY, uMessage.getRaw().toString());
            UMJobIntentService.enqueueWork(context, (Class<? extends UMJobIntentService>) UmengDownloadResourceService.class, intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private void a(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            boolean zIsScreenOn = powerManager.isScreenOn();
            UPLog.i(a, "screen on:" + zIsScreenOn);
            if (zIsScreenOn) {
                return;
            }
            powerManager.newWakeLock(805306374, "MyLock").acquire(10000L);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(Context context, Notification.Builder builder, UMessage uMessage) {
        int smallIconId = getSmallIconId(context, uMessage);
        Bitmap largeIcon = getLargeIcon(context, uMessage);
        if (smallIconId < 0) {
            return false;
        }
        builder.setSmallIcon(smallIconId);
        builder.setLargeIcon(largeIcon);
        return true;
    }

    private void a(Context context, UMessage uMessage) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
            if (notificationManager == null) {
                return;
            }
            for (UNotificationItem uNotificationItem : MessageNotificationQueue.getInstance().getQueue()) {
                if (uMessage.recall.equals(uNotificationItem.message.msg_id)) {
                    notificationManager.cancel(uNotificationItem.id);
                    MessageNotificationQueue.getInstance().remove(uNotificationItem);
                    s.a().a(uMessage);
                    return;
                }
            }
            s.a().b(uMessage);
        } catch (Throwable th) {
            UPLog.e(a, "notification recall exception:" + th.getMessage());
        }
    }
}
