package com.bytedance.adsdk.ugeno.dl;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f231a;
    private JSONObject dl;
    private JSONObject g;
    private Context z;

    public Context getContext() {
        return this.z;
    }

    public void z(Context context) {
        this.z = context;
    }

    public void z(JSONObject jSONObject) {
        this.g = jSONObject;
    }

    public JSONObject z() {
        return this.dl;
    }

    public void g(JSONObject jSONObject) {
        this.dl = jSONObject;
    }

    public Map<String, Object> g() {
        return this.f231a;
    }

    public void z(Map<String, Object> map) {
        this.f231a = map;
    }
}
