package com.bytedance.adsdk.lottie.vn;

import android.util.Log;
import com.airbnb.lottie.L;
import com.bytedance.adsdk.lottie.wu;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class d implements wu {
    private static final Set<String> e = new HashSet();

    @Override // com.bytedance.adsdk.lottie.wu
    public void bf(String str) {
        e(str, null);
    }

    public void d(String str, Throwable th) {
        if (com.bytedance.adsdk.lottie.ga.e) {
            Log.d(L.TAG, str, th);
        }
    }

    @Override // com.bytedance.adsdk.lottie.wu
    public void e(String str) {
        d(str, null);
    }

    @Override // com.bytedance.adsdk.lottie.wu
    public void bf(String str, Throwable th) {
        if (com.bytedance.adsdk.lottie.ga.e) {
            Log.d(L.TAG, str, th);
        }
    }

    @Override // com.bytedance.adsdk.lottie.wu
    public void e(String str, Throwable th) {
        Set<String> set = e;
        if (set.contains(str)) {
            return;
        }
        Log.w(L.TAG, str, th);
        set.add(str);
    }
}
