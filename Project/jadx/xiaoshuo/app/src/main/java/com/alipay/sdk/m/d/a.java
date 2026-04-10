package com.alipay.sdk.m.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ryg.utils.DLConstants;
import com.xiaomi.ad.mediation.DspNameConstant;
import xcrash.TombstoneParser;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1791a = "ro.build.version.emui";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1792b = "hw_sc.build.platform.version";

    public static com.alipay.sdk.m.c.b a(Context context) {
        String str = Build.BRAND;
        com.alipay.sdk.m.e.a.b("Device", TombstoneParser.keyBrand, str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("huawei") || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("华为")) {
            return new b();
        }
        if (str.equalsIgnoreCase(DspNameConstant.DSP_XIAOMI) || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new i();
        }
        if (str.equalsIgnoreCase("vivo")) {
            return new h();
        }
        if (str.equalsIgnoreCase("oppo") || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new f();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new c();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new e();
        }
        if (str.equalsIgnoreCase(DLConstants.BRAND_SAMSUNG)) {
            return new g();
        }
        if (a()) {
            return new b();
        }
        if (str.equalsIgnoreCase("meizu") || str.equalsIgnoreCase("mblu")) {
            return new d();
        }
        return null;
    }

    public static boolean a() {
        return (TextUtils.isEmpty(a(f1791a)) && TextUtils.isEmpty(a(f1792b))) ? false : true;
    }

    public static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
