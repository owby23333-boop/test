package com.bytedance.e.e.p;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ga {
    private String bf;
    private JSONObject d;
    private final int e;

    public ga(int i) {
        this.e = i;
    }

    public boolean e() {
        return this.e == 0;
    }

    public ga(int i, Throwable th) {
        this.e = i;
        if (th != null) {
            this.bf = th.getMessage();
        }
    }

    public ga(int i, String str) {
        this.e = i;
        this.bf = str;
    }

    public ga(int i, JSONObject jSONObject) {
        this.e = i;
        this.d = jSONObject;
    }
}
