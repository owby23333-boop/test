package ms.bz.bd.c.Pgl;

import java.util.TimeZone;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class j0 extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        String id;
        int rawOffset;
        try {
            TimeZone timeZone = TimeZone.getDefault();
            id = timeZone.getID();
            try {
                rawOffset = ((timeZone.getRawOffset() / 60) / 60) / 1000;
            } catch (Throwable unused) {
                rawOffset = 0;
            }
        } catch (Throwable unused2) {
            id = null;
        }
        return id + ((String) pblk.a(16777217, 0, 0L, "4fb4d5", new byte[]{105})) + rawOffset;
    }
}
