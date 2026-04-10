package com.kwad.components.ad.fullscreen;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsFullScreenVideoAd;

/* JADX INFO: loaded from: classes2.dex */
public class c implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {

    @Nullable
    private KsFullScreenVideoAd.FullScreenVideoAdInteractionListener ge;

    public final void a(@Nullable KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.ge = fullScreenVideoAdInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClicked() {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.ge;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onPageDismiss() {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.ge;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onPageDismiss();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.ge;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onSkippedVideo();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayEnd() {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.ge;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onVideoPlayEnd();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayError(int i2, int i3) {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.ge;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onVideoPlayError(i2, i3);
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayStart() {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.ge;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onVideoPlayStart();
        }
    }
}
