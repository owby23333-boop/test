package com.bytedance.sdk.component.kb.e;

import com.bytedance.sdk.component.kb.a.a;
import com.bytedance.sdk.component.kb.z.g;
import com.bytedance.sdk.component.kb.z.z.dl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z g;
    private Map<String, com.bytedance.sdk.component.kb.z.z.z> z = new HashMap();

    private z() {
    }

    public static z z() {
        if (g != null) {
            return g;
        }
        synchronized (z.class) {
            if (g != null) {
                return g;
            }
            z zVar = new z();
            g = zVar;
            return zVar;
        }
    }

    public void z(String str, com.bytedance.sdk.component.kb.z.z.z zVar) {
        this.z.put(str, zVar);
    }

    public void z(String str, com.bytedance.sdk.component.kb.z.z zVar, com.bytedance.sdk.component.kb.a.z zVar2) {
        com.bytedance.sdk.component.kb.z.z.z zVarZ = this.z.get(str);
        if (zVarZ == null || zVar == null) {
            return;
        }
        Map<String, Object> mapZ = zVar.z();
        a aVarGc = zVar.gc();
        if (aVarGc instanceof g) {
            Map<String, Object> mapZ2 = com.bytedance.sdk.component.kb.gc.z.z().z(String.valueOf(aVarGc.hashCode()));
            mapZ.putAll(mapZ2);
            mapZ2.clear();
            com.bytedance.sdk.component.kb.m.z zVarZ2 = com.bytedance.sdk.component.kb.m.z.z();
            zVarZ = zVarZ2.z(zVarZ);
            HashMap map = new HashMap();
            map.putAll(zVar.g());
            map.putAll(mapZ);
            zVarZ2.z(zVarZ, map);
        }
        if (zVarZ instanceof dl) {
            ((dl) zVarZ).z(zVar.g(), zVar.z(), zVar);
        } else if (zVarZ instanceof com.bytedance.sdk.component.kb.z.z.g) {
            ((com.bytedance.sdk.component.kb.z.z.g) zVarZ).z(zVar.g(), zVar.z(), zVar);
        }
    }
}
