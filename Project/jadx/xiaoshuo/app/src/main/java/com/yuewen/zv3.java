package com.yuewen;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class zv3 extends p12 {
    public static final String T = "sync_dir_struct_task__root_path";
    public static final String U = "sync_dir_struct_task__use_incremental_refresh";
    public static final String V = "sync_dir_struct_task__just_sync_first_level";
    public static final String W = "sync_dir_struct_task__just_sync_first_level_files";
    public String P;
    public boolean Q;
    public boolean R;
    public boolean S;

    public zv3(String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, int i) {
        super(str, str2, str3, 3, i);
        this.P = str4;
        this.Q = z;
        this.R = z2;
        this.S = z3;
    }

    @Override // com.yuewen.p12, com.duokan.core.async.work.b
    public void E(JSONObject jSONObject) {
        super.E(jSONObject);
        try {
            jSONObject.put(T, this.P);
            jSONObject.put(U, this.Q);
            jSONObject.put(V, this.R);
            jSONObject.put(W, this.S);
        } catch (JSONException unused) {
        }
    }

    public String K() {
        return this.P;
    }

    public boolean L() {
        return this.S;
    }

    public boolean M() {
        return this.R;
    }

    public boolean N() {
        return this.Q;
    }

    @Override // com.yuewen.p12, com.duokan.core.async.work.b
    public void z(JSONObject jSONObject) throws JSONException {
        super.z(jSONObject);
        this.P = jSONObject.optString(T);
        this.Q = jSONObject.optBoolean(U);
        this.R = jSONObject.optBoolean(V);
        this.S = jSONObject.optBoolean(W);
    }

    public zv3(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }
}
