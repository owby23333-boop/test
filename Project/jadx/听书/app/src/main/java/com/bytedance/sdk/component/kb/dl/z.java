package com.bytedance.sdk.component.kb.dl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private int dl;
    private String g;
    private String z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f755a = new HashMap();
    private List<C0138z> gc = new ArrayList();
    private final List<C0138z> m = new ArrayList();
    private final List<C0138z> e = new ArrayList();

    public String z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public Map<String, String> dl() {
        return this.f755a;
    }

    public List<C0138z> a() {
        return this.gc;
    }

    public z(JSONObject jSONObject) {
        z(jSONObject);
    }

    public void z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.z = jSONObject.optString("name");
        this.dl = jSONObject.optInt("index");
        this.g = jSONObject.optString("scheme");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.f755a.put(next, jSONObjectOptJSONObject.optString(next));
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("next");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    this.gc.add(new C0138z(jSONObjectOptJSONObject2.optString("name"), jSONObjectOptJSONObject2.optString("condition")));
                }
            }
        } else {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("next");
            if (jSONObjectOptJSONObject3 != null) {
                this.gc.add(new C0138z(jSONObjectOptJSONObject3.optString("name"), jSONObjectOptJSONObject3.optString("condition")));
            }
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("callback");
        if (jSONObjectOptJSONObject4 == null) {
            jSONObjectOptJSONObject4 = new JSONObject();
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray("success");
        if (jSONArrayOptJSONArray2 == null) {
            jSONArrayOptJSONArray2 = new JSONArray();
        }
        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
            JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i2);
            if (jSONObjectOptJSONObject5 != null) {
                this.m.add(new C0138z(jSONObjectOptJSONObject5.optString("name"), jSONObjectOptJSONObject5.optString("condition")));
            }
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject4.optJSONArray("fail");
        if (jSONArrayOptJSONArray3 == null) {
            jSONArrayOptJSONArray3 = new JSONArray();
        }
        for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
            JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray3.optJSONObject(i3);
            if (jSONObjectOptJSONObject6 != null) {
                this.e.add(new C0138z(jSONObjectOptJSONObject6.optString("name"), jSONObjectOptJSONObject6.optString("condition")));
            }
        }
    }

    public List<C0138z> gc() {
        return this.m;
    }

    public List<C0138z> m() {
        return this.e;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.kb.dl.z$z, reason: collision with other inner class name */
    public static class C0138z {
        private String g;
        private String z;

        public String z() {
            return this.z;
        }

        public String g() {
            return this.g;
        }

        public C0138z(String str, String str2) {
            this.z = str;
            this.g = str2;
        }
    }
}
