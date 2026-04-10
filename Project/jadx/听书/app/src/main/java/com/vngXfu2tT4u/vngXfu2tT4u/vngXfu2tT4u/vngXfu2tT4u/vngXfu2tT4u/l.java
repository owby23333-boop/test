package com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.ks.KsRewardLoader;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge;
import com.bytedance.msdk.adapter.ks.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.ks.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KsRewardLoader f2467a;
    private boolean b;

    static class a extends MediationBaseAdBridge {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        KsLoadManager.RewardVideoAdListener f2469a;
        private KsRewardVideoAd b;
        private KsRewardLoader c;
        private Function d;
        private MediationAdSlotValueSet e;
        private boolean f;

        public a(KsRewardLoader ksRewardLoader, MediationAdSlotValueSet mediationAdSlotValueSet, Function function, boolean z) {
            super(mediationAdSlotValueSet, function);
            this.f2469a = new KsLoadManager.RewardVideoAdListener() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.l.a.4
                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public void onError(int i, String str) {
                    MediationApiLog.i("KsRewardLoader", "load fail");
                    a.this.c.notifyAdFailed(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
                    if (list == null || list.size() == 0 || list.get(0) == null) {
                        a.this.c.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "广告位空");
                        return;
                    }
                    a.this.b = list.get(0);
                    if (a.this.c.isClientBidding()) {
                        a.this.setCpm(a.this.b.getECPM());
                    }
                    if (a.this.d != null) {
                        SparseArray sparseArray = new SparseArray();
                        sparseArray.put(-99999987, 8140);
                        sparseArray.put(-99999985, Void.class);
                        sparseArray.put(8059, Integer.valueOf(o.a(a.this.b.getInteractionType())));
                        a.this.d.apply(sparseArray);
                    }
                    a.this.b.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.l.a.4.1
                        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                        public void onAdClicked() {
                            MediationApiLog.i("KsRewardLoader", "onAdClicked");
                            if (a.this.d != null) {
                                SparseArray sparseArray2 = new SparseArray();
                                sparseArray2.put(-99999987, 8115);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.d.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                        public void onExtraRewardVerify(int i) {
                            MediationApiLog.i("KsRewardLoader", "onExtraRewardVerify");
                        }

                        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                        public void onPageDismiss() {
                            MediationApiLog.i("KsRewardLoader", "onPageDismiss");
                            if (a.this.d != null) {
                                SparseArray sparseArray2 = new SparseArray();
                                sparseArray2.put(-99999987, 8116);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.d.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                        public void onRewardStepVerify(int i, int i2) {
                            MediationApiLog.i("KsRewardLoader", "onRewardStepVerify");
                        }

                        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                        public void onRewardVerify() {
                            MediationApiLog.i("KsRewardLoader", "onRewardVerify");
                            if (a.this.d != null) {
                                SparseArray sparseArray2 = new SparseArray();
                                sparseArray2.put(-99999987, 8231);
                                sparseArray2.put(-99999985, Void.class);
                                sparseArray2.put(8017, true);
                                sparseArray2.put(8018, Integer.valueOf(a.this.e.getRewardAmount()));
                                sparseArray2.put(8019, a.this.e.getRewardName());
                                a.this.d.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                        public void onRewardVerify(Map<String, Object> map) {
                        }

                        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                        public void onVideoPlayEnd() {
                            MediationApiLog.i("KsRewardLoader", "onVideoPlayEnd");
                            if (a.this.d != null) {
                                SparseArray sparseArray2 = new SparseArray();
                                sparseArray2.put(-99999987, 8118);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.d.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                        public void onVideoPlayError(int i, int i2) {
                            MediationApiLog.i("KsRewardLoader", "onVideoPlayError");
                            if (a.this.d != null) {
                                SparseArray sparseArray2 = new SparseArray();
                                sparseArray2.put(-99999987, 8117);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.d.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                        public void onVideoPlayStart() {
                            MediationApiLog.i("KsRewardLoader", "onVideoPlayStart");
                            if (a.this.d != null) {
                                SparseArray sparseArray2 = new SparseArray();
                                sparseArray2.put(-99999987, 8230);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.d.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                        public void onVideoSkipToEnd(long j) {
                            MediationApiLog.i("KsRewardLoader", "onVideoSkipToEnd");
                            if (a.this.d != null) {
                                SparseArray sparseArray2 = new SparseArray();
                                sparseArray2.put(-99999987, 8119);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.d.apply(sparseArray2);
                            }
                        }
                    });
                    if (a.this.c != null) {
                        MediationApiLog.i("KsRewardLoader", "load success");
                        KsRewardLoader ksRewardLoader2 = a.this.c;
                        a aVar = a.this;
                        ksRewardLoader2.notifyAdSuccess(aVar, aVar.d);
                    }
                    if (a.this.c != null) {
                        MediationApiLog.i("KsRewardLoader", "cache success");
                        a.this.c.notifyAdCache(a.this.d, MediationConstant.ErrorCode.ADN_AD_NO_CACHE, "没有cache回调");
                    }
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public void onRewardVideoResult(List<KsRewardVideoAd> list) {
                }
            };
            this.c = ksRewardLoader;
            this.e = mediationAdSlotValueSet;
            this.d = function;
            this.f = z;
            a();
        }

        private void a() {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8128);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8035, this);
            this.d.apply(sparseArray);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(KsScene ksScene) {
            if (KsAdSDK.getLoadManager() != null) {
                KsAdSDK.getLoadManager().loadRewardVideoAd(ksScene, this.f2469a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            KsRewardVideoAd ksRewardVideoAd = this.b;
            if (ksRewardVideoAd != null) {
                ksRewardVideoAd.setRewardAdInteractionListener(null);
                this.b = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Activity activity) {
            if (this.b != null) {
                KsVideoPlayConfig.Builder builder = new KsVideoPlayConfig.Builder();
                MediationAdSlotValueSet mediationAdSlotValueSet = this.e;
                boolean zIsMuted = mediationAdSlotValueSet != null ? mediationAdSlotValueSet.isMuted() : false;
                MediationAdSlotValueSet mediationAdSlotValueSet2 = this.e;
                if (mediationAdSlotValueSet2 != null && mediationAdSlotValueSet2.getOrientation() == 2) {
                    builder.showLandscape(true);
                }
                builder.videoSoundEnable(!zIsMuted);
                this.b.showRewardVideoAd(activity, builder.build());
            }
        }

        private void c() {
            n.b(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.l.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b();
                }
            });
        }

        private void c(final Activity activity) {
            n.b(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.l.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(activity);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Integer d() {
            KsRewardVideoAd ksRewardVideoAd = this.b;
            return Integer.valueOf((ksRewardVideoAd == null || !ksRewardVideoAd.isAdEnable()) ? 4 : 2);
        }

        private Integer e() {
            try {
                Integer num = (Integer) n.a(new Callable<Integer>() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.l.a.2
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Integer call() {
                        return a.this.d();
                    }
                }).get(500L, TimeUnit.MILLISECONDS);
                if (num != null) {
                    return num;
                }
                return 4;
            } catch (Exception e) {
                e.printStackTrace();
                return 4;
            }
        }

        private String f() {
            return this.f ? g() : h();
        }

        private String g() {
            try {
                return (String) n.a(new Callable<String>() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.l.a.5
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public String call() {
                        return a.this.h();
                    }
                }).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String h() {
            Object obj;
            try {
                KsRewardVideoAd ksRewardVideoAd = this.b;
                if (ksRewardVideoAd == null || (obj = ksRewardVideoAd.getMediaExtraInfo().get("llsid")) == null) {
                    return null;
                }
                return obj.toString();
            } catch (Throwable unused) {
                return null;
            }
        }

        public void a(Activity activity) {
            if (this.f) {
                c(activity);
            } else {
                b(activity);
            }
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
        public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
            if (i == 8113) {
                Activity activity = (Activity) MediationValueUtil.objectValue(sparseArray.get(20033), Activity.class, null);
                if (activity != null) {
                    a(activity);
                }
            } else if (i == 8109) {
                onDestroy();
            } else {
                if (i == 8120) {
                    return (T) Boolean.valueOf(hasDestroyed());
                }
                if (i == 8121) {
                    return (T) isReadyStatusForProto2(isReadyStatus(), sparseArray, cls);
                }
                if (i == 8147) {
                    return (T) f();
                }
                if (i == 8142) {
                    if (o.a(this.b)) {
                        Map map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                        if (map != null) {
                            long jA = o.a((Map<String, Object>) map);
                            long jB = o.b((Map<String, Object>) map);
                            MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + jA + " loseBidEcpm = " + jB);
                            KsRewardVideoAd ksRewardVideoAd = this.b;
                            if (ksRewardVideoAd != null) {
                                ksRewardVideoAd.setBidEcpm(jA, jB);
                            }
                        }
                    }
                } else if (i == 8144 && o.b(this.b)) {
                    Map map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                    MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                    if (map2 != null) {
                        int iC = o.c(map2);
                        int iD = o.d(map2);
                        int iE = o.e(map2);
                        String strF = o.f(map2);
                        MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + iD + " failureCode = " + iC);
                        if (this.b != null) {
                            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                            adExposureFailedReason.setWinEcpm(iD);
                            adExposureFailedReason.setAdnType(iE);
                            adExposureFailedReason.setAdnName(strF);
                            this.b.reportAdExposureFailed(iC, adExposureFailedReason);
                        }
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.b == null;
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public Integer isReadyStatus() {
            return this.f ? e() : d();
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public void onDestroy() {
            if (this.f) {
                c();
            } else {
                b();
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    public l(KsRewardLoader ksRewardLoader) {
        this.f2467a = ksRewardLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediationAdSlotValueSet mediationAdSlotValueSet) {
        try {
            KsScene.Builder builder = new KsScene.Builder(Long.valueOf(mediationAdSlotValueSet.getADNId()).longValue());
            HashMap map = new HashMap();
            String userId = mediationAdSlotValueSet.getUserId();
            if (userId != null) {
                map.put("thirdUserId", userId);
            }
            Map<String, Object> extraObject = mediationAdSlotValueSet.getExtraObject();
            if (extraObject != null && extraObject.get(MediationConstant.ADN_KS) != null) {
                map.put("extraData", String.valueOf(extraObject.get(MediationConstant.ADN_KS)));
            }
            if (map.size() > 0) {
                builder.rewardCallbackExtraData(map);
            }
            KsScene ksSceneBuild = builder.build();
            KsRewardLoader ksRewardLoader = this.f2467a;
            new a(ksRewardLoader, mediationAdSlotValueSet, ksRewardLoader.getGMBridge(), this.b).a(ksSceneBuild);
        } catch (Exception unused) {
            this.f2467a.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "代码位不合法");
        }
    }

    public void a(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean zA = o.a(this.f2467a, mediationAdSlotValueSet);
        this.b = zA;
        if (zA) {
            n.a(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.l.1
                @Override // java.lang.Runnable
                public void run() {
                    l.this.a(mediationAdSlotValueSet);
                    n.a(getClass().getName(), context.getApplicationContext());
                }
            });
        } else {
            a(mediationAdSlotValueSet);
        }
    }
}
