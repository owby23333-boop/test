package com.bytedance.sdk.openadsdk.core.component.splash;

import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.core.hb;

/* JADX INFO: loaded from: classes10.dex */
public class e {
    private Object e;

    public void bf() {
        if (hb.e >= 4700) {
            Object obj = this.e;
            if (obj instanceof CSJSplashAd.SplashCardListener) {
                ((CSJSplashAd.SplashCardListener) obj).onSplashCardClick();
            }
        }
    }

    public boolean d() {
        if (hb.e >= 4700) {
            return !(this.e instanceof CSJSplashAd.SplashCardListener);
        }
        return true;
    }

    public void e(Object obj) {
        this.e = obj;
    }

    public void tg() {
        this.e = null;
    }

    public void e() {
        if (hb.e >= 4700) {
            Object obj = this.e;
            if (obj instanceof CSJSplashAd.SplashCardListener) {
                ((CSJSplashAd.SplashCardListener) obj).onSplashCardClose();
                this.e = null;
            }
        }
    }

    public void e(CSJSplashAd cSJSplashAd) {
        if (hb.e >= 4700) {
            Object obj = this.e;
            if (obj instanceof CSJSplashAd.SplashCardListener) {
                ((CSJSplashAd.SplashCardListener) obj).onSplashCardReadyToShow(cSJSplashAd);
            }
        }
    }
}
