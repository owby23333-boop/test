package com.kwad.sdk.core.g;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements c {
    private boolean aoL = false;
    private boolean JW = false;
    private boolean JX = false;

    @Override // com.kwad.sdk.core.g.c
    public final void aS() {
        this.aoL = true;
        if (this.JX) {
            return;
        }
        ap();
        this.JX = true;
    }

    @Override // com.kwad.sdk.core.g.c
    public final void aT() {
        if (this.aoL && !this.JW) {
            aq();
            this.JW = true;
        }
    }

    protected abstract void ap();

    protected abstract void aq();
}
