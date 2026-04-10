package com.kwad.components.ad.splashscreen.presenter;

import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends e implements com.kwad.sdk.widget.d {
    private View FU;
    private boolean FV;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.FU = findViewById(R.id.ksad_splash_actionbar_full_screen);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        if (this.Gf == null) {
            return;
        }
        this.FV = com.kwad.sdk.core.response.b.d.ea(this.Gf.mAdTemplate);
        boolean zN = com.kwad.components.ad.splashscreen.h.n(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate));
        this.FU.setVisibility(zN ? 0 : 8);
        if (zN) {
            new com.kwad.sdk.widget.h(this.FU.getContext(), this.FU, this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        this.Gf.c(1, view.getContext(), 53, 2);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        com.kwad.sdk.core.d.c.d("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.FV);
        if (this.FV) {
            this.Gf.c(1, view.getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT, 2);
        }
    }
}
