package com.anythink.expressad.videocommon.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static volatile a a;
    private final com.anythink.core.common.res.a.c b = com.anythink.core.common.res.a.c.a();

    private a() {
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

    public static com.anythink.core.common.a.i b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.anythink.core.common.a.j.a().a(str);
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : com.anythink.core.common.res.d.a(com.anythink.core.common.b.n.a().g()).b(4, com.anythink.core.common.k.f.a(str));
    }
}
