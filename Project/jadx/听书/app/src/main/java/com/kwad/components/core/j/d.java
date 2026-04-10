package com.kwad.components.core.j;

import com.kwad.sdk.api.KsInnerAd;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private Object Rf;

    public d(Object obj) {
        this.Rf = obj;
    }

    public final void c(c cVar) {
        if (this.Rf == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.Rf).onAdClicked((KsInnerAd) cVar.getHost());
        } catch (Exception unused) {
        }
    }

    public final void d(c cVar) {
        if (this.Rf == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.Rf).onAdShow((KsInnerAd) cVar.getHost());
        } catch (Exception unused) {
        }
    }

    public final void destroy() {
        this.Rf = null;
    }
}
