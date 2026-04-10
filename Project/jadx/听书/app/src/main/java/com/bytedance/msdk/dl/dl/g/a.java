package com.bytedance.msdk.dl.dl.g;

import android.util.Pair;
import com.bytedance.msdk.core.gz.fo;
import com.bytedance.msdk.core.gz.kb;
import com.bytedance.msdk.core.gz.v;
import com.bytedance.msdk.core.gz.wp;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.dl.dl.g.z;

/* JADX INFO: loaded from: classes2.dex */
public class a implements z {
    @Override // com.bytedance.msdk.dl.dl.g.z
    public void z(z.InterfaceC0089z interfaceC0089z) {
        com.bytedance.msdk.api.z zVar;
        com.bytedance.msdk.api.z zVar2;
        com.bytedance.msdk.dl.m.g.g gVarZ = interfaceC0089z.z();
        com.bytedance.msdk.dl.m.z.g gVarG = interfaceC0089z.g();
        uy uyVarGz = gVarZ.gz();
        String strZw = gVarG.js().zw();
        if (uyVarGz != null) {
            if (uyVarGz.a() && !kb.z().dl(strZw, uyVarGz.fv())) {
                com.bytedance.msdk.z.gc.dl.g("TMe", "adn 请求触发次数拦截............");
                Pair<String, String> pairZ = kb.z().z(strZw, uyVarGz.fv());
                if (pairZ != null) {
                    zVar2 = new com.bytedance.msdk.api.g.g(41041, com.bytedance.msdk.api.z.z(41041), (String) pairZ.second, (String) pairZ.first);
                } else {
                    zVar2 = new com.bytedance.msdk.api.z(41041, com.bytedance.msdk.api.z.z(41041));
                }
                com.bytedance.msdk.api.z zVar3 = zVar2;
                com.bytedance.msdk.gc.m.z(uyVarGz, gVarG.js(), com.bytedance.msdk.core.gc.z.z.z().z(uyVarGz.fv()), gVarZ.gc(), 2, gVarZ.dl(), gVarZ.e(), gVarZ.m(), zVar3, -1L, gVarG.un().gc, false);
                com.bytedance.msdk.gc.m.z(zVar3, gVarG.js(), uyVarGz, gVarZ.dl(), gVarZ.e(), gVarZ.m(), com.bytedance.msdk.core.gc.z.z.z().z(uyVarGz.fv()), 0L, (String) null, (String) null, (String) null, 0L);
                gVarZ.z(zVar3, uyVarGz);
                return;
            }
            if (uyVarGz.a() && !wp.z().dl(strZw, uyVarGz.fv())) {
                com.bytedance.msdk.z.gc.dl.g("TMe", "adn 请求触发时间间隔拦截............");
                fo foVarA = wp.z().a(strZw, uyVarGz.fv());
                if (foVarA != null) {
                    zVar = new com.bytedance.msdk.api.g.dl(41042, com.bytedance.msdk.api.z.z(41042), new StringBuilder().append(wp.z().z(strZw, uyVarGz.fv())).toString(), foVarA.uy());
                } else {
                    zVar = new com.bytedance.msdk.api.z(41042, com.bytedance.msdk.api.z.z(41042));
                }
                com.bytedance.msdk.api.z zVar4 = zVar;
                com.bytedance.msdk.gc.m.z(uyVarGz, gVarG.js(), com.bytedance.msdk.core.gc.z.z.z().z(uyVarGz.fv()), gVarZ.gc(), 2, gVarZ.dl(), gVarZ.e(), gVarZ.m(), zVar4, -1L, gVarG.un().gc, false);
                com.bytedance.msdk.gc.m.z(zVar4, gVarG.js(), uyVarGz, gVarZ.dl(), gVarZ.e(), gVarZ.m(), com.bytedance.msdk.core.gc.z.z.z().z(uyVarGz.fv()), 0L, (String) null, (String) null, (String) null, 0L);
                gVarZ.z(zVar4, uyVarGz);
                return;
            }
            if (v.z().z(strZw, uyVarGz.p())) {
                com.bytedance.msdk.api.z zVarZ = v.z().z(strZw, uyVarGz.pf(), uyVarGz.fv());
                if (zVarZ != null) {
                    com.bytedance.msdk.z.gc.dl.g("TMe", "adn 请求触发了rit级别的错误码拦截............");
                    com.bytedance.msdk.gc.m.z(uyVarGz, gVarG.js(), com.bytedance.msdk.core.gc.z.z.z().z(uyVarGz.fv()), gVarZ.gc(), 2, gVarZ.dl(), gVarZ.e(), gVarZ.m(), zVarZ, -1L, gVarG.un().gc, false);
                    com.bytedance.msdk.gc.m.z(zVarZ, gVarG.js(), uyVarGz, gVarZ.dl(), gVarZ.e(), gVarZ.m(), com.bytedance.msdk.core.gc.z.z.z().z(uyVarGz.fv()), 0L, (String) null, (String) null, (String) null, 0L);
                    gVarZ.z(zVarZ, uyVarGz);
                    return;
                }
            } else {
                com.bytedance.msdk.api.z zVarZ2 = com.bytedance.msdk.core.gz.dl.z().z(uyVarGz.pf(), uyVarGz.fv());
                if (zVarZ2 != null) {
                    com.bytedance.msdk.z.gc.dl.g("TMe", "adn 请求触发了错误码拦截............");
                    com.bytedance.msdk.gc.m.z(uyVarGz, gVarG.js(), com.bytedance.msdk.core.gc.z.z.z().z(uyVarGz.fv()), gVarZ.gc(), 2, gVarZ.dl(), gVarZ.e(), gVarZ.m(), zVarZ2, -1L, gVarG.un().gc, false);
                    com.bytedance.msdk.gc.m.z(zVarZ2, gVarG.js(), uyVarGz, gVarZ.dl(), gVarZ.e(), gVarZ.m(), com.bytedance.msdk.core.gc.z.z.z().z(uyVarGz.fv()), 0L, (String) null, (String) null, (String) null, 0L);
                    gVarZ.z(zVarZ2, uyVarGz);
                    return;
                }
            }
        }
        interfaceC0089z.z(this);
    }
}
