package com.xiaomi.passport.ui.settings.utils;

import android.annotation.SuppressLint;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes8.dex */
public class PermissionUtils {
    private static final String MANUFACTURER = Build.MANUFACTURER.toLowerCase();

    @SuppressLint({"PrivateApi"})
    private static String getModDevice() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.product.mod_device");
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void openPermissionSetting(android.app.Activity r5, int r6) {
        /*
            java.lang.String r0 = com.xiaomi.passport.ui.settings.utils.PermissionUtils.MANUFACTURER
            java.lang.String r1 = "xiaomi"
            boolean r1 = r0.contains(r1)
            r2 = 0
            if (r1 == 0) goto L2a
            java.lang.String r0 = getModDevice()
            if (r0 == 0) goto L76
            java.lang.String r1 = "_global"
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L76
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "miui.intent.action.APP_PERM_EDITOR"
            r0.<init>(r1)
            java.lang.String r1 = "extra_pkgname"
            java.lang.String r3 = r5.getPackageName()
            r0.putExtra(r1, r3)
            goto L77
        L2a:
            java.lang.String r1 = "huawei"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L33
            goto L76
        L33:
            java.lang.String r1 = "oppo"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L3c
            goto L76
        L3c:
            java.lang.String r1 = "vivo"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L5f
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.String r1 = "packagename"
            java.lang.String r3 = r5.getPackageName()
            r0.putExtra(r1, r3)
            android.content.ComponentName r1 = new android.content.ComponentName
            java.lang.String r3 = "com.vivo.permissionmanager"
            java.lang.String r4 = "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"
            r1.<init>(r3, r4)
            r0.setComponent(r1)
            goto L77
        L5f:
            java.lang.String r1 = "samsung"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L68
            goto L76
        L68:
            java.lang.String r1 = "meizu"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L71
            goto L76
        L71:
            java.lang.String r1 = "smartisan"
            r0.contains(r1)
        L76:
            r0 = r2
        L77:
            if (r0 == 0) goto L7e
            r5.startActivityForResult(r0, r6)     // Catch: java.lang.Throwable -> L7d
            goto L7e
        L7d:
            r0 = r2
        L7e:
            if (r0 != 0) goto L97
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.settings.APPLICATION_DETAILS_SETTINGS"
            r0.<init>(r1)
            java.lang.String r1 = r5.getPackageName()
            java.lang.String r3 = "package"
            android.net.Uri r1 = android.net.Uri.fromParts(r3, r1, r2)
            r0.setData(r1)
            r5.startActivityForResult(r0, r6)
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.passport.ui.settings.utils.PermissionUtils.openPermissionSetting(android.app.Activity, int):void");
    }
}
