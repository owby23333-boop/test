package com.anythink.network.mobrain;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMUnifiedNativeAd;
import com.bytedance.msdk.api.v2.slot.GMAdSlotNative;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MobrainATAdapter extends CustomNativeAdapter {
    private static final String a = "MobrainATAdapter";
    private GMUnifiedNativeAd b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MobrainConfig f12534d;

    /* JADX INFO: renamed from: com.anythink.network.mobrain.MobrainATAdapter$1, reason: invalid class name */
    final class AnonymousClass1 implements GMNativeAdLoadCallback {
        final /* synthetic */ Context a;

        AnonymousClass1(Context context) {
            this.a = context;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdLoadCallback
        public final void onAdLoaded(List<GMNativeAd> list) {
            ArrayList arrayList = new ArrayList();
            Iterator<GMNativeAd> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new MobrainATNativeAd(this.a, it.next()));
            }
            CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
            if (((ATBaseAdAdapter) MobrainATAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATAdapter.this).mLoadListener.onAdCacheLoaded(customNativeAdArr);
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdLoadCallback
        public final void onAdLoadedFail(AdError adError) {
            if (((ATBaseAdAdapter) MobrainATAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATAdapter.this).mLoadListener.onAdLoadError(String.valueOf(adError.code), "Gromore: " + adError.toString());
            }
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return MobrainATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f12533c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return MobrainATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, Map<String, Object> map2) {
        String str = (String) map.get("slot_id");
        if (TextUtils.isEmpty(str)) {
            ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("", "Gromore: pl_id is empty!");
                return;
            }
            return;
        }
        this.f12533c = str;
        this.f12534d = new MobrainConfig(context, 2);
        this.f12534d.a(map);
        this.f12534d.b(map2);
        int i2 = this.mRequestNum;
        if (i2 > 3) {
            i2 = 3;
        }
        this.f12534d.mAdCount = i2;
        MobrainATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.mobrain.MobrainATAdapter.2
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str2) {
                if (((ATBaseAdAdapter) MobrainATAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) MobrainATAdapter.this).mLoadListener.onAdLoadError("", "Gromore: ".concat(String.valueOf(str2)));
                }
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                MobrainATAdapter.a(MobrainATAdapter.this, context);
            }
        });
    }

    private void a(Context context) {
        this.b = new GMUnifiedNativeAd(context, this.f12533c);
        GMAdSlotNative.Builder adCount = new GMAdSlotNative.Builder().setAdStyleType(this.f12534d.mAdStyleType).setMuted(this.f12534d.f12575f == 0).setImageAdSize(a(context, this.f12534d.mWidth), a(context, this.f12534d.mHeight)).setAdCount(this.f12534d.mAdCount);
        int i2 = this.f12534d.mDownloadType;
        if (i2 != -1) {
            adCount.setDownloadType(i2);
        }
        this.b.loadAd(adCount.build(), new AnonymousClass1(context));
    }

    private static int a(Context context, float f2) {
        float f3 = context.getResources().getDisplayMetrics().density;
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    static /* synthetic */ void a(MobrainATAdapter mobrainATAdapter, Context context) {
        mobrainATAdapter.b = new GMUnifiedNativeAd(context, mobrainATAdapter.f12533c);
        GMAdSlotNative.Builder adCount = new GMAdSlotNative.Builder().setAdStyleType(mobrainATAdapter.f12534d.mAdStyleType).setMuted(mobrainATAdapter.f12534d.f12575f == 0).setImageAdSize(a(context, mobrainATAdapter.f12534d.mWidth), a(context, mobrainATAdapter.f12534d.mHeight)).setAdCount(mobrainATAdapter.f12534d.mAdCount);
        int i2 = mobrainATAdapter.f12534d.mDownloadType;
        if (i2 != -1) {
            adCount.setDownloadType(i2);
        }
        mobrainATAdapter.b.loadAd(adCount.build(), mobrainATAdapter.new AnonymousClass1(context));
    }
}
