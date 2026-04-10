package com.sntech.okhttpconnection.log;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.kuaishou.weapon.p0.bh;
import com.sntech.okhttpconnection.log.Cif;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.sntech.okhttpconnection.log.for, reason: invalid class name */
/* JADX INFO: compiled from: DeviceUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cfor {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static final Set<String> f119do;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static final Set<String> f120if;

    static {
        HashSet hashSet = new HashSet(5);
        f119do = hashSet;
        HashSet hashSet2 = new HashSet(1);
        f120if = hashSet2;
        hashSet.add("com.tencent.mm");
        hashSet.add("com.eg.android.AlipayGphone");
        hashSet.add("com.xunmeng.pinduoduo");
        hashSet.add(AgooConstants.TAOBAO_PACKAGE);
        hashSet.add("com.baidu.searchbox");
        hashSet.add(TbsConfig.APP_QQ);
        hashSet.add(TbsConfig.APP_QB);
        hashSet.add("com.ss.android.ugc.aweme");
        hashSet.add("com.snda.wifilocating");
        hashSet.add("com.autonavi.minimap");
        hashSet.add("com.smile.gifmaker");
        hashSet.add("com.tencent.qqlive");
        hashSet.add("com.sankuai.meituan");
        hashSet.add("com.jingdong.app.mall");
        hashSet.add("com.qiyi.video");
        hashSet.add("com.bytedance.ad.deliver");
        hashSet.add("com.bytedance.ad.videotool");
        hashSet.add("com.ss.android.lark");
        hashSet.add("com.taou.maimai");
        hashSet.add("com.kwad.demo");
        hashSet.add("com.union_test.toutiao");
        hashSet.add("com.qq.e.union.demo");
        hashSet2.add("android.permission.QUERY_ALL_PACKAGES");
    }

    /* JADX INFO: renamed from: case, reason: not valid java name */
    public static boolean m122case(Context context) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("tel:123456"));
        intent.setAction("android.intent.action.DIAL");
        boolean z2 = intent.resolveActivity(context.getPackageManager()) != null;
        String str = Build.FINGERPRINT;
        if (str.startsWith("generic") || str.toLowerCase().contains("vbox") || str.toLowerCase().contains("test-keys")) {
            return true;
        }
        String str2 = Build.MODEL;
        if (str2.contains("google_sdk") || str2.contains("Emulator") || str2.contains("Android SDK built for x86") || Build.SERIAL.equalsIgnoreCase(DispatchConstants.ANDROID) || Build.MANUFACTURER.contains("Genymotion")) {
            return true;
        }
        return (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT) || ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName().toLowerCase().equals(DispatchConstants.ANDROID) || !z2;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static boolean m124do() {
        String[] strArr = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
        for (int i2 = 0; i2 < 8; i2++) {
            if (new File(strArr[i2]).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public static JSONObject m125for(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(16384)) {
            if (((HashSet) f119do).contains(packageInfo.packageName)) {
                arrayList.add(packageInfo.packageName);
            }
        }
        arrayList2.addAll(f119do);
        arrayList2.removeAll(arrayList);
        jSONObject.put("have_packages", new JSONArray((Collection) arrayList));
        jSONObject.put("no_packages", new JSONArray((Collection) arrayList2));
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0230 A[Catch: Exception -> 0x0241, all -> 0x0250, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:7:0x0018, B:9:0x002e, B:11:0x0034, B:17:0x004a, B:18:0x004f, B:20:0x006a, B:25:0x0074, B:26:0x00ac, B:28:0x00b6, B:33:0x00c5, B:39:0x00dc, B:47:0x00ee, B:48:0x00f1, B:51:0x00f7, B:52:0x010a, B:54:0x0139, B:55:0x014a, B:56:0x015a, B:61:0x0167, B:63:0x0181, B:68:0x0190, B:70:0x0194, B:72:0x019e, B:81:0x01b8, B:83:0x01c7, B:88:0x01d6, B:90:0x01da, B:92:0x01e4, B:101:0x01fe, B:103:0x0230, B:93:0x01e9, B:95:0x01ef, B:97:0x01f5, B:73:0x01a3, B:75:0x01a9, B:77:0x01af, B:42:0x00e1, B:44:0x00e7, B:109:0x0245, B:111:0x024b), top: B:122:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c7 A[Catch: Exception -> 0x0241, all -> 0x0250, TryCatch #1 {, blocks: (B:4:0x0003, B:7:0x0018, B:9:0x002e, B:11:0x0034, B:17:0x004a, B:18:0x004f, B:20:0x006a, B:25:0x0074, B:26:0x00ac, B:28:0x00b6, B:33:0x00c5, B:39:0x00dc, B:47:0x00ee, B:48:0x00f1, B:51:0x00f7, B:52:0x010a, B:54:0x0139, B:55:0x014a, B:56:0x015a, B:61:0x0167, B:63:0x0181, B:68:0x0190, B:70:0x0194, B:72:0x019e, B:81:0x01b8, B:83:0x01c7, B:88:0x01d6, B:90:0x01da, B:92:0x01e4, B:101:0x01fe, B:103:0x0230, B:93:0x01e9, B:95:0x01ef, B:97:0x01f5, B:73:0x01a3, B:75:0x01a9, B:77:0x01af, B:42:0x00e1, B:44:0x00e7, B:109:0x0245, B:111:0x024b), top: B:122:0x0003 }] */
    @android.annotation.SuppressLint({"MissingPermission"})
    /* JADX INFO: renamed from: if, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized org.json.JSONObject m127if(android.content.Context r9) {
        /*
            Method dump skipped, instruction units count: 595
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sntech.okhttpconnection.log.Cfor.m127if(android.content.Context):org.json.JSONObject");
    }

    /* JADX INFO: renamed from: new, reason: not valid java name */
    public static String m129new(Context context) {
        int port;
        String property;
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
        if (TextUtils.isEmpty(property)) {
            return null;
        }
        return property + ":" + port;
    }

    /* JADX INFO: renamed from: try, reason: not valid java name */
    public static String m130try(Context context) {
        try {
            return Cif.Cfor.m134do(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static JSONObject m123do(Context context) {
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            for (String str : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                if (((HashSet) f120if).contains(str)) {
                    arrayList.add(str);
                }
            }
            arrayList2.addAll(f120if);
            arrayList2.removeAll(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String[] strArrSplit = ((String) it.next()).split("\\.");
                jSONObject.put(strArrSplit[strArrSplit.length - 1], 1);
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                String[] strArrSplit2 = ((String) it2.next()).split("\\.");
                jSONObject.put(strArrSplit2[strArrSplit2.length - 1], 0);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public static boolean m126for() {
        try {
            String name = "";
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.isUp()) {
                    name = networkInterface.getName();
                }
                if (Cdo.m119do()) {
                    String str = "IFACE NAME: " + name;
                }
                if (name.contains("tun") || name.contains("ppp") || name.contains("pptp")) {
                    return true;
                }
            }
            return false;
        } catch (SocketException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static boolean m128if() {
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"which", bh.f16586y});
            try {
                if (new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine() != null) {
                    processExec.destroy();
                    return true;
                }
                processExec.destroy();
                return false;
            } catch (Throwable unused) {
                if (processExec != null) {
                    processExec.destroy();
                }
                return false;
            }
        } catch (Throwable unused2) {
            processExec = null;
        }
    }
}
