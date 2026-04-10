package com.kwad.sdk.core.network.idc.a;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private final long aFD;
    private volatile boolean aFE = false;

    public a(long j, boolean z) {
        this.aFD = j;
    }

    public final boolean HJ() {
        return this.aFE;
    }

    public final a bq(boolean z) {
        this.aFE = true;
        return this;
    }

    public final long HK() {
        return this.aFD;
    }
}
