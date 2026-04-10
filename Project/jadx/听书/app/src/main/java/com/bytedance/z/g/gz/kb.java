package com.bytedance.z.g.gz;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class kb {
    public static void z(com.bytedance.z.g.dl.z zVar, com.bytedance.z.g.dl.g gVar, com.bytedance.z.g.dl dlVar) {
        if (zVar == null || zVar.z() == null || dlVar == null) {
            return;
        }
        JSONObject jSONObjectZ = zVar.z();
        long jOptLong = jSONObjectZ.optLong("crash_time");
        int iG = g(z("aid"));
        String strZ = com.bytedance.z.g.gz.dl().z();
        if (jOptLong <= 0 || iG <= 0 || TextUtils.isEmpty(strZ) || "0".equals(strZ) || TextUtils.isEmpty(dlVar.z())) {
            return;
        }
        try {
            String str = "android_" + iG + "_" + strZ + "_" + jOptLong + "_" + dlVar;
            if (gVar != null) {
                JSONObject jSONObjectZ2 = gVar.z();
                if (jSONObjectZ2 != null) {
                    jSONObjectZ2.put("unique_key", str);
                    return;
                }
                return;
            }
            jSONObjectZ.put("unique_key", str);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    public static String z(String str) {
        Map<String, Object> mapZ;
        if (com.bytedance.z.g.gz.z() == null || (mapZ = com.bytedance.z.g.gz.z().z()) == null) {
            return null;
        }
        Object obj = mapZ.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static int g(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            uy.g(e);
            return 0;
        }
    }
}
