package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ca;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, ca.a {
    private static final String[] yB = {"%ss后获得奖励1", "已获得奖励1/2", "已获得全部奖励"};
    private ca bQ;
    private TextView jV;
    private boolean jX;
    private long jY;
    private AdInfo mAdInfo;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private TextView yx;
    private ImageView yy;
    private View yz;
    private boolean yA = false;
    private boolean yC = false;
    private boolean yD = false;
    private final m jE = new m() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            long jA = g.a(j, a.this.mAdInfo);
            a.this.jY = j2;
            a.this.a(jA, j2);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.h
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.jX) {
                return;
            }
            a.this.bQ.sendEmptyMessageDelayed(1, 500L);
        }
    };
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.2
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            a.a(a.this, true);
            a.this.yx.setText(a.yB[2]);
        }
    };

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.yC = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jV = (TextView) findViewById(R.id.ksad_video_count_down);
        this.yy = (ImageView) findViewById(R.id.ksad_detail_reward_icon);
        this.yx = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down);
        this.yz = findViewById(R.id.ksad_detail_reward_deep_task_view);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.bQ = new ca(this);
        dm();
        if (this.tm.rE.kW()) {
            G((int) (com.kwad.sdk.core.response.b.a.ag(this.mAdInfo) / 1000.0f));
        }
    }

    private void dm() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        this.mApkDownloadHelper = this.tm.mApkDownloadHelper;
        long jA = g.a(com.kwad.sdk.core.response.b.a.M(this.mAdInfo), this.mAdInfo) / 1000;
        if (g.P(this.mAdTemplate)) {
            this.yz.setVisibility(0);
            this.yz.setOnClickListener(this);
            this.yx.setText(String.format(yB[0], Long.valueOf(jA)));
            this.jV.setVisibility(8);
        } else {
            this.yz.setVisibility(8);
            this.jV.setText(String.valueOf(jA));
            this.jV.setVisibility(0);
            this.jV.setAlpha(1.0f);
        }
        com.kwad.components.ad.reward.b.gk().a(this.mRewardVerifyListener);
        this.tm.rE.a(this.jE);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.gk().b(this.mRewardVerifyListener);
        this.tm.rE.b(this.jE);
        this.yy.setVisibility(8);
        this.yz.setVisibility(8);
        this.yA = false;
        this.yC = false;
        this.jX = false;
    }

    public final void a(long j, long j2) {
        int iAK;
        if (com.kwad.sdk.core.response.b.a.aO(this.mAdInfo) && com.kwad.components.core.r.a.sF().sG() == 0) {
            iAK = com.kwad.sdk.core.response.b.a.aM(this.mAdInfo);
        } else {
            iAK = com.kwad.sdk.core.response.b.a.aK(this.mAdInfo);
        }
        long j3 = iAK * (this.tm.rV ? 1000 : 0);
        com.kwad.components.ad.reward.m.b(this.tm, j2, j, j3);
        if (!this.yD) {
            this.yD = k.a(this.tm, j2, j, j3);
        }
        a(j2, j, j3);
    }

    private void a(long j, long j2, long j3) {
        if (j < (j2 - 800) - j3) {
            int iFloor = (int) Math.floor((j2 - j) / 1000.0f);
            int i = iFloor > 0 ? iFloor : 1;
            G(i);
            if (this.tm.se != null) {
                this.tm.se.ah(i);
                return;
            }
            return;
        }
        this.tm.rY = true;
        if (g.P(this.mAdTemplate)) {
            if (g.N(this.mAdTemplate) && this.tm.sm != null) {
                if (!this.tm.sm.kL()) {
                    this.tm.sm.kK();
                }
            } else if (g.O(this.mAdTemplate) && this.tm.sn != null && !this.tm.sn.kL()) {
                this.tm.sn.kK();
            }
            if (this.yC) {
                return;
            }
            this.yx.setText(yB[1]);
            jw();
            return;
        }
        notifyRewardVerify();
        jv();
        if (this.tm.se != null) {
            this.tm.se.ah(0);
        }
    }

    private void G(int i) {
        this.tm.so = i;
        if (g.P(this.mAdTemplate)) {
            if (this.yC) {
                return;
            }
            this.yx.setText(String.format(yB[0], Integer.valueOf(i)));
            return;
        }
        this.jV.setText(String.valueOf(i));
    }

    private void jv() {
        if (this.yA) {
            return;
        }
        this.yA = true;
        this.yy.setAlpha(0.0f);
        this.yy.setVisibility(0);
        this.yy.setOnClickListener(this);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                a.this.jV.setVisibility(8);
            }
        });
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.jV.setAlpha(1.0f - fFloatValue);
                a.this.yy.setAlpha(fFloatValue);
            }
        });
        valueAnimatorOfFloat.start();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.yy || view == this.yz) {
            com.kwad.components.core.e.d.a.a(new a.C0333a(view.getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aB(2).A(this.tm.rE.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.5
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    private void notifyRewardVerify() {
        this.tm.rD.onRewardVerify();
    }

    private void jw() {
        if (this.tm.mAdRewardStepListener != null) {
            this.tm.mAdRewardStepListener.gp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", "playTopBar-style1", new com.kwad.sdk.core.adlog.c.b().f(this.tm.mRootContainer.getTouchCoords()).dd(41), this.tm.mReportExtData);
        this.tm.rD.cW();
    }

    @Override // com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (this.tm.gV() || this.tm.gU()) {
                this.bQ.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.jY += 500;
            a(com.kwad.sdk.core.response.b.a.ag(this.mAdInfo), this.jY);
            this.bQ.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
