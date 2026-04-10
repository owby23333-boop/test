package com.bytedance.sdk.openadsdk.core.component.splash;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.ISplashCardListener;
import com.bytedance.sdk.openadsdk.core.hb;

/* JADX INFO: loaded from: classes10.dex */
public class vn {
    private Object e;

    public void bf() {
        if (hb.e >= 4500) {
            Object obj = this.e;
            if (obj instanceof ISplashCardListener) {
                ((ISplashCardListener) obj).onSplashEyeReady();
            }
        }
    }

    public boolean d() {
        if (hb.e >= 4500) {
            return !(this.e instanceof ISplashCardListener);
        }
        return true;
    }

    public void e(Object obj) {
        this.e = obj;
    }

    public Activity getActivity() {
        if (hb.e < 4500) {
            return null;
        }
        Object obj = this.e;
        if (obj instanceof ISplashCardListener) {
            return ((ISplashCardListener) obj).getActivity();
        }
        return null;
    }

    public void tg() {
        this.e = null;
    }

    public void e() {
        if (hb.e >= 4500) {
            Object obj = this.e;
            if (obj instanceof ISplashCardListener) {
                ((ISplashCardListener) obj).onSplashClickEyeClose();
                this.e = null;
            }
        }
    }

    public void e(boolean z) {
        if (hb.e >= 4500) {
            Object obj = this.e;
            if (obj instanceof ISplashCardListener) {
                ((ISplashCardListener) obj).setSupportSplashClickEye(z);
            }
        }
    }
}
