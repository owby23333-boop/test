package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class ag {
    private static String sAppTag = "";

    public static void e(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", str, j);
    }

    public static long V(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_pref", str, 0L);
    }

    public static void f(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_length", str, j);
    }

    public static long W(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_download_package_length", str, 0L);
    }

    public static void g(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_md5", str, str2);
    }

    public static String X(Context context, String str) {
        return context == null ? "" : b(context, "ksadsdk_download_package_md5", str, "");
    }

    public static String cR(Context context) {
        return context == null ? "" : b(context, "ksadsdk_egid", "KEY_SDK_EGID", "");
    }

    private static String cS(Context context) {
        return context == null ? "" : b(context, "ksadsdk_uaid", "KEY_SDK_UAID", "");
    }

    public static String cT(Context context) {
        return context == null ? "" : b(context, "ksadsdk_uaid_token", "KEY_SDK_UAID_TOKEN", "");
    }

    public static boolean Qq() {
        return c(getContext(), "ksadsdk_uaid_enable", "KEY_SDK_UAID_ENABLE", false);
    }

    public static long Qr() {
        return b(getContext(), "ksadsdk_uaid_expire_sec", "KEY_SDK_UAID_EXPIRE_SEC", 0L);
    }

    private static long Qs() {
        return b(getContext(), "ksadsdk_uaid_create_time", "KEY_SDK_UAID_CREATE_TIME", 0L);
    }

    public static void d(Context context, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", j);
    }

    public static long cU(Context context) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", 0L);
    }

    public static void Y(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_egid", "KEY_SDK_EGID", str);
    }

    public static void Z(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid", "KEY_SDK_UAID", str);
    }

    public static void aa(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid_token", "KEY_SDK_UAID_TOKEN", str);
    }

    public static void e(Context context, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid_create_time", "KEY_SDK_UAID_CREATE_TIME", j);
    }

    public static void c(Context context, boolean z) {
        if (context == null) {
            return;
        }
        b(context, "ksadsdk_uaid_enable", "KEY_SDK_UAID_ENABLE", z);
    }

    public static void f(Context context, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid_expire_sec", "KEY_SDK_UAID_EXPIRE_SEC", j);
    }

    public static void l(Context context, int i) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", i);
    }

    public static int cV(Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", 0);
    }

    public static String cW(Context context) {
        if (context == null) {
            return "";
        }
        String strB = b(context, "ksadsdk_model", "KEY_SDK_MODEL", "");
        bo.i(strB, "ksadsdk_model", "KEY_SDK_MODEL");
        return strB;
    }

    public static void ab(Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_model", "KEY_SDK_MODEL", str, true);
    }

    public static String Qt() {
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", "");
    }

    public static void ac(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", str);
    }

    public static void m(Context context, int i) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", i);
    }

    public static int cX(Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", 0);
    }

    public static void ad(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", str);
    }

    public static String cY(Context context) {
        return context == null ? "" : b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", "");
    }

    public static String Qu() {
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", "");
    }

    public static void ae(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", str);
    }

    public static String Qv() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (bn.RK()) {
            return b(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
        }
        return b(context, "ksadsdk_splash_daily_show_count", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
    }

    public static void af(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", str);
        bn.RJ();
    }

    public static String Qw() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (bn.RM()) {
            return h("ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
        }
        return b(context, "ksadsdk_reward_auto_call_app_card_show_count", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static void ag(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
        bn.RL();
    }

    public static String Qx() {
        return h("ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static void ah(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
    }

    public static String cZ(Context context) {
        return context == null ? "" : b(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", "");
    }

    public static void ai(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", str);
    }

    public static void aj(Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.utils.ag.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ag.ak(ServiceProvider.getContext(), str);
            }
        });
    }

    public static void ak(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", "appTag", str);
    }

    public static String Qy() {
        if (!TextUtils.isEmpty(sAppTag)) {
            return sAppTag;
        }
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_pref", "appTag", "");
    }

    public static void al(Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_pref", "webview_ua", str, true);
    }

    public static String da(Context context) {
        if (context == null) {
            return "";
        }
        String strH = h("ksadsdk_pref", "webview_ua", "");
        bo.i(strH, "ksadsdk_pref", "webview_ua");
        return strH;
    }

    public static String Qz() {
        Context context = getContext();
        return context == null ? "" : cR(context);
    }

    public static String QA() {
        Context context = getContext();
        return context == null ? "" : cS(context);
    }

    public static String QB() {
        Context context = getContext();
        return context == null ? "" : cT(context);
    }

    public static boolean QC() {
        return !TextUtils.isEmpty(QB());
    }

    public static boolean QD() {
        return (TextUtils.isEmpty(QA()) || QE()) ? false : true;
    }

    private static boolean QE() {
        long jCurrentTimeMillis = (System.currentTimeMillis() - Qs()) / 1000;
        long jQr = Qr();
        return jQr != 0 && jCurrentTimeMillis >= jQr;
    }

    public static String db(Context context) {
        if (bn.RH()) {
            return bn.ax(context.getApplicationContext(), "ksadsdk_sdk_config_data");
        }
        String strH = bo.h("ksadsdk_sdk_config_data", "config_str", "");
        bn.i(context.getApplicationContext(), "ksadsdk_sdk_config_data", strH);
        return strH;
    }

    public static void am(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        bn.j(context.getApplicationContext(), "ksadsdk_sdk_config_data", str);
    }

    public static long QF() {
        return b("ksadsdk_push_ad_common", "key_push_last_show_time", -1L);
    }

    public static void aZ(long j) {
        a("ksadsdk_push_ad_common", "key_push_last_show_time", j);
    }

    public static String QG() {
        return getContext() == null ? "" : h("ksadsdk_install_tips_show_count", "init_install_tips_show_count", "");
    }

    public static void an(Context context, String str) {
        if (context == null) {
            return;
        }
        g("ksadsdk_install_tips_show_count", "init_install_tips_show_count", str);
    }

    public static void QH() {
        b("ksadsdk_perf", "image_load_total", c("ksadsdk_perf", "image_load_total", 0) + 1);
    }

    public static void QI() {
        b("ksadsdk_perf", "image_load_suc", c("ksadsdk_perf", "image_load_suc", 0) + 1);
    }

    public static void QJ() {
        b("ksadsdk_perf", "image_load_failed", c("ksadsdk_perf", "image_load_failed", 0) + 1);
    }

    public static void ba(long j) {
        b("ksadsdk_perf", "image_load_complete_count", c("ksadsdk_perf", "image_load_complete_count", 0) + 1);
        a("ksadsdk_perf", "image_load_complete_total", b("ksadsdk_perf", "image_load_complete_total", 0L) + j);
    }

    public static double QK() {
        int iC = c("ksadsdk_perf", "image_load_complete_count", 0);
        long jB = b("ksadsdk_perf", "image_load_complete_total", 0L);
        b("ksadsdk_perf", "image_load_complete_count", 0);
        a("ksadsdk_perf", "image_load_complete_total", 0L);
        if (iC == 0) {
            return 0.0d;
        }
        return jB / ((double) iC);
    }

    public static int QL() {
        int iC = c("ksadsdk_perf", "image_load_total", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "imageLoadTotal:" + iC);
        b("ksadsdk_perf", "image_load_total", 0);
        return iC;
    }

    public static int QM() {
        int iC = c("ksadsdk_perf", "image_load_suc", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "imageLoadSuccess:" + iC);
        b("ksadsdk_perf", "image_load_suc", 0);
        return iC;
    }

    public static int QN() {
        int iC = c("ksadsdk_perf", "image_load_failed", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "imageLoadFailed:" + iC);
        b("ksadsdk_perf", "image_load_failed", 0);
        return iC;
    }

    public static void g(String str, String str2, String str3) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3);
    }

    public static String h(String str, String str2, String str3) {
        Context context = getContext();
        return context == null ? str3 : b(context, str, str2, str3);
    }

    public static void a(String str, String str2, String str3, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3, true);
    }

    public static void a(String str, String str2, long j) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, j);
    }

    public static long b(String str, String str2, long j) {
        Context context = getContext();
        return context == null ? j : b(context, str, str2, j);
    }

    public static void b(String str, String str2, int i) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, i);
    }

    public static int c(String str, String str2, int i) {
        Context context = getContext();
        return context == null ? i : b(context, str, str2, i);
    }

    public static void l(String str, String str2, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        b(context, str, str2, z);
    }

    public static boolean m(String str, String str2, boolean z) {
        Context context = getContext();
        return context == null ? z : c(context, str, str2, z);
    }

    public static Context getContext() {
        return ServiceProvider.Pp();
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        if (af.gX(str)) {
            bo.g(str, str2, str3);
            if (com.kwad.framework.a.a.oz.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.ay(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.oz.booleanValue()) {
            com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        af.at(str2, str3);
    }

    private static void a(Context context, String str, String str2, String str3, boolean z) {
        if (context == null) {
            return;
        }
        if (af.gX(str)) {
            bo.a(str, str2, str3, z);
            if (com.kwad.framework.a.a.oz.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.ay(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.oz.booleanValue()) {
            com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        af.at(str2, str3);
    }

    public static String b(Context context, String str, String str2, String str3) {
        String string;
        if (context == null) {
            return str3;
        }
        if (af.gX(str)) {
            string = bo.h(str, str2, str3);
            if (com.kwad.framework.a.a.oz.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "getString From Sp key:" + str2 + " value:" + string);
            }
        } else {
            string = com.kwad.sdk.utils.a.e.ay(context, str).getString(str2, str3);
            af.au(str2, string);
            if (com.kwad.framework.a.a.oz.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "getString key:" + str2 + " value:" + string);
            }
        }
        return com.kwad.sdk.core.a.c.isEncodeKsSdk(string) ? com.kwad.sdk.core.a.c.decodeKsSdk(string) : string;
    }

    private static void a(Context context, String str, String str2, long j) {
        if (context == null) {
            return;
        }
        if (af.gX(str)) {
            bo.a(str, str2, j);
        } else {
            com.kwad.sdk.utils.a.e.ay(context, str).putLong(str2, j);
        }
    }

    private static long b(Context context, String str, String str2, long j) {
        if (context == null) {
            return j;
        }
        if (af.gX(str)) {
            return bo.b(str, str2, j);
        }
        return com.kwad.sdk.utils.a.e.ay(context, str).getLong(str2, j);
    }

    private static void a(Context context, String str, String str2, int i) {
        if (context == null) {
            return;
        }
        if (af.gX(str)) {
            bo.b(str, str2, i);
        } else {
            com.kwad.sdk.utils.a.e.ay(context, str).putInt(str2, i);
        }
    }

    private static int b(Context context, String str, String str2, int i) {
        if (context == null) {
            return i;
        }
        if (af.gX(str)) {
            return bo.c(str, str2, i);
        }
        return com.kwad.sdk.utils.a.e.ay(context, str).getInt(str2, i);
    }

    private static void b(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        if (af.gX(str)) {
            bo.l(str, str2, z);
        } else {
            com.kwad.sdk.utils.a.e.ay(context, str).putBoolean(str2, z);
        }
    }

    private static boolean c(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return z;
        }
        if (af.gX(str)) {
            return bo.m(str, str2, z);
        }
        return com.kwad.sdk.utils.a.e.ay(context, str).getBoolean(str2, z);
    }

    public static void h(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        if (af.gX(str)) {
            bo.ay(str, str2);
        } else {
            com.kwad.sdk.utils.a.e.ay(context, str).remove(str2);
            af.at(str2, "");
        }
    }

    public static void i(String str, String str2, String str3) {
        if (af.gX(str2)) {
            bo.i(str, str2, str3);
        }
    }
}
