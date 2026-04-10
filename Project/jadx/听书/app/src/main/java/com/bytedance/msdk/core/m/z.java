package com.bytedance.msdk.core.m;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.z.gc.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private final Map<String, com.bytedance.msdk.api.a.z.g.m.z> z = new ConcurrentHashMap();

    public Map<String, com.bytedance.msdk.api.a.z.g.m.z> z() {
        return this.z;
    }

    public void z(String str, com.bytedance.msdk.api.a.z.g.m.z zVar) {
        this.z.put(str, zVar);
    }

    public com.bytedance.msdk.api.a.z.g.m.z z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.z.get(str);
    }

    public String z(Context context, Map<String, Object> map, String str) {
        a.z(context);
        com.bytedance.msdk.api.a.z.g.m.z zVarZ = z(str);
        if (zVarZ != null) {
            return zVarZ.z(null, null);
        }
        com.bytedance.msdk.z.z.a aVarG = g(str);
        if (aVarG == null) {
            return null;
        }
        return aVarG.z(context, map);
    }

    public Map<String, Object> g(Context context, Map<String, Object> map, String str) {
        a.z(context);
        com.bytedance.msdk.api.a.z.g.m.z zVarZ = z(str);
        if (zVarZ != null) {
            HashMap map2 = new HashMap();
            map2.put("buyerId", zVarZ.z(context, map));
            map2.put("sdkInfo", zVarZ.g(context, map));
            return map2;
        }
        com.bytedance.msdk.z.z.a aVarG = g(str);
        if (aVarG == null) {
            return null;
        }
        return aVarG.g(context, map);
    }

    public com.bytedance.msdk.z.z.a g(String str) {
        return com.bytedance.msdk.m.g.g.z().z(str);
    }
}
