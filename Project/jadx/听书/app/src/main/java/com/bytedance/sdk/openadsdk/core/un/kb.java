package com.bytedance.sdk.openadsdk.core.un;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.OsConstants;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import androidx.core.app.NotificationCompat;
import androidx.core.view.MotionEventCompat;
import androidx.media3.session.MediaController;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.utils.uf;
import com.funny.audio.core.utils.FileUtils;
import com.kuaishou.weapon.p0.bi;
import com.qq.e.comm.pi.ACTD;
import com.umeng.analytics.pro.an;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f1378a;
    private static volatile boolean dl;
    private static String g;
    private static volatile a gk;
    private static volatile long io;
    private static volatile String iq;
    private static volatile long js;
    private static volatile long p;
    private static volatile long pf;
    private static volatile String q;
    private static volatile long sy;
    private static volatile String tb;
    private static volatile String uf;
    private static volatile long v;
    private static volatile g x;
    private static volatile String zw;
    private static AtomicBoolean gc = new AtomicBoolean(false);
    private static AtomicBoolean m = new AtomicBoolean(false);
    private static AtomicInteger e = new AtomicInteger(-1);
    private static volatile boolean gz = true;
    private static long fo = 0;
    private static volatile int uy = -1;
    private static volatile int kb = -1;
    private static volatile String wp = null;
    private static volatile String i = null;
    private static volatile float ls = -2.0f;
    private static volatile int fv = -1;
    private static volatile long hh = -1;
    private static volatile long l = System.currentTimeMillis();
    public static final AtomicLong z = new AtomicLong();
    private static volatile int h = -1;

    public static boolean z() {
        if (!gz && SystemClock.elapsedRealtime() - fo >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            fo = SystemClock.elapsedRealtime();
            try {
                PowerManager powerManager = (PowerManager) com.bytedance.sdk.openadsdk.core.zw.getContext().getSystemService("power");
                if (powerManager != null) {
                    gz = powerManager.isInteractive();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
        }
        return gz;
    }

    public static long g() {
        return l;
    }

    public static void dl() {
        e.set(com.bytedance.sdk.component.utils.v.dl(com.bytedance.sdk.openadsdk.core.zw.getContext()));
        a();
        wp();
        v();
        z(0);
        z(1);
        uy.g(false);
        z((String) null);
    }

    public static int a() {
        if (uy == -1 || m.getAndSet(false)) {
            uy = com.bytedance.sdk.component.utils.v.g(com.bytedance.sdk.openadsdk.core.zw.getContext());
        }
        return uy;
    }

    public static void z(Context context) {
        if (dl) {
            return;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                gz = powerManager.isScreenOn();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        try {
            gk = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            context.getApplicationContext().registerReceiver(gk, intentFilter);
            dl = true;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.wp.z(th2);
        }
    }

    public static void gc() {
        try {
            if (dl && gk != null) {
                com.bytedance.sdk.openadsdk.core.zw.getContext().getApplicationContext().unregisterReceiver(gk);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    static class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            com.bytedance.sdk.component.utils.gz.g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.kb.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.z(intent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(final Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                boolean unused = kb.gz = true;
                com.bytedance.sdk.component.utils.wp.z("DeviceUtils", "screen_on");
            } else {
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    boolean unused2 = kb.gz = false;
                    com.bytedance.sdk.component.utils.wp.z("DeviceUtils", "screen_off");
                    if (com.bytedance.sdk.openadsdk.core.uy.ls().gk()) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.hh.e.z(new com.bytedance.sdk.component.uy.fo("updateScreenStatus") { // from class: com.bytedance.sdk.openadsdk.core.un.kb.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.a.z zVarG = io.g();
                            if (zVarG != null) {
                                zVarG.updateScreenStatus(intent.getAction());
                            }
                        }
                    });
                    return;
                }
                if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                    long unused3 = kb.l = System.currentTimeMillis();
                }
            }
        }
    }

    public static String z(String str) {
        if (!TextUtils.isEmpty(uf) && !z(sy, 1800000L)) {
            return uf;
        }
        String strDl = com.bytedance.sdk.openadsdk.core.dl.a.z().dl("dev14", 1800000L);
        if (TextUtils.isEmpty(strDl)) {
            if (str == null) {
                str = uy.v();
            }
            uf = str;
        } else {
            uf = com.bytedance.sdk.component.utils.z.dl(strDl);
        }
        sy = System.currentTimeMillis();
        return uf;
    }

    public static String m() {
        if (zw()) {
            return tb;
        }
        return uy.g(false)[0];
    }

    public static String e() {
        if (zw()) {
            return iq;
        }
        return uy.g(false)[1];
    }

    private static boolean zw() {
        return (gc.get() || z(io, 1800000L) || TextUtils.isEmpty(tb)) ? false : true;
    }

    public static JSONArray gz() {
        JSONArray jSONArray = new JSONArray();
        try {
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
        if (!uy()) {
            return new JSONArray();
        }
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces == null) {
            return new JSONArray();
        }
        for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
            String name = networkInterface.getName();
            if ("dummy0".equals(name) || "wlan0".equals(name)) {
                Iterator it = Collections.list(networkInterface.getInetAddresses()).iterator();
                while (it.hasNext()) {
                    String hostAddress = ((InetAddress) it.next()).getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (!(hostAddress.indexOf(58) < 0)) {
                            int iIndexOf = hostAddress.indexOf(37);
                            if ("dummy0".equals(name)) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("type", "client_tun");
                                if (iIndexOf >= 0) {
                                    hostAddress = hostAddress.substring(0, iIndexOf);
                                }
                                jSONObject.put("value", hostAddress.toUpperCase());
                                jSONArray.put(jSONObject);
                            } else if ("wlan0".equals(name) || "fe80".equalsIgnoreCase(hostAddress.split("::")[0])) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("type", "client_anpi");
                                if (iIndexOf >= 0) {
                                    hostAddress = hostAddress.substring(0, iIndexOf);
                                }
                                jSONObject2.put("value", hostAddress.toUpperCase());
                                jSONArray.put(jSONObject2);
                            }
                        }
                    }
                }
            }
        }
        return jSONArray;
    }

    public static String[] z(boolean z2) {
        long j;
        String strDl;
        String strDl2;
        String strJs;
        if (zw()) {
            return new String[]{tb, iq};
        }
        String[] strArrIo = {"", ""};
        String strFv = com.bytedance.sdk.openadsdk.core.dl.a.z().fv();
        long j2 = 0;
        if (strFv != null) {
            try {
                JSONObject jSONObject = new JSONObject(strFv);
                strDl = com.bytedance.sdk.component.utils.z.dl(jSONObject.getString("value"));
                try {
                    j = jSONObject.getLong("time");
                } catch (JSONException unused) {
                    j = 0;
                }
            } catch (JSONException unused2) {
                j = 0;
                strDl = null;
                strDl2 = null;
            }
        } else {
            j = 0;
            strDl = null;
        }
        try {
            strJs = com.bytedance.sdk.openadsdk.core.dl.a.z().js();
        } catch (JSONException unused3) {
        }
        if (strJs != null) {
            JSONObject jSONObject2 = new JSONObject(strJs);
            strDl2 = com.bytedance.sdk.component.utils.z.dl(jSONObject2.getString("value"));
            try {
                j2 = jSONObject2.getLong("time");
            } catch (JSONException unused4) {
            }
        } else {
            strDl2 = null;
        }
        if (strDl != null || strDl2 != null) {
            strArrIo[0] = strDl;
            q = strDl;
            strArrIo[1] = strDl2;
            zw = strDl2;
            if (z2) {
                return strArrIo;
            }
        }
        if (gc.getAndSet(false)) {
            strArrIo = io();
            if (TextUtils.isEmpty(strArrIo[0]) && TextUtils.isEmpty(strArrIo[1])) {
                if (strDl == null) {
                    strDl = "";
                }
                strArrIo[0] = strDl;
                strArrIo[1] = strDl2 != null ? strDl2 : "";
            }
        } else {
            if (strDl != null && System.currentTimeMillis() - j > bi.s) {
                strDl = null;
            }
            String str = (strDl2 == null || System.currentTimeMillis() - j2 <= bi.s) ? strDl2 : null;
            if (TextUtils.isEmpty(strDl) && TextUtils.isEmpty(str)) {
                strArrIo = io();
            } else {
                strArrIo[0] = strDl;
                strArrIo[1] = str;
            }
        }
        tb = strArrIo[0];
        iq = strArrIo[1];
        io = System.currentTimeMillis();
        return strArrIo;
    }

    private static String[] io() {
        String[] strArrFo = fo();
        if (TextUtils.isEmpty(strArrFo[0]) && TextUtils.isEmpty(strArrFo[1])) {
            com.bytedance.sdk.openadsdk.core.dl.a.z().i("");
        }
        return strArrFo;
    }

    public static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.dl.a.z().a("dev14", com.bytedance.sdk.component.utils.z.g(str));
        uf = str;
        sy = System.currentTimeMillis();
    }

    public static String[] fo() {
        if (!uy()) {
            return new String[]{"", ""};
        }
        if (com.bytedance.sdk.openadsdk.core.a.z.gz() && !TextUtils.isEmpty(q) && !TextUtils.isEmpty(zw)) {
            new com.bytedance.sdk.openadsdk.core.a.g("device_get_ip").z(5).g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.kb.1
                @Override // java.lang.Runnable
                public void run() {
                    kb.uf();
                }
            });
            return new String[]{q, zw};
        }
        return uf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] uf() {
        String[] strArr = {"", ""};
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            boolean z2 = false;
            boolean z3 = false;
            while (it.hasNext()) {
                for (InetAddress inetAddress : z((NetworkInterface) it.next())) {
                    boolean z4 = inetAddress instanceof Inet4Address;
                    if (!z4 || !z2) {
                        if (z4 || !z3) {
                            if (g(z4, inetAddress, strArr)) {
                                if (!TextUtils.isEmpty(strArr[0]) && !TextUtils.isEmpty(strArr[1])) {
                                    return strArr;
                                }
                            } else {
                                String hostAddress = inetAddress.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress) && !hostAddress.startsWith("127")) {
                                    if (z4) {
                                        com.bytedance.sdk.openadsdk.core.dl.a.z().i(com.bytedance.sdk.component.utils.z.g(hostAddress));
                                        strArr[0] = hostAddress;
                                        q = hostAddress;
                                        tb = hostAddress;
                                        if (z3) {
                                            return strArr;
                                        }
                                        z2 = true;
                                    } else {
                                        int iIndexOf = hostAddress.indexOf(37);
                                        if (iIndexOf >= 0) {
                                            hostAddress = hostAddress.substring(0, iIndexOf);
                                        }
                                        if (dl(hostAddress)) {
                                            com.bytedance.sdk.openadsdk.core.dl.a.z().v(com.bytedance.sdk.component.utils.z.g(hostAddress));
                                            strArr[1] = hostAddress;
                                            zw = hostAddress;
                                            iq = hostAddress;
                                            if (z2) {
                                                return strArr;
                                            }
                                            z3 = true;
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return strArr;
    }

    private static List<InetAddress> z(NetworkInterface networkInterface) {
        if (networkInterface == null) {
            return Collections.emptyList();
        }
        try {
            Object objZ = uf.z(networkInterface, "java.net.NetworkInterface", "addrs", null);
            if (!(objZ instanceof InetAddress[])) {
                return Collections.list(networkInterface.getInetAddresses());
            }
            return Arrays.asList((InetAddress[]) objZ);
        } catch (Throwable unused) {
            return Collections.list(networkInterface.getInetAddresses());
        }
    }

    private static boolean z(boolean z2, InetAddress inetAddress, String[] strArr) {
        if (z2) {
            try {
                if (!TextUtils.isEmpty(strArr[0])) {
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (!z2 && !TextUtils.isEmpty(strArr[1])) {
            return true;
        }
        Class<?> cls = Class.forName("libcore.io.Libcore");
        Field declaredField = cls.getDeclaredField(an.x);
        declaredField.setAccessible(true);
        Object obj = declaredField.get(cls);
        Method method = obj.getClass().getMethod("getnameinfo", InetAddress.class, Integer.TYPE);
        method.setAccessible(true);
        Object objInvoke = method.invoke(obj, inetAddress, Integer.valueOf(OsConstants.NI_NUMERICHOST));
        if (objInvoke == null) {
            return false;
        }
        String strSubstring = (String) objInvoke;
        if (strSubstring.startsWith("127")) {
            return true;
        }
        if (z2) {
            strArr[0] = strSubstring;
            return true;
        }
        int iIndexOf = strSubstring.indexOf(37);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf);
        }
        if (!dl(strSubstring)) {
            return true;
        }
        strArr[1] = strSubstring;
        return true;
    }

    private static boolean g(boolean z2, InetAddress inetAddress, String[] strArr) {
        Field declaredField;
        if (z2) {
            try {
                if (!TextUtils.isEmpty(strArr[0])) {
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (!z2 && !TextUtils.isEmpty(strArr[1])) {
            return true;
        }
        if (z2) {
            declaredField = InetAddress.class.getDeclaredField("holder");
        } else {
            declaredField = Inet6Address.class.getDeclaredField("holder6");
        }
        declaredField.setAccessible(true);
        Object obj = declaredField.get(inetAddress);
        Class<?> cls = obj.getClass();
        if (z2) {
            Field declaredField2 = cls.getDeclaredField("address");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            int iIntValue = obj2 instanceof Integer ? ((Integer) obj2).intValue() : 0;
            byte[] bArr = {(byte) ((iIntValue >>> 24) & 255), (byte) ((iIntValue >>> 16) & 255), (byte) ((iIntValue >>> 8) & 255), (byte) (iIntValue & 255)};
            String strG = g(bArr);
            if (bArr[0] != 127) {
                strArr[0] = strG;
            }
        } else {
            Field declaredField3 = cls.getDeclaredField("ipaddress");
            declaredField3.setAccessible(true);
            Object obj3 = declaredField3.get(obj);
            if (obj3 instanceof byte[]) {
                String strZ = z((byte[]) obj3);
                if (!dl(strZ)) {
                    return true;
                }
                strArr[1] = strZ;
            }
        }
        return true;
    }

    private static String z(byte[] bArr) {
        StringBuilder sb = new StringBuilder(39);
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = i2 << 1;
            sb.append(Integer.toHexString(((bArr[i3] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr[i3 + 1] & 255)));
            if (i2 < 7) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

    private static String g(byte[] bArr) {
        return (bArr[0] & 255) + FileUtils.FILE_EXTENSION_SEPARATOR + (bArr[1] & 255) + FileUtils.FILE_EXTENSION_SEPARATOR + (bArr[2] & 255) + FileUtils.FILE_EXTENSION_SEPARATOR + (bArr[3] & 255);
    }

    private static boolean dl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if ((cCharAt != '2' && cCharAt != '3' && cCharAt != '5') || str.length() < 2) {
            return false;
        }
        char cCharAt2 = str.charAt(1);
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            return true;
        }
        if (cCharAt2 < 'a' || cCharAt2 > 'f') {
            return cCharAt2 >= 'A' && cCharAt2 <= 'F';
        }
        return true;
    }

    public static boolean uy() {
        JSONArray jSONArray;
        int length;
        int i2;
        if (!com.bytedance.sdk.openadsdk.core.zw.g().rg()) {
            return true;
        }
        try {
            jSONArray = new JSONArray(com.bytedance.sdk.openadsdk.core.uy.ls().sy());
            length = jSONArray.length();
        } catch (JSONException unused) {
        }
        for (i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null && !jSONObjectOptJSONObject.isNull("name") && "tt_inner_isw".equals(jSONObjectOptJSONObject.optString("name"))) {
                return jSONObjectOptJSONObject.optBoolean("value", true);
            }
            return true;
        }
        return true;
    }

    public static boolean g(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean dl(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int z(Context context, boolean z2) {
        if (kb != -1) {
            return kb;
        }
        if (z2) {
            String strDl = com.bytedance.sdk.openadsdk.core.dl.a.z().dl("dev06", 2592000000L);
            try {
                if (!TextUtils.isEmpty(strDl)) {
                    kb = Integer.parseInt(strDl);
                }
            } catch (Exception unused) {
            }
            if (kb != -1) {
                return kb;
            }
        }
        if (dl(context)) {
            kb = 3;
        } else if (g(context)) {
            kb = 2;
        } else {
            kb = 1;
        }
        if (z2) {
            com.bytedance.sdk.openadsdk.core.dl.a.z().a("dev06", String.valueOf(kb));
        }
        return kb;
    }

    public static void z(JSONObject jSONObject) throws JSONException {
        if (v.g()) {
            jSONObject.putOpt("os_new", "harmony");
            jSONObject.putOpt("harmonyos_api", v.gc());
            jSONObject.putOpt("harmonyos_version", v.m());
            jSONObject.putOpt("harmonyos_release_type", v.e());
            jSONObject.putOpt("harmonyos_build_version", v.gz());
            jSONObject.putOpt("pure_mode", Integer.valueOf(v.z(com.bytedance.sdk.openadsdk.core.zw.getContext()) ? 1 : 2));
        } else {
            jSONObject.putOpt("os_new", "android");
        }
        jSONObject.putOpt("rom_name", Build.BRAND);
    }

    public static String kb() {
        String languageTag = Locale.getDefault().toLanguageTag();
        return !TextUtils.isEmpty(languageTag) ? languageTag : "";
    }

    public static float wp() {
        if (ls != -2.0f && !z(p, MediaController.RELEASE_UNBIND_TIMEOUT_MS)) {
            return ls;
        }
        int i2 = -1;
        try {
            Context context = com.bytedance.sdk.openadsdk.core.zw.getContext();
            if (context != null) {
                i2 = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.a("DeviceUtils", th.getMessage());
        }
        if (i2 < 0) {
            ls = -1.0f;
        } else {
            ls = Math.round((i2 / 255.0f) * 10.0f) / 10.0f;
        }
        p = System.currentTimeMillis();
        return ls;
    }

    public static class z {
        static float g = 0.0f;
        static int z = -1;

        public static int z(Context context) {
            com.bytedance.sdk.openadsdk.z.g.g.z(context);
            return z;
        }

        public static float g(Context context) {
            com.bytedance.sdk.openadsdk.z.g.g.g(context);
            return g;
        }
    }

    public static void a(Context context) {
        if (f1378a) {
            return;
        }
        try {
            x = new g();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            context.getApplicationContext().registerReceiver(x, intentFilter);
            f1378a = true;
        } catch (Throwable unused) {
        }
    }

    public static void i() {
        try {
            if (f1378a && x != null) {
                com.bytedance.sdk.openadsdk.core.zw.getContext().getApplicationContext().unregisterReceiver(x);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    static class g extends BroadcastReceiver {
        g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            com.bytedance.sdk.component.utils.gz.dl().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.kb.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.z(intent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(Intent intent) {
            int intExtra = -1;
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                boolean booleanExtra = intent.getBooleanExtra("present", false);
                if (booleanExtra) {
                    int intExtra2 = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                    if (intExtra2 == -1) {
                        z.z = intExtra2;
                    } else if (intExtra2 == 2) {
                        z.z = 1;
                    } else {
                        z.z = 0;
                    }
                } else {
                    z.z = 2;
                }
                z.g = (intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1);
                if (!com.bytedance.sdk.openadsdk.core.uy.ls().gk()) {
                    com.bytedance.sdk.openadsdk.z.g.g.z(booleanExtra);
                }
            }
            try {
                intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
            } catch (Exception unused) {
            }
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intExtra == 3) {
                com.bytedance.sdk.component.utils.gz.z().post(new com.bytedance.sdk.component.uy.fo("tt_vol") { // from class: com.bytedance.sdk.openadsdk.core.un.kb.g.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AudioManager audioManager = (AudioManager) com.bytedance.sdk.openadsdk.core.zw.getContext().getSystemService("audio");
                            if (audioManager == null) {
                                return;
                            }
                            int unused2 = kb.h = audioManager.getStreamVolume(3);
                        } catch (Exception unused3) {
                        }
                    }
                });
            }
        }
    }

    public static int v() {
        if (fv != -1 && !z(js, 60000L)) {
            return fv;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) com.bytedance.sdk.openadsdk.core.zw.getContext().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        fv = accessibilityManager.isEnabled() ? 1 : 0;
        js = System.currentTimeMillis();
        return fv;
    }

    public static void pf() {
        Context context = com.bytedance.sdk.openadsdk.core.zw.getContext();
        if (context != null) {
            int i2 = eo.i();
            com.bytedance.sdk.openadsdk.core.dl.a.z().z("cpu_cnt", i2);
            eo.z = i2;
            int iDl = eo.dl(eo.i());
            com.bytedance.sdk.openadsdk.core.dl.a.z().z("cpu_max_freq", iDl);
            eo.g = iDl;
            int iA = eo.a(eo.i());
            com.bytedance.sdk.openadsdk.core.dl.a.z().z("cpu_min_freq", iA);
            eo.dl = iA;
            String strA = eo.a(context, "MemTotal");
            if (strA != null) {
                com.bytedance.sdk.openadsdk.core.dl.a.z().g("total_memory", strA);
                eo.f1373a = strA;
            }
            long jFv = eo.fv();
            com.bytedance.sdk.openadsdk.core.dl.a.z().z("internal_storage", jFv);
            eo.gc = jFv;
            long jZ = com.bytedance.sdk.component.utils.i.z();
            com.bytedance.sdk.openadsdk.core.dl.a.z().z("free_storage", jZ);
            eo.m = jZ;
            long jQ = eo.q();
            com.bytedance.sdk.openadsdk.core.dl.a.z().z("sdcard_storage", jQ);
            eo.e = jQ;
            boolean zZw = eo.zw();
            com.bytedance.sdk.openadsdk.core.dl.a.z().z("is_root", zZw ? 1 : 0);
            eo.gz = zZw ? 1 : 0;
        }
    }

    public static void gc(Context context) {
        com.bytedance.sdk.component.utils.uf.z(new dl(), context);
    }

    static class dl implements uf.z {
        dl() {
        }

        @Override // com.bytedance.sdk.component.utils.uf.z
        public void z(Context context, Intent intent, boolean z, int i) {
            if (kb.e.get() == i) {
                return;
            }
            kb.e.set(i);
            kb.gc.set(true);
            kb.m.set(true);
            com.bytedance.sdk.component.a.z zVarG = io.g();
            if (com.bytedance.sdk.openadsdk.core.uy.ls().gk() || zVarG == null) {
                return;
            }
            zVarG.updateNetworkStatus(i);
        }
    }

    public static String z(int i2) {
        if (i2 == 0 && !TextUtils.isEmpty(wp) && !z(v, 60000L)) {
            return wp;
        }
        if (i2 == 1 && !TextUtils.isEmpty(i) && !z(pf, 60000L)) {
            return i;
        }
        String strDl = dl(i2);
        if (i2 == 0) {
            wp = strDl;
            v = System.currentTimeMillis();
        } else if (i2 == 1) {
            i = strDl;
            pf = System.currentTimeMillis();
        }
        return strDl;
    }

    private static String dl(int i2) {
        TelephonyManager telephonyManagerZ;
        List<CellInfo> allCellInfo;
        int dbm;
        WifiInfo wifiInfoG;
        int iDl = com.bytedance.sdk.component.utils.v.dl(com.bytedance.sdk.openadsdk.core.zw.getContext());
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = com.bytedance.sdk.openadsdk.core.uy.ls().p();
        if (iDl == 4) {
            if (i2 == 0) {
                try {
                    return (aVarP.a() && (wifiInfoG = com.bytedance.sdk.openadsdk.core.tb.g()) != null) ? wifiInfoG.getRssi() + "dBm" : "unknown";
                } catch (Throwable unused) {
                }
            }
            return "unknown";
        }
        if (aVarP.dl() && aVarP.z() && i2 == 1) {
            try {
                if (!com.bytedance.sdk.openadsdk.core.tb.wp() || (telephonyManagerZ = com.bytedance.sdk.openadsdk.core.tb.z()) == null || (allCellInfo = telephonyManagerZ.getAllCellInfo()) == null) {
                    return "unknown";
                }
                CellInfo cellInfo = allCellInfo.get(0);
                if (cellInfo instanceof CellInfoGsm) {
                    dbm = ((CellInfoGsm) cellInfo).getCellSignalStrength().getDbm();
                } else if (cellInfo instanceof CellInfoCdma) {
                    dbm = ((CellInfoCdma) cellInfo).getCellSignalStrength().getDbm();
                } else if (cellInfo instanceof CellInfoLte) {
                    dbm = ((CellInfoLte) cellInfo).getCellSignalStrength().getDbm();
                } else if (cellInfo instanceof CellInfoWcdma) {
                    dbm = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getDbm();
                } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
                    dbm = ((CellInfoNr) cellInfo).getCellSignalStrength().getDbm();
                } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoTdscdma)) {
                    dbm = ((CellInfoTdscdma) cellInfo).getCellSignalStrength().getDbm();
                }
                return Integer.MIN_VALUE == dbm ? "unknown" : dbm + "dBm";
            } catch (Throwable unused2) {
            }
        }
        return "unknown";
    }

    private static boolean z(long j, long j2) {
        return System.currentTimeMillis() - j > j2;
    }

    public static int ls() {
        return (int) (com.bytedance.sdk.openadsdk.core.zw.getContext().getResources().getConfiguration().fontScale * 16.0f);
    }

    public static JSONObject z(int i2, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ACTD.APPID_KEY, com.bytedance.sdk.openadsdk.core.uy.ls().q());
            jSONObject.put("name", com.bytedance.sdk.openadsdk.core.uy.ls().iq());
            g(jSONObject);
            com.bytedance.sdk.openadsdk.pf.g.z(jSONObject, i2);
            jSONObject.put("is_paid_app", com.bytedance.sdk.openadsdk.core.uy.ls().zw());
            if (!com.bytedance.sdk.openadsdk.core.dl.a.z().e(i2)) {
                jSONObject.put("network_speed", com.bytedance.sdk.openadsdk.core.io.z.z());
            }
            jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.core.gz.z.gz());
            jSONObject.put("useful_open_sdk", com.bytedance.sdk.openadsdk.core.g.z.g.a.dl().g());
            jSONObject.put("real_app_name", com.bytedance.sdk.openadsdk.core.gz.z.g(com.bytedance.sdk.openadsdk.core.zw.getContext()));
            jSONObject.put("app_cold_startup_time", com.bytedance.sdk.openadsdk.core.v.dl.gc().dl());
            jSONObject.put("sdk_init_timestamp", com.bytedance.sdk.openadsdk.core.v.dl.gc().a());
            if (z2) {
                jSONObject.put("session_ad_index", z.addAndGet(1L));
                if (com.bytedance.sdk.openadsdk.core.zw.g().li()) {
                    long jDl = com.bytedance.sdk.openadsdk.core.v.z.dl();
                    jSONObject.put("app_total_7_duration", com.bytedance.sdk.openadsdk.core.v.z.a() + jDl);
                    jSONObject.put("app_use_7_duration", jDl);
                    jSONObject.put("start_session", com.bytedance.sdk.openadsdk.core.v.z.gc());
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void g(JSONObject jSONObject) {
        try {
            jSONObject.put(an.o, eo.fo());
            jSONObject.put("version_code", eo.uy());
            jSONObject.put("version", eo.kb());
        } catch (Exception unused) {
        }
    }

    public static void z(long j) {
        if (j == -1 || hh == j) {
            return;
        }
        hh = j;
        com.bytedance.sdk.openadsdk.core.dl.a.z().z("dev19", j);
    }

    public static long p() {
        if (hh != -1) {
            return hh;
        }
        return com.bytedance.sdk.openadsdk.core.dl.a.z().g("dev19", -1L);
    }

    public static int fv() {
        if (h >= 0) {
            return h;
        }
        try {
            AudioManager audioManager = (AudioManager) com.bytedance.sdk.openadsdk.core.zw.getContext().getSystemService("audio");
            if (audioManager == null) {
                return 0;
            }
            h = audioManager.getStreamVolume(3);
            return h;
        } catch (Exception unused) {
            return 0;
        }
    }
}
