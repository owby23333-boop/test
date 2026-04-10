package com.bytedance.sdk.openadsdk.core.dislike;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wu;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class bf {
    private String bf;
    private String d;
    private boolean e;

    public String bf() {
        return this.bf;
    }

    public String d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("enable", Boolean.valueOf(this.e));
            jSONObject.putOpt("upload_api", this.bf);
            jSONObject.putOpt("alert_text", this.d);
        } catch (JSONException e) {
            wu.d("OncallUploadConfig", e);
        }
        return jSONObject.toString();
    }

    public static bf e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return e(new JSONObject(str));
        } catch (JSONException e) {
            wu.tg("OncallUploadConfig", "parse failed:" + e);
            return null;
        }
    }

    public static bf e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        bf bfVar = new bf();
        bfVar.e = jSONObject.optBoolean("enable");
        bfVar.bf = jSONObject.optString("upload_api");
        bfVar.d = jSONObject.optString("alert_text");
        return bfVar;
    }
}
