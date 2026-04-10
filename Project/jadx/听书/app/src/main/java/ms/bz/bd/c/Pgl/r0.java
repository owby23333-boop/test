package ms.bz.bd.c.Pgl;

import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class r0 extends pbly.pgla {
    r0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(long j, String str, Object obj) throws Throwable {
        boolean zG;
        try {
            zG = v0.g(pblv.z().g(), str, obj.toString());
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2a2451", new byte[]{36, 98, 71});
            zG = false;
        }
        if (zG) {
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7c0a5b", new byte[]{9, 74});
        }
        return null;
    }
}
