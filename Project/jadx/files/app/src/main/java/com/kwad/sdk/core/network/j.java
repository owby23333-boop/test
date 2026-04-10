package com.kwad.sdk.core.network;

/* JADX INFO: loaded from: classes3.dex */
public class j extends com.kwad.sdk.core.response.kwai.a {
    public String age;
    public int agf = 0;
    public String agg;
    public String errorMsg;
    public String host;
    public int httpCode;
    public String url;

    @Override // com.kwad.sdk.core.response.kwai.a
    public String toString() {
        return toJson().toString();
    }
}
