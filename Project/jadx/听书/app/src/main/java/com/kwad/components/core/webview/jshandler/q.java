package com.kwad.components.core.webview.jshandler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements com.kwad.sdk.core.webview.c.a {
    private BroadcastReceiver acx;
    private com.kwad.sdk.core.webview.c.c qn;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public String message;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "onMessage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.qn = cVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ksad_webView_local_broadcast");
        try {
            if (this.acx != null) {
                com.kwad.sdk.utils.ad.cO(ServiceProvider.getContext()).unregisterReceiver(this.acx);
                this.acx = null;
            }
            this.acx = new BroadcastReceiver() { // from class: com.kwad.components.core.webview.jshandler.q.1
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context, Intent intent) {
                    String stringExtra = intent.getStringExtra("data");
                    if (TextUtils.isEmpty(stringExtra)) {
                        return;
                    }
                    a aVar = new a();
                    aVar.message = stringExtra;
                    q.this.qn.a(aVar);
                }
            };
            com.kwad.sdk.utils.ad.cO(ServiceProvider.getContext()).a(this.acx, intentFilter);
        } catch (Throwable th) {
            com.kwad.sdk.crash.b.n(th);
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        try {
            if (this.acx != null) {
                com.kwad.sdk.utils.ad.cO(ServiceProvider.getContext()).unregisterReceiver(this.acx);
                this.acx = null;
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.b.n(th);
        }
    }
}
