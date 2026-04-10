package com.kwad.components.ad.reward.presenter.kwai;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.webview.a.a.k;
import com.kwad.components.core.webview.a.a.s;
import com.kwad.components.core.webview.a.g;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.widget.e;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements h {
    private FrameLayout lC;
    private AdInfo mAdInfo;
    private g mTKLoadController;
    private long ub;
    private long uc;
    private boolean ud;
    private boolean ue;
    private j.b uf = new j.b() { // from class: com.kwad.components.ad.reward.presenter.kwai.a.1
        @Override // com.kwad.components.ad.reward.j.b
        public final boolean interceptPlayCardResume() {
            return a.this.lC != null && a.this.lC.getVisibility() == 0;
        }
    };
    private final com.kwad.components.core.video.j mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.kwai.a.2
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            super.onVideoPlayProgress(j2, j3);
            long jA = j.a(j2, a.this.mAdInfo);
            if (j3 <= a.this.ub || jA - j3 <= a.this.uc || a.this.ud) {
                return;
            }
            a.a(a.this, true);
            a.this.mTKLoadController.bind(a.this.qS.getActivity(), a.this.qS.mAdTemplate, a.this);
        }
    };

    static /* synthetic */ boolean a(a aVar, boolean z2) {
        aVar.ud = true;
        return true;
    }

    private g ij() {
        return new g(-1L, getContext());
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (this.mTKLoadController == null) {
            this.mTKLoadController = ij();
        }
        this.mAdInfo = d.cb(this.qS.mAdTemplate);
        this.ub = ((long) com.kwad.sdk.core.response.a.a.aC(this.mAdInfo)) * 1000;
        this.uc = ((long) com.kwad.sdk.core.response.a.a.aD(this.mAdInfo)) * 1000;
        this.qS.pw.a(this.mVideoPlayStateListener, null);
        this.qS.a(this.uf);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final FrameLayout getTKContainer() {
        return this.lC;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final String getTkTemplateId() {
        b.d("TkRewardInteractPresenter", "getTkTemplateId: ");
        return i.b("ksad-video-interact-card", this.qS.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final e getTouchCoordsView() {
        return this.qS.mRootContainer;
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
        this.lC = (FrameLayout) findViewById(R.id.ksad_js_interact);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onGetContainerLimited(l.a aVar) {
        float fAG = com.kwad.sdk.b.kwai.a.aG(getContext());
        aVar.width = (int) ((bc.getScreenWidth(getContext()) / fAG) + 0.5f);
        aVar.height = (int) ((bc.getScreenHeight(getContext()) / fAG) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onRegisterLifecycleLisener(ae aeVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onRegisterVideoMuteStateListener(o oVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onRegisterVideoProgressListener(p pVar, com.kwad.components.core.video.i iVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onSkipClick(s sVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onTkLoadFailed() {
        b.d("TkRewardInteractPresenter", "onTkLoadFailed: ");
        this.lC.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onTkLoadSuccess() {
        b.d("TkRewardInteractPresenter", "onTkLoadSuccess: ");
        if (ah.cu(getContext())) {
            this.lC.setVisibility(0);
            com.kwad.components.ad.reward.c.a.R(this.qS.mContext);
            this.qS.pw.ka().pause();
            this.ue = true;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qS.pw.b(this.mVideoPlayStateListener, null);
        this.qS.b(this.uf);
        this.mTKLoadController.unBind();
        this.mTKLoadController = null;
        this.lC.setVisibility(8);
        this.ud = false;
        this.ue = false;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onUpdateMuteStatus(k kVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void pageClose(WebCloseStatus webCloseStatus) {
        this.qS.pQ = webCloseStatus != null && webCloseStatus.interactSuccess;
        j jVar = this.qS;
        if (jVar.pQ) {
            jVar.pw.ka().jW();
        }
        if (this.ue && com.kwad.sdk.b.kwai.a.m(this.lC, 30)) {
            this.qS.pw.resume();
        }
        this.lC.setVisibility(8);
    }
}
