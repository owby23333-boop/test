package com.bytedance.msdk.api.a.z;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static com.bytedance.msdk.api.z.g z(int i, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, Function<SparseArray<Object>, Object> function) {
        if (zVar == null) {
            return null;
        }
        com.bytedance.msdk.core.kb.z.z().z(function);
        return new com.bytedance.msdk.api.z.g(i, zVar.gk());
    }
}
