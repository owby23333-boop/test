package com.kwad.components.core.webview.jshandler;

import androidx.core.app.NotificationCompat;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c ack;
    private com.kwad.components.core.proxy.launchdialog.b acl = uA();
    private final com.kwad.sdk.core.webview.b eQ;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "dpInterceptPopupListener";
    }

    public c(com.kwad.sdk.core.webview.b bVar) {
        this.eQ = bVar;
        com.kwad.components.core.proxy.launchdialog.e.sc().a(this.acl);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
    }

    private com.kwad.components.core.proxy.launchdialog.b uA() {
        return new com.kwad.components.core.proxy.launchdialog.b() { // from class: com.kwad.components.core.webview.jshandler.c.1
            @Override // com.kwad.components.core.proxy.launchdialog.b
            public final void b(long j, int i) {
                try {
                    String strValueOf = String.valueOf(j);
                    AdTemplate adTemplateDk = c.this.eQ.dk(strValueOf);
                    if (c.this.ack == null || adTemplateDk == null) {
                        return;
                    }
                    a aVar = new a();
                    aVar.status = i;
                    aVar.NN = strValueOf;
                    c.this.ack.a(aVar);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
        com.kwad.components.core.proxy.launchdialog.e.sc().b(this.acl);
        this.acl = null;
    }

    public static final class a implements com.kwad.sdk.core.b {
        String NN;
        int status;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, this.status);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", this.NN);
            return jSONObject;
        }
    }
}
