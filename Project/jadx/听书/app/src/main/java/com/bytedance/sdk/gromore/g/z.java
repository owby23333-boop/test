package com.bytedance.sdk.gromore.g;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Function<SparseArray<Object>, Object> {
    private static Function<SparseArray<Object>, Object> g;
    private static volatile z z;

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        return null;
    }

    public static void z(Function<SparseArray<Object>, Object> function) {
        g = function;
    }

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    private z() {
    }

    public void z(String str, String str2) {
        if (g != null) {
            com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z();
            zVarZ.z(20000, str);
            zVarZ.z(20001, str2);
            zVarZ.z(-99999987, 10000);
            zVarZ.z(-99999985, Void.class);
            g.apply(zVarZ.g().sparseArray());
        }
    }
}
