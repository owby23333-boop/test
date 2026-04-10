package com.bytedance.sdk.openadsdk.e;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.wp;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements g {
    private Object g;
    private SparseArray<Method> z = new SparseArray<>();

    public abstract String z();

    @Override // com.bytedance.sdk.openadsdk.e.g
    public <T> T call(int i, Object... objArr) {
        Object obj;
        Method method = this.z.get(i);
        if (method == null || (obj = this.g) == null) {
            wp.g(z(), "call method " + i + " failed for null ");
            return null;
        }
        try {
            if (obj instanceof Class) {
                return (T) method.invoke(null, objArr);
            }
            return (T) method.invoke(obj, objArr);
        } catch (Throwable th) {
            wp.g(z(), "call method " + i + " failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.g
    public void z(int i, Method method) {
        this.z.put(i, method);
    }

    @Override // com.bytedance.sdk.openadsdk.e.g
    public void z(Object obj) {
        this.g = obj;
    }
}
