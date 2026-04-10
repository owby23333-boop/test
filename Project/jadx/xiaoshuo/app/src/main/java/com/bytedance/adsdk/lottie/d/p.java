package com.bytedance.adsdk.lottie.d;

import com.bytedance.adsdk.lottie.l;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class p {
    private static final p e = new p();
    private final l<String, com.bytedance.adsdk.lottie.vn> bf = new l<>(20);

    public static p e() {
        return e;
    }

    public com.bytedance.adsdk.lottie.vn e(String str) {
        if (str == null) {
            return null;
        }
        return this.bf.e(str);
    }

    public void e(String str, com.bytedance.adsdk.lottie.vn vnVar) {
        if (str == null) {
            return;
        }
        this.bf.e(str, vnVar);
    }
}
