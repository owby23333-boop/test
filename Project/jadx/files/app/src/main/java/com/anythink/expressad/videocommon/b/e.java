package com.anythink.expressad.videocommon.b;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static final String a = "DownLoadManager";
    private static e b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, List<Map<String, c>>> f12165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, List<com.anythink.expressad.foundation.d.c>> f12166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, List<c>> f12167h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f12163d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, n> f12164e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ThreadPoolExecutor f12162c = new ThreadPoolExecutor(5, 15, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());

    private e() {
        this.f12162c.allowCoreThreadTimeOut(true);
    }

    public static e a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }

    private List<Map<String, c>> e(String str) {
        Map<String, List<Map<String, c>>> map = this.f12165f;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f12165f.get(str);
    }

    private void f(String str) {
        n nVarC = c(str);
        if (nVarC != null) {
            nVarC.d();
        }
    }

    public final List<c> b(String str) {
        Map<String, List<c>> map = this.f12167h;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f12167h.get(str);
    }

    public final n c(String str) {
        ConcurrentHashMap<String, n> concurrentHashMap = this.f12164e;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f12164e.get(str);
    }

    public final void d(String str) {
        n nVarC = c(str);
        if (nVarC != null) {
            nVarC.a();
        }
    }

    private c b(int i2, String str, boolean z2) {
        n nVarC = c(str);
        if (nVarC != null) {
            return nVarC.b(i2, z2);
        }
        return null;
    }

    private void d() {
        ConcurrentHashMap<String, n> concurrentHashMap = this.f12164e;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, n>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                n value = it.next().getValue();
                if (value != null) {
                    value.b();
                }
            }
        }
    }

    public final void c() {
        ConcurrentHashMap<String, n> concurrentHashMap = this.f12164e;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, n> entry : concurrentHashMap.entrySet()) {
                n value = entry.getValue();
                String key = entry.getKey();
                try {
                    com.anythink.expressad.videocommon.e.d dVarA = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), key);
                    if (dVarA != null) {
                        if (dVarA.F() == 2) {
                            value.c();
                        } else {
                            value.a();
                        }
                    }
                } catch (Exception e2) {
                    com.anythink.expressad.foundation.h.o.d(a, e2.getMessage());
                    try {
                        if (!TextUtils.isEmpty(key)) {
                            com.anythink.expressad.d.b.a();
                            com.anythink.expressad.d.c cVarC = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), key);
                            if (cVarC == null) {
                                cVarC = com.anythink.expressad.d.c.d(key);
                            }
                            if (cVarC.m() == 2) {
                                value.c();
                            } else {
                                value.a();
                            }
                        }
                    } catch (Exception e3) {
                        com.anythink.expressad.foundation.h.o.d(a, e3.getMessage());
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(java.lang.String r9, boolean r10, int r11, boolean r12, int r13, java.util.List<com.anythink.expressad.foundation.d.c> r14) {
        /*
            Method dump skipped, instruction units count: 573
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.videocommon.b.e.b(java.lang.String, boolean, int, boolean, int, java.util.List):boolean");
    }

    public final c a(String str, String str2) {
        n nVarC = c(str);
        if (nVarC != null) {
            return nVarC.a(str2);
        }
        return null;
    }

    public final List<com.anythink.expressad.foundation.d.c> a(String str) {
        Map<String, List<com.anythink.expressad.foundation.d.c>> map = this.f12166g;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f12166g.get(str);
    }

    public final boolean a(int i2, String str, boolean z2) {
        try {
            n nVarC = c(str);
            if (nVarC != null) {
                return nVarC.a(i2, z2) != null;
            }
            return false;
        } catch (Exception e2) {
            if (!com.anythink.expressad.a.a) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean a(String str, boolean z2, int i2, boolean z3, int i3, List<com.anythink.expressad.foundation.d.c> list) {
        return b(str, z2, i2, z3, i3, list);
    }

    public final n a(String str, List<com.anythink.expressad.foundation.d.c> list, int i2, com.anythink.expressad.videocommon.d.b bVar) {
        if (TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return null;
        }
        if (this.f12164e.containsKey(str)) {
            n nVar = this.f12164e.get(str);
            if (i2 != 94 && i2 != 287) {
                nVar.a(bVar);
            } else {
                nVar.a(list.get(0).Z(), bVar);
            }
            nVar.a(list);
            return nVar;
        }
        n nVar2 = new n(list, this.f12162c, str, i2);
        if (bVar != null) {
            nVar2.a(bVar);
        }
        this.f12164e.put(str, nVar2);
        return nVar2;
    }

    private n a(String str, com.anythink.expressad.foundation.d.c cVar, int i2, com.anythink.expressad.videocommon.d.b bVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return null;
        }
        if (this.f12164e.containsKey(str)) {
            n nVar = this.f12164e.get(str);
            if (i2 != 94 && i2 != 287) {
                nVar.a(bVar);
            } else {
                nVar.a(cVar.Z(), bVar);
            }
            nVar.a(cVar);
            return nVar;
        }
        n nVar2 = new n(cVar, this.f12162c, str, i2);
        if (bVar != null) {
            nVar2.a(bVar);
        }
        this.f12164e.put(str, nVar2);
        return nVar2;
    }

    public final void a(boolean z2) {
        if (z2) {
            if (this.f12163d) {
                return;
            }
        } else {
            this.f12163d = false;
        }
        ConcurrentHashMap<String, n> concurrentHashMap = this.f12164e;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, n>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().a();
            }
        }
    }

    private static void a(n nVar, String str) {
        try {
            com.anythink.expressad.videocommon.e.d dVarA = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), str);
            if (dVarA == null) {
                return;
            }
            if (dVarA.F() == 2) {
                nVar.c();
            } else {
                nVar.a();
            }
        } catch (Exception e2) {
            com.anythink.expressad.foundation.h.o.d(a, e2.getMessage());
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                com.anythink.expressad.d.b.a();
                com.anythink.expressad.d.c cVarC = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), str);
                if (cVarC == null) {
                    cVarC = com.anythink.expressad.d.c.d(str);
                }
                if (cVarC.m() == 2) {
                    nVar.c();
                } else {
                    nVar.a();
                }
            } catch (Exception e3) {
                com.anythink.expressad.foundation.h.o.d(a, e3.getMessage());
            }
        }
    }

    private void b(String str, String str2) {
        n nVarC = c(str);
        if (nVarC != null) {
            try {
                nVarC.b(str2);
            } catch (Exception unused) {
            }
        }
    }

    public final void b() {
        this.f12163d = false;
        ConcurrentHashMap<String, n> concurrentHashMap = this.f12164e;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, n>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                n value = it.next().getValue();
                if (value != null) {
                    value.c();
                }
            }
        }
    }
}
