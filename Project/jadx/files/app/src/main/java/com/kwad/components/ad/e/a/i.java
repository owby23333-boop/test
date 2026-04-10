package com.kwad.components.ad.e.a;

import android.view.View;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    private DetailVideoView mDetailVideoView;

    private void eW() {
        com.kwad.components.core.d.b.a.a(new a.C0395a(this.mDetailVideoView.getContext()).J(this.nf.mAdTemplate).b(this.nf.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.ad.e.a.i.2
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(i.this.nf.mAdTemplate, 2, i.this.nf.na.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        this.nf.mO.l(this.mDetailVideoView);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.i.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                super.onVideoPlayStart();
                i.this.mDetailVideoView.setOnClickListener(i.this);
            }
        };
        this.nf.ng.a(this.mVideoPlayStateListener);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.mDetailVideoView) {
            eW();
            notifyAdClick();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mDetailVideoView.setOnClickListener(null);
    }
}
