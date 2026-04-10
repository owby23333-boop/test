package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarH5;
import com.kwad.components.core.r.o;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.core.webview.a.d.b {

    @Nullable
    private ValueAnimator cZ;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private RewardActionBarControl pz;
    private KsLogoView sH;

    @Nullable
    private ViewGroup uA;

    @Nullable
    private ViewGroup uB;

    @Nullable
    private ViewGroup uC;
    private r uD;
    private boolean uE;
    private ActionBarAppLandscape uv;
    private ActionBarAppPortrait uw;
    private ActionBarH5 ux;
    private boolean uz;
    private boolean uy = false;
    private final AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.uE = true;
            if (!com.kwad.sdk.core.response.a.a.co(b.this.mAdInfo) || b.this.uC == null) {
                return;
            }
            b.this.uC.setVisibility(8);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            b.this.uE = false;
            if (!com.kwad.sdk.core.response.a.a.co(b.this.mAdInfo) || b.this.uC == null) {
                return;
            }
            b.this.uC.setVisibility(0);
        }
    };
    private RewardActionBarControl.b uF = new RewardActionBarControl.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.3
        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
        public final void a(boolean z2, a aVar) {
            b.this.uz = true;
            b.this.a(z2, aVar);
        }
    };
    private com.kwad.components.ad.reward.d.f uG = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.4
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            b.this.uz = false;
            b.this.Q(false);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(boolean z2) {
        View view;
        if (this.uy) {
            this.uy = false;
            this.sH.setVisibility(8);
            ViewGroup viewGroup = this.uA;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            ViewGroup viewGroup2 = this.uC;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            if (com.kwad.sdk.core.response.a.a.ay(this.mAdInfo)) {
                if (this.qS.mScreenOrientation == 1) {
                    if (z2) {
                        ip();
                        return;
                    } else {
                        iq();
                        return;
                    }
                }
                if (!z2) {
                    ActionBarAppPortrait actionBarAppPortrait = this.uw;
                    if (actionBarAppPortrait != null) {
                        actionBarAppPortrait.setVisibility(8);
                        return;
                    }
                    return;
                }
                view = this.uw;
                if (view == null) {
                    return;
                }
            } else {
                if (!z2) {
                    this.ux.setVisibility(8);
                    return;
                }
                view = this.ux;
            }
            g(view, com.kwad.sdk.b.kwai.a.a(getContext(), 90.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r5, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a r6) {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.a(boolean, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a):void");
    }

    private void aM() {
        ValueAnimator valueAnimator = this.cZ;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.cZ.cancel();
        }
    }

    private void b(boolean z2, a aVar) {
        in();
        this.uv.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppLandscape.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.6
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.a
            public final void R(boolean z3) {
                b.this.L(z3);
            }
        });
        if (z2) {
            f(this.uv, com.kwad.sdk.b.kwai.a.a(getContext(), 90.0f));
        } else {
            this.uv.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.uv, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void c(boolean z2, a aVar) {
        io();
        this.uw.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppPortrait.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.7
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.a
            public final void R(boolean z3) {
                b.this.L(z3);
            }
        });
        if (z2) {
            f(this.uw, com.kwad.sdk.b.kwai.a.a(getContext(), 90.0f));
        } else {
            this.uw.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.uw, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void cc() {
        this.mAdTemplate = this.qS.mAdTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.ci(this.mAdInfo)) {
            this.uA = (ViewGroup) findViewById(R.id.ksad_reward_jinniu_root);
        }
        this.sH.U(this.mAdTemplate);
        j jVar = this.qS;
        this.mApkDownloadHelper = jVar.mApkDownloadHelper;
        this.pz = jVar.pz;
        this.pz.a(this.uF);
        this.qS.b(this.uG);
    }

    private void d(boolean z2, a aVar) {
        this.ux.a(this.mAdTemplate, new ActionBarH5.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.8
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.a
            public final void R(boolean z3) {
                b.this.L(z3);
            }
        });
        if (z2) {
            f(this.ux, com.kwad.sdk.b.kwai.a.a(getContext(), 90.0f));
        } else {
            this.ux.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.ux, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void e(final View view, int i2) {
        aM();
        view.setVisibility(0);
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        this.cZ = o.c(view, i2, 0);
        this.cZ.setInterpolator(interpolatorCreate);
        this.cZ.setDuration(500L);
        this.cZ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.cZ.start();
    }

    @Deprecated
    private void f(final View view, int i2) {
        aM();
        view.setVisibility(0);
        this.cZ = o.b(view, 0, i2);
        this.cZ.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cZ.setDuration(500L);
        this.cZ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.cZ.start();
    }

    private void g(final View view, int i2) {
        aM();
        view.setVisibility(0);
        this.cZ = o.b(view, i2, 0);
        this.cZ.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cZ.setDuration(300L);
        this.cZ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        this.cZ.start();
    }

    private void in() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar_landscape);
        this.uv = (ActionBarAppLandscape) (viewStub != null ? viewStub.inflate() : findViewById(R.id.ksad_video_play_bar_app_landscape));
    }

    private void io() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar);
        this.uw = (ActionBarAppPortrait) (viewStub != null ? viewStub.inflate() : findViewById(R.id.ksad_video_play_bar_app_portrait));
    }

    private void ip() {
        io();
        f(this.uw, com.kwad.sdk.b.kwai.a.a(getContext(), 90.0f));
    }

    private void iq() {
        ActionBarAppPortrait actionBarAppPortrait = this.uw;
        if (actionBarAppPortrait != null) {
            actionBarAppPortrait.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (j.d(this.qS)) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
        } else {
            this.qS.pw.a(null, this.mAdLivePlayStateListener);
            cc();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sH = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
        this.ux = (ActionBarH5) findViewById(R.id.ksad_video_play_bar_h5);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.pz;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.b) null);
        }
        this.qS.pw.b(null, this.mAdLivePlayStateListener);
        com.kwad.components.core.webview.a.c.a.rE().b(this);
        this.qS.c(this.uG);
        aM();
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        if (i.b("ksad-video-bottom-card-v2", this.qS.mAdTemplate).equals(str)) {
            cc();
        }
    }
}
