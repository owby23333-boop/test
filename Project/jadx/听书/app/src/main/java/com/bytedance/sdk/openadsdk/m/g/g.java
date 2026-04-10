package com.bytedance.sdk.openadsdk.m.g;

import com.bytedance.sdk.component.utils.wp;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static Map<String, Map<String, Map<String, Integer>>> z = new HashMap();

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void z(java.lang.String r2, com.bytedance.sdk.openadsdk.core.iq.na r3) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.m.g.g.z(java.lang.String, com.bytedance.sdk.openadsdk.core.iq.na):void");
    }

    private static void z(String str, String str2) {
        z(str, str2, "show_c");
    }

    private static void g(String str, String str2) {
        z(str, str2, "ps_c");
    }

    private static void dl(String str, String str2) {
        z(str, str2, "fpl_c");
    }

    private static void a(String str, String str2) {
        z(str, str2, "fo_c");
    }

    private static void gc(String str, String str2) {
        z(str, str2, "fpu_c");
    }

    private static void m(String str, String str2) {
        z(str, str2, "fb_c");
    }

    private static void e(String str, String str2) {
        z(str, str2, "pe_c");
    }

    private static void gz(String str, String str2) {
        z(str, str2, "lvs_c");
    }

    private static void fo(String str, String str2) {
        z(str, str2, "lvsu_c");
    }

    private static void uy(String str, String str2) {
        z(str, str2, "lve_c");
    }

    private static void kb(String str, String str2) {
        z(str, str2, "lvc_c");
    }

    private static void z(String str, String str2, String str3) {
        Map<String, Map<String, Integer>> map = z.get(str);
        if (map == null) {
            map = new HashMap<>();
            z.put(str, map);
        }
        Map<String, Integer> map2 = map.get(str2);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(str2, map2);
        }
        Integer num = map2.get(str3);
        if (num == null) {
            map2.put(str3, 1);
        } else {
            map2.put(str3, Integer.valueOf(num.intValue() + 1));
        }
    }

    public static JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        if (z.isEmpty()) {
            return jSONObject;
        }
        try {
            for (Map.Entry<String, Map<String, Map<String, Integer>>> entry : z.entrySet()) {
                String key = entry.getKey();
                Map<String, Map<String, Integer>> value = entry.getValue();
                JSONObject jSONObject2 = new JSONObject();
                if (value != null) {
                    for (Map.Entry<String, Map<String, Integer>> entry2 : value.entrySet()) {
                        String key2 = entry2.getKey();
                        Map<String, Integer> value2 = entry2.getValue();
                        JSONObject jSONObject3 = new JSONObject();
                        if (value2 != null) {
                            for (Map.Entry<String, Integer> entry3 : value2.entrySet()) {
                                jSONObject3.put(entry3.getKey(), entry3.getValue());
                            }
                        }
                        jSONObject2.put(key2, jSONObject3);
                    }
                }
                jSONObject.put(key, jSONObject2);
            }
        } catch (Exception e) {
            wp.z(e);
        }
        return jSONObject;
    }
}
