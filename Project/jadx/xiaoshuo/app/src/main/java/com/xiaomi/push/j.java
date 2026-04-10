package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.market.sdk.utils.Region;
import com.xiaomi.mipush.sdk.Constants;
import com.yuewen.eq2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import miuix.android.content.SystemIntent;

/* JADX INFO: loaded from: classes8.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f8112a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Map<String, m> f700a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f8113b = -1;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m611a() {
        return a() == 1;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m615b() {
        return a() == 2;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public static boolean m616c() {
        if (f8113b < 0) {
            f8113b = !m618e() ? 1 : 0;
        }
        return f8113b > 0;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public static boolean m617d() {
        return !m.China.name().equalsIgnoreCase(a(b()).name());
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public static boolean m618e() {
        String strA = "";
        try {
            strA = q.a(com.xiaomi.ad.c.f7255a, "");
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(strA);
    }

    public static int a() {
        if (f8112a == 0) {
            try {
                int i = 1;
                if (!((TextUtils.isEmpty(m609a(com.xiaomi.ad.c.f7255a)) && TextUtils.isEmpty(m609a("ro.miui.ui.version.name"))) ? false : true)) {
                    i = 2;
                }
                f8112a = i;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a("get isMIUI failed", th);
                f8112a = 0;
            }
            com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + f8112a);
        }
        return f8112a;
    }

    public static String b() {
        String strA = q.a("ro.miui.region", "");
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = m614b(q.a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(strA)) {
            com.xiaomi.channel.commonutils.logger.b.m106a("get region from system, region = " + strA);
        }
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String country = Locale.getDefault().getCountry();
        com.xiaomi.channel.commonutils.logger.b.m106a("locale.default.country = " + country);
        return country;
    }

    public static String d() {
        return m609a("ro.build.characteristics");
    }

    public static String e() {
        return m609a("ro.product.manufacturer");
    }

    public static String c() {
        return m609a("ro.miui.ui.version.name");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m608a() {
        int iA = C0855r.a();
        return (!m611a() || iA <= 0) ? "" : iA < 2 ? "alpha" : iA < 3 ? "development" : "stable";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m609a(String str) {
        try {
            try {
                return (String) bj.a("android.os.SystemProperties", "get", str, "");
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to get property. " + e);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m612a(Context context) {
        return context != null && m613a(context.getPackageName());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m613a(String str) {
        return SystemIntent.ACTIVATE_SERVICE_HOST_PACKAGE.equals(str);
    }

    public static m a(String str) {
        m mVarB = b(str);
        return mVarB == null ? m.Global : mVarB;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static void m610a() {
        if (f700a != null) {
            return;
        }
        HashMap map = new HashMap();
        f700a = map;
        map.put("CN", m.China);
        Map<String, m> map2 = f700a;
        m mVar = m.Europe;
        map2.put("FI", mVar);
        f700a.put("SE", mVar);
        f700a.put("NO", mVar);
        f700a.put("FO", mVar);
        f700a.put("EE", mVar);
        f700a.put("LV", mVar);
        f700a.put("LT", mVar);
        f700a.put("BY", mVar);
        f700a.put("MD", mVar);
        f700a.put("UA", mVar);
        f700a.put("PL", mVar);
        f700a.put("CZ", mVar);
        f700a.put("SK", mVar);
        f700a.put("HU", mVar);
        f700a.put("DE", mVar);
        f700a.put("AT", mVar);
        f700a.put("CH", mVar);
        f700a.put("LI", mVar);
        f700a.put("GB", mVar);
        f700a.put("IE", mVar);
        f700a.put("NL", mVar);
        f700a.put("BE", mVar);
        f700a.put("LU", mVar);
        f700a.put("FR", mVar);
        f700a.put("RO", mVar);
        f700a.put("BG", mVar);
        f700a.put("RS", mVar);
        f700a.put("MK", mVar);
        f700a.put("AL", mVar);
        f700a.put("GR", mVar);
        f700a.put("SI", mVar);
        f700a.put("HR", mVar);
        f700a.put("IT", mVar);
        f700a.put("SM", mVar);
        f700a.put("MT", mVar);
        f700a.put(Region.ES, mVar);
        f700a.put("PT", mVar);
        f700a.put("AD", mVar);
        f700a.put("CY", mVar);
        f700a.put("DK", mVar);
        f700a.put("IS", mVar);
        f700a.put("UK", mVar);
        f700a.put("EL", mVar);
        f700a.put(Region.RU, m.Russia);
        f700a.put(Region.IN, m.India);
    }

    private static m b(String str) {
        m610a();
        return f700a.get(str.toUpperCase());
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(SystemIntent.ACTIVATE_SERVICE_HOST_PACKAGE, 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private static String m614b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return strArrSplit.length > 0 ? strArrSplit[0] : str;
    }

    public static int a(Context context) {
        String strM609a = m609a(com.xiaomi.ad.c.f7255a);
        if (TextUtils.isEmpty(strM609a) || !TextUtils.isDigitsOnly(strM609a)) {
            return 0;
        }
        return Integer.parseInt(strM609a);
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + " " + a(intent.getExtras());
    }

    public static String a(Bundle bundle) {
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append(eq2.g);
        } else {
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(com.alipay.sdk.m.p.a.h);
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    sb.append(Arrays.toString((int[]) obj));
                } else if (obj instanceof byte[]) {
                    sb.append(Arrays.toString((byte[]) obj));
                } else if (obj instanceof boolean[]) {
                    sb.append(Arrays.toString((boolean[]) obj));
                } else if (obj instanceof short[]) {
                    sb.append(Arrays.toString((short[]) obj));
                } else if (obj instanceof long[]) {
                    sb.append(Arrays.toString((long[]) obj));
                } else if (obj instanceof float[]) {
                    sb.append(Arrays.toString((float[]) obj));
                } else if (obj instanceof double[]) {
                    sb.append(Arrays.toString((double[]) obj));
                } else if (obj instanceof String[]) {
                    sb.append(Arrays.toString((String[]) obj));
                } else if (obj instanceof CharSequence[]) {
                    sb.append(Arrays.toString((CharSequence[]) obj));
                } else if (obj instanceof Parcelable[]) {
                    sb.append(Arrays.toString((Parcelable[]) obj));
                } else if (obj instanceof Bundle) {
                    sb.append(a((Bundle) obj));
                } else {
                    sb.append(obj);
                }
                z = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
