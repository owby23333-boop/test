package com.bytedance.sdk.component.gz.g;

import android.text.TextUtils;
import com.bytedance.sdk.component.gz.z.e;
import com.bytedance.sdk.component.gz.z.gc;
import com.bytedance.sdk.component.gz.z.m;
import com.bytedance.sdk.component.utils.wp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static final ConcurrentHashMap<String, g> z = new ConcurrentHashMap<>();
    private static volatile List<com.bytedance.sdk.component.gz.z.dl> g = new ArrayList();
    private static ConcurrentHashMap<String, gc> dl = new ConcurrentHashMap<>();

    public static e z(com.bytedance.sdk.component.gz.z.z zVar) {
        if (zVar == null || TextUtils.isEmpty(zVar.gc()) || zVar.getContext() == null) {
            wp.a("csj_log_error", "config or adLogFrom or context is null");
            return null;
        }
        ConcurrentHashMap<String, g> concurrentHashMap = z;
        g gVar = concurrentHashMap.get(zVar.gc());
        if (gVar == null) {
            gVar = new g(zVar);
        } else {
            gVar.g(zVar);
        }
        concurrentHashMap.put(zVar.gc(), gVar);
        return gVar;
    }

    public static void z(m mVar, String str) {
        dl(str).z(mVar);
    }

    public static void z(boolean z2, String str) {
        dl(str).z(z2);
    }

    public static List<com.bytedance.sdk.component.gz.z.dl> z() {
        return g;
    }

    public static void z(com.bytedance.sdk.component.gz.z.dl dlVar) {
        if (dlVar != null) {
            g.add(dlVar);
        }
    }

    public static boolean z(String str) {
        g gVar = z.get(str);
        return gVar == null || gVar.dl() == null || gVar.a() == null || gVar.gc() == null;
    }

    public static void g(String str) {
        z(false, str);
        dl(str).z();
    }

    public static e dl(String str) {
        ConcurrentHashMap<String, g> concurrentHashMap = z;
        g gVar = concurrentHashMap.get(str);
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g();
        concurrentHashMap.put(str, gVar2);
        return gVar2;
    }

    public static void z(String str, String str2) {
        dl(str).z(str2);
    }

    public static void z(String str, String str2, List<String> list, boolean z2, Map<String, String> map, JSONObject jSONObject) {
        dl(str).z(str2, list, z2, map, jSONObject);
    }

    public static void z(com.bytedance.sdk.component.gz.z.g gVar, String str) {
        dl(str).z(gVar);
    }

    public static void a(String str) {
        dl(str).g();
    }

    public static gc gc(String str) {
        gc gcVarDl = dl.get(str);
        if (gcVarDl == null && (gcVarDl = dl(str).dl()) != null) {
            dl.put(str, gcVarDl);
        }
        return gcVarDl;
    }
}
