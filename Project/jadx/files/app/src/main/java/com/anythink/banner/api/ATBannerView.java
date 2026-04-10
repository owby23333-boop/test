package com.anythink.banner.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.banner.a.d;
import com.anythink.banner.a.e;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.a;
import com.anythink.core.common.b.b;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.a.c;
import com.anythink.core.common.k.a.f;
import com.anythink.core.common.k.g;
import com.anythink.core.common.k.s;
import com.anythink.core.common.v;
import com.anythink.core.common.w;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ATBannerView extends FrameLayout implements d {
    private final String TAG;
    a adLoadListener;
    private boolean canRenderBanner;
    boolean hasTouchWindow;
    c impressionTracker;
    private com.anythink.banner.a.a mAdLoadManager;
    b mAdSourceEventListener;
    private com.anythink.banner.b.a mBannerRefreshTimer;
    CustomBannerAdapter mCustomBannerAd;
    ATAdSourceStatusListener mDeveloperStatusListener;
    ATEventInterface mDownloadListener;
    private e mInnerBannerListener;
    boolean mIsRefresh;
    private ATBannerListener mListener;
    private String mPlacementId;
    private String mScenario;
    Map<String, Object> mTKExtraMap;
    f.b visibilityChecker;

    public ATBannerView(Context context) {
        super(context);
        this.TAG = ATBannerView.class.getSimpleName();
        this.mScenario = "";
        this.hasTouchWindow = false;
        this.mIsRefresh = false;
        this.mInnerBannerListener = new e() { // from class: com.anythink.banner.api.ATBannerView.1
            @Override // com.anythink.banner.a.e
            public void onBannerClicked(final CustomBannerAdapter customBannerAdapter) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClicked(j.a(customBannerAdapter));
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onBannerClose(final CustomBannerAdapter customBannerAdapter) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClose(j.a(customBannerAdapter));
                        }
                    }
                });
                ATBannerView.this.canRenderBanner = true;
                ATBannerView.this.loadAd(1);
            }

            @Override // com.anythink.banner.a.e
            public void onBannerShow(final CustomBannerAdapter customBannerAdapter, final boolean z2) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            if (customBannerAdapter == null || !z2) {
                                ATBannerView.this.mListener.onBannerShow(j.a(customBannerAdapter));
                            } else {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(j.a(customBannerAdapter));
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onDeeplinkCallback(final CustomBannerAdapter customBannerAdapter, final boolean z2) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDeeplinkCallback(ATBannerView.this.mIsRefresh, j.a(customBannerAdapter), z2);
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onDownloadConfirm(final Context context2, final CustomBannerAdapter customBannerAdapter, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDownloadConfirm(context2, j.a(customBannerAdapter), aTNetworkConfirmInfo);
                    }
                });
            }
        };
        this.adLoadListener = new a() { // from class: com.anythink.banner.api.ATBannerView.2
            @Override // com.anythink.core.common.b.a
            public void onAdLoadFail(final AdError adError) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !ATBannerView.this.canRenderBanner) {
                            return;
                        }
                        ATBannerView aTBannerView = ATBannerView.this;
                        if (aTBannerView.mIsRefresh) {
                            aTBannerView.mListener.onBannerAutoRefreshFail(adError);
                        } else {
                            aTBannerView.mListener.onBannerFailed(adError);
                        }
                    }
                });
                if (ATBannerView.this.mAdLoadManager == null || !ATBannerView.this.isInView() || ATBannerView.this.mBannerRefreshTimer.a()) {
                    return;
                }
                String unused = ATBannerView.this.TAG;
                ATBannerView.this.mBannerRefreshTimer.b();
            }

            @Override // com.anythink.core.common.b.a
            public void onAdLoaded() {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView aTBannerView = ATBannerView.this;
                            if (!aTBannerView.mIsRefresh) {
                                aTBannerView.mListener.onBannerLoaded();
                            }
                        }
                        ATBannerView.this.controlShow();
                    }
                });
            }
        };
        this.mBannerRefreshTimer = new com.anythink.banner.b.a(this);
    }

    private boolean checkVisibilityPercent() {
        if (this.visibilityChecker == null) {
            this.visibilityChecker = new f.b();
        }
        if (getParent() != null) {
            return this.visibilityChecker.a((View) getParent(), this, 80, 0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.anythink.core.common.e.b getBannerCache() {
        return com.anythink.core.common.a.a().a(getContext(), this.mPlacementId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInView() {
        if (this.hasTouchWindow && isShown()) {
            return this.mCustomBannerAd == null || checkVisibilityPercent();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRefreshOpen() {
        com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(getContext().getApplicationContext()).a(this.mPlacementId);
        return dVarA != null && dVarA.V() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBannerImpression(final Context context, final ATBaseAdAdapter aTBaseAdAdapter, final boolean z2) {
        final com.anythink.core.common.e.e trackingInfo = aTBaseAdAdapter.getTrackingInfo();
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.6
            @Override // java.lang.Runnable
            public void run() {
                g.a(trackingInfo, g.i.f6857c, g.i.f6860f, "");
                com.anythink.core.common.j.a.a(context).a(4, trackingInfo, aTBaseAdAdapter.getUnitGroupInfo());
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.6.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            if (aTBaseAdAdapter == null || !z2) {
                                ATBannerView.this.mListener.onBannerShow(j.a(aTBaseAdAdapter));
                            } else {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(j.a(aTBaseAdAdapter));
                            }
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBannerShow(final Context context, final com.anythink.core.common.e.b bVar, final boolean z2) {
        final ATBaseAdAdapter aTBaseAdAdapterE = bVar.e();
        final com.anythink.core.common.e.e trackingInfo = aTBaseAdAdapterE.getTrackingInfo();
        trackingInfo.f7248v = w.a().b(trackingInfo.W());
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (trackingInfo != null && TextUtils.isEmpty(trackingInfo.l())) {
            trackingInfo.h(com.anythink.core.common.k.g.a(trackingInfo.X(), trackingInfo.x(), jCurrentTimeMillis));
        }
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.5
            @Override // java.lang.Runnable
            public final void run() {
                if (trackingInfo != null) {
                    s.a(ATBannerView.this.getContext(), trackingInfo);
                    com.anythink.core.common.a.a().a(context.getApplicationContext(), bVar);
                    com.anythink.core.common.j.a.a(context).a(13, trackingInfo, aTBaseAdAdapterE.getUnitGroupInfo(), jCurrentTimeMillis);
                    if (aTBaseAdAdapterE.supportImpressionCallback()) {
                        return;
                    }
                    ATBannerView.this.notifyBannerImpression(context, aTBaseAdAdapterE, z2);
                }
            }
        });
    }

    private void registerDelayShow(final Context context, final com.anythink.core.common.e.b bVar, CustomBannerAdapter customBannerAdapter, final boolean z2) {
        View bannerView = customBannerAdapter.getBannerView();
        if (bannerView == null) {
            bannerView = this;
        }
        c cVar = this.impressionTracker;
        if (cVar != null) {
            cVar.a(bannerView, new com.anythink.core.common.k.a.a() { // from class: com.anythink.banner.api.ATBannerView.3
                @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
                public final int getImpressionMinPercentageViewed() {
                    return 50;
                }

                @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
                public final int getImpressionMinTimeViewed() {
                    return 0;
                }

                @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
                public final void recordImpression(View view) {
                    ATBannerView.this.notifyBannerShow(context, bVar, z2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderBannerView(com.anythink.core.common.e.b bVar, boolean z2) {
        CustomBannerAdapter customBannerAdapter = (bVar == null || !(bVar.e() instanceof CustomBannerAdapter)) ? null : (CustomBannerAdapter) bVar.e();
        if (customBannerAdapter != null) {
            CustomBannerAdapter customBannerAdapter2 = this.mCustomBannerAd;
            if (customBannerAdapter2 != null) {
                customBannerAdapter2.destory();
            }
            View bannerView = customBannerAdapter.getBannerView();
            if (bannerView != null && bannerView.getParent() != null && bannerView.getParent() != this) {
                ((ViewGroup) bannerView.getParent()).removeView(bannerView);
            }
            this.mCustomBannerAd = customBannerAdapter;
            if (bannerView != null) {
                com.anythink.core.common.e.e trackingInfo = this.mCustomBannerAd.getTrackingInfo();
                trackingInfo.C = this.mScenario;
                s.a(this.mTKExtraMap, trackingInfo);
                customBannerAdapter.setAdEventListener(new com.anythink.banner.a.b(this.mInnerBannerListener, customBannerAdapter, z2));
                if (isInView()) {
                    notifyBannerShow(getContext().getApplicationContext(), bVar, z2);
                } else {
                    registerDelayShow(getContext().getApplicationContext(), bVar, customBannerAdapter, z2);
                }
                IExHandler iExHandlerB = n.a().b();
                if (iExHandlerB != null) {
                    customBannerAdapter.setAdDownloadListener(iExHandlerB.createDownloadListener(customBannerAdapter, null, this.mDownloadListener));
                }
                removeAllViews();
                int i2 = bannerView.getLayoutParams() != null ? bannerView.getLayoutParams().width : 0;
                if (i2 == 0) {
                    i2 = -2;
                }
                int i3 = bannerView.getLayoutParams() != null ? bannerView.getLayoutParams().height : 0;
                if (i3 <= 0) {
                    i3 = -2;
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i3);
                layoutParams.gravity = 17;
                bannerView.setLayoutParams(layoutParams);
                if (bannerView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) bannerView.getParent()).removeView(bannerView);
                }
                addView(bannerView, layoutParams);
            }
            this.mAdLoadManager.a(bVar);
            this.mBannerRefreshTimer.b();
            if (isRefreshOpen()) {
                loadAd(1);
            }
        }
    }

    public ATAdStatusInfo checkAdStatus() {
        if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q())) {
            return new ATAdStatusInfo(false, false, null);
        }
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        if (aVar == null) {
            return new ATAdStatusInfo(false, false, null);
        }
        ATAdStatusInfo aTAdStatusInfoA = aVar.a(getContext(), this.mTKExtraMap);
        com.anythink.core.common.k.n.b(this.mPlacementId, g.i.f6863i, g.i.f6875u, aTAdStatusInfoA.toString(), "");
        return aTAdStatusInfoA;
    }

    public List<ATAdInfo> checkValidAdCaches() {
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            return aVar.a(getContext());
        }
        return null;
    }

    protected void controlShow() {
        if (this.mAdLoadManager == null) {
            return;
        }
        final boolean z2 = this.mIsRefresh;
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ATBannerView.this.mAdLoadManager) {
                    if (!ATBannerView.this.canRenderBanner) {
                        String unused = ATBannerView.this.TAG;
                        return;
                    }
                    final com.anythink.core.common.e.b bannerCache = ATBannerView.this.getBannerCache();
                    boolean z3 = false;
                    if (bannerCache != null) {
                        if (ATBannerView.this.isInView()) {
                            bannerCache.a(bannerCache.d() + 1);
                            ATBannerView.this.canRenderBanner = false;
                            n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.4.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    ATBannerView.this.renderBannerView(bannerCache, z2);
                                }
                            });
                        } else {
                            if (ATBannerView.this.hasTouchWindow && ATBannerView.this.isShown()) {
                                z3 = true;
                            } else {
                                ATBannerView.this.mBannerRefreshTimer.d();
                            }
                            String unused2 = ATBannerView.this.TAG;
                        }
                    } else if (ATBannerView.this.isRefreshOpen() && ATBannerView.this.mAdLoadManager != null && !ATBannerView.this.mAdLoadManager.e()) {
                        ATBannerView.this.loadAd(1);
                        if (ATBannerView.this.hasTouchWindow && ATBannerView.this.isShown()) {
                            z3 = true;
                        }
                    }
                    if (z3 && ATBannerView.this.mBannerRefreshTimer != null && ATBannerView.this.mBannerRefreshTimer.c()) {
                        ATBannerView.this.mBannerRefreshTimer.b();
                    }
                }
            }
        });
    }

    public void destroy() {
        removeAllViews();
        CustomBannerAdapter customBannerAdapter = this.mCustomBannerAd;
        if (customBannerAdapter != null) {
            customBannerAdapter.destory();
        }
        com.anythink.banner.b.a aVar = this.mBannerRefreshTimer;
        if (aVar != null) {
            aVar.d();
        }
        c cVar = this.impressionTracker;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void loadAd() {
        loadAd(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.hasTouchWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.hasTouchWindow = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            controlShow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            controlShow();
        }
    }

    public void setAdDownloadListener(ATEventInterface aTEventInterface) {
        IExHandler iExHandlerB;
        this.mDownloadListener = aTEventInterface;
        if (this.mCustomBannerAd == null || (iExHandlerB = n.a().b()) == null) {
            return;
        }
        CustomBannerAdapter customBannerAdapter = this.mCustomBannerAd;
        customBannerAdapter.setAdDownloadListener(iExHandlerB.createDownloadListener(customBannerAdapter, null, this.mDownloadListener));
    }

    public void setAdSourceStatusListener(ATAdSourceStatusListener aTAdSourceStatusListener) {
        if (this.mAdSourceEventListener == null) {
            this.mAdSourceEventListener = new b();
        }
        this.mDeveloperStatusListener = aTAdSourceStatusListener;
        this.mAdSourceEventListener.a(this.mDeveloperStatusListener);
    }

    public void setBannerAdListener(ATBannerListener aTBannerListener) {
        this.mListener = aTBannerListener;
    }

    public void setLocalExtra(Map<String, Object> map) {
        if (TextUtils.isEmpty(this.mPlacementId)) {
            return;
        }
        v.a().a(this.mPlacementId, map);
    }

    public void setPlacementId(String str) {
        this.mAdLoadManager = com.anythink.banner.a.a.a(getContext(), str);
        this.mPlacementId = str;
        this.mBannerRefreshTimer.a(str);
        if (this.impressionTracker == null) {
            getContext();
            this.impressionTracker = new c(50);
        }
    }

    public void setScenario(String str) {
        if (com.anythink.core.common.k.g.c(str)) {
            this.mScenario = str;
        }
    }

    public void setTKExtra(Map<String, Object> map) {
        if (this.mTKExtraMap == null) {
            this.mTKExtraMap = new ConcurrentHashMap();
        }
        this.mTKExtraMap.clear();
        this.mTKExtraMap.putAll(map);
    }

    @Override // com.anythink.banner.a.d
    public void timeUpRefreshView() {
        this.canRenderBanner = true;
        controlShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(int i2) {
        com.anythink.core.common.k.n.a(this.mPlacementId, g.i.f6863i, g.i.f6871q, g.i.f6862h, "", true);
        this.mIsRefresh = i2 == 1;
        if (i2 == 0) {
            this.canRenderBanner = true;
        }
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.a(getContext(), i2, this.adLoadListener, this.mAdSourceEventListener, this.mTKExtraMap);
        } else {
            this.adLoadListener.onAdLoadFail(ErrorCode.getErrorCode(ErrorCode.placeStrategyError, "", ""));
        }
    }

    public ATBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = ATBannerView.class.getSimpleName();
        this.mScenario = "";
        this.hasTouchWindow = false;
        this.mIsRefresh = false;
        this.mInnerBannerListener = new e() { // from class: com.anythink.banner.api.ATBannerView.1
            @Override // com.anythink.banner.a.e
            public void onBannerClicked(final CustomBannerAdapter customBannerAdapter) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClicked(j.a(customBannerAdapter));
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onBannerClose(final CustomBannerAdapter customBannerAdapter) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClose(j.a(customBannerAdapter));
                        }
                    }
                });
                ATBannerView.this.canRenderBanner = true;
                ATBannerView.this.loadAd(1);
            }

            @Override // com.anythink.banner.a.e
            public void onBannerShow(final CustomBannerAdapter customBannerAdapter, final boolean z2) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            if (customBannerAdapter == null || !z2) {
                                ATBannerView.this.mListener.onBannerShow(j.a(customBannerAdapter));
                            } else {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(j.a(customBannerAdapter));
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onDeeplinkCallback(final CustomBannerAdapter customBannerAdapter, final boolean z2) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDeeplinkCallback(ATBannerView.this.mIsRefresh, j.a(customBannerAdapter), z2);
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onDownloadConfirm(final Context context2, final CustomBannerAdapter customBannerAdapter, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDownloadConfirm(context2, j.a(customBannerAdapter), aTNetworkConfirmInfo);
                    }
                });
            }
        };
        this.adLoadListener = new a() { // from class: com.anythink.banner.api.ATBannerView.2
            @Override // com.anythink.core.common.b.a
            public void onAdLoadFail(final AdError adError) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !ATBannerView.this.canRenderBanner) {
                            return;
                        }
                        ATBannerView aTBannerView = ATBannerView.this;
                        if (aTBannerView.mIsRefresh) {
                            aTBannerView.mListener.onBannerAutoRefreshFail(adError);
                        } else {
                            aTBannerView.mListener.onBannerFailed(adError);
                        }
                    }
                });
                if (ATBannerView.this.mAdLoadManager == null || !ATBannerView.this.isInView() || ATBannerView.this.mBannerRefreshTimer.a()) {
                    return;
                }
                String unused = ATBannerView.this.TAG;
                ATBannerView.this.mBannerRefreshTimer.b();
            }

            @Override // com.anythink.core.common.b.a
            public void onAdLoaded() {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView aTBannerView = ATBannerView.this;
                            if (!aTBannerView.mIsRefresh) {
                                aTBannerView.mListener.onBannerLoaded();
                            }
                        }
                        ATBannerView.this.controlShow();
                    }
                });
            }
        };
        this.mBannerRefreshTimer = new com.anythink.banner.b.a(this);
    }

    public ATBannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.TAG = ATBannerView.class.getSimpleName();
        this.mScenario = "";
        this.hasTouchWindow = false;
        this.mIsRefresh = false;
        this.mInnerBannerListener = new e() { // from class: com.anythink.banner.api.ATBannerView.1
            @Override // com.anythink.banner.a.e
            public void onBannerClicked(final CustomBannerAdapter customBannerAdapter) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClicked(j.a(customBannerAdapter));
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onBannerClose(final CustomBannerAdapter customBannerAdapter) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClose(j.a(customBannerAdapter));
                        }
                    }
                });
                ATBannerView.this.canRenderBanner = true;
                ATBannerView.this.loadAd(1);
            }

            @Override // com.anythink.banner.a.e
            public void onBannerShow(final CustomBannerAdapter customBannerAdapter, final boolean z2) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            if (customBannerAdapter == null || !z2) {
                                ATBannerView.this.mListener.onBannerShow(j.a(customBannerAdapter));
                            } else {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(j.a(customBannerAdapter));
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onDeeplinkCallback(final CustomBannerAdapter customBannerAdapter, final boolean z2) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDeeplinkCallback(ATBannerView.this.mIsRefresh, j.a(customBannerAdapter), z2);
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onDownloadConfirm(final Context context2, final CustomBannerAdapter customBannerAdapter, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDownloadConfirm(context2, j.a(customBannerAdapter), aTNetworkConfirmInfo);
                    }
                });
            }
        };
        this.adLoadListener = new a() { // from class: com.anythink.banner.api.ATBannerView.2
            @Override // com.anythink.core.common.b.a
            public void onAdLoadFail(final AdError adError) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !ATBannerView.this.canRenderBanner) {
                            return;
                        }
                        ATBannerView aTBannerView = ATBannerView.this;
                        if (aTBannerView.mIsRefresh) {
                            aTBannerView.mListener.onBannerAutoRefreshFail(adError);
                        } else {
                            aTBannerView.mListener.onBannerFailed(adError);
                        }
                    }
                });
                if (ATBannerView.this.mAdLoadManager == null || !ATBannerView.this.isInView() || ATBannerView.this.mBannerRefreshTimer.a()) {
                    return;
                }
                String unused = ATBannerView.this.TAG;
                ATBannerView.this.mBannerRefreshTimer.b();
            }

            @Override // com.anythink.core.common.b.a
            public void onAdLoaded() {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView aTBannerView = ATBannerView.this;
                            if (!aTBannerView.mIsRefresh) {
                                aTBannerView.mListener.onBannerLoaded();
                            }
                        }
                        ATBannerView.this.controlShow();
                    }
                });
            }
        };
        this.mBannerRefreshTimer = new com.anythink.banner.b.a(this);
    }
}
