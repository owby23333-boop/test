package com.kwad.components.core.webview.jshandler;

import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public final class WebCardRegisterLiveShopListener implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c ack;

    public static class AdLiveItemShopInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -7621721959722008440L;
        public String price;
        public int status;
        public String title;
        public String url;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerLiveShopListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
    }

    public final void a(AdLiveShopInfo adLiveShopInfo) {
        if (this.ack == null) {
            return;
        }
        AdLiveItemShopInfo adLiveItemShopInfo = new AdLiveItemShopInfo();
        adLiveItemShopInfo.status = adLiveShopInfo.status;
        adLiveItemShopInfo.title = adLiveShopInfo.title;
        adLiveItemShopInfo.url = adLiveShopInfo.url;
        adLiveItemShopInfo.price = adLiveShopInfo.price;
        this.ack.a(adLiveItemShopInfo);
    }
}
