package com.hjq.permissions;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import androidx.fragment.app.FragmentActivity;
import com.kuaishou.weapon.p0.g;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: PermissionUtils.java */
/* JADX INFO: loaded from: classes2.dex */
final class e {
    static boolean a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (a(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean b() {
        return Build.VERSION.SDK_INT >= 29;
    }

    static boolean c() {
        return Build.VERSION.SDK_INT >= 30;
    }

    static boolean d() {
        return Build.VERSION.SDK_INT >= 23;
    }

    static boolean e() {
        return Build.VERSION.SDK_INT >= 24;
    }

    static boolean f() {
        return Build.VERSION.SDK_INT >= 26;
    }

    static boolean g(Context context) {
        return c() ? Environment.isExternalStorageManager() : f.a(context, b.a);
    }

    static boolean h(Context context) {
        if (d()) {
            return Settings.canDrawOverlays(context);
        }
        return true;
    }

    static List<String> b(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                return a(strArr);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    static boolean c(Context context) {
        return (context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    static boolean d(Context context) {
        if (f()) {
            return context.getPackageManager().canRequestPackageInstalls();
        }
        return true;
    }

    static boolean e(Context context) {
        if (e()) {
            return ((NotificationManager) context.getSystemService(NotificationManager.class)).areNotificationsEnabled();
        }
        if (!d()) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            return ((Integer) appOpsManager.getClass().getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) appOpsManager.getClass().getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(context.getApplicationInfo().uid), context.getPackageName())).intValue() == 0;
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    static boolean f(Context context) {
        if (d()) {
            return Settings.System.canWrite(context);
        }
        return true;
    }

    static boolean a(String str) {
        return "android.permission.MANAGE_EXTERNAL_STORAGE".equals(str) || "android.permission.REQUEST_INSTALL_PACKAGES".equals(str) || "android.permission.SYSTEM_ALERT_WINDOW".equals(str) || "android.permission.ACCESS_NOTIFICATION_POLICY".equals(str) || "android.permission.WRITE_SETTINGS".equals(str);
    }

    static boolean b(Context context, List<String> list) {
        if (!d()) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!b(context, it.next())) {
                return false;
            }
        }
        return true;
    }

    static boolean b(Context context, String str) {
        if (!d()) {
            return true;
        }
        if ("android.permission.MANAGE_EXTERNAL_STORAGE".equals(str)) {
            return g(context);
        }
        if ("android.permission.REQUEST_INSTALL_PACKAGES".equals(str)) {
            return d(context);
        }
        if ("android.permission.SYSTEM_ALERT_WINDOW".equals(str)) {
            return h(context);
        }
        if ("android.permission.ACCESS_NOTIFICATION_POLICY".equals(str)) {
            return e(context);
        }
        if ("android.permission.WRITE_SETTINGS".equals(str)) {
            return f(context);
        }
        if (!b()) {
            if ("android.permission.ACCESS_BACKGROUND_LOCATION".equals(str) || "android.permission.ACCESS_MEDIA_LOCATION".equals(str)) {
                return true;
            }
            if ("android.permission.ACTIVITY_RECOGNITION".equals(str)) {
                return context.checkSelfPermission("android.permission.BODY_SENSORS") == 0;
            }
        }
        if (!f()) {
            if ("android.permission.ANSWER_PHONE_CALLS".equals(str)) {
                return context.checkSelfPermission("android.permission.PROCESS_OUTGOING_CALLS") == 0;
            }
            if ("android.permission.READ_PHONE_NUMBERS".equals(str)) {
                return context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0;
            }
        }
        return context.checkSelfPermission(str) == 0;
    }

    static int a(Context context, String str) {
        return b(context, str) ? 0 : -1;
    }

    private static boolean a(Activity activity, String str) {
        if (!d() || a(str)) {
            return false;
        }
        if (!b()) {
            if ("android.permission.ACCESS_BACKGROUND_LOCATION".equals(str) || "android.permission.ACCESS_MEDIA_LOCATION".equals(str)) {
                return false;
            }
            if ("android.permission.ACTIVITY_RECOGNITION".equals(str)) {
                return activity.checkSelfPermission("android.permission.BODY_SENSORS") == -1 && !activity.shouldShowRequestPermissionRationale(str);
            }
        }
        if (!f()) {
            if ("android.permission.ANSWER_PHONE_CALLS".equals(str)) {
                return activity.checkSelfPermission("android.permission.PROCESS_OUTGOING_CALLS") == -1 && !activity.shouldShowRequestPermissionRationale(str);
            }
            if ("android.permission.READ_PHONE_NUMBERS".equals(str)) {
                return activity.checkSelfPermission("android.permission.READ_PHONE_STATE") == -1 && !activity.shouldShowRequestPermissionRationale(str);
            }
        }
        return activity.checkSelfPermission(str) == -1 && !activity.shouldShowRequestPermissionRationale(str);
    }

    static List<String> a(String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == -1) {
                arrayList.add(strArr[i2]);
            }
        }
        return arrayList;
    }

