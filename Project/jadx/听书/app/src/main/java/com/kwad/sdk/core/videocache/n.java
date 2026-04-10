package com.kwad.sdk.core.videocache;

/* JADX INFO: loaded from: classes4.dex */
public final class n {
    public final long aLB;
    public final String aLC;
    public final String url;

    public n(String str, long j, String str2) {
        this.url = str;
        this.aLB = j;
        this.aLC = str2;
    }

    public final String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.aLB + ", mime='" + this.aLC + "'}";
    }
}
