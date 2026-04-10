package com.yuewen;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class p12 extends com.duokan.core.async.work.b {
    public static final String J = "storage_task_item_mi_account_id";
    public static final String K = "storage_task_item_namespace";
    public static final int L = 0;
    public static final int M = 1;
    public static final int N = 2;
    public static final int O = 3;
    public String H;
    public String I;

    public p12(String str, String str2, String str3, int i, int i2) {
        super(str3, i, i2);
        this.H = str;
        this.I = str2;
    }

    @Override // com.duokan.core.async.work.b
    public void E(JSONObject jSONObject) {
        super.E(jSONObject);
        try {
            jSONObject.put(J, this.H);
            jSONObject.put(K, this.I);
        } catch (Exception unused) {
        }
    }

    public final String I() {
        return this.H;
    }

    public final String J() {
        return this.I;
    }

    @Override // com.duokan.core.async.work.b
    public void z(JSONObject jSONObject) throws JSONException {
        super.z(jSONObject);
        this.H = jSONObject.optString(J);
        this.I = jSONObject.optString(K);
    }

    public p12(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }
}
