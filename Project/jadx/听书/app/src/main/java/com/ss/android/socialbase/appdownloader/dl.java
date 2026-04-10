package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.appdownloader.dl.kb;
import com.ss.android.socialbase.appdownloader.dl.uy;
import com.ss.android.socialbase.downloader.a.gk;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class dl {
    private static NotificationChannel g;
    private static int z;

    private static String z(long j, long j2, String str, boolean z2) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if (z2 || "GB".equals(str) || "TB".equals(str)) {
            return new DecimalFormat("#.##").format(d) + " " + str;
        }
        return new DecimalFormat("#").format(d) + " " + str;
    }

    public static String z(long j) {
        return z(j, true);
    }

    public static String z(long j, boolean z2) {
        long[] jArr = {1099511627776L, 1073741824, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return z(j, j2, strArr[i], z2);
            }
        }
        return null;
    }

    private static String z(long j, long j2, String str) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d) + str;
        }
        return new DecimalFormat("#.##").format(d) + str;
    }

    public static String g(long j) {
        long[] jArr = {1099511627776L, 1073741824, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return z(j, j2, strArr[i]);
            }
        }
        return null;
    }

    public static int z(final Context context, final int i, final boolean z2) {
        kb kbVarGz = a.kb().gz();
        if (kbVarGz == null) {
            return a(context, i, z2);
        }
        com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(context).gz(i);
        z = 1;
        kbVarGz.z(dlVarGz, new uy() { // from class: com.ss.android.socialbase.appdownloader.dl.1
            @Override // com.ss.android.socialbase.appdownloader.dl.uy
            public void z() {
                int unused = dl.z = dl.a(context, i, z2);
            }
        });
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(Context context, int i, boolean z2) {
        if (com.ss.android.socialbase.downloader.i.z.z(i).g("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.g.z().m(i);
        }
        z((Activity) gz.z().g());
        if (com.ss.android.socialbase.downloader.i.z.z(i).z("install_queue_enable", 0) == 1) {
            return gz.z().z(context, i, z2);
        }
        return g(context, i, z2);
    }

    public static int g(final Context context, final int i, final boolean z2) {
        final com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(context).gz(i);
        if (dlVarGz != null && "application/vnd.android.package-archive".equals(dlVarGz.yt()) && !TextUtils.isEmpty(dlVarGz.kb()) && !TextUtils.isEmpty(dlVarGz.gz())) {
            final File file = new File(dlVarGz.kb(), dlVarGz.gz());
            if (file.exists()) {
                com.ss.android.socialbase.downloader.downloader.dl.g(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.dl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.kb().wp();
                        int iZ = dl.z(context, i, z2, dlVarGz, file);
                        if (iZ == 1 && a.kb().fv() != null) {
                            a.kb().fv().z(dlVarGz, null);
                        }
                        dl.g(dlVarGz, z2, iZ);
                    }
                });
                return 1;
            }
        }
        g(dlVarGz, z2, 2);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(com.ss.android.socialbase.downloader.e.dl dlVar, boolean z2, int i) {
        if (dlVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z2 ? 1 : 2);
            jSONObject.put("view_result", i);
            jSONObject.put("real_package_name", dlVar.lq());
        } catch (Exception e) {
            wp.z(e);
        }
        com.ss.android.socialbase.downloader.downloader.dl.gp().z(dlVar.e(), "install_view_result", jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int z(android.content.Context r5, int r6, boolean r7, com.ss.android.socialbase.downloader.e.dl r8, java.io.File r9) {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.dl.z(android.content.Context, int, boolean, com.ss.android.socialbase.downloader.e.dl, java.io.File):int");
    }

    public static int z(Context context, Intent intent) {
        try {
            if (a.kb().p() != null) {
                if (a.kb().p().z(intent)) {
                    return 1;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static boolean z(Context context, com.ss.android.socialbase.downloader.e.dl dlVar, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(dlVar.x())) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.dl.gc gcVarDl = a.kb().dl();
        if (gcVarDl != null) {
            gcVarDl.z(dlVar.e(), 8, dlVar.x(), packageInfo.packageName, "");
            if (gcVarDl.z()) {
                return true;
            }
        }
        gk gkVarFo = com.ss.android.socialbase.downloader.downloader.e.g(context).fo(dlVar.e());
        if (gkVarFo == null) {
            return false;
        }
        gkVarFo.z(8, dlVar, packageInfo.packageName, "");
        com.ss.android.socialbase.appdownloader.dl.a aVarG = a.kb().g();
        return (aVarG instanceof com.ss.android.socialbase.appdownloader.dl.z) && ((com.ss.android.socialbase.appdownloader.dl.z) aVarG).g();
    }

    public static boolean z(Context context, int i, File file) {
        if (com.ss.android.socialbase.downloader.i.z.z(i).z("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.m.gc.i() || com.ss.android.socialbase.appdownloader.m.gc.v()) && com.ss.android.socialbase.downloader.pf.uy.z(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt("userId", 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e) {
                wp.z(e);
            }
        }
        return false;
    }

    public static int z() {
        return a.kb().e() ? 16384 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri z(int r1, com.ss.android.socialbase.downloader.a.q r2, android.content.Context r3, java.lang.String r4, java.io.File r5) {
        /*
            if (r2 == 0) goto Lb
            java.lang.String r1 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.z(r4, r1)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        Lb:
            com.ss.android.socialbase.appdownloader.a r2 = com.ss.android.socialbase.appdownloader.a.kb()
            com.ss.android.socialbase.appdownloader.dl.e r2 = r2.m()
            if (r2 == 0) goto L1e
            java.lang.String r0 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.z(r1, r4, r0)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 != 0) goto L35
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L31
            if (r2 != 0) goto L2c
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r3, r4, r5)     // Catch: java.lang.Throwable -> L31
            goto L35
        L2c:
            android.net.Uri r1 = android.net.Uri.fromFile(r5)     // Catch: java.lang.Throwable -> L31
            goto L35
        L31:
            r2 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r2)
        L35:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.dl.z(int, com.ss.android.socialbase.downloader.a.q, android.content.Context, java.lang.String, java.io.File):android.net.Uri");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6 */
    private static Intent z(Context context, com.ss.android.socialbase.downloader.e.dl dlVar, File file, boolean z2, int[] iArr) {
        Uri uriZ = z(dlVar.e(), com.ss.android.socialbase.downloader.downloader.e.g(context).wp(dlVar.e()), context, a.kb().gc(), file);
        if (uriZ == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(1);
        intent.setDataAndType(uriZ, "application/vnd.android.package-archive");
        com.ss.android.socialbase.appdownloader.dl.gc gcVarDl = a.kb().dl();
        boolean z3 = gcVarDl != null ? gcVarDl.z(dlVar.e(), z2) : false;
        gk gkVarFo = com.ss.android.socialbase.downloader.downloader.e.g(context).fo(dlVar.e());
        ?? Z = z3;
        if (gkVarFo != null) {
            Z = gkVarFo.z(z2);
        }
        iArr[0] = Z;
        if (Z != 0) {
            return null;
        }
        return intent;
    }

    public static boolean z(com.ss.android.socialbase.downloader.e.dl dlVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(dlVar.x()) || !str.equals(dlVar.x())) {
            return !TextUtils.isEmpty(dlVar.gz()) && z(com.ss.android.socialbase.downloader.downloader.dl.xl(), dlVar, str);
        }
        return true;
    }

    public static boolean z(Context context, com.ss.android.socialbase.downloader.e.dl dlVar, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(dlVar.kb(), dlVar.gz());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                wp.a("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + dlVar.gz() + " apkFileSize：" + file.length() + " fileUrl：" + dlVar.uy());
                PackageInfo packageInfoZ = z(dlVar, file);
                if (packageInfoZ == null || !packageInfoZ.packageName.equals(str)) {
                    return false;
                }
                int i = packageInfoZ.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, z());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i != packageInfo.versionCode) {
                    return false;
                }
            } else {
                if (!com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("install_callback_error")) {
                    return false;
                }
                String strZ = com.ss.android.socialbase.downloader.pf.m.z(dlVar.rg().get("extra_apk_package_name"), (String) null);
                int iZ = com.ss.android.socialbase.downloader.pf.m.z(dlVar.rg().get("extra_apk_version_code"), 0);
                if (strZ == null || TextUtils.isEmpty(strZ) || !strZ.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, z());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || iZ != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            wp.z(e);
            return false;
        }
    }

    public static boolean g(Context context, com.ss.android.socialbase.downloader.e.dl dlVar, PackageInfo packageInfo) {
        return z(context, dlVar, packageInfo, false);
    }

    public static boolean z(Context context, com.ss.android.socialbase.downloader.e.dl dlVar, PackageInfo packageInfo, boolean z2) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i = packageInfo.versionCode;
        if (dlVar != null) {
            dlVar.gz(i);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, z());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i2 = packageInfo2.versionCode;
        return z2 ? i < i2 : (dlVar == null || com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("install_with_same_version_code", 0) != 1) ? i <= i2 : i < i2;
    }

    public static boolean z(Context context, com.ss.android.socialbase.downloader.e.dl dlVar) {
        return z(context, dlVar, true);
    }

    public static boolean z(Context context, com.ss.android.socialbase.downloader.e.dl dlVar, boolean z2) {
        PackageInfo packageInfo;
        if (dlVar == null) {
            return false;
        }
        String strX = dlVar.x();
        int iZd = dlVar.zd();
        if (iZd > 0 || !z2) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(strX, z());
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("install_with_same_version_code", 0) == 1 ? iZd < packageInfo.versionCode : iZd <= packageInfo.versionCode;
        }
        return dl(context, dlVar);
    }

    public static int g(Context context, com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (context != null && dlVar != null && !TextUtils.isEmpty(dlVar.kb()) && !TextUtils.isEmpty(dlVar.gz())) {
            int iZd = dlVar.zd();
            if (iZd > 0) {
                return iZd;
            }
            try {
                PackageInfo packageInfoZ = z(context, dlVar, dlVar.kb(), dlVar.gz());
                if (packageInfoZ != null) {
                    int i = packageInfoZ.versionCode;
                    dlVar.gz(i);
                    return i;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static boolean dl(Context context, com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (context == null || dlVar == null || TextUtils.isEmpty(dlVar.kb()) || TextUtils.isEmpty(dlVar.gz())) {
            return false;
        }
        return g(context, dlVar, z(context, dlVar, dlVar.kb(), dlVar.gz()));
    }

    public static PackageInfo z(Context context, com.ss.android.socialbase.downloader.e.dl dlVar, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        wp.a("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
        return z(dlVar, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String z(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r1 = ""
            if (r0 == 0) goto L9
            return r1
        L9:
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.String r0 = "default.apk"
            java.lang.String r2 = ".."
            if (r6 == 0) goto L34
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L5a
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = r4.contains(r2)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            goto L5a
        L32:
            r4 = r0
            goto L5a
        L34:
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L4c
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = r6.contains(r2)
            if (r6 != 0) goto L4c
            java.lang.String r1 = r3.getLastPathSegment()
        L4c:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L59
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L32
            goto L5a
        L59:
            r4 = r1
        L5a:
            boolean r3 = dl(r5)
            if (r3 == 0) goto L79
            java.lang.String r3 = ".apk"
            boolean r5 = r4.endsWith(r3)
            if (r5 != 0) goto L79
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r4 = r3.toString()
        L79:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.dl.z(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static String g() {
        return com.ss.android.socialbase.downloader.pf.m.gc();
    }

    public static String z(String str, com.ss.android.socialbase.downloader.i.z zVar) {
        JSONObject jSONObjectA;
        String str2;
        if (zVar == null || (jSONObjectA = zVar.a("download_dir")) == null) {
            return "";
        }
        String strOptString = jSONObjectA.optString("dir_name");
        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("/")) {
            strOptString = strOptString.substring(1);
        }
        if (TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        if (!strOptString.contains("%s")) {
            str2 = strOptString + str;
        } else {
            try {
                str2 = String.format(strOptString, str);
            } catch (Throwable unused) {
            }
        }
        strOptString = str2;
        return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
    }

    public static boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (JSONException e) {
            wp.z(e);
        }
        return new JSONObject(str).optBoolean("bind_app", false);
    }

    public static boolean g(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            wp.z(e);
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                return false;
            }
        }
        return true;
    }

    public static int z(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == -2) {
            return 2;
        }
        if (i == 1) {
            return 4;
        }
        if (com.ss.android.socialbase.downloader.g.m.g(i) || i == 11) {
            return 1;
        }
        return com.ss.android.socialbase.downloader.g.m.z(i) ? 3 : 0;
    }

    public static boolean dl(String str) {
        return !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0033 A[EXC_TOP_SPLITTER, PHI: r4
  0x0033: PHI (r4v3 android.content.res.TypedArray) = (r4v2 android.content.res.TypedArray), (r4v4 android.content.res.TypedArray) binds: [B:16:0x0038, B:12:0x0031] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean z(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            int r1 = com.ss.android.socialbase.appdownloader.gc.g()     // Catch: java.lang.Throwable -> L37
            android.content.res.Resources r2 = r4.getResources()     // Catch: java.lang.Throwable -> L37
            int r1 = r2.getColor(r1)     // Catch: java.lang.Throwable -> L37
            int r2 = com.ss.android.socialbase.appdownloader.gc.dl()     // Catch: java.lang.Throwable -> L37
            int r3 = com.ss.android.socialbase.appdownloader.gc.a()     // Catch: java.lang.Throwable -> L37
            int[] r2 = new int[]{r2, r3}     // Catch: java.lang.Throwable -> L37
            int r3 = com.ss.android.socialbase.appdownloader.gc.gc()     // Catch: java.lang.Throwable -> L37
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r3, r2)     // Catch: java.lang.Throwable -> L37
            int r2 = r4.getColor(r0, r0)     // Catch: java.lang.Throwable -> L38
            if (r1 != r2) goto L31
            if (r4 == 0) goto L2f
            r4.recycle()     // Catch: java.lang.Throwable -> L2f
        L2f:
            r4 = 1
            return r4
        L31:
            if (r4 == 0) goto L3b
        L33:
            r4.recycle()     // Catch: java.lang.Throwable -> L3b
            goto L3b
        L37:
            r4 = 0
        L38:
            if (r4 == 0) goto L3b
            goto L33
        L3b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.dl.z(android.content.Context):boolean");
    }

    public static String g(Context context) {
        try {
            if (g == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                g = notificationChannel;
                notificationChannel.setSound(null, null);
                g.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(g);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        return "111111";
    }

    public static List<String> dl() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("application/vnd.android.package-archive");
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static void z(com.ss.android.socialbase.downloader.e.dl dlVar, boolean z2, boolean z3) {
        a.kb().z(new m(com.ss.android.socialbase.downloader.downloader.dl.xl(), dlVar.uy()).z(dlVar.fo()).g(dlVar.gz()).dl(dlVar.kb()).z(dlVar.wx()).g(dlVar.cb()).dl(dlVar.io() || z3).gc(dlVar.gk()).m(dlVar.yt()).z(dlVar.ti()).gc(true).g(dlVar.oq()).dl(dlVar.wj()).g(dlVar.mj()).a(dlVar.vk()).gc(dlVar.vy()).m(z2).a(dlVar.dt()).e(dlVar.x()).gz(dlVar.mc()).z(dlVar.un()).fo(dlVar.pf()).uy(dlVar.sd()).wp(dlVar.tf()).z(dlVar.fv()).v(dlVar.vo()).i(dlVar.wn()).e(dlVar.xo()).fo(dlVar.xf()).z(a(dlVar.y())).kb(dlVar.zb()).m(dlVar.fs()).ls(dlVar.o()));
    }

    private static JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void z(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e) {
                wp.z(e);
            }
        }
    }

    public static PackageInfo z(com.ss.android.socialbase.downloader.e.dl dlVar, File file) {
        if (dlVar == null) {
            return com.ss.android.socialbase.appdownloader.m.z.gc.z(com.ss.android.socialbase.downloader.downloader.dl.xl(), file, z());
        }
        PackageInfo packageInfoCt = dlVar.ct();
        if (packageInfoCt != null) {
            return packageInfoCt;
        }
        PackageInfo packageInfoZ = com.ss.android.socialbase.appdownloader.m.z.gc.z(com.ss.android.socialbase.downloader.downloader.dl.xl(), file, z());
        dlVar.z(packageInfoZ);
        return packageInfoZ;
    }

    public static int z(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
