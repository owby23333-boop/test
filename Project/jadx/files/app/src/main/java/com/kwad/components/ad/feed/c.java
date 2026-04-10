package com.kwad.components.ad.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.kuaishou.pushad.KsAdGlobalWatcher;
import com.kwad.components.ad.feed.a.m;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.core.AbstractKsFeedAd;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwai.adclient.logger.model.BusinessType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends AbstractKsFeedAd implements com.kwad.components.core.internal.api.a {
    private KsFeedAd.AdInteractionListener dU;
    private com.kwad.components.core.widget.b dV;
    private com.kwad.components.core.widget.b dW;
    private boolean dX;
    private final KsAdVideoPlayConfig dY;
    private final AdInfo mAdInfo;

    @NonNull
    private final AdTemplate mAdTemplate;
    private com.kwad.components.core.internal.api.c ch = new com.kwad.components.core.internal.api.c();
    private com.kwad.sdk.core.g.b cb = new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.feed.c.1
        @Override // com.kwad.sdk.core.g.b
        public final void ap() {
            c.this.ch.a(c.this);
        }

        @Override // com.kwad.sdk.core.g.b
        public final void aq() {
            c.this.ch.b(c.this);
        }
    };

    public static class a {
        int ed;
        int size;

        public a(int i2) {
            this.size = i2;
        }

        public final int aZ() {
            return this.ed;
        }

        public final boolean ba() {
            this.ed++;
            return this.ed == this.size;
        }
    }

    public interface b {
        void c(int i2, String str);
    }

    public c(@NonNull AdTemplate adTemplate, boolean z2) {
        this.mAdTemplate = adTemplate;
        this.mAdTemplate.mInitVoiceStatus = 1;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.dX = z2;
        this.dY = new KSAdVideoPlayConfigImpl();
        KsAdGlobalWatcher.getInstance().watch(this);
    }

    @Nullable
    private com.kwad.components.core.widget.b<?> E(Context context) {
        com.kwad.components.core.widget.b<?> bVarA;
        if (this.dX && com.kwad.sdk.core.response.a.b.br(this.mAdTemplate)) {
            try {
                m mVar = new m(Wrapper.wrapContextIfNeed(context));
                mVar.setWidth(this.mAdTemplate.mAdScene.getWidth());
                mVar.setVideoPlayConfig(this.dY);
                bVarA = mVar;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                bVarA = null;
            }
        } else {
            bVarA = com.kwad.components.ad.feed.b.a(context, FeedType.fromInt(this.mAdTemplate.type), com.kwad.sdk.core.response.a.a.aX(this.mAdInfo));
        }
        if (bVarA != null) {
            bVarA.setPageExitListener(this.cb);
        }
        return bVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.components.core.widget.b bVar, final boolean z2) {
        if (bVar == null) {
            return;
        }
        bVar.setInnerAdInteractionListener(new b.InterfaceC0422b() { // from class: com.kwad.components.ad.feed.c.3
            @Override // com.kwad.components.core.widget.b.InterfaceC0422b
            public final void onAdClicked() {
                if (c.this.dU != null) {
                    c.this.dU.onAdClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0422b
            public final void onAdShow() {
                com.kwad.components.ad.feed.monitor.a.bg();
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FEED, "adShowSuccess").report();
                if (c.this.dU != null) {
                    c.this.dU.onAdShow();
                }
                if (z2) {
                    i iVar = new i();
                    y.a aVar = new y.a();
                    FeedType feedTypeFromInt = FeedType.fromInt(c.this.mAdTemplate.type);
                    if (feedTypeFromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        feedTypeFromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    aVar.templateId = String.valueOf(feedTypeFromInt.getType());
                    iVar.a(aVar);
                    iVar.p(c.this.dV.getHeight(), c.this.dV.getWidth());
                    com.kwad.components.core.r.c.qa().a(c.this.mAdTemplate, null, iVar);
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0422b
            public final void onDislikeClicked() {
                if (c.this.dU != null) {
                    c.this.dU.onDislikeClicked();
                    try {
                        if (bVar.getParent() instanceof ViewGroup) {
                            ((ViewGroup) bVar.getParent()).removeView(bVar);
                        }
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.b.printStackTrace(e2);
                    }
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0422b
            public final void onDownloadTipsDialogDismiss() {
                if (c.this.dU != null) {
                    try {
                        c.this.dU.onDownloadTipsDialogDismiss();
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0422b
            public final void onDownloadTipsDialogShow() {
                if (c.this.dU != null) {
                    try {
                        c.this.dU.onDownloadTipsDialogShow();
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    private void aY() {
        if (this.mAdTemplate != null) {
            com.kwad.sdk.core.diskcache.a.a.vE().remove("feed_ad_cache_" + this.mAdTemplate.posId);
        }
    }

    private boolean isVideoSoundEnable() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dY;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                return kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            }
        }
        return com.kwad.sdk.core.response.a.a.bF(this.mAdInfo);
    }

    public final void a(Context context, @NonNull final b bVar) {
        com.kwad.sdk.f.a.e(IAdInterListener.AdProdType.PRODUCT_FEEDS, TTLogUtil.TAG_EVENT_SHOW, "feed_preload_view");
        Context contextWrapContextIfNeed = Wrapper.wrapContextIfNeed(context);
        this.dW = E(contextWrapContextIfNeed);
        if (this.dW != null) {
            this.dW.setMargin(com.kwad.sdk.b.kwai.a.a(contextWrapContextIfNeed, 16.0f));
            com.kwad.components.core.widget.b bVar2 = this.dW;
            if (bVar2 instanceof m) {
                m mVar = (m) bVar2;
                mVar.setPreloadListener(new m.a() { // from class: com.kwad.components.ad.feed.c.2
                    @Override // com.kwad.components.ad.feed.a.m.a
                    public final void c(int i2, String str) {
                        c cVar = c.this;
                        cVar.a(cVar.dW, false);
                        bVar.c(i2, str);
                    }
                });
                mVar.bindView(this.mAdTemplate);
            } else {
                bVar2.bindView(this.mAdTemplate);
                com.kwad.components.core.widget.b bVar3 = this.dW;
                if (bVar3 instanceof com.kwad.components.ad.feed.a.c) {
                    ((com.kwad.components.ad.feed.a.c) bVar3).a(this.dY);
                }
                a(this.dW, true);
                bVar.c(1, "");
            }
        } else {
            bVar.c(1, "");
        }
        com.kwad.sdk.f.a.f(IAdInterListener.AdProdType.PRODUCT_FEEDS, TTLogUtil.TAG_EVENT_SHOW, "feed_preload_view");
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

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aK(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public final View getFeedView2(Context context) {
        if (context == null || !KsAdSDKImpl.get().hasInitFinish()) {
            return null;
        }
        try {
            Context contextWrapContextIfNeed = Wrapper.wrapContextIfNeed(context);
            com.kwad.sdk.f.a.T(IAdInterListener.AdProdType.PRODUCT_FEEDS, TTLogUtil.TAG_EVENT_SHOW);
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FEED, "callShow").report();
            if (this.dV == null) {
                aY();
                if (this.dW != null) {
                    this.dV = this.dW;
                    com.kwad.sdk.f.a.U(IAdInterListener.AdProdType.PRODUCT_FEEDS, TTLogUtil.TAG_EVENT_SHOW);
                    return this.dV;
                }
                this.dV = E(contextWrapContextIfNeed);
            } else if (this.dV.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dV.getParent()).removeView(this.dV);
            }
            if (this.dV != null) {
                this.dV.bindView(this.mAdTemplate);
                if (this.dV instanceof com.kwad.components.ad.feed.a.c) {
                    ((com.kwad.components.ad.feed.a.c) this.dV).a(this.dY);
                }
                if (this.dV instanceof m) {
                    a(this.dV, false);
                } else {
                    a(this.dV, true);
                }
            }
            com.kwad.sdk.f.a.U(IAdInterListener.AdProdType.PRODUCT_FEEDS, TTLogUtil.TAG_EVENT_SHOW);
        } catch (Throwable th) {
            if (!KsAdSDKImpl.get().getIsExternal()) {
                throw th;
            }
            com.kwad.components.core.c.a.b(th);
        }
        return this.dV;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.aJ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
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

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i2, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.dU = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(int i2) {
        setBidEcpm(i2, -1L);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(long j2, long j3) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j2;
        com.kwad.sdk.core.report.a.j(adTemplate, j3);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    @SuppressLint({"WrongConstant"})
    public final void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i2;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.dY.setVideoSoundEnable(kSAdVideoPlayConfigImpl.isVideoSoundEnable());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() != 0) {
                this.dY.setVideoAutoPlayType(kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                this.dY.setDataFlowAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
            } else {
                this.dY.setDataFlowAutoStart(com.kwad.sdk.core.config.d.uK());
            }
            com.kwad.components.core.widget.b bVar = this.dW;
            if (bVar instanceof m) {
                ((m) bVar).setVideoPlayConfig(this.dY);
            }
            com.kwad.components.core.widget.b bVar2 = this.dW;
            if (bVar2 instanceof com.kwad.components.ad.feed.a.c) {
                ((com.kwad.components.ad.feed.a.c) bVar2).setVideoPlayConfig(this.dY);
            }
        }
        if (isVideoSoundEnable()) {
            adTemplate = this.mAdTemplate;
            i2 = 2;
        } else {
            adTemplate = this.mAdTemplate;
            i2 = 1;
        }
        adTemplate.mInitVoiceStatus = i2;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setVideoSoundEnable(boolean z2) {
        AdTemplate adTemplate;
        int i2;
        this.dY.setVideoSoundEnable(z2);
        if (this.dY.isVideoSoundEnable()) {
            adTemplate = this.mAdTemplate;
            i2 = 2;
        } else {
            adTemplate = this.mAdTemplate;
            i2 = 1;
        }
        adTemplate.mInitVoiceStatus = i2;
    }
}
