package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.core.webview.a.d.b {
    private TextView gL;
    private long gN;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.b.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            b.this.f(j2);
        }
    };
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.b.2
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            b.this.f(j3);
        }
    };

    private void cc() {
        com.kwad.components.ad.reward.j jVar = this.qS;
        this.mAdTemplate = jVar.mAdTemplate;
        this.mApkDownloadHelper = jVar.mApkDownloadHelper;
        this.gN = com.kwad.sdk.core.response.a.c.bN(this.mAdTemplate);
        this.qS.pw.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }

    private void cd() {
        if (this.gL.getVisibility() == 0) {
            return;
        }
        String strBO = com.kwad.sdk.core.response.a.c.bO(this.mAdTemplate);
        if (TextUtils.isEmpty(strBO)) {
            return;
        }
        this.gL.setText(strBO);
        this.gL.setVisibility(0);
        this.gL.setOnClickListener(this);
        ce();
    }

    private void ce() {
        com.kwad.sdk.core.report.a.b(this.mAdTemplate, 18, this.qS.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(long j2) {
        if (j2 >= this.gN) {
            cd();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (com.kwad.components.ad.reward.j.b(this.qS)) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
        } else {
            cc();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.gL) {
            this.qS.a(1, view.getContext(), 40, 1, this.qS.pw.getPlayDuration());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gL = (TextView) findViewById(R.id.ksad_detail_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rE().b(this);
        this.qS.pw.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.gL.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        if (com.kwad.components.core.webview.a.i.b("ksad-video-top-bar", this.qS.mAdTemplate).equals(str)) {
            cc();
        }
    }
}
