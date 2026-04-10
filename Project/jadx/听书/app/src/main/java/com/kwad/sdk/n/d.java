package com.kwad.sdk.n;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class d extends com.kwad.sdk.core.response.a.a {
    public List<com.kwad.sdk.n.a.a> aWU;
    public List<String> aXc;
    public List<a> aXd;
    public List<com.kwad.sdk.n.a.b> aXe;
    public long funcSwitch;
    public long byteCount = 1000;
    public double sampleRate = 1.0d;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public String aXf;
        public String aXg;
    }

    public final boolean OX() {
        return (this.funcSwitch & 1) == 0;
    }

    public final boolean OY() {
        return eH(4);
    }

    public final boolean OZ() {
        return eH(16);
    }

    public final boolean Pa() {
        return eH(32);
    }

    private boolean eH(int i) {
        return (OX() || (this.funcSwitch & ((long) i)) == 0) ? false : true;
    }
}
