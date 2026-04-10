package com.anythink.expressad.foundation.g.c;

import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.r;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static final String a = "AnythinkDirManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static d f10485d;
    private f b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<a> f10486c = new ArrayList<>();

    private static final class a {
        public com.anythink.expressad.foundation.g.c.a a;
        public File b;

        public a(com.anythink.expressad.foundation.g.c.a aVar, File file) {
            this.a = aVar;
            this.b = file;
        }
    }

    private d(f fVar) {
        this.b = fVar;
    }

    public static synchronized void a(f fVar) {
        if (f10485d == null) {
            f10485d = new d(fVar);
        }
    }

    public static String b(com.anythink.expressad.foundation.g.c.a aVar) {
        File fileA = a(aVar);
        if (fileA != null) {
            return fileA.getAbsolutePath();
        }
        return null;
    }

    public final boolean b() {
        return a(this.b.b());
    }

    public static synchronized d a() {
        if (f10485d == null && com.anythink.expressad.foundation.b.a.b().d() != null) {
            r.a(com.anythink.expressad.foundation.b.a.b().d());
        }
        d dVar = f10485d;
        return f10485d;
    }

    public static File a(com.anythink.expressad.foundation.g.c.a aVar) {
        try {
            if (a() == null || a().f10486c == null || a().f10486c.size() <= 0) {
                return null;
            }
            for (a aVar2 : a().f10486c) {
                if (aVar2.a.equals(aVar)) {
                    return aVar2.b;
                }
            }
            return null;
        } catch (Throwable th) {
            o.b(a, th.getMessage(), th);
            return null;
        }
    }

    private boolean a(e eVar) {
        String strB;
        e eVarC = eVar.c();
        if (eVarC == null) {
            strB = eVar.b();
        } else {
            File fileA = a(eVarC.a());
            if (fileA == null) {
                return false;
            }
            strB = fileA.getAbsolutePath() + File.separator + eVar.b();
        }
        File file = new File(strB);
        if (!(!file.exists() ? file.mkdirs() : true)) {
            return false;
        }
        this.f10486c.add(new a(eVar.a(), file));
        List<e> listD = eVar.d();
        if (listD != null) {
            Iterator<e> it = listD.iterator();
            while (it.hasNext()) {
                if (!a(it.next())) {
                    return false;
                }
            }
        }
        return true;
    }
}
