package com.umeng.message.common;

import android.app.AppOpsManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.PushAgent;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.h;
import com.umeng.message.proguard.l;
import com.ut.device.UTDevice;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Locale;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes3.dex */
public class UmengMessageDeviceConfig {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String a = "DeviceConfig";
    private static String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f20277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Boolean f20278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f20279e;

    private static String a(Context context) {
        return DeviceConfig.getImeiNew(context);
    }

    private static Locale b(Context context) {
        Locale locale;
        try {
            Configuration configuration = new Configuration();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            locale = configuration.locale;
        } catch (Exception unused) {
            UPLog.e(a, "fail to read user config locale");
            locale = null;
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    public static String getAndroidId(Context context) {
        return DeviceConfig.getAndroidId(context);
    }

    public static String getAppVersionCode(Context context) {
        return UMUtils.getAppVersionCode(context);
    }

    public static String getAppVersionName(Context context) {
        return UMUtils.getAppVersionName(context);
    }

    public static String getCPU() {
        return UMUtils.getCPU();
    }

    public static String getChannel(Context context) {
        String channelByXML = UMUtils.getChannelByXML(context);
        return !TextUtils.isEmpty(channelByXML) ? channelByXML : "Unknown";
    }

    public static String getDeviceIDAes(Context context) {
        String deviceId;
        try {
            deviceId = getDeviceId(context);
        } catch (Exception e2) {
            e = e2;
            deviceId = "";
        }
        try {
            if (TextUtils.isEmpty(deviceId)) {
                return "";
            }
            String messageAppkey = PushAgent.getInstance(context).getMessageAppkey();
            return (messageAppkey == null || 24 != messageAppkey.length()) ? h.a(deviceId, "") : h.a(deviceId, messageAppkey.substring(0, 16));
        } catch (Exception e3) {
            e = e3;
            UPLog.i(a, "getDeviceIDAes:" + e.getMessage());
            return deviceId;
        }
    }

    public static String getDeviceId(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        b = a(context);
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        b = getAndroidId(context);
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        b = getSerial();
        if (TextUtils.isEmpty(b)) {
            b = "";
        }
        return b;
    }

    public static String getDeviceIdMD5(Context context) {
        return l.a(getDeviceId(context));
    }

    public static String getDummyId() {
        return "02:00:00:00:00:00";
    }

    public static String getImeiAes(Context context) {
        String strA;
        try {
            strA = a(context);
        } catch (Exception e2) {
            e = e2;
            strA = "";
        }
        try {
            if (TextUtils.isEmpty(strA)) {
                return "";
            }
            String messageAppkey = PushAgent.getInstance(context).getMessageAppkey();
            return (messageAppkey == null || 24 != messageAppkey.length()) ? h.a(strA, "") : h.a(strA, messageAppkey.substring(0, 16));
        } catch (Exception e3) {
            e = e3;
            UPLog.i(a, "getDINAes:" + e.getMessage());
            return strA;
        }
    }

    public static String getImeiMd5(Context context) {
        String strA = a(context);
        return TextUtils.isEmpty(strA) ? "" : l.a(strA);
    }

    public static String[] getLocaleInfo(Context context) {
        String[] strArr = new String[2];
        try {
            Locale localeB = b(context);
            strArr[0] = localeB.getCountry();
            strArr[1] = localeB.getLanguage();
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (Exception e2) {
            UPLog.i(a, "error in getLocaleInfo", e2.getMessage());
            return strArr;
        }
    }

    public static String getMetaData(Context context, String str) {
        String string;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (string = applicationInfo.metaData.getString(str)) != null) {
                return string.trim();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        UPLog.e(a, String.format("Could not read meta-data %s from AndroidManifest.xml.", str));
        return null;
    }

    public static String[] getNetworkAccessMode(Context context) {
        return UMUtils.getNetworkAccessMode(context);
    }

    public static String getOperator(Context context) {
        try {
            return UMUtils.getOperator(context);
        } catch (Throwable unused) {
            return "Unknown";
        }
    }

    public static String getResolution(Context context) {
        int iA;
        int iA2;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if ((context.getApplicationInfo().flags & 8192) == 0) {
                iA = a(displayMetrics, "noncompatWidthPixels");
                iA2 = a(displayMetrics, "noncompatHeightPixels");
            } else {
                iA = -1;
                iA2 = -1;
            }
            if (iA == -1 || iA2 == -1) {
                iA = displayMetrics.widthPixels;
                iA2 = displayMetrics.heightPixels;
            }
            return iA + "*" + iA2;
        } catch (Exception e2) {
            UPLog.w(a, "read resolution fail", e2.getMessage());
            return "Unknown";
        }
    }

    public static String getSerial() {
        return DeviceConfig.getSerial();
    }

    public static int getTimeZone(Context context) {
        try {
            return Calendar.getInstance(b(context)).getTimeZone().getRawOffset() / BaseConstants.Time.HOUR;
        } catch (Exception e2) {
            UPLog.i(a, "error in getTimeZone", e2.getMessage());
            return 8;
        }
    }

    public static String getUiOs() {
        String str = f20279e;
        if (str != null) {
            return str;
        }
        if (!AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO.equalsIgnoreCase(TextUtils.isEmpty(Build.BRAND) ? Build.MANUFACTURER : Build.BRAND)) {
            f20279e = "";
            return f20279e;
        }
        f20279e = a("ro.vivo.os.build.display.id");
        if (!TextUtils.isEmpty(f20279e)) {
            return f20279e;
        }
        f20279e = a("ro.iqoo.os.build.display.id");
        if (!TextUtils.isEmpty(f20279e)) {
            return f20279e;
        }
        f20279e = "";
        return f20279e;
    }

    public static String getUmid(Context context) {
        String uMId = UMUtils.getUMId(context);
        return uMId == null ? "" : uMId;
    }

    public static String getUtdid(Context context) {
        try {
            return UTDevice.getUtdid(context);
        } catch (Throwable th) {
            UPLog.e(a, "utdid failed:" + th.getMessage());
            return "";
        }
    }

    public static boolean isMi8() {
        Boolean bool = f20277c;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI.equalsIgnoreCase(TextUtils.isEmpty(Build.BRAND) ? Build.MANUFACTURER : Build.BRAND)) {
            f20277c = false;
            return false;
        }
        String strA = a("ro.miui.ui.version.name");
        if (strA != null && strA.contains("8")) {
            f20277c = true;
            return true;
        }
        f20277c = false;
        return false;
    }

    public static String isNotificationEnabled(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT < 26) {
                return isNotificationEnabled(context);
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
            if (!notificationManager.areNotificationsEnabled()) {
                return String.valueOf(false);
            }
            if (TextUtils.isEmpty(str)) {
                return String.valueOf(true);
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
            if (notificationChannel != null) {
                return String.valueOf(notificationChannel.getImportance() != 0);
            }
            return "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static boolean isOnline(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean isVivo() {
        Boolean bool = f20278d;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO.equalsIgnoreCase(TextUtils.isEmpty(Build.BRAND) ? Build.MANUFACTURER : Build.BRAND)) {
            f20278d = true;
            return true;
        }
        String uiOs = getUiOs();
        if (TextUtils.isEmpty(uiOs)) {
            f20278d = false;
            return false;
        }
        if (uiOs.startsWith("OriginOS") || uiOs.startsWith("Funtouch")) {
            f20278d = true;
            return true;
        }
        f20278d = false;
        return false;
    }

    private static int a(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String isNotificationEnabled(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            try {
                return String.valueOf(((NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION)).areNotificationsEnabled());
            } catch (Throwable unused) {
            }
        } else if (i2 >= 19) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i3 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                return String.valueOf(((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(appOpsManager)).intValue()), Integer.valueOf(i3), packageName)).intValue() == 0);
            } catch (Exception unused2) {
                UPLog.e(a, "检测通知开关是否打开异常");
            }
        }
        return "unknown";
    }
}
