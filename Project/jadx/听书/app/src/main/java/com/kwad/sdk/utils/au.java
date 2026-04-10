package com.kwad.sdk.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.provider.Settings;
import com.funny.audio.core.utils.FileUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class au {
    private static Map<String, Integer> baa;
    private static Set<String> bab;
    private static Method bac;

    static {
        HashSet hashSet = new HashSet();
        bab = hashSet;
        hashSet.add("android.permission.REQUEST_INSTALL_PACKAGES");
        bab.add("android.permission.WRITE_SETTINGS");
        bab.add("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public static int at(Context context, String str) {
        int iAu;
        if (baa == null) {
            h(y.cN(context));
        }
        if (bab.contains(str) && (iAu = au(context, str)) != -2) {
            return iAu;
        }
        int iAv = av(context, str);
        if (iAv != -2) {
            return iAv;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return iAv;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int au(Context context, String str) {
        str.hashCode();
        switch (str) {
            case "android.permission.WRITE_SETTINGS":
                try {
                    if (Settings.System.canWrite(context)) {
                        return 0;
                    }
                    return -1;
                } catch (Throwable unused) {
                    break;
                }
                break;
            case "android.permission.SYSTEM_ALERT_WINDOW":
                try {
                    if (Settings.canDrawOverlays(context)) {
                        return 0;
                    }
                    return -1;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    break;
                }
                break;
            case "android.permission.REQUEST_INSTALL_PACKAGES":
                if (y.cM(context)) {
                    return 0;
                }
                return -1;
            default:
                return -2;
        }
    }

    private static int av(Context context, String str) {
        if (baa == null || str == null || !baa.containsKey(str)) {
            return -2;
        }
        try {
            Integer num = baa.get(str);
            if (num == null) {
                return -2;
            }
            if (bac == null) {
                Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class);
                bac = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return ((Integer) bac.invoke((AppOpsManager) context.getSystemService("appops"), num, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0 ? 0 : -1;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return 0;
        }
    }

    private static void h(String[] strArr) {
        if (strArr == null) {
            return;
        }
        baa = new HashMap();
        for (String str : strArr) {
            try {
                int iIntValue = ((Integer) z.c(AppOpsManager.class, "OP_" + hg(str))).intValue();
                if (iIntValue >= 0) {
                    baa.put(str, Integer.valueOf(iIntValue));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String hg(String str) {
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR);
        if (iLastIndexOf < 0) {
            return str;
        }
        try {
            return str.substring(iLastIndexOf + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    public static boolean dk(Context context) {
        int i;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Throwable unused) {
            i = 0;
        }
        return i == 1;
    }
}
