package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.i;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ah;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends com.kwad.components.ad.reward.presenter.a implements h, com.kwad.components.core.webview.a.d.b {
    private f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.e.1
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            e.this.iH();
        }
    };
    private View vu;
    private View vv;
    private ImageView vw;

    public e() {
        a(new com.kwad.components.ad.reward.presenter.platdetail.a());
        a(new com.kwad.components.ad.reward.presenter.c.a());
        a(new com.kwad.components.ad.reward.presenter.e.h());
    }

    private void bY() {
        this.vu.setVisibility(0);
        this.vv.setVisibility(8);
    }

    private void iG() {
        if (!this.qS.pP) {
            this.vv.setVisibility(8);
        }
        this.vu.setVisibility(0);
        Context context = getContext();
        if (j.q(this.qS.mAdTemplate) && ah.cu(context)) {
            this.vw.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, @Nullable l lVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        View view;
        int i2;
        super.ar();
        if (j.b(this.qS)) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
            i2 = 8;
            this.vu.setVisibility(8);
            view = this.vv;
        } else {
            view = this.vu;
            i2 = 0;
        }
        view.setVisibility(i2);
        this.qS.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.fz().a(this);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        iG();
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
        iH();
    }

    public final void iH() {
        if (this.qS.pP) {
            this.vu.setVisibility(8);
        } else {
            this.vu.setVisibility(8);
            this.vv.setVisibility(0);
        }
        Context context = getContext();
        if (j.q(this.qS.mAdTemplate) && ah.cu(context)) {
            this.vw.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vu = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.vv = findViewById(R.id.ksad_play_end_top_toolbar);
        this.vw = (ImageView) findViewById(R.id.ksad_blur_end_cover);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rE().b(this);
        iG();
        this.qS.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.fz().b(this);
        this.vv.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        if (i.b("ksad-video-top-bar", this.qS.mAdTemplate).equals(str)) {
            this.qS.qm = true;
            bY();
        }
    }
}
