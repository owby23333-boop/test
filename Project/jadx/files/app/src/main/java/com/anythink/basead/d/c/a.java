package com.anythink.basead.d.c;

import android.text.TextUtils;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static void a(ab abVar, com.anythink.basead.d.c cVar) {
        if (abVar == null || cVar == null) {
            return;
        }
        abVar.v(cVar.a());
        abVar.w(cVar.b());
        abVar.a(cVar.d());
        abVar.p(cVar.c());
        abVar.o(cVar.e());
        abVar.b(cVar.f());
        abVar.n(cVar.g());
        abVar.a(cVar.h());
        abVar.b(cVar.i());
        abVar.b(cVar.j());
    }

    public static void a(j jVar, aa aaVar) {
        k kVar;
        if (jVar == null || aaVar == null || (kVar = jVar.f7312m) == null || !(kVar instanceof ab)) {
            return;
        }
        k kVarK = aaVar.k();
        if (kVarK != null) {
            kVarK.v(kVar.y());
            kVarK.w(kVar.z());
            kVarK.p(kVar.s());
            kVarK.a(kVar.r());
            kVarK.q(kVar.t());
            kVarK.o(kVar.q());
            kVarK.b(kVar.n());
            kVarK.n(kVar.p());
            kVarK.b(kVar.b());
            kVarK.a(kVar.a());
            kVarK.b(kVar.E());
            jVar.f7312m = kVarK;
        } else {
            aaVar.a(jVar.f7312m);
        }
        if ((!(aaVar instanceof g) || TextUtils.isEmpty(((g) aaVar).a())) && TextUtils.isEmpty(aaVar.A())) {
            jVar.f7312m.r(0);
            jVar.f7312m.t(0);
            jVar.f7312m.H(2);
            jVar.f7312m.h(2);
            jVar.f7312m.A(1);
            jVar.f7312m.s(-2);
        }
    }
}
