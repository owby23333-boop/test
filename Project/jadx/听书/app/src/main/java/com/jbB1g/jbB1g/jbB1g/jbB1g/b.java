package com.jbB1g.jbB1g.jbB1g.jbB1g;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.gdt.GdtDrawLoader;
import com.bytedance.msdk.adapter.gdt.base.ad.MediationNativeAd;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public class b extends MediationNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeExpressADView f1633a;
    private volatile boolean b;
    private g c;
    private boolean d;
    private NativeExpressMediaListener e;

    public b(g gVar, GdtDrawLoader gdtDrawLoader, Function<SparseArray<Object>, Object> function, NativeExpressADView nativeExpressADView, boolean z) {
        super(gdtDrawLoader, function);
        this.b = false;
        this.e = new NativeExpressMediaListener() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.b.1
            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoCached(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoComplete(NativeExpressADView nativeExpressADView2) {
                b.this.notifyOnVideoComplete();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoError(NativeExpressADView nativeExpressADView2, AdError adError) {
                b bVar = b.this;
                if (adError != null) {
                    bVar.notifyOnVideoError(adError.getErrorCode(), adError.getErrorMsg());
                } else {
                    bVar.notifyOnVideoError(MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "aderror is null");
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoInit(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoLoading(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPageClose(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPageOpen(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPause(NativeExpressADView nativeExpressADView2) {
                b.this.notifyOnVideoPause();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoReady(NativeExpressADView nativeExpressADView2, long j) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoStart(NativeExpressADView nativeExpressADView2) {
                b.this.notifyOnVideoStart();
            }
        };
        this.f1633a = nativeExpressADView;
        this.c = gVar;
        this.d = z;
        b();
    }

    private void a(Object obj) {
        final int iA = a.a(obj);
        if (iA == -1) {
            return;
        }
        if (this.d) {
            n.a(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.b.6
                @Override // java.lang.Runnable
                public void run() {
                    b.this.f1633a.sendLossNotification(0, iA, null);
                }
            });
        } else {
            this.f1633a.sendLossNotification(0, iA, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            r9 = this;
            android.util.SparseArray r0 = new android.util.SparseArray
            r0.<init>()
            com.qq.e.ads.nativ.NativeExpressADView r1 = r9.f1633a
            com.qq.e.comm.pi.AdData r1 = r1.getBoundData()
            int r2 = r1.getAdPatternType()
            r3 = 2
            r4 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
            r6 = 3
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r8 = 8060(0x1f7c, float:1.1294E-41)
            if (r2 != r3) goto L2e
            com.qq.e.ads.nativ.NativeExpressADView r2 = r9.f1633a
            com.qq.e.ads.nativ.NativeExpressMediaListener r3 = r9.e
            r2.setMediaListener(r3)
            r2 = 5
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L2a:
            r0.put(r8, r2)
            goto L4a
        L2e:
            int r2 = r1.getAdPatternType()
            r3 = 4
            if (r2 == r3) goto L47
            int r2 = r1.getAdPatternType()
            if (r2 != r4) goto L3c
            goto L47
        L3c:
            int r2 = r1.getAdPatternType()
            if (r2 != r6) goto L47
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            goto L2a
        L47:
            r0.put(r8, r7)
        L4a:
            r2 = 8033(0x1f61, float:1.1257E-41)
            r0.put(r2, r5)
            r3 = 8045(0x1f6d, float:1.1273E-41)
            java.lang.String r4 = r1.getTitle()
            r0.put(r3, r4)
            r3 = 8046(0x1f6e, float:1.1275E-41)
            java.lang.String r4 = r1.getDesc()
            r0.put(r3, r4)
            r3 = 8059(0x1f7b, float:1.1293E-41)
            r0.put(r3, r7)
            boolean r3 = r9.isClientBidding()
            if (r3 == 0) goto L81
            int r1 = r1.getECPM()
            double r3 = (double) r1
            r6 = 0
            double r3 = java.lang.Math.max(r3, r6)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r3 = 8016(0x1f50, float:1.1233E-41)
        L7d:
            r0.put(r3, r1)
            goto L8e
        L81:
            boolean r3 = r9.isMultiBidding()
            if (r3 == 0) goto L8e
            r3 = 8058(0x1f7a, float:1.1292E-41)
            java.lang.String r1 = r1.getECPMLevel()
            goto L7d
        L8e:
            r0.put(r2, r5)
            r9.notifyNativeValue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jbB1g.jbB1g.jbB1g.jbB1g.b.b():void");
    }

    private String c() {
        return this.d ? d() : e();
    }

    private String d() {
        try {
            return (String) n.a(new Callable<String>() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.b.2
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return b.this.e();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        Object obj;
        try {
            NativeExpressADView nativeExpressADView = this.f1633a;
            if (nativeExpressADView == null || (obj = nativeExpressADView.getExtraInfo().get("request_id")) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        notifyDislikeClick("gdt信息流模板dislike接口无关闭原因", new HashMap());
        notifyDislikeSelect(-1, "gdt信息流模板dislike接口无关闭原因");
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 6083) {
            if (this.d) {
                n.b(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.f1633a != null) {
                            b.this.f1633a.render();
                        }
                    }
                });
            } else {
                NativeExpressADView nativeExpressADView = this.f1633a;
                if (nativeExpressADView != null) {
                    nativeExpressADView.render();
                }
            }
        } else {
            if (i == 6081) {
                if (isServerBidding()) {
                    NativeExpressADView nativeExpressADView2 = this.f1633a;
                    nativeExpressADView2.setBidECPM(nativeExpressADView2.getECPM());
                }
                return (T) this.f1633a;
            }
            if (i == 8135) {
                return (T) true;
            }
            if (i == 8109) {
                this.b = true;
                if (this.c.a() != null) {
                    this.c.a().remove(this.f1633a);
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.f1633a != null) {
                            b.this.f1633a.destroy();
                        }
                    }
                });
            } else {
                if (i == 8120) {
                    return (T) Boolean.valueOf(this.b);
                }
                try {
                    if (i == 8142) {
                        NativeExpressADView nativeExpressADView3 = this.f1633a;
                        if (nativeExpressADView3 != null) {
                            if (this.d) {
                                n.a(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.b.5
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.f1633a.sendWinNotification((int) b.this.getCpm());
                                    }
                                });
                            } else {
                                nativeExpressADView3.sendWinNotification((int) getCpm());
                            }
                        }
                    } else if (i == 8144) {
                        Map map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        if (map != null && this.f1633a != null) {
                            a(map.get(MediationConstant.BIDDING_LOSE_REASON));
                        }
                    } else if (i == 8147) {
                        return (T) c();
                    }
                } catch (Exception unused) {
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
