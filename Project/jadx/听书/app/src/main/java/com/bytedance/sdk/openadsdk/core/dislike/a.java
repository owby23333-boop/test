package com.bytedance.sdk.openadsdk.core.dislike;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.zw;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.dl.dl f1022a;
    private String dl;
    private String g;
    private boolean z;

    public static a z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return z(new JSONObject(str));
        } catch (JSONException e) {
            wp.g("OncallUploadConfig", "parse failed:".concat(String.valueOf(e)));
            return null;
        }
    }

    public static a z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.z = jSONObject.optBoolean("enable");
        aVar.g = jSONObject.optString("upload_api");
        aVar.dl = jSONObject.optString("alert_text");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("filter_word");
        if (jSONObjectOptJSONObject != null) {
            com.bytedance.sdk.openadsdk.core.dislike.dl.dl dlVarZ = com.bytedance.sdk.openadsdk.core.dislike.dl.dl.z(jSONObjectOptJSONObject);
            if (dlVarZ != null) {
                if (TextUtils.isEmpty(dlVarZ.z())) {
                    dlVarZ.z("99:1");
                }
                if (TextUtils.isEmpty(dlVarZ.g())) {
                    dlVarZ.g("素材反馈");
                }
            }
            aVar.f1022a = dlVarZ;
        }
        return aVar;
    }

    public static com.bytedance.sdk.openadsdk.core.dislike.dl.dl z() {
        a aVarWn = zw.g().wn();
        if (aVarWn != null) {
            return aVarWn.gc();
        }
        return null;
    }

    public boolean g() {
        return this.z;
    }

    public String dl() {
        return this.g;
    }

    public String a() {
        return this.dl;
    }

    public com.bytedance.sdk.openadsdk.core.dislike.dl.dl gc() {
        return this.f1022a;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("enable", Boolean.valueOf(this.z));
            jSONObject.putOpt("upload_api", this.g);
            jSONObject.putOpt("alert_text", this.dl);
            com.bytedance.sdk.openadsdk.core.dislike.dl.dl dlVar = this.f1022a;
            if (dlVar != null) {
                jSONObject.putOpt("filter_word", dlVar.e());
            }
        } catch (JSONException e) {
            wp.g("OncallUploadConfig", e);
        }
        return jSONObject.toString();
    }
}
