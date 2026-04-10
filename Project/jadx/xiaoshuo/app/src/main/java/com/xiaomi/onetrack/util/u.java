package com.xiaomi.onetrack.util;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.accountsdk.account.AccountIntent;
import com.yuewen.km4;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7771a = "PermissionUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7772b = "android.permission.READ_PRIVILEGED_PHONE_STATE";
    private static Set<String> c;

    static {
        try {
            HashSet hashSet = new HashSet();
            c = hashSet;
            hashSet.add("android");
            c.add("com.miui.analytics");
            c.add("com.miui.cit");
            c.add(AccountIntent.PACKAGE_NAME_FIND_DEVICE);
            c.add("com.miui.securitycenter");
            c.add("com.android.settings");
            c.add(km4.v);
            c.add("com.google.android.gms");
            c.add("com.xiaomi.factory.mmi");
            c.add("com.miui.qr");
            c.add("com.android.contacts");
            c.add("com.qualcomm.qti.autoregistration");
            c.add("com.miui.tsmclient");
            c.add("com.miui.sekeytool");
            c.add("com.android.updater");
            if ("cn_chinamobile".equals(ab.a("ro.miui.cust_variant")) || "cn_chinatelecom".equals(ab.a("ro.miui.cust_variant"))) {
                c.add("com.mobiletools.systemhelper");
                c.add("com.miui.dmregservice");
            }
        } catch (Exception e) {
            Log.e(f7771a, "static initializer: " + e.toString());
        }
    }

    public static boolean a(Context context) {
        return Build.VERSION.SDK_INT < 29 ? a(context, "android.permission.READ_PHONE_STATE") : a() ? a(com.xiaomi.onetrack.f.a.e()) && a(context, "android.permission.READ_PRIVILEGED_PHONE_STATE") : a(context, "android.permission.READ_PRIVILEGED_PHONE_STATE");
    }

    public static boolean b(Context context) {
        return Build.VERSION.SDK_INT < 29 ? a(context, "android.permission.READ_PHONE_STATE") : a(context, "android.permission.READ_PRIVILEGED_PHONE_STATE");
    }

    private static boolean a() {
        try {
            if (q.a() && !q.i()) {
                return "1".equals(ab.a("ro.miui.restrict_imei"));
            }
            return false;
        } catch (Exception e) {
            p.b(f7771a, "isRestrictIMEI " + e.toString());
            return false;
        }
    }

    private static boolean a(String str) {
        Set<String> set;
        return (TextUtils.isEmpty(str) || (set = c) == null || !set.contains(str)) ? false : true;
    }

    private static boolean a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