    static boolean b(Activity activity, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (a(activity, it.next())) {
                return true;
            }
        }
        return false;
    }

    static boolean a(Context context, Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, 65536).isEmpty();
    }

    static List<String> b(String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == 0) {
                arrayList.add(strArr[i2]);
            }
        }
        return arrayList;
    }

    static <T> ArrayList<T> a(T... tArr) {
        if (tArr == null) {
            return null;
        }
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T t2 : tArr) {
            arrayList.add(t2);
        }
        return arrayList;
    }

    static void a(Activity activity, List<String> list) {
        List<String> listB = b(activity);
        if (listB != null && !listB.isEmpty()) {
            int i2 = Build.VERSION.SDK_INT >= 24 ? activity.getApplicationInfo().minSdkVersion : 23;
            for (String str : list) {
                if (i2 < 30 && "android.permission.MANAGE_EXTERNAL_STORAGE".equals(str)) {
                    if (listB.contains(g.f16729i)) {
                        if (!listB.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
                            throw new ManifestException("android.permission.WRITE_EXTERNAL_STORAGE");
                        }
                    } else {
                        throw new ManifestException(g.f16729i);
                    }
                }
                if (i2 < 29 && "android.permission.ACTIVITY_RECOGNITION".equals(str) && !listB.contains("android.permission.BODY_SENSORS")) {
                    throw new ManifestException("android.permission.BODY_SENSORS");
                }
                if (i2 < 26) {
                    if ("android.permission.ANSWER_PHONE_CALLS".equals(str) && !listB.contains("android.permission.PROCESS_OUTGOING_CALLS")) {
                        throw new ManifestException("android.permission.PROCESS_OUTGOING_CALLS");
                    }
                    if ("android.permission.READ_PHONE_NUMBERS".equals(str) && !listB.contains("android.permission.READ_PHONE_STATE")) {
                        throw new ManifestException("android.permission.READ_PHONE_STATE");
                    }
                }
                if (!"android.permission.ACCESS_NOTIFICATION_POLICY".equals(str) && !listB.contains(str)) {
                    throw new ManifestException(str);
                }
            }
            return;
        }
        throw new ManifestException();
    }

    static void b(List<String> list) {
        if (list.contains("android.permission.MANAGE_EXTERNAL_STORAGE")) {
            if (!list.contains(g.f16729i) && !list.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
                if (!c()) {
                    list.add(g.f16729i);
                    list.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
            } else {
                throw new IllegalArgumentException("Please do not apply for these two permissions dynamically");
            }
        }
        if (list.contains("android.permission.ANSWER_PHONE_CALLS")) {
            if (!list.contains("android.permission.PROCESS_OUTGOING_CALLS")) {
                if (!b() && !list.contains("android.permission.PROCESS_OUTGOING_CALLS")) {
                    list.add("android.permission.PROCESS_OUTGOING_CALLS");
                }
            } else {
                throw new IllegalArgumentException("Please do not apply for these two permissions dynamically");
            }
        }
        if (!list.contains("android.permission.ACTIVITY_RECOGNITION") || b() || list.contains("android.permission.BODY_SENSORS")) {
            return;
        }
        list.add("android.permission.BODY_SENSORS");
    }

    static void a(Context context, List<String> list) {
        int i2;
        if (list.contains("android.permission.MANAGE_EXTERNAL_STORAGE")) {
            i2 = 30;
        } else if (list.contains("android.permission.ACCESS_BACKGROUND_LOCATION") || list.contains("android.permission.ACTIVITY_RECOGNITION") || list.contains("android.permission.ACCESS_MEDIA_LOCATION")) {
            i2 = 29;
        } else {
            i2 = (list.contains("android.permission.REQUEST_INSTALL_PACKAGES") || list.contains("android.permission.ANSWER_PHONE_CALLS") || list.contains("android.permission.READ_PHONE_NUMBERS")) ? 26 : 23;
        }
        if (context.getApplicationInfo().targetSdkVersion >= i2) {
            return;
        }
        throw new RuntimeException("The targetSdkVersion SDK must be " + i2 + " or more");
    }

    static int a() {
        return new Random().nextInt((int) Math.pow(2.0d, 16.0d));
    }

    static FragmentActivity a(Context context) {
        while (!(context instanceof FragmentActivity)) {
            if (!(context instanceof ContextWrapper) || (context = ((ContextWrapper) context).getBaseContext()) == null) {
                return null;
            }
        }
        return (FragmentActivity) context;
    }
}
