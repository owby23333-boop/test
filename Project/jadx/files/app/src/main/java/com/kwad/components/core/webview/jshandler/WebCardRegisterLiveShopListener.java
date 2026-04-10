package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class WebCardRegisterLiveShopListener implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c RZ;

    public static class AdLiveItemShopInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -7621721959722008440L;
        public String price;
        public int status;
        public String title;
        public String url;
    }

    public final void a(AdLiveShopInfo adLiveShopInfo) {
        if (this.RZ == null) {
            return;
        }
        AdLiveItemShopInfo adLiveItemShopInfo = new AdLiveItemShopInfo();
        adLiveItemShopInfo.status = adLiveShopInfo.status;
        adLiveItemShopInfo.title = adLiveShopInfo.title;
        adLiveItemShopInfo.url = adLiveShopInfo.url;
        adLiveItemShopInfo.price = adLiveShopInfo.price;
        this.RZ.a(adLiveItemShopInfo);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.RZ = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerLiveShopListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.RZ = null;
    }
}
