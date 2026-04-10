package com.bytedance.sdk.openadsdk.core.un;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class uy {
    public static String z() {
        return q().getAndroidId();
    }

    public static String g() {
        return q().getDeviceModel();
    }

    public static String dl() {
        return q().getLocalLanguage();
    }

    public static String a() {
        return q().getMcc();
    }

    public static String gc() {
        return q().getMnc();
    }

    public static String m() {
        return q().getTotalMem();
    }

    public static String e() {
        return q().getTotalSpace();
    }

    public static String gz() {
        return q().getImei(null);
    }

    public static String fo() {
        return q().getWifiMac(null);
    }

    public static String uy() {
        return q().getCompilingTime();
    }

    public static String kb() {
        return q().getBuildSerial();
    }

    public static String wp() {
        return q().getMacAddress(null);
    }

    public static int z(boolean z) {
        return q().getDeviceType(z);
    }

    public static String i() {
        return q().getWebViewUA();
    }

    public static String v() {
        return q().getIP();
    }

    public static String pf() {
        return q().getIpv6();
    }

    public static String[] g(boolean z) {
        return q().getNewIpAddrs(z);
    }

    public static String z(com.bytedance.sdk.openadsdk.core.uf.z zVar) {
        return q().getWifiMac(Boolean.valueOf((zVar.g() && zVar.dl()) ? false : true));
    }

    public static String g(com.bytedance.sdk.openadsdk.core.uf.z zVar) {
        return q().getImei(Boolean.valueOf(zVar.z()));
    }

    public static List<ResolveInfo> z(Intent intent, int i) {
        return com.bytedance.sdk.openadsdk.core.zw.getContext().getPackageManager().queryIntentActivities(intent, i);
    }

    public static String dl(com.bytedance.sdk.openadsdk.core.uf.z zVar) {
        return q().getMacAddress(Boolean.valueOf(zVar.g()));
    }

    public static com.bytedance.sdk.component.a.z.dl ls() {
        return q().getLocation();
    }

    public static String a(com.bytedance.sdk.openadsdk.core.uf.z zVar) {
        return q().getSSID(Boolean.valueOf((zVar.g() && zVar.dl()) ? false : true));
    }

    public static String gc(com.bytedance.sdk.openadsdk.core.uf.z zVar) {
        return q().getImsi(Boolean.valueOf(zVar.z()));
    }

    public static String dl(boolean z) {
        return q().getOAID(z);
    }

    public static String p() {
        return q().getAppLogDid();
    }

    public static String fv() {
        return q().getUUId();
    }

    public static int js() {
        return q().getTimeZoneInt();
    }

    public static String tb() {
        return q().getRom();
    }

    public static com.bytedance.sdk.component.a.z.z q() {
        return (com.bytedance.sdk.component.a.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("device_info");
    }
}
