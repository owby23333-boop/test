package com.amgcyo.cuttadon.h.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.RewardAdParam;
import com.amgcyo.cuttadon.api.entity.other.SdkErrorBean;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.f.o;
import java.util.Random;

/* JADX INFO: compiled from: BaseAllAdUtil.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static int b(int i2) {
        return (int) (i2 / 6.7f);
    }

    public abstract String a();

    protected void a(Context context) {
        if (context instanceof BaseTitleBarActivity) {
            ((BaseTitleBarActivity) context).hideLoading();
        }
    }

    protected boolean a(int i2) {
        return 1 == i2;
    }

    protected void b(Context context) {
        if (context instanceof BaseTitleBarActivity) {
            ((BaseTitleBarActivity) context).showLoading();
        }
    }

    protected void c(Context context, com.amgcyo.cuttadon.h.f.c cVar, RewardAdParam rewardAdParam) {
        if (context != null) {
            a(context);
        }
        if (rewardAdParam == null || cVar == null) {
            return;
        }
        int errorCode = rewardAdParam.getErrorCode();
        String errorMsg = rewardAdParam.getErrorMsg();
        String platform = rewardAdParam.getPlatform();
        if (TextUtils.isEmpty(platform)) {
            platform = a();
        }
        String str = "platform：" + platform + " errorCode：" + errorCode + " msg：" + errorMsg;
        cVar.onRewardAdFail(errorCode, errorMsg, platform, rewardAdParam.getAdPosition());
        com.amgcyo.cuttadon.h.h.c.a(platform, " reward ad errorCode：" + errorCode + " msg: " + errorMsg);
    }

    protected boolean a(Context context, com.amgcyo.cuttadon.h.f.c cVar, RewardAdParam rewardAdParam) {
        boolean zIsEmpty = TextUtils.isEmpty(rewardAdParam.getCodeId());
        if (zIsEmpty) {
            rewardAdParam.setErrorMsg("必要参数异常！");
            rewardAdParam.setErrorCode(80011);
            c(context, cVar, rewardAdParam);
        }
        return zIsEmpty;
    }

    protected boolean b(Context context, com.amgcyo.cuttadon.h.f.c cVar, RewardAdParam rewardAdParam) {
        boolean z2 = context == null;
        if (z2) {
            rewardAdParam.setErrorMsg("系统参数异常！");
            rewardAdParam.setErrorCode(80010);
            c(MkApplication.getAppContext(), cVar, rewardAdParam);
        }
        return z2;
    }

    protected boolean b() {
        boolean z2;
        if (com.amgcyo.cuttadon.utils.otherutils.g.q0()) {
            z2 = false;
        } else {
            com.sdsmdg.tastytoast.a.a(MkApplication.getAppContext(), 80, "网络不可用或网络中断，请重试！", 1, 3);
            z2 = true;
        }
        return !z2;
    }

    protected void a(String str) {
        com.sdsmdg.tastytoast.a.a(MkApplication.getAppContext(), 17, str, 1, 1);
    }

    protected void b(final com.amgcyo.cuttadon.h.f.c cVar, final String str, Context context) {
        if (cVar != null && b()) {
            com.amgcyo.cuttadon.h.g.h hVar = new com.amgcyo.cuttadon.h.g.h();
            hVar.f3979c = new Random().nextInt(100);
            hVar.a = a() + "激励视频广告获取激励";
            hVar.b = str;
            cVar.onRewardAdSuccess(hVar);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.h.a.a
                @Override // java.lang.Runnable
                public final void run() {
                    cVar.onRewardAdClose(str);
                }
            }, 1000L);
        }
        a(context);
    }

    protected void a(Context context, SdkErrorBean sdkErrorBean, int[] iArr) {
        if (sdkErrorBean == null) {
            return;
        }
        String strA = a();
        int errorCode = sdkErrorBean.getErrorCode();
        int[] iArrD = com.amgcyo.cuttadon.utils.otherutils.h.d(strA);
        if (iArrD != null && iArrD.length > 0) {
            iArr = iArrD;
        }
        sdkErrorBean.setPlatform(strA);
        sdkErrorBean.setAppId(com.amgcyo.cuttadon.utils.otherutils.h.a(strA));
        int length = iArr.length;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (errorCode == iArr[i2]) {
                z2 = true;
                break;
            }
            i2++;
        }
        String str = strA + " 广告平台发生错误：" + sdkErrorBean.toString() + "是否需要重启：" + z2;
        if (z2) {
            o.a(context, sdkErrorBean);
        }
    }

    protected void a(Context context, int i2, String str) {
        if (context != null) {
            a(context);
        }
        String strA = a();
        String str2 = strA + " 出现广告错误，errorCode：" + i2 + " msg：" + str;
        com.amgcyo.cuttadon.h.h.c.a(strA, " normal ad errorCode：" + i2 + " msg: " + str);
    }

    protected void a(com.amgcyo.cuttadon.h.f.c cVar, String str, Context context) {
        if (cVar != null && b()) {
            com.amgcyo.cuttadon.h.g.h hVar = new com.amgcyo.cuttadon.h.g.h();
            hVar.f3979c = new Random().nextInt(100);
            hVar.a = a() + "激励视频广告获取激励";
            hVar.b = str;
            cVar.onRewardAdSuccess(hVar);
        }
        a(context);
    }
}
