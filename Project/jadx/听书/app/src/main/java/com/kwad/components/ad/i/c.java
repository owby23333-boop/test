package com.kwad.components.ad.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.components.core.j.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    private static final Handler qI = new Handler(Looper.getMainLooper());
    private static volatile boolean qM;
    private final long qJ;
    private final AdTemplate qK;
    private boolean qL = false;
    private d qN;

    static /* synthetic */ boolean access$002(boolean z) {
        qM = false;
        return false;
    }

    public c(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        this.qK = adTemplate;
        long jDb = com.kwad.sdk.core.response.b.a.db(com.kwad.sdk.core.response.b.e.el(adTemplate));
        this.qJ = jDb;
        com.kwad.sdk.core.d.c.d("PushAdManager", "PushAdManager create adTemplate: " + adTemplate.hashCode() + ", " + jDb);
    }

    public final void fV() {
        com.kwad.sdk.core.d.c.w("PushAdManager", "startRequestPushAd processingPush: " + qM);
        if (qM || this.qK.mAdScene == null) {
            return;
        }
        qM = true;
        com.kwad.components.core.j.a.b(this.qK.mAdScene, new a.InterfaceC0338a() { // from class: com.kwad.components.ad.i.c.1
            @Override // com.kwad.components.core.j.a.InterfaceC0338a
            public final void onRequestResult(int i) {
            }

            @Override // com.kwad.components.core.j.a.InterfaceC0338a
            public final void onError(int i, String str) {
                com.kwad.sdk.core.d.c.d("PushAdManager", "onError: " + str);
                c.access$002(false);
            }

            @Override // com.kwad.components.core.j.a.InterfaceC0338a
            public final void e(List<com.kwad.components.core.j.c> list) {
                com.kwad.sdk.core.d.c.d("PushAdManager", "onInnerAdLoad: " + list);
                if (list != null && list.size() > 0) {
                    AdTemplate adTemplate = list.get(0).getAdTemplate();
                    if (com.kwad.sdk.core.response.b.a.cZ(com.kwad.sdk.core.response.b.e.el(adTemplate))) {
                        com.kwad.sdk.core.d.c.d("PushAdManager", "loadPushTK");
                        c.this.qN = new d(ServiceProvider.getContext(), adTemplate);
                        return;
                    }
                    c.access$002(false);
                    com.kwad.sdk.core.d.c.d("PushAdManager", "pushAdInfo templateId invalid");
                    return;
                }
                c.access$002(false);
            }
        });
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (com.kwad.components.core.e.a.e.oK().isShowing()) {
            com.kwad.components.core.e.a.e.oK().a(new com.kwad.components.core.e.a.c() { // from class: com.kwad.components.ad.i.c.2
                @Override // com.kwad.components.core.e.a.c, com.kwad.components.core.e.a.b
                public final void fY() {
                    com.kwad.components.core.e.a.e.oK().b(this);
                    c.this.fW();
                }
            });
        } else {
            fW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW() {
        d dVar;
        if (!b.fR().fT()) {
            com.kwad.sdk.core.d.c.d("PushAdManager", "run preCheckResult false");
            return;
        }
        qM = false;
        if (this.qL || (dVar = this.qN) == null || !dVar.gb()) {
            return;
        }
        this.qL = true;
        this.qN.c(new com.kwad.components.ad.b.a.b() { // from class: com.kwad.components.ad.i.c.3
            @Override // com.kwad.components.ad.b.a.b
            public final void U() {
                ag.aZ(System.currentTimeMillis());
                e.ge().ga();
            }

            @Override // com.kwad.components.ad.b.a.b
            public final void V() {
                com.kwad.sdk.core.d.c.d("PushAdManager", "onAdClose: ");
                e.ge().gc();
                b.fR().a(c.this);
            }
        });
    }

    public final void d(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (!adTemplate.equals(this.qK)) {
            com.kwad.sdk.core.d.c.d("PushAdManager", "onAdExit not current ad");
            return;
        }
        com.kwad.sdk.core.d.c.d("PushAdManager", "onAdExit showPushAdDelayTime: " + this.qJ + ", adTemplate: " + adTemplate.hashCode());
        if (aVar.supportPushAd()) {
            a(1000001, this, this.qJ);
        }
    }

    public final void fX() {
        com.kwad.sdk.core.d.c.d("PushAdManager", "onOutSDKPage: ");
        if (qI.hasMessages(1000001)) {
            return;
        }
        com.kwad.sdk.core.d.c.d("PushAdManager", "onOutSDKPage: sendMessageDelay MSG_WHAT_PAGE_OUT");
        a(1000002, this, 500L);
    }

    private static void a(int i, Runnable runnable, long j) {
        Handler handler = qI;
        Message messageObtain = Message.obtain(handler, runnable);
        messageObtain.what = i;
        handler.sendMessageDelayed(messageObtain, j);
    }
}
