package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.appdownloader.b.x;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.SystemUtils;
import com.umeng.message.entity.UMessage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static int mb;
    private static NotificationChannel ox;

    /* JADX INFO: Access modifiers changed from: private */
    public static int hj(Context context, int i2, boolean z2) {
        if (DownloadSetting.obtain(i2).optInt("notification_opt_2") == 1) {
            DownloadNotificationManager.getInstance().cancelNotification(i2);
        }
        mb((Activity) ww.mb().ox());
        return DownloadSetting.obtain(i2).optInt("install_queue_enable", 0) == 1 ? ww.mb().mb(context, i2, z2) : ox(context, i2, z2);
    }

    public static boolean b(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return ox(context, downloadInfo, mb(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    private static String mb(long j2, long j3, String str, boolean z2) {
        double d2 = j2;
        if (j3 > 1) {
            double d3 = j3;
            Double.isNaN(d2);
            Double.isNaN(d3);
            d2 /= d3;
        }
        if (z2 || "GB".equals(str) || "TB".equals(str)) {
            return new DecimalFormat("#.##").format(d2) + " " + str;
        }
        return new DecimalFormat("#").format(d2) + " " + str;
    }

    public static String ox(long j2) {
        long[] jArr = {DownloadConstants.TB, DownloadConstants.GB, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j2 < 1) {
            return "0 " + strArr[strArr.length - 1];
        }
        for (int i2 = 0; i2 < jArr.length; i2++) {
            long j3 = jArr[i2];
            if (j2 >= j3) {
                return mb(j2, j3, strArr[i2]);
            }
        }
        return null;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.equals(AdBaseConstants.MIME_APK);
    }

    public static List<String> b() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(AdBaseConstants.MIME_APK);
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static String mb(long j2) {
        return mb(j2, true);
    }

    private static JSONObject hj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String mb(long j2, boolean z2) {
        long[] jArr = {DownloadConstants.TB, DownloadConstants.GB, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j2 < 1) {
            return "0 " + strArr[strArr.length - 1];
        }
        for (int i2 = 0; i2 < jArr.length; i2++) {
            long j3 = jArr[i2];
            if (j2 >= j3) {
                return mb(j2, j3, strArr[i2], z2);
            }
        }
        return null;
    }

    public static int ox(final Context context, final int i2, final boolean z2) {
        final DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
        if (downloadInfo != null && AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            final File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                DownloadComponentManager.submitIOTask(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int iMb = b.mb(context, i2, z2, downloadInfo, file);
                        if (iMb == 1 && hj.x().lc() != null) {
                            hj.x().lc().onOpenInstaller(downloadInfo, null);
                        }
                        b.ox(downloadInfo, z2, iMb);
                    }
                });
                return 1;
            }
        }
        ox(downloadInfo, z2, 2);
        return 2;
    }

    private static String mb(long j2, long j3, String str) {
        double d2 = j2;
        if (j3 > 1) {
            double d3 = j3;
            Double.isNaN(d2);
            Double.isNaN(d3);
            d2 /= d3;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d2) + str;
        }
        return new DecimalFormat("#.##").format(d2) + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ox(DownloadInfo downloadInfo, boolean z2, int i2) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z2 ? 1 : 2);
            jSONObject.put("view_result", i2);
            jSONObject.put(EventConstants.ExtraJson.REAL_PACKAGE_NAME, downloadInfo.getFilePackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), MonitorConstants.EventLabel.INSTALL_VIEW_RESULT, jSONObject);
    }

    public static int mb(final Context context, final int i2, final boolean z2) {
        x xVarKo = hj.x().ko();
        if (xVarKo == null) {
            return hj(context, i2, z2);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
        mb = 1;
        xVarKo.mb(downloadInfo, new com.ss.android.socialbase.appdownloader.b.lz() { // from class: com.ss.android.socialbase.appdownloader.b.1
            @Override // com.ss.android.socialbase.appdownloader.b.lz
            public void mb() {
                int unused = b.mb = b.hj(context, i2, z2);
            }
        });
        return mb;
    }

    public static boolean ox(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return mb(context, downloadInfo, packageInfo, false);
    }

    public static int ox(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo packageInfoMb = mb(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (packageInfoMb != null) {
                    int i2 = packageInfoMb.versionCode;
                    downloadInfo.setAppVersionCode(i2);
                    return i2;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int mb(android.content.Context r5, int r6, boolean r7, com.ss.android.socialbase.downloader.model.DownloadInfo r8, java.io.File r9) {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.mb(android.content.Context, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo, java.io.File):int");
    }

    public static String ox() {
        return DownloadUtils.getDownloadPath();
    }

    public static boolean ox(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(26)
    public static String ox(@NonNull Context context) {
        try {
            if (ox == null) {
                ox = new NotificationChannel("111111", "channel_appdownloader", 3);
                ox.setSound(null, null);
                ox.setShowBadge(false);
                ((NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION)).createNotificationChannel(ox);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "111111";
    }

    public static int mb(Context context, Intent intent) {
        try {
            if (hj.x().o() != null) {
                if (hj.x().o().installApp(intent)) {
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

    public static boolean mb(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.b.hj hjVarOx = hj.x().ox();
        if (hjVarOx != null) {
            hjVarOx.mb(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (hjVarOx.mb()) {
                return true;
            }
        }
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener == null) {
            return false;
        }
        downloadNotificationEventListener.onNotificationEvent(8, downloadInfo, packageInfo.packageName, "");
        com.ss.android.socialbase.appdownloader.b.b bVarMb = hj.x().mb();
        return (bVarMb instanceof com.ss.android.socialbase.appdownloader.b.mb) && ((com.ss.android.socialbase.appdownloader.b.mb) bVarMb).b();
    }

    public static boolean mb(Context context, int i2, File file) {
        if (DownloadSetting.obtain(i2).optInt("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.u.hj.je() || com.ss.android.socialbase.appdownloader.u.hj.nk()) && SystemUtils.checkServiceExists(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt("userId", 0);
            bundle.putInt(AgooConstants.MESSAGE_FLAG, 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static int mb() {
        return hj.x().u() ? 16384 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri mb(int r1, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider r2, android.content.Context r3, java.lang.String r4, java.io.File r5) {
        /*
            if (r2 == 0) goto Lb
            java.lang.String r1 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.getUriForFile(r4, r1)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        Lb:
            com.ss.android.socialbase.appdownloader.hj r2 = com.ss.android.socialbase.appdownloader.hj.x()
            com.ss.android.socialbase.appdownloader.b.u r2 = r2.h()
            if (r2 == 0) goto L1e
            java.lang.String r0 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.mb(r1, r4, r0)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 != 0) goto L3b
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L37
            r0 = 24
            if (r2 < r0) goto L32
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L37
            if (r2 != 0) goto L32
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r3, r4, r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L32:
            android.net.Uri r1 = android.net.Uri.fromFile(r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L37:
            r2 = move-exception
            r2.printStackTrace()
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.mb(int, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider, android.content.Context, java.lang.String, java.io.File):android.net.Uri");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6 */
    private static Intent mb(Context context, DownloadInfo downloadInfo, @NonNull File file, boolean z2, int[] iArr) {
        Uri uriMb = mb(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, hj.x().hj(), file);
        if (uriMb == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(uriMb, AdBaseConstants.MIME_APK);
        com.ss.android.socialbase.appdownloader.b.hj hjVarOx = hj.x().ox();
        boolean zMb = hjVarOx != null ? hjVarOx.mb(downloadInfo.getId(), z2) : false;
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        ?? InterceptAfterNotificationSuccess = zMb;
        if (downloadNotificationEventListener != null) {
            InterceptAfterNotificationSuccess = downloadNotificationEventListener.interceptAfterNotificationSuccess(z2);
        }
        iArr[0] = InterceptAfterNotificationSuccess;
        if (InterceptAfterNotificationSuccess != 0) {
            return null;
        }
        return intent;
    }

    public static boolean mb(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && mb(DownloadComponentManager.getAppContext(), downloadInfo, str);
        }
        return true;
    }

    public static boolean mb(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                String str2 = "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl();
                PackageInfo packageInfoMb = mb(downloadInfo, file);
                if (packageInfoMb == null || !packageInfoMb.packageName.equals(str)) {
                    return false;
                }
                int i2 = packageInfoMb.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, mb());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i2 != packageInfo.versionCode) {
                    return false;
                }
            } else {
                if (!DownloadSetting.obtain(downloadInfo.getId()).optBugFix("install_callback_error")) {
                    return false;
                }
                String string = DownloadUtils.getString(downloadInfo.getTempCacheData().get("extra_apk_package_name"), null);
                int i3 = DownloadUtils.getInt(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (string == null || TextUtils.isEmpty(string) || !string.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, mb());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || i3 != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean mb(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z2) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i2 = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i2);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, mb());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i3 = packageInfo2.versionCode;
        return z2 ? i2 < i3 : (downloadInfo == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("install_with_same_version_code", 0) != 1) ? i2 <= i3 : i2 < i3;
    }

    public static boolean mb(Context context, DownloadInfo downloadInfo) {
        return mb(context, downloadInfo, true);
    }

    public static boolean mb(Context context, DownloadInfo downloadInfo, boolean z2) {
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode <= 0 && z2) {
            return b(context, downloadInfo);
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, mb());
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null) {
            return false;
        }
        return DownloadSetting.obtain(downloadInfo.getId()).optInt("install_with_same_version_code", 0) == 1 ? appVersionCode < packageInfo.versionCode : appVersionCode <= packageInfo.versionCode;
    }

    public static PackageInfo mb(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        String str3 = "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length();
        return mb(downloadInfo, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String mb(java.lang.String r1, java.lang.String r2, java.lang.String r3, boolean r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L9
            java.lang.String r1 = ""
            return r1
        L9:
            android.net.Uri r1 = android.net.Uri.parse(r1)
            java.lang.String r0 = "default.apk"
            if (r4 == 0) goto L26
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 == 0) goto L3a
            java.lang.String r2 = r1.getLastPathSegment()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L37
            java.lang.String r2 = r1.getLastPathSegment()
            goto L3a
        L26:
            java.lang.String r1 = r1.getLastPathSegment()
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L39
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L37
            goto L3a
        L37:
            r2 = r0
            goto L3a
        L39:
            r2 = r1
        L3a:
            boolean r1 = b(r3)
            if (r1 == 0) goto L57
            java.lang.String r1 = ".apk"
            boolean r3 = r2.endsWith(r1)
            if (r3 != 0) goto L57
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r1)
            java.lang.String r2 = r3.toString()
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.mb(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static String mb(String str, DownloadSetting downloadSetting) {
        JSONObject jSONObjectOptJSONObject;
        String str2;
        if (downloadSetting == null || (jSONObjectOptJSONObject = downloadSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            return "";
        }
        String strOptString = jSONObjectOptJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
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

    public static boolean mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new JSONObject(str).optBoolean("bind_app", false);
    }

    public static int mb(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == -2) {
            return 2;
        }
        if (i2 == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i2) || i2 == 11) {
            return 1;
        }
        return DownloadStatus.isDownloadOver(i2) ? 3 : 0;
    }

    public static boolean mb(Context context) {
        int color;
        if (Build.VERSION.SDK_INT > 20 && context != null) {
            TypedArray typedArrayObtainStyledAttributes = null;
            try {
                color = context.getResources().getColor(h.ox());
                typedArrayObtainStyledAttributes = context.obtainStyledAttributes(h.h(), new int[]{h.b(), h.hj()});
            } catch (Throwable unused) {
                if (typedArrayObtainStyledAttributes != null) {
                }
            }
            if (color == typedArrayObtainStyledAttributes.getColor(0, 0)) {
                if (typedArrayObtainStyledAttributes != null) {
                    try {
                        typedArrayObtainStyledAttributes.recycle();
                    } catch (Throwable unused2) {
                    }
                }
                return true;
            }
            if (typedArrayObtainStyledAttributes != null) {
                try {
                    typedArrayObtainStyledAttributes.recycle();
                } catch (Throwable unused3) {
                }
            }
        }
        return false;
    }

    public static void mb(DownloadInfo downloadInfo, boolean z2, boolean z3) {
        hj.x().mb(new u(DownloadComponentManager.getAppContext(), downloadInfo.getUrl()).mb(downloadInfo.getTitle()).ox(downloadInfo.getName()).b(downloadInfo.getSavePath()).mb(downloadInfo.isShowNotification()).ox(downloadInfo.isAutoInstallWithoutNotification()).b(downloadInfo.isOnlyWifi() || z3).hj(downloadInfo.getExtra()).h(downloadInfo.getMimeType()).mb(downloadInfo.getExtraHeaders()).h(true).ox(downloadInfo.getRetryCount()).b(downloadInfo.getBackUpUrlRetryCount()).ox(downloadInfo.getBackUpUrls()).hj(downloadInfo.getMinProgressTimeMsInterval()).h(downloadInfo.getMaxProgressCount()).u(z2).hj(downloadInfo.isNeedHttpsToHttpRetry()).u(downloadInfo.getPackageName()).ko(downloadInfo.getMd5()).mb(downloadInfo.getExpectFileLength()).lz(downloadInfo.isNeedDefaultHttpServiceBackUp()).x(downloadInfo.isNeedReuseFirstConnection()).je(downloadInfo.isNeedIndependentProcess()).mb(downloadInfo.getEnqueueType()).o(downloadInfo.isForce()).nk(downloadInfo.isHeadConnectionAvailable()).ko(downloadInfo.isNeedRetryDelay()).ww(downloadInfo.getRetryDelayTimeArray()).mb(hj(downloadInfo.getDownloadSettingString())).x(downloadInfo.getIconUrl()).u(downloadInfo.getExecutorGroup()).io(downloadInfo.isAutoInstall()));
    }

    public static void mb(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static PackageInfo mb(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.ss.android.socialbase.appdownloader.u.mb.h.mb(DownloadComponentManager.getAppContext(), file, mb());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo packageInfoMb = com.ss.android.socialbase.appdownloader.u.mb.h.mb(DownloadComponentManager.getAppContext(), file, mb());
        downloadInfo.setPackageInfo(packageInfoMb);
        return packageInfoMb;
    }

    public static int mb(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
