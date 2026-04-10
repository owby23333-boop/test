package com.kwad.components.ad.fullscreen.b.b;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.e.c;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends c implements h {
    private FrameLayout ht;
    private final f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.fullscreen.b.b.a.1
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (com.kwad.sdk.core.response.a.a.am(d.cb(a.this.qS.mAdTemplate))) {
                a.this.ht.setVisibility(8);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, @Nullable l lVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (ck()) {
            this.ht.setVisibility(0);
            this.qS.b(this.mPlayEndPageListener);
            com.kwad.components.ad.reward.b.fz().a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        if (this.qS.pP) {
            this.ht.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
        AdInfo adInfoCb = d.cb(this.qS.mAdTemplate);
        if (!this.qS.pP || com.kwad.sdk.core.response.a.a.am(adInfoCb)) {
            return;
        }
        this.ht.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c
    public final boolean ck() {
        return j.c(this.qS) && !this.qS.pw.jY();
    }

    @Override // com.kwad.components.core.webview.a.h
    public final FrameLayout getTKContainer() {
        return this.ht;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final String getTkTemplateId() {
        return i.b("ksad-video-top-bar", this.qS.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ht = (FrameLayout) findViewById(R.id.ksad_js_top);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onGetContainerLimited(l.a aVar) {
        aVar.width = (int) ((com.kwad.sdk.b.kwai.a.getScreenWidth(getContext()) / com.kwad.sdk.b.kwai.a.aG(getContext())) + 0.5f);
        aVar.height = 44;
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        this.qS.pP = false;
        this.ht.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (ck()) {
            this.qS.c(this.mPlayEndPageListener);
            com.kwad.components.ad.reward.b.fz().b(this);
        }
    }
}
