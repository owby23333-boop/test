package com.kwad.sdk.core.download.a;

import com.kwad.sdk.api.KsAppDownloadListener;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements KsAppDownloadListener {
    public String downloadId;

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    public void onPaused(int i) {
    }

    public a() {
    }

    public a(String str) {
        this.downloadId = str;
    }

    public final String pC() {
        return this.downloadId;
    }
}
