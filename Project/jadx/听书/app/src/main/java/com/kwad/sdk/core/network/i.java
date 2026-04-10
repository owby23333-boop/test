package com.kwad.sdk.core.network;

/* JADX INFO: loaded from: classes4.dex */
public class i extends com.kwad.sdk.commercial.c.a {
    public String aEH;
    public int aEI = 0;
    public String host;
    public int httpCode;
    public String url;

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        return toJson().toString();
    }
}
