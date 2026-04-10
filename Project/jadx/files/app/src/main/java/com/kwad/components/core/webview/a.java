package com.kwad.components.core.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.b.d;
import com.kwad.sdk.core.webview.b.e;
import com.kwad.sdk.core.webview.b.f;
import com.kwad.sdk.utils.bm;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private WebView Lk;
    private final Map<String, com.kwad.sdk.core.webview.b.a> RI = new ConcurrentHashMap(32);
    private com.kwad.sdk.core.webview.b.a RJ = new d();
    private boolean RK;

    public a(WebView webView) {
        this.Lk = webView;
        rb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, String str2) {
        String str3;
        if (this.RK) {
            str3 = "callJS after destroy jsInterface, " + str2;
        } else {
            if (!TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.d.b.d("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
                WebView webView = this.Lk;
                if (webView == null) {
                    return;
                }
                bm.a(webView, str, str2);
                return;
            }
            str3 = "callJS callback is empty";
        }
        com.kwad.sdk.core.d.b.d("KSAdJSBridge", str3);
    }

    private void rb() {
        a(new com.kwad.sdk.core.webview.c.a());
        a(new com.kwad.sdk.core.webview.c.b());
        a(new i());
    }

    public final void a(com.kwad.sdk.core.webview.b.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.getKey())) {
            com.kwad.sdk.core.d.b.e("KSAdJSBridge", "handler and handler'key cannot be null");
            return;
        }
        if (this.RI.containsKey(aVar.getKey())) {
            com.kwad.sdk.core.d.b.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.getKey());
        }
        this.RI.put(aVar.getKey(), aVar);
    }

    public final void b(com.kwad.sdk.core.webview.b.a aVar) {
        if (TextUtils.isEmpty(aVar.getKey())) {
            com.kwad.sdk.core.d.b.e("KSAdJSBridge", "handler and handler'key cannot be null");
        } else {
            this.RI.put(aVar.getKey(), aVar);
        }
    }

    @JavascriptInterface
    public final void callAdBridge(String str) {
        com.kwad.sdk.core.d.b.d("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            final com.kwad.sdk.core.webview.b.b bVar = new com.kwad.sdk.core.webview.b.b();
            bVar.parseJson(new JSONObject(str));
            com.kwad.sdk.core.webview.b.a aVar = this.RI.get(bVar.apz);
            if (aVar == null) {
                aVar = this.RJ;
            }
            if (this.Lk != null && (this.Lk instanceof KsAdWebView)) {
                KsAdWebView ksAdWebView = (KsAdWebView) this.Lk;
                com.kwad.sdk.core.webview.a.b.b.a(ksAdWebView.getLoadUrl(), ksAdWebView.getUniqueId(), bVar.apz, bVar.data);
            }
            if (aVar != null) {
                aVar.a(bVar.data, !TextUtils.isEmpty(bVar.apA) ? new com.kwad.sdk.core.webview.b.c() { // from class: com.kwad.components.core.webview.a.1
                    @Override // com.kwad.sdk.core.webview.b.c
                    public final void a(com.kwad.sdk.core.b bVar2) {
                        a.this.h(bVar.apA, new f(bVar2).toJson().toString());
                    }

                    @Override // com.kwad.sdk.core.webview.b.c
                    public final void onError(int i2, String str2) {
                        a.this.h(bVar.apA, new e(i2, str2).toJson().toString());
                    }
                } : new com.kwad.sdk.core.webview.b.c() { // from class: com.kwad.components.core.webview.a.2
                    @Override // com.kwad.sdk.core.webview.b.c
                    public final void a(com.kwad.sdk.core.b bVar2) {
                    }

                    @Override // com.kwad.sdk.core.webview.b.c
                    public final void onError(int i2, String str2) {
                    }
                });
            } else {
                com.kwad.sdk.core.d.b.e("KSAdJSBridge", "bridgeHandler is null");
            }
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            com.kwad.sdk.core.d.b.e("KSAdJSBridge", "callAdBridge JSONException:" + e2);
        }
    }

    public final void destroy() {
        com.kwad.sdk.core.d.b.i("KSAdJSBridge", "destroy jsInterface");
        Iterator<Map.Entry<String, com.kwad.sdk.core.webview.b.a>> it = this.RI.entrySet().iterator();
        while (it.hasNext()) {
            com.kwad.sdk.core.webview.b.a value = it.next().getValue();
            if (value != null) {
                value.onDestroy();
            }
        }
        this.RK = true;
    }
}
