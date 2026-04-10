package com.ss.android.socialbase.appdownloader.u.mb;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class h {
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
    
        r4 = null;
        r13 = r1.getInputStream(r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.ss.android.socialbase.appdownloader.u.mb.mb] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.ss.android.socialbase.appdownloader.u.mb.mb] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.pm.PackageInfo mb(@androidx.annotation.NonNull java.io.File r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.u.mb.h.mb(java.io.File):android.content.pm.PackageInfo");
    }

    private static String mb(int i2) {
        return (i2 >>> 24) == 1 ? "android:" : "";
    }

    private static PackageInfo ox(@NonNull Context context, @NonNull File file, int i2) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            mb("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i2);
        } catch (Throwable th) {
            mb("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    public static PackageInfo mb(@NonNull Context context, @NonNull File file, int i2) {
        int i3;
        if (DownloadExpSwitchCode.isSwitchEnable(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP) && (i3 = Build.VERSION.SDK_INT) >= 21 && i3 < 26) {
            try {
                return mb(file);
            } catch (Throwable th) {
                mb("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
                return ox(context, file, i2);
            }
        }
        return ox(context, file, i2);
    }

    private static void mb(@NonNull String str, @NonNull String str2) {
        IDownloadMonitorListener downloadMonitorListener = DownloadComponentManager.getDownloadMonitorListener();
        if (downloadMonitorListener == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", str2);
        } catch (JSONException unused) {
        }
        downloadMonitorListener.monitorEvent(str, jSONObject, null, null);
    }

    private static String mb(mb mbVar, int i2) {
        int iOx = mbVar.ox(i2);
        int iB = mbVar.b(i2);
        if (iOx == 3) {
            return mbVar.hj(i2);
        }
        return iOx == 2 ? String.format("?%s%08X", mb(iB), Integer.valueOf(iB)) : (iOx < 16 || iOx > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(iB), Integer.valueOf(iOx)) : String.valueOf(iB);
    }

    public static String mb(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e2) {
            mb("getPackageInfo::fail_load_label", e2.getMessage());
            return null;
        }
    }
}
