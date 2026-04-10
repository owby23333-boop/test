package com.efs.sdk.base.core.e.a;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends a {
    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        Double d;
        com.efs.sdk.base.core.config.a.c cVarA = com.efs.sdk.base.core.config.a.c.a();
        String str = bVar.f1559a.f1558a;
        com.efs.sdk.base.core.config.a.b bVar2 = cVarA.d;
        if (com.efs.sdk.base.core.config.a.c.f1549a.nextDouble() * 100.0d <= ((!bVar2.e.containsKey(str) || (d = bVar2.e.get(str)) == null) ? 100.0d : d.doubleValue())) {
            b(bVar);
        }
    }
}
