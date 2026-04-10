package com.kwad.components.ad.nativead.b;

import android.widget.ImageView;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends com.kwad.components.ad.nativead.a.a {
    private ImageView pM;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(R.id.ksad_video_cover_image);
        this.pM = imageView;
        a(imageView, "NativePlayEndCoverPresenter R.id.ksad_video_cover_image is null");
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.nativead.b.g.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                g.this.fD();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                g.this.fE();
            }
        };
        this.pq.pr.b(this.mVideoPlayStateListener);
        this.pM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD() {
        KSImageLoader.loadImage(this.pM, com.kwad.sdk.core.response.b.a.X(com.kwad.sdk.core.response.b.e.el(this.pq.mAdTemplate)), this.pq.mAdTemplate);
        this.pM.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE() {
        if (this.pM.getVisibility() == 0) {
            this.pM.setVisibility(8);
        }
    }
}
