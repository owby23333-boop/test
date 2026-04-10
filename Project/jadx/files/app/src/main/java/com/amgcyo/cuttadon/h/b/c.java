package com.amgcyo.cuttadon.h.b;

import android.app.Activity;
import android.content.Context;
import com.amgcyo.cuttadon.api.entity.other.RewardAdParam;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* JADX INFO: compiled from: CsjNewInterExpressAd.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends com.amgcyo.cuttadon.h.b.b {
    private static final String a = "com.amgcyo.cuttadon.h.b.c";

    /* JADX INFO: compiled from: CsjNewInterExpressAd.java */
    class a implements TTAdNative.FullScreenVideoAdListener {
        final /* synthetic */ RewardAdParam a;
        final /* synthetic */ Context b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.amgcyo.cuttadon.h.f.c f3869c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3870d;

        /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.b.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CsjNewInterExpressAd.java */
        class C0092a implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
            C0092a() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdClose() {
                String unused = c.a;
                a aVar = a.this;
                c.this.b(aVar.f3869c, aVar.f3870d, aVar.b);
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdShow() {
                String unused = c.a;
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdVideoBarClick() {
                String unused = c.a;
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onSkippedVideo() {
                String unused = c.a;
                a aVar = a.this;
                if (aVar.f3869c == null || !c.this.b()) {
                    return;
                }
                c.this.a("恭喜您免广告成功，请返回继续阅读！");
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onVideoComplete() {
                String unused = c.a;
                a aVar = a.this;
                if (aVar.f3869c == null || !c.this.b()) {
                    return;
                }
                c.this.a("恭喜您免广告成功，请返回继续阅读！");
            }
        }

        /* JADX INFO: compiled from: CsjNewInterExpressAd.java */
        class b implements TTAppDownloadListener {
            b(a aVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j2, long j3, String str, String str2) {
                String str3 = "onDownloadActive==totalBytes=" + j2 + ",currBytes=" + j3 + ",fileName=" + str + ",appName=" + str2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j2, long j3, String str, String str2) {
                String str3 = "onDownloadFailed==totalBytes=" + j2 + ",currBytes=" + j3 + ",fileName=" + str + ",appName=" + str2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j2, String str, String str2) {
                String str3 = "onDownloadFinished==totalBytes=" + j2 + ",fileName=" + str + ",appName=" + str2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j2, long j3, String str, String str2) {
                String str3 = "onDownloadPaused===totalBytes=" + j2 + ",currBytes=" + j3 + ",fileName=" + str + ",appName=" + str2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                String str3 = "onInstalled==,fileName=" + str + ",appName=" + str2;
            }
        }

        a(RewardAdParam rewardAdParam, Context context, com.amgcyo.cuttadon.h.f.c cVar, String str) {
            this.a = rewardAdParam;
            this.b = context;
            this.f3869c = cVar;
            this.f3870d = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            String str2 = "csj CsjNewInterExpressAd 出现错误, code: " + i2 + str;
            System.out.println("new inter error code " + i2);
            this.a.setErrorMsg(str);
            this.a.setErrorCode(i2);
            c.this.c(this.b, this.f3869c, this.a);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            String unused = c.a;
            String str = "Callback --> onFullScreenVideoAdLoad:" + tTFullScreenVideoAd.getInteractionType();
            if (this.f3869c != null) {
                c.this.a(this.b);
            }
            tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new C0092a());
            tTFullScreenVideoAd.setDownloadListener(new b(this));
            tTFullScreenVideoAd.showFullScreenVideoAd((Activity) this.b);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
        }
    }

    /* JADX INFO: compiled from: CsjNewInterExpressAd.java */
    private static class b {
        private static final c a = new c(null);
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    public static c d() {
        return b.a;
    }

    private c() {
    }

    public void a(Context context, String str, String str2, com.amgcyo.cuttadon.h.f.c cVar) {
        RewardAdParam rewardAdParam = new RewardAdParam(str2, str);
        if (b(context, cVar, rewardAdParam)) {
            return;
        }
        TTAdNative tTAdNativeC = c(context);
        if (tTAdNativeC == null) {
            rewardAdParam.setErrorMsg("数据参数异常！");
            rewardAdParam.setErrorCode(80013);
            c(context, cVar, rewardAdParam);
        } else {
            if (cVar != null) {
                b(context);
            }
            double d2 = n.d(MkApplication.getAppContext());
            Double.isNaN(d2);
            tTAdNativeC.loadFullScreenVideoAd(a(str, (int) (d2 / 1.3d), 0), new a(rewardAdParam, context, cVar, str2));
        }
    }
}
