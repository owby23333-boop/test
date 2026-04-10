package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class af implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c RZ;
    private final Handler Ss = new Handler(Looper.getMainLooper());
    private final c TP;

    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int likeUserCount;
        public long liveDuration;
        public int status;
        public long totalWatchingDuration;
        public int watchingUserCount;
        public String displayWatchingUserCount = "0";
        public String displayLikeUserCount = "0";
    }

    public static final class b {
        WeakReference<com.kwad.sdk.core.webview.b.c> TR;

        public b(com.kwad.sdk.core.webview.b.c cVar) {
            this.TR = new WeakReference<>(cVar);
        }

        public final void a(a aVar) {
            com.kwad.sdk.core.webview.b.c cVar = this.TR.get();
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    public interface c {
        void a(b bVar);
    }

    public af(c cVar) {
        this.TP = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.RZ = cVar;
        this.Ss.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.af.1
            @Override // java.lang.Runnable
            public final void run() {
                af.this.TP.a(new b(af.this.RZ));
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerLiveListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.RZ = null;
        this.Ss.removeCallbacksAndMessages(null);
    }
}
