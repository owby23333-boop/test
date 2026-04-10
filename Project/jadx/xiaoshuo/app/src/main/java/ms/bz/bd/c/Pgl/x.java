package ms.bz.bd.c.Pgl;

import java.util.Arrays;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class x extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        Throwable thBf = m1.e().bf();
        return thBf != null ? Arrays.toString(thBf.getStackTrace()) : "";
    }
}
