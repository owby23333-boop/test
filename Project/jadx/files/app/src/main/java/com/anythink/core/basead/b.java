package com.anythink.core.basead;

import android.content.Context;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.p;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static volatile b a;

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public static void b(Context context, String str) {
        p.a(context, g.f6806v, str);
    }

    public static void a(Context context, String str, String str2) {
        p.a(context, g.f6806v, str, str2);
    }

    public static String a(Context context, String str) {
        return p.b(context, g.f6806v, str, "");
    }

    public static String a(j jVar) {
        return jVar == null ? "" : a(jVar.b, jVar.f7302c, jVar.f7305f);
    }

    public static String a(String str, String str2, int i2) {
        return str + "_" + str2 + "_" + i2;
    }
}
