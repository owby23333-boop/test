package com.bytedance.sdk.openadsdk.core.un;

import android.content.Intent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pf {
    private static volatile pf z;
    private com.bytedance.sdk.component.a.g.dl g;

    public static pf z() {
        if (z == null) {
            synchronized (pf.class) {
                if (z == null) {
                    z = new pf();
                }
            }
        }
        return z;
    }

    public void z(Intent intent) {
        final boolean z2 = (intent.getFlags() & 8388608) == 8388608;
        com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.pf.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                int i2 = pf.this.g().get("all_activity_count", 0) + 1;
                if (z2) {
                    int i3 = pf.this.g().get("hide_activity_count", 0) + 1;
                    if (i3 >= 10) {
                        pf.this.z(i2);
                        i2 = 0;
                    } else {
                        i = i3;
                    }
                    pf.this.g().put("hide_activity_count", i);
                }
                pf.this.g().put("all_activity_count", i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.a.g.dl g() {
        if (this.g == null) {
            this.g = x.z("hide_recent_activity_recorder");
        }
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final int i) {
        try {
            com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.un.pf.2
                @Override // com.bytedance.sdk.openadsdk.kb.z.z
                public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ac", i);
                    return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("hide_activity_record").g(jSONObject.toString());
                }
            }, "hide_activity_record");
        } catch (Throwable unused) {
        }
    }
}
