package com.kwad.components.core.g;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInnerAd;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    @Nullable
    private Object JS;

    public d(Object obj) {
        this.JS = obj;
    }

    public void d(c cVar) {
        if (this.JS == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.JS).onAdClicked((KsInnerAd) cVar.getHost());
        } catch (Exception unused) {
        }
    }

    public final void destroy() {
        this.JS = null;
    }

    public void e(c cVar) {
        if (this.JS == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.JS).onAdShow((KsInnerAd) cVar.getHost());
        } catch (Exception unused) {
        }
    }
}
