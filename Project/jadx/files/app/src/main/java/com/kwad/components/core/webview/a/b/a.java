package com.kwad.components.core.webview.a.b;

import androidx.annotation.Nullable;
import com.kwad.components.core.video.i;
import com.kwad.components.core.webview.a.a.k;
import com.kwad.components.core.webview.a.a.s;
import com.kwad.components.core.webview.a.g;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.e;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends Presenter implements h {
    protected b Vi;
    protected g mTKLoadController;

    protected void a(b bVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        this.Vi = (b) Bs();
        a(this.Vi);
        if (this.mTKLoadController == null) {
            this.mTKLoadController = ij();
        }
        StyleTemplate styleTemplate = this.Vi.mStyleTemplate;
        if (styleTemplate != null) {
            this.mTKLoadController.setStyleTemplate(styleTemplate);
        }
        g gVar = this.mTKLoadController;
        b bVar = this.Vi;
        gVar.bind(bVar.mActivity, bVar.mAdTemplate, this);
    }

    @Override // com.kwad.components.core.webview.a.h
    public e getTouchCoordsView() {
        return this.Vi.Vj;
    }

    protected g ij() {
        return new g(this.Vi.mPlayedDuration, getContext());
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onCloseTKDialogClick() {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onRegisterVideoMuteStateListener(o oVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onRegisterVideoProgressListener(p pVar, i iVar) {
    }

    public void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onSkipClick(s sVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mTKLoadController.unBind();
        this.mTKLoadController = null;
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onUpdateMuteStatus(k kVar) {
    }

    public void pageClose(WebCloseStatus webCloseStatus) {
        d dVar = this.Vi.mTkDialogFragment;
        if (dVar != null) {
            dVar.dismiss();
        }
    }
}
