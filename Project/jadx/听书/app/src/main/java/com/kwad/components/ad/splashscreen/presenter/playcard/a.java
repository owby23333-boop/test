package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.ad.splashscreen.presenter.j;
import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends e {
    private com.kwad.components.core.o.a.e.b IH;
    private long II;
    private volatile boolean IJ = false;
    private g mq = new g() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.1
        @Override // com.kwad.components.core.webview.tachikoma.f.b
        public final void v(String str) {
            a.this.Gf.bO = true;
            if ("tk_splash".equals(str)) {
                a.this.aV();
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.g
        public final void a(String str, long j, long j2, long j3) {
            if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.dK(a.this.Gf.mAdTemplate))) {
                return;
            }
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.a(a.this.Gf.mAdTemplate, a.this.Gf.Fr, a.this.Gf.FA, a.this.Gf.FC, a.this.Gf.FB, a.this.Gf.FD, j, j2, j3, SystemClock.elapsedRealtime() - a.this.II);
            a.this.Gf.FE = j;
            a.this.Gf.FF = j2;
            a.this.Gf.FG = j3;
            bw.c(a.this.IK);
        }
    };
    private final Runnable IK = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.IJ) {
                a.this.Gf.bO = true;
                a.this.aV();
                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                com.kwad.components.ad.splashscreen.monitor.b.c(a.this.Gf.mAdTemplate, a.this.Gf.Fr);
                return;
            }
            a.this.mZ();
        }
    };
    private com.kwad.components.core.o.a.e.a IL = new com.kwad.components.core.o.a.e.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.3
        @Override // com.kwad.components.core.o.a.e.a
        public final void a(int i, int i2, long j, long j2) {
            a.this.Gf.FA = i;
            a.this.Gf.FB = i2;
            a.this.Gf.FC = j;
            a.this.Gf.FD = j2;
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.g(a.this.Gf.mAdTemplate, SystemClock.elapsedRealtime() - a.this.II);
            a.this.mZ();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.II = SystemClock.elapsedRealtime();
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.a(this.Gf.mAdTemplate, this.Gf.Fr);
        this.Gf.Fz = this.II;
        bw.runOnUiThreadDelay(this.IK, com.kwad.sdk.core.response.b.b.dw(this.Gf.mAdTemplate));
        com.kwad.components.core.webview.tachikoma.e.c.vO().a(this.mq);
        mY();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.o.a.e.b bVar = this.IH;
        if (bVar != null) {
            bVar.b(this.IL);
        }
        bw.c(this.IK);
        com.kwad.components.core.webview.tachikoma.e.c.vO().b(this.mq);
    }

    private void mY() {
        com.kwad.components.core.o.a.e.b bVar = (com.kwad.components.core.o.a.e.b) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.e.b.class);
        this.IH = bVar;
        if (bVar != null) {
            bVar.a(this.IL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mZ() {
        if (this.IJ) {
            return;
        }
        this.IJ = true;
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.a(new com.kwad.components.ad.splashscreen.presenter.a.a(), true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV() {
        if (this.Gf.Fy) {
            return;
        }
        this.Gf.Fy = true;
        this.Gf.Fx = true;
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.a(new j(), true);
            }
        });
    }
}
