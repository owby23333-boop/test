package ms.bz.bd.c.Pgl;

import java.io.File;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class pble extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        File file = new File(pgla.e().bf().getFilesDir(), (String) pblk.a(16777217, 0, 0L, "b597e6", new byte[]{Base64.padSymbol, 58, 89, 71, 91, 53, 96}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
