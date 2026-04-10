package com.bytedance.sdk.openadsdk.core.ugeno.z;

import com.bytedance.sdk.component.adexpress.g.i;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.un.eo;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements g {
    protected abstract String z(na naVar, int i, int i2);

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.z.g
    public String z(na naVar) {
        int iGc = gc(naVar);
        int iA = a(naVar);
        if (iGc <= 0 || iGc > 9 || iA == -1) {
            return null;
        }
        return z(naVar, iGc, iA);
    }

    private int a(na naVar) {
        if (naVar == null) {
            return -1;
        }
        return naVar.ou();
    }

    private static int gc(na naVar) {
        int iGz;
        if (naVar == null) {
            return -1;
        }
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarLw = naVar.lw();
        int iTb = gVarLw != null ? gVarLw.tb() : -1;
        return ((iTb <= 0 || iTb >= 10) && (iGz = eo.gz(naVar)) > 0 && iGz < 10) ? iGz : iTb;
    }

    public static g z(na naVar, i iVar) {
        if (naVar == null || gc(naVar) != 5) {
            return null;
        }
        if ((iVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.g) && ((com.bytedance.sdk.openadsdk.core.ugeno.express.g) iVar).un()) {
            return new com.bytedance.sdk.openadsdk.core.ugeno.z.g.z();
        }
        return new com.bytedance.sdk.openadsdk.core.ugeno.z.z.z();
    }

    public static boolean g(na naVar) {
        if (naVar == null) {
            return false;
        }
        return (vm.dl(naVar) == 2) && dl(naVar);
    }

    public static boolean dl(na naVar) {
        return gc(naVar) == 5;
    }
}
