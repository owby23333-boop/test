package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class aj implements com.kwad.sdk.core.webview.c.a {
    private final Handler acR = new Handler(Looper.getMainLooper());
    private final com.kwad.sdk.core.webview.b acw;
    private final AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int adr;
        public String ads;
        public String adt;

        @Deprecated
        public boolean adu;
        public boolean adv;
        public boolean adw;
        public String appId;
        public String appName;
        public String icon;
        public String md5;
        public String pkgName;
        public String sX;
        public int type;
        public String url;
        public String version;
        public int versionCode;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "handleAdUrl";
    }

    public aj(com.kwad.sdk.core.webview.b bVar) {
        this.acw = bVar;
        AdTemplate adTemplate = new AdTemplate();
        this.mAdTemplate = adTemplate;
        try {
            AdTemplate adTemplate2 = bVar.getAdTemplate();
            if (adTemplate2 != null) {
                if (adTemplate2.mOriginJString != null) {
                    adTemplate.parseJson(new JSONObject(adTemplate2.mOriginJString));
                } else {
                    adTemplate.parseJson(adTemplate2.toJson());
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aG(2);
        } else {
            AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
            a(adInfoEl, aVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aG(1);
        }
        this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.aj.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.components.core.e.d.a.a(new a.C0333a(aj.this.acw.TG.getContext()).aB(aj.this.mAdTemplate).b(aj.this.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.aj.1.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                    }
                }));
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.acR.removeCallbacksAndMessages(null);
    }

    private static void a(AdInfo adInfo, a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.ads;
        adConversionInfo.marketUrl = aVar.adt;
        adInfo.adBaseInfo.adOperationType = aVar.type;
        adInfo.adBaseInfo.appPackageName = aVar.pkgName;
        adInfo.adBaseInfo.appName = aVar.appName;
        adInfo.adBaseInfo.appVersion = aVar.version;
        adInfo.adBaseInfo.packageSize = aVar.adr;
        adInfo.adBaseInfo.appIconUrl = aVar.icon;
        adInfo.adBaseInfo.appDescription = aVar.sX;
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            adInfo.adConversionInfo.appDownloadUrl = aVar.url;
            adInfo.downloadId = com.kwad.sdk.utils.al.md5(adInfo.adConversionInfo.appDownloadUrl);
        } else {
            adInfo.adConversionInfo.h5Url = aVar.url;
        }
    }
}
