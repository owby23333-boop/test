package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.page.AdLandPageActivityProxy;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends com.kwad.sdk.mvp.a {
    private KsSplashScreenAd.SplashScreenAdInteractionListener BP;
    public int BR;

    @Nullable
    public com.kwad.components.ad.splashscreen.d.a BY;
    public com.kwad.sdk.core.g.a BZ;
    private List<g> Ca = new CopyOnWriteArrayList();
    private List<f> Cb = new CopyOnWriteArrayList();
    private boolean Cc = false;

    @NonNull
    public SceneImpl mAdScene;
    public com.kwad.components.core.d.b.c mApkDownloadHelper;

    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public bg mTimerHelper;

    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;

    public interface a {
        void b(@NonNull i iVar);
    }

    public static boolean d(Context context, AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.b.cC(adInfo) && com.kwad.sdk.core.response.a.a.aW(adInfo) && !com.kwad.components.ad.splashscreen.local.b.e(context, adInfo);
    }

    private void kR() {
        Iterator<g> it = this.Ca.iterator();
        while (it.hasNext()) {
            it.next().kL();
        }
    }

    private void kS() {
        Iterator<f> it = this.Cb.iterator();
        while (it.hasNext()) {
            it.next().kK();
        }
    }

    public final void a(int i2, Context context, final int i3, int i4, final a aVar) {
        com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        com.kwad.components.core.d.b.a.a(new a.C0395a(context).J(this.mAdTemplate).b(this.mApkDownloadHelper).ap(i4).al(false).ao(i3).an(i2).a(new a.b() { // from class: com.kwad.components.ad.splashscreen.h.1
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                if (h.this.BP != null) {
                    h.this.BP.onAdClicked();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (h.this.BY != null) {
                        jSONObject.put("duration", h.this.BY.getCurrentPosition());
                    }
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.b.printStackTrace(e2);
                }
                i iVarC = new i().bf(i3).c(h.this.mRootContainer.getTouchCoords());
                com.kwad.sdk.core.report.a.a(h.this.mAdTemplate, iVarC, jSONObject);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b(iVarC);
                }
            }
        }));
    }

    public final void a(f fVar) {
        if (fVar == null) {
            return;
        }
        this.Cb.add(fVar);
    }

    public final void a(g gVar) {
        this.Ca.add(gVar);
    }

    public final void ab(int i2) {
        Iterator<g> it = this.Ca.iterator();
        while (it.hasNext()) {
            it.next().aa(i2);
        }
    }

    public final void b(f fVar) {
        if (fVar == null) {
            return;
        }
        this.Cb.remove(fVar);
    }

    public final void b(g gVar) {
        this.Ca.remove(gVar);
    }

    public final void c(int i2, Context context, int i3, int i4) {
        a(i2, context, i3, i4, null);
    }

    @MainThread
    public final void f(int i2, String str) {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.BP;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(0, str);
        }
        com.kwad.components.splash.monitor.a.sp();
        com.kwad.components.splash.monitor.a.d(this.mAdTemplate, 0, String.valueOf(str));
        kR();
    }

    @MainThread
    public final void kM() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.BP;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
    }

    @MainThread
    public final void kN() {
        com.kwad.components.splash.monitor.a.sp();
        com.kwad.components.splash.monitor.a.h(this.mAdTemplate, SystemClock.elapsedRealtime() - this.mAdTemplate.showStartTime);
        com.kwad.components.ad.splashscreen.monitor.a.kY();
        com.kwad.sdk.kwai.kwai.c.tm().aR(true);
        bg bgVar = this.mTimerHelper;
        if (bgVar != null) {
            bgVar.startTiming();
        }
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.BP;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
    }

    @MainThread
    public final void kO() {
        if (this.Cc) {
            return;
        }
        this.Cc = true;
        if (!d(this.mRootContainer.getContext(), com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)) || this.mAdTemplate.converted) {
            y.a aVar = new y.a();
            bg bgVar = this.mTimerHelper;
            if (bgVar != null) {
                aVar.duration = bgVar.getTime();
            }
            com.kwad.sdk.core.report.a.b(this.mAdTemplate, new i().bg(14).bm(22).a(aVar), (JSONObject) null);
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.BP;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
        } else {
            kS();
        }
        kR();
    }

    @MainThread
    public final void kP() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.BP;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
    }

    @MainThread
    public final void kQ() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.BP;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
        kR();
    }

    public final void kT() {
        this.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.h.2
            @Override // java.lang.Runnable
            public final void run() {
                if (com.kwad.components.core.d.a.b.na() || AdLandPageActivityProxy.isDownloadDialogShowing()) {
                    h.this.mRootContainer.postDelayed(this, 1000L);
                } else {
                    h.this.kP();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.BY;
        if (aVar != null) {
            aVar.release();
        }
        com.kwad.sdk.core.g.a aVar2 = this.BZ;
        if (aVar2 != null) {
            aVar2.release();
        }
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.BP = splashScreenAdInteractionListener;
    }
}
