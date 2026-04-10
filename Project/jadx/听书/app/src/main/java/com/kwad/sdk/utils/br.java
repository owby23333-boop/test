package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.funny.audio.core.utils.FileUtils;
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public final class br {
    private static String baZ = null;
    private static String bba = "";
    private static boolean bbb = false;
    private static String bbc = "";
    private static String bbd = "";
    private static int bbe = 0;
    private static boolean bbf = false;
    private static int bbg = 0;
    private static boolean bbh = false;
    private static String bbj = "";
    private static String bbk = "";
    private static String bbl = "";
    private static String bbm = null;
    private static String bbn = null;
    private static int bbo = -1;
    private static boolean bbp = false;
    private static boolean bbq = false;
    private static boolean bbr = false;
    private static boolean bbs = false;
    private static boolean bbt = false;
    private static boolean bbu = false;
    private static int bbv = 0;
    private static long bbw = 0;
    private static String bbx = "";
    private static String bby = "";
    public static String bbz = "";
    private static final String[] bbi = {"", ""};
    private static final List<String> bbA = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    public static int dR(Context context) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(512L)) {
            return 0;
        }
        try {
            return ((BatteryManager) context.getApplicationContext().getSystemService("batterymanager")).getIntProperty(4);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long RP() {
        return com.kwad.sdk.crash.utils.h.L(Environment.getDataDirectory());
    }

    public static long RQ() {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(1024L)) {
            return 0L;
        }
        return com.kwad.sdk.crash.utils.h.K(Environment.getDataDirectory());
    }

    private static long RN() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!line.contains("MemTotal"));
            long jLongValue = Long.valueOf(line.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return jLongValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static long dS(Context context) throws Throwable {
        long j = bbw;
        if (j > 0) {
            return j;
        }
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long jRN = memoryInfo.totalMem;
            if (jRN <= 0) {
                jRN = RN();
            }
            bbw = jRN;
            return jRN;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long dO(Context context) {
        if (context == null || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(1024L)) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long RR() {
        long jFreeMemory;
        try {
            jFreeMemory = Runtime.getRuntime().freeMemory();
        } catch (Throwable unused) {
        }
        if (jFreeMemory > 0) {
            return jFreeMemory;
        }
        return 0L;
    }

    public static int RS() {
        int i = bbv;
        if (i > 0) {
            return i;
        }
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        bbv = iAvailableProcessors;
        return iAvailableProcessors;
    }

    public static String w(Context context, boolean z) {
        if (bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei())) {
            return bc.getDevImei();
        }
        String strDT = dT(context);
        return (TextUtils.isEmpty(strDT) && !z && TextUtils.isEmpty(com.kwad.sdk.core.e.a.getAppOAID(context))) ? ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Bz() : strDT;
    }

    private static synchronized String dT(Context context) {
        boolean zDN;
        if (bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei())) {
            return bc.getDevImei();
        }
        if (bbp) {
            return bbc;
        }
        if (TextUtils.isEmpty(bbc) && context != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return bbc;
            }
            if (bc.usePhoneStateDisable()) {
                return bbc;
            }
            if (!s.PY()) {
                return bbc;
            }
            try {
                zDN = SystemUtil.dN(context);
                if (zDN) {
                    try {
                        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                        bbc = deviceId;
                        if (TextUtils.isEmpty(deviceId)) {
                            bbp = true;
                        }
                    } catch (Exception e) {
                        e = e;
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                        if (zDN) {
                            bbp = true;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zDN = false;
            }
            return bbc;
        }
        return bbc;
    }

    public static synchronized String dU(Context context) {
        boolean zDN;
        if (bbu) {
            return bbd;
        }
        if (TextUtils.isEmpty(bbd) && context != null) {
            if (bc.usePhoneStateDisable()) {
                return bbd;
            }
            if (!s.PX()) {
                return bbl;
            }
            try {
                zDN = SystemUtil.dN(context);
                if (zDN) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager != null) {
                            String meid = telephonyManager.getMeid();
                            bbd = meid;
                            if (TextUtils.isEmpty(meid)) {
                                bbu = true;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                        if (zDN) {
                            bbu = true;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zDN = false;
            }
            return bbd;
        }
        return bbd;
    }

    public static synchronized String[] dV(Context context) {
        if (bc.usePhoneStateDisable() && bc.getDevImeis() != null) {
            return bc.getDevImeis();
        }
        if (bbt) {
            return bbi;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return bbi;
        }
        String[] strArr = bbi;
        boolean z = false;
        if (TextUtils.isEmpty(strArr[0]) && TextUtils.isEmpty(strArr[1]) && context != null) {
            if (bc.usePhoneStateDisable()) {
                return strArr;
            }
            if (!s.PY()) {
                return strArr;
            }
            try {
                boolean zDN = SystemUtil.dN(context);
                if (zDN) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager != null) {
                            int iMin = Math.min(dW(context), 2);
                            for (int i = 0; i < iMin; i++) {
                                bbi[i] = telephonyManager.getImei(i);
                            }
                            String[] strArr2 = bbi;
                            if (TextUtils.isEmpty(strArr2[0]) && TextUtils.isEmpty(strArr2[1])) {
                                bbt = true;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        z = zDN;
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        if (z) {
                            bbt = true;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
            return bbi;
        }
        return strArr;
    }

    public static synchronized int dW(Context context) {
        if (bbf || bbe > 0 || context == null || bc.usePhoneStateDisable()) {
            return bbe;
        }
        try {
            bbe = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
        } catch (Exception unused) {
        }
        int i = bbe;
        bbf = i == 0;
        return i;
    }

    public static int dX(Context context) {
        if (context == null || bbg > 0 || bbh || !SystemUtil.dN(context) || bc.usePhoneStateDisable()) {
            return bbg;
        }
        try {
            bbg = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
        } catch (Throwable unused) {
        }
        int i = bbg;
        bbh = i != 0;
        return i;
    }

    public static synchronized String dt(Context context) {
        if (context != null) {
            if (!bbq && TextUtils.isEmpty(bbj) && SystemUtil.dN(context) && !bc.usePhoneStateDisable() && s.PZ()) {
                try {
                    bbj = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                } catch (Exception unused) {
                }
                bbq = TextUtils.isEmpty(bbj);
                return bbj;
            }
        }
        return bbj;
    }

    public static int checkSelfPermission(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static String dY(Context context) {
        if (!TextUtils.isEmpty(bbk) || context == null) {
            return bbk;
        }
        if (bbr) {
            return bbk;
        }
        if (bc.usePhoneStateDisable()) {
            return bbk;
        }
        if (!s.Qa()) {
            return bbk;
        }
        try {
            if (SystemUtil.dN(context)) {
                bbk = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            bbk = null;
        }
        if (TextUtils.isEmpty(bbk)) {
            bbr = true;
        }
        String str = TextUtils.isEmpty(bbk) ? "" : bbk;
        bbk = str;
        return str;
    }

    public static String getLocale() {
        Locale locale = LocaleList.getDefault().get(0);
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    public static String RT() {
        return Build.MODEL;
    }

    public static synchronized long RU() {
        long j;
        j = (!bc.usePhoneStateDisable() || (TextUtils.isEmpty(bc.getDevImei()) && bc.getDevImeis() == null)) ? 0L : 1L;
        if (bc.readLocationDisable() && bc.Ro() != null) {
            j |= 64;
        }
        if (bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevAndroidId())) {
            j |= 2;
        }
        if (bc.useMacAddressDisable() && !TextUtils.isEmpty(bc.getDevMacAddress())) {
            j |= 4;
        }
        if (bc.useOaidDisable() && !TextUtils.isEmpty(bc.getDevOaid())) {
            j |= 2048;
        }
        if (bc.readInstalledPackagesDisable()) {
            if (bc.getDevInstalledPackages() != null) {
                j |= 16;
            }
        }
        return j;
    }

    public static String RV() {
        return Build.BRAND;
    }

    public static String RW() {
        return Build.CPU_ABI;
    }

    public static synchronized int dZ(Context context) {
        try {
        } catch (Exception unused) {
            return -1;
        }
        return ((AudioManager) context.getSystemService("audio")).getRingerMode();
    }

    public static synchronized long RX() {
        return SystemClock.elapsedRealtime() / 1000;
    }

    public static synchronized long RY() {
        return Build.TIME;
    }

    public static synchronized String RZ() {
        return Build.FINGERPRINT;
    }

    public static synchronized String Sa() {
        if (!TextUtils.isEmpty(baZ)) {
            return baZ;
        }
        String radioVersion = Build.getRadioVersion();
        baZ = radioVersion;
        return radioVersion;
    }

    public static synchronized String Sb() {
        return bb.getName();
    }

    public static synchronized String Sc() {
        return bb.getVersion();
    }

    public static String Sd() {
        return Build.MANUFACTURER;
    }

    public static int Se() {
        if (bbo == -1) {
            bbo = ea(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()) ? 4 : 3;
        }
        return bbo;
    }

    public static String Sf() {
        if (TextUtils.isEmpty(bbn)) {
            try {
                bbn = System.getProperty("os.arch");
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }
        return bbn;
    }

    private static boolean ea(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int Sg() {
        return Build.VERSION.SDK_INT;
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static int getScreenWidth(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT >= 35) {
                WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Rect bounds = currentWindowMetrics.getBounds();
                Insets insets = currentWindowMetrics.getWindowInsets().getInsets(WindowInsets.Type.systemBars());
                return (bounds.width() - insets.left) - insets.right;
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenHeight(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT >= 35) {
                WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Rect bounds = currentWindowMetrics.getBounds();
                Insets insets = currentWindowMetrics.getWindowInsets().getInsets(WindowInsets.Type.systemBars());
                return (bounds.height() - insets.top) - insets.bottom;
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String Sh() {
        Enumeration<NetworkInterface> networkInterfaces;
        if (bc.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(8L)) {
            return "";
        }
        if (TextUtils.isEmpty(bbz)) {
            return bbz;
        }
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (Throwable unused) {
        }
        while (networkInterfaces.hasMoreElements()) {
            Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddressNextElement = inetAddresses.nextElement();
                if ((inetAddressNextElement instanceof Inet4Address) && !inetAddressNextElement.isLoopbackAddress()) {
                    String hostAddress = inetAddressNextElement.getHostAddress();
                    bbz = hostAddress;
                    return hostAddress;
                }
                return "";
            }
        }
        return "";
    }

    public static String dp(Context context) {
        if (!TextUtils.isEmpty(bbl) || context == null || bbs) {
            return bbl;
        }
        if (bc.usePhoneStateDisable()) {
            return bc.getDevAndroidId();
        }
        if (!s.PS()) {
            return bbl;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            bbl = string;
            if (!hx(string)) {
                bbl = "";
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(bbl)) {
            bbs = true;
        }
        return bbl;
    }

    public static synchronized String eb(Context context) {
        if (TextUtils.isEmpty(bba) && context != null && !bbb) {
            if (bc.useMacAddressDisable()) {
                String devMacAddress = bc.getDevMacAddress();
                bba = devMacAddress;
                return devMacAddress;
            }
            if (!s.PT()) {
                return bba;
            }
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    bba = connectionInfo.getMacAddress();
                }
                if (hv(bba)) {
                    Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface != null && "wlan0".equals(networkInterface.getName())) {
                            byte[] hardwareAddress = networkInterface.getHardwareAddress();
                            if (hardwareAddress != null && hardwareAddress.length != 0) {
                                StringBuilder sb = new StringBuilder();
                                for (byte b : hardwareAddress) {
                                    sb.append(String.format("%02X:", Byte.valueOf(b)));
                                }
                                if (sb.length() > 0) {
                                    sb.deleteCharAt(sb.length() - 1);
                                }
                                bba = sb.toString();
                            }
                        }
                    }
                }
                if (hv(bba)) {
                    bba = com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                }
                if (!hv(bba)) {
                    bba = bba.toUpperCase(Locale.US);
                }
            } catch (Exception unused) {
                bbb = true;
            }
            bbb = hv(bba);
            return bba;
        }
        return bba;
    }

    private static boolean hv(String str) {
        return TextUtils.isEmpty(str) || str.equals("02:00:00:00:00:00");
    }

    public static String getDeviceId() {
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        if (!TextUtils.isEmpty(bbm)) {
            return bbm;
        }
        String strSj = Sj();
        if (!TextUtils.isEmpty(strSj)) {
            String str = "ANDROID_" + strSj;
            bbm = str;
            return str;
        }
        String strDp = dp(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
        if (!TextUtils.isEmpty(strDp) && !hw(strDp) && hx(strDp)) {
            String str2 = "ANDROID_" + strDp;
            bbm = str2;
            return str2;
        }
        String strSi = Si();
        if (!TextUtils.isEmpty(strSi)) {
            bbm = "ANDROID_" + strSi;
            hy(strSi);
            return bbm;
        }
        return "ANDROID_";
    }

    private static String Si() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(String str, int i, char c) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < 16) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    private static boolean hw(String str) {
        return bbA.contains(str.toLowerCase(Locale.US));
    }

    private static boolean hx(String str) {
        for (int i = 0; i < str.length(); i++) {
            try {
                if (str.charAt(i) != '0') {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static void hy(String str) {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return;
        }
        ag.a("ksadsdk_pref", "android_id", str, true);
    }

    private static String Sj() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String strH = ag.h("ksadsdk_pref", "android_id", (String) null);
        ag.i(strH, "ksadsdk_pref", "android_id");
        return strH;
    }

    public static String cn(boolean z) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            return "";
        }
        Context context = fVar.getContext();
        String appOAID = com.kwad.sdk.core.e.a.getAppOAID(context);
        return (TextUtils.isEmpty(appOAID) && !z && TextUtils.isEmpty(dT(context))) ? ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BA() : appOAID;
    }

    public static List<String> ec(Context context) {
        String[] list;
        if (d.cr(context)) {
            return new ArrayList();
        }
        if (!ed(context)) {
            return new ArrayList();
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
        if (!file.exists() || !file.isDirectory() || (list = file.list()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && !str.startsWith(FileUtils.FILE_EXTENSION_SEPARATOR)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean ed(Context context) {
        try {
            if (context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30) {
                return false;
            }
            if (context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.j) == 0) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String hz(String str) {
        StructStat structStatStat;
        String strValueOf;
        if (!TextUtils.isEmpty(bby) || TextUtils.isEmpty(str)) {
            return bby;
        }
        try {
            structStatStat = Os.stat(str);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (structStatStat == null) {
            return bby;
        }
        String strValueOf2 = "";
        if (Build.VERSION.SDK_INT >= 27) {
            if (structStatStat.st_atim == null) {
                strValueOf = "";
            } else {
                strValueOf2 = String.valueOf(structStatStat.st_atim.tv_sec);
                strValueOf = String.valueOf(structStatStat.st_atim.tv_nsec);
            }
            bby = strValueOf2 + FileUtils.FILE_EXTENSION_SEPARATOR + strValueOf;
        } else {
            if (structStatStat.st_atime != 0) {
                strValueOf2 = String.valueOf(structStatStat.st_atime);
            }
            bby = strValueOf2;
        }
        return bby;
    }

    public static Pair<Boolean, Boolean> ee(Context context) {
        boolean z;
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            accessibilityManager.getEnabledAccessibilityServiceList(16);
            boolean zIsEnabled = accessibilityManager.isEnabled();
            try {
                z = accessibilityManager.getEnabledAccessibilityServiceList(16).isEmpty() ? false : true;
                return new Pair<>(Boolean.valueOf(zIsEnabled), Boolean.valueOf(z));
            } catch (Throwable th) {
                th = th;
                z = z;
                z = zIsEnabled;
                com.kwad.sdk.core.d.c.printStackTrace(th);
                return new Pair<>(Boolean.valueOf(z), Boolean.valueOf(z));
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }
}
