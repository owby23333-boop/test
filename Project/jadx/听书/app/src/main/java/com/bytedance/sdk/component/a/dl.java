package com.bytedance.sdk.component.a;

import android.util.SparseArray;
import com.bytedance.sdk.component.a.z;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements z.g, Function {
    z.g g;
    Function z;

    public dl(z.g gVar) {
        this.g = gVar;
    }

    public dl(Function function) {
        this.z = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            this.g.setCryptInitStatus(((Long) sparseArray.get(1)).longValue(), ((Boolean) sparseArray.get(2)).booleanValue());
            return null;
        }
        if (iIntValue != 2) {
            return null;
        }
        this.g.reportSoftDecData((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
        return null;
    }

    @Override // com.bytedance.sdk.component.a.z.g
    public void reportSoftDecData(String str, JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.g
    public void setCryptInitStatus(long j, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, Long.valueOf(j));
        sparseArray.put(3, Boolean.valueOf(z));
        this.z.apply(sparseArray);
    }
}
