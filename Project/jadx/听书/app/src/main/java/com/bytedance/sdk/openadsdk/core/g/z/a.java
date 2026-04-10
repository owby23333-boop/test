package com.bytedance.sdk.openadsdk.core.g.z;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.iq.na;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private final Map<Class, z> z = new HashMap();

    public dl z(na naVar, Context context, com.bytedance.sdk.openadsdk.core.g.a aVar, boolean z) {
        dl dlVar = new dl(aVar);
        com.bytedance.sdk.openadsdk.core.g.z.g.z zVar = new com.bytedance.sdk.openadsdk.core.g.z.g.z(naVar, context);
        this.z.put(com.bytedance.sdk.openadsdk.core.g.z.g.z.class, zVar);
        g gVar = new g(naVar, context);
        this.z.put(g.class, gVar);
        com.bytedance.sdk.openadsdk.core.g.z.z.z zVarZ = z(naVar, context);
        this.z.put(com.bytedance.sdk.openadsdk.core.g.z.z.z.class, zVarZ);
        com.bytedance.sdk.openadsdk.core.g.z.dl.z zVar2 = new com.bytedance.sdk.openadsdk.core.g.z.dl.z(naVar, context);
        this.z.put(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class, zVar2);
        com.bytedance.sdk.openadsdk.core.g.z.dl.dl dlVar2 = new com.bytedance.sdk.openadsdk.core.g.z.dl.dl(naVar, context);
        this.z.put(com.bytedance.sdk.openadsdk.core.g.z.dl.dl.class, dlVar2);
        dlVar.z(dlVar2);
        dlVar.z(zVar);
        dlVar.z(gVar);
        dlVar.z(zVarZ);
        dlVar.z(zVar2);
        return dlVar;
    }

    private com.bytedance.sdk.openadsdk.core.g.z.z.z z(na naVar, Context context) {
        com.bytedance.sdk.openadsdk.core.g.z.z.dl dlVar = new com.bytedance.sdk.openadsdk.core.g.z.z.dl();
        dlVar.z(naVar);
        dlVar.z(context);
        return dlVar;
    }

    public <T extends z> T z(Class<T> cls) {
        T t = (T) this.z.get(cls);
        return t == null ? (T) g(cls) : t;
    }

    private <T extends z> T g(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (Throwable unused) {
            try {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(na.class, Context.class);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(null, null);
            } catch (Throwable unused2) {
                return null;
            }
        }
    }
}
