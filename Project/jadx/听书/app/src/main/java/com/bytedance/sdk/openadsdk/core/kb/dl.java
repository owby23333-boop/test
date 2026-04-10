package com.bytedance.sdk.openadsdk.core.kb;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private JSONObject z;

    public dl(JSONObject jSONObject) {
        this.z = jSONObject;
    }

    public boolean z() {
        JSONObject jSONObject = this.z;
        return jSONObject == null || jSONObject.optInt("enable_install_notification", 1) == 1;
    }

    public boolean g() {
        JSONObject jSONObject = this.z;
        return jSONObject == null || jSONObject.optInt("enable_active_notification", 1) == 1;
    }

    public boolean dl() {
        JSONObject jSONObject = this.z;
        return jSONObject != null && jSONObject.optInt("enable_install_interface", 0) == 1;
    }

    public long a() {
        JSONObject jSONObject = this.z;
        if (jSONObject == null) {
            return 300L;
        }
        return jSONObject.optLong("uninstall_delay", 300L);
    }

    public long gc() {
        JSONObject jSONObject = this.z;
        if (jSONObject == null) {
            return 1800L;
        }
        return jSONObject.optLong("notification_internal", 1800L);
    }

    public int m() {
        JSONObject jSONObject = this.z;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_notification", 1);
    }

    public int e() {
        JSONObject jSONObject = this.z;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_interface", 1);
    }
}
