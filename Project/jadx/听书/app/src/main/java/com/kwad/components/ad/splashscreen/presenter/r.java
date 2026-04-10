package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import com.kwad.sdk.utils.ac;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends e {
    private com.kwad.sdk.core.download.a.a HF;

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.HF = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.r.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
            }

            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                super.onDownloadStarted();
                Context context = r.this.getContext();
                if (context != null) {
                    String strCF = com.kwad.sdk.utils.m.cF(context);
                    ac.Q(context, strCF != null ? strCF + ":已开始下载" : "已开始下载");
                }
            }
        };
        this.Gf.mApkDownloadHelper.b(this.HF);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        if (this.HF != null) {
            this.Gf.mApkDownloadHelper.c(this.HF);
        }
    }
}
