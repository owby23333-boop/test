package com.bytedance.sdk.openadsdk.mediation.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements Function<SparseArray<Object>, Object>, IntSupplier {
    public abstract <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls);

    public abstract SparseArray<Object> get();

    @Override // java.util.function.IntSupplier
    public int getAsInt() {
        return 7000;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetG = dl.z(sparseArray).g();
        int iIntValue = valueSetG.intValue(-99999987, 0);
        Class cls = (Class) valueSetG.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return get();
        }
        return applyFunction(iIntValue, valueSetG, cls);
    }

    public static <T> T objectValue(Object obj, Class<T> cls, T t) {
        if (obj instanceof ValueSet.ValueGetter) {
            obj = (T) ((ValueSet.ValueGetter) obj).get();
        } else if ((obj instanceof Supplier) && !(obj instanceof Function) && !(obj instanceof ValueSet)) {
            obj = (T) ((Supplier) obj).get();
        }
        return cls.isInstance(obj) ? (T) obj : t;
    }
}
