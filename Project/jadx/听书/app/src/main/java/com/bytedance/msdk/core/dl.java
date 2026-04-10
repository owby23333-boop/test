package com.bytedance.msdk.core;

import android.text.TextUtils;
import com.bytedance.msdk.gz.lq;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static String g;
    private static String z;

    public static String z() {
        return lq.z(gc() + "/api/ad/union/mediation/config/");
    }

    public static String g() {
        return lq.z("https://" + g.g().kb());
    }

    public static String dl() {
        return lq.z(gc() + "/api/ad/union/mediation/exchange/");
    }

    public static String a() {
        return lq.z(gc() + "/api/ad/union/mediation/reward_video/reward/");
    }

    private static String gc() {
        String strM = m();
        return !TextUtils.isEmpty(strM) ? strM : "https://gromore.pangolin-sdk-toutiao.com";
    }

    private static String m() {
        String strG = com.bytedance.msdk.e.z.z().g("server_dist_host");
        if (TextUtils.isEmpty(strG)) {
            return null;
        }
        if (TextUtils.equals(strG, z) && !TextUtils.isEmpty(g)) {
            return g;
        }
        z = strG;
        g = null;
        if (!TextUtils.isEmpty(strG)) {
            g = com.bytedance.msdk.gz.z.g(z, com.bytedance.msdk.gz.g.z());
        }
        if (TextUtils.isEmpty(g)) {
            return null;
        }
        String str = "https://" + g;
        g = str;
        return str;
    }
}
