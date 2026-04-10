package com.bytedance.sdk.component.a;

import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gz implements e {
    Function z;

    public gz(Function function) {
        this.z = function;
    }

    @Override // com.bytedance.sdk.component.a.e
    public void onExceptionEvent(String str, JSONObject jSONObject, Throwable th) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, th);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.e
    public void onStatsEvent(String str, JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        this.z.apply(sparseArray);
    }
}
