package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements com.kwad.sdk.core.webview.b.a {
    private final com.kwad.sdk.core.webview.b Sk;
    private final Handler Ss = new Handler(Looper.getMainLooper());
    private final AdTemplate mAdTemplate = new AdTemplate();
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String SZ;
        public int Ta;
        public String Tb;
        public String Tc;
        public String Td;

        @Deprecated
        public boolean Te;
        public boolean Tf;
        public boolean Tg;
        public String appId;
        public String appName;
        public String icon;
        public String qM;
        public int type;
        public String url;
        public String version;
        public int versionCode;
    }

    public q(com.kwad.sdk.core.webview.b bVar) {
        this.Sk = bVar;
        try {
            AdTemplate adTemplate = this.Sk.getAdTemplate();
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

    private static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.Tc;
        adConversionInfo.marketUrl = aVar.Td;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = aVar.type;
        adBaseInfo.appPackageName = aVar.SZ;
        adBaseInfo.appName = aVar.appName;
        adBaseInfo.appVersion = aVar.version;
        adBaseInfo.packageSize = aVar.Ta;
        adBaseInfo.appIconUrl = aVar.icon;
        adBaseInfo.appDescription = aVar.qM;
        if (!com.kwad.sdk.core.response.a.a.ay(adInfo)) {
            adInfo.adConversionInfo.h5Url = aVar.url;
        } else {
            AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
            adConversionInfo2.appDownloadUrl = aVar.url;
            adInfo.downloadId = com.kwad.sdk.utils.ac.el(adConversionInfo2.appDownloadUrl);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.d.b.c cVar2;
        int i2;
        if (com.kwad.sdk.core.response.a.a.ay(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i2 = 2;
        } else {
            AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
            a(adInfoCb, aVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i2 = 1;
        }
        cVar2.as(i2);
        this.Ss.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.q.1
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.d.b.a.a(new a.C0395a(q.this.Sk.LI.getContext()).J(q.this.mAdTemplate).b(q.this.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.q.1.1
                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                    }
                }));
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "handleAdUrl";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Ss.removeCallbacksAndMessages(null);
    }
}
