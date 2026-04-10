package com.bytedance.sdk.openadsdk.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static String z = "AppEnvironment";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f911a;
    private long dl;
    private Map<String, String> g;
    private String gc;

    private static class z {
        public static final a z = new a();
    }

    private a() {
        this.gc = "";
        HashMap map = new HashMap();
        this.g = map;
        map.put("ad_style", "default");
        this.g.put(MediationConstant.EXTRA_ADID, "default");
        this.g.put("rit", "default");
        this.g.put("request_id", "default");
        this.g.put("ad_slot_type", "default");
        this.g.put("net_type", "default");
        this.g.put("low_memory", "default");
        this.g.put("total_max_memory_rate", "default");
        this.g.put("commit_hash", "0053168ac6");
        this.g.put("branch", "");
        this.g.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
        this.g.put("sdk_api_version", gk.f1105a);
        this.g.put("setting_ab_version", com.bytedance.sdk.openadsdk.core.dl.gc.z().gc());
        this.dl = com.bytedance.sdk.openadsdk.core.un.x.z("tt_sp_app_env").get("last_app_env_time", 0L);
        this.f911a = false;
    }

    public static a z() {
        return z.z;
    }

    public void z(na naVar) {
        if (naVar == null) {
            return;
        }
        String strNv = naVar.nv();
        Map<String, String> map = this.g;
        if (TextUtils.isEmpty(strNv)) {
            strNv = "";
        }
        map.put("ad_info", strNv);
    }

    public void z(String str) {
        this.g.put("dynamic_ptpl_id", str);
    }

    public void g(String str) {
        this.g.put("request_ad_info", str);
    }

    public void dl(String str) {
        this.g.put("show_ad_info", str);
    }

    public void g(na naVar) {
        if (naVar == null) {
            return;
        }
        this.g.put(MediationConstant.EXTRA_ADID, naVar.mj());
        this.g.put("rit", new StringBuilder().append(com.bytedance.sdk.openadsdk.core.un.eo.fo(naVar)).toString());
        this.g.put("request_id", com.bytedance.sdk.openadsdk.core.un.eo.i(naVar));
        this.g.put("ad_slot_type", new StringBuilder().append(com.bytedance.sdk.openadsdk.core.un.eo.gz(naVar)).toString());
        this.g.put("net_type", com.bytedance.sdk.component.utils.v.e(zw.getContext()));
        if (com.bytedance.sdk.openadsdk.core.un.iq.g(naVar)) {
            this.g.put("ad_style", "is_playable");
        }
        a();
    }

    private void a() {
        Runtime runtime = Runtime.getRuntime();
        float fMaxMemory = (float) ((runtime.maxMemory() * 1.0d) / 1048576.0d);
        float f = (float) ((runtime.totalMemory() * 1.0d) / 1048576.0d);
        ActivityManager activityManager = (ActivityManager) zw.getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        com.bytedance.sdk.component.utils.wp.a(z, "系统是否处于低内存运行：" + memoryInfo.lowMemory);
        com.bytedance.sdk.component.utils.wp.a(z, "maxMemory: ".concat(String.valueOf(fMaxMemory)));
        com.bytedance.sdk.component.utils.wp.a(z, "totalMemory: ".concat(String.valueOf(f)));
        com.bytedance.sdk.component.utils.wp.a(z, "freeMemory: ".concat(String.valueOf((float) ((runtime.freeMemory() * 1.0d) / 1048576.0d))));
        int i = (int) ((f / fMaxMemory) * 100.0f);
        com.bytedance.sdk.component.utils.wp.a(z, "totalMaxRate: ".concat(String.valueOf(i)));
        this.g.put("low_memory", String.valueOf(memoryInfo.lowMemory));
        this.g.put("total_max_memory_rate", String.valueOf(i));
    }

    public Map<String, String> g() {
        return this.g;
    }

    public void dl() {
        if (this.f911a || com.bytedance.sdk.openadsdk.core.un.eo.z(this.dl, System.currentTimeMillis())) {
            return;
        }
        this.f911a = true;
        com.bytedance.sdk.openadsdk.core.q.v.z().gz(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.a.1
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                a.this.f911a = false;
                com.bytedance.sdk.openadsdk.core.q.z.g<com.bytedance.sdk.openadsdk.core.q.z.g> gVarG = com.bytedance.sdk.openadsdk.core.q.z.g.g();
                JSONObject jSONObjectGc = a.this.gc();
                if (jSONObjectGc != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    a.this.dl = jCurrentTimeMillis;
                    com.bytedance.sdk.openadsdk.core.un.x.z("tt_sp_app_env").put("last_app_env_time", jCurrentTimeMillis);
                    gVarG.g(jSONObjectGc.toString());
                }
                return gVarG;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject gc() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = zw.getContext();
            if (context == null) {
                return null;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4111);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
            }
            jSONObject.put(PluginConstants.KEY_APP_ID, uy.ls().q());
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put("permissions", jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
