package com.amgcyo.cuttadon.h.h;

import android.content.Context;
import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;

/* JADX INFO: compiled from: UMEventUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static String a = "";

    public static void a(Context context, String str, NewApiAd newApiAd, String str2, String str3) {
        if (newApiAd == null || TextUtils.isEmpty(newApiAd.getDown_url()) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("url", newApiAd.getDown_url());
        map.put("location", str2);
        map.put(GMAdConstant.EXTRA_ADID, String.valueOf(newApiAd.getId()));
        map.put("type", str3);
        MobclickAgent.onEventObject(context, str, map);
    }

    public static void b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (context == null) {
            context = MkApplication.getAppContext();
        }
        HashMap map = new HashMap();
        map.put("info5.0.2", a() + str);
        MobclickAgent.onEvent(context, "error_info", map);
    }

    public static void c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("ip", str);
        MobclickAgent.onEvent(context, "user_info", map);
    }

    public static void c(String str, String str2) {
        MkApplication appContext = MkApplication.getAppContext();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        HashMap map = new HashMap();
        String str3 = "信息：" + a() + str2;
        map.put("info_5.0.2", a() + str2);
        MobclickAgent.onEvent(appContext, str, map);
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("tts_type_5.0.2", str);
        MobclickAgent.onEvent(MkApplication.getAppContext(), "tts_click", map);
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("type", str);
        map.put("time", t0.d(System.currentTimeMillis()));
        MobclickAgent.onEvent(context, "look_ad_count", map);
    }

    public static void b(String str, String str2) {
        MkApplication appContext = MkApplication.getAppContext();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("info", str2);
        MobclickAgent.onEvent(appContext, str, map);
    }

    public static void a(int i2) {
        HashMap map = new HashMap();
        map.put("Kindle_5.0.2", String.valueOf(i2));
        MobclickAgent.onEvent(MkApplication.getAppContext(), "Kindle", map);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("cache_count5.0.2", str);
        MobclickAgent.onEvent(MkApplication.getAppContext(), "cache_click", map);
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        MkApplication appContext = MkApplication.getAppContext();
        HashMap map = new HashMap();
        map.put(str + "_error_5.0.2", a() + str2);
        MobclickAgent.onEvent(appContext, "ad_error_code", map);
    }

    public static void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (context == null) {
            context = MkApplication.getAppContext();
        }
        HashMap map = new HashMap();
        String str3 = "信息：" + a() + str2;
        map.put("package " + str + "_error_5.0.2", a() + str2);
        MobclickAgent.onEvent(context, "ad_error_code", map);
    }

    public static void a(String str, String str2, String str3) {
        MkApplication appContext = MkApplication.getAppContext();
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        HashMap map = new HashMap();
        String str4 = "信息：" + a() + str3;
        map.put(str2 + "_reason_5.0.2", a() + str3);
        MobclickAgent.onEvent(appContext, str, map);
    }

    private static String a() {
        try {
            if (TextUtils.isEmpty(a)) {
                a = g0.a().a("user_ip_info", "not found address") + " · ";
            }
            return a;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "not found address";
        }
    }
}
