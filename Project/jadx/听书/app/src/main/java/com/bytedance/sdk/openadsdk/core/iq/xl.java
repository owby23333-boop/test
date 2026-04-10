package com.bytedance.sdk.openadsdk.core.iq;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1205a;
    private int dl;
    private long e;
    private int fo;
    private int g;
    private int gc;
    private long gz;
    private long m;
    private int uy = 0;
    na z;

    public xl(na naVar) {
        this.z = naVar;
    }

    public xl(na naVar, JSONObject jSONObject) {
        this.z = naVar;
        if (jSONObject != null) {
            this.g = jSONObject.optInt("req_type", 0);
            this.dl = jSONObject.optInt("load_type", 0);
            this.f1205a = jSONObject.optInt("bidding_result", 0);
            this.gc = jSONObject.optInt("reuse_count", 0);
            this.m = jSONObject.optLong("object_create_time", 0L);
            this.e = jSONObject.optLong("show_time", 0L);
            this.gz = jSONObject.optLong("final_ts", 0L);
            this.fo = jSONObject.optInt("final_status", 0);
        }
    }

    public void z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ca_send_ts", this.z.ti());
            jSONObject.put("ca_bid_rst", this.f1205a);
            jSONObject.put("ca_reuse_cnt", this.gc);
            jSONObject.put("ca_obj_ts", this.m);
            jSONObject.put("ca_fnl_st", this.fo);
            jSONObject.put("ca_rpt_show_cnt", this.uy);
        } catch (JSONException unused) {
        }
    }

    public JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("req_type", this.g);
            jSONObject.put("load_type", this.dl);
            jSONObject.put("bidding_result", this.f1205a);
            jSONObject.put("reuse_count", this.gc);
            jSONObject.put("object_create_time", this.m);
            jSONObject.put("show_time", this.e);
            jSONObject.put("final_ts", this.gz);
            jSONObject.put("final_status", this.fo);
            jSONObject.put("show_count", this.uy);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void z(int i) {
        this.g = i;
    }

    public void g(int i) {
        this.dl = i;
        if (i == 2) {
            this.gc++;
        }
    }

    public void dl(int i) {
        this.f1205a = i;
    }

    public void g() {
        this.m = System.currentTimeMillis();
    }

    public void dl() {
        this.e = System.currentTimeMillis();
        this.uy++;
        a(1);
    }

    public void a(int i) {
        this.fo = i;
        this.gz = System.currentTimeMillis();
    }
}
