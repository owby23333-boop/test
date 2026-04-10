package com.bytedance.msdk.core.kb;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.uy;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f403a;
    private Function<SparseArray<Object>, Object> m;
    private boolean g = false;
    private boolean dl = false;
    private boolean gc = false;

    private z() {
    }

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    public void g() {
        this.g = true;
    }

    public boolean dl() {
        return this.g;
    }

    public void z(boolean z2) {
        this.dl = z2;
    }

    public boolean a() {
        return this.dl;
    }

    public boolean z(String str, int i, boolean z2) {
        return z2 || z(str) || com.bytedance.msdk.core.g.g().z(str, i, 101) != null;
    }

    public boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("200000000".equals(str)) {
            return true;
        }
        return str.matches("^1[0-9]{8}$");
    }

    public void z(g gVar) {
        this.f403a = gVar;
    }

    public void gc() {
        g gVar = this.f403a;
        if (gVar != null) {
            gVar.z();
        }
    }

    public void z(int i, String str) {
        g gVar = this.f403a;
        if (gVar != null) {
            gVar.z(i, str);
        }
    }

    public void m() {
        this.gc = true;
    }

    public void z(Function<SparseArray<Object>, Object> function) {
        this.m = function;
    }

    public Function<SparseArray<Object>, Object> e() {
        return this.m;
    }

    public String g(String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        JSONObject jSONObjectZ = z(jSONObject);
        if (jSONObjectZ != null) {
            return jSONObjectZ.toString();
        }
        return null;
    }

    public JSONObject z(JSONObject jSONObject) {
        String strQd = uy.ls().qd();
        if (TextUtils.isEmpty(strQd)) {
            return jSONObject;
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("app_ab_version", strQd);
                return jSONObject2;
            } catch (JSONException unused) {
                return null;
            }
        }
        try {
            if (jSONObject.has("app_ab_version")) {
                String strOptString = jSONObject.optString("app_ab_version");
                if (TextUtils.isEmpty(strOptString)) {
                    jSONObject.put("app_ab_version", strQd);
                } else {
                    jSONObject.put("app_ab_version", strOptString + "," + strQd);
                }
            } else {
                jSONObject.put("app_ab_version", strQd);
            }
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    public String dl(String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        JSONObject jSONObjectG = g(jSONObject);
        if (jSONObjectG != null) {
            return jSONObjectG.toString();
        }
        return null;
    }

    public JSONObject g(JSONObject jSONObject) {
        String strQd = uy.ls().qd();
        if (TextUtils.isEmpty(strQd)) {
            return jSONObject;
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("waterfall_ab_version", strQd);
                return jSONObject2;
            } catch (JSONException unused) {
                return null;
            }
        }
        try {
            if (jSONObject.has("waterfall_ab_version")) {
                String strOptString = jSONObject.optString("waterfall_ab_version");
                if (TextUtils.isEmpty(strOptString)) {
                    jSONObject.put("waterfall_ab_version", strQd);
                } else {
                    jSONObject.put("waterfall_ab_version", strOptString + "," + strQd);
                }
            } else {
                jSONObject.put("waterfall_ab_version", strQd);
            }
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }
}
