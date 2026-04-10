package com.kwad.components.ad.reward.presenter.d.a;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.k;
import com.kwad.components.ad.reward.widget.tailframe.TailFrameView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements as.b {
    private com.kwad.components.ad.l.b dF;
    private AdInfo mAdInfo;
    private DetailVideoView mDetailVideoView;
    private TailFrameView yX;
    private volatile boolean yY;
    private boolean yZ;
    private k za;
    private Drawable zd;
    private boolean wn = false;
    private int zb = Integer.MIN_VALUE;
    private int zc = Integer.MIN_VALUE;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            b.this.jH();
            if (b.this.yX == null || !g.P(b.this.mAdTemplate)) {
                return;
            }
            b.this.yX.la();
        }
    };
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.2
        @Override // com.kwad.components.ad.reward.e.a, com.kwad.components.ad.reward.e.g
        public final int getPriority() {
            return -1;
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            if ((!e.ey(b.this.mAdTemplate) && b.this.wn && !b.this.tm.gQ()) || b.this.tm.sf || b.this.tm.sl) {
                return;
            }
            b.this.yZ = true;
            if (b.this.dF != null && b.this.dF.aW()) {
                b.this.yZ = false;
            }
            b.this.tm.sw = true ^ b.this.yZ;
            if (b.this.yZ) {
                if (b.this.tm.rH != null) {
                    com.kwad.components.ad.reward.monitor.c.a(b.this.tm.mAdTemplate, b.this.tm.rS, "end_card", com.kwad.sdk.core.response.b.b.cK(b.this.mAdTemplate), System.currentTimeMillis() - b.this.tm.rH.getLoadTime(), 1);
                }
                b.this.bn();
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.yX = (TailFrameView) findViewById(R.id.ksad_video_tail_frame);
        DetailVideoView detailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView.getLayoutTransition() != null) {
            this.mDetailVideoView.getLayoutTransition().enableTransitionType(4);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        if (this.tm.rF != null) {
            this.tm.rF.a(this);
        }
        this.mAdInfo = e.el(this.mAdTemplate);
        this.dF = this.tm.rH;
        this.tm.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.gk().a(this.mRewardVerifyListener);
        this.yX.setCallerContext(this.tm);
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playend_native_jinniu);
        if (viewStub != null) {
            this.za = new k(this.tm, viewStub);
        } else {
            this.za = new k(this.tm, (ViewGroup) findViewById(R.id.ksad_reward_jinniu_end_card_root));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jH() {
        if (this.yY) {
            return;
        }
        jI();
    }

    private void jI() {
        com.kwad.sdk.core.d.c.d("RewardPlayEndNativeCardPresenter", "initTailView");
        this.yX.a(getContext(), this.tm.mScreenOrientation == 0, jK());
        this.yY = true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.tm.rF != null) {
            this.tm.rF.b(this);
        }
        com.kwad.components.ad.reward.b.gk().b(this.mRewardVerifyListener);
        jJ();
        this.tm.c(this.mPlayEndPageListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            int i = this.zc;
            if (i != Integer.MIN_VALUE) {
                detailVideoView.updateTextureViewGravity(i);
            }
            com.kwad.sdk.core.d.c.d("RewardPlayEndNativeCardPresenter", "onUnbind:  videoOriginalWidth :" + this.zb);
            int i2 = this.zb;
            if (i2 != Integer.MIN_VALUE) {
                ad(i2);
            }
            Drawable drawable = this.zd;
            if (drawable != null) {
                this.mDetailVideoView.setBackground(drawable);
            }
        }
    }

    private void ad(int i) {
        ViewGroup.LayoutParams layoutParams = this.mDetailVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            this.mDetailVideoView.setLayoutParams(layoutParams);
        }
    }

    private void jJ() {
        if (this.yZ) {
            jH();
            this.yX.destroy();
            this.yX.setVisibility(8);
            this.za.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn() {
        jH();
        this.yX.a(new com.kwad.components.ad.reward.widget.tailframe.b() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.3
            @Override // com.kwad.components.ad.reward.widget.tailframe.b
            public final void O(boolean z) {
                b.this.L(z);
            }
        });
        this.yX.setVisibility(0);
    }

    private boolean jK() {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAX = com.kwad.sdk.core.response.b.a.aX(this.mAdInfo);
        return materialFeatureAX.height > materialFeatureAX.width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z) {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", (String) null, new com.kwad.sdk.core.adlog.c.b().f(this.tm.mRootContainer.getTouchCoords()).dd(z ? 2 : MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT), this.tm.mReportExtData);
        this.tm.rD.cW();
    }

    @Override // com.kwad.components.core.webview.jshandler.as.b
    public final void a(as.a aVar) {
        this.wn = aVar.isSuccess();
    }
}
