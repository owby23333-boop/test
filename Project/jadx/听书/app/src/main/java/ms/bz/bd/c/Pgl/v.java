package ms.bz.bd.c.Pgl;

import java.util.Arrays;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class v extends pbly.pgla {
    v() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object z(long j, String str, Object obj) throws Throwable {
        Throwable thG = p1.z().g();
        return thG != null ? Arrays.toString(thG.getStackTrace()) : "";
    }
}
