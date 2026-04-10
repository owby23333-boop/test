package com.anythink.core.common;

import com.anythink.core.api.ATAdInfo;
import com.anythink.core.common.e.ad;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    private static volatile v a;
    private ConcurrentHashMap<String, ad> b = new ConcurrentHashMap<>(4);

    private v() {
    }

    public static v a() {
        if (a == null) {
            synchronized (v.class) {
                if (a == null) {
                    a = new v();
                }
            }
        }
        return a;
    }

    private synchronized ad h(String str) {
        ad adVar;
        adVar = this.b.get(str);
        if (adVar == null) {
            adVar = new ad();
            this.b.put(str, adVar);
        }
        return adVar;
    }

    public final f b(String str) {
        return h(str).b();
    }

    public final synchronized Map<String, Object> c(String str) {
        HashMap map;
        map = new HashMap(2);
        Map<String, Object> mapC = h(str).c();
        if (mapC != null) {
            map.putAll(mapC);
        }
        return map;
    }

    public final com.anythink.core.common.e.d d(String str) {
        return h(str).d();
    }

    public final void e(String str) {
        h(str).a((ATAdInfo) null);
    }

    public final boolean f(String str) {
        return h(str).e();
    }

    public final String g(String str) {
        return h(str).f();
    }

    public final Object a(String str) {
        return h(str).a();
    }

    public final void a(String str, f fVar) {
        h(str).a(fVar);
    }

    public final synchronized void a(String str, Map<String, Object> map) {
        ConcurrentHashMap concurrentHashMap = null;
        if (map != null) {
            try {
                concurrentHashMap = new ConcurrentHashMap(map);
            } catch (Throwable unused) {
            }
        }
        h(str).a(concurrentHashMap);
    }

    private synchronized void a(String str, String str2, Object obj) {
        h(str).a(str2, obj);
    }

    public final void a(String str, ATAdInfo aTAdInfo) {
        h(str).a(aTAdInfo);
    }

    public final void a(String str, String str2, String str3) {
        h(str).a(str2, str3);
    }

    public final String a(String str, String str2) {
        return h(str).a(str2);
    }

    public final void a(String str, boolean z2) {
        h(str).a(z2);
    }

    public final void a(String str, Object[] objArr) {
        h(str).a(objArr);
    }

    public final void a(String str, int i2, String str2) {
        h(str).b(String.valueOf(i2), str2);
    }

    public final String a(String str, int i2) {
        return h(str).b(String.valueOf(i2));
    }
}
