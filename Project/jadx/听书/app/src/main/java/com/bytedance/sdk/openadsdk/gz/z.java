package com.bytedance.sdk.openadsdk.gz;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.g.z.wp;
import com.bytedance.sdk.component.m.dl.gc;
import com.bytedance.sdk.component.m.g.a;
import com.bytedance.sdk.component.m.iq;
import com.bytedance.sdk.component.m.js;
import com.bytedance.sdk.component.m.m;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.fo;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static Context getContext() {
        return zw.getContext();
    }

    public static iq z(Context context, js jsVar) {
        return com.bytedance.sdk.component.m.dl.g.z(context, jsVar);
    }

    public static js z() {
        return new gc.z().z(new com.bytedance.sdk.component.m.dl.z.z(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 10485760), AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE), 0, 41943040L, true, true, new File(fo.m()))).z(e.z()).z(new com.bytedance.sdk.component.m.gc() { // from class: com.bytedance.sdk.openadsdk.gz.z.1
            @Override // com.bytedance.sdk.component.m.gc
            public a call(m mVar) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                wp wpVarM = com.bytedance.sdk.openadsdk.core.io.gc.z().g().m();
                v vVarG = new v.z().z(mVar.z()).z().z("csj_client_source_from", "2").g();
                ls lsVar = null;
                com.bytedance.sdk.component.m.g.gc gcVar = mVar.dl() ? new com.bytedance.sdk.component.m.g.gc() : null;
                if (gcVar != null) {
                    gcVar.z(jCurrentTimeMillis);
                }
                try {
                    ls lsVarG = wpVarM.z(vVarG).g();
                    if (gcVar != null) {
                        try {
                            gcVar.g(System.currentTimeMillis());
                        } catch (Throwable th) {
                            th = th;
                            lsVar = lsVarG;
                            try {
                                return z(gcVar, th);
                            } finally {
                                com.bytedance.sdk.component.m.dl.dl.g.z(lsVar);
                            }
                        }
                    }
                    if (mVar.a() != null) {
                        mVar.a().onStep(3, null);
                    }
                    Map<String, String> mapZ = z(mVar, lsVarG);
                    byte[] bArrA = lsVarG.m().a();
                    mapZ.put("image_size", String.valueOf(bArrA == null ? 0 : bArrA.length));
                    a aVar = new a(lsVarG.dl(), bArrA, "", mapZ);
                    if (gcVar != null) {
                        gcVar.dl(System.currentTimeMillis());
                    }
                    aVar.z(gcVar);
                    com.bytedance.sdk.component.m.dl.dl.g.z(lsVarG);
                    return aVar;
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            private Map<String, String> z(m mVar, ls lsVar) {
                HashMap map = new HashMap();
                if (mVar.g()) {
                    com.bytedance.sdk.component.g.z.m mVarE = lsVar.e();
                    int iZ = mVarE.z();
                    for (int i = 0; i < iZ; i++) {
                        String strZ = mVarE.z(i);
                        String strG = mVarE.g(i);
                        if (strZ != null) {
                            map.put(strZ, strG);
                        }
                    }
                }
                return map;
            }

            private a z(com.bytedance.sdk.component.m.g.gc gcVar, Throwable th) {
                com.bytedance.sdk.component.utils.wp.g("ImageConfig", th.getMessage());
                if (gcVar != null) {
                    gcVar.dl(System.currentTimeMillis());
                }
                a aVar = new a(0, th, "net failed");
                aVar.z(gcVar);
                return aVar;
            }
        }).z();
    }
}
