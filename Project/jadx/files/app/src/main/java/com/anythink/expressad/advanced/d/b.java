package com.anythink.expressad.advanced.d;

import com.anythink.expressad.out.o;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.anythink.expressad.advanced.b.a {
    private o a;
    private c b;

    public b(c cVar) {
        this.b = cVar;
    }

    private static void a() {
    }

    private void b() {
        if (this.a != null) {
            this.a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    public final void a(o oVar) {
        this.a = oVar;
    }

    @Override // com.anythink.expressad.advanced.b.a
    public final void a(com.anythink.expressad.foundation.d.c cVar, int i2) {
        c cVar2;
        com.anythink.expressad.foundation.h.o.d("NativeAdvancedLoadManager", "onLoadSuccessed: ".concat(String.valueOf(i2)));
        c cVar3 = this.b;
        if (cVar3 == null || !cVar3.a() || cVar == null) {
            return;
        }
        o oVar = this.a;
        if (oVar != null && this.b != null) {
            oVar.a();
        }
        this.b.b();
        new ArrayList().add(cVar);
        if (i2 != 2 || (cVar2 = this.b) == null) {
            return;
        }
        cVar2.a(cVar, true);
    }

    @Override // com.anythink.expressad.advanced.b.a
    public final void a(String str, int i2) {
        com.anythink.expressad.foundation.h.o.d("NativeAdvancedLoadManager", "onLoadFailed: " + i2 + str);
        c cVar = this.b;
        if (cVar == null || !cVar.a()) {
            return;
        }
        o oVar = this.a;
        if (oVar != null) {
            oVar.a(str);
        }
        this.b.b();
    }
}
