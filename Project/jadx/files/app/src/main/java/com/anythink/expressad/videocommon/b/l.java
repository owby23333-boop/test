package com.anythink.expressad.videocommon.b;

import android.text.TextUtils;
import com.anythink.expressad.foundation.d.c;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    private static Map<String, Boolean> b = new HashMap();
    private Map<String, Boolean> a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, Boolean> f12182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, Boolean> f12183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, Boolean> f12184e;

    private static final class a {
        public static l a = new l(0);

        private a() {
        }
    }

    /* synthetic */ l(byte b2) {
        this();
    }

    public static l a() {
        return a.a;
    }

    public static void c(String str) {
        if (b == null) {
            b = new HashMap();
        }
        b.put(str, Boolean.TRUE);
    }

    private void e(String str) {
        if (this.f12183d == null) {
            this.f12183d = new HashMap();
        }
        this.f12183d.put(str, Boolean.FALSE);
    }

    private void f(String str) {
        if (this.f12184e.containsKey(str)) {
            this.f12184e.remove(str);
        }
    }

    private static boolean g(String str) {
        boolean zA = a(b, str);
        if (zA || com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.b.a.b().d()).b(str)) {
            return true;
        }
        return zA;
    }

    private static boolean h(String str) {
        File file = new File(com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_VC) + File.separator + com.anythink.expressad.foundation.h.m.d(str));
        try {
            if (file.exists() && file.isFile()) {
                return file.canRead();
            }
            return false;
        } catch (Throwable th) {
            if (!com.anythink.expressad.a.a) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public final boolean b(String str) {
        if (this.f12182c == null || TextUtils.isEmpty(str) || !this.f12182c.containsKey(str)) {
            return false;
        }
        return this.f12182c.get(str).booleanValue();
    }

    public final boolean d(String str) {
        if (!TextUtils.isEmpty(str) && this.f12184e.containsKey(str)) {
            return this.f12184e.get(str).booleanValue();
        }
        return false;
    }

    private l() {
        this.a = new HashMap();
        this.f12182c = new HashMap();
        this.f12183d = new HashMap();
        this.f12184e = new HashMap();
    }

    public final boolean a(String str) {
        if (this.a == null || TextUtils.isEmpty(str) || !this.a.containsKey(str)) {
            return false;
        }
        return this.a.get(str).booleanValue();
    }

    public final void b(String str, boolean z2) {
        if (this.f12182c == null) {
            this.f12182c = new HashMap();
        }
        this.f12182c.put(str, Boolean.valueOf(z2));
    }

    public final void a(List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (cVar != null) {
                b(cVar);
                e(cVar.aZ());
            }
        }
    }

    public final void c(String str, boolean z2) {
        if (this.f12184e == null) {
            this.f12184e = new HashMap();
        }
        this.f12184e.put(str, Boolean.valueOf(z2));
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        List<c.C0205c.a> listF;
        if (cVar != null) {
            String strS = cVar.S();
            Map<String, Boolean> map = this.a;
            if (map != null && !map.containsKey(strS)) {
                this.a.put(strS, Boolean.FALSE);
            }
            String strI = cVar.I();
            Map<String, Boolean> map2 = this.f12182c;
            if (map2 != null && !map2.containsKey(strI)) {
                this.f12182c.put(strI, Boolean.FALSE);
            }
            c.C0205c c0205cM = cVar.M();
            if (c0205cM == null || (listF = c0205cM.f()) == null) {
                return;
            }
            for (c.C0205c.a aVar : listF) {
                if (aVar != null) {
                    b(aVar.b);
                }
            }
        }
    }

    private void a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            b(cVar);
            e(cVar.aZ());
        }
    }

    public final void a(String str, boolean z2) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, Boolean.valueOf(z2));
    }

    private static boolean a(Map<String, Boolean> map, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (map != null) {
            if (map.containsKey(str)) {
                return map.get(str).booleanValue();
            }
            map.put(str, Boolean.FALSE);
            return false;
        }
        new HashMap().put(str, Boolean.FALSE);
        return false;
    }

    private static void b(List<String> list) {
        Map<String, Boolean> map;
        if (list == null || list.size() == 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && (map = b) != null && !map.containsKey(str)) {
                b.put(str, Boolean.valueOf(com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.b.a.b().d()).b(str)));
            }
        }
    }

    private boolean a(boolean z2, String str) {
        boolean zA = a(this.f12182c, str);
        if (zA || !z2 || TextUtils.isEmpty(i.a().c(str))) {
            return zA;
        }
        this.f12182c.put(str, Boolean.TRUE);
        return true;
    }

    private static boolean a(c.C0205c c0205c) {
        List<c.C0205c.a> listF;
        List<String> list;
        if (c0205c != null && (listF = c0205c.f()) != null) {
            for (c.C0205c.a aVar : listF) {
                if (aVar != null && (list = aVar.b) != null) {
                    for (String str : list) {
                        boolean zA = a(b, str);
                        if (zA || com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.b.a.b().d()).b(str)) {
                            zA = true;
                        }
                        if (!zA) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
