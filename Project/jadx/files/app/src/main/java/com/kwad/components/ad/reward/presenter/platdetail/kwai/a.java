package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.k.o;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bk;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.core.webview.a.d.b, bk.a {
    private static final String[] vi = {"%ss后获得奖励1", "已获得奖励1/2", "已获得全部奖励"};
    private TextView gF;
    private bk gH;
    private boolean gI;
    private long gJ;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private TextView ve;
    private ImageView vf;
    private View vg;
    private boolean vh = false;
    private boolean vj = false;
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.gI) {
                return;
            }
            a.this.gH.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            if (j2 > 800) {
                a.this.a(com.kwad.sdk.core.response.a.a.Y(a.this.mAdInfo), j2);
                a.this.gJ = j2;
                a.a(a.this, true);
            }
        }
    };
    private final i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.2
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            long jA = com.kwad.components.ad.reward.j.a(j2, a.this.mAdInfo);
            a.this.gJ = j3;
            a.this.a(jA, j3);
        }
    };
    private final com.kwad.components.ad.reward.d.j mRewardVerifyListener = new com.kwad.components.ad.reward.d.j() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.3
        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            a.b(a.this, true);
            a.this.ve.setText(a.vi[2]);
        }
    };

    private void A(int i2) {
        this.qS.qe = i2;
        if (!com.kwad.components.ad.reward.j.r(this.mAdTemplate)) {
            this.gF.setText(String.valueOf(i2));
        } else {
            if (this.vj) {
                return;
            }
            this.ve.setText(String.format(vi[0], Integer.valueOf(i2)));
        }
    }

    static /* synthetic */ boolean a(a aVar, boolean z2) {
        aVar.gI = true;
        return true;
    }

    static /* synthetic */ boolean b(a aVar, boolean z2) {
        aVar.vj = true;
        return true;
    }

    private void cc() {
        this.mAdTemplate = this.qS.mAdTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        this.mApkDownloadHelper = this.qS.mApkDownloadHelper;
        long jA = com.kwad.components.ad.reward.j.a(com.kwad.sdk.core.response.a.a.G(this.mAdInfo), this.mAdInfo) / 1000;
        if (com.kwad.components.ad.reward.j.r(this.mAdTemplate)) {
            this.vg.setVisibility(0);
            this.vg.setOnClickListener(this);
            this.ve.setText(String.format(vi[0], Long.valueOf(jA)));
            this.gF.setVisibility(8);
        } else {
            this.vg.setVisibility(8);
            this.gF.setText(String.valueOf(jA));
            this.gF.setVisibility(0);
            this.gF.setAlpha(1.0f);
        }
        com.kwad.components.ad.reward.c.fD().a(this.mRewardVerifyListener);
        this.qS.pw.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }

    private void iA() {
        if (this.vh) {
            return;
        }
        this.vh = true;
        this.vf.setAlpha(0.0f);
        this.vf.setVisibility(0);
        this.vf.setOnClickListener(this);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                a.this.gF.setVisibility(8);
            }
        });
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.gF.setAlpha(1.0f - fFloatValue);
                a.this.vf.setAlpha(fFloatValue);
            }
        });
        valueAnimatorOfFloat.start();
    }

    private void iB() {
        com.kwad.components.ad.reward.d.d dVar = this.qS.mAdRewardStepListener;
        if (dVar != null) {
            dVar.fI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, 41, this.qS.mRootContainer.getTouchCoords(), this.qS.mReportExtData);
        this.qS.mAdOpenInteractionListener.bN();
    }

    private void notifyRewardVerify() {
        this.qS.mAdOpenInteractionListener.onRewardVerify();
    }

    public final void a(long j2, long j3) {
        com.kwad.components.ad.reward.i.kwai.a aVar;
        com.kwad.components.ad.reward.i.a.a aVar2;
        if (j3 < (j2 - 800) - ((long) ((com.kwad.sdk.core.response.a.a.aH(this.mAdInfo) && com.kwad.components.core.p.a.pJ().pK() == 0 ? com.kwad.sdk.core.response.a.a.aF(this.mAdInfo) : com.kwad.sdk.core.response.a.a.aD(this.mAdInfo)) * (this.qS.pQ ? 1000 : 0)))) {
            int i2 = (int) (((j2 - j3) / 1000.0f) + 0.5f);
            A(i2);
            o oVar = this.qS.pV;
            if (oVar != null) {
                oVar.W(i2);
                return;
            }
            return;
        }
        this.qS.pT = true;
        if (!com.kwad.components.ad.reward.j.r(this.mAdTemplate)) {
            notifyRewardVerify();
            iA();
            o oVar2 = this.qS.pV;
            if (oVar2 != null) {
                oVar2.W(0);
                return;
            }
            return;
        }
        if (!com.kwad.components.ad.reward.j.p(this.mAdTemplate) || (aVar2 = this.qS.qc) == null) {
            if (com.kwad.components.ad.reward.j.q(this.mAdTemplate) && (aVar = this.qS.qd) != null && !aVar.jO()) {
                this.qS.qd.jN();
            }
        } else if (!aVar2.jO()) {
            this.qS.qc.jN();
        }
        if (this.vj) {
            return;
        }
        this.ve.setText(vi[1]);
        iB();
    }

    @Override // com.kwad.sdk.utils.bk.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (this.qS.gp() || this.qS.go()) {
                this.gH.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.gJ += 500;
            a(com.kwad.sdk.core.response.a.a.Y(this.mAdInfo), this.gJ);
            this.gH.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.gH = new bk(this);
        if (com.kwad.components.ad.reward.j.b(this.qS)) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
            return;
        }
        cc();
        if (this.qS.pw.jY()) {
            A((int) (com.kwad.sdk.core.response.a.a.Y(this.mAdInfo) / 1000.0f));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.vf || view == this.vg) {
            com.kwad.components.core.d.b.a.a(new a.C0395a(view.getContext()).J(this.mAdTemplate).b(this.mApkDownloadHelper).ap(2).q(this.qS.pw.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.6
                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gF = (TextView) findViewById(R.id.ksad_video_count_down);
        this.vf = (ImageView) findViewById(R.id.ksad_detail_reward_icon);
        this.ve = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down);
        this.vg = findViewById(R.id.ksad_detail_reward_deep_task_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.c.fD().b(this.mRewardVerifyListener);
        this.qS.pw.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        com.kwad.components.core.webview.a.c.a.rE().b(this);
        this.vf.setVisibility(8);
        this.vg.setVisibility(8);
        this.vh = false;
        this.vj = false;
        this.gI = false;
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        if (com.kwad.components.core.webview.a.i.b("ksad-video-top-bar", this.qS.mAdTemplate).equals(str)) {
            cc();
        }
    }
}
