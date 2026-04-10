package com.bytedance.sdk.openadsdk.core.ga;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wu;
import com.yuewen.e01;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class bf {
    private int bf;
    private int d;
    private int e;
    private boolean tg;

    public int bf() {
        return this.bf;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public boolean tg() {
        return this.tg;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("expire_days", bf());
            jSONObject.put(e01.z3, e());
            jSONObject.put("max_size", d());
            jSONObject.put("is_open", tg());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void bf(int i) {
        this.bf = i;
    }

    public void d(int i) {
        this.d = i;
    }

    public void e(int i) {
        this.e = i;
    }

    public static bf e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return e(new JSONObject(str));
        } catch (JSONException e) {
            wu.tg("CLogConfig", "parse failed:" + e);
            return null;
        }
    }

    public static bf e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        bf bfVar = new bf();
        bfVar.bf(jSONObject.optInt("expire_days"));
        bfVar.e(jSONObject.optInt(e01.z3));
        bfVar.d(jSONObject.optInt("max_size"));
        bfVar.e(jSONObject.optBoolean("is_open"));
        return bfVar;
    }

    public void e(boolean z) {
        this.tg = z;
    }
}
