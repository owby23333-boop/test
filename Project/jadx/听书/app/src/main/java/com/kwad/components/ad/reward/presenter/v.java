package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.aq;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends b {
    private DetailVideoView wV;
    private ViewGroup wW;
    private FrameLayout wX;
    private ImageView wY;
    private ViewGroup.LayoutParams wZ = null;
    private com.kwad.components.core.video.m jE = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.v.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            v.this.wV.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.v.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    v.this.wV.setVisibility(0);
                }
            }, 200L);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wV = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.wW = (ViewGroup) findViewById(R.id.ksad_play_right_area);
        this.wY = (ImageView) findViewById(R.id.ksad_play_right_area_bg_img);
        this.wX = (FrameLayout) findViewById(R.id.ksad_play_right_area_container);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        iV();
        ViewGroup.LayoutParams layoutParams = this.wV.getLayoutParams();
        if (layoutParams != null) {
            this.wZ = new ViewGroup.LayoutParams(layoutParams);
        }
        this.tm.rE.a(this.jE);
        iW();
    }

    private void iV() {
    }

    private void iW() {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
        getContext();
        boolean z = !aq.QW();
        boolean zBK = com.kwad.sdk.core.response.b.a.bK(adInfoEl);
        boolean z2 = com.kwad.sdk.core.response.b.a.cJ(adInfoEl) && com.kwad.components.ad.reward.a.b.hM();
        boolean z3 = com.kwad.components.ad.reward.g.N(this.tm.mAdTemplate) || com.kwad.components.ad.reward.g.O(this.tm.mAdTemplate) || zBK || z2;
        if (z && z3) {
            this.wW.setVisibility(z2 ? 4 : 0);
            if (zBK) {
                this.wY.setVisibility(8);
                ac(R.layout.ksad_playable_end_info);
            } else {
                ac(R.layout.ksad_activity_apk_info_landscape);
            }
            if (!com.kwad.sdk.core.response.b.a.aY(adInfoEl)) {
                this.wV.updateTextureViewGravity(17);
                return;
            } else {
                this.wV.updateTextureViewGravity(21);
                return;
            }
        }
        this.wW.setVisibility(8);
    }

    private void ac(int i) {
        this.wX.addView(com.kwad.sdk.o.m.a(getContext(), i, this.wX, false), -1, -1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        DetailVideoView detailVideoView;
        super.onUnbind();
        this.tm.rE.b(this.jE);
        if (this.wZ == null || (detailVideoView = this.wV) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = detailVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.wZ.width;
            layoutParams.height = this.wZ.height;
            this.wV.setLayoutParams(layoutParams);
        }
        DetailVideoView detailVideoView2 = this.wV;
        if (detailVideoView2 != null) {
            detailVideoView2.setVisibility(4);
        }
        this.wZ = null;
    }
}
