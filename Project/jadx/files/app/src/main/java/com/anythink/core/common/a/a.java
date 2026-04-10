package com.anythink.core.common.a;

import android.content.Context;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.c.k;
import com.anythink.core.common.k.p;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static volatile a a;
    private k b;

    private a() {
        if (n.a().g() != null) {
            this.b = k.a(com.anythink.core.common.c.c.a(n.a().g()));
        }
    }

    public static void c(Context context, String str) {
        p.a(context, com.anythink.core.common.b.g.f6809y, str + g.o.f6922n, 1);
    }

    public static boolean d(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g.o.f6922n);
        return p.b(context, com.anythink.core.common.b.g.f6809y, sb.toString(), 0) == 1;
    }

    public final void b(final Context context, final String str) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.b == null) {
                    a.this.b = k.a(com.anythink.core.common.c.c.a(context.getApplicationContext()));
                }
                a.this.b.a(str);
            }
        });
        p.a(context, com.anythink.core.common.b.g.f6809y, str + g.o.f6922n);
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public final void a(Context context, int i2, String str, String str2, String str3) {
        if (this.b == null) {
            this.b = k.a(com.anythink.core.common.c.c.a(context.getApplicationContext()));
        }
        h hVar = new h();
        hVar.a(str2);
        hVar.b(str);
        hVar.a(i2);
        hVar.c(str3);
        this.b.a(hVar);
    }

    public final String a(Context context, String str) {
        if (this.b == null) {
            this.b = k.a(com.anythink.core.common.c.c.a(context.getApplicationContext()));
        }
        return this.b.b(str);
    }
}
