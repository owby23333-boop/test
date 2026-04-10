package com.anythink.splashad.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATMediationRequestInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.c.a;
import com.anythink.core.common.b.b;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.h;
import com.anythink.core.common.v;
import com.anythink.splashad.a.c;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ATSplashAd {
    public final int DEFAULT_SPLASH_TIMEOUT_TIME;
    final String TAG;
    WeakReference<Activity> mActivityWeakRef;
    c mAdLoadManager;
    b mAdSourceEventListener;
    Context mContext;
    String mDefaultAdSourceConfig;
    ATMediationRequestInfo mDefaultRequestInfo;
    ATAdSourceStatusListener mDeveloperStatusListener;
    ATEventInterface mDownloadListener;
    int mFetchAdTimeout;
    ATSplashAdListener mListener;
    String mPlacementId;
    Map<String, Object> mTKExtraMap;

    /* JADX INFO: renamed from: com.anythink.splashad.api.ATSplashAd$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int val$loadType;

        /* JADX INFO: renamed from: com.anythink.splashad.api.ATSplashAd$1$1, reason: invalid class name and collision with other inner class name */
        class C02491 extends com.anythink.splashad.a.b {
            boolean hasCacheWhenTimeout = false;

            C02491() {
            }

            @Override // com.anythink.splashad.a.b
            public void onAdLoaded(String str, final boolean z2) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.1.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C02491 c02491 = C02491.this;
                        ATSplashAdListener aTSplashAdListener = ATSplashAd.this.mListener;
                        if (aTSplashAdListener != null) {
                            aTSplashAdListener.onAdLoaded(!c02491.hasCacheWhenTimeout && z2);
                        }
                    }
                });
            }

            @Override // com.anythink.splashad.a.b
            public void onNoAdError(String str, final AdError adError) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.1.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ATSplashAdListener aTSplashAdListener = ATSplashAd.this.mListener;
                        if (aTSplashAdListener != null) {
                            aTSplashAdListener.onNoAdError(adError);
                        }
                    }
                });
            }

            @Override // com.anythink.splashad.a.b
            public void onTimeout(String str) {
                ATSplashAd aTSplashAd = ATSplashAd.this;
                if (aTSplashAd.mAdLoadManager.a(aTSplashAd.mContext, false, false, aTSplashAd.mTKExtraMap) != null) {
                    this.hasCacheWhenTimeout = true;
                    h hVarC = ATSplashAd.this.mAdLoadManager.c(str);
                    if (hVarC != null) {
                        String str2 = ATSplashAd.this.TAG;
                        String str3 = "has cache when timeout: " + ATSplashAd.this.mPlacementId;
                        hVarC.b(9);
                        return;
                    }
                }
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.1.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        ATSplashAdListener aTSplashAdListener = ATSplashAd.this.mListener;
                        if (aTSplashAdListener != null) {
                            aTSplashAdListener.onAdLoadTimeout();
                        }
                    }
                });
            }
        }

        AnonymousClass1(int i2) {
            this.val$loadType = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ATSplashAd aTSplashAd = ATSplashAd.this;
            int iV = aTSplashAd.mFetchAdTimeout;
            if (iV <= 0) {
                a aVarB = com.anythink.core.c.b.a(aTSplashAd.mContext).b(n.a().p());
                iV = aVarB.V() == 0 ? 5000 : (int) aVarB.V();
            }
            int i2 = iV;
            WeakReference<Activity> weakReference = ATSplashAd.this.mActivityWeakRef;
            C02491 c02491 = null;
            Activity activity = weakReference != null ? weakReference.get() : null;
            if (this.val$loadType == 0) {
                c02491 = new C02491();
                c02491.startCountDown(i2);
            }
            C02491 c024912 = c02491;
            ATSplashAd aTSplashAd2 = ATSplashAd.this;
            c cVar = aTSplashAd2.mAdLoadManager;
            if (activity == null) {
                activity = aTSplashAd2.mContext;
            }
            Context context = activity;
            ATSplashAd aTSplashAd3 = ATSplashAd.this;
            cVar.a(context, aTSplashAd3.mDefaultRequestInfo, aTSplashAd3.mDefaultAdSourceConfig, c024912, i2, this.val$loadType, aTSplashAd3.mAdSourceEventListener, aTSplashAd3.mTKExtraMap);
        }
    }

    public ATSplashAd(Context context, String str, ATSplashAdListener aTSplashAdListener) {
        this(context, str, aTSplashAdListener, 0, "");
    }

    @Deprecated
    public static void checkSplashDefaultConfigList(Context context, String str, Map<String, Object> map) {
        n.a().a(context, str, map);
    }

    public static void entryAdScenario(String str, String str2) {
        n.a().a(str, str2, "4", (Map<String, Object>) null);
    }

    private ATAdStatusInfo getAdStatus() {
        if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q())) {
            return null;
        }
        return this.mAdLoadManager.a(this.mContext, this.mTKExtraMap);
    }

    public ATAdStatusInfo checkAdStatus() {
        ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return new ATAdStatusInfo(false, false, null);
        }
        com.anythink.core.common.k.n.b(this.mPlacementId, g.i.f6867m, g.i.f6875u, adStatus.toString(), "");
        return adStatus;
    }

    public List<ATAdInfo> checkValidAdCaches() {
        c cVar = this.mAdLoadManager;
        if (cVar != null) {
            return cVar.a(this.mContext);
        }
        return null;
    }

    public boolean isAdReady() {
        ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return false;
        }
        boolean zIsReady = adStatus.isReady();
        com.anythink.core.common.k.n.b(this.mPlacementId, g.i.f6867m, g.i.f6874t, String.valueOf(zIsReady), "");
        return zIsReady;
    }

    public void loadAd() {
        loadAd(0);
    }

    @Deprecated
    public void onDestory() {
    }

    public void setAdDownloadListener(ATEventInterface aTEventInterface) {
        this.mDownloadListener = aTEventInterface;
    }

    public void setAdListener(ATSplashAdListener aTSplashAdListener) {
        this.mListener = aTSplashAdListener;
    }

    public void setAdSourceStatusListener(ATAdSourceStatusListener aTAdSourceStatusListener) {
        if (this.mAdSourceEventListener == null) {
            this.mAdSourceEventListener = new b();
        }
        this.mDeveloperStatusListener = aTAdSourceStatusListener;
        this.mAdSourceEventListener.a(this.mDeveloperStatusListener);
    }

    public void setLocalExtra(Map<String, Object> map) {
        v.a().a(this.mPlacementId, map);
    }

    public void setTKExtra(Map<String, Object> map) {
        if (this.mTKExtraMap == null) {
            this.mTKExtraMap = new ConcurrentHashMap();
        }
        this.mTKExtraMap.clear();
        this.mTKExtraMap.putAll(map);
    }

    public void show(Activity activity, ViewGroup viewGroup) {
        show(activity, viewGroup, null, "");
    }

    @Deprecated
    public ATSplashAd(Context context, String str, ATMediationRequestInfo aTMediationRequestInfo, ATSplashAdListener aTSplashAdListener) {
        this(context, str, aTMediationRequestInfo, aTSplashAdListener, 0);
    }

    public static void entryAdScenario(String str, String str2, Map<String, Object> map) {
        n.a().a(str, str2, "4", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(int i2) {
        com.anythink.core.common.k.n.a(this.mPlacementId, g.i.f6867m, g.i.f6871q, g.i.f6862h, "", true);
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass1(i2));
    }

    public void show(Activity activity, ViewGroup viewGroup, String str) {
        show(activity, viewGroup, null, str);
    }

    @Deprecated
    public ATSplashAd(Context context, String str, ATMediationRequestInfo aTMediationRequestInfo, ATSplashAdListener aTSplashAdListener, int i2) {
        this.TAG = ATSplashAd.class.getSimpleName();
        this.DEFAULT_SPLASH_TIMEOUT_TIME = 5000;
        this.mContext = context.getApplicationContext();
        this.mPlacementId = str;
        this.mListener = aTSplashAdListener;
        this.mDefaultRequestInfo = aTMediationRequestInfo;
        this.mFetchAdTimeout = i2;
        if (context instanceof Activity) {
            this.mActivityWeakRef = new WeakReference<>((Activity) context);
        }
        ATMediationRequestInfo aTMediationRequestInfo2 = this.mDefaultRequestInfo;
        if (aTMediationRequestInfo2 != null) {
            aTMediationRequestInfo2.setFormat("4");
        }
        this.mAdLoadManager = c.a(context, str);
    }

    public void show(Activity activity, ViewGroup viewGroup, ATSplashSkipInfo aTSplashSkipInfo) {
        show(activity, viewGroup, aTSplashSkipInfo, "");
    }

    public void show(Activity activity, ViewGroup viewGroup, ATSplashSkipInfo aTSplashSkipInfo, String str) {
        com.anythink.core.common.k.n.b(this.mPlacementId, g.i.f6867m, g.i.f6873s, g.i.f6862h, "");
        if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q()) || viewGroup == null) {
            return;
        }
        this.mAdLoadManager.a(activity, viewGroup, new com.anythink.splashad.a.a() { // from class: com.anythink.splashad.api.ATSplashAd.2
            @Override // com.anythink.splashad.a.a
            public void onAdClick(final ATAdInfo aTAdInfo) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        ATSplashAdListener aTSplashAdListener = ATSplashAd.this.mListener;
                        if (aTSplashAdListener != null) {
                            aTSplashAdListener.onAdClick(aTAdInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.splashad.a.a
            public void onAdDismiss(final ATAdInfo aTAdInfo, final ATSplashAdExtraInfo aTSplashAdExtraInfo) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        ATSplashAdListener aTSplashAdListener = ATSplashAd.this.mListener;
                        if (aTSplashAdListener != null) {
                            aTSplashAdListener.onAdDismiss(aTAdInfo, aTSplashAdExtraInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.splashad.a.a
            public void onAdShow(final ATAdInfo aTAdInfo) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        ATSplashAdListener aTSplashAdListener = ATSplashAd.this.mListener;
                        if (aTSplashAdListener != null) {
                            aTSplashAdListener.onAdShow(aTAdInfo);
                        }
                    }
                });
                if (ATSplashAd.this.mAdLoadManager.a((ATAdStatusInfo) null)) {
                    ATSplashAd.this.loadAd(6);
                }
            }

            @Override // com.anythink.splashad.a.a
            public void onDeeplinkCallback(final ATAdInfo aTAdInfo, final boolean z2) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ATSplashAdListener aTSplashAdListener = ATSplashAd.this.mListener;
                        if (aTSplashAdListener == null || !(aTSplashAdListener instanceof ATSplashExListener)) {
                            return;
                        }
                        ((ATSplashExListener) aTSplashAdListener).onDeeplinkCallback(aTAdInfo, z2);
                    }
                });
            }

            @Override // com.anythink.splashad.a.a
            public void onDownloadConfirm(final Context context, final ATAdInfo aTAdInfo, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ATSplashAd aTSplashAd = ATSplashAd.this;
                        ATSplashAdListener aTSplashAdListener = aTSplashAd.mListener;
                        if (aTSplashAdListener == null || !(aTSplashAdListener instanceof ATSplashExListener)) {
                            return;
                        }
                        ATSplashExListener aTSplashExListener = (ATSplashExListener) aTSplashAdListener;
                        Context context2 = context;
                        if (context2 == null) {
                            context2 = aTSplashAd.mContext;
                        }
                        aTSplashExListener.onDownloadConfirm(context2, aTAdInfo, aTNetworkConfirmInfo);
                    }
                });
            }
        }, this.mDownloadListener, aTSplashSkipInfo, com.anythink.core.common.k.g.c(str) ? str : "", this.mTKExtraMap);
    }

    public ATSplashAd(Context context, String str, ATSplashAdListener aTSplashAdListener, String str2) {
        this(context, str, aTSplashAdListener, 0, str2);
    }

    public ATSplashAd(Context context, String str, ATSplashAdListener aTSplashAdListener, int i2, String str2) {
        this.TAG = ATSplashAd.class.getSimpleName();
        this.DEFAULT_SPLASH_TIMEOUT_TIME = 5000;
        this.mContext = context.getApplicationContext();
        this.mPlacementId = str;
        this.mListener = aTSplashAdListener;
        this.mDefaultAdSourceConfig = str2;
        this.mFetchAdTimeout = i2;
        if (context instanceof Activity) {
            this.mActivityWeakRef = new WeakReference<>((Activity) context);
        }
        ATMediationRequestInfo aTMediationRequestInfo = this.mDefaultRequestInfo;
        if (aTMediationRequestInfo != null) {
            aTMediationRequestInfo.setFormat("4");
        }
        this.mAdLoadManager = c.a(context, str);
    }
}
