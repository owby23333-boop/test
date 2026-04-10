package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"AppCompatCustomView"})
public class KsConvertButton extends KSCornerButton implements KsAppDownloadListener {

    @Nullable
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    public KsConvertButton(Context context) {
        super(context);
    }

    public KsConvertButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsConvertButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public KsConvertButton(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    private void aK(@Nullable String str) {
        if (str != null) {
            setText(str);
        }
    }

    @Nullable
    private String getAdActionDesc() {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            return com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        }
        return null;
    }

    public final void a(@Nullable com.kwad.components.core.d.b.c cVar, AdTemplate adTemplate) {
        this.mApkDownloadHelper = cVar;
        this.mAdTemplate = adTemplate;
        com.kwad.components.core.d.b.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            cVar2.b(this);
        }
        aK(getAdActionDesc());
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        aK(adTemplate != null ? com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        aK(getAdActionDesc());
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        aK(adTemplate != null ? com.kwad.sdk.core.response.a.a.U(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : "立即打开");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i2) {
        aK("下载中..." + i2 + "%");
    }
}
