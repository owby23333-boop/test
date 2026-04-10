package com.xuexiang.xupdate.utils;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.xuexiang.xupdate.R;
import com.xuexiang.xupdate.XUpdate;
import com.xuexiang.xupdate._XUpdate;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.logs.UpdateLog;
import com.xuexiang.xupdate.proxy.IUpdateProxy;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdateUtils {
    private static final String IGNORE_VERSION = "xupdate_ignore_version";
    private static final String KEY_XUPDATE = "xupdate";
    private static final String PREFS_FILE = "xupdate_prefs";

    private UpdateUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void processUpdateEntity(UpdateEntity updateEntity, String str, IUpdateProxy iUpdateProxy) throws Exception {
        if (updateEntity != null) {
            if (updateEntity.isHasUpdate()) {
                if (updateEntity.isIgnorable() && isIgnoreVersion(iUpdateProxy.getContext(), updateEntity.getVersionName())) {
                    _XUpdate.onUpdateError(2007);
                    return;
                } else if (TextUtils.isEmpty(updateEntity.getApkCacheDir())) {
                    _XUpdate.onUpdateError(2008);
                    return;
                } else {
                    iUpdateProxy.findNewVersion(updateEntity, iUpdateProxy);
                    return;
                }
            }
            UpdateLog.i("未发现新版本, 解析后的版本更新信息如下:" + updateEntity);
            iUpdateProxy.noNewVersion(null);
            return;
        }
        _XUpdate.onUpdateError(2006, "json:" + str);
    }

    public static <T> T requireNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean checkWifi() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) XUpdate.getContext().getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }

    public static boolean checkNetwork() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) XUpdate.getContext().getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public static int getVersionCode(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    public static String getVersionName(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        return packageInfo != null ? packageInfo.versionName : "";
    }

    public static int compareVersionName(String str, String str2) {
        if (str.equals(str2)) {
            return 0;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        int length = 0;
        for (int i = 0; i < iMin; i++) {
            length = strArrSplit[i].length() - strArrSplit2[i].length();
            if (length != 0 || (length = strArrSplit[i].compareTo(strArrSplit2[i])) != 0) {
                break;
            }
        }
        return length != 0 ? length : strArrSplit.length - strArrSplit2.length;
    }

    public static int dip2px(int i, Context context) {
        return (int) ((i * getDensity(context)) + 0.5f);
    }

    private static float getDensity(Context context) {
        return getDisplayMetrics(context).density;
    }

    private static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static Bitmap drawable2Bitmap(Drawable drawable) {
        Bitmap bitmapCreateBitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmapCreateBitmap = Bitmap.createBitmap(1, 1, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private static SharedPreferences getSP(Context context) {
        return context.getSharedPreferences(PREFS_FILE, 0);
    }

    public static void saveIgnoreVersion(Context context, String str) {
        getSP(context).edit().putString(IGNORE_VERSION, str).apply();
    }

    public static boolean isIgnoreVersion(Context context, String str) {
        return getSP(context).getString(IGNORE_VERSION, "").equals(str);
    }

    public static String getDisplayUpdateInfo(Context context, UpdateEntity updateEntity) {
        String strByte2FitMemorySize = byte2FitMemorySize(updateEntity.getSize() * 1024);
        String updateContent = updateEntity.getUpdateContent();
        String str = !TextUtils.isEmpty(strByte2FitMemorySize) ? context.getString(R.string.xupdate_lab_new_version_size) + strByte2FitMemorySize + "\n" : "";
        return !TextUtils.isEmpty(updateContent) ? str + updateContent : str;
    }

    private static String byte2FitMemorySize(long j) {
        if (j <= 0) {
            return "";
        }
        if (j < 1024) {
            return String.format("%.1fB", Double.valueOf(j));
        }
        if (j < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return String.format("%.1fKB", Double.valueOf(j / 1024.0d));
        }
        if (j < 1073741824) {
            return String.format("%.1fMB", Double.valueOf(j / 1048576.0d));
        }
        return String.format("%.1fGB", Double.valueOf(j / 1.073741824E9d));
    }

    public static boolean isApkDownloaded(UpdateEntity updateEntity) {
        File apkFileByUpdateEntity = getApkFileByUpdateEntity(updateEntity);
        return !TextUtils.isEmpty(updateEntity.getMd5()) && FileUtils.isFileExists(apkFileByUpdateEntity) && _XUpdate.isFileValid(updateEntity.getMd5(), apkFileByUpdateEntity);
    }

    public static File getApkFileByUpdateEntity(UpdateEntity updateEntity) {
        return new File(updateEntity.getApkCacheDir().concat(File.separator + updateEntity.getVersionName()).concat(File.separator + getApkNameByDownloadUrl(updateEntity.getDownloadUrl())));
    }

    public static String getApkNameByDownloadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "temp_" + System.currentTimeMillis() + ".apk";
        }
        String strSubstring = str.substring(str.lastIndexOf("/") + 1);
        return !strSubstring.endsWith(".apk") ? "temp_" + System.currentTimeMillis() + ".apk" : strSubstring;
    }

    public static String getDiskCacheDir(Context context, String str) {
        String path;
        if (isSDCardEnable() && context.getExternalCacheDir() != null) {
            path = context.getExternalCacheDir().getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return path + File.separator + str;
    }

    public static File getDefaultDiskCacheDir() {
        return FileUtils.getFileByPath(getDefaultDiskCacheDirPath());
    }

    public static boolean isPrivateApkCacheDir(UpdateEntity updateEntity) {
        return FileUtils.isPrivatePath(XUpdate.getContext(), updateEntity.getApkCacheDir());
    }

    public static String getDefaultDiskCacheDirPath() {
        return getDiskCacheDir(XUpdate.getContext(), KEY_XUPDATE);
    }

    private static boolean isSDCardEnable() {
        return "mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable();
    }

    private static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAppName(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        return packageInfo != null ? packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString() : "";
    }

    public static Drawable getAppIcon(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        if (packageInfo != null) {
            return packageInfo.applicationInfo.loadIcon(context.getPackageManager());
        }
        return null;
    }

    public static boolean isAppOnForeground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        String packageName = context.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean startActivity(Intent intent) {
        if (intent == null) {
            UpdateLog.e("[startActivity failed]: intent == null");
            return false;
        }
        if (XUpdate.getContext().getPackageManager().resolveActivity(intent, 65536) != null) {
            try {
                intent.addFlags(268435456);
                XUpdate.getContext().startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                UpdateLog.e(e);
            }
        } else {
            UpdateLog.e("[resolveActivity failed]: " + (intent.getComponent() != null ? intent.getComponent().getClassName() : intent.getAction()) + " do not register in manifest");
        }
        return false;
    }
}
