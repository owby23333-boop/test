package com.bytedance.msdk.m;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.gc.m;
import com.bytedance.sdk.component.utils.wp;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static final Map<String, Boolean> z = new ConcurrentHashMap();

    static final synchronized void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        z.put(str, Boolean.TRUE);
    }

    public static final synchronized boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Boolean bool = z.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static synchronized void z(Context context, List<com.bytedance.msdk.core.uy.z> list) {
        if (list != null) {
            for (com.bytedance.msdk.core.uy.z zVar : list) {
                final com.bytedance.msdk.api.a.z.g.dl.g gVarA = zVar.a();
                try {
                    if (!g(zVar.m())) {
                        z(context, gVarA, new com.bytedance.msdk.z.z.dl() { // from class: com.bytedance.msdk.m.g.1
                            @Override // com.bytedance.msdk.z.z.dl
                            public void z() {
                                com.bytedance.msdk.m.g.z.z(gVarA.g(), (Pair<Boolean, String>) new Pair(Boolean.TRUE, ""));
                            }

                            @Override // com.bytedance.msdk.z.z.dl
                            public void z(com.bytedance.msdk.api.z zVar2) {
                                if (zVar2 != null) {
                                    com.bytedance.msdk.m.g.z.z(gVarA.g(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, "errorCode = " + zVar2.z + " errorMessage = " + zVar2.g));
                                }
                            }
                        });
                        z(zVar.m());
                    }
                } catch (Exception e) {
                    wp.z(e);
                    com.bytedance.msdk.m.g.z.z(gVarA.g(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, e.toString()));
                    m.z(gVarA.g(), (com.bytedance.msdk.g.dl) null, (com.bytedance.msdk.api.z.g) null, (uy) null, new com.bytedance.msdk.api.z(49013, e.toString()));
                }
            }
            return;
        }
        m.z("", (com.bytedance.msdk.g.dl) null, (com.bytedance.msdk.api.z.g) null, (uy) null, new com.bytedance.msdk.api.z(49013, "获取的自定义Adapter总配置为null"));
    }

    private static com.bytedance.msdk.api.a.z.g.m.z z(com.bytedance.msdk.api.a.z.g.dl.g gVar, com.bytedance.msdk.z.z.dl dlVar) {
        com.bytedance.msdk.api.a.z.g.m.z zVarZ = com.bytedance.msdk.m.g.z.a().z(gVar.g());
        if (zVarZ != null) {
            return zVarZ;
        }
        com.bytedance.msdk.api.a.z.g.m.z zVar = new com.bytedance.msdk.api.a.z.g.m.z();
        com.bytedance.msdk.m.g.z.a().z(gVar.g(), zVar);
        return zVar;
    }

    private static void z(Context context, com.bytedance.msdk.api.a.z.g.dl.g gVar, com.bytedance.msdk.z.z.dl dlVar) throws Exception {
        if (gVar == null || TextUtils.isEmpty(gVar.dl())) {
            if (gVar == null) {
                throw new Exception("自定义ADN初始化失败，获取的自定义Adapter单条配置为null");
            }
            throw new Exception("自定义ADN初始化失败，获取的自定义Adapter单条配置初始化类名为空");
        }
        com.bytedance.msdk.api.a.z.g.m.z zVarZ = z(gVar, dlVar);
        if (zVarZ != null) {
            if (!zVarZ.g()) {
                z(context, gVar, zVarZ);
            }
            dlVar.z();
            return;
        }
        throw new Exception("GMCustomAdapterConfiguration is null");
    }

    private static void z(Context context, com.bytedance.msdk.api.a.z.g.dl.g gVar, com.bytedance.msdk.api.a.z.g.m.z zVar) {
        if (context == null) {
            m.z(gVar.g(), (com.bytedance.msdk.g.dl) null, (com.bytedance.msdk.api.z.g) null, (uy) null, new com.bytedance.msdk.api.z(49013, "context为null"));
            return;
        }
        try {
            zVar.z(context.getApplicationContext(), gVar, com.bytedance.msdk.core.z.kb().uf());
        } catch (Exception e) {
            m.z(gVar.g(), (com.bytedance.msdk.g.dl) null, (com.bytedance.msdk.api.z.g) null, (uy) null, new com.bytedance.msdk.api.z(49013, "调用自定义Adapter初始化方法出现异常 " + e.getClass().getName()));
            wp.z(e);
        }
    }

    public static synchronized void z(Context context, String str) {
        if (!g(str)) {
            z(context, com.bytedance.msdk.e.z.g.z().g());
        }
    }
}
