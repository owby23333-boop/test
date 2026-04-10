package com.bytedance.msdk.core.uy;

import com.bytedance.sdk.component.utils.wp;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f404a;
    private int dl;
    private JSONObject e;
    private double g;
    private int gc;
    private String m;
    private double z;

    private a(double d, double d2, int i, String str, int i2, String str2, JSONObject jSONObject) {
        this.z = d;
        this.g = d2;
        this.dl = i;
        this.f404a = str;
        this.gc = i2;
        this.m = str2;
        this.e = jSONObject;
    }

    public static void z(JSONObject jSONObject, Map<String, a> map) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("prime_rits")) == null) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                try {
                    map.put(strOptString, new a(jSONObject.optDouble("upper", 0.0d), jSONObject.optDouble("lower", 0.0d), jSONObject.optInt("type"), strOptString, jSONObject.optInt("js_mode"), jSONObject.optString("rule_id"), jSONObject.optJSONObject("refresh_time")));
                } catch (Exception e) {
                    e = e;
                    wp.z(e);
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    public double z() {
        return this.z;
    }

    public double g() {
        return this.g;
    }

    public int getType() {
        return this.dl;
    }

    public int dl() {
        return this.gc;
    }

    public String a() {
        return this.m;
    }

    public int z(String str) {
        JSONObject jSONObject = this.e;
        if (jSONObject != null) {
            return jSONObject.optInt(str);
        }
        return 0;
    }

    public boolean gc() {
        return this.z <= 0.0d && this.g <= 0.0d;
    }
}
