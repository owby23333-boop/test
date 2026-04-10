package com.kwad.components.ad.reward.presenter.c.kwai;

import android.animation.Animator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.i.b;
import com.kwad.components.ad.reward.d.j;
import com.kwad.components.ad.reward.k.t;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ah;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements b.a {
    private com.kwad.components.ad.i.b cp;
    private FrameLayout de;
    private DetailVideoView mDetailVideoView;
    private com.kwad.components.ad.i.b pB;

    @Nullable
    private FrameLayout vL;
    private int tt = Integer.MIN_VALUE;
    private final j mRewardVerifyListener = new j() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.c.1
        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (c.this.cp == null || !com.kwad.components.ad.reward.j.r(c.this.qS.mAdTemplate)) {
                return;
            }
            c.this.cp.ai(true);
        }
    };
    private com.kwad.sdk.core.webview.c.kwai.a cV = new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.c.2
        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            c.this.qS.mAdOpenInteractionListener.bN();
        }
    };

    private void iS() {
        FrameLayout frameLayout;
        com.kwad.components.ad.i.b bVar;
        AdTemplate adTemplate = this.qS.mAdTemplate;
        if (!com.kwad.sdk.core.response.a.b.bG(adTemplate) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.b.bI(adTemplate)) || (frameLayout = this.vL) == null || (bVar = this.pB) == null) {
            return;
        }
        com.kwad.components.ad.reward.j jVar = this.qS;
        bVar.a(frameLayout, jVar.mRootContainer, adTemplate, jVar.mApkDownloadHelper, jVar.mScreenOrientation);
        this.pB.a((b.InterfaceC0353b) null);
        ViewGroup.LayoutParams layoutParams = this.vL.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            if (ah.cu(getContext())) {
                marginLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ksad_play_again_end_animate_margin);
            } else {
                marginLayoutParams.bottomMargin = 0;
                marginLayoutParams.width = com.kwad.sdk.b.kwai.a.getScreenWidth(getContext()) / 2;
                marginLayoutParams.height = -1;
                marginLayoutParams.rightMargin = -marginLayoutParams.width;
            }
            this.vL.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.kwad.components.ad.i.b.a
    public final void a(com.kwad.components.ad.i.b bVar) {
        Animator animatorA;
        if (bVar.equals(this.pB)) {
            if (ah.cu(getContext())) {
                this.tt = com.kwad.sdk.b.kwai.a.G(this.mDetailVideoView);
                com.kwad.sdk.b.kwai.a.o(this.mDetailVideoView, 49);
                animatorA = t.a(this.qS.mAdTemplate, this.pB.mg(), this.mDetailVideoView);
            } else {
                animatorA = t.a(this.qS.mAdTemplate, this.mDetailVideoView, this.pB.mg());
            }
            if (animatorA != null) {
                animatorA.start();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.reward.j jVar = this.qS;
        AdTemplate adTemplate = jVar.mAdTemplate;
        this.cp = jVar.pA;
        if (this.cp == null) {
            return;
        }
        com.kwad.components.ad.reward.c.fD().a(this.mRewardVerifyListener);
        this.cp.a(this.cV);
        com.kwad.components.ad.i.b bVar = this.cp;
        FrameLayout frameLayout = this.de;
        com.kwad.components.ad.reward.j jVar2 = this.qS;
        bVar.a(frameLayout, jVar2.mRootContainer, adTemplate, jVar2.mApkDownloadHelper, jVar2.mScreenOrientation);
        this.cp.a((b.InterfaceC0353b) null);
        this.pB = this.qS.pB;
        com.kwad.components.ad.i.b bVar2 = this.pB;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        com.kwad.components.ad.i.b bVar3 = this.cp;
        if (bVar3 != null) {
            bVar3.a(this);
        }
        iS();
    }

    @Override // com.kwad.components.ad.i.b.a
    public final void iT() {
        hH();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.de = (FrameLayout) findViewById(R.id.ksad_web_card_container);
        this.vL = (FrameLayout) findViewById(R.id.ksad_play_again_web_card_container);
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        int i2;
        super.onUnbind();
        com.kwad.components.ad.i.b bVar = this.cp;
        if (bVar != null) {
            bVar.mf();
            this.cp.ko();
        }
        com.kwad.components.ad.reward.c.fD().b(this.mRewardVerifyListener);
        com.kwad.components.ad.i.b bVar2 = this.pB;
        if (bVar2 != null) {
            bVar2.mf();
            this.pB.ko();
            this.pB.a((b.a) null);
        }
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView == null || (i2 = this.tt) == Integer.MIN_VALUE) {
            return;
        }
        com.kwad.sdk.b.kwai.a.o(detailVideoView, i2);
    }
}
