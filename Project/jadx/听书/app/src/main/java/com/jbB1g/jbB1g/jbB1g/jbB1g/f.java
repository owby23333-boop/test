package com.jbB1g.jbB1g.jbB1g.jbB1g;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.gdt.GdtBannerLoader;
import com.bytedance.msdk.adapter.gdt.R;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.gdt.base.config.MediationViewBinder;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediationAdSlotValueSet f1677a;
    private Function<SparseArray<Object>, Object> b;
    private FrameLayout.LayoutParams c;
    private final GdtBannerLoader d;
    private boolean e;
    private final NativeExpressAD.NativeExpressADListener f = new NativeExpressAD.NativeExpressADListener() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.2

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        c f1679a;

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            c cVar = this.f1679a;
            if (cVar != null) {
                cVar.c();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            c cVar = this.f1679a;
            if (cVar != null) {
                cVar.b();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            c cVar = this.f1679a;
            if (cVar != null) {
                cVar.d();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            c cVar = this.f1679a;
            if (cVar != null) {
                cVar.a();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            if (list == null || list.size() == 0) {
                f.this.d.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty");
                return;
            }
            for (NativeExpressADView nativeExpressADView : list) {
                if (nativeExpressADView != null) {
                    f fVar = f.this;
                    c cVar = fVar.new c(nativeExpressADView, fVar.f1677a, f.this.b);
                    this.f1679a = cVar;
                    cVar.e();
                    return;
                }
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            if (adError != null) {
                f.this.d.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                f.this.d.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "error is null");
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            f.this.d.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "render fail");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            f.this.d.notifyAdSuccess(this.f1679a, f.this.b);
        }
    };
    private final NativeADUnifiedListener g = new NativeADUnifiedListener() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.3
        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            if (list == null || list.size() <= 0) {
                f.this.d.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is empty");
                return;
            }
            for (NativeUnifiedADData nativeUnifiedADData : list) {
                if (nativeUnifiedADData != null) {
                    GdtBannerLoader gdtBannerLoader = f.this.d;
                    f fVar = f.this;
                    gdtBannerLoader.notifyAdSuccess(fVar.new b(nativeUnifiedADData, fVar.f1677a, f.this.b), f.this.b);
                    return;
                }
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            if (adError != null) {
                f.this.d.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                f.this.d.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "error is null");
            }
        }
    };

    class a extends MediationBaseAdBridge {
        private UnifiedBannerView b;
        private boolean c;
        private boolean d;

        public a(MediationAdSlotValueSet mediationAdSlotValueSet, Function function) {
            super(mediationAdSlotValueSet, function);
            this.c = false;
            this.d = false;
        }

        private void a(Object obj) {
            final int iA = com.jbB1g.jbB1g.jbB1g.jbB1g.a.a(obj);
            if (iA == -1) {
                return;
            }
            if (f.this.e) {
                n.a(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b.sendLossNotification(0, iA, null);
                    }
                });
            } else {
                this.b.sendLossNotification(0, iA, null);
            }
        }

        private View c() {
            return this.b;
        }

        private String d() {
            return f.this.e ? e() : f();
        }

        private String e() {
            try {
                return (String) n.a(new Callable<String>() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.a.6
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
                UnifiedBannerView unifiedBannerView = this.b;
                if (unifiedBannerView == null || (obj = unifiedBannerView.getExtraInfo().get("request_id")) == null) {
                    return null;
                }
                return obj.toString();
            } catch (Throwable unused) {
                return null;
            }
        }

        public Integer a() {
            UnifiedBannerView unifiedBannerView = this.b;
            return Integer.valueOf((unifiedBannerView == null || !unifiedBannerView.isValid()) ? 4 : 2);
        }

        void a(Context context) {
            if (context instanceof Activity) {
                UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) context, f.this.d.getAdnId(), new UnifiedBannerADListener() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.a.1
                    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                    public void onADClicked() {
                        if (a.this.mGMAd != null) {
                            SparseArray<Object> sparseArray = new SparseArray<>();
                            sparseArray.put(-99999987, 1009);
                            sparseArray.put(-99999985, Void.class);
                            a.this.mGMAd.apply(sparseArray);
                        }
                    }

                    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                    public void onADClosed() {
                        if (a.this.mGMAd != null) {
                            SparseArray<Object> sparseArray = new SparseArray<>();
                            sparseArray.put(-99999987, 1014);
                            sparseArray.put(-99999985, Void.class);
                            a.this.mGMAd.apply(sparseArray);
                        }
                    }

                    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                    public void onADExposure() {
                        if (a.this.mGMAd != null) {
                            SparseArray<Object> sparseArray = new SparseArray<>();
                            sparseArray.put(-99999987, 1008);
                            sparseArray.put(-99999985, Void.class);
                            a.this.mGMAd.apply(sparseArray);
                        }
                    }

                    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                    public void onADLeftApplication() {
                        if (a.this.mGMAd != null) {
                            SparseArray<Object> sparseArray = new SparseArray<>();
                            sparseArray.put(-99999987, 1016);
                            sparseArray.put(-99999985, Void.class);
                            a.this.mGMAd.apply(sparseArray);
                        }
                    }

                    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                    public void onADReceive() {
                        if (a.this.c) {
                            return;
                        }
                        a.this.c = true;
                        if (a.this.b != null) {
                            if (f.this.d.isClientBidding()) {
                                int ecpm = a.this.b.getECPM();
                                a.this.setCpm(ecpm > 0 ? ecpm : 0.0d);
                            } else if (f.this.d.isMultiBidding()) {
                                a aVar = a.this;
                                aVar.setCpmLevel(aVar.b.getECPMLevel());
                            }
                        }
                        GdtBannerLoader gdtBannerLoader = f.this.d;
                        a aVar2 = a.this;
                        gdtBannerLoader.notifyAdSuccess(aVar2, aVar2.mGMAd);
                    }

                    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                    public void onNoAD(AdError adError) {
                        if (a.this.c) {
                            return;
                        }
                        a.this.c = true;
                        f.this.d.notifyAdFailed(adError != null ? adError.getErrorCode() : -1, adError != null ? adError.getErrorMsg() : "位置错误");
                    }
                });
                this.b = unifiedBannerView;
                unifiedBannerView.setRefresh(0);
                this.b.loadAD();
            }
        }

        public void a(Map<String, Object> map) {
            if (f.this.d.isClientBidding() && this.b != null) {
                try {
                    if (f.this.e) {
                        n.a(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.a.4
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.b.sendWinNotification((int) a.this.getCpm());
                            }
                        });
                    } else {
                        this.b.sendWinNotification((int) getCpm());
                    }
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
        public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
            if (i == 6081) {
                return (T) c();
            }
            if (i == 8121) {
                return (T) isReadyStatusForProto2(isReadyStatus(), sparseArray, cls);
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8109) {
                onDestroy();
            } else if (i == 8142) {
                MediationApiLog.i("TMe", "GdtBannerLoader bidWinNotify");
                Map<String, Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                if (map != null) {
                    a(map);
                }
            } else if (i == 8144) {
                MediationApiLog.i("TMe", "GdtBannerLoader bidLoseNotify");
                Map<String, Object> map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                if (map2 != null) {
                    b(map2);
                }
            } else if (i == 8147) {
                return (T) d();
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        public Integer b() {
            try {
                Integer num = (Integer) n.a(new Callable<Integer>() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.a.2
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Integer call() {
                        return a.this.a();
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

        public void b(Map<String, Object> map) {
            if (!f.this.d.isClientBidding() || this.b == null || map == null) {
                return;
            }
            try {
                a(map.get(MediationConstant.BIDDING_LOSE_REASON));
            } catch (Exception unused) {
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
        }

        @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.d;
        }

        @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
        public Integer isReadyStatus() {
            return f.this.e ? b() : a();
        }

        @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
        public void onDestroy() {
            this.d = true;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.b != null) {
                        a.this.b.destroy();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    class b extends MediationBaseAdBridge {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        NativeUnifiedADData f1688a;
        NativeADMediaListener b;
        private String d;
        private volatile boolean e;

        /* JADX WARN: Removed duplicated region for block: B:15:0x013e  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0147  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0175  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x017a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        b(com.qq.e.ads.nativ.NativeUnifiedADData r6, com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet r7, java.util.function.Function r8) {
            /*
                Method dump skipped, instruction units count: 418
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jbB1g.jbB1g.jbB1g.jbB1g.f.b.<init>(com.jbB1g.jbB1g.jbB1g.jbB1g.f, com.qq.e.ads.nativ.NativeUnifiedADData, com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet, java.util.function.Function):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JProtect
        public void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
            NativeAdContainer nativeAdContainer;
            Object tag;
            if (this.f1688a != null) {
                if (list3 != null) {
                    if (list2 == null) {
                        list2 = new ArrayList<>();
                    }
                    list2.addAll(list3);
                }
                List<View> list4 = list2;
                int i = 0;
                if (viewGroup.getChildCount() == 0 || !(viewGroup.getChildAt(0) instanceof NativeAdContainer)) {
                    nativeAdContainer = new NativeAdContainer(context);
                    nativeAdContainer.setTag(R.id.tt_mediation_gdt_developer_view_root_tag_key, MediationConstant.TT_GDT_NATIVE_ROOT_VIEW_TAG);
                    while (viewGroup.getChildCount() > 0) {
                        View childAt = viewGroup.getChildAt(0);
                        childAt.setTag(R.id.tt_mediation_gdt_developer_view_tag_key, MediationConstant.TT_GDT_NATIVE_VIEW_TAG);
                        int iIndexOfChild = viewGroup.indexOfChild(childAt);
                        viewGroup.removeViewInLayout(childAt);
                        if (childAt != null) {
                            nativeAdContainer.addView(childAt, iIndexOfChild, childAt.getLayoutParams());
                        }
                    }
                    viewGroup.removeAllViews();
                    viewGroup.addView(nativeAdContainer, -1, -1);
                } else {
                    nativeAdContainer = (NativeAdContainer) viewGroup.getChildAt(0);
                    while (i < nativeAdContainer.getChildCount()) {
                        View childAt2 = nativeAdContainer.getChildAt(i);
                        if (childAt2 == null || ((tag = childAt2.getTag(R.id.tt_mediation_gdt_developer_view_tag_key)) != null && (tag instanceof String) && ((String) tag).equals(MediationConstant.TT_GDT_NATIVE_VIEW_TAG))) {
                            i++;
                        } else {
                            nativeAdContainer.removeView(childAt2);
                        }
                    }
                }
                NativeAdContainer nativeAdContainer2 = nativeAdContainer;
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(mediationViewBinder.mediaViewId);
                this.f1688a.bindAdToView(context, nativeAdContainer2, f.this.c, list, list4);
                if (viewGroup2 != null && this.f1688a.getAdPatternType() == 2) {
                    MediaView mediaView = new MediaView(context);
                    viewGroup2.removeAllViews();
                    viewGroup2.addView(mediaView, -1, -1);
                    VideoOption videoOptionBuild = new VideoOption.Builder().build();
                    if (f.this.f1677a != null && (f.this.f1677a.getGdtVideoOption() instanceof VideoOption)) {
                        videoOptionBuild = (VideoOption) f.this.f1677a.getGdtVideoOption();
                    }
                    this.f1688a.bindMediaView(mediaView, videoOptionBuild, this.b);
                }
                if (!TextUtils.isEmpty(this.f1688a.getCTAText())) {
                    View viewFindViewById = viewGroup.findViewById(mediationViewBinder.callToActionId);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(viewFindViewById);
                    this.f1688a.bindCTAViews(arrayList);
                }
                this.f1688a.setNativeAdEventListener(new NativeADEventListener() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.b.1
                    @Override // com.qq.e.ads.nativ.NativeADEventListener
                    public void onADClicked() {
                        if (b.this.mGMAd != null) {
                            SparseArray<Object> sparseArray = new SparseArray<>();
                            sparseArray.put(-99999987, 1009);
                            sparseArray.put(-99999985, Void.class);
                            b.this.mGMAd.apply(sparseArray);
                        }
                    }

                    @Override // com.qq.e.ads.nativ.NativeADEventListener
                    public void onADError(AdError adError) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeADEventListener
                    public void onADExposed() {
                        if (b.this.mGMAd != null) {
                            SparseArray<Object> sparseArray = new SparseArray<>();
                            sparseArray.put(-99999987, 1008);
                            sparseArray.put(-99999985, Void.class);
                            b.this.mGMAd.apply(sparseArray);
                        }
                    }

                    @Override // com.qq.e.ads.nativ.NativeADEventListener
                    public void onADStatusChanged() {
                    }
                });
            }
        }

        private void a(Object obj) {
            final int iA = com.jbB1g.jbB1g.jbB1g.jbB1g.a.a(obj);
            if (iA == -1) {
                return;
            }
            if (f.this.e) {
                n.a(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.b.5
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.f1688a.sendLossNotification(0, iA, null);
                    }
                });
            } else {
                this.f1688a.sendLossNotification(0, iA, null);
            }
        }

        private String c() {
            return f.this.e ? d() : e();
        }

        private String d() {
            try {
                return (String) n.a(new Callable<String>() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.b.7
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
                NativeUnifiedADData nativeUnifiedADData = this.f1688a;
                if (nativeUnifiedADData == null || (obj = nativeUnifiedADData.getExtraInfo().get("request_id")) == null) {
                    return null;
                }
                return obj.toString();
            } catch (Throwable unused) {
                return null;
            }
        }

        public Integer a() {
            NativeUnifiedADData nativeUnifiedADData = this.f1688a;
            return Integer.valueOf((nativeUnifiedADData == null || !nativeUnifiedADData.isValid()) ? 4 : 2);
        }

        public void a(Map<String, Object> map) {
            if (f.this.d.isClientBidding() && this.f1688a != null) {
                try {
                    if (f.this.e) {
                        n.a(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.b.4
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.f1688a.sendWinNotification((int) b.this.getCpm());
                            }
                        });
                    } else {
                        this.f1688a.sendWinNotification((int) getCpm());
                    }
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
        public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
            if (i == 8121) {
                return (T) isReadyStatusForProto2(isReadyStatus(), sparseArray, cls);
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8159) {
                final Activity activity = (Activity) MediationValueUtil.objectValue(sparseArray.get(20033), Activity.class, null);
                final ViewGroup viewGroup = (ViewGroup) MediationValueUtil.objectValue(sparseArray.get(8067), ViewGroup.class, null);
                final List<View> list = (List) MediationValueUtil.objectValue(sparseArray.get(8068), List.class, null);
                final List<View> list2 = (List) MediationValueUtil.objectValue(sparseArray.get(8069), List.class, null);
                final List<View> list3 = (List) MediationValueUtil.objectValue(sparseArray.get(8070), List.class, null);
                final Object objObjectValue = MediationValueUtil.objectValue(sparseArray.get(8071), Object.class, null);
                if (f.this.e) {
                    n.b(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.b.8
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.a(activity, viewGroup, list, list2, list3, com.jbB1g.jbB1g.jbB1g.jbB1g.a.a(AdnAdapterBridgeWrapper.covertToFunction(objObjectValue)));
                        }
                    });
                } else {
                    a(activity, viewGroup, list, list2, list3, com.jbB1g.jbB1g.jbB1g.jbB1g.a.a(AdnAdapterBridgeWrapper.covertToFunction(objObjectValue)));
                }
            } else if (i == 8109) {
                onDestroy();
            } else if (i == 8142) {
                MediationApiLog.i(this.d, "GdtBannerLoader Native bidWinNotify");
                Map<String, Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                if (map != null) {
                    a(map);
                }
            } else if (i == 8144) {
                MediationApiLog.i(this.d, "GdtBannerLoader Native bidLoseNotify");
                Map<String, Object> map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                if (map2 != null) {
                    b(map2);
                }
            } else if (i == 8147) {
                return (T) c();
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        public Integer b() {
            try {
                Integer num = (Integer) n.a(new Callable<Integer>() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.b.3
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Integer call() {
                        return b.this.a();
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

        public void b(Map<String, Object> map) {
            if (!f.this.d.isClientBidding() || this.f1688a == null || map == null) {
                return;
            }
            try {
                a(map.get(MediationConstant.BIDDING_LOSE_REASON));
            } catch (Exception unused) {
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
        }

        @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.e;
        }

        @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
        public Integer isReadyStatus() {
            return f.this.e ? b() : a();
        }

        @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
        public void onDestroy() {
            this.e = true;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f1688a != null) {
                        b.this.f1688a.destroy();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    class c extends MediationBaseAdBridge {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        NativeExpressADView f1697a;
        private String c;
        private volatile boolean d;
        private final NativeExpressMediaListener e;

        /* JADX WARN: Removed duplicated region for block: B:17:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00a9  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        c(com.qq.e.ads.nativ.NativeExpressADView r10, com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet r11, java.util.function.Function r12) {
            /*
                r8 = this;
                com.jbB1g.jbB1g.jbB1g.jbB1g.f.this = r9
                r8.<init>(r11, r12)
                java.lang.String r11 = "GdtBanenrLoader-TTExpressAd"
                r8.c = r11
                r11 = 0
                r8.d = r11
                com.jbB1g.jbB1g.jbB1g.jbB1g.f$c$6 r11 = new com.jbB1g.jbB1g.jbB1g.jbB1g.f$c$6
                r11.<init>()
                r8.e = r11
                r8.f1697a = r10
                android.util.SparseArray r0 = new android.util.SparseArray
                r0.<init>()
                com.qq.e.comm.pi.AdData r1 = r10.getBoundData()
                int r2 = r1.getAdPatternType()
                r3 = 2
                r4 = 1
                r5 = 3
                java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
                r7 = 8060(0x1f7c, float:1.1294E-41)
                if (r2 != r3) goto L39
                r10.setMediaListener(r11)
                r10 = 5
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            L35:
                r0.put(r7, r10)
                goto L55
            L39:
                int r10 = r1.getAdPatternType()
                r11 = 4
                if (r10 == r11) goto L52
                int r10 = r1.getAdPatternType()
                if (r10 != r4) goto L47
                goto L52
            L47:
                int r10 = r1.getAdPatternType()
                if (r10 != r5) goto L52
                java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
                goto L35
            L52:
                r0.put(r7, r6)
            L55:
                r10 = 8033(0x1f61, float:1.1257E-41)
                java.lang.Boolean r11 = java.lang.Boolean.valueOf(r4)
                r0.put(r10, r11)
                r10 = 8045(0x1f6d, float:1.1273E-41)
                java.lang.String r11 = r1.getTitle()
                r0.put(r10, r11)
                r10 = 8046(0x1f6e, float:1.1275E-41)
                java.lang.String r11 = r1.getDesc()
                r0.put(r10, r11)
                r10 = 8059(0x1f7b, float:1.1293E-41)
                r0.put(r10, r6)
                r10 = 8140(0x1fcc, float:1.1407E-41)
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
                r11 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
                r0.put(r11, r10)
                r10 = -99999985(0xfffffffffa0a1f0f, float:-1.7929173E35)
                java.lang.Class<java.lang.Void> r11 = java.lang.Void.class
                r0.put(r10, r11)
                r12.apply(r0)
                com.bytedance.msdk.adapter.gdt.GdtBannerLoader r10 = com.jbB1g.jbB1g.jbB1g.jbB1g.f.a(r9)
                boolean r10 = r10.isClientBidding()
                if (r10 == 0) goto La9
                int r9 = r1.getECPM()
                r10 = -1
                if (r9 == r10) goto La3
                int r9 = r1.getECPM()
                double r9 = (double) r9
                goto La5
            La3:
                r9 = 0
            La5:
                r8.setCpm(r9)
                goto Lba
            La9:
                com.bytedance.msdk.adapter.gdt.GdtBannerLoader r9 = com.jbB1g.jbB1g.jbB1g.jbB1g.f.a(r9)
                boolean r9 = r9.isMultiBidding()
                if (r9 == 0) goto Lba
                java.lang.String r9 = r1.getECPMLevel()
                r8.setCpmLevel(r9)
            Lba:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jbB1g.jbB1g.jbB1g.jbB1g.f.c.<init>(com.jbB1g.jbB1g.jbB1g.jbB1g.f, com.qq.e.ads.nativ.NativeExpressADView, com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet, java.util.function.Function):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a(AdData.VideoPlayer videoPlayer) {
            if (videoPlayer == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder("{state:");
            sb.append(videoPlayer.getVideoState()).append(",duration:").append(videoPlayer.getDuration()).append(",position:").append(videoPlayer.getCurrentPosition()).append("}");
            return sb.toString();
        }

        private void a(Object obj) {
            final int iA = com.jbB1g.jbB1g.jbB1g.jbB1g.a.a(obj);
            if (iA == -1) {
                return;
            }
            if (f.this.e) {
                n.a(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.c.5
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.f1697a.sendLossNotification(0, iA, null);
                    }
                });
            } else {
                this.f1697a.sendLossNotification(0, iA, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Integer g() {
            NativeExpressADView nativeExpressADView = this.f1697a;
            return Integer.valueOf((nativeExpressADView == null || !nativeExpressADView.isValid()) ? 4 : 2);
        }

        private Integer h() {
            try {
                Integer num = (Integer) n.a(new Callable<Integer>() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.c.3
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Integer call() {
                        return c.this.g();
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

        private String i() {
            return f.this.e ? j() : k();
        }

        private String j() {
            try {
                return (String) n.a(new Callable<String>() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.c.7
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public String call() {
                        return c.this.k();
                    }
                }).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String k() {
            Object obj;
            try {
                NativeExpressADView nativeExpressADView = this.f1697a;
                if (nativeExpressADView == null || (obj = nativeExpressADView.getExtraInfo().get("request_id")) == null) {
                    return null;
                }
                return obj.toString();
            } catch (Throwable unused) {
                return null;
            }
        }

        public void a() {
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 1016);
                sparseArray.put(-99999985, Void.class);
                this.mGMAd.apply(sparseArray);
            }
        }

        public void a(Map<String, Object> map) {
            if (f.this.d.isClientBidding() && this.f1697a != null) {
                try {
                    if (f.this.e) {
                        n.a(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.c.4
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.f1697a.sendWinNotification((int) c.this.getCpm());
                            }
                        });
                    } else {
                        this.f1697a.sendWinNotification((int) getCpm());
                    }
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
        public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
            if (i == 6081) {
                return (T) f();
            }
            if (i == 8121) {
                return (T) isReadyStatusForProto2(isReadyStatus(), sparseArray, cls);
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8109) {
                onDestroy();
            } else if (i == 8142) {
                MediationApiLog.i(this.c, "GdtBannerLoader ExpressNative bidWinNotify");
                Map<String, Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                if (map != null) {
                    a(map);
                }
            } else if (i == 8144) {
                MediationApiLog.i(this.c, "GdtBannerLoader ExpressNative bidLoseNotify");
                Map<String, Object> map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                if (map2 != null) {
                    b(map2);
                }
            } else if (i == 8147) {
                return (T) i();
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        public void b() {
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 1014);
                sparseArray.put(-99999985, Void.class);
                this.mGMAd.apply(sparseArray);
            }
        }

        public void b(Map<String, Object> map) {
            if (!f.this.d.isClientBidding() || this.f1697a == null || map == null) {
                return;
            }
            try {
                a(map.get(MediationConstant.BIDDING_LOSE_REASON));
            } catch (Exception unused) {
            }
        }

        public void c() {
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 1009);
                sparseArray.put(-99999985, Void.class);
                this.mGMAd.apply(sparseArray);
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
        }

        public void d() {
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 1008);
                sparseArray.put(-99999985, Void.class);
                this.mGMAd.apply(sparseArray);
            }
        }

        @JProtect
        public void e() {
            if (f.this.e) {
                n.b(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.f1697a != null) {
                            c.this.f1697a.render();
                        }
                    }
                });
                return;
            }
            NativeExpressADView nativeExpressADView = this.f1697a;
            if (nativeExpressADView != null) {
                nativeExpressADView.render();
            }
        }

        @JProtect
        public View f() {
            return this.f1697a;
        }

        @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.d;
        }

        @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
        public Integer isReadyStatus() {
            return f.this.e ? h() : g();
        }

        @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
        public void onDestroy() {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.f1697a != null) {
                        c.this.f1697a.destroy();
                    }
                }
            });
            this.d = true;
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    public f(GdtBannerLoader gdtBannerLoader) {
        this.d = gdtBannerLoader;
    }

    private ADSize a(MediationAdSlotValueSet mediationAdSlotValueSet) {
        ADSize aDSize = new ADSize(-1, -2);
        float expressWidth = mediationAdSlotValueSet.getExpressWidth();
        float expressHeight = mediationAdSlotValueSet.getExpressHeight();
        return expressWidth > 0.0f ? (com.jbB1g.jbB1g.jbB1g.jbB1g.a.a(mediationAdSlotValueSet) || expressHeight == 0.0f) ? new ADSize((int) expressWidth, -2) : new ADSize((int) expressWidth, (int) expressHeight) : aDSize;
    }

    private void a(Context context) {
        NativeExpressAD nativeExpressAD = this.d.isServerBidding() ? new NativeExpressAD(context, a(this.f1677a), this.d.getAdnId(), this.f, this.d.getAdm()) : new NativeExpressAD(context, a(this.f1677a), this.d.getAdnId(), this.f);
        int gdtMaxVideoDuration = this.f1677a.getGdtMaxVideoDuration();
        int gdtMinVideoDuration = this.f1677a.getGdtMinVideoDuration();
        if (gdtMinVideoDuration > 0) {
            nativeExpressAD.setMinVideoDuration(gdtMinVideoDuration);
        }
        if (gdtMaxVideoDuration > 0) {
            nativeExpressAD.setMaxVideoDuration(gdtMaxVideoDuration);
        }
        nativeExpressAD.setVideoOption(this.f1677a.getGdtVideoOption() instanceof VideoOption ? (VideoOption) this.f1677a.getGdtVideoOption() : new VideoOption.Builder().build());
        nativeExpressAD.loadAD(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediationAdSlotValueSet mediationAdSlotValueSet, Context context) {
        if (mediationAdSlotValueSet.getAdSubType() != 4) {
            new a(mediationAdSlotValueSet, this.b).a(context);
            return;
        }
        int originType = mediationAdSlotValueSet.getOriginType();
        if (originType == 1) {
            a(context.getApplicationContext());
        } else if (originType == 2) {
            b(context.getApplicationContext());
        } else {
            this.d.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "originType is mismatch");
        }
    }

    private void b(Context context) {
        NativeUnifiedAD nativeUnifiedAD = this.d.isServerBidding() ? new NativeUnifiedAD(context, this.d.getAdnId(), this.g, this.d.getAdm()) : new NativeUnifiedAD(context, this.d.getAdnId(), this.g);
        int gdtMaxVideoDuration = this.f1677a.getGdtMaxVideoDuration();
        int gdtMinVideoDuration = this.f1677a.getGdtMinVideoDuration();
        if (gdtMinVideoDuration > 0) {
            nativeUnifiedAD.setMinVideoDuration(gdtMinVideoDuration);
        }
        if (gdtMaxVideoDuration > 0) {
            nativeUnifiedAD.setMaxVideoDuration(gdtMaxVideoDuration);
        }
        Object gdtNativeLogoParams = this.f1677a.getGdtNativeLogoParams();
        if (gdtNativeLogoParams instanceof FrameLayout.LayoutParams) {
            this.c = (FrameLayout.LayoutParams) gdtNativeLogoParams;
        }
        nativeUnifiedAD.loadData(1);
    }

    public void a(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context == null || mediationAdSlotValueSet == null) {
            this.d.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "context is null or adSlotValueSet is null");
            return;
        }
        com.jbB1g.jbB1g.jbB1g.jbB1g.a.a((Map) mediationAdSlotValueSet.getExtraObject());
        this.f1677a = mediationAdSlotValueSet;
        this.b = this.d.getGMBridge();
        boolean zA = com.jbB1g.jbB1g.jbB1g.jbB1g.a.a(this.d, mediationAdSlotValueSet);
        this.e = zA;
        if (zA) {
            n.a(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.a(mediationAdSlotValueSet, context);
                    n.a(getClass().getName(), context);
                }
            });
        } else {
            a(mediationAdSlotValueSet, context);
        }
    }
}
