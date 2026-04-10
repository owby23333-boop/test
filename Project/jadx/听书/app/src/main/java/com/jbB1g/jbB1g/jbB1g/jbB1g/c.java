package com.jbB1g.jbB1g.jbB1g.jbB1g;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.gdt.R;
import com.bytedance.msdk.adapter.gdt.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.ad.MediationNativeAd;
import com.bytedance.msdk.adapter.gdt.base.config.MediationViewBinder;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public class c extends MediationNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeUnifiedADData f1640a;
    private volatile boolean b;
    private VideoOption c;
    private boolean d;
    private Context e;
    private MediaView f;
    private NativeADMediaListener g;

    public c(Context context, NativeUnifiedADData nativeUnifiedADData, MediationAdLoaderBaseFunction mediationAdLoaderBaseFunction, Function function, VideoOption videoOption, boolean z) {
        super(mediationAdLoaderBaseFunction, function);
        this.b = false;
        this.g = new NativeADMediaListener() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.c.9
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoClicked() {
                c.this.notifyOnClickAd();
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoCompleted() {
                c.this.notifyOnVideoComplete();
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoError(AdError adError) {
                if (adError != null) {
                    c.this.notifyOnVideoError(adError.getErrorCode(), adError.getErrorMsg());
                } else {
                    c.this.notifyOnVideoError(MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "error is null");
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i) {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoPause() {
                c.this.notifyOnVideoPause();
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoResume() {
                c.this.notifyOnVideoResume();
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoStart() {
                c.this.notifyOnVideoStart();
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
            }
        };
        this.e = context;
        this.f1640a = nativeUnifiedADData;
        this.c = videoOption;
        this.d = z;
        d();
    }

    private void a(Context context, ViewGroup viewGroup, MediationViewBinder mediationViewBinder) {
        if (viewGroup == null || mediationViewBinder == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(mediationViewBinder.mediaViewId);
        if (frameLayout != null && getImageMode() == 5) {
            MediaView mediaViewF = f();
            frameLayout.removeAllViews();
            frameLayout.addView(mediaViewF, -1, -1);
        }
        if (TextUtils.isEmpty(this.f1640a.getCTAText())) {
            return;
        }
        View viewFindViewById = viewGroup.findViewById(mediationViewBinder.callToActionId);
        ArrayList arrayList = new ArrayList();
        arrayList.add(viewFindViewById);
        this.f1640a.bindCTAViews(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
        NativeAdContainer nativeAdContainer;
        Object tag;
        NativeUnifiedADData nativeUnifiedADData;
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
        List<View> list4 = list2;
        if (isServerBidding() && (nativeUnifiedADData = this.f1640a) != null) {
            nativeUnifiedADData.setBidECPM(nativeUnifiedADData.getECPM());
        }
        if (this.f1640a != null) {
            if (context == null) {
                context = viewGroup.getContext();
            }
            Context context2 = context;
            int i = 0;
            if (viewGroup.getChildCount() == 0 || !(viewGroup.getChildAt(0) instanceof NativeAdContainer)) {
                nativeAdContainer = new NativeAdContainer(context2);
                nativeAdContainer.setTag(R.id.tt_mediation_gdt_developer_view_root_tag_key, MediationConstant.TT_GDT_NATIVE_ROOT_VIEW_TAG);
                while (viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    childAt.setTag(R.id.tt_mediation_gdt_developer_view_tag_key, MediationConstant.TT_GDT_NATIVE_VIEW_TAG);
                    viewGroup.removeViewInLayout(childAt);
                    if (childAt != null) {
                        nativeAdContainer.addView(childAt, childAt.getLayoutParams());
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
            if (mediationViewBinder != null) {
                a(context2, viewGroup, mediationViewBinder);
            } else {
                a(list4);
            }
            this.f1640a.bindAdToView(context2, nativeAdContainer2, null, list, list4);
            this.f1640a.setNativeAdEventListener(new NativeADEventListener() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.c.8
                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADClicked() {
                    c.this.notifyOnClickAd();
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADError(AdError adError) {
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADExposed() {
                    c.this.notifyOnShowAd();
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADStatusChanged() {
                }
            });
        }
    }

    private void a(Object obj) {
        final int iA = a.a(obj);
        if (iA == -1) {
            return;
        }
        if (this.d) {
            n.a(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.c.6
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f1640a.sendLossNotification(0, iA, null);
                }
            });
        } else {
            this.f1640a.sendLossNotification(0, iA, null);
        }
    }

    private void a(List<View> list) {
        NativeUnifiedADData nativeUnifiedADData;
        if (list == null || (nativeUnifiedADData = this.f1640a) == null || TextUtils.isEmpty(nativeUnifiedADData.getCTAText())) {
            return;
        }
        this.f1640a.bindCTAViews(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jbB1g.jbB1g.jbB1g.jbB1g.c.d():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoOption e() {
        VideoOption videoOption = this.c;
        return videoOption == null ? new VideoOption.Builder().build() : videoOption;
    }

    private MediaView f() {
        if (this.e == null) {
            return null;
        }
        if (this.f == null) {
            MediaView mediaView = new MediaView(this.e);
            this.f = mediaView;
            mediaView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            if (this.f.getViewTreeObserver() != null) {
                this.f.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.c.7
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (c.this.f.getVisibility() == 0) {
                            if (c.this.f1640a != null) {
                                c.this.f1640a.bindMediaView(c.this.f, c.this.e(), c.this.g);
                            }
                            if (c.this.f.getViewTreeObserver() != null) {
                                c.this.f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                        }
                    }
                });
            }
        }
        MediaView mediaView2 = this.f;
        if (mediaView2 != null && mediaView2.getParent() != null) {
            ((ViewGroup) this.f.getParent()).removeView(this.f);
        }
        return this.f;
    }

    private String g() {
        return this.d ? h() : i();
    }

    private String h() {
        try {
            return (String) n.a(new Callable<String>() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.c.10
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return c.this.i();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i() {
        Object obj;
        try {
            NativeUnifiedADData nativeUnifiedADData = this.f1640a;
            if (nativeUnifiedADData == null || (obj = nativeUnifiedADData.getExtraInfo().get("request_id")) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public Integer a() {
        return this.d ? c() : b();
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        Runnable runnable;
        if (i == 8148) {
            if (this.d) {
                runnable = new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.f1640a != null) {
                            c.this.f1640a.resume();
                        }
                    }
                };
                n.b(runnable);
            } else {
                NativeUnifiedADData nativeUnifiedADData = this.f1640a;
                if (nativeUnifiedADData != null) {
                    nativeUnifiedADData.resume();
                }
            }
        } else if (i == 8149) {
            if (this.d) {
                runnable = new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.c.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.f1640a != null) {
                            c.this.f1640a.pauseVideo();
                        }
                    }
                };
                n.b(runnable);
            } else {
                NativeUnifiedADData nativeUnifiedADData2 = this.f1640a;
                if (nativeUnifiedADData2 != null) {
                    nativeUnifiedADData2.pauseVideo();
                }
            }
        } else if (i == 8109) {
            this.b = true;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.c.13
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.f1640a != null) {
                        c.this.f1640a.destroy();
                    }
                }
            });
        } else {
            if (i == 8120) {
                return (T) Boolean.valueOf(this.b);
            }
            if (i == 8191) {
                if (this.d) {
                    runnable = new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.c.14
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.f1640a != null) {
                                c.this.f1640a.pauseAppDownload();
                            }
                        }
                    };
                    n.b(runnable);
                } else {
                    NativeUnifiedADData nativeUnifiedADData3 = this.f1640a;
                    if (nativeUnifiedADData3 != null) {
                        nativeUnifiedADData3.pauseAppDownload();
                    }
                }
            } else if (i == 8192) {
                if (this.d) {
                    runnable = new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.c.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.f1640a != null) {
                                c.this.f1640a.resumeAppDownload();
                            }
                        }
                    };
                    n.b(runnable);
                } else {
                    NativeUnifiedADData nativeUnifiedADData4 = this.f1640a;
                    if (nativeUnifiedADData4 != null) {
                        nativeUnifiedADData4.resumeAppDownload();
                    }
                }
            } else {
                if (i == 8121) {
                    return (T) isReadyStatusForProto2(a(), sparseArray, cls);
                }
                try {
                    if (i == 8142) {
                        NativeUnifiedADData nativeUnifiedADData5 = this.f1640a;
                        if (nativeUnifiedADData5 != null) {
                            if (this.d) {
                                n.a(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.c.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        c.this.f1640a.sendWinNotification((int) c.this.getCpm());
                                    }
                                });
                            } else {
                                nativeUnifiedADData5.sendWinNotification((int) getCpm());
                            }
                        }
                    } else if (i == 8144) {
                        Map map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        if (map != null && this.f1640a != null) {
                            a(map.get(MediationConstant.BIDDING_LOSE_REASON));
                        }
                    } else if (i == 8194) {
                        if (this.d) {
                            runnable = new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.c.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (c.this.f1640a != null) {
                                        c.this.f1640a.negativeFeedback();
                                    }
                                }
                            };
                            n.b(runnable);
                        } else {
                            NativeUnifiedADData nativeUnifiedADData6 = this.f1640a;
                            if (nativeUnifiedADData6 != null) {
                                nativeUnifiedADData6.negativeFeedback();
                            }
                        }
                    } else if (i == 8159) {
                        final Activity activity = (Activity) MediationValueUtil.objectValue(sparseArray.get(20033), Activity.class, null);
                        final ViewGroup viewGroup = (ViewGroup) MediationValueUtil.objectValue(sparseArray.get(8067), ViewGroup.class, null);
                        final List<View> list = (List) MediationValueUtil.objectValue(sparseArray.get(8068), List.class, null);
                        final List<View> list2 = (List) MediationValueUtil.objectValue(sparseArray.get(8069), List.class, null);
                        final List<View> list3 = (List) MediationValueUtil.objectValue(sparseArray.get(8070), List.class, null);
                        final Object objObjectValue = MediationValueUtil.objectValue(sparseArray.get(8071), Object.class, null);
                        if (this.d) {
                            n.b(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.c.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.a(activity, viewGroup, list, list2, list3, a.a(AdnAdapterBridgeWrapper.covertToFunction(objObjectValue)));
                                }
                            });
                        } else {
                            a(activity, viewGroup, list, list2, list3, a.a(AdnAdapterBridgeWrapper.covertToFunction(objObjectValue)));
                        }
                    } else {
                        if (i == 8147) {
                            return (T) g();
                        }
                        if (i == 8267) {
                            Context context = this.e;
                            if (context != null) {
                                return (T) BitmapFactory.decodeResource(context.getResources(), R.drawable.tt_gdt_logo);
                            }
                        } else if (i == 6164) {
                            if (this.e != null) {
                                return (T) f();
                            }
                            return null;
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public Integer b() {
        NativeUnifiedADData nativeUnifiedADData = this.f1640a;
        return Integer.valueOf((nativeUnifiedADData == null || !nativeUnifiedADData.isValid()) ? 4 : 2);
    }

    public Integer c() {
        try {
            Integer num = (Integer) n.a(new Callable<Integer>() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.c.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Integer call() {
                    return c.this.b();
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

    @Override // com.bytedance.msdk.adapter.gdt.base.ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }
}
