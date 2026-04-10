package anet.channel.status;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.AwcnConfig;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.taobao.accs.utl.UtilityImpl;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static Method f430t;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static String[] f423m = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
    static volatile Context a = null;
    static volatile boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static volatile NetworkStatusHelper.NetworkStatus f413c = NetworkStatusHelper.NetworkStatus.NONE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static volatile String f414d = "unknown";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile String f415e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static volatile String f416f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static volatile String f417g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static volatile String f418h = "unknown";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static volatile String f419i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static volatile Pair<String, Integer> f420j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static volatile boolean f421k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static volatile List<InetAddress> f422l = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile boolean f424n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static volatile boolean f425o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static ConnectivityManager f426p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static TelephonyManager f427q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static WifiManager f428r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static SubscriptionManager f429s = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static BroadcastReceiver f431u = new BroadcastReceiver() { // from class: anet.channel.status.NetworkStatusMonitor$2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.NetworkStatusMonitor", "receiver:" + intent.getAction(), null, new Object[0]);
            }
            ThreadPoolExecutorFactory.submitScheduledTask(new d(this));
        }
    };

    b() {
    }

    static void a() {
        if (f424n || a == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            a.registerReceiver(f431u, intentFilter);
        } catch (Exception unused) {
            ALog.e("awcn.NetworkStatusMonitor", "registerReceiver failed", null, new Object[0]);
        }
        d();
        f424n = true;
    }

    static void b() {
        if (a != null) {
            a.unregisterReceiver(f431u);
        }
    }

    static void c() {
        if (Build.VERSION.SDK_INT < 24 || f425o) {
            return;
        }
        NetworkInfo networkInfoE = e();
        b = networkInfoE != null && networkInfoE.isConnected();
        f426p.registerDefaultNetworkCallback(new c());
        f425o = true;
    }

    static void d() {
        NetworkInfo networkInfoE;
        boolean z2;
        WifiInfo wifiInfoI;
        ALog.d("awcn.NetworkStatusMonitor", "[checkNetworkStatus]", null, new Object[0]);
        NetworkStatusHelper.NetworkStatus networkStatus = f413c;
        String str = f415e;
        String str2 = f416f;
        try {
            try {
                networkInfoE = e();
                z2 = false;
            } catch (Exception e2) {
                ALog.e("awcn.NetworkStatusMonitor", "getNetworkInfo exception", null, e2, new Object[0]);
                a(NetworkStatusHelper.NetworkStatus.NONE, "unknown");
                networkInfoE = null;
                z2 = true;
            }
            if (!z2) {
                if (networkInfoE == null || !networkInfoE.isConnected()) {
                    a(NetworkStatusHelper.NetworkStatus.NO, "no network");
                    ALog.i("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "no network");
                } else {
                    ALog.i("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "info.isConnected", Boolean.valueOf(networkInfoE.isConnected()), "info.isAvailable", Boolean.valueOf(networkInfoE.isAvailable()), "info.getType", Integer.valueOf(networkInfoE.getType()));
                    if (networkInfoE.getType() == 0) {
                        String subtypeName = networkInfoE.getSubtypeName();
                        String strReplace = TextUtils.isEmpty(subtypeName) ? "" : subtypeName.replace(" ", "");
                        a(a(networkInfoE.getSubtype(), strReplace), strReplace);
                        f415e = a(networkInfoE.getExtraInfo());
                        h();
                    } else if (networkInfoE.getType() == 1) {
                        a(NetworkStatusHelper.NetworkStatus.WIFI, UtilityImpl.NET_TYPE_WIFI);
                        if (AwcnConfig.isWifiInfoEnable() && (wifiInfoI = i()) != null && b(g.f16727g)) {
                            f417g = wifiInfoI.getBSSID();
                            f416f = wifiInfoI.getSSID();
                        }
                        f418h = UtilityImpl.NET_TYPE_WIFI;
                        f419i = UtilityImpl.NET_TYPE_WIFI;
                        f420j = j();
                    } else {
                        a(NetworkStatusHelper.NetworkStatus.NONE, "unknown");
                    }
                    f421k = networkInfoE.isRoaming();
                    anet.channel.util.c.e();
                }
            }
            if (f413c == networkStatus && f415e.equalsIgnoreCase(str) && f416f.equalsIgnoreCase(str2)) {
                return;
            }
            if (ALog.isPrintLog(2)) {
                NetworkStatusHelper.printNetworkDetail();
            }
            NetworkStatusHelper.notifyStatusChanged(f413c);
        } catch (Exception e3) {
            ALog.e("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, e3, new Object[0]);
        }
    }

    static NetworkInfo e() {
        if (f426p == null) {
            f426p = (ConnectivityManager) a.getSystemService("connectivity");
        }
        return f426p.getActiveNetworkInfo();
    }

    static String f() {
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class);
            for (String str : f423m) {
                String str2 = (String) method.invoke(null, str);
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    static int g() {
        if (f426p == null || Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        return f426p.getRestrictBackgroundStatus();
    }

    private static void h() {
        try {
            if (b("android.permission.READ_PHONE_STATE")) {
                if (f427q == null) {
                    f427q = (TelephonyManager) a.getSystemService("phone");
                }
                f419i = f427q.getSimOperator();
                if (Build.VERSION.SDK_INT >= 22) {
                    if (f429s == null) {
                        f429s = SubscriptionManager.from(a);
                        f430t = f429s.getClass().getDeclaredMethod("getDefaultDataSubscriptionInfo", new Class[0]);
                    }
                    if (f430t != null) {
                        f418h = ((SubscriptionInfo) f430t.invoke(f429s, new Object[0])).getCarrierName().toString();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private static WifiInfo i() {
        try {
            if (f428r == null) {
                f428r = (WifiManager) a.getSystemService(UtilityImpl.NET_TYPE_WIFI);
            }
            return f428r.getConnectionInfo();
        } catch (Throwable th) {
            ALog.e("awcn.NetworkStatusMonitor", "getWifiInfo", null, th, new Object[0]);
            return null;
        }
    }

    private static Pair<String, Integer> j() {
        try {
            String property = System.getProperty("http.proxyHost");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return Pair.create(property, Integer.valueOf(Integer.parseInt(System.getProperty("http.proxyPort"))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static boolean b(String str) {
        return Build.VERSION.SDK_INT >= 23 && a.checkSelfPermission(str) == 0;
    }

    private static void a(NetworkStatusHelper.NetworkStatus networkStatus, String str) {
        f413c = networkStatus;
        f414d = str;
        f415e = "";
        f416f = "";
        f417g = "";
        f420j = null;
        f418h = "";
        f419i = "";
    }

    private static NetworkStatusHelper.NetworkStatus a(int i2, String str) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkStatusHelper.NetworkStatus.G2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return NetworkStatusHelper.NetworkStatus.G3;
            case 13:
            case 18:
            case 19:
                return NetworkStatusHelper.NetworkStatus.G4;
            case 20:
                return NetworkStatusHelper.NetworkStatus.G5;
            default:
                if (!str.equalsIgnoreCase("TD-SCDMA") && !str.equalsIgnoreCase("WCDMA") && !str.equalsIgnoreCase("CDMA2000")) {
                    return NetworkStatusHelper.NetworkStatus.NONE;
                }
                return NetworkStatusHelper.NetworkStatus.G3;
        }
    }

    private static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.contains("cmwap")) {
                return "cmwap";
            }
            if (lowerCase.contains("uniwap")) {
                return "uniwap";
            }
            if (lowerCase.contains("3gwap")) {
                return "3gwap";
            }
            if (lowerCase.contains("ctwap")) {
                return "ctwap";
            }
            if (lowerCase.contains("cmnet")) {
                return "cmnet";
            }
            if (lowerCase.contains("uninet")) {
                return "uninet";
            }
            if (lowerCase.contains("3gnet")) {
                return "3gnet";
            }
            if (lowerCase.contains("ctnet")) {
                return "ctnet";
            }
        }
        return "unknown";
    }
}
