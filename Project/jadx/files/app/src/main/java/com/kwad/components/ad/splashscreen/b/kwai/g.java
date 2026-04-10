package com.kwad.components.ad.splashscreen.b.kwai;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.utils.bg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends com.kwad.components.ad.splashscreen.b.b.a implements com.kwad.sdk.core.g.c {
    private FrameLayout lC;
    private ae wD;

    @NonNull
    private com.kwad.components.core.webview.jshandler.g a(com.kwad.sdk.core.webview.b bVar) {
        return new com.kwad.components.core.webview.jshandler.g(bVar, this.Cx.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.kwai.g.1
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar != null) {
                    g.this.Cx.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.kwai.g.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            g.this.Cx.kM();
                        }
                    });
                }
            }
        });
    }

    private void ad(int i2) {
        y.a aVar = new y.a();
        bg bgVar = this.Cx.mTimerHelper;
        if (bgVar != null) {
            aVar.duration = bgVar.getTime();
        }
        i iVarA = new i().bm(6).a(aVar);
        iVarA.bg(i2 == 2 ? 14 : 1);
        com.kwad.sdk.core.report.a.b(this.Cx.mAdTemplate, iVarA, (JSONObject) null);
    }

    private void lJ() {
        this.Cx.mRootContainer.findViewById(R.id.splash_play_card_view).setVisibility(8);
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

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.Cx.BZ.a(this);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final FrameLayout getTKContainer() {
        return this.lC;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final String getTkTemplateId() {
        return com.kwad.components.core.webview.a.i.b("ksad-splash-end-card", this.Cx.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lC = (FrameLayout) findViewById(R.id.splash_end_card_view);
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
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(a(bVar));
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onTkLoadFailed() {
        ae aeVar = this.wD;
        if (aeVar != null) {
            aeVar.rt();
            this.wD.ru();
        }
        lJ();
        this.lC.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onTkLoadSuccess() {
        ae aeVar = this.wD;
        if (aeVar != null) {
            aeVar.rr();
            this.wD.rs();
        }
        lJ();
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
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.components.core.webview.a.h
    public final void pageClose(WebCloseStatus webCloseStatus) {
        super.pageClose(webCloseStatus);
        ad(webCloseStatus.closeType);
        if (webCloseStatus.closeType == 2) {
            this.Cx.kT();
        } else {
            this.Cx.kQ();
        }
    }
}
