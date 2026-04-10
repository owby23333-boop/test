package com.bytedance.sdk.component.kb.dl;

import android.text.TextUtils;
import com.bytedance.sdk.component.kb.dl.z;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, z> f754a = new HashMap();
    private boolean dl;
    private String g;
    private z gc;
    private JSONObject m;
    private String z;

    public dl(JSONObject jSONObject) {
        this.dl = false;
        String next = jSONObject.keys().next();
        this.g = next;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
        this.z = jSONObjectOptJSONObject.optString("version");
        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("lazyLoad");
        this.dl = zOptBoolean;
        if (!zOptBoolean) {
            z(jSONObjectOptJSONObject);
        } else {
            this.m = jSONObjectOptJSONObject;
        }
    }

    private void z(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(d.ar);
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            z zVar = new z(jSONArrayOptJSONArray.optJSONObject(i));
            this.f754a.put(zVar.z(), zVar);
            if (zVar.z().equals(jSONObject.optString("main"))) {
                this.gc = zVar;
            }
        }
    }

    public z z(String str) {
        if (this.dl) {
            z(this.m);
        }
        return this.f754a.get(str);
    }

    public z z() {
        if (this.dl) {
            z(this.m);
        }
        return this.gc;
    }

    public String g() {
        return this.g;
    }

    public List<z> z(z zVar, JSONObject jSONObject, Map<String, Object> map) {
        return z(jSONObject, map, zVar.gc());
    }

    public List<z> g(z zVar, JSONObject jSONObject, Map<String, Object> map) {
        return z(jSONObject, map, zVar.m());
    }

    private List<z> z(JSONObject jSONObject, Map<String, Object> map, List<z.C0138z> list) {
        z zVarZ;
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (z.C0138z c0138z : list) {
            if (c0138z != null && (zVarZ = z(c0138z.z())) != null && z(c0138z.g(), jSONObject, map)) {
                arrayList.add(zVarZ);
            }
        }
        return arrayList;
    }

    private static boolean z(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return true;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    jSONObject.put(key, entry.getValue());
                }
            }
            if (str.startsWith("${") && str.endsWith("}")) {
                return Boolean.parseBoolean(com.bytedance.adsdk.g.g.z.z(str.substring(2, str.length() - 1)).z(jSONObject).toString());
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public List<z> dl(z zVar, JSONObject jSONObject, Map<String, Object> map) {
        List<z.C0138z> listA = zVar.a();
        ArrayList arrayList = new ArrayList();
        for (z.C0138z c0138z : listA) {
            if (c0138z != null && z(c0138z.g(), jSONObject, map)) {
                arrayList.add(z(c0138z.z()));
            }
        }
        return arrayList;
    }
}
