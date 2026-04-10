package com.bytedance.sdk.openadsdk.core.iq;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    private static final List<dl> g = new CopyOnWriteArrayList();
    public static boolean z = false;

    public interface z {
        void g(dl dlVar);

        void z(dl dlVar);
    }

    public static void z(JSONObject jSONObject, z zVar) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.un.xl.z().z(zVar);
        z = jSONObject.optBoolean("h5_cache_resources_enable", false);
        g(jSONObject, zVar);
    }

    public static List<dl> z() {
        return g;
    }

    private static void g(JSONObject jSONObject, final z zVar) {
        if (z) {
            final ArrayList arrayList = new ArrayList();
            String str = "h5_cache_resources";
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("h5_cache_resources");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(new dl(jSONObjectOptJSONObject));
                    }
                }
            }
            com.bytedance.sdk.openadsdk.hh.e.z(new com.bytedance.sdk.component.uy.fo(str) { // from class: com.bytedance.sdk.openadsdk.core.iq.l.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.un.xl.z().z(arrayList, zVar);
                }
            });
        }
    }

    public static void z(com.bytedance.sdk.component.a.g.dl dlVar) {
        try {
            z = dlVar.get("h5_cache_resources_enable", false);
            JSONArray jSONArray = new JSONArray(dlVar.get("h5_cache_resources", ""));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    g.add(new dl(jSONObjectOptJSONObject));
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void g(com.bytedance.sdk.component.a.g.dl dlVar) {
        dlVar.put("h5_cache_resources_enable", z);
    }

    public static synchronized void z(com.bytedance.sdk.component.a.g.dl dlVar, dl dlVar2) {
        List<dl> list = g;
        list.add(dlVar2);
        JSONArray jSONArray = new JSONArray();
        Iterator<dl> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().gc());
        }
        dlVar.put("h5_cache_resources", jSONArray.toString());
    }

    public static synchronized void g(com.bytedance.sdk.component.a.g.dl dlVar, dl dlVar2) {
        List<dl> list = g;
        list.remove(dlVar2);
        JSONArray jSONArray = new JSONArray();
        Iterator<dl> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().gc());
        }
        dlVar.put("h5_cache_resources", jSONArray.toString());
    }

    public static class dl {
        private final List<a> dl = new ArrayList();
        private final String g;
        private final String z;

        public dl(JSONObject jSONObject) {
            this.z = jSONObject.optString("channel");
            this.g = jSONObject.optString("prefix");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resource");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        this.dl.add(new a(jSONObjectOptJSONObject));
                    }
                }
            }
        }

        public String z() {
            return this.z;
        }

        public String g() {
            return this.g;
        }

        public a dl() {
            if (this.dl.isEmpty()) {
                return null;
            }
            return this.dl.get(0);
        }

        public String a() {
            String str = this.z;
            return dl() != null ? str + "$" + com.bytedance.sdk.component.utils.gc.g(dl().g()) : str;
        }

        public List<a> getResources() {
            return this.dl;
        }

        public JSONObject gc() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channel", this.z);
                jSONObject.put("prefix", this.g);
                JSONArray jSONArray = new JSONArray();
                Iterator<a> it = this.dl.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().a());
                }
                jSONObject.put("resource", jSONArray);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
            return jSONObject;
        }
    }

    public static class a {
        private final List<g> dl = new ArrayList();
        private final String g;
        private final String z;

        public a(JSONObject jSONObject) {
            this.z = jSONObject.optString("resource_url");
            this.g = jSONObject.optString("content_hash");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("channel_resource_list");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        this.dl.add(new g(jSONObjectOptJSONObject));
                    }
                }
            }
        }

        public String z() {
            return this.z;
        }

        public String g() {
            return this.g;
        }

        public List<g> dl() {
            return this.dl;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resource_url", this.z);
                jSONObject.put("content_hash", this.g);
                JSONArray jSONArray = new JSONArray();
                Iterator<g> it = this.dl.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().dl());
                }
                jSONObject.put("channel_resource_list", jSONArray);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
            return jSONObject;
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f1176a;
        private final String dl;
        private final String g;
        private final String gc;
        private final String m;
        private final long z;

        public g(JSONObject jSONObject) {
            this.z = jSONObject.optLong("size", 0L);
            this.g = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
            this.dl = jSONObject.optString("content_hash");
            this.f1176a = jSONObject.optString("url");
            this.gc = jSONObject.optString("mime_type");
            this.m = jSONObject.optString("file_name");
        }

        public String z() {
            return this.gc;
        }

        public String g() {
            return this.m;
        }

        public JSONObject dl() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("size", this.z);
                jSONObject.put(TKDownloadReason.KSAD_TK_MD5, this.g);
                jSONObject.put("content_hash", this.dl);
                jSONObject.put("mime_type", this.gc);
                jSONObject.put("file_name", this.m);
                jSONObject.put("url", this.f1176a);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
            return jSONObject;
        }
    }
}
