package com.kwad.components.core.request.model;

import android.text.TextUtils;
import com.kwad.components.core.request.j;
import com.kwad.sdk.commercial.d.d;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.AdResultData;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public final ImpInfo Rw;
    public final com.kwad.components.core.request.c Xc;
    public j Xd;
    public List<String> Xe;
    public boolean Xf;
    public boolean Xg;
    public c Xh;
    private String Xi;

    /* synthetic */ a(C0351a c0351a, byte b) {
        this(c0351a);
    }

    public static void a(a aVar, AdResultData adResultData, boolean z) {
        d.a(aVar.Rw.adScene, aVar.sv(), adResultData.getAdSource());
        if (adResultData.isAdResultDataEmpty()) {
            aVar.Xc.a(e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? e.aEq.msg : adResultData.testErrorMsg, z);
        } else {
            aVar.Xc.a(adResultData, z);
        }
    }

    public static void a(a aVar, int i, String str, boolean z) {
        aVar.Xc.a(i, str, z);
        d.a(aVar.getAdStyle(), i, str, aVar.sv());
    }

    private a(C0351a c0351a) {
        this.Rw = c0351a.Rw;
        this.Xc = c0351a.Xc;
        this.Xf = c0351a.Xf;
        this.Xg = c0351a.Xg;
        this.Xd = c0351a.Xj;
    }

    public final long getPosId() {
        if (this.Rw.adScene != null) {
            return this.Rw.adScene.getPosId();
        }
        return -1L;
    }

    public final int getAdNum() {
        if (this.Rw.adScene != null) {
            return this.Rw.adScene.getAdNum();
        }
        return 1;
    }

    public final j su() {
        return this.Xd;
    }

    public final int getAdStyle() {
        if (this.Rw.adScene != null) {
            return this.Rw.adScene.adStyle;
        }
        return 0;
    }

    public final String sv() {
        return !TextUtils.isEmpty(this.Xi) ? this.Xi : "network_only";
    }

    public final void aE(String str) {
        this.Xi = str;
    }

    /* JADX INFO: renamed from: com.kwad.components.core.request.model.a$a, reason: collision with other inner class name */
    public static class C0351a {
        public ImpInfo Rw;
        public com.kwad.components.core.request.c Xc;
        public boolean Xf;
        public boolean Xg;
        public j Xj;

        public final C0351a e(ImpInfo impInfo) {
            this.Rw = impInfo;
            return this;
        }

        public final C0351a aL(boolean z) {
            this.Xf = true;
            return this;
        }

        public final C0351a aM(boolean z) {
            this.Xg = z;
            return this;
        }

        public final C0351a a(com.kwad.components.core.request.c cVar) {
            this.Xc = cVar;
            return this;
        }

        public final C0351a a(j jVar) {
            this.Xj = jVar;
            return this;
        }

        public final a sw() {
            if (com.kwad.components.ad.f.a.oz.booleanValue() && (this.Rw == null || this.Xc == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new a(this, (byte) 0);
        }
    }
}
