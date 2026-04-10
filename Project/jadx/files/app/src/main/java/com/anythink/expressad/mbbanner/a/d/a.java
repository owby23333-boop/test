package com.anythink.expressad.mbbanner.a.d;

import android.content.Context;
import android.os.Handler;
import com.anythink.core.common.b.n;
import com.anythink.expressad.mbbanner.a.b.d;
import com.anythink.expressad.mbbanner.a.b.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final String a = "a";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile a f10810h;
    private Context b = n.a().g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.anythink.expressad.mbbanner.a.e.a f10811c = new com.anythink.expressad.mbbanner.a.e.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, e> f10812d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, Boolean> f10813e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Handler> f10814f = new ConcurrentHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, Integer> f10815g = new ConcurrentHashMap();

    private a() {
    }

    private e b(String str) {
        if (this.f10812d.containsKey(str)) {
            return this.f10812d.get(str);
        }
        String strE = com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.c cVarC = com.anythink.expressad.d.b.c(strE, str);
        if (cVarC == null) {
            cVarC = com.anythink.expressad.d.c.c(str);
        }
        e eVar = new e(str, "", cVarC.t() * 1);
        this.f10812d.put(str, eVar);
        return eVar;
    }

    public static a a() {
        if (f10810h == null) {
            synchronized (a.class) {
                if (f10810h == null) {
                    f10810h = new a();
                }
            }
        }
        return f10810h;
    }

    private void a(String str, d dVar, com.anythink.expressad.mbbanner.a.c.b bVar) {
        if (this.b == null) {
            this.f10811c.a(bVar, "Banner Context == null!", str);
            return;
        }
        if (dVar != null && bVar != null) {
            Map<String, Boolean> map = this.f10813e;
            if (map != null && map.containsKey(str) && this.f10813e.get(str).booleanValue()) {
                this.f10811c.a(bVar, "Current unit is loading!", str);
                return;
            }
            this.f10813e.put(str, Boolean.TRUE);
            new b(this.b, b(str), bVar, this.f10811c);
            return;
        }
        this.f10811c.a(bVar, "Banner request parameters or callback empty!", str);
    }

    public final void b() {
        Map<String, e> map = this.f10812d;
        if (map != null) {
            map.clear();
        }
        Map<String, Boolean> map2 = this.f10813e;
        if (map2 != null) {
            map2.clear();
        }
        Map<String, Handler> map3 = this.f10814f;
        if (map3 != null) {
            for (Map.Entry<String, Handler> entry : map3.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().removeCallbacksAndMessages(null);
                }
            }
            this.f10814f.clear();
        }
        Map<String, Integer> map4 = this.f10815g;
        if (map4 != null) {
            map4.clear();
        }
    }

    public final void a(String str, com.anythink.expressad.foundation.d.d dVar, com.anythink.expressad.mbbanner.a.c.b bVar) {
        synchronized (a()) {
            if (this.f10813e != null && this.f10813e.containsKey(str) && this.f10813e.get(str).booleanValue()) {
                this.f10811c.a(bVar, "Current unit is loading!", str);
                return;
            }
            this.f10813e.put(str, Boolean.TRUE);
            new b(this.b, b(str), bVar, this.f10811c).a(str, dVar, new com.anythink.expressad.mbbanner.a.c.d() { // from class: com.anythink.expressad.mbbanner.a.d.a.1
                @Override // com.anythink.expressad.mbbanner.a.c.d
                public final void a(String str2) {
                    synchronized (a.a()) {
                        a.this.f10813e.put(str2, Boolean.FALSE);
                    }
                }
            });
        }
    }

    public final void a(String str) {
        if (this.f10814f.containsKey(str)) {
            this.f10814f.get(str).removeCallbacksAndMessages(null);
            this.f10814f.remove(str);
        }
    }

    public final void a(int i2, String str) {
        int iIntValue = this.f10815g.containsKey(str) ? this.f10815g.get(str).intValue() : 0;
        if (i2 == 1) {
            if (this.f10814f.containsKey(str)) {
                this.f10814f.get(str).removeCallbacksAndMessages(null);
            }
            this.f10815g.put(str, Integer.valueOf(i2));
            return;
        }
        if (i2 == 2) {
            if (iIntValue == 1) {
                if (this.f10814f.containsKey(str)) {
                    this.f10814f.get(str).removeCallbacksAndMessages(null);
                }
                this.f10815g.put(str, Integer.valueOf(i2));
                return;
            }
            return;
        }
        if (i2 == 3) {
            if (iIntValue == 2 || iIntValue == 4) {
                this.f10815g.put(str, 1);
                return;
            }
            return;
        }
        if (i2 != 4) {
            return;
        }
        if (iIntValue == 0) {
            this.f10815g.put(str, 0);
            return;
        }
        if (this.f10814f.containsKey(str)) {
            this.f10814f.get(str).removeCallbacksAndMessages(null);
        }
        this.f10815g.put(str, Integer.valueOf(i2));
    }
}
