package com.kwad.components.ad.fullscreen.b;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.fullscreen.b.kwai.e;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.i;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements h, com.kwad.components.core.webview.a.d.b {
    private View gC;
    private View gD;
    private f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.fullscreen.b.c.1
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            c.this.i(false);
        }
    };

    public c() {
        a(new e());
        a(new com.kwad.components.ad.fullscreen.b.a.a());
        a(new com.kwad.components.ad.fullscreen.b.b.a());
    }

    private void bY() {
        this.gC.setVisibility(0);
        this.gD.setVisibility(8);
    }

    private void bZ() {
        j jVar = this.qS;
        if (jVar.pP || jVar.pO) {
            return;
        }
        this.gC.setVisibility(0);
        this.gD.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z2) {
        j jVar = this.qS;
        if ((jVar.pP || jVar.pO) && !z2) {
            this.gC.setVisibility(8);
            this.gD.setVisibility(8);
        } else {
            this.gC.setVisibility(8);
            this.gD.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, @Nullable l lVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        int i2;
        View view;
        super.ar();
        this.qS.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.fz().a(this);
        if (j.c(this.qS) || j.a(this.qS)) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
            i2 = 8;
            this.gC.setVisibility(8);
            view = this.gD;
        } else {
            view = this.gC;
            i2 = 0;
        }
        view.setVisibility(i2);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        bZ();
        if (this.qS.pO && this.gD.getVisibility() == 0) {
            this.gD.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
        i(true);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gC = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.gD = findViewById(R.id.ksad_play_end_top_toolbar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rE().b(this);
        this.qS.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.fz().b(this);
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        if (i.b("ksad-video-top-bar", this.qS.mAdTemplate).equals(str) || i.b("ksad-fullscreen-video-card", this.qS.mAdTemplate).equals(str)) {
            bY();
        }
    }
}
