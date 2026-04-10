package ms.bz.bd.c.Pgl;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.List;
import ms.bz.bd.c.Pgl.pblb;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
final class e0 extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        Method declaredMethod;
        Context contextBf = pgla.e().bf();
        JSONArray jSONArray = new JSONArray();
        AccessibilityManager accessibilityManager = (AccessibilityManager) contextBf.getSystemService((String) pblk.a(16777217, 0, 0L, "386ee0", new byte[]{35, 57, 70, Ascii.DC4, 73, 52, 57, Ascii.ESC, 110, 57, 43, 46, 92}));
        if (accessibilityManager != null) {
            try {
                declaredMethod = accessibilityManager.getClass().getDeclaredMethod((String) pblk.a(16777217, 0, 0L, "9047e1", new byte[]{47, 55, 83, 106, 84, 53, 46, 16, 105, 107, 45, 54, 102, 64, 89, 35, 41, 2, 108, 101, 33, 62, 78, 87, 67, Ascii.NAK, Utf8.REPLACEMENT_BYTE, 3, 115, 110, 43, 55, 107, 74, 73, 50}), new Class[0]);
            } catch (Throwable unused) {
            }
            List<AccessibilityServiceInfo> list = declaredMethod != null ? (List) declaredMethod.invoke(accessibilityManager, new Object[0]) : null;
            if (list == null || list.size() == 0) {
                return jSONArray.toString();
            }
            for (AccessibilityServiceInfo accessibilityServiceInfo : list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put((String) pblk.a(16777217, 0, 0L, "fad637", new byte[]{114, 117}), accessibilityServiceInfo.eventTypes);
                    jSONObject.put((String) pblk.a(16777217, 0, 0L, "6a313d", new byte[]{46, 103}), accessibilityServiceInfo.getId());
                    jSONArray.put(jSONObject);
                } catch (Throwable unused2) {
                }
            }
        }
        return jSONArray.toString();
    }
}
