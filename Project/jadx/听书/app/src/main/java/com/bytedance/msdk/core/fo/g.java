package com.bytedance.msdk.core.fo;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.umcrash.UMCrash;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f385a;
    protected final Map<String, String> dl;

    private g() {
        super("label_v_v_s_3");
        this.dl = new ConcurrentHashMap();
        g();
    }

    public static g a() {
        if (f385a == null) {
            synchronized (g.class) {
                if (f385a == null) {
                    f385a = new g();
                }
            }
        }
        return f385a;
    }

    protected void z(String str, int i, double d) {
        if (!com.bytedance.msdk.core.g.g().y() || TextUtils.isEmpty(str)) {
            return;
        }
        z(3, str, i, d);
    }

    @Override // com.bytedance.msdk.core.fo.z
    protected void z(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        com.bytedance.msdk.z.gc.dl.g("DynamicLabelValueManagerAbs", "readCacheFromSp-SP_NAME_V3，cpmKey:" + str + "，type_value_timestamp:" + str2);
        if (str.startsWith("cpm_key_")) {
            this.dl.put(str, str2);
        }
    }

    @Override // com.bytedance.msdk.core.fo.z
    protected Map<String, String> z() {
        return this.dl;
    }

    @Override // com.bytedance.msdk.core.fo.z
    protected void z(String str, int i, String str2) {
        if (i == 3) {
            this.dl.put(str, str2);
        }
    }

    @Override // com.bytedance.msdk.core.fo.z
    protected boolean g(String str, JSONObject jSONObject, Map<String, Object> map) {
        try {
            Object obj = map.get("user_label_value");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            jSONObject2.putOpt("label_info", z(obj != null ? (com.bytedance.msdk.core.uy.dl) obj : null));
            jSONObject2.putOpt("ecpm_ttl", Integer.valueOf(com.bytedance.msdk.core.g.g().ec()));
            jSONObject2.putOpt("rule_id", map.get("rule_id"));
            jSONObject2.putOpt("group_type", map.get("group_type"));
            jSONObject2.putOpt("rule_in_use", map.get("rule_in_use"));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt(MediationConstant.KEY_ECPM, map.get(MediationConstant.KEY_ECPM));
            jSONObject3.putOpt(UMCrash.SP_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            jSONObject2.putOpt("ecpm_info", jSONObject3);
            jSONObject2.putOpt("refresh_time", map.get("refresh_time"));
            return true;
        } catch (JSONException e) {
            wp.z(e);
            return false;
        }
    }

    protected void dl(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (!com.bytedance.msdk.core.g.g().y() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.putOpt("rule_id", map.get("rule_id"));
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    @Override // com.bytedance.msdk.core.fo.z
    protected JSONObject z(com.bytedance.msdk.core.uy.dl dlVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("label_name", dlVar != null ? dlVar.z() : "-1");
            jSONObject.putOpt("label_id", dlVar != null ? Integer.valueOf(dlVar.dl()) : "-1");
            jSONObject.putOpt("label_version", dlVar != null ? dlVar.a() : "-1");
            return jSONObject;
        } catch (JSONException e) {
            wp.z(e);
            return null;
        }
    }
}
