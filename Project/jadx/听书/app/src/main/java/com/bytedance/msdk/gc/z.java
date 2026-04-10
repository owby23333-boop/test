package com.bytedance.msdk.gc;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.msdk.gz.io;
import com.bytedance.msdk.gz.l;
import com.bytedance.msdk.gz.mc;
import com.bytedance.msdk.gz.zw;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.an;
import com.umeng.umcrash.UMCrash;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.component.gz.g.a.z.g {
    public static final String dl = UUID.randomUUID().toString();
    public final JSONObject g;
    public final String z;

    public z(String str, JSONObject jSONObject) {
        this.z = str;
        this.g = jSONObject;
    }

    @Override // com.bytedance.sdk.component.gz.g.a.z.g
    public JSONObject z(String str) {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.gz.g.a.z.g
    public long z() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject = this.g;
        if (jSONObject != null) {
            if (jSONObject.has("params")) {
                jSONObjectOptJSONObject = this.g.optJSONObject("params");
            } else {
                jSONObjectOptJSONObject = this.g;
            }
            if (jSONObjectOptJSONObject != null) {
                return jSONObjectOptJSONObject.optLong(UMCrash.SP_KEY_TIMESTAMP);
            }
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.component.gz.g.a.z.g
    public long g() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject = this.g;
        if (jSONObject != null) {
            if (jSONObject.has("params")) {
                jSONObjectOptJSONObject = this.g.optJSONObject("params");
            } else {
                jSONObjectOptJSONObject = this.g;
            }
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("event_extra");
                if (!TextUtils.isEmpty(strOptString)) {
                    try {
                        return new JSONObject(strOptString).optLong("eventIndex");
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return 0L;
    }

    public static JSONObject z(a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("device_info", zw.z());
            if (aVar != null) {
                jSONObject2.putOpt("type", aVar.z);
                jSONObject2.putOpt("link_id", aVar.g);
                jSONObject2.putOpt(MediationConstant.EXTRA_ADN_NAME, aVar.dl);
                jSONObject2.putOpt("ad_sdk_version", aVar.f466a);
                jSONObject2.putOpt("rit_cpm", aVar.e);
                jSONObject2.putOpt("mediation_rit", aVar.m);
                jSONObject2.putOpt("adtype", Integer.valueOf(aVar.p));
                jSONObject2.putOpt("error_msg", aVar.kb);
                jSONObject2.putOpt("error_code", Integer.valueOf(aVar.v));
                jSONObject2.putOpt("creative_id", aVar.wp);
                jSONObject2.putOpt("exchange_rate", aVar.q);
                jSONObject2.putOpt("msdk_session_id", dl);
                jSONObject2.putOpt("is_trusteeship_monetize", Integer.valueOf(com.bytedance.msdk.core.g.g().z()));
                String strG = com.bytedance.msdk.core.kb.z.z().g(com.bytedance.msdk.core.g.g().i());
                if (strG != null) {
                    jSONObject2.putOpt("app_abtest", strG);
                }
                z(jSONObject2, aVar);
                dl(jSONObject2, aVar);
                g(aVar, jSONObject);
                if (!"total_load_fail".equalsIgnoreCase(aVar.z) && !"adapter_request_fail".equalsIgnoreCase(aVar.z)) {
                    jSONObject2.putOpt("req_id", TextUtils.isEmpty(aVar.gc) ? aVar.g + "_" + aVar.m : aVar.gc);
                }
                jSONObject2.putOpt(an.O, com.bytedance.msdk.core.g.g().gz());
                com.bytedance.msdk.core.uy.z zVarZ = com.bytedance.msdk.core.g.g().z(MediationConstant.ADN_PANGLE);
                if (zVarZ != null) {
                    jSONObject2.putOpt(PluginConstants.KEY_APP_ID, zVarZ.g());
                } else {
                    jSONObject2.putOpt(PluginConstants.KEY_APP_ID, com.bytedance.msdk.core.z.kb().wp());
                }
                if (aVar.fo != 0) {
                    jSONObject2.putOpt("waterfall_id", Long.valueOf(aVar.fo));
                }
                if (!TextUtils.isEmpty(aVar.uy)) {
                    jSONObject2.putOpt("version", aVar.uy);
                }
                if (aVar.iq != null && aVar.iq.size() > 0) {
                    for (String str : aVar.iq.keySet()) {
                        Object obj = aVar.iq.get(str);
                        if (!TextUtils.isEmpty(str) && obj != null) {
                            jSONObject2.putOpt(str, obj);
                        }
                    }
                }
            }
            jSONObject2.putOpt("event_extra", jSONObject != null ? jSONObject.toString() : null);
            jSONObject2.putOpt("app_version", mc.dl());
            jSONObject2.putOpt("conn_type", Integer.valueOf(io.gc()));
            g(jSONObject2, aVar);
            jSONObject2.putOpt("mediation_sdk_version", com.bytedance.msdk.g.g.g());
            jSONObject2.putOpt(PluginConstants.KEY_PLUGIN_VERSION, com.bytedance.msdk.g.g.a());
            try {
                jSONObject2.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.sy.z.z().z("DeviceRate", "bytebench_value")));
            } catch (NumberFormatException unused) {
                jSONObject2.put("device_score", -1);
            }
        } catch (Throwable th) {
            try {
                z(jSONObject2, th, aVar);
            } catch (Throwable unused2) {
            }
        }
        return jSONObject2;
    }

    private static void z(JSONObject jSONObject, a aVar) throws JSONException {
        if (jSONObject == null || aVar == null) {
            return;
        }
        if (aVar.js != -1) {
            jSONObject.putOpt("result", Integer.valueOf(aVar.js));
        }
        if (aVar.tb != -1) {
            jSONObject.putOpt("status_code", Integer.valueOf(aVar.tb));
        }
        if (aVar.ls != null) {
            jSONObject.putOpt("show_sort", aVar.ls);
        }
        if (aVar.pf != null) {
            jSONObject.putOpt("load_sort", aVar.pf);
        }
        if (aVar.i != null) {
            jSONObject.putOpt("req_bidding_type", aVar.i);
        }
        jSONObject.putOpt(MediationConstant.KEY_GM_PRIME_RIT, aVar.gz);
    }

    private static void g(JSONObject jSONObject, a aVar) throws JSONException {
        if (jSONObject != null && aVar != null) {
            if (TextUtils.equals(aVar.z, "sdk_init")) {
                jSONObject.putOpt(UMCrash.SP_KEY_TIMESTAMP, Long.valueOf(com.bytedance.msdk.api.a.uy.g()));
                return;
            }
            if (TextUtils.equals(aVar.z, "start_up")) {
                jSONObject.putOpt(UMCrash.SP_KEY_TIMESTAMP, Long.valueOf(com.bytedance.msdk.api.a.uy.dl()));
                return;
            } else if (aVar.z() != -1) {
                jSONObject.putOpt(UMCrash.SP_KEY_TIMESTAMP, Long.valueOf(aVar.z()));
                return;
            } else {
                jSONObject.putOpt(UMCrash.SP_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
                return;
            }
        }
        jSONObject.putOpt(UMCrash.SP_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
    }

    private static void g(a aVar, JSONObject jSONObject) {
        if (aVar != null) {
            if ("media_request".equals(aVar.z) || "media_fill".equals(aVar.z) || "media_fill_fail".equals(aVar.z) || "get_bidding_adm_to_adn".equals(aVar.z) || "bidding_adm_load".equals(aVar.z) || "bidding_adm_load_fail".equals(aVar.z) || "bidding_win_event".equals(aVar.z) || "media_show_is_ready".equals(aVar.z) || "media_will_show".equals(aVar.z) || "media_show".equals(aVar.z) || "media_show_fail".equals(aVar.z) || "media_show_listen".equals(aVar.z) || "media_show_fail_listen".equals(aVar.z) || "media_click_listen".equals(aVar.z) || "sdk_init".equals(aVar.z) || "sdk_init_end".equals(aVar.z) || "get_config_start".equals(aVar.z) || "get_config_final".equals(aVar.z) || "mediation_request".equals(aVar.z) || "mediation_fill".equals(aVar.z) || "mediation_request_end".equals(aVar.z) || "total_load_fail".equals(aVar.z)) {
                aVar.z("grouping_params", com.bytedance.msdk.core.v.g.g());
                JSONObject jSONObjectDl = com.bytedance.msdk.core.v.g.dl();
                if (jSONObjectDl != null) {
                    aVar.z("user_defined_grouping_params", jSONObjectDl.toString());
                } else {
                    aVar.z("user_defined_grouping_params", null);
                }
                com.bytedance.msdk.core.fo.a.z(aVar.gz, aVar.z, aVar.p, jSONObject);
            }
        }
    }

    private static void dl(JSONObject jSONObject, a aVar) throws JSONException {
        if (jSONObject == null || aVar == null) {
            return;
        }
        if ("media_fill_fail".equals(aVar.z) || "media_fill".equals(aVar.z) || "bidding_adm_load".equals(aVar.z) || "bidding_adm_load_fail".equals(aVar.z) || "mediation_fill".equals(aVar.z) || "mediation_request_end".equals(aVar.z) || "mediation_video_cached".equals(aVar.z) || "get_config_final".equals(aVar.z) || "sdk_init_end".equals(aVar.z) || "sdk_backstage".equals(aVar.z) || "mediation_request".equals(aVar.z) || "rit_map_query".equals(aVar.z) || "return_bidding_result".equals(aVar.z)) {
            jSONObject.putOpt("duration", Long.valueOf(aVar.fv));
        }
    }

    private static void z(JSONObject jSONObject, Throwable th, a aVar) throws JSONException {
        if (jSONObject != null && th != null) {
            String strOptString = jSONObject.optString("event_extra");
            if (!TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                jSONObject2.putOpt("err_msg_comm", th.toString());
                jSONObject.putOpt("event_extra", jSONObject2.toString());
            }
        }
        if (aVar == null || th == null) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.putOpt("comm_eventId", aVar.iq.get("event_id"));
        jSONObject3.putOpt("err_msg_comm", th.toString());
        l.z(jSONObject3);
    }

    public String dl() {
        if (TextUtils.isEmpty(this.z) || this.g == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("localId", this.z);
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, this.g);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "AdEvent{localId='" + this.z + "', event=" + this.g + '}';
    }
}
