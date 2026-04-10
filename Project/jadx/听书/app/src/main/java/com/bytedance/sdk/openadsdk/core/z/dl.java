package com.bytedance.sdk.openadsdk.core.z;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.q;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends com.bytedance.sdk.openadsdk.tb.z.g.z.z implements g {
    private long z;

    public dl(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.z = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.z
    public void z(final com.bytedance.sdk.openadsdk.ls.dl.g.g gVar) {
        if (com.bytedance.sdk.openadsdk.core.component.splash.gc.z()) {
            super.z(gVar);
        } else {
            com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.dl.1
                @Override // java.lang.Runnable
                public void run() {
                    dl.super.z(gVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.z
    public void z(final com.bytedance.sdk.openadsdk.ls.dl.g.z zVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.z(zVar);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.dl.2
                @Override // java.lang.Runnable
                public void run() {
                    dl.super.z(zVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.z
    public void g(final com.bytedance.sdk.openadsdk.ls.dl.g.g gVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.g(gVar);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.dl.3
                @Override // java.lang.Runnable
                public void run() {
                    dl.super.g(gVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.z
    public void z(final com.bytedance.sdk.openadsdk.ls.dl.g.g gVar, final com.bytedance.sdk.openadsdk.ls.dl.g.z zVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.z(gVar, zVar);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.dl.4
                @Override // java.lang.Runnable
                public void run() {
                    dl.super.z(gVar, zVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.z.g
    public long g() {
        return this.z;
    }
}
