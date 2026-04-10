package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.core.report.KSLoggerReporter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements com.kwad.sdk.core.webview.b.a {
    private static void a(@NonNull WebViewCommercialMsg webViewCommercialMsg) {
        com.kwad.sdk.core.d.b.d("WebCardLogHandler", "handleH5Log actionType actionType" + webViewCommercialMsg.category);
        KSLoggerReporter.a(webViewCommercialMsg.category, webViewCommercialMsg);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            WebViewCommercialMsg webViewCommercialMsg = new WebViewCommercialMsg();
            webViewCommercialMsg.parseJson(new JSONObject(str));
            a(webViewCommercialMsg);
            cVar.a(null);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            cVar.onError(-1, e2.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "commercialLog";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
