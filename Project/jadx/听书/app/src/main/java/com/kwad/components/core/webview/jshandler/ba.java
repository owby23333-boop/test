package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ba implements com.kwad.sdk.core.webview.c.a {
    private final Handler acR = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c ack;
    private final c aei;

    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int likeUserCount;
        public long liveDuration;
        public int status;
        public long totalWatchingDuration;
        public int watchingUserCount;
        public String displayWatchingUserCount = "0";
        public String displayLikeUserCount = "0";
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface c {
        void a(b bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerLiveListener";
    }

    public ba(c cVar) {
        this.aei = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
        this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.ba.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ba.this.aei.a(new b(ba.this.ack));
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
        this.acR.removeCallbacksAndMessages(null);
    }

    public static final class b {
        WeakReference<com.kwad.sdk.core.webview.c.c> aek;

        public b(com.kwad.sdk.core.webview.c.c cVar) {
            this.aek = new WeakReference<>(cVar);
        }

        public final void a(a aVar) {
            com.kwad.sdk.core.webview.c.c cVar = this.aek.get();
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }
}
