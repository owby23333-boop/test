package com.kwad.components.ad.i;

import android.annotation.SuppressLint;
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
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.kwai.c;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private KsAdWebView GB;
    private boolean GC;
    private boolean GD;
    protected AdBaseFrameLayout GE;
    private InterfaceC0352a GF;
    private b GJ;

    @Nullable
    private com.kwad.sdk.core.webview.c.kwai.a cV;
    private AdBaseFrameLayout dF;
    private FrameLayout de;
    private c.a kj;
    private Activity mActivity;
    private AdTemplate mAdTemplate;
    private ImageView mBackIcon;
    private long mLastDown;
    private boolean GA = true;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean GG = false;
    private boolean GH = false;
    private boolean GI = false;

    /* JADX INFO: renamed from: com.kwad.components.ad.i.a$a, reason: collision with other inner class name */
    public interface InterfaceC0352a {
        void V(boolean z2);
    }

    public interface b {
        void iK();
    }

    static /* synthetic */ boolean a(a aVar, boolean z2) {
        aVar.GH = true;
        return true;
    }

    static /* synthetic */ boolean b(a aVar, boolean z2) {
        aVar.GA = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bE() {
        return this.GI ? !this.GA : (this.GA || this.GG || this.GH) ? false : true;
    }

    static /* synthetic */ boolean c(a aVar, boolean z2) {
        aVar.GG = true;
        return true;
    }

    static /* synthetic */ boolean d(a aVar, boolean z2) {
        aVar.GC = true;
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void fK() {
        this.de.removeAllViews();
        this.de.setVisibility(4);
        this.GE = (AdBaseFrameLayout) ((ViewGroup) com.kwad.sdk.b.kwai.a.a((ViewGroup) this.de, R.layout.ksad_ad_landingpage_layout, true)).findViewById(R.id.ksad_web_card_frame);
        this.GB = (KsAdWebView) this.de.findViewById(R.id.ksad_web_card_webView);
        this.GB.setBackgroundColor(-1);
        y.b bVar = new y.b();
        bVar.ajX = 1;
        this.kj = this.GB.getClientConfig().aY(false).aZ(false).b(bVar).cr(this.mAdTemplate).a(md()).b(getWebListener());
        this.GB.setClientConfig(this.kj);
        this.GB.setDownloadListener(new DownloadListener() { // from class: com.kwad.components.ad.i.a.1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                a.a(a.this, true);
                if (a.this.GF != null) {
                    a.this.GF.V(a.this.bE());
                }
            }
        });
        this.mBackIcon = (ImageView) this.GE.findViewById(R.id.ksad_end_close_btn);
        this.mBackIcon.setVisibility(8);
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.i.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (a.this.GJ != null) {
                    a.this.GJ.iK();
                }
            }
        });
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.i.a.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                if (a.this.GF != null) {
                    a.this.GF.V(a.this.bE());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                a.b(a.this, true);
                if (a.this.GF != null) {
                    a.this.GF.V(a.this.bE());
                }
            }
        };
    }

    private static String m(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.a.aL(d.cb(adTemplate));
    }

    private KsAdWebView.b md() {
        return new KsAdWebView.b() { // from class: com.kwad.components.ad.i.a.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                a.c(a.this, true);
                if (a.this.GF != null) {
                    a.this.GF.V(a.this.bE());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                a.c(a.this, true);
                if (a.this.GF != null) {
                    a.this.GF.V(a.this.bE());
                }
            }
        };
    }

    private boolean me() {
        if (!bE()) {
            FrameLayout frameLayout = this.de;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            return false;
        }
        FrameLayout frameLayout2 = this.de;
        if (frameLayout2 == null) {
            return true;
        }
        frameLayout2.setVisibility(0);
        return true;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        this.de = frameLayout;
        this.dF = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        fK();
        this.GA = false;
    }

    public final void a(InterfaceC0352a interfaceC0352a) {
        this.GF = interfaceC0352a;
    }

    public final void a(b bVar) {
        this.GJ = bVar;
    }

    public final void a(com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this.cV = aVar;
    }

    public final void aF() {
        this.de.setVisibility(4);
        String strM = m(this.mAdTemplate);
        if (TextUtils.isEmpty(strM)) {
            return;
        }
        this.GB.loadUrl(strM);
    }

    public final a ah(boolean z2) {
        this.GD = z2;
        return this;
    }

    public final boolean az() {
        boolean zMe = me();
        this.GI = true;
        if (zMe && this.mActivity != null) {
            if (this.GB.getClientConfig() != null) {
                this.GB.getClientConfig().aY(true);
                this.GB.getClientConfig().aZ(true);
            }
            this.GE.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.i.a.5
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getX() > a.this.mBackIcon.getX() && motionEvent.getX() - a.this.mBackIcon.getX() < a.this.mBackIcon.getWidth() && motionEvent.getY() > a.this.mBackIcon.getY() && motionEvent.getY() - a.this.mBackIcon.getY() < a.this.mBackIcon.getHeight()) {
                        com.kwad.sdk.core.d.b.d("LandingPageWebCard", "onClick backIcon");
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        a.this.mLastDown = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime() - a.this.mLastDown;
                        if (a.this.mLastDown > 0 && jElapsedRealtime > 30 && jElapsedRealtime < 500) {
                            com.kwad.sdk.core.report.a.a(a.this.mAdTemplate, TbsListener.ErrorCode.NO_NEED_STARTDOWNLOAD, a.this.dF.getTouchCoords());
                            if (!a.this.GC) {
                                a.d(a.this, true);
                                if (a.this.cV != null) {
                                    com.kwad.sdk.core.webview.c.a.a aVar = new com.kwad.sdk.core.webview.c.a.a();
                                    aVar.Ty = 3;
                                    a.this.cV.onAdClicked(aVar);
                                }
                            }
                        }
                        a.this.mLastDown = 0L;
                    }
                    return false;
                }
            });
            long jAe = com.kwad.sdk.core.response.a.a.ae(d.cb(this.mAdTemplate));
            if (jAe == 0 || !this.GD) {
                this.mBackIcon.setVisibility(0);
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.i.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.mActivity == null || a.this.mActivity.isFinishing()) {
                            return;
                        }
                        a.this.mBackIcon.setVisibility(0);
                        a.this.mBackIcon.setAlpha(0.0f);
                        a.this.mBackIcon.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, jAe);
            }
            KsAdWebView ksAdWebView = this.GB;
            if (ksAdWebView != null) {
                ksAdWebView.onActivityCreate();
            }
        }
        return zMe;
    }

    public final void setActivity(Activity activity) {
        this.mActivity = activity;
    }
}
