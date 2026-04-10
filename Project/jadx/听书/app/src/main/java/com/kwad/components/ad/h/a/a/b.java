package com.kwad.components.ad.h.a.a;

import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    public static int qo = 1;
    public static int qp = 2;
    private com.kwad.sdk.core.webview.c.c qn;
    private int qq;
    private int qr;
    private InterfaceC0278b qt;
    private c qs = new c(this, 0);
    private Runnable qu = null;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int qw;
        public int qx;
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.h.a.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0278b {
        void Q(int i);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerTimerListener";
    }

    private b(int i, int i2) {
        this.qq = i;
        this.qr = i2;
    }

    public static b I(AdTemplate adTemplate) {
        AdInfo adInfoEl = e.el(adTemplate);
        if (!(!com.kwad.sdk.core.response.b.a.bc(adInfoEl))) {
            return null;
        }
        if (com.kwad.sdk.core.response.b.a.bK(adInfoEl)) {
            return new b(qp, f(adInfoEl));
        }
        if (adInfoEl.adInsertScreenInfo.autoCloseTime > 0) {
            return new b(qo, adInfoEl.adInsertScreenInfo.autoCloseTime);
        }
        return null;
    }

    private static int f(AdInfo adInfo) {
        int iB = com.kwad.components.ad.interstitial.b.b.b(adInfo);
        if (iB <= 0) {
            iB = 60;
        }
        int i = adInfo.adInsertScreenInfo.autoCloseTime;
        return i > 0 ? Math.min(iB, i) : iB;
    }

    public final void a(InterfaceC0278b interfaceC0278b) {
        this.qt = interfaceC0278b;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.qn = cVar;
        Runnable runnable = this.qu;
        if (runnable != null) {
            runnable.run();
            this.qu = null;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.qn = null;
    }

    public final void au() {
        com.kwad.sdk.core.d.c.d("RegisterTimer", "startTimer: mCallBackFunction: " + this.qn);
        if (this.qn == null) {
            this.qu = new Runnable() { // from class: com.kwad.components.ad.h.a.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.au();
                }
            };
        } else {
            this.qs.X(this.qr);
            bw.runOnUiThread(this.qs);
        }
    }

    public final void fP() {
        this.qs.z(true);
    }

    public final void fQ() {
        this.qs.z(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i) {
        com.kwad.sdk.core.d.c.d("RegisterTimer", "updateTimer: " + i + ", mCallBackFunction: " + this.qn);
        if (i >= 0 && this.qn != null) {
            InterfaceC0278b interfaceC0278b = this.qt;
            if (interfaceC0278b != null && i == 0) {
                interfaceC0278b.Q(this.qq);
            }
            a aVar = new a();
            aVar.qx = i;
            aVar.qw = this.qq;
            com.kwad.sdk.core.webview.c.c cVar = this.qn;
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    class c implements Runnable {
        private boolean qy;
        private int qz;

        private c() {
            this.qy = false;
            this.qz = -1;
        }

        /* synthetic */ c(b bVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.d("RegisterTimer", "TimerRunnable run timerPaused:  " + this.qy + ", currentTime: " + this.qz);
            if (this.qy) {
                bw.a(this, null, 1000L);
                return;
            }
            int i = this.qz;
            if (i < 0) {
                return;
            }
            b.this.W(i);
            this.qz--;
            bw.a(this, null, 1000L);
        }

        public final void X(int i) {
            this.qz = i;
        }

        public final void z(boolean z) {
            this.qy = z;
        }
    }
}
