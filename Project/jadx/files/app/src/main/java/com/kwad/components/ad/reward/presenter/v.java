package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.LayoutRes;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ah;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends a {
    private DetailVideoView pv;
    private ViewGroup tV;
    private FrameLayout tW;
    private ImageView tX;
    private ViewGroup.LayoutParams tY = null;
    private com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.v.1
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            super.onVideoPlayStart();
            v.this.pv.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.v.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    v.this.pv.setVisibility(0);
                }
            }, 200L);
        }
    };

    private void R(@LayoutRes int i2) {
        this.tW.addView(com.kwad.sdk.i.a.a(getContext(), i2, this.tW, false), -1, -1);
    }

    private void ih() {
    }

    private void ii() {
        int i2;
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate);
        boolean z2 = !ah.cu(getContext());
        boolean zBu = com.kwad.sdk.core.response.a.a.bu(adInfoCb);
        boolean z3 = com.kwad.sdk.core.response.a.a.cg(adInfoCb) && com.kwad.components.ad.reward.kwai.b.hb();
        boolean z4 = com.kwad.components.ad.reward.j.p(this.qS.mAdTemplate) || com.kwad.components.ad.reward.j.q(this.qS.mAdTemplate) || zBu || z3;
        if (!z2 || !z4) {
            this.tV.setVisibility(8);
            return;
        }
        this.tV.setVisibility(z3 ? 4 : 0);
        if (zBu) {
            this.tX.setVisibility(8);
            i2 = R.layout.ksad_playable_end_info;
        } else {
            i2 = R.layout.ksad_activity_apk_info_landscape;
        }
        R(i2);
        if (!com.kwad.sdk.core.response.a.a.aS(adInfoCb)) {
            this.pv.updateTextureViewGravity(17);
        } else {
            this.pv.updateTextureViewGravity(21);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        ih();
        ViewGroup.LayoutParams layoutParams = this.pv.getLayoutParams();
        if (layoutParams != null) {
            this.tY = new ViewGroup.LayoutParams(layoutParams);
        }
        this.qS.pw.ka().a(this.mVideoPlayStateListener);
        ii();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.pv = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.tV = (ViewGroup) findViewById(R.id.ksad_play_right_area);
        this.tX = (ImageView) findViewById(R.id.ksad_play_right_area_bg_img);
        this.tW = (FrameLayout) findViewById(R.id.ksad_play_right_area_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        DetailVideoView detailVideoView;
        super.onUnbind();
        this.qS.pw.ka().b(this.mVideoPlayStateListener);
        if (this.tY == null || (detailVideoView = this.pv) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = detailVideoView.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.LayoutParams layoutParams2 = this.tY;
            layoutParams.width = layoutParams2.width;
            layoutParams.height = layoutParams2.height;
            this.pv.setLayoutParams(layoutParams);
        }
        DetailVideoView detailVideoView2 = this.pv;
        if (detailVideoView2 != null) {
            detailVideoView2.setVisibility(4);
        }
        this.tY = null;
    }
}
