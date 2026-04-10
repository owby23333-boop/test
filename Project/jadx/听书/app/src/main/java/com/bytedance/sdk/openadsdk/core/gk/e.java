package com.bytedance.sdk.openadsdk.core.gk;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public boolean z = false;
    public boolean g = false;
    public boolean dl = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1108a = false;
    private boolean gc = false;

    public static e z(String str) {
        e eVar = new e();
        if (TextUtils.isEmpty(str)) {
            return eVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            eVar.z = jSONObject.optBoolean("use_csj_main", false);
            eVar.g = jSONObject.optBoolean("use_layze_layout", false);
            eVar.dl = jSONObject.optBoolean("create_ad_in_io", false);
            eVar.f1108a = jSONObject.optBoolean("opt_panel_view", false);
            boolean zOptBoolean = jSONObject.optBoolean("so_lock", false);
            eVar.gc = zOptBoolean;
            if (zOptBoolean) {
                com.bytedance.sdk.openadsdk.hh.m.z().mkdirs();
            }
        } catch (Throwable unused) {
        }
        return eVar;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("use_csj_main", this.z);
            jSONObject.put("use_layze_layout", this.g);
            jSONObject.put("create_ad_in_io", this.dl);
            jSONObject.put("opt_panel_view", this.f1108a);
            jSONObject.put("so_lock", this.gc);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
