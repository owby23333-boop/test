package com.amgcyo.cuttadon.h.g;

import android.content.Context;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.other.RewardAdParam;
import com.amgcyo.cuttadon.app.MkApplication;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* JADX INFO: compiled from: GDTRewardVideo.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends com.amgcyo.cuttadon.h.c.c {
    private RewardVideoAD a;

    /* JADX INFO: compiled from: GDTRewardVideo.java */
    class a implements RewardVideoADListener {
        final /* synthetic */ RewardAdParam a;
        final /* synthetic */ Context b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.amgcyo.cuttadon.h.f.c f3971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f3972d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3973e;

        a(RewardAdParam rewardAdParam, Context context, com.amgcyo.cuttadon.h.f.c cVar, int i2, String str) {
            this.a = rewardAdParam;
            this.b = context;
            this.f3971c = cVar;
            this.f3972d = i2;
            this.f3973e = str;
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            com.amgcyo.cuttadon.h.a.e.a();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            if (e.this.a != null) {
                e.this.a = null;
            }
            com.amgcyo.cuttadon.h.f.c cVar = this.f3971c;
            if (cVar != null) {
                cVar.onRewardAdClose(this.f3973e);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            if (e.this.a != null) {
                if (e.this.a.hasShown()) {
                    this.a.setErrorMsg("数据异常，请重试！");
                    this.a.setErrorCode(80016);
                    e.this.c(this.b, this.f3971c, this.a);
                } else if (e.this.a.isValid()) {
                    e.this.a.showAD();
                } else {
                    this.a.setErrorMsg("数据异常，请重试！");
                    this.a.setErrorCode(80015);
                    e.this.c(this.b, this.f3971c, this.a);
                }
            }
            e.this.a(this.b);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            String errorMsg;
            int errorCode;
            if (adError != null) {
                errorMsg = adError.getErrorMsg();
                errorCode = adError.getErrorCode();
            } else {
                errorMsg = "数据异常，请重试！";
                errorCode = 80017;
            }
            String str = "错误码：" + errorCode + "详情：" + errorMsg;
            this.a.setErrorCode(errorCode);
            this.a.setErrorMsg(errorMsg);
            e.this.c(this.b, this.f3971c, this.a);
            if (errorCode == 2003) {
                com.amgcyo.cuttadon.utils.otherutils.g.a(errorCode, this.b, e.this.a());
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward(Map<String, Object> map) {
            e.this.a(this.f3971c, this.f3973e, this.b);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
            if (this.f3971c == null || !e.this.a(this.f3972d)) {
                return;
            }
            this.f3971c.onRewardAdVideoCached(e.this.a);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
        }
    }

    /* JADX INFO: compiled from: GDTRewardVideo.java */
    private static class b {
        private static final e a = new e(null);
    }

    /* synthetic */ e(a aVar) {
        this();
    }

    private e() {
    }

    public static e c() {
        return b.a;
    }

    public void a(Context context, @NonNull RewardAdParam rewardAdParam, com.amgcyo.cuttadon.h.f.c cVar) {
        String adPosition = rewardAdParam.getAdPosition();
        if (b(context, cVar, rewardAdParam) || a(context, cVar, rewardAdParam)) {
            return;
        }
        String codeId = rewardAdParam.getCodeId();
        int loadType = rewardAdParam.getLoadType();
        if (!a(loadType)) {
            b(context);
        }
        MkApplication appContext = MkApplication.getAppContext();
        if (!appContext.isGdtInit()) {
            appContext.initGdtSdk();
        }
        this.a = new RewardVideoAD(context, codeId, new a(rewardAdParam, context, cVar, loadType, adPosition), com.amgcyo.cuttadon.utils.otherutils.h.f("gdt_new"));
        this.a.setServerSideVerificationOptions(new ServerSideVerificationOptions.Builder().setCustomData("APP's custom data").setUserId("APP's user id for server verify").build());
        this.a.loadAD();
    }
}
