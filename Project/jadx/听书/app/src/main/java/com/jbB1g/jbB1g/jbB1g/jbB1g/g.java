package com.jbB1g.jbB1g.jbB1g.jbB1g;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.msdk.adapter.gdt.GdtDrawLoader;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<NativeExpressADView, b> f1705a = new HashMap();
    private final GdtDrawLoader b;
    private boolean c;
    private final NativeExpressAD.NativeExpressADListener d = new NativeExpressAD.NativeExpressADListener() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.g.3
        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            b bVar;
            if (g.f1705a == null || (bVar = (b) g.f1705a.get(nativeExpressADView)) == null) {
                return;
            }
            bVar.notifyOnClickAd();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            if (g.f1705a != null) {
                b bVar = (b) g.f1705a.get(nativeExpressADView);
                if (bVar != null) {
                    bVar.a();
                }
                g.f1705a.remove(nativeExpressADView);
            }
            if (nativeExpressADView != null) {
                nativeExpressADView.destroy();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            b bVar;
            if (g.f1705a == null || (bVar = (b) g.f1705a.get(nativeExpressADView)) == null) {
                return;
            }
            bVar.notifyOnShowAd();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            if (list == null || list.size() == 0) {
                g.this.b.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "list is empty");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (NativeExpressADView nativeExpressADView : list) {
                if (nativeExpressADView != null && nativeExpressADView.getBoundData() != null) {
                    Function<SparseArray<Object>, Object> gMBridge = g.this.b.getGMBridge();
                    Map map = g.f1705a;
                    g gVar = g.this;
                    map.put(nativeExpressADView, new b(gVar, gVar.b, gMBridge, nativeExpressADView, g.this.c));
                    arrayList.add(gMBridge);
                }
            }
            g.this.b.notifyAdSuccess(arrayList);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            if (adError != null) {
                g.this.b.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                g.this.b.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "adError is null");
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            b bVar;
            if (g.f1705a == null || (bVar = (b) g.f1705a.get(nativeExpressADView)) == null) {
                return;
            }
            bVar.notifyRenderFail(nativeExpressADView, MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL, "渲染失败");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            b bVar;
            if (g.f1705a == null || (bVar = (b) g.f1705a.get(nativeExpressADView)) == null) {
                return;
            }
            bVar.notifyRenderSuccess(-1.0f, -2.0f);
        }
    };

    public g(GdtDrawLoader gdtDrawLoader) {
        this.b = gdtDrawLoader;
    }

    private ADSize a(MediationAdSlotValueSet mediationAdSlotValueSet) {
        return mediationAdSlotValueSet.getExpressWidth() > 0.0f ? new ADSize((int) mediationAdSlotValueSet.getExpressWidth(), -2) : new ADSize(-1, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean zIsExpress = mediationAdSlotValueSet.isExpress();
        Context applicationContext = context.getApplicationContext();
        if (zIsExpress) {
            d(applicationContext, mediationAdSlotValueSet);
        } else {
            c(applicationContext, mediationAdSlotValueSet);
        }
    }

    private void c(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(context, mediationAdSlotValueSet.getADNId(), new NativeADUnifiedListener() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.g.2
            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> list) {
                if (list == null || list.size() <= 0) {
                    g.this.b.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "请求成功，但无广告可用");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (NativeUnifiedADData nativeUnifiedADData : list) {
                    Function<SparseArray<Object>, Object> gMBridge = g.this.b.getGMBridge();
                    VideoOption videoOptionBuild = new VideoOption.Builder().build();
                    if (mediationAdSlotValueSet.getGdtVideoOption() instanceof VideoOption) {
                        videoOptionBuild = (VideoOption) mediationAdSlotValueSet.getGdtVideoOption();
                    }
                    new c(context, nativeUnifiedADData, g.this.b, gMBridge, videoOptionBuild, g.this.c);
                    arrayList.add(gMBridge);
                }
                g.this.b.notifyAdSuccess(arrayList);
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                if (adError != null) {
                    g.this.b.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
                } else {
                    g.this.b.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "error is null");
                }
            }
        });
        int gdtMaxVideoDuration = mediationAdSlotValueSet.getGdtMaxVideoDuration();
        int gdtMinVideoDuration = mediationAdSlotValueSet.getGdtMinVideoDuration();
        if (gdtMinVideoDuration > 0) {
            nativeUnifiedAD.setMinVideoDuration(gdtMinVideoDuration);
        }
        if (gdtMaxVideoDuration > 0) {
            nativeUnifiedAD.setMaxVideoDuration(gdtMaxVideoDuration);
        }
        nativeUnifiedAD.loadData(mediationAdSlotValueSet.getAdCount());
    }

    private void d(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        NativeExpressAD nativeExpressAD = this.b.isServerBidding() ? new NativeExpressAD(context, a(mediationAdSlotValueSet), mediationAdSlotValueSet.getADNId(), this.d, this.b.getAdm()) : new NativeExpressAD(context, a(mediationAdSlotValueSet), mediationAdSlotValueSet.getADNId(), this.d);
        int gdtMaxVideoDuration = mediationAdSlotValueSet.getGdtMaxVideoDuration();
        int gdtMinVideoDuration = mediationAdSlotValueSet.getGdtMinVideoDuration();
        if (gdtMinVideoDuration > 0) {
            nativeExpressAD.setMinVideoDuration(gdtMinVideoDuration);
        }
        if (gdtMaxVideoDuration > 0) {
            nativeExpressAD.setMaxVideoDuration(gdtMaxVideoDuration);
        }
        nativeExpressAD.setVideoOption(mediationAdSlotValueSet.getGdtVideoOption() instanceof VideoOption ? (VideoOption) mediationAdSlotValueSet.getGdtVideoOption() : new VideoOption.Builder().build());
        nativeExpressAD.loadAD(mediationAdSlotValueSet.getAdCount());
    }

    public Map<NativeExpressADView, b> a() {
        return f1705a;
    }

    public void a(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        a.a((Map) mediationAdSlotValueSet.getExtraObject());
        boolean zA = a.a(this.b, mediationAdSlotValueSet);
        this.c = zA;
        if (zA) {
            n.a(new Runnable() { // from class: com.jbB1g.jbB1g.jbB1g.jbB1g.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.b(context.getApplicationContext(), mediationAdSlotValueSet);
                    n.a(getClass().getName(), context.getApplicationContext());
                }
            });
        } else {
            b(context.getApplicationContext(), mediationAdSlotValueSet);
        }
    }
}
