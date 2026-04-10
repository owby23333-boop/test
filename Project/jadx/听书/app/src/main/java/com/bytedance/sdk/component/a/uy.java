package com.bytedance.sdk.component.a;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class uy implements fo {
    Function z;

    public uy(Function function) {
        this.z = function;
    }

    public void clear() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.z.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    @Override // com.bytedance.sdk.component.a.fo
    public com.bytedance.sdk.component.a.g.dl get(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        ?? Apply = this.z.apply(sparseArray);
        ?? aVar = Apply;
        if (Apply != 0) {
            aVar = new com.bytedance.sdk.component.a.g.a((Function) Apply);
        }
        return (com.bytedance.sdk.component.a.g.dl) aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public com.bytedance.sdk.component.a.g.dl get(String str, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        ?? Apply = this.z.apply(sparseArray);
        ?? aVar = Apply;
        if (Apply != 0) {
            aVar = new com.bytedance.sdk.component.a.g.a((Function) Apply);
        }
        return (com.bytedance.sdk.component.a.g.dl) aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    @Override // com.bytedance.sdk.component.a.fo
    public com.bytedance.sdk.component.a.g.z getEncrypt(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Integer.valueOf(i));
        ?? Apply = this.z.apply(sparseArray);
        ?? gVar = Apply;
        if (Apply != 0) {
            gVar = new com.bytedance.sdk.component.a.g.g((Function) Apply);
        }
        return (com.bytedance.sdk.component.a.g.z) gVar;
    }

    @Override // com.bytedance.sdk.component.a.fo
    public void store() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        this.z.apply(sparseArray);
    }
}
