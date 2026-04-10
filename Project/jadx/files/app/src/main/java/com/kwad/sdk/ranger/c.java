package com.kwad.sdk.ranger;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class c extends com.kwad.sdk.core.response.kwai.a {
    public long axk;
    public List<String> axl;
    public List<a> axm;
    public long axn = 1000;
    public double axo = 1.0d;

    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String axp;
        public String axq;
    }

    private boolean bZ(int i2) {
        return (Cv() || (this.axk & ((long) i2)) == 0) ? false : true;
    }

    public final boolean Cv() {
        return (this.axk & 1) == 0;
    }

    public final boolean Cw() {
        return bZ(2);
    }

    public final boolean Cx() {
        return bZ(4);
    }
}
