package com.tramini.plugin.a.k;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static String a(l.c.a.a.a aVar) {
        com.tramini.plugin.a.g.c cVar;
        ConcurrentHashMap<String, com.tramini.plugin.a.g.c> concurrentHashMapE = aVar.e();
        if (concurrentHashMapE == null) {
            return "";
        }
        for (String str : concurrentHashMapE.keySet()) {
            if (!TextUtils.isEmpty(str) && (cVar = concurrentHashMapE.get(str)) != null && !TextUtils.isEmpty(cVar.a) && cVar.a.startsWith("http")) {
                return str;
            }
        }
        return "";
    }
}
