package com.kwad.components.ad.splashscreen.b;

import android.os.SystemClock;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends e {
    private com.kwad.components.core.offline.api.a.b CN;
    private com.kwad.components.core.offline.api.a.a CO = new com.kwad.components.core.offline.api.a.a() { // from class: com.kwad.components.ad.splashscreen.b.j.1
        @Override // com.kwad.components.core.offline.api.a.a
        public final void onSuccess() {
            com.kwad.components.splash.monitor.a.sp();
            com.kwad.components.splash.monitor.a.g(j.this.Cx.mAdTemplate, SystemClock.elapsedRealtime() - j.this.mLoadStartTime);
            if (com.kwad.sdk.core.response.a.b.cF(com.kwad.sdk.core.response.a.d.cb(j.this.Cx.mAdTemplate))) {
                bh.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.j.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.this.a(new com.kwad.components.ad.splashscreen.b.a.a(), true);
                    }
                });
            }
        }
    };
    private long mLoadStartTime;

    private void lu() {
        this.CN = (com.kwad.components.core.offline.api.a.b) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.a.b.class);
        com.kwad.components.core.offline.api.a.b bVar = this.CN;
        if (bVar != null) {
            bVar.a(this.CO);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        lu();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mLoadStartTime = SystemClock.elapsedRealtime();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.offline.api.a.b bVar = this.CN;
        if (bVar != null) {
            bVar.b(this.CO);
        }
    }
}
