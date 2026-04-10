package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.qq.e.comm.pi.ACTD;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class m {
    private static SharedPreferences g;
    private static final List<Pair<String, JSONObject>> dl = new CopyOnWriteArrayList();
    static final Map<String, String> z = new HashMap();

    public static void z(int i, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j));
            jSONObject.putOpt("code", Integer.valueOf(i));
            jSONObject.putOpt("message", str);
            jSONObject.putOpt("load_record", gc.z());
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.m.z(e);
        }
        gc("plugin_load_failed", jSONObject);
    }

    public static void z(String str, JSONObject jSONObject) {
        a("zeus_".concat(String.valueOf(str)), jSONObject);
    }

    public static void z() {
        List<Pair<String, JSONObject>> list = dl;
        if (list.size() <= 0) {
            return;
        }
        try {
            for (Pair<String, JSONObject> pair : list) {
                if (pair != null) {
                    a((String) pair.first, (JSONObject) pair.second);
                }
            }
            dl.clear();
        } catch (Exception unused) {
        }
    }

    private static void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString("event_name", str);
            bundle.putString("event_extra", jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
            return;
        }
        gc(str, jSONObject);
    }

    private static void gc(final String str, final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.fv.z.z().dl().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.m.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ArrayList arrayList = new ArrayList();
                arrayList.add(m.m(str, jSONObject));
                m.g(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject m(String str, JSONObject jSONObject) {
        String str2 = "7.1.0.5";
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("support_abi", Arrays.toString(Build.SUPPORTED_ABIS));
            jSONObject.put("is_boost", true);
            jSONObject.put("is_only_armv8a", com.bytedance.sdk.openadsdk.api.plugin.dl.dl.dl());
            jSONObject2.put("ad_sdk_version", "7.1.0.5");
            String strZ = fo.z("com.byted.pangle");
            if (!TextUtils.isEmpty(strZ)) {
                str2 = strZ;
            }
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, str2);
            jSONObject2.put(UMCrash.SP_KEY_TIMESTAMP, System.currentTimeMillis() / 1000);
            jSONObject2.put("is_plugin", true);
            Map<String, String> map = z;
            jSONObject.put(ACTD.APPID_KEY, map.get(ACTD.APPID_KEY));
            jSONObject2.put("event_extra", jSONObject != null ? jSONObject.toString() : "");
            jSONObject2.put("type", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("model", Build.MODEL);
            jSONObject3.put("vendor", Build.MANUFACTURER);
            jSONObject3.put("imei", map.get("imei"));
            jSONObject3.put("oaid", map.get("oaid"));
            jSONObject2.put("device_info", jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public static void g(String str, JSONObject jSONObject) {
        dl.add(new Pair<>(str, jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(List<JSONObject> list) throws Throwable {
        if (list == null) {
            return;
        }
        if (g == null) {
            g = g.g(TTAppContextHolder.getContext(), "tt_sdk_settings_other", 0);
        }
        String str = String.format("https://%s%s", g.getString("url_stats", "api-access.pangolin-sdk-toutiao.com"), "/api/ad/union/sdk/stats/batch/");
        JSONObject jSONObject = new JSONObject();
        try {
            List<Pair<String, JSONObject>> list2 = dl;
            if (list2.size() > 0) {
                for (Pair<String, JSONObject> pair : list2) {
                    list.add(m((String) pair.first, (JSONObject) pair.second));
                }
                dl.clear();
            }
            jSONObject.put("stats_list", new JSONArray((Collection) list));
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.api.plugin.g.dl.z().z(true, str, com.bytedance.sdk.openadsdk.api.plugin.dl.g.z(jSONObject).toString().getBytes());
    }

    public static void z(AdConfig adConfig) {
        if (adConfig == null) {
            return;
        }
        Map<String, String> map = z;
        map.put(ACTD.APPID_KEY, adConfig.getAppId());
        int pluginUpdateConfig = adConfig.getPluginUpdateConfig();
        map.put("plugin_update_conf", pluginUpdateConfig != 0 ? String.valueOf(pluginUpdateConfig) : "2");
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                map.put("oaid", customController.getDevOaid());
                map.put("imei", customController.getDevImei());
            } catch (Exception unused) {
            }
        }
    }

    static Map<String, String> g() {
        return z;
    }
}
