package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import miuix.android.content.SystemIntent;

/* JADX INFO: loaded from: classes8.dex */
public class ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<String, String, String> f8227a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static Boolean f966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a<String, String, String> f8228b;
    public static final a<String, String, String> c;
    public static final a<String, String, String> d;
    public static final a<String, String, String> e;
    public static final a<String, String, String> f;
    public static final a<String, String, String> g;
    public static final a<String, String, String> h;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final String[] f968a = {"com.mi.globalbrowser", "com.android.browser"};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f967a = null;

    public static class a<F, S, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        F f8229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        S f8230b;
        T c;

        private a(F f, S s, T t) {
            this.f8229a = f;
            this.f8230b = s;
            this.c = t;
        }
    }

    static {
        String str = "getNotificationSettings";
        f8227a = new a<>(str, str, str);
        String str2 = "canSound";
        f8228b = new a<>("setSound", str2, str2);
        String str3 = "canVibrate";
        c = new a<>("setVibrate", str3, str3);
        String str4 = "canLights";
        d = new a<>("setLights", str4, str4);
        String str5 = "canShowOnKeyguard";
        e = new a<>("setShowOnKeyguard", str5, str5);
        f = new a<>("setFloat", "canFloat", "canShowFloat");
        String str6 = "canShowBadge";
        g = new a<>("setShowBadge", str6, str6);
        String str7 = "canShowOngoing";
        h = new a<>("setShowOngoing", str7, str7);
    }

    public static boolean a() {
        Bundle bundleM786a;
        if (f966a == null) {
            if (Build.VERSION.SDK_INT < 30 || (bundleM786a = g.m786a(SystemIntent.ACTIVATE_SERVICE_HOST_PACKAGE, (String) null)) == null || bundleM786a.isEmpty()) {
                f966a = Boolean.FALSE;
            } else {
                f966a = Boolean.TRUE;
            }
        }
        return f966a.booleanValue();
    }

    public static String b(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT);
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static String c(Notification notification) {
        Object objA;
        try {
            Bundle bundle = notification.extras;
            string = bundle != null ? bundle.getString("target_package") : null;
            return (!TextUtils.isEmpty(string) || (objA = com.xiaomi.push.bj.a(notification, "extraNotification")) == null) ? string : (String) com.xiaomi.push.bj.a(objA, "getTargetPkg", new Object[0]);
        } catch (Exception unused) {
            return string;
        }
    }

    public static void b(Notification notification, boolean z) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableKeyguard", z);
            }
            Object objA = com.xiaomi.push.bj.a(notification, "extraNotification");
            if (objA != null) {
                com.xiaomi.push.bj.a(objA, "setEnableKeyguard", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    public static String a(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE);
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Notification.Action[] m761a(Notification notification) {
        Parcelable[] parcelableArray;
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr;
        }
        Bundle bundle = notification.extras;
        if (bundle == null || (parcelableArray = bundle.getParcelableArray("mipush.customActions")) == null) {
            return null;
        }
        return (Notification.Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification.Action[].class);
    }

    public static <T> T a(Notification notification, String str) {
        Bundle bundle = notification.extras;
        if (bundle == null) {
            return null;
        }
        try {
            return (T) bundle.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Map<String, String> map, Bundle bundle, String str) {
        if (map != null && bundle != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(map.get(str))) {
                bundle.remove(str);
                return;
            } else {
                bundle.putString(str, map.get(str));
                return;
            }
        }
        com.xiaomi.channel.commonutils.logger.b.m106a("cp map to b fail:" + str);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m759a(Notification notification, String str) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putString("target_package", str);
            }
            Object objA = com.xiaomi.push.bj.a(notification, "extraNotification");
            if (objA != null) {
                com.xiaomi.push.bj.a(objA, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Notification notification, boolean z) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableFloat", z);
            }
            Object objA = com.xiaomi.push.bj.a(notification, "extraNotification");
            if (objA != null) {
                com.xiaomi.push.bj.a(objA, "setEnableFloat", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Notification notification, int i) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putInt("miui.messageCount", i);
            }
            Object objA = com.xiaomi.push.bj.a(notification, "extraNotification");
            if (objA != null) {
                com.xiaomi.push.bj.a(objA, "setMessageCount", Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Notification notification, int i, int i2) {
        if (notification != null) {
            if (notification.extras == null) {
                notification.extras = new Bundle();
            }
            notification.extras.putInt("is_priority", i);
            notification.extras.putInt("mipush_class", i2);
        }
    }

    public static String a(Object obj) {
        return (String) a(obj, "msg_busi_type", "");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T a(java.lang.Object r2, java.lang.String r3, T r4) {
        /*
            r0 = 0
            boolean r1 = r2 instanceof android.app.Notification     // Catch: java.lang.Exception -> L38
            if (r1 == 0) goto Ld
            android.app.Notification r2 = (android.app.Notification) r2     // Catch: java.lang.Exception -> L38
            java.lang.Object r2 = a(r2, r3)     // Catch: java.lang.Exception -> L38
        Lb:
            r0 = r2
            goto L4d
        Ld:
            boolean r1 = r2 instanceof java.util.Map     // Catch: java.lang.Exception -> L38
            if (r1 == 0) goto L18
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Exception -> L38
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Exception -> L38
            goto Lb
        L18:
            boolean r1 = r2 instanceof android.os.Bundle     // Catch: java.lang.Exception -> L38
            if (r1 == 0) goto L23
            android.os.Bundle r2 = (android.os.Bundle) r2     // Catch: java.lang.Exception -> L38
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Exception -> L38
            goto Lb
        L23:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L38
            r3.<init>()     // Catch: java.lang.Exception -> L38
            java.lang.String r1 = "not support get value from classType:"
            r3.append(r1)     // Catch: java.lang.Exception -> L38
            r3.append(r2)     // Catch: java.lang.Exception -> L38
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> L38
            com.xiaomi.channel.commonutils.logger.b.m106a(r2)     // Catch: java.lang.Exception -> L38
            goto L4d
        L38:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = "get value error "
            r3.append(r1)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.m106a(r2)
        L4d:
            if (r0 != 0) goto L50
            goto L51
        L50:
            r4 = r0
        L51:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ay.a(java.lang.Object, java.lang.String, java.lang.Object):java.lang.Object");
    }

    public static int a(Context context, String str) {
        return com.xiaomi.push.g.b(context, str);
    }

    public static void a(Context context, String str, Intent intent) {
        if (intent == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        arrayList.addAll(Arrays.asList(f968a));
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str2 = (String) arrayList.get(i);
            if (!TextUtils.isEmpty(str2)) {
                Intent intent2 = new Intent(intent);
                intent2.setPackage(str2);
                try {
                    if (context.getPackageManager().resolveActivity(intent2, 65536) != null) {
                        intent.setPackage(str2);
                        break;
                    }
                    continue;
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m106a("can't match url intent. " + e2);
                }
            }
        }
        intent.setPackage(intent.getPackage());
    }

    public static int a(ContentResolver contentResolver) {
        try {
            return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m106a("get user aggregate failed, " + e2);
            return 0;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m760a(ContentResolver contentResolver) {
        int iA = a(contentResolver);
        return iA == 1 || iA == 2;
    }

    public static boolean a(Map<String, String> map) {
        return Boolean.parseBoolean((String) a(map, "not_suppress", com.duokan.reader.domain.payment.a.c));
    }

    public static boolean a(Notification.Builder builder, boolean z) {
        builder.setGroupAlertBehavior(z ? 2 : 1);
        return true;
    }

    public static int a(Context context, String str, String str2, a<String, String, String> aVar) {
        if (aVar == null) {
            return -1;
        }
        try {
            Bundle bundleA = a(context, aVar.f8230b, str, str2, (Bundle) null);
            if (bundleA == null || !bundleA.containsKey(aVar.c)) {
                return -1;
            }
            return bundleA.getBoolean(aVar.c) ? 1 : 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static Bundle a(Context context, String str, String str2) {
        try {
            return a(context, f8227a.f8230b, str, str2, (Bundle) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a(Context context, String str, String str2, a<String, String, String> aVar, boolean z) {
        if (aVar != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean(aVar.c, z);
                a(context, aVar.f8229a, str, str2, bundle);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static Bundle a(Context context, String str, String str2, String str3, Bundle bundle) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("package", str2);
            if (!TextUtils.isEmpty(str3)) {
                bundle2.putString("channel_id", str3);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            return context.getContentResolver().call(Uri.parse("content://statusbar.notification"), str, (String) null, bundle2);
        }
        throw new IllegalArgumentException("call notification provider failed!");
    }
}
