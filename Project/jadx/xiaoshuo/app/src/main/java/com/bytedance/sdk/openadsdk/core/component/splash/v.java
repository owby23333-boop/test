package com.bytedance.sdk.openadsdk.core.component.splash;

import com.bytedance.sdk.openadsdk.ISplashClickEyeListener;

/* JADX INFO: loaded from: classes10.dex */
public class v {
    private Object e;

    public void bf() {
        Object obj = this.e;
        if (obj instanceof ISplashClickEyeListener) {
            ((ISplashClickEyeListener) obj).onSplashClickEyeAnimationStart();
        }
    }

    public void d() {
        this.e = null;
    }

    public void e(Object obj) {
        this.e = obj;
    }

    public void e() {
        Object obj = this.e;
        if (obj instanceof ISplashClickEyeListener) {
            ((ISplashClickEyeListener) obj).onSplashClickEyeAnimationFinish();
            this.e = null;
        }
    }

    public void e(boolean z) {
        Object obj = this.e;
        if (obj instanceof ISplashClickEyeListener) {
            ((ISplashClickEyeListener) obj).isSupportSplashClickEye(z);
        }
    }
}
