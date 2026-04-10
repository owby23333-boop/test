package ms.bz.bd.c.Pgl;

import java.util.Locale;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class k0 extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        String string;
        try {
            Locale locale = pgla.e().bf().getResources().getConfiguration().locale;
            String language = locale.getLanguage();
            String country = locale.getCountry();
            StringBuilder sb = new StringBuilder();
            sb.append(language);
            sb.append((String) pblk.a(16777217, 0, 0L, "cf4e5f", new byte[]{77}));
            sb.append(country);
            string = sb.toString();
        } catch (Throwable unused) {
            string = null;
        }
        return n1.e(string);
    }
}
