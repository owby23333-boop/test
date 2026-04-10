package com.kwad.sdk.pngencrypt.chunk;

/* JADX INFO: loaded from: classes4.dex */
public abstract class t extends k {
    protected String aWB;
    protected String key;

    protected t(String str, com.kwad.sdk.pngencrypt.k kVar) {
        super(str, kVar);
    }

    public final String getKey() {
        return this.key;
    }

    public final String ON() {
        return this.aWB;
    }
}
