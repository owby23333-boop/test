package com.anythink.nativead.a;

import android.content.Context;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.e.e;
import com.anythink.core.common.f;
import com.anythink.core.common.h;
import com.anythink.core.common.j;
import com.anythink.core.common.k.s;
import com.anythink.core.common.v;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a extends f<d> {
    public static final String a = "a";

    private a(Context context, String str) {
        super(context, str);
    }

    @Override // com.anythink.core.common.f
    public final /* synthetic */ h a(j jVar) {
        d dVar = (d) jVar;
        c cVar = new c(dVar.a());
        cVar.a(dVar.f7583d);
        return cVar;
    }

    @Override // com.anythink.core.common.f
    protected final String a() {
        return "0";
    }

    public static a a(Context context, String str) {
        f fVarB = v.a().b(str);
        if (fVarB == null || !(fVarB instanceof a)) {
            fVarB = new a(context, str);
            v.a().a(str, fVarB);
        }
        return (a) fVarB;
    }

    public final com.anythink.core.common.e.b a(String str, Map<String, Object> map) {
        com.anythink.core.common.e.b bVarA = com.anythink.core.common.a.a().a(this.b, this.f7392c);
        if (bVarA == null || !(bVarA.f() instanceof com.anythink.nativead.unitgroup.a) || !(bVarA.e() instanceof CustomNativeAdapter)) {
            return null;
        }
        BaseAd baseAdF = bVarA.f();
        ATBaseAdAdapter aTBaseAdAdapterE = bVarA.e();
        e detail = baseAdF.getDetail();
        detail.C = str;
        com.anythink.core.common.a.a().a(this.f7392c, detail.x(), bVarA);
        com.anythink.core.common.a.a();
        com.anythink.core.common.a.b(this.f7392c, aTBaseAdAdapterE.getUnitGroupInfo());
        s.a(map, detail);
        return bVarA;
    }

    public final void a(Context context, com.anythink.core.common.b.a aVar, com.anythink.core.common.b.b bVar, Map<String, Object> map) {
        d dVar = new d();
        dVar.a(context);
        dVar.f7584e = bVar;
        dVar.f7583d = 0;
        dVar.f7586g = map;
        super.a(this.b, "0", this.f7392c, dVar, aVar);
    }

    private static h a(d dVar) {
        c cVar = new c(dVar.a());
        cVar.a(dVar.f7583d);
        return cVar;
    }
}
