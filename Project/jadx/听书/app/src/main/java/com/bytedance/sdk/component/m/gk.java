package com.bytedance.sdk.component.m;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class gk implements h, Function {
    h g;
    Function z;

    public gk(h hVar) {
        this.g = hVar;
    }

    public gk(Function function) {
        this.z = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            Object obj2 = sparseArray.get(1);
            Object iVar = sparseArray.get(2);
            if (iVar != null) {
                iVar = new i((Function) iVar);
            }
            this.g.onStepStart((String) obj2, (wp) iVar);
            return null;
        }
        if (iIntValue != 2) {
            return null;
        }
        Object obj3 = sparseArray.get(1);
        Object iVar2 = sparseArray.get(2);
        if (iVar2 != null) {
            iVar2 = new i((Function) iVar2);
        }
        this.g.onStepEnd((String) obj3, (wp) iVar2);
        return null;
    }

    @Override // com.bytedance.sdk.component.m.h
    public void onStepEnd(String str, wp wpVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        if (wpVar != null) {
            wpVar = new i(wpVar);
        }
        sparseArray.put(2, wpVar);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.m.h
    public void onStepStart(String str, wp wpVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        if (wpVar != null) {
            wpVar = new i(wpVar);
        }
        sparseArray.put(2, wpVar);
        this.z.apply(sparseArray);
    }
}
