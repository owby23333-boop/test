package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes4.dex */
public class KsConvertButton extends KSCornerButton implements KsAppDownloadListener {
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    public KsConvertButton(Context context) {
        super(context);
    }

    public KsConvertButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsConvertButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public KsConvertButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public final void a(com.kwad.components.core.e.d.c cVar, AdTemplate adTemplate) {
        this.mApkDownloadHelper = cVar;
        this.mAdTemplate = adTemplate;
        if (cVar != null) {
            cVar.b(this);
        }
        bj(getAdActionDesc());
    }

    private String getAdActionDesc() {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            return com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(adTemplate));
        }
        return null;
    }

    private void bj(String str) {
        if (str != null) {
            setText(str);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        bj(getAdActionDesc());
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        bj("下载中..." + i + "%");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        bj(adTemplate != null ? com.kwad.sdk.core.response.b.a.ac(com.kwad.sdk.core.response.b.e.el(adTemplate)) : "立即打开");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        bj(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(adTemplate)) : "立即下载");
    }
}
