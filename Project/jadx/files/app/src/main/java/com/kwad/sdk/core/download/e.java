package com.kwad.sdk.core.download;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public class e implements d {
    private AdInfo mAdInfo;

    public e(AdTemplate adTemplate) {
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, int i2, int i3, int i4) {
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i2, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, int i2, String str2, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, String str2, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void an(String str) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void b(String str, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void c(String str, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void d(String str, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void e(String str, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final String nx() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.d
    public final String ny() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }
}
