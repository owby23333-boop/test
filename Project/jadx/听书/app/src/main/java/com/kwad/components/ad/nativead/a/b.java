package com.kwad.components.ad.nativead.a;

import com.kwad.components.ad.nativead.d;
import com.kwad.components.core.e.d.c;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public c mApkDownloadHelper;
    public KsNativeAd.VideoPlayListener oQ;
    public d.a oW;
    public AdBasePvFrameLayout pl;
    public com.kwad.components.ad.nativead.c.a pr;
    public boolean pw = false;
    public boolean px = false;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        this.pr.release();
    }
}
