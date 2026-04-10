package ms.bz.bd.c.Pgl;

import java.util.UUID;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class t extends pbly.pgla {
    t() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object z(long j, String str, Object obj) throws Throwable {
        return UUID.randomUUID().toString();
    }
}
