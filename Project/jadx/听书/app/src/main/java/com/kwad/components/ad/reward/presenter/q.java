package com.kwad.components.ad.reward.presenter;

import android.view.View;
import androidx.media3.common.C;
import com.kwad.components.ad.reward.widget.KsToastView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends b {
    private float vY;
    private r wa;
    private KsToastView wh;
    private Runnable wk;
    private boolean wi = false;
    private boolean wj = false;
    private boolean wl = false;
    private boolean wb = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.q.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            q.this.wh.setVisibility(8);
        }
    };

    static /* synthetic */ boolean a(q qVar, boolean z) {
        qVar.wl = true;
        return true;
    }

    public q(r rVar) {
        this.wa = rVar;
    }

    public final void iL() {
        if (this.wj) {
            return;
        }
        iI();
        this.wj = true;
        this.wh.setVisibility(0);
        this.wh.ai(3);
        iN();
        bw.a(this.wk, null, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    public final void iM() {
        this.wj = false;
        this.wh.setVisibility(8);
    }

    private synchronized void iI() {
        if (this.wb) {
            return;
        }
        com.kwad.sdk.core.adlog.c.d(this.tm.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().df(192).aw(this.tm.rE.getPlayDuration()));
        this.wb = true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vY = com.kwad.components.ad.reward.a.b.hF();
        this.wi = com.kwad.components.ad.reward.a.b.hG() && com.kwad.components.ad.reward.a.b.hH();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        if (this.wh == null) {
            KsToastView ksToastView = (KsToastView) findViewById(R.id.ksad_toast_view);
            this.wh = ksToastView;
            ksToastView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.presenter.q.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.a(q.this, true);
                    q.this.wh.setVisibility(8);
                    com.kwad.components.ad.reward.a.gg().a(PlayableSource.PENDANT_CLICK_AUTO);
                }
            });
        }
        this.tm.b(this.mPlayEndPageListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        iO();
        this.tm.c(this.mPlayEndPageListener);
    }

    private void iN() {
        this.wk = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.q.3
            @Override // java.lang.Runnable
            public final void run() {
                if (q.this.wl) {
                    return;
                }
                if (q.this.wh != null) {
                    q.this.wh.setVisibility(8);
                }
                com.kwad.components.ad.reward.a.gg().a(PlayableSource.PENDANT_AUTO);
            }
        };
    }

    private void iO() {
        bw.c(this.wk);
        this.wk = null;
    }
}
