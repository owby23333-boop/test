package com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ks.KsInterstitialLoader;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge;
import com.bytedance.msdk.adapter.ks.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.ks.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KsInterstitialLoader f2455a;
    private boolean b;

    class a extends MediationBaseAdBridge {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        KsLoadManager.InterstitialAdListener f2457a;
        private KsInterstitialAd c;
        private boolean d;

        public a(MediationAdSlotValueSet mediationAdSlotValueSet, Function function) {
            super(mediationAdSlotValueSet, function);
            this.f2457a = new KsLoadManager.InterstitialAdListener() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.j.a.3
                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                @JProtect
                public void onError(int i, String str) {
                    MediationApiLog.i("TMe", "ks_KsInterstitialLoader onError");
                    j.this.f2455a.notifyAdFailed(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                @JProtect
                public void onInterstitialAdLoad(List<KsInterstitialAd> list) {
                    if (list == null || list.size() == 0) {
                        j.this.f2455a.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "暂无广告");
                        return;
                    }
                    MediationApiLog.i("TMe", "ks_KsInterstitialLoader onInterstitialAdLoad");
                    a.this.c = list.get(0);
                    a.this.setExpress();
                    if (j.this.f2455a.isClientBidding()) {
                        double ecpm = a.this.c.getECPM();
                        a aVar = a.this;
                        if (ecpm <= 0.0d) {
                            ecpm = 0.0d;
                        }
                        aVar.setCpm(ecpm);
                    }
                    if (a.this.mGMAd != null) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, 8140);
                        sparseArray.put(-99999985, Void.class);
                        sparseArray.put(8059, Integer.valueOf(o.a(a.this.c.getInteractionType())));
                        a.this.mGMAd.apply(sparseArray);
                    }
                    KsInterstitialLoader ksInterstitialLoader = j.this.f2455a;
                    a aVar2 = a.this;
                    ksInterstitialLoader.notifyAdSuccess(aVar2, aVar2.mGMAd);
                    a.this.c.setAdInteractionListener(new KsInterstitialAd.AdInteractionListener() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.j.a.3.1
                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onAdClicked() {
                            MediationApiLog.i("TMe", "ks_KsInterstitialLoader onAdClicked");
                            if (a.this.mGMAd != null) {
                                SparseArray<Object> sparseArray2 = new SparseArray<>();
                                sparseArray2.put(-99999987, 1009);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.mGMAd.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onAdClosed() {
                            MediationApiLog.i("TMe", "ks_KsInterstitialLoader onAdClosed");
                            a.this.c();
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onAdShow() {
                            MediationApiLog.i("TMe", "ks_KsInterstitialLoader onAdShow");
                            if (a.this.mGMAd != null) {
                                SparseArray<Object> sparseArray2 = new SparseArray<>();
                                sparseArray2.put(-99999987, 1008);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.mGMAd.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onPageDismiss() {
                            MediationApiLog.i("TMe", "ks_KsInterstitialLoader onPageDismiss");
                            a.this.c();
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onSkippedAd() {
                            MediationApiLog.i("TMe", "ks_KsInterstitialLoader onSkippedAd");
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onVideoPlayEnd() {
                            MediationApiLog.i("TMe", "ks_KsInterstitialLoader onVideoPlayEnd");
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onVideoPlayError(int i, int i2) {
                            MediationApiLog.i("TMe", "ks_KsInterstitialLoader onVideoPlayError");
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onVideoPlayStart() {
                            MediationApiLog.i("TMe", "ks_KsInterstitialLoader onVideoPlayStart");
                        }
                    });
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public void onRequestResult(int i) {
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            if (this.d) {
                return;
            }
            this.d = true;
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 1014);
                sparseArray.put(-99999985, Void.class);
                this.mGMAd.apply(sparseArray);
            }
        }

        private String d() {
            return j.this.b ? e() : f();
        }

        private String e() {
            try {
                return (String) n.a(new Callable<String>() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.j.a.4
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public String call() {
                        return a.this.f();
                    }
                }).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String f() {
            Object obj;
            try {
                KsInterstitialAd ksInterstitialAd = this.c;
                if (ksInterstitialAd == null || (obj = ksInterstitialAd.getMediaExtraInfo().get("llsid")) == null) {
                    return null;
                }
                return obj.toString();
            } catch (Throwable unused) {
                return null;
            }
        }

        public void a() {
            KsInterstitialAd ksInterstitialAd = this.c;
            if (ksInterstitialAd != null) {
                ksInterstitialAd.setAdInteractionListener(null);
                this.c = null;
            }
        }

        @JProtect
        public void a(Activity activity) {
            if (this.c != null) {
                this.c.showInterstitialAd(activity, new KsVideoPlayConfig.Builder().videoSoundEnable(!isMuted()).build());
            }
        }

        @JProtect
        public void a(KsScene ksScene) {
            MediationApiLog.i("TMe", "ks_KsInterstitialLoader loadAd");
            KsAdSDK.getLoadManager().loadInterstitialAd(ksScene, this.f2457a);
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
        public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
            if (i == 8113) {
                Activity activity = (Activity) MediationValueUtil.objectValue(sparseArray.get(20033), Activity.class, null);
                if (activity != null) {
                    c(activity);
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
                    return (T) d();
                }
                if (i == 8142) {
                    if (o.a(this.c)) {
                        Map map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                        if (map != null) {
                            long jA = o.a((Map<String, Object>) map);
                            long jB = o.b((Map<String, Object>) map);
                            MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + jA + " loseBidEcpm = " + jB);
                            KsInterstitialAd ksInterstitialAd = this.c;
                            if (ksInterstitialAd != null) {
                                ksInterstitialAd.setBidEcpm(jA, jB);
                            }
                        }
                    }
                } else if (i == 8144 && o.b(this.c)) {
                    Map map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                    MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                    if (map2 != null) {
                        int iC = o.c(map2);
                        int iD = o.d(map2);
                        int iE = o.e(map2);
                        String strF = o.f(map2);
                        MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + iD + " failureCode = " + iC);
                        if (this.c != null) {
                            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                            adExposureFailedReason.setWinEcpm(iD);
                            adExposureFailedReason.setAdnType(iE);
                            adExposureFailedReason.setAdnName(strF);
                            this.c.reportAdExposureFailed(iC, adExposureFailedReason);
                        }
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        public void b() {
            n.b(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.j.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a();
                }
            });
        }

        public void b(final Activity activity) {
            n.b(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.j.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(activity);
                }
            });
        }

        public void c(Activity activity) {
            if (j.this.b) {
                b(activity);
            } else {
                a(activity);
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.c == null;
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public void onDestroy() {
            if (j.this.b) {
                b();
            } else {
                a();
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    public j(KsInterstitialLoader ksInterstitialLoader) {
        this.f2455a = ksInterstitialLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediationAdSlotValueSet mediationAdSlotValueSet) {
        try {
            new a(mediationAdSlotValueSet, this.f2455a.getGMBridge()).a(new KsScene.Builder(Long.valueOf(this.f2455a.getAdnId()).longValue()).build());
        } catch (Exception unused) {
            this.f2455a.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "代码位不合法");
        }
    }

    public void a(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean zA = o.a(this.f2455a, mediationAdSlotValueSet);
        this.b = zA;
        if (zA) {
            n.a(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.a(mediationAdSlotValueSet);
                    n.a(getClass().getName(), context);
                }
            });
        } else {
            a(mediationAdSlotValueSet);
        }
    }
}
