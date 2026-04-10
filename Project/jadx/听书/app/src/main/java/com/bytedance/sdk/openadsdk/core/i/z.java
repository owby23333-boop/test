package com.bytedance.sdk.openadsdk.core.i;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.component.gz.g.a.z.g {
    private static final AtomicLong dl = new AtomicLong(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f1143a;
    private String e;
    private String fo;
    protected final JSONObject g;
    private String gc;
    private String gz;
    private long i;
    private String kb;
    private String m;
    private com.bytedance.sdk.openadsdk.m.z.z uy;
    private AtomicBoolean v = new AtomicBoolean(false);
    private long wp;
    public final String z;

    z(C0178z c0178z) {
        this.f1143a = new JSONObject();
        this.z = TextUtils.isEmpty(c0178z.z) ? UUID.randomUUID().toString() : c0178z.z;
        this.uy = c0178z.kb;
        this.kb = c0178z.gc;
        this.gc = c0178z.g;
        this.m = c0178z.dl;
        if (TextUtils.isEmpty(c0178z.f1144a)) {
            this.e = "app_union";
        } else {
            this.e = c0178z.f1144a;
        }
        this.gz = c0178z.m;
        this.fo = c0178z.e;
        this.f1143a = c0178z.fo = c0178z.fo != null ? c0178z.fo : new JSONObject();
        this.i = System.currentTimeMillis();
        this.g = new JSONObject();
        try {
            e();
        } catch (Exception e) {
            wp.z(e);
        }
    }

    @Override // com.bytedance.sdk.component.gz.g.a.z.g
    public long z() {
        return this.i;
    }

    private void e() {
        this.wp = dl.incrementAndGet();
    }

    public String dl() {
        if (TextUtils.isEmpty(this.m)) {
            JSONObject jSONObject = this.g;
            return jSONObject != null ? jSONObject.optString("label") : "";
        }
        return this.m;
    }

    public String a() {
        return this.z;
    }

    @Override // com.bytedance.sdk.component.gz.g.a.z.g
    public JSONObject z(String str) {
        JSONObject jSONObject;
        JSONObject jSONObjectGc = gc();
        try {
            String strOptString = jSONObjectGc.optString("ad_extra_data");
            if (TextUtils.isEmpty(strOptString)) {
                jSONObject = new JSONObject();
                if (zw.g().tb() && !TextUtils.isEmpty(str)) {
                    jSONObject.put("will_save_labels", str);
                }
            } else {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                if (zw.g().tb() && TextUtils.isEmpty(jSONObject2.optString("will_save_labels")) && !TextUtils.isEmpty(str)) {
                    jSONObject2.put("will_save_labels", str);
                }
                jSONObject = jSONObject2;
            }
            String strE = com.bytedance.sdk.openadsdk.core.live.g.z().e();
            if (strE != null) {
                jSONObject.putOpt("live_plugin_version", strE.replaceAll("\\.", ""));
            }
            if (uy.ls().e()) {
                jSONObject.putOpt("first_of_two", 1);
            }
            jSONObjectGc.put("ad_extra_data", jSONObject.toString());
        } catch (Exception e) {
            wp.z(e);
        }
        return jSONObjectGc;
    }

    public JSONObject gc() {
        if (this.v.get()) {
            return this.g;
        }
        try {
            gz();
            com.bytedance.sdk.openadsdk.m.z.z zVar = this.uy;
            if (zVar != null) {
                zVar.z(this.g);
            }
            z(this.g);
            this.v.set(true);
        } catch (Throwable th) {
            wp.g("AdEvent", th);
        }
        return this.g;
    }

    private void z(JSONObject jSONObject) {
        try {
            if (this.wp != 0) {
                String strOptString = jSONObject.optString("ad_extra_data");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    if (jSONObject2.optInt("sdk_event_index") == 0) {
                        jSONObject2.put("sdk_event_index", this.wp);
                    }
                    if (jSONObject2.optInt("sdk_event_self_count") == 0) {
                        jSONObject2.put("sdk_event_self_count", com.bytedance.sdk.component.gz.g.dl.z.z(this.m));
                    }
                    jSONObject2.put("create_ts", System.currentTimeMillis());
                    jSONObject2.put("csj_type", uy.ls().na() ? 1 : 0);
                    jSONObject2.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.a.z.a());
                    jSONObject2.put("sdk_session_id", com.bytedance.sdk.openadsdk.core.q.g.z);
                    if (!TextUtils.isEmpty(eo.fo)) {
                        jSONObject2.put("wrong_stats_url", eo.fo);
                    }
                    if (!TextUtils.isEmpty(eo.uy)) {
                        jSONObject2.put("wrong_applog_url", eo.uy);
                    }
                    com.bytedance.sdk.openadsdk.core.eo.z.z().z(jSONObject2);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("sdk_event_index", this.wp);
                jSONObject3.put("sdk_event_self_count", com.bytedance.sdk.component.gz.g.dl.z.z(this.m));
                jSONObject3.put("sdk_session_id", com.bytedance.sdk.openadsdk.core.q.g.z);
                jSONObject3.put("csj_type", uy.ls().na() ? 1 : 0);
                jSONObject3.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.a.z.a());
                jSONObject3.put("create_ts", System.currentTimeMillis());
                if (!TextUtils.isEmpty(eo.fo)) {
                    jSONObject3.put("wrong_stats_url", eo.fo);
                }
                if (!TextUtils.isEmpty(eo.uy)) {
                    jSONObject3.put("wrong_applog_url", eo.uy);
                }
                com.bytedance.sdk.openadsdk.core.eo.z.z().z(jSONObject3);
                jSONObject.put("ad_extra_data", jSONObject3.toString());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.gz.g.a.z.g
    public long g() {
        return this.wp;
    }

    private void gz() throws JSONException {
        this.g.putOpt("tag", this.gc);
        this.g.putOpt("label", this.m);
        this.g.putOpt("category", this.e);
        if (!TextUtils.isEmpty(this.gz)) {
            try {
                this.g.putOpt("value", Long.valueOf(Long.parseLong(this.gz)));
            } catch (NumberFormatException unused) {
                this.g.putOpt("value", 0L);
            }
        }
        if (!TextUtils.isEmpty(this.fo)) {
            this.g.putOpt("ext_value", this.fo);
        }
        if (!TextUtils.isEmpty(this.kb)) {
            this.g.putOpt(MediationConstant.EXTRA_LOG_EXTRA, this.kb);
        }
        if (!TextUtils.equals(this.m, "pangle_live_sdk_monitor")) {
            this.g.putOpt("is_ad_event", "1");
        }
        this.g.putOpt("nt", Integer.valueOf(v.dl(zw.getContext())));
        this.g.putOpt("tob_ab_sdk_version", uy.ls().gp());
        Iterator<String> itKeys = this.f1143a.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.g.putOpt(next, this.f1143a.opt(next));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.i.z$z, reason: collision with other inner class name */
    public static final class C0178z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1144a;
        private String dl;
        private String e;
        private JSONObject fo;
        private String g;
        private String gc;
        private String gz;
        private com.bytedance.sdk.openadsdk.m.z.z kb;
        private String m;
        private com.bytedance.sdk.openadsdk.m.z.g uy;
        private String z;

        public C0178z z(String str) {
            this.g = str;
            return this;
        }

        public C0178z g(String str) {
            this.dl = str;
            return this;
        }

        public C0178z dl(String str) {
            this.f1144a = str;
            return this;
        }

        public C0178z a(String str) {
            this.gc = str;
            return this;
        }

        public C0178z gc(String str) {
            this.m = str;
            return this;
        }

        public C0178z m(String str) {
            this.e = str;
            return this;
        }

        public C0178z z(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.fo = jSONObject;
            return this;
        }

        public C0178z e(String str) {
            this.gz = str;
            return this;
        }

        public void z(com.bytedance.sdk.openadsdk.m.z.z zVar) {
            if (com.bytedance.sdk.openadsdk.core.q.gc.z(this.dl, 1.0d)) {
                if (this.gc != null) {
                    com.bytedance.sdk.openadsdk.core.v.dl.gc().z(this.dl, this.m, this.gz, (JSONObject) null, this.gc);
                }
                this.kb = zVar;
                z zVar2 = new z(this);
                try {
                    com.bytedance.sdk.openadsdk.m.z.g gVar = this.uy;
                    if (gVar != null) {
                        gVar.z(zVar2.g);
                    } else {
                        new com.bytedance.sdk.openadsdk.m.z.dl().z(zVar2.g);
                    }
                } catch (Throwable th) {
                    wp.g("AdEvent", th);
                }
                com.bytedance.sdk.openadsdk.core.q.g.z(zVar2, this.dl);
            }
        }
    }

    public boolean m() {
        JSONObject jSONObject = this.g;
        if (jSONObject == null) {
            return false;
        }
        String strOptString = jSONObject.optString("label");
        if (TextUtils.isEmpty(strOptString)) {
            if (TextUtils.isEmpty(this.m)) {
                return false;
            }
            return dl.z.contains(this.m);
        }
        return dl.z.contains(strOptString);
    }
}
