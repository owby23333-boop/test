package com.bytedance.sdk.openadsdk.core.zw;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.q.v;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    static HashSet<String> z = new HashSet<>();

    public static void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        z.add(str);
    }

    public static void g(final String str) {
        if (TextUtils.isEmpty(str) || !z.contains(str)) {
            return;
        }
        z.remove(str);
        v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.zw.z.1
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("union_key", str);
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("listener_process_but_not_register").g(jSONObject.toString());
            }
        }, "listener_process_but_not_register");
    }
}
