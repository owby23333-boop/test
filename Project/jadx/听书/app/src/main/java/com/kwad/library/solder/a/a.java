package com.kwad.library.solder.a;

import android.content.Context;
import com.kwad.library.solder.lib.b.c;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static com.kwad.library.b.a k(Context context, String str) {
        com.kwad.library.solder.lib.a.a aVarM = i.zS().m(context, str);
        if (aVarM != null && aVarM.isLoaded() && (aVarM instanceof com.kwad.library.b.a)) {
            return (com.kwad.library.b.a) aVarM;
        }
        return null;
    }

    public static void a(Context context, b bVar, b.c cVar) {
        i.zS().a(context, new c(bVar), cVar);
    }

    public static void a(Context context, com.kwad.library.solder.lib.c.b bVar, b.a aVar) {
        i.zS().a(context, new com.kwad.library.solder.lib.b.a(bVar), aVar);
    }

    public static void l(Context context, String str) {
        i.zS().l(context, str);
    }
}
