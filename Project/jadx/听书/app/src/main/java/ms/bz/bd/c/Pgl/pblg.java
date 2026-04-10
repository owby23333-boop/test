package ms.bz.bd.c.Pgl;

import android.os.Build;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class pblg {
    private static HashMap g() {
        HashMap map = new HashMap();
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f29f6f", new byte[]{38}), Build.MODEL);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "98c1b3", new byte[]{122}), Build.BRAND);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "19172b", new byte[]{115}), Build.BOARD);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3b5625", new byte[]{118}), Build.VERSION.RELEASE);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "919dd7", new byte[]{125}), Build.DISPLAY);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "777ec4", new byte[]{112}), Build.HARDWARE);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f491a0", new byte[]{32}), Build.FINGERPRINT);
        return map;
    }

    public static String z() {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap mapG = g();
            for (String str : mapG.keySet()) {
                jSONObject.put(str, mapG.get(str));
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "091f3c", new byte[]{58, 38});
        }
    }
}
