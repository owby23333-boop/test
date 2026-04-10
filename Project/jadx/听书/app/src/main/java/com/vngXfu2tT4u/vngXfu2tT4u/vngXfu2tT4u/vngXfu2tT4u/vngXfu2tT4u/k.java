package com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.msdk.adapter.ks.KsNativeLoader;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.NativeAdExtraData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2463a;

    private void a(final Context context, KsScene ksScene, final MediationAdSlotValueSet mediationAdSlotValueSet, final KsNativeLoader ksNativeLoader) {
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager != null) {
            loadManager.loadConfigFeedAd(ksScene, new KsLoadManager.FeedAdListener() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.k.2
                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public void onError(int i, String str) {
                    ksNativeLoader.notifyAdFailed(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public void onFeedAdLoad(List<KsFeedAd> list) {
                    if (list == null || list.isEmpty()) {
                        ksNativeLoader.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "返回广告位列表空");
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (KsFeedAd ksFeedAd : list) {
                        if (ksFeedAd != null) {
                            Function<SparseArray<Object>, Object> gMBridge = ksNativeLoader.getGMBridge();
                            new e(context, ksFeedAd, mediationAdSlotValueSet, gMBridge, ksNativeLoader, k.this.f2463a);
                            arrayList.add(gMBridge);
                        }
                    }
                    ksNativeLoader.notifyAdSuccess(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, MediationAdSlotValueSet mediationAdSlotValueSet, KsNativeLoader ksNativeLoader) {
        try {
            KsScene.Builder builderAdNum = new KsScene.Builder(Long.valueOf(mediationAdSlotValueSet.getADNId()).longValue()).adNum(mediationAdSlotValueSet.getAdCount());
            if (context != null) {
                int iA = o.a(context);
                if (mediationAdSlotValueSet.getWidth() != 0) {
                    iA = mediationAdSlotValueSet.getWidth();
                } else if (mediationAdSlotValueSet.getExpressWidth() != 0.0f) {
                    iA = (int) o.a(context, mediationAdSlotValueSet.getExpressWidth());
                }
                builderAdNum = builderAdNum.width(iA);
            }
            if (mediationAdSlotValueSet.isExpress()) {
                a(context, builderAdNum.build(), mediationAdSlotValueSet, ksNativeLoader);
                return;
            }
            Map<String, Object> extraObject = mediationAdSlotValueSet.getExtraObject();
            if (extraObject != null) {
                Object obj = extraObject.get(MediationConstant.GM_EXTRA_KEY_KS_ENABLE_ROTATE);
                if (obj instanceof Boolean) {
                    try {
                        builderAdNum.setNativeAdExtraData(new NativeAdExtraData().setEnableRotate(((Boolean) obj).booleanValue()));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            b(context, builderAdNum.build(), mediationAdSlotValueSet, ksNativeLoader);
        } catch (Exception unused) {
            ksNativeLoader.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "代码位不合法");
        }
    }

    private void b(final Context context, KsScene ksScene, final MediationAdSlotValueSet mediationAdSlotValueSet, final KsNativeLoader ksNativeLoader) {
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager != null) {
            loadManager.loadNativeAd(ksScene, new KsLoadManager.NativeAdListener() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.k.3
                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public void onError(int i, String str) {
                    ksNativeLoader.notifyAdFailed(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public void onNativeAdLoad(List<KsNativeAd> list) {
                    if (list == null || list.isEmpty()) {
                        ksNativeLoader.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "返回广告位列表空");
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (KsNativeAd ksNativeAd : list) {
                        Function<SparseArray<Object>, Object> gMBridge = ksNativeLoader.getGMBridge();
                        new d(context, ksNativeAd, mediationAdSlotValueSet, gMBridge, ksNativeLoader, k.this.f2463a);
                        arrayList.add(gMBridge);
                    }
                    ksNativeLoader.notifyAdSuccess(arrayList);
                }
            });
        }
    }

    public void a(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet, final KsNativeLoader ksNativeLoader) {
        boolean zA = o.a(ksNativeLoader, mediationAdSlotValueSet);
        this.f2463a = zA;
        if (zA) {
            n.a(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.k.1
                @Override // java.lang.Runnable
                public void run() {
                    k.this.b(context.getApplicationContext(), mediationAdSlotValueSet, ksNativeLoader);
                    n.a(getClass().getName(), context.getApplicationContext());
                }
            });
        } else {
            b(context.getApplicationContext(), mediationAdSlotValueSet, ksNativeLoader);
        }
    }
}
