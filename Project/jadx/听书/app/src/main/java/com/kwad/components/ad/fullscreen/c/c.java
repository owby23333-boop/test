package com.kwad.components.ad.fullscreen.c;

import android.view.View;
import com.kwad.components.ad.fullscreen.c.a.e;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements j {
    private View jS;
    private View jT;
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.c.c.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            c.this.j(false);
        }
    };

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, n nVar) {
    }

    public c() {
        a(new e());
        a(new com.kwad.components.ad.fullscreen.c.b.a());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jS = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.jT = findViewById(R.id.ksad_play_end_top_toolbar);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.tm.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gg().a(this);
        this.jS.setVisibility(0);
        this.jT.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gg().b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z) {
        if ((this.tm.rU || this.tm.rT) && !z) {
            this.jS.setVisibility(8);
            this.jT.setVisibility(8);
        } else {
            this.jS.setVisibility(8);
            this.jT.setVisibility(0);
        }
    }

    private void dj() {
        if (this.tm.rU || this.tm.rT) {
            return;
        }
        this.jS.setVisibility(0);
        this.jT.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dk() {
        dj();
        if (this.tm.rT && this.jT.getVisibility() == 0) {
            this.jT.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dl() {
        j(true);
    }
}
