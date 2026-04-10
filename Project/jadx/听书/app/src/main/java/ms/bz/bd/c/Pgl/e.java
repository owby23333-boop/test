package ms.bz.bd.c.Pgl;

import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class e extends pbly.pgla {
    e() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(long j, String str, Object obj) throws Throwable {
        int iZ;
        l1 l1VarZ = l1.z(pblv.z().g());
        l1VarZ.getClass();
        try {
            synchronized (l1VarZ) {
                iZ = l1VarZ.z();
            }
        } catch (Exception unused) {
            iZ = -1;
        }
        return "" + iZ;
    }
}
