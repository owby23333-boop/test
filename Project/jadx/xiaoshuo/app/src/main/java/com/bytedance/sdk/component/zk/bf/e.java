package com.bytedance.sdk.component.zk.bf;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public int bf;
    public int d;
    public int e;
    public int tg;

    public e(int i, int i2, int i3, int i4) {
        this.e = i;
        this.bf = i2;
        this.d = i3;
        this.tg = i4;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_thread_num", this.e);
            jSONObject.put("sdk_max_thread_num", this.bf);
            jSONObject.put("app_thread_num", this.d);
            jSONObject.put("app_max_thread_num", this.tg);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }
}
