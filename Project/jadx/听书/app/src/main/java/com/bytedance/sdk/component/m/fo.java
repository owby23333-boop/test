package com.bytedance.sdk.component.m;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class fo implements gz, Function {
    gz g;
    Function z;

    public fo(gz gzVar) {
        this.g = gzVar;
    }

    public fo(Function function) {
        this.z = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int iIntValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (iIntValue == 1) {
            return Long.valueOf(this.g.getStartRequestTime());
        }
        if (iIntValue == 2) {
            return Long.valueOf(this.g.getFirstFrameTime());
        }
        if (iIntValue != 3) {
            return null;
        }
        return Long.valueOf(this.g.getEndRequestTime());
    }

    @Override // com.bytedance.sdk.component.m.gz
    public long getEndRequestTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Long) this.z.apply(sparseArray)).longValue();
    }

    @Override // com.bytedance.sdk.component.m.gz
    public long getFirstFrameTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Long) this.z.apply(sparseArray)).longValue();
    }

    @Override // com.bytedance.sdk.component.m.gz
    public long getStartRequestTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Long) this.z.apply(sparseArray)).longValue();
    }
}
