package com.bytedance.sdk.component.adexpress.e.d;

import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.onetrack.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private String bf;
    private String d;
    private String e;
    private bf ga;
    private List<C0086e> tg;

    public static class bf {
        private String bf;
        private List<Pair<String, String>> d;
        private String e;

        public void bf(String str) {
            this.bf = str;
        }

        public String e() {
            return this.e;
        }

        public List<Pair<String, String>> bf() {
            return this.d;
        }

        public void e(String str) {
            this.e = str;
        }

        public void e(List<Pair<String, String>> list) {
            this.d = list;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.e.d.e$e, reason: collision with other inner class name */
    public static class C0086e {
        private String bf;
        private int d;
        private String e;

        public String bf() {
            return this.bf;
        }

        public int d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0086e)) {
                return super.equals(obj);
            }
            String str = this.e;
            return str != null && str.equals(((C0086e) obj).e());
        }

        public void bf(String str) {
            this.bf = str;
        }

        public void e(String str) {
            this.e = str;
        }

        public void e(int i) {
            this.d = i;
        }
    }

    public String bf() {
        return this.bf;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public boolean ga() {
        return (TextUtils.isEmpty(d()) || TextUtils.isEmpty(bf()) || TextUtils.isEmpty(e())) ? false : true;
    }

    public List<C0086e> getResources() {
        if (this.tg == null) {
            this.tg = new ArrayList();
        }
        return this.tg;
    }

    public bf tg() {
        return this.ga;
    }

    public String vn() {
        if (!ga()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", e());
            jSONObject.putOpt("version", bf());
            jSONObject.putOpt("main", d());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (C0086e c0086e : getResources()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0086e.e());
                    jSONObject2.putOpt("md5", c0086e.bf());
                    jSONObject2.putOpt(a.d, Integer.valueOf(c0086e.d()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            bf bfVarTg = tg();
            if (bfVarTg != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", bfVarTg.e);
                jSONObject3.put("md5", bfVarTg.bf);
                JSONObject jSONObject4 = new JSONObject();
                List<Pair<String, String>> listBf = bfVarTg.bf();
                if (listBf != null) {
                    for (Pair<String, String> pair : listBf) {
                        jSONObject4.put((String) pair.first, pair.second);
                    }
                }
                jSONObject3.put("map", jSONObject4);
                jSONObject.putOpt("resources_archive", jSONObject3);
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static e tg(String str) {
        if (str == null) {
            return null;
        }
        try {
            return e(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public void bf(String str) {
        this.bf = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public void e(bf bfVar) {
        this.ga = bfVar;
    }

    public void e(List<C0086e> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.tg = list;
    }

    public static e e(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        e eVar = new e();
        eVar.e(jSONObject.optString("name"));
        eVar.bf(jSONObject.optString("version"));
        eVar.d(jSONObject.optString("main"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                C0086e c0086e = new C0086e();
                c0086e.e(jSONObjectOptJSONObject2.optString("url"));
                c0086e.bf(jSONObjectOptJSONObject2.optString("md5"));
                c0086e.e(jSONObjectOptJSONObject2.optInt(a.d));
                arrayList.add(c0086e);
            }
        }
        eVar.e(arrayList);
        if (jSONObject.has("resources_archive") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            bf bfVar = new bf();
            bfVar.e(jSONObjectOptJSONObject.optString("url"));
            bfVar.bf(jSONObjectOptJSONObject.optString("md5"));
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("map");
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                ArrayList arrayList2 = new ArrayList();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    arrayList2.add(new Pair<>(next, jSONObjectOptJSONObject3.optString(next)));
                }
                bfVar.e(arrayList2);
            }
            eVar.e(bfVar);
        }
        if (eVar.ga()) {
            return eVar;
        }
        return null;
    }
}
