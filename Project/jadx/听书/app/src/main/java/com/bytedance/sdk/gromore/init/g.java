package com.bytedance.sdk.gromore.init;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static com.bytedance.msdk.api.a.m z(com.bytedance.sdk.openadsdk.mediation.init.z.g.z.dl dlVar) {
        if (dlVar == null) {
            return null;
        }
        com.bytedance.msdk.api.a.m mVar = new com.bytedance.msdk.api.a.m();
        mVar.z(dlVar.g());
        mVar.a(dlVar.m());
        mVar.g(dlVar.dl());
        mVar.dl(dlVar.a());
        mVar.z(dlVar.gc());
        mVar.gc(dlVar.e());
        mVar.z(dlVar.z());
        return mVar;
    }

    public static Map<String, String> z(Map<String, Object> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                map2.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return map2;
    }
}
