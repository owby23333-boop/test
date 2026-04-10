package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements com.kwad.sdk.core.webview.b.a {
    private final Handler Ss = new Handler(Looper.getMainLooper());

    @Nullable
    private com.kwad.sdk.core.webview.b.c St;
    private b cX;

    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int Ti = -1;
        public int type;
    }

    public interface b {
        @MainThread
        void a(a aVar);
    }

    public r(b bVar) {
        this.cX = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.cX;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            this.St = cVar;
            final a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar.parseJson(new JSONObject(str));
            }
            this.Ss.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.r.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (r.this.St != null) {
                        r.this.St.a(null);
                    }
                    r.this.b(aVar);
                }
            });
        } catch (Exception e2) {
            this.St.onError(-1, e2.getMessage());
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "hide";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.cX = null;
        this.St = null;
        this.Ss.removeCallbacksAndMessages(null);
    }
}
