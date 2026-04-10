package com.bytedance.sdk.openadsdk.core.component.splash;

import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.core.hb;

/* JADX INFO: loaded from: classes10.dex */
public class bf {
    private Object e;

    public void bf() {
        if (hb.e >= 4700) {
            Object obj = this.e;
            if (obj instanceof CSJSplashAd.SplashClickEyeListener) {
                ((CSJSplashAd.SplashClickEyeListener) obj).onSplashClickEyeClick();
            }
        }
    }

    public void d() {
        this.e = null;
    }

    public void e(Object obj) {
        this.e = obj;
    }

    public void e(CSJSplashAd cSJSplashAd) {
        if (hb.e >= 4700) {
            Object obj = this.e;
            if (obj instanceof CSJSplashAd.SplashClickEyeListener) {
                ((CSJSplashAd.SplashClickEyeListener) obj).onSplashClickEyeReadyToShow(cSJSplashAd);
            }
        }
    }

    public void e() {
        if (hb.e >= 4700) {
            Object obj = this.e;
            if (obj instanceof CSJSplashAd.SplashClickEyeListener) {
                ((CSJSplashAd.SplashClickEyeListener) obj).onSplashClickEyeClose();
                this.e = null;
            }
        }
    }
}
