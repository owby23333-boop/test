package com.kwad.components.ad.splashscreen.b.a;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.ad.splashscreen.g;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.a.kwai.m;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.g.c;
import com.kwad.sdk.core.webview.b;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.splashscreen.b.b.a implements g, c {
    f Ej = new f() { // from class: com.kwad.components.ad.splashscreen.b.a.a.2
        @Override // com.kwad.components.ad.splashscreen.f
        public final void kK() {
            a.this.lC.setVisibility(8);
        }
    };
    private m En;
    private FrameLayout lC;
    private ae wD;

    @NonNull
    private com.kwad.components.core.webview.jshandler.g a(b bVar) {
        return new com.kwad.components.core.webview.jshandler.g(bVar, this.Cx.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.a.a.1
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar != null) {
                    a.this.Cx.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.a.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.Cx.kM();
                        }
                    });
                }
            }
        });
    }

    @NonNull
    private m lK() {
        this.En = new m();
        return this.En;
    }

    @Override // com.kwad.sdk.core.g.c
    public final void aS() {
        ae aeVar = this.wD;
        if (aeVar != null) {
            aeVar.rv();
        }
    }

    @Override // com.kwad.sdk.core.g.c
    public final void aT() {
        ae aeVar = this.wD;
        if (aeVar != null) {
            aeVar.rw();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aa(int i2) {
        m mVar = this.En;
        if (mVar != null) {
            mVar.aN(i2);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.Cx.BZ.a(this);
        this.Cx.a(this);
        this.Cx.a(this.Ej);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final FrameLayout getTKContainer() {
        return this.lC;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final String getTkTemplateId() {
        return i.b("ksad-splash-play-card", this.Cx.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kL() {
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lC = (FrameLayout) findViewById(R.id.splash_tk_play_card_view);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onGetContainerLimited(l.a aVar) {
        aVar.width = com.kwad.sdk.b.kwai.a.b(getContext(), this.Cx.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.b.kwai.a.b(getContext(), this.Cx.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.components.core.webview.a.h
    public final void onRegisterLifecycleLisener(ae aeVar) {
        super.onRegisterLifecycleLisener(aeVar);
        this.wD = aeVar;
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.components.core.webview.a.h
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(a(bVar));
        lVar.c(lK());
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onTkLoadFailed() {
        ae aeVar = this.wD;
        if (aeVar != null) {
            aeVar.rt();
            this.wD.ru();
        }
        this.lC.setVisibility(8);
        com.kwad.components.core.webview.a.c.a.rE().aJ(getTkTemplateId());
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onTkLoadSuccess() {
        ae aeVar = this.wD;
        if (aeVar != null) {
            aeVar.rr();
            this.wD.rs();
        }
        this.lC.setVisibility(0);
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        ae aeVar = this.wD;
        if (aeVar != null) {
            aeVar.rt();
            this.wD.ru();
        }
        super.onUnbind();
        this.Cx.BZ.b(this);
        this.Cx.b(this.Ej);
        this.Cx.b(this);
    }
}
