package com.funny.audio.core.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class MiscUtils {
    public static final String APP_FOLDER_ON_SD = Environment.getExternalStorageDirectory().getAbsolutePath() + "/dt/dt";
    private static final String TAG = "MiscUtils";

    public static boolean checkFsWritable() {
        String str = APP_FOLDER_ON_SD;
        File file = new File(str);
        if (!file.isDirectory() && !file.mkdirs()) {
            return false;
        }
        File file2 = new File(str, ".probe");
        try {
            if (file2.exists()) {
                file2.delete();
            }
            if (!file2.createNewFile()) {
                return false;
            }
            file2.delete();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean hasStorage() {
        if (Environment.getExternalStorageState().equalsIgnoreCase("mounted")) {
            return checkFsWritable();
        }
        return false;
    }

    public static void updateFileTime(String dir, String fileName) {
        new File(dir, fileName).setLastModified(System.currentTimeMillis());
    }

    public static boolean checkNet(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
    }

    public static String getAPN(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "";
        }
        if (1 == activeNetworkInfo.getType()) {
            String typeName = activeNetworkInfo.getTypeName();
            return typeName == null ? "wifi" : typeName;
        }
        String lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
        return lowerCase == null ? "mobile" : lowerCase;
    }

    public static String getModel(Context context) {
        return Build.MODEL;
    }

    public static String getManufacturer(Context context) {
        return Build.MANUFACTURER;
    }

    public static String getFirmware(Context context) {
        return Build.VERSION.RELEASE;
    }

    public static String getSDKVer() {
        return Integer.valueOf(Build.VERSION.SDK_INT).toString();
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getLanguage() {
        String language = Locale.getDefault().getLanguage();
        return android.text.TextUtils.isEmpty(language) ? "" : language;
    }

    public static String getCountry() {
        String country = Locale.getDefault().getCountry();
        return android.text.TextUtils.isEmpty(country) ? "" : country;
    }

    public static String getIMEI(Context context) {
        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        return (android.text.TextUtils.isEmpty(deviceId) || deviceId.equals("000000000000000")) ? "0" : deviceId;
    }

    public static String getIMSI(Context context) {
        String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        return android.text.TextUtils.isEmpty(subscriberId) ? "0" : subscriberId;
    }

    public static String getMcnc(Context context) {
        String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        return android.text.TextUtils.isEmpty(networkOperator) ? "0" : networkOperator;
    }

    public static int getPhoneSDK(Context mContext) {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (Exception e) {
            e.printStackTrace();
            return 7;
        }
    }

    public static Object getMetaData(Context context, String keyName) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(keyName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Integer getAppVersionCode(Context context) {
        try {
            return Integer.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getPackageName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getSerialNumber(Context context) {
        String str = null;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
            if (str2 != null) {
                try {
                    if (str2.trim().length() > 0) {
                        return str2;
                    }
                } catch (Exception e) {
                    e = e;
                    str = str2;
                    e.printStackTrace();
                    return str;
                }
            }
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e2) {
            e = e2;
        }
    }

    public boolean isSDCardSizeOverflow() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockCount = statFs.getBlockCount();
            long blockSize = statFs.getBlockSize();
            long availableBlocks = statFs.getAvailableBlocks();
            statFs.getFreeBlocks();
            long j = ((blockCount * blockSize) / 1024) / 1024;
            if (((availableBlocks * blockSize) / 1024) / 1024 <= 1) {
                return true;
            }
        }
        return false;
    }
}
