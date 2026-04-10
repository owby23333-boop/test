package com.anythink.core.common;

import android.text.TextUtils;
import com.anythink.core.common.b.g;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    private static volatile i a;

    private i() {
    }

    public static i a() {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    a = new i();
                }
            }
        }
        return a;
    }

    private static String a(String str) {
        return str;
    }

    public static String b() {
        return m() ? g.c.f6841s : g.c.f6829g;
    }

    public static String c() {
        return m() ? g.c.f6842t : g.c.f6830h;
    }

    public static String d() {
        return m() ? g.c.f6845w : g.c.f6833k;
    }

    public static String e() {
        return m() ? g.c.C : g.c.f6840r;
    }

    public static String f() {
        com.anythink.core.common.e.n nVarR = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p()).r();
        String str = m() ? g.c.f6847y : g.c.f6835m;
        return nVarR != null ? a(nVarR.b(), str) : str;
    }

    public static String g() {
        com.anythink.core.common.e.n nVarR = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p()).r();
        String str = m() ? g.c.f6848z : g.c.f6836n;
        return nVarR != null ? a(nVarR.d(), str) : str;
    }

    public static String h() {
        com.anythink.core.common.e.n nVarR = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p()).r();
        String str = m() ? g.c.A : g.c.f6837o;
        return nVarR != null ? a(nVarR.a(), str) : str;
    }

    public static String i() {
        com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p());
        String str = m() ? g.c.B : g.c.f6839q;
        return aVarB != null ? a(aVarB.o(), str) : str;
    }

    public static String j() {
        com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p());
        String str = m() ? g.c.f6844v : g.c.f6832j;
        return aVarB != null ? a(aVarB.X(), str) : str;
    }

    public static String k() {
        com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p());
        String str = m() ? g.c.f6843u : g.c.f6831i;
        return aVarB != null ? a(aVarB.ac(), str) : str;
    }

    public static String l() {
        com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p());
        return aVarB != null ? a(aVarB.T(), g.q.a) : g.q.a;
    }

    private static boolean m() {
        return com.anythink.core.common.b.n.a().D() && com.anythink.core.common.b.n.a().C();
    }

    public static String b(com.anythink.core.c.d dVar) {
        return dVar.q();
    }

    public static String a(com.anythink.core.c.d dVar, boolean z2) {
        if (z2) {
            String strV = dVar.v();
            dVar.an();
            if (!TextUtils.isEmpty(strV)) {
                return strV;
            }
        }
        com.anythink.core.common.e.n nVarR = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p()).r();
        String str = m() ? g.c.f6846x : g.c.f6834l;
        return nVarR != null ? a(nVarR.c(), str) : str;
    }

    public static String a(com.anythink.core.c.d dVar) {
        String strR = dVar.r();
        return TextUtils.isEmpty(strR) ? "" : strR;
    }

    private static String a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }
}
