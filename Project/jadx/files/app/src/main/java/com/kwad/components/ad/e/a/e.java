package com.kwad.components.ad.e.a;

import com.kwad.sdk.api.KsNativeAd;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends com.kwad.components.ad.e.kwai.a {
    private boolean bZ = false;
    private KsNativeAd.VideoPlayListener mJ;

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mJ = this.nf.mJ;
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.e.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                if (e.this.mJ != null) {
                    e.this.mJ.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i2, int i3) {
                if (e.this.mJ != null) {
                    e.this.mJ.onVideoPlayError(i2, i3);
                }
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayPaused() {
                super.onVideoPlayPaused();
                if (e.this.mJ != null) {
                    try {
                        e.this.mJ.onVideoPlayPause();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
                e.this.bZ = true;
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                if (e.this.mJ != null) {
                    e.this.mJ.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                if (e.this.bZ) {
                    e.this.bZ = false;
                    if (e.this.mJ != null) {
                        try {
                            e.this.mJ.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                }
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPrepared() {
                super.onVideoPrepared();
                if (e.this.mJ != null) {
                    try {
                        e.this.mJ.onVideoPlayReady();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
            }
        };
        this.nf.ng.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
