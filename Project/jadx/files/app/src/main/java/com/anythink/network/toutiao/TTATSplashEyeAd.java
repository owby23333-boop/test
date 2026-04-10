package com.anythink.network.toutiao;

import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEyeAd;
import com.bytedance.sdk.openadsdk.CSJSplashAd;

/* JADX INFO: loaded from: classes2.dex */
public class TTATSplashEyeAd extends CustomSplashEyeAd {
    CSJSplashAd a;

    public TTATSplashEyeAd(ATBaseAdAdapter aTBaseAdAdapter, CSJSplashAd cSJSplashAd) {
        super(aTBaseAdAdapter);
        this.a = cSJSplashAd;
    }

    private static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEyeAd
    public void customResourceDestory() {
        this.a = null;
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public int[] getSuggestedSize(Context context) {
        int[] splashClickEyeSizeToDp;
        CSJSplashAd cSJSplashAd = this.a;
        if (cSJSplashAd == null || context == null || (splashClickEyeSizeToDp = cSJSplashAd.getSplashClickEyeSizeToDp()) == null || splashClickEyeSizeToDp.length < 2) {
            return null;
        }
        return new int[]{a(context, splashClickEyeSizeToDp[0]), a(context, splashClickEyeSizeToDp[1])};
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public void onFinished() {
        ViewGroup viewGroup;
        CSJSplashAd cSJSplashAd = this.a;
        if (cSJSplashAd == null || (viewGroup = this.mEyeAdContainer) == null) {
            return;
        }
        cSJSplashAd.showSplashClickEyeView(viewGroup);
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEyeAd
    public void show(Context context, Rect rect) {
        try {
            if (this.mEyeAdContainer == null) {
                if (this.mATSplashEyeAdListener != null) {
                    this.mATSplashEyeAdListener.onAdDismiss(false, "mEyeAdContainer = null");
                }
            } else if (this.mATSplashEyeAdListener != null) {
                this.mATSplashEyeAdListener.onAnimationStart(this.mSplashView);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
