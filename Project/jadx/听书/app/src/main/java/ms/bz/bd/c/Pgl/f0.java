package ms.bz.bd.c.Pgl;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pbly;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
final class f0 extends pbly.pgla {
    f0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(long j, String str, Object obj) throws Throwable {
        Method declaredMethod;
        Context contextG = pblv.z().g();
        JSONArray jSONArray = new JSONArray();
        AccessibilityManager accessibilityManager = (AccessibilityManager) contextG.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "46f67d", new byte[]{36, 55, Ascii.SYN, 71, Ascii.ESC, 96, 62, Ascii.NAK, 62, 106, 44, 32, 12}));
        if (accessibilityManager != null) {
            try {
                declaredMethod = accessibilityManager.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c6daa2", new byte[]{117, 49, 3, 60, 80, 54, 116, Ascii.SYN, 57, Base64.padSymbol, 119, 48, 54, Ascii.SYN, 93, 32, 115, 4, 60, 51, 123, 56, Ascii.RS, 1, 71, Ascii.SYN, 101, 5, 35, 56, 113, 49, 59, Ascii.FS, 77, 49}), new Class[0]);
            } catch (Throwable unused) {
            }
            List<AccessibilityServiceInfo> list = declaredMethod != null ? (List) declaredMethod.invoke(accessibilityManager, new Object[0]) : null;
            if (list == null || list.size() == 0) {
                return jSONArray.toString();
            }
            for (AccessibilityServiceInfo accessibilityServiceInfo : list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d3ac60", new byte[]{112, 39}), accessibilityServiceInfo.eventTypes);
                    jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6eb54c", new byte[]{46, 99}), accessibilityServiceInfo.getId());
                    jSONArray.put(jSONObject);
                } catch (Throwable unused2) {
                }
            }
        }
        return jSONArray.toString();
    }
}
