package com.kwad.components.ad.l;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.a.c;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private KsAdWebView LZ;
    private boolean Ma;
    private boolean Mb;
    protected AdBaseFrameLayout Mc;
    private InterfaceC0288a Md;
    private c.a Mh;
    private b Mi;
    private com.kwad.sdk.core.webview.d.a.a eT;
    private FrameLayout fc;
    private AdBaseFrameLayout gt;
    private Activity mActivity;
    private AdTemplate mAdTemplate;
    private ImageView mBackIcon;
    private long mLastDown;
    private boolean LY = true;
    private Handler iK = new Handler(Looper.getMainLooper());
    private boolean Me = false;
    private boolean Mf = false;
    private boolean Mg = false;

    /* JADX INFO: renamed from: com.kwad.components.ad.l.a$a, reason: collision with other inner class name */
    public interface InterfaceC0288a {
        void S(boolean z);
    }

    public interface b {
        void jG();
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.Mf = true;
        return true;
    }

    static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.LY = true;
        return true;
    }

    static /* synthetic */ boolean c(a aVar, boolean z) {
        aVar.Me = true;
        return true;
    }

    static /* synthetic */ boolean d(a aVar, boolean z) {
        aVar.Ma = true;
        return true;
    }

    public final a ah(boolean z) {
        this.Mb = true;
        return this;
    }

    public final void bd() {
        this.fc.setVisibility(4);
        String strK = K(this.mAdTemplate);
        if (TextUtils.isEmpty(strK)) {
            return;
        }
        this.LZ.loadUrl(strK);
    }

    public final void a(InterfaceC0288a interfaceC0288a) {
        this.Md = interfaceC0288a;
    }

    private void gs() {
        this.fc.removeAllViews();
        this.fc.setVisibility(4);
        this.Mc = (AdBaseFrameLayout) ((ViewGroup) com.kwad.sdk.c.a.a.a((ViewGroup) this.fc, R.layout.ksad_ad_landingpage_layout, true)).findViewById(R.id.ksad_web_card_frame);
        KsAdWebView ksAdWebView = (KsAdWebView) this.fc.findViewById(R.id.ksad_web_card_webView);
        this.LZ = ksAdWebView;
        ksAdWebView.setBackgroundColor(-1);
        c.a aVarB = this.LZ.getClientConfig().bB(false).bD(true).bC(false).bA(true).eJ(this.mAdTemplate).a(nK()).b(ju());
        this.Mh = aVarB;
        this.LZ.setClientConfig(aVarB);
        this.LZ.setDownloadListener(new DownloadListener() { // from class: com.kwad.components.ad.l.a.1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                a.a(a.this, true);
                if (a.this.Md != null) {
                    a.this.Md.S(a.this.cH());
                }
            }
        });
        ImageView imageView = (ImageView) this.Mc.findViewById(R.id.ksad_end_close_btn);
        this.mBackIcon = imageView;
        imageView.setVisibility(8);
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.l.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (a.this.Mi != null) {
                    a.this.Mi.jG();
                }
            }
        });
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        this.fc = frameLayout;
        this.gt = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        gs();
        this.LY = false;
    }

    private KsAdWebView.e ju() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.l.a.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                a.b(a.this, true);
                if (a.this.Md != null) {
                    a.this.Md.S(a.this.cH());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                if (a.this.Md != null) {
                    a.this.Md.S(a.this.cH());
                }
            }
        };
    }

    private KsAdWebView.b nK() {
        return new KsAdWebView.b() { // from class: com.kwad.components.ad.l.a.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                a.c(a.this, true);
                if (a.this.Md != null) {
                    a.this.Md.S(a.this.cH());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                a.c(a.this, true);
                if (a.this.Md != null) {
                    a.this.Md.S(a.this.cH());
                }
            }
        };
    }

    public final void a(b bVar) {
        this.Mi = bVar;
    }

    public final void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    private static String K(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.aS(e.el(adTemplate));
    }

    public final void a(com.kwad.sdk.core.webview.d.a.a aVar) {
        this.eT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cH() {
        return this.Mg ? !this.LY : (this.LY || this.Me || this.Mf) ? false : true;
    }

    private boolean nL() {
        if (cH()) {
            FrameLayout frameLayout = this.fc;
            if (frameLayout == null) {
                return true;
            }
            frameLayout.setVisibility(0);
            return true;
        }
        FrameLayout frameLayout2 = this.fc;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        return false;
    }

    public final boolean aW() {
        boolean zNL = nL();
        this.Mg = true;
        if (zNL && this.mActivity != null) {
            if (this.LZ.getClientConfig() != null) {
                this.LZ.getClientConfig().bB(true);
                this.LZ.getClientConfig().bC(true);
            }
            this.Mc.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.l.a.5
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getX() > a.this.mBackIcon.getX() && motionEvent.getX() - a.this.mBackIcon.getX() < a.this.mBackIcon.getWidth() && motionEvent.getY() > a.this.mBackIcon.getY() && motionEvent.getY() - a.this.mBackIcon.getY() < a.this.mBackIcon.getHeight()) {
                        com.kwad.sdk.core.d.c.d("LandingPageWebCard", "onClick backIcon");
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        a.this.mLastDown = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime() - a.this.mLastDown;
                        if (a.this.mLastDown > 0 && jElapsedRealtime > 30 && jElapsedRealtime < 500) {
                            com.kwad.sdk.core.adlog.c.a(a.this.mAdTemplate, 155, a.this.gt.getTouchCoords());
                            if (!a.this.Ma) {
                                a.d(a.this, true);
                                if (a.this.eT != null) {
                                    com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
                                    aVar.adN = 3;
                                    a.this.eT.a(aVar);
                                }
                            }
                        }
                        a.this.mLastDown = 0L;
                    }
                    return false;
                }
            });
            long jAm = com.kwad.sdk.core.response.b.a.am(e.el(this.mAdTemplate));
            if (jAm == 0 || !this.Mb) {
                this.mBackIcon.setVisibility(0);
            } else {
                this.iK.postDelayed(new Runnable() { // from class: com.kwad.components.ad.l.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.mActivity == null || a.this.mActivity.isFinishing()) {
                            return;
                        }
                        a.this.mBackIcon.setVisibility(0);
                        a.this.mBackIcon.setAlpha(0.0f);
                        a.this.mBackIcon.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, jAm);
            }
            KsAdWebView ksAdWebView = this.LZ;
            if (ksAdWebView != null) {
                ksAdWebView.onActivityCreate();
            }
        }
        return zNL;
    }
}
