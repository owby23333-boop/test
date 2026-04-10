package com.kwad.sdk.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class ak {
    private static Map<String, Integer> ayV;
    private static Set<String> ayW;
    private static Method ayX;

    static {
        HashSet hashSet = new HashSet();
        ayW = hashSet;
        hashSet.add("android.permission.REQUEST_INSTALL_PACKAGES");
        ayW.add("android.permission.WRITE_SETTINGS");
        ayW.add("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public static int al(Context context, String str) {
        int iAm;
        if (ayV == null) {
            h(ai.cx(context));
        }
        if (ayW.contains(str) && (iAm = am(context, str)) != -2) {
            return iAm;
        }
        int iAn = an(context, str);
        if (iAn != -2) {
            return iAn;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return iAn;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004b A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int am(android.content.Context r6, java.lang.String r7) {
        /*
            int r0 = r7.hashCode()
            r1 = -2078357533(0xffffffff841ec7e3, float:-1.8664594E-36)
            r2 = 2
            r3 = 1
            r4 = 0
            r5 = -1
            if (r0 == r1) goto L2c
            r1 = -1561629405(0xffffffffa2eb6d23, float:-6.381243E-18)
            if (r0 == r1) goto L22
            r1 = 1777263169(0x69eee241, float:3.60991E25)
            if (r0 == r1) goto L18
            goto L36
        L18:
            java.lang.String r0 = "android.permission.REQUEST_INSTALL_PACKAGES"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L36
            r7 = 0
            goto L37
        L22:
            java.lang.String r0 = "android.permission.SYSTEM_ALERT_WINDOW"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L36
            r7 = 2
            goto L37
        L2c:
            java.lang.String r0 = "android.permission.WRITE_SETTINGS"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L36
            r7 = 1
            goto L37
        L36:
            r7 = -1
        L37:
            if (r7 == 0) goto L5d
            r0 = 23
            if (r7 == r3) goto L52
            if (r7 == r2) goto L40
            goto L6a
        L40:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r0) goto L6a
            boolean r6 = android.provider.Settings.canDrawOverlays(r6)     // Catch: java.lang.Throwable -> L4d
            if (r6 == 0) goto L4b
            goto L6b
        L4b:
            r4 = -1
            goto L6b
        L4d:
            r6 = move-exception
            com.kwad.sdk.core.d.b.printStackTraceOnly(r6)
            goto L6a
        L52:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r0) goto L6a
            boolean r6 = android.provider.Settings.System.canWrite(r6)
            if (r6 == 0) goto L4b
            goto L6b
        L5d:
            int r7 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r7 < r0) goto L6a
            boolean r6 = com.kwad.sdk.utils.ai.cw(r6)
            if (r6 == 0) goto L4b
            goto L6b
        L6a:
            r4 = -2
        L6b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.ak.am(android.content.Context, java.lang.String):int");
    }

    private static int an(Context context, String str) {
        if (ayV == null || str == null) {
            return -2;
        }
        if (Build.VERSION.SDK_INT < 19) {
            return 0;
        }
        if (!ayV.containsKey(str)) {
            return -2;
        }
        try {
            Integer num = ayV.get(str);
            if (num == null) {
                return -2;
            }
            if (ayX == null) {
                Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class);
                ayX = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return ((Integer) ayX.invoke((AppOpsManager) context.getSystemService("appops"), num, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0 ? 0 : -1;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return 0;
        }
    }

    public static boolean cy(Context context) {
        int i2;
        try {
            i2 = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Throwable unused) {
            i2 = 0;
        }
        return i2 == 1;
    }

    private static String es(String str) {
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(".");
        if (iLastIndexOf < 0) {
            return str;
        }
        try {
            return str.substring(iLastIndexOf + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    private static void h(String[] strArr) {
        if (Build.VERSION.SDK_INT < 19 || strArr == null) {
            return;
        }
        ayV = new HashMap();
        for (String str : strArr) {
            try {
                int iIntValue = ((Integer) r.c((Class<?>) AppOpsManager.class, "OP_" + es(str))).intValue();
                if (iIntValue >= 0) {
                    ayV.put(str, Integer.valueOf(iIntValue));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
