package com.kwad.components.core.video;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private boolean Ro = false;
    private boolean Rp = false;
    private boolean Rq = false;
    private boolean Rr = false;
    private boolean Rs = false;
    private int Rt = -1;

    public final void aJ(int i2) {
        this.Rt = i2;
    }

    public final void aK(boolean z2) {
        this.Rq = z2;
    }

    public final boolean qE() {
        return this.Rt > 0;
    }

    public final int qF() {
        return this.Rt;
    }

    public final boolean qG() {
        return this.Ro;
    }

    public final boolean qH() {
        return this.Rp;
    }

    public final boolean qI() {
        return this.Rq;
    }

    public final boolean qJ() {
        return this.Rr;
    }

    public final boolean qK() {
        return this.Rs;
    }

    public final void setAd(boolean z2) {
        this.Rp = z2;
    }

    public final void setFillXY(boolean z2) {
        this.Rs = z2;
    }

    public final void setForce(boolean z2) {
        this.Ro = z2;
    }

    public final void setHorizontalVideo(boolean z2) {
        this.Rr = z2;
    }
}
