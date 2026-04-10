package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    public static void z(final String str, final String str2, final na naVar) {
        final long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        com.bytedance.sdk.openadsdk.core.q.v.z().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.gz.1
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z(gz.z(str)).dl(str2).m(eo.i(naVar)).z("dynamic_backup_render_new");
                gVarZ.z(jCurrentTimeMillis);
                return gVarZ;
            }
        }, "dynamic_backup_render_new");
    }

    public static void z(final int i, final String str, final String str2, final na naVar) {
        com.bytedance.sdk.openadsdk.core.q.v.z().gc(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.gz.2
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z(gz.z(str)).dl(str2).m(eo.i(naVar)).g(i).e(com.bytedance.sdk.openadsdk.core.fo.z(i));
            }
        });
    }

    public static int z(String str) {
        if (TextUtils.isEmpty(str)) {
            return 5;
        }
        str.hashCode();
        switch (str) {
        }
        return 5;
    }
}
