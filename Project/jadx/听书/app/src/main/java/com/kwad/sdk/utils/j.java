package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

/* JADX INFO: loaded from: classes4.dex */
public final class j {
    private static String aYL = Build.BRAND;
    private static String aYM = "OPPO";
    private static String aYN = "vivo";
    private static String aYO = "Xiaomi";
    private static String aYP = "Meizu";
    private static String aYQ = "HUAWEI";
    private static String aYR = "HONOR";

    public static void cA(Context context) {
        Intent intentCB;
        if (context == null || (intentCB = cB(context)) == null) {
            return;
        }
        try {
            context.startActivity(intentCB);
        } catch (Exception unused) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        }
    }

    private static Intent cB(Context context) {
        Intent intent;
        if (PJ()) {
            return N(context, PO());
        }
        if (PK() || PL()) {
            intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        } else if (PH()) {
            intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("packageName", context.getPackageName());
        } else if (PM() || PN()) {
            intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
        } else if (PI()) {
            intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity"));
        } else {
            intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
        }
        return intent;
    }

    private static Intent N(Context context, String str) {
        if ("V5".equals(str)) {
            return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName()));
        }
        if ("V6".equals(str) || "V7".equals(str)) {
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            return intent;
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent2.putExtra("extra_pkgname", context.getPackageName());
        return intent2;
    }

    private static boolean PH() {
        String str = "";
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.display.id", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str.toLowerCase().contains("flyme");
    }

    private static boolean PI() {
        return "QIKU".equals(Build.MANUFACTURER.toUpperCase()) || "360".equals(Build.MANUFACTURER.toUpperCase());
    }

    private static boolean PJ() {
        return aYL.equalsIgnoreCase(aYO);
    }

    public static boolean PK() {
        return aYL.equalsIgnoreCase(aYQ);
    }

    public static boolean PL() {
        return aYL.equalsIgnoreCase(aYR);
    }

    private static boolean PM() {
        return aYL.equalsIgnoreCase(aYM);
    }

    private static boolean PN() {
        return aYL.equalsIgnoreCase(aYN);
    }

    private static String PO() {
        return ap("ro.miui.ui.version.name", "");
    }

    private static String ap(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }
}
