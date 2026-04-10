package com.bytedance.msdk.dl.gz;

import com.bytedance.msdk.core.uy.uy;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    public static void z(com.bytedance.msdk.g.dl dlVar, String str, String str2) {
        uy uyVarGc = com.bytedance.msdk.core.gc.z.z.z().gc(str, str2);
        if (dlVar == null || uyVarGc == null) {
            return;
        }
        dlVar.p(uyVarGc.io());
        dlVar.ls(uyVarGc.uf());
        dlVar.pf(uyVarGc.v());
        dlVar.pf(uyVarGc.js());
        dlVar.z(uyVarGc.zw());
        dlVar.gc(uyVarGc.m());
    }
}
