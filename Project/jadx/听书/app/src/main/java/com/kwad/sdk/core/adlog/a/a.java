package com.kwad.sdk.core.adlog.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public JSONObject axq;
    public com.kwad.sdk.core.adlog.c.a axr;
    public long axs;
    public int axt;
    public String axu;
    public int retryCount;
    public String url;

    public static a Ez() {
        return new a();
    }

    public final a dm(String str) {
        this.url = str;
        return this;
    }

    public final a i(JSONObject jSONObject) {
        this.axq = jSONObject;
        return this;
    }

    public final a c(com.kwad.sdk.core.adlog.c.a aVar) {
        this.axr = aVar;
        return this;
    }

    public final a as(long j) {
        this.axs = j;
        return this;
    }

    public final a cK(int i) {
        this.axt = i;
        return this;
    }

    public final a dn(String str) {
        this.axu = str;
        return this;
    }

    public final String toString() {
        return "AdLogCache {actionType=" + this.axr.awx + ", retryCount=" + this.retryCount + ", retryErrorCode=" + this.axt + ", retryErrorMsg=" + this.axu + '}';
    }
}
