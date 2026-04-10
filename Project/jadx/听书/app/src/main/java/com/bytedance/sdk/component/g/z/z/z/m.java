package com.bytedance.sdk.component.g.z.z.z;

import android.text.TextUtils;
import com.bytedance.sdk.component.dl.g.a;
import com.bytedance.sdk.component.dl.g.h;
import com.bytedance.sdk.component.dl.g.hh;
import com.bytedance.sdk.component.dl.g.iq;
import com.bytedance.sdk.component.dl.g.q;
import com.bytedance.sdk.component.dl.g.sy;
import com.bytedance.sdk.component.dl.g.tb;
import com.bytedance.sdk.component.dl.g.zw;
import com.bytedance.sdk.component.g.z.pf;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.g.z.wp;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class m extends wp {
    com.bytedance.sdk.component.g.z.a i;
    zw wp;

    public m(wp.z zVar) {
        super(zVar);
        z(zVar);
        this.i = new e(this.wp);
    }

    private void z(wp.z zVar) {
        zw.z zVar2 = new zw.z();
        zVar2.io = (int) zVar.dl;
        zVar2.gk = zVar.f724a;
        zVar2.uf = (int) zVar.gc;
        zVar2.x = zVar.m;
        zVar2.sy = (int) zVar.e;
        zVar2.lq = zVar.gz;
        zVar2.h = zVar.uy;
        zVar2.l = zVar.kb;
        zVar2.z(new dl(zVar.g));
        List<com.bytedance.sdk.component.g.z.fo> list = zVar.z;
        if (list != null && !list.isEmpty()) {
            for (final com.bytedance.sdk.component.g.z.fo foVar : list) {
                zVar2.z(new tb() { // from class: com.bytedance.sdk.component.g.z.z.z.m.1
                    @Override // com.bytedance.sdk.component.dl.g.tb
                    public h z(tb.z zVar3) throws IOException {
                        return ((fo) foVar.z(new gc(zVar3))).z;
                    }
                });
            }
        }
        this.wp = zVar2.z();
    }

    @Override // com.bytedance.sdk.component.g.z.wp
    public com.bytedance.sdk.component.g.z.a z() {
        return this.i;
    }

    @Override // com.bytedance.sdk.component.g.z.wp
    public com.bytedance.sdk.component.g.z.g z(v vVar) {
        if (vVar == null) {
            return null;
        }
        sy.z zVar = new sy.z();
        zVar.z(vVar.z());
        if (vVar.g() != null) {
            zVar.z(vVar.g().z());
        }
        if (vVar.m() != null) {
            if (dl(vVar.m())) {
                zVar.z(vVar.dl(), hh.z(q.z(vVar.m().dl.toString()), vVar.m().f719a));
            } else if (z(vVar.m())) {
                zVar.z(vVar.dl(), new iq.z().z(iq.gc).z(vVar.m().g(), vVar.m().z(), hh.z(q.z("multipart/form-data"), vVar.m().gc)).z());
            } else if (g(vVar.m())) {
                zVar.z(vVar.dl(), hh.z(q.z(vVar.m().dl.toString()), vVar.m().gc));
            }
        }
        if (vVar.gc() != null && vVar.gc().z) {
            zVar.z(new a.z().z().dl());
        }
        if (vVar.a() != null && vVar.a().size() > 0) {
            for (Map.Entry<String, List<String>> entry : vVar.a().entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    zVar.z(entry.getKey(), it.next());
                }
            }
        }
        return new a(this.wp.z(zVar.z()));
    }

    private boolean z(pf pfVar) {
        return pfVar != null && pfVar.m == pf.z.FILE_TYPE && pfVar.gc != null && pfVar.gc.length > 0;
    }

    private boolean g(pf pfVar) {
        return pfVar != null && pfVar.m == pf.z.BYTE_ARRAY_TYPE && pfVar.gc != null && pfVar.gc.length > 0;
    }

    private boolean dl(pf pfVar) {
        return (pfVar == null || pfVar.m != pf.z.STRING_TYPE || TextUtils.isEmpty(pfVar.f719a)) ? false : true;
    }
}
