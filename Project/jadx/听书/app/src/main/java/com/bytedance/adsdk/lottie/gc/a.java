package com.bytedance.adsdk.lottie.gc;

import com.airbnb.lottie.L;
import com.bytedance.adsdk.lottie.kb;
import com.bytedance.sdk.component.utils.wp;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a implements kb {
    private static final Set<String> z = new HashSet();

    @Override // com.bytedance.adsdk.lottie.kb
    public void z(String str) {
        z(str, null);
    }

    @Override // com.bytedance.adsdk.lottie.kb
    public void z(String str, Throwable th) {
        Set<String> set = z;
        if (set.contains(str)) {
            return;
        }
        wp.g(L.TAG, str, th);
        set.add(str);
    }

    @Override // com.bytedance.adsdk.lottie.kb
    public void g(String str, Throwable th) {
        boolean z2 = com.bytedance.adsdk.lottie.gc.z;
    }
}
