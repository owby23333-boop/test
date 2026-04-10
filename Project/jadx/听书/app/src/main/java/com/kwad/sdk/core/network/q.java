package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class q {
    private static volatile q aFl;
    private final Map<String, String> aDS = new ConcurrentHashMap();

    private q() {
    }

    public static q HB() {
        if (aFl == null) {
            synchronized (q.class) {
                if (aFl == null) {
                    aFl = new q();
                }
            }
        }
        return aFl;
    }

    public final void U(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.aDS.put(str, str2);
    }

    public final String ea(String str) {
        return this.aDS.get(str);
    }
}
