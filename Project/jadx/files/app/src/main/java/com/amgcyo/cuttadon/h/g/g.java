package com.amgcyo.cuttadon.h.g;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.other.RewardAdParam;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import java.util.List;

/* JADX INFO: compiled from: KsRewardVideo.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends com.amgcyo.cuttadon.h.e.a {

    /* JADX INFO: compiled from: KsRewardVideo.java */
    class a implements KsLoadManager.RewardVideoAdListener {
        final /* synthetic */ RewardAdParam a;
        final /* synthetic */ Context b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.amgcyo.cuttadon.h.f.c f3975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3976d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f3977e;

        /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.g.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KsRewardVideo.java */
        class C0101a implements KsRewardVideoAd.RewardAdInteractionListener {
            C0101a() {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onAdClicked() {
                com.amgcyo.cuttadon.h.a.e.a();
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onExtraRewardVerify(int i2) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onPageDismiss() {
                a aVar = a.this;
                com.amgcyo.cuttadon.h.f.c cVar = aVar.f3975c;
                if (cVar != null) {
                    cVar.onRewardAdClose(aVar.f3976d);
                }
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardStepVerify(int i2, int i3) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify() {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayEnd() {
                a aVar = a.this;
                g.this.a(aVar.f3975c, aVar.f3976d, aVar.b);
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayError(int i2, int i3) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayStart() {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoSkipToEnd(long j2) {
            }
        }

        a(RewardAdParam rewardAdParam, Context context, com.amgcyo.cuttadon.h.f.c cVar, String str, int i2) {
            this.a = rewardAdParam;
            this.b = context;
            this.f3975c = cVar;
            this.f3976d = str;
            this.f3977e = i2;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onError(int i2, String str) {
            this.a.setErrorMsg(str);
            this.a.setErrorCode(i2);
            g.this.c(this.b, this.f3975c, this.a);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
            KsRewardVideoAd ksRewardVideoAd;
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(list) || (ksRewardVideoAd = list.get(0)) == null || !ksRewardVideoAd.isAdEnable()) {
                this.a.setErrorCode(80014);
                this.a.setErrorMsg("暂无数据返回，请稍后重试!");
                g.this.c(this.b, this.f3975c, this.a);
            } else {
                ksRewardVideoAd.setRewardAdInteractionListener(new C0101a());
                if (g.this.a(this.f3977e)) {
                    com.amgcyo.cuttadon.h.f.c cVar = this.f3975c;
                    if (cVar != null) {
                        cVar.onRewardAdVideoCached(ksRewardVideoAd);
                    }
                } else {
                    ksRewardVideoAd.showRewardVideoAd((Activity) this.b, null);
                }
            }
            g.this.a(this.b);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                return;
            }
            String str = "ks 返回结果数:" + list.size();
        }
    }

    /* JADX INFO: compiled from: KsRewardVideo.java */
    private static class b {
        private static final g a = new g(null);
    }

    /* synthetic */ g(a aVar) {
        this();
    }

    private g() {
    }

    public static g c() {
        return b.a;
    }

    public void a(Context context, @NonNull RewardAdParam rewardAdParam, com.amgcyo.cuttadon.h.f.c cVar) {
        String adPosition = rewardAdParam.getAdPosition();
        if (b(context, cVar, rewardAdParam)) {
            return;
        }
        String codeId = rewardAdParam.getCodeId();
        if (a(context, cVar, rewardAdParam)) {
            return;
        }
        KsScene ksSceneBuild = new KsScene.Builder(Long.valueOf(codeId).longValue()).screenOrientation(1).build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager != null && ksSceneBuild != null) {
            int loadType = rewardAdParam.getLoadType();
            if (!a(loadType)) {
                b(context);
            }
            loadManager.loadRewardVideoAd(ksSceneBuild, new a(rewardAdParam, context, cVar, adPosition, loadType));
            return;
        }
        rewardAdParam.setErrorMsg("数据参数异常！");
        rewardAdParam.setErrorCode(80012);
        c(context, cVar, rewardAdParam);
    }
}
