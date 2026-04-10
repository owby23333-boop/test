package com.anythink.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.c.d;
import com.anythink.core.common.b.g;
import com.anythink.core.common.k.p;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f6467c;
    final String a = b.class.getSimpleName();
    ConcurrentHashMap<String, com.anythink.core.common.e.c> b = new ConcurrentHashMap<>();

    public static b a() {
        if (f6467c == null) {
            synchronized (b.class) {
                if (f6467c == null) {
                    f6467c = new b();
                }
            }
        }
        return f6467c;
    }

    public final void b(Context context, String str, d dVar) {
        com.anythink.core.common.e.c cVar = this.b.get(str);
        if (cVar == null) {
            String strB = p.b(context, g.f6803s, str, "");
            com.anythink.core.common.e.c cVar2 = new com.anythink.core.common.e.c();
            if (!TextUtils.isEmpty(strB)) {
                cVar2.a(strB);
            }
            this.b.put(str, cVar2);
            cVar = cVar2;
        }
        if (System.currentTimeMillis() - cVar.b > dVar.al()) {
            cVar.b = System.currentTimeMillis();
            cVar.a = 0;
        }
        cVar.a++;
        StringBuilder sb = new StringBuilder("After save load cap:");
        sb.append(str);
        sb.append(":");
        sb.append(cVar.toString());
        p.a(context, g.f6803s, str, cVar.toString());
    }

    public final boolean a(Context context, String str, d dVar) {
        if (dVar.ak() <= 0) {
            return false;
        }
        com.anythink.core.common.e.c cVar = this.b.get(str);
        if (cVar == null) {
            String strB = p.b(context, g.f6803s, str, "");
            cVar = new com.anythink.core.common.e.c();
            if (!TextUtils.isEmpty(strB)) {
                cVar.a(strB);
            }
            this.b.put(str, cVar);
        }
        StringBuilder sb = new StringBuilder("Load Cap info:");
        sb.append(str);
        sb.append(":");
        sb.append(cVar.toString());
        return cVar.a >= dVar.ak() && System.currentTimeMillis() - cVar.b <= dVar.al();
    }
}
