package com.bytedance.msdk.m.g;

import com.bytedance.msdk.api.a.kb;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static volatile g dl;
    private final Map<String, com.bytedance.msdk.z.z.a> g = new ConcurrentHashMap();
    public kb z;

    public static g z() {
        if (dl == null) {
            synchronized (g.class) {
                if (dl == null) {
                    dl = new g();
                }
            }
        }
        return dl;
    }

    private g() {
    }

    public synchronized Map<String, com.bytedance.msdk.z.z.a> g() {
        return this.g;
    }

    public Collection<com.bytedance.msdk.z.z.a> dl() {
        return this.g.values();
    }

    public com.bytedance.msdk.z.z.a z(String str, kb kbVar) {
        this.z = kbVar;
        return z(str);
    }

    public synchronized com.bytedance.msdk.z.z.a z(String str) {
        com.bytedance.msdk.z.z.a aVarG;
        aVarG = g(str);
        if (aVarG == null) {
            com.bytedance.msdk.core.uy.z zVarZ = com.bytedance.msdk.core.g.g().z(str);
            if (zVarZ == null && this.z != null) {
                zVarZ = new com.bytedance.msdk.core.uy.z(this.z.gc(), this.z.dl(), this.z.a());
                this.z = null;
            }
            if (zVarZ != null && !zVarZ.gc()) {
                aVarG = dl(str);
            }
            if (aVarG != null) {
                z(str, aVarG);
            }
        }
        return aVarG;
    }

    private com.bytedance.msdk.z.z.a g(String str) {
        if (str == null) {
            return null;
        }
        return this.g.get(str);
    }

    private void z(String str, com.bytedance.msdk.z.z.a aVar) {
        if (str == null) {
            return;
        }
        this.g.put(str, aVar);
    }

    private com.bytedance.msdk.z.z.a dl(String str) {
        if (MediationConstant.ADN_PANGLE.equalsIgnoreCase(str)) {
            return new com.bytedance.msdk.z.dl.z();
        }
        return new a();
    }
}
