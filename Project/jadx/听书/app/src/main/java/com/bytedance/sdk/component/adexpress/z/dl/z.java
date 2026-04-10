package com.bytedance.sdk.component.adexpress.z.dl;

import android.text.TextUtils;
import android.util.Pair;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<C0124z> f617a;
    private String dl;
    private String g;
    private g gc;
    private Map<String, z> m = new ConcurrentHashMap();
    private String z;

    public Map<String, z> z() {
        return this.m;
    }

    public String g() {
        return this.z;
    }

    public void z(String str) {
        this.z = str;
    }

    public String dl() {
        return this.g;
    }

    public void g(String str) {
        this.g = str;
    }

    public String a() {
        return this.dl;
    }

    public void dl(String str) {
        this.dl = str;
    }

    public void z(g gVar) {
        this.gc = gVar;
    }

    public g gc() {
        return this.gc;
    }

    public List<C0124z> getResources() {
        if (this.f617a == null) {
            this.f617a = new ArrayList();
        }
        return this.f617a;
    }

    public void z(List<C0124z> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f617a = list;
    }

    public boolean m() {
        return (TextUtils.isEmpty(a()) || TextUtils.isEmpty(dl()) || TextUtils.isEmpty(g())) ? false : true;
    }

    public JSONObject e() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", g());
            jSONObject.putOpt("version", dl());
            jSONObject.putOpt("main", a());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (C0124z c0124z : getResources()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0124z.z());
                    jSONObject2.putOpt(TKDownloadReason.KSAD_TK_MD5, c0124z.g());
                    jSONObject2.putOpt("level", Integer.valueOf(c0124z.dl()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.m.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z = false;
                for (String str : this.m.keySet()) {
                    z zVar = this.m.get(str);
                    if (zVar != null) {
                        jSONObject3.put(str, zVar.e());
                        z = true;
                    }
                }
                if (z) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            g gVarGc = gc();
            if (gVarGc != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", gVarGc.z);
                jSONObject4.put(TKDownloadReason.KSAD_TK_MD5, gVarGc.g);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> listG = gVarGc.g();
                if (listG != null) {
                    for (Pair<String, String> pair : listG) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String gz() {
        JSONObject jSONObjectE;
        if (!m() || (jSONObjectE = e()) == null) {
            return null;
        }
        return jSONObjectE.toString();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.z.dl.z$z, reason: collision with other inner class name */
    public static class C0124z {
        private int dl;
        private String g;
        private String z;

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof C0124z) {
                String str2 = this.z;
                if (str2 != null) {
                    C0124z c0124z = (C0124z) obj;
                    if (str2.equals(c0124z.z()) && (str = this.g) != null && str.equals(c0124z.g())) {
                        return true;
                    }
                }
                return false;
            }
            return super.equals(obj);
        }

        public String z() {
            return this.z;
        }

        public void z(String str) {
            this.z = str;
        }

        public String g() {
            return this.g;
        }

        public void g(String str) {
            this.g = str;
        }

        public int dl() {
            return this.dl;
        }

        public void z(int i) {
            this.dl = i;
        }
    }

    public static class g {
        private List<Pair<String, String>> dl;
        private String g;
        private String z;

        public String z() {
            return this.z;
        }

        public void z(String str) {
            this.z = str;
        }

        public void g(String str) {
            this.g = str;
        }

        public void z(List<Pair<String, String>> list) {
            this.dl = list;
        }

        public List<Pair<String, String>> g() {
            return this.dl;
        }
    }

    public static z a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return z(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static z z(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        z zVar = new z();
        zVar.z(jSONObject.optString("name"));
        zVar.g(jSONObject.optString("version"));
        zVar.dl(jSONObject.optString("main"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                C0124z c0124z = new C0124z();
                c0124z.z(jSONObjectOptJSONObject2.optString("url"));
                c0124z.g(jSONObjectOptJSONObject2.optString(TKDownloadReason.KSAD_TK_MD5));
                c0124z.z(jSONObjectOptJSONObject2.optInt("level"));
                arrayList.add(c0124z);
            }
        }
        zVar.z(arrayList);
        try {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("engines");
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    z zVarZ = z(jSONObjectOptJSONObject3.optJSONObject(next));
                    if (zVarZ != null) {
                        zVar.z().put(next, zVarZ);
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (jSONObject.has("resources_archive") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            g gVar = new g();
            gVar.z(jSONObjectOptJSONObject.optString("url"));
            gVar.g(jSONObjectOptJSONObject.optString(TKDownloadReason.KSAD_TK_MD5));
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("map");
            if (jSONObjectOptJSONObject4 != null) {
                Iterator<String> itKeys2 = jSONObjectOptJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    arrayList2.add(new Pair<>(next2, jSONObjectOptJSONObject4.optString(next2)));
                }
                gVar.z(arrayList2);
            }
            zVar.z(gVar);
        }
        if (zVar.m()) {
            return zVar;
        }
        return null;
    }
}
