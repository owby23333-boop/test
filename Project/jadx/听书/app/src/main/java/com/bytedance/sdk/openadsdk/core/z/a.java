package com.bytedance.sdk.openadsdk.core.z;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.q;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.sdk.openadsdk.tb.z.g.z.g implements g {
    private long z;

    public a(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.z = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.g
    public void z(final int i, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.z(i, str);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.super.z(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.g
    public void z(final List<com.bytedance.sdk.openadsdk.ls.dl.g.fo> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.z(list);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.super.z(list);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.z.g
    public long g() {
        return this.z;
    }
}
