package com.kwad.components.ad.reward.b;

/* JADX INFO: loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public static int STATUS_NONE = 2;
    public static int rP = 1;
    public static int rQ = 3;
    public int rR;
    public int rS;

    public b() {
        this.rR = STATUS_NONE;
    }

    public b(int i2) {
        this.rR = STATUS_NONE;
        this.rR = 1;
    }

    public final void P(int i2) {
        this.rS = i2;
    }

    public final int getType() {
        return this.rR;
    }

    public final int hl() {
        return this.rS;
    }
}
