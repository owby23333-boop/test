package com.bytedance.sdk.component.dl.g.z.dl;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.component.dl.g.h;
import com.bytedance.sdk.component.dl.g.sy;
import com.bytedance.sdk.component.dl.g.tb;
import com.bytedance.sdk.component.dl.z.fv;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements tb {
    private final boolean z;

    public g(boolean z2) {
        this.z = z2;
    }

    @Override // com.bytedance.sdk.component.dl.g.tb
    public h z(tb.z zVar) throws IOException {
        h hVarZ;
        e eVar = (e) zVar;
        dl dlVarE = eVar.e();
        com.bytedance.sdk.component.dl.g.z.g.e eVarM = eVar.m();
        com.bytedance.sdk.component.dl.g.z.g.dl dlVar = (com.bytedance.sdk.component.dl.g.z.g.dl) eVar.gc();
        sy syVarZ = eVar.z();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (syVarZ != null && syVarZ.m != null) {
            syVarZ.m.z(jCurrentTimeMillis);
        }
        eVar.call();
        dlVarE.z(syVarZ);
        eVar.call();
        h.z zVarZ = null;
        if (m.dl(syVarZ.g()) && syVarZ.a() != null) {
            if ("100-continue".equalsIgnoreCase(syVarZ.z(HttpHeaders.EXPECT))) {
                dlVarE.z();
                eVar.call();
                zVarZ = dlVarE.z(true);
            }
            if (zVarZ == null) {
                eVar.call();
                com.bytedance.sdk.component.dl.z.a aVarZ = com.bytedance.sdk.component.dl.z.wp.z(new z(dlVarE.z(syVarZ, syVarZ.a().g())));
                syVarZ.a().z(aVarZ);
                aVarZ.close();
                eVar.call();
            } else if (!dlVar.gc()) {
                eVarM.a();
            }
        }
        dlVarE.g();
        if (zVarZ == null) {
            eVar.call();
            zVarZ = dlVarE.z(false);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (syVarZ.m != null) {
            syVarZ.m.g(jCurrentTimeMillis2);
        }
        h hVarZ2 = zVarZ.z(syVarZ).z(eVarM.g().a()).z(jCurrentTimeMillis).g(jCurrentTimeMillis2).z();
        eVar.call();
        int iDl = hVarZ2.dl();
        if (this.z && iDl == 101) {
            hVarZ = hVarZ2.fo().z(com.bytedance.sdk.component.dl.g.z.dl.dl).z();
        } else {
            hVarZ = hVarZ2.fo().z(dlVarE.z(hVarZ2)).z();
        }
        if (ILivePush.ClickType.CLOSE.equalsIgnoreCase(hVarZ.z().z(HttpHeaders.CONNECTION)) || ILivePush.ClickType.CLOSE.equalsIgnoreCase(hVarZ.z(HttpHeaders.CONNECTION))) {
            eVarM.a();
        }
        if ((iDl == 204 || iDl == 205) && hVarZ.gz().g() > 0) {
            throw new ProtocolException("HTTP " + iDl + " had non-zero Content-Length: " + hVarZ.gz().g());
        }
        return hVarZ;
    }

    static final class z extends com.bytedance.sdk.component.dl.z.e {
        long z;

        z(fv fvVar) {
            super(fvVar);
        }

        @Override // com.bytedance.sdk.component.dl.z.e, com.bytedance.sdk.component.dl.z.fv
        public void a_(com.bytedance.sdk.component.dl.z.dl dlVar, long j) throws IOException {
            super.a_(dlVar, j);
            this.z += j;
        }
    }
}
