package com.bytedance.sdk.openadsdk.core.iq;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONObject f1159a;
    private static int dl;
    private static int g;
    private static int z;

    public static boolean z() {
        return z == 1;
    }

    public static boolean g() {
        return g == 1;
    }

    public static boolean dl() {
        return dl == 1;
    }

    public static void z(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config")) == null) {
            return;
        }
        g(jSONObjectOptJSONObject.optJSONObject("dex_strategy"));
    }

    private static void g(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        z = jSONObject.optInt("use_dex_load_gdt");
        g = jSONObject.optInt("use_dex_load_ks");
        dl = jSONObject.optInt("use_dex_load_xiaomi");
        f1159a = jSONObject;
    }

    public static void z(com.bytedance.sdk.component.a.g.dl dlVar) {
        JSONObject jSONObject;
        if (dlVar == null || (jSONObject = f1159a) == null) {
            return;
        }
        dlVar.put("dex_strategy", jSONObject.toString());
    }

    public static void g(com.bytedance.sdk.component.a.g.dl dlVar) {
        if (dlVar != null) {
            try {
                g(new JSONObject(dlVar.get("dex_strategy", "")));
            } catch (JSONException unused) {
            }
        }
    }
}
