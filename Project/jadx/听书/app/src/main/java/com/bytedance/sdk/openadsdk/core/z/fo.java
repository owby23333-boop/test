package com.bytedance.sdk.openadsdk.core.z;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.ls.dl.g.pf;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends com.bytedance.sdk.openadsdk.tb.z.g.z.e implements g {
    private long z;

    public fo(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.z = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.e
    public void z(final int i, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.z(i, str);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.fo.1
                @Override // java.lang.Runnable
                public void run() {
                    fo.super.z(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.e
    public void z(final pf pfVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.z(pfVar);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.fo.2
                @Override // java.lang.Runnable
                public void run() {
                    fo.super.z(pfVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.e
    public void z() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.z();
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.fo.3
                @Override // java.lang.Runnable
                public void run() {
                    fo.super.z();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.e
    public void g(final pf pfVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.g(pfVar);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.fo.4
                @Override // java.lang.Runnable
                public void run() {
                    fo.super.g(pfVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.z.g
    public long g() {
        return this.z;
    }
}
