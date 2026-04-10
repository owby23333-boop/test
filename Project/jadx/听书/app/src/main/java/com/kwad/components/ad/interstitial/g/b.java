package com.kwad.components.ad.interstitial.g;

import android.view.View;
import com.kwad.sdk.utils.bz;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.core.widget.a.a {
    private View mRootView;

    public b(View view, int i) {
        super(view, i);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.a
    public final boolean ae() {
        return bz.o(this.mRootView, 100);
    }
}
