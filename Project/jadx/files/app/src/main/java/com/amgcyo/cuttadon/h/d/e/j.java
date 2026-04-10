package com.amgcyo.cuttadon.h.d.e;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.other.RewardAdParam;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardAd;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdOptionUtil;
import com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: compiled from: AdRewardManager.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends com.amgcyo.cuttadon.h.a.f {
    private Activity a;

    /* JADX INFO: compiled from: AdRewardManager.java */
    class a implements GMRewardedAdLoadCallback {
        final /* synthetic */ RewardAdParam a;
        final /* synthetic */ com.amgcyo.cuttadon.h.f.c b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f3915c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ GMRewardAd f3916d;

        a(RewardAdParam rewardAdParam, com.amgcyo.cuttadon.h.f.c cVar, boolean z2, GMRewardAd gMRewardAd) {
            this.a = rewardAdParam;
            this.b = cVar;
            this.f3915c = z2;
            this.f3916d = gMRewardAd;
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdLoadCallback
        public void onRewardVideoAdLoad() {
            if (!this.f3915c) {
                this.f3916d.showRewardAd(j.this.a);
            }
            j jVar = j.this;
            jVar.a(jVar.a);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdLoadCallback
        public void onRewardVideoCached() {
            if (this.f3915c) {
                this.b.onRewardAdVideoCached(this.f3916d);
            }
            j jVar = j.this;
            jVar.a(jVar.a);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdLoadCallback
        public void onRewardVideoLoadFail(@NonNull AdError adError) {
            this.a.setErrorMsg(adError.message);
            this.a.setErrorCode(adError.code);
            j jVar = j.this;
            jVar.c(jVar.a, this.b, this.a);
        }
    }

    /* JADX INFO: compiled from: AdRewardManager.java */
    class b implements GMRewardedAdListener {
        final /* synthetic */ String a;
        final /* synthetic */ RewardAdParam b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.amgcyo.cuttadon.h.f.c f3918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3919d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ GMRewardAd f3920e;

        b(String str, RewardAdParam rewardAdParam, com.amgcyo.cuttadon.h.f.c cVar, String str2, GMRewardAd gMRewardAd) {
            this.a = str;
            this.b = rewardAdParam;
            this.f3918c = cVar;
            this.f3919d = str2;
            this.f3920e = gMRewardAd;
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardClick() {
            com.amgcyo.cuttadon.h.a.e.a();
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardVerify(@NonNull RewardItem rewardItem) {
            boolean zRewardVerify = rewardItem.rewardVerify();
            String str = this.a + "  onRewardVerify";
            if (zRewardVerify) {
                j jVar = j.this;
                jVar.a(this.f3918c, this.f3919d, jVar.a);
            } else {
                this.b.setErrorCode(80018);
                this.b.setErrorMsg("数据验证失败，请重试！");
                j jVar2 = j.this;
                jVar2.c(jVar2.a, this.f3918c, this.b);
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardedAdClosed() {
            this.f3918c.onRewardAdClose(this.f3919d);
            this.f3920e.destroy();
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardedAdShow() {
            String str = this.a + "onRewardedAdShow";
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardedAdShowFail(@NonNull AdError adError) {
            String str = this.a + "onRewardedAdShowFail";
            this.b.setErrorMsg(adError.message);
            this.b.setErrorCode(adError.code);
            j jVar = j.this;
            jVar.c(jVar.a, this.f3918c, this.b);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onSkippedVideo() {
            String str = this.a + "  onSkippedVideo";
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onVideoComplete() {
            j jVar = j.this;
            jVar.a(this.f3918c, this.f3919d, jVar.a);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onVideoError() {
            String str = this.a + "视频播放错误";
        }
    }

    public j(Activity activity) {
        this.a = activity;
    }

    @Override // com.amgcyo.cuttadon.h.a.f
    public String a() {
        return "gm";
    }

    public void a(RewardAdParam rewardAdParam, com.amgcyo.cuttadon.h.f.c cVar) {
        if (b(this.a, cVar, rewardAdParam)) {
            return;
        }
        String strA = a();
        int loadType = rewardAdParam.getLoadType();
        String strJ = com.amgcyo.cuttadon.sdk.utils.d.j("j");
        if (a(loadType)) {
            strJ = com.amgcyo.cuttadon.sdk.utils.d.j("k");
        }
        rewardAdParam.setCodeId(strJ);
        String str = "rewardCodeId:" + strJ;
        if (a(this.a, cVar, rewardAdParam)) {
            return;
        }
        String codeId = rewardAdParam.getCodeId();
        String adPosition = rewardAdParam.getAdPosition();
        boolean zA = a(loadType);
        if (!a(loadType)) {
            b(this.a);
        }
        GMRewardAd gMRewardAd = new GMRewardAd(this.a, codeId);
        HashMap map = new HashMap();
        map.put("pangle", "pangle media_extra");
        map.put("gdt", "gdt custom data");
        map.put("ks", "ks custom data");
        map.put("sigmob", "sigmob custom data");
        map.put("mintegral", "mintegral custom data");
        map.put("baidu", "baidu custom data");
        map.put("gromoreExtra", "gromore serverside verify extra data");
        String string = UUID.randomUUID().toString();
        String str2 = "获取随机用户id：" + string;
        gMRewardAd.loadAd(new GMAdSlotRewardVideo.Builder().setMuted(true).setVolume(0.0f).setGMAdSlotGDTOption(GMAdOptionUtil.getGMAdSlotGDTOption().build()).setGMAdSlotBaiduOption(GMAdOptionUtil.getGMAdSlotBaiduOption().build()).setCustomData(map).setRewardName("金币").setRewardAmount(3).setUserID(string).setUseSurfaceView(false).setOrientation(rewardAdParam.getOrientation()).setBidNotify(true).build(), new a(rewardAdParam, cVar, zA, gMRewardAd));
        gMRewardAd.setRewardAdListener(new b(strA, rewardAdParam, cVar, adPosition, gMRewardAd));
    }
}
