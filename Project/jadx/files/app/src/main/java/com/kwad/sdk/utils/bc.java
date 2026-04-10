package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
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
import android.support.v4.media.session.PlaybackStateCompat;
import android.system.Os;
import android.system.StructStat;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.taobao.accs.utl.UtilityImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

/* JADX INFO: loaded from: classes3.dex */
public final class bc {
    private static int aAh = 0;
    private static long aAi = 0;
    private static String azL = null;
    private static String azM = "";
    private static boolean azN = false;
    private static String azO = "";
    private static String azP = "";
    private static int azQ = 0;
    private static boolean azR = false;
    private static int azS = 0;
    private static boolean azT = false;
    private static String azY;
    private static String azZ;
    private static final String[] azU = {"", ""};
    private static String azV = "";
    private static String azW = "";
    private static String azX = "";
    private static int aAa = -1;
    private static boolean aAb = false;
    private static boolean aAc = false;
    private static boolean aAd = false;
    private static boolean aAe = false;
    private static boolean aAf = false;
    private static boolean aAg = false;
    private static String aAj = "";
    private static String aAk = "";
    private static final List<String> aAl = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    public static int EA() {
        int i2 = aAh;
        if (i2 > 0) {
            return i2;
        }
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        aAh = iAvailableProcessors;
        return iAvailableProcessors;
    }

    public static String EB() {
        return Build.MODEL;
    }

