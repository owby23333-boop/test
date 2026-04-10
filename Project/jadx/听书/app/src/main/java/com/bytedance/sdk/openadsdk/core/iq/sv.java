package com.bytedance.sdk.openadsdk.core.iq;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class sv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1194a;
    private long dl;
    private int g;
    private int gc;
    private int z;

    public static sv z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        sv svVar = new sv();
        svVar.z = jSONObject.optInt("auth_type");
        svVar.g = jSONObject.optInt("auth_time");
        svVar.dl = jSONObject.optLong("auth_out_time");
        svVar.f1194a = jSONObject.optInt("video_open_deeplink");
        svVar.gc = jSONObject.optInt("reject_in");
        return svVar;
    }

    public JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("auth_type", this.z);
            jSONObject.put("auth_time", this.g);
            jSONObject.put("auth_out_time", this.dl);
            jSONObject.put("video_open_deeplink", this.f1194a);
            jSONObject.put("reject_in", this.gc);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject;
    }

    public int g() {
        return this.z;
    }

    public int dl() {
        return this.g;
    }

    public int a() {
        return this.f1194a;
    }

    public long gc() {
        return this.dl;
    }

    public int m() {
        return this.gc;
    }
}
