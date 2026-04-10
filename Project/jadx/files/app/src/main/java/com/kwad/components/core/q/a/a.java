package com.kwad.components.core.q.a;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.l.d;
import com.kwad.components.core.q.kwai.b;
import com.kwad.components.core.video.i;
import com.kwad.components.core.webview.a.a.k;
import com.kwad.components.core.webview.a.a.s;
import com.kwad.components.core.webview.a.g;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.widget.e;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends Presenter implements h {
    private FrameLayout PC;
    private ae PD;
    protected boolean PE;
    protected b PF;
    private com.kwad.components.core.j.kwai.a PG = new com.kwad.components.core.j.kwai.a() { // from class: com.kwad.components.core.q.a.a.1
        @Override // com.kwad.components.core.j.kwai.a
        public final void a(d dVar) {
            a.this.pV();
        }

        @Override // com.kwad.components.core.j.kwai.a
        public final void b(d dVar) {
            a.this.pW();
        }

        @Override // com.kwad.components.core.j.kwai.a
        public final void c(d dVar) {
            a.this.pX();
        }

        @Override // com.kwad.components.core.j.kwai.a
        public final void gq() {
        }
    };
    private g mTKLoadController;

    private void pU() {
        ae aeVar = this.PD;
        if (aeVar == null) {
            return;
        }
        if (this.PE) {
            aeVar.rv();
            return;
        }
        aeVar.rr();
        this.PD.rs();
        this.PE = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV() {
        pU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pW() {
        ae aeVar = this.PD;
        if (aeVar == null || !this.PE) {
            return;
        }
        aeVar.rw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX() {
        ae aeVar = this.PD;
        if (aeVar == null || !this.PE) {
            return;
        }
        aeVar.rt();
        this.PD.ru();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.PF = (b) Bs();
        this.PC = (FrameLayout) findViewById(R.id.ksad_js_container);
        this.mTKLoadController = new g(getContext(), 1000);
        this.mTKLoadController.setStyleTemplate(this.PF.mStyleTemplate);
        com.kwad.sdk.components.h hVar = this.PF.Pw;
        if (hVar != null) {
            hVar.a(this.mTKLoadController);
            this.mTKLoadController.setTKBridgeHandler(new com.kwad.sdk.core.webview.b.g() { // from class: com.kwad.components.core.q.a.a.2
                @Override // com.kwad.sdk.core.webview.b.g
                public final void callTKBridge(String str) {
                    com.kwad.sdk.components.h hVar2 = a.this.PF.Pw;
                    if (hVar2 != null) {
                        hVar2.callTKBridge(str);
                    }
                }
            });
            this.mTKLoadController.addCustomEnv("hasTKBridge", Boolean.TRUE);
        }
        this.mTKLoadController.bind(getActivity(), this.PF.mAdTemplate, this);
        this.PF.Kg.add(this.PG);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final FrameLayout getTKContainer() {
        return this.PC;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final String getTkTemplateId() {
        return this.PF.mStyleTemplate.templateId;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final e getTouchCoordsView() {
        return this.PF.mRootContainer;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onCloseTKDialogClick() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onGetContainerLimited(l.a aVar) {
        float fAG = com.kwad.sdk.b.kwai.a.aG(getContext());
        aVar.width = (int) ((bc.getScreenWidth(getContext()) / fAG) + 0.5f);
        aVar.height = (int) ((bc.getScreenHeight(getContext()) / fAG) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onRegisterLifecycleLisener(ae aeVar) {
        this.PD = aeVar;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onRegisterVideoMuteStateListener(o oVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onRegisterVideoProgressListener(p pVar, i iVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onSkipClick(s sVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onTkLoadFailed() {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onTkLoadSuccess() {
        pU();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        pX();
        this.mTKLoadController.unBind();
        this.PF.Kg.remove(this.PG);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onUpdateMuteStatus(k kVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void pageClose(WebCloseStatus webCloseStatus) {
        getActivity().finish();
    }
}
