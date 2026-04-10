package com.kwad.sdk.core.network;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public int aEi = -1;
    public Exception aEj;
    public String aEk;
    public int code;

    public final boolean Hx() {
        return this.code == 200;
    }

    public final String toString() {
        return "BaseResponse{code=" + this.code + ", rawCode=" + this.aEi + ", rawException=" + this.aEj + ", body='" + this.aEk + "'}";
    }
}
