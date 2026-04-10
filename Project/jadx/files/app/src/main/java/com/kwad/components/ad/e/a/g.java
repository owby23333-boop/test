package com.kwad.components.ad.e.a;

import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends com.kwad.components.ad.e.kwai.a {
    private ImageView nw;

    /* JADX INFO: Access modifiers changed from: private */
    public void eV() {
        KSImageLoader.loadImage(this.nw, com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.a.d.cb(this.nf.mAdTemplate)), this.nf.mAdTemplate);
        this.nw.setVisibility(0);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.g.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                g.this.eV();
            }
        };
        this.nf.ng.a(this.mVideoPlayStateListener);
        this.nw.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nw = (ImageView) findViewById(R.id.ksad_video_cover_image);
    }
}
