package com.bytedance.sdk.component.dl.g.z.z;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.component.dl.g.fv;
import com.bytedance.sdk.component.dl.g.gk;
import com.bytedance.sdk.component.dl.g.h;
import com.bytedance.sdk.component.dl.g.io;
import com.bytedance.sdk.component.dl.g.sy;
import com.bytedance.sdk.component.dl.g.tb;
import com.bytedance.sdk.component.dl.g.z.dl.gz;
import com.bytedance.sdk.component.dl.g.z.z.dl;
import com.bytedance.sdk.component.dl.z.fv;
import com.bytedance.sdk.component.dl.z.js;
import com.bytedance.sdk.component.dl.z.wp;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements tb {
    final m z;

    public z(m mVar) {
        this.z = mVar;
    }

    @Override // com.bytedance.sdk.component.dl.g.tb
    public h z(tb.z zVar) throws IOException {
        m mVar = this.z;
        h hVarZ = mVar != null ? mVar.z(zVar.z()) : null;
        dl dlVarZ = new dl.z(System.currentTimeMillis(), zVar.z(), hVarZ).z();
        sy syVar = dlVarZ.z;
        h hVar = dlVarZ.g;
        if (hVarZ != null && hVar == null) {
            com.bytedance.sdk.component.dl.g.z.dl.z(hVarZ.gz());
        }
        if (syVar == null && hVar == null) {
            return new h.z().z(zVar.z()).z(io.HTTP_1_1).z(TypedValues.Position.TYPE_PERCENT_HEIGHT).z("Unsatisfiable Request (only-if-cached)").z(com.bytedance.sdk.component.dl.g.z.dl.dl).z(-1L).g(System.currentTimeMillis()).z();
        }
        if (syVar == null) {
            return hVar.fo().g(z(hVar)).z();
        }
        try {
            h hVarZ2 = zVar.z(syVar);
            if (hVarZ2 == null && hVarZ != null) {
            }
            if (hVar != null) {
                if (hVarZ2.dl() == 304) {
                    h hVarZ3 = hVar.fo().z(z(hVar.e(), hVarZ2.e())).z(hVarZ2.i()).g(hVarZ2.v()).g(z(hVar)).z(z(hVarZ2)).z();
                    hVarZ2.gz().close();
                    this.z.update(hVar, hVarZ3);
                    return hVarZ3;
                }
                com.bytedance.sdk.component.dl.g.z.dl.z(hVar.gz());
            }
            h hVarZ4 = hVarZ2.fo().g(z(hVar)).z(z(hVarZ2)).z();
            if (this.z != null) {
                if (com.bytedance.sdk.component.dl.g.z.dl.gc.dl(hVarZ4) && dl.z(hVarZ4, syVar)) {
                    return z(this.z.z(hVarZ4), hVarZ4);
                }
                com.bytedance.sdk.component.dl.g.z.dl.m.z(syVar.g());
            }
            return hVarZ4;
        } finally {
            if (hVarZ != null) {
                com.bytedance.sdk.component.dl.g.z.dl.z(hVarZ.gz());
            }
        }
    }

    private static h z(h hVar) {
        return (hVar == null || hVar.gz() == null) ? hVar : hVar.fo().z((gk) null).z();
    }

    private h z(final g gVar, h hVar) throws IOException {
        fv fvVarZ;
        if (gVar == null || (fvVarZ = gVar.z()) == null) {
            return hVar;
        }
        final com.bytedance.sdk.component.dl.z.gc gcVarDl = hVar.gz().dl();
        final com.bytedance.sdk.component.dl.z.a aVarZ = wp.z(fvVarZ);
        return hVar.fo().z(new gz(hVar.z(HttpHeaders.CONTENT_TYPE), hVar.gz().g(), wp.z(new js() { // from class: com.bytedance.sdk.component.dl.g.z.z.z.1
            boolean z;

            @Override // com.bytedance.sdk.component.dl.z.js
            public long z(com.bytedance.sdk.component.dl.z.dl dlVar, long j) throws IOException {
                try {
                    long jZ = gcVarDl.z(dlVar, j);
                    if (jZ == -1) {
                        if (!this.z) {
                            this.z = true;
                            aVarZ.close();
                        }
                        return -1L;
                    }
                    dlVar.z(aVarZ.dl(), dlVar.g() - jZ, jZ);
                    aVarZ.q();
                    return jZ;
                } catch (IOException e) {
                    if (!this.z) {
                        this.z = true;
                    }
                    throw e;
                }
            }

            @Override // com.bytedance.sdk.component.dl.z.js
            public com.bytedance.sdk.component.dl.z.tb z() {
                return gcVarDl.z();
            }

            @Override // com.bytedance.sdk.component.dl.z.js, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.z && !com.bytedance.sdk.component.dl.g.z.dl.z(this, 100, TimeUnit.MILLISECONDS)) {
                    this.z = true;
                }
                gcVarDl.close();
            }
        }))).z();
    }

    private static com.bytedance.sdk.component.dl.g.fv z(com.bytedance.sdk.component.dl.g.fv fvVar, com.bytedance.sdk.component.dl.g.fv fvVar2) {
        fv.z zVar = new fv.z();
        int iZ = fvVar.z();
        for (int i = 0; i < iZ; i++) {
            String strZ = fvVar.z(i);
            String strG = fvVar.g(i);
            if ((!HttpHeaders.WARNING.equalsIgnoreCase(strZ) || !strG.startsWith("1")) && (!z(strZ) || fvVar2.z(strZ) == null)) {
                com.bytedance.sdk.component.dl.g.z.z.z.z(zVar, strZ, strG);
            }
        }
        int iZ2 = fvVar2.z();
        for (int i2 = 0; i2 < iZ2; i2++) {
            String strZ2 = fvVar2.z(i2);
            if (!HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(strZ2) && z(strZ2)) {
                com.bytedance.sdk.component.dl.g.z.z.z.z(zVar, strZ2, fvVar2.g(i2));
            }
        }
        return zVar.z();
    }

    static boolean z(String str) {
        return (HttpHeaders.CONNECTION.equalsIgnoreCase(str) || HttpHeaders.KEEP_ALIVE.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) || HttpHeaders.TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(str) || HttpHeaders.UPGRADE.equalsIgnoreCase(str)) ? false : true;
    }
}
