package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements com.kwad.sdk.core.webview.b.a {
    private Handler Ss = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.b.c St;
    private b cY;
    private String mUrl;

    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String errorMsg;
        public int status;

        public final boolean isSuccess() {
            return this.status == 1;
        }
    }

    public interface b {
        @MainThread
        void a(a aVar);
    }

    @Deprecated
    public z(b bVar) {
        this.cY = bVar;
    }

    public z(b bVar, String str) {
        this.cY = bVar;
        this.mUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.cY;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.St = cVar;
        try {
            final a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            this.Ss.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.z.1
                @Override // java.lang.Runnable
                public final void run() {
                    z.this.b(aVar);
                    if (z.this.St != null) {
                        z.this.St.a(null);
                    }
                }
            });
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.e("WebCardPageStatusHandler", "handleJsCall error: " + e2);
            com.kwad.sdk.core.webview.a.b.b.P(this.mUrl, e2.getMessage());
            cVar.onError(-1, e2.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "pageStatus";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.cY = null;
        this.St = null;
        this.Ss.removeCallbacksAndMessages(null);
    }
}
