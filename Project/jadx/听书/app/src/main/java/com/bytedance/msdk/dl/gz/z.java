package com.bytedance.msdk.dl.gz;

import android.os.SystemClock;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static void z(com.bytedance.msdk.dl.m.z.g gVar, List<com.bytedance.msdk.g.dl> list, boolean z) {
        if (gVar == null) {
            return;
        }
        com.bytedance.msdk.g.dl dlVarZ = z(list);
        if (gVar.mc()) {
            return;
        }
        gVar.dl(SystemClock.elapsedRealtime());
        com.bytedance.msdk.gc.m.z(dlVarZ, gVar.js(), gVar.wp(), gVar.lq() - gVar.x(), gVar.un().z, !gVar.zw(), list != null ? list.size() : 0, gVar.un().gc, z);
        gVar.a(true);
    }

    private static com.bytedance.msdk.g.dl z(List<com.bytedance.msdk.g.dl> list) {
        com.bytedance.msdk.g.dl dlVar = null;
        if (list != null && list.size() != 0) {
            for (com.bytedance.msdk.g.dl dlVar2 : list) {
                if (dlVar == null || dlVar2.f() < dlVar.f()) {
                    dlVar = dlVar2;
                }
            }
        }
        return dlVar;
    }
}
