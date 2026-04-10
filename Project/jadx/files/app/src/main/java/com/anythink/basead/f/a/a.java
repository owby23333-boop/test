package com.anythink.basead.f.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.a.b.b;
import com.anythink.basead.a.f;
import com.anythink.basead.c.c;
import com.anythink.core.c.d;
import com.anythink.core.c.e;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.s;
import com.anythink.core.common.e.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static a a;
    private Context b;

    private a(Context context) {
        this.b = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (a == null) {
            a = new a(context);
        }
        return a;
    }

    public final String b(String str) {
        d dVarA = e.a(this.b).a(str);
        if (dVarA == null) {
            return "";
        }
        List<s> listE = dVarA.E();
        ArrayList arrayList = new ArrayList();
        if (listE == null || listE.size() == 0) {
            return "";
        }
        for (int size = listE.size() - 1; size >= 0; size--) {
            s sVar = listE.get(size);
            f.a();
            if (f.a(sVar, dVarA.X(), dVarA.D())) {
                arrayList.add(b.a(this.b).d(sVar));
            } else {
                listE.remove(size);
            }
        }
        if (arrayList.size() == 0) {
            return "";
        }
        Collections.sort(arrayList, new Comparator<c>() { // from class: com.anythink.basead.f.a.a.1
            private static int a(c cVar, c cVar2) {
                return Integer.valueOf(cVar.f5895d).compareTo(Integer.valueOf(cVar2.f5895d));
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(c cVar, c cVar2) {
                return Integer.valueOf(cVar.f5895d).compareTo(Integer.valueOf(cVar2.f5895d));
            }
        });
        return ((c) arrayList.get(0)).a;
    }

    public final void a(String str) {
        List<s> listE;
        u uVarD;
        d dVarA = e.a(this.b).a(str);
        if (dVarA == null || (listE = dVarA.E()) == null || (uVarD = dVarA.D()) == null) {
            return;
        }
        f.a();
        if (listE != null) {
            int size = listE.size();
            for (int i2 = 0; i2 < size; i2++) {
                j jVar = new j();
                jVar.f7312m = uVarD;
                f.a(str, true, listE.get(i2), jVar, null);
            }
        }
    }

    public final s a(String str, String str2) {
        d dVarA = e.a(this.b).a(str);
        if (dVarA == null) {
            return null;
        }
        return dVarA.e(str2);
    }

    public final void a(String str, s sVar, j jVar, b.InterfaceC0129b interfaceC0129b) {
        if (a(sVar)) {
            interfaceC0129b.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5904h, com.anythink.basead.c.f.G));
            return;
        }
        if (b.a(this.b).b(sVar)) {
            interfaceC0129b.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5901e, com.anythink.basead.c.f.f5922z));
        } else if (b.a(this.b).c(sVar)) {
            interfaceC0129b.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5902f, com.anythink.basead.c.f.A));
        } else {
            f.a();
            f.a(str, sVar, jVar, interfaceC0129b);
        }
    }

    private static boolean a(s sVar) {
        List<String> listK = n.a().k();
        if (listK == null) {
            return false;
        }
        Iterator<String> it = listK.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(sVar.B(), it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(s sVar, j jVar, boolean z2) {
        if (this.b == null || sVar == null || a(sVar)) {
            return false;
        }
        if (z2) {
            f.a();
            return f.a(sVar, jVar);
        }
        if (!b.a(this.b).b(sVar) && !b.a(this.b).c(sVar)) {
            f.a();
            if (f.a(sVar, jVar)) {
                return true;
            }
        }
        return false;
    }
}
