package com.bytedance.msdk.core.dl;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f382a;
    private int dl;
    private int e;
    private JSONObject g;
    private String gc;
    private String m;
    public List<Integer> z;

    public g(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("behavior_state");
        if (jSONArrayOptJSONArray != null) {
            this.z = new LinkedList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                try {
                    this.z.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(i)));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("rule_excs");
        if (jSONObjectOptJSONObject != null) {
            this.e = jSONObjectOptJSONObject.optInt("condition");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("perform");
            this.g = jSONObjectOptJSONObject2;
            if (jSONObjectOptJSONObject2 != null) {
                this.dl = jSONObjectOptJSONObject2.optInt("condition");
                this.f382a = this.g.optString("opt");
                this.gc = this.g.optString("rule_id");
                this.m = this.g.optString("rule_timestamp");
            }
        }
    }

    public int z() {
        return this.dl;
    }

    public int g() {
        return this.e;
    }

    public String dl() {
        return this.gc;
    }

    public String a() {
        return this.m;
    }

    public JSONObject gc() {
        return this.g;
    }

    public boolean z(int i) {
        List<Integer> list = this.z;
        if (list != null) {
            return list.contains(Integer.valueOf(i));
        }
        return false;
    }

    public String m() {
        return this.f382a;
    }

    public boolean e() {
        return "1".equals(this.f382a) || "2".equals(this.f382a) || "3".equals(this.f382a) || "4".equals(this.f382a) || "5".equals(this.f382a);
    }

    public boolean z(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = this.g.optJSONObject("prime_rits");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(str)) == null) {
            return false;
        }
        return (jSONObjectOptJSONObject.optJSONObject("ssr") == null && jSONObjectOptJSONObject.optJSONObject("srr") == null) ? false : true;
    }

    public double z(String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (jSONObject = this.g) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("prime_rits")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str2)) == null || (jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("ssr")) == null) {
            return 0.0d;
        }
        return jSONObjectOptJSONObject3.optDouble(str, 0.0d);
    }

    public double g(String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (jSONObject = this.g) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("prime_rits")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str2)) == null || (jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("srr")) == null) {
            return 0.0d;
        }
        return jSONObjectOptJSONObject3.optDouble(str, 0.0d);
    }
}
