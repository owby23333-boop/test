package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.ad.splashscreen.presenter.s;
import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends e {
    private com.kwad.components.core.o.a.e.b IH;
    private long II;
    private volatile boolean IJ = false;
    private g mq = new g() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.1
        @Override // com.kwad.components.core.webview.tachikoma.f.b
        public final void v(String str) {
            b.this.Gf.bO = true;
            if ("tk_splash".equals(str)) {
                b.this.na();
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.g
        public final void a(String str, long j, long j2, long j3) {
            if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.dK(b.this.Gf.mAdTemplate))) {
                return;
            }
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.a(b.this.Gf.mAdTemplate, b.this.Gf.Fr, b.this.Gf.FA, b.this.Gf.FC, b.this.Gf.FB, b.this.Gf.FD, j, j2, j3, SystemClock.elapsedRealtime() - b.this.II);
            b.this.Gf.FE = j;
            b.this.Gf.FF = j2;
            b.this.Gf.FG = j3;
            bw.c(b.this.IK);
        }
    };
    private final Runnable IK = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.2
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.IJ) {
                b.this.Gf.bO = true;
                b.this.na();
                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                com.kwad.components.ad.splashscreen.monitor.b.c(b.this.Gf.mAdTemplate, b.this.Gf.Fr);
                return;
            }
            b.this.mZ();
        }
    };
    private com.kwad.components.core.o.a.e.a IL = new com.kwad.components.core.o.a.e.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.3
        @Override // com.kwad.components.core.o.a.e.a
        public final void a(int i, int i2, long j, long j2) {
            b.this.Gf.FA = i;
            b.this.Gf.FB = i2;
            b.this.Gf.FC = j;
            b.this.Gf.FD = j2;
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.g(b.this.Gf.mAdTemplate, SystemClock.elapsedRealtime() - b.this.II);
            b.this.mZ();
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
        if (nb()) {
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.a(this.Gf.mAdTemplate, this.Gf.Fr);
            this.Gf.Fz = this.II;
            bw.runOnUiThreadDelay(this.IK, com.kwad.sdk.core.response.b.b.dG(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate)));
            com.kwad.components.core.webview.tachikoma.e.c.vO().a(this.mq);
        }
        if (com.kwad.sdk.core.config.e.Fq()) {
            mY();
        } else {
            na();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.o.a.e.b bVar = this.IH;
        if (bVar != null) {
            bVar.b(this.IL);
        }
        if (nb()) {
            bw.c(this.IK);
            com.kwad.components.core.webview.tachikoma.e.c.vO().b(this.mq);
        }
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
        if (nb()) {
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(new d(), true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na() {
        if (!com.kwad.sdk.core.response.b.b.dT(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate)) || this.Gf.Fx) {
            return;
        }
        this.Gf.Fx = true;
        bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.5
            @Override // java.lang.Runnable
            public final void run() {
                b.this.a(new s(), true);
            }
        });
    }

    private boolean nb() {
        if (com.kwad.sdk.core.config.e.Fq()) {
            return com.kwad.sdk.core.response.b.b.dB(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate));
        }
        return false;
    }
}
