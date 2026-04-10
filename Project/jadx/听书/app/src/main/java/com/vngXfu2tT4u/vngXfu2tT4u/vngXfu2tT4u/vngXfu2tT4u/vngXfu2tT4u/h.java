package com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ks.KsFullVideoLoader;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge;
import com.bytedance.msdk.adapter.ks.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.ks.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
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
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KsFullVideoLoader f2441a;
    private boolean b;

    class a extends MediationBaseAdBridge {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        KsLoadManager.FullScreenVideoAdListener f2443a;
        private KsFullScreenVideoAd c;

        public a(MediationAdSlotValueSet mediationAdSlotValueSet, Function function) {
            super(mediationAdSlotValueSet, function);
            this.f2443a = new KsLoadManager.FullScreenVideoAdListener() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.h.a.4
                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                @JProtect
                public void onError(int i, String str) {
                    MediationApiLog.i("TMe", "ks_KsFullVideoLoader onError");
                    h.this.f2441a.notifyAdFailed(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                @JProtect
                public void onFullScreenVideoAdLoad(List<KsFullScreenVideoAd> list) {
                    MediationApiLog.i("TMe", "ks_KsFullVideoLoader onFullScreenVideoAdLoad");
                    if (list == null || list.size() == 0 || list.get(0) == null) {
                        h.this.f2441a.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "暂无广告");
                        return;
                    }
                    a.this.c = list.get(0);
                    if (h.this.f2441a.isClientBidding()) {
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
                    a.this.setExpress();
                    a.this.c.setFullScreenVideoAdInteractionListener(new KsFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.h.a.4.1
                        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onAdClicked() {
                            MediationApiLog.i("TMe", "ks_KsFullVideoLoader onAdClicked");
                            if (a.this.mGMAd != null) {
                                SparseArray<Object> sparseArray2 = new SparseArray<>();
                                sparseArray2.put(-99999987, 1009);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.mGMAd.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onPageDismiss() {
                            MediationApiLog.i("TMe", "ks_KsFullVideoLoader onPageDismiss");
                            if (a.this.mGMAd != null) {
                                SparseArray<Object> sparseArray2 = new SparseArray<>();
                                sparseArray2.put(-99999987, 1014);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.mGMAd.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onSkippedVideo() {
                            MediationApiLog.i("TMe", "ks_KsFullVideoLoader onSkippedVideo");
                            if (a.this.mGMAd != null) {
                                SparseArray<Object> sparseArray2 = new SparseArray<>();
                                sparseArray2.put(-99999987, 1037);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.mGMAd.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onVideoPlayEnd() {
                            MediationApiLog.i("TMe", "ks_KsFullVideoLoader onVideoPlayEnd");
                            if (a.this.mGMAd != null) {
                                SparseArray<Object> sparseArray2 = new SparseArray<>();
                                sparseArray2.put(-99999987, Integer.valueOf(AnalyticsListener.EVENT_DRM_KEYS_REMOVED));
                                sparseArray2.put(-99999985, Void.class);
                                a.this.mGMAd.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onVideoPlayError(int i, int i2) {
                            MediationApiLog.i("TMe", "ks_KsFullVideoLoader onVideoPlayError");
                            if (a.this.mGMAd != null) {
                                SparseArray<Object> sparseArray2 = new SparseArray<>();
                                sparseArray2.put(-99999987, 1021);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.mGMAd.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onVideoPlayStart() {
                            MediationApiLog.i("TMe", "ks_KsFullVideoLoader onVideoPlayStart");
                            if (a.this.mGMAd != null) {
                                SparseArray<Object> sparseArray2 = new SparseArray<>();
                                sparseArray2.put(-99999987, 1008);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.mGMAd.apply(sparseArray2);
                            }
                        }
                    });
                    KsFullVideoLoader ksFullVideoLoader = h.this.f2441a;
                    a aVar2 = a.this;
                    ksFullVideoLoader.notifyAdSuccess(aVar2, aVar2.mGMAd);
                    h.this.f2441a.notifyAdCache(a.this.mGMAd, MediationConstant.ErrorCode.ADN_AD_NO_CACHE, "没有cache回调");
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public void onFullScreenVideoResult(List<KsFullScreenVideoAd> list) {
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JProtect
        public void b(Activity activity) {
            MediationApiLog.i("TMe", "ks_KsFullVideoLoader showAd");
            if (activity == null || this.c == null) {
                return;
            }
            KsVideoPlayConfig.Builder builder = new KsVideoPlayConfig.Builder();
            boolean zIsMuted = isMuted();
            if (getOrientation() == 2) {
                builder.showLandscape(true);
            }
            builder.videoSoundEnable(!zIsMuted);
            this.c.showFullScreenVideoAd(activity, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Integer c() {
            MediationApiLog.i("TMe", "ks_KsFullVideoLoader isReadyStatus");
            KsFullScreenVideoAd ksFullScreenVideoAd = this.c;
            return Integer.valueOf((ksFullScreenVideoAd == null || !ksFullScreenVideoAd.isAdEnable()) ? 4 : 2);
        }

        private void c(final Activity activity) {
            n.b(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.h.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(activity);
                }
            });
        }

        private Integer d() {
            try {
                Integer num = (Integer) n.a(new Callable<Integer>() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.h.a.2
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Integer call() {
                        return a.this.c();
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

        private String e() {
            return h.this.b ? f() : g();
        }

        private String f() {
            try {
                return (String) n.a(new Callable<String>() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.h.a.5
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public String call() {
                        return a.this.g();
                    }
                }).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String g() {
            Object obj;
            try {
                KsFullScreenVideoAd ksFullScreenVideoAd = this.c;
                if (ksFullScreenVideoAd == null || (obj = ksFullScreenVideoAd.getMediaExtraInfo().get("llsid")) == null) {
                    return null;
                }
                return obj.toString();
            } catch (Throwable unused) {
                return null;
            }
        }

        public void a() {
            MediationApiLog.i("TMe", "ks_KsFullVideoLoader onDestroy");
            KsFullScreenVideoAd ksFullScreenVideoAd = this.c;
            if (ksFullScreenVideoAd != null) {
                ksFullScreenVideoAd.setFullScreenVideoAdInteractionListener(null);
                this.c = null;
            }
        }

        public void a(Activity activity) {
            if (h.this.b) {
                c(activity);
            } else {
                b(activity);
            }
        }

        @JProtect
        public void a(KsScene ksScene) {
            MediationApiLog.i("TMe", "ks_KsFullVideoLoader loadAd");
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(ksScene, this.f2443a);
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
        public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
            if (i == 8113) {
                MediationApiLog.i("TMe", "ks_KsFullVideoLoader showAd");
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
                    return (T) e();
                }
                if (i == 8142) {
                    if (o.a(this.c)) {
                        Map map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                        if (map != null) {
                            long jA = o.a((Map<String, Object>) map);
                            long jB = o.b((Map<String, Object>) map);
                            MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + jA + " loseBidEcpm = " + jB);
                            KsFullScreenVideoAd ksFullScreenVideoAd = this.c;
                            if (ksFullScreenVideoAd != null) {
                                ksFullScreenVideoAd.setBidEcpm(jA, jB);
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
            n.b(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.h.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a();
                }
            });
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public boolean hasDestroyed() {
            MediationApiLog.i("TMe", "ks_KsFullVideoLoader hasDestroyed");
            return this.c == null;
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public Integer isReadyStatus() {
            return h.this.b ? d() : c();
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public void onDestroy() {
            if (h.this.b) {
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

    public h(KsFullVideoLoader ksFullVideoLoader) {
        this.f2441a = ksFullVideoLoader;
    }

    public void a(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean zA = o.a(this.f2441a, mediationAdSlotValueSet);
        this.b = zA;
        if (zA) {
            n.a(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.a(mediationAdSlotValueSet);
                    n.a(getClass().getName(), context);
                }
            });
        } else {
            a(mediationAdSlotValueSet);
        }
    }

    public void a(MediationAdSlotValueSet mediationAdSlotValueSet) {
        try {
            new a(mediationAdSlotValueSet, this.f2441a.getGMBridge()).a(new KsScene.Builder(Long.valueOf(this.f2441a.getAdnId()).longValue()).build());
        } catch (Exception unused) {
            this.f2441a.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "代码位不合法");
        }
    }
}
