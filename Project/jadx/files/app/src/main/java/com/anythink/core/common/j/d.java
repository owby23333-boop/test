package com.anythink.core.common.j;

import android.content.Context;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.h;
import com.anythink.core.common.g.a.c;
import com.anythink.core.common.g.i;
import com.anythink.core.common.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d extends o<h> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile d f7636f;

    private d(Context context) {
        super(context);
    }

    public static d a(Context context) {
        if (f7636f == null) {
            synchronized (d.class) {
                if (f7636f == null) {
                    f7636f = new d(context);
                }
            }
        }
        return f7636f;
    }

    @Override // com.anythink.core.common.o
    protected final void a(final List<h> list) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.j.d.1
            @Override // java.lang.Runnable
            public final void run() {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((h) it.next()).a().toString());
                }
                com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
                if (aVarB == null) {
                    com.anythink.core.common.g.b bVar = new com.anythink.core.common.g.b(((o) d.this).f7838e, 0, arrayList);
                    bVar.p();
                    bVar.a(0, (i) null);
                } else if (aVarB.u() != 1) {
                    com.anythink.core.common.g.b bVar2 = new com.anythink.core.common.g.b(((o) d.this).f7838e, aVarB.u(), arrayList);
                    bVar2.p();
                    bVar2.a(0, (i) null);
                } else {
                    com.anythink.core.common.g.a.a aVar = new com.anythink.core.common.g.a.a(arrayList);
                    aVar.a(1, aVarB.t());
                    aVar.a();
                    aVar.a((c.a) null);
                }
            }
        });
    }
}
