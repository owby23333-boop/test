package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import java.io.File;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class pblz extends pbly.pgla {
    pblz() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(long j, String str, Object obj) throws Throwable {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.g.z(pblv.z().g()), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9efb08", new byte[]{102, 106, 6, Ascii.DC2, 14, 59, 59}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
