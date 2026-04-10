package com.bytedance.adsdk.lottie;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f191a;
    private final gz dl;
    private final LottieAnimationView g;
    private final Map<String, String> z;

    public String z(String str) {
        return str;
    }

    tb() {
        this.z = new HashMap();
        this.f191a = true;
        this.g = null;
        this.dl = null;
    }

    public tb(LottieAnimationView lottieAnimationView) {
        this.z = new HashMap();
        this.f191a = true;
        this.g = lottieAnimationView;
        this.dl = null;
    }

    public String z(String str, String str2) {
        return z(str2);
    }

    public void g(String str, String str2) {
        this.z.put(str, str2);
        z();
    }

    public final String dl(String str, String str2) {
        if (this.f191a && this.z.containsKey(str2)) {
            return this.z.get(str2);
        }
        String strZ = z(str, str2);
        if (this.f191a) {
            this.z.put(str2, strZ);
        }
        return strZ;
    }

    private void z() {
        LottieAnimationView lottieAnimationView = this.g;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        gz gzVar = this.dl;
        if (gzVar != null) {
            gzVar.invalidateSelf();
        }
    }
}
