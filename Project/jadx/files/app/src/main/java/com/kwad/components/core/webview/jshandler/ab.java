package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ab implements com.kwad.sdk.core.webview.b.a {

    @Nullable
    private KsAppDownloadListener RS;

    @Nullable
    private com.kwad.sdk.core.webview.b.c RZ;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private final com.kwad.sdk.core.webview.b mJsBridgeContext;

    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public double TE;
        public int status;
    }

    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public String SZ;
        public long TM;
        public String Tb;
        public String appName;
        public String icon;
        public String qM;
        public String url;
        public String version;
        public int versionCode;
    }

    public ab(com.kwad.sdk.core.webview.b bVar) {
        this.mJsBridgeContext = bVar;
        try {
            this.mAdTemplate = new AdTemplate();
            AdTemplate adTemplate = this.mJsBridgeContext.getAdTemplate();
            if (adTemplate != null) {
                if (adTemplate.mOriginJString != null) {
                    this.mAdTemplate.parseJson(new JSONObject(adTemplate.mOriginJString));
                } else {
                    this.mAdTemplate.parseJson(adTemplate.toJson());
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2) {
        if (this.RZ != null) {
            a aVar = new a();
            aVar.TE = f2;
            aVar.status = i2;
            this.RZ.a(aVar);
        }
    }

    private static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = bVar.SZ;
        adBaseInfo.appName = bVar.appName;
        adBaseInfo.appVersion = bVar.version;
        adBaseInfo.packageSize = bVar.TM;
        adBaseInfo.appIconUrl = bVar.icon;
        adBaseInfo.appDescription = bVar.qM;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.appDownloadUrl = bVar.url;
        adInfo.downloadId = com.kwad.sdk.utils.ac.el(adConversionInfo.appDownloadUrl);
    }

    private KsAppDownloadListener rm() {
        return new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.webview.jshandler.ab.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                ab.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                ab.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                ab.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                ab.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                ab.this.a(3, (i2 * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                ab.this.a(2, (i2 * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.d.b.c cVar2;
        int i2;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        if (com.kwad.sdk.core.response.a.a.ay(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i2 = 2;
        } else {
            AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
            a(adInfoCb, bVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i2 = 1;
        }
        cVar2.as(i2);
        this.RZ = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.RS;
        if (ksAppDownloadListener != null) {
            this.mApkDownloadHelper.d(ksAppDownloadListener);
        } else {
            this.RS = rm();
            this.mApkDownloadHelper.b(this.RS);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerApkStatusListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.RZ = null;
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.RS) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
        this.RS = null;
    }
}
