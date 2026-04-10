package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.common.base.Ascii;
import java.util.HashMap;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pbly;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
final class t0 extends pbly.pgla {
    t0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(long j, String str, Object obj) throws Throwable {
        String string;
        Context contextG = pblv.z().g();
        ApplicationInfo applicationInfo = contextG.getPackageManager().getApplicationInfo(contextG.getPackageName(), 0);
        String str2 = applicationInfo.sourceDir;
        if (str2 == null) {
            str2 = applicationInfo.publicSourceDir;
        }
        HashMap mapZ = pblc.z(str2);
        String string2 = "";
        String str3 = (mapZ == null || !mapZ.containsKey(1903654775)) ? "" : (String) mapZ.get(1903654775);
        if (str3 != null && str3.length() > 0) {
            JSONObject jSONObject = new JSONObject(str3);
            try {
                string = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "70bbbb", new byte[]{43, 55, 5, Ascii.ETB, 98, 96, 57, Ascii.DC4, Base64.padSymbol, 53, Ascii.EM, 49, Ascii.EM, Ascii.ETB, 83, 123, 49, Ascii.GS}));
            } catch (JSONException unused) {
                string = "";
            }
            StringBuilder sbAppend = new StringBuilder().append(string).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "06e739", new byte[]{122}));
            try {
                string2 = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e412d9", new byte[]{102, 51, 78, 67, 90, Base64.padSymbol, 99, 42, 98, 119, 125, 58, 70}));
            } catch (JSONException unused2) {
            }
            string2 = sbAppend.append(string2).toString();
        }
        return string2.length() == 0 ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "53d452", new byte[]{10, 62, Ascii.EM, 69}) : string2;
    }
}
