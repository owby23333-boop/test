package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private Map<String, g> a;
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.c<g> b;

    private static class b {
        private static h a = new h();
    }

    static {
        String str = "TTMediationSDK_" + h.class.getSimpleName();
    }

    private h() {
        this.b = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.d(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
        this.a = new ConcurrentHashMap();
    }

    public static h a() {
        return b.a;
    }

    public void a(g gVar) {
        e eVar;
        g gVarB = gVar.h() ? b(gVar.d(), gVar.c()) : b(gVar.d());
        if (gVarB == null) {
            if (this.b != null) {
                Map<String, g> map = this.a;
                if (map != null) {
                    map.put(gVar.g(), gVar);
                }
                this.b.a(gVar);
                return;
            }
            return;
        }
        HashMap map2 = new HashMap();
        for (e eVar2 : gVarB.i()) {
            map2.put(eVar2.d(), eVar2);
        }
        for (e eVar3 : gVar.i()) {
            if (map2.containsKey(eVar3.d()) && (eVar = (e) map2.get(eVar3.d())) != null) {
                eVar3.a(eVar);
            }
        }
        Map<String, g> map3 = this.a;
        if (map3 != null) {
            map3.put(gVar.g(), gVar);
        }
        b(gVar);
    }

    public void a(g gVar, String str, int i2) {
        if (this.b != null) {
            gVar.a(str, i2);
            Map<String, g> map = this.a;
            if (map != null) {
                map.put(gVar.g(), gVar);
            }
            this.b.b(gVar);
        }
    }

    public void a(g gVar, String str, long j2) {
        if (this.b != null) {
            gVar.a(str, j2);
            Map<String, g> map = this.a;
            if (map != null) {
                map.put(gVar.g(), gVar);
            }
            this.b.b(gVar);
        }
    }

    public void a(String str) {
        if (this.b != null) {
            Map<String, g> map = this.a;
            if (map != null) {
                map.remove(str);
            }
            this.b.a(str);
        }
    }

    public void a(String str, String str2) {
        if (this.b != null) {
            Map<String, g> map = this.a;
            if (map != null) {
                map.remove(str + "_" + str2);
            }
            this.b.a(str, str2);
        }
    }

    public g b(String str) {
        if (this.b != null) {
            Map<String, g> map = this.a;
            g gVar = map != null ? map.get(str) : null;
            if (gVar != null) {
                return gVar;
            }
            g gVarB = this.b.b(str);
            if (gVarB != null) {
                Map<String, g> map2 = this.a;
                if (map2 == null) {
                    return gVarB;
                }
                map2.put(gVarB.g(), gVarB);
                return gVarB;
            }
        }
        return null;
    }

    public g b(String str, String str2) {
        g gVar;
        if (this.b != null) {
            Map<String, g> map = this.a;
            if (map != null) {
                gVar = map.get(str + "_" + str2);
            } else {
                gVar = null;
            }
            if (gVar != null) {
                return gVar;
            }
            g gVarB = this.b.b(str, str2);
            if (gVarB != null) {
                Map<String, g> map2 = this.a;
                if (map2 == null) {
                    return gVarB;
                }
                map2.put(gVarB.g(), gVarB);
                return gVarB;
            }
        }
        return null;
    }

    public void b(g gVar) {
        if (this.b != null) {
            Map<String, g> map = this.a;
            if (map != null) {
                map.put(gVar.g(), gVar);
            }
            this.b.b(gVar);
        }
    }
}
