package com.kwad.components.ad.draw;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.kuaishou.pushad.KsAdGlobalWatcher;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.core.AbstractKsDrawAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends AbstractKsDrawAd implements com.kwad.components.core.internal.api.a {

    @Nullable
    private KsDrawAd.AdInteractionListener bV;
    private b cg;
    private com.kwad.components.core.internal.api.c ch = new com.kwad.components.core.internal.api.c();

    @NonNull
    private AdTemplate mAdTemplate;

    public c(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.bh(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)).getUrl(), this.mAdTemplate);
        KsAdGlobalWatcher.getInstance().watch(this);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.ch.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ao() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.ch.b(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public final View getDrawView2(Context context) {
        com.kwad.sdk.f.a.T("draw", TTLogUtil.TAG_EVENT_SHOW);
        if (this.cg == null) {
            this.cg = new b(context);
            this.cg.setPageExitListener(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.draw.c.1
                @Override // com.kwad.sdk.core.g.b
                public final void ap() {
                    c.this.ch.a(c.this);
                }

                @Override // com.kwad.sdk.core.g.b
                public final void aq() {
                    c.this.ch.b(c.this);
                }
            });
            this.cg.setAdInteractionListener(new KsDrawAd.AdInteractionListener() { // from class: com.kwad.components.ad.draw.c.2
                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public final void onAdClicked() {
                    if (c.this.bV != null) {
                        c.this.bV.onAdClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public final void onAdShow() {
                    if (c.this.bV != null) {
                        c.this.bV.onAdShow();
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public final void onVideoPlayEnd() {
                    if (c.this.bV != null) {
                        try {
                            c.this.bV.onVideoPlayEnd();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public final void onVideoPlayError() {
                    if (c.this.bV != null) {
                        try {
                            c.this.bV.onVideoPlayError();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public final void onVideoPlayPause() {
                    if (c.this.bV != null) {
                        try {
                            c.this.bV.onVideoPlayPause();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public final void onVideoPlayResume() {
                    if (c.this.bV != null) {
                        try {
                            c.this.bV.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public final void onVideoPlayStart() {
                    if (c.this.bV != null) {
                        try {
                            c.this.bV.onVideoPlayStart();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                }
            });
            this.cg.a(this.mAdTemplate);
        } else {
            com.kwad.sdk.core.d.b.i("KSDrawAdControl", "mDrawVideoView is not null");
        }
        com.kwad.sdk.f.a.U("draw", TTLogUtil.TAG_EVENT_SHOW);
        return this.cg;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aK(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.aJ(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aX(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.d.uD()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i2, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.bV = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(int i2) {
        setBidEcpm(i2, -1L);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(long j2, long j3) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j2;
        com.kwad.sdk.core.report.a.j(adTemplate, j3);
    }
}
