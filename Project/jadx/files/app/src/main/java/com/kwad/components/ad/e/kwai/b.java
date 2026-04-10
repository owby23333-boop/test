package com.kwad.components.ad.e.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.e.d;
import com.kwad.components.core.d.b.c;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @Nullable
    public c mApkDownloadHelper;

    @NonNull
    public KsNativeAd.VideoPlayListener mJ;

    @NonNull
    public d.a mO;

    @NonNull
    public AdBasePvFrameLayout na;

    @NonNull
    public com.kwad.components.ad.e.b.a ng;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        this.ng.release();
    }
}
