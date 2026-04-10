package com.kwad.components.core.webview.a;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.a.a.k;
import com.kwad.components.core.webview.a.a.s;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.sdk.commercial.model.WebCloseStatus;

/* JADX INFO: loaded from: classes3.dex */
public interface h {
    FrameLayout getTKContainer();

    String getTkTemplateId();

    com.kwad.sdk.widget.e getTouchCoordsView();

    void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar);

    void onCloseTKDialogClick();

    void onGetContainerLimited(l.a aVar);

    void onRegisterLifecycleLisener(ae aeVar);

    void onRegisterVideoMuteStateListener(o oVar);

    void onRegisterVideoProgressListener(p pVar, com.kwad.components.core.video.i iVar);

    void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar);

    void onSkipClick(s sVar);

    void onTkLoadFailed();

    void onTkLoadSuccess();

    void onUpdateMuteStatus(k kVar);

    void pageClose(WebCloseStatus webCloseStatus);
}
