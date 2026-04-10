package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private Map<Integer, AdResultData> NI = new ConcurrentHashMap();
    private AtomicInteger NJ = new AtomicInteger(0);

    static class a {
        static f NK = new f();
    }

    public static f ol() {
        return a.NK;
    }

    public final int l(AdResultData adResultData) {
        if (adResultData == null) {
            return 0;
        }
        int iIncrementAndGet = this.NJ.incrementAndGet();
        this.NI.put(Integer.valueOf(iIncrementAndGet), adResultData);
        return iIncrementAndGet;
    }

    public final AdResultData d(int i, boolean z) {
        AdResultData adResultData = this.NI.get(Integer.valueOf(i));
        this.NI.remove(Integer.valueOf(i));
        return adResultData;
    }
}
