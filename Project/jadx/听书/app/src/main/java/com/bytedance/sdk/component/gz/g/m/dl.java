package com.bytedance.sdk.component.gz.g.m;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements g {
    private com.bytedance.sdk.component.gz.z.gc dl;
    private final gc g;
    private final Context z;

    public dl(gc gcVar, com.bytedance.sdk.component.gz.z.gc gcVar2) {
        this.z = gcVar2.getContext();
        this.g = gcVar;
        this.dl = gcVar2;
    }

    public Context getContext() {
        Context context = this.z;
        return context == null ? this.dl.getContext() : context;
    }

    @Override // com.bytedance.sdk.component.gz.g.m.g
    public void z(String str, List<String> list, boolean z2, Map<String, String> map, JSONObject jSONObject) {
        com.bytedance.sdk.component.gz.z.a aVarA = this.dl.a();
        if (aVarA == null || this.dl.getContext() == null || aVarA.gz() == null || !aVarA.a() || list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            aVarA.gz().execute(new z(new a(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), it.next(), z2, 5, jSONObject, 1), str, map));
        }
    }

    @Override // com.bytedance.sdk.component.gz.g.m.g
    public void z(final String str) {
        com.bytedance.sdk.component.gz.z.a aVarA = this.dl.a();
        if (aVarA == null || this.dl.getContext() == null || !aVarA.a()) {
            return;
        }
        com.bytedance.sdk.component.gz.g.gc.g gVar = new com.bytedance.sdk.component.gz.g.gc.g("trackFailedUrls") { // from class: com.bytedance.sdk.component.gz.g.m.dl.1
            @Override // java.lang.Runnable
            public void run() {
                dl.this.z(dl.this.g.z(), str);
            }
        };
        gVar.z(1);
        if (aVarA.gz() != null) {
            aVarA.gz().execute(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(List<a> list, String str) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.gz.z.a aVarA = this.dl.a();
        for (a aVar : list) {
            if (aVarA != null && aVarA.gz() != null) {
                aVarA.gz().execute(new z(aVar, str, null));
            }
        }
    }

    private class z extends com.bytedance.sdk.component.gz.g.gc.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, String> f745a;
        private final String dl;
        private final a g;

        private z(a aVar, String str, Map<String, String> map) {
            super("AdsStats");
            this.g = aVar;
            this.dl = str;
            this.f745a = map;
        }

        private String dl(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            return ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.dl)) ? str.replace("{UID}", this.dl).replace("__UID__", this.dl) : str;
        }

        boolean z(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("http://") || str.startsWith("https://");
        }

        String g(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(dl.g().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception e) {
                wp.z(e);
                return str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.gz.z.z.gc gcVarZ;
            com.bytedance.sdk.component.gz.z.a aVarA = dl.this.dl.a();
            if (aVarA == null || dl.this.dl.getContext() == null || !aVarA.a()) {
                return;
            }
            if (!z(this.g.dl())) {
                a aVar = this.g;
                z(null, aVarA, aVar, aVar.dl(), "not http url");
                return;
            }
            if (this.g.gc() == 0) {
                dl.this.g.delete(this.g);
                a aVar2 = this.g;
                z(null, aVarA, aVar2, aVar2.dl(), "retry max");
                return;
            }
            try {
                if (this.g.gc() == 5) {
                    dl.this.g.insert(this.g);
                }
                if (!aVarA.z(dl.this.getContext())) {
                    a aVar3 = this.g;
                    z(null, aVarA, aVar3, aVar3.dl(), "no net");
                    return;
                }
                System.currentTimeMillis();
                String strDl = this.g.dl();
                if (aVarA.uy() == 0) {
                    strDl = dl(this.g.dl());
                    if (this.g.a()) {
                        strDl = g(strDl);
                    }
                }
                String str = strDl;
                com.bytedance.sdk.component.gz.z.z.g gVarE = aVarA.e();
                if (gVarE == null) {
                    z(null, this.g, str, "no executor");
                    return;
                }
                gVarE.z("User-Agent", aVarA.gc());
                gVarE.z("csj_client_source_from", "1");
                if (this.f745a != null) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.f745a.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    gVarE.z("csj_extra_info", jSONObject.toString());
                }
                gVarE.z(str);
                try {
                    gcVarZ = gVarE.z();
                } catch (Throwable unused) {
                    gcVarZ = null;
                }
                if (gcVarZ != null && gcVarZ.z()) {
                    dl.this.g.delete(this.g);
                    com.bytedance.sdk.component.gz.z.gc unused2 = dl.this.dl;
                    System.currentTimeMillis();
                } else {
                    if (gcVarZ != null && gcVarZ.dl() == 8848) {
                        gcVarZ.a();
                        dl.this.g.delete(this.g);
                    }
                    com.bytedance.sdk.component.gz.z.gc unused3 = dl.this.dl;
                    this.g.z(r0.gc() - 1);
                    if (this.g.gc() == 0) {
                        dl.this.g.delete(this.g);
                        com.bytedance.sdk.component.gz.z.gc unused4 = dl.this.dl;
                    } else {
                        dl.this.g.update(this.g);
                    }
                    if (gcVarZ != null) {
                        gcVarZ.a();
                        System.currentTimeMillis();
                    } else {
                        System.currentTimeMillis();
                    }
                }
                z(gcVarZ, aVarA, this.g, str, null);
            } catch (Throwable unused5) {
            }
        }

        private void z(com.bytedance.sdk.component.gz.z.z.gc gcVar, com.bytedance.sdk.component.gz.z.a aVar, a aVar2, String str, String str2) {
            try {
                aVar.z(this.g.z(), z(gcVar, aVar2, str, str2));
            } catch (Exception e) {
                wp.z(e);
            }
        }

        private JSONObject z(com.bytedance.sdk.component.gz.z.z.gc gcVar, a aVar, String str, String str2) {
            JSONObject jSONObject = new JSONObject();
            if (aVar == null) {
                return jSONObject;
            }
            try {
                jSONObject.put("retry_count", 5 - aVar.gc());
                JSONObject jSONObjectZ = aVar.z();
                if (jSONObjectZ != null) {
                    jSONObject.put("track_type", jSONObjectZ.optString("track_type", ""));
                }
                jSONObject.put("url", str);
                jSONObject.put("current", System.currentTimeMillis());
                jSONObject.put("error_msg", str2);
                if (gcVar != null) {
                    jSONObject.put("http_code", gcVar.dl());
                    String strG = gcVar.g();
                    if (!TextUtils.isEmpty(strG)) {
                        if (strG.length() > 5000) {
                            strG = strG.substring(0, 5000);
                        }
                        jSONObject.put("http_response", strG);
                    }
                    jSONObject.put("success", gcVar.z() ? 1 : 0);
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Random g() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }
}
