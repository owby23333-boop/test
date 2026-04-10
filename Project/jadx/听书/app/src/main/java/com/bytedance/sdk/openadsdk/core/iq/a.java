package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<z> f1149a;
    private String dl;
    private String e;
    private String fo;
    private String g;
    private String gc;
    private float gz;
    private JSONObject i;
    private JSONArray kb;
    private String m;
    private String uy;
    private String wp;
    private String z;

    public a(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("package");
            this.z = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME);
            this.g = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            this.dl = jSONObjectOptJSONObject.optString("developer_name");
            this.f1149a = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.f1149a.add(new z(jSONArrayOptJSONArray.optJSONObject(i)));
                }
            }
            this.gc = jSONObjectOptJSONObject.optString("policy_url");
            String strOptString = jSONObjectOptJSONObject.optString("package");
            this.m = strOptString;
            if (TextUtils.isEmpty(strOptString)) {
                this.m = jSONObjectOptJSONObject.optString(an.o);
            }
            this.e = jSONObjectOptJSONObject.optString("icon_url");
            this.fo = jSONObjectOptJSONObject.optString("desc_url");
            this.uy = jSONObjectOptJSONObject.optString("reg_number");
            this.wp = jSONObjectOptJSONObject.optString("reg_url");
            this.i = jSONObjectOptJSONObject.optJSONObject("reg_info");
        } catch (Throwable unused) {
        }
    }

    public String z() {
        return this.z;
    }

    public String g() {
        return this.dl;
    }

    public String dl() {
        return this.e;
    }

    public void z(float f) {
        this.gz = f;
    }

    public void z(JSONArray jSONArray) {
        this.kb = jSONArray;
    }

    public String a() {
        return this.fo;
    }

    public boolean gc() {
        List<z> list;
        return (TextUtils.isEmpty(this.z) || TextUtils.isEmpty(this.g) || TextUtils.isEmpty(g()) || (list = this.f1149a) == null || list.size() == 0 || TextUtils.isEmpty(this.gc) || TextUtils.isEmpty(this.fo)) ? false : true;
    }

    public String m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, this.z);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        try {
            jSONObject.put("app_version", this.g);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
        try {
            jSONObject.put("developer_name", this.dl);
        } catch (JSONException e3) {
            com.bytedance.sdk.component.utils.wp.z(e3);
        }
        try {
            jSONObject.put(an.o, this.m);
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.wp.z(e4);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<z> it = this.f1149a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().z());
        }
        try {
            jSONObject.put("permissions", jSONArray);
        } catch (JSONException e5) {
            com.bytedance.sdk.component.utils.wp.z(e5);
        }
        try {
            jSONObject.put("privacy_policy_url", this.gc);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.wp.z(e6);
        }
        try {
            jSONObject.put("score", this.gz);
        } catch (JSONException e7) {
            com.bytedance.sdk.component.utils.wp.z(e7);
        }
        try {
            jSONObject.put("creative_tags", this.kb);
        } catch (JSONException e8) {
            com.bytedance.sdk.component.utils.wp.z(e8);
        }
        try {
            jSONObject.put("desc_url", this.fo);
        } catch (JSONException e9) {
            com.bytedance.sdk.component.utils.wp.z(e9);
        }
        try {
            jSONObject.put("reg_number", this.uy);
        } catch (JSONException e10) {
            com.bytedance.sdk.component.utils.wp.z(e10);
        }
        try {
            jSONObject.put("icon_url", this.e);
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.wp.z(e11);
        }
        try {
            jSONObject.put("reg_url", this.wp);
        } catch (JSONException e12) {
            com.bytedance.sdk.component.utils.wp.z(e12);
        }
        try {
            jSONObject.put("reg_info", this.i);
        } catch (JSONException e13) {
            com.bytedance.sdk.component.utils.wp.z(e13);
        }
        return jSONObject.toString();
    }

    private static class z {
        private final String g;
        private final String z;

        public z(JSONObject jSONObject) {
            this.z = jSONObject.optString("permission_name");
            this.g = jSONObject.optString("permission_desc");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject z() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("permission_desc", this.g);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
            try {
                jSONObject.put("permission_name", this.z);
            } catch (JSONException e2) {
                com.bytedance.sdk.component.utils.wp.z(e2);
            }
            return jSONObject;
        }
    }
}
