package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import java.util.Locale;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class i extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        String string;
        try {
            Locale locale = pgla.e().bf().getResources().getConfiguration().locale;
            String language = locale.getLanguage();
            String country = locale.getCountry();
            StringBuilder sb = new StringBuilder();
            sb.append(language);
            sb.append((String) pblk.a(16777217, 0, 0L, "6b5472", new byte[]{Ascii.CAN}));
            sb.append(country);
            string = sb.toString();
        } catch (Throwable unused) {
            string = null;
        }
        return n1.e(string);
    }
}
