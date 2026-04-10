package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class x {
    private static String sAppTag = "";

    public static double DA() {
        int iC = c("ksadsdk_perf", "image_load_complete_count", 0);
        long jB = b("ksadsdk_perf", "image_load_complete_total", 0L);
        b("ksadsdk_perf", "image_load_complete_count", 0);
        a("ksadsdk_perf", "image_load_complete_total", 0L);
        if (iC == 0) {
            return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }
        double d2 = jB;
        double d3 = iC;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 / d3;
    }

    public static int DB() {
        int iC = c("ksadsdk_perf", "image_load_total", 0);
        com.kwad.sdk.core.d.b.d("Ks_UnionUtils", "imageLoadTotal:" + iC);
        b("ksadsdk_perf", "image_load_total", 0);
        return iC;
    }

    public static int DC() {
        int iC = c("ksadsdk_perf", "image_load_suc", 0);
        com.kwad.sdk.core.d.b.d("Ks_UnionUtils", "imageLoadSuccess:" + iC);
        b("ksadsdk_perf", "image_load_suc", 0);
        return iC;
    }

    public static int DD() {
        int iC = c("ksadsdk_perf", "image_load_failed", 0);
        com.kwad.sdk.core.d.b.d("Ks_UnionUtils", "imageLoadFailed:" + iC);
        b("ksadsdk_perf", "image_load_failed", 0);
        return iC;
    }

    public static String Dl() {
        Context context = getContext();
        return context == null ? "" : d(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", "");
    }

    public static String Dm() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return d(context, ay.Ev() ? "ksadsdk_interstitial_daily_show_count" : "ksadsdk_interstitial_aggregate_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", "");
    }

    public static String Dn() {
        Context context = getContext();
        return context == null ? "" : d(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", "");
    }

    public static String Do() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return d(context, ay.Er() ? "ksadsdk_splash_local_ad_force_active" : "ksadsdk_splash_daily_show_count", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
    }

    public static String Dp() {
        Context context = getContext();
        return context == null ? "" : ay.Et() ? h("ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "") : d(context, "ksadsdk_reward_auto_call_app_card_show_count", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String Dq() {
        return h("ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String Dr() {
        if (!TextUtils.isEmpty(sAppTag)) {
            return sAppTag;
        }
        Context context = getContext();
        return context == null ? "" : d(context, "ksadsdk_pref", "appTag", "");
    }

    public static String Ds() {
        Context context = getContext();
        return context == null ? "" : cc(context);
    }

    public static String Dt() {
        return h("ksadsdk_splash_local_ad_force_active", "key_local_info", (String) null);
    }

    public static long Du() {
        return b("ksadsdk_push_ad_common", "key_push_last_show_time", -1L);
    }

    public static String Dv() {
        return h("ksadsdk_splash_local_ad_force_active", "key_splash_end_card_info", (String) null);
    }

    public static String Dw() {
        return getContext() == null ? "" : h("ksadsdk_install_tips_show_count", "init_install_tips_show_count", "");
    }

    public static void Dx() {
        b("ksadsdk_perf", "image_load_total", c("ksadsdk_perf", "image_load_total", 0) + 1);
    }

    public static void Dy() {
        b("ksadsdk_perf", "image_load_suc", c("ksadsdk_perf", "image_load_suc", 0) + 1);
    }

    public static void Dz() {
        b("ksadsdk_perf", "image_load_failed", c("ksadsdk_perf", "image_load_failed", 0) + 1);
    }

    public static long K(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_pref", str, 0L);
    }

    public static long L(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_download_package_length", str, 0L);
    }

    public static String M(Context context, String str) {
        return context == null ? "" : d(context, "ksadsdk_download_package_md5", str, "");
    }

    public static void N(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_egid", "KEY_SDK_EGID", str);
    }

    public static void O(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_model", "KEY_SDK_MODEL", str, true);
    }

    public static void P(Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", str);
    }

    public static void Q(Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", str);
        ay.Eu();
    }

    public static void R(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", str);
    }

    public static void S(Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", str);
    }

    public static void T(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", str);
        ay.Eq();
    }

    public static void U(Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
        ay.Es();
    }

    public static void V(Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
    }

    public static void W(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", str);
    }

    public static void X(Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        g.execute(new av() { // from class: com.kwad.sdk.utils.x.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                x.Y(ServiceProvider.getContext(), str);
            }
        });
    }

    public static void Y(Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_pref", "appTag", str);
    }

    public static void Z(Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_pref", "webview_ua", str, true);
    }

    private static void a(Context context, String str, String str2, int i2) {
        if (context == null) {
            return;
        }
        if (w.De()) {
            az.a(context, str, str2, i2);
        } else {
            com.kwad.sdk.utils.kwai.e.ar(context, str).putInt(str2, i2);
        }
    }

    private static void a(Context context, String str, String str2, long j2) {
        if (context == null) {
            return;
        }
        if (w.De()) {
            az.a(context, str, str2, j2);
        } else {
            com.kwad.sdk.utils.kwai.e.ar(context, str).putLong(str2, j2);
        }
    }

    private static void a(Context context, @NonNull String str, @NonNull String str2, String str3, boolean z2) {
        if (context == null) {
            return;
        }
        if (w.De()) {
            az.a(context, str, str2, str3, z2);
            if (com.kwad.b.kwai.a.bI.booleanValue()) {
                com.kwad.sdk.core.d.b.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.kwai.e.ar(context, str).putString(str2, str3);
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        w.Z(str2, str3);
    }

    public static void a(String str, String str2, long j2) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, j2);
    }

    public static void a(String str, String str2, String str3, boolean z2) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3, true);
    }

    @WorkerThread
    public static void aa(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        ay.l(context.getApplicationContext(), "ksadsdk_sdk_config_data", str);
    }

    public static void ab(Context context, String str) {
        if (context == null) {
            return;
        }
        g("ksadsdk_splash_local_rotate_active_count", "key_splash_local_info", str);
    }

    public static void ab(String str, String str2) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        j(context, str, str2);
    }

    public static void ac(Context context, String str) {
        if (context == null) {
            return;
        }
        g("ksadsdk_splash_local_ad_force_active", "key_splash_slide_local_info", str);
    }

    public static void ad(Context context, String str) {
        if (context == null) {
            return;
        }
        g("ksadsdk_splash_local_ad_force_active", "key_splash_end_card_info", str);
    }

    public static void ae(Context context, String str) {
        if (context == null) {
            return;
        }
        g("ksadsdk_install_tips_show_count", "init_install_tips_show_count", str);
    }

    public static Map<String, ?> af(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (!w.De()) {
            return com.kwad.sdk.utils.kwai.e.ar(context, str).getAll();
        }
        SharedPreferences sharedPreferencesEw = az.ew(str);
        if (sharedPreferencesEw != null) {
            return sharedPreferencesEw.getAll();
        }
        return null;
    }

    public static void ag(long j2) {
        a("ksadsdk_push_ad_common", "key_push_last_show_time", j2);
    }

    public static void ah(long j2) {
        b("ksadsdk_perf", "image_load_complete_count", c("ksadsdk_perf", "image_load_complete_count", 0) + 1);
        a("ksadsdk_perf", "image_load_complete_total", b("ksadsdk_perf", "image_load_complete_total", 0L) + j2);
    }

    private static int b(Context context, String str, String str2, int i2) {
        return context == null ? i2 : w.De() ? az.b(context, str, str2, i2) : com.kwad.sdk.utils.kwai.e.ar(context, str).getInt(str2, i2);
    }

    private static long b(Context context, String str, String str2, long j2) {
        return context == null ? j2 : w.De() ? az.b(context, str, str2, j2) : com.kwad.sdk.utils.kwai.e.ar(context, str).getLong(str2, j2);
    }

    public static long b(String str, String str2, long j2) {
        Context context = getContext();
        return context == null ? j2 : b(context, str, str2, j2);
    }

    public static void b(Context context, String str, String str2, boolean z2) {
        if (context == null) {
            return;
        }
        h("ksadsdk_solder", "solder_is_success_loaded_" + str + str2, z2);
    }

    public static void b(String str, String str2, int i2) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, i2);
    }

    public static int c(String str, String str2, int i2) {
        Context context = getContext();
        if (context == null) {
            return 0;
        }
        return b(context, str, str2, 0);
    }

    public static void c(Context context, @NonNull String str, @NonNull String str2, String str3) {
        if (context == null) {
            return;
        }
        if (w.De()) {
            az.c(context, str, str2, str3);
            if (com.kwad.b.kwai.a.bI.booleanValue()) {
                com.kwad.sdk.core.d.b.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.kwai.e.ar(context, str).putString(str2, str3);
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        w.Z(str2, str3);
    }

    private static void c(Context context, String str, String str2, boolean z2) {
        if (context == null) {
            return;
        }
        if (w.De()) {
            az.c(context, str, str2, z2);
        } else {
            com.kwad.sdk.utils.kwai.e.ar(context, str).putBoolean(str2, z2);
        }
    }

    public static String cc(@NonNull Context context) {
        return context == null ? "" : d(context, "ksadsdk_egid", "KEY_SDK_EGID", "");
    }

    public static long cd(@NonNull Context context) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", 0L);
    }

    public static int ce(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", 0);
    }

    public static String cf(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        String strD = d(context, "ksadsdk_model", "KEY_SDK_MODEL", "");
        az.i(strD, "ksadsdk_model", "KEY_SDK_MODEL");
        return strD;
    }

    public static int cg(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", 0);
    }

    public static String ch(@NonNull Context context) {
        return context == null ? "" : d(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", "");
    }

    public static String ci(@NonNull Context context) {
        return context == null ? "" : d(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", "");
    }

    public static String cj(Context context) {
        if (context == null) {
            return "";
        }
        String strH = h("ksadsdk_pref", "webview_ua", "");
        az.i(strH, "ksadsdk_pref", "webview_ua");
        return strH;
    }

    @WorkerThread
    public static String ck(Context context) {
        if (ay.Eo()) {
            return ay.ap(context.getApplicationContext(), "ksadsdk_sdk_config_data");
        }
        String strH = az.h("ksadsdk_sdk_config_data", "config_str", "");
        ay.k(context.getApplicationContext(), "ksadsdk_sdk_config_data", strH);
        return strH;
    }

    public static String cl(Context context) {
        if (context == null) {
            return null;
        }
        return h("ksadsdk_splash_local_rotate_active_count", "key_splash_local_info", (String) null);
    }

    public static void clear(String str) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (w.De()) {
            az.aq(context, str);
        } else {
            com.kwad.sdk.utils.kwai.e.ar(context, str).clear();
        }
    }

    public static String cm(Context context) {
        if (context == null) {
            return null;
        }
        return h("ksadsdk_splash_local_ad_force_active", "key_splash_slide_local_info", (String) null);
    }

    public static String d(Context context, String str, String str2, String str3) {
        String string;
        StringBuilder sb;
        if (context == null) {
            return str3;
        }
        if (w.De()) {
            string = az.d(context, str, str2, str3);
            if (com.kwad.b.kwai.a.bI.booleanValue()) {
                sb = new StringBuilder("getString From Sp key:");
                sb.append(str2);
                sb.append(" value:");
                sb.append(string);
                com.kwad.sdk.core.d.b.d("Ks_UnionUtils", sb.toString());
            }
        } else {
            com.kwad.sdk.utils.kwai.e.ar(context, str);
            string = com.kwad.sdk.utils.kwai.e.ar(context, str).getString(str2, str3);
            w.aa(str2, string);
            if (com.kwad.b.kwai.a.bI.booleanValue()) {
                sb = new StringBuilder("getString key:");
                sb.append(str2);
                sb.append(" value:");
                sb.append(string);
                com.kwad.sdk.core.d.b.d("Ks_UnionUtils", sb.toString());
            }
        }
        return com.kwad.sdk.core.kwai.c.bI(string) ? com.kwad.sdk.core.kwai.c.bH(string) : string;
    }

    public static void d(@NonNull Context context, long j2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", j2);
    }

    private static boolean d(Context context, String str, String str2, boolean z2) {
        return context == null ? z2 : w.De() ? az.d(context, str, str2, z2) : com.kwad.sdk.utils.kwai.e.ar(context, str).getBoolean(str2, z2);
    }

    public static void e(Context context, String str, long j2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", str, j2);
    }

    public static void ej(String str) {
        g("ksadsdk_splash_local_ad_force_active", "key_local_info", str);
    }

    @Nullable
    public static Map<String, ?> ek(String str) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return af(context, str);
    }

    public static void f(Context context, String str, long j2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_length", str, j2);
    }

    private static void g(String str, String str2, String str3) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        c(context, str, str2, str3);
    }

    @Nullable
    public static Context getContext() {
        try {
            com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
            if (eVar == null) {
                return null;
            }
            return eVar.getContext();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String h(String str, String str2, String str3) {
        Context context = getContext();
        return context == null ? str3 : d(context, str, str2, str3);
    }

    public static void h(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_download_package_md5", str, str2);
    }

    public static void h(String str, String str2, boolean z2) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        c(context, str, str2, z2);
    }

    public static void i(String str, String str2, String str3) {
        if (w.De()) {
            az.i(str, str2, str3);
        }
    }

    public static boolean i(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        return i("ksadsdk_solder", "solder_is_success_loaded_" + str + str2, false);
    }

    public static boolean i(String str, String str2, boolean z2) {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        return d(context, str, str2, false);
    }

    public static void j(@NonNull Context context, int i2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", i2);
    }

    private static void j(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        if (w.De()) {
            az.j(context, str, str2);
        } else {
            com.kwad.sdk.utils.kwai.e.ar(context, str).remove(str2);
            w.Z(str2, "");
        }
    }

    public static void k(@NonNull Context context, int i2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", i2);
    }
}
