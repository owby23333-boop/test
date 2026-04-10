package com.bytedance.sdk.openadsdk.core.dt;

import android.text.TextUtils;
import com.xiaomi.verificationsdk.internal.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class d {
    private String bf;
    private String d;
    private String e;
    private String ga;
    private JSONArray m;
    private String p;
    private List<e> tg;
    private float v;
    private String vn;
    private String zk;

    public static class e {
        private final String bf;
        private final String e;

        public e(JSONObject jSONObject) {
            this.e = jSONObject.optString("permission_name");
            this.bf = jSONObject.optString("permission_desc");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject e() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("permission_desc", this.bf);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                jSONObject.put("permission_name", this.e);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    public d(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("package");
            this.e = jSONObjectOptJSONObject.optString(Constants.APP_NAME);
            this.bf = jSONObjectOptJSONObject.optString("version_name");
            this.d = jSONObjectOptJSONObject.optString("developer_name");
            this.tg = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.tg.add(new e(jSONArrayOptJSONArray.optJSONObject(i)));
                }
            }
            this.ga = jSONObjectOptJSONObject.optString("policy_url");
            String strOptString = jSONObjectOptJSONObject.optString("package");
            this.vn = strOptString;
            if (TextUtils.isEmpty(strOptString)) {
                this.vn = jSONObjectOptJSONObject.optString("package_name");
            }
            this.p = jSONObjectOptJSONObject.optString("icon_url");
            this.zk = jSONObjectOptJSONObject.optString("desc_url");
        } catch (Throwable unused) {
        }
    }

    public String bf() {
        return this.d;
    }

    public String d() {
        return this.p;
    }

    public String e() {
        return this.e;
    }

    public boolean ga() {
        List<e> list;
        return (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.bf) || TextUtils.isEmpty(bf()) || (list = this.tg) == null || list.size() == 0 || TextUtils.isEmpty(this.ga) || TextUtils.isEmpty(this.zk)) ? false : true;
    }

    public String tg() {
        return this.zk;
    }

    public String vn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.APP_NAME, this.e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("app_version", this.bf);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        try {
            jSONObject.put("developer_name", this.d);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("package_name", this.vn);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<e> it = this.tg.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().e());
        }
        try {
            jSONObject.put("permissions", jSONArray);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put("privacy_policy_url", this.ga);
        } catch (JSONException e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject.put("score", this.v);
        } catch (JSONException e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put("creative_tags", this.m);
        } catch (JSONException e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put("desc_url", this.zk);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        try {
            jSONObject.put("icon_url", this.p);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void e(float f) {
        this.v = f;
    }

    public void e(JSONArray jSONArray) {
        this.m = jSONArray;
    }
}
