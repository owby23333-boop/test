package com.bytedance.msdk.gz;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class io {
    private static final AtomicInteger z = new AtomicInteger(0);

    private static String g(int i) {
        return i != 0 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? "mobile" : NetworkUtil.NETWORK_CLASS_5G : NetworkUtil.NETWORK_CLASS_4G : "wifi" : NetworkUtil.NETWORK_CLASS_3G : "2g" : "unknown";
    }

    private static int z(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 2;
        if (i != 2) {
            i2 = 3;
            if (i != 3) {
                if (i == 4) {
                    return 1;
                }
                if (i == 5) {
                    return 4;
                }
                if (i != 6) {
                    return i;
                }
                return 5;
            }
        }
        return i2;
    }

    public static String z() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getAppLogDid() : "";
    }

    public static String g() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getOAID(false) : "";
    }

    public static String dl() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getCompilingTime() : "";
    }

    public static String a() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getAndroidId() : "";
    }

    public static int gc() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        int connType = 0;
        if (com.bytedance.msdk.core.z.kb().zw().dl() && zVar != null) {
            connType = zVar.getConnType();
        }
        return z(connType);
    }

    public static String m() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        int connType = 0;
        if (com.bytedance.msdk.core.z.kb().zw().dl() && zVar != null) {
            connType = zVar.getConnType();
        }
        return g(connType);
    }

    public static String e() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getDeviceModel() : "";
    }

    public static String gz() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getDeviceName() : "";
    }

    public static boolean z(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean g(Context context) {
        return com.bytedance.sdk.component.utils.v.dl(context) == 3;
    }

    public static boolean dl(Context context) {
        return com.bytedance.sdk.component.utils.v.dl(context) == 2;
    }

    public static String fo() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getLanguage() : "";
    }

    public static String uy() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getLocalLanguage() : "";
    }

    public static String kb() {
        com.bytedance.sdk.component.a.z.z zVar;
        return (un() && (zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info")) != null) ? zVar.getMcc() : "";
    }

    public static String wp() {
        com.bytedance.sdk.component.a.z.z zVar;
        return (un() && (zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info")) != null) ? zVar.getMnc() : "";
    }

    public static int i() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        if (zVar != null) {
            return zVar.getOs();
        }
        return 0;
    }

    public static String v() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getOsVersion() : "";
    }

    public static String pf() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getTotalMem() : "";
    }

    public static String ls() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getTotalSpace() : "";
    }

    public static String p() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getVendor() : "";
    }

    private static boolean un() {
        return com.bytedance.msdk.core.z.kb().zw().dl() && a(com.bytedance.msdk.core.g.getContext());
    }

    public static String fv() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getTimeZone() : "";
    }

    public static String js() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getBoot() : "";
    }

    public static String tb() {
        com.bytedance.sdk.component.a.z.z zVar;
        return (un() && (zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info")) != null) ? zVar.getCarrierName() : "";
    }

    public static String q() {
        AtomicInteger atomicInteger = z;
        if (atomicInteger.intValue() > 5) {
            return null;
        }
        atomicInteger.incrementAndGet();
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        if (zVar != null) {
            return zVar.getImei(null);
        }
        return null;
    }

    public static String iq() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getIP() : "";
    }

    public static String zw() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getUUId() : "";
    }

    public static String io() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getImsi(null) : "";
    }

    public static String uf() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getSSID(null) : "";
    }

    public static String sy() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getWifiMac(null) : "";
    }

    public static String hh() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getBuildSerial() : "";
    }

    public static String l() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getMacAddress(null) : "";
    }

    public static int h() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        if (zVar != null) {
            return zVar.getDeviceType(false);
        }
        return 1;
    }

    public static String gk() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getUserAgent() : "";
    }

    public static String x() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getRom() : "";
    }

    public static int lq() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        if (zVar != null) {
            return zVar.getTimeZoneInt();
        }
        return 0;
    }

    public static String mc() {
        com.bytedance.sdk.component.a.z.z zVar = (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
        return zVar != null ? zVar.getDisplayDensity() : "";
    }

    private static boolean a(Context context) {
        return com.bytedance.msdk.core.wp.dl.z(context, com.kuaishou.weapon.p0.g.c) == 0;
    }
}
