package com.bytedance.adsdk.ugeno.gc.z;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private volatile Map<String, dl> z = new HashMap();

    public dl z(String str) {
        if (this.z.containsKey(str) && this.z.get(str) != null) {
            return this.z.get(str);
        }
        g gVar = new g();
        this.z.put(str, gVar);
        return gVar;
    }

    public void z(String str, dl dlVar) {
        if (!this.z.containsKey(str) || this.z.get(str) == null) {
            this.z.put(str, dlVar);
        }
    }
}
