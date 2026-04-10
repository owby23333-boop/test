package com.kwad.components.ad.reward.presenter.c.a;

import android.view.View;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.i;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, c, com.kwad.components.core.webview.a.d.b {
    private View vQ;
    private boolean vR;
    private final Runnable vS = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.b.1
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.getActivity() == null || b.this.getActivity().isFinishing()) {
                return;
            }
            b.this.iX();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void iX() {
        com.kwad.sdk.core.d.b.d("RewardPlayEndCloseBtn", "showPageCloseBtn mPlayEndH5ShowSuccess: " + this.qS.qn + ", needHideCloseButton: " + this.vR);
        if (this.qS.qn && this.vR) {
            return;
        }
        this.vQ.setVisibility(0);
        this.vQ.setAlpha(0.0f);
        this.vQ.animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.vR = com.kwad.sdk.core.response.a.b.dn(com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate));
        if (j.b(this.qS)) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a.c
    public final void iW() {
        j jVar = this.qS;
        if (jVar.pW) {
            return;
        }
        long j2 = jVar.qg;
        if (j2 == 0) {
            this.vS.run();
        } else {
            bh.runOnUiThreadDelay(this.vS, j2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.vQ) {
            PlayableSource playableSourceGh = this.qS.gh();
            if (playableSourceGh != null && (playableSourceGh.equals(PlayableSource.PENDANT_CLICK_NOT_AUTO) || playableSourceGh.equals(PlayableSource.PENDANT_CLICK_AUTO) || playableSourceGh.equals(PlayableSource.PENDANT_AUTO) || playableSourceGh.equals(PlayableSource.ACTIONBAR_CLICK))) {
                com.kwad.components.ad.reward.b.fz().fA();
            } else {
                j jVar = this.qS;
                e.a(jVar, jVar.gk(), false);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vQ = findViewById(R.id.ksad_end_close_btn);
        this.vQ.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vQ.setVisibility(8);
        bh.b(this.vS);
        com.kwad.components.core.webview.a.c.a.rE().b(this);
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        i.b("ksad-video-top-bar", this.qS.mAdTemplate).equals(str);
    }
}
