package ms.bz.bd.c.Pgl;

import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class r extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        return pgla.e().bf().getSharedPreferences(str, 0).getString((String) obj, null);
    }
}
