package com.bytedance.sdk.openadsdk.core.kb;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.kb.dl.uy;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static final LruCache<String, com.bytedance.sdk.openadsdk.core.iq.a> z = new LruCache<>(10);

    public static void z(String str, com.bytedance.sdk.openadsdk.core.iq.a aVar) {
        if (zw.g().st() && !TextUtils.isEmpty(str) && aVar != null && aVar.gc()) {
            z.put(str, aVar);
        }
    }

    public static com.bytedance.sdk.openadsdk.core.iq.a z(String str) {
        com.bytedance.sdk.openadsdk.core.iq.a aVar;
        if (zw.g().st() && (aVar = z.get(str)) != null && aVar.gc()) {
            return aVar;
        }
        return null;
    }

    public static void z(final na naVar) {
        if (zw.g().st() && naVar != null) {
            final String strG = naVar.c() != null ? naVar.c().g() : "";
            if (!TextUtils.isEmpty(strG) && naVar.lt() == 4 && TextUtils.isEmpty(naVar.po())) {
                if ((naVar.dt() == null || naVar.dt().g() == 0) && uy.z(naVar) == 2) {
                    com.bytedance.sdk.openadsdk.hh.e.z(new com.bytedance.sdk.component.uy.fo("preloadAppInfo") { // from class: com.bytedance.sdk.openadsdk.core.kb.z.1
                        @Override // java.lang.Runnable
                        public void run() {
                            zw.z().z(naVar, strG);
                        }
                    });
                }
            }
        }
    }
}
