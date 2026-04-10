package com.kwad.sdk.mobileid;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private String aTj;
    private String errorReason;
    private boolean success;

    public d(boolean z, String str) {
        this.success = z;
        this.errorReason = str;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public final String Nz() {
        return this.errorReason;
    }

    public final String NA() {
        return this.aTj;
    }

    public final void gn(String str) {
        this.aTj = str;
    }

    public final String toString() {
        return "UaidErrorReason{success=" + this.success + ", errorReason='" + this.errorReason + "', extraErrorMsg='" + this.aTj + "'}";
    }
}
