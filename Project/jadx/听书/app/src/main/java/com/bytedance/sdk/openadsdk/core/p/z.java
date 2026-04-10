package com.bytedance.sdk.openadsdk.core.p;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.gc;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.ja;
import com.bytedance.sdk.openadsdk.core.iq.ls;
import com.bytedance.sdk.openadsdk.core.iq.m;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tb;
import com.bytedance.sdk.openadsdk.core.kb.dl.uy;
import com.bytedance.sdk.openadsdk.core.kb.g.a;
import com.bytedance.sdk.openadsdk.core.kb.gz;
import com.bytedance.sdk.openadsdk.core.un.eo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements dl {
    private boolean dl;
    private final g g;
    private com.bytedance.sdk.openadsdk.core.kb.g.z m;
    private final na z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, com.bytedance.sdk.openadsdk.core.kb.g.a> f1291a = new HashMap();
    private boolean gc = true;
    private boolean e = false;

    private z(g gVar, na naVar, boolean z) {
        this.g = gVar;
        this.z = naVar;
        this.dl = z;
    }

    public static z z(g gVar, na naVar, boolean z) {
        return new z(gVar, naVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.dl
    public void z() {
        for (com.bytedance.sdk.openadsdk.core.kb.g.a aVar : this.f1291a.values()) {
            if (aVar != null) {
                aVar.z();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.dl
    public void g() {
        Iterator<com.bytedance.sdk.openadsdk.core.kb.g.a> it = this.f1291a.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.dl
    public void dl() {
        g();
        for (com.bytedance.sdk.openadsdk.core.kb.g.a aVar : this.f1291a.values()) {
            if (aVar != null) {
                aVar.g();
            }
        }
        this.f1291a.clear();
    }

    public static na z(na naVar, JSONObject jSONObject, String str) {
        String strOptString;
        boolean z;
        na naVarZ;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        if (jSONObject != null) {
            strOptString = jSONObject.optString("download_url");
            z = true;
        } else {
            strOptString = "";
            z = false;
        }
        if (TextUtils.isEmpty(strOptString)) {
            z = false;
        }
        boolean z2 = (naVar.c() == null || naVar.c().g() == null || !naVar.c().g().equals(strOptString)) ? z : false;
        if (jSONObject != null && (jSONObjectOptJSONObject2 = jSONObject.optJSONObject("download_config_json")) != null && !jSONObjectOptJSONObject2.optBoolean("has_valid_download_url", true)) {
            z2 = true;
        }
        if (z2) {
            naVarZ = new na();
            naVarZ.a(naVar.gc());
            naVarZ.h(naVar.zb());
            naVarZ.l(naVar.dh());
            naVarZ.h(jSONObject.optInt("lp_down_rule"));
            naVarZ.x(4);
            naVarZ.q(jSONObject.optString("id"));
            naVarZ.v(jSONObject.optString("source"));
            gc gcVar = new gc();
            gcVar.a(jSONObject.optString("pkg_name"));
            gcVar.dl(jSONObject.optString("name"));
            gcVar.g(strOptString);
            naVarZ.z(gcVar);
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("download_config_json");
            if (jSONObjectOptJSONObject3 != null) {
                naVarZ.z(new tb(jSONObjectOptJSONObject3));
                if (!jSONObjectOptJSONObject3.optBoolean("has_valid_download_url", true)) {
                    naVarZ.uy(true);
                }
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("app_manage_json");
            if (jSONObjectOptJSONObject4 != null) {
                m mVarBw = naVarZ.bw();
                if (mVarBw == null) {
                    mVarBw = new m();
                }
                mVarBw.z(jSONObjectOptJSONObject4.optInt("score"));
                mVarBw.z(jSONObjectOptJSONObject4.optJSONArray("creative_tags"));
                naVarZ.z(mVarBw);
                naVarZ.i(jSONObjectOptJSONObject4.toString());
                gk gkVarKp = naVarZ.kp();
                if (gkVarKp == null) {
                    gkVarKp = new gk();
                }
                gkVarKp.z(jSONObjectOptJSONObject4.optString("icon_url"));
                naVarZ.z(gkVarKp);
                naVarZ.js(jSONObjectOptJSONObject4.optString("desc"));
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("app_manage_type_json");
            if (jSONObjectOptJSONObject5 != null) {
                naVarZ.l(jSONObjectOptJSONObject5.optInt("app_manage_type"));
            }
            int iOptInt = jSONObject.optInt("live_interaction_type");
            String strOptString2 = jSONObject.optString("live_room_id");
            if (iOptInt > 0 && !TextUtils.isEmpty(strOptString2)) {
                naVarZ.jq(iOptInt);
                naVarZ.un(strOptString2);
            }
            naVarZ.gb(jSONObject.optInt("ad_type"));
            ja jaVarZ = ja.z(jSONObject.optJSONObject("wc_miniapp_info"));
            if (jaVarZ != null) {
                naVarZ.z(jaVarZ);
            }
            String strOptString3 = jSONObject.optString("quick_app_url");
            if (!TextUtils.isEmpty(strOptString3)) {
                gc gcVarC = naVarZ.c() != null ? naVarZ.c() : new gc();
                gcVarC.z(strOptString3);
                naVarZ.z(gcVarC);
            }
        } else {
            naVarZ = com.bytedance.sdk.openadsdk.core.z.z(naVar.kv());
        }
        if (!TextUtils.isEmpty(str)) {
            naVarZ.iq(str);
        }
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("deep_link")) != null) {
            ls lsVar = new ls();
            if (naVar.vy() != null) {
                lsVar.z(naVar.vy());
            }
            lsVar.z(new ls(jSONObjectOptJSONObject));
            naVarZ.z(lsVar);
        }
        return naVarZ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.dl
    public void z(Context context, JSONObject jSONObject, String str, int i, boolean z, boolean z2) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        na naVarZ = z(this.z, jSONObjectOptJSONObject, z(jSONObjectOptJSONObject, str));
        z(context, naVarZ, jSONObjectOptJSONObject, i, z ? uy.z(naVarZ) : 0, z2);
    }

    private void z(Context context, na naVar, JSONObject jSONObject, int i, int i2, boolean z) {
        if (context == null || naVar == null || naVar.c() == null || jSONObject == null || this.g == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kb.g.a aVar = this.f1291a.get(naVar.c().g());
        if (aVar != null) {
            aVar.z(i2);
            return;
        }
        String strZ = eo.z(i);
        if (TextUtils.isEmpty(strZ)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kb.g.a aVarZ = z(context, naVar, jSONObject, strZ);
        aVarZ.z(i2);
        if (aVarZ instanceof com.bytedance.sdk.openadsdk.core.kb.dl.a) {
            ((com.bytedance.sdk.openadsdk.core.kb.dl.a) aVarZ).m(z);
        }
        this.f1291a.put(naVar.c().g(), aVarZ);
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.dl
    public void z(Context context, JSONObject jSONObject, String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        z(context, z(this.z, jSONObjectOptJSONObject, z(jSONObjectOptJSONObject, str2)), str);
    }

    private String z(JSONObject jSONObject, String str) {
        String strOptString = jSONObject != null ? jSONObject.optString("ext") : null;
        return TextUtils.isEmpty(strOptString) ? str : strOptString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z(Context context, na naVar, String str) {
        if (context == 0 || naVar == null) {
            return;
        }
        if (naVar.c() == null) {
            com.bytedance.sdk.openadsdk.core.kb.g.dl dlVarG = gz.g(context, naVar, str, false);
            if (dlVarG instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gc) {
                ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) dlVarG).m(this.dl);
            }
            dlVarG.z(naVar, false);
        } else {
            final String strMj = naVar.mj();
            com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = (com.bytedance.sdk.openadsdk.core.kb.g.a) this.f1291a.get(naVar.c().g());
            if (dlVar != null) {
                dlVar.dl(this.e);
                if (dlVar instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gc) {
                    ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) dlVar).gz().z(this.gc);
                } else if (dlVar instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gz) {
                    ((com.bytedance.sdk.openadsdk.core.kb.dl.gz) dlVar).m().z(this.gc);
                }
                dlVar.z(naVar, false);
                dlVar.z(new com.bytedance.sdk.openadsdk.core.kb.g.z() { // from class: com.bytedance.sdk.openadsdk.core.p.z.1
                    @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                    public void z() {
                        C0193z.z(strMj, 1, 0);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                    public void z(long j, long j2, String str2, String str3) {
                        if (j > 0) {
                            C0193z.z(strMj, 3, (int) ((j2 * 100) / j));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                    public void g(long j, long j2, String str2, String str3) {
                        if (j > 0) {
                            C0193z.z(strMj, 2, (int) ((j2 * 100) / j));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                    public void dl(long j, long j2, String str2, String str3) {
                        if (j > 0) {
                            C0193z.z(strMj, 4, (int) ((j2 * 100) / j));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                    public void z(long j, String str2, String str3) {
                        C0193z.z(strMj, 5, 100);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                    public void z(String str2, String str3) {
                        C0193z.z(strMj, 6, 100);
                    }
                });
            }
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.gz.g) {
            ((com.bytedance.sdk.openadsdk.core.gz.g) context).z(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.dl
    public void z(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        z(z(this.z, jSONObjectOptJSONObject, (String) null), jSONObjectOptJSONObject);
    }

    private void z(na naVar, JSONObject jSONObject) {
        if (this.g == null || naVar == null || naVar.c() == null) {
            return;
        }
        String strG = naVar.c().g();
        if (this.f1291a.containsKey(strG)) {
            com.bytedance.sdk.openadsdk.core.kb.g.a aVarRemove = this.f1291a.remove(strG);
            if (aVarRemove != null) {
                try {
                    aVarRemove.g();
                } catch (JSONException e) {
                    wp.z(e);
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("message", "success");
            jSONObject2.put(NotificationCompat.CATEGORY_STATUS, "unsubscribed");
            jSONObject2.put("appad", jSONObject);
            this.g.z("app_ad_event", jSONObject2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.dl
    public void g(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || this.g == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kb.g.a aVar = this.f1291a.get(z(this.z, jSONObjectOptJSONObject, (String) null).c().g());
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.dl
    public void z(boolean z) {
        this.gc = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.dl
    public void z(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.kb.g.a aVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f1291a.get(str)) == null) {
            return;
        }
        aVar.g(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.dl
    public void g(boolean z) {
        this.e = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bytedance.sdk.openadsdk.core.kb.g.a z(Context context, na naVar, final JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.kb.g.a aVarG = gz.g(context, naVar, str, false);
        if (aVarG instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gc) {
            ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) aVarG).m(this.dl);
        }
        aVarG.z(new com.bytedance.sdk.openadsdk.core.kb.g.z() { // from class: com.bytedance.sdk.openadsdk.core.p.z.2
            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z() {
                z(NotificationCompat.CATEGORY_STATUS, "idle");
                if (z.this.m == null) {
                    return;
                }
                z.this.m.z();
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z(long j, long j2, String str2, String str3) {
                z(NotificationCompat.CATEGORY_STATUS, "download_active", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (z.this.m == null) {
                    return;
                }
                z.this.m.z(j, j2, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void g(long j, long j2, String str2, String str3) {
                z(NotificationCompat.CATEGORY_STATUS, "download_paused", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (z.this.m == null) {
                    return;
                }
                z.this.m.g(j, j2, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void dl(long j, long j2, String str2, String str3) {
                z(NotificationCompat.CATEGORY_STATUS, "download_failed", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (z.this.m == null) {
                    return;
                }
                z.this.m.dl(j, j2, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z(long j, String str2, String str3) {
                z(NotificationCompat.CATEGORY_STATUS, "download_finished", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j));
                if (z.this.m == null) {
                    return;
                }
                z.this.m.z(j, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z(String str2, String str3) {
                z(NotificationCompat.CATEGORY_STATUS, "installed");
                if (z.this.m == null) {
                    return;
                }
                z.this.m.z(str2, str3);
            }

            private void z(String... strArr) {
                if (strArr == null || strArr.length % 2 != 0) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", "success");
                    jSONObject2.put("appad", jSONObject);
                    for (int i = 0; i < strArr.length; i += 2) {
                        jSONObject2.put(strArr[i], strArr[i + 1]);
                    }
                    z.this.g.z("app_ad_event", jSONObject2);
                } catch (JSONException unused) {
                }
            }
        });
        aVarG.z(new a.z() { // from class: com.bytedance.sdk.openadsdk.core.p.z.3
        });
        return aVarG;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.p.z$z, reason: collision with other inner class name */
    public static class C0193z {
        private static ConcurrentHashMap<String, JSONObject> z = new ConcurrentHashMap<>();

        public static synchronized JSONObject z(String str) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            ConcurrentHashMap<String, JSONObject> concurrentHashMap = z;
            if (concurrentHashMap == null) {
                return new JSONObject();
            }
            JSONObject jSONObject = concurrentHashMap.get(str);
            if (jSONObject != null) {
                return jSONObject;
            }
            return new JSONObject();
        }

        public static synchronized void z(String str, int i, int i2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z == null) {
                z = new ConcurrentHashMap<>();
            }
            JSONObject jSONObject = z.get(str);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                z.put(str, jSONObject);
            }
            try {
                jSONObject.put("downloadStatus", i);
                jSONObject.put("downloadProcessRate", i2);
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "get ad_down_load_id success");
            } catch (Exception e) {
                wp.z(e);
            }
        }
    }
}
