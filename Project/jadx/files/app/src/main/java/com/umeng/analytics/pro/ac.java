package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: DeviceIdSupplier.java */
/* JADX INFO: loaded from: classes3.dex */
public class ac {
    private static final String a = "ro.build.version.emui";
    private static final String b = "hw_sc.build.platform.version";

    public static z a(Context context) {
        String str = Build.BRAND;
        al.a("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI) || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("华为")) {
            return new ad();
        }
        if (str.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI) || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new ak();
        }
        if (str.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO)) {
            return new aj();
        }
        if (str.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO) || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new ah();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new ae();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new ag();
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG")) {
            return new ai();
        }
        if (b()) {
            return new ab();
        }
        if (a()) {
            return new ad();
        }
        if (str.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_MEIZU) || str.equalsIgnoreCase("mblu")) {
            return new af();
        }
        return null;
    }

    private static boolean b() {
        return !TextUtils.isEmpty(a("ro.coolos.version"));
    }

    private static boolean a() {
        return (TextUtils.isEmpty(a(a)) && TextUtils.isEmpty(a(b))) ? false : true;
    }

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
