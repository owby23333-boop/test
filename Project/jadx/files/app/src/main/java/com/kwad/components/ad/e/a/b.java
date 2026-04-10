package com.kwad.components.ad.e.a;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.e.kwai.a {
    private ImageView cr;
    private com.kwad.sdk.core.response.model.b cs;
    private Runnable ct = new Runnable() { // from class: com.kwad.components.ad.e.a.b.2
        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.b.kwai.a.d(b.this.cr, b.this.cs.getWidth(), b.this.cs.getHeight());
            b.this.cr.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.cr, b.this.cs.getUrl(), b.this.nf.mAdTemplate);
        }
    };

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.cs = com.kwad.sdk.core.response.a.a.bh(com.kwad.sdk.core.response.a.d.cb(this.nf.mAdTemplate));
        if (TextUtils.isEmpty(this.cs.getUrl())) {
            return;
        }
        getRootView().post(this.ct);
        this.cr.setVisibility(0);
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.b.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                if (b.this.cr.getVisibility() == 0) {
                    b.this.cr.setVisibility(8);
                }
            }
        };
        this.nf.ng.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cr = (ImageView) findViewById(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.ct);
    }
}
