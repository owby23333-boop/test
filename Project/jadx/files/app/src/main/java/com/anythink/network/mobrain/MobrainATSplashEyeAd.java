package com.anythink.network.mobrain;

import android.content.Context;
import android.graphics.Rect;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEyeAd;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAd;

/* JADX INFO: loaded from: classes2.dex */
public class MobrainATSplashEyeAd extends CustomSplashEyeAd {
    private GMSplashAd a;

    public MobrainATSplashEyeAd(ATBaseAdAdapter aTBaseAdAdapter, GMSplashAd gMSplashAd) {
        super(aTBaseAdAdapter);
        this.a = gMSplashAd;
    }

    private static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEyeAd
    public void customResourceDestory() {
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public int[] getSuggestedSize(Context context) {
        int[] minWindowSize;
        GMSplashAd gMSplashAd = this.a;
        if (gMSplashAd == null || context == null || gMSplashAd.getMinWindowSize().length < 2 || (minWindowSize = this.a.getMinWindowSize()) == null || minWindowSize.length < 2) {
            return null;
        }
        return new int[]{a(context, minWindowSize[0]), a(context, minWindowSize[1])};
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public void onFinished() {
        this.a = null;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEyeAd
    protected void show(Context context, Rect rect) {
        try {
            if (this.mATSplashEyeAdListener != null) {
                this.mATSplashEyeAdListener.onAnimationStart(this.mSplashView);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
