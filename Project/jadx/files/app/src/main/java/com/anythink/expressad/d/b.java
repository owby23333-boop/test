package com.anythink.expressad.d;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static final String a = "b";
    public static final int b = 500;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8402c = "anythink";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile b f8403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static HashMap<String, c> f8404e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f8405f = null;

    private b() {
    }

    public static b a() {
        if (f8403d == null) {
            synchronized (b.class) {
                if (f8403d == null) {
                    f8403d = new b();
                }
            }
        }
        return f8403d;
    }

    public static a b() {
        if (f8405f == null) {
            f8405f = c();
        }
        return f8405f;
    }

    public static c c(String str, String str2) {
        c cVarG = g(str, str2);
        if (cVarG != null && cVarG.k() == 0) {
            cVarG.l();
        }
        return cVarG;
    }

    public static c d(String str, String str2) {
        return g(str, str2);
    }

    public static void e(String str, String str2) {
        com.anythink.expressad.foundation.a.a.a.a().a("ivreward_".concat(String.valueOf(str)), str2);
    }

    private static void f(String str, String str2) {
        com.anythink.expressad.foundation.a.a.a.a().a(str, str2);
        a aVarB = a.b(str2);
        f8405f = aVarB;
        if (aVarB != null) {
            f8405f.G();
        }
    }

    private static c g(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = com.anythink.expressad.foundation.b.a.b().e();
        }
        String str3 = str + "_" + str2;
        c cVarB = null;
        if (f8404e.containsKey(str3)) {
            return f8404e.get(str3);
        }
        try {
            cVarB = c.b(com.anythink.expressad.foundation.a.a.a.a().a(str3));
            f8404e.put(str3, cVarB);
            return cVarB;
        } catch (Exception e2) {
            e2.printStackTrace();
            return cVarB;
        }
    }

    private static c d(String str) {
        c cVar = new c();
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(8);
        arrayList2.add(8);
        cVar.v();
        cVar.u();
        cVar.a(str);
        cVar.a(arrayList);
        cVar.b(arrayList2);
        cVar.p();
        cVar.r();
        cVar.q();
        cVar.o();
        cVar.n();
        cVar.j();
        cVar.l();
        cVar.c(100);
        cVar.d(0);
        cVar.h();
        cVar.e();
        cVar.c();
        cVar.w();
        cVar.x();
        return cVar;
    }

    public static String b(String str) {
        return com.anythink.expressad.foundation.a.a.a.a().a("ivreward_".concat(String.valueOf(str)));
    }

    public static void c(String str) {
        com.anythink.expressad.foundation.a.a.a.a().b("ivreward_".concat(String.valueOf(str)));
    }

    public static c b(String str, String str2) {
        c cVarG = g(str, str2);
        return cVarG == null ? new c() : cVarG;
    }

    public static a c() {
        a aVar = new a();
        aVar.A();
        aVar.B();
        aVar.y();
        aVar.z();
        aVar.w();
        aVar.u();
        aVar.m();
        aVar.a("anythink");
        aVar.j();
        aVar.p();
        aVar.o();
        aVar.s();
        aVar.e();
        aVar.d();
        aVar.f();
        aVar.g();
        aVar.h();
        aVar.i();
        aVar.c();
        aVar.c(com.anythink.expressad.d.a.b.df);
        aVar.a(120);
        aVar.O();
        aVar.N();
        aVar.a(100);
        aVar.Q();
        aVar.e(com.anythink.expressad.foundation.g.a.cH);
        aVar.d(com.anythink.expressad.foundation.g.a.cJ);
        aVar.c(com.anythink.expressad.foundation.g.a.cI);
        aVar.a();
        aVar.f(com.anythink.expressad.foundation.g.a.cO);
        aVar.b(10);
        return aVar;
    }

    public static String a(String str) {
        return str == null ? "" : b().R();
    }

    private static void a(Context context, String str) {
        try {
            Map<String, ?> all = context.getSharedPreferences(com.anythink.expressad.foundation.g.a.f10418o, 0).getAll();
            for (String str2 : all.keySet()) {
                if (str2.startsWith(str + "_")) {
                    f8404e.put(str2, c.b((String) all.get(str2)));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static c a(String str, String str2) {
        c cVarC = c(str, str2);
        return cVarC == null ? new c() : cVarC;
    }

    private static void a(String str, String str2, String str3) {
        String str4 = str + "_" + str2;
        com.anythink.expressad.foundation.a.a.a.a().a(str4, str3);
        f8404e.put(str4, c.b(str3));
    }
}
