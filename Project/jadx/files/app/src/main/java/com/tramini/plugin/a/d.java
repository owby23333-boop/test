package com.tramini.plugin.a;

import android.text.TextUtils;
import l.c.a.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static volatile d a;

    private d() {
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public static String b() {
        a aVarB = l.c.a.a.b.b(com.tramini.plugin.a.a.c.c().a());
        return aVarB != null ? a(aVarB.p(), "https://aa.birdgesdk.com/v1/d_api") : "https://aa.birdgesdk.com/v1/d_api";
    }

    public static String c() {
        a aVarB = l.c.a.a.b.b(com.tramini.plugin.a.a.c.c().a());
        return aVarB != null ? a(aVarB.q(), "https://pitk.birdgesdk.com/v1/ptk") : "https://pitk.birdgesdk.com/v1/ptk";
    }

    private static String a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }
}
