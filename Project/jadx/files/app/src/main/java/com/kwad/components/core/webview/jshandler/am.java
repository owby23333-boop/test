package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class am implements com.kwad.sdk.core.webview.b.a {
    private static Handler Ui;
    private com.kwad.components.core.d.b.c IZ;
    private b Uj;
    private com.kwad.sdk.core.webview.b jsBridgeContext;

    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int jS;
    }

    public interface b {
        @MainThread
        void T(int i2);
    }

    public am(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, b bVar2) {
        this.jsBridgeContext = bVar;
        this.IZ = cVar;
        this.Uj = bVar2;
        if (Ui == null) {
            Ui = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            final int i2 = aVar.jS;
            Ui.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.am.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (am.this.Uj != null) {
                        am.this.Uj.T(i2);
                    }
                }
            });
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "playableConvert";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
