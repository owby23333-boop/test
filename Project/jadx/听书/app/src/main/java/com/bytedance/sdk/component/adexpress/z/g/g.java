package com.bytedance.sdk.component.adexpress.z.g;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.adexpress.a.uy;
import com.bytedance.sdk.component.adexpress.z.dl.z;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    static Object z = new Object();

    public static void z() {
        gc.g();
    }

    public static void g() {
        try {
            gz.a();
            File fileE = gc.e();
            if (fileE == null || !fileE.exists()) {
                return;
            }
            if (fileE.getParentFile() != null) {
                com.bytedance.sdk.component.utils.m.dl(fileE.getParentFile());
            } else {
                com.bytedance.sdk.component.utils.m.dl(fileE);
            }
        } catch (Throwable unused) {
        }
    }

    public static String dl() {
        return m.dl();
    }

    public static void z(com.bytedance.sdk.component.adexpress.z.dl.a aVar) {
        e.z().z(aVar, aVar.m);
    }

    public static Set<com.bytedance.sdk.component.adexpress.z.dl.g> z(String str, boolean z2) {
        final Set<com.bytedance.sdk.component.adexpress.z.dl.g> setG = e.z().g(str);
        if (setG != null && setG.size() > 0) {
            if (z2) {
                com.bytedance.sdk.component.adexpress.a.gc.z(new fo("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.z.g.g.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.g((Set<com.bytedance.sdk.component.adexpress.z.dl.g>) setG);
                    }
                }, 5);
            } else {
                g(setG);
            }
        }
        return setG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Set<com.bytedance.sdk.component.adexpress.z.dl.g> set) {
        try {
            for (com.bytedance.sdk.component.adexpress.z.dl.g gVar : set) {
                gVar.z(Long.valueOf(System.currentTimeMillis()));
                m.z().z(gVar, true);
            }
        } catch (Throwable unused) {
        }
    }

    public static com.bytedance.sdk.component.adexpress.z.dl.g z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.z.dl.g gVarZ = e.z().z(str);
        if (gVarZ != null) {
            gVarZ.z(Long.valueOf(System.currentTimeMillis()));
            z(gVarZ);
        }
        return gVarZ;
    }

    private static void z(final com.bytedance.sdk.component.adexpress.z.dl.g gVar) {
        com.bytedance.sdk.component.adexpress.a.gc.z(new fo("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.z.g.g.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (g.z) {
                    m.z().z(gVar, true);
                }
            }
        }, 10);
    }

    public static com.bytedance.sdk.component.adexpress.z.dl.z a() {
        return gc.g().gc();
    }

    @Deprecated
    private static String m() {
        com.bytedance.sdk.component.adexpress.z.dl.z zVarA = a();
        if (zVarA == null) {
            return null;
        }
        return zVarA.a();
    }

    public static String g(String str) {
        com.bytedance.sdk.component.adexpress.z.dl.z zVar;
        com.bytedance.sdk.component.adexpress.z.dl.z zVarA = a();
        if (zVarA == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            Map<String, com.bytedance.sdk.component.adexpress.z.dl.z> mapZ = zVarA.z();
            if (mapZ == null || mapZ.size() <= 0 || (zVar = mapZ.get(str)) == null) {
                return null;
            }
            return zVar.a();
        }
        return m();
    }

    public static boolean gc() {
        return gc.g().a();
    }

    public static z z(String str, uy.z zVar, String str2, String str3) {
        File fileA;
        z zVar2 = new z();
        if (TextUtils.isEmpty(str3)) {
            fileA = null;
        } else {
            fileA = g(str3, str);
            if (fileA != null) {
                zVar2.z(1);
            }
        }
        if (fileA == null && (fileA = gc(str)) != null) {
            zVar2.z(3);
        }
        if (fileA == null && (fileA = a(str)) != null) {
            zVar2.z(2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!z(str, str3)) {
                zVar2.z(4);
            }
        } else if (!dl(str)) {
            zVar2.z(6);
        }
        zVar2.getType();
        if (fileA != null) {
            try {
                zVar2.z(new WebResourceResponse(zVar.getType(), "utf-8", new FileInputStream(fileA)));
            } catch (Throwable th) {
                wp.dl("TTDynamic", "get html WebResourceResponse error", th);
            }
        }
        return zVar2;
    }

    private static boolean z(String str, String str2) {
        com.bytedance.sdk.component.adexpress.z.dl.z zVarA;
        com.bytedance.sdk.component.adexpress.z.dl.z zVar;
        if (!gc() || (zVarA = a()) == null) {
            return false;
        }
        Map<String, com.bytedance.sdk.component.adexpress.z.dl.z> mapZ = zVarA.z();
        if (mapZ.size() == 0 || (zVar = mapZ.get(str2)) == null) {
            return false;
        }
        for (z.C0124z c0124z : zVar.getResources()) {
            if (c0124z != null && TextUtils.equals(str, c0124z.z())) {
                return true;
            }
        }
        return false;
    }

    private static boolean dl(String str) {
        com.bytedance.sdk.component.adexpress.z.dl.z zVarA;
        List<z.C0124z> resources;
        if (!gc() || (zVarA = a()) == null || (resources = zVarA.getResources()) == null) {
            return false;
        }
        for (z.C0124z c0124z : resources) {
            if (c0124z != null && TextUtils.equals(str, c0124z.z())) {
                return true;
            }
        }
        return false;
    }

    private static File a(String str) {
        if (!gc()) {
            return null;
        }
        for (z.C0124z c0124z : a().getResources()) {
            if (c0124z.z() != null && c0124z.z().equals(str)) {
                File file = new File(gc.e(), com.bytedance.sdk.component.utils.gc.g(c0124z.z()));
                String strZ = com.bytedance.sdk.component.utils.gc.z(file);
                if (c0124z.g() == null || !c0124z.g().equals(strZ)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    private static File gc(String str) {
        List<Pair<String, String>> listG;
        z.g gVarGc = a().gc();
        if (gVarGc == null || (listG = gVarGc.g()) == null || listG.size() <= 0) {
            return null;
        }
        for (Pair<String, String> pair : listG) {
            if (pair.second != null && ((String) pair.second).equals(str)) {
                return new File(gc.e(), (String) pair.first);
            }
        }
        return null;
    }

    private static File g(String str, String str2) {
        com.bytedance.sdk.component.adexpress.z.dl.z zVar;
        com.bytedance.sdk.component.adexpress.z.dl.z zVarA = a();
        if (zVarA == null || !gc()) {
            return null;
        }
        Map<String, com.bytedance.sdk.component.adexpress.z.dl.z> mapZ = zVarA.z();
        if (mapZ.size() == 0 || (zVar = mapZ.get(str)) == null) {
            return null;
        }
        for (z.C0124z c0124z : zVar.getResources()) {
            if (c0124z.z() != null && c0124z.z().equals(str2)) {
                File file = new File(gc.e(), com.bytedance.sdk.component.utils.gc.g(c0124z.z()));
                String strZ = com.bytedance.sdk.component.utils.gc.z(file);
                if (c0124z.g() == null || !c0124z.g().equals(strZ)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    public static boolean z(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    public static boolean g(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("xTemplate")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    public static boolean dl(JSONObject jSONObject) {
        Object objOpt;
        if (jSONObject == null) {
            return false;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject == null || (objOpt = jSONObjectOptJSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
