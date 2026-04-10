package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.ig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f8225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Object f962a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static WeakHashMap<Integer, ax> f963a = new WeakHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8226b;

    private ax(String str) {
        this.f965a = str;
    }

    private String b(String str) {
        return a(m749a() ? "mipush|%s|%s" : "mipush_%s_%s", this.f965a, str);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Context m753a() {
        return f8225a;
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f965a + com.alipay.sdk.m.y.l.d;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m754a() {
        return this.f965a;
    }

    public static ax a(Context context, String str) {
        a(context);
        int iHashCode = str.hashCode();
        ax axVar = f963a.get(Integer.valueOf(iHashCode));
        if (axVar != null) {
            return axVar;
        }
        ax axVar2 = new ax(str);
        f963a.put(Integer.valueOf(iHashCode), axVar2);
        return axVar2;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f8226b)) {
            this.f8226b = b("default");
        }
        return this.f8226b;
    }

    public String b(String str, String str2) {
        return m749a() ? str : str2;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public List<StatusBarNotification> m758b() {
        String str = this.f965a;
        NotificationManager notificationManagerA = a();
        List<StatusBarNotification> list = null;
        try {
            if (m749a()) {
                int iA = com.xiaomi.push.i.a();
                if (iA != -1) {
                    list = (List) a(com.xiaomi.push.bj.a(f962a, "getAppActiveNotifications", str, Integer.valueOf(iA)));
                }
            } else {
                StatusBarNotification[] activeNotifications = notificationManagerA.getActiveNotifications();
                if (activeNotifications != null && activeNotifications.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        for (StatusBarNotification statusBarNotification : activeNotifications) {
                            if (str.equals(ay.c(statusBarNotification.getNotification()))) {
                                arrayList.add(statusBarNotification);
                            }
                        }
                        list = arrayList;
                    } catch (Throwable th) {
                        th = th;
                        list = arrayList;
                        m748a("getActiveNotifications error " + th);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return list;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m750a(Context context) {
        a(context);
        return m749a();
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strA = a("mipush|%s|%s", str2, "");
        return str.startsWith(strA) ? a("mipush_%s_%s", str2, str.replace(strA, "")) : str;
    }

    private static void a(Context context) {
        if (f8225a == null) {
            f8225a = context.getApplicationContext();
            NotificationManager notificationManagerA = a();
            Boolean bool = (Boolean) com.xiaomi.push.bj.a((Object) notificationManagerA, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m748a("fwk is support.init:" + bool);
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            f964a = zBooleanValue;
            if (zBooleanValue) {
                f962a = com.xiaomi.push.bj.a((Object) notificationManagerA, "getService", new Object[0]);
            }
        }
    }

    private static NotificationManager a() {
        return (NotificationManager) f8225a.getSystemService("notification");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m749a() {
        if (com.xiaomi.push.j.m611a() && ba.a(f8225a).a(ig.NotificationBelongToAppSwitch.a(), true)) {
            return f964a;
        }
        return false;
    }

    private static int a(String str) {
        try {
            return f8225a.getPackageManager().getPackageUid(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    private static Object a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    private static <T> T a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String a(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) ? "" : String.format(str, str2, str3);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m757a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(b(""));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m755a(String str) {
        if (TextUtils.isEmpty(str)) {
            return b();
        }
        return com.xiaomi.push.j.m612a(m753a()) ? b(str) : str;
    }

    @TargetApi(26)
    public void a(NotificationChannel notificationChannel) {
        String str = this.f965a;
        try {
            if (m749a()) {
                int iA = a(str);
                if (iA != -1) {
                    com.xiaomi.push.bj.b(f962a, "createNotificationChannelsForPackage", str, Integer.valueOf(iA), a(Arrays.asList(notificationChannel)));
                }
            } else {
                a().createNotificationChannel(notificationChannel);
            }
        } catch (Exception e) {
            m748a("createNotificationChannel error" + e);
        }
    }

    @TargetApi(26)
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public NotificationChannel m752a(String str) {
        NotificationChannel notificationChannel = null;
        try {
            if (m749a()) {
                List<NotificationChannel> listM756a = m756a();
                if (listM756a != null) {
                    Iterator<NotificationChannel> it = listM756a.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            NotificationChannel next = it.next();
                            if (str.equals(next.getId())) {
                                notificationChannel = next;
                                break;
                            }
                        }
                    }
                }
            } else {
                notificationChannel = a().getNotificationChannel(str);
            }
            break;
        } catch (Exception e) {
            m748a("getNotificationChannel error" + e);
        }
        return notificationChannel;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @TargetApi(26)
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public List<NotificationChannel> m756a() {
        String str;
        String str2 = this.f965a;
        List<NotificationChannel> notificationChannels = null;
        try {
            if (m749a()) {
                int iA = a(str2);
                if (iA != -1) {
                    Object obj = f962a;
                    Object[] objArr = {str2, Integer.valueOf(iA), Boolean.FALSE};
                    str = "mipush|%s|%s";
                    notificationChannels = (List) a(com.xiaomi.push.bj.a(obj, "getNotificationChannelsForPackage", objArr));
                } else {
                    str = null;
                }
            } else {
                notificationChannels = a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!com.xiaomi.push.j.m611a() || notificationChannels == null) {
                return notificationChannels;
            }
            ArrayList arrayList = new ArrayList();
            String strA = a(str, str2, "");
            for (NotificationChannel notificationChannel : notificationChannels) {
                if (notificationChannel.getId().startsWith(strA)) {
                    arrayList.add(notificationChannel);
                }
            }
            return arrayList;
        } catch (Exception e) {
            m748a("getNotificationChannels error " + e);
            return notificationChannels;
        }
    }

    public void a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f965a;
        try {
            if (z) {
                int iA = a(str);
                if (iA != -1) {
                    com.xiaomi.push.bj.b(f962a, "updateNotificationChannelForPackage", str, Integer.valueOf(iA), notificationChannel);
                }
            } else {
                a(notificationChannel);
            }
        } catch (Exception e) {
            m748a("updateNotificationChannel error " + e);
        }
    }

    public void a(int i, Notification notification) {
        String str = this.f965a;
        NotificationManager notificationManagerA = a();
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (m749a()) {
                notification.extras.putString("xmsf_target_package", str);
                if (i2 >= 29) {
                    notificationManagerA.notifyAsPackage(str, null, i, notification);
                } else {
                    notificationManagerA.notify(i, notification);
                }
            } else {
                notificationManagerA.notify(i, notification);
            }
        } catch (Exception unused) {
        }
    }

    public void a(int i) {
        String str = this.f965a;
        try {
            if (m749a()) {
                int iA = com.xiaomi.push.i.a();
                String packageName = m753a().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    com.xiaomi.push.bj.b(f962a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i), Integer.valueOf(iA));
                } else {
                    com.xiaomi.push.bj.b(f962a, "cancelNotificationWithTag", str, null, Integer.valueOf(i), Integer.valueOf(iA));
                }
                m748a("cancel succ:" + i);
                return;
            }
            a().cancel(i);
        } catch (Exception e) {
            m748a("cancel error" + e);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private StatusBarNotification[] m751a() {
        if (!com.xiaomi.push.j.m612a(m753a())) {
            return null;
        }
        try {
            Object objA = com.xiaomi.push.bj.a(f962a, "getActiveNotifications", m753a().getPackageName());
            if (objA instanceof StatusBarNotification[]) {
                return (StatusBarNotification[]) objA;
            }
            return null;
        } catch (Throwable th) {
            m748a("getAllNotifications error " + th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m748a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m106a("NMHelper:" + str);
    }
}
