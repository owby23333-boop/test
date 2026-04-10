package com.bytedance.msdk.dl.dl.g.z;

import com.bytedance.msdk.dl.dl.g.z.g.e;
import com.bytedance.msdk.dl.dl.g.z.g.gc;
import com.bytedance.msdk.dl.dl.g.z.g.kb;
import com.bytedance.msdk.dl.dl.g.z.g.m;
import com.bytedance.msdk.dl.dl.g.z.g.uy;
import com.bytedance.msdk.dl.dl.g.z.g.wp;
import com.bytedance.msdk.dl.dl.g.z.z.gz;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static com.bytedance.msdk.dl.z.z z(com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.dl.z.g gVar2) {
        if (gVar == null) {
            return null;
        }
        int iPf = gVar.pf();
        switch (gVar.sy()) {
            case 1:
                return new com.bytedance.msdk.dl.dl.g.z.g.z(gVar2);
            case 2:
                return new e(gVar2);
            case 3:
                return new wp(gVar2);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (iPf == 4) {
                    return new uy(gVar2);
                }
                if (iPf == 5) {
                    return new gc(gVar2);
                }
                if (iPf == 3) {
                    return new com.bytedance.msdk.dl.dl.g.z.g.z(gVar2);
                }
                return new uy(gVar2);
            case 7:
                if (iPf == 6) {
                    return new kb(gVar2);
                }
                if (iPf == 7) {
                    return new m(gVar2);
                }
                return new kb(gVar2);
            case 8:
                return new m(gVar2);
            case 9:
                return new gc(gVar2);
            case 10:
                if (iPf == 1) {
                    return new e(gVar2);
                }
                if (iPf == 2) {
                    return new m(gVar2);
                }
                return null;
        }
    }

    public static com.bytedance.msdk.dl.z.z z(String str, com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.dl.z.g gVar2) {
        if (gVar == null) {
            return null;
        }
        int iPf = gVar.pf();
        switch (gVar.sy()) {
            case 1:
                return new com.bytedance.msdk.dl.dl.g.z.z.z(str, gVar2);
            case 2:
                return new com.bytedance.msdk.dl.dl.g.z.z.m(str, gVar2);
            case 3:
                return new gz(str, gVar2);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (iPf == 4) {
                    return new com.bytedance.msdk.dl.dl.g.z.z.a(str, gVar2);
                }
                if (iPf == 5) {
                    return new com.bytedance.msdk.dl.dl.g.z.z.dl(str, gVar2);
                }
                if (iPf == 3) {
                    return new com.bytedance.msdk.dl.dl.g.z.z.z(str, gVar2);
                }
                return new com.bytedance.msdk.dl.dl.g.z.z.a(str, gVar2);
            case 7:
                if (iPf == 6) {
                    return new com.bytedance.msdk.dl.dl.g.z.z.e(str, gVar2);
                }
                if (iPf == 7) {
                    return new com.bytedance.msdk.dl.dl.g.z.z.gc(str, gVar2);
                }
                return new com.bytedance.msdk.dl.dl.g.z.z.e(str, gVar2);
            case 8:
                return new com.bytedance.msdk.dl.dl.g.z.z.gc(str, gVar2);
            case 9:
                return new com.bytedance.msdk.dl.dl.g.z.z.dl(str, gVar2);
            case 10:
                if (iPf == 1) {
                    return new com.bytedance.msdk.dl.dl.g.z.z.m(str, gVar2);
                }
                if (iPf == 2) {
                    return new com.bytedance.msdk.dl.dl.g.z.z.gc(str, gVar2);
                }
                return null;
        }
    }
}
