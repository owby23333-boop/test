package com.bytedance.sdk.openadsdk.core.un;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class tb {
    private static long g = -1;
    private static final String z = null;

    public static JSONArray z(final Context context) {
        if (System.currentTimeMillis() - g <= 1000) {
            return null;
        }
        g = System.currentTimeMillis();
        if (!com.bytedance.sdk.openadsdk.core.gk.gz.a() || !g() || !com.bytedance.sdk.openadsdk.core.zw.g().kp() || !com.bytedance.sdk.openadsdk.core.uy.ls().p().g()) {
            return null;
        }
        com.bytedance.sdk.component.uy.e.z(new com.bytedance.sdk.component.uy.fo("getIncrementalInstallApps") { // from class: com.bytedance.sdk.openadsdk.core.un.tb.1
            @Override // java.lang.Runnable
            public void run() {
                tb.dl(context);
            }
        }, 1);
        return z();
    }

    private static JSONArray z() {
        try {
            String str = com.bytedance.sdk.openadsdk.core.g.z().get("install_app_incremental_string", z);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new JSONArray((Collection) a(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dl(Context context) {
        try {
            List<String> listZ = com.bytedance.sdk.openadsdk.core.gk.dl.z().z(context);
            if (listZ != null && !listZ.isEmpty()) {
                List<String> listA = a(com.bytedance.sdk.openadsdk.core.g.z().get("install_app_string", z));
                g(z(listZ));
                if (listA != null && !listA.isEmpty()) {
                    listZ.removeAll(listA);
                }
                dl(z(listZ));
            }
        } catch (Exception unused) {
        }
    }

    private static void g(String str) {
        com.bytedance.sdk.openadsdk.core.g.z().put("install_app_string", str);
    }

    private static void dl(String str) {
        com.bytedance.sdk.component.a.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.g.z();
        dlVarZ.put("install_app_incremental_string", str);
        dlVarZ.put("apptime", System.currentTimeMillis());
    }

    private static boolean g() {
        long j = com.bytedance.sdk.openadsdk.core.g.z().get("apptime", -1L);
        return j == -1 || System.currentTimeMillis() - j > 43200000;
    }

    private static List<String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    private static String z(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString().trim();
    }

    public static boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            z(0, 0, null);
            return false;
        }
        if (eo.g(com.bytedance.sdk.openadsdk.core.zw.getContext()) && !eo.dl(com.bytedance.sdk.openadsdk.core.zw.getContext(), str)) {
            z(0, 0, null);
        }
        return false;
    }

    private static void z(final int i, final int i2, final String str) {
        com.bytedance.sdk.openadsdk.core.q.g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.un.tb.2
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("call_api_status", i);
                    jSONObject.put("has_actived", i2);
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("error_msg", str);
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("call_active_api").g(jSONObject.toString());
            }
        }, "call_active_api", true);
    }
}
