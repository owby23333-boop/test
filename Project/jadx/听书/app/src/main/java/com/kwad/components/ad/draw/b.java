package com.kwad.components.ad.draw;

import android.view.View;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.utils.bz;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.core.widget.a.b {
    private View mRootView;

    public b(View view) {
        super(view, aG());
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.b, com.kwad.components.core.widget.a.a
    public final boolean ae() {
        return bz.a(this.mRootView, 70, true);
    }

    private static int aG() {
        int iFI;
        try {
            iFI = ((int) e.FI()) * 100;
        } catch (Throwable unused) {
        }
        if (iFI < 0 || iFI > 100) {
            return 70;
        }
        return iFI;
    }
}
