package com.bytedance.sdk.openadsdk.core.iq;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class nh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1186a;
    private String dl;
    private String e;
    private String g;
    private JSONObject gc;
    private String gz;
    private int m;
    private String z;

    public String z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public String dl() {
        return this.dl;
    }

    public String a() {
        return this.f1186a;
    }

    public JSONObject gc() {
        return this.gc;
    }

    public String m() {
        return this.e;
    }

    public int e() {
        return this.m;
    }

    public String gz() {
        return this.gz;
    }

    public static nh z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        nh nhVar = new nh();
        nhVar.z = jSONObject.optString("id");
        nhVar.f1186a = jSONObject.optString("data");
        nhVar.dl = jSONObject.optString("url");
        nhVar.g = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
        nhVar.e = jSONObject.optString("express_gesture_priority");
        nhVar.m = jSONObject.optInt("material_type");
        nhVar.gc = jSONObject.optJSONObject("custom_components");
        nhVar.gz = jSONObject.optString("rule_id");
        return nhVar;
    }

    public JSONObject fo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.z);
            jSONObject.put(TKDownloadReason.KSAD_TK_MD5, this.g);
            jSONObject.put("url", this.dl);
            jSONObject.put("data", this.f1186a);
            jSONObject.put("material_type", this.m);
            jSONObject.put("custom_components", this.gc);
            jSONObject.put("express_gesture_priority", this.e);
            jSONObject.put("rule_id", this.gz);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject;
    }
}
