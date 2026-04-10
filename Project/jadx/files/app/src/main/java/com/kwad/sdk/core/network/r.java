package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class r {
    private static volatile r agJ;
    private final Map<String, String> afs = new ConcurrentHashMap();

    private r() {
    }

    public static r wu() {
        if (agJ == null) {
            synchronized (r.class) {
                if (agJ == null) {
                    agJ = new r();
                }
            }
        }
        return agJ;
    }

    public final void A(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.afs.put(str, str2);
    }

    public final String bO(String str) {
        return this.afs.get(str);
    }
}
