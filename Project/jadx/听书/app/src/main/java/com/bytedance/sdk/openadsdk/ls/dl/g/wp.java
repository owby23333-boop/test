package com.bytedance.sdk.openadsdk.ls.dl.g;

import android.util.SparseArray;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class wp implements Function<SparseArray<Object>, Object> {
    private SparseArray<Object> z;

    public abstract double a();

    public abstract String dl();

    public abstract int g();

    public abstract boolean gc();

    public abstract int z();

    public SparseArray<Object> m() {
        SparseArray<Object> sparseArray = this.z;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArrayE = e();
        this.z = sparseArrayE;
        return sparseArrayE;
    }

    private SparseArray<Object> e() {
        com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z();
        aVarZ.z(230002, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.wp.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(wp.this.z());
            }
        }));
        aVarZ.z(230001, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.wp.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(wp.this.g());
            }
        }));
        aVarZ.z(230003, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.wp.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return wp.this.dl();
            }
        }));
        aVarZ.z(230004, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Double>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.wp.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(wp.this.a());
            }
        }));
        aVarZ.z(230005, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.wp.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(wp.this.gc());
            }
        }));
        return aVarZ.g();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null && com.bykv.z.z.z.z.z.z(sparseArray).g().intValue(-99999987) == -99999986) {
            return m();
        }
        return null;
    }
}
