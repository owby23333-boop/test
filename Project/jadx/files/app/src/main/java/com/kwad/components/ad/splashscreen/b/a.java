package com.kwad.components.ad.splashscreen.b;

import android.view.View;
import com.kwad.sdk.R;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends e implements com.kwad.sdk.widget.c {
    private View Cm;
    private com.kwad.sdk.widget.f Cn;
    private boolean Co;

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        this.Cx.c(1, view.getContext(), 53, 2);
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.splashscreen.h hVar = this.Cx;
        if (hVar == null) {
            return;
        }
        this.Co = com.kwad.sdk.core.response.a.c.bQ(hVar.mAdTemplate);
        boolean zO = o.o(com.kwad.sdk.core.response.a.d.cb(this.Cx.mAdTemplate));
        this.Cm.setVisibility(zO ? 0 : 8);
        if (zO) {
            this.Cn = new com.kwad.sdk.widget.f(this.Cm.getContext(), this.Cm, this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        com.kwad.sdk.core.d.b.d("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.Co);
        if (this.Co) {
            this.Cx.c(1, view.getContext(), TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED, 2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Cm = findViewById(R.id.ksad_splash_actionbar_full_screen);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
