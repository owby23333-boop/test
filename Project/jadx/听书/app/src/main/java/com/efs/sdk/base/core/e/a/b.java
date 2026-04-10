package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.core.b.a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends a {
    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        com.efs.sdk.base.core.b.e eVarA;
        if (bVar.b.f1560a) {
            b(bVar);
            return;
        }
        com.efs.sdk.base.core.b.a aVar = a.b.f1531a;
        if (!"wa".equals(bVar.f1559a.f1558a) && !com.efs.sdk.base.core.b.c.a().f1533a) {
            if (!aVar.f1530a) {
                com.efs.sdk.base.core.f.f fVar = f.a.f1570a;
                int i = com.efs.sdk.base.core.config.a.c.a().d.f1548a;
                if (fVar.b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                    fVar.b.send(fVar.a("disk_limit", i));
                }
            }
            aVar.f1530a = true;
            return;
        }
        if ((bVar.f1559a.c == 0 && (bVar.c == null || bVar.c.length == 0)) || (eVarA = aVar.c.a(bVar.f1559a.b)) == null) {
            return;
        }
        eVarA.a(bVar);
    }
}
