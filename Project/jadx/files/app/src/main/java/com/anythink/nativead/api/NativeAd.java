package com.anythink.nativead.api;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomVideo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.l;
import com.anythink.core.common.e.b;
import com.anythink.core.common.e.e;
import com.anythink.core.common.f;
import com.anythink.core.common.k.n;
import com.anythink.core.common.k.s;
import com.anythink.core.common.v;
import com.anythink.core.common.w;
import com.anythink.nativead.unitgroup.a;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NativeAd {
    private boolean hasSetShowTkDetail;
    private b mAdCacheInfo;
    protected a mBaseNativeAd;
    DownloadConfirmListener mConfirmListener;
    private Context mContext;
    private ATNativeDislikeListener mDislikeListener;
    ATEventInterface mEventInterface;
    private boolean mIsDestroyed;
    private ATNativeEventListener mNativeEventListener;
    ATNativeAdView mNativeView;
    private String mPlacementId;
    private boolean mRecordedImpression;
    private boolean mRecordedShow;
    ATNativeMaterial nativeMaterial;
    private final String TAG = NativeAd.class.getSimpleName();
    View.OnClickListener mDefaultCloseViewListener = new View.OnClickListener() { // from class: com.anythink.nativead.api.NativeAd.4
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar = NativeAd.this.mBaseNativeAd;
            if (aVar != null) {
                aVar.notifyAdDislikeClick();
            }
        }
    };
    boolean isManualImpressionTrack = false;

    public interface DownloadConfirmListener {
        void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo);
    }

    public interface ImpressionEventListener {
        void onImpression();
    }

    protected NativeAd(Context context, String str, b bVar) {
        this.mContext = context.getApplicationContext();
        this.mPlacementId = str;
        this.mAdCacheInfo = bVar;
        this.mBaseNativeAd = (a) this.mAdCacheInfo.f();
        this.mBaseNativeAd.setNativeEventListener(new l() { // from class: com.anythink.nativead.api.NativeAd.1
            @Override // com.anythink.core.common.b.l
            public final void onAdClicked(View view) {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleClick(nativeAd.mNativeView, view);
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdDislikeButtonClick() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleAdDislikeButtonClick(nativeAd.mNativeView);
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdImpressed() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleImpression(nativeAd.mNativeView);
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdVideoEnd() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleVideoEnd(nativeAd.mNativeView);
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdVideoProgress(int i2) {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleVideoProgress(nativeAd.mNativeView, i2);
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdVideoStart() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleVideoStart(nativeAd.mNativeView);
            }

            @Override // com.anythink.core.common.b.l
            public final void onDeeplinkCallback(boolean z2) {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleDeeplinkCallback(nativeAd.mNativeView, z2);
            }

            @Override // com.anythink.core.common.b.l
            public final void onDownloadConfirmCallback(Context context2, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                NativeAd.this.handleDownloadConfirm(context2, view, aTNetworkConfirmInfo);
            }
        });
        a aVar = this.mBaseNativeAd;
        if (aVar instanceof CustomNativeAd) {
            this.nativeMaterial = new com.anythink.nativead.a.b((CustomNativeAd) aVar);
        }
    }

    private void bindListener() {
        ATNativePrepareInfo nativePrepareInfo;
        View closeView;
        a aVar = this.mBaseNativeAd;
        if (aVar instanceof CustomNativeAd) {
            CustomNativeAd customNativeAd = (CustomNativeAd) aVar;
            if (customNativeAd.checkHasCloseViewListener() || (nativePrepareInfo = customNativeAd.getNativePrepareInfo()) == null || (closeView = nativePrepareInfo.getCloseView()) == null) {
                return;
            }
            closeView.setOnClickListener(this.mDefaultCloseViewListener);
        }
    }

    private void checkBindView(ATNativePrepareInfo aTNativePrepareInfo) {
        if (aTNativePrepareInfo == null) {
            return;
        }
        if (aTNativePrepareInfo.getTitleView() == null) {
            printNotSetViewLog("titleView");
        }
        if (aTNativePrepareInfo.getCtaView() == null) {
            printNotSetViewLog("ctaView");
        }
        if (aTNativePrepareInfo.getDescView() == null) {
            printNotSetViewLog("descView");
        }
        if (aTNativePrepareInfo.getIconView() == null) {
            printNotSetViewLog("iconView");
        }
        if (aTNativePrepareInfo.getMainImageView() == null) {
            printNotSetViewLog("mainImageView");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void fillShowTrackingInfo(e eVar) {
        if (!this.hasSetShowTkDetail) {
            String strB = w.a().b(this.mPlacementId);
            this.hasSetShowTkDetail = true;
            if (eVar != null) {
                eVar.f7248v = strB;
                s.a(this.mContext, eVar);
            }
        }
    }

    private void printNotSetViewLog(String str) {
        String str2 = "The " + str + " is not set, it may cause the ad to not be clicked normally.";
    }

    private void renderViewToWindow(View view) {
        n.b(this.mPlacementId, g.i.f6866l, g.i.f6873s, g.i.f6862h, "");
        ViewGroup customAdContainer = this.mBaseNativeAd.getCustomAdContainer();
        int iHashCode = hashCode();
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (customAdContainer != null) {
            if (customAdContainer.getParent() != null) {
                ((ViewGroup) customAdContainer.getParent()).removeView(customAdContainer);
            }
            customAdContainer.addView(view);
        }
        if (customAdContainer != null) {
            view = customAdContainer;
        }
        this.mNativeView.renderView(iHashCode, view, new ImpressionEventListener() { // from class: com.anythink.nativead.api.NativeAd.3
            @Override // com.anythink.nativead.api.NativeAd.ImpressionEventListener
            public final void onImpression() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                a aVar = NativeAd.this.mBaseNativeAd;
                e detail = aVar != null ? aVar.getDetail() : null;
                if (detail != null && TextUtils.isEmpty(detail.l())) {
                    detail.h(com.anythink.core.common.k.g.a(detail.X(), detail.x(), jCurrentTimeMillis));
                }
                a aVar2 = NativeAd.this.mBaseNativeAd;
                if (aVar2 instanceof CustomNativeAd) {
                    ((CustomNativeAd) aVar2).setShowId(detail.l());
                }
                NativeAd nativeAd = NativeAd.this;
                nativeAd.recordShow(nativeAd.mNativeView);
            }
        });
    }

    public synchronized void clear(ATNativeAdView aTNativeAdView) {
        if (this.mIsDestroyed) {
            return;
        }
        try {
            if (this.mBaseNativeAd != null) {
                this.mBaseNativeAd.clear(this.mNativeView);
            }
        } catch (Throwable unused) {
        }
        if (this.mNativeView != null) {
            this.mNativeView.clearImpressionListener(hashCode());
            this.mNativeView = null;
        }
    }

    public synchronized void destory() {
        if (this.mIsDestroyed) {
            return;
        }
        clear(this.mNativeView);
        this.mIsDestroyed = true;
        this.mNativeEventListener = null;
        this.mDislikeListener = null;
        this.mDefaultCloseViewListener = null;
        this.mNativeView = null;
        if (this.mBaseNativeAd != null) {
            this.mBaseNativeAd.destroy();
        }
    }

    public ATAdInfo getAdInfo() {
        return j.a(this.mBaseNativeAd);
    }

    public int getAdInteractionType() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return 0;
        }
        return ((CustomNativeAd) aVar).getNativeAdInteractionType();
    }

    public ATNativeMaterial getAdMaterial() {
        return this.nativeMaterial;
    }

    @Deprecated
    public ATCustomVideo getCustomVideo() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return null;
        }
        return ((CustomNativeAd) aVar).getNativeCustomVideo();
    }

    public int getNativeType() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return 0;
        }
        return ((CustomNativeAd) aVar).getNativeType();
    }

    public double getVideoDuration() {
        a aVar = this.mBaseNativeAd;
        return (aVar == null || !(aVar instanceof CustomNativeAd)) ? PangleAdapterUtils.CPM_DEFLAUT_VALUE : ((CustomNativeAd) aVar).getVideoDuration();
    }

    public double getVideoProgress() {
        a aVar = this.mBaseNativeAd;
        return (aVar == null || !(aVar instanceof CustomNativeAd)) ? PangleAdapterUtils.CPM_DEFLAUT_VALUE : ((CustomNativeAd) aVar).getVideoProgress();
    }

    synchronized void handleAdDislikeButtonClick(final ATNativeAdView aTNativeAdView) {
        if (this.mIsDestroyed) {
            return;
        }
        com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.9
            @Override // java.lang.Runnable
            public final void run() {
                if (NativeAd.this.mDislikeListener != null) {
                    NativeAd.this.mDislikeListener.onAdCloseButtonClick(aTNativeAdView, j.a(NativeAd.this.mBaseNativeAd));
                }
            }
        });
    }

    synchronized void handleClick(final ATNativeAdView aTNativeAdView, View view) {
        if (this.mIsDestroyed) {
            return;
        }
        if (this.mBaseNativeAd != null) {
            e detail = this.mBaseNativeAd.getDetail();
            com.anythink.core.common.k.g.a(detail, g.i.f6858d, g.i.f6860f, "");
            com.anythink.core.common.j.a.a(this.mContext.getApplicationContext()).a(6, detail);
        }
        com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.7
            @Override // java.lang.Runnable
            public final void run() {
                if (NativeAd.this.mNativeEventListener != null) {
                    NativeAd.this.mNativeEventListener.onAdClicked(aTNativeAdView, j.a(NativeAd.this.mBaseNativeAd));
                }
            }
        });
    }

    synchronized void handleDeeplinkCallback(ATNativeAdView aTNativeAdView, boolean z2) {
        if (this.mIsDestroyed) {
            return;
        }
        if (this.mNativeEventListener != null && (this.mNativeEventListener instanceof ATNativeEventExListener)) {
            ((ATNativeEventExListener) this.mNativeEventListener).onDeeplinkCallback(aTNativeAdView, j.a(this.mBaseNativeAd), z2);
        }
    }

    synchronized void handleDownloadConfirm(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        if (this.mIsDestroyed) {
            return;
        }
        if (this.mConfirmListener != null && this.mBaseNativeAd != null) {
            DownloadConfirmListener downloadConfirmListener = this.mConfirmListener;
            if (context == null) {
                context = this.mContext;
            }
            downloadConfirmListener.onDownloadConfirm(context, j.a(this.mBaseNativeAd), view, aTNetworkConfirmInfo);
        }
    }

    synchronized void handleImpression(final ATNativeAdView aTNativeAdView) {
        if (!this.mRecordedImpression && !this.mIsDestroyed) {
            this.mRecordedImpression = true;
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.6
                @Override // java.lang.Runnable
                public void run() {
                    if (NativeAd.this.mIsDestroyed) {
                        return;
                    }
                    try {
                        if (NativeAd.this.mBaseNativeAd != null) {
                            e detail = NativeAd.this.mBaseNativeAd.getDetail();
                            com.anythink.core.common.k.g.a(detail, g.i.f6857c, g.i.f6860f, "");
                            NativeAd.this.fillShowTrackingInfo(detail);
                            com.anythink.core.common.j.a.a(NativeAd.this.mContext.getApplicationContext()).a(4, detail, NativeAd.this.mAdCacheInfo.e().getUnitGroupInfo());
                            com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.6.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (NativeAd.this.mNativeEventListener != null) {
                                        ATNativeEventListener aTNativeEventListener = NativeAd.this.mNativeEventListener;
                                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                        aTNativeEventListener.onAdImpressed(aTNativeAdView, j.a(NativeAd.this.mBaseNativeAd));
                                    }
                                }
                            });
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    synchronized void handleVideoEnd(final ATNativeAdView aTNativeAdView) {
        if (this.mIsDestroyed) {
            return;
        }
        if (this.mBaseNativeAd != null) {
            e detail = this.mBaseNativeAd.getDetail();
            detail.f7246t = 100;
            com.anythink.core.common.j.a.a(this.mContext.getApplicationContext()).a(9, detail);
        }
        com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.10
            @Override // java.lang.Runnable
            public final void run() {
                if (NativeAd.this.mNativeEventListener != null) {
                    NativeAd.this.mNativeEventListener.onAdVideoEnd(aTNativeAdView);
                }
            }
        });
    }

    synchronized void handleVideoProgress(final ATNativeAdView aTNativeAdView, final int i2) {
        if (this.mIsDestroyed) {
            return;
        }
        com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.2
            @Override // java.lang.Runnable
            public final void run() {
                if (NativeAd.this.mNativeEventListener != null) {
                    NativeAd.this.mNativeEventListener.onAdVideoProgress(aTNativeAdView, i2);
                }
            }
        });
    }

    synchronized void handleVideoStart(final ATNativeAdView aTNativeAdView) {
        if (this.mIsDestroyed) {
            return;
        }
        if (this.mBaseNativeAd != null) {
            e detail = this.mBaseNativeAd.getDetail();
            detail.f7246t = 0;
            com.anythink.core.common.j.a.a(this.mContext.getApplicationContext()).a(8, detail);
        }
        com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.8
            @Override // java.lang.Runnable
            public final void run() {
                if (NativeAd.this.mNativeEventListener != null) {
                    NativeAd.this.mNativeEventListener.onAdVideoStart(aTNativeAdView);
                }
            }
        });
    }

    public boolean isNativeExpress() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return false;
        }
        return ((CustomNativeAd) aVar).isNativeExpress();
    }

    public void manualImpressionTrack() {
        if (this.mIsDestroyed) {
            return;
        }
        if (!this.isManualImpressionTrack) {
            com.anythink.core.common.b.n.a().A();
            return;
        }
        ATNativeAdView aTNativeAdView = this.mNativeView;
        b bVar = this.mAdCacheInfo;
        ATBaseAdAdapter aTBaseAdAdapterE = bVar != null ? bVar.e() : null;
        if (aTBaseAdAdapterE != null && aTBaseAdAdapterE.supportImpressionCallback()) {
            com.anythink.core.common.b.n.a().A();
            return;
        }
        if (aTNativeAdView == null) {
            com.anythink.core.common.b.n.a().A();
            return;
        }
        if (!aTNativeAdView.isShown()) {
            com.anythink.core.common.b.n.a().A();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            if (!aTNativeAdView.isAttachedToWindow()) {
                com.anythink.core.common.b.n.a().A();
                return;
            }
        } else if (!aTNativeAdView.isAttachInWindow()) {
            com.anythink.core.common.b.n.a().A();
            return;
        }
        com.anythink.core.common.b.n.a().A();
        a aVar = this.mBaseNativeAd;
        if (aVar instanceof CustomNativeAd) {
            ((CustomNativeAd) aVar).impressionTrack(aTNativeAdView);
        }
    }

    public void onPause() {
        a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.onPause();
    }

    public void onResume() {
        a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.onResume();
    }

    public void pauseVideo() {
        a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.pauseVideo();
    }

    public synchronized void prepare(ATNativeAdView aTNativeAdView, ATNativePrepareInfo aTNativePrepareInfo) {
        if (this.mIsDestroyed) {
            return;
        }
        if (aTNativeAdView != null) {
            if (aTNativePrepareInfo == null) {
                aTNativePrepareInfo = new ATNativePrepareInfo();
            }
            this.mBaseNativeAd.setNativePrepareInfo(aTNativePrepareInfo);
            this.mBaseNativeAd.prepare(aTNativeAdView, aTNativePrepareInfo);
            bindListener();
            if (!this.mBaseNativeAd.isNativeExpress()) {
                checkBindView(aTNativePrepareInfo);
            }
        }
    }

    synchronized void recordShow(ATNativeAdView aTNativeAdView) {
        if (!this.mRecordedShow) {
            final e detail = this.mBaseNativeAd.getDetail();
            this.mRecordedShow = true;
            if (this.mAdCacheInfo != null) {
                this.mAdCacheInfo.a(this.mAdCacheInfo.d() + 1);
                f fVarB = v.a().b(this.mPlacementId);
                if (fVarB != null) {
                    fVarB.a(this.mAdCacheInfo);
                    fVarB.f();
                }
            }
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (NativeAd.this.mIsDestroyed || NativeAd.this.mAdCacheInfo == null) {
                        return;
                    }
                    NativeAd.this.fillShowTrackingInfo(detail);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        jCurrentTimeMillis = Long.parseLong(detail.l().split("_")[r2.length - 1]);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    long j2 = jCurrentTimeMillis;
                    a aVar = NativeAd.this.mBaseNativeAd;
                    if (aVar != null && (aVar instanceof CustomNativeAd)) {
                        ((CustomNativeAd) aVar).setShowId(detail.l());
                    }
                    com.anythink.core.common.a.a().a(NativeAd.this.mContext.getApplicationContext(), NativeAd.this.mAdCacheInfo);
                    com.anythink.core.common.j.a.a(NativeAd.this.mContext).a(13, detail, NativeAd.this.mAdCacheInfo.e().getUnitGroupInfo(), j2);
                }
            });
        }
    }

    public synchronized void renderAdContainer(ATNativeAdView aTNativeAdView, View view) {
        if (this.mIsDestroyed) {
            return;
        }
        if (aTNativeAdView != null) {
            aTNativeAdView.clear();
        }
        if (isNativeExpress()) {
            if (this.mBaseNativeAd == null) {
                view = null;
            } else {
                if (aTNativeAdView == null) {
                    return;
                }
                view = this.mBaseNativeAd.getAdMediaView(aTNativeAdView, Integer.valueOf(aTNativeAdView.getWidth()));
                if (view == null) {
                    return;
                }
            }
        } else if (view == null) {
            return;
        }
        this.mNativeView = aTNativeAdView;
        if (this.mNativeView != null) {
            this.mNativeView.attachNativeAd(this);
        }
        if (view != null) {
            view.setVisibility(0);
            renderViewToWindow(view);
        }
    }

    public void resumeVideo() {
        a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.resumeVideo();
    }

    public void setAdDownloadListener(ATEventInterface aTEventInterface) {
        this.mEventInterface = aTEventInterface;
        IExHandler iExHandlerB = com.anythink.core.common.b.n.a().b();
        if (iExHandlerB == null) {
            this.mBaseNativeAd.setDownloadListener(null);
        } else if (aTEventInterface != null) {
            this.mBaseNativeAd.setDownloadListener(iExHandlerB.createDownloadListener(this.mAdCacheInfo.e(), this.mBaseNativeAd, aTEventInterface));
        } else {
            this.mBaseNativeAd.setDownloadListener(null);
        }
    }

    public void setDislikeCallbackListener(ATNativeDislikeListener aTNativeDislikeListener) {
        if (this.mIsDestroyed) {
            return;
        }
        this.mDislikeListener = aTNativeDislikeListener;
    }

    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        if (downloadConfirmListener != null) {
            a aVar = this.mBaseNativeAd;
            if (aVar instanceof CustomNativeAd) {
                ((CustomNativeAd) aVar).registerDownloadConfirmListener();
            }
        } else {
            a aVar2 = this.mBaseNativeAd;
            if (aVar2 instanceof CustomNativeAd) {
                ((CustomNativeAd) aVar2).unregeisterDownloadConfirmListener();
            }
        }
        this.mConfirmListener = downloadConfirmListener;
    }

    public void setManualImpressionTrack(boolean z2) {
        this.isManualImpressionTrack = z2;
    }

    public void setNativeEventListener(ATNativeEventListener aTNativeEventListener) {
        if (this.mIsDestroyed) {
            return;
        }
        this.mNativeEventListener = aTNativeEventListener;
    }

    public void setVideoMute(boolean z2) {
        a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.setVideoMute(z2);
    }
}