    public static synchronized long EC() {
        long j2;
        j2 = 0;
        if (as.DS() && (!TextUtils.isEmpty(as.DT()) || as.DU() != null)) {
            j2 = 1;
        }
        if (as.DQ() && as.DR() != null) {
            j2 |= 64;
        }
        if (as.DS() && !TextUtils.isEmpty(as.DV())) {
            j2 |= 2;
        }
        if (as.DW() && !TextUtils.isEmpty(as.DX())) {
            j2 |= 4;
        }
        if (as.DY() && !TextUtils.isEmpty(as.DZ())) {
            j2 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        if (as.Ec()) {
            if (as.Ed() != null) {
                j2 |= 16;
            }
        }
        return j2;
    }

    public static String ED() {
        return Build.BRAND;
    }

    public static synchronized long EE() {
        return SystemClock.elapsedRealtime() / 1000;
    }

    public static synchronized long EF() {
        return Build.TIME;
    }

    public static synchronized String EG() {
        return Build.FINGERPRINT;
    }

    public static synchronized String EH() {
        if (!TextUtils.isEmpty(azL)) {
            return azL;
        }
        String radioVersion = Build.getRadioVersion();
        azL = radioVersion;
        return radioVersion;
    }

    public static synchronized String EI() {
        return ar.getName();
    }

    public static synchronized String EJ() {
        return ar.getVersion();
    }

    public static String EK() {
        return Build.MANUFACTURER;
    }

    public static int EL() {
        if (aAa == -1) {
            aAa = m73do(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext()) ? 4 : 3;
        }
        return aAa;
    }

    public static String EM() {
        if (TextUtils.isEmpty(azZ)) {
            azZ = System.getProperty("os.arch");
        }
        return azZ;
    }

    public static int EN() {
        return Build.VERSION.SDK_INT;
    }

    public static String EO() {
        Enumeration<NetworkInterface> networkInterfaces;
        if (as.Ea() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(8L)) {
            return "";
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
                    return inetAddressNextElement.getHostAddress();
                }
                return "";
            }
        }
        return "";
    }

    private static String EP() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String EQ() {
        if (((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext() == null) {
            return null;
        }
        String strH = x.h("ksadsdk_pref", "android_id", (String) null);
        x.i(strH, "ksadsdk_pref", "android_id");
        return strH;
    }

    public static String ER() {
        if (!TextUtils.isEmpty(aAj)) {
            return aAj;
        }
        try {
            String strQ = p.Q(new File("/proc/sys/kernel/random/boot_id"));
            aAj = TextUtils.isEmpty(strQ) ? "" : strQ.substring(0, strQ.indexOf("\n"));
        } catch (IOException unused) {
        }
        return aAj;
    }

    private static long Ew() throws Throwable {
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

    public static long Ey() {
        return com.kwad.sdk.crash.utils.h.F(Environment.getDataDirectory());
    }

    public static long Ez() {
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(1024L)) {
            return 0L;
        }
        return com.kwad.sdk.crash.utils.h.E(Environment.getDataDirectory());
    }

    private static String a(String str, int i2, char c2) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < 16) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    public static String bD(boolean z2) {
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        String strBd = com.kwad.sdk.core.e.a.bd(context);
        return (TextUtils.isEmpty(strBd) && !z2 && TextUtils.isEmpty(dh(context))) ? ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sR() : strBd;
    }

    @SuppressLint({"HardwareIds"})
    public static String cC(Context context) {
        if (as.DS() && !TextUtils.isEmpty(as.DV())) {
            return as.DV();
        }
        if (!TextUtils.isEmpty(azX) || context == null) {
            return azX;
        }
        if (aAe) {
            return azX;
        }
        if (as.DS() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(2L)) {
            return azX;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            azX = string;
            if (!eC(string)) {
                azX = "";
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(azX)) {
            aAe = true;
        }
        return azX;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String cG(Context context) {
        if (context != null) {
            if (!aAc && TextUtils.isEmpty(azV) && SystemUtil.dd(context) && !as.DS() && !((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(128L)) {
                try {
                    azV = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                } catch (Exception unused) {
                }
                aAc = TextUtils.isEmpty(azV);
                return azV;
            }
        }
        return azV;
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static long de(Context context) {
        if (context == null || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(1024L)) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static int df(Context context) {
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(512L)) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((BatteryManager) context.getApplicationContext().getSystemService("batterymanager")).getIntProperty(4);
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static long dg(Context context) throws Throwable {
        long j2 = aAi;
        if (j2 > 0) {
            return j2;
        }
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long jEw = memoryInfo.totalMem;
            if (jEw <= 0) {
                jEw = Ew();
            }
            aAi = jEw;
            return jEw;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static synchronized String dh(@Nullable Context context) {
        if (as.DS() && !TextUtils.isEmpty(as.DT())) {
            return as.DT();
        }
        if (aAb) {
            return azO;
        }
        if (TextUtils.isEmpty(azO) && context != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return azO;
            }
            if (as.DS() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(1L)) {
                return azO;
            }
            boolean zDd = false;
            try {
                zDd = SystemUtil.dd(context);
                if (zDd) {
                    String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                    azO = deviceId;
                    if (TextUtils.isEmpty(deviceId)) {
                        aAb = true;
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
                if (zDd) {
                    aAb = true;
                }
            }
            return azO;
        }
        return azO;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String di(@Nullable Context context) {
        TelephonyManager telephonyManager;
        if (aAg) {
            return azP;
        }
        if (TextUtils.isEmpty(azP) && context != null) {
            if (as.DS() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)) {
                return azP;
            }
            boolean zDd = false;
            try {
                zDd = SystemUtil.dd(context);
                if (zDd && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        String meid = telephonyManager.getMeid();
                        azP = meid;
                        if (TextUtils.isEmpty(meid)) {
                            aAg = true;
                        }
                    } else {
                        if (telephonyManager.getPhoneType() == 2) {
                            String deviceId = telephonyManager.getDeviceId();
                            azP = deviceId;
                            if (TextUtils.isEmpty(deviceId)) {
                            }
                        } else {
                            azP = null;
                        }
                        aAg = true;
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
                if (zDd) {
                    aAg = true;
                }
            }
            return azP;
        }
        return azP;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String[] dj(@Nullable Context context) {
        boolean zDd;
        if (as.DS() && as.DU() != null) {
            return as.DU();
        }
        if (aAf) {
            return azU;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return azU;
        }
        if (TextUtils.isEmpty(azU[0]) && TextUtils.isEmpty(azU[1]) && context != null) {
            if (as.DS() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(1L)) {
                return azU;
            }
            try {
                zDd = SystemUtil.dd(context);
                if (zDd) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager != null) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                int iMin = Math.min(dk(context), 2);
                                for (int i2 = 0; i2 < iMin; i2++) {
                                    azU[i2] = telephonyManager.getImei(i2);
                                }
                                if (TextUtils.isEmpty(azU[0]) && TextUtils.isEmpty(azU[1])) {
                                    aAf = true;
                                }
                            } else {
                                if (telephonyManager.getPhoneType() == 1) {
                                    if (Build.VERSION.SDK_INT >= 23) {
                                        int iMin2 = Math.min(dk(context), 2);
                                        for (int i3 = 0; i3 < iMin2; i3++) {
                                            azU[i3] = telephonyManager.getDeviceId(i3);
                                        }
                                    } else {
                                        azU[0] = telephonyManager.getDeviceId();
                                        azU[1] = null;
                                    }
                                    if (TextUtils.isEmpty(azU[0]) && TextUtils.isEmpty(azU[1])) {
                                    }
                                } else {
                                    azU[0] = null;
                                    azU[1] = null;
                                }
                                aAf = true;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                        if (zDd) {
                            aAf = true;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                zDd = false;
            }
            return azU;
        }
        return azU;
    }

    public static synchronized int dk(Context context) {
        if (azR || azQ > 0 || Build.VERSION.SDK_INT < 23 || context == null || as.DS()) {
            return azQ;
        }
        try {
            azQ = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
        } catch (Exception unused) {
        }
        azR = azQ == 0;
        return azQ;
    }

    @SuppressLint({"MissingPermission"})
    public static int dl(Context context) {
        if (context == null || azS > 0 || azT || Build.VERSION.SDK_INT < 22 || !SystemUtil.dd(context) || as.DS()) {
            return azS;
        }
        try {
            azS = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
        } catch (Throwable unused) {
        }
        azT = azS != 0;
        return azS;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String dm(Context context) {
        if (!TextUtils.isEmpty(azW) || context == null) {
            return azW;
        }
        if (aAd) {
            return azW;
        }
        if (as.DS() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(128L)) {
            return azW;
        }
        try {
            if (SystemUtil.dd(context)) {
                azW = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            azW = null;
        }
        if (TextUtils.isEmpty(azW)) {
            aAd = true;
        }
        String str = TextUtils.isEmpty(azW) ? "" : azW;
        azW = str;
        return str;
    }

    public static synchronized int dn(Context context) {
        return ((AudioManager) context.getSystemService(com.anythink.expressad.exoplayer.k.o.b)).getRingerMode();
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private static boolean m73do(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    @SuppressLint({"HardwareIds"})
    public static synchronized String dp(@Nullable Context context) {
        if (TextUtils.isEmpty(azM) && context != null && !azN) {
            if (as.DW()) {
                String strDX = as.DX();
                azM = strDX;
                return strDX;
            }
            if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(4L)) {
                return azM;
            }
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo();
                if (connectionInfo != null) {
                    azM = connectionInfo.getMacAddress();
                }
                if (eA(azM)) {
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
                                azM = sb.toString();
                            }
                        }
                    }
                }
                if (eA(azM)) {
                    azM = com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                }
                if (!eA(azM)) {
                    azM = azM.toUpperCase(Locale.US);
                }
            } catch (Exception unused) {
                azN = true;
            }
            azN = eA(azM);
            return azM;
        }
        return azM;
    }

    @Nullable
    public static List<String> dq(@NonNull Context context) {
        String[] list;
        if (!c.bH(context) && dr(context)) {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
            if (!file.exists() || !file.isDirectory() || (list = file.list()) == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (!TextUtils.isEmpty(str) && !str.startsWith(".")) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public static boolean dr(@NonNull Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    private static boolean eA(String str) {
        return TextUtils.isEmpty(str) || str.equals("02:00:00:00:00:00");
    }

    private static boolean eB(String str) {
        return aAl.contains(str.toLowerCase(Locale.US));
    }

    private static boolean eC(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            try {
                if (str.charAt(i2) != '0') {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static void eD(String str) {
        if (((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext() == null) {
            return;
        }
        x.a("ksadsdk_pref", "android_id", str, true);
    }

    public static String eE(String str) {
        String strValueOf;
        if (!TextUtils.isEmpty(aAk) || TextUtils.isEmpty(str)) {
            return aAk;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                StructStat structStatStat = Os.stat(str);
                if (structStatStat == null) {
                    return aAk;
                }
                String strValueOf2 = "";
                if (Build.VERSION.SDK_INT >= 27) {
                    if (structStatStat.st_atim == null) {
                        strValueOf = "";
                    } else {
                        strValueOf2 = String.valueOf(structStatStat.st_atim.tv_sec);
                        strValueOf = String.valueOf(structStatStat.st_atim.tv_nsec);
                    }
                    aAk = strValueOf2 + "." + strValueOf;
                } else {
                    if (structStatStat.st_atime != 0) {
                        strValueOf2 = String.valueOf(structStatStat.st_atime);
                    }
                    aAk = strValueOf2;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        return aAk;
    }

    public static String getDeviceId() {
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        if (!TextUtils.isEmpty(azY)) {
            return azY;
        }
        String strEQ = EQ();
        if (!TextUtils.isEmpty(strEQ)) {
            String str = "ANDROID_" + strEQ;
            azY = str;
            return str;
        }
        String strCC = cC(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext());
        if (!TextUtils.isEmpty(strCC) && !eB(strCC) && eC(strCC)) {
            String str2 = "ANDROID_" + strCC;
            azY = str2;
            return str2;
        }
        String strEP = EP();
        if (!TextUtils.isEmpty(strEP)) {
            azY = "ANDROID_" + strEP;
            eD(strEP);
            return azY;
        }
        return "ANDROID_";
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getLocale() {
        Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getScreenHeight(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String u(@Nullable Context context, boolean z2) {
        if (as.DS() && !TextUtils.isEmpty(as.DT())) {
            return as.DT();
        }
        String strDh = dh(context);
        return (TextUtils.isEmpty(strDh) && !z2 && TextUtils.isEmpty(com.kwad.sdk.core.e.a.bd(context))) ? ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sQ() : strDh;
    }
}
