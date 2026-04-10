package com.anythink.network.gdt;

import android.content.Context;
import android.graphics.Rect;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEyeAd;
import com.qq.e.ads.splash.SplashAD;

/* JADX INFO: loaded from: classes2.dex */
public class GDTATSplashEyeAd extends CustomSplashEyeAd {
    SplashAD a;

    public GDTATSplashEyeAd(ATBaseAdAdapter aTBaseAdAdapter, SplashAD splashAD) {
        super(aTBaseAdAdapter);
        this.mAtBaseAdAdapter = aTBaseAdAdapter;
        this.a = splashAD;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEyeAd
    public void customResourceDestory() {
        this.a = null;
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public int[] getSuggestedSize(Context context) {
        return null;
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public void onFinished() {
        SplashAD splashAD = this.a;
        if (splashAD != null) {
            splashAD.zoomOutAnimationFinish();
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEyeAd
    public void show(Context context, Rect rect) {
        try {
            if (this.mATSplashEyeAdListener != null) {
                this.mATSplashEyeAdListener.onAnimationStart(this.mSplashView);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
