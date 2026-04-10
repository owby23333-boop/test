package com.kwad.components.ad.splashscreen.b.b;

import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.b.e;
import com.kwad.components.core.video.i;
import com.kwad.components.core.webview.a.a.k;
import com.kwad.components.core.webview.a.a.s;
import com.kwad.components.core.webview.a.g;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.webview.b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends e implements h {
    private g mTKLoadController;

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        this.mTKLoadController.bind(getActivity(), this.Cx.mAdTemplate, this);
    }

    @Override // com.kwad.components.core.webview.a.h
    public com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.Cx.mRootContainer;
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onCloseTKDialogClick() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        this.mTKLoadController = new g(getContext(), 600);
    }

    public void onRegisterLifecycleLisener(ae aeVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onRegisterVideoMuteStateListener(o oVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onRegisterVideoProgressListener(p pVar, i iVar) {
    }

    public void onRegisterWebCardHandler(l lVar, b bVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onSkipClick(s sVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.mTKLoadController.unBind();
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onUpdateMuteStatus(k kVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void pageClose(WebCloseStatus webCloseStatus) {
    }
}
