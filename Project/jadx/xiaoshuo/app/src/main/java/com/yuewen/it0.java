package com.yuewen;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class it0 extends p12 {
    public static final String X = "download_file_task_local_file_path";
    public static final String Y = "download_file_task_local_temp_file_path";
    public static final String Z = "download_file_task_cloud_file_info";
    public static final String a0 = "download_file_task_download_data";
    public static final String b0 = "download_file_task_downloaded_length";
    public static final String c0 = "download_file_task_kss_downloaded";
    public String P;
    public String Q;
    public u12 R;
    public l12 S;
    public long T;
    public boolean U;
    public long V;
    public long W;

    public it0(String str, String str2, String str3, String str4, String str5, u12 u12Var, int i) {
        super(str, str2, str3, 1, i);
        this.V = 0L;
        this.W = 0L;
        this.P = str4;
        this.Q = str5;
        this.R = u12Var;
        this.S = null;
        this.T = 0L;
        this.U = false;
        F(u12Var.e());
    }

    @Override // com.yuewen.p12, com.duokan.core.async.work.b
    public void E(JSONObject jSONObject) {
        super.E(jSONObject);
        try {
            jSONObject.put(X, this.P);
            jSONObject.put(Y, this.Q);
            jSONObject.put(Z, this.R.d());
            l12 l12Var = this.S;
            jSONObject.put(a0, l12Var == null ? null : l12Var.a());
            jSONObject.put(b0, this.T);
            jSONObject.put(c0, this.U);
        } catch (JSONException unused) {
        }
    }

    public String K() {
        return this.R.e();
    }

    public u12 L() {
        return this.R;
    }

    public String M() {
        return this.R.l();
    }

    public long N() {
        return this.T;
    }

    public l12 O() {
        return this.S;
    }

    public long P() {
        return this.V;
    }

    public long Q() {
        return this.W;
    }

    public String R() {
        return this.Q;
    }

    public String S() {
        return this.P;
    }

    public boolean T() {
        return this.U;
    }

    public void U() {
        this.U = true;
    }

    public void V() {
        this.V = 0L;
        this.W = 0L;
    }

    public void W() {
        this.V = System.currentTimeMillis();
        this.W = 0L;
    }

    public void X(long j, long j2) {
        this.T = j;
        this.W += j2;
    }

    public void Y(l12 l12Var) {
        this.S = l12Var;
    }

    @Override // com.yuewen.p12, com.duokan.core.async.work.b
    public void z(JSONObject jSONObject) throws JSONException {
        super.z(jSONObject);
        this.P = jSONObject.optString(X);
        this.Q = jSONObject.optString(Y);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(Z);
        this.R = jSONObjectOptJSONObject == null ? null : new u12(jSONObjectOptJSONObject);
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(a0);
        this.S = jSONObjectOptJSONObject2 != null ? new l12(jSONObjectOptJSONObject2) : null;
        this.T = jSONObject.optLong(b0);
        this.U = jSONObject.optBoolean(c0);
    }

    public it0(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.V = 0L;
        this.W = 0L;
    }
}
