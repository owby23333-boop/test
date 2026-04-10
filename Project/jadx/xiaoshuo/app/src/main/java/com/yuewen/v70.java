package com.yuewen;

import android.text.TextUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class v70 extends p12 {
    public static final String e0 = "create_file_task_local_file_path";
    public static final String f0 = "create_file_task_cloud_file_parent_path";
    public static final String g0 = "create_file_task_cloud_file_name";
    public static final String h0 = "create_file_task_cloud_parent_id";
    public static final String i0 = "create_file_task_file_block_infos";
    public static final String j0 = "create_file_task_last_modified_time";
    public static final String k0 = "create_file_task_file_size";
    public static final String l0 = "create_file_task_file_sha1";
    public static final String m0 = "create_file_task_upload_data";
    public static final String n0 = "create_file_task_uploaded_length";
    public static final String o0 = "create_file_task_commit_data";
    public static final String p0 = "create_file_task_cloud_file_info";
    public static final String q0 = "work_item_need_delete_source";
    public String P;
    public String Q;
    public String R;
    public dq1 S;
    public long T;
    public long U;
    public String V;
    public String W;
    public s12 X;
    public long Y;
    public eq1 Z;
    public u12 a0;
    public long b0;
    public long c0;
    public boolean d0;

    public v70(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        super(str, str2, str3, 0, i);
        this.P = str4;
        this.Q = str5;
        this.R = str6;
        this.W = "";
        this.S = null;
        this.T = 0L;
        this.U = 0L;
        this.V = null;
        this.X = null;
        this.Y = 0L;
        this.Z = null;
        this.a0 = null;
    }

    @Override // com.yuewen.p12, com.duokan.core.async.work.b
    public void E(JSONObject jSONObject) {
        super.E(jSONObject);
        try {
            jSONObject.put(e0, this.P);
            jSONObject.put(q0, this.d0);
            jSONObject.put(f0, this.Q);
            jSONObject.put(g0, this.R);
            jSONObject.put(h0, this.W);
            dq1 dq1Var = this.S;
            JSONObject jSONObjectD = null;
            jSONObject.put(i0, dq1Var == null ? null : dq1Var.a());
            jSONObject.put(j0, this.T);
            jSONObject.put(k0, this.U);
            jSONObject.put(l0, this.V);
            s12 s12Var = this.X;
            jSONObject.put(m0, s12Var == null ? null : s12Var.a());
            jSONObject.put(n0, this.Y);
            eq1 eq1Var = this.Z;
            jSONObject.put(o0, eq1Var == null ? null : eq1Var.b());
            u12 u12Var = this.a0;
            if (u12Var != null) {
                jSONObjectD = u12Var.d();
            }
            jSONObject.put(p0, jSONObjectD);
        } catch (JSONException unused) {
        }
    }

    public u12 K() {
        return this.a0;
    }

    public String L() {
        return this.R;
    }

    public String M() {
        return this.Q;
    }

    public String N() {
        return this.W;
    }

    public dq1 O() {
        return this.S;
    }

    public eq1 P() {
        return this.Z;
    }

    public s12 Q() {
        return this.X;
    }

    public long R() {
        return this.b0;
    }

    public long S() {
        return this.c0;
    }

    public long T() {
        return this.T;
    }

    public String U() {
        return this.P;
    }

    public String V() {
        return this.V;
    }

    public long W() {
        return this.U;
    }

    public long X() {
        if (!r() || R() == 0 || S() == 0) {
            return 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - R();
        if (jCurrentTimeMillis == 0) {
            return 0L;
        }
        return (S() * 1000) / jCurrentTimeMillis;
    }

    public long Y() {
        return this.Y;
    }

    public void Z(long j, long j2, dq1 dq1Var, String str) {
        this.T = j;
        this.U = j2;
        this.S = dq1Var;
        this.V = str;
    }

    public boolean a0() {
        return this.d0;
    }

    public boolean b0(v70 v70Var) {
        if (v70Var == null) {
            return false;
        }
        return this.P.equals(v70Var.U());
    }

    public void c0() {
        this.b0 = System.currentTimeMillis();
        this.c0 = 0L;
    }

    public void d0(long j) {
        this.U = j;
    }

    public void e0(boolean z) {
        this.d0 = z;
    }

    public void f0() {
        this.b0 = System.currentTimeMillis();
        this.c0 = 0L;
    }

    public void g0(u12 u12Var) {
        this.a0 = u12Var;
    }

    public void h0(String str) {
        this.W = str;
    }

    public void i0(eq1 eq1Var) {
        this.Z = eq1Var;
    }

    public void j0(s12 s12Var) {
        this.X = s12Var;
    }

    public void k0(long j, long j2) {
        this.Y = j;
        this.c0 += j2;
    }

    @Override // com.yuewen.p12, com.duokan.core.async.work.b
    public void z(JSONObject jSONObject) throws JSONException {
        super.z(jSONObject);
        this.P = jSONObject.optString(e0);
        this.Q = jSONObject.optString(f0);
        String strOptString = jSONObject.optString(g0);
        this.R = strOptString;
        if (TextUtils.isEmpty(strOptString)) {
            this.R = new File(this.P).getName();
        }
        this.W = jSONObject.optString(h0);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(i0);
        this.S = jSONObjectOptJSONObject == null ? null : new dq1(jSONObjectOptJSONObject);
        this.T = jSONObject.optLong(j0);
        this.U = jSONObject.optLong(k0);
        this.V = jSONObject.optString(l0);
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(m0);
        this.X = jSONObjectOptJSONObject2 == null ? null : new s12(jSONObjectOptJSONObject2);
        this.Y = jSONObject.optLong(n0);
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(o0);
        this.Z = jSONObjectOptJSONObject3 == null ? null : new eq1(jSONObjectOptJSONObject3);
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject(p0);
        this.a0 = jSONObjectOptJSONObject4 != null ? new u12(jSONObjectOptJSONObject4) : null;
        this.d0 = jSONObject.optBoolean(q0, false);
    }

    public v70(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }
}
