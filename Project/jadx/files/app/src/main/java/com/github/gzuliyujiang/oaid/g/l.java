package com.github.gzuliyujiang.oaid.g;

import android.app.Application;
import android.content.Context;

/* JADX INFO: compiled from: OAIDFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l {
    private static com.github.gzuliyujiang.oaid.d a;

    public static com.github.gzuliyujiang.oaid.d a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        com.github.gzuliyujiang.oaid.d dVar = a;
        if (dVar != null) {
            return dVar;
        }
        a = b(context);
        com.github.gzuliyujiang.oaid.d dVar2 = a;
        if (dVar2 == null || !dVar2.a()) {
            a = c(context);
            return a;
        }
        com.github.gzuliyujiang.oaid.e.a("Manufacturer interface has been found: " + a.getClass().getName());
        return a;
    }

    private static com.github.gzuliyujiang.oaid.d b(Context context) {
        if (com.github.gzuliyujiang.oaid.f.g() || com.github.gzuliyujiang.oaid.f.j()) {
            return new h(context);
        }
        if (com.github.gzuliyujiang.oaid.f.h()) {
            return new i(context);
        }
        if (com.github.gzuliyujiang.oaid.f.k()) {
            return new k(context);
        }
        if (com.github.gzuliyujiang.oaid.f.p() || com.github.gzuliyujiang.oaid.f.i() || com.github.gzuliyujiang.oaid.f.b()) {
            return new q(context);
        }
        if (com.github.gzuliyujiang.oaid.f.n()) {
            return new o(context);
        }
        if (com.github.gzuliyujiang.oaid.f.o()) {
            return new p(context);
        }
        if (com.github.gzuliyujiang.oaid.f.a()) {
            return new a(context);
        }
        if (com.github.gzuliyujiang.oaid.f.f() || com.github.gzuliyujiang.oaid.f.d()) {
            return new g(context);
        }
        if (com.github.gzuliyujiang.oaid.f.m() || com.github.gzuliyujiang.oaid.f.l()) {
            return new n(context);
        }
        if (com.github.gzuliyujiang.oaid.f.a(context)) {
            return new b(context);
        }
        if (com.github.gzuliyujiang.oaid.f.c()) {
            return new c(context);
        }
        if (com.github.gzuliyujiang.oaid.f.e()) {
            return new e(context);
        }
        return null;
    }

    private static com.github.gzuliyujiang.oaid.d c(Context context) {
        j jVar = new j(context);
        if (jVar.a()) {
            com.github.gzuliyujiang.oaid.e.a("Mobile Security Alliance has been found: " + j.class.getName());
            return jVar;
        }
        f fVar = new f(context);
        if (fVar.a()) {
            com.github.gzuliyujiang.oaid.e.a("Google Play Service has been found: " + f.class.getName());
            return fVar;
        }
        d dVar = new d();
        com.github.gzuliyujiang.oaid.e.a("OAID/AAID was not supported: " + d.class.getName());
        return dVar;
    }
}
