package com.bytedance.msdk.core.gc.g;

import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f394a;
    private String dl;
    private int e;
    private int g;
    private int gc;
    private int m;
    private int z;

    public String z() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediationConstant.KEY_REASON, this.z);
            jSONObject.put("fill_error_code", this.g);
            jSONObject.put("fill_error_msg", this.dl);
            jSONObject.put("mediation_rit", this.f394a);
            jSONObject.put("load_sort", this.gc);
            jSONObject.put("show_sort", this.m);
            jSONObject.put("has_shown", this.e);
            return jSONObject.toString();
        } catch (JSONException e) {
            wp.z(e);
            return "{\"name\": \"json err\"}";
        }
    }

    public void z(int i) {
        this.e = i;
    }

    public void g(int i) {
        this.z = i;
    }

    public void dl(int i) {
        this.g = i;
    }

    public void z(String str) {
        this.dl = str;
    }

    public void g(String str) {
        this.f394a = str;
    }

    public void a(int i) {
        this.gc = i;
    }

    public void gc(int i) {
        this.m = i;
    }
}
