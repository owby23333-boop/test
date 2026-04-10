package com.anythink.china.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.kuaishou.weapon.p0.g;
import com.taobao.accs.utl.UtilityImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String[] a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    public static String a() {
        try {
            String[] strArr = a;
            int length = strArr.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (new File(strArr[i2]).exists()) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (Build.TAGS != null) {
                if (Build.TAGS.contains("test-keys")) {
                    return "1";
                }
            }
            return z2 ? "1" : "2";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return e(context);
            }
            boolean zIsProviderEnabled = ((LocationManager) context.getApplicationContext().getSystemService("location")).isProviderEnabled("gps");
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            boolean z2 = false;
            boolean z3 = packageManager.checkPermission(g.f16727g, context.getPackageName()) == 0 || packageManager.checkPermission(g.f16728h, context.getPackageName()) == 0;
            if (zIsProviderEnabled && z3) {
                z2 = true;
            }
            return z2 ? e(context) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] c(Context context) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0);
            StringBuilder sb = new StringBuilder();
            sb.append(packageInfo.firstInstallTime);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(packageInfo.lastUpdateTime);
            return new String[]{sb.toString(), sb2.toString()};
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean d(Context context) {
        boolean zIsProviderEnabled = ((LocationManager) context.getApplicationContext().getSystemService("location")).isProviderEnabled("gps");
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return zIsProviderEnabled && (packageManager.checkPermission(g.f16727g, context.getPackageName()) == 0 || packageManager.checkPermission(g.f16728h, context.getPackageName()) == 0);
    }

    @SuppressLint({"MissingPermission"})
    private static String e(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo();
            String ssid = connectionInfo == null ? "" : connectionInfo.getSSID();
            if ("<unknown ssid>".equalsIgnoreCase(ssid)) {
                ssid = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo().getExtraInfo();
            }
            return "<unknown ssid>".equalsIgnoreCase(ssid) ? "" : ssid;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(Context context) {
        int port;
        String property;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                if (property2 == null) {
                    property2 = GMNetworkPlatformConst.AD_NETWORK_NO_PRICE;
                }
                port = Integer.parseInt(property2);
            } else {
                String host = Proxy.getHost(context);
                port = Proxy.getPort(context);
                property = host;
            }
            return (TextUtils.isEmpty(property) || port == -1) ? "2" : "1";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c() {
        try {
            File file = new File("/proc/sys/kernel/random/boot_id");
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String str = "";
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        return str;
                    }
                    str = str + line;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String d() {
        try {
            File file = new File("/data/data");
            if (!file.exists()) {
                return "";
            }
            return (file.lastModified() / 1000) + ".000000000";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b() {
        try {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(Build.CPU_ABI2)) {
                return str;
            }
            return str + com.anythink.expressad.foundation.g.a.bQ + Build.CPU_ABI2;
        } catch (Throwable unused) {
            return "";
        }
    }
}
