package ms.bz.bd.c.Pgl;

import java.io.File;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class b extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        File file = new File(pgla.e().bf().getFilesDir(), (String) pblk.a(16777217, 0, 0L, "8ac2d2", new byte[]{103, 110, 3, 66, 90, 49, 58}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
