package com.bytedance.msdk.core.gz;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    private static final String z = "TTMediationSDK_gz";
    private com.bytedance.msdk.gc.z.z<e> dl;
    private Map<String, e> g;

    private gz() {
        this.dl = new com.bytedance.msdk.gc.z.g(com.bytedance.msdk.core.g.getContext());
        this.g = new ConcurrentHashMap();
    }

    public static gz z() {
        return z.z;
    }

    private static class z {
        private static gz z = new gz();
    }

    public void z(String str) {
        if (this.dl != null) {
            Map<String, e> map = this.g;
            if (map != null) {
                map.remove(str);
            }
            this.dl.delete(str);
        }
    }

    public void z(String str, String str2) {
        if (this.dl != null) {
            Map<String, e> map = this.g;
            if (map != null) {
                map.remove(str + "_" + str2);
            }
            this.dl.delete(str, str2);
        }
    }

    public void z(e eVar) {
        e eVarG;
        gc gcVar;
        if (eVar.z()) {
            eVarG = g(eVar.g(), eVar.dl());
        } else {
            eVarG = g(eVar.g());
        }
        if (eVarG == null) {
            if (this.dl != null) {
                Map<String, e> map = this.g;
                if (map != null) {
                    map.put(eVar.a(), eVar);
                }
                this.dl.g(eVar);
                return;
            }
            return;
        }
        HashMap map2 = new HashMap();
        for (gc gcVar2 : eVarG.kb()) {
            map2.put(gcVar2.dl(), gcVar2);
        }
        for (gc gcVar3 : eVar.kb()) {
            if (map2.containsKey(gcVar3.dl()) && (gcVar = (gc) map2.get(gcVar3.dl())) != null) {
                gcVar3.z(gcVar);
            }
        }
        Map<String, e> map3 = this.g;
        if (map3 != null) {
            map3.put(eVar.a(), eVar);
        }
        g(eVar);
    }

    public e g(String str) {
        if (this.dl != null) {
            Map<String, e> map = this.g;
            e eVar = map != null ? map.get(str) : null;
            if (eVar != null) {
                return eVar;
            }
            e eVarQuery = this.dl.query(str);
            if (eVarQuery != null) {
                Map<String, e> map2 = this.g;
                if (map2 != null) {
                    map2.put(eVarQuery.a(), eVarQuery);
                }
                return eVarQuery;
            }
        }
        return null;
    }

    public e g(String str, String str2) {
        if (this.dl != null) {
            Map<String, e> map = this.g;
            e eVar = map != null ? map.get(str + "_" + str2) : null;
            if (eVar != null) {
                return eVar;
            }
            e eVarQuery = this.dl.query(str, str2);
            if (eVarQuery != null) {
                Map<String, e> map2 = this.g;
                if (map2 != null) {
                    map2.put(eVarQuery.a(), eVarQuery);
                }
                return eVarQuery;
            }
        }
        return null;
    }

    public void g(e eVar) {
        if (this.dl != null) {
            Map<String, e> map = this.g;
            if (map != null) {
                map.put(eVar.a(), eVar);
            }
            this.dl.z(eVar);
        }
    }

    public void z(e eVar, String str, int i) {
        if (this.dl != null) {
            eVar.z(str, i);
            Map<String, e> map = this.g;
            if (map != null) {
                map.put(eVar.a(), eVar);
            }
            this.dl.z(eVar);
        }
    }

    public void z(e eVar, String str, long j) {
        if (this.dl != null) {
            eVar.z(str, j);
            Map<String, e> map = this.g;
            if (map != null) {
                map.put(eVar.a(), eVar);
            }
            this.dl.z(eVar);
        }
    }
}
