package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.b;

/* JADX INFO: loaded from: classes3.dex */
public class GlobalImageListener implements OnRenderResultListener<AdTemplate> {
    @Override // com.kwad.sdk.core.imageloader.OnRenderResultListener
    public void onRenderResult(boolean z2, AdTemplate adTemplate, String str, String str2) {
        if (!z2) {
            ((b) ServiceProvider.get(b.class)).n(str, str2);
        }
        if (z2) {
            return;
        }
        ((b) ServiceProvider.get(b.class)).Y(adTemplate);
    }
}
