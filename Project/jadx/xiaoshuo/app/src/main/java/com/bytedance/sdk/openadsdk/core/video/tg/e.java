package com.bytedance.sdk.openadsdk.core.video.tg;

import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class e {
    static final Map<Integer, WeakReference<TTNativeExpressAd>> e = new HashMap();

    public static void e(Integer num, TTNativeExpressAd tTNativeExpressAd) {
        e.put(num, new WeakReference<>(tTNativeExpressAd));
    }

    public static TTNativeExpressAd e(Integer num) {
        WeakReference<TTNativeExpressAd> weakReference = e.get(num);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
