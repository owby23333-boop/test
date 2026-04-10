package com.kwad.components.ad.fullscreen;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.kuaishou.pushad.KsAdGlobalWatcher;
import com.kwad.components.core.video.h;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwai.adclient.logger.model.BusinessType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements com.kwad.components.core.internal.api.a, KsFullScreenVideoAd {
    private com.kwad.components.core.internal.api.c ch = new com.kwad.components.core.internal.api.c();
    private c gj;
    private AdInfo mAdInfo;

    @NonNull
    private AdTemplate mAdTemplate;

    public e(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
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

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aK(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.aJ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aX(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.d.uD()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final boolean isAdEnable() {
        if (com.kwad.sdk.core.config.d.uJ() >= 0) {
            return true;
        }
        return h.i(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i2, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setBidEcpm(int i2) {
        setBidEcpm(i2, -1L);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setBidEcpm(long j2, long j3) {
        com.kwad.sdk.core.report.a.j(this.mAdTemplate, j3);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setFullScreenVideoAdInteractionListener(KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        if (this.gj == null) {
            this.gj = new c() { // from class: com.kwad.components.ad.fullscreen.e.1
                @Override // com.kwad.components.ad.fullscreen.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    e.this.ch.b(e.this);
                }

                @Override // com.kwad.components.ad.fullscreen.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onVideoPlayStart() {
                    super.onVideoPlayStart();
                    e.this.ch.a(e.this);
                }
            };
        }
        this.gj.a(fullScreenVideoAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void showFullScreenVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity == null || activity.isFinishing()) {
            com.kwad.sdk.core.d.b.e("KsFullScreenVideoAdControl", "showFullScreenVideoAd error, activity is null or finished");
            return;
        }
        com.kwad.sdk.f.a.T("fullscreen", TTLogUtil.TAG_EVENT_SHOW);
        com.kwad.components.ad.reward.monitor.a.a(false, this.mAdTemplate);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FULLSCREEN, "callShow").report();
        if (!isAdEnable()) {
            com.kwad.sdk.core.d.b.i("KsFullScreenVideoAdControl", "isAdEnable is false");
            com.kwad.sdk.f.a.U("fullscreen", TTLogUtil.TAG_EVENT_SHOW);
        } else {
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
            KsFullScreenVideoActivityProxy.launch(activity, this.mAdTemplate, ksVideoPlayConfig, this.gj);
        }
    }
}
