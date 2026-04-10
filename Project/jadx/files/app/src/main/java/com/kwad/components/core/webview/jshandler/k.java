package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements com.kwad.sdk.core.webview.b.a {
    private final com.kwad.sdk.core.webview.b Sk;
    private a Sz;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public interface a {
        void bI();
    }

    public k(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.Sk = bVar;
        this.Sz = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.k.1
            @Override // java.lang.Runnable
            public final void run() {
                k.this.Sz.bI();
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "dislike";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
