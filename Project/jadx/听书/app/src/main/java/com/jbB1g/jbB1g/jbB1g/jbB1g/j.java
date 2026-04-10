package com.jbB1g.jbB1g.jbB1g.jbB1g;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.gdt.GdtInterstitialLoader;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public class j extends MediationBaseAdBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    UnifiedInterstitialADListener f1728a;
    private UnifiedInterstitialAD b;
    private final MediationAdSlotValueSet c;
    private final GdtInterstitialLoader d;
    private boolean e;

    public j(MediationAdSlotValueSet mediationAdSlotValueSet, Function function, GdtInterstitialLoader gdtInterstitialLoader) {
        super(mediationAdSlotValueSet, function);
        this.f1728a = new UnifiedInterstitialADListener() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.j.5
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADClicked() {
                MediationApiLog.i("TMe", "GdtInterstitialLoader onADClicked");
                if (j.this.mGMAd != null) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, 1009);
                    sparseArray.put(-99999985, Void.class);
                    j.this.mGMAd.apply(sparseArray);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADClosed() {
                MediationApiLog.i("TMe", "GdtInterstitialLoader onADClosed");
                if (j.this.mGMAd != null) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, 1014);
                    sparseArray.put(-99999985, Void.class);
                    j.this.mGMAd.apply(sparseArray);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADExposure() {
                MediationApiLog.i("TMe", "GdtInterstitialLoader onADExposure");
                if (j.this.mGMAd != null) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, 1008);
                    sparseArray.put(-99999985, Void.class);
                    j.this.mGMAd.apply(sparseArray);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADLeftApplication() {
                MediationApiLog.i("TMe", "GdtInterstitialLoader onADLeftApplication");
                if (j.this.mGMAd != null) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, 1016);
                    sparseArray.put(-99999985, Void.class);
                    j.this.mGMAd.apply(sparseArray);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADOpened() {
                MediationApiLog.i("TMe", "GdtInterstitialLoader onADOpened");
                if (j.this.mGMAd != null) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, 1015);
                    sparseArray.put(-99999985, Void.class);
                    j.this.mGMAd.apply(sparseArray);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0089  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x008d  */
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @com.bytedance.JProtect
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onADReceive() {
                /*
                    r4 = this;
                    java.lang.String r0 = "GdtInterstitialLoader onADReceive"
                    java.lang.String r1 = "TMe"
                    com.bytedance.msdk.adapter.gdt.base.utils.MediationApiLog.i(r1, r0)
                    com.jbB1g.jbB1g.jbB1g.jbB1g.j r0 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.this
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialLoader r0 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.a(r0)
                    boolean r0 = r0.isClientBidding()
                    if (r0 == 0) goto L47
                    com.jbB1g.jbB1g.jbB1g.jbB1g.j r0 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.b(r0)
                    int r2 = r2.getECPM()
                    r3 = -1
                    if (r2 == r3) goto L2c
                    com.jbB1g.jbB1g.jbB1g.jbB1g.j r2 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.b(r2)
                    int r2 = r2.getECPM()
                    double r2 = (double) r2
                    goto L2e
                L2c:
                    r2 = 0
                L2e:
                    r0.setCpm(r2)
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r2 = "GdtInterstitialLoader GDT_clientBidding 插屏 返回的 cpm价格："
                    r0.<init>(r2)
                    com.jbB1g.jbB1g.jbB1g.jbB1g.j r2 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.b(r2)
                    int r2 = r2.getECPM()
                    java.lang.StringBuilder r0 = r0.append(r2)
                    goto L75
                L47:
                    com.jbB1g.jbB1g.jbB1g.jbB1g.j r0 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.this
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialLoader r0 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.a(r0)
                    boolean r0 = r0.isMultiBidding()
                    if (r0 == 0) goto L7c
                    com.jbB1g.jbB1g.jbB1g.jbB1g.j r0 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.b(r0)
                    java.lang.String r2 = r2.getECPMLevel()
                    r0.setLevelTag(r2)
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r2 = "GdtInterstitialLoader GDT_多阶底价 插屏 返回的价格标签："
                    r0.<init>(r2)
                    com.jbB1g.jbB1g.jbB1g.jbB1g.j r2 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.b(r2)
                    java.lang.String r2 = r2.getECPMLevel()
                    java.lang.StringBuilder r0 = r0.append(r2)
                L75:
                    java.lang.String r0 = r0.toString()
                    com.bytedance.msdk.adapter.gdt.base.utils.MediationApiLog.i(r1, r0)
                L7c:
                    com.jbB1g.jbB1g.jbB1g.jbB1g.j r0 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.b(r0)
                    int r0 = r0.getAdPatternType()
                    r1 = 2
                    if (r0 != r1) goto L8d
                    com.jbB1g.jbB1g.jbB1g.jbB1g.j r0 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.this
                    r1 = 5
                    goto L90
                L8d:
                    com.jbB1g.jbB1g.jbB1g.jbB1g.j r0 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.this
                    r1 = 3
                L90:
                    r0.setImageMode(r1)
                    com.jbB1g.jbB1g.jbB1g.jbB1g.j r0 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.this
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialLoader r0 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.a(r0)
                    com.jbB1g.jbB1g.jbB1g.jbB1g.j r1 = com.jbB1g.jbB1g.jbB1g.jbB1g.j.this
                    java.util.function.Function<android.util.SparseArray<java.lang.Object>, java.lang.Object> r2 = r1.mGMAd
                    r0.notifyAdSuccess(r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.jbB1g.jbB1g.jbB1g.jbB1g.j.AnonymousClass5.onADReceive():void");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onNoAD(AdError adError) {
                MediationApiLog.i("TMe", "GdtInterstitialLoader onNoAD");
                if (adError != null) {
                    j.this.d.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
                } else {
                    j.this.d.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "暂无广告");
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
            }
        };
        this.c = mediationAdSlotValueSet;
        this.d = gdtInterstitialLoader;
        this.e = a.a(gdtInterstitialLoader, mediationAdSlotValueSet);
    }

    private void a(Object obj) {
        final int iA = a.a(obj);
        if (iA == -1) {
            return;
        }
        if (this.e) {
            n.a(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.j.7
                @Override // java.lang.Runnable
                public void run() {
                    j.this.b.sendLossNotification(0, iA, null);
                }
            });
        } else {
            this.b.sendLossNotification(0, iA, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JProtect
    public void b(Context context) {
        UnifiedInterstitialAD unifiedInterstitialAD;
        VideoOption videoOptionBuild;
        MediationApiLog.i("TMe", "GdtInterstitialLoader loadAd adnId:" + this.d.getAdnId());
        if (!(context instanceof Activity)) {
            MediationApiLog.i("TMe", "GdtInterstitialLoader 传入mContext 不是 Activity 请求中断");
            return;
        }
        this.b = new UnifiedInterstitialAD((Activity) context, this.d.getAdnId(), this.f1728a);
        if (getGdtVideoOption() instanceof VideoOption) {
            unifiedInterstitialAD = this.b;
            videoOptionBuild = (VideoOption) getGdtVideoOption();
        } else {
            unifiedInterstitialAD = this.b;
            videoOptionBuild = new VideoOption.Builder().build();
        }
        unifiedInterstitialAD.setVideoOption(videoOptionBuild);
        if (this.c.getGdtMaxVideoDuration() > 0) {
            this.b.setMaxVideoDuration(this.c.getGdtMaxVideoDuration());
        }
        if (this.c.getGdtMinVideoDuration() > 0) {
            this.b.setMinVideoDuration(this.c.getGdtMinVideoDuration());
        }
        this.b.loadAD();
    }

    private void c(final Activity activity) {
        n.b(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.j.2
            @Override // java.lang.Runnable
            public void run() {
                j.this.a(activity);
            }
        });
    }

    private void c(final Context context) {
        n.a(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.j.1
            @Override // java.lang.Runnable
            public void run() {
                j.this.b(context);
                n.a(getClass().getName(), context);
            }
        });
    }

    private Integer d() {
        try {
            Integer num = (Integer) n.a(new Callable<Integer>() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.j.3
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Integer call() {
                    return j.this.a();
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
        return this.e ? f() : g();
    }

    private String f() {
        try {
            return (String) n.a(new Callable<String>() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.j.8
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return j.this.g();
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
            UnifiedInterstitialAD unifiedInterstitialAD = this.b;
            if (unifiedInterstitialAD == null || (obj = unifiedInterstitialAD.getExtraInfo().get("request_id")) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public Integer a() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.b;
        return Integer.valueOf((unifiedInterstitialAD == null || !unifiedInterstitialAD.isValid()) ? 4 : 2);
    }

    @JProtect
    public void a(Activity activity) {
        if (this.b == null || activity == null || activity.isFinishing()) {
            return;
        }
        this.b.show(activity);
    }

    public void a(Context context) {
        a.a((Map) this.c.getExtraObject());
        if (this.e) {
            c(context);
        } else {
            b(context);
        }
    }

    public void a(Map<String, Object> map) {
        UnifiedInterstitialAD unifiedInterstitialAD;
        if (this.d.isClientBidding() && (unifiedInterstitialAD = this.b) != null) {
            try {
                if (this.e) {
                    n.a(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.j.6
                        @Override // java.lang.Runnable
                        public void run() {
                            j.this.b.sendWinNotification((int) j.this.getCpm());
                        }
                    });
                } else {
                    unifiedInterstitialAD.sendWinNotification((int) getCpm());
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 8142) {
            MediationApiLog.i("TMe", "GdtInterstitialLoader bidWinNotify");
            Map<String, Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
            if (map != null) {
                a(map);
            }
        } else if (i == 8144) {
            MediationApiLog.i("TMe", "GdtInterstitialLoader bidLoseNotify");
            Map<String, Object> map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
            if (map2 != null) {
                b(map2);
            }
        } else if (i == 8113) {
            MediationApiLog.i("TMe", "GdtInterstitialLoader showAd");
            Activity activity = (Activity) MediationValueUtil.objectValue(sparseArray.get(20033), Activity.class, null);
            if (activity != null) {
                b(activity);
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
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public void b() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.b;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
            this.b = null;
        }
    }

    public void b(Activity activity) {
        if (this.e) {
            c(activity);
        } else {
            a(activity);
        }
    }

    public void b(Map<String, Object> map) {
        if (!this.d.isClientBidding() || this.b == null || map == null) {
            return;
        }
        try {
            a(map.get(MediationConstant.BIDDING_LOSE_REASON));
        } catch (Exception unused) {
        }
    }

    public void c() {
        n.b(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.j.4
            @Override // java.lang.Runnable
            public void run() {
                j.this.b();
            }
        });
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
    public boolean hasDestroyed() {
        return this.b == null;
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
    public Integer isReadyStatus() {
        return this.e ? d() : a();
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
    public void onDestroy() {
        if (this.e) {
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
