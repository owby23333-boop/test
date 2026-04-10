package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.common.base.Ascii;
import java.util.Map;
import ms.bz.bd.c.Pgl.pblb;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
final class pblh extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        String string;
        Context contextBf = pgla.e().bf();
        ApplicationInfo applicationInfo = contextBf.getPackageManager().getApplicationInfo(contextBf.getPackageName(), 0);
        String str2 = applicationInfo.sourceDir;
        if (str2 == null) {
            str2 = applicationInfo.publicSourceDir;
        }
        Map<Integer, String> mapE = pblx.e(str2);
        String string2 = "";
        String str3 = (mapE == null || !mapE.containsKey(1903654775)) ? "" : mapE.get(1903654775);
        if (str3 != null && str3.length() > 0) {
            JSONObject jSONObject = new JSONObject(str3);
            try {
                string = jSONObject.getString((String) pblk.a(16777217, 0, 0L, "b0300f", new byte[]{126, 55, 84, 69, 48, 100, 108, Ascii.DC4, 108, 103, 76, 49, 72, 69, 1, 127, 100, Ascii.GS}));
            } catch (JSONException unused) {
                string = "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append((String) pblk.a(16777217, 0, 0L, "d71b6d", new byte[]{46}));
            try {
                string2 = jSONObject.getString((String) pblk.a(16777217, 0, 0L, "29e08e", new byte[]{49, 62, Ascii.SUB, 65, 6, 97, 52, 39, 54, 117, 42, 55, 18}));
            } catch (JSONException unused2) {
            }
            sb.append(string2);
            string2 = sb.toString();
        }
        return string2.length() == 0 ? (String) pblk.a(16777217, 0, 0L, "95e576", new byte[]{6, 56, Ascii.CAN, 68}) : string2;
    }
}
