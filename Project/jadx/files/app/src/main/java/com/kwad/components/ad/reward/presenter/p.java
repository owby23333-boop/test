package com.kwad.components.ad.reward.presenter;

import android.view.View;
import com.kwad.components.ad.reward.widget.KsToastView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends a {
    private float sQ;
    private q sS;
    private KsToastView sZ;
    private Runnable tc;
    private boolean ta = false;
    private boolean tb = false;
    private boolean td = false;
    private boolean sT = false;
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.p.1
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            p.this.sZ.setVisibility(8);
        }
    };

    public p(q qVar) {
        this.sS = qVar;
    }

    static /* synthetic */ boolean a(p pVar, boolean z2) {
        pVar.td = true;
        return true;
    }

    private synchronized void hQ() {
        if (this.sT) {
            return;
        }
        com.kwad.sdk.core.report.a.d(this.qS.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.i().bh(192).R(this.qS.pw.getPlayDuration()));
        this.sT = true;
    }

    private void hV() {
        this.tc = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.p.3
            @Override // java.lang.Runnable
            public final void run() {
                if (p.this.td) {
                    return;
                }
                if (p.this.sZ != null) {
                    p.this.sZ.setVisibility(8);
                }
                com.kwad.components.ad.reward.b.fz().a(PlayableSource.PENDANT_AUTO);
            }
        };
    }

    private void hW() {
        bh.b(this.tc);
        this.tc = null;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qS.b(this.mPlayEndPageListener);
    }

    public final void hT() {
        if (this.tb) {
            return;
        }
        hQ();
        this.tb = true;
        this.sZ.setVisibility(0);
        this.sZ.Y(3);
        hV();
        bh.a(this.tc, null, com.anythink.expressad.video.module.a.a.m.ag);
    }

    public final void hU() {
        this.tb = false;
        this.sZ.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sZ = (KsToastView) findViewById(R.id.ksad_toast_view);
        this.sZ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.presenter.p.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.a(p.this, true);
                p.this.sZ.setVisibility(8);
                com.kwad.components.ad.reward.b.fz().a(PlayableSource.PENDANT_CLICK_AUTO);
            }
        });
        this.sQ = com.kwad.components.ad.reward.kwai.b.gU();
        this.ta = com.kwad.components.ad.reward.kwai.b.gV() && com.kwad.components.ad.reward.kwai.b.gW();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        hW();
        this.qS.c(this.mPlayEndPageListener);
    }
}
