package com.kwad.components.core.o.a.e.a;

import com.kwad.sdk.core.response.model.AdResultData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final Map<Integer, WeakReference<AdResultData>> Rx = new HashMap();

    public static void a(int i, AdResultData adResultData) {
        if (adResultData == null) {
            return;
        }
        Rx.put(Integer.valueOf(i), new WeakReference<>(adResultData));
    }

    public static AdResultData aI(int i) {
        WeakReference<AdResultData> weakReference = Rx.get(Integer.valueOf(i));
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return weakReference.get();
    }
}
