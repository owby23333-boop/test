package com.anythink.banner.a;

import android.content.Context;
import com.anythink.core.common.b.g;
import com.anythink.core.common.h;
import com.anythink.core.common.j;
import com.anythink.core.common.v;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.anythink.core.common.f<c> {
    public static final String a = g.C0162g.f6852c + a.class.getSimpleName();

    private a(Context context, String str) {
        super(context, str);
    }

    @Override // com.anythink.core.common.f
    public final /* synthetic */ h a(j jVar) {
        c cVar = (c) jVar;
        f fVar = new f(cVar.a());
        fVar.a(cVar.f7583d);
        return fVar;
    }

    @Override // com.anythink.core.common.f
    protected final String a() {
        return "2";
    }

    public static a a(Context context, String str) {
        com.anythink.core.common.f fVarB = v.a().b(str);
        if (fVarB == null || !(fVarB instanceof a)) {
            fVarB = new a(context, str);
            v.a().a(str, fVarB);
        }
        return (a) fVarB;
    }

    public final void a(Context context, int i2, com.anythink.core.common.b.a aVar, com.anythink.core.common.b.b bVar, Map<String, Object> map) {
        c cVar = new c();
        cVar.f7584e = bVar;
        cVar.a(context);
        cVar.f7583d = i2;
        cVar.f7586g = map;
        super.a(this.b, "2", this.f7392c, cVar, aVar);
    }

    private static h a(c cVar) {
        f fVar = new f(cVar.a());
        fVar.a(cVar.f7583d);
        return fVar;
    }
}
