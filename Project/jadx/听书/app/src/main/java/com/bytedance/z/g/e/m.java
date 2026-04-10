package com.bytedance.z.g.e;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private JSONObject dl;
    private String g;
    private final int z;

    public m(int i) {
        this.z = i;
    }

    public m(int i, Throwable th) {
        this.z = i;
        if (th != null) {
            this.g = th.getMessage();
        }
    }

    public m(int i, String str) {
        this.z = i;
        this.g = str;
    }

    public m(int i, JSONObject jSONObject) {
        this.z = i;
        this.dl = jSONObject;
    }

    public boolean z() {
        return this.z == 0;
    }
}
