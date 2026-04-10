package com.bytedance.msdk.core.gz;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class uy {
    private static final String z = "TTMediationSDK_uy";
    private com.bytedance.msdk.gc.z.dl<fo> dl;
    private Map<String, fo> g;

    private uy() {
        this.dl = new com.bytedance.msdk.gc.z.a(com.bytedance.msdk.core.g.getContext());
        this.g = new ConcurrentHashMap();
    }

    public static uy z() {
        return z.z;
    }

    private static class z {
        private static uy z = new uy();
    }

    public void z(String str, long j) {
        if (this.dl != null) {
            Map<String, fo> map = this.g;
            fo foVar = map != null ? map.get(str) : null;
            if (foVar != null) {
                foVar.z(j);
            }
            this.dl.z(str, j);
        }
    }

    public void z(String str, String str2, long j) {
        if (this.dl != null) {
            Map<String, fo> map = this.g;
            fo foVar = map != null ? map.get(str + "_" + str2) : null;
            if (foVar != null) {
                foVar.z(j);
            }
            this.dl.z(str, str2, j);
        }
    }

    public void z(String str) {
        if (this.dl != null) {
            Map<String, fo> map = this.g;
            if (map != null) {
                map.remove(str);
            }
            this.dl.delete(str);
        }
    }

    public void z(String str, String str2) {
        if (this.dl != null) {
            Map<String, fo> map = this.g;
            if (map != null) {
                map.remove(str + "_" + str2);
            }
            this.dl.delete(str, str2);
        }
    }

    public void z(fo foVar) {
        if (this.dl == null || TextUtils.isEmpty(foVar.uy())) {
            return;
        }
        Map<String, fo> map = this.g;
        if (map != null) {
            map.put(foVar.a(), foVar);
        }
        this.dl.g(foVar);
    }

    public fo g(String str) {
        if (this.dl == null) {
            return null;
        }
        Map<String, fo> map = this.g;
        fo foVar = map != null ? map.get(str) : null;
        if (foVar != null) {
            return foVar;
        }
        fo foVarQuery = this.dl.query(str);
        if (foVarQuery != null) {
            this.g.put(foVarQuery.g(), foVarQuery);
        }
        return foVarQuery;
    }

    public fo g(String str, String str2) {
        if (this.dl == null) {
            return null;
        }
        Map<String, fo> map = this.g;
        fo foVar = map != null ? map.get(str + "_" + str2) : null;
        if (foVar != null) {
            return foVar;
        }
        fo foVarQuery = this.dl.query(str, str2);
        if (foVarQuery != null) {
            this.g.put(foVarQuery.a(), foVarQuery);
        }
        return foVarQuery;
    }
}
