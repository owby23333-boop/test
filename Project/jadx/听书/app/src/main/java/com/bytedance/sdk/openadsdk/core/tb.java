package com.bytedance.sdk.openadsdk.core;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f1324a = null;
    private static volatile String dl = null;
    private static volatile String e = null;
    private static volatile boolean eo = false;
    private static volatile String fo = null;
    private static volatile String fv = null;
    private static volatile String g = "";
    private static volatile String gc;
    private static volatile boolean gk;
    private static volatile boolean h;
    private static volatile boolean hh;
    private static volatile String i;
    private static volatile boolean io;
    private static volatile boolean iq;
    private static volatile String js;
    private static volatile boolean l;
    private static volatile boolean lq;
    private static volatile String ls;
    private static volatile String m;
    private static volatile WifiInfo na;
    private static volatile TelephonyManager oq;
    private static volatile String p;
    private static volatile String pf;
    private static volatile boolean sy;
    private static volatile long ti;
    private static volatile boolean uf;
    private static volatile String un;
    private static volatile String v;
    private static volatile WifiManager wj;
    private static volatile boolean x;
    private static String z;
    private static volatile boolean zw;
    private static AtomicBoolean gz = new AtomicBoolean(false);
    private static volatile String uy = "";
    private static volatile String kb = "";
    private static volatile boolean wp = true;
    private static volatile String tb = null;
    private static AtomicBoolean q = new AtomicBoolean(false);
    private static AtomicBoolean mc = new AtomicBoolean(false);

    public static TelephonyManager z() {
        if (oq != null) {
            return oq;
        }
        synchronized (tb.class) {
            if (oq != null) {
                return oq;
            }
            oq = (TelephonyManager) zw.getContext().getSystemService("phone");
            return oq;
        }
    }

    private static WifiManager io() {
        if (wj != null) {
            return wj;
        }
        synchronized (tb.class) {
            if (wj != null) {
                return wj;
            }
            wj = (WifiManager) zw.getContext().getApplicationContext().getSystemService("wifi");
            return wj;
        }
    }

    public static WifiInfo g() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
        if (aVarP != null && (!aVarP.a() || !aVarP.z())) {
            return na;
        }
        if (na != null) {
            return na;
        }
        synchronized (tb.class) {
            if (na != null) {
                return na;
            }
            WifiManager wifiManagerIo = io();
            if (wifiManagerIo == null) {
                return na;
            }
            na = wifiManagerIo.getConnectionInfo();
            return na;
        }
    }

    public static void z(String str) {
        if (com.bytedance.sdk.openadsdk.z.z.z.z() != null) {
            com.bytedance.sdk.openadsdk.z.z.z.z().z(str);
        }
        if (TextUtils.isEmpty(str) || str.equals(dl)) {
            return;
        }
        g.z().put("did", str);
        dl = str;
    }

    public static String dl() {
        if (!TextUtils.isEmpty(dl)) {
            return dl;
        }
        String str = g.z().get("did", z);
        dl = str;
        return str;
    }

    public static String a() {
        if (!TextUtils.isEmpty(fv)) {
            return fv;
        }
        String strValueOf = String.valueOf(Build.TIME);
        fv = strValueOf;
        return strValueOf;
    }

    public static boolean gc() {
        return iq;
    }

    public static String m() {
        if (!TextUtils.isEmpty(f1324a)) {
            return f1324a;
        }
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
        if (aVarP != null && gk.dl >= 4600 && !aVarP.m()) {
            if (gk.dl >= 4900) {
                return aVarP.v();
            }
            return null;
        }
        if (iq) {
            return f1324a;
        }
        if (com.bytedance.sdk.openadsdk.core.a.z.gz()) {
            String strE = com.bytedance.sdk.openadsdk.core.dl.a.z().e();
            if (!TextUtils.isEmpty(strE)) {
                f1324a = strE;
                new com.bytedance.sdk.openadsdk.core.a.g("device_get_android_id").z(5).g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tb.1
                    @Override // java.lang.Runnable
                    public void run() {
                        tb.uf();
                    }
                });
                return f1324a;
            }
        }
        uf();
        return f1324a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void uf() {
        synchronized (tb.class) {
            if (iq) {
                return;
            }
            f1324a = lq();
            com.bytedance.sdk.openadsdk.tools.g.g(9, f1324a);
        }
    }

    public static String z(Boolean bool) {
        if (!TextUtils.isEmpty(gc)) {
            return gc;
        }
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
        if (bool == null) {
            return z(aVarP, aVarP != null && aVarP.dl());
        }
        if (zw) {
            return gc;
        }
        return z(aVarP, bool.booleanValue());
    }

    private static String z(com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar, boolean z2) {
        if (aVar != null && !z2) {
            String strUy = aVar.uy();
            gc = strUy;
            com.bytedance.sdk.openadsdk.tools.g.g(6, strUy);
            return strUy;
        }
        if (zw) {
            return gc;
        }
        if (com.bytedance.sdk.openadsdk.core.a.z.gz()) {
            String strKb = TextUtils.isEmpty(gc) ? com.bytedance.sdk.openadsdk.core.dl.a.z().kb(null) : gc;
            if (!TextUtils.isEmpty(strKb)) {
                new com.bytedance.sdk.openadsdk.core.a.g("device_get_imei").z(5).g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tb.2
                    @Override // java.lang.Runnable
                    public void run() {
                        tb.sy();
                    }
                });
                return strKb;
            }
        }
        sy();
        return gc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sy() {
        synchronized (tb.class) {
            if (zw) {
                return;
            }
            if (io) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.core.uf.g.z(zw.getContext(), com.kuaishou.weapon.p0.g.c) == 0) {
                io = true;
                TelephonyManager telephonyManagerZ = z();
                if (telephonyManagerZ == null) {
                    return;
                }
                try {
                    gc = telephonyManagerZ.getImei();
                } catch (Throwable unused) {
                }
                zw = true;
                com.bytedance.sdk.openadsdk.tools.g.g(6, gc);
            }
        }
    }

    public static String g(Boolean bool) {
        if (!TextUtils.isEmpty(fo)) {
            return fo;
        }
        if (bool == null) {
            com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
            if (aVarP != null && !aVarP.dl()) {
                return null;
            }
        } else {
            if (hh || io) {
                return fo;
            }
            if (!bool.booleanValue()) {
                return null;
            }
        }
        return hh();
    }

    private static String hh() {
        if (hh) {
            return fo;
        }
        synchronized (tb.class) {
            if (hh) {
                return fo;
            }
            if (io) {
                return gc;
            }
            TelephonyManager telephonyManagerZ = z();
            if (telephonyManagerZ == null) {
                return fo;
            }
            try {
                fo = telephonyManagerZ.getSubscriberId();
            } catch (Throwable unused) {
            }
            hh = true;
            return fo;
        }
    }

    public static String dl(Boolean bool) {
        if (!TextUtils.isEmpty(m)) {
            return m;
        }
        if (bool == null) {
            com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
            if (aVarP != null && (!aVarP.a() || !aVarP.z())) {
                return null;
            }
        } else {
            if (uf) {
                return m;
            }
            if (bool.booleanValue()) {
                return null;
            }
        }
        return l();
    }

    private static String l() {
        WifiInfo wifiInfoG;
        if (uf) {
            return m;
        }
        synchronized (tb.class) {
            if (uf) {
                return m;
            }
            try {
                wifiInfoG = g();
            } catch (Throwable unused) {
            }
            if (wifiInfoG == null) {
                return m;
            }
            m = wifiInfoG.getSSID();
            uf = true;
            return m;
        }
    }

    public static String a(Boolean bool) {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        if (bool == null) {
            com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
            if (aVarP != null && (!aVarP.a() || !aVarP.z())) {
                return null;
            }
        } else {
            if (sy) {
                return e;
            }
            if (bool.booleanValue()) {
                return null;
            }
        }
        return h();
    }

    public static String e() {
        if (!TextUtils.isEmpty(e) || sy) {
            return e;
        }
        if (gz.get()) {
            return null;
        }
        gz.set(true);
        com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("") { // from class: com.bytedance.sdk.openadsdk.core.tb.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.un.uy.fo();
                tb.gz.set(false);
            }
        });
        return null;
    }

    private static String h() {
        if (sy) {
            return e;
        }
        synchronized (tb.class) {
            if (sy) {
                return e;
            }
            e = fo();
            sy = true;
            return e;
        }
    }

    public static String gz() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
        if (aVarP != null && !aVarP.dl()) {
            return null;
        }
        if (!TextUtils.isEmpty(js)) {
            return js;
        }
        if (x) {
            return js;
        }
        synchronized (tb.class) {
            if (x) {
                return js;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    js = Build.getSerial();
                } catch (Throwable unused) {
                }
            } else {
                js = Build.SERIAL;
            }
            x = true;
            return js;
        }
    }

    public static String fo() {
        if (com.bytedance.sdk.openadsdk.core.a.z.gz()) {
            new com.bytedance.sdk.openadsdk.core.a.g("device_get_bssid").z(3).g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tb.4
                @Override // java.lang.Runnable
                public void run() {
                    String unused = tb.e = tb.a("02:00:00:00:00:00");
                }
            });
            return TextUtils.isEmpty(e) ? "02:00:00:00:00:00" : e;
        }
        return a("02:00:00:00:00:00");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(String str) {
        try {
            WifiInfo wifiInfoG = g();
            if (wifiInfoG == null) {
                return str;
            }
            String bssid = wifiInfoG.getBSSID();
            return TextUtils.isEmpty(bssid) ? str : bssid;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static void uy() {
        TelephonyManager telephonyManagerZ;
        if (io) {
            return;
        }
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
        if ((aVarP == null || aVarP.dl()) && com.bytedance.sdk.openadsdk.core.uf.g.z(zw.getContext(), com.kuaishou.weapon.p0.g.c) == 0 && (telephonyManagerZ = z()) != null) {
            synchronized (tb.class) {
                io = true;
                if (TextUtils.isEmpty(gc)) {
                    try {
                        gc = telephonyManagerZ.getImei();
                    } catch (Throwable unused) {
                    }
                    com.bytedance.sdk.openadsdk.tools.g.g(6, gc);
                }
                if (TextUtils.isEmpty(fo)) {
                    try {
                        fo = telephonyManagerZ.getSubscriberId();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    public static String kb() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
        if (aVarP != null && !aVarP.dl()) {
            return "";
        }
        if (!TextUtils.isEmpty(uy)) {
            return uy;
        }
        if (l) {
            return uy;
        }
        synchronized (tb.class) {
            if (l) {
                return uy;
            }
            TelephonyManager telephonyManagerZ = z();
            if (telephonyManagerZ == null) {
                return uy;
            }
            try {
                uy = telephonyManagerZ.getSimOperator();
            } catch (Throwable unused) {
            }
            l = true;
            return uy;
        }
    }

    public static boolean wp() {
        if (h) {
            return wp;
        }
        synchronized (tb.class) {
            if (h) {
                return wp;
            }
            try {
                int simState = z().getSimState();
                if (1 == simState) {
                    wp = false;
                }
                if (simState == 0) {
                    wp = false;
                }
                h = true;
            } catch (Throwable unused) {
            }
            return wp;
        }
    }

    public static String i() {
        try {
            gk();
            if (!TextUtils.isEmpty(i)) {
                return i;
            }
            if (!z(ti, 60000L)) {
                return un;
            }
            if (!wp()) {
                return null;
            }
            int i2 = zw.getContext().getResources().getConfiguration().mcc;
            String strValueOf = i2 != 0 ? String.valueOf(i2) : i;
            un = strValueOf;
            ti = System.currentTimeMillis();
            return strValueOf;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String v() {
        gk();
        return v;
    }

    public static String pf() {
        gk();
        return pf;
    }

    public static String ls() {
        gk();
        return ls;
    }

    public static String p() {
        gk();
        return p;
    }

    private static void gk() {
        String strKb;
        String simOperatorName;
        String strSubstring;
        if (gk) {
            return;
        }
        synchronized (tb.class) {
            if (gk) {
                return;
            }
            TelephonyManager telephonyManagerZ = z();
            String strSubstring2 = null;
            try {
                strKb = telephonyManagerZ.getNetworkOperator();
            } catch (Throwable unused) {
                strKb = null;
            }
            if (TextUtils.isEmpty(strKb) || strKb.length() < 5) {
                strKb = kb();
            }
            try {
                simOperatorName = telephonyManagerZ.getSimOperatorName();
            } catch (Throwable unused2) {
                simOperatorName = null;
            }
            if (TextUtils.isEmpty(strKb) || strKb.length() <= 4) {
                strSubstring = null;
            } else {
                strSubstring2 = strKb.substring(0, 3);
                strSubstring = strKb.substring(3);
            }
            if (!TextUtils.isEmpty(strSubstring2)) {
                i = strSubstring2;
            }
            if (!TextUtils.isEmpty(strSubstring)) {
                pf = strSubstring;
            }
            if (!TextUtils.isEmpty(simOperatorName)) {
                p = simOperatorName;
            }
            x();
            gk = true;
        }
    }

    private static synchronized void x() {
        String strValueOf;
        String strValueOf2;
        if (eo) {
            return;
        }
        synchronized (tb.class) {
            eo = true;
            SubscriptionManager subscriptionManager = (SubscriptionManager) zw.getContext().getSystemService("telephony_subscription_service");
            if (subscriptionManager.getActiveSubscriptionInfoCount() < 2) {
                return;
            }
            List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList.size() < 2) {
                return;
            }
            for (int i2 = 0; i2 < 2; i2++) {
                SubscriptionInfo subscriptionInfo = activeSubscriptionInfoList.get(i2);
                if (Build.VERSION.SDK_INT >= 29) {
                    strValueOf = subscriptionInfo.getMccString();
                    strValueOf2 = subscriptionInfo.getMncString();
                } else {
                    strValueOf = String.valueOf(subscriptionInfo.getMcc());
                    strValueOf2 = String.valueOf(subscriptionInfo.getMnc());
                }
                if (i2 == 0) {
                    if (!TextUtils.isEmpty(strValueOf)) {
                        i = strValueOf;
                    }
                    if (!TextUtils.isEmpty(strValueOf2)) {
                        pf = strValueOf2;
                    }
                } else {
                    if (!TextUtils.isEmpty(strValueOf)) {
                        v = strValueOf;
                    }
                    if (!TextUtils.isEmpty(strValueOf2)) {
                        ls = strValueOf2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized java.lang.String lq() {
        /*
            java.lang.Class<com.bytedance.sdk.openadsdk.core.tb> r0 = com.bytedance.sdk.openadsdk.core.tb.class
            monitor-enter(r0)
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.zw.getContext()     // Catch: java.lang.Throwable -> L2b
            r2 = 0
            if (r1 != 0) goto Lc
            monitor-exit(r0)
            return r2
        Lc:
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Exception -> L19 java.lang.Throwable -> L2b
            java.lang.String r3 = "android_id"
            java.lang.String r2 = android.provider.Settings.Secure.getString(r1, r3)     // Catch: java.lang.Exception -> L19 java.lang.Throwable -> L2b
            r1 = 1
            com.bytedance.sdk.openadsdk.core.tb.iq = r1     // Catch: java.lang.Exception -> L19 java.lang.Throwable -> L2b
        L19:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L2b
            if (r1 != 0) goto L27
            int r1 = r2.length()     // Catch: java.lang.Throwable -> L2b
            r3 = 13
            if (r1 >= r3) goto L29
        L27:
            java.lang.String r2 = ""
        L29:
            monitor-exit(r0)
            return r2
        L2b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.tb.lq():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mc() {
        String strGc = gc("wlan0");
        if (TextUtils.isEmpty(strGc)) {
            strGc = gc("eth0");
        }
        if (TextUtils.isEmpty(strGc)) {
            strGc = "DU:MM:YA:DD:RE:SS";
        }
        com.bytedance.sdk.openadsdk.core.dl.a.z().a("mac_address", strGc);
        com.bytedance.sdk.openadsdk.core.dl.a.z().a("new_mac_address", com.bytedance.sdk.component.utils.z.g(strGc));
        tb = strGc;
    }

    public static String gc(Boolean bool) {
        if (!TextUtils.isEmpty(tb)) {
            return tb;
        }
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
        if (bool == null) {
            if (aVarP != null && !aVarP.a()) {
                return aVarP.kb();
            }
        } else {
            if (lq) {
                return tb;
            }
            if (aVarP != null && !bool.booleanValue()) {
                return aVarP.kb();
            }
        }
        return un();
    }

    private static String un() {
        if (lq) {
            return tb;
        }
        synchronized (tb.class) {
            if (lq) {
                return tb;
            }
            tb = ti();
            lq = true;
            return tb;
        }
    }

    private static String ti() {
        String strDl = null;
        try {
            String strDl2 = com.bytedance.sdk.openadsdk.core.dl.a.z().dl("new_mac_address", "");
            if (!TextUtils.isEmpty(strDl2)) {
                JSONObject jSONObject = new JSONObject(strDl2);
                long j = jSONObject.getLong("time");
                strDl = com.bytedance.sdk.component.utils.z.dl(jSONObject.getString("value"));
                if (System.currentTimeMillis() - j <= 864000000) {
                    if (!TextUtils.isEmpty(strDl)) {
                        return strDl;
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (com.bytedance.sdk.openadsdk.core.a.z.gz()) {
            if (!TextUtils.isEmpty(tb)) {
                strDl = tb;
            }
            if (!TextUtils.isEmpty(strDl)) {
                if (!q.get()) {
                    new com.bytedance.sdk.openadsdk.core.a.g("device_get_macaddress").z(5).z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tb.6
                        @Override // java.lang.Runnable
                        public void run() {
                            tb.q.set(false);
                        }
                    }).g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tb.5
                        @Override // java.lang.Runnable
                        public void run() {
                            tb.q.set(false);
                            tb.mc();
                        }
                    });
                }
                q.set(true);
                return strDl;
            }
        }
        mc();
        return tb;
    }

    private static String gc(String str) {
        try {
        } catch (Throwable unused) {
        }
        for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
            if (str == null || networkInterface.getName().equalsIgnoreCase(str)) {
                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                if (hardwareAddress == null) {
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                for (byte b : hardwareAddress) {
                    sb.append(String.format("%02X:", Byte.valueOf(b)));
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
                return "";
            }
        }
        return "";
    }

    public static String fv() {
        if (!TextUtils.isEmpty(g)) {
            return g;
        }
        String strZ = com.bytedance.sdk.component.utils.io.z();
        g = strZ;
        return strZ;
    }

    private static boolean z(long j, long j2) {
        return System.currentTimeMillis() - j > j2;
    }
}
