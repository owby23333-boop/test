package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.l0;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static String a;
    private static String b;

    public static String a() {
        return l0.a("https://" + a.f().d());
    }

    public static String b() {
        return l0.a(c() + "/api/ad/union/mediation/exchange/");
    }

    private static String c() {
        String strE = e();
        return !TextUtils.isEmpty(strE) ? strE : "https://gromore.pangolin-sdk-toutiao.com";
    }

    public static String d() {
        return l0.a(c() + "/api/ad/union/mediation/stats/");
    }

    private static String e() {
        String strD = d.S().d("server_dist_host");
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        if (!TextUtils.equals(strD, a) || TextUtils.isEmpty(b)) {
            a = strD;
            b = null;
            if (!TextUtils.isEmpty(a)) {
                b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(a, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
            }
            if (TextUtils.isEmpty(b)) {
                return null;
            }
            b = "https://" + b;
        }
        return b;
    }

    public static String f() {
        return l0.a(c() + "/api/ad/union/mediation/reward_video/reward/");
    }

    public static String g() {
        return l0.a(c() + "/api/ad/union/mediation/config/");
    }
}
