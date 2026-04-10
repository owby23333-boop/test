package com.kwad.components.ad.e.kwai;

import com.kwad.components.core.video.i;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Presenter {
    public i mVideoPlayStateListener;
    public b nf;

    @Override // com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        this.nf = (b) Bs();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.nf.ng.b(this.mVideoPlayStateListener);
    }
}
