package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements com.kwad.sdk.core.webview.b.a {
    private a UK;

    public interface a {
        void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo);
    }

    public w(a aVar) {
        this.UK = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            com.kwad.sdk.core.d.b.d("UpdateLiveCurrentShopInfoHandler", "handleJsCall: " + str);
            final TKAdLiveShopItemInfo tKAdLiveShopItemInfo = new TKAdLiveShopItemInfo();
            tKAdLiveShopItemInfo.parseJson(new JSONObject(str));
            bh.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.kwai.w.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (w.this.UK != null) {
                        w.this.UK.a(tKAdLiveShopItemInfo);
                    }
                }
            });
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "updateLiveCurrentShopInfo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
