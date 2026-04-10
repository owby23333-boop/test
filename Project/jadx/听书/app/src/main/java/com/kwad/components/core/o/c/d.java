package com.kwad.components.core.o.c;

/* JADX INFO: loaded from: classes3.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public String ST;
    public long SU;
    public long SV;
    public String SX;
    public long SY;

    public final d aw(String str) {
        this.ST = str;
        return this;
    }

    public final d H(long j) {
        this.SU = j;
        return this;
    }

    public final d I(long j) {
        this.SV = j;
        return this;
    }

    public final d J(long j) {
        this.SY = j;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: aN, reason: merged with bridge method [inline-methods] */
    public final d setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public final d ax(String str) {
        this.errorMsg = str;
        return this;
    }

    public final d ay(String str) {
        this.SX = str;
        return this;
    }
}
