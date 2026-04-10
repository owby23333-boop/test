package com.bytedance.adsdk.ugeno.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private List<z> g;
    private z z;

    public z z() {
        return this.z;
    }

    public List<z> g() {
        return this.g;
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f244a;
        private String dl = "global";
        private String g;
        private Map<String, String> gc;
        private Map<String, Object> m;
        private String z;

        public String z() {
            return this.dl;
        }

        public void z(String str) {
            this.dl = str;
        }

        public String g() {
            return this.f244a;
        }

        public void g(String str) {
            this.f244a = str;
        }

        public Map<String, String> dl() {
            return this.gc;
        }

        public void z(Map<String, String> map) {
            this.gc = map;
        }

        public void dl(String str) {
            this.z = str;
        }

        public String a() {
            return this.z;
        }

        public void a(String str) {
            this.g = str;
        }

        public String gc() {
            return this.g;
        }

        public String toString() {
            return "Action{scheme='" + this.dl + "', name='" + this.f244a + "', params=" + this.gc + ", host='" + this.g + "', origin='" + this.z + "', extra=" + this.m + '}';
        }
    }

    public static m z(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        m mVar = new m();
        String strOptString = jSONObject.optString(DebugKt.DEBUG_PROPERTY_VALUE_ON);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("handlers");
        mVar.z = wp.z(strOptString, jSONObject2);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            z zVarZ = wp.z(jSONArrayOptJSONArray.optString(i), jSONObject2);
            if (zVarZ != null) {
                arrayList.add(zVarZ);
            }
        }
        mVar.g = arrayList;
        return mVar;
    }
}
