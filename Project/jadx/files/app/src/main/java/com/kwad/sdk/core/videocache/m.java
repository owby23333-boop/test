package com.kwad.sdk.core.videocache;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public final long anE;
    public final String anF;
    public final String url;

    public m(String str, long j2, String str2) {
        this.url = str;
        this.anE = j2;
        this.anF = str2;
    }

    public final String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.anE + ", mime='" + this.anF + "'}";
    }
}
