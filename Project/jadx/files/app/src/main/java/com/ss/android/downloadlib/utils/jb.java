package com.ss.android.downloadlib.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.ss.android.download.api.config.lc;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class jb {
    private static Object[] ox = new Object[0];
    private static Object[] b = new Object[73];
    static final char[] mb = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String hj = null;

    public static Drawable b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static boolean h(Context context, String str) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                return false;
            }
            String str2 = packageArchiveInfo.packageName;
            int i2 = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i2 <= packageInfo.versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean hj(Context context, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.x.getContext();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static Signature[] ko(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static File lz(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        File file = new File((parentFile != null ? parentFile.getParent() : null) + File.separator + str);
        StringBuilder sb = new StringBuilder();
        sb.append("getExtDir: file.toString()-->");
        sb.append(file.toString());
        Logger.d("ToolUtils", sb.toString());
        return file;
    }

    public static boolean mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean ox(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static Intent u(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        return launchIntentForPackage;
    }

    public static Signature[] ww(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static long mb(JSONObject jSONObject, String str) {
        return com.ss.android.download.api.b.ox.mb(jSONObject, str);
    }

    public static int ox(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    @WorkerThread
    public static boolean b(String str) {
        File file;
        Context context = com.ss.android.downloadlib.addownload.x.getContext();
        if (TextUtils.isEmpty(str) || !hj(context, str)) {
            return false;
        }
        int i2 = context.getApplicationInfo().targetSdkVersion;
        if (com.ss.android.downloadlib.addownload.x.lz().optInt("get_ext_dir_mode") == 0 && Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
            return true;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 && com.ss.android.downloadlib.addownload.x.lz().optInt("get_ext_dir_mode") == 1) {
                file = lz(context, str);
            } else {
                file = new File(Environment.getExternalStorageDirectory().getPath(), "android/data/" + str);
            }
            if (!file.exists()) {
                return false;
            }
            long jMb = u.mb(file);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                if (packageInfo.lastUpdateTime < jMb) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static JSONObject mb(JSONObject jSONObject, JSONObject jSONObject2) {
        return com.ss.android.download.api.b.ox.mb(jSONObject, jSONObject2);
    }

    @NonNull
    public static JSONObject mb(JSONObject jSONObject) {
        return com.ss.android.download.api.b.ox.mb(jSONObject);
    }

    @NonNull
    public static JSONObject mb(JSONObject... jSONObjectArr) {
        return com.ss.android.download.api.b.ox.mb(jSONObjectArr);
    }

    public static boolean mb(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities != null) {
                return !listQueryIntentActivities.isEmpty();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean ox(com.ss.android.downloadad.api.mb.ox oxVar) {
        if (oxVar == null) {
            return false;
        }
        return mb(oxVar.h(), oxVar.q(), oxVar.bv()).mb();
    }

    public static boolean ox(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.x.getContext();
        }
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }

    public static PackageInfo mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        DownloadInfo downloadInfo;
        if (oxVar == null || (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.x.getContext()).getDownloadInfo(oxVar.m())) == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.appdownloader.b.mb(com.ss.android.downloadlib.addownload.x.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Drawable mb(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public static void ox() {
        try {
            if (com.ss.android.downloadlib.addownload.x.h().mb(com.ss.android.downloadlib.addownload.x.getContext(), "android.permission.REORDER_TASKS")) {
                ActivityManager activityManager = (ActivityManager) com.ss.android.downloadlib.addownload.x.getContext().getSystemService("activity");
                for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                    if (com.ss.android.downloadlib.addownload.x.getContext().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @NonNull
    public static HashMap<String, String> ox(JSONObject jSONObject) {
        HashMap<String, String> map = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.optString(next));
                }
                return map;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return map;
    }

    public static com.ss.android.downloadlib.addownload.model.b mb(String str, int i2, String str2) {
        com.ss.android.downloadlib.addownload.model.b bVar = new com.ss.android.downloadlib.addownload.model.b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        try {
            PackageInfo packageInfo = com.ss.android.downloadlib.addownload.x.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                bVar.ox(packageInfo.versionCode);
                bVar.mb(com.ss.android.downloadlib.addownload.model.b.ox);
                lc lcVarKo = com.ss.android.downloadlib.addownload.x.ko();
                if (lcVarKo != null && lcVarKo.mb() && !mb(packageInfo.versionCode, i2, packageInfo.versionName, str2)) {
                    bVar.mb(com.ss.android.downloadlib.addownload.model.b.b);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bVar;
    }

    private static boolean mb(int i2, int i3, String str, String str2) {
        if (i3 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i3 > 0 && i2 >= i3) || mb(str, str2) >= 0;
    }

    public static boolean mb(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return false;
        }
        return mb(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).mb();
    }

    public static boolean mb(Context context, String str, String str2) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null || !packageArchiveInfo.packageName.equals(str2)) {
                return false;
            }
            int i2 = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i2 == packageInfo.versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean mb(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < signatureArr.length; i2++) {
            if ((signatureArr[i2] == null && signatureArr2[i2] != null) || (signatureArr[i2] != null && !signatureArr[i2].equals(signatureArr2[i2]))) {
                return false;
            }
        }
        return true;
    }

    public static int mb(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String mb(String str, int i2) {
        return i2 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public static int mb(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] strArrSplit = str.split("\\.");
                String[] strArrSplit2 = str2.split("\\.");
                int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
                int i2 = 0;
                int i3 = 0;
                while (i2 < iMin) {
                    i3 = Integer.parseInt(strArrSplit[i2]) - Integer.parseInt(strArrSplit2[i2]);
                    if (i3 != 0) {
                        break;
                    }
                    i2++;
                }
                if (i3 != 0) {
                    return i3 > 0 ? 1 : -1;
                }
                for (int i4 = i2; i4 < strArrSplit.length; i4++) {
                    if (Integer.parseInt(strArrSplit[i4]) > 0) {
                        return 1;
                    }
                }
                while (i2 < strArrSplit2.length) {
                    if (Integer.parseInt(strArrSplit2[i2]) > 0) {
                        return -1;
                    }
                    i2++;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    public static String mb(String... strArr) {
        return com.ss.android.download.api.b.ox.mb(strArr);
    }

    @NonNull
    public static <T> T mb(T... tArr) {
        if (tArr != null) {
            for (T t2 : tArr) {
                if (t2 != null) {
                    return t2;
                }
            }
            throw new IllegalArgumentException("args is null");
        }
        throw new IllegalArgumentException("args is null");
    }

    public static long mb(long j2) {
        try {
            return mb(Environment.getExternalStorageDirectory(), j2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return j2;
        }
    }

    public static long mb(File file, long j2) {
        if (file == null) {
            return j2;
        }
        try {
            return DownloadUtils.getAvailableSpaceBytes(file.getAbsolutePath());
        } catch (Exception e2) {
            e2.printStackTrace();
            return j2;
        }
    }

    public static long mb(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getTotalBytes();
            }
            return -1L;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public static boolean mb() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void mb(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
