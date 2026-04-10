package com.kwad.sdk.core.j;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b implements c {
    private boolean aMM = false;
    private boolean Rj = false;
    private boolean Rk = false;

    protected abstract void aK();

    protected abstract void aL();

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        this.aMM = true;
        if (this.Rk) {
            return;
        }
        aK();
        this.Rk = true;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        if (this.aMM && !this.Rj) {
            aL();
            this.Rj = true;
        }
    }
}
