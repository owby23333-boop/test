package com.bytedance.adsdk.ugeno.bf;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class vn {
    private JSONObject bf;
    private String d;
    private JSONObject e;
    private JSONObject tg;

    public static class e {
        private String bf;
        private JSONObject d;
        private String e;
        private e ga;
        private List<e> tg;
        private String vn;

        public List<e> ga() {
            return this.tg;
        }

        public JSONObject tg() {
            return this.d;
        }

        public String toString() {
            return "UGNode{id='" + this.e + "', name='" + this.bf + "'}";
        }

        public String d() {
            return this.bf;
        }

        public String bf() {
            return this.vn;
        }

        public String e() {
            return this.e;
        }

        public void e(e eVar) {
            if (this.tg == null) {
                this.tg = new ArrayList();
            }
            this.tg.add(eVar);
        }
    }

    public vn(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            this.e = jSONObject.optJSONObject("main_template");
            this.bf = jSONObject.optJSONObject("sub_templates");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("template_info");
            if (jSONObjectOptJSONObject != null) {
                this.d = jSONObjectOptJSONObject.optString("sdk_version");
            }
            this.tg = jSONObject2;
        }
    }

    public List<e> bf() {
        if (this.bf == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = this.bf.keys();
        while (itKeys.hasNext()) {
            e eVarE = e(this.bf.optJSONObject(itKeys.next()), null);
            if (eVarE != null) {
                arrayList.add(eVarE);
            }
        }
        return arrayList;
    }

    public e e() {
        return e(this.e, null);
    }

    private e e(JSONObject jSONObject, e eVar) {
        e eVarE;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("name");
        String strOptString2 = jSONObject.optString("id");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.equals(next, "children")) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        e eVar2 = new e();
        eVar2.e = strOptString2;
        eVar2.bf = strOptString;
        eVar2.d = jSONObject2;
        eVar2.ga = eVar;
        eVar2.vn = this.d;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                String strOptString3 = jSONObjectOptJSONObject.optString("name");
                String strE = com.bytedance.adsdk.ugeno.d.e.e(jSONObjectOptJSONObject.optString("id"), this.tg);
                if (TextUtils.equals(strOptString3, "Template")) {
                    JSONObject jSONObject3 = this.bf;
                    eVarE = jSONObject3 != null ? e(jSONObject3.optJSONObject(strE), eVar2) : null;
                } else {
                    eVarE = e(jSONObjectOptJSONObject, eVar2);
                }
                if (eVarE != null) {
                    eVar2.e(eVarE);
                }
            }
        }
        return eVar2;
    }

    public static boolean e(e eVar) {
        return (eVar == null || eVar.d == null) ? false : true;
    }
}
