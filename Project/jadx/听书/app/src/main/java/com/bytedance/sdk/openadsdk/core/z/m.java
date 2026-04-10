package com.bytedance.sdk.openadsdk.core.z;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.ls.dl.g.kb;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class m extends com.bytedance.sdk.openadsdk.tb.z.g.z.a implements g {
    private long z;

    public m(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.z = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.a
    public void z(final int i, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.z(i, str);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.super.z(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.a
    public void z(final kb kbVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.z(kbVar);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.m.2
                @Override // java.lang.Runnable
                public void run() {
                    m.super.z(kbVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.a
    public void z() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.z();
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.m.3
                @Override // java.lang.Runnable
                public void run() {
                    m.super.z();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.a
    public void g(final kb kbVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.g(kbVar);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.m.4
                @Override // java.lang.Runnable
                public void run() {
                    m.super.g(kbVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.z.g
    public long g() {
        return this.z;
    }
}
