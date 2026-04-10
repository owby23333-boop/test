package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import java.util.Locale;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class l0 extends pbly.pgla {
    l0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(long j, String str, Object obj) throws Throwable {
        String str2;
        try {
            Locale locale = pblv.z().g().getResources().getConfiguration().locale;
            str2 = locale.getLanguage() + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5fed00", new byte[]{Ascii.ESC})) + locale.getCountry();
        } catch (Throwable unused) {
            str2 = null;
        }
        return q1.z(str2);
    }
}
