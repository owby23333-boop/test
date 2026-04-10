package com.bytedance.sdk.openadsdk.core.video.a;

import com.bytedance.sdk.openadsdk.ls.dl.g.v;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class z {
    static final Map<Integer, WeakReference<v>> z = new HashMap();

    public static void z(Integer num, v vVar) {
        z.put(num, new WeakReference<>(vVar));
    }

    public static v z(Integer num) {
        WeakReference<v> weakReference = z.get(num);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
