package com.bytedance.sdk.openadsdk.core.nativeexpress.z;

import android.text.TextUtils;
import com.bytedance.sdk.component.fo.g.a;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.io.gc;
import com.bytedance.sdk.openadsdk.core.iq.nh;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static volatile g z;

    public interface z {
    }

    public static g z() {
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new g();
                }
            }
        }
        return z;
    }

    public void z(nh nhVar, String str, String str2) {
        if (nhVar == null) {
            return;
        }
        if (TextUtils.isEmpty(nhVar.z())) {
            wp.a("UGTemplateManager", "save ugen template error : tmpId is empty");
            return;
        }
        final String str3 = str2 + "_" + nhVar.z();
        final String strDl = nhVar.dl();
        final String strG = nhVar.g();
        final String strA = nhVar.a();
        if (TextUtils.isEmpty(str) && str2.equals(an.aw)) {
            str = uy.ls().q();
        }
        final String str4 = str;
        e.z(new fo("saveUGenTemplate") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.z.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.z(str3, strDl, strG, strA, str4);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, String str2, String str3, String str4, String str5) {
        if (z(str, str3) != null) {
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                return;
            }
            g(str2, str3, str5, str4, str);
            return;
        }
        if (TextUtils.isEmpty(str4)) {
            z(str2, str, str3, str5, (z) null);
        } else {
            g(str2, str3, str5, str4, str);
        }
    }

    private void z(final String str, final String str2, final String str3, final String str4, final z zVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.bytedance.sdk.component.fo.g.dl dlVarDl = gc.z().g().dl();
        dlVarDl.z(str);
        dlVarDl.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.z.g.2
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(a aVar, com.bytedance.sdk.component.fo.g gVar) {
                if (gVar != null && gVar.gz()) {
                    String strA = gVar.a();
                    if (TextUtils.isEmpty(strA)) {
                        return;
                    }
                    dl.z().z(new com.bytedance.sdk.openadsdk.core.nativeexpress.z.z().z(str2).g(str3).dl(str).gc(str4).a(strA).z(Long.valueOf(System.currentTimeMillis())), false);
                    g.this.g();
                    if (zVar != null) {
                        try {
                            new JSONObject(strA);
                        } catch (JSONException unused) {
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(a aVar, IOException iOException) {
                if (zVar != null) {
                    iOException.getMessage();
                }
            }
        });
    }

    public Set<com.bytedance.sdk.openadsdk.core.nativeexpress.z.z> z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return dl.z().z(str);
    }

    public String z(String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.z.z zVarZ = z(str + "_" + str2, str3);
        if (zVarZ == null) {
            return null;
        }
        z(zVarZ);
        return zVarZ.gc();
    }

    private com.bytedance.sdk.openadsdk.core.nativeexpress.z.z z(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return dl.z().z(str, str2);
    }

    private void g(String str, String str2, String str3, String str4, String str5) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.z.z zVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.z.z();
        zVar.dl(str).gc(str3).a(str4).g(str2).z(str5).z(Long.valueOf(System.currentTimeMillis()));
        dl.z().z(zVar, false);
        g();
    }

    private void z(final com.bytedance.sdk.openadsdk.core.nativeexpress.z.z zVar) {
        zVar.z(Long.valueOf(System.currentTimeMillis()));
        e.z(new fo("updateTmplTime") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.z.g.3
            @Override // java.lang.Runnable
            public void run() {
                dl.z().z(zVar, true);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        int iFp = zw.g().fp();
        if (iFp <= 0) {
            iFp = 100;
        }
        List<com.bytedance.sdk.openadsdk.core.nativeexpress.z.z> listG = dl.z().g();
        if (listG == null || listG.isEmpty() || iFp >= listG.size()) {
            if (listG != null) {
                listG.size();
                return;
            }
            return;
        }
        int size = (int) (listG.size() - (iFp * 0.75f));
        if (size <= 0) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.openadsdk.core.nativeexpress.z.z zVar : listG) {
            treeMap.put(zVar.a(), zVar);
        }
        HashSet hashSet = new HashSet();
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                com.bytedance.sdk.openadsdk.core.nativeexpress.z.z zVar2 = (com.bytedance.sdk.openadsdk.core.nativeexpress.z.z) entry.getValue();
                if (zVar2 != null) {
                    hashSet.add(zVar2.z());
                }
            }
        }
        z(hashSet);
    }

    public void z(Set<String> set) {
        try {
            dl.z().z(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
