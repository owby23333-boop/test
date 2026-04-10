package com.kwad.components.core.o.c;

/* JADX INFO: loaded from: classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String ST;
    public long SU;
    public long SV;
    public long SW;
    public String SX;

    public final b at(String str) {
        this.ST = str;
        return this;
    }

    public final b F(long j) {
        this.SU = j;
        return this;
    }

    public final b G(long j) {
        this.SV = j;
        return this;
    }

    public final b aL(int i) {
        this.SW = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: aM, reason: merged with bridge method [inline-methods] */
    public final b setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public final b au(String str) {
        this.errorMsg = str;
        return this;
    }

    public final b av(String str) {
        this.SX = str;
        return this;
    }
}
