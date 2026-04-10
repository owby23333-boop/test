package com.bytedance.sdk.openadsdk.core.q;

import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.sv;
import com.bytedance.sdk.openadsdk.core.uf;
import com.bytedance.sdk.openadsdk.core.un;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.an;
import com.umeng.umcrash.UMCrash;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    private static volatile v z;

    private boolean g(com.bytedance.sdk.openadsdk.core.q.z.g gVar) {
        return gVar == null;
    }

    private v() {
    }

    public static v z() {
        if (z == null) {
            synchronized (v.class) {
                if (z == null) {
                    z = new v();
                }
            }
        }
        return z;
    }

    public void z(com.bytedance.sdk.openadsdk.kb.z.z zVar, String str) {
        g.dl().z(zVar, str, true);
    }

    public void z(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.1
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("render_backup").g(jSONObject.toString());
            }
        }, "render_backup", true);
    }

    public static void z(SparseArray<Object> sparseArray, JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        long j;
        com.bytedance.sdk.openadsdk.ls.z zVar = new com.bytedance.sdk.openadsdk.ls.z(sparseArray);
        PluginValueSet pluginValueSetA = zVar.a();
        boolean z2 = zVar.z();
        int iG = zVar.g();
        String strDl = zVar.dl();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.put("success", z2);
            jSONObject4.put("code", iG);
            jSONObject4.put("message", strDl);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        if (pluginValueSetA != null) {
            JSONObject jSONObject5 = (JSONObject) pluginValueSetA.objectValue(10, JSONObject.class);
            String strStringValue = pluginValueSetA.stringValue(5);
            long jCurrentTimeMillis = jSONObject5 != null ? System.currentTimeMillis() - jSONObject5.optLong("run_package_start", 0L) : -1L;
            JSONObject jSONObject6 = (JSONObject) pluginValueSetA.objectValue(3, JSONObject.class);
            jSONObject3 = (JSONObject) pluginValueSetA.objectValue(4, JSONObject.class);
            j = jCurrentTimeMillis;
            jSONObject2 = jSONObject6;
            str = strStringValue;
        } else {
            str = null;
            jSONObject2 = null;
            jSONObject3 = null;
            j = -1;
        }
        z().z(str, jSONObject != null ? jSONObject.optString("business_type") : "", z2, j, jSONObject2, jSONObject3, jSONObject4);
    }

    public void z(final long j, final long j2, final int i) {
        final long j3 = j2 - j;
        if (j3 <= 0 || j3 >= 30000000) {
            return;
        }
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.12
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("starttime", j);
                    jSONObject.put("endtime", j2);
                    jSONObject.put("start_type", i);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("general_label").gc(new StringBuilder().append(j3).toString()).g(jSONObject.toString());
            }
        }, "general_label", true);
    }

    public void z(final String str, final String str2) {
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.22
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("close_time_1", str2);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("sdk_retention").gc(str).g(jSONObject.toString());
            }
        }, "sdk_retention", true);
    }

    public void z(final Object obj, final Object obj2, final String str, final String str2, final String str3) {
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.33
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    Object obj3 = obj;
                    if (obj3 instanceof Boolean) {
                        jSONObject.put("is_button", obj3);
                    }
                    Object obj4 = obj2;
                    if (obj4 instanceof Boolean) {
                        jSONObject.put("convert_result", obj4);
                    }
                    jSONObject.put("error_msg", str);
                    jSONObject.put("req_id", str2);
                    jSONObject.put(MediationConstant.EXTRA_ADID, str3);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("obm_result").g(jSONObject.toString());
            }
        }, "obm_result", true);
    }

    public void z(String str, int i, int i2, String str2, final int i3, final String str3, final long j) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i3);
            jSONObject.put("message", str3);
            jSONObject.put("version", i2);
            jSONObject.put("current_version", i);
            jSONObject.put(an.o, str);
            jSONObject.put("url", str2);
            jSONObject.put("duration", j);
        } catch (Throwable unused) {
        }
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.41
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("plugin_download").g(i3).e(str3).gc(new StringBuilder().append(j).toString()).g(jSONObject.toString());
            }
        }, "plugin_download", true);
    }

    public void g(final String str, final String str2) {
        com.bytedance.sdk.component.uy.e.dl(new com.bytedance.sdk.component.uy.fo("plugin_report") { // from class: com.bytedance.sdk.openadsdk.core.q.v.42
            @Override // java.lang.Runnable
            public void run() {
                if (!"exception".equals(str)) {
                    v.gc(str, str2);
                    return;
                }
                try {
                    JSONObject jSONObject = !TextUtils.isEmpty(str2) ? new JSONObject(str2) : null;
                    if (str2 != null) {
                        v.this.z(jSONObject.optString("scene"), jSONObject, (Throwable) null);
                    }
                } catch (JSONException unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gc(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !str.startsWith("zeus") && !TextUtils.equals("plugin_load_failed", str)) {
                str = "zeus_".concat(String.valueOf(str));
            }
            JSONObject jSONObject = !TextUtils.isEmpty(str2) ? new JSONObject(str2) : null;
            if (str2 != null) {
                jSONObject.put("current_version", "7.1.0.5");
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put("support_abi", Arrays.toString(Build.SUPPORTED_ABIS));
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            final int iOptInt = jSONObject.has("status_code") ? jSONObject.optInt("status_code") : jSONObject.optInt("code");
            final String strOptString = jSONObject.optString("message");
            final String strOptString2 = jSONObject.optString("duration");
            final String string = jSONObject.toString();
            final String str3 = str;
            g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.43
                @Override // com.bytedance.sdk.openadsdk.kb.z.z
                public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                    if ("zeus_load_finish".equals(str3)) {
                        return com.bytedance.sdk.openadsdk.core.q.z.g.g().z(str3).g(string).g(iOptInt).e(strOptString).gc(strOptString2).z(v.z("7.1.0.5") ? 1 : 0);
                    }
                    return com.bytedance.sdk.openadsdk.core.q.z.g.g().z(str3).g(string).g(iOptInt).gc(strOptString2).e(strOptString);
                }
            }, str, true);
        } catch (Throwable unused) {
        }
    }

    public static boolean z(String str) {
        com.bytedance.sdk.component.a.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.g.z();
        String str2 = dlVarZ.get("plugin_first_load", "");
        if (!TextUtils.isEmpty(str2) && str2.endsWith(str)) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2 + "-" + str;
        }
        dlVarZ.put("plugin_first_load", str);
        return true;
    }

    public void dl(final String str, final String str2) {
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.44
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("lp_monitor").m(str2).g(str);
            }
        }, "lp_monitor", true);
    }

    public void g() {
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.45
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarJs = com.bytedance.sdk.openadsdk.core.uy.ls().js();
                boolean zG = aVarJs.g();
                boolean z2 = aVarJs.z();
                boolean zGc = aVarJs.gc();
                boolean zA = aVarJs.a();
                boolean zDl = aVarJs.dl();
                boolean zM = aVarJs.m();
                String strWp = aVarJs.wp();
                JSONObject jSONObject = new JSONObject();
                int i = 1;
                try {
                    jSONObject.put("access_fine_location", z2 ? 1 : 0);
                    jSONObject.put("applist", zG ? 1 : 0);
                    jSONObject.put("external_storage", zGc ? 1 : 0);
                    jSONObject.put("wifi_state", zA ? 1 : 0);
                    jSONObject.put("phone_state", zDl ? 1 : 0);
                    if (!zM) {
                        i = 0;
                    }
                    jSONObject.put("can_use_androidId", i);
                    jSONObject.put("dev_oaid", strWp);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("sdk_permission").g(jSONObject.toString());
            }
        }, "sdk_permission", true);
    }

    public void z(final na naVar, final JSONObject jSONObject) {
        if (naVar == null) {
            return;
        }
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.2
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarM = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("jsb_video_action").m(naVar.aq());
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    gVarM.g(jSONObject2.toString());
                }
                gVarM.dl(eo.z(naVar, ""));
                return gVarM;
            }
        }, "jsb_video_action", true);
    }

    public static void z(final String str, final long j, final boolean z2) {
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.3
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("is_agg", z2);
                jSONObject.put(UMCrash.SP_KEY_TIMESTAMP, j);
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("over_freq").dl(str).g(jSONObject.toString());
            }
        }, "over_freq", true);
    }

    private void z(final com.bytedance.sdk.openadsdk.kb.z.z zVar, final String str, boolean z2) {
        final long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.4
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVar = (com.bytedance.sdk.openadsdk.core.q.z.g) zVar.z();
                gVar.z(str);
                gVar.z(jCurrentTimeMillis);
                return gVar;
            }
        }, str, true);
    }

    private void dl(com.bytedance.sdk.openadsdk.kb.z.z zVar, String str) {
        z(zVar, str, true);
    }

    private void a(final com.bytedance.sdk.openadsdk.kb.z.z zVar, final String str) {
        final long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.5
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVar = (com.bytedance.sdk.openadsdk.core.q.z.g) zVar.z();
                gVar.z(str);
                gVar.z(jCurrentTimeMillis);
                return gVar;
            }
        }, str, true);
    }

    public void z(com.bytedance.sdk.openadsdk.kb.z.z zVar) {
        dl(zVar, "outer_call");
    }

    public void g(com.bytedance.sdk.openadsdk.kb.z.z zVar) {
        dl(zVar, "outer_call_send");
    }

    public void dl(com.bytedance.sdk.openadsdk.kb.z.z zVar) {
        dl(zVar, "outer_call_no_rsp");
    }

    public void a(com.bytedance.sdk.openadsdk.kb.z.z zVar) {
        dl(zVar, "load_timeout");
    }

    public void gc(com.bytedance.sdk.openadsdk.kb.z.z zVar) {
        a(zVar, "express_ad_render");
    }

    private boolean z(String str, int i) {
        com.bytedance.sdk.component.a.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.g.z();
        int i2 = dlVarZ.get(str, 0);
        boolean z2 = (i2 & 2) == 0 || (i2 & 1) != i;
        if (z2) {
            dlVarZ.put(str, i + 2);
        }
        return z2;
    }

    public void z(final int i, na naVar, final boolean z2) {
        final String strValueOf = String.valueOf(eo.fo(naVar));
        if (z(strValueOf, z2 ? 1 : 0)) {
            g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.6
                @Override // com.bytedance.sdk.openadsdk.kb.z.z
                public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                    com.bytedance.sdk.openadsdk.core.q.z.g gVarDl = com.bytedance.sdk.openadsdk.core.q.z.g.g().z(i).dl(strValueOf);
                    if (z2) {
                        gVarDl.z("reg_creative");
                    } else {
                        gVarDl.z("no_reg_creative");
                    }
                    return gVarDl;
                }
            }, z2 ? "reg_creative" : "no_reg_creative", true);
        }
    }

    public void z(final com.bytedance.sdk.openadsdk.core.q.z.g gVar) {
        if (g(gVar)) {
            return;
        }
        gVar.z("load_icon_error");
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.7
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                return gVar;
            }
        }, "load_icon_error", true);
    }

    public void m(com.bytedance.sdk.openadsdk.kb.z.z zVar) {
        a(zVar, "show_backup_endcard");
    }

    public void e(com.bytedance.sdk.openadsdk.kb.z.z zVar) {
        dl(zVar, "splash_creative_check");
    }

    public void z(final boolean z2, final String[] strArr) {
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.8
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("if_sd", z2 ? 1 : 0);
                    String[] strArr2 = strArr;
                    if (strArr2 != null && strArr2.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (String str : strArr) {
                            if (!TextUtils.isEmpty(str)) {
                                sb.append(str).append(",");
                            }
                        }
                        jSONObject.put("permission", sb.toString());
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("download_permission").z(System.currentTimeMillis() / 1000).g(jSONObject.toString());
            }
        }, "download_permission", true);
    }

    public void gz(final com.bytedance.sdk.openadsdk.kb.z.z zVar) {
        if (zVar == null) {
            return;
        }
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.9
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                return ((com.bytedance.sdk.openadsdk.core.q.z.g) zVar.z()).z("app_env").z(System.currentTimeMillis() / 1000);
            }
        }, "app_env", true);
    }

    public void z(final String str, final String str2, final String str3, final boolean z2) {
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.10
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("get_bidding_token");
                boolean zG = zw.g().g(str);
                JSONObject jSONObject = new JSONObject();
                if (zG) {
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("cache_req_id", str2);
                    }
                    if (TextUtils.equals(str3, "0")) {
                        jSONObject.put("no_cache_reason", 0);
                    } else if (TextUtils.equals(str3, "1")) {
                        jSONObject.put("no_cache_reason", 1);
                    }
                }
                if (z2) {
                    jSONObject.put("opt_sample", 1);
                }
                gVarZ.g(jSONObject.toString());
                return gVarZ;
            }
        }, "get_bidding_token", z2);
    }

    public void z(final long j, final com.bytedance.sdk.openadsdk.core.sy.gc gcVar) {
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.11
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", j);
                jSONObject.put("ext_plugin_code", un.g());
                com.bytedance.sdk.openadsdk.core.sy.gc gcVar2 = gcVar;
                if (gcVar2 != null) {
                    jSONObject.put("success", gcVar2.z() ? 1 : 0);
                    com.bytedance.sdk.openadsdk.core.sy.e eVarG = gcVar.g();
                    if (eVarG != null) {
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, eVarG.toString());
                        jSONObject.put("code", eVarG.z());
                    }
                }
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("pitaya_init").g(jSONObject.toString());
            }
        }, "pitaya_init", true);
    }

    public void z(final String str, final String str2, final boolean z2, final long j, final JSONObject jSONObject, final JSONObject jSONObject2, final JSONObject jSONObject3) {
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.13
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("duration", j);
                jSONObject4.put("business", str);
                jSONObject4.put("biztype", str2);
                jSONObject4.put("result", z2);
                JSONObject jSONObject5 = jSONObject;
                if (jSONObject5 != null) {
                    jSONObject4.put("package_info", jSONObject5.toString());
                }
                JSONObject jSONObject6 = jSONObject2;
                if (jSONObject6 != null) {
                    jSONObject4.put("error_info", jSONObject6.toString());
                }
                JSONObject jSONObject7 = jSONObject3;
                if (jSONObject7 != null) {
                    jSONObject4.put("common_info", jSONObject7.toString());
                }
                jSONObject4.put("ext_plugin_code", un.g());
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("pitaya_run_task").g(jSONObject4.toString());
            }
        }, "pitaya_run_task", true);
    }

    public void z(final int i, uf ufVar) {
        if (ufVar == null) {
            return;
        }
        final JSONObject jSONObjectZ = ufVar.z(-1L);
        final long jG = ufVar.g();
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.14
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("bid_token_time");
                try {
                    jSONObjectZ.put("total", jG);
                    jSONObjectZ.put("opt_sample", 1);
                    jSONObjectZ.put("slot_type", i);
                    gVarZ.g(jSONObjectZ.toString());
                } catch (Throwable unused) {
                }
                return gVarZ;
            }
        }, "get_bidding_token", true);
    }

    public void z(int i, long j, String str) {
        z(i, j, (Boolean) null, str);
    }

    public void z(final int i, final long j, final Boolean bool, final String str) {
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.15
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("encrypt_track");
                try {
                    JSONObject jSONObject = new JSONObject();
                    long j2 = j;
                    if (j2 >= 0) {
                        jSONObject.put("cost_time", j2);
                    }
                    Boolean bool2 = bool;
                    if (bool2 != null) {
                        jSONObject.put("init_succ", bool2.booleanValue() ? 1 : 2);
                    }
                    jSONObject.put("opt_sample", 1);
                    int i2 = i;
                    if (i2 != -1) {
                        jSONObject.put("event_res", i2);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("type", str);
                    }
                    gVarZ.g(jSONObject.toString());
                } catch (Throwable unused) {
                }
                return gVarZ;
            }
        }, "encrypt_track", true);
    }

    public void z(final int i) {
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.16
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("has_pre_req").g(i);
            }
        }, "has_pre_req", true);
    }

    public void z(final int i, final String str, final String str2, final String str3, final String str4) {
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.17
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fetch_adm", i == 0 ? 1 : 0);
                jSONObject.put("code", i);
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                jSONObject.put("material_keys", str4);
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("fetch_adm_status").g(i).dl(str3).m(str2).g(jSONObject.toString());
            }
        }, "fetch_adm_status", true);
    }

    public void g(final int i) {
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.18
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("get_ad_cache_failed").g(i);
            }
        }, "get_ad_cache_failed", true);
    }

    public void g(final String str) {
        if (str == null) {
            return;
        }
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.19
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("error_ad_info").z(System.currentTimeMillis() / 1000).fo(str);
            }
        }, "error_ad_info", true);
    }

    public void g(com.bytedance.sdk.openadsdk.kb.z.z zVar, String str) {
        g.dl().z(zVar, str, true);
    }

    public void z(final String str, final JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.20
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z(str);
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    gVarZ.g(jSONObject2.toString());
                }
                return gVarZ;
            }
        }, str);
    }

    public void z(String str, Throwable th) {
        z(str, (JSONObject) null, th);
    }

    public void z(final String str, final JSONObject jSONObject, final Throwable th) {
        g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.21
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("scene", str);
                jSONObject2.putOpt("object", jSONObject);
                jSONObject2.putOpt("exception", th);
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("exception").g(jSONObject2.toString());
            }
        }, "exception");
    }

    public void g(final JSONObject jSONObject) {
        g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.23
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("saas_schema").g(jSONObject.toString());
            }
        }, "saas_schema");
    }

    public void z(final na naVar, final long j, final boolean z2, final boolean z3) {
        g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.24
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("req_id", naVar.aq());
                jSONObject.put("auth", z2);
                jSONObject.put("duration", j);
                jSONObject.put("time_out", z3);
                sv svVarDz = naVar.dz();
                if (svVarDz != null) {
                    jSONObject.put("saas_info", svVarDz.z());
                }
                jSONObject.put("ext", naVar.vk());
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("auth_time").g(jSONObject.toString());
            }
        }, "auth_time");
    }

    public void z(final String str, final String str2, final int i, final JSONObject jSONObject) {
        g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.25
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("event_type", str2);
                jSONObject2.putOpt(NotificationCompat.CATEGORY_EVENT, str);
                jSONObject2.putOpt("object", jSONObject);
                jSONObject2.putOpt("state", Integer.valueOf(i));
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("convert_event").g(jSONObject2.toString());
            }
        }, "convert_event");
    }

    public void dl() {
        g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.26
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("live_init_start");
            }
        }, "live_init_start");
    }

    public void z(final boolean z2, final long j, final JSONObject jSONObject) {
        g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.27
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("success", z2);
                jSONObject2.put("cost", j);
                jSONObject2.put("obj", jSONObject);
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("live_init_success").g(jSONObject2.toString());
            }
        }, "live_init_success");
    }

    public void z(final na naVar, final Object obj) {
        g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.28
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("upie_img_play_success");
                na naVar2 = naVar;
                if (naVar2 != null) {
                    gVarZ.m(naVar2.aq());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", obj);
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject, naVar);
                gVarZ.g(jSONObject.toString());
                return gVarZ;
            }
        }, "upie_img_play_success");
    }

    public void z(final na naVar, final int i, final String str) {
        g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.29
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("upie_img_play_fail");
                na naVar2 = naVar;
                if (naVar2 != null) {
                    gVarZ.m(naVar2.aq());
                }
                gVarZ.g(i);
                gVarZ.e(str);
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject, naVar);
                gVarZ.g(jSONObject.toString());
                return gVarZ;
            }
        }, "upie_img_play_fail");
    }

    public void z(final na naVar, final String str) {
        g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.30
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("uttie_start");
                na naVar2 = naVar;
                if (naVar2 != null) {
                    gVarZ.m(naVar2.aq());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                gVarZ.g(jSONObject.toString());
                return gVarZ;
            }
        }, "uttie_start");
    }

    public void z(final na naVar, final String str, final long j) {
        g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.31
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("uttie_played");
                na naVar2 = naVar;
                if (naVar2 != null) {
                    gVarZ.m(naVar2.aq());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                jSONObject.put("duration", j);
                gVarZ.g(jSONObject.toString());
                return gVarZ;
            }
        }, "uttie_played");
    }

    public void g(final na naVar, final String str) {
        g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.32
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("uttie_close");
                na naVar2 = naVar;
                if (naVar2 != null) {
                    gVarZ.m(naVar2.aq());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                gVarZ.g(jSONObject.toString());
                return gVarZ;
            }
        }, "uttie_close");
    }

    public void z(final na naVar, final String str, final JSONObject jSONObject) {
        g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.34
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z(str);
                na naVar2 = naVar;
                if (naVar2 != null) {
                    gVarZ.m(naVar2.aq()).gz(naVar.vk());
                }
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    gVarZ.g(jSONObject2.toString());
                }
                return gVarZ;
            }
        }, str);
    }

    public void dl(na naVar, String str) {
        z(naVar, str, (JSONObject) null);
    }

    public void dl(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.35
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("device_qty_compare");
                gVarZ.g(jSONObject.toString());
                return gVarZ;
            }
        }, "device_qty_compare", true);
    }

    public void a(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.36
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("device_bytebench");
                gVarZ.g(jSONObject.toString());
                return gVarZ;
            }
        }, "device_bytebench", true);
    }

    public void gc(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.37
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("render_timeout_opt");
                gVarZ.g(jSONObject.toString());
                return gVarZ;
            }
        }, "render_timeout_opt", true);
    }

    public void m(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.38
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("landingpage_check_info");
                gVarZ.g(jSONObject.toString());
                return gVarZ;
            }
        }, "landingpage_check_info", true);
    }

    public static void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final long j, final long j2, final long j3, final int i, final int i2, final int i3) {
        z().e(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.39
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                int i4 = i3 > 0 ? 2 : 1;
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("available_type", Integer.valueOf(i4));
                jSONObject.putOpt("creative_check_duration", Long.valueOf(j2));
                jSONObject.putOpt("total_duration", Long.valueOf(j3));
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(i));
                jSONObject.putOpt("check_count", Integer.valueOf(i2));
                jSONObject.putOpt("success_count", Integer.valueOf(i3));
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z(i).dl(gVar.a()).g((int) j).g(jSONObject.toString());
            }
        });
    }

    public void e(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.v.40
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("type_realtime_feature_cost");
                gVarZ.g(jSONObject.toString());
                return gVarZ;
            }
        }, "type_realtime_feature_cost", true);
    }
}
