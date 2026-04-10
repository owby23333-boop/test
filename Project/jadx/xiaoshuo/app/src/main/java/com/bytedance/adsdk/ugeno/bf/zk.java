package com.bytedance.adsdk.ugeno.bf;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zk {
    private JSONObject bf;
    private Map<String, Object> d;
    private Context e;

    public Map<String, Object> bf() {
        return this.d;
    }

    public void e(Context context) {
        this.e = context;
    }

    public Context getContext() {
        return this.e;
    }

    public JSONObject e() {
        return this.bf;
    }

    public void e(JSONObject jSONObject) {
        this.bf = jSONObject;
    }

    public void e(Map<String, Object> map) {
        this.d = map;
    }
}
