package com.kwad.components.ad.f.kwai.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.kwad.sdk.core.webview.b.a {
    public static int nL = 1;
    public static int nM = 2;
    private com.kwad.sdk.core.webview.b.c nK;
    private int nN;
    private int nO;
    private InterfaceC0346b nQ;
    private c nP = new c(this, 0);

    @Nullable
    private Runnable nR = null;

    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int nT;
        public int nU;
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.f.kwai.kwai.b$b, reason: collision with other inner class name */
    public interface InterfaceC0346b {
        void G(int i2);
    }

    class c implements Runnable {
        private boolean nV;
        private int nW;

        private c() {
            this.nV = false;
            this.nW = -1;
        }

        /* synthetic */ c(b bVar, byte b) {
            this();
        }

        public final void M(int i2) {
            this.nW = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.b.d("RegisterTimer", "TimerRunnable run timerPaused:  " + this.nV + ", currentTime: " + this.nW);
            if (this.nV) {
                bh.a(this, null, 1000L);
                return;
            }
            int i2 = this.nW;
            if (i2 < 0) {
                return;
            }
            b.this.L(i2);
            this.nW--;
            bh.a(this, null, 1000L);
        }

        public final void y(boolean z2) {
            this.nV = z2;
        }
    }

    private b(int i2, int i3) {
        this.nN = i2;
        this.nO = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i2) {
        com.kwad.sdk.core.d.b.d("RegisterTimer", "updateTimer: " + i2 + ", mCallBackFunction: " + this.nK);
        if (i2 >= 0 && this.nK != null) {
            InterfaceC0346b interfaceC0346b = this.nQ;
            if (interfaceC0346b != null && i2 == 0) {
                interfaceC0346b.G(this.nN);
            }
            a aVar = new a();
            aVar.nU = i2;
            aVar.nT = this.nN;
            com.kwad.sdk.core.webview.b.c cVar = this.nK;
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    private static int g(AdInfo adInfo) {
        int iB = com.kwad.components.ad.interstitial.kwai.b.b(adInfo);
        if (iB <= 0) {
            iB = 60;
        }
        int i2 = adInfo.adInsertScreenInfo.autoCloseTime;
        return i2 > 0 ? Math.min(iB, i2) : iB;
    }

    @Nullable
    public static b k(AdTemplate adTemplate) {
        AdInfo adInfoCb = d.cb(adTemplate);
        if (!(!com.kwad.sdk.core.response.a.a.aV(adInfoCb))) {
            return null;
        }
        if (com.kwad.sdk.core.response.a.a.bu(adInfoCb)) {
            return new b(nM, g(adInfoCb));
        }
        int i2 = adInfoCb.adInsertScreenInfo.autoCloseTime;
        if (i2 > 0) {
            return new b(nL, i2);
        }
        return null;
    }

    public final void a(InterfaceC0346b interfaceC0346b) {
        this.nQ = interfaceC0346b;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.nK = cVar;
        Runnable runnable = this.nR;
        if (runnable != null) {
            runnable.run();
            this.nR = null;
        }
    }

    public final void fc() {
        com.kwad.sdk.core.d.b.d("RegisterTimer", "startTimer: mCallBackFunction: " + this.nK);
        if (this.nK == null) {
            this.nR = new Runnable() { // from class: com.kwad.components.ad.f.kwai.kwai.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.fc();
                }
            };
        } else {
            this.nP.M(this.nO);
            bh.runOnUiThread(this.nP);
        }
    }

    public final void fd() {
        this.nP.y(true);
    }

    public final void fe() {
        this.nP.y(false);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerTimerListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.nK = null;
    }
}
