package com.bytedance.sdk.openadsdk.core.e;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1039a;
    private int dl;
    private int g;
    private int z;

    public int z() {
        return this.z;
    }

    public void z(int i) {
        this.z = i;
    }

    public int g() {
        return this.g;
    }

    public void g(int i) {
        this.g = i;
    }

    public int dl() {
        return this.dl;
    }

    public void dl(int i) {
        this.dl = i;
    }

    public static g z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return z(new JSONObject(str));
        } catch (JSONException e) {
            wp.g("CLogConfig", "parse failed:".concat(String.valueOf(e)));
            return null;
        }
    }

    public static g z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        g gVar = new g();
        gVar.g(jSONObject.optInt("expire_days"));
        gVar.z(jSONObject.optInt("log_level"));
        gVar.dl(jSONObject.optInt("max_size"));
        gVar.z(jSONObject.optBoolean("is_open"));
        return gVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("expire_days", g());
            jSONObject.put("log_level", z());
            jSONObject.put("max_size", dl());
            jSONObject.put("is_open", a());
        } catch (JSONException e) {
            wp.z(e);
        }
        return jSONObject.toString();
    }

    public boolean a() {
        return this.f1039a;
    }

    public void z(boolean z) {
        this.f1039a = z;
    }
}
