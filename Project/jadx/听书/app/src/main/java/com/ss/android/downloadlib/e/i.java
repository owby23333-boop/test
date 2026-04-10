package com.ss.android.downloadlib.e;

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
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.z.z.g.fv;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class i {
    private static Object[] g = new Object[0];
    private static Object[] dl = new Object[73];
    static final char[] z = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2005a = null;

    public static boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean g(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static long z(JSONObject jSONObject, String str) {
        return com.ss.android.z.z.m.g.z(jSONObject, str);
    }

    public static JSONObject z(JSONObject jSONObject, JSONObject jSONObject2) {
        return com.ss.android.z.z.m.g.z(jSONObject, jSONObject2);
    }

    public static JSONObject z(JSONObject jSONObject) {
        return com.ss.android.z.z.m.g.z(jSONObject);
    }

    public static JSONObject z(JSONObject... jSONObjectArr) {
        return com.ss.android.z.z.m.g.z(jSONObjectArr);
    }

    public static boolean z(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities != null) {
                if (!listQueryIntentActivities.isEmpty()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String z(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j >= 1073741824) {
            return (j / 1073741824) + "G";
        }
        if (j >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return (j / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) + "M";
        }
        return decimalFormat.format(j / 1048576.0f) + "M";
    }

    public static PackageInfo z(com.ss.android.g.z.g.g gVar) {
        com.ss.android.socialbase.downloader.e.dl dlVarGz;
        if (gVar == null || (dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.downloadlib.addownload.wp.getContext()).gz(gVar.js())) == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.appdownloader.dl.z(com.ss.android.downloadlib.addownload.wp.getContext(), dlVarGz, dlVarGz.kb(), dlVarGz.gz());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Drawable z(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
        return null;
    }

    public static int g(Context context, String str) {
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

    public static String dl(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static Drawable a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static boolean gc(Context context, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.wp.getContext();
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

    public static com.ss.android.downloadlib.addownload.g.dl z(String str, int i, String str2) {
        com.ss.android.downloadlib.addownload.g.dl dlVar = new com.ss.android.downloadlib.addownload.g.dl();
        if (TextUtils.isEmpty(str)) {
            return dlVar;
        }
        try {
            PackageInfo packageInfo = com.ss.android.downloadlib.addownload.wp.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                dlVar.g(packageInfo.versionCode);
                dlVar.z(com.ss.android.downloadlib.addownload.g.dl.g);
                fv fvVarE = com.ss.android.downloadlib.addownload.wp.e();
                if (fvVarE != null && fvVarE.z() && !z(packageInfo.versionCode, i, packageInfo.versionName, str2)) {
                    dlVar.z(com.ss.android.downloadlib.addownload.g.dl.dl);
                }
            }
        } catch (Exception e) {
            com.ss.android.socialbase.downloader.m.z.gc("ToolUtils", "getInstalledAppInfo:" + e.getMessage());
        }
        return dlVar;
    }

    private static boolean z(int i, int i2, String str, String str2) {
        if (i2 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i2 > 0 && i >= i2) || z(str, str2) >= 0;
    }

    public static boolean g(com.ss.android.g.z.g.g gVar) {
        if (gVar == null) {
            return false;
        }
        return z(gVar.gc(), gVar.ti(), gVar.eo()).z();
    }

    public static boolean z(com.ss.android.z.z.dl.dl dlVar) {
        if (dlVar == null) {
            return false;
        }
        return z(dlVar.sy(), dlVar.iq(), dlVar.zw()).z();
    }

    public static boolean g(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.wp.getContext();
        }
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }

    public static boolean z(Context context, String str, String str2) {
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
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i == packageInfo.versionCode;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return false;
        }
    }

    public static boolean m(Context context, String str) {
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
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i <= packageInfo.versionCode;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return false;
        }
    }

    public static Intent e(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static Signature[] gz(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return null;
        }
    }

    public static Signature[] fo(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return null;
        }
    }

    public static boolean z(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i = 0; i < signatureArr.length; i++) {
            Signature signature = signatureArr[i];
            if ((signature == null && signatureArr2[i] != null) || (signature != null && !signature.equals(signatureArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static boolean dl(String str) {
        File file;
        Context context = com.ss.android.downloadlib.addownload.wp.getContext();
        if (TextUtils.isEmpty(str) || !gc(context, str)) {
            return false;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        if (com.ss.android.downloadlib.addownload.wp.fo().optInt("get_ext_dir_mode") == 0 && Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
            return true;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 && com.ss.android.downloadlib.addownload.wp.fo().optInt("get_ext_dir_mode") == 1) {
                file = uy(context, str);
            } else {
                file = new File(Environment.getExternalStorageDirectory().getPath(), "android/data/".concat(String.valueOf(str)));
            }
            if (!file.exists()) {
                return false;
            }
            long jZ = e.z(file);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                if (packageInfo.lastUpdateTime < jZ) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return true;
        }
    }

    public static File uy(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        File file = new File((parentFile != null ? parentFile.getParent() : null) + File.separator + str);
        com.ss.android.socialbase.downloader.m.z.g("ToolUtils", "getExtDir: file.toString()-->" + file.toString());
        return file;
    }

    public static int z(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String z(String str, int i) {
        return i == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static int z(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] strArrSplit = str.split("\\.");
                String[] strArrSplit2 = str2.split("\\.");
                int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
                int i = 0;
                int i2 = 0;
                while (i < iMin) {
                    i2 = Integer.parseInt(strArrSplit[i]) - Integer.parseInt(strArrSplit2[i]);
                    if (i2 != 0) {
                        break;
                    }
                    i++;
                }
                if (i2 != 0) {
                    return i2 > 0 ? 1 : -1;
                }
                for (int i3 = i; i3 < strArrSplit.length; i3++) {
                    if (Integer.parseInt(strArrSplit[i3]) > 0) {
                        return 1;
                    }
                }
                while (i < strArrSplit2.length) {
                    if (Integer.parseInt(strArrSplit2[i]) > 0) {
                        return -1;
                    }
                    i++;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    public static String z(String... strArr) {
        return com.ss.android.z.z.m.g.z(strArr);
    }

    public static <T> T z(T... tArr) {
        if (tArr == null) {
            throw new IllegalArgumentException("args is null");
        }
        for (T t : tArr) {
            if (t != null) {
                return t;
            }
        }
        throw new IllegalArgumentException("args is null");
    }

    public static long g(long j) {
        try {
            return z(Environment.getExternalStorageDirectory(), j);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return j;
        }
    }

    public static boolean z() {
        try {
            if (com.ss.android.downloadlib.addownload.wp.getContext().getPackageManager().getPackageInfo(com.ss.android.downloadlib.addownload.wp.getContext().getPackageName(), 0).applicationInfo.targetSdkVersion >= 33) {
                return Build.VERSION.SDK_INT >= 33;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return false;
        }
    }

    public static long z(File file, long j) {
        if (file == null) {
            return j;
        }
        try {
            return com.ss.android.socialbase.downloader.pf.m.a(file.getAbsolutePath());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return j;
        }
    }

    public static long z(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            return new StatFs(file.getAbsolutePath()).getTotalBytes();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return -1L;
        }
    }

    public static boolean g() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void z(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    public static void dl() {
        try {
            if (com.ss.android.downloadlib.addownload.wp.gc().z(com.ss.android.downloadlib.addownload.wp.getContext(), "android.permission.REORDER_TASKS")) {
                ActivityManager activityManager = (ActivityManager) com.ss.android.downloadlib.addownload.wp.getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
                for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                    if (com.ss.android.downloadlib.addownload.wp.getContext().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    public static HashMap<String, String> g(JSONObject jSONObject) {
        HashMap<String, String> map = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.optString(next));
                }
                return map;
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
        return map;
    }
}
