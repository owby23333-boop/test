package com.anythink.basead.a;

import com.anythink.basead.a.b.b;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.s;
import com.anythink.core.common.e.u;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static final String a = "f";
    private static volatile f b;

    private f() {
    }

    public static f a() {
        if (b == null) {
            synchronized (f.class) {
                if (b == null) {
                    b = new f();
                }
            }
        }
        return b;
    }

    private static FileInputStream b(int i2, String str) {
        return com.anythink.core.common.res.d.a(n.a().g()).a(i2, com.anythink.core.common.k.f.a(str));
    }

    private static void a(String str, List<s> list, u uVar) {
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.anythink.core.common.e.j jVar = new com.anythink.core.common.e.j();
            jVar.f7312m = uVar;
            a(str, true, list.get(i2), jVar, null);
        }
    }

    public static void a(String str, com.anythink.core.common.e.i iVar, com.anythink.core.common.e.j jVar, b.InterfaceC0129b interfaceC0129b) {
        a(str, false, iVar, jVar, interfaceC0129b);
    }

    public static void a(String str, boolean z2, com.anythink.core.common.e.i iVar, com.anythink.core.common.e.j jVar, b.InterfaceC0129b interfaceC0129b) {
        new com.anythink.basead.a.b.b(str, z2, iVar, jVar).a(interfaceC0129b);
    }

    public static boolean a(s sVar, com.anythink.core.common.e.j jVar) {
        return com.anythink.basead.a.b.c.a(sVar, jVar);
    }

    public static boolean a(s sVar, int i2, k kVar) {
        return com.anythink.basead.a.b.c.a(sVar, i2, kVar);
    }

    public static boolean a(String str, InputStream inputStream) {
        if (str == null || inputStream == null) {
            return false;
        }
        return com.anythink.core.common.res.d.a(n.a().g()).a(1, com.anythink.core.common.k.f.a(str), inputStream);
    }

    public static String a(int i2, String str) {
        return com.anythink.core.common.res.d.a(n.a().g()).b(i2, com.anythink.core.common.k.f.a(str));
    }
}
