package com.xiaomi.passport.ui.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes8.dex */
public class OsHelper {
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_MI_OS = "ro.mi.os.version.name";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    private static String sName;
    private static String sVersion;

    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean check(java.lang.String r2) throws java.lang.Throwable {
        /*
            java.lang.String r0 = com.xiaomi.passport.ui.utils.OsHelper.sName
            if (r0 == 0) goto L9
            boolean r2 = r0.equals(r2)
            return r2
        L9:
            java.lang.String r0 = "ro.miui.ui.version.name"
            java.lang.String r0 = getProp(r0)
            com.xiaomi.passport.ui.utils.OsHelper.sVersion = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L93
            java.lang.String r0 = "ro.mi.os.version.name"
            java.lang.String r0 = getProp(r0)
            com.xiaomi.passport.ui.utils.OsHelper.sVersion = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L27
            goto L93
        L27:
            java.lang.String r0 = "ro.build.version.emui"
            java.lang.String r0 = getProp(r0)
            com.xiaomi.passport.ui.utils.OsHelper.sVersion = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L3a
            java.lang.String r0 = "EMUI"
            com.xiaomi.passport.ui.utils.OsHelper.sName = r0
            goto L97
        L3a:
            java.lang.String r0 = "ro.build.version.opporom"
            java.lang.String r0 = getProp(r0)
            com.xiaomi.passport.ui.utils.OsHelper.sVersion = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L4d
            java.lang.String r0 = "OPPO"
            com.xiaomi.passport.ui.utils.OsHelper.sName = r0
            goto L97
        L4d:
            java.lang.String r0 = "ro.vivo.os.version"
            java.lang.String r0 = getProp(r0)
            com.xiaomi.passport.ui.utils.OsHelper.sVersion = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L60
            java.lang.String r0 = "VIVO"
            com.xiaomi.passport.ui.utils.OsHelper.sName = r0
            goto L97
        L60:
            java.lang.String r0 = "ro.smartisan.version"
            java.lang.String r0 = getProp(r0)
            com.xiaomi.passport.ui.utils.OsHelper.sVersion = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L73
            java.lang.String r0 = "SMARTISAN"
            com.xiaomi.passport.ui.utils.OsHelper.sName = r0
            goto L97
        L73:
            java.lang.String r0 = android.os.Build.DISPLAY
            com.xiaomi.passport.ui.utils.OsHelper.sVersion = r0
            java.lang.String r0 = r0.toUpperCase()
            java.lang.String r1 = "FLYME"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L86
            com.xiaomi.passport.ui.utils.OsHelper.sName = r1
            goto L97
        L86:
            java.lang.String r0 = "unknown"
            com.xiaomi.passport.ui.utils.OsHelper.sVersion = r0
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r0 = r0.toUpperCase()
            com.xiaomi.passport.ui.utils.OsHelper.sName = r0
            goto L97
        L93:
            java.lang.String r0 = "MIUI"
            com.xiaomi.passport.ui.utils.OsHelper.sName = r0
        L97:
            java.lang.String r0 = com.xiaomi.passport.ui.utils.OsHelper.sName
            boolean r2 = r0.equals(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.passport.ui.utils.OsHelper.check(java.lang.String):boolean");
    }

    public static String getName() throws Throwable {
        if (sName == null) {
            check("");
        }
        return sName;
    }

    public static String getProp(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return line;
            } catch (IOException unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String getVersion() throws Throwable {
        if (sVersion == null) {
            check("");
        }
        return sVersion;
    }

    public static boolean is360() {
        return check(ROM_QIKU) || check("360");
    }

    public static boolean isEmui() {
        return check(ROM_EMUI);
    }

    public static boolean isFlyme() {
        return check(ROM_FLYME);
    }

    public static boolean isMiui() {
        return check(ROM_MIUI);
    }

    public static boolean isOppo() {
        return check(ROM_OPPO);
    }

    public static boolean isSmartisan() {
        return check(ROM_SMARTISAN);
    }

    public static boolean isVivo() {
        return check(ROM_VIVO);
    }
}
