package com.anythink.core.common;

import com.anythink.core.common.b.g;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile n f7834c;
    private final String b = n.class.getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f7835d = new ConcurrentHashMap<>(3);
    com.anythink.core.common.c.h a = com.anythink.core.common.c.h.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g()));

    public n() {
        List<com.anythink.core.common.e.p> listD = this.a.d();
        if (listD != null) {
            Iterator<com.anythink.core.common.e.p> it = listD.iterator();
            while (it.hasNext()) {
                this.f7835d.put(it.next().a(), "1");
            }
        }
    }

    public static n a() {
        if (f7834c == null) {
            synchronized (n.class) {
                if (f7834c == null) {
                    f7834c = new n();
                }
            }
        }
        return f7834c;
    }

    public static int b() {
        return com.anythink.core.common.k.p.b(com.anythink.core.common.b.n.a().g(), com.anythink.core.common.b.g.f6799o, g.o.f6924p, 0);
    }

    public final JSONArray c() {
        Iterator<Map.Entry<String, String>> it = this.f7835d.entrySet().iterator();
        JSONArray jSONArray = new JSONArray();
        while (it.hasNext()) {
            try {
                jSONArray.put(Long.parseLong(it.next().getKey()));
            } catch (Throwable unused) {
            }
        }
        return jSONArray;
    }

    public final void a(String str) {
        Map<String, Object> mapC = com.anythink.core.common.k.h.c(com.anythink.core.common.k.c.c(str));
        if (mapC.size() == 0) {
            com.anythink.core.common.k.p.a(com.anythink.core.common.b.n.a().g(), com.anythink.core.common.b.g.f6799o, g.o.f6924p, 0);
            return;
        }
        for (Map.Entry<String, Object> entry : mapC.entrySet()) {
            try {
                if (com.anythink.core.common.k.h.a(com.anythink.core.common.b.n.a().g(), entry.getValue().toString())) {
                    this.f7835d.put(entry.getKey(), "1");
                    this.a.a(entry.getKey());
                }
            } catch (Throwable unused) {
            }
        }
        com.anythink.core.common.k.p.a(com.anythink.core.common.b.n.a().g(), com.anythink.core.common.b.g.f6799o, g.o.f6924p, b() + mapC.size());
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.n.1
            @Override // java.lang.Runnable
            public final void run() {
                n.this.a.c();
            }
        });
    }
}
