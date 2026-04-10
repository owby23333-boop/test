package com.qmuiteam.qmui.util;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qmuiteam.qmui.QMUILog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIDeviceHelper {
    private static final String CPU_FILE_PATH_0 = "/sys/devices/system/cpu/";
    private static final String CPU_FILE_PATH_1 = "/sys/devices/system/cpu/possible";
    private static final String CPU_FILE_PATH_2 = "/sys/devices/system/cpu/present";
    private static final String ESSENTIAL = "essential";
    private static final String FLYME = "flyme";
    private static final String KEY_FLYME_VERSION_NAME = "ro.build.display.id";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String POWER_PROFILE_CLASS = "com.android.internal.os.PowerProfile";
    private static final String TAG = "QMUIDeviceHelper";
    private static final String ZTEC2016 = "zte c2016";
    private static final String ZUKZ1 = "zuk z1";
    private static String sFlymeVersionName;
    private static String sMiuiVersionName;
    private static final String[] MEIZUBOARD = {"m9", "M9", "mx", "MX"};
    private static FileFilter CPU_FILTER = new FileFilter() { // from class: com.qmuiteam.qmui.util.QMUIDeviceHelper.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    };
    private static boolean sIsTabletChecked = false;
    private static boolean sIsTabletValue = false;
    private static final String BRAND = Build.BRAND.toLowerCase();
    private static long sTotalMemory = -1;
    private static long sInnerStorageSize = -1;
    private static long sExtraStorageSize = -1;
    private static double sBatteryCapacity = -1.0d;
    private static int sCpuCoreCount = -1;

    static {
        Properties properties = new Properties();
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            sMiuiVersionName = getLowerCaseName(properties, declaredMethod, "ro.miui.ui.version.name");
            sFlymeVersionName = getLowerCaseName(properties, declaredMethod, KEY_FLYME_VERSION_NAME);
        } catch (Exception e) {
            QMUILog.printErrStackTrace(TAG, e, "read SystemProperties error", new Object[0]);
        }
    }

    private static boolean _isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static boolean isTablet(Context context) {
        if (sIsTabletChecked) {
            return sIsTabletValue;
        }
        boolean z_isTablet = _isTablet(context);
        sIsTabletValue = z_isTablet;
        sIsTabletChecked = true;
        return z_isTablet;
    }

    public static boolean isFlyme() {
        return !TextUtils.isEmpty(sFlymeVersionName) && sFlymeVersionName.contains(FLYME);
    }

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(sMiuiVersionName);
    }

    public static boolean isMIUIV5() {
        return "v5".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV6() {
        return "v6".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV7() {
        return "v7".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV8() {
        return "v8".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV9() {
        return "v9".equals(sMiuiVersionName);
    }

    public static boolean isFlymeLowerThan(int i) {
        return isFlymeLowerThan(i, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isFlymeLowerThan(int r6, int r7, int r8) {
        /*
            java.lang.String r0 = com.qmuiteam.qmui.util.QMUIDeviceHelper.sFlymeVersionName
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L5d
            java.lang.String r3 = ""
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L5d
            java.lang.String r0 = "(\\d+\\.){2}\\d"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = com.qmuiteam.qmui.util.QMUIDeviceHelper.sFlymeVersionName     // Catch: java.lang.Throwable -> L5d
            java.util.regex.Matcher r0 = r0.matcher(r3)     // Catch: java.lang.Throwable -> L5d
            boolean r3 = r0.find()     // Catch: java.lang.Throwable -> L5d
            if (r3 == 0) goto L5d
            java.lang.String r0 = r0.group()     // Catch: java.lang.Throwable -> L5d
            int r3 = r0.length()     // Catch: java.lang.Throwable -> L5d
            if (r3 <= 0) goto L5d
            java.lang.String r3 = "\\."
            java.lang.String[] r0 = r0.split(r3)     // Catch: java.lang.Throwable -> L5d
            int r3 = r0.length     // Catch: java.lang.Throwable -> L5d
            if (r3 < r1) goto L3d
            r3 = r0[r2]     // Catch: java.lang.Throwable -> L5d
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.Throwable -> L5d
            if (r3 >= r6) goto L3d
            r3 = r1
            goto L3e
        L3d:
            r3 = r2
        L3e:
            int r4 = r0.length     // Catch: java.lang.Throwable -> L5e
            r5 = 2
            if (r4 < r5) goto L4d
            if (r7 <= 0) goto L4d
            r7 = r0[r1]     // Catch: java.lang.Throwable -> L5e
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Throwable -> L5e
            if (r7 >= r6) goto L4d
            r3 = r1
        L4d:
            int r7 = r0.length     // Catch: java.lang.Throwable -> L5e
            r4 = 3
            if (r7 < r4) goto L5e
            if (r8 <= 0) goto L5e
            r7 = r0[r5]     // Catch: java.lang.Throwable -> L5e
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Throwable -> L5e
            if (r7 >= r6) goto L5e
            r3 = r1
            goto L5e
        L5d:
            r3 = r2
        L5e:
            boolean r6 = isMeizu()
            if (r6 == 0) goto L67
            if (r3 == 0) goto L67
            goto L68
        L67:
            r1 = r2
        L68:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qmuiteam.qmui.util.QMUIDeviceHelper.isFlymeLowerThan(int, int, int):boolean");
    }

    public static boolean isMeizu() {
        return isPhone(MEIZUBOARD) || isFlyme();
    }

    public static boolean isXiaomi() {
        return Build.MANUFACTURER.toLowerCase().equals(MediationConstant.ADN_XIAOMI);
    }

    public static boolean isVivo() {
        String str = BRAND;
        return str.contains("vivo") || str.contains("bbk");
    }

    public static boolean isOppo() {
        return BRAND.contains("oppo");
    }

    public static boolean isHuawei() {
        String str = BRAND;
        return str.contains("huawei") || str.contains("honor");
    }

    public static boolean isEssentialPhone() {
        return BRAND.contains(ESSENTIAL);
    }

    public static boolean isZUKZ1() {
        String str = Build.MODEL;
        return str != null && str.toLowerCase().contains(ZUKZ1);
    }

    public static boolean isZTKC2016() {
        String str = Build.MODEL;
        return str != null && str.toLowerCase().contains(ZTEC2016);
    }

    private static boolean isPhone(String[] strArr) {
        String str = Build.BOARD;
        if (str == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static long getTotalMemory(Context context) {
        long j = sTotalMemory;
        if (j != -1) {
            return j;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            sTotalMemory = memoryInfo.totalMem;
        }
        return sTotalMemory;
    }

    public static long getInnerStorageSize() {
        long j = sInnerStorageSize;
        if (j != -1) {
            return j;
        }
        File dataDirectory = Environment.getDataDirectory();
        if (dataDirectory == null) {
            return 0L;
        }
        long totalSpace = dataDirectory.getTotalSpace();
        sInnerStorageSize = totalSpace;
        return totalSpace;
    }

    public static boolean hasExtraStorage() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static long getExtraStorageSize() {
        long j = sExtraStorageSize;
        if (j != -1) {
            return j;
        }
        if (!hasExtraStorage()) {
            return 0L;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long blockSizeLong = statFs.getBlockSizeLong() * statFs.getBlockCountLong();
        sExtraStorageSize = blockSizeLong;
        return blockSizeLong;
    }

    public static long getTotalStorageSize() {
        return getInnerStorageSize() + getExtraStorageSize();
    }

    public static int getCpuCoreCount() throws Throwable {
        int coresFromFile;
        int i = sCpuCoreCount;
        if (i != -1) {
            return i;
        }
        try {
            coresFromFile = getCoresFromFile(CPU_FILE_PATH_1);
            if (coresFromFile == 0) {
                coresFromFile = getCoresFromFile(CPU_FILE_PATH_2);
            }
            if (coresFromFile == 0) {
                coresFromFile = getCoresFromCPUFiles(CPU_FILE_PATH_0);
            }
        } catch (Exception unused) {
            coresFromFile = 0;
        }
        if (coresFromFile == 0) {
            coresFromFile = 1;
        }
        sCpuCoreCount = coresFromFile;
        return coresFromFile;
    }

    private static int getCoresFromCPUFiles(String str) {
        File[] fileArrListFiles = new File(str).listFiles(CPU_FILTER);
        if (fileArrListFiles == null) {
            return 0;
        }
        return fileArrListFiles.length;
    }

    private static int getCoresFromFile(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (IOException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
            String line = bufferedReader.readLine();
            bufferedReader.close();
            if (line != null && line.matches("0-[\\d]+$")) {
                int i = Integer.parseInt(line.substring(2)) + 1;
                QMUILangHelper.close(fileInputStream);
                return i;
            }
            QMUILangHelper.close(fileInputStream);
            return 0;
        } catch (IOException unused2) {
            fileInputStream2 = fileInputStream;
            QMUILangHelper.close(fileInputStream2);
            return 0;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            QMUILangHelper.close(fileInputStream2);
            throw th;
        }
    }

    public static boolean isFloatWindowOpAllowed(Context context) {
        return checkOp(context, 24);
    }

    public static double getBatteryCapacity(Context context) {
        double d = sBatteryCapacity;
        double dDoubleValue = -1.0d;
        if (d != -1.0d) {
            return d;
        }
        try {
            Class<?> cls = Class.forName(POWER_PROFILE_CLASS);
            dDoubleValue = ((Double) cls.getMethod("getBatteryCapacity", new Class[0]).invoke(cls.getConstructor(Context.class).newInstance(context), new Object[0])).doubleValue();
        } catch (Exception unused) {
        }
        sBatteryCapacity = dDoubleValue;
        return dDoubleValue;
    }

    private static boolean checkOp(Context context, int i) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            return ((Integer) appOpsManager.getClass().getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String getLowerCaseName(Properties properties, Method method, String str) {
        String property = properties.getProperty(str);
        if (property == null) {
            try {
                property = (String) method.invoke(null, str);
            } catch (Exception unused) {
            }
        }
        return property != null ? property.toLowerCase() : property;
    }
}
