package com.bytedance.sdk.component.adexpress.z.g;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static volatile e z;
    private AtomicBoolean g = new AtomicBoolean(false);

    public interface z {
        void g();

        void z();
    }

    public static e z() {
        if (z == null) {
            synchronized (e.class) {
                if (z == null) {
                    z = new e();
                }
            }
        }
        return z;
    }

    private e() {
    }

    public com.bytedance.sdk.component.adexpress.z.dl.g z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m.z().z(str);
    }

    public Set<com.bytedance.sdk.component.adexpress.z.dl.g> g(String str) {
        return m.z().g(str);
    }

    private void g() {
        if (com.bytedance.sdk.component.adexpress.z.z.z.z().dl() == null) {
            return;
        }
        int iZ = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().z();
        if (iZ <= 0) {
            iZ = 100;
        }
        List<com.bytedance.sdk.component.adexpress.z.dl.g> listG = m.z().g();
        if (listG == null || listG.isEmpty() || iZ >= listG.size()) {
            if (listG != null) {
                listG.size();
                return;
            }
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.component.adexpress.z.dl.g gVar : listG) {
            treeMap.put(gVar.e(), gVar);
        }
        HashSet hashSet = new HashSet();
        int size = (int) (listG.size() - (iZ * 0.75f));
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                ((Long) entry.getKey()).longValue();
                com.bytedance.sdk.component.adexpress.z.dl.g gVar2 = (com.bytedance.sdk.component.adexpress.z.dl.g) entry.getValue();
                if (gVar2 != null) {
                    hashSet.add(gVar2.g());
                }
            }
        }
        z(hashSet);
        this.g.set(false);
    }

    private JSONObject z(String str, z zVar) {
        if (com.bytedance.sdk.component.adexpress.z.z.z.z().dl() == null) {
            zVar.g();
            return null;
        }
        com.bytedance.sdk.component.fo.g.dl dlVarGc = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().gc();
        dlVarGc.z(str);
        com.bytedance.sdk.component.fo.g gVarZ = dlVarGc.z();
        if (gVarZ != null) {
            try {
                if (gVarZ.gz() && gVarZ.a() != null) {
                    return new JSONObject(gVarZ.a());
                }
            } catch (Exception e) {
                wp.z(e);
            }
        }
        zVar.g();
        return null;
    }

    private JSONObject dl(String str) {
        com.bytedance.sdk.component.adexpress.z.z.dl dlVarDl = com.bytedance.sdk.component.adexpress.z.z.z.z().dl();
        if (dlVarDl == null) {
            return null;
        }
        com.bytedance.sdk.component.fo.g.dl dlVarGc = dlVarDl.gc();
        dlVarGc.z(str);
        com.bytedance.sdk.component.fo.g gVarZ = dlVarGc.z();
        if (gVarZ != null) {
            try {
                if (gVarZ.gz() && gVarZ.a() != null) {
                    return new JSONObject(gVarZ.a());
                }
            } catch (Exception e) {
                wp.z(e);
            }
        }
        return null;
    }

    public void z(com.bytedance.sdk.component.adexpress.z.dl.a aVar, String str) {
        if (aVar == null) {
            wp.a("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        final String str2 = aVar.z;
        final String str3 = aVar.dl;
        final String str4 = aVar.g;
        final String str5 = aVar.f615a;
        final String str6 = aVar.gc;
        final String strM = TextUtils.isEmpty(str) ? com.bytedance.sdk.component.adexpress.z.z.z.z().dl() != null ? com.bytedance.sdk.component.adexpress.z.z.z.z().dl().m() : "" : str;
        if (TextUtils.isEmpty(str2)) {
            wp.a("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            com.bytedance.sdk.component.adexpress.a.gc.z(new fo("saveTemplate") { // from class: com.bytedance.sdk.component.adexpress.z.g.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.z(str2, str3, str4, str5, str6, strM);
                }
            }, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void z(String str, String str2, String str3, String str4, String str5, String str6) {
        if (z(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                g(str6, str, str3, str2, str4, str5);
            }
            return;
        } else if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            z(str2, str6, str);
        } else {
            g(str6, str, str3, str2, str4, str5);
        }
        boolean z2 = gz.z(str5);
        if (!g.gc() || z2) {
            gc.g().z(true);
        }
    }

    private void z(String str, String str2, String str3) {
        JSONObject jSONObjectDl;
        if (TextUtils.isEmpty(str) || (jSONObjectDl = dl(str)) == null) {
            return;
        }
        String strOptString = jSONObjectDl.optString(TKDownloadReason.KSAD_TK_MD5);
        String strOptString2 = jSONObjectDl.optString("version");
        String strOptString3 = jSONObjectDl.optString("data");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
            return;
        }
        com.bytedance.sdk.component.adexpress.z.dl.g gVarZ = new com.bytedance.sdk.component.adexpress.z.dl.g().z(str2).g(str3).dl(strOptString).a(str).gc(strOptString3).m(strOptString2).z(Long.valueOf(System.currentTimeMillis()));
        m.z().z(gVarZ, false);
        g();
        if (gz.z(strOptString2)) {
            gVarZ.m(strOptString2);
            gc.g().z(true);
        }
    }

    public void z(com.bytedance.sdk.component.adexpress.z.dl.a aVar, z zVar) {
        z(aVar, aVar.g(), zVar);
    }

    public void z(com.bytedance.sdk.component.adexpress.z.dl.a aVar, String str, final z zVar) {
        if (zVar == null) {
            return;
        }
        if (aVar == null) {
            wp.a("TmplDiffManager", "saveTemplate error: tplInfo == null");
            zVar.g();
            return;
        }
        final String str2 = aVar.z;
        final String str3 = aVar.dl;
        final String str4 = aVar.g;
        final String str5 = aVar.f615a;
        final String str6 = aVar.gc;
        final String strM = TextUtils.isEmpty(str) ? com.bytedance.sdk.component.adexpress.z.z.z.z().dl() != null ? com.bytedance.sdk.component.adexpress.z.z.z.z().dl().m() : "" : str;
        if (TextUtils.isEmpty(str2)) {
            wp.a("TmplDiffManager", "saveTemplate error:tmpId is empty");
            zVar.g();
        } else {
            com.bytedance.sdk.component.adexpress.a.gc.z(new fo("saveTemplate") { // from class: com.bytedance.sdk.component.adexpress.z.g.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.z(str2, str3, str4, str5, str6, strM, zVar);
                }
            }, 10);
        }
    }

    public synchronized void z(String str, String str2, String str3, String str4, String str5, String str6, z zVar) {
        if (z(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                g(str6, str, str3, str2, str4, str5);
                zVar.z();
            }
            zVar.z();
            return;
        }
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            z(str2, str6, str, zVar);
        } else {
            g(str6, str, str3, str2, str4, str5);
            zVar.z();
        }
        boolean z2 = gz.z(str5);
        if (!g.gc() || z2) {
            gc.g().z(true);
        }
    }

    private void g(String str, String str2, String str3, String str4, String str5, String str6) {
        m.z().z(new com.bytedance.sdk.component.adexpress.z.dl.g().z(str).g(str2).dl(str3).a(str4).gc(str5).m(str6).z(Long.valueOf(System.currentTimeMillis())), false);
        g();
    }

    private void z(String str, String str2, String str3, z zVar) {
        if (TextUtils.isEmpty(str)) {
            zVar.g();
            return;
        }
        JSONObject jSONObjectZ = z(str, zVar);
        if (jSONObjectZ != null) {
            String strOptString = jSONObjectZ.optString(TKDownloadReason.KSAD_TK_MD5);
            String strOptString2 = jSONObjectZ.optString("version");
            String strOptString3 = jSONObjectZ.optString("data");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
                zVar.g();
                return;
            }
            com.bytedance.sdk.component.adexpress.z.dl.g gVarZ = new com.bytedance.sdk.component.adexpress.z.dl.g().z(str2).g(str3).dl(strOptString).a(str).gc(strOptString3).m(strOptString2).z(Long.valueOf(System.currentTimeMillis()));
            if (gVarZ == null || com.bytedance.sdk.component.adexpress.z.z.z.z().g() == null) {
                zVar.g();
                return;
            }
            if (TextUtils.isEmpty(gVarZ.g())) {
                zVar.g();
                return;
            }
            m.z().z(gVarZ, false);
            g();
            if (gz.z(strOptString2)) {
                gVarZ.m(strOptString2);
                gc.g().z(true);
            }
            zVar.z();
        }
    }

    public void z(Set<String> set) {
        try {
            m.z().z(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
