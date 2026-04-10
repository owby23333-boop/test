package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class jq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1174a;
    private int dl;
    private boolean g;
    private boolean z;

    public jq(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("window_landing");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        this.z = jSONObjectOptJSONObject.optBoolean("can_jump_to_landing", false);
        this.g = jSONObjectOptJSONObject.optBoolean("can_click_to_landing", false);
        this.dl = jSONObjectOptJSONObject.optInt("auto_to_landing_type", 0);
        this.f1174a = jSONObjectOptJSONObject.optInt("auto_to_landing_time", 0);
    }

    public void z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("can_jump_to_landing", this.z);
            jSONObject2.put("can_click_to_landing", this.g);
            jSONObject2.put("auto_to_landing_type", this.dl);
            jSONObject2.put("auto_to_landing_time", this.f1174a);
            jSONObject.put("window_landing", jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.dl("parse json:" + e.getMessage());
        }
    }

    public static boolean z(na naVar) {
        jq jqVarIq = gb.iq(naVar);
        if (jqVarIq == null || !jqVarIq.z || vm.z(naVar) == 1) {
            return false;
        }
        if (vm.z(naVar) == 2 && vm.g(naVar) == 3) {
            return false;
        }
        if (vm.z(naVar) == 2 && vm.g(naVar) == 7) {
            return false;
        }
        return (naVar.ou() == 5 || naVar.ou() == 15) && !TextUtils.isEmpty(gc(naVar));
    }

    public static boolean g(na naVar) {
        jq jqVarIq = gb.iq(naVar);
        if (jqVarIq == null) {
            return false;
        }
        return jqVarIq.g;
    }

    public static int dl(na naVar) {
        jq jqVarIq = gb.iq(naVar);
        if (jqVarIq == null) {
            return 0;
        }
        return jqVarIq.dl;
    }

    public static int a(na naVar) {
        jq jqVarIq = gb.iq(naVar);
        if (jqVarIq == null) {
            return 0;
        }
        return jqVarIq.f1174a;
    }

    public static String gc(na naVar) {
        return naVar == null ? "" : naVar.fp();
    }
}
