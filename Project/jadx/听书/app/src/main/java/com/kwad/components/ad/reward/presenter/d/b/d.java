package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private static final String[] zr = {"未获得奖励", "已获得奖励1/2", "已获得全部奖励"};
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (g.P(d.this.tm.mAdTemplate)) {
                d.this.jR();
            }
        }
    };
    private ViewGroup zn;
    private ImageView zo;
    private ViewGroup zp;
    private TextView zq;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.zn = (ViewGroup) findViewById(R.id.ksad_end_reward_icon_layout);
        this.zo = (ImageView) findViewById(R.id.ksad_end_reward_icon);
        this.zp = (ViewGroup) findViewById(R.id.ksad_detail_reward_deep_task_view_playend);
        this.zq = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down_playend);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        dm();
    }

    private void dm() {
        com.kwad.components.ad.reward.b.gk().a(this.mRewardVerifyListener);
        this.zn.setVisibility(0);
        this.zp.setVisibility(g.P(this.tm.mAdTemplate) ? 0 : 8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.gk().b(this.mRewardVerifyListener);
        this.zn.setVisibility(8);
        this.zo.setVisibility(8);
        this.zp.setVisibility(8);
    }

    private void jQ() {
        ImageView imageView = this.zo;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.zo.setOnClickListener(this);
        }
        ViewGroup viewGroup = this.zn;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
            this.zn.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jR() {
        this.zq.setText(zr[2]);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.zo || view == this.zn) {
            com.kwad.components.core.e.d.a.a(new a.C0333a(view.getContext()).aB(this.tm.mAdTemplate).b(this.tm.mApkDownloadHelper).aq(false).aB(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    d.this.notifyAdClick();
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.components.ad.reward.j.b.a(this.tm.mAdTemplate, (String) null, (String) null, new com.kwad.sdk.core.adlog.c.b().f(this.tm.mRootContainer.getTouchCoords()).dd(41), this.tm.mReportExtData);
        this.tm.rD.cW();
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void jO() {
        if (this.tm.sf) {
            if (com.kwad.sdk.core.response.b.a.as(e.el(this.tm.mAdTemplate))) {
                this.zp.setVisibility(8);
            }
        } else if (g.N(this.tm.mAdTemplate) || g.O(this.tm.mAdTemplate)) {
            if (this.tm.gW()) {
                return;
            }
            this.zq.setText(this.tm.rY ? zr[1] : zr[0]);
        } else if (this.tm.gW()) {
            jQ();
        }
    }
}
