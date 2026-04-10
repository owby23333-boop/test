package com.amgcyo.cuttadon.h.g;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.other.RewardAdParam;
import com.amgcyo.cuttadon.api.entity.other.SdkErrorBean;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.UUID;

/* JADX INFO: compiled from: CsjRewardVideo.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends com.amgcyo.cuttadon.h.b.b {

    /* JADX INFO: compiled from: CsjRewardVideo.java */
    class a implements TTAdNative.RewardVideoAdListener {
        final /* synthetic */ RewardAdParam a;
        final /* synthetic */ Context b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.amgcyo.cuttadon.h.f.c f3966c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3967d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3968e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f3969f;

        /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.g.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CsjRewardVideo.java */
        class C0100a implements TTRewardVideoAd.RewardAdInteractionListener {
            C0100a() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdClose() {
                a aVar = a.this;
                com.amgcyo.cuttadon.h.f.c cVar = aVar.f3966c;
                if (cVar != null) {
                    cVar.onRewardAdClose(aVar.f3967d);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdShow() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdVideoBarClick() {
                com.amgcyo.cuttadon.h.a.e.a();
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onRewardArrived(boolean z2, int i2, Bundle bundle) {
                String str = "csj onRewardArrived: " + z2 + " rewardType: " + i2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify(boolean z2, int i2, String str, int i3, String str2) {
                if (z2) {
                    a aVar = a.this;
                    d.this.a(aVar.f3966c, aVar.f3967d, aVar.b);
                } else {
                    a.this.a.setErrorMsg(str2);
                    a.this.a.setErrorCode(i3);
                    a aVar2 = a.this;
                    d.this.c(aVar2.b, aVar2.f3966c, aVar2.a);
                }
                a aVar3 = a.this;
                d.this.a(aVar3.b);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onSkippedVideo() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onVideoComplete() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onVideoError() {
            }
        }

        /* JADX INFO: compiled from: CsjRewardVideo.java */
        class b implements TTAppDownloadListener {
            b(a aVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j2, long j3, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j2, long j3, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j2, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j2, long j3, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
            }
        }

        a(RewardAdParam rewardAdParam, Context context, com.amgcyo.cuttadon.h.f.c cVar, String str, String str2, int i2) {
            this.a = rewardAdParam;
            this.b = context;
            this.f3966c = cVar;
            this.f3967d = str;
            this.f3968e = str2;
            this.f3969f = i2;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            String str2 = "错误码：" + i2 + "详情：" + str;
            this.a.setErrorMsg(str);
            this.a.setErrorCode(i2);
            d.this.c(this.b, this.f3966c, this.a);
            if (i2 == 1000) {
                com.amgcyo.cuttadon.utils.otherutils.g.a(i2, this.b, d.this.a());
            } else {
                d.this.a(this.b, new SdkErrorBean(i2, str, this.f3967d, this.f3968e));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            tTRewardVideoAd.setRewardAdInteractionListener(new C0100a());
            tTRewardVideoAd.setDownloadListener(new b(this));
            d.this.a(this.b);
            if (d.this.a(this.f3969f)) {
                return;
            }
            tTRewardVideoAd.showRewardVideoAd((Activity) this.b);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            d.this.a(this.b);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
            com.amgcyo.cuttadon.h.f.c cVar;
            d.this.a(this.b);
            if (!d.this.a(this.f3969f) || (cVar = this.f3966c) == null) {
                return;
            }
            cVar.onRewardAdVideoCached(tTRewardVideoAd);
        }
    }

    /* JADX INFO: compiled from: CsjRewardVideo.java */
    private static class b {
        private static final d a = new d(null);
    }

    /* synthetic */ d(a aVar) {
        this();
    }

    private d() {
    }

    public static d c() {
        return b.a;
    }

    public void a(Context context, @NonNull RewardAdParam rewardAdParam, com.amgcyo.cuttadon.h.f.c cVar) {
        if (b(context, cVar, rewardAdParam)) {
            return;
        }
        TTAdNative tTAdNativeC = c(context);
        if (tTAdNativeC == null) {
            rewardAdParam.setErrorMsg("数据参数异常！");
            rewardAdParam.setErrorCode(80013);
            c(context, cVar, rewardAdParam);
            return;
        }
        if (a(context, cVar, rewardAdParam)) {
            return;
        }
        String codeId = rewardAdParam.getCodeId();
        String adPosition = rewardAdParam.getAdPosition();
        int loadType = rewardAdParam.getLoadType();
        TTAdLoadType tTAdLoadType = TTAdLoadType.PRELOAD;
        if (!a(loadType)) {
            b(context);
            tTAdLoadType = TTAdLoadType.LOAD;
        }
        String str = "form：" + rewardAdParam.getForm() + " 激励视频id：" + codeId;
        String string = UUID.randomUUID().toString();
        String str2 = "获取随机用户id：" + string;
        tTAdNativeC.loadRewardVideoAd(new AdSlot.Builder().setCodeId(codeId).setSupportDeepLink(true).setExpressViewAcceptedSize(500.0f, 500.0f).setImageAcceptedSize(DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED, 1920).setUserID(string).setMediaExtra("media_extra").setAdLoadType(tTAdLoadType).setOrientation(1).build(), new a(rewardAdParam, context, cVar, adPosition, codeId, loadType));
    }
}
