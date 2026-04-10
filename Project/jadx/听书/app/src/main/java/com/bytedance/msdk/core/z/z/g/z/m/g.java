package com.bytedance.msdk.core.z.z.g.z.m;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private Function<SparseArray<Object>, Object> z;

    public g(Function<SparseArray<Object>, Object> function) {
        this.z = function;
    }

    public int z() {
        if (this.z == null) {
            return -998;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40005);
        sparseArray.put(-99999985, Integer.class);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    public String g() {
        if (this.z == null) {
            return "adn no msg";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40006);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }
}
