package com.kwad.components.ad.reward.presenter.c.kwai;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.k.j;
import com.kwad.components.ad.reward.k.p;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.k.s;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.ad.reward.widget.tailframe.TailFrameView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ah;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements z.b {

    @Nullable
    private com.kwad.components.ad.i.b cp;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private DetailVideoView mDetailVideoView;
    private TailFrameView vB;
    private volatile boolean vC;
    private boolean vD;
    private j vE;
    private s vF;
    private p vG;
    private Drawable vJ;
    private boolean tf = false;
    private int vH = Integer.MIN_VALUE;
    private int vI = Integer.MIN_VALUE;
    private final com.kwad.components.ad.reward.d.j mRewardVerifyListener = new com.kwad.components.ad.reward.d.j() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.b.1
        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            b.this.iL();
            if (b.this.vB == null || !com.kwad.components.ad.reward.j.r(b.this.mAdTemplate)) {
                return;
            }
            b.this.vB.kc();
        }
    };
    private f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.b.3
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if ((!d.co(b.this.mAdTemplate) && b.this.tf && !b.this.qS.gi()) || b.this.qS.pW || b.this.qS.qb) {
                return;
            }
            boolean z2 = com.kwad.sdk.core.response.a.b.bG(b.this.mAdTemplate) && b.this.qS.mRewardVerifyCalled && b.this.qS.gc() == 1;
            b.this.vD = true;
            com.kwad.sdk.core.d.b.d("RewardPlayEndNativeCardPresenter", "onPlayEndPageShow " + z2);
            b bVar = b.this;
            if (z2) {
                com.kwad.components.ad.i.b bVar2 = bVar.qS.pB;
                if (bVar2 != null && bVar2.az()) {
                    b.this.qS.E(true);
                    b.this.vD = false;
                }
                b.this.iO();
            } else if (bVar.cp != null && b.this.cp.az()) {
                b.this.vD = false;
            }
            b.this.qS.qn = true ^ b.this.vD;
            if (b.this.vD) {
                if (b.this.qS.pA != null) {
                    com.kwad.components.ad.reward.monitor.a.a(b.this.qS.pN, "end_card", com.kwad.sdk.core.response.a.b.be(b.this.mAdTemplate), System.currentTimeMillis() - b.this.qS.pA.getLoadTime(), 1);
                }
                b.this.W(z2);
            }
        }

        @Override // com.kwad.components.ad.reward.d.a, com.kwad.components.ad.reward.d.f
        public final int getPriority() {
            return -1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void P(boolean z2) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, z2 ? 2 : TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED, this.qS.mRootContainer.getTouchCoords(), this.qS.mReportExtData);
        this.qS.mAdOpenInteractionListener.bN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i2) {
        ViewGroup.LayoutParams layoutParams = this.mDetailVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i2;
            this.mDetailVideoView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(boolean z2) {
        s sVar = this.vF;
        if (sVar != null) {
            sVar.show();
            return;
        }
        if (z2) {
            this.vG.show();
            this.vG.b(v.C(this.mAdTemplate));
            this.qS.E(true);
        } else {
            iL();
            this.vB.a(new com.kwad.components.ad.reward.widget.tailframe.b() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.b.5
                @Override // com.kwad.components.ad.reward.widget.tailframe.b
                public final void R(boolean z3) {
                    b.this.P(z3);
                }
            });
            this.vB.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iL() {
        if (this.vC) {
            return;
        }
        iM();
    }

    private void iM() {
        com.kwad.sdk.core.d.b.d("RewardPlayEndNativeCardPresenter", "initTailView");
        this.vB.a(getContext(), this.qS.mScreenOrientation == 0, iR());
        this.vC = true;
    }

    private void iN() {
        boolean zBu = com.kwad.sdk.core.response.a.a.bu(this.mAdInfo);
        boolean zCm = d.cm(this.mAdTemplate);
        if (zBu && zCm) {
            this.vF = new s(R.id.ksad_playable_end_stub);
            this.vF.a(new r.a() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.b.2
                @Override // com.kwad.components.ad.reward.k.r.a
                public final void ir() {
                    new y.b().akp = 6;
                }

                @Override // com.kwad.components.ad.reward.k.r.a
                public final void is() {
                    com.kwad.components.ad.reward.b.fz().c(PlayableSource.ENDCARD_CLICK, new com.kwad.components.ad.reward.f.a(b.this.getContext()));
                    com.kwad.sdk.core.report.a.a(b.this.qS.mAdTemplate, new i().bh(67).bm(6));
                }

                @Override // com.kwad.components.ad.reward.k.r.a
                public final void it() {
                    b.this.qS.a(2, b.this.getContext(), 2, 1);
                }

                @Override // com.kwad.components.ad.reward.k.r.a
                public final void iu() {
                    b.this.qS.a(2, b.this.getContext(), 2, 2);
                }
            });
            this.vF.e((ViewGroup) getRootView());
            this.vF.b(v.C(this.qS.mAdTemplate));
            this.vF.d(this.mAdTemplate, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iO() {
        this.mDetailVideoView.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.b.4
            @Override // java.lang.Runnable
            public final void run() {
                DetailVideoView detailVideoView;
                int i2;
                if (b.this.mDetailVideoView == null || ah.cu(b.this.getContext())) {
                    return;
                }
                boolean zAS = com.kwad.sdk.core.response.a.a.aS(b.this.mAdInfo);
                int screenWidth = com.kwad.sdk.b.kwai.a.getScreenWidth(b.this.getContext());
                b bVar = b.this;
                bVar.vH = bVar.mDetailVideoView.getLayoutParams().width;
                com.kwad.sdk.core.d.b.d("RewardPlayEndNativeCardPresenter", "setPlayAgainDetailView:  videoOriginalWidth :" + b.this.vH);
                b.this.S(screenWidth / 2);
                b bVar2 = b.this;
                bVar2.vI = bVar2.mDetailVideoView.getTextureViewGravity();
                if (zAS) {
                    detailVideoView = b.this.mDetailVideoView;
                    i2 = 21;
                } else {
                    detailVideoView = b.this.mDetailVideoView;
                    i2 = 17;
                }
                detailVideoView.updateTextureViewGravity(i2);
                b bVar3 = b.this;
                bVar3.vJ = bVar3.mDetailVideoView.getBackground();
                b.this.mDetailVideoView.setBackgroundColor(b.this.getContext().getResources().getColor(R.color.ksad_play_again_horizontal_bg_light));
                b.this.iP();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iP() {
        ImageView imageView = (ImageView) findViewById(R.id.ksad_blur_video_cover);
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
        com.kwad.components.ad.reward.presenter.b.a(imageView, com.kwad.sdk.core.response.a.a.P(this.mAdInfo), this.mAdTemplate);
    }

    private void iQ() {
        if (this.vD) {
            iL();
            this.vB.destroy();
            this.vB.setVisibility(8);
            this.vE.hide();
            this.vG.hide();
        }
    }

    private boolean iR() {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAO = com.kwad.sdk.core.response.a.a.aO(this.mAdInfo);
        return materialFeatureAO.height > materialFeatureAO.width;
    }

    @Override // com.kwad.components.core.webview.jshandler.z.b
    public final void a(z.a aVar) {
        this.tf = aVar.isSuccess();
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        j jVar;
        p pVar;
        super.ar();
        com.kwad.components.core.playable.a aVar = this.qS.py;
        if (aVar != null) {
            aVar.a(this);
        }
        this.mAdTemplate = this.qS.mAdTemplate;
        this.mAdInfo = d.cb(this.mAdTemplate);
        com.kwad.components.ad.reward.j jVar2 = this.qS;
        this.cp = jVar2.pA;
        jVar2.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.c.fD().a(this.mRewardVerifyListener);
        this.vB.setCallerContext(this.qS);
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playend_native_jinniu);
        if (viewStub != null) {
            jVar = new j(this.qS, viewStub);
        } else {
            jVar = new j(this.qS, (ViewGroup) findViewById(R.id.ksad_reward_jinniu_end_card_root));
        }
        this.vE = jVar;
        ViewStub viewStub2 = (ViewStub) findViewById(R.id.ksad_playend_native_play_again);
        if (viewStub2 != null) {
            pVar = new p(this.mAdTemplate, this.qS, viewStub2, this.mDetailVideoView);
        } else {
            pVar = new p(this.mAdTemplate, this.qS, (ViewGroup) findViewById(R.id.ksad_play_again_end_root), this.mDetailVideoView);
        }
        this.vG = pVar;
        iN();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vB = (TailFrameView) findViewById(R.id.ksad_video_tail_frame);
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
        if (this.mDetailVideoView.getLayoutTransition() != null) {
            this.mDetailVideoView.getLayoutTransition().enableTransitionType(4);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.playable.a aVar = this.qS.py;
        if (aVar != null) {
            aVar.b(this);
        }
        com.kwad.components.ad.reward.c.fD().b(this.mRewardVerifyListener);
        iQ();
        this.qS.c(this.mPlayEndPageListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            int i2 = this.vI;
            if (i2 != Integer.MIN_VALUE) {
                detailVideoView.updateTextureViewGravity(i2);
            }
            com.kwad.sdk.core.d.b.d("RewardPlayEndNativeCardPresenter", "onUnbind:  videoOriginalWidth :" + this.vH);
            int i3 = this.vH;
            if (i3 != Integer.MIN_VALUE) {
                S(i3);
            }
            Drawable drawable = this.vJ;
            if (drawable != null) {
                this.mDetailVideoView.setBackground(drawable);
            }
        }
        p pVar = this.vG;
        if (pVar != null) {
            pVar.ko();
        }
    }
}
