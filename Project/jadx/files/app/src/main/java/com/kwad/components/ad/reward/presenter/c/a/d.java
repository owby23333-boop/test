package com.kwad.components.ad.reward.presenter.c.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.d.j;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.webview.a.i;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, c, com.kwad.components.core.webview.a.d.b {
    private static final String[] vY = {"未获得奖励", "已获得奖励1/2", "已获得全部奖励"};
    private final j mRewardVerifyListener = new j() { // from class: com.kwad.components.ad.reward.presenter.c.a.d.1
        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (com.kwad.components.ad.reward.j.r(d.this.qS.mAdTemplate)) {
                d.this.iZ();
            }
        }
    };
    private ViewGroup vU;
    private ImageView vV;
    private ViewGroup vW;
    private TextView vX;

    private void cc() {
        com.kwad.components.ad.reward.c.fD().a(this.mRewardVerifyListener);
        this.vU.setVisibility(0);
        this.vW.setVisibility(com.kwad.components.ad.reward.j.r(this.qS.mAdTemplate) ? 0 : 8);
    }

    private void iY() {
        ImageView imageView = this.vV;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.vV.setOnClickListener(this);
        }
        ViewGroup viewGroup = this.vU;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
            this.vU.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iZ() {
        this.vX.setText(vY[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.components.ad.reward.j jVar = this.qS;
        com.kwad.sdk.core.report.a.a(jVar.mAdTemplate, 41, jVar.mRootContainer.getTouchCoords(), this.qS.mReportExtData);
        this.qS.mAdOpenInteractionListener.bN();
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (com.kwad.components.ad.reward.j.b(this.qS)) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
        } else {
            cc();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a.c
    public final void iW() {
        com.kwad.components.ad.reward.j jVar = this.qS;
        boolean z2 = jVar.pW;
        AdTemplate adTemplate = jVar.mAdTemplate;
        if (z2) {
            if (com.kwad.sdk.core.response.a.a.ak(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
                this.vW.setVisibility(8);
            }
        } else if (!com.kwad.components.ad.reward.j.p(adTemplate) && !com.kwad.components.ad.reward.j.q(this.qS.mAdTemplate)) {
            if (this.qS.mRewardVerifyCalled) {
                iY();
            }
        } else {
            com.kwad.components.ad.reward.j jVar2 = this.qS;
            if (jVar2.mRewardVerifyCalled) {
                return;
            }
            this.vX.setText(jVar2.pT ? vY[1] : vY[0]);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.vV || view == this.vU) {
            com.kwad.components.core.d.b.a.a(new a.C0395a(view.getContext()).J(this.qS.mAdTemplate).b(this.qS.mApkDownloadHelper).al(false).ap(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.c.a.d.2
                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    d.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vU = (ViewGroup) findViewById(R.id.ksad_end_reward_icon_layout);
        this.vV = (ImageView) findViewById(R.id.ksad_end_reward_icon);
        this.vW = (ViewGroup) findViewById(R.id.ksad_detail_reward_deep_task_view_playend);
        this.vX = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down_playend);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.c.fD().b(this.mRewardVerifyListener);
        com.kwad.components.core.webview.a.c.a.rE().b(this);
        this.vU.setVisibility(8);
        this.vV.setVisibility(8);
        this.vW.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        if (i.b("ksad-video-top-bar", this.qS.mAdTemplate).equals(str)) {
            cc();
        }
    }
}
