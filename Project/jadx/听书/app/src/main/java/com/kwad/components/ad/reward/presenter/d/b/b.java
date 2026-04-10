package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private View zj;
    private boolean zk;
    private final Runnable zl = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.d.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.getActivity() == null || b.this.getActivity().isFinishing()) {
                return;
            }
            b.this.jP();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        View viewFindViewById = findViewById(R.id.ksad_end_close_btn);
        this.zj = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.zk = com.kwad.sdk.core.response.b.b.el(e.el(this.tm.mAdTemplate));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.zj.setVisibility(8);
        bw.c(this.zl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jP() {
        com.kwad.sdk.core.d.c.d("RewardPlayEndCloseBtn", "showPageCloseBtn mPlayEndH5ShowSuccess: " + this.tm.sw + ", needHideCloseButton: " + this.zk);
        if (this.tm.sw && this.zk) {
            return;
        }
        this.zj.setVisibility(0);
        this.zj.setAlpha(0.0f);
        this.zj.animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.zj) {
            PlayableSource playableSourceGP = this.tm.gP();
            if (playableSourceGP != null && (playableSourceGP.equals(PlayableSource.PENDANT_CLICK_NOT_AUTO) || playableSourceGP.equals(PlayableSource.PENDANT_CLICK_AUTO) || playableSourceGP.equals(PlayableSource.PENDANT_AUTO) || playableSourceGP.equals(PlayableSource.ACTIONBAR_CLICK))) {
                com.kwad.components.ad.reward.a.gg().gh();
            } else {
                f.v(this.tm);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void jO() {
        if (this.tm.sf) {
            return;
        }
        long j = this.tm.sq;
        if (j == 0) {
            this.zl.run();
        } else {
            bw.runOnUiThreadDelay(this.zl, j);
        }
    }
}
