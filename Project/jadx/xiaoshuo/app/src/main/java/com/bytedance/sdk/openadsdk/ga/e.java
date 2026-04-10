package com.bytedance.sdk.openadsdk.ga;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.wu;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes10.dex */
public abstract class e implements d {
    private Object bf;
    private SparseArray<Method> e = new SparseArray<>();

    @Override // com.bytedance.sdk.openadsdk.ga.d
    public <T> T call(int i, Object... objArr) {
        Object obj;
        Method method = this.e.get(i);
        if (method == null || (obj = this.bf) == null) {
            wu.tg(e(), "call method " + i + " failed for null ");
            return null;
        }
        try {
            return obj instanceof Class ? (T) method.invoke(null, objArr) : (T) method.invoke(obj, objArr);
        } catch (Throwable th) {
            wu.tg(e(), "call method " + i + " failed: " + th.getMessage());
            return null;
        }
    }

    public abstract String e();

    @Override // com.bytedance.sdk.openadsdk.ga.d
    public void e(int i, Method method) {
        this.e.put(i, method);
    }

    @Override // com.bytedance.sdk.openadsdk.ga.d
    public void e(Object obj) {
        this.bf = obj;
    }
}
