package com.amgcyo.cuttadon.h.g;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.other.RewardAdParam;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.f.o;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.anythink.rewardvideo.api.ATRewardVideoAd;
import com.anythink.rewardvideo.api.ATRewardVideoListener;
import com.sntech.ads.api.event.SNEvent;

/* JADX INFO: compiled from: ToponRewardVideo.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends com.amgcyo.cuttadon.h.i.f {

    /* JADX INFO: compiled from: ToponRewardVideo.java */
    class a implements ATRewardVideoListener {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ATRewardVideoAd[] f3981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f3982d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f3983e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.amgcyo.cuttadon.h.f.c f3984f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ RewardAdParam f3985g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f3986h;

        a(Context context, String str, ATRewardVideoAd[] aTRewardVideoAdArr, boolean z2, boolean z3, com.amgcyo.cuttadon.h.f.c cVar, RewardAdParam rewardAdParam, String str2) {
            this.a = context;
            this.b = str;
            this.f3981c = aTRewardVideoAdArr;
            this.f3982d = z2;
            this.f3983e = z3;
            this.f3984f = cVar;
            this.f3985g = rewardAdParam;
            this.f3986h = str2;
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onReward(ATAdInfo aTAdInfo) {
            j.this.a(this.f3984f, this.f3986h, this.a);
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdClosed(ATAdInfo aTAdInfo) {
            String str = "onRewardedVideoAdClosed:" + aTAdInfo.toString();
            j.this.a(this.a);
            ATRewardVideoAd[] aTRewardVideoAdArr = this.f3981c;
            if (aTRewardVideoAdArr[0] != null) {
                aTRewardVideoAdArr[0] = null;
            }
            com.amgcyo.cuttadon.h.f.c cVar = this.f3984f;
            if (cVar != null) {
                cVar.onRewardAdClose(this.f3986h);
            }
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdFailed(AdError adError) {
            j.this.a(this.a);
            if (adError != null) {
                String fullErrorInfo = adError.getFullErrorInfo();
                String str = "错误详情：" + fullErrorInfo;
                this.f3985g.setErrorMsg(fullErrorInfo);
                o.g("激励视频广告加载失败：" + adError.getFullErrorInfo());
            } else {
                this.f3985g.setErrorCode(0);
                this.f3985g.setErrorMsg("未知数据错误！");
            }
            j.this.c(this.a, this.f3984f, this.f3985g);
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdLoaded() {
            com.amgcyo.cuttadon.h.f.c cVar;
            j.this.a(this.a);
            String str = "onRewardedVideoAdLoaded，loadType" + this.b;
            ATRewardVideoAd[] aTRewardVideoAdArr = this.f3981c;
            if (aTRewardVideoAdArr[0] == null || !aTRewardVideoAdArr[0].isAdReady()) {
                return;
            }
            if (this.f3982d) {
                this.f3981c[0].show((Activity) this.a);
            } else {
                if (!this.f3983e || (cVar = this.f3984f) == null) {
                    return;
                }
                cVar.onRewardAdVideoCached(this.f3981c[0]);
            }
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdPlayClicked(ATAdInfo aTAdInfo) {
            String str = "onRewardedVideoAdPlayClicked:" + aTAdInfo.toString();
            com.amgcyo.cuttadon.h.j.a.c(aTAdInfo);
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdPlayEnd(ATAdInfo aTAdInfo) {
            String str = "onRewardedVideoAdPlayEnd：" + aTAdInfo.toString();
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdPlayFailed(AdError adError, ATAdInfo aTAdInfo) {
            String str = "onRewardedVideoAdPlayFailed:" + adError.getFullErrorInfo();
            o.g("激励视频播放遇到问题：" + adError.getFullErrorInfo());
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdPlayStart(ATAdInfo aTAdInfo) {
            String str = "onRewardedVideoAdPlayStart：" + aTAdInfo.toString();
            com.amgcyo.cuttadon.h.j.a.d(aTAdInfo);
            com.amgcyo.cuttadon.h.j.a.a(SNEvent.AdType.REWARD_VIDEO, aTAdInfo);
            if (this.f3983e) {
                return;
            }
            this.f3985g.setLoadType(1);
            j.this.a(this.a, this.f3985g, this.f3984f);
        }
    }

    /* JADX INFO: compiled from: ToponRewardVideo.java */
    private static class b {
        private static final j a = new j(null);
    }

    /* synthetic */ j(a aVar) {
        this();
    }

    private j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(Context context, @NonNull RewardAdParam rewardAdParam, com.amgcyo.cuttadon.h.f.c cVar, String str, String str2) {
        boolean z2 = rewardAdParam.getLoadType() == 0;
        String str3 = z2 ? "实时加载" : "预加载";
        String str4 = str2 + " --- " + str3 + "激励视频广告 bean对象类型：" + rewardAdParam.getLoadType();
        boolean z3 = "position_unlock_comic_reward_ad_video".equals(str2) || "position_unlock_novel_reward_ad_video".equals(str2);
        String str5 = "isUnloc:" + z3;
        boolean z4 = com.amgcyo.cuttadon.utils.otherutils.g.X() && z3;
        StringBuilder sb = new StringBuilder();
        sb.append(z4 ? "不需要" : "需要");
        sb.append("预加载激励视频");
        sb.toString();
        ATRewardVideoAd[] aTRewardVideoAdArr = {new ATRewardVideoAd(context, str)};
        aTRewardVideoAdArr[0].setAdListener(new a(context, str3, aTRewardVideoAdArr, z2, z4, cVar, rewardAdParam, str2));
        aTRewardVideoAdArr[0].setAdSourceStatusListener(new com.amgcyo.cuttadon.h.i.a(str3 + " 激励视频", "ToponRewardVideo"));
        aTRewardVideoAdArr[0].load();
    }

    public static j c() {
        return b.a;
    }

    public void a(final Context context, @NonNull final RewardAdParam rewardAdParam, final com.amgcyo.cuttadon.h.f.c cVar) {
        final String adPosition = rewardAdParam.getAdPosition();
        if (b(context, cVar, rewardAdParam)) {
            return;
        }
        rewardAdParam.setCodeId(com.amgcyo.cuttadon.utils.otherutils.h.a("topon_new", com.anythink.core.c.e.a));
        if (a(context, cVar, rewardAdParam)) {
            return;
        }
        final String codeId = rewardAdParam.getCodeId();
        if (!a(rewardAdParam.getLoadType())) {
            b(context);
        }
        String str = "激励视频id：" + codeId;
        MkApplication appContext = MkApplication.getAppContext();
        if (!appContext.isToponInit()) {
            String strP = com.amgcyo.cuttadon.sdk.utils.d.p("aid");
            String strP2 = com.amgcyo.cuttadon.sdk.utils.d.p("as");
            if (!TextUtils.isEmpty(strP) && !TextUtils.isEmpty(strP2)) {
                appContext.initToponSdk(strP, strP2);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.h.g.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f3960s.a(context, rewardAdParam, cVar, codeId, adPosition);
                    }
                }, com.anythink.expressad.exoplayer.i.a.f9492f);
                return;
            }
            a(context);
            String str2 = "错误详情：应用必要参数异常！";
            rewardAdParam.setErrorMsg("应用必要参数异常！");
            c(context, cVar, rewardAdParam);
            return;
        }
        a(context, rewardAdParam, cVar, codeId, adPosition);
    }
}
