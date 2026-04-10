package com.bytedance.sdk.openadsdk.core.i;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.ugeno.uy;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private final na g;
    private volatile boolean z = false;
    private String dl = "landingpage";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1142a = 0;
    private long gc = 0;
    private long m = 0;
    private long e = 0;
    private long gz = 0;
    private long fo = 0;
    private AtomicInteger uy = new AtomicInteger(0);
    private boolean kb = false;
    private AtomicBoolean wp = new AtomicBoolean(false);

    public m(na naVar) {
        this.g = naVar;
    }

    public m z(boolean z) {
        this.kb = z;
        return this;
    }

    public void z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            na naVar = this.g;
            if (naVar != null && uy.gz(naVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.g.fv()));
            }
        } catch (JSONException e) {
            wp.z(e);
        }
        z("open_url_h5", jSONObject);
    }

    public void g() {
        if (this.z) {
            return;
        }
        this.e = System.currentTimeMillis();
        this.fo = System.currentTimeMillis();
        this.z = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            na naVar = this.g;
            if (naVar != null && uy.gz(naVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.g.fv()));
            }
        } catch (Exception unused) {
        }
        z("load_start", jSONObject);
    }

    public void z(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            na naVar = this.g;
            if (naVar != null && uy.gz(naVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.g.fv()));
            }
            jSONObject.putOpt("code", Integer.valueOf(i));
            jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, str);
        } catch (JSONException e) {
            wp.z(e);
        }
        z("load_fail", jSONObject);
    }

    public void z(long j) {
        if (this.wp.get()) {
            return;
        }
        this.wp.set(true);
        this.gz = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        long j2 = this.gz - this.e;
        try {
            jSONObject.putOpt("render_type", "ugen");
            jSONObject.put("net_work_duration", j);
            na naVar = this.g;
            if (naVar != null && uy.gz(naVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.g.fv()));
            }
        } catch (JSONException e) {
            wp.z(e);
        }
        z("load_finish", jSONObject, Math.min(j2, TTAdConstant.AD_MAX_EVENT_TIME));
    }

    public void dl() {
        this.m = System.currentTimeMillis();
        this.f1142a = System.currentTimeMillis();
    }

    public void z(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.gc = jCurrentTimeMillis;
        long jMax = jCurrentTimeMillis - Math.max(this.f1142a, this.m);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_status", 2);
            jSONObject.put("max_scroll_percent", this.uy.get());
            jSONObject.put("is_slide", i);
            jSONObject.putOpt("render_type", "ugen");
            na naVar = this.g;
            if (naVar != null && uy.gz(naVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.g.fv()));
            }
        } catch (JSONException e) {
            wp.z(e);
        }
        z("stay_page", jSONObject, Math.min(jMax, TTAdConstant.AD_MAX_EVENT_TIME));
    }

    public void a() {
        if (this.wp.get() || !this.z) {
            return;
        }
        a.z(this.g, this.dl, "load", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.m.1
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "ugen");
                if (m.this.g != null && uy.gz(m.this.g)) {
                    jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(m.this.g.fv()));
                }
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject2, m.this.g);
                jSONObject.putOpt("ad_extra_data", jSONObject2);
                jSONObject.put("duration", Math.min(System.currentTimeMillis() - m.this.fo, TTAdConstant.AD_MAX_EVENT_TIME));
            }
        });
    }

    private void z(String str, JSONObject jSONObject) {
        z(str, jSONObject, -1L);
    }

    private void z(String str, JSONObject jSONObject, long j) {
        if (!this.kb || this.g == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("ad_extra_data", jSONObject.toString());
                    if (j > 0) {
                        jSONObject3.put("duration", j);
                    }
                    jSONObject2 = jSONObject3;
                } catch (JSONException e) {
                    e = e;
                    jSONObject2 = jSONObject3;
                    wp.z(e);
                }
            } catch (JSONException e2) {
                e = e2;
            }
        }
        a.dl(this.g, this.dl, str, jSONObject2);
    }
}
