package com.kwad.components.core.playable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.webview.a.kwai.f;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.c;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.b;
import com.kwad.sdk.utils.bh;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements c {
    private final KsAdWebView NO;
    private long NP;
    private int NQ;
    private PlayableSource NR = PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE;
    private List<z.b> NS = new CopyOnWriteArrayList();
    private List<KsAdWebView.d> NT = new CopyOnWriteArrayList();

    @Nullable
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private ae mCardLifecycleHandler;
    private Context mContext;

    @Nullable
    private com.kwad.components.core.webview.a mJsInterface;
    private AdBaseFrameLayout mRootContainer;

    /* JADX INFO: renamed from: com.kwad.components.core.playable.a$a, reason: collision with other inner class name */
    static class C0409a implements am.b {
        private final WeakReference<a> NV;

        public C0409a(a aVar) {
            this.NV = new WeakReference<>(aVar);
        }

        @Override // com.kwad.components.core.webview.jshandler.am.b
        public final void T(int i2) {
            a aVar = this.NV.get();
            if (aVar != null) {
                aVar.ay(i2);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public a(KsAdWebView ksAdWebView) {
        this.NO = ksAdWebView;
        this.NO.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.playable.a.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                a.this.NP = SystemClock.elapsedRealtime();
                a.this.NO.getClientConfig().aY(true);
                return false;
            }
        });
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().cr(this.mAdTemplate).b(getWebListener()));
        b(this.NO);
    }

    private void a(b bVar, com.kwad.components.core.webview.a aVar, com.kwad.components.core.d.b.c cVar) {
        aVar.a(new am(bVar, cVar, new C0409a(this)));
        aVar.a(new z(new z.b() { // from class: com.kwad.components.core.playable.a.3
            @Override // com.kwad.components.core.webview.jshandler.z.b
            public final void a(z.a aVar2) {
                a.this.NQ = aVar2.status;
                if (aVar2.status == 1 && a.this.mAdTemplate != null) {
                    com.kwad.sdk.core.report.a.aB(a.this.mAdTemplate);
                }
                Iterator it = a.this.NS.iterator();
                while (it.hasNext()) {
                    ((z.b) it.next()).a(aVar2);
                }
            }
        }, getUrl()));
        aVar.a(new t(bVar));
        this.mCardLifecycleHandler = new ae();
        aVar.a(new o());
        aVar.a(new n(bVar));
        aVar.a(new f());
        aVar.a(this.mCardLifecycleHandler);
        aVar.a(new com.kwad.components.core.webview.jshandler.b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(int i2) {
        if (getAdTemplate() == null) {
            return;
        }
        long jUW = d.uW();
        if (jUW <= 0 || SystemClock.elapsedRealtime() - this.NP <= jUW) {
            y.b bVar = new y.b();
            bVar.jS = i2;
            bVar.jU = this.mRootContainer.getTouchCoords();
            com.kwad.components.core.d.b.a.a(new a.C0395a(this.mContext).J(this.mAdTemplate).b(this.mApkDownloadHelper).al(false).a(bVar).an(true));
        }
    }

    private static void b(KsAdWebView ksAdWebView) {
        if (Build.VERSION.SDK_INT < 17 || !d.uV()) {
            return;
        }
        ksAdWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    @Nullable
    private AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    private String getUrl() {
        AdTemplate adTemplate = this.mAdTemplate;
        return adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.bA(com.kwad.sdk.core.response.a.d.cb(adTemplate));
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.core.playable.a.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                Iterator it = a.this.NT.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.d) it.next()).onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
                Iterator it = a.this.NT.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.d) it.next()).onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                Iterator it = a.this.NT.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.d) it.next()).onReceivedHttpError(i2, str, str2);
                }
            }
        };
    }

    private void oN() {
        if (com.kwad.sdk.core.response.a.a.bw(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)) > 0) {
            bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.playable.a.4
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    a.this.NO.getClientConfig().aY(true);
                }
            }, com.kwad.sdk.core.response.a.a.bw(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)));
        }
        if (com.kwad.sdk.core.response.a.a.bw(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)) == 0) {
            this.NO.getClientConfig().aY(true);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.c
    public final void a(com.kwad.components.core.webview.jshandler.b bVar, String str) {
        AdTemplate adTemplate;
        if ("playableSrc".equals(str)) {
            bVar.f(this.NR);
        }
        if (!"getAdType".equals(str) || (adTemplate = this.mAdTemplate) == null) {
            return;
        }
        bVar.aK(adTemplate.adStyle);
    }

    public final void a(@Nullable z.b bVar) {
        this.NS.add(bVar);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, com.kwad.components.core.d.b.c cVar) {
        if (this.NO == null) {
            com.kwad.sdk.core.d.b.w("PlayableViewHelper", "registerJsBridge mPlayableView is null");
            return;
        }
        this.mContext = adBaseFrameLayout.getContext();
        this.mRootContainer = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.NQ = -1;
        b bVar = new b();
        bVar.setAdTemplate(adTemplate);
        bVar.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout2 = this.mRootContainer;
        bVar.aoM = adBaseFrameLayout2;
        bVar.LI = adBaseFrameLayout2;
        bVar.Lk = this.NO;
        clearJsInterfaceRegister();
        this.mJsInterface = new com.kwad.components.core.webview.a(this.NO);
        a(bVar, this.mJsInterface, cVar);
        this.NO.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    public final void a(@Nullable KsAdWebView.d dVar) {
        this.NT.add(dVar);
    }

    public final void b(@Nullable z.b bVar) {
        this.NS.remove(bVar);
    }

    public final void e(PlayableSource playableSource) {
        if (playableSource != null) {
            this.NR = playableSource;
        }
        if (this.NO == null) {
            return;
        }
        oN();
        com.kwad.sdk.core.d.b.d("PlayableViewHelper", "showPlayable");
        ae aeVar = this.mCardLifecycleHandler;
        if (aeVar != null) {
            aeVar.rr();
        }
        this.NO.setVisibility(0);
        ae aeVar2 = this.mCardLifecycleHandler;
        if (aeVar2 != null) {
            aeVar2.rs();
        }
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.NO;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    public final void hS() {
        com.kwad.sdk.core.d.b.d("PlayableViewHelper", "showPlayable");
        if (this.NO == null) {
            return;
        }
        ae aeVar = this.mCardLifecycleHandler;
        if (aeVar != null) {
            aeVar.rt();
        }
        this.NO.setVisibility(8);
        ae aeVar2 = this.mCardLifecycleHandler;
        if (aeVar2 != null) {
            aeVar2.ru();
        }
        this.NO.reload();
    }

    public final void pn() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    public final void po() {
        KsAdWebView ksAdWebView;
        if (this.mAdTemplate == null || (ksAdWebView = this.NO) == null) {
            return;
        }
        ksAdWebView.getClientConfig().aY(false);
        String url = getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.NO.loadUrl(url);
        }
        com.kwad.sdk.core.report.a.aC(this.mAdTemplate);
    }

    public final boolean pp() {
        return this.NO != null && this.NQ == 1;
    }
}
