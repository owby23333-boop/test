package com.bytedance.sdk.openadsdk.core.z;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.ls.dl.g.i;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.bytedance.sdk.openadsdk.tb.z.g.z.gc implements g {
    private long z;

    public e(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.z = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.gc
    public void z(final int i, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.z(i, str);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.super.z(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.gc
    public void z(final List<i> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.z(list);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.super.z(list);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.z.g
    public long g() {
        return this.z;
    }
}
