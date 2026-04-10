package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static String a;

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|21|3|(2:17|4)|(5:5|(1:7)(1:23)|19|9|15)|8|19|9|15|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L46
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L46
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L46
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L46
            r4.<init>()     // Catch: java.lang.Throwable -> L46
            java.lang.String r5 = "/proc/"
            r4.append(r5)     // Catch: java.lang.Throwable -> L46
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L46
            r4.append(r5)     // Catch: java.lang.Throwable -> L46
            java.lang.String r5 = "/cmdline"
            r4.append(r5)     // Catch: java.lang.Throwable -> L46
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L46
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L46
            java.lang.String r4 = "iso-8859-1"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L46
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L46
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44
            r2.<init>()     // Catch: java.lang.Throwable -> L44
        L31:
            int r3 = r1.read()     // Catch: java.lang.Throwable -> L44
            if (r3 <= 0) goto L3c
            char r3 = (char) r3     // Catch: java.lang.Throwable -> L44
            r2.append(r3)     // Catch: java.lang.Throwable -> L44
            goto L31
        L3c:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L44
        L40:
            r1.close()     // Catch: java.lang.Exception -> L4a
            goto L4a
        L44:
            goto L47
        L46:
            r1 = r0
        L47:
            if (r1 == 0) goto L4a
            goto L40
        L4a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.a():java.lang.String");
    }

    public static String a(Context context) {
        int iMyPid;
        String str = a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            iMyPid = Process.myPid();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == iMyPid) {
                a = runningAppProcessInfo.processName;
                return a;
            }
            a = a();
            return a;
        }
        a = a();
        return a;
    }

    public static boolean b(Context context) {
        String strA = a(context);
        return (strA == null || !strA.contains(":")) && strA != null && strA.equals(context.getPackageName());
    }

    public static boolean c(Context context) {
        String strA = a(context);
        return strA != null && (strA.endsWith(":push") || strA.endsWith(":pushservice"));
    }
}
