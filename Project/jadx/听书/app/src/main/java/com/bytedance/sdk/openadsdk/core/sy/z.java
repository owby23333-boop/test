package com.bytedance.sdk.openadsdk.core.sy;

import com.bytedance.sdk.openadsdk.core.un.x;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z z;
    private Map<String, g> g = new HashMap();

    private z() {
        z(com.bytedance.sdk.openadsdk.core.sy.dl.z.dl());
        z(com.bytedance.sdk.openadsdk.core.sy.z.z.z());
        z(com.bytedance.sdk.openadsdk.core.sy.a.z.dl());
        z(com.bytedance.sdk.openadsdk.core.sy.gc.z.z());
        z(com.bytedance.sdk.openadsdk.core.i.g.z());
    }

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    private void z(g gVar) {
        this.g.put(gVar.g(), gVar);
    }

    public String z(String str, String str2) {
        if (this.g.containsKey(str)) {
            return this.g.get(str).z(str2);
        }
        return x.z(str).get(str2, "");
    }

    public void z(String str, String str2, String str3) {
        if (this.g.containsKey(str)) {
            this.g.get(str).z(str2, str3);
        } else {
            x.z(str).put(str2, str3);
        }
    }
}
