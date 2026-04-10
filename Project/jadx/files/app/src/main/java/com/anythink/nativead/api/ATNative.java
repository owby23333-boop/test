package com.anythink.nativead.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.a;
import com.anythink.core.common.b.b;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.v;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ATNative {
    private final String TAG = ATNative.class.getSimpleName();
    a adLoadListener = new a() { // from class: com.anythink.nativead.api.ATNative.1
        @Override // com.anythink.core.common.b.a
        public void onAdLoadFail(final AdError adError) {
            n.a().a(new Runnable() { // from class: com.anythink.nativead.api.ATNative.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    ATNativeNetworkListener aTNativeNetworkListener = ATNative.this.mListener;
                    if (aTNativeNetworkListener != null) {
                        aTNativeNetworkListener.onNativeAdLoadFail(adError);
                    }
                }
            });
        }

        @Override // com.anythink.core.common.b.a
        public void onAdLoaded() {
            n.a().a(new Runnable() { // from class: com.anythink.nativead.api.ATNative.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    ATNativeNetworkListener aTNativeNetworkListener = ATNative.this.mListener;
                    if (aTNativeNetworkListener != null) {
                        aTNativeNetworkListener.onNativeAdLoaded();
                    }
                }
            });
        }
    };
    WeakReference<Activity> mActivityRef;
    com.anythink.nativead.a.a mAdLoadManager;
    b mAdSourceEventListener;
    Context mContext;
    ATAdSourceStatusListener mDeveloperStatusListener;
    ATNativeNetworkListener mListener;
    String mPlacementId;
    Map<String, Object> mTKExtraMap;

    public ATNative(Context context, String str, ATNativeNetworkListener aTNativeNetworkListener) {
        this.mContext = context.getApplicationContext();
        if (context != null && (context instanceof Activity)) {
            this.mActivityRef = new WeakReference<>((Activity) context);
        }
        this.mPlacementId = str;
        this.mListener = aTNativeNetworkListener;
        this.mAdLoadManager = com.anythink.nativead.a.a.a(context, str);
    }

    public static void entryAdScenario(String str, String str2) {
        n.a().a(str, str2, "0", (Map<String, Object>) null);
    }

    private Context getContext() {
        Activity activity;
        WeakReference<Activity> weakReference = this.mActivityRef;
        return (weakReference == null || (activity = weakReference.get()) == null) ? this.mContext : activity;
    }

    public ATAdStatusInfo checkAdStatus() {
        if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q())) {
            return new ATAdStatusInfo(false, false, null);
        }
        ATAdStatusInfo aTAdStatusInfoA = this.mAdLoadManager.a(getContext(), this.mTKExtraMap);
        com.anythink.core.common.k.n.b(this.mPlacementId, g.i.f6866l, g.i.f6875u, aTAdStatusInfoA.toString(), "");
        return aTAdStatusInfoA;
    }

    public List<ATAdInfo> checkValidAdCaches() {
        com.anythink.nativead.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            return aVar.a(getContext());
        }
        return null;
    }

    public NativeAd getNativeAd() {
        com.anythink.core.common.e.b bVarA = this.mAdLoadManager.a("", this.mTKExtraMap);
        if (bVarA != null) {
            return new NativeAd(getContext(), this.mPlacementId, bVarA);
        }
        return null;
    }

    public void makeAdRequest() {
        com.anythink.core.common.k.n.a(this.mPlacementId, g.i.f6866l, g.i.f6871q, g.i.f6862h, "", true);
        this.mAdLoadManager.a(getContext(), this.adLoadListener, this.mAdSourceEventListener, this.mTKExtraMap);
    }

    public void setAdListener(ATNativeNetworkListener aTNativeNetworkListener) {
        this.mListener = aTNativeNetworkListener;
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

    public static void entryAdScenario(String str, String str2, Map<String, Object> map) {
        n.a().a(str, str2, "0", map);
    }

    public NativeAd getNativeAd(String str) {
        if (!com.anythink.core.common.k.g.c(str)) {
            str = "";
        }
        com.anythink.core.common.e.b bVarA = this.mAdLoadManager.a(str, this.mTKExtraMap);
        if (bVarA != null) {
            return new NativeAd(getContext(), this.mPlacementId, bVarA);
        }
        return null;
    }
}
